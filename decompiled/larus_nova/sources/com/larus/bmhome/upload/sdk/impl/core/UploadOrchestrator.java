package com.larus.bmhome.upload.sdk.impl.core;

import com.larus.bmhome.upload.sdk.api.model.UploadStage;
import com.larus.bmhome.upload.sdk.impl.post.PostUploadActionChain;
import is8.g;
import is8.h;
import is8.j;
import is8.k;
import is8.l;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class UploadOrchestrator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ks8.b f314853a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final js8.a f314854b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.upload.sdk.impl.engine.a f314855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PostUploadActionChain f314856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final UploadPreprocessChain f314857e;

    public final Object b(String r210, g r211, e r212, Continuation<? super Unit> r213) {
        e r100 = r212;
        if ((r213 instanceof UploadOrchestrator$execute$1) == false) goto L7;
        UploadOrchestrator$execute$1 r101 = (UploadOrchestrator$execute$1) r213;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        UploadOrchestrator$execute$1 r103 = r101;
        Object r104 = r103.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r103.label;
        if (r106 == 0) goto L46;
        if (r106 == 1) goto L37;
        if (r106 == 2) goto L30;
        if (r106 == 3) goto L23;
        if (r106 != 4) goto L22;
        e r107 = (e) r103.L$1;
        String r108 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L17 CancellationException -> L19
    L68:
        r107.a(r108, new j.g((h) r104));     // Catch: Throwable -> L17 CancellationException -> L19
    L93:
        return Unit.INSTANCE;
    L19:
        e = e;
    L88:
        String r109 = e.getMessage();
        if (r109 != null) goto L91;
        r109 = "";
    L91:
        r107.a(r108, new j.a(r109));
    L17:
        th = th;
    L82:
        UploadStage r110 = UploadStage.FAILED;
        String r111 = th.getMessage();
        if (r111 != null) goto L85;
        r111 = "";
    L85:
        r107.a(r108, new j.d(new is8.d(r110, r111, th)));
        goto L93
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L23:
        long r112 = r103.J$0;
        is8.a r113 = (is8.a) r103.L$3;
        g r114 = (g) r103.L$2;
        e r115 = (e) r103.L$1;
        String r116 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L26 CancellationException -> L28
        long r117 = r112;
        String r118 = r116;
        e r119 = r115;
        is8.a r120 = r113;
        Object r121 = r104;
    L96:
        com.larus.bmhome.upload.sdk.impl.engine.b r122 = (com.larus.bmhome.upload.sdk.impl.engine.b) r121;     // Catch: Throwable -> L70 CancellationException -> L72
        if (r120.f495638c == false) goto L64;
        r119.a(r118, new j.f(r122.f314869a, r120));     // Catch: Throwable -> L70 CancellationException -> L72
    L64:
        r103.L$0 = r118;     // Catch: Throwable -> L70 CancellationException -> L72
        r103.L$1 = r119;     // Catch: Throwable -> L70 CancellationException -> L72
        r103.L$2 = r15;     // Catch: Throwable -> L70 CancellationException -> L72
        r103.L$3 = 0;     // Catch: Throwable -> L70 CancellationException -> L72
        r103.label = 4;     // Catch: Throwable -> L70 CancellationException -> L72
        Object r123 = a(r118, r114, r120, r117, r122, r103);     // Catch: Throwable -> L70 CancellationException -> L72
        if (r123 != r105) goto L67;
        return r105;
    L67:
        r104 = r123;
        r107 = r119;
        r108 = r118;
        goto L68
    L72:
        e = e;
        r107 = r119;
        r108 = r118;
    L70:
        th = th;
        r107 = r119;
        r108 = r118;
        goto L82
    L28:
        e = e;
        r107 = r115;
        r108 = r116;
    L26:
        th = th;
        r107 = r115;
        r108 = r116;
        goto L82
    L30:
        long r124 = r103.J$0;
        is8.a r125 = (is8.a) r103.L$3;
        g r126 = (g) r103.L$2;
        e r127 = (e) r103.L$1;
        String r128 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L33 CancellationException -> L35
        g r129 = r126;
        r100 = r127;
        String r130 = r128;
        long r131 = r124;
    L55:
        js8.b r132 = (js8.b) r104;     // Catch: Throwable -> L80 CancellationException -> L86
        r100.a(r130, new j.h(0, r125));     // Catch: Throwable -> L80 CancellationException -> L86
        com.larus.bmhome.upload.sdk.impl.engine.c r133 = this.f314855c.a(r125);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r133 == null) goto L75;
        UploadOrchestrator$execute$engineResult$1 r134 = new UploadOrchestrator$execute$engineResult$1(r100, r130, r125, null);     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$0 = r130;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$1 = r100;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$2 = r129;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$3 = r125;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.J$0 = r131;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.label = 3;     // Catch: Throwable -> L80 CancellationException -> L86
        r117 = r131;
        r121 = r133.b(r130, r129, r125, r132, r134, r103);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r121 != r105) goto L60;
        return r105;
    L60:
        r118 = r130;
        r119 = r100;
        r120 = r125;
        r114 = r129;
        goto L96
    L75:
        throw new IllegalStateException("No upload engine bound for route: " + r125);     // Catch: Throwable -> L80 CancellationException -> L86
    L35:
        e = e;
        r107 = r127;
        r108 = r128;
    L33:
        th = th;
        r107 = r127;
        r108 = r128;
        goto L82
    L37:
        long r135 = r103.J$0;
        e r136 = (e) r103.L$1;
        String r137 = (String) r103.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L40 CancellationException -> L43
        r131 = r135;
        r100 = r136;
    L94:
        g r138 = (g) r104;     // Catch: Throwable -> L76 CancellationException -> L78
        r125 = this.f314853a.a(r138);     // Catch: Throwable -> L76 CancellationException -> L78
        r100.a(r137, new j.c(r125.f495636a));     // Catch: Throwable -> L76 CancellationException -> L78
        js8.a r139 = this.f314854b;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.L$0 = r137;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.L$1 = r100;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.L$2 = r138;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.L$3 = r125;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.J$0 = r131;     // Catch: Throwable -> L76 CancellationException -> L78
        r103.label = 2;     // Catch: Throwable -> L76 CancellationException -> L78
        Object r140 = r139.a(r138, r125, r103);     // Catch: Throwable -> L76 CancellationException -> L78
        if (r140 != r105) goto L54;
        return r105;
    L54:
        r129 = r138;
        r104 = r140;
        r130 = r137;
        goto L55
    L78:
        e = e;
        r107 = r100;
    L45:
        r108 = r137;
    L76:
        th = th;
        r107 = r100;
    L42:
        r108 = r137;
        goto L82
    L43:
        e = e;
        r107 = r136;
    L40:
        th = th;
        r107 = r136;
        goto L42
    L46:
        ResultKt.throwOnFailure(r104);
        r131 = System.currentTimeMillis();
        r100.a(r210, new j.e(0));     // Catch: Throwable -> L80 CancellationException -> L86
        UploadPreprocessChain r141 = this.f314857e;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$0 = r210;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.L$1 = r100;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.J$0 = r131;     // Catch: Throwable -> L80 CancellationException -> L86
        r103.label = 1;     // Catch: Throwable -> L80 CancellationException -> L86
        r104 = r141.a(r211, r103);     // Catch: Throwable -> L80 CancellationException -> L86
        if (r104 != r105) goto L50;
        return r105;
    L50:
        r137 = r210;
    L86:
        e = e;
        r108 = r210;
        r107 = r100;
    L80:
        th = th;
        r108 = r210;
        r107 = r100;
    L7:
        r101 = new UploadOrchestrator$execute$1(this, r213);
        goto L8
    }

    public UploadOrchestrator(ks8.a r100, js8.a r101, com.larus.bmhome.upload.sdk.impl.engine.a r102, PostUploadActionChain r103, UploadPreprocessChain r104) {
        Intrinsics.checkNotNullParameter(r100, "routeResolver");
        Intrinsics.checkNotNullParameter(r101, "credentialProvider");
        Intrinsics.checkNotNullParameter(r102, "engineRegistry");
        Intrinsics.checkNotNullParameter(r103, "postUploadActionChain");
        Intrinsics.checkNotNullParameter(r104, "preprocessChain");
        this.f314853a = r100;
        this.f314854b = r101;
        this.f314855c = r102;
        this.f314856d = r103;
        this.f314857e = r104;
    }

    public final Object a(String r110, g r111, is8.a r112, long r113, com.larus.bmhome.upload.sdk.impl.engine.b r210, Continuation<? super h> r211) {
        if ((r211 instanceof UploadOrchestrator$buildResult$1) == false) goto L7;
        UploadOrchestrator$buildResult$1 r100 = (UploadOrchestrator$buildResult$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        long r105 = r100.J$0;
        is8.a r106 = (is8.a) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
        is8.a r108 = r106;
        String r109 = r107;
        long r114 = r105;
    L17:
        com.larus.bmhome.upload.sdk.impl.post.c r115 = (com.larus.bmhome.upload.sdk.impl.post.c) r102;
        String r116 = r115.f314874c;
        String r117 = r115.f314876e;
        l r118 = r115.f314875d;
        long r119 = r114;
        k r120 = new k(r119, System.currentTimeMillis(), r115.f314877f);
        return new h(r109, r116, r117, r118, r108, r120);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        PostUploadActionChain r121 = this.f314856d;
        com.larus.bmhome.upload.sdk.impl.post.c r122 = new com.larus.bmhome.upload.sdk.impl.post.c(r111, r112, r210.f314869a, r210.f314870b, null, MapsKt.emptyMap());
        r109 = r110;
        r100.L$0 = r109;
        r108 = r112;
        r100.L$1 = r108;
        r114 = r113;
        r100.J$0 = r114;
        r100.label = 1;
        r102 = r121.a(r122, r100);
        if (r102 != r103) goto L17;
        return r103;
    L7:
        r100 = new UploadOrchestrator$buildResult$1(this, r211);
        goto L8
    }
}
