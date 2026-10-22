package androidx.appcompat.view.menu;

import android.content.DialogInterface;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.bytedance.crash.d;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
class MenuDialogHelper implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, MenuPresenter.Callback {
    private AlertDialog mDialog;
    private MenuBuilder mMenu;
    ListMenuPresenter mPresenter;
    private MenuPresenter.Callback mPresenterCallback;

    public void dismiss() {
        AlertDialog r0 = this.mDialog;
        if (r0 == null) goto L6;
        INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(r0);
        return;
    }

    public MenuDialogHelper(MenuBuilder r1) {
        this.mMenu = r1;
    }

    public static View INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_dismiss(AlertDialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L10:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L13:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L10;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
        goto L10
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public static void INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(AlertDialog r1) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L7:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface r3) {
        this.mPresenter.onCloseMenu(this.mMenu, true);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public boolean onOpenSubMenu(MenuBuilder r2) {
        MenuPresenter.Callback r0 = this.mPresenterCallback;
        if (r0 != null) goto L5;
        return false;
    L5:
        return r0.onOpenSubMenu(r2);
    }

    public void setPresenterCallback(MenuPresenter.Callback r1) {
        this.mPresenterCallback = r1;
    }

    public void show(IBinder r6) {
        MenuBuilder r0 = this.mMenu;
        AlertDialog.Builder r1 = new AlertDialog.Builder(r0.getContext());
        ListMenuPresenter r2 = new ListMenuPresenter(r1.getContext(), 2131558422);
        this.mPresenter = r2;
        r2.setCallback(this);
        this.mMenu.addMenuPresenter(this.mPresenter);
        r1.setAdapter(this.mPresenter.getAdapter(), this);
        View r3 = r0.getHeaderView();
        if (r3 == null) goto L5;
        r1.setCustomTitle(r3);
    L6:
        r1.setOnKeyListener(this);
        AlertDialog r4 = r1.create();
        this.mDialog = r4;
        r4.setOnDismissListener(this);
        WindowManager.LayoutParams r5 = this.mDialog.getWindow().getAttributes();
        r5.type = 1003;
        if (r6 == null) goto L9;
        r5.token = r6;
    L9:
        r5.flags |= 131072;
        INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_obric_assistant_interaction_impl_window_helpers_DialogLancet_show(this.mDialog);
        return;
    L5:
        r1.setIcon(r0.getHeaderIcon()).setTitle(r0.getHeaderTitle());
        goto L6
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
    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface r2, int r3) {
        this.mMenu.performItemAction((MenuItemImpl) this.mPresenter.getAdapter().getItem(r3), 0);
    }

    @Override // androidx.appcompat.view.menu.MenuPresenter.Callback
    public void onCloseMenu(MenuBuilder r2, boolean r3) {
        if (r3 == false) goto L4;
    L5:
        dismiss();
    L6:
        MenuPresenter.Callback r0 = this.mPresenterCallback;
        if (r0 == null) goto L10;
        r0.onCloseMenu(r2, r3);
        return;
    L10:
        return;
    L4:
        if (r2 != this.mMenu) goto L6;
        goto L5
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface r3, int r4, KeyEvent r5) {
        if (r4 == 82) goto L7;
        if (r4 == 4) goto L7;
    L33:
        return this.mMenu.performShortcut(r4, r5, 0);
    L7:
        if (r5.getAction() != 0) goto L19;
        if (r5.getRepeatCount() != 0) goto L19;
        Window r6 = this.mDialog.getWindow();
        if (r6 == null) goto L33;
        View r7 = INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r6);
        if (r7 == null) goto L33;
        KeyEvent.DispatcherState r8 = r7.getKeyDispatcherState();
        if (r8 == null) goto L33;
        r8.startTracking(r5, this);
        return true;
    L19:
        if (r5.getAction() != 1) goto L33;
        if (r5.isCanceled() == true) goto L33;
        Window r0 = this.mDialog.getWindow();
        if (r0 == null) goto L33;
        View r1 = INVOKEVIRTUAL_androidx_appcompat_view_menu_MenuDialogHelper_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r0);
        if (r1 == null) goto L33;
        KeyEvent.DispatcherState r2 = r1.getKeyDispatcherState();
        if (r2 == null) goto L33;
        if (r2.isTracking(r5) == false) goto L33;
        this.mMenu.close(true);
        r3.dismiss();
        return true;
    }
}
