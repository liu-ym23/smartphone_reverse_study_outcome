package qn6;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.platform.api.creation.TplType;
import java.util.Iterator;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements Window.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Window.Callback f534101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f534102b;

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.f534101a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        this.f534101a.onContentChanged();
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.f534101a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.f534101a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent r100) {
        return this.f534101a.dispatchGenericMotionEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent r100) {
        return this.f534101a.dispatchKeyEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyShortcutEvent(KeyEvent r100) {
        return this.f534101a.dispatchKeyShortcutEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent r100) {
        return this.f534101a.dispatchPopulateAccessibilityEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        c r101 = this.f534102b;
        if (r101.f534107e == true) goto L9;
        IntRange r102 = ArraysKt.getIndices(r101.f534106d);
        c r103 = this.f534102b;
        Iterator<Integer> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L8;
        int r105 = ((IntIterator) r104).nextInt();
        ((View) ListProtector.get(r103.f534104b, r105)).getGlobalVisibleRect(r103.f534106d[r105]);
        goto L6
    L8:
        this.f534102b.f534107e = true;
    L9:
        if (r100 == null) goto L23;
        c r106 = this.f534102b;
        int r107 = r106.f534106d.length;
        int r108 = 0;
    L11:
        if (r108 >= r107) goto L23;
        Rect r109 = r106.f534106d[r108];
        if (r100.getRawX() > r109.right) goto L21;
        if (r100.getRawX() < r109.left) goto L21;
        if (r100.getRawY() < r109.top) goto L21;
        if (r100.getRawY() > r109.bottom) goto L21;
        r106.f534105c.c(r106.f534103a, r100);
    L21:
        r108 = r108 + 1;
    L23:
        return this.f534101a.dispatchTouchEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent r100) {
        return this.f534101a.dispatchTrackballEvent(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode r100) {
        this.f534101a.onActionModeFinished(r100);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode r100) {
        this.f534101a.onActionModeStarted(r100);
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int r100) {
        return this.f534101a.onCreatePanelView(r100);
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent r100) {
        return this.f534101a.onSearchRequested(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams r100) {
        this.f534101a.onWindowAttributesChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean r100) {
        this.f534101a.onWindowFocusChanged(r100);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100) {
        return this.f534101a.onWindowStartingActionMode(r100);
    }

    public b(Window.Callback r100, c r101) {
        this.f534101a = r100;
        this.f534102b = r101;
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        return this.f534101a.onCreatePanelMenu(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int r100, MenuItem r101) {
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        return this.f534101a.onMenuItemSelected(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        return this.f534101a.onMenuOpened(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        this.f534101a.onPanelClosed(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback r100, int r101) {
        return this.f534101a.onWindowStartingActionMode(r100, r101);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int r100, View r101, Menu r102) {
        Intrinsics.checkNotNullParameter(r102, TplType.MENU);
        return this.f534101a.onPreparePanel(r100, r101, r102);
    }
}
