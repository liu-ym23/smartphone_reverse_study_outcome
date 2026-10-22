package com.bytedance.ee.bear.bitable.card.view.cell.select;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.SafeFlexboxLayoutManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\bH\u0016J\b\u0010\u001d\u001a\u00020\u0011H\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\bH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020$H\u0016J\u0012\u0010%\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\fH\u0016J\u0016\u0010'\u001a\u00020\u00192\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010)J\u0010\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010\u000fJ\u000e\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020\"J\u000e\u0010.\u001a\u00020\u00192\u0006\u0010/\u001a\u00020$J\u0010\u00100\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u000101R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseRecordSelectView;", "Landroid/widget/RelativeLayout;", "Lcom/bytedance/ee/bear/bitable/card/view/IBindPermissionChecker;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mChecker", "Lcom/bytedance/ee/bear/bitable/card/view/cell/IPermissionCopyChecker;", "flexView", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexView;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/field/OptionField$OptionEntity;", "mAdapter", "Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "getMAdapter", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/select/BaseFlexSelectAdapter;", "recyclerView", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "getRecyclerView", "()Lcom/bytedance/ee/bear/bitable/common/widgets/flex/InnerRecyclerView;", "setOptionOnClickListener", "", "listener", "Lcom/bytedance/ee/bear/widgets/SafeClickListener;", "getLayoutId", "getFlexAdapter", "setDropTriangleVisibility", RemoteMessageConst.Notification.VISIBILITY, "setDropTriangleSelected", "selected", "", "getItemWidthMargin", "", "setIPermissionCopyChecker", "checker", "setData", "optionList", "", "getItemWidth", "option", "updateWidth", "needFullWidth", "limitVisibleLine", GXTemplateKey.STYLE_FONT_LINES, "injectClickListener", "Landroid/view/View$OnClickListener;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BaseRecordSelectView extends RelativeLayout implements gp4.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public hp4.v f208040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f208041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseFlexSelectAdapter f208042c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InnerRecyclerView f208043d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BaseRecordSelectView f208044a;

        public a(BaseRecordSelectView r100) {
            this.f208044a = r100;
        }
    }

    public BaseRecordSelectView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public BaseRecordSelectView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public float getItemWidthMargin() {
        return 0.0f;
    }

    public int getLayoutId() {
        return R.layout.bitable_card_multiselect_layout_v2;
    }

    public void setDropTriangleSelected(boolean r100) {
    }

    public void setDropTriangleVisibility(int r100) {
    }

    public BaseFlexSelectAdapter getFlexAdapter() {
        if (com.bytedance.ee.bear.bitable.c.B() == false) goto L6;
        return new BaseFlexSelectAdapterV2();
    L6:
        return new BaseFlexSelectAdapter(R.layout.bitable_card_multiselect_cell_item_v2);
    }

    public final BaseFlexSelectAdapter getMAdapter() {
        return this.f208042c;
    }

    public final InnerRecyclerView getRecyclerView() {
        return this.f208043d;
    }

    public final void a(boolean r100) {
        this.f208042c.f208035e = r100;
        ViewGroup.LayoutParams r101 = this.f208043d.getLayoutParams();
        if (r100 == false) goto L5;
        int r102 = -1;
    L6:
        r101.width = r102;
        return;
    L5:
        r102 = -2;
        goto L6
    }

    public final void setData(List<? extends com.bytedance.ee.bear.bitable.card.model.stmodel.field.a.C2987a> r100) {
        a r101 = this.f208041b;
        hp4.v r102 = this.f208040a;
        r101.f208044a.getMAdapter().I2(r102);
        r101.f208044a.getMAdapter().setNewData(r100);
    }

    @Override // gp4.g
    public void setIPermissionCopyChecker(hp4.v r100) {
        this.f208040a = r100;
    }

    public void setOptionOnClickListener(com.bytedance.ee.bear.widgets.t r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f208042c.f208037g = r100;
    }

    public BaseRecordSelectView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(getLayoutId(), this);
        BaseFlexSelectAdapter r103 = getFlexAdapter();
        this.f208042c = r103;
        InnerRecyclerView r104 = (InnerRecyclerView) findViewById(R.id.recycler_view);
        this.f208043d = r104;
        r104.setLayoutManager(new SafeFlexboxLayoutManager(r100));
        r104.setAdapter(r103.G2());
        this.f208041b = new a(this);
    }

    public /* synthetic */ BaseRecordSelectView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
