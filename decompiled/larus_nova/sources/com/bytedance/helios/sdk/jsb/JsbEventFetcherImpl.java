package com.bytedance.helios.sdk.jsb;

import com.bytedance.helios.sdk.HeliosEnvImpl;
import com.larus.apm.impl.protector.RunnableProtector;
import hz5.i;
import hz5.j;
import hz5.l;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0016R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/bytedance/helios/sdk/jsb/JsbEventFetcherImpl;", "Lhz5/j;", "Lhz5/i;", "removeTimeOutEvents", "event", "", "addJsbEvent", "", "getJsbEvents", "Ljava/util/LinkedList;", "mJsbEventList", "Ljava/util/LinkedList;", "", "getTIMEOUT_MILLS", "()J", "TIMEOUT_MILLS", "getDELAYED_MILLS", "DELAYED_MILLS", "<init>", "()V", "sdk_release"}, k = 1, mv = {1, 4, 0})
public final class JsbEventFetcherImpl extends j {
    private final LinkedList<i> mJsbEventList;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ JsbEventFetcherImpl f245584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f245585b;

        public a(JsbEventFetcherImpl r100, i r101) {
            this.f245584a = r100;
            this.f245585b = r101;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JsbEventFetcherImpl.access$removeTimeOutEvents(this.f245584a);     // Catch: Throwable -> L4
            JsbEventFetcherImpl.access$getMJsbEventList$p(this.f245584a).add(this.f245585b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // hz5.j
    public List<i> getJsbEvents() {
        int r100 = this.mJsbEventList.size() - 1;
        long r101 = System.currentTimeMillis();
        ArrayList r102 = new ArrayList();
    L3:
        if (r100 < 0) goto L7;
        i r103 = this.mJsbEventList.get(r100);
        if ((r101 - r103.f487695d) > (getTIMEOUT_MILLS() + getDELAYED_MILLS())) goto L7;
        r102.add(r103);
        r100 = r100 - 1;
    L7:
        return r102;
    }

    public JsbEventFetcherImpl() {
        this.mJsbEventList = new LinkedList();
        l.f487701d = this;
    }

    private final long getDELAYED_MILLS() {
        return HeliosEnvImpl.get().f245470m.l().b();
    }

    private final long getTIMEOUT_MILLS() {
        return HeliosEnvImpl.get().f245470m.l().a();
    }

    private final i removeTimeOutEvents() {
        long r100 = System.currentTimeMillis();
        ListIterator<i> r101 = this.mJsbEventList.listIterator();
        i r102 = null;
    L4:
        if (r101.hasNext() == false) goto L8;
        r102 = r101.next();
        if ((r100 - r102.f487695d) < getTIMEOUT_MILLS()) goto L8;
        r101.remove();
    L8:
        return r102;
    }

    public static final /* synthetic */ LinkedList access$getMJsbEventList$p(JsbEventFetcherImpl r100) {
        return r100.mJsbEventList;
    }

    public static final /* synthetic */ i access$removeTimeOutEvents(JsbEventFetcherImpl r100) {
        return r100.removeTimeOutEvents();
    }

    @Override // hz5.j
    public void addJsbEvent(i r100) {
        l.f487699b.post(new a(this, r100));
    }
}
