package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.transition.Transition;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.appcompat.view.menu.MenuAdapter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.internal.view.SupportMenuItem;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class MenuPopupWindow extends ListPopupWindow implements MenuItemHoverListener {
    private static final String TAG = "MenuPopupWindow";
    private static Method sSetTouchModalMethod;
    private MenuItemHoverListener mHoverListener;

    public static class MenuDropDownListView extends DropDownListView {
        final int mAdvanceKey;
        private MenuItemHoverListener mHoverListener;
        private MenuItem mHoveredMenuItem;
        final int mRetreatKey;

        public void clearSelection() {
            setSelection(-1);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.ViewGroup, android.view.View
        public /* bridge */ /* synthetic */ boolean hasFocus() {
            return super.hasFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean hasWindowFocus() {
            return super.hasWindowFocus();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isFocused() {
            return super.isFocused();
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public /* bridge */ /* synthetic */ boolean isInTouchMode() {
            return super.isInTouchMode();
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.appcompat.widget.DropDownListView, android.view.View
        public boolean onHoverEvent(MotionEvent r5) {
            if (this.mHoverListener == null) goto L27;
            ListAdapter r0 = getAdapter();
            if ((r0 instanceof HeaderViewListAdapter) == false) goto L7;
            HeaderViewListAdapter r1 = (HeaderViewListAdapter) r0;
            int r2 = r1.getHeadersCount();
            MenuAdapter r3 = (MenuAdapter) r1.getWrappedAdapter();
        L9:
            if (r5.getAction() == 10) goto L17;
            int r4 = pointToPosition((int) r5.getX(), (int) r5.getY());
            if (r4 == (-1)) goto L17;
            int r6 = r4 - r2;
            if (r6 < 0) goto L17;
            if (r6 >= r3.getCount()) goto L17;
            SupportMenuItem r7 = r3.getItem(r6);
        L18:
            SupportMenuItem r8 = this.mHoveredMenuItem;
            if (r8 == r7) goto L27;
            MenuBuilder r9 = r3.getAdapterMenu();
            if (r8 == null) goto L23;
            this.mHoverListener.onItemHoverExit(r9, r8);
        L23:
            this.mHoveredMenuItem = r7;
            if (r7 == null) goto L27;
            this.mHoverListener.onItemHoverEnter(r9, r7);
        L17:
            r7 = null;
            goto L18
        L7:
            r3 = (MenuAdapter) r0;
            r2 = 0;
        L27:
            return super.onHoverEvent(r5);
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView, android.view.View
        public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent r1) {
            return super.onTouchEvent(r1);
        }

        public void setHoverListener(MenuItemHoverListener r1) {
            this.mHoverListener = r1;
        }

        @Override // androidx.appcompat.widget.DropDownListView, android.widget.AbsListView
        public /* bridge */ /* synthetic */ void setSelector(Drawable r1) {
            super.setSelector(r1);
        }

        public MenuDropDownListView(Context r3, boolean r4) {
            super(r3, r4);
            if (1 != r3.getResources().getConfiguration().getLayoutDirection()) goto L5;
            this.mAdvanceKey = 21;
            this.mRetreatKey = 22;
            return;
        L5:
            this.mAdvanceKey = 22;
            this.mRetreatKey = 21;
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int lookForSelectablePosition(int r1, boolean r2) {
            return super.lookForSelectablePosition(r1, r2);
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ boolean onForwardedEvent(MotionEvent r1, int r2) {
            return super.onForwardedEvent(r1, r2);
        }

        @Override // android.widget.ListView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
        public boolean onKeyDown(int r5, KeyEvent r6) {
            ListMenuItemView r0 = (ListMenuItemView) getSelectedView();
            if (r0 != null) goto L5;
        L12:
            if (r0 == null) goto L22;
            if (r5 != this.mRetreatKey) goto L22;
            setSelection(-1);
            ListAdapter r7 = getAdapter();
            if ((r7 instanceof HeaderViewListAdapter) == false) goto L18;
            MenuAdapter r8 = (MenuAdapter) ((HeaderViewListAdapter) r7).getWrappedAdapter();
        L19:
            r8.getAdapterMenu().close(false);
            return true;
        L18:
            r8 = (MenuAdapter) r7;
        L22:
            return super.onKeyDown(r5, r6);
        L5:
            if (r5 != this.mAdvanceKey) goto L12;
            if (r0.isEnabled() == true) goto L9;
        L11:
            return true;
        L9:
            if (r0.getItemData().hasSubMenu() == false) goto L11;
            performItemClick(r0, getSelectedItemPosition(), getSelectedItemId());
            goto L11
        }

        @Override // androidx.appcompat.widget.DropDownListView
        public /* bridge */ /* synthetic */ int measureHeightOfChildrenCompat(int r1, int r2, int r3, int r4, int r5) {
            return super.measureHeightOfChildrenCompat(r1, r2, r3, r4, r5);
        }
    }

    static {
        if (Build.VERSION.SDK_INT > 28) goto L9;
        sSetTouchModalMethod = PopupWindow.class.getDeclaredMethod("setTouchModal", new Class[]{Boolean.TYPE});     // Catch: NoSuchMethodException -> L6
        return;
    L9:
        return;
    }

    public void setEnterTransition(Object r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mPopup.setEnterTransition((Transition) r3);
        return;
    }

    public void setExitTransition(Object r3) {
        if (Build.VERSION.SDK_INT < 23) goto L6;
        this.mPopup.setExitTransition((Transition) r3);
        return;
    }

    public void setHoverListener(MenuItemHoverListener r1) {
        this.mHoverListener = r1;
    }

    public void setTouchModal(boolean r5) {
        if (Build.VERSION.SDK_INT > 28) goto L8;
        Method r0 = sSetTouchModalMethod;
        if (r0 == null) goto L13;
        r0.invoke(this.mPopup, new Object[]{Boolean.valueOf(r5)});     // Catch: Exception -> L10
        return;
    L15:
        return;
    L13:
        return;
    L8:
        this.mPopup.setTouchModal(r5);
    }

    @Override // androidx.appcompat.widget.ListPopupWindow
    public DropDownListView createDropDownListView(Context r2, boolean r3) {
        MenuDropDownListView r0 = new MenuDropDownListView(r2, r3);
        r0.setHoverListener(this);
        return r0;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverEnter(MenuBuilder r2, MenuItem r3) {
        MenuItemHoverListener r0 = this.mHoverListener;
        if (r0 == null) goto L6;
        r0.onItemHoverEnter(r2, r3);
        return;
    }

    @Override // androidx.appcompat.widget.MenuItemHoverListener
    public void onItemHoverExit(MenuBuilder r2, MenuItem r3) {
        MenuItemHoverListener r0 = this.mHoverListener;
        if (r0 == null) goto L6;
        r0.onItemHoverExit(r2, r3);
        return;
    }

    public MenuPopupWindow(Context r1, AttributeSet r2, int r3, int r4) {
        super(r1, r2, r3, r4);
    }
}
