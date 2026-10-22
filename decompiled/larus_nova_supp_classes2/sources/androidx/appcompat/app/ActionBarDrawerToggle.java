package androidx.appcompat.app;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.Toolbar;
import androidx.compose.material3.MenuKt;
import androidx.drawerlayout.widget.DrawerLayout;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class ActionBarDrawerToggle implements DrawerLayout.DrawerListener {
    private final Delegate mActivityImpl;
    private final int mCloseDrawerContentDescRes;
    boolean mDrawerIndicatorEnabled;
    private final DrawerLayout mDrawerLayout;
    private boolean mDrawerSlideAnimationEnabled;
    private boolean mHasCustomUpIndicator;
    private Drawable mHomeAsUpIndicator;
    private final int mOpenDrawerContentDescRes;
    private DrawerArrowDrawable mSlider;
    View.OnClickListener mToolbarNavigationClickListener;
    private boolean mWarnedForDisplayHomeAsUp;

    public interface Delegate {
        Context getActionBarThemedContext();

        Drawable getThemeUpIndicator();

        boolean isNavigationVisible();

        void setActionBarDescription(int r1);

        void setActionBarUpIndicator(Drawable r1, int r2);
    }

    public static class FrameworkActionBarDelegate implements Delegate {
        private final Activity mActivity;
        private ActionBarDrawerToggleHoneycomb.SetIndicatorInfo mSetIndicatorInfo;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 == null) goto L7;
            return r0.getThemedContext();
        L7:
            return this.mActivity;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 != null) goto L5;
        L7:
            return false;
        L5:
            if ((r0.getDisplayOptions() & 4) == 0) goto L7;
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            TypedArray r0 = getActionBarThemedContext().obtainStyledAttributes(null, new int[]{R.attr.homeAsUpIndicator}, R.attr.actionBarStyle, 0);
            Drawable r1 = r0.getDrawable(0);
            r0.recycle();
            return r1;
        }

        public FrameworkActionBarDelegate(Activity r1) {
            this.mActivity = r1;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r2) {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 == null) goto L6;
            r0.setHomeActionContentDescription(r2);
            return;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r2, int r3) {
            android.app.ActionBar r0 = this.mActivity.getActionBar();
            if (r0 == null) goto L6;
            r0.setHomeAsUpIndicator(r2);
            r0.setHomeActionContentDescription(r3);
            return;
        }
    }

    public static class ToolbarCompatDelegate implements Delegate {
        final CharSequence mDefaultContentDescription;
        final Drawable mDefaultUpIndicator;
        final Toolbar mToolbar;

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public boolean isNavigationVisible() {
            return true;
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Context getActionBarThemedContext() {
            return this.mToolbar.getContext();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public Drawable getThemeUpIndicator() {
            return this.mDefaultUpIndicator;
        }

        public ToolbarCompatDelegate(Toolbar r2) {
            this.mToolbar = r2;
            this.mDefaultUpIndicator = r2.getNavigationIcon();
            this.mDefaultContentDescription = r2.getNavigationContentDescription();
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarDescription(int r2) {
            if (r2 != 0) goto L4;
            this.mToolbar.setNavigationContentDescription(this.mDefaultContentDescription);
            return;
        L4:
            this.mToolbar.setNavigationContentDescription(r2);
        }

        @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
        public void setActionBarUpIndicator(Drawable r2, int r3) {
            this.mToolbar.setNavigationIcon(r2);
            setActionBarDescription(r3);
        }
    }

    public void onDrawerStateChanged(int r1) {
    }

    public Drawable getThemeUpIndicator() {
        return this.mActivityImpl.getThemeUpIndicator();
    }

    public void syncState() {
        if (this.mDrawerLayout.isDrawerOpen(8388611) == false) goto L5;
        setPosition(1.0f);
    L7:
        if (this.mDrawerIndicatorEnabled == false) goto L14;
        DrawerArrowDrawable r0 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(8388611) == false) goto L11;
        int r1 = this.mCloseDrawerContentDescRes;
    L12:
        setActionBarUpIndicator(r0, r1);
        return;
    L11:
        r1 = this.mOpenDrawerContentDescRes;
        goto L12
    L14:
        return;
    L5:
        setPosition(MenuKt.ClosedAlphaTarget);
        goto L7
    }

    public void toggle() {
        int r0 = this.mDrawerLayout.getDrawerLockMode(8388611);
        if (this.mDrawerLayout.isDrawerVisible(8388611) == false) goto L8;
        if (r0 == 2) goto L8;
        this.mDrawerLayout.closeDrawer(8388611);
        return;
    L8:
        if (r0 == 1) goto L12;
        this.mDrawerLayout.openDrawer(8388611);
        return;
    }

    public DrawerArrowDrawable getDrawerArrowDrawable() {
        return this.mSlider;
    }

    public View.OnClickListener getToolbarNavigationClickListener() {
        return this.mToolbarNavigationClickListener;
    }

    public boolean isDrawerIndicatorEnabled() {
        return this.mDrawerIndicatorEnabled;
    }

    public boolean isDrawerSlideAnimationEnabled() {
        return this.mDrawerSlideAnimationEnabled;
    }

    private void setPosition(float r3) {
        if (r3 != 1.0f) goto L6;
        this.mSlider.setVerticalMirror(true);
    L8:
        this.mSlider.setProgress(r3);
        return;
    L6:
        if (r3 != MenuKt.ClosedAlphaTarget) goto L8;
        this.mSlider.setVerticalMirror(false);
        goto L8
    }

    public void onConfigurationChanged(Configuration r1) {
        if (this.mHasCustomUpIndicator == true) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
    L5:
        syncState();
    }

    public void onDrawerClosed(View r1) {
        setPosition(MenuKt.ClosedAlphaTarget);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mOpenDrawerContentDescRes);
        return;
    }

    public void onDrawerOpened(View r1) {
        setPosition(1.0f);
        if (this.mDrawerIndicatorEnabled == false) goto L6;
        setActionBarDescription(this.mCloseDrawerContentDescRes);
        return;
    }

    public boolean onOptionsItemSelected(MenuItem r2) {
        if (r2 != null) goto L4;
        return false;
    L4:
        if (r2.getItemId() == 16908332) goto L6;
        return false;
    L6:
        if (this.mDrawerIndicatorEnabled == false) goto L12;
        toggle();
        return true;
    L12:
        return false;
    }

    public void setActionBarDescription(int r2) {
        this.mActivityImpl.setActionBarDescription(r2);
    }

    public void setDrawerArrowDrawable(DrawerArrowDrawable r1) {
        this.mSlider = r1;
        syncState();
    }

    public void setDrawerIndicatorEnabled(boolean r4) {
        if (r4 == this.mDrawerIndicatorEnabled) goto L13;
        if (r4 == false) goto L10;
        DrawerArrowDrawable r0 = this.mSlider;
        if (this.mDrawerLayout.isDrawerOpen(8388611) == false) goto L8;
        int r1 = this.mCloseDrawerContentDescRes;
    L9:
        setActionBarUpIndicator(r0, r1);
    L11:
        this.mDrawerIndicatorEnabled = r4;
        return;
    L8:
        r1 = this.mOpenDrawerContentDescRes;
        goto L9
    L10:
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        goto L11
    }

    public void setDrawerSlideAnimationEnabled(boolean r1) {
        this.mDrawerSlideAnimationEnabled = r1;
        if (r1 == true) goto L6;
        setPosition(MenuKt.ClosedAlphaTarget);
        return;
    }

    public void setHomeAsUpIndicator(Drawable r2) {
        if (r2 != null) goto L5;
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        this.mHasCustomUpIndicator = false;
    L7:
        if (this.mDrawerIndicatorEnabled == true) goto L10;
        setActionBarUpIndicator(this.mHomeAsUpIndicator, 0);
        return;
    L10:
        return;
    L5:
        this.mHomeAsUpIndicator = r2;
        this.mHasCustomUpIndicator = true;
        goto L7
    }

    public void setToolbarNavigationClickListener(View.OnClickListener r1) {
        this.mToolbarNavigationClickListener = r1;
    }

    public void setHomeAsUpIndicator(int r2) {
        if (r2 == 0) goto L4;
        Drawable r3 = this.mDrawerLayout.getResources().getDrawable(r2);
    L5:
        setHomeAsUpIndicator(r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void onDrawerSlide(View r2, float r3) {
        if (this.mDrawerSlideAnimationEnabled == false) goto L5;
        setPosition(Math.min(1.0f, Math.max(MenuKt.ClosedAlphaTarget, r3)));
        return;
    L5:
        setPosition(MenuKt.ClosedAlphaTarget);
    }

    public void setActionBarUpIndicator(Drawable r2, int r3) {
        if (this.mWarnedForDisplayHomeAsUp == false) goto L5;
    L7:
        this.mActivityImpl.setActionBarUpIndicator(r2, r3);
        return;
    L5:
        if (this.mActivityImpl.isNavigationVisible() == true) goto L7;
        this.mWarnedForDisplayHomeAsUp = true;
        goto L7
    }

    public ActionBarDrawerToggle(Activity r8, DrawerLayout r9, int r10, int r11) {
        this(r8, null, r9, null, r10, r11);
    }

    public ActionBarDrawerToggle(Activity r8, DrawerLayout r9, Toolbar r10, int r11, int r12) {
        this(r8, r10, r9, null, r11, r12);
    }

    public ActionBarDrawerToggle(Activity r2, Toolbar r3, DrawerLayout r4, DrawerArrowDrawable r5, int r6, int r7) {
        this.mDrawerSlideAnimationEnabled = true;
        this.mDrawerIndicatorEnabled = true;
        this.mWarnedForDisplayHomeAsUp = false;
        if (r3 == null) goto L6;
        this.mActivityImpl = new ToolbarCompatDelegate(r3);
        r3.setNavigationOnClickListener(new AnonymousClass1(this));
    L9:
        this.mDrawerLayout = r4;
        this.mOpenDrawerContentDescRes = r6;
        this.mCloseDrawerContentDescRes = r7;
        if (r5 != null) goto L12;
        this.mSlider = new DrawerArrowDrawable(this.mActivityImpl.getActionBarThemedContext());
    L13:
        this.mHomeAsUpIndicator = getThemeUpIndicator();
        return;
    L12:
        this.mSlider = r5;
        goto L13
    L6:
        if ((r2 instanceof DelegateProvider) == false) goto L8;
        this.mActivityImpl = ((DelegateProvider) r2).getDrawerToggleDelegate();
        goto L9
    L8:
        this.mActivityImpl = new FrameworkActionBarDelegate(r2);
        goto L9
    }
}
