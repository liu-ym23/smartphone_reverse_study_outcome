package com.bytedance.ee.docsdk.impl.document.plugins.offline.resourceinterceptor;

import android.content.Context;
import com.bytedance.ee.docsdk.impl.utils.LanguageUtil;
import com.ss.android.lark.chameleon.idependency.Env;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.AssetsUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        JSONObject r0 = new JSONObject(LocalFG.INSTANCE.getDEF_FG_STR());     // Catch: Exception -> L4
        r0.put("ccm.sheet.ai.inline.reading-enable", false);     // Catch: Exception -> L4
        r0.put("lark.my_ai.main_switch", false);     // Catch: Exception -> L4
        r0.put("ccm.docx.mobile.docx_ai_1.0", false);     // Catch: Exception -> L4
        r0.put("ccm.docx.doc_ai_all_enabled", false);     // Catch: Exception -> L4
        r0.put("ccm.whiteboard.web.aigc", false);     // Catch: Exception -> L4
        r0.put("ccm.docx.ai_placeholder_is_default", false);     // Catch: Exception -> L4
        r0.put("ccm.bitable.optimize_preload", false);     // Catch: Exception -> L4
        r0.put("ccm.bitable.native_gallery_view", false);     // Catch: Exception -> L4
        r0.put("base.mobile.native_request_mobile_view", false);     // Catch: Exception -> L4
        r0.put("ccm.docx.all.mobile_revision_card_enable", false);     // Catch: Exception -> L4
        return r0.toString();
    L4:
        e = move-exception;
        e.printStackTrace();
        return "";
    }

    private String getFontSize() {
        int r0 = Env.getFontSize();
        if (r0 != (-1)) goto L5;
        return "S";
    L5:
        if (r0 != 1) goto L7;
        return "L";
    L7:
        if (r0 == 2) goto L10;
        return "M";
    L10:
        return "XL";
    }

    public Map<String, String> getHtmlReplaceMap(Context r7, String r8) {
        HashMap r0 = new HashMap();
        r0.put("{{ user_id }}", Env.getUserId());
        r0.put("{{ tenant_id }}", "1");
        r0.put("{{lang_cdn}}", "//lf-package-cn.feishucdn.com/obj/feishu-static/eesz/resource/bear/lang/" + LanguageUtil.convertLan(Env.getCacheLanguageSetting().getCountry(), Env.getCacheLanguageSetting().getLanguage()) + ".js");
        r0.put("{{ language }}", LanguageUtil.getLanguage(Env.getCacheLanguageSetting().getCountry(), Env.getCacheLanguageSetting().getLanguage()).toString());
        r0.put("\"{{ app_config }}\"", AssetsUtils.INSTANCE.readAssetsConfig(r7, "app_config.json"));
        r0.put("\"{{ app_debug_config }}\"", "{\"isDebug\":" + Boolean.FALSE + "}");
        r0.put("{{navigator_env}}", "prod");
        r0.put("{{navigator_path_prefix}}", "");
        r0.put("{{navigator_api_prefix}}", "https://internal-api-space.larkoffice.com/space");
        r0.put("{{ anonymous_access }}", "False");
        r0.put("{{cdn_host}}", "//www.doubao.com");
        String[] r9 = DOC_USER_INFOS;
        if (r8.equals("slides") == false) goto L5;
        r9 = SLIDES_USER_INFOS;
    L5:
        int r10 = r9.length;
        int r3 = 0;
    L6:
        if (r3 >= r10) goto L8;
        r0.put(r9[r3], "null");
        r3 = r3 + 1;
        goto L6
    L8:
        r0.put("{{ enable_et_test }}", "false");
        r0.put("\"{{ globalKaConfig }}\"", "{}");
        r0.put("\"{{ device_info }}\"", String.format("{\"baseFontSize\": \"%s\"}", new Object[]{getFontSize()}));
        if (Env.isDarkMode() == false) goto L11;
        r0.put("\"{{ theme }}\"", "\"dark\"");
    L12:
        r0.put("{{ darkmode_enable }}", "True");
        r0.put("{{ disk_crypto_enable }}", "False");
        r0.put("{{ comment_disable_rn }}", "True");
        r0.put("\"{{ mobile_fg_dictionary }}\"", getFg());
        r0.put("\"{{ mobile_ab_test_dictionary }}\"", "{}");
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L15
        ArrayList r12 = new ArrayList();     // Catch: Exception -> L15
        r12.add("sf1-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r12.add("sf3-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r12.add("sf6-scmcdn-cn.feishucdn.com/obj/lark-reaction-cn");     // Catch: Exception -> L15
        r11.put("reaction_bucket_prex", new JSONArray(r12));     // Catch: Exception -> L15
        JSONObject r13 = new JSONObject();     // Catch: Exception -> L15
        r13.put("biz_domain_config", r11);     // Catch: Exception -> L15
        r0.put("\"{{ settings_config }}\"", r13.toString());     // Catch: Exception -> L15
    L17:
        r0.put("{{iframeJsbCheck}}", "这里生成一个随机的key");
        return r0;
    L15:
        e = move-exception;
        Log.e(TAG, "replaceTemplateInfos()... ", e);
        goto L17
    L11:
        r0.put("\"{{ theme }}\"", "\"light\"");
        goto L12
    }
}
