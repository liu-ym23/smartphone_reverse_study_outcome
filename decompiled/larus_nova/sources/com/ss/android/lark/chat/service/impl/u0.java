package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.contact.v1.PushChannelNickname;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chat.entity.Channel;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class u0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PushChannelNickname f416578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImSdkChatterPushImplV2 f416579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Channel f416580c;

    public u0(PushChannelNickname r100, ImSdkChatterPushImplV2 r101, Channel r102) {
        this.f416578a = r100;
        this.f416579b = r101;
        this.f416580c = r102;
    }

    public final void a() {
        Log.i("ImSdkChatterPushImplV2", "onPushChannelNickname " + this.f416578a.user_id);
        Iterator r100 = ((CopyOnWriteArrayList) this.f416579b.f416370k).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        w r101 = (w) r100.next();
        PushChannelNickname r102 = this.f416578a;
        r101.a(r102.user_id, r102.nickname, this.f416580c);
        goto L4
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
