package com.bytedance.ee.bear.drive.core.fragment;

import android.content.Context;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00112\u00020\u00012\u00020\u0002:\u0001\u0011B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\n\u0010\u0010\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/UserContainerDrivePreviewFragment;", "Lcom/bytedance/ee/bear/drive/core/fragment/DrivePreviewFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "cachedUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "onAttach", "", "context", "Landroid/content/Context;", "provideUserSession", "shouldGuardDetachedSession", "", "getPluginUserComponent", "Lcom/bytedance/ee/bear/user/container/UserComponentDelegate;", "getContext", "Companion", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserContainerDrivePreviewFragment extends Hilt_UserContainerDrivePreviewFragment implements d0c.c {
    public UserSession t;

    public static final class a {
    }

    static {
    }

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final boolean ba0() {
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (FeatureGatingModule.getFeatureGatingService().isEnable("lark.android.disable_detached_fragment_session_guard") == true) goto L6;
        boolean r2 = true;
    L7:
        Object r3 = Result.constructor-impl(Boolean.valueOf(r2));     // Catch: Throwable -> L9
    L11:
        Throwable r4 = Result.exceptionOrNull-impl(r3);
        if (r4 == null) goto L14;
        Log.e("UserContainerDrivePreviewFragment", "read detached session guard fg failed", r4, true);
    L14:
        Boolean r0 = Boolean.TRUE;
        if (Result.isFailure-impl(r3) == false) goto L18;
        r3 = r0;
    L18:
        return ((Boolean) r3).booleanValue();
    L6:
        r2 = false;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r3 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ com.ss.android.lark.passportc.api.m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ e0c.l provideComponent() {
        return d0c.b.b(this);
    }

    public final UserSession e9() {
        if (ba0() == false) goto L5;
        UserSession r0 = this.t;
        if (r0 == null) goto L10;
        return r0;
    L10:
        if (isAdded() == false) goto L14;
        UserSession r1 = PassportcConvention.b(this);
        this.t = r1;
        return r1;
    L14:
        throw new IllegalStateException("UserSession unavailable after drive preview fragment detached");
    L5:
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.AbsLazyLoadFragment, com.bytedance.ee.bear.browser.plugin.PluginHost.a
    public final vo5.a ej() {
        return com.bytedance.ee.bear.browser.plugin.m.a(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.Hilt_UserContainerDrivePreviewFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m343provideComponent() {
        return provideComponent();
    }

    public UserContainerDrivePreviewFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.Hilt_UserContainerDrivePreviewFragment
    public final void onAttach(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super.onAttach(r5);
        if (ba0() == true) goto L17;
        return;
    L17:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L7
        Object r7 = Result.constructor-impl(PassportcConvention.b(this));     // Catch: Throwable -> L7
    L9:
        Throwable r0 = Result.exceptionOrNull-impl(r7);
        if (r0 == null) goto L13;
        Log.e("UserContainerDrivePreviewFragment", "cache user session failed", r0, true);
    L13:
        if (Result.isFailure-impl(r7) == false) goto L15;
        r7 = null;
    L15:
        this.t = (UserSession) r7;
        return;
    L7:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    }
}
