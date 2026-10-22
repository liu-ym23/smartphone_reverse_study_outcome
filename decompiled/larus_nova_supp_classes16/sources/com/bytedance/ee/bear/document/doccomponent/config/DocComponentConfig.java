package com.bytedance.ee.bear.document.doccomponent.config;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.doccomponent.impl.DoComponentConfigVM;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import qz4.c;
import s05.e;
import tt5.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = DocComponentConfig.KEY)
public class DocComponentConfig extends JSONObject implements NonProguard {
    public static final String KEY = "doc_component_config_mobile_all";
    public static final String KEY_INJECT_WEB = "docComponentConfig";
    public static final String KEY_INJECT_WEB_PATCH = "injectDocComponentConfig";
    private static final String SUB_SCENE_KEY_PREFIX = "doc_component_config_";
    private static final String TAG = "DocComponentConfig";

    public DocComponentConfig() {
    }

    public static JSONObject getPatchSettingConfig(WeakReference<Fragment> r5) {
        if (r5 != null) goto L6;
        a.d(TAG, "updateSettingConfig fragmentRef is null");
        return null;
    L6:
        Fragment r6 = r5.get();
        if (r6 != null) goto L25;
        a.d(TAG, "updateSettingConfig fragment is null");
        return null;
    L25:
        HashMap r3 = (HashMap) ((DoComponentConfigVM) new ViewModelProvider(r6).get(DoComponentConfigVM.class)).getLivePatchDocComponentConfig().getValue();     // Catch: Throwable -> L15
        if (r3 == null) goto L27;
        a.h(TAG, "updateSettingConfig use getLivePatchDocComponentConfig data");     // Catch: Throwable -> L15
        return JSON.parseObject(JSON.toJSONString(r3));
    L27:
        c r7 = e.a(r6);     // Catch: Throwable -> L21
        if (r7 == null) goto L23;
        a.h(TAG, "updateSettingConfig use DocComponentHost data");     // Catch: Throwable -> L21
        return JSON.parseObject(JSON.toJSONString(r7.a()));
    L23:
        a.h(TAG, "updateSettingConfig get null result");
        return null;
    L21:
        th = move-exception;
        a.f(TAG, th, false);
    L15:
        th = move-exception;
        a.f(TAG, th, false);
        goto L27
    }

    public static JSONObject getSceneConfig(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L7;
        return null;
    L7:
        return com.bytedance.ee.bear.appsetting.c.a.a.c(KEY, DocComponentConfig.class, new DocComponentConfig()).getJSONObject(SUB_SCENE_KEY_PREFIX + r4);
    }

    public static boolean isDocComponent(BearUrl r1) {
        if (r1 != null) goto L5;
        String r2 = null;
    L9:
        return !TextUtils.isEmpty(r2);
    L5:
        if (TextUtils.isEmpty(r1.r) == true) goto L7;
        r2 = r1.r;
        goto L9
    L7:
        r2 = r1.q;
        goto L9
    }
}
