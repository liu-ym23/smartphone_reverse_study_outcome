package com.larus.bmhome.view.actionbar.custom.actionbarpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.MaxHeightRecyclerView;
import com.larus.input.impl.databinding.LarusLayoutActionBarPanelBinding;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import vs8.b;
import vs8.c;
import vs8.d;
import wa8.n1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\n\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010\"\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000bH\u0002J\u0010\u0010&\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010'\u001a\u00020(H\u0016R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000b@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/CustomActionBarPanel;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/actionbar/model/ICustomActionbarOperator;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/input/impl/databinding/LarusLayoutActionBarPanelBinding;", "callback", "Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/ActionBarPanelCallback;", "itemTouchHelperCallback", "Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/ItemDragHelperCallback;", "actualWidth", "itemWidth", "currentAdapter", "Lcom/larus/bmhome/view/actionbar/custom/actionbarpanel/CustomActionBarPanelAdapter;", "value", "spanCount", "getSpanCount", "()I", "init", "", "layoutListener", "Landroid/view/View$OnLayoutChangeListener;", "initRecyclerView", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "bindAdapter", "adapter", "updateSpanCount", "it", "setCallback", "getView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomActionBarPanel extends LinearLayout implements n1 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f315830i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusLayoutActionBarPanelBinding f315831a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public vs8.a f315832b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ItemDragHelperCallback f315833c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f315834d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f315835e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public d f315836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f315837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final a f315838h;

    public static final class a implements View.OnLayoutChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CustomActionBarPanel f315839a;

        public a(CustomActionBarPanel r100) {
            this.f315839a = r100;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
            CustomActionBarPanel r109 = this.f315839a;
            int r110 = r103 - r101;
            r109.f315834d = r110;
            if (r110 <= 0) goto L19;
            r109.f315837g = (int) Math.rint(((r110 - c7.b(12)) * 1.0f) / c7.b(110));
            CustomActionBarPanel r111 = this.f315839a;
            LarusLayoutActionBarPanelBinding r112 = r111.f315831a;
            if (r112 == null) goto L9;
            MaxHeightRecyclerView r113 = r112.f351487d;
            if (r113 == null) goto L9;
            r113.setLayoutManager(new GridLayoutManager(r111.getContext(), this.f315839a.getSpanCount()));
        L9:
            CustomActionBarPanel r114 = this.f315839a;
            r114.f315835e = (r114.f315834d - (c7.b(Integer.valueOf(r114.getSpanCount() + 1)) * 12)) / this.f315839a.getSpanCount();
            LarusLayoutActionBarPanelBinding r115 = this.f315839a.f315831a;
            if (r115 == null) goto L14;
            MaxHeightRecyclerView r116 = r115.f351487d;
            if (r116 == null) goto L14;
            r116.addItemDecoration(new ActionBarGridSpacingItemDecoration(c7.b(12), c7.b(10), c7.b(12)));
        L14:
            CustomActionBarPanel r117 = this.f315839a;
            d r118 = r117.f315836f;
            if (r118 == null) goto L17;
            r118.I0(r117.f315835e);
            r117.a(r118);
        L17:
            this.f315839a.removeOnLayoutChangeListener(this);
            return;
        }
    }

    @Override // wa8.n1
    public View getView() {
        return this;
    }

    @Override // wa8.n1
    public RecyclerView getRecyclerView() {
        LarusLayoutActionBarPanelBinding r100 = this.f315831a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f351487d;
    }

    @Override // wa8.n1
    public int getSpanCount() {
        return this.f315837g;
    }

    public CustomActionBarPanel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f315834d = -1;
        this.f315835e = -1;
        this.f315837g = 3;
        this.f315838h = new a(this);
        b(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [vs8.c] */
    @Override // wa8.n1
    public final void a(final d r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        if (this.f315834d <= 0) goto L25;
        r100.r0(new c(this, r100));
        c(r100, r100.f0());
        int r101 = this.f315835e;
        if (r101 <= 0) goto L7;
        r100.I0(r101);
    L7:
        LarusLayoutActionBarPanelBinding r102 = this.f315831a;
        if (r102 == null) goto L12;
        MaxHeightRecyclerView r103 = r102.f351487d;
        if (r103 == null) goto L12;
        r103.setAdapter(r100.e());
    L12:
        LarusLayoutActionBarPanelBinding r104 = this.f315831a;
        ItemDragHelperCallback r105 = null;
        if (r104 == null) goto L20;
        MaxHeightRecyclerView r106 = r104.f351487d;
        if (r106 == null) goto L20;
        ItemDragHelperCallback r107 = this.f315833c;
        if (r107 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelperCallback");
        r107 = null;
    L19:
        new ItemTouchHelper(r107).attachToRecyclerView(r106);
    L20:
        ItemDragHelperCallback r108 = this.f315833c;
        if (r108 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelperCallback");
    L24:
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "itemDragHelper");
        r105.f315847a = r100;
        return;
    L23:
        r105 = r108;
        goto L24
    L25:
        this.f315836f = r100;
    }

    public final void b(Context r100) {
        setOrientation(1);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_action_bar_panel, this);
        int r101 = R.id.action_bar_panel_click_area;
        View r102 = ViewBindings.findChildViewById(this, R.id.action_bar_panel_click_area);
        if (r102 == null) goto L35;
        r101 = R.id.action_bar_panel_close;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.action_bar_panel_close)) == null) goto L35;
        r101 = R.id.action_bar_panel_sub_title;
        AppCompatTextView r103 = (AppCompatTextView) ViewBindings.findChildViewById(this, R.id.action_bar_panel_sub_title);
        if (r103 == null) goto L35;
        r101 = R.id.action_bar_panel_title;
        if (((AppCompatTextView) ViewBindings.findChildViewById(this, R.id.action_bar_panel_title)) == null) goto L35;
        r101 = R.id.iv_ic_skills;
        if (((AppCompatImageView) ViewBindings.findChildViewById(this, R.id.iv_ic_skills)) == null) goto L35;
        r101 = R.id.recycler_view_action_bar_panel;
        MaxHeightRecyclerView r104 = (MaxHeightRecyclerView) ViewBindings.findChildViewById(this, R.id.recycler_view_action_bar_panel);
        if (r104 == null) goto L35;
        r101 = R.id.title_container;
        if (((ConstraintLayout) ViewBindings.findChildViewById(this, R.id.title_container)) == null) goto L35;
        this.f315831a = new LarusLayoutActionBarPanelBinding(this, r102, r103, r104);
        z2 r105 = z2.f365865a;
        if (r105.getActionBarEntryConfig().f500097b == true) goto L23;
        LarusLayoutActionBarPanelBinding r106 = this.f315831a;
        if (r106 == null) goto L23;
        AppCompatTextView r107 = r106.f351486c;
        if (r107 == null) goto L23;
        e1.o(r107);
    L23:
        setBackgroundResource(v19.c.b(R.attr.larus_bg_instruction_editor_area, r100, R.drawable.larus_bg_instruction_editor_area));
        addOnLayoutChangeListener(this.f315838h);
        LarusLayoutActionBarPanelBinding r108 = this.f315831a;
        if (r108 == null) goto L28;
        MaxHeightRecyclerView r109 = r108.f351487d;
        if (r109 == null) goto L28;
        r109.setMaxHeight(c7.b(Integer.valueOf(r105.X0())));
        this.f315833c = new ItemDragHelperCallback(r109);
    L28:
        LarusLayoutActionBarPanelBinding r110 = this.f315831a;
        if (r110 == null) goto L31;
        View r111 = r110.f351485b;
    L32:
        e1.d(r111, new b(this));
        return;
    L31:
        r111 = null;
    L35:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r101)));
    }

    @Override // wa8.n1
    public void setCallback(vs8.a r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        this.f315832b = r100;
        ItemDragHelperCallback r101 = this.f315833c;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelperCallback");
        r101 = null;
    L5:
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "callback");
        r101.f315848b = r100;
    }

    public CustomActionBarPanel(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f315834d = -1;
        this.f315835e = -1;
        this.f315837g = 3;
        this.f315838h = new a(this);
        b(r100);
    }

    public final void c(d r100, int r101) {
        int r102 = (int) Math.rint(((this.f315834d - c7.b(12)) * 1.0f) / (c7.b(110) + r101));
        if (r102 == getSpanCount()) goto L17;
        FLogger.f375446a.i("CustomActionBarPanel", "updateSpanCount: " + r102 + ", preCount:" + getSpanCount() + ", addMoreWidth:" + r101);
        this.f315837g = r102;
        this.f315835e = (this.f315834d - (c7.b(Integer.valueOf(getSpanCount() + 1)) * 12)) / getSpanCount();
        LarusLayoutActionBarPanelBinding r103 = this.f315831a;
        GridLayoutManager r104 = null;
        if (r103 == null) goto L9;
        MaxHeightRecyclerView r105 = r103.f351487d;
        if (r105 == null) goto L9;
        RecyclerView.LayoutManager r106 = r105.getLayoutManager();
    L11:
        if ((r106 instanceof GridLayoutManager) == false) goto L13;
        r104 = (GridLayoutManager) r106;
    L13:
        if (r104 == null) goto L15;
        r104.setSpanCount(getSpanCount());
    L15:
        r100.I0(this.f315835e);
        return;
    L9:
        r106 = null;
        goto L11
    }

    public CustomActionBarPanel(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f315834d = -1;
        this.f315835e = -1;
        this.f315837g = 3;
        this.f315838h = new a(this);
        b(r100);
    }
}
