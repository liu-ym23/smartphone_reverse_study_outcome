package com.larus.platform.service;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.larus.platform.api.creation.CreateCreationSource;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e0 implements com.larus.platform.api.g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e0 f365731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f365732b = null;

    public e0() {
    }

    static {
        f365731a = new e0();
        f365732b = LazyKt.lazy(new d0());
    }

    public static com.larus.platform.api.g2 m() {
        return (com.larus.platform.api.g2) f365732b.getValue();
    }

    @Override // com.larus.platform.api.g2
    public final void d1() {
        com.larus.platform.api.g2 r100 = m();
        if (r100 == null) goto L6;
        r100.d1();
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void f() {
        com.larus.platform.api.g2 r100 = m();
        if (r100 == null) goto L6;
        r100.f();
        return;
    }

    @Override // com.larus.platform.api.g2
    public final boolean j() {
        com.larus.platform.api.g2 r100 = m();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.j() != true) goto L7;
        return true;
    }

    @Override // com.larus.platform.api.g2
    public final void X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationId");
        com.larus.platform.api.g2 r101 = m();
        if (r101 == null) goto L6;
        r101.X0(r100);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void c1(zp9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.platform.api.g2 r101 = m();
        if (r101 == null) goto L6;
        r101.c1(r100);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void e1(zp9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        com.larus.platform.api.g2 r101 = m();
        if (r101 == null) goto L6;
        r101.e1(r100);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final void g1(PublisherCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "publisherCreation");
        com.larus.platform.api.g2 r101 = m();
        if (r101 == null) goto L6;
        r101.g1(r100);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> i1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
        com.larus.platform.api.g2 r101 = m();
        if (r101 == null) goto L7;
        kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> r102 = r101.i1(r100);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return kotlinx.coroutines.flow.j1.a(null);
    }

    @Override // com.larus.platform.api.g2
    public final gs9.g a(gs9.c r100, gs9.d r101) {
        Intrinsics.checkNotNullParameter(r100, "initConfig");
        Intrinsics.checkNotNullParameter(r101, "creationPagerInitParams");
        com.larus.platform.api.g2 r102 = m();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.a(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final void a1(PublisherCreation r100, PublisherTrackParams r101) {
        Intrinsics.checkNotNullParameter(r100, "publisherCreation");
        Intrinsics.checkNotNullParameter(r101, "publisherTrackParams");
        com.larus.platform.api.g2 r102 = m();
        if (r102 == null) goto L6;
        r102.a1(r100, r101);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final CreationFeedCacheEntity b1(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
        com.larus.platform.api.g2 r102 = m();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b1(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final Object g(String r100, Continuation<? super Pair<Boolean, String>> r101) {
        com.larus.platform.api.g2 r102 = m();
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.g(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final Object b(String r100, boolean r101, Continuation<? super Pair<Boolean, String>> r102) {
        com.larus.platform.api.g2 r103 = m();
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.b(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g2
    public final void e(int r100, boolean r101, Function1<? super Boolean, Unit> r102) {
        com.larus.platform.api.g2 r103 = m();
        if (r103 == null) goto L6;
        r103.e(r100, r101, r102);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final Object h(String r100, int r101, Continuation<? super Pair<Boolean, String>> r102) {
        com.larus.platform.api.g2 r103 = m();
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.h(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g2
    public final Object i(String r100, Map<String, String> r101, Continuation<? super Unit> r102) {
        com.larus.platform.api.g2 r103 = m();
        if (r103 == null) goto L10;
        Object r104 = r103.i(r100, r101, r102);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r104;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object h1(String r100, String r101, String r102, Continuation<? super Unit> r103) {
        com.larus.platform.api.g2 r104 = m();
        if (r104 == null) goto L10;
        Object r105 = r104.h1(r100, r101, r102, r103);
        if (r105 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        return r105;
    L8:
        return Unit.INSTANCE;
    L10:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object k(String r100, String r101, String r102, ContinuationImpl r103) {
        com.larus.platform.api.g2 r104 = m();
        if (r104 != null) goto L5;
        return null;
    L5:
        return r104.k(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.g2
    public final Object c(Long r100, Long r101, String r102, Integer r110, ContinuationImpl r111) {
        com.larus.platform.api.g2 r103 = m();
        if (r103 != null) goto L5;
        return null;
    L5:
        return r103.c(r100, r101, r102, r110, r111);
    }

    @Override // com.larus.platform.api.g2
    public final boolean Y0(int r110, FragmentManager r111, String r112, String r113, boolean r114, Integer r115, CreationInputComponent$tryShowUpdateDialog$1.a r116) {
        Intrinsics.checkNotNullParameter(r111, "fragmentManager");
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        com.larus.platform.api.g2 r100 = m();
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.Y0(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.platform.api.g2
    public final void d(Context r110, nr9.g r111, String r112, String r113, String r114, String r115, Map<String, String> r116) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "videoPlayData");
        com.larus.platform.api.g2 r100 = m();
        if (r100 == null) goto L6;
        r100.d(r110, r111, r112, r113, r114, r115, r116);
        return;
    }

    @Override // com.larus.platform.api.g2
    public final Object l(String r110, int r111, String r112, int r113, String r114, @CreateCreationSource int r115, String r116, Continuation<? super zp9.a> r117) {
        com.larus.platform.api.g2 r100 = m();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.l(r110, r111, r112, r113, r114, r115, r116, r117);
    }
}
