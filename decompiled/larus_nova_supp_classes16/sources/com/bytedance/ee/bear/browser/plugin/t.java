package com.bytedance.ee.bear.browser.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface t {

    public interface a {
    }

    void a();

    View b(f r1, int r2);

    ViewGroup c(f r1);

    void d(f r1);

    void disablePluginsFitSystemWindow();

    void e(f r1, Fragment r2, s r3);

    boolean f(f r1);

    View findView(int r1);

    View findView(Object r1);

    void g(TitleBar r1);

    View getContentView();

    Context getContext();

    FragmentManager getFragmentManager();

    a getLayoutStrategy();

    TitleBar getTitleBar();

    void h(f r1, View r2);

    void hideStatusBar();

    void i(f r1, Fragment r2);

    void j(u r1);

    void k(c r1);

    Fragment l(f r1);

    void m(f r1, View r2);

    u saveUIState();
}
