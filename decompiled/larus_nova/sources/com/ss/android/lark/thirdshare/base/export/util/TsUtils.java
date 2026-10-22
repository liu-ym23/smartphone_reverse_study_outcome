package com.ss.android.lark.thirdshare.base.export.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.thread.ThreadUtils;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.m;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.audit.AuditManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.authorization.ThridPartySDKAuthEffectType;
import com.ss.android.lark.thirdshare.base.export.OnShareCallback;
import com.ss.android.lark.thirdshare.base.export.ShareActionType;
import com.ss.android.lark.thirdshare.base.export.ShareAnswerType;
import com.ss.android.lark.thirdshare.base.export.ShareEntity;
import com.ss.android.lark.thirdshare.base.export.TransActivity;
import com.ss.android.lark.thirdshare.base.export.TransActivityDelegate4Share;
import com.ss.android.lark.utils.ApiUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.ViewUtils;
import com.ss.android.lark.utils.n;
import java.io.File;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public final class TsUtils {
    public static void e(final ShareEntity r100) {
        if (r100.isTextShare() == false) goto L11;
        String r101 = r100.getDowngradeContent();
        Token r102 = u6c.c.f548994a;
        Intent r103 = new Intent("android.intent.action.SEND");
        r103.setType("text/plain");
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "";
    L7:
        r103.putExtra("android.intent.extra.TEXT", r101);
        Intent r104 = Intent.createChooser(r103, UIHelper.getString(R.string.Lark_UserGrowth_InvitePeopleContactsShareTo));
        r104.setFlags(268435456);
        LarkContext.getApplication().startActivity(r104);
        if (r100.getCallback() == null) goto L17;
        r100.getCallback().onSuccess(ShareActionType.SYS);
        return;
    L17:
        return;
    L11:
        if (r100.isImageShare() == false) goto L14;
        ApiUtils.a r105 = new e(r100);
        File r106 = r100.getImageFile();
        Token r107 = u6c.c.f548994a;
        c.b(r106, "image/*", r105);
        return;
    L14:
        if (r100.isFileShare() == false) goto L20;
        ApiUtils.a r108 = new f(r100);
        File r109 = r100.getImageFile();
        Token r110 = u6c.c.f548994a;
        MimeTypeMap r111 = MimeTypeMap.getSingleton();
        int r112 = r109.getName().lastIndexOf(46) + 1;
        c.b(r109, r111.getMimeTypeFromExtension(r109.getName().substring(r112).toLowerCase()), r108);
        return;
    }

    public static boolean a(ShareEntity r100, ShareActionType r101) {
        if (u6c.c.e(r101) == false) goto L5;
        return false;
    L5:
        if (r100.getCallback() == null) goto L11;
        r100.getCallback().onFailed(r101, OnShareCallback.NOT_INSTALLED.appendMsg(r101.name()));
        return true;
    L11:
        return true;
    }

    public static boolean b(ShareEntity r100, ShareActionType r101) {
        if (r101.isThirdAppShareType() == true) goto L9;
        OnShareCallback.ShareError r102 = OnShareCallback.ILLEGAL_CONFIG_PARAM;
        b.a(r102.toString(r101 + " is not third share type."));
        if (r100.getCallback() == null) goto L11;
        r100.getCallback().onFailed(r101, r102);
        return true;
    L11:
        return true;
    L9:
        return false;
    }

    public static void f(Context r100, ShareEntity r101) {
        if (TextUtils.isEmpty(r101.getContentType()) == false) goto L7;
        r101.getCallback().onFailed(r101.getCurActionType(), OnShareCallback.ILLEGAL_CONFIG_PARAM);
        ViewUtils.showCommonErrorTip();
        return;
    L7:
        if (r101.isCrossProcess() == false) goto L16;
        TransActivityDelegate4Share r102 = new TransActivityDelegate4Share();
        Map<TransActivity, TransActivity.TransActivityDelegate> r103 = TransActivity.f441214a;
        Intent r104 = new Intent(LarkContext.getApplication(), TransActivity.class);     // Catch: Exception -> L13
        r104.putExtra("extra_delegate", r102);     // Catch: Exception -> L13
        r104.putExtra(TransActivityDelegate4Share.EXTRA_SHARE_ENTITY, r101);     // Catch: Exception -> L13
        if (ViewUtils.isActivityAlive(null) == true) goto L12;
        r104.addFlags(268435456);     // Catch: Exception -> L13
        LarkContext.getApplication().startActivity(r104);     // Catch: Exception -> L13
        return;
    L12:
        throw null;     // Catch: Exception -> L13
    L13:
        e = move-exception;
        Log.e("ThirdShare", e);
        return;
    L16:
        if (r101.getCurActionType() == ShareActionType.UNKNOWN) goto L19;
        c(r100, r101, r101.getCurActionType());
        return;
    L19:
        if (r101.getShareActionTypes().size() != 1) goto L22;
        ShareActionType r105 = (ShareActionType) ListProtector.get(r101.getShareActionTypes(), 0);
        r101.setCurActionType((ShareActionType) ListProtector.get(r101.getShareActionTypes(), 0));
        c(r100, r101, r105);
        return;
    L22:
        if (ViewUtils.isActivityAlive(r100) == true) goto L25;
        return;
    L25:
        if (r101.getCallback() == null) goto L27;
        r101.getCallback().onShow();
    L27:
        LKUIDialog r106 = new w6c.b(r100, r101).f558474b;
        if (DialogLancet.shouldBlockDialogShow(r106) == false) goto L34;
        DialogLancet.handleBlockedDialogShow(r106);
        return;
    L34:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L33
    L31:
        DialogLancet.beforeDialogShow(r106);
        r106.show();
        DialogLancet.afterDialogShow(r106);
    }

    /* JADX WARN: Type inference failed for: r0v23, types: [com.ss.android.lark.thirdshare.base.export.util.d] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.ss.android.lark.thirdshare.base.export.util.h] */
    public static void c(final Context r110, final ShareEntity r111, final ShareActionType r112) {
        if (r111.getCallback() == null) goto L8;
        if (r111.getCallback().intercept(r112) == false) goto L8;
        return;
    L8:
        if (r112.isThirdAppShareType() == false) goto L79;
        String r100 = r112.name();
        r100.getClass();
        int r101 = r100.hashCode();
        boolean r102 = true;
        if (r101 == (-471685830)) goto L31;
        if (r101 == 3616) goto L27;
        if (r101 == 113011944) goto L23;
        if (r101 == 1344024189) goto L19;
    L32:
        byte r103 = -1;
    L35:
        if (r103 == 0) goto L66;
        if (r103 == 1) goto L53;
        if (r103 == 2) goto L40;
        if (r103 == 3) goto L66;
        Log.e("ThirdShare", "it is other share action type name: " + r112.name());
        goto L79
    L40:
        int r104 = a.f441217a;
        if (AuditManager.isInit() == true) goto L43;
        Log.e("AdminShareSdkConfig", "WeiBoSDK AuditManager has not init");
    L50:
        if (r102 == true) goto L79;
        ThreadUtils.runOnUIThread(new j(r110, R.string.Lark_Core_UnableShareToWeibo_Toast));
        r111.getCallback().onFailed(r112, OnShareCallback.ADMIN_WEIBO_SDK_DISABLE);
        return;
    L43:
        Pair<Integer, Integer> r105 = AuditManager.getInstance().checkAuthorityWithErrorType(28, "SDK", String.valueOf(ThridPartySDKAuthEffectType.WeiBoSDK.getValue()));
        Log.i("AdminShareSdkConfig", "WeiBoSDK AuditManager checkAuthorityWithErrorType result: " + r105.first + ", error: " + r105.second);
        Integer r106 = (Integer) r105.first;
        if (r106 == null) goto L50;
        if (r106.intValue() != 1) goto L50;
        r102 = false;
        goto L50
    L53:
        int r107 = a.f441217a;
        if (AuditManager.isInit() == true) goto L56;
        Log.e("AdminShareSdkConfig", "QQSDK AuditManager has not init");
    L63:
        if (r102 == true) goto L79;
        ThreadUtils.runOnUIThread(new j(r110, R.string.Lark_Core_UnableShareToQQ_Toast));
        r111.getCallback().onFailed(r112, OnShareCallback.ADMIN_QQ_SDK_DISABLE);
        return;
    L56:
        Pair<Integer, Integer> r108 = AuditManager.getInstance().checkAuthorityWithErrorType(28, "SDK", String.valueOf(ThridPartySDKAuthEffectType.QQSDK.getValue()));
        Log.i("AdminShareSdkConfig", "QQSDK AuditManager checkAuthorityWithErrorType result: " + r108.first + ", error: " + r108.second);
        Integer r109 = (Integer) r108.first;
        if (r109 == null) goto L63;
        if (r109.intValue() != 1) goto L63;
        r102 = false;
    L66:
        int r113 = a.f441217a;
        if (AuditManager.isInit() == true) goto L69;
        Log.e("AdminShareSdkConfig", "WeChatSDK AuditManager has not init");
    L76:
        if (r102 == true) goto L79;
        ThreadUtils.runOnUIThread(new j(r110, R.string.Lark_Core_UnableShareToWechat_Toast));
        r111.getCallback().onFailed(r112, OnShareCallback.ADMIN_WECHAT_SDK_DISABLE);
        return;
    L69:
        Pair<Integer, Integer> r114 = AuditManager.getInstance().checkAuthorityWithErrorType(28, "SDK", String.valueOf(ThridPartySDKAuthEffectType.WeChatSDK.getValue()));
        Log.i("AdminShareSdkConfig", "WeChatSDK AuditManager checkAuthorityWithErrorType result: " + r114.first + ", error: " + r114.second);
        Integer r115 = (Integer) r114.first;
        if (r115 == null) goto L76;
        if (r115.intValue() != 1) goto L76;
        r102 = false;
        goto L76
    L19:
        if (r100.equals("wechat_session") == false) goto L32;
        r103 = 3;
        goto L35
    L23:
        if (r100.equals("weibo") == false) goto L32;
        r103 = 2;
        goto L35
    L27:
        if (r100.equals("qq") == false) goto L32;
        r103 = 1;
        goto L35
    L31:
        if (r100.equals("wechat_timeline") == false) goto L32;
        r103 = 0;
    L79:
        Map<ShareActionType, String> r116 = r111.getAnswerTypes();
        if (r116 == null) goto L153;
        String r117 = r116.get(r112);
        if (TextUtils.isEmpty(r117) == true) goto L153;
        if (ShareActionType.WX_TIMELINE != r112) goto L89;
        if (r111.isTextShare() == false) goto L89;
        r117 = ShareAnswerType.DOWNGRADE_TO_WAKEUP_BY_TIP;
    L89:
        if (ShareAnswerType.DOWNGRADE_TO_SYSTEM_SHARE.equals(r117) == false) goto L92;
        e(r111);
    L92:
        if (ShareAnswerType.DOWNGRADE_TO_SYSTEM_SHARE_BY_SPECIFIC_APP.equals(r117) == false) goto L131;
        if (b(r111, r112) == true) goto L131;
        if (a(r111, r112) == true) goto L131;
        String r118 = "";
        if (r111.isTextShare() == false) goto L113;
        String r119 = r111.getDowngradeContent();
        ApiUtils.a r120 = new g(r111, r112);
        ComponentName r121 = c.a(r112);     // Catch: Exception -> L111
        if (r121 != null) goto L105;
        r120.consume(Boolean.FALSE);     // Catch: Exception -> L111
    L193:
        goto L131
    L105:
        Intent r122 = new Intent("android.intent.action.SEND");     // Catch: Exception -> L111
        r122.setType("text/plain");     // Catch: Exception -> L111
        if (TextUtils.isEmpty(r119) == true) goto L109;
        r118 = r119;
    L109:
        r122.putExtra("android.intent.extra.TEXT", r118);     // Catch: Exception -> L111
        r122.setComponent(r121);     // Catch: Exception -> L111
        r122.setFlags(268435456);     // Catch: Exception -> L111
        LarkContext.getApplication().startActivity(r122);     // Catch: Exception -> L111
        r120.consume(Boolean.TRUE);     // Catch: Exception -> L111
    L111:
        r120.consume(Boolean.FALSE);
        goto L131
    L113:
        if (r111.isImageShare() == false) goto L125;
        final ?? r123 = new h(r111);
        File r124 = r111.getImageFile();
        ApiUtils.a r125 = new i(r111, r123);
        ComponentName r126 = c.a(r112);     // Catch: Exception -> L123
        if (r126 != null) goto L118;
        r125.consume(Boolean.FALSE);     // Catch: Exception -> L123
    L196:
        goto L131
    L118:
        Uri r127 = m.a(LarkContext.getApplication(), r124);     // Catch: Exception -> L123
        if (r127 != null) goto L121;
        Log.e("ThirdShare", "getUriForFile failed.");     // Catch: Exception -> L123
        r125.consume(Boolean.FALSE);     // Catch: Exception -> L123
        goto L196
    L121:
        Intent r128 = new Intent("android.intent.action.SEND");     // Catch: Exception -> L123
        r128.putExtra("android.intent.extra.STREAM", r127);     // Catch: Exception -> L123
        r128.setType("image/*");     // Catch: Exception -> L123
        r128.setComponent(r126);     // Catch: Exception -> L123
        TextUtils.isEmpty("");     // Catch: Exception -> L123
        r128.putExtra("android.intent.extra.TEXT", "");     // Catch: Exception -> L123
        TextUtils.isEmpty("");     // Catch: Exception -> L123
        r128.putExtra("Kdescription", "");     // Catch: Exception -> L123
        r128.setFlags(268435456);     // Catch: Exception -> L123
        LarkContext.getApplication().startActivity(r128);     // Catch: Exception -> L123
        r125.consume(Boolean.TRUE);     // Catch: Exception -> L123
    L123:
        r125.consume(Boolean.FALSE);
        goto L131
    L125:
        if (r111.isMiniAppShare() == false) goto L131;
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == false) goto L129;
        ViewUtils.showToastShort("sysShare didn't support miniApp");
    L129:
        Log.e("ThirdShare", "WxSdk doesn't exist.");
    L131:
        if (ShareAnswerType.DOWNGRADE_TO_WAKEUP_BY_TIP.equals(r117) == false) goto L150;
        if (b(r111, r112) == true) goto L150;
        if (a(r111, r112) == true) goto L150;
        if (r111.isTextShare() == false) goto L144;
        ShareEntity.TextDowngradePanel r129 = r111.getTextDowngradePanel();
        u6c.c.g(r110, r129.getDowngradePanelCopyContent(), r111.getExemptEnable(), r129.getDowngradePanelTitle(), r112, new AnonymousClass3(r111, r112));
        if (r111.getUdSharePanelCallback() == null) goto L150;
        r111.getUdSharePanelCallback().a();
        goto L150
    L144:
        if (r111.isImageShare() == false) goto L150;
        ShareEntity.ImageDowngradePanel r130 = r111.getImageDowngradePanel();
        final String r131 = r130.getDowngradePanelTitle();
        if (r130.isNeedSave2Album() == false) goto L148;
        d(r110, r111, new d(r110, r131, r111, r112));
        goto L150
    L148:
        g(r110, r131, r111, r112);
    L150:
        if (r111.getCallback() == null) goto L199;
        r111.getCallback().onFailed(r112, OnShareCallback.INTERCEPT_DOWNGRADE);
        return;
    L199:
        return;
    L153:
        v6c.a r132 = (v6c.a) ApiUtils.getApi(v6c.a.class);
        if (r132 == null) goto L158;
        r132.a();
    L158:
        if (r112.isThirdAppShareType() == false) goto L176;
        if (b(r111, r112) == false) goto L163;
        return;
    L163:
        if (a(r111, r112) == true) goto L208;
        v6c.a r133 = (v6c.a) ApiUtils.getApi(v6c.a.class);
        if (r133 == null) goto L170;
        r133.a();
    L170:
        if (r111.getCallback() == null) goto L173;
        r111.getCallback().onFailed(r112, OnShareCallback.BASE_DEP_API_IS_NULL);
    L173:
        if (r111.getCallback() == null) goto L200;
        r111.getCallback().onSuccess(r112);
        return;
    L200:
        return;
    L208:
        return;
    L176:
        if (ShareActionType.SYS.equals(r112) == false) goto L178;
        e(r111);
        return;
    L178:
        ShareActionType r134 = ShareActionType.COPY;
        if (r134.equals(r112) == false) goto L189;
        if (r111.getExemptEnable() == false) goto L183;
        boolean r135 = u6c.c.c(r111.getContent());
    L185:
        if (r111.getCallback() == null) goto L203;
        if (r135 == false) goto L204;
        r111.getCallback().onSuccess(r134);
        return;
    L204:
        return;
    L203:
        return;
    L183:
        r135 = u6c.c.b(r111.getContent());
        goto L185
    L189:
        if (ShareActionType.SAVE.equals(r112) == false) goto L191;
        d(r110, r111, null);
        return;
    L191:
        r112.getShareItemInfo().mListener.onClickReal(r110, r111);
    }

    public static void d(Context r100, ShareEntity r101, d r102) {
        File r103 = r101.getImageFile();
        k r104 = new k(r101, r102);
        Token r105 = u6c.c.f548994a;
        if (ViewUtils.isActivityAlive(r100) == false) goto L6;
        com.ss.android.lark.utils.h.g(ViewUtils.getActivityByContext(r100), new u6c.d(r103, r104), n.c(), new Token("LARK-PSDA-third_share_panel_share_picture_save_storage_permission"), new String[0]);
        return;
    }

    public static void g(Context r100, String r101, final ShareEntity r102, final ShareActionType r103) {
        u6c.c.g(r100, "", r102.getExemptEnable(), r101, r103, new AnonymousClass4(r102, r103));
        if (r102.getUdSharePanelCallback() == null) goto L6;
        r102.getUdSharePanelCallback().a();
        return;
    }
}
