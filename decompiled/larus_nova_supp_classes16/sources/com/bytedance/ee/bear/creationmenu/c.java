package com.bytedance.ee.bear.creationmenu;

import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.BaseDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iw4.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c implements com.bytedance.ee.bear.content.creation.mvp.b {
    public static final /* synthetic */ int C = 0;
    public final b A;
    public f B;
    public final Context a;
    public final Fragment b;
    public final ViewGroup c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public Boolean h;
    public CreationMenuItemAdapter i;
    public com.bytedance.ee.bear.content.creation.mvp.b.a j;
    public com.bytedance.ee.bear.creationmenu.a k;
    public com.bytedance.ee.bear.creationmenu.a l;
    public com.bytedance.ee.bear.creationmenu.a m;
    public Dialog n;
    public final ViewOnClickListenerC0040c o;
    public Integer p;
    public Integer q;
    public View r;
    public com.bytedance.ee.bear.creationmenu.a s;
    public final String t;
    public final String u;
    public final String v;
    public BaseRecyclerView w;
    public List<g> x;
    public List<g> y;
    public final d z;

    public static final class a {
    }

    public static final class b implements ComponentCallbacks {
        public final /* synthetic */ c a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public b(c r1) {
            this.a = r1;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r5) {
            Intrinsics.checkNotNullParameter(r5, "newConfig");
            int r0 = r5.orientation;
            Integer r1 = this.a.p;
            if (r1 != null) goto L6;
        L12:
            Dialog r2 = this.a.n;
            if (r2 == null) goto L31;
            Handler r3 = DialogLancet.resolveDialogHandler(r2);
            if (r3 != null) goto L17;
        L19:
            DialogLancet.beforeDialogDismiss(r2);
            r2.dismiss();     // Catch: Throwable -> L22 Exception -> L24
        L28:
            DialogLancet.afterDialogDismiss(r2);
            goto L31
        L24:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
            if (r4 == null) goto L28;
            com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r2);
            throw th;
        L17:
            if (Looper.myLooper() == r3.getLooper()) goto L19;
            r3.post(DialogLancet.createDismissRunnable(r2));
        L31:
            c r6 = this.a;
            r6.n = null;
            r6.p = Integer.valueOf(r5.orientation);
            c r7 = this.a;
            r7.q = Integer.valueOf(r5.screenLayout);
            return;
        L6:
            if (r0 != r1.intValue()) goto L12;
            int r8 = r5.screenLayout;
            Integer r9 = this.a.q;
            if (r9 == null) goto L12;
            if (r8 != r9.intValue()) goto L12;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.creationmenu.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC0040c implements View.OnClickListener {
        public final /* synthetic */ c a;

        public ViewOnClickListenerC0040c(c r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            Dialog r5 = this.a.n;
            if (r5 == null) goto L21;
            Handler r0 = DialogLancet.resolveDialogHandler(r5);
            if (r0 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r5);
            r5.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r5);
            goto L21
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r5);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r1 == null) goto L18;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r0.getLooper()) goto L9;
            r0.post(DialogLancet.createDismissRunnable(r5));
        L21:
            this.a.n = null;
        }
    }

    public static final class d implements com.bytedance.ee.bear.creationmenu.e {
        public final /* synthetic */ c a;

        public d(c r1) {
            this.a = r1;
        }

        @Override // com.bytedance.ee.bear.creationmenu.e
        public final void a(SelectCreationMenuItem r5) {
            Intrinsics.checkNotNullParameter(r5, "menuItem");
            Dialog r0 = this.a.n;
            if (r0 == null) goto L7;
            Window r1 = r0.getWindow();
            if (r1 == null) goto L7;
            r1.setWindowAnimations(0);
        L7:
            Dialog r2 = this.a.n;
            if (r2 == null) goto L26;
            Handler r3 = DialogLancet.resolveDialogHandler(r2);
            if (r3 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r2);
            r2.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r2);
            goto L26
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r4 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r4 == null) goto L23;
            com.bytedance.crash.d.d(r4, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r2);
            throw th;
        L12:
            if (Looper.myLooper() == r3.getLooper()) goto L14;
            r3.post(DialogLancet.createDismissRunnable(r2));
        L26:
            hac.b.a.b("CreationMenuItemView", "onPlusMenuItemClick()...menuItem = " + r5 + ".text");
            if (this.a.j != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("mDelegate");
        L30:
            if (r5.d == false) goto L35;
            com.bytedance.ee.bear.content.creation.mvp.b.a r6 = this.a.j;
            if (r6 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mDelegate");
            r6 = null;
        L34:
            r6.j7(r5.getType());
        L35:
            this.a.n = null;
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {
        public final /* synthetic */ c a;

        public e(c r1) {
            this.a = r1;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r2) {
            this.a.n = null;
        }
    }

    static {
    }

    public final void create() {
        hac.b r0 = hac.b.a;
        r0.b("CreationMenuItemView", "create()...");
        r0.b("CreationMenuItemView", "initView() called");
        FragmentActivity r2 = this.b.getActivity();
        if (r2 == null) goto L5;
        SelectCreationMenuViewModel r1 = (SelectCreationMenuViewModel) new ViewModelProvider(r2).get(SelectCreationMenuViewModel.class);
    L7:
        if (this.i != null) goto L9;
        hac.c.a("CreationMenuItemView", "initView: madapter isInitialized is false");
        CreationMenuItemAdapter r3 = new CreationMenuItemAdapter(h(true), this.e, this.f);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.i = r3;
    L9:
        CreationMenuItemAdapter r4 = this.i;
        RecyclerView r5 = null;
        if (r4 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("madapter");
        r4 = null;
    L13:
        BaseRecyclerView r6 = this.c.findViewById(2131384076);
        Intrinsics.checkNotNullParameter(r6, "<set-?>");
        this.w = r6;
        Function2<com.bytedance.ee.bear.creationmenu.a, View, Unit> r7 = new CreationMenuItemView$initRvMenu$1(this);
        r4.getClass();
        Intrinsics.checkNotNullParameter(r7, "listener");
        r4.c = r7;
        RecyclerView r8 = this.w;
        if (r8 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r8 = null;
    L17:
        r8.setAdapter(r4);
        RecyclerView r9 = this.w;
        if (r9 == null) goto L20;
        r5 = r9;
    L21:
        r5.setLayoutManager(new GridLayoutManager(this.a, 3, 1, false));
        FragmentActivity r10 = this.b.getActivity();
        if (r10 == null) goto L24;
        r10.unregisterComponentCallbacks(this.A);
    L24:
        FragmentActivity r11 = this.b.getActivity();
        if (r11 == null) goto L28;
        r11.registerComponentCallbacks(this.A);
        return;
    L28:
        return;
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        goto L21
    L5:
        r0.b("CreationMenuItemView", "initView()...activity is null");
        goto L7
    }

    public final void destroy() {
        hac.b.a.b("CreationMenuItemView", "destroy()...");
        FragmentActivity r0 = this.b.getActivity();
        if (r0 == null) goto L6;
        r0.unregisterComponentCallbacks(this.A);
        return;
    }

    public final ArrayList<com.bytedance.ee.bear.creationmenu.a> h(boolean r28) {
        ArrayList<com.bytedance.ee.bear.creationmenu.a> r1 = new ArrayList();
        com.bytedance.ee.bear.creationmenu.a r10 = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.NEW_DOC.getId(), 2131255209, this.a.getString(2131889579), this.a.getString(2131889623), true, this.x, 64);
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        this.k = r10;
        com.bytedance.ee.bear.creationmenu.a r3 = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.UPLOAD.getId(), 2131254130, this.a.getString(2131889656), this.a.getString(2131889655), r28, this.y, 64);
        Intrinsics.checkNotNullParameter(r3, "<set-?>");
        this.l = r3;
        this.m = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.TEMPLATE.getId(), 2131255980, this.a.getString(2131889618), this.a.getString(2131889619), r28, null, 96);
        com.bytedance.ee.bear.creationmenu.a r2 = this.k;
        com.bytedance.ee.bear.creationmenu.a r4 = null;
        if (r2 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("newDocItem");
        r2 = null;
    L6:
        r1.add(r2);
        com.bytedance.ee.bear.creationmenu.a r5 = this.l;
        if (r5 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("uploadItem");
        r5 = null;
    L10:
        r1.add(r5);
        if (this.d == false) goto L17;
        com.bytedance.ee.bear.creationmenu.a r6 = this.m;
        if (r6 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("templateItem");
    L16:
        r1.add(r4);
        goto L17
    L15:
        r4 = r6;
    L17:
        return r1;
    }

    public final void setViewDelegate(IView.IViewDelegate r2) {
        com.bytedance.ee.bear.content.creation.mvp.b.a r3 = (com.bytedance.ee.bear.content.creation.mvp.b.a) r2;
        Intrinsics.checkNotNullParameter(r3, "viewDelegate");
        this.j = r3;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void v6(boolean r4) {
        if (this.i != null) goto L5;
        CreationMenuItemAdapter r0 = new CreationMenuItemAdapter(h(r4), this.e, this.f);
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        this.i = r0;
        return;
    L5:
        Boolean r1 = this.h;
        if (r1 != null) goto L8;
    L10:
        this.h = Boolean.valueOf(r4);
        ArrayList<com.bytedance.ee.bear.creationmenu.a> r5 = h(r4);
        CreationMenuItemAdapter r2 = this.i;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("madapter");
        r2 = null;
    L14:
        r2.setNewData(r5);
        return;
    L8:
        if (Intrinsics.areEqual(r1, Boolean.valueOf(r4)) == false) goto L10;
    }

    public final void k(View r18, com.bytedance.ee.bear.creationmenu.a r19) {
        if (r19.g.isEmpty() == true) goto L5;
    L8:
        Rect r3 = new Rect();
        r18.getWindowVisibleDisplayFrame(r3);
        Rect r4 = new Rect();
        r18.getGlobalVisibleRect(r4);
        Rect r1 = new Rect();
        FragmentActivity r5 = this.b.getActivity();
        if (r5 == null) goto L19;
        Window r6 = r5.getWindow();
        if (r6 == null) goto L19;
        View r7 = r6.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L17;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r8 = ThreadMethodProxy.currentThread();
        if (r8 == com.larus.home.impl.utils.c.a) goto L17;
        com.larus.home.impl.utils.c.a(r8, "getDecorView");
    L17:
        if (r7 == null) goto L19;
        r7.getGlobalVisibleRect(r1);
    L19:
        float r9 = (UIUtils.px2dp(this.a, r4.bottom - r3.top) - 36.0f) + 8.0f;
        float r10 = UIUtils.px2dp(this.a, r1.right - r4.right) - 36.0f;
        if (this.g == false) goto L46;
        List<g> r2 = r19.f;
        LinearLayout r11 = new LinearLayout(this.a);
        r11.setOrientation(1);
        Iterator<T> r12 = r2.iterator();
    L23:
        if (r12.hasNext() == false) goto L70;
        g r13 = (g) r12.next();
        int r16 = CreationMenuPlusItem.h;
        Context r14 = this.a;
        String r17 = eu5.b.a.getText(r13.e).toString();
        int r110 = r13.d;
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r13, "menuItem");
        CreationMenuPlusItem r111 = new CreationMenuPlusItem(r14);
        if (r111.d != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L27:
        if (r17 == null) goto L33;
        TextView r20 = r111.d;
        if (r20 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r20 = null;
    L31:
        r20.setText(r17);
    L33:
        if (r111.c != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
    L35:
        if (r110 == 0) goto L40;
        ImageView r21 = r111.c;
        if (r21 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r21 = null;
    L39:
        r21.setImageResource(r110);
    L40:
        r111.f = r13;
        if (r13.a == true) goto L43;
    L44:
        r111.setEnabled(false);
        r111.setAlpha(0.5f);
    L45:
        r111.setWikiMenuItemClickListener(new com.bytedance.ee.bear.creationmenu.d(this));
        r11.addView(r111);
        goto L23
    L43:
        if (r13.b == true) goto L45;
    L70:
        ScrollView r22 = new ScrollView(this.a);
        r22.setBackgroundResource(2131232565);
        r22.setOverScrollMode(2);
        r22.setVerticalScrollBarEnabled(false);
        r22.addView(r11, new ViewGroup.LayoutParams(-1, -2));
        UDShadowLayout r23 = new UDShadowLayout(this.a);
        r23.c(2131953899);
        r23.setShadowRadius(new UDDimension.Dp(8.0f));
        r23.setOnClickListener(this.o);
        Context r24 = this.a;
        Intrinsics.checkNotNullParameter(r22, "<this>");
        r22.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        com.ss.android.lark.forsetiutils.b r112 = com.ss.android.lark.forsetiutils.b.a;
        int r113 = r22.getMeasuredWidth();
        Context r114 = r22.getContext();
        r112.getClass();
        UDShadowLayout.LayoutParams r26 = new UDShadowLayout.LayoutParams(Math.max(UIUtils.dp2px(r24, new Size(com.ss.android.lark.forsetiutils.b.b(r113, r114), com.ss.android.lark.forsetiutils.b.b(r22.getMeasuredHeight(), r22.getContext())).getWidth()), r4.width()), -2);
        if (r10 > 0.0f) goto L73;
        r26.setMarginEnd(y9c.d.b(this.a, 16.0f));
    L73:
        Unit r27 = Unit.INSTANCE;
        r23.addView(r22, r26);
        BaseDialog r28 = new BaseDialog(this.a, 2131954192);
        r28.setContentView(r23);
        r28.setCanceledOnTouchOutside(true);
        this.n = r28;
        Rect r29 = new Rect(r4.left - UIUtils.dp2px(this.a, 36.0f), UIUtils.dp2px(this.a, r9), r4.right, r1.bottom);
        Context r30 = this.a;
        Window r31 = r28.getWindow();
        WindowManager.LayoutParams r32 = r31.getAttributes();
        r32.x = r29.left;
        r32.y = r29.top;
        r32.gravity = 51;
        r31.setAttributes(r32);
        r31.setWindowAnimations(2131953926);
        r31.setDimAmount(fac.a.b(r30));
        fac.a.a(r28);
        r28.setOnCancelListener(new e(this));
        return;
    L46:
        List<? extends SelectCreationMenuItem> r33 = r19.g;
        r11 = new LinearLayout(this.a);
        r11.setOrientation(1);
        Iterator r34 = r33.iterator();
    L48:
        if (r34.hasNext() == false) goto L70;
        SelectCreationMenuItem r36 = (SelectCreationMenuItem) r34.next();
        int r37 = CreationMenuPlusItem.h;
        Context r38 = this.a;
        String r115 = r36.getType().getTag();
        CharSequence r116 = r36.b;
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type kotlin.String");
        String r117 = (String) r116;
        int r118 = r36.c;
        Intrinsics.checkNotNullParameter(r38, "context");
        Iterator r119 = r34;
        Intrinsics.checkNotNullParameter(r115, "menuKey");
        Intrinsics.checkNotNullParameter(r36, "menuItem");
        CreationMenuPlusItem r39 = new CreationMenuPlusItem(r38);
        if (r39.d != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L52:
        if (r117 == null) goto L58;
        TextView r40 = r39.d;
        if (r40 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r40 = null;
    L56:
        r40.setText(r117);
    L58:
        if (r39.c != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
    L60:
        if (r118 == 0) goto L65;
        ImageView r41 = r39.c;
        if (r41 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r41 = null;
    L64:
        r41.setImageResource(r118);
    L65:
        r39.e = r36;
        if (r36.d == true) goto L69;
        r39.setEnabled(false);
        r39.setAlpha(0.5f);
    L69:
        r39.setMenuItemClickListener(this.z);
        r11.addView(r39);
        r34 = r119;
        goto L48
    L5:
        if (r19.f.isEmpty() == false) goto L8;
        hac.b.a.b("CreationMenuItemView", "showPopOver()...item menuList or wikiMenuList is empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList<com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.List<? extends com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.ArrayList<com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.List<? extends com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List] */
    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void o1(ArrayList<SelectCreationMenuItem> r4, ArrayList<SelectCreationMenuItem> r5) {
        com.bytedance.ee.bear.creationmenu.a r0 = this.k;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("newDocItem");
        r0 = null;
    L6:
        if (r4 != 0) goto L9;
        r4 = CollectionsKt.emptyList();
    L9:
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.g = r4;
        com.bytedance.ee.bear.creationmenu.a r6 = this.l;
        if (r6 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("uploadItem");
        r6 = null;
    L13:
        if (r5 != 0) goto L16;
        r5 = CollectionsKt.emptyList();
    L16:
        r6.getClass();
        Intrinsics.checkNotNullParameter(r5, "<set-?>");
        r6.g = r5;
        Dialog r7 = this.n;
        if (r7 == null) goto L40;
        Handler r8 = DialogLancet.resolveDialogHandler(r7);
        if (r8 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(r7);
        r7.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(r7);
    L33:
        this.n = null;
        View r9 = this.r;
        if (r9 == null) goto L44;
        com.bytedance.ee.bear.creationmenu.a r10 = this.s;
        if (r10 == null) goto L45;
        k(r9, r10);
        return;
    L45:
        return;
    L44:
        return;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r11 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r11 == null) goto L32;
        com.bytedance.crash.d.d(r11, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r7);
        throw th;
    L21:
        if (Looper.myLooper() == r8.getLooper()) goto L23;
        r8.post(DialogLancet.createDismissRunnable(r7));
        goto L33
    }

    public c(Context r2, Fragment r3, ViewGroup r4, boolean r5, h r6, boolean r7, boolean r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        Intrinsics.checkNotNullParameter(r3, "mFragment");
        Intrinsics.checkNotNullParameter(r4, "mRootView");
        Intrinsics.checkNotNullParameter(r6, "menuContext");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        hac.b.a.b("CreationMenuItemView", "null() called " + this);
        this.o = new ViewOnClickListenerC0040c(this);
        FragmentActivity r10 = r3.getActivity();
        Integer r11 = null;
        if (r10 == null) goto L9;
        Resources r12 = r10.getResources();
        if (r12 == null) goto L9;
        Configuration r13 = r12.getConfiguration();
        if (r13 == null) goto L9;
        Integer r14 = Integer.valueOf(r13.orientation);
    L10:
        this.p = r14;
        FragmentActivity r16 = r3.getActivity();
        if (r16 == null) goto L17;
        Resources r17 = r16.getResources();
        if (r17 == null) goto L17;
        Configuration r18 = r17.getConfiguration();
        if (r18 == null) goto L17;
        r11 = Integer.valueOf(r18.screenLayout);
    L17:
        this.q = r11;
        this.t = r6.b;
        String r19 = r6.a;
        String r20 = "";
        if (r19 != null) goto L20;
        r19 = "";
    L20:
        this.u = r19;
        CreateSelectResult.CREATOR.getClass();
        CreateSelectResult.a.b();
        String r21 = r6.h;
        if (r21 == null) goto L24;
        r20 = r21;
    L24:
        this.v = r20;
        this.x = CollectionsKt.emptyList();
        this.y = CollectionsKt.emptyList();
        this.z = new d(this);
        this.A = new b(this);
        return;
    L9:
        r14 = null;
        goto L10
    }
}
