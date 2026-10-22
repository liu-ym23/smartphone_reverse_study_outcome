package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.SpinnerAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.ViewPropertyAnimatorCompat;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public interface DecorToolbar {
    void animateToVisibility(int r1);

    boolean canShowOverflowMenu();

    void collapseActionView();

    void dismissPopupMenus();

    Context getContext();

    View getCustomView();

    int getDisplayOptions();

    int getDropdownItemCount();

    int getDropdownSelectedPosition();

    int getHeight();

    Menu getMenu();

    int getNavigationMode();

    CharSequence getSubtitle();

    CharSequence getTitle();

    ViewGroup getViewGroup();

    int getVisibility();

    boolean hasEmbeddedTabs();

    boolean hasExpandedActionView();

    boolean hasIcon();

    boolean hasLogo();

    boolean hideOverflowMenu();

    void initIndeterminateProgress();

    void initProgress();

    boolean isOverflowMenuShowPending();

    boolean isOverflowMenuShowing();

    boolean isTitleTruncated();

    void restoreHierarchyState(SparseArray<Parcelable> r1);

    void saveHierarchyState(SparseArray<Parcelable> r1);

    void setBackgroundDrawable(Drawable r1);

    void setCollapsible(boolean r1);

    void setCustomView(View r1);

    void setDefaultNavigationContentDescription(int r1);

    void setDefaultNavigationIcon(Drawable r1);

    void setDisplayOptions(int r1);

    void setDropdownParams(SpinnerAdapter r1, AdapterView.OnItemSelectedListener r2);

    void setDropdownSelectedPosition(int r1);

    void setEmbeddedTabView(ScrollingTabContainerView r1);

    void setHomeButtonEnabled(boolean r1);

    void setIcon(int r1);

    void setIcon(Drawable r1);

    void setLogo(int r1);

    void setLogo(Drawable r1);

    void setMenu(Menu r1, MenuPresenter.Callback r2);

    void setMenuCallbacks(MenuPresenter.Callback r1, MenuBuilder.Callback r2);

    void setMenuPrepared();

    void setNavigationContentDescription(int r1);

    void setNavigationContentDescription(CharSequence r1);

    void setNavigationIcon(int r1);

    void setNavigationIcon(Drawable r1);

    void setNavigationMode(int r1);

    void setSubtitle(CharSequence r1);

    void setTitle(CharSequence r1);

    void setVisibility(int r1);

    void setWindowCallback(Window.Callback r1);

    void setWindowTitle(CharSequence r1);

    ViewPropertyAnimatorCompat setupAnimatorToVisibility(int r1, long r2);

    boolean showOverflowMenu();
}
