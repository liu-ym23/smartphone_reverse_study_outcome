package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import android.os.SystemClock;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larus.platform.exp.LarkSocialExp;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import hq9.v2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes25.dex */
public final class MentionRecommendStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MentionRecommendStore f298868a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Gson f298869b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f298870c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CoroutineScope f298871d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Object f298872e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static a f298873f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static c f298874g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static b f298875h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static long f298876i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298877a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final f0 f298878b;

        public a(String r100, f0 r101) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f298877a = r100;
            this.f298878b = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f298879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v2 f298880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f298881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f298882d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f298879a, r101.f298879a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f298880b, r101.f298880b) == true) goto L15;
            return false;
        L15:
            if (this.f298881c == r101.f298881c) goto L18;
            return false;
        L18:
            if (this.f298882d == r101.f298882d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f298879a.hashCode() * 31;
            v2 r101 = this.f298880b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            int r104 = 1231;
            if (this.f298881c == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r103 + r105) * 31;
            if (this.f298882d == true) goto L15;
            r104 = 1237;
        L15:
            return r106 + r104;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "RequestKey(userId=" + this.f298879a + ", session=" + this.f298880b + ", includeContacts=" + this.f298881c + ", includeGroups=" + this.f298882d + ')';
        }

        public b(String r100, v2 r101, boolean r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f298879a = r100;
            this.f298880b = r101;
            this.f298881c = r102;
            this.f298882d = r103;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final b f298883a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Deferred<f0> f298884b;

        public c(b r100, Deferred<f0> r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "deferred");
            this.f298883a = r100;
            this.f298884b = r101;
        }
    }

    public MentionRecommendStore() {
    }

    static {
        f298868a = new MentionRecommendStore();
        f298869b = new Gson();
        f298870c = LazyKt.lazy(new a1());
        f298871d = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f298872e = new Object();
    }

    public static f0 c(String r100) {
        String r101 = ((Keva) f298870c.getValue()).getString(r100, null);
        if (r101 != null) goto L17;
        return null;
    L17:
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L7
        Object r103 = Result.m9449constructorimpl((z0) f298869b.fromJson(r101, z0.class));     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r103) == false) goto L12;
        r103 = null;
    L12:
        z0 r104 = (z0) r103;
        if (r104 != null) goto L15;
        return null;
    L15:
        f0 r105 = r104.a();
        FLogger.f375446a.i("MentionRecommendStore", "[readDisk] contacts=" + r105.f298914b.size() + ", drives=" + r105.f298913a.size() + ", conversations=" + r105.f298916d.size());
        return r105;
    L7:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static b e(qp8.e r100, boolean r101) {
        String r102 = AccountService.f365697a.getUserId();
        LarkSocialExp.f365340a.getClass();
        v2 r103 = LarkSocialExp.a();
        boolean r104 = false;
        if (r101 == true) goto L5;
    L9:
        boolean r105 = false;
    L10:
        if (r101 == false) goto L15;
        if (LarkSocialExp.f() == false) goto L15;
        r104 = true;
    L15:
        return new b(r102, r103, r105, r104);
    L5:
        if (LarkSocialExp.e() == false) goto L9;
        if ((!StringsKt.isBlank(r100.f534374d.invoke())) == false) goto L9;
        r105 = true;
        goto L10
    }

    public static c f(qp8.e r110, boolean r111) {
        b r112 = e(r110, r111);
        final c r100 = null;
        if (StringsKt.isBlank(r112.f298879a) == false) goto L5;
        return null;
    L5:
        long r101 = SystemClock.elapsedRealtime();
        Object r102 = f298872e;
        monitor-enter(r102);
        c r103 = f298874g;     // Catch: Throwable -> L36
        if (r103 != null) goto L10;
    L20:
        final MentionRecommendStore r104 = f298868a;     // Catch: Throwable -> L36
        if (Intrinsics.areEqual(f298875h, r112) == false) goto L27;
        long r105 = f298876i;     // Catch: Throwable -> L36
        if (r105 <= 0) goto L27;
        if ((r101 - r105) >= 3000) goto L27;
        FLogger.f375446a.d("MentionRecommendStore", "[startOrJoin] drop throttled request, interval=" + (r101 - f298876i));     // Catch: Throwable -> L36
    L33:
        r103 = r100;
    L34:
        monitor-exit(r102);
        return r103;
    L27:
        c r106 = f298874g;     // Catch: Throwable -> L36
        if (r106 == null) goto L32;
        Deferred<f0> r107 = r106.f298884b;     // Catch: Throwable -> L36
        if (r107 == null) goto L32;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);     // Catch: Throwable -> L36
    L32:
        f298875h = r112;     // Catch: Throwable -> L36
        f298876i = r101;     // Catch: Throwable -> L36
        Deferred r113 = BuildersKt.async$default(f298871d, null, null, new MentionRecommendStore$startOrJoin$1$3$deferred$1(r104, r110, r112, null), 3, null);     // Catch: Throwable -> L36
        r100 = new c(r112, r113);     // Catch: Throwable -> L36
        f298874g = r100;     // Catch: Throwable -> L36
        r113.invokeOnCompletion(new b1(r100, r104));     // Catch: Throwable -> L36
        goto L33
    L10:
        if (Intrinsics.areEqual(r103.f298883a, r112) == true) goto L12;
    L14:
        boolean r108 = false;
    L15:
        if (r108 == true) goto L18;
        r103 = null;
    L18:
        if (r103 == null) goto L20;
        FLogger.f375446a.d("MentionRecommendStore", "[startOrJoin] join running request");     // Catch: Throwable -> L36
        goto L34
    L12:
        if (r103.f298884b.isActive() == false) goto L14;
        r108 = true;
    L36:
        th = move-exception;
        throw th;
    }

    public static void g(String r100, f0 r110) {
        Keva r101 = (Keva) f298870c.getValue();
        Gson r102 = f298869b;
        int r103 = z0.f298997a;
        Intrinsics.checkNotNullParameter(r110, "data");
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r104 = r110.f298914b;
        ArrayList r105 = new ArrayList();
        Iterator<T> r106 = r104.iterator();
    L3:
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a r107 = null;
        if (r106.hasNext() == false) goto L10;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r108 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r106.next();
        if (r108 == null) goto L8;
        int r109 = com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a.f298894a;
        qp8.c r111 = r108.f298901a;
        Intrinsics.checkNotNullParameter(r111, "contact");
        r107 = new com.larus.bmhome.chat.component.bottom.core.inputtext.mention.a(r111.f534367a, r111.f534368b, r111.f534369c, r111.f534370d);
    L8:
        if (r107 == null) goto L3;
        r105.add(r107);
        goto L3
    L10:
        List<c1> r112 = r110.f298915c;
        ArrayList r113 = new ArrayList();
        Iterator<T> r114 = r112.iterator();
    L12:
        if (r114.hasNext() == false) goto L19;
        c1 r115 = (c1) r114.next();
        if (r115 == null) goto L16;
        int r116 = e1.f298911a;
        e1 r117 = e1.a.a(r115);
    L17:
        if (r117 == null) goto L12;
        r113.add(r117);
        goto L12
    L16:
        r117 = null;
        goto L17
    L19:
        List<c1> r118 = r110.f298913a;
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L21:
        if (r120.hasNext() == false) goto L28;
        c1 r121 = (c1) r120.next();
        if (r121 == null) goto L25;
        int r122 = e1.f298911a;
        e1 r123 = e1.a.a(r121);
    L26:
        if (r123 == null) goto L21;
        r119.add(r123);
        goto L21
    L25:
        r123 = null;
        goto L26
    L28:
        List<c1> r124 = r110.f298916d;
        ArrayList r125 = new ArrayList();
        Iterator<T> r126 = r124.iterator();
    L30:
        if (r126.hasNext() == false) goto L37;
        c1 r127 = (c1) r126.next();
        if (r127 == null) goto L34;
        int r128 = e1.f298911a;
        e1 r129 = e1.a.a(r127);
    L35:
        if (r129 == null) goto L30;
        r125.add(r129);
        goto L30
    L34:
        r129 = null;
        goto L35
    L37:
        r101.storeString(r100, GsonProtectorUtils.toJson(r102, new z0(r105, r113, r119, r125)));
    }

    public static final Object b(MentionRecommendStore r100, Function1 r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof MentionRecommendStore$loadCatching$1) == false) goto L7;
        MentionRecommendStore$loadCatching$1 r103 = (MentionRecommendStore$loadCatching$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L15;
        if (r107 != 1) goto L14;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L19 CancellationException -> L22
    L24:
    L21:
        return r105;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r105);
        r103.label = 1;     // Catch: Throwable -> L19 CancellationException -> L22
        r105 = r101.invoke(r103);     // Catch: Throwable -> L19 CancellationException -> L22
        if (r105 != r106) goto L24;
        return r106;
    L22:
        e = move-exception;
        throw e;
    L19:
        r105 = null;
    L7:
        r103 = new MentionRecommendStore$loadCatching$1(r100, r102);
        goto L8
    }

    public final Object d(qp8.e r100, boolean r101, Continuation<? super f0> r102) {
        if ((r102 instanceof MentionRecommendStore$refresh$1) == false) goto L7;
        MentionRecommendStore$refresh$1 r103 = (MentionRecommendStore$refresh$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        f0 r108 = null;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        c r109 = (c) r103.L$1;
        qp8.e r110 = (qp8.e) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L35:
        f0 r111 = (f0) r105;
        if (r111 == null) goto L43;
        b r112 = r109.f298883a;
        f298868a.getClass();
        if (Intrinsics.areEqual(r112, e(r110, r101)) == true) goto L40;
        return null;
    L40:
        return r111;
    L43:
        return null;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        c r113 = f(r100, r101);
        if (r113 != null) goto L31;
        Object r114 = f298872e;
        monitor-enter(r114);
        a r115 = f298873f;     // Catch: Throwable -> L28
        if (r115 != null) goto L21;
    L26:
        monitor-exit(r114);
        return r108;
    L21:
        if (Intrinsics.areEqual(r115.f298877a, AccountService.f365697a.getUserId()) == true) goto L24;
        r115 = null;
    L24:
        if (r115 == null) goto L26;
        r108 = r115.f298878b;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    L31:
        Deferred<f0> r116 = r113.f298884b;
        r103.L$0 = r100;
        r103.L$1 = r113;
        r103.Z$0 = r101;
        r103.label = 1;
        Object r117 = r116.await(r103);
        if (r117 != r106) goto L34;
        return r106;
    L34:
        r110 = r100;
        r109 = r113;
        r105 = r117;
    L7:
        r103 = new MentionRecommendStore$refresh$1(this, r102);
        goto L8
    }

    public static final Object a(MentionRecommendStore r210, qp8.e r211, b r212, Continuation r213) {
        qp8.e r100 = r211;
        b r101 = r212;
        r210.getClass();
        if ((r213 instanceof MentionRecommendStore$fetchAndCache$1) == false) goto L7;
        MentionRecommendStore$fetchAndCache$1 r102 = (MentionRecommendStore$fetchAndCache$1) r213;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = true;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        String r108 = (String) r102.L$2;
        r101 = (b) r102.L$1;
        qp8.e r109 = (qp8.e) r102.L$0;
        ResultKt.throwOnFailure(r104);
        String r110 = r108;
        r100 = r109;
        Object r111 = r104;
    L17:
        Pair r112 = (Pair) r111;
        List r113 = (List) r112.component1();
        f0 r114 = (f0) r112.component2();
        if (r113 != null) goto L22;
        if (r114 != null) goto L22;
        FLogger.f375446a.w("MentionRecommendStore", "[fetchAndCache] both requests failed");
    L132:
        return null;
    L22:
        if (Intrinsics.areEqual(r101, e(r100, r101.f298882d)) == true) goto L24;
        FLogger.f375446a.i("MentionRecommendStore", "[fetchAndCache] discard result after account or IM capability changed");
        goto L132
    L24:
        Object r115 = f298872e;
        monitor-enter(r115);
        a r116 = f298873f;     // Catch: Throwable -> L136
        if (r116 != null) goto L29;
    L35:
        f0 r117 = null;
    L36:
        monitor-exit(r115);
        if (r117 != null) goto L39;
        r117 = c(r110);
    L39:
        if (r117 == null) goto L41;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r118 = r117.f298914b;
    L42:
        if (r118 != null) goto L44;
        r118 = CollectionsKt.emptyList();
    L44:
        ArrayList r119 = new ArrayList();
        Iterator<T> r120 = r118.iterator();
    L46:
        if (r120.hasNext() == false) goto L56;
        com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c r121 = (com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c) r120.next();
        if (r121 == null) goto L52;
        qp8.c r122 = r121.f298901a;
        if (r122 == null) goto L52;
        String r123 = r122.f534367a;
    L53:
        if (r123 == null) goto L46;
        r119.add(r123);
    L52:
        r123 = null;
        goto L53
    L56:
        if (r113 == null) goto L61;
        List r124 = r113;
        ArrayList r125 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r124, 10));
        Iterator r126 = r124.iterator();
    L59:
        if (r126.hasNext() == false) goto L62;
        r125.add(((qp8.c) r126.next()).f534367a);
    L62:
        FLogger r127 = FLogger.f375446a;
        StringBuilder r128 = new StringBuilder("[fetchAndCache] contacts previous=");
        r128.append(r119);
        r128.append(", fresh=");
        r128.append(r125);
        r128.append(", changed=");
        if (r125 != null) goto L65;
    L67:
        boolean r129 = false;
    L68:
        r128.append(r129);
        r127.i("MentionRecommendStore", r128.toString());
        if (r114 == null) goto L74;
        List<c1> r130 = r114.f298913a;
        if (r130 == null) goto L74;
    L73:
        List<c1> r131 = r130;
        if (r113 == null) goto L85;
        List r132 = r113;
        ArrayList r133 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r132, 10));
        Iterator r134 = r132.iterator();
    L82:
        if (r134.hasNext() == false) goto L84;
        r133.add(new com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c((qp8.c) r134.next(), null));
        goto L82
    L84:
        List r135 = r133;
    L92:
        if (r101.f298882d == false) goto L100;
        if (r114 == null) goto L96;
        List<c1> r136 = r114.f298915c;
        if (r136 == null) goto L96;
    L101:
        List<c1> r137 = r136;
        if (r114 == null) goto L107;
        List<c1> r138 = r114.f298916d;
        if (r138 == null) goto L107;
    L112:
        f0 r139 = new f0(r131, r135, r137, r138, 16);
        Object r140 = f298872e;
        monitor-enter(r140);
    L133:
        th = move-exception;
        throw th;
    L115:
        if (Intrinsics.areEqual(f298875h, r101) == false) goto L130;
        MentionRecommendStore r141 = f298868a;     // Catch: Throwable -> L133
        boolean r142 = r101.f298882d;     // Catch: Throwable -> L133
        r141.getClass();     // Catch: Throwable -> L133
        if (Intrinsics.areEqual(r101, e(r100, r142)) == false) goto L130;
        f298873f = new a(r110, r139);     // Catch: Throwable -> L133
        g(r110, r139);     // Catch: Throwable -> L133
        Unit r143 = Unit.INSTANCE;     // Catch: Throwable -> L133
        monitor-exit(r140);
        FLogger r144 = FLogger.f375446a;
        StringBuilder r145 = new StringBuilder("[fetchAndCache] contacts=");
        r145.append(r139.f298914b.size());
        r145.append(", drives=");
        r145.append(r139.f298913a.size());
        r145.append(", conversations=");
        r145.append(r139.f298916d.size());
        r145.append(", contactsFailed=");
        if (r113 != null) goto L124;
        boolean r146 = true;
    L125:
        r145.append(r146);
        r145.append(", recommendFailed=");
        if (r114 == null) goto L129;
        r107 = false;
    L129:
        r145.append(r107);
        r144.i("MentionRecommendStore", r145.toString());
        return r139;
    L124:
        r146 = false;
    L130:
        monitor-exit(r140);
    L107:
        if (r117 == null) goto L109;
        r138 = r117.f298916d;
    L110:
        if (r138 != null) goto L112;
        r138 = CollectionsKt.emptyList();
        goto L112
    L109:
        r138 = null;
    L96:
        if (r117 == null) goto L98;
        r136 = r117.f298915c;
    L99:
        if (r136 != null) goto L101;
    L98:
        r136 = null;
    L100:
        r136 = CollectionsKt.emptyList();
        goto L101
    L85:
        if (r117 == null) goto L87;
        List<com.larus.bmhome.chat.component.bottom.core.inputtext.mention.c> r147 = r117.f298914b;
    L88:
        if (r147 != null) goto L90;
        r147 = CollectionsKt.emptyList();
    L90:
        r135 = r147;
        goto L92
    L87:
        r147 = null;
    L74:
        if (r117 == null) goto L76;
        r130 = r117.f298913a;
    L77:
        if (r130 != null) goto L73;
        r130 = CollectionsKt.emptyList();
        goto L73
    L76:
        r130 = null;
        goto L77
    L65:
        if (Intrinsics.areEqual(r125, r119) == true) goto L67;
        r129 = true;
        goto L68
    L61:
        r125 = null;
        goto L62
    L41:
        r118 = null;
        goto L42
    L29:
        if (Intrinsics.areEqual(r116.f298877a, r110) == true) goto L32;
        r116 = null;
    L32:
        if (r116 == null) goto L35;
        r117 = r116.f298878b;     // Catch: Throwable -> L136
    L136:
        th = move-exception;
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r110 = r101.f298879a;
        MentionRecommendStore$fetchAndCache$2 r148 = new MentionRecommendStore$fetchAndCache$2(r101, r100, null);
        r102.L$0 = r100;
        r102.L$1 = r101;
        r102.L$2 = r110;
        r102.label = 1;
        r111 = SupervisorKt.supervisorScope(r148, r102);
        if (r111 != r105) goto L17;
        return r105;
    L7:
        r102 = new MentionRecommendStore$fetchAndCache$1(r210, r213);
        goto L8
    }
}
