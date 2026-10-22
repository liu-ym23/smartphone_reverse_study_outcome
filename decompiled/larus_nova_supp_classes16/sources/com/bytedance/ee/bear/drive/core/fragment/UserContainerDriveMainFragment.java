package com.bytedance.ee.bear.drive.core.fragment;

import android.content.Context;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.utils.ContextsKt;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import java.util.Iterator;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = e0c.l.class)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/drive/core/fragment/UserContainerDriveMainFragment;", "Lcom/bytedance/ee/bear/drive/core/fragment/DriveMainFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "driveAIExtensionProvider", "Lcom/bytedance/ee/bear/drive/core/ai/CcmDriveAIExtensionProvider;", "getDriveAIExtensionProvider", "()Lcom/bytedance/ee/bear/drive/core/ai/CcmDriveAIExtensionProvider;", "setDriveAIExtensionProvider", "(Lcom/bytedance/ee/bear/drive/core/ai/CcmDriveAIExtensionProvider;)V", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "getContext", "Landroid/content/Context;", "installProductHostAbilities", "", "openStrategy", "Lcom/bytedance/ee/drive/render/IDriveOpenStrategy;", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserContainerDriveMainFragment extends Hilt_UserContainerDriveMainFragment implements d0c.c {

    @Inject
    public t75.a o;

    public final void afterUserOffline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(f0c.h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
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
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.Hilt_UserContainerDriveMainFragment, com.bytedance.ee.bear.facade.common.BaseFragment
    public Context getContext() {
        Context r0 = super.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return ContextsKt.findActivity(r0);
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m342provideComponent() {
        return provideComponent();
    }

    public UserContainerDriveMainFragment() {
    }

    @Override // com.bytedance.ee.bear.drive.core.fragment.DriveMainFragment
    public final void W90(com.bytedance.ee.drive.render.j r4) {
        Intrinsics.checkNotNullParameter(r4, "openStrategy");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L18
        com.bytedance.ee.drive.render.m r5 = r4.d();     // Catch: Throwable -> L18
        t75.a r1 = this.o;     // Catch: Throwable -> L18
        t75.a r2 = null;
        if (r1 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("driveAIExtensionProvider");     // Catch: Throwable -> L18
        r1 = null;
    L8:
        r1.f(r5);     // Catch: Throwable -> L18
        t75.a r3 = this.o;     // Catch: Throwable -> L18
        if (r3 == null) goto L11;
        r2 = r3;
    L12:
        Iterator<T> r6 = r2.d(this).iterator();     // Catch: Throwable -> L18
    L14:
        if (r6.hasNext() == false) goto L16;
        com.bytedance.ee.bear.browser.plugin.i r7 = (com.bytedance.ee.bear.browser.plugin.i) r6.next();     // Catch: Throwable -> L18
        r5.c(r7.getClass(), r7);     // Catch: Throwable -> L18
        goto L14
    L16:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L27;
        tt5.a.e("DriveSdk", "installProductHostAbilities failed", r9, false);
        return;
    L27:
        return;
    L11:
        Intrinsics.throwUninitializedPropertyAccessException("driveAIExtensionProvider");     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }
}
