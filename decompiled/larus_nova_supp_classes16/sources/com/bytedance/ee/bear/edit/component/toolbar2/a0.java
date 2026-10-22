package com.bytedance.ee.bear.edit.component.toolbar2;

import com.bytedance.ee.bear.browser.plugin.PluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface a0 {

    public interface a {
        boolean a();

        boolean b();

        void c();

        boolean d();

        void e();

        void hideAllToolbar();
    }

    public interface b {
        boolean f9();
    }

    void attach(PluginHost r1, a r2);

    void detach(PluginHost r1);

    void forceClearToolbar();

    boolean hasShowingPanel();

    void hideAllToolbar();

    boolean isShowingFunctionPanel();

    boolean onKeyboardToolbarItemClick();

    void onToolbarChanged();

    void onToolbarItemClick(String r1);
}
