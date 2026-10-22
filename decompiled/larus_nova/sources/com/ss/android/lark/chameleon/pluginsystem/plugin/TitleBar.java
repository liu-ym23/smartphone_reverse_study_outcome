package com.ss.android.lark.chameleon.pluginsystem.plugin;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import com.ss.android.lark.chameleon.widget.titlebar.CommonTitleBar;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public interface TitleBar {

    /* JADX INFO: renamed from: com.ss.android.lark.chameleon.pluginsystem.plugin.TitleBar$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$setLeftClickListener(TitleBar r100, View.OnClickListener r101) {
        }

        public static void $default$setTitleSize(TitleBar r100, int r101) {
        }
    }

    public static final enum MenuType extends Enum<MenuType> {
        private static final /* synthetic */ MenuType[] $VALUES = null;
        public static final MenuType Left = null;
        public static final MenuType Right = null;

        static {
            MenuType r100 = new MenuType("Left", 0);
            Left = r100;
            MenuType r101 = new MenuType("Right", 1);
            Right = r101;
            $VALUES = new MenuType[]{r100, r101};
        }

        public static MenuType[] values() {
            return (MenuType[]) $VALUES.clone();
        }

        public static MenuType valueOf(String r100) {
            return (MenuType) r27.a.a(MenuType.class, r100);
        }

        private MenuType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface OnTitleBarStateChangedListener {
        void onTitleBarStateChanged(DeviceInfo r100);
    }

    public interface SpaceTagInfoChangeListener {
        void onExternalTagChanged(boolean r100);

        void onTemplateTagChanged(boolean r100);
    }

    public static final enum TitleGravity extends Enum<TitleGravity> {
        private static final /* synthetic */ TitleGravity[] $VALUES = null;
        public static final TitleGravity Center = null;
        public static final TitleGravity Left = null;

        static {
            TitleGravity r100 = new TitleGravity("Left", 0);
            Left = r100;
            TitleGravity r101 = new TitleGravity("Center", 1);
            Center = r101;
            $VALUES = new TitleGravity[]{r100, r101};
        }

        public static TitleGravity[] values() {
            return (TitleGravity[]) $VALUES.clone();
        }

        public static TitleGravity valueOf(String r100) {
            return (TitleGravity) r27.a.a(TitleGravity.class, r100);
        }

        private TitleGravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    void addCustomSecondRightView(View r100, ViewGroup.LayoutParams r101);

    void addTitleBarStateChangedListener(OnTitleBarStateChangedListener r100);

    void clearMenus();

    void enableTitleBarAlwaysShowing(boolean r100);

    View findMenuView(String r100);

    DeviceInfo getDeviceInfo();

    List<MenuItem> getMenus(MenuType r100);

    CharSequence getTitle();

    CommonTitleBar getTitleBarLayout();

    void hide(boolean r100);

    void invalidate();

    boolean isLeftIconVisible();

    void removeTitleBarStateChangedListener(OnTitleBarStateChangedListener r100);

    void setBackground(int r100);

    void setDividerVisible(boolean r100);

    void setExternalTagEnabled(boolean r100);

    void setHiddenMenus(List<MenuItem> r100);

    void setLeftClickListener(View.OnClickListener r100);

    void setLeftIconTint(int r100);

    void setLeftIconVisibility(boolean r100);

    void setLeftVisible(boolean r100);

    void setMenuIconTint(int r100);

    void setMenus(List<MenuItem> r100, MenuType r101);

    void setRightVisible(boolean r100);

    void setRiskFlag(boolean r100);

    void setSecondTitle(CharSequence r100);

    void setSecondTitleLeftDrawable(Drawable r100);

    void setSecondTitleVisibility(boolean r100);

    void setSpaceTagTitleBarEnabled(SpaceTagInfoChangeListener r100);

    void setSpaceTagTitleBarEnabled(boolean r100);

    void setStatusBarTransparent(boolean r100);

    void setSubTitle(CharSequence r100);

    void setSubTitleSuffix(CharSequence r100);

    void setTitle(CharSequence r100);

    void setTitleGravity(TitleGravity r100);

    void setTitleSize(int r100);

    void setTitleTextColor(int r100);

    void setTitleVisibility(boolean r100);

    void setTransparent(boolean r100);

    void show(boolean r100);
}
