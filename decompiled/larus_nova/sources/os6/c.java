package os6;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.SparseArray;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.router.SmartRouter;
import com.bytedance.sdk.account.platform.api.IOnekeyLoginService;
import com.bytedance.sdk.account.platform.base.AuthorizeFramework;
import com.larus.account.base.api.ILoginService;
import com.larus.account.base.model.LoginPlatform;
import com.larus.common.apphost.AppHost;
import com.larus.login.api.CommonDouYinLoginUtil;
import com.larus.login.api.DouYinBindStatus;
import com.larus.login.api.ITouristApi;
import com.larus.login.api.TouristManager;
import com.larus.login.api.b0;
import com.larus.login.api.ecommerce.ECommerceTextConfigRepository;
import com.larus.login.api.k0;
import com.larus.nova.R;
import com.larus.platform.model.TriggerLoginScene;
import com.larus.platform.service.AccountService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class c extends kl6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f526502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<Object> f526503b = null;

    public static final class a implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function2<Boolean, String, Unit> f526504a;

        /* JADX INFO: renamed from: os6.c$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C7105a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f526505a = null;

            static {
                int[] r100 = new int[DouYinBindStatus.values().length];
                r100[DouYinBindStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f526505a = r100;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function2<? super Boolean, ? super String, Unit> r100) {
            this.f526504a = r100;
        }

        @Override // com.larus.login.api.b0
        public final void a(DouYinBindStatus r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "status");
            int r103 = C7105a.f526505a[r100.ordinal()];
            if (r103 != 1) goto L5;
        L7:
            this.f526504a.invoke(Boolean.TRUE, null);
            return;
        L5:
            if (r103 == 2) goto L7;
            this.f526504a.invoke(Boolean.FALSE, r102);
        }
    }

    public static final class b extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f526506a;

        public b(Context r100) {
            this.f526506a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            com.bytedance.router.i r101 = SmartRouter.buildRoute(this.f526506a, "//flow/webview");
            Bundle r102 = new Bundle();
            r102.putString("link_url", "https://lf9-cdn-tos.draftstatic.com/obj/ies-hotsoon-draft/grace_legal/Shopping-Payment-FAQ.html");
            r101.f267554c.putExtras(r102);
            r101.d();
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
            r100.setUnderlineText(false);
            Context r101 = this.f526506a;
            r100.setColor(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_100, r101, R.color.larus_neutral_100)));
        }
    }

    /* JADX INFO: renamed from: os6.c$c, reason: collision with other inner class name */
    public static final class C7106c implements os6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<JSONObject, Unit> f526507a;

        /* JADX WARN: Multi-variable type inference failed */
        public C7106c(Function1<? super JSONObject, Unit> r100) {
            this.f526507a = r100;
        }

        @Override // os6.e
        public final void onResult(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "callbackJsonObject");
            this.f526507a.invoke(r100);
        }
    }

    public static final class d implements os6.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<JSONObject, Unit> f526508a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(Function1<? super JSONObject, Unit> r100) {
            this.f526508a = r100;
        }

        @Override // os6.e
        public final void onResult(JSONObject r100) {
            Intrinsics.checkNotNullParameter(r100, "callbackJsonObject");
            this.f526508a.invoke(r100);
        }
    }

    public static final class e implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f526509a;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f526510a = null;

            static {
                int[] r100 = new int[DouYinBindStatus.values().length];
                r100[DouYinBindStatus.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[DouYinBindStatus.ALREADY_BOUND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f526510a = r100;
            }
        }

        public e(f r100) {
            this.f526509a = r100;
        }

        @Override // com.larus.login.api.b0
        public final void a(DouYinBindStatus r100, int r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "status");
            int r103 = a.f526510a[r100.ordinal()];
            if (r103 != 1) goto L5;
        L7:
            this.f526509a.a();
            return;
        L5:
            if (r103 == 2) goto L7;
            this.f526509a.b();
        }
    }

    static {
        f526502a = new c();
        f526503b = new ArrayList();
        new SparseArray();
    }

    @Override // os6.d
    public final long a() {
        Long r100 = StringsKt.toLongOrNull(AccountService.f365697a.getUserId());
        if (r100 != null) goto L7;
        return -1;
    L7:
        return r100.longValue();
    }

    @Override // os6.d
    public final String d() {
        return AccountService.f365697a.B();
    }

    @Override // os6.d
    public final String e() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L7;
        n38.e r101 = r100.Y(LoginPlatform.DOUYIN);
        if (r101 == null) goto L7;
        return r101.f516997a;
    L7:
        return null;
    }

    @Override // os6.d
    public final String getAvatarUrl() {
        String r100 = AccountService.f365697a.s();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // os6.d
    public final String getNickName() {
        return AccountService.f365697a.getNickname();
    }

    @Override // os6.d
    public final String getUid() {
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L7;
        n38.e r101 = r100.Y(LoginPlatform.DOUYIN);
        if (r101 == null) goto L7;
        String r102 = r101.f516998b;
    L8:
        if (r102 != null) goto L11;
        return "";
    L11:
        return r102;
    L7:
        r102 = null;
        goto L8
    }

    @Override // os6.d
    public final boolean isLogin() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        return AccountService.f365697a.isLogin().booleanValue();
    L4:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Object r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        Boolean r103 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L9;
        r102 = r103;
    L9:
        return ((Boolean) r102).booleanValue();
    }

    @Override // os6.d
    public final boolean c() {
        if (isLogin() == true) goto L5;
        return false;
    L5:
        ILoginService r100 = (ILoginService) ServiceManager.get().getService(ILoginService.class);
        if (r100 == null) goto L8;
        n38.e r101 = r100.Y(LoginPlatform.DOUYIN);
    L9:
        if (r101 != null) goto L11;
        return false;
    L11:
        if (r101.f517002f <= System.currentTimeMillis()) goto L15;
        return true;
    L15:
        return false;
    L8:
        r101 = null;
        goto L9
    }

    public c() {
    }

    public static SpannableStringBuilder h(Context r100, String r101) {
        String r102 = ContextCompat.getString(r100, R.string.larus_learn_more);
        SpannableString r103 = new SpannableString(r102);
        r103.setSpan(new b(r100), 0, r102.length(), 33);
        r103.setSpan(new StyleSpan(1), 0, r102.length(), 33);
        SpannableStringBuilder r104 = new SpannableStringBuilder();
        r104.append(r101);
        r104.append(r103);
        return r104;
    }

    @Override // os6.d
    public final void f(int r100, int r101, Function1<? super JSONObject, Unit> r102) {
        Intrinsics.checkNotNullParameter(r102, "callback");
        JSONObject r103 = new JSONObject();
        if (r100 != 1) goto L7;
        int r104 = i.f526515a;
        C7106c r105 = new C7106c(r102);
        Intrinsics.checkNotNullParameter(r103, "callbackRes");
        Intrinsics.checkNotNullParameter(r105, "callback");
        IOnekeyLoginService r106 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (r106 == null) goto L7;
        r106.getPhoneInfo(new g(r103, r105));
    L7:
        if (r101 != 1) goto L12;
        int r107 = i.f526515a;
        d r108 = new d(r102);
        Intrinsics.checkNotNullParameter(r103, "callbackRes");
        Intrinsics.checkNotNullParameter(r108, "callback");
        IOnekeyLoginService r109 = (IOnekeyLoginService) AuthorizeFramework.getService(IOnekeyLoginService.class);
        if (r109 == null) goto L13;
        r109.getAuthToken(new h(r103, r108));
        return;
    L13:
        return;
    }

    @Override // os6.d
    public final void b(Context r210, os6.b r211, os6.a r212, Function2<? super Boolean, ? super String, Unit> r213) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "uiConfig");
        Intrinsics.checkNotNullParameter(r212, "sourceParams");
        Intrinsics.checkNotNullParameter(r213, "callback");
        com.larus.login.api.i r100 = new com.larus.login.api.i(Integer.valueOf(R.drawable.larus_binder_douyin), null, r211.f526499a, h(r210, r211.f526500b), r211.f526501c, null, false, null, null, false, 32674);
        FragmentActivity r101 = null;
        if ((r210 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r102 = (FragmentActivity) r210;
    L6:
        if (r102 != null) goto L14;
        Activity r103 = AppHost.f326268a.a().getCurrentActivity();
        if ((r103 instanceof FragmentActivity) == false) goto L10;
        r101 = (FragmentActivity) r103;
    L10:
        if (r101 != null) goto L13;
        r213.invoke(Boolean.FALSE, "no fragment activity");
        return;
    L13:
        FragmentActivity r104 = r101;
    L15:
        CommonDouYinLoginUtil r105 = CommonDouYinLoginUtil.f356945a;
        String r106 = r212.f526497a;
        if (r106 != null) goto L18;
        String r107 = "local_life";
    L19:
        String r108 = r212.f526498b;
        if (r108 != null) goto L22;
        r108 = "local_life";
    L22:
        k0 r109 = new k0(r104, r107, r108, null, false, false, new a(r213), null, null, null, r100, 200, null, null, null, null, null, 127880);
        r105.getClass();
        CommonDouYinLoginUtil.s(r109);
        return;
    L18:
        r107 = r106;
        goto L19
    L14:
        r104 = r102;
        goto L15
    L5:
        r102 = null;
        goto L6
    }

    @Override // os6.d
    public final void g(Context r310, String r311, String r312, f r313) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "enterFrom");
        Intrinsics.checkNotNullParameter(r312, "enterMethod");
        Intrinsics.checkNotNullParameter(r313, "callback");
        TouristManager r100 = TouristManager.f357001a;
        if (r100.f() == false) goto L6;
        ITouristApi.a.a(r100, TriggerLoginScene.TRIGGER_LOGIN_LOCAL_LIFE, false, 2);
        r313.b();
        return;
    L6:
        if ((r310 instanceof FragmentActivity) == false) goto L8;
        FragmentActivity r101 = (FragmentActivity) r310;
    L9:
        FragmentActivity r102 = r101;
        if (r102 != null) goto L13;
        r313.b();
        return;
    L13:
        com.larus.login.api.i r110 = new com.larus.login.api.i(Integer.valueOf(R.drawable.larus_binder_douyin), null, ContextCompat.getString(r102, R.string.larus_settings_bottomsheet_title_douyin_account_cn), h(r102, ContextCompat.getString(r102, uj9.a.a())), ContextCompat.getString(r102, R.string.larus_settings_bottomsheet_btn_link_douyin_cn), ContextCompat.getString(r102, R.string.larus_settings_bottomsheet_btn_later_cn), false, null, null, false, 32706);
        CommonDouYinLoginUtil r210 = CommonDouYinLoginUtil.f356945a;
        e r103 = new e(r313);
        ECommerceTextConfigRepository r104 = ECommerceTextConfigRepository.f357016a;
        k0 r211 = new k0(r102, r311, r312, null, false, false, r103, null, null, null, ECommerceTextConfigRepository.a(r102, r312, r110), 200, null, null, null, null, null, 127880);
        r210.getClass();
        CommonDouYinLoginUtil.s(r211);
        return;
    L8:
        r101 = null;
        goto L9
    }
}
