package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.view.menu.ListMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public final class AppCompatDelegateImpl$PanelFeatureState {
    int background;
    View createdPanelView;
    ViewGroup decorView;
    int featureId;
    Bundle frozenActionViewState;
    Bundle frozenMenuState;
    int gravity;
    boolean isHandled;
    boolean isOpen;
    boolean isPrepared;
    ListMenuPresenter listMenuPresenter;
    Context listPresenterContext;
    MenuBuilder menu;
    public boolean qwertyMode;
    boolean refreshDecorView;
    boolean refreshMenuContent;
    View shownPanelView;
    boolean wasLastOpen;
    int windowAnimations;
    int x;
    int y;

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;
        int featureId;
        boolean isOpen;
        Bundle menuState;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState() {
        }

        public static SavedState readFromParcel(Parcel r3, ClassLoader r4) {
            SavedState r0 = new SavedState();
            r0.featureId = r3.readInt();
            boolean r2 = true;
            if (r3.readInt() == 1) goto L6;
            r2 = false;
        L6:
            r0.isOpen = r2;
            if (r2 == false) goto L9;
            r0.menuState = r3.readBundle(r4);
        L9:
            return r0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.featureId);
            r1.writeInt(this.isOpen ? 1 : 0);
            if (this.isOpen == false) goto L6;
            r1.writeBundle(this.menuState);
            return;
        }
    }

    public void applyFrozenState() {
        MenuBuilder r0 = this.menu;
        if (r0 == null) goto L8;
        Bundle r1 = this.frozenMenuState;
        if (r1 == null) goto L9;
        r0.restorePresenterStates(r1);
        this.frozenMenuState = null;
        return;
    L9:
        return;
    }

    public void clearMenuPresenters() {
        MenuBuilder r0 = this.menu;
        if (r0 == null) goto L5;
        r0.removeMenuPresenter(this.listMenuPresenter);
    L5:
        this.listMenuPresenter = null;
    }

    public boolean hasPanelItems() {
        if (this.shownPanelView != null) goto L6;
        return false;
    L6:
        if (this.createdPanelView == null) goto L9;
        return true;
    L9:
        if (this.listMenuPresenter.getAdapter().getCount() <= 0) goto L12;
        return true;
    L12:
        return false;
    }

    public Parcelable onSaveInstanceState() {
        SavedState r0 = new SavedState();
        r0.featureId = this.featureId;
        r0.isOpen = this.isOpen;
        if (this.menu == null) goto L5;
        Bundle r1 = new Bundle();
        r0.menuState = r1;
        this.menu.savePresenterStates(r1);
    L5:
        return r0;
    }

    public AppCompatDelegateImpl$PanelFeatureState(int r1) {
        this.featureId = r1;
        this.refreshDecorView = false;
    }

    public MenuView getListMenuView(MenuPresenter.Callback r4) {
        if (this.menu != null) goto L7;
        return null;
    L7:
        if (this.listMenuPresenter != null) goto L10;
        ListMenuPresenter r0 = new ListMenuPresenter(this.listPresenterContext, 2131558422);
        this.listMenuPresenter = r0;
        r0.setCallback(r4);
        this.menu.addMenuPresenter(this.listMenuPresenter);
    L10:
        return this.listMenuPresenter.getMenuView(this.decorView);
    }

    public void onRestoreInstanceState(Parcelable r2) {
        SavedState r3 = (SavedState) r2;
        this.featureId = r3.featureId;
        this.wasLastOpen = r3.isOpen;
        this.frozenMenuState = r3.menuState;
        this.shownPanelView = null;
        this.decorView = null;
    }

    public void setMenu(MenuBuilder r3) {
        MenuBuilder r0 = this.menu;
        if (r3 != r0) goto L5;
        return;
    L5:
        if (r0 == null) goto L7;
        r0.removeMenuPresenter(this.listMenuPresenter);
    L7:
        this.menu = r3;
        if (r3 != null) goto L10;
        return;
    L10:
        if (this.listMenuPresenter == null) goto L14;
        r3.addMenuPresenter(this.listMenuPresenter);
        return;
    }

    public void setStyle(Context r5) {
        TypedValue r0 = new TypedValue();
        Resources.Theme r1 = r5.getResources().newTheme();
        r1.setTo(r5.getTheme());
        r1.resolveAttribute(2130968712, r0, true);
        int r2 = r0.resourceId;
        if (r2 == 0) goto L5;
        r1.applyStyle(r2, true);
    L5:
        r1.resolveAttribute(2130973435, r0, true);
        int r3 = r0.resourceId;
        if (r3 == 0) goto L8;
        r1.applyStyle(r3, true);
    L9:
        ContextThemeWrapper r4 = new ContextThemeWrapper(r5, 0);
        r4.getTheme().setTo(r1);
        this.listPresenterContext = r4;
        TypedArray r6 = r4.obtainStyledAttributes(new int[]{R.attr.windowIsFloating, R.attr.windowAnimationStyle, 2130968710, 2130968711, 2130968712, 2130968713, 2130968714, 2130968715, 2130968716, 2130968717, 2130968718, 2130968719, 2130968720, 2130968721, 2130968722, 2130968724, 2130968725, 2130968726, 2130968727, 2130968728, 2130968729, 2130968730, 2130968731, 2130968732, 2130968733, 2130968734, 2130968735, 2130968736, 2130968737, 2130968738, 2130968739, 2130968740, 2130968741, 2130968742, 2130968747, 2130968767, 2130968768, 2130968769, 2130968770, 2130968871, 2130969037, 2130969098, 2130969099, 2130969100, 2130969101, 2130969102, 2130969107, 2130969108, 2130969183, 2130969189, 2130969561, 2130969562, 2130969563, 2130969564, 2130969565, 2130969566, 2130969567, 2130969568, 2130969569, 2130969571, 2130969637, 2130969751, 2130969752, 2130969753, 2130969764, 2130969772, 2130969843, 2130969844, 2130969937, 2130969938, 2130969939, 2130970261, 2130970320, 2130972554, 2130972556, 2130972558, 2130972559, 2130972562, 2130972563, 2130972564, 2130972565, 2130972566, 2130972567, 2130972568, 2130972569, 2130972570, 2130973434, 2130973435, 2130973436, 2130973584, 2130973586, 2130973710, 2130973725, 2130973726, 2130973727, 2130973954, 2130973996, 2130974008, 2130974009, 2130974125, 2130974126, 2130974350, 2130974508, 2130974509, 2130974510, 2130974511, 2130974513, 2130974514, 2130974515, 2130974516, 2130974526, 2130974528, 2130974605, 2130974606, 2130974611, 2130974612, 2130975037, 2130975145, 2130975146, 2130975147, 2130975148, 2130975149, 2130975150, 2130975151, 2130975152, 2130975153, 2130975154});
        this.background = r6.getResourceId(86, 0);
        this.windowAnimations = r6.getResourceId(1, 0);
        r6.recycle();
        return;
    L8:
        r1.applyStyle(2131953623, true);
        goto L9
    }
}
