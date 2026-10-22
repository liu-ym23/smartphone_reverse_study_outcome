package androidx.appcompat.app;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.TintTypedArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class AppCompatDelegateImpl$ActionBarDrawableToggleImpl implements ActionBarDrawerToggle.Delegate {
    final /* synthetic */ AppCompatDelegateImpl this$0;

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public Context getActionBarThemedContext() {
        return this.this$0.getActionBarThemedContext();
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public boolean isNavigationVisible() {
        ActionBar r0 = this.this$0.getSupportActionBar();
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if ((r0.getDisplayOptions() & 4) == 0) goto L7;
        return true;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public Drawable getThemeUpIndicator() {
        TintTypedArray r0 = TintTypedArray.obtainStyledAttributes(getActionBarThemedContext(), null, new int[]{2130970261});
        Drawable r1 = r0.getDrawable(0);
        r0.recycle();
        return r1;
    }

    public AppCompatDelegateImpl$ActionBarDrawableToggleImpl(AppCompatDelegateImpl r1) {
        this.this$0 = r1;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public void setActionBarDescription(int r2) {
        ActionBar r0 = this.this$0.getSupportActionBar();
        if (r0 == null) goto L6;
        r0.setHomeActionContentDescription(r2);
        return;
    }

    @Override // androidx.appcompat.app.ActionBarDrawerToggle.Delegate
    public void setActionBarUpIndicator(Drawable r2, int r3) {
        ActionBar r0 = this.this$0.getSupportActionBar();
        if (r0 == null) goto L6;
        r0.setHomeAsUpIndicator(r2);
        r0.setHomeActionContentDescription(r3);
        return;
    }
}
