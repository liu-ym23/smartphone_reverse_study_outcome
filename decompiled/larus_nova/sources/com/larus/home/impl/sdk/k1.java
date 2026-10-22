package com.larus.home.impl.sdk;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.larus.community.api.ICommunityService;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.home.impl.MainActivity;
import com.larus.platform.api.creation.CreateCreationSource;
import com.larus.platform.api.creation.CreationFeedCacheEntity;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.profile.api.ICreationService;
import com.larus.profile.api.IProfileApi;
import com.larus.uaigc.createpage.component.input.CreationInputComponent$tryShowUpdateDialog$1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k1 implements com.larus.platform.api.g2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k1 f346194a = null;

    public static final class a implements e29.c {
        public a() {
        }

        @Override // e29.c
        public final String a() {
            return VoiceInputFrom.ACTION_BAR;
        }
    }

    static {
        f346194a = new k1();
    }

    public k1() {
    }

    @Override // com.larus.platform.api.g2
    public final void d1() {
        ICommunityService.f328743a.d1();
    }

    @Override // com.larus.platform.api.g2
    public final void f() {
        IProfileApi.f365981a.h().postValue(Boolean.TRUE);
    }

    @Override // com.larus.platform.api.g2
    public final boolean j() {
        ICommunityService.Companion r100 = ICommunityService.f328743a;
        if (r100.f1().c() == false) goto L5;
    L8:
        return true;
    L5:
        if (r100.f1().f() == false) goto L8;
        return false;
    }

    @Override // com.larus.platform.api.g2
    public final void X0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationId");
        ICommunityService.f328743a.X0(r100);
    }

    @Override // com.larus.platform.api.g2
    public final void c1(zp9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ICommunityService.f328743a.c1(r100);
    }

    @Override // com.larus.platform.api.g2
    public final void e1(zp9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        ICommunityService.f328743a.e1(r100);
    }

    @Override // com.larus.platform.api.g2
    public final void g1(PublisherCreation r100) {
        Intrinsics.checkNotNullParameter(r100, "publisherCreation");
        ICommunityService.f328743a.g1(r100);
    }

    @Override // com.larus.platform.api.g2
    public final kotlinx.coroutines.flow.i1<CreationFeedCacheEntity> i1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
        return ICommunityService.f328743a.i1(r100);
    }

    @Override // com.larus.platform.api.g2
    public final gs9.g a(gs9.c r100, gs9.d r101) {
        Intrinsics.checkNotNullParameter(r100, "initConfig");
        Intrinsics.checkNotNullParameter(r101, "creationPagerInitParams");
        return ICreationService.f365978a.a(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final void a1(PublisherCreation r100, PublisherTrackParams r101) {
        Intrinsics.checkNotNullParameter(r100, "publisherCreation");
        Intrinsics.checkNotNullParameter(r101, "publisherTrackParams");
        ICommunityService.f328743a.a1(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final CreationFeedCacheEntity b1(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "creationRecommendType");
        return ICommunityService.f328743a.b1(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final Object g(String r100, Continuation<? super Pair<Boolean, String>> r101) {
        return ICreationService.f365978a.b(r100, false, r101);
    }

    public final Fragment m(zp9.m r100, Boolean r101) {
        return ICommunityService.f328743a.j1(r100, r101);
    }

    @Override // com.larus.platform.api.g2
    public final Object b(String r100, boolean r101, Continuation<? super Pair<Boolean, String>> r102) {
        return ICreationService.f365978a.b(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g2
    public final void e(int r100, boolean r101, Function1<? super Boolean, Unit> r102) {
        ICommunityService.Companion r103 = ICommunityService.f328743a;
        if (r101 == false) goto L5;
        a r104 = new a();
    L6:
        r103.x1(r100, r104, r102);
        return;
    L5:
        r104 = null;
        goto L6
    }

    @Override // com.larus.platform.api.g2
    public final Object h(String r100, int r101, Continuation<? super Pair<Boolean, String>> r102) {
        return ICreationService.f365978a.f(r100, r101, r102);
    }

    @Override // com.larus.platform.api.g2
    public final Object i(String r100, Map<String, String> r101, Continuation<? super Unit> r102) {
        Object r103 = ICreationService.f365978a.g(r100, r101, !(AppHost.f326268a.a().getCurrentActivity() instanceof MainActivity), r102);
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r103;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object h1(String r100, String r101, String r102, Continuation<? super Unit> r103) {
        Object r104 = ICommunityService.f328743a.h1(r100, r101, r102, r103);
        if (r104 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r104;
    L6:
        return Unit.INSTANCE;
    }

    @Override // com.larus.platform.api.g2
    public final Object k(String r100, String r101, String r102, ContinuationImpl r103) {
        return ICreationService.f365978a.j(r100, r101, r102, r103);
    }

    @Override // com.larus.platform.api.g2
    public final Object c(Long r100, Long r101, String r102, Integer r110, ContinuationImpl r111) {
        return ICreationService.f365978a.i(r100, r101, r102, r110, r111);
    }

    public final void n(FragmentManager r100, List r101, int r110, com.larus.uaigc.avatar.instruction.p r111, com.larus.uaigc.avatar.instruction.q r112) {
        Intrinsics.checkNotNullParameter(r101, "list");
        Intrinsics.checkNotNullParameter(r111, "selectCallback");
        Intrinsics.checkNotNullParameter(r112, "scrollListener");
        ICommunityService.f328743a.n1(r100, r101, r110, r111, r112);
    }

    @Override // com.larus.platform.api.g2
    public final boolean Y0(int r110, FragmentManager r111, String r112, String r113, boolean r114, Integer r115, CreationInputComponent$tryShowUpdateDialog$1.a r116) {
        Intrinsics.checkNotNullParameter(r111, "fragmentManager");
        Intrinsics.checkNotNullParameter(r112, "enterMethod");
        return ICommunityService.f328743a.Y0(r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // com.larus.platform.api.g2
    public final void d(Context r100, nr9.g r110, String r111, String r112, String r113, String r114, Map<String, String> r115) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "videoPlayData");
        ICreationService.f365978a.h(r100, new fs9.i(r110, r111, r112, r113, r114), r115);
    }

    @Override // com.larus.platform.api.g2
    public final Object l(String r110, int r111, String r112, int r113, String r114, @CreateCreationSource int r115, String r116, Continuation<? super zp9.a> r117) {
        return ICreationService.f365978a.c(r110, Boxing.boxInt(r111), r112, r113, r114, r115, r116, r117);
    }
}
