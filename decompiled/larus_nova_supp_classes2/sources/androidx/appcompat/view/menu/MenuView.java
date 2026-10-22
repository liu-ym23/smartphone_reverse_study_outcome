package androidx.appcompat.view.menu;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface MenuView {

    public interface ItemView {
        MenuItemImpl getItemData();

        void initialize(MenuItemImpl r1, int r2);

        boolean prefersCondensedTitle();

        void setCheckable(boolean r1);

        void setChecked(boolean r1);

        void setEnabled(boolean r1);

        void setIcon(Drawable r1);

        void setShortcut(boolean r1, char r2);

        void setTitle(CharSequence r1);

        boolean showsIcon();
    }

    int getWindowAnimations();

    void initialize(MenuBuilder r1);
}
