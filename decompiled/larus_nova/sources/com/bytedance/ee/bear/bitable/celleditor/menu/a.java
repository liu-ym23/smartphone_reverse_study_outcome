package com.bytedance.ee.bear.bitable.celleditor.menu;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorMenuModel;
import com.bytedance.ee.bear.bitable.celleditor.bean.EditorMenuStyle;
import com.bytedance.ee.bear.bitable.celleditor.model.BitableEditorViewModel;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements i<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hr4.a f209574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.celleditor.editor.b f209575b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LKUIDialog f209576c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.larksuite.component.universe_design.menu.c f209577d;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.celleditor.menu.a$a, reason: collision with other inner class name */
    public static final class C3018a {
    }

    static {
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerV2$CC.$default$authType(this);
    }

    public a(hr4.a r100) {
        Intrinsics.checkNotNullParameter(r100, "mEditorContext");
        this.f209574a = r100;
        this.f209575b = new com.bytedance.ee.bear.bitable.celleditor.editor.b();
    }

    public static final void a(a r100) {
        r100.getClass();
        tt5.a.h("BitableEditorMenuHandler", "handleDismiss");
        com.bytedance.ee.bear.bitable.celleditor.editor.b r101 = r100.f209575b;
        r101.getClass();
        ActionPayload r102 = new ActionPayload();
        r102.setAction("EditorMenuCloseAction");
        r101.a(r102);
        r100.f209576c = null;
        r100.f209577d = null;
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
    public final void c(String r100, m r101) {
        tt5.a.h("BitableEditorMenuHandler", "handle");
        this.f209575b.update(r101);
        EditorMenuModel r102 = (EditorMenuModel) GsonProtectorUtils.fromJson(new Gson(), r100, EditorMenuModel.class);
        View r103 = null;
        String r104 = null;
        r103 = null;
        if (Intrinsics.areEqual(r102.isClose(), Boolean.TRUE) == false) goto L34;
        tt5.a.h("BitableEditorMenuHandler", "dismissMenu");
        LKUIDialog r105 = this.f209576c;
        if (r105 == null) goto L7;
        r105.setOnDismissListener(null);
    L7:
        com.larksuite.component.universe_design.menu.c r106 = this.f209577d;
        if (r106 == null) goto L10;
        b r107 = new b();
        Intrinsics.checkNotNullParameter(r107, "listener");
        r106.f285081g = r107;
    L10:
        LKUIDialog r108 = this.f209576c;
        if (r108 == null) goto L29;
        Handler r109 = DialogLancet.resolveDialogHandler(r108);
        if (r109 != null) goto L15;
    L17:
        DialogLancet.beforeDialogDismiss(r108);
        r108.dismiss();     // Catch: Throwable -> L20 Exception -> L22
    L26:
        DialogLancet.afterDialogDismiss(r108);
        goto L29
    L20:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r108);
        throw th;
    L22:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L20
        Throwable r110 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L20
        if (r110 == null) goto L26;
        com.bytedance.crash.d.d(r110, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L20
        goto L26
    L15:
        if (Looper.myLooper() == r109.getLooper()) goto L17;
        r109.post(DialogLancet.createDismissRunnable(r108));
    L29:
        com.larksuite.component.universe_design.menu.c r111 = this.f209577d;
        if (r111 == null) goto L32;
        r111.a();
    L32:
        this.f209576c = null;
        this.f209577d = null;
        return;
    L34:
        if (r102.isBottomSheet() == false) goto L53;
        Intrinsics.checkNotNull(r102);
        tt5.a.h("BitableEditorMenuHandler", "showBottomSheet");
        com.bytedance.ee.bear.widgets.a r112 = new com.bytedance.ee.bear.widgets.a(this.f209574a.getContext());
        EditorMenuStyle r113 = r102.getStyle();
        if (r113 == null) goto L38;
        r104 = r113.getTitle();
    L38:
        r112.k(r104);
        ArrayList<SimpleItemModel> r114 = r102.getMenu();
        if (r114 == null) goto L47;
        Iterator<T> r115 = r114.iterator();
    L42:
        if (r115.hasNext() == false) goto L47;
        SimpleItemModel r116 = (SimpleItemModel) r115.next();
        String r117 = r116.getText();
        if (r117 != null) goto L46;
        r117 = "";
    L46:
        r112.g(r117, new c(r116, this));
    L47:
        r112.a();
        LKUIDialog r118 = r112.m(0.4f);
        r118.setOnDismissListener(new d(this));
        this.f209576c = r118;
        if (DialogLancet.shouldBlockDialogShow(r118) == false) goto L72;
        DialogLancet.handleBlockedDialogShow(r118);
        return;
    L72:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L71
    L51:
        DialogLancet.beforeDialogShow(r118);
        r118.show();
        DialogLancet.afterDialogShow(r118);
        return;
    L53:
        if (r102.isMenu() == false) goto L84;
        Intrinsics.checkNotNull(r102);
        tt5.a.h("BitableEditorMenuHandler", "showEditMenu");
        ArrayList r119 = new ArrayList();
        ArrayList<SimpleItemModel> r120 = r102.getMenu();
        if (r120 == null) goto L60;
        Iterator<T> r121 = r120.iterator();
    L58:
        if (r121.hasNext() == false) goto L60;
        final SimpleItemModel r122 = (SimpleItemModel) r121.next();
        r119.add(new f(this.f209574a.getContext(), r122, new BitableEditorMenuHandler$showEditMenu$1$1(r122, this)));
    L60:
        com.larksuite.component.universe_design.menu.c.f r123 = new com.larksuite.component.universe_design.menu.c.f();
        r123.c(80);
        r123.b(PositionAlign.END);
        r123.f(r119);
        r123.d(new e(this));
        this.f209577d = r123.a();
        Function0<BitableEditorViewModel> r124 = this.f209574a.f486868j;
        if (r124 == null) goto L65;
        BitableEditorViewModel r125 = r124.invoke();
        if (r125 == null) goto L65;
        r103 = r125.getClickRenderCellView();
    L65:
        if (r103 == null) goto L69;
        com.larksuite.component.universe_design.menu.c r126 = this.f209577d;
        if (r126 == null) goto L85;
        Intrinsics.checkNotNullParameter(r103, "anchorView");
        r126.c(r103);
        return;
    L85:
        return;
    L69:
        tt5.a.d("BitableEditorMenuHandler", "showEditMenu failed cellView is null");
        return;
    }

    @Override // tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ void handle(Object r100, m r101) {
        c((String) r100, r101);
    }
}
