package com.obric.livecard.api;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.obric.livecard.api.entity.IslandSession;
import com.obric.livecard.api.impl.IslandImpl;
import com.obric.livecard.api.island.IslandApi;
import com.obric.livecard.api.island.IslandHideApi;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020 H\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0080\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006#"}, d2 = {"Lcom/obric/livecard/api/LiveCard;", "Lcom/obric/livecard/api/ILiveCard;", "()V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/app/Application;", "getContext", "()Landroid/app/Application;", "setContext", "(Landroid/app/Application;)V", "islandImpl", "Lcom/obric/livecard/api/impl/IslandImpl;", "islandVersion", "", "getIslandVersion$LiveCard_sdk_release", "()Ljava/lang/Integer;", "setIslandVersion$LiveCard_sdk_release", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "keyIslandVersion", "", "packageName", "getPackageName", "()Ljava/lang/String;", "clearSession", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "Lcom/obric/livecard/api/entity/IslandSession;", "getIslandHideApi", "Lcom/obric/livecard/api/island/IslandHideApi;", "getIslandService", "Lcom/obric/livecard/api/island/IslandApi;", "getVersion", "Landroid/content/Context;", "getVersionReal", "init", "LiveCard-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LiveCard implements ILiveCard {
    public static final LiveCard INSTANCE = null;
    private static Application context = null;
    private static final IslandImpl islandImpl = null;
    private static volatile Integer islandVersion = null;
    public static final String keyIslandVersion = "island_version";

    /* JADX INFO: renamed from: com.obric.livecard.api.LiveCard$init$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.obric.livecard.api.LiveCard$init$1", f = "LiveCard.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C116531(Continuation<? super C116531> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116531(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116531) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            IslandImpl r103 = LiveCard.access$getIslandImpl$p();
            this.label = 1;
            if (r103.getService(this) != r101) goto L12;
            return r101;
        }
    }

    private LiveCard() {
    }

    public static /* synthetic */ boolean a(Function1 r100, Object r101) {
        return clearSession$lambda$4(r100, r101);
    }

    static {
        INSTANCE = new LiveCard();
        islandImpl = new IslandImpl();
    }

    @Override // com.obric.livecard.api.ILiveCard
    public String getPackageName() {
        Application r100 = getContext();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getPackageName();
    }

    public static final /* synthetic */ IslandImpl access$getIslandImpl$p() {
        return islandImpl;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public Application getContext() {
        return context;
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandApi getIslandService() {
        return islandImpl;
    }

    public final Integer getIslandVersion$LiveCard_sdk_release() {
        return islandVersion;
    }

    private final int getVersionReal(Context r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L17
        ApplicationInfo r102 = r100.getPackageManager().getPackageInfo(IslandImpl.LIVE_CARD_PLUGIN, 128).applicationInfo;     // Catch: Throwable -> L17
        if (r102 == null) goto L9;
        Bundle r103 = r102.metaData;     // Catch: Throwable -> L17
        if (r103 == null) goto L9;
        int r104 = r103.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L17
        islandVersion = Integer.valueOf(r104);     // Catch: Throwable -> L17
    L15:
        Object r105 = Result.m9449constructorimpl(Integer.valueOf(r104));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r105) == false) goto L22;
        r105 = null;
    L22:
        Integer r106 = (Integer) r105;
        if (r106 != null) goto L25;
        return 0;
    L25:
        return r106.intValue();
    L9:
        ApplicationInfo r107 = r100.getPackageManager().getPackageInfo("com.android.systemui", 128).applicationInfo;     // Catch: Throwable -> L17
        if (r107 == null) goto L14;
        Bundle r108 = r107.metaData;     // Catch: Throwable -> L17
        if (r108 == null) goto L14;
        r104 = r108.getInt(keyIslandVersion, 0);     // Catch: Throwable -> L17
        islandVersion = Integer.valueOf(r104);     // Catch: Throwable -> L17
    L14:
        r104 = 0;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    }

    public final void clearSession(final IslandSession r100) {
        Intrinsics.checkNotNullParameter(r100, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        Set<IslandSession> r101 = islandImpl.getMSessionMap().keySet();
        final Function1<IslandSession, Boolean> r102 = new AnonymousClass1(r100);
        r101.removeIf(new a(r102));
    }

    @Override // com.obric.livecard.api.ILiveCard
    public IslandHideApi getIslandHideApi(Application r100) {
        if (getContext() != null) goto L5;
        setContext(r100);
    L5:
        Application r101 = getContext();
        if (r101 == null) goto L8;
        String r102 = r101.getPackageName();
    L10:
        if (Intrinsics.areEqual(r102, "com.obric.appletapp") == true) goto L30;
        Application r103 = getContext();
        if (r103 == null) goto L14;
        String r104 = r103.getPackageName();
    L16:
        if (Intrinsics.areEqual(r104, "com.android.systemui") == true) goto L30;
        Application r105 = getContext();
        if (r105 == null) goto L20;
        String r106 = r105.getPackageName();
    L22:
        if (Intrinsics.areEqual(r106, "com.android.launcher3") == true) goto L30;
        Application r107 = getContext();
        if (r107 == null) goto L26;
        String r108 = r107.getPackageName();
    L28:
        if (Intrinsics.areEqual(r108, IslandImpl.LIVE_CARD_HOST_DEPRECATED) == true) goto L30;
        return null;
    L26:
        r108 = null;
        goto L28
    L20:
        r106 = null;
        goto L22
    L14:
        r104 = null;
    L30:
        return islandImpl;
    L8:
        r102 = null;
        goto L10
    }

    @Override // com.obric.livecard.api.ILiveCard
    public int getVersion(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Integer r101 = islandVersion;
        if (r101 == null) goto L6;
        return r101.intValue();
    L6:
        return getVersionReal(r100);
    }

    @Override // com.obric.livecard.api.ILiveCard
    public void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        setContext(r100);
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault()), null, null, new C116531(null), 3, null);
    }

    public void setContext(Application r100) {
        context = r100;
    }

    public final void setIslandVersion$LiveCard_sdk_release(Integer r100) {
        islandVersion = r100;
    }

    private static final boolean clearSession$lambda$4(Function1 r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "$tmp0");
        return ((Boolean) r100.invoke(r101)).booleanValue();
    }
}
