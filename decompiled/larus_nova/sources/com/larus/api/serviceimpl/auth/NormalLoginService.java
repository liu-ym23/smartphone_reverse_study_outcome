package com.larus.api.serviceimpl.auth;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.awemeopen.awemesdk.se.Aos;
import com.bytedance.awemeopen.domain.user.login.normal.NormalLogin$login$afterHostLogin$1;
import com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService;
import com.bytedance.keva.Keva;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.nova.R;
import com.larus.platform.model.video.business.VideoFeedProviderDelegate;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import n38.e;
import n38.p;
import o48.d;
import o48.f;
import o48.l;
import o48.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J3\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u00070\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0002J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0002J \u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0010H\u0002J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0010H\u0016J\u0018\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016J \u0010\u001b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u001dH\u0016J \u0010\u001e\u001a\u00020\u001f2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0018\u00010!H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/api/serviceimpl/auth/NormalLoginService;", "Lcom/bytedance/awemeopen/user/serviceapi/normal/AoNormalLoginService;", "<init>", "()V", "isNeedUnbindAndRebindAndroidClientKey", "", "showAuthorizationDialog", "", "activity", "Landroid/app/Activity;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "needRequestDouYinAuthorization", "bindDouyin", "Lcom/bytedance/awemeopen/user/serviceapi/AoBindDouyinCallback;", "unBindIOSDouYinClientKey", "bindDouYinUseAndroidClientKey", "handleSwitchBindDouYinAccount", "profileKey", "", "forceClear", "isBindDouyin", "requestDouyinToken", "Lcom/bytedance/awemeopen/user/serviceapi/AoAccessTokenCallback;", "isHostLogin", "startHostLogin", "loginSource", "Lcom/bytedance/awemeopen/user/serviceapi/AoHostLoginCallback;", "mapToJson", "Lorg/json/JSONObject;", "map", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NormalLoginService implements AoNormalLoginService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286934a = 0;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u64.c f286935a;

        public b(u64.c r100) {
            this.f286935a = r100;
        }

        @Override // n38.p
        public final void a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "oouYinTokenResult");
            FLogger.f375446a.d("NormalLoginService", "isBindDouyin  onSuccess:");
            this.f286935a.onSuccess(true);
        }

        @Override // n38.p
        public final void onFail(int r100) {
            FLogger.f375446a.d("NormalLoginService", "isBindDouyin  Fail:");
            this.f286935a.onSuccess(false);
        }
    }

    /* JADX INFO: loaded from: classes24.dex */
    public static final class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ u64.a f286936a;

        public c(u64.a r100) {
            this.f286936a = r100;
        }

        @Override // n38.p
        public final void a(e r100) {
            Intrinsics.checkNotNullParameter(r100, "oouYinTokenResult");
            FLogger.f375446a.d("NormalLoginService", "requestDouyinToken:onSuccess");
            this.f286936a.a(o48.c.a(r100));
        }

        @Override // n38.p
        public final void onFail(int r100) {
            FLogger.f375446a.d("NormalLoginService", "requestDouyinToken:onFail");
            this.f286936a.onFail(r100);
        }
    }

    static {
    }

    public NormalLoginService() {
    }

    @Override // com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService
    public final void isHostLogin() {
    }

    @Override // com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService
    public final void a() {
        FLogger.f375446a.d("NormalLoginService", "forceClear:");
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L6;
        r100.k(LoginPlatform.DOUYIN);
        return;
    }

    @Override // com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService
    public final void R0(final u64.c r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        FLogger.f375446a.d("NormalLoginService", "isBindDouyin  :");
        Looper r101 = Looper.myLooper();
        Intrinsics.checkNotNull(r101);
        new Handler(r101).post(new d(r100));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [o48.f] */
    @Override // com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService
    public final void S0(final Activity r100, final NormalLogin$login$afterHostLogin$1.a.b r110) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r110, "callback");
        FLogger.f375446a.d("NormalLoginService", "bindDouyin: " + r100);
        ?? r101 = new f(r110, this, r100);
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r111 = (FragmentActivity) r100;
    L6:
        if (r111 != null) goto L8;
        r101.invoke(Boolean.TRUE);
        return;
    L8:
        Keva r102 = com.larus.api.bussiness.a.f286896a;
        com.larus.api.bussiness.a.a(AppHost.f326268a.getAppClock().currentTimeMillis());
        qr9.b r103 = VideoFeedProviderDelegate.f365695b.getTopPlayerController();
        if (r103 == null) goto L11;
        r103.pausePlayer();
    L11:
        Map<String, String> r104 = Aos.INSTANCE.getController().getAuthContextProvider().a();
        JSONObject r105 = new JSONObject();
        if (r104 != null) goto L14;
    L17:
        boolean r106 = true;
    L18:
        if (r106 == true) goto L25;
        Iterator<String> r107 = r104.keySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();
        String r109 = r104.get(r108);
        if (r109 == null) goto L21;
        r105.put(r108, r109);
    L25:
        CommonDialog.a r112 = new CommonDialog.a();
        r112.i(r100.getString(R.string.larus_dy_authorize_pop_title));
        r112.g(r100.getString(R.string.larus_dy_authorize_pop));
        CommonDialog.a.f(r112, new l(r101, r105), r100.getString(R.string.larus_dy_authorize_pop_confirm), false, 12);
        CommonDialog.a.e(r112, new m(r101, r105), r100.getString(R.string.larus_phone_change_toast_cancel), 4);
        r112.f327197z = false;
        r112.b(ContextCompat.getColor(r100, R.color.larus_neutral_100)).T90(r111.getSupportFragmentManager(), null);
        o.f365780a.reportEvent("sdk_video_notice_show", r105);
        return;
    L14:
        if (r104.isEmpty() == true) goto L17;
        r106 = false;
        goto L18
    L5:
        r111 = null;
        goto L6
    }

    @Override // com.bytedance.awemeopen.user.serviceapi.normal.AoNormalLoginService
    public final void s0(Activity r100, final u64.a r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "callback");
        Looper r102 = Looper.myLooper();
        Intrinsics.checkNotNull(r102);
        new Handler(r102).post(new o48.e(r101));
        FLogger.f375446a.d("NormalLoginService", "requestDouyinToken  :");
    }
}
