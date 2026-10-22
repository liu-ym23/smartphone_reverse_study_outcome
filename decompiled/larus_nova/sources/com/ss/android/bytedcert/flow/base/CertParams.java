package com.ss.android.bytedcert.flow.base;

import android.content.Context;
import com.ss.android.bytedcert.config.ThemeConfig;
import com.ss.android.bytedcert.flow.base.CertParams.Builder;
import com.ss.android.cert.manager.ablity.ICertDialogDepend;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public abstract class CertParams<B extends Builder<?>> {
    private final ICertDialogDepend certDialogDepend;
    private final Map<String, String> certInfo;
    private final Context context;
    private final String language;
    private final boolean showLoading;
    private final ThemeConfig themeConfig;

    public static abstract class Builder<B extends Builder<?>> {
        ICertDialogDepend certDialogDepend;
        Map<String, String> certInfo;
        Context context;
        String language;
        boolean showLoading;
        ThemeConfig themeConfig;

        public Builder(Context r100) {
            this.showLoading = true;
            this.context = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setCertDialogDepend(ICertDialogDepend r100) {
            this.certDialogDepend = r100;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setCertInfo(Map<String, String> r100) {
            Map<String, String> r101 = this.certInfo;
            if (r101 != null) goto L5;
            this.certInfo = r100;
        L7:
            return this;
        L5:
            if (r100 == null) goto L7;
            r101.putAll(r100);
            goto L7
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setLanguage(String r100) {
            this.language = r100;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setShowLoading(boolean r100) {
            this.showLoading = r100;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setThemeConfig(ThemeConfig r100) {
            this.themeConfig = r100;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public B setCertInfo(String r100, String r101) {
            if (this.certInfo != null) goto L5;
            this.certInfo = new HashMap();
        L5:
            this.certInfo.put(r100, r101);
            return this;
        }
    }

    public ICertDialogDepend getCertDialogDepend() {
        return this.certDialogDepend;
    }

    public Map<String, String> getCertInfo() {
        return this.certInfo;
    }

    public Context getContext() {
        return this.context;
    }

    public String getLanguage() {
        return this.language;
    }

    public ThemeConfig getThemeConfig() {
        return this.themeConfig;
    }

    public boolean isShowLoading() {
        return this.showLoading;
    }

    public CertParams(B r100) {
        this.context = r100.context;
        this.certInfo = r100.certInfo;
        this.themeConfig = r100.themeConfig;
        this.certDialogDepend = r100.certDialogDepend;
        this.showLoading = r100.showLoading;
        this.language = r100.language;
    }
}
