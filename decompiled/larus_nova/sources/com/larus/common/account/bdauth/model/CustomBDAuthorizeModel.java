package com.larus.common.account.bdauth.model;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.sdk.account.platform.base.AuthorizeMonitorUtil;
import com.bytedance.sdk.open.aweme.common.constants.ParamKeyConstants;
import com.larus.applog.api.IApplog;
import com.larus.common.account.bdauth.api.AuthorizeApiOrigin;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class CustomBDAuthorizeModel implements vz8.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f325907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f325908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f325909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f325910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f325911e;

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.model.CustomBDAuthorizeModel$registerNewUser$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.common.account.bdauth.model.CustomBDAuthorizeModel", f = "CustomBDAuthorizeModel.kt", i = {}, l = {79}, m = "registerNewUser", n = {}, s = {})
    public static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ CustomBDAuthorizeModel this$0;

        public AnonymousClass1(CustomBDAuthorizeModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.registerNewUser(this);
        }
    }

    public final Context getContext() {
        return this.f325907a;
    }

    public CustomBDAuthorizeModel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f325907a = r100;
        this.f325908b = "CustomBDAuthorizeModel";
        this.f325909c = "/passport/open/auth_info/v2/";
        this.f325910d = "/passport/open/auth/";
        this.f325911e = LazyKt.lazy(new b());
    }

    @Override // vz8.a
    public final Object registerNewUser(Continuation<? super Boolean> r100) {
        if ((r100 instanceof AnonymousClass1) == false) goto L7;
        AnonymousClass1 r101 = (AnonymousClass1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L30
    L19:
        String r107 = (String) r103;     // Catch: Throwable -> L30
        if (r107 != null) goto L22;
    L25:
        if (r106 == false) goto L29;
        return Boxing.boxBoolean(false);
    L29:
        return Boxing.boxBoolean(Intrinsics.areEqual("success", new JSONObject(r107).optString("message")));
    L22:
        if (r107.length() == 0) goto L25;
        r106 = false;
        goto L25
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        AuthorizeApiOrigin r108 = (AuthorizeApiOrigin) this.f325911e.getValue();     // Catch: Throwable -> L30
        r101.label = 1;     // Catch: Throwable -> L30
        r103 = r108.registerNewUser(r101);     // Catch: Throwable -> L30
        if (r103 != r104) goto L19;
        return r104;
    L31:
        return Boxing.boxBoolean(false);
    L7:
        r101 = new AnonymousClass1(this, r100);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, za7.c, za7.d] */
    /* JADX WARN: Type inference failed for: r10v21, types: [T, za7.c] */
    @Override // vz8.a
    public final Object a(fb7.c r100, Continuation r110) {
        if ((r110 instanceof CustomBDAuthorizeModel$requestGetAuthInfoV2$1) == false) goto L7;
        CustomBDAuthorizeModel$requestGetAuthInfoV2$1 r101 = (CustomBDAuthorizeModel$requestGetAuthInfoV2$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        String r105 = "";
        int r106 = -1;
        boolean r107 = true;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r101.L$1;
        fb7.c r109 = (fb7.c) r101.L$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L50:
        String r112 = (String) r111;     // Catch: Throwable -> L14
        if (r112 == null) goto L57;
        r108.element = ya7.a.a(r112);     // Catch: Throwable -> L14
    L57:
        T r113 = r108.element;
        String r114 = "fail";
        if (r113 != 0) goto L60;
        r105 = this.f325907a.getString(R.string.bd_platform_error_tips_common);
    L70:
        IApplog.Companion r115 = IApplog.f287053a;
        JSONObject r116 = new JSONObject();
        r116.put("code", r106);
        r116.put("path", this.f325909c);
        r116.put("msg", r105);
        Unit r117 = Unit.INSTANCE;
        r115.reportEvent("flow_request_event", r116);
        FLogger.f375446a.i(this.f325908b, "requestGetAuthInfoV2 code=" + r106 + ", msg=" + r105);
        c(r109, r114, r106, r105);
        return r108.element;
    L60:
        za7.c r118 = (za7.c) r113;
        r106 = 0;
        if (r118.f571091a == true) goto L64;
        r107 = false;
    L64:
        if (r107 == true) goto L69;
        r106 = r118.f571092b;
        String r119 = r118.f571093c;
        if (r119 == null) goto L70;
        r105 = r119;
        goto L70
    L69:
        r114 = "success";
    L14:
        th = th;
        Ref.ObjectRef r120 = r108;
        r100 = r109;
    L56:
        th.printStackTrace();
        ?? r121 = new za7.c();
        r120.element = r121;
        int r122 = xz8.b.f565543a;
        r121.f571092b = xz8.b.a.a(th);
        r109 = r100;
        r108 = r120;
        goto L57
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        String r123 = null;
        if (TextUtils.isEmpty(null) == false) goto L38;
        StringBuilder r124 = new StringBuilder();
        r124.append(r100.f476274g);
        if (TextUtils.isEmpty(r100.f476275h) == true) goto L30;
        if (r124.length() > 0) goto L26;
    L28:
        r124.append(r100.f476275h);
        goto L30
    L26:
        if (r124.charAt(r124.length() - 1) == ',') goto L28;
        r124.append(",");
    L30:
        if (TextUtils.isEmpty(r100.f476276i) == false) goto L32;
    L37:
        r123 = r124.toString();
        goto L38
    L32:
        if (r124.length() > 0) goto L34;
    L36:
        r124.append(r100.f476276i);
        goto L37
    L34:
        if (r124.charAt(r124.length() - 1) == ',') goto L36;
        r124.append(",");
    L38:
        r120 = new Ref.ObjectRef();
        AuthorizeApiOrigin r125 = (AuthorizeApiOrigin) this.f325911e.getValue();     // Catch: Throwable -> L55
        if (r100 == null) goto L43;
        String r126 = r100.f476272e;     // Catch: Throwable -> L55
        if (r126 == null) goto L43;
    L44:
        if (r123 != null) goto L46;
        r123 = "";
    L46:
        r101.L$0 = r100;     // Catch: Throwable -> L55
        r101.L$1 = r120;     // Catch: Throwable -> L55
        r101.label = 1;     // Catch: Throwable -> L55
        r111 = r125.getAuthInfo(r126, r123, r101);     // Catch: Throwable -> L55
        if (r111 != r103) goto L49;
        return r103;
    L49:
        r109 = r100;
        r108 = r120;
    L43:
        r126 = "";
    L55:
        th = th;
    L7:
        r101 = new CustomBDAuthorizeModel$requestGetAuthInfoV2$1(this, r110);
        goto L8
    }

    public static void c(fb7.c r100, String r101, int r102, String r103) {
        JSONObject r104 = new JSONObject();     // Catch: JSONException -> L7
        if (r100 == null) goto L5;
        r104.put("client_key", r100.f476272e);     // Catch: JSONException -> L7
    L5:
        r104.put("sdk_version", 7);     // Catch: JSONException -> L7
        r104.put("params_for_special", "uc_login");     // Catch: JSONException -> L7
    L9:
        if (r104 != null) goto L11;
        r104 = new JSONObject();     // Catch: JSONException -> L16
    L11:
        r104.put("result", r101);     // Catch: JSONException -> L16
        r104.put("errCode", r102);     // Catch: JSONException -> L16
        if (r103 != null) goto L14;
        r103 = "";
    L14:
        r104.put(AuthorizeMonitorUtil.Param.ERROR_DESC, r103);     // Catch: JSONException -> L16
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        return;
    L7:
        e = move-exception;
        e.printStackTrace();     // Catch: JSONException -> L16
        r104 = null;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [T, za7.a, za7.d] */
    /* JADX WARN: Type inference failed for: r4v5, types: [T, za7.a, za7.d] */
    @Override // vz8.a
    public final Object b(fb7.c r110, String r111, Map r112, Continuation r210) {
        fb7.c r100 = r110;
        if ((r210 instanceof CustomBDAuthorizeModel$requestGetAuthCodeV2$1) == false) goto L7;
        CustomBDAuthorizeModel$requestGetAuthCodeV2$1 r101 = (CustomBDAuthorizeModel$requestGetAuthCodeV2$1) r210;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        int r107 = 0;
        String r113 = "";
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Ref.ObjectRef r108 = (Ref.ObjectRef) r101.L$1;
        fb7.c r109 = (fb7.c) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        Ref.ObjectRef r114 = r108;
        r100 = r109;
    L128:
        String r115 = (String) r103;     // Catch: Throwable -> L142
        if (r115 == null) goto L145;
        ?? r116 = new za7.a();     // Catch: Throwable -> L142
        ya7.a.b(r116, r115);     // Catch: Exception -> L138 Throwable -> L142
        if (r116.f571091a == false) goto L166;
        JSONObject r117 = r116.f571094d;     // Catch: Exception -> L138 Throwable -> L142
        if (r117 == null) goto L136;
        r116.f571087e = r117.optString("code");     // Catch: Exception -> L138 Throwable -> L142
        goto L166
    L136:
        r116.f571092b = -1;     // Catch: Exception -> L138 Throwable -> L142
    L166:
    L140:
        r114.element = r116;     // Catch: Throwable -> L142
        goto L145
    L138:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L142
    L142:
        Throwable th10 = th;
        r109 = r100;
        r108 = r114;
    L144:
        ?? r118 = new za7.a();
        r108.element = r118;
        int r119 = xz8.b.f565543a;
        r118.f571092b = xz8.b.a.a(th10);
        r114 = r108;
        r100 = r109;
    L145:
        T r120 = r114.element;
        String r121 = "fail";
        if (r120 != 0) goto L148;
        r113 = this.f325907a.getString(R.string.bd_platform_error_tips_common);
        r107 = -1;
    L158:
        IApplog.Companion r122 = IApplog.f287053a;
        JSONObject r123 = new JSONObject();
        r123.put("code", r107);
        r123.put("path", this.f325910d);
        r123.put("msg", r113);
        Unit r124 = Unit.INSTANCE;
        r122.reportEvent("flow_request_event", r123);
        FLogger.f375446a.i(this.f325908b, "requestGetAuthInfoV2 code=" + r107 + ", msg=" + r113);
        c(r100, r121, r107, r113);
        return r114.element;
    L148:
        za7.a r125 = (za7.a) r120;
        if (r125.f571091a == true) goto L152;
        r106 = false;
    L152:
        if (r106 == true) goto L157;
        r107 = r125.f571092b;
        String r126 = r125.f571093c;
        if (r126 == null) goto L158;
        r113 = r126;
        goto L158
    L157:
        r121 = "success";
    L14:
        th10 = th;
        goto L144
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        if (TextUtils.isEmpty(r111) == true) goto L23;
        if (r111 == null) goto L26;
        String r127 = r111;
    L27:
        Context r128 = this.f325907a;
        if (r100 == null) goto L31;
        String r129 = r100.f476265a;
        if (r129 == null) goto L31;
    L32:
        String r130 = null;
        if (TextUtils.isEmpty(r129) == false) goto L164;
    L42:
        ArrayList r131 = null;
    L43:
        HashMap r132 = new HashMap();
        if (r100 == null) goto L47;
        String r133 = r100.f476272e;
        if (r133 == null) goto L47;
    L48:
        r132.put("client_key", r133);
        r132.put("response_type", "code");
        r132.put("source", "native");
        r132.put("scope", r127);
        if (r100 == null) goto L51;
        String r134 = r100.f476273f;
    L53:
        if (TextUtils.isEmpty(r134) == true) goto L59;
        if (r100 == null) goto L57;
        String r135 = r100.f476273f;
        if (r135 == null) goto L57;
    L58:
        r132.put("from", r135);
    L57:
        r135 = "";
    L59:
        if (r100 == null) goto L61;
        String r136 = r100.f476273f;
    L63:
        if (TextUtils.equals("wap_to_native", r136) == false) goto L74;
        if (r100 == null) goto L66;
        String r137 = r100.f476271d;
    L68:
        if (TextUtils.isEmpty(r137) == true) goto L74;
        if (r100 == null) goto L72;
        String r138 = r100.f476271d;
        if (r138 == null) goto L72;
    L73:
        r132.put("redirect_uri", r138);
    L72:
        r138 = "";
        goto L73
    L66:
        r137 = null;
    L74:
        if (r100 == null) goto L76;
        String r139 = r100.f476270c;
    L78:
        if (TextUtils.isEmpty(r139) == true) goto L84;
        if (r100 == null) goto L82;
        String r140 = r100.f476270c;
        if (r140 == null) goto L82;
    L83:
        r132.put("state", r140);
    L82:
        r140 = "";
    L84:
        if (r100 == null) goto L86;
        String r141 = r100.f476265a;
    L88:
        if (TextUtils.isEmpty(r141) == true) goto L98;
        if (r100 == null) goto L92;
        String r142 = r100.f476265a;
        if (r142 == null) goto L92;
    L169:
        String r143 = gb7.a.a(r142.getBytes());     // Catch: Exception -> L95
    L97:
        r132.put(ParamKeyConstants.WebViewConstants.QUERY_ENCRIPTION_PACKAGE, r143);
    L95:
        e = move-exception;
        e.printStackTrace();
        r143 = null;
    L92:
        r142 = "";
    L98:
        if (r131 == null) goto L109;
        if (r131.isEmpty() == true) goto L109;
        StringBuilder r144 = new StringBuilder();
        int r145 = 0;
    L103:
        if (r145 >= r131.size()) goto L107;
        if (r145 == 0) goto L106;
        r144.append(",");
    L106:
        r144.append((String) ListProtector.get(r131, r145));
        r145 = r145 + 1;
        goto L103
    L107:
        r130 = r144.toString();
    L109:
        if (TextUtils.isEmpty(r130) == true) goto L111;
        r132.put("signature", r130);
        r132.put("sign", r130);
    L111:
        if (r112 == null) goto L124;
        Iterator r146 = r112.entrySet().iterator();
    L114:
        if (r146.hasNext() == false) goto L124;
        Map.Entry r147 = (Map.Entry) r146.next();
        String r148 = (String) r147.getKey();
        String r149 = (String) r147.getValue();
        if (TextUtils.isEmpty(r148) == true) goto L114;
        if (TextUtils.isEmpty(r149) == true) goto L114;
        if (r148 != null) goto L121;
        r148 = "";
    L121:
        if (r149 != null) goto L123;
        r149 = "";
    L123:
        r132.put(r148, r149);
    L124:
        r114 = new Ref.ObjectRef();
        AuthorizeApiOrigin r150 = (AuthorizeApiOrigin) this.f325911e.getValue();     // Catch: Throwable -> L142
        r101.L$0 = r100;     // Catch: Throwable -> L142
        r101.L$1 = r114;     // Catch: Throwable -> L142
        r101.label = 1;     // Catch: Throwable -> L142
        r103 = r150.getAuthCode(r132, r101);     // Catch: Throwable -> L142
        if (r103 != r104) goto L128;
        return r104;
    L86:
        r141 = null;
        goto L88
    L76:
        r139 = null;
        goto L78
    L61:
        r136 = null;
        goto L63
    L51:
        r134 = null;
    L47:
        r133 = "";
        goto L48
    L164:
        PackageInfo r151 = r128.getPackageManager().getPackageInfo(r129, 64);     // Catch: PackageManager.NameNotFoundException -> L41
        r131 = new ArrayList();
        Signature[] r152 = r151.signatures;
        if (r152 == null) goto L42;
        int r153 = r152.length;
        int r154 = 0;
    L39:
        if (r154 >= r153) goto L43;
        r131.add(gb7.a.a(r152[r154].toByteArray()));
        r154 = r154 + 1;
    L31:
        r129 = "";
    L26:
        r127 = "";
        goto L27
    L23:
        if (r100 == null) goto L26;
        r127 = r100.f476274g;
        if (r127 != null) goto L27;
    L7:
        r101 = new CustomBDAuthorizeModel$requestGetAuthCodeV2$1(this, r210);
        goto L8
    }
}
