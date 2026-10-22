package com.ss.ugc.live.sdk.msg.unify;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.ss.ugc.live.sdk.msg.unify.data.idl.UMGWCustomData;
import com.ss.ugc.live.sdk.msg.unify.network.UnifyWSState;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements imc.b, com.ss.ugc.live.sdk.msg.unify.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PthreadHandlerThreadV2 f458377a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.utils.task.c f458378b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kmc.d f458379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final UnifyWSState f458380d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final b f458381e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public f f458382f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final a f458383g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f458384h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final gmc.a f458385i;

    public static final class a implements c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f458386a;

        public a(d r100) {
            this.f458386a = r100;
        }

        @Override // com.ss.ugc.live.sdk.msg.unify.c.b
        public final void a(c r100) {
            Intrinsics.checkNotNullParameter(r100, "bridge");
            f r101 = this.f458386a.f458382f;
            if (r101 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
        L5:
            r101.getClass();
            Intrinsics.checkNotNullParameter(r100, "bridge");
            com.ss.ugc.live.sdk.msg.utils.a.c(r101.f458401n, "unregister bridge: " + r100.a());
            JSONObject r102 = new JSONObject();
            r102.put("service", r100.g());
            r102.put(com.alipay.sdk.m.p.e.f25671s, r100.e());
            JSONObject r103 = new JSONObject();
            JSONObject r104 = new JSONObject();
            Iterator r105 = ((ArrayList) r100.f()).iterator();
        L7:
            if (r105.hasNext() == false) goto L9;
            UMGWCustomData r106 = (UMGWCustomData) r105.next();
            r104.put(r106.key, r106.value);
            goto L7
        L9:
            r101.f458401n.e("ttlive_im_unified_channel_biz_unregister_" + r100.e(), r102, r103, r104);
            r101.f458389b.sendMessage(r101.f458389b.obtainMessage(112, r100));
        }
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onInit() {
        this.f458385i.b();
        this.f458377a = null;
        Looper r100 = Looper.getMainLooper();
        this.f458382f = new f(r100, this.f458381e, this.f458378b, this.f458379c, this.f458385i, this.f458380d);
        new Handler(r100);
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onRelease() {
        f r100 = this.f458382f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L5:
        r100.f458389b.removeCallbacksAndMessages(null);
        r100.f458390c.removeCallbacksAndMessages(null);
        PthreadHandlerThreadV2 r101 = this.f458377a;
        if (r101 == null) goto L9;
        r101.quit();
        return;
    }

    @Override // com.ss.ugc.live.sdk.msg.unify.a
    public final void onStart() {
        f r100 = this.f458382f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L5:
        Message r101 = r100.f458390c.obtainMessage(101);
        if (r101 == null) goto L9;
        r101.sendToTarget();
        return;
    }

    public d(gmc.a r100) {
        Intrinsics.checkNotNullParameter(r100, "unifyMessageConfig");
        this.f458385i = r100;
        this.f458378b = new com.ss.ugc.live.sdk.msg.utils.task.c(PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("SingleTaskExecutorServiceProvider")));
        kmc.d r101 = new kmc.d(r100.logger(), r100.monitor());
        this.f458379c = r101;
        this.f458380d = new UnifyWSState(r100.d(), r101);
        this.f458381e = new b();
        this.f458383g = new a(this);
        i r102 = new i(this, r101);
        this.f458384h = r102;
        r102.f458413a.d(i.a.C5496a.f458415a);
    }

    @Override // imc.b
    public final imc.a registerBusiness(imc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        if (Intrinsics.areEqual(this.f458384h.f458413a.b(), i.c.d.f458423a) == true) goto L5;
        this.f458384h.f458413a.d(i.a.c.f458416a);
    L5:
        c r101 = new c(Long.valueOf(kmc.c.f504130a.incrementAndGet()).longValue(), this.f458380d, r100, this.f458381e, this.f458383g);
        b r102 = this.f458381e;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "bridge");
        r102.f458317a.put(Long.valueOf(r101.f458359d), r101);
        f r103 = this.f458382f;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("unifyMessageProvider");
    L8:
        r103.k();
        return r101;
    }
}
