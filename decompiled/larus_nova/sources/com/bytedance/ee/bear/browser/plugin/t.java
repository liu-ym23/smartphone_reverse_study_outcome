package com.bytedance.ee.bear.browser.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes16.dex */
public interface t {

    public interface a {
    }

    void a();

    View b(f r100, int r101);

    ViewGroup c(f r100);

    void d(f r100);

    void disablePluginsFitSystemWindow();

    void e(f r100, Fragment r101, s r102);

    boolean f(f r100);

    View findView(int r100);

    View findView(Object r100);

    void g(TitleBar r100);

    View getContentView();

    Context getContext();

    FragmentManager getFragmentManager();

    a getLayoutStrategy();

    TitleBar getTitleBar();

    void h(f r100, View r101);

    void hideStatusBar();

    void i(f r100, Fragment r101);

    void j(u r100);

    void k(c r100);

    Fragment l(f r100);

    void m(f r100, View r101);

    u saveUIState();
}
