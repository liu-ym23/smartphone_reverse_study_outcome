package com.bytedance.ee.bear.browser.plugin;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface TitleBar {

    public static final enum MenuType extends Enum<MenuType> {
        public static final MenuType Left = null;
        public static final MenuType Right = null;
        public static final /* synthetic */ MenuType[] a = null;

        static {
            MenuType r0 = new MenuType("Left", 0);
            Left = r0;
            MenuType r1 = new MenuType("Right", 1);
            Right = r1;
            a = new MenuType[]{r0, r1};
        }

        public static MenuType[] values() {
            return (MenuType[]) a.clone();
        }

        public static MenuType valueOf(String r1) {
            return (MenuType) r27.a.a(MenuType.class, r1);
        }

        public MenuType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final enum TitleGravity extends Enum<TitleGravity> {
        public static final TitleGravity Center = null;
        public static final TitleGravity Left = null;
        public static final /* synthetic */ TitleGravity[] a = null;

        static {
            TitleGravity r0 = new TitleGravity("Left", 0);
            Left = r0;
            TitleGravity r1 = new TitleGravity("Center", 1);
            Center = r1;
            a = new TitleGravity[]{r0, r1};
        }

        public static TitleGravity[] values() {
            return (TitleGravity[]) a.clone();
        }

        public static TitleGravity valueOf(String r1) {
            return (TitleGravity) r27.a.a(TitleGravity.class, r1);
        }

        public TitleGravity(String r1, int r2) {
            super(r1, r2);
        }
    }

    public interface a {
        void onTitleBarStateChanged(d r1);
    }

    public interface b {
        void onExternalTagChanged(boolean r1);

        void onTemplateTagChanged(boolean r1);
    }

    View a();

    void b(TitleGravity r1);

    void c(a r1);

    void clearMenus();

    void d();

    boolean e(String r1, Drawable r2);

    void enableTitleBarAlwaysShowing(boolean r1);

    void f();

    View findMenuView(String r1);

    void g(a r1);

    d getDeviceInfo();

    BaseTitleBar getTitleBarLayout();

    void h();

    void hide(boolean r1);

    List<MenuItem> i(MenuType r1);

    void invalidate();

    boolean isLeftIconVisible();

    void j(List<MenuItem> r1, MenuType r2);

    void k(b r1);

    void setBackground(int r1);

    void setHiddenMenus(List<MenuItem> r1);

    void setLeftClickListener(View.OnClickListener r1);

    void setLeftIconVisibility(boolean r1);

    void setLeftVisible(boolean r1);

    void setMenuIconTint(int r1);

    void setRightVisible(boolean r1);

    void setRiskFlag(boolean r1);

    void setSubTitle(CharSequence r1);

    void setTitle(CharSequence r1);

    void setTitleSize(int r1);

    void setTitleVisibility(boolean r1);

    void setTransparent(boolean r1);

    void show(boolean r1);
}
