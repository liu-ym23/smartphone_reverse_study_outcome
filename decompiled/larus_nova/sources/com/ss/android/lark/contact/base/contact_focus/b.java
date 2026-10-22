package com.ss.android.lark.contact.base.contact_focus;

import com.bytedance.lark.pb.contact.v1.PushFocusChatter;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpecialFocusPush f418564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PushFocusChatter f418565b;

    public b(SpecialFocusPush r100, PushFocusChatter r101) {
        this.f418564a = r100;
        this.f418565b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CopyOnWriteArrayList<IGetDataCallback<PushFocusChatter>> r100 = this.f418564a.f418563a;     // Catch: Throwable -> L7
        PushFocusChatter r101 = this.f418565b;     // Catch: Throwable -> L7
        Iterator<IGetDataCallback<PushFocusChatter>> r102 = r100.iterator();     // Catch: Throwable -> L7
    L4:
        if (r102.hasNext() == false) goto L16;
        r102.next().onSuccess(r101);     // Catch: Throwable -> L7
        goto L4
    L16:
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
