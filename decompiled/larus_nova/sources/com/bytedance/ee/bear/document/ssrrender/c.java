package com.bytedance.ee.bear.document.ssrrender;

/* JADX INFO: loaded from: classes16.dex */
public final class c extends iua.a<Boolean> {

    public static final class a {
    }

    static {
    }

    @Override // iua.a
    public final boolean isSticky() {
        return true;
    }

    @Override // iua.a
    public final iua.b getLarkExperimentInfo() {
        return new iua.b("docs_android_render_ssr_in_ssr_webview", "render ssr in ssr webview");
    }

    public c() {
    }

    @Override // iua.a
    public final Boolean getDefault() {
        return Boolean.FALSE;
    }
}
