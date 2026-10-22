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
import com.bytedance.ee.bear.content.creation.SelectCreationMenuViewModel;
import com.bytedance.ee.bear.content.creation.location.CreateSelectResult;
import com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem;
import com.bytedance.ee.bear.widgets.BaseRecyclerView;
import com.larksuite.component.universe_design.dimension.UDDimension;
import com.larksuite.component.universe_design.shadow.UDShadowLayout;
import com.larksuite.framework.mvp.IView;
import com.larksuite.framework.ui.BaseDialog;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import iw4.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements com.bytedance.ee.bear.content.creation.mvp.b {
    public static final /* synthetic */ int C = 0;
    public final b A;
    public f B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f217291a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f217292b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ViewGroup f217293c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f217294d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f217295e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f217296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f217297g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f217298h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public CreationMenuItemAdapter f217299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.ee.bear.content.creation.mvp.b.a f217300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.a f217301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.a f217302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.a f217303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Dialog f217304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ViewOnClickListenerC3096c f217305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Integer f217306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f217307q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public View f217308r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public com.bytedance.ee.bear.creationmenu.a f217309s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f217310t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f217311u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f217312v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public BaseRecyclerView f217313w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<g> f217314x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<g> f217315y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d f217316z;

    public static final class a {
    }

    public static final class b implements ComponentCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f217317a;

        @Override // android.content.ComponentCallbacks
        public final void onLowMemory() {
        }

        public b(c r100) {
            this.f217317a = r100;
        }

        @Override // android.content.ComponentCallbacks
        public final void onConfigurationChanged(Configuration r100) {
            Intrinsics.checkNotNullParameter(r100, "newConfig");
            int r101 = r100.orientation;
            Integer r102 = this.f217317a.f217306p;
            if (r102 != null) goto L6;
        L12:
            Dialog r103 = this.f217317a.f217304n;
            if (r103 == null) goto L31;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L17;
        L19:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L22 Exception -> L24
        L28:
            DialogLancet.afterDialogDismiss(r103);
            goto L31
        L24:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L22
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L22
            if (r105 == null) goto L28;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L22
        L22:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L17:
            if (Looper.myLooper() == r104.getLooper()) goto L19;
            r104.post(DialogLancet.createDismissRunnable(r103));
        L31:
            c r106 = this.f217317a;
            r106.f217304n = null;
            r106.f217306p = Integer.valueOf(r100.orientation);
            c r107 = this.f217317a;
            r107.f217307q = Integer.valueOf(r100.screenLayout);
            return;
        L6:
            if (r101 != r102.intValue()) goto L12;
            int r108 = r100.screenLayout;
            Integer r109 = this.f217317a.f217307q;
            if (r109 == null) goto L12;
            if (r108 != r109.intValue()) goto L12;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.creationmenu.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC3096c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f217318a;

        public ViewOnClickListenerC3096c(c r100) {
            this.f217318a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Dialog r101 = this.f217318a.f217304n;
            if (r101 == null) goto L21;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r101);
            goto L21
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L14:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r103 == null) goto L18;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
            goto L18
        L7:
            if (Looper.myLooper() == r102.getLooper()) goto L9;
            r102.post(DialogLancet.createDismissRunnable(r101));
        L21:
            this.f217318a.f217304n = null;
        }
    }

    public static final class d implements com.bytedance.ee.bear.creationmenu.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f217319a;

        public d(c r100) {
            this.f217319a = r100;
        }

        @Override // com.bytedance.ee.bear.creationmenu.e
        public final void a(SelectCreationMenuItem r100) {
            Intrinsics.checkNotNullParameter(r100, "menuItem");
            Dialog r101 = this.f217319a.f217304n;
            if (r101 == null) goto L7;
            Window r102 = r101.getWindow();
            if (r102 == null) goto L7;
            r102.setWindowAnimations(0);
        L7:
            Dialog r103 = this.f217319a.f217304n;
            if (r103 == null) goto L26;
            Handler r104 = DialogLancet.resolveDialogHandler(r103);
            if (r104 != null) goto L12;
        L14:
            DialogLancet.beforeDialogDismiss(r103);
            r103.dismiss();     // Catch: Throwable -> L17 Exception -> L19
        L23:
            DialogLancet.afterDialogDismiss(r103);
            goto L26
        L19:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L17
            Throwable r105 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L17
            if (r105 == null) goto L23;
            com.bytedance.crash.d.d(r105, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L17
        L17:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r103);
            throw th;
        L12:
            if (Looper.myLooper() == r104.getLooper()) goto L14;
            r104.post(DialogLancet.createDismissRunnable(r103));
        L26:
            hac.b.f484427a.b("CreationMenuItemView", "onPlusMenuItemClick()...menuItem = " + r100 + ".text");
            if (this.f217319a.f217300j != null) goto L30;
            Intrinsics.throwUninitializedPropertyAccessException("mDelegate");
        L30:
            if (r100.f216851d == false) goto L35;
            com.bytedance.ee.bear.content.creation.mvp.b.a r106 = this.f217319a.f217300j;
            if (r106 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("mDelegate");
            r106 = null;
        L34:
            r106.j7(r100.getType());
        L35:
            this.f217319a.f217304n = null;
        }
    }

    public static final class e implements DialogInterface.OnCancelListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f217320a;

        public e(c r100) {
            this.f217320a = r100;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public final void onCancel(DialogInterface r100) {
            this.f217320a.f217304n = null;
        }
    }

    static {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        hac.b r100 = hac.b.f484427a;
        r100.b("CreationMenuItemView", "create()...");
        r100.b("CreationMenuItemView", "initView() called");
        FragmentActivity r101 = this.f217292b.getActivity();
        if (r101 == null) goto L5;
        SelectCreationMenuViewModel r102 = (SelectCreationMenuViewModel) new ViewModelProvider(r101).get(SelectCreationMenuViewModel.class);
    L7:
        if (this.f217299i != null) goto L9;
        hac.c.a("CreationMenuItemView", "initView: madapter isInitialized is false");
        CreationMenuItemAdapter r103 = new CreationMenuItemAdapter(h(true), this.f217295e, this.f217296f);
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        this.f217299i = r103;
    L9:
        CreationMenuItemAdapter r104 = this.f217299i;
        BaseRecyclerView r105 = null;
        if (r104 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("madapter");
        r104 = null;
    L13:
        BaseRecyclerView r106 = (BaseRecyclerView) this.f217293c.findViewById(R.id.recycler_view);
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        this.f217313w = r106;
        Function2<com.bytedance.ee.bear.creationmenu.a, View, Unit> r107 = new CreationMenuItemView$initRvMenu$1(this);
        r104.getClass();
        Intrinsics.checkNotNullParameter(r107, "listener");
        r104.f217268c = r107;
        BaseRecyclerView r108 = this.f217313w;
        if (r108 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L17:
        r108.setAdapter(r104);
        BaseRecyclerView r109 = this.f217313w;
        if (r109 == null) goto L20;
        r105 = r109;
    L21:
        r105.setLayoutManager(new GridLayoutManager(this.f217291a, 3, 1, false));
        FragmentActivity r110 = this.f217292b.getActivity();
        if (r110 == null) goto L24;
        r110.unregisterComponentCallbacks(this.A);
    L24:
        FragmentActivity r111 = this.f217292b.getActivity();
        if (r111 == null) goto L28;
        r111.registerComponentCallbacks(this.A);
        return;
    L28:
        return;
    L20:
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        goto L21
    L5:
        r100.b("CreationMenuItemView", "initView()...activity is null");
        goto L7
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        hac.b.f484427a.b("CreationMenuItemView", "destroy()...");
        FragmentActivity r100 = this.f217292b.getActivity();
        if (r100 == null) goto L6;
        r100.unregisterComponentCallbacks(this.A);
        return;
    }

    public final ArrayList<com.bytedance.ee.bear.creationmenu.a> h(boolean r210) {
        ArrayList<com.bytedance.ee.bear.creationmenu.a> r100 = new ArrayList();
        com.bytedance.ee.bear.creationmenu.a r110 = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.NEW_DOC.getId(), R.drawable.ud_icon_new_doc_colorful, this.f217291a.getString(R.string.LarkCCM_NewCM_CreateNew_Button), this.f217291a.getString(R.string.LarkCCM_NewCM_NewDoc__Title), true, this.f217314x, 64);
        Intrinsics.checkNotNullParameter(r110, "<set-?>");
        this.f217301k = r110;
        com.bytedance.ee.bear.creationmenu.a r101 = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.UPLOAD.getId(), R.drawable.ud_icon_cloud_upload_colorful, this.f217291a.getString(R.string.LarkCCM_NewCM_Upload_Button), this.f217291a.getString(R.string.LarkCCM_NewCM_UploadFile_Title), r210, this.f217315y, 64);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f217302l = r101;
        this.f217303m = new com.bytedance.ee.bear.creationmenu.a(CreationItemEnum.TEMPLATE.getId(), R.drawable.ud_icon_template_colorful, this.f217291a.getString(R.string.LarkCCM_NewCM_Mobile_TemplateCenter_Button), this.f217291a.getString(R.string.LarkCCM_NewCM_Mobile_TemplateCenter_Desc), r210, null, 96);
        com.bytedance.ee.bear.creationmenu.a r102 = this.f217301k;
        com.bytedance.ee.bear.creationmenu.a r103 = null;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("newDocItem");
        r102 = null;
    L6:
        r100.add(r102);
        com.bytedance.ee.bear.creationmenu.a r104 = this.f217302l;
        if (r104 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("uploadItem");
        r104 = null;
    L10:
        r100.add(r104);
        if (this.f217294d == false) goto L17;
        com.bytedance.ee.bear.creationmenu.a r105 = this.f217303m;
        if (r105 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("templateItem");
    L16:
        r100.add(r103);
        goto L17
    L15:
        r103 = r105;
    L17:
        return r100;
    }

    @Override // com.larksuite.framework.mvp.IView
    public final void setViewDelegate(IView.IViewDelegate r100) {
        com.bytedance.ee.bear.content.creation.mvp.b.a r101 = (com.bytedance.ee.bear.content.creation.mvp.b.a) r100;
        Intrinsics.checkNotNullParameter(r101, "viewDelegate");
        this.f217300j = r101;
    }

    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void v6(boolean r100) {
        if (this.f217299i != null) goto L5;
        CreationMenuItemAdapter r101 = new CreationMenuItemAdapter(h(r100), this.f217295e, this.f217296f);
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        this.f217299i = r101;
        return;
    L5:
        Boolean r102 = this.f217298h;
        if (r102 != null) goto L8;
    L10:
        this.f217298h = Boolean.valueOf(r100);
        ArrayList<com.bytedance.ee.bear.creationmenu.a> r103 = h(r100);
        CreationMenuItemAdapter r104 = this.f217299i;
        if (r104 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("madapter");
        r104 = null;
    L14:
        r104.setNewData(r103);
        return;
    L8:
        if (Intrinsics.areEqual(r102, Boolean.valueOf(r100)) == false) goto L10;
    }

    public final void k(View r110, com.bytedance.ee.bear.creationmenu.a r111) {
        if (r111.f217287g.isEmpty() == true) goto L5;
    L8:
        Rect r100 = new Rect();
        r110.getWindowVisibleDisplayFrame(r100);
        Rect r101 = new Rect();
        r110.getGlobalVisibleRect(r101);
        Rect r102 = new Rect();
        FragmentActivity r103 = this.f217292b.getActivity();
        if (r103 == null) goto L19;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L19;
        View r105 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L17:
        if (r105 == null) goto L19;
        r105.getGlobalVisibleRect(r102);
    L19:
        float r107 = (UIUtils.px2dp(this.f217291a, r101.bottom - r100.top) - 36.0f) + 8.0f;
        float r108 = UIUtils.px2dp(this.f217291a, r102.right - r101.right) - 36.0f;
        if (this.f217297g == false) goto L46;
        List<g> r109 = r111.f217286f;
        LinearLayout r112 = new LinearLayout(this.f217291a);
        r112.setOrientation(1);
        Iterator<T> r113 = r109.iterator();
    L23:
        if (r113.hasNext() == false) goto L70;
        g r114 = (g) r113.next();
        int r115 = CreationMenuPlusItem.f217269h;
        Context r116 = this.f217291a;
        String r117 = eu5.b.f474075a.getText(r114.f217326e).toString();
        int r118 = r114.f217325d;
        Intrinsics.checkNotNullParameter(r116, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r114, "menuItem");
        CreationMenuPlusItem r119 = new CreationMenuPlusItem(r116);
        if (r119.f217273d != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L27:
        if (r117 == null) goto L33;
        TextView r120 = r119.f217273d;
        if (r120 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r120 = null;
    L31:
        r120.setText(r117);
    L33:
        if (r119.f217272c != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
    L35:
        if (r118 == 0) goto L40;
        ImageView r121 = r119.f217272c;
        if (r121 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r121 = null;
    L39:
        r121.setImageResource(r118);
    L40:
        r119.f217275f = r114;
        if (r114.f217322a == true) goto L43;
    L44:
        r119.setEnabled(false);
        r119.setAlpha(0.5f);
    L45:
        r119.setWikiMenuItemClickListener(new com.bytedance.ee.bear.creationmenu.d(this));
        r112.addView(r119);
        goto L23
    L43:
        if (r114.f217323b == true) goto L45;
    L70:
        ScrollView r122 = new ScrollView(this.f217291a);
        r122.setBackgroundResource(R.drawable.ccm_feed_plus_menu_bg);
        r122.setOverScrollMode(2);
        r122.setVerticalScrollBarEnabled(false);
        r122.addView(r112, new ViewGroup.LayoutParams(-1, -2));
        UDShadowLayout r123 = new UDShadowLayout(this.f217291a);
        r123.c(R.style.UDShadow_S5);
        r123.setShadowRadius(new UDDimension.Dp(8.0f));
        r123.setOnClickListener(this.f217305o);
        Context r124 = this.f217291a;
        Intrinsics.checkNotNullParameter(r122, "<this>");
        r122.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        com.ss.android.lark.forsetiutils.b r125 = com.ss.android.lark.forsetiutils.b.f424768a;
        int r126 = r122.getMeasuredWidth();
        Context r127 = r122.getContext();
        r125.getClass();
        UDShadowLayout.LayoutParams r128 = new UDShadowLayout.LayoutParams(Math.max(UIUtils.dp2px(r124, new Size(com.ss.android.lark.forsetiutils.b.b(r126, r127), com.ss.android.lark.forsetiutils.b.b(r122.getMeasuredHeight(), r122.getContext())).getWidth()), r101.width()), -2);
        if (r108 > 0.0f) goto L73;
        r128.setMarginEnd(y9c.d.b(this.f217291a, 16.0f));
    L73:
        Unit r129 = Unit.INSTANCE;
        r123.addView(r122, r128);
        BaseDialog r130 = new BaseDialog(this.f217291a, R.style.creationMenuFeedPlusDialog);
        r130.setContentView(r123);
        r130.setCanceledOnTouchOutside(true);
        this.f217304n = r130;
        Rect r131 = new Rect(r101.left - UIUtils.dp2px(this.f217291a, 36.0f), UIUtils.dp2px(this.f217291a, r107), r101.right, r102.bottom);
        Context r132 = this.f217291a;
        Window r133 = r130.getWindow();
        WindowManager.LayoutParams r134 = r133.getAttributes();
        r134.x = r131.left;
        r134.y = r131.top;
        r134.gravity = 51;
        r133.setAttributes(r134);
        r133.setWindowAnimations(R.style.UtilsAnimBottomFade);
        r133.setDimAmount(fac.a.b(r132));
        fac.a.a(r130);
        r130.setOnCancelListener(new e(this));
        return;
    L46:
        List<? extends SelectCreationMenuItem> r135 = r111.f217287g;
        r112 = new LinearLayout(this.f217291a);
        r112.setOrientation(1);
        Iterator r136 = r135.iterator();
    L48:
        if (r136.hasNext() == false) goto L70;
        SelectCreationMenuItem r137 = (SelectCreationMenuItem) r136.next();
        int r138 = CreationMenuPlusItem.f217269h;
        Context r139 = this.f217291a;
        String r140 = r137.getType().getTag();
        CharSequence r141 = r137.f216849b;
        Intrinsics.checkNotNull(r141, "null cannot be cast to non-null type kotlin.String");
        String r142 = (String) r141;
        int r143 = r137.f216850c;
        Intrinsics.checkNotNullParameter(r139, PerfLog.PARAM_KEY_CONTEXT_ID);
        Iterator r144 = r136;
        Intrinsics.checkNotNullParameter(r140, "menuKey");
        Intrinsics.checkNotNullParameter(r137, "menuItem");
        CreationMenuPlusItem r145 = new CreationMenuPlusItem(r139);
        if (r145.f217273d != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
    L52:
        if (r142 == null) goto L58;
        TextView r146 = r145.f217273d;
        if (r146 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("mTextView");
        r146 = null;
    L56:
        r146.setText(r142);
    L58:
        if (r145.f217272c != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
    L60:
        if (r143 == 0) goto L65;
        ImageView r147 = r145.f217272c;
        if (r147 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("mImageView");
        r147 = null;
    L64:
        r147.setImageResource(r143);
    L65:
        r145.f217274e = r137;
        if (r137.f216851d == true) goto L69;
        r145.setEnabled(false);
        r145.setAlpha(0.5f);
    L69:
        r145.setMenuItemClickListener(this.f217316z);
        r112.addView(r145);
        r136 = r144;
        goto L48
    L5:
        if (r111.f217286f.isEmpty() == false) goto L8;
        hac.b.f484427a.b("CreationMenuItemView", "showPopOver()...item menuList or wikiMenuList is empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.util.ArrayList<com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, java.util.List<? extends com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r4v9, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.util.ArrayList<com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object, java.util.List<? extends com.bytedance.ee.bear.content.creation.mvp.SelectCreationMenuItem>] */
    /* JADX WARN: Type inference failed for: r5v7, types: [java.util.List] */
    @Override // com.bytedance.ee.bear.content.creation.mvp.b
    public final void o1(ArrayList<SelectCreationMenuItem> r100, ArrayList<SelectCreationMenuItem> r101) {
        com.bytedance.ee.bear.creationmenu.a r102 = this.f217301k;
        if (r102 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("newDocItem");
        r102 = null;
    L6:
        if (r100 != 0) goto L9;
        r100 = CollectionsKt.emptyList();
    L9:
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f217287g = r100;
        com.bytedance.ee.bear.creationmenu.a r103 = this.f217302l;
        if (r103 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("uploadItem");
        r103 = null;
    L13:
        if (r101 != 0) goto L16;
        r101 = CollectionsKt.emptyList();
    L16:
        r103.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r103.f217287g = r101;
        Dialog r104 = this.f217304n;
        if (r104 == null) goto L40;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L21;
    L23:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L26 Exception -> L28
    L32:
        DialogLancet.afterDialogDismiss(r104);
    L33:
        this.f217304n = null;
        View r106 = this.f217308r;
        if (r106 == null) goto L44;
        com.bytedance.ee.bear.creationmenu.a r107 = this.f217309s;
        if (r107 == null) goto L45;
        k(r106, r107);
        return;
    L45:
        return;
    L44:
        return;
    L28:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L26
        Throwable r108 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L26
        if (r108 == null) goto L32;
        com.bytedance.crash.d.d(r108, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L21:
        if (Looper.myLooper() == r105.getLooper()) goto L23;
        r105.post(DialogLancet.createDismissRunnable(r104));
        goto L33
    }

    public c(Context r100, Fragment r101, ViewGroup r102, boolean r103, h r104, boolean r105, boolean r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        Intrinsics.checkNotNullParameter(r101, "mFragment");
        Intrinsics.checkNotNullParameter(r102, "mRootView");
        Intrinsics.checkNotNullParameter(r104, "menuContext");
        this.f217291a = r100;
        this.f217292b = r101;
        this.f217293c = r102;
        this.f217294d = r103;
        this.f217295e = r105;
        this.f217296f = r106;
        this.f217297g = r107;
        hac.b.f484427a.b("CreationMenuItemView", "null() called " + this);
        this.f217305o = new ViewOnClickListenerC3096c(this);
        FragmentActivity r108 = r101.getActivity();
        Integer r109 = null;
        if (r108 == null) goto L9;
        Resources r110 = r108.getResources();
        if (r110 == null) goto L9;
        Configuration r111 = r110.getConfiguration();
        if (r111 == null) goto L9;
        Integer r112 = Integer.valueOf(r111.orientation);
    L10:
        this.f217306p = r112;
        FragmentActivity r113 = r101.getActivity();
        if (r113 == null) goto L17;
        Resources r114 = r113.getResources();
        if (r114 == null) goto L17;
        Configuration r115 = r114.getConfiguration();
        if (r115 == null) goto L17;
        r109 = Integer.valueOf(r115.screenLayout);
    L17:
        this.f217307q = r109;
        this.f217310t = r104.f496209b;
        String r116 = r104.f496208a;
        String r117 = "";
        if (r116 != null) goto L20;
        r116 = "";
    L20:
        this.f217311u = r116;
        CreateSelectResult.CREATOR.getClass();
        CreateSelectResult.a.b();
        String r118 = r104.f496215h;
        if (r118 == null) goto L24;
        r117 = r118;
    L24:
        this.f217312v = r117;
        this.f217314x = CollectionsKt.emptyList();
        this.f217315y = CollectionsKt.emptyList();
        this.f217316z = new d(this);
        this.A = new b(this);
        return;
    L9:
        r112 = null;
        goto L10
    }
}
