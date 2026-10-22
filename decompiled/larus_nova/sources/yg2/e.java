package yg2;

import com.bytedance.android.livesdk.livecommerce.actionrecord.event.EventType;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f567493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ xg2.e f567494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f567495c;

    public e(a r100, xg2.e r101, String r102) {
        this.f567493a = r100;
        this.f567494b = r101;
        this.f567495c = r102;
    }

    public final void a() {
        this.f567493a.a(this.f567494b);
        a r100 = this.f567493a;
        xg2.e r101 = this.f567494b;
        String r102 = this.f567495c;
        Map<String, String> r103 = r100.f567485c;
        ConcurrentHashMap r104 = (ConcurrentHashMap) r103;
        r104.put(r101.f563597b.toString(), r102);
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f563596a = r102;
        System.currentTimeMillis();
        LinkedList r105 = new LinkedList();
        r105.add(r101);
        ((ConcurrentHashMap) r100.f567484b).put(r102, r105);
        this.f567493a.b(this.f567494b, EventType.RATE_START, "ec_live_quality_monitor_start", this.f567495c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
