package com.bytedance.ee.bear.browser.plugin;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public interface TitleBar {

    public static final enum MenuType extends Enum<MenuType> {
        public static final MenuType Left = null;
        public static final MenuType Right = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ MenuType[] f216611a = null;

        static {
            MenuType r100 = new MenuType("Left", 0);
            Left = r100;
            MenuType r101 = new MenuType("Right", 1);
            Right = r101;
            f216611a = new MenuType[]{r100, r101};
        }

        public static MenuType[] values() {
            return (MenuType[]) f216611a.clone();
        }

        public static MenuType valueOf(String r100) {
            return (MenuType) r27.a.a(MenuType.class, r100);
        }

        public MenuType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum TitleGravity extends Enum<TitleGravity> {
        public static final TitleGravity Center = null;
        public static final TitleGravity Left = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TitleGravity[] f216612a = null;

        static {
            TitleGravity r100 = new TitleGravity("Left", 0);
            Left = r100;
            TitleGravity r101 = new TitleGravity("Center", 1);
            Center = r101;
            f216612a = new TitleGravity[]{r100, r101};
        }

        public static TitleGravity[] values() {
            return (TitleGravity[]) f216612a.clone();
        }

        public static TitleGravity valueOf(String r100) {
            return (TitleGravity) r27.a.a(TitleGravity.class, r100);
        }

        public TitleGravity(String r100, int r101) {
            super(r100, r101);
        }
    }

    public interface a {
        void onTitleBarStateChanged(d r100);
    }

    public interface b {
        void onExternalTagChanged(boolean r100);

        void onTemplateTagChanged(boolean r100);
    }

    View a();

    void b(TitleGravity r100);

    void c(a r100);

    void clearMenus();

    void d();

    boolean e(String r100, Drawable r101);

    void enableTitleBarAlwaysShowing(boolean r100);

    void f();

    View findMenuView(String r100);

    void g(a r100);

    d getDeviceInfo();

    BaseTitleBar getTitleBarLayout();

    void h();

    void hide(boolean r100);

    List<MenuItem> i(MenuType r100);

    void invalidate();

    boolean isLeftIconVisible();

    void j(List<MenuItem> r100, MenuType r101);

    void k(b r100);

    void setBackground(int r100);

    void setHiddenMenus(List<MenuItem> r100);

    void setLeftClickListener(View.OnClickListener r100);

    void setLeftIconVisibility(boolean r100);

    void setLeftVisible(boolean r100);

    void setMenuIconTint(int r100);

    void setRightVisible(boolean r100);

    void setRiskFlag(boolean r100);

    void setSubTitle(CharSequence r100);

    void setTitle(CharSequence r100);

    void setTitleSize(int r100);

    void setTitleVisibility(boolean r100);

    void setTransparent(boolean r100);

    void show(boolean r100);
}
