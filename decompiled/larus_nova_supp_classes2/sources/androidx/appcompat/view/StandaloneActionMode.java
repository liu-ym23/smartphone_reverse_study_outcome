package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
public class StandaloneActionMode extends ActionMode implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public void onCloseMenu(MenuBuilder r1, boolean r2) {
    }

    public void onCloseSubMenu(SubMenuBuilder r1) {
    }

    @Override // androidx.appcompat.view.ActionMode
    public void finish() {
        if (this.mFinished == false) goto L5;
        return;
    L5:
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode(this);
    }

    @Override // androidx.appcompat.view.ActionMode
    public View getCustomView() {
        WeakReference<View> r0 = this.mCustomView;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get();
    }

    @Override // androidx.appcompat.view.ActionMode
    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    @Override // androidx.appcompat.view.ActionMode
    public CharSequence getTitle() {
        return this.mContextView.getTitle();
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
    @Override // androidx.appcompat.view.ActionMode
    public void invalidate() {
        this.mCallback.onPrepareActionMode(this, this.mMenu);
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    @Override // androidx.appcompat.view.ActionMode
    public Menu getMenu() {
        return this.mMenu;
    }

    @Override // androidx.appcompat.view.ActionMode
    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public void onMenuModeChange(MenuBuilder r1) {
        invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder r4) {
        if (r4.hasVisibleItems() == true) goto L5;
        return true;
    L5:
        new MenuPopupHelper(this.mContextView.getContext(), r4).show();
        return true;
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setCustomView(View r2) {
        this.mContextView.setCustomView(r2);
        if (r2 == null) goto L5;
        WeakReference<View> r0 = new WeakReference(r2);
    L6:
        this.mCustomView = r0;
        return;
    L5:
        r0 = null;
        goto L6
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(int r2) {
        setSubtitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(int r2) {
        setTitle(this.mContext.getString(r2));
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitleOptionalHint(boolean r2) {
        super.setTitleOptionalHint(r2);
        this.mContextView.setTitleOptional(r2);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setSubtitle(CharSequence r2) {
        this.mContextView.setSubtitle(r2);
    }

    @Override // androidx.appcompat.view.ActionMode
    public void setTitle(CharSequence r2) {
        this.mContextView.setTitle(r2);
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
    public boolean onMenuItemSelected(MenuBuilder r1, MenuItem r2) {
        return this.mCallback.onActionItemClicked(this, r2);
    }

    public StandaloneActionMode(Context r1, ActionBarContextView r2, ActionMode.Callback r3, boolean r4) {
        this.mContext = r1;
        this.mContextView = r2;
        this.mCallback = r3;
        MenuBuilder r5 = new MenuBuilder(r2.getContext()).setDefaultShowAsAction(1);
        this.mMenu = r5;
        r5.setCallback(this);
        this.mFocusable = r4;
    }
}
