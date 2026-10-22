package com.bytedance.ee.bear.docshost;

import com.bytedance.ee.util.io.NonProguard;
import com.ss.android.lark.appsetting.annotation.AppConfig;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@AppConfig(key = DocxUrlUnAddSchemeListConfig.GET_APP_SCHEME_KEY)
public class DocxUrlUnAddSchemeListConfig implements NonProguard {
    public static final String GET_APP_SCHEME_KEY = "ccm_docx_open_external_link_is_app_scheme";
    public ArrayList<String> unAddSchemeList;

    public DocxUrlUnAddSchemeListConfig() {
    }
}
