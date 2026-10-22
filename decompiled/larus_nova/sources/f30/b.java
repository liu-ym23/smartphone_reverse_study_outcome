package f30;

import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.browser.jsbridge.base.GetUserInfoResultModel;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livehostapi.platform.depend.user.HostUserDetail;
import com.bytedance.android.livesdk.user.e;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import jc1.k;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import w20.v1;

/* JADX INFO: loaded from: classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getUserInfo")
public final class b extends v1<JsonObject, GetUserInfoResultModel> {
    public b() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(Object r100, CallContext r110) {
        JsonObject r101 = (JsonObject) r100;
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        JsonElement r102 = r101.get("through_aweme");
        boolean r111 = true;
        if (r102 == null) goto L5;
        boolean r103 = r102.getAsBoolean();
    L6:
        String r104 = null;
        if (r103 == false) goto L109;
        IMiddlewareUserService r105 = (IMiddlewareUserService) k.f(IMiddlewareUserService.class);
        if (r105 == null) goto L11;
        e r106 = r105.user();
    L12:
        GetUserInfoResultModel r107 = new GetUserInfoResultModel();
        if (r106 == null) goto L15;
        Boolean r108 = Boolean.valueOf(r106.isLogin());
    L16:
        r107.c(r108);
        if (r106 == null) goto L19;
        IBaseUser r109 = r106.b();
    L21:
        if (Intrinsics.areEqual(r107.a(), Boolean.TRUE) == false) goto L108;
        GetUserInfoResultModel.a r112 = new GetUserInfoResultModel.a();
        if (r109 == null) goto L25;
        String r113 = String.valueOf(r109.getShortId());
    L26:
        r112.e(r113);
        if (r109 == null) goto L29;
        String r114 = r109.getIdString();
    L30:
        r112.f(r114);
        if (r109 == null) goto L33;
        Intrinsics.checkNotNullParameter(r109, "$this$secUidExt");
        String r115 = r109.getCastSecUid();
    L34:
        r112.d(r115);
        if (r109 == null) goto L37;
        String r116 = r109.getNickName();
    L38:
        r112.c(r116);
        if (r109 == null) goto L43;
        py.k r117 = r109.getAvatarThumbKt();
        if (r117 == null) goto L43;
        List<String> r118 = r117.getUrls();
    L44:
        List<String> r119 = r118;
        if (r119 != null) goto L47;
    L50:
        boolean r120 = true;
    L51:
        if (r120 == true) goto L58;
        if (r109 == null) goto L107;
        py.k r121 = r109.getAvatarThumbKt();
        if (r121 == null) goto L107;
        List<String> r122 = r121.getUrls();
        if (r122 == null) goto L107;
        r104 = (String) CollectionsKt.first(r122);
    L107:
        r112.a(r104);
        r112.b(Boolean.FALSE);
        Unit r123 = Unit.INSTANCE;
        r107.e(r112);
        goto L108
    L58:
        if (r109 == null) goto L62;
        py.k r124 = r109.getAvatarMedium();
        if (r124 == null) goto L62;
        List<String> r125 = r124.getUrls();
    L63:
        List<String> r126 = r125;
        if (r126 != null) goto L66;
    L69:
        boolean r127 = true;
    L70:
        if (r127 == true) goto L77;
        if (r109 == null) goto L107;
        py.k r128 = r109.getAvatarMedium();
        if (r128 == null) goto L107;
        List<String> r129 = r128.getUrls();
        if (r129 == null) goto L107;
        r104 = (String) CollectionsKt.first(r129);
        goto L107
    L77:
        if (r109 == null) goto L79;
        String r130 = r109.getAvatarUrl();
    L80:
        if (r130 != null) goto L82;
    L85:
        boolean r131 = true;
    L86:
        if (r131 == true) goto L89;
        if (r109 == null) goto L107;
        r104 = r109.getAvatarUrl();
        goto L107
    L89:
        if (r109 == null) goto L93;
        py.k r132 = r109.getAvatarLarge();
        if (r132 == null) goto L93;
        List<String> r133 = r132.getUrls();
    L94:
        List<String> r134 = r133;
        if (r134 != null) goto L97;
    L100:
        if (r111 == true) goto L107;
        if (r109 == null) goto L107;
        py.k r135 = r109.getAvatarLarge();
        if (r135 == null) goto L107;
        List<String> r136 = r135.getUrls();
        if (r136 == null) goto L107;
        r104 = (String) CollectionsKt.first(r136);
        goto L107
    L97:
        if (r134.isEmpty() == true) goto L100;
        r111 = false;
    L93:
        r133 = null;
        goto L94
    L82:
        if (r130.length() == 0) goto L85;
        r131 = false;
        goto L86
    L79:
        r130 = null;
        goto L80
    L66:
        if (r126.isEmpty() == true) goto L69;
        r127 = false;
    L62:
        r125 = null;
        goto L63
    L47:
        if (r119.isEmpty() == true) goto L50;
        r120 = false;
    L43:
        r118 = null;
        goto L44
    L37:
        r116 = null;
        goto L38
    L33:
        r115 = null;
        goto L34
    L29:
        r114 = null;
        goto L30
    L25:
        r113 = null;
    L108:
        r107.b(GetUserInfoResultModel.Code.Success);
        r107.d("SUCCESS");
        finishWithResult(r107);
        return;
    L19:
        r109 = null;
        goto L21
    L15:
        r108 = null;
        goto L16
    L11:
        r106 = null;
        goto L12
    L109:
        GetUserInfoResultModel r137 = new GetUserInfoResultModel();
        if (TTMiddlewareLiveSDK.hostMiddlewareService().user().hostUserId() != 0) goto L113;
        r111 = false;
    L113:
        r137.c(Boolean.valueOf(r111));
        HostUserDetail r138 = TTMiddlewareLiveSDK.hostMiddlewareService().user().hostUserDetail();
        if (Intrinsics.areEqual(r137.a(), Boolean.TRUE) == false) goto L139;
        GetUserInfoResultModel.a r139 = new GetUserInfoResultModel.a();
        if (r138 == null) goto L120;
        String r140 = r138.shortId;
        if (r140 == null) goto L120;
    L121:
        r139.e(r140);
        if (r138 == null) goto L126;
        String r141 = r138.f102942id;
        if (r141 == null) goto L126;
    L127:
        r139.f(r141);
        if (r138 == null) goto L130;
        String r142 = r138.secUid;
    L131:
        r139.d(r142);
        if (r138 == null) goto L134;
        String r143 = r138.nickName;
    L135:
        r139.c(r143);
        if (r138 == null) goto L138;
        r104 = r138.avatarURL;
    L138:
        r139.a(r104);
        r139.b(Boolean.FALSE);
        Unit r144 = Unit.INSTANCE;
        r137.e(r139);
        goto L139
    L134:
        r143 = null;
        goto L135
    L130:
        r142 = null;
    L126:
        r141 = null;
    L120:
        r140 = null;
    L139:
        r137.b(GetUserInfoResultModel.Code.Success);
        r137.d("SUCCESS");
        finishWithResult(r137);
        return;
    L5:
        r103 = true;
        goto L6
    }
}
