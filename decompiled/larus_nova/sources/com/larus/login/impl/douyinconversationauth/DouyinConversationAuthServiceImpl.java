package com.larus.login.impl.douyinconversationauth;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.keva.Keva;
import com.larus.account.base.api.ConversationAuthUpdateScene;
import com.larus.account.base.api.IDouyinHeartBeatService;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.DouyinConversationAuthTriggerScene;
import com.larus.login.api.IDouyinConversationAuthService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0007H\u0016J(\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/login/impl/douyinconversationauth/DouyinConversationAuthServiceImpl;", "Lcom/larus/login/api/IDouyinConversationAuthService;", "<init>", "()V", "requestInFlight", "Ljava/util/concurrent/atomic/AtomicBoolean;", "markTrigger", "", "scene", "Lcom/larus/login/api/DouyinConversationAuthTriggerScene;", "tryShow", "host", "Landroidx/fragment/app/FragmentActivity;", "currentPage", "", "clearTrigger", "handleDialogPopup", "requestSuccess", "", "shouldShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DouyinConversationAuthServiceImpl implements IDouyinConversationAuthService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f357645a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f357646a = null;

        static {
            int[] r100 = new int[DouyinConversationAuthTriggerScene.values().length];
            r100[DouyinConversationAuthTriggerScene.DOUYIN_LOGIN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DouyinConversationAuthTriggerScene.ACCOUNT_BIND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f357646a = r100;
        }
    }

    static {
    }

    public DouyinConversationAuthServiceImpl() {
        this.f357645a = new AtomicBoolean(false);
    }

    @Override // com.larus.login.api.IDouyinConversationAuthService
    public final void b(DouyinConversationAuthTriggerScene r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (AppHost.f326268a.isOversea() == false) goto L5;
        return;
    L5:
        g.f357656a.getClass();
        Intrinsics.checkNotNullParameter(r100, "scene");
        g.c().storeString("scene", r100.name());
        Keva r101 = g.c();
        q38.a r102 = ILoginService.f286097a.getAccountInfo();
        String r103 = r102.f531530c;
        if (StringsKt.isBlank(r103) == false) goto L8;
        r103 = r102.f531531d;
    L8:
        r101.storeString("uid", r103);
    }

    @Override // com.larus.login.api.IDouyinConversationAuthService
    public final void a(FragmentActivity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "currentPage");
        if (AppHost.f326268a.isOversea() == false) goto L5;
        return;
    L5:
        if (ILoginService.f286097a.getAccountInfo().f531528a == false) goto L40;
        g.f357656a.getClass();
        e r102 = g.b();
        if (r102 != null) goto L10;
        return;
    L10:
        FLogger.f375446a.i("DouyinConversationAuth", "tryShow scene=" + r102.f357655a + ", lifecycle=" + r100.getLifecycle().getCurrentState());
        if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == true) goto L13;
        return;
    L13:
        FragmentManager r103 = r100.getSupportFragmentManager();
        if (r103.isStateSaved() == false) goto L16;
        return;
    L16:
        if (r103.isDestroyed() == false) goto L19;
        return;
    L19:
        if (r103.findFragmentByTag("DouyinConversationAuthDialogFragment") == null) goto L22;
        return;
    L22:
        if (this.f357645a.compareAndSet(false, true) == true) goto L24;
        return;
    L24:
        IDouyinHeartBeatService r104 = (IDouyinHeartBeatService) ServiceManager.get().getService(IDouyinHeartBeatService.class);
        if (r104 != null) goto L28;
        this.f357645a.set(false);
        return;
    L28:
        WeakReference r105 = new WeakReference(r100);
        int r106 = b.f357646a[r102.f357655a.ordinal()];
        if (r106 != 1) goto L31;
        ConversationAuthUpdateScene r107 = ConversationAuthUpdateScene.Login;
    L36:
        r104.b(r107, new DouyinConversationAuthServiceImpl$tryShow$1(r105, this, r101));
        return;
    L31:
        if (r106 != 2) goto L34;
        r107 = ConversationAuthUpdateScene.Bind;
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    }

    public static final void c(DouyinConversationAuthServiceImpl r100, FragmentActivity r101, boolean r102, boolean r103, String r104) {
        r100.getClass();
        if (r102 == false) goto L32;
        if (r103 == true) goto L7;
        g.f357656a.getClass();
        g.a();
        return;
    L7:
        g.f357656a.getClass();
        if (g.b() != null) goto L11;
        return;
    L11:
        if (r101.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED) == false) goto L34;
        FragmentManager r105 = r101.getSupportFragmentManager();
        if (r105.isStateSaved() == false) goto L16;
        return;
    L16:
        if (r105.isDestroyed() == false) goto L19;
        return;
    L19:
        if (r105.findFragmentByTag("DouyinConversationAuthDialogFragment") != null) goto L36;
        FLogger.f375446a.i("DouyinConversationAuth", "show conversation auth dialog");
        int r106 = DouyinConversationAuthDialogFragment.f357640g;
        Intrinsics.checkNotNullParameter(r104, "currentPage");
        DouyinConversationAuthDialogFragment r107 = new DouyinConversationAuthDialogFragment();
        Bundle r108 = new Bundle();
        r108.putString("current_page", r104);
        r107.setArguments(r108);
        LandscapeRestrictionOperation r109 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r107, "DouyinConversationAuthDialogFragment", r109);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r105, r107, r109) == true) goto L37;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L27
    L25:
        r107.show(r105, "DouyinConversationAuthDialogFragment");
        return;
    L37:
        return;
    L36:
        return;
    L34:
        return;
    }
}
