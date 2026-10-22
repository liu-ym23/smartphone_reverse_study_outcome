package com.bytedance.ee.docsdk.impl.document.plugins.offline.resourceinterceptor;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.u.i;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.docsdk.impl.utils.LanguageUtil;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AssetsUtils;
import com.ss.android.lark.dynamicconfig.interfaces.IDomainConfigService;
import com.ss.android.lark.picker.base.widget.utils.FG;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public class OfflineResourceInterceptor {
    private static final String[] DOC_USER_INFOS = null;
    private static final String[] SLIDES_USER_INFOS = null;
    private static final String TAG = "OfflineResourceInterceptor";

    public OfflineResourceInterceptor() {
    }

    static {
        SLIDES_USER_INFOS = new String[]{"\"{{ user_id }}\"", "\"{{ sz }}\"", "\"{{ host }}\"", "\"{{ ws_server }}\"", "\"{{ language }}\"", "\"{{ user_agent }}\"", "\"{{ suid }}\"", "\"{{ tenant_id }}\"", "\"{{ department_id }}\"", "\"{{ ws_ticket }}\"", "\"{{ can_create_sheet }}\"", "{{client_vars|safe}}"};
        DOC_USER_INFOS = new String[]{"\"{{ user_id }}\"", "\"{{ sz }}\"", "\"{{ host }}\"", "\"{{ ws_server }}\"", "\"{{ language }}\"", "\"{{ user_agent }}\"", "\"{{ suid }}\"", "\"{{ tenant_id }}\"", "\"{{ department_id }}\"", "\"{{ ws_ticket }}\"", "\"{{ can_create_sheet }}\"", "\"{{ app_config }}\"", "{{client_vars|safe}}"};
    }

    private String getFg() {
        JSONObject r100 = new JSONObject(LocalFG.INSTANCE.getDEF_FG_STR());     // Catch: Exception -> L4
        r100.put("ccm.sheet.ai.inline.reading-enable", false);     // Catch: Exception -> L4
        r100.put(FG.MY_AI, false);     // Catch: Exception -> L4
        r100.put("ccm.docx.mobile.docx_ai_1.0", false);     // Catch: Exception -> L4
        r100.put("ccm.docx.doc_ai_all_enabled", false);     // Catch: Exception -> L4
        r100.put("ccm.whiteboard.web.aigc", false);     // Catch: Exception -> L4
        r100.put("ccm.docx.ai_placeholder_is_default", false);     // Catch: Exception -> L4
        r100.put("ccm.bitable.optimize_preload", false);     // Catch: Exception -> L4
        r100.put("ccm.bitable.native_gallery_view", false);     // Catch: Exception -> L4
        r100.put("base.mobile.native_request_mobile_view", false);     // Catch: Exception -> L4
        r100.put("ccm.docx.all.mobile_revision_card_enable", false);     // Catch: Exception -> L4
        return r100.toString();
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private String getFontSize() {
        int r100 = Env.getFontSize();
        if (r100 != (-1)) goto L5;
        return ExifInterface.LATITUDE_SOUTH;
    L5:
        if (r100 != 1) goto L7;
        return "L";
    L7:
        if (r100 == 2) goto L10;
        return "M";
    L10:
        return "XL";
    }

    public Map<String, String> getHtmlReplaceMap(Context r100, String r101) {
        HashMap r102 = new HashMap();
        r102.put("{{ user_id }}", Env.getUserId());
        r102.put("{{ tenant_id }}", "1");
        r102.put("{{lang_cdn}}", "//lf-package-cn.feishucdn.com/obj/feishu-static/eesz/resource/bear/lang/" + LanguageUtil.convertLan(Env.getCacheLanguageSetting().getCountry(), Env.getCacheLanguageSetting().getLanguage()) + ".js");
        r102.put("{{ language }}", LanguageUtil.getLanguage(Env.getCacheLanguageSetting().getCountry(), Env.getCacheLanguageSetting().getLanguage()).toString());
        r102.put("\"{{ app_config }}\"", AssetsUtils.INSTANCE.readAssetsConfig(r100, "app_config.json"));
        r102.put("\"{{ app_debug_config }}\"", "{\"isDebug\":" + Boolean.FALSE + i.f25855d);
        r102.put("{{navigator_env}}", "prod");
        r102.put("{{navigator_path_prefix}}", "");
        r102.put("{{navigator_api_prefix}}", "https://internal-api-space.larkoffice.com/space");
        r102.put("{{ anonymous_access }}", BdpAppEventConstant.FALSE);
        r102.put("{{cdn_host}}", "//www.doubao.com");
        String[] r103 = DOC_USER_INFOS;
        if (r101.equals("slides") == false) goto L5;
        r103 = SLIDES_USER_INFOS;
    L5:
        int r104 = r103.length;
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L8;
        r102.put(r103[r105], "null");
        r105 = r105 + 1;
        goto L6
    L8:
        r102.put("{{ enable_et_test }}", "false");
        r102.put("\"{{ globalKaConfig }}\"", SliceInitService.DEFAULT_SWITCH);
        r102.put("\"{{ device_info }}\"", String.format("{\"baseFontSize\": \"%s\"}", new Object[]{getFontSize()}));
        if (Env.isDarkMode() == false) goto L11;
        r102.put("\"{{ theme }}\"", "\"dark\"");
    L12:
        r102.put("{{ darkmode_enable }}", BdpAppEventConstant.TRUE);
        r102.put("{{ disk_crypto_enable }}", BdpAppEventConstant.FALSE);
        r102.put("{{ comment_disable_rn }}", BdpAppEventConstant.TRUE);
        r102.put("\"{{ mobile_fg_dictionary }}\"", getFg());
        r102.put("\"{{ mobile_ab_test_dictionary }}\"", SliceInitService.DEFAULT_SWITCH);
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L15
        ArrayList r107 = new ArrayList();     // Catch: Exception -> L15
        r107.add("sf1-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r107.add("sf3-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r107.add("sf6-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r106.put(IDomainConfigService.DomainAlias.DOCS_REACTION_BUCKET_PREX, new JSONArray(r107));     // Catch: Exception -> L15
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L15
        r108.put("biz_domain_config", r106);     // Catch: Exception -> L15
        r102.put("\"{{ settings_config }}\"", r108.toString());     // Catch: Exception -> L15
    L17:
        r102.put("{{iframeJsbCheck}}", "这里生成一个随机的key");
        return r102;
    L15:
        e = move-exception;
        Log.e(TAG, "replaceTemplateInfos()... ", e);
        goto L17
    L11:
        r102.put("\"{{ theme }}\"", "\"light\"");
        goto L12
    }
}
