package com.bytedance.ee.bear.bitable.itemview.record;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.card.view.page.u;
import com.bytedance.ee.bear.bitable.cardview.widget.StickyItemViewLayout;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.bitable.databinding.BitableItemViewRecordContainer2Binding;
import com.bytedance.ee.bear.bitable.itemview.record.list.ContainerDirection;
import com.bytedance.ee.bear.bitable.itemview.record.list.HorizontalContainer;
import com.bytedance.ee.bear.bitable.itemview.record.list.ItemViewRenderItemAdapter;
import com.bytedance.ee.bear.bitable.itemview.record.list.ItemViewRenderItemData;
import com.bytedance.ee.bear.bitable.itemview.record.list.RenderItemKey;
import com.bytedance.ee.bear.bitable.itemview.record.list.RenderType;
import com.bytedance.ee.bear.bitable.itemview.recordpages.ItemViewRecordPagesData;
import com.bytedance.ee.bear.bitable.itemview.util.ItemViewTracker;
import com.bytedance.ee.bear.bitable.itemview.util.ReportEvent;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.ui.n;
import com.larksuite.component.universe_design.emptystate.UDEmptyState;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u001d\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u00101\u001a\u0002022\b\u00103\u001a\u0004\u0018\u00010\u00032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u0004\u0018\u0001072\u0006\u00103\u001a\u00020\u0003H\u0002R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020,X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00068"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordContainer2;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordContainer2Binding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableItemViewRecordContainer2Binding;", "editorScrollManager", "Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordEditorScrollManager;", "getEditorScrollManager", "()Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordEditorScrollManager;", "setEditorScrollManager", "(Lcom/bytedance/ee/bear/bitable/itemview/record/ItemViewRecordEditorScrollManager;)V", "adapter", "Lcom/bytedance/ee/bear/bitable/itemview/record/list/ItemViewRenderItemAdapter;", "getAdapter", "()Lcom/bytedance/ee/bear/bitable/itemview/record/list/ItemViewRenderItemAdapter;", "pageItemInfo", "Lcom/bytedance/ee/bear/bitable/itemview/record/PagesItemInfo;", "getPageItemInfo", "()Lcom/bytedance/ee/bear/bitable/itemview/record/PagesItemInfo;", "setPageItemInfo", "(Lcom/bytedance/ee/bear/bitable/itemview/record/PagesItemInfo;)V", "listLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "getListLayoutManager", "()Landroidx/recyclerview/widget/LinearLayoutManager;", "setListLayoutManager", "(Landroidx/recyclerview/widget/LinearLayoutManager;)V", "titleBarHeight", "Landroidx/lifecycle/MutableLiveData;", "", "getTitleBarHeight", "()Landroidx/lifecycle/MutableLiveData;", "setTitleBarHeight", "(Landroidx/lifecycle/MutableLiveData;)V", "needSetData", "", "getNeedSetData", "()Z", "setNeedSetData", "(Z)V", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "findScrollIndexInfo", "Lcom/bytedance/ee/bear/bitable/itemview/record/ScrollIndexInfo;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ItemViewRecordContainer2 extends FrameLayout implements gv4.b<ItemViewRecordData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableItemViewRecordContainer2Binding f213992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ItemViewRecordEditorScrollManager f213993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ItemViewRenderItemAdapter f213994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public j f213995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinearLayoutManager f213996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public MutableLiveData<Integer> f213997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f213998g;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordContainer2 f214000a;

        public a(ItemViewRecordContainer2 r100) {
            this.f214000a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            int r109 = r104 - r102;
            MutableLiveData<Integer> r110 = this.f214000a.getTitleBarHeight();
            if (r110 == null) goto L7;
            Integer r111 = r110.getValue();
            if (r111 == null) goto L7;
            int r112 = r111.intValue();
        L8:
            this.f214000a.getTitleBarHeight().setValue(Integer.valueOf(r109));
            if (r112 <= 0) goto L13;
            if (r112 == r109) goto L14;
            this.f214000a.getAdapter().notifyDataSetChanged();
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r112 = 0;
            goto L8
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ItemViewRecordContainer2 f214001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f214002b;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ItemViewRecordContainer2 f214003a;

            public a(ItemViewRecordContainer2 r100) {
                this.f214003a = r100;
            }

            public final void a() {
                this.f214003a.getBinding().f210879h.e();
                this.f214003a.getBinding().f210876e.a(this.f214003a.getBinding().f210878g.computeVerticalScrollOffset(), this.f214003a.getBinding().f210878g.computeVerticalScrollRange());
            }

            @Override // java.lang.Runnable
            public final void run() {
                a();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        public b(ItemViewRecordContainer2 r100, int r101) {
            this.f214001a = r100;
            this.f214002b = r101;
        }

        public final void a() {
            this.f214001a.getListLayoutManager().scrollToPositionWithOffset(this.f214002b, this.f214001a.getAdapter().U1() + n.d(40));
            this.f214001a.getBinding().f210878g.post(new a(this.f214001a));
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public final ItemViewRenderItemAdapter getAdapter() {
        return this.f213994c;
    }

    public final BitableItemViewRecordContainer2Binding getBinding() {
        return this.f213992a;
    }

    public final ItemViewRecordEditorScrollManager getEditorScrollManager() {
        return this.f213993b;
    }

    public final LinearLayoutManager getListLayoutManager() {
        return this.f213996e;
    }

    public final boolean getNeedSetData() {
        return this.f213998g;
    }

    public final j getPageItemInfo() {
        return this.f213995d;
    }

    public final MutableLiveData<Integer> getTitleBarHeight() {
        return this.f213997f;
    }

    public ItemViewRecordContainer2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setEditorScrollManager(ItemViewRecordEditorScrollManager r100) {
        this.f213993b = r100;
    }

    public final void setListLayoutManager(LinearLayoutManager r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213996e = r100;
    }

    public final void setNeedSetData(boolean r100) {
        this.f213998g = r100;
    }

    public final void setPageItemInfo(j r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213995d = r100;
    }

    public final void setTitleBarHeight(MutableLiveData<Integer> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213997f = r100;
    }

    public ItemViewRecordContainer2(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        LayoutInflater.from(r110).inflate(R.layout.bitable_item_view_record_container2, this);
        int r112 = R.id.record_empty;
        ItemViewRecordEmpty r100 = (ItemViewRecordEmpty) ViewBindings.findChildViewById(this, R.id.record_empty);
        if (r100 == null) goto L27;
        r112 = R.id.record_notice1;
        ItemViewNotice r101 = (ItemViewNotice) ViewBindings.findChildViewById(this, R.id.record_notice1);
        if (r101 == null) goto L27;
        r112 = R.id.record_notice2;
        ItemViewNotice r102 = (ItemViewNotice) ViewBindings.findChildViewById(this, R.id.record_notice2);
        if (r102 == null) goto L27;
        r112 = R.id.record_title_bar;
        ItemViewRecordTitleBarContainer r103 = (ItemViewRecordTitleBarContainer) ViewBindings.findChildViewById(this, R.id.record_title_bar);
        if (r103 == null) goto L27;
        r112 = R.id.record_title_bar_container;
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(this, R.id.record_title_bar_container);
        if (r104 == null) goto L27;
        r112 = R.id.render_list;
        RecyclerView r113 = (RecyclerView) ViewBindings.findChildViewById(this, R.id.render_list);
        if (r113 == null) goto L27;
        r112 = R.id.sticky_container;
        StickyItemViewLayout r105 = (StickyItemViewLayout) ViewBindings.findChildViewById(this, R.id.sticky_container);
        if (r105 == null) goto L27;
        BitableItemViewRecordContainer2Binding r114 = new BitableItemViewRecordContainer2Binding(this, r100, r101, r102, r103, r104, r113, r105);
        this.f213992a = r114;
        int r106 = ItemViewRecordEditorScrollManager.f214013g;
        RecyclerView r115 = r114.f210878g;
        com.bytedance.ee.bear.bitable.itemview.b r107 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        Intrinsics.checkNotNullParameter(r115, "recyclerView");
        int r108 = com.bytedance.ee.bear.bitable.c.f207079a;
        int r109 = com.bytedance.ee.bear.bitable.n.f214744a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.mobile.config_item_view.bugfix") == false) goto L19;
        ItemViewRecordEditorScrollManager r116 = new ItemViewRecordEditorScrollManager(r115, r107);
    L20:
        this.f213993b = r116;
        ItemViewRenderItemAdapter r117 = new ItemViewRenderItemAdapter(r116, ContainerDirection.VERTICAL);
        this.f213994c = r117;
        this.f213995d = new j(-1, null);
        this.f213997f = new DiffMutableLiveData();
        LinearLayoutManager r118 = new LinearLayoutManager(r110);
        this.f213996e = r118;
        r113.setLayoutManager(r118);
        r113.setAdapter(r117);
        r113.addOnScrollListener(new ItemViewRecordContainer2$1$1(this));
        r104.addOnLayoutChangeListener(new a(this));
        r117.f214114c = this.f213997f;
        com.bytedance.ee.bear.bitable.itemview.b r119 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r119 == null) goto L28;
        ItemViewTracker r120 = r119.R0();
        if (r120 == null) goto L29;
        Intrinsics.checkNotNullParameter(r113, "recyclerView");
        ((com.bytedance.ee.bear.bitable.statistic.c) r120.f214265e.getValue()).f(r113);
        return;
    L29:
        return;
    L28:
        return;
    L19:
        r116 = null;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r112)));
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
    public final void a(final ItemViewRecordData r110, gv4.a r111) {
        if (r110 == null) goto L172;
        ReportEvent r100 = r110.getRecordViewEvent();
        if (r100 == null) goto L10;
        com.bytedance.ee.bear.bitable.itemview.b r101 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r101 == null) goto L10;
        BitableAnalytic r102 = r101.q0();
        if (r102 == null) goto L10;
        r102.e(r100);
    L10:
        ItemViewRecordTitleBarContainer r103 = this.f213992a.f210876e;
        ItemViewRecordTitleBarData r104 = r110.getTitleBar();
        r104.setRecordId(r110.getId());
        r103.f214038b.f214042a = r104;
        ConstraintLayout r105 = r103.f214037a.f210936i;
        if (ku5.c.k(r103.getContext()) == false) goto L13;
    L15:
        int r106 = n.d(32);
    L16:
        m.u(r105, r106, true);
        r103.f214037a.f210935h.setText(r104.getTitle());
        r103.f214037a.f210931d.setOnClickListener(new g(r111));
        AppCompatImageView r107 = r103.f214037a.f210937j;
        if (r104.getShowAddToMainNav() != true) goto L19;
        boolean r108 = true;
    L20:
        k r109 = null;
        Integer r112 = null;
        if (r108 == false) goto L40;
        Intrinsics.checkNotNull(r107);
        com.bytedance.ee.bear.bitable.itemview.b r113 = com.bytedance.ee.bear.bitable.itemview.util.i.c(r107);
        if (r113 == null) goto L25;
        ItemViewRecordPagesData r114 = r113.Kg();
    L26:
        com.bytedance.ee.bear.bitable.itemview.record.menu.b r115 = r103.f214039c;
        if (r115 != null) goto L39;
        Context r116 = r107.getContext();
        if (r114 == null) goto L31;
        String r117 = r114.getBaseName();
    L32:
        if (r114 == null) goto L34;
        String r118 = r114.getBaseId();
    L35:
        if (r114 == null) goto L37;
        String r119 = r114.getTableId();
    L38:
        r115 = new com.bytedance.ee.bear.bitable.itemview.record.menu.b(r116, r107, r117, r118, r119);
        goto L39
    L37:
        r119 = null;
        goto L38
    L34:
        r118 = null;
        goto L35
    L31:
        r117 = null;
    L39:
        r103.f214039c = r115;
        r115.f214159d = r111;
    L41:
        FrameLayout r120 = r103.f214037a.f210933f;
        if (r104.getShareButtonIcon() == null) goto L44;
        Intrinsics.checkNotNull(r120);
        m.z(r120, true);
        com.bytedance.ee.bear.bitable.panel.e.j(r103.f214037a.f210934g, r104.getShareButtonIcon());
        r120.setOnClickListener(new h(r103, r111));
    L45:
        FrameLayout r121 = r103.f214037a.f210929b;
        if (r104.getShowSubscribeButton() != true) goto L48;
        boolean r122 = true;
    L50:
        if (r122 == false) goto L73;
        Intrinsics.checkNotNull(r121);
        m.z(r121, true);
        com.bytedance.ee.bear.bitable.itemview.b r123 = com.bytedance.ee.bear.bitable.itemview.util.i.c(r121);
        if (r123 == null) goto L74;
        com.bytedance.ee.bear.bitable.itemview.record.menu.h r124 = r123.Sm();
        if (r124 == null) goto L74;
        r103.f214040d = new u(r124, r121, r103.f214037a.f210930c);
        com.bytedance.ee.bear.bitable.itemview.b r125 = com.bytedance.ee.bear.bitable.itemview.util.i.c(r121);
        if (r125 == null) goto L58;
        ItemViewRecordPagesData r126 = r125.Kg();
    L59:
        u r127 = r103.f214040d;
        if (r127 == null) goto L62;
        r127.f208608i = r111;
    L62:
        if (r127 == null) goto L74;
        if (r126 == null) goto L67;
        String r128 = r126.getBaseId();
        if (r128 == null) goto L67;
    L68:
        if (r126 == null) goto L71;
        String r129 = r126.getTableId();
        if (r129 == null) goto L71;
    L72:
        r127.e(new com.bytedance.ee.bear.bitable.itemview.record.menu.f(r128, r129, r104.getRecordId()));
    L71:
        r129 = "";
    L67:
        r128 = "";
        goto L68
    L58:
        r126 = null;
    L74:
        FrameLayout r130 = r103.f214037a.f210932e;
        ItemViewMoreMenuData r131 = r104.getMoreMenuData();
        if (r131 == null) goto L77;
        Intrinsics.checkNotNull(r130);
        m.z(r130, true);
        r130.setOnClickListener(new i(r103, r131, r111));
    L79:
        if (r110.showEmpty() == false) goto L101;
        m.z(this.f213992a.f210873b, true);
        ItemViewRecordEmpty r132 = this.f213992a.f210873b;
        EmptyData r133 = r110.getEmptyModel();
        r132.f214023a.f210883b.setOnClickListener(new com.bytedance.ee.bear.bitable.itemview.record.b(r111));
        if (r133 != null) goto L84;
        r132.f214023a.f210884c.setImageRes(Integer.valueOf(R.drawable.bitable_permission_limited_view));
        r132.f214023a.f210884c.setTitle("");
        r132.f214023a.f210884c.setDesc(n.x(r132.getContext(), R.string.Bitable_Core_RecordDeletedOrNoPerm));
        r132.f214023a.f210884c.showPrimaryAction(false);
        r132.f214023a.f210884c.showSecondaryAction(false);
    L100:
        m.z(this.f213992a.f210879h, false);
        return;
    L84:
        if (r133.getIcon() == null) goto L89;
        m.z(r132.f214023a.f210884c, true);
        UDEmptyState r134 = r132.f214023a.f210884c;
        Icon r135 = r133.getIcon();
        if (r135 == null) goto L88;
        r112 = r135.getImgRes(r132.getContext());
    L88:
        r134.setImageRes(r112);
    L89:
        r132.f214023a.f210884c.setTitle(r133.getTitle());
        UDEmptyState r136 = r132.f214023a.f210884c;
        CharSequence r137 = r133.getTextEx();
        if (r137 != null) goto L92;
        r137 = r133.getText();
    L92:
        r136.setDesc(r137);
        SimpleItemModel r138 = r133.getButton();
        if (r138 == null) goto L95;
        UDEmptyState r139 = r132.f214023a.f210884c;
        r139.showPrimaryAction(true);
        r139.setPrimaryText(r138.getText());
        r139.setPrimaryClickListener(new c(r138, r111));
    L96:
        SimpleItemModel r140 = r133.getSecondaryButton();
        if (r140 == null) goto L99;
        UDEmptyState r141 = r132.f214023a.f210884c;
        r141.showSecondaryAction(true);
        r141.setSecondaryText(r140.getText());
        r141.setSecondaryClickListener(new d(r140, r111));
        goto L100
    L99:
        r132.f214023a.f210884c.showSecondaryAction(false);
        Unit r142 = Unit.INSTANCE;
        goto L100
    L95:
        r132.f214023a.f210884c.showPrimaryAction(false);
        Unit r143 = Unit.INSTANCE;
        goto L96
    L101:
        m.z(this.f213992a.f210873b, false);
        m.z(this.f213992a.f210879h, true);
        this.f213992a.f210874c.o6(r110.getNotice1(), r111);
        this.f213992a.f210875d.o6(r110.getNotice2(), r111);
        if (this.f213992a.f210877f.getMeasuredHeight() != 0) goto L104;
        this.f213992a.f210877f.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    L104:
        this.f213997f.setValue(Integer.valueOf(this.f213992a.f210877f.getMeasuredHeight()));
        this.f213992a.f210879h.e();
        String r144 = r110.getScrollRenderId();
        r110.setScrollRenderId(null);
        if (r144 != null) goto L107;
    L110:
        boolean r145 = true;
    L111:
        int r146 = -1;
        if (r145 == true) goto L147;
        Iterator<RenderItemKey> r147 = r110.getRenderList().iterator();
        int r148 = -1;
        int r149 = 0;
    L116:
        if (r147.hasNext() == false) goto L145;
        RenderItemKey r150 = r147.next();
        if (r150.getRenderType() != RenderType.HorizontalContainer) goto L141;
        ItemViewRenderItemData<Object> r151 = r110.getRenderDataMap().get(r150.getRenderId());
        if ((r151 instanceof ItemViewRenderItemData) == false) goto L122;
        ItemViewRenderItemData<Object> r152 = r151;
    L123:
        if (r152 == null) goto L135;
        HorizontalContainer r153 = (HorizontalContainer) r152.getValue();
        if (r153 == null) goto L135;
        ArrayList<RenderItemKey> r154 = r153.getRenderList();
        if (r154 == null) goto L135;
        Iterator<RenderItemKey> r155 = r154.iterator();
        int r156 = 0;
    L130:
        if (r155.hasNext() == false) goto L135;
        if (Intrinsics.areEqual(r155.next().getRenderId(), r144) == true) goto L136;
        r156 = r156 + 1;
    L136:
        if (r156 < 0) goto L138;
        boolean r157 = true;
    L139:
        if (r157 == false) goto L142;
        r148 = r156;
    L142:
        if (r157 == true) goto L146;
        r149 = r149 + 1;
    L146:
        r109 = new k(r149, r148);
        goto L147
    L138:
        r157 = false;
    L135:
        r156 = -1;
        goto L136
    L122:
        r152 = null;
        goto L123
    L141:
        r157 = Intrinsics.areEqual(r150.getRenderId(), r144);
        goto L142
    L145:
        r149 = -1;
    L147:
        ItemViewRenderItemAdapter r158 = this.f213994c;
        com.bytedance.ee.bear.bitable.itemview.record.list.d r159 = new com.bytedance.ee.bear.bitable.itemview.record.list.d();
        r159.a(r110, r109, r111);
        r159.f214146h = this.f213997f;
        r158.z2(r159);
        if (this.f213992a.f210878g.getItemDecorationCount() <= 0) goto L150;
        this.f213992a.f210878g.removeItemDecorationAt(0);
    L150:
        this.f213992a.f210878g.addItemDecoration(new MultiItemBackgroundDecoration(r110.getRenderList(), new ItemViewRecordContainer2$setData$1$4(r110)));
        if (r109 == null) goto L174;
        int r160 = r109.f214077a;
        Iterator<RenderItemKey> r161 = r110.getRenderList().iterator();
        int r162 = 0;
    L154:
        if (r161.hasNext() == false) goto L162;
        if (r161.next().getRenderType() != RenderType.Field) goto L158;
        boolean r163 = true;
    L159:
        if (r163 == true) goto L160;
        r162 = r162 + 1;
        goto L154
    L160:
        r146 = r162;
        goto L162
    L158:
        r163 = false;
    L162:
        if (r160 <= 0) goto L175;
        if (r160 == r146) goto L176;
        this.f213992a.f210878g.post(new b(this, r160));
        return;
    L176:
        return;
    L175:
        return;
    L174:
        return;
    L107:
        if (r144.length() == 0) goto L110;
        r145 = false;
        goto L111
    L77:
        Intrinsics.checkNotNull(r130);
        m.z(r130, false);
        goto L79
    L73:
        Intrinsics.checkNotNull(r121);
        m.z(r121, false);
        goto L74
    L48:
        r122 = false;
        goto L50
    L44:
        Intrinsics.checkNotNull(r120);
        m.z(r120, false);
        goto L45
    L25:
        r114 = null;
        goto L26
    L40:
        Intrinsics.checkNotNull(r107);
        m.z(r107, false);
        goto L41
    L19:
        r108 = false;
        goto L20
    L13:
        if (com.bytedance.ee.bear.bitable.itemview.util.i.e(r103) == false) goto L15;
        r106 = 0;
        goto L16
    }
}
