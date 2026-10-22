package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.Window;
import androidx.appcompat.view.menu.MenuPresenter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface DecorContentParent {
    boolean canShowOverflowMenu();

    void dismissPopups();

    CharSequence getTitle();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initFeature(int r1);

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    void restoreToolbarHierarchyState(SparseArray<Parcelable> r1);

    void saveToolbarHierarchyState(SparseArray<Parcelable> r1);

    void setIcon(int r1);

    void setIcon(Drawable r1);

    void setLogo(int r1);

    void setMenu(Menu r1, MenuPresenter.Callback r2);

    void setMenuPrepared();

    void setUiOptions(int r1);

    void setWindowCallback(Window.Callback r1);

    void setWindowTitle(CharSequence r1);

    boolean showOverflowMenu();
}
