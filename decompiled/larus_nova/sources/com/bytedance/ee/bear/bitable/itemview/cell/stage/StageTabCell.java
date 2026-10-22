package com.bytedance.ee.bear.bitable.itemview.cell.stage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.model.stmodel.field.StageType;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepAdapter;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepItemDecoration;
import com.bytedance.ee.bear.bitable.card.view.stage.step.StageDataStepLayoutManager;
import com.bytedance.ee.bear.bitable.common.model.field.OriginStageOptionItem;
import com.bytedance.ee.bear.bitable.common.widgets.common.RingView;
import com.bytedance.ee.bear.bitable.databinding.BitableStageFieldDataLayoutBinding;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.util.ui.ColorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.larksuite.component.universe_design.notice.UDNotice;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 >2\u00020\u00012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00022\u00020\u0005:\u0001>B\u001d\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ&\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00032\b\u0010%\u001a\u0004\u0018\u00010\u00042\b\u0010&\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J(\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020+H\u0002J&\u00101\u001a\u00020#2\f\u00102\u001a\b\u0012\u0004\u0012\u00020)032\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u000200H\u0002J\u0010\u00106\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0002J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000200H\u0016J\u0018\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020<R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabCell;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemCellData;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemRenderData;", "Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageStepDep;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableStageFieldDataLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableStageFieldDataLayoutBinding;", "mData", "getMData", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemCellData;", "setMData", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemCellData;)V", "mExtra", "getMExtra", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemRenderData;", "setMExtra", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageTabItemRenderData;)V", "mHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getMHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setMHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "stepAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/stage/step/StageDataStepAdapter;", "setData", "", "data", "extra", "handler", "updateNotice", "option", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/StageOptionItem;", "isEditable", "", "updateViewStep", "viewOption", "dataOption", "diff", "", "updateStepList", "options", "", "stepDataIndex", "stepViewIndex", "markStepDone", "updateViewSelectStageIndex", "index", "getStageAction", "Lcom/bytedance/ee/bear/bitable/itemview/cell/stage/StageActionPayload;", "action", "", "optionId", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class StageTabCell extends FrameLayout implements lq4.b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f213955f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableStageFieldDataLayoutBinding f213956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public StageTabItemCellData f213957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public StageTabItemRenderData f213958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public gv4.a f213959d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final StageDataStepAdapter f213960e;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> f213961a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StageTabCell f213962b;

        public b(List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r100, StageTabCell r101) {
            this.f213961a = r100;
            this.f213962b = r101;
        }

        public final void a() {
            List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r100 = this.f213961a;
            if (r100 == null) goto L27;
            Iterator<T> r101 = r100.iterator();
        L6:
            if (r101.hasNext() == false) goto L13;
            Object r102 = r101.next();
            if (((com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) r102).getType() != StageType.EndCancel) goto L10;
            boolean r103 = true;
        L11:
            if (r103 == false) goto L6;
        L14:
            com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r104 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) r102;
            if (r104 == null) goto L28;
            StageTabCell r105 = this.f213962b;
            StageActionPayload r106 = r105.b("ItemViewStageCancelAction", r104.f207141a);
            if (r106 == null) goto L29;
            gv4.a r107 = r105.getMHandler();
            if (r107 == null) goto L30;
            r107.a(r106);
            return;
        L30:
            return;
        L29:
            return;
        L28:
            return;
        L10:
            r103 = false;
            goto L11
        L13:
            r102 = null;
            goto L14
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

    static {
    }

    public final BitableStageFieldDataLayoutBinding getBinding() {
        return this.f213956a;
    }

    public final StageTabItemCellData getMData() {
        return this.f213957b;
    }

    public final StageTabItemRenderData getMExtra() {
        return this.f213958c;
    }

    public final gv4.a getMHandler() {
        return this.f213959d;
    }

    public StageTabCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // lq4.b
    public final void h(int r100) {
        StageTabItemRenderData r101 = this.f213958c;
        if (r101 == null) goto L20;
        ActionPayload r102 = r101.getSwitchPayload();
        if (r102 == null) goto L14;
        StageTabItemCellData r103 = this.f213957b;
        String r104 = null;
        if (r103 == null) goto L13;
        ArrayList<OriginStageOptionItem> r105 = r103.getStages();
        if (r105 == null) goto L13;
        OriginStageOptionItem r106 = (OriginStageOptionItem) com.bytedance.ee.bear.bitable.m.j(r105, r100, null);
        if (r106 == null) goto L13;
        r104 = r106.getId();
    L13:
        r102.setId(r104);
    L14:
        ActionPayload r107 = r101.getSwitchPayload();
        if (r107 == null) goto L21;
        gv4.a r108 = this.f213959d;
        if (r108 == null) goto L22;
        r108.a(r107);
        return;
    L22:
        return;
    L21:
        return;
    }

    public final void setMData(StageTabItemCellData r100) {
        this.f213957b = r100;
    }

    public final void setMExtra(StageTabItemRenderData r100) {
        this.f213958c = r100;
    }

    public final void setMHandler(gv4.a r100) {
        this.f213959d = r100;
    }

    public StageTabCell(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        View r100 = LayoutInflater.from(r110).inflate(R.layout.bitable_stage_field_data_layout, this, false);
        addView(r100);
        int r101 = R.id.currentButton;
        UDButton r102 = (UDButton) ViewBindings.findChildViewById(r100, R.id.currentButton);
        if (r102 == null) goto L23;
        r101 = R.id.currentNameTV;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.currentNameTV);
        if (r103 == null) goto L23;
        r101 = R.id.currentStateAction;
        AppCompatImageView r104 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.currentStateAction);
        if (r104 == null) goto L23;
        r101 = R.id.currentStateIcon;
        AppCompatImageView r112 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.currentStateIcon);
        if (r112 == null) goto L23;
        r101 = R.id.currentStateTv;
        TextView r113 = (TextView) ViewBindings.findChildViewById(r100, R.id.currentStateTv);
        if (r113 == null) goto L23;
        r101 = R.id.currentStepRingView;
        RingView r114 = (RingView) ViewBindings.findChildViewById(r100, R.id.currentStepRingView);
        if (r114 == null) goto L23;
        r101 = R.id.notice;
        UDNotice r115 = (UDNotice) ViewBindings.findChildViewById(r100, R.id.notice);
        if (r115 == null) goto L23;
        r101 = R.id.stepMoreIcon;
        AppCompatImageView r105 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.stepMoreIcon);
        if (r105 == null) goto L23;
        r101 = R.id.stepRecyclerView;
        RecyclerView r116 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.stepRecyclerView);
        if (r116 == null) goto L23;
        this.f213956a = new BitableStageFieldDataLayoutBinding((LinearLayout) r100, r102, r103, r104, r112, r113, r114, r115, r105, r116);
        StageDataStepAdapter r106 = new StageDataStepAdapter(this);
        this.f213960e = r106;
        Intrinsics.checkNotNullParameter(r105, "stepMoreIcon");
        r105.post(new com.bytedance.ee.bear.bitable.itemview.util.h(r105, null));
        r116.setLayoutManager(new StageDataStepLayoutManager(r110));
        r116.setAdapter(r106);
        r116.addItemDecoration(new StageDataStepItemDecoration());
        return;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    public final StageActionPayload b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "optionId");
        StageTabItemRenderData r102 = this.f213958c;
        if (r102 == null) goto L8;
        StageActionPayload r103 = r102.getPayload();
        if (r103 == null) goto L10;
        StageActionPayload r104 = new StageActionPayload();
        r104.setAction(r100);
        r104.setStackIdentify(r103.getStackIdentify());
        r104.setTableId(r103.getTableId());
        r104.setViewId(r103.getViewId());
        r104.setRecordId(r103.getRecordId());
        r104.setFieldId(r103.getFieldId());
        r104.setExtra(new StageExtra(r101));
        return r104;
    L10:
        return null;
    L8:
        return null;
    }

    /* JADX WARN: Type inference failed for: r3v30, types: [T, com.larksuite.component.universe_design.menu.c] */
    public final void d(StageTabItemCellData r110, StageTabItemRenderData r111, gv4.a r112) {
        if (r110 == null) goto L91;
        this.f213957b = r110;
        this.f213958c = r111;
        this.f213959d = r112;
        int r100 = r110.currentDataIndex();
        if (r111 == null) goto L7;
        Integer r101 = Integer.valueOf(r111.currentViewIndex(r110.getStages()));
    L8:
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r102 = r110.getStageItemList();
        if (r101 == null) goto L86;
        List<com.bytedance.ee.bear.bitable.card.model.stmodel.field.d> r103 = r102;
        if (r103 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == true) goto L86;
        if (r100 < 0) goto L86;
        if (r101.intValue() < 0) goto L86;
        if (r100 >= r102.size()) goto L86;
        if (r101.intValue() >= r102.size()) goto L86;
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r105 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) ListProtector.get(r102, r100);
        com.bytedance.ee.bear.bitable.card.model.stmodel.field.d r113 = (com.bytedance.ee.bear.bitable.card.model.stmodel.field.d) ListProtector.get(r102, r101.intValue());
        AppCompatImageView r114 = this.f213956a.f211040i;
        boolean r115 = r110.getEditable();
        b r116 = new b(r102, this);
        Intrinsics.checkNotNullParameter(this, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r114, "stepMoreIcon");
        Intrinsics.checkNotNullParameter(r105, "option");
        Intrinsics.checkNotNullParameter(r116, "markStageCanceled");
        StageType r117 = r105.getType();
        StageType r106 = StageType.EndCancel;
        if (r117 == r106) goto L31;
        if (r115 == false) goto L31;
        r114.setVisibility(0);
        View r118 = LayoutInflater.from(r114.getContext()).inflate(R.layout.bitable_stage_step_menu_more, this, false);
        com.larksuite.component.universe_design.menu.c.e r119 = new com.larksuite.component.universe_design.menu.c.e();
        r119.f(r118);
        r119.b(PositionAlign.END);
        r119.e();
        r119.d(new f());
        com.larksuite.component.universe_design.menu.c r120 = r119.a();
        r118.findViewById(R.id.item_end).setOnClickListener(new d(r120, r114, r116));
        r114.setOnClickListener(new e(r118, r120, r114));
    L32:
        boolean r107 = r110.getEditable();
        if (r105.getType() != r106) goto L38;
        com.bytedance.ee.bear.bitable.m.z(this.f213956a.f211039h, true);
        if (r107 == false) goto L37;
        this.f213956a.f211039h.setText(R.string.Bitable_Flow_RecordCard_FlowEnd_Tooltip);
        this.f213956a.f211039h.k6(true);
        this.f213956a.f211039h.setTextButtonListener(new h(this, r105));
    L39:
        this.f213960e.y2(r102, r100, r101.intValue());
        int r108 = r101.intValue() - r100;
        boolean r109 = r110.getEditable();
        if (r113.getType() == StageType.Default) goto L42;
        tt5.a.d("StageTabCell", "initCurrentSelectStep option type not default: " + r113.getType());
    L82:
        String r121 = r111.getCurrentButtonColor();
        if (r121 == null) goto L85;
        this.f213956a.f211033b.setBackgroundColor(ColorUtils.h(r121));
        return;
    L85:
        this.f213956a.f211033b.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.ud_button_blue_bg));
        return;
    L42:
        StageTabItemCellData r122 = this.f213957b;
        if (r122 == null) goto L58;
        ArrayList<OriginStageOptionItem> r123 = r122.getStages();
        if (r123 == null) goto L58;
        Iterator<T> r124 = r123.iterator();
    L48:
        if (r124.hasNext() == false) goto L52;
        Object r125 = r124.next();
        if (Intrinsics.areEqual(((OriginStageOptionItem) r125).getId(), r113.f207141a) == false) goto L48;
    L53:
        OriginStageOptionItem r126 = (OriginStageOptionItem) r125;
        if (r126 == null) goto L58;
        Boolean r127 = r126.getCanConvert();
        if (r127 == null) goto L58;
        boolean r128 = r127.booleanValue();
    L59:
        this.f213956a.f211034c.setText(r113.f207142b);
        if (r105.getType() != StageType.EndCancel) goto L62;
        this.f213956a.f211038g.a(UIHelper.getColor(R.color.ud_N500), UIHelper.getColor(R.color.ud_N350));
        this.f213956a.f211033b.setVisibility(8);
        this.f213956a.f211036e.setVisibility(8);
        this.f213956a.f211037f.setVisibility(8);
        this.f213956a.f211035d.setVisibility(8);
        goto L82
    L62:
        if (r108 != 0) goto L68;
        this.f213956a.f211038g.a(UIHelper.getColor(R.color.ud_O350), UIHelper.getColor(R.color.ud_O200));
        if (r128 == false) goto L67;
        if (r109 == false) goto L67;
        this.f213956a.f211033b.setVisibility(0);
        this.f213956a.f211036e.setVisibility(8);
        this.f213956a.f211037f.setVisibility(8);
        this.f213956a.f211035d.setVisibility(8);
        this.f213956a.f211033b.setOnClickListener(new i(this, r113));
    L67:
        this.f213956a.f211033b.setVisibility(8);
        this.f213956a.f211036e.setVisibility(0);
        this.f213956a.f211037f.setVisibility(0);
        this.f213956a.f211035d.setVisibility(8);
        AppCompatImageView r129 = this.f213956a.f211036e;
        int r130 = UIHelper.getColor(R.color.ud_O350);
        float r131 = UIHelper.dp2px(1.0f);
        r129.setImageDrawable(new a18.a(new z08.b(1, UIHelper.dp2px(2.0f), UIHelper.getColor(R.color.ud_border_color), r130, r131, 80, UIHelper.dp2px(14.0f))));
        this.f213956a.f211037f.setText(R.string.Bitable_Flow_RecordCard_InProgress_Text);
        this.f213956a.f211037f.setTextColor(UIHelper.getColor(R.color.ud_O350));
        this.f213956a.f211037f.setOnClickListener(new j());
        goto L82
    L68:
        if (r108 <= 0) goto L74;
        this.f213956a.f211038g.a(UIHelper.getColor(R.color.ud_N500), UIHelper.getColor(R.color.ud_N350));
        if (r128 == false) goto L73;
        if (r109 == false) goto L73;
        this.f213956a.f211033b.setVisibility(0);
        this.f213956a.f211036e.setVisibility(8);
        this.f213956a.f211037f.setVisibility(8);
        this.f213956a.f211035d.setVisibility(8);
        this.f213956a.f211033b.setOnClickListener(new k(this, r113));
    L73:
        this.f213956a.f211033b.setVisibility(8);
        this.f213956a.f211036e.setVisibility(0);
        this.f213956a.f211037f.setVisibility(0);
        this.f213956a.f211035d.setVisibility(8);
        this.f213956a.f211036e.setImageResource(R.drawable.ud_icon_time_outlined);
        this.f213956a.f211036e.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.icon_n3)));
        this.f213956a.f211037f.setText(R.string.Bitable_Flow_RecordCard_NotStarted_Text);
        this.f213956a.f211037f.setTextColor(UIHelper.getColor(R.color.icon_n3));
        this.f213956a.f211037f.setOnClickListener(new l());
        goto L82
    L74:
        this.f213956a.f211038g.a(UIHelper.getColor(R.color.ud_G500), UIHelper.getColor(R.color.ud_G300));
        this.f213956a.f211033b.setVisibility(8);
        this.f213956a.f211036e.setVisibility(0);
        this.f213956a.f211037f.setVisibility(0);
        AppCompatImageView r132 = this.f213956a.f211035d;
        if (r109 == false) goto L77;
        int r133 = 0;
    L78:
        r132.setVisibility(r133);
        this.f213956a.f211036e.setImageResource(R.drawable.ud_icon_yes_filled);
        this.f213956a.f211036e.setImageTintList(ColorStateList.valueOf(UIHelper.getColor(R.color.ud_G400)));
        this.f213956a.f211037f.setText(R.string.Bitable_Flow_RecordCard_Done_Text);
        this.f213956a.f211037f.setTextColor(UIHelper.getColor(R.color.ud_G400));
        this.f213956a.f211037f.setOnClickListener(null);
        if (r109 == false) goto L81;
        AppCompatImageView r134 = this.f213956a.f211035d;
        m r135 = new m(this, r113);
        Intrinsics.checkNotNullParameter(r134, "currentStateAction");
        Intrinsics.checkNotNullParameter(r113, "viewOption");
        Intrinsics.checkNotNullParameter(r135, "revertStep");
        Ref.ObjectRef r136 = new Ref.ObjectRef();
        com.larksuite.component.universe_design.menu.c.f r137 = new com.larksuite.component.universe_design.menu.c.f();
        r137.f(CollectionsKt.listOf(new com.bytedance.ee.bear.bitable.itemview.cell.stage.b(r136, r134, r113, r135)));
        r137.b(PositionAlign.END);
        r137.e();
        r136.element = r137.a();
        r134.setOnClickListener(new c(r136));
        goto L82
    L81:
        this.f213956a.f211035d.setOnClickListener(null);
        goto L82
    L77:
        r133 = 8;
        goto L78
    L52:
        r125 = null;
    L58:
        r128 = false;
        goto L59
    L37:
        this.f213956a.f211039h.k6(false);
        goto L39
    L38:
        com.bytedance.ee.bear.bitable.m.z(this.f213956a.f211039h, false);
    L31:
        r114.setVisibility(8);
        goto L32
    L13:
        if (r103.isEmpty() == true) goto L16;
        r104 = false;
    L86:
        tt5.a.d("StageTabCell", "index invalid data:" + r100 + " view:" + r101);
        return;
    L7:
        r101 = null;
        goto L8
    }
}
