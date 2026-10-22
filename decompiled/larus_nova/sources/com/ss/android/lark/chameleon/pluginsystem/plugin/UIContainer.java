package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes35.dex */
public interface UIContainer {

    public interface LayoutStrategy {
        ViewGroup getAllPluginsContainer();

        ViewGroup getPluginContainer(UIContainer r100, Plugin r101);

        void restoreUIState(UIState r100);

        UIState saveUIState();

        void updateLayoutStrategy(PluginList r100);
    }

    void addOrReplaceFragment(Plugin r100, Fragment r101);

    void addOrReplaceFragment(Plugin r100, Fragment r101, TransactionParams r102);

    View addView(Plugin r100, int r101);

    void addView(Plugin r100, View r101);

    void disablePluginsFitSystemWindow();

    Fragment findFragment(Plugin r100);

    View findView(int r100);

    View findView(Object r100);

    View getContentView();

    Context getContext();

    FragmentManager getFragmentManager();

    LayoutStrategy getLayoutStrategy();

    ViewGroup getPluginContainer(Plugin r100);

    TitleBar getTitleBar();

    void hideStatusBar();

    boolean isRemovingOrNotExistFragment(Plugin r100);

    void removeFragment(Plugin r100);

    void removeView(Plugin r100, View r101);

    void restoreUIState(UIState r100);

    UIState saveUIState();

    void setLayoutStrategy(LayoutStrategy r100);

    void setTitleBar(TitleBar r100);

    void showStatusBar();
}
