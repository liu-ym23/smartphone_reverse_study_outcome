package com.bytedance.ee.bear.bitable.infoarch.nativeview.common.uikit.cell;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.GravityCompat;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.common.BaseCellData;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.FieldUIKitFactory;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.MutilCellLayout;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.c;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.h0;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.a;
import gv4.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0003H\u0002J\u001c\u00103\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u00032\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020)J\b\u00108\u001a\u000201H\u0014J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0014J!\u00109\u001a\u0002012\b\b\u0001\u0010:\u001a\u00020\t2\n\b\u0003\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010<J\u0012\u0010=\u001a\u00020>2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\rX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u000f\"\u0004\b!\u0010\u0011R\u0010\u0010\"\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010%\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0012\u0010'\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020+X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/¨\u0006A"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/uikit/cell/CommonCellView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/common/BaseCellData;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cellValueView", "Landroid/view/View;", "getCellValueView", "()Landroid/view/View;", "setCellValueView", "(Landroid/view/View;)V", "cellCreator", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/AbsUIKitCreator;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/IFiledUIkitModel;", "getCellCreator", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/AbsUIKitCreator;", "setCellCreator", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/AbsUIKitCreator;)V", "cellUIType", "Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "getCellUIType", "()Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;", "setCellUIType", "(Lcom/bytedance/ee/bear/bitable/common/model/field/EFieldUIType;)V", "emptyValueView", "getEmptyValueView", "setEmptyValueView", "emptyLineView", "emptyTextView", "Landroid/widget/TextView;", "emptyText", "Ljava/lang/Integer;", "emptyTextColor", "emptyValueVisible", "", "cellStyle", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;", "getCellStyle", "()Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;", "setCellStyle", "(Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/style/UIKitStyle;)V", "ensureCellView", "", "data", "setData", "actionHandler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setEmptyValueVisible", "visible", "showEmptyValue", "setEmptyText", "text", "textColor", "(ILjava/lang/Integer;)V", "applyParams", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonCellView extends FrameLayout implements b<BaseCellData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f213381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> f213382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public EFieldUIType f213383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f213384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f213385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TextView f213386f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Integer f213387g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Integer f213388h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f213389i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public iv4.b f213390j;

    public CommonCellView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CommonCellView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public void c() {
        if (this.f213384d != null) goto L5;
        View r100 = a(getContext());
        this.f213384d = r100;
        addView(r100);
    L5:
        View r101 = this.f213384d;
        if (r101 == null) goto L8;
        r101.setVisibility(0);
    L8:
        View r102 = this.f213381a;
        if (r102 == null) goto L11;
        r102.setVisibility(8);
    L11:
        boolean r103 = this.f213389i;
        Integer r104 = this.f213387g;
        if (r103 == true) goto L22;
        View r105 = this.f213385e;
        if (r105 == null) goto L16;
        r105.setVisibility(8);
    L16:
        TextView r106 = this.f213386f;
        if (r106 == null) goto L19;
        r106.setVisibility(8);
    L19:
        View r107 = this.f213384d;
        if (r107 == null) goto L40;
        r107.setVisibility(4);
        return;
    L40:
        return;
    L22:
        if (r104 == null) goto L33;
        View r108 = this.f213385e;
        if (r108 == null) goto L26;
        r108.setVisibility(8);
    L26:
        TextView r109 = this.f213386f;
        if (r109 == null) goto L42;
        r109.setVisibility(0);
        r109.setText(getContext().getString(r104.intValue()));
        Integer r110 = this.f213388h;
        if (r110 != null) goto L31;
        r110 = getCellStyle().c(getContext());
    L31:
        if (r110 == null) goto L43;
        r109.setTextColor(ContextCompat.getColor(getContext(), r110.intValue()));
        return;
    L43:
        return;
    L42:
        return;
    L33:
        View r111 = this.f213385e;
        if (r111 == null) goto L36;
        r111.setVisibility(0);
    L36:
        TextView r112 = this.f213386f;
        if (r112 == null) goto L45;
        r112.setVisibility(8);
        return;
    }

    public final com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> getCellCreator() {
        return this.f213382b;
    }

    public iv4.b getCellStyle() {
        return this.f213390j;
    }

    public final EFieldUIType getCellUIType() {
        return this.f213383c;
    }

    public final View getCellValueView() {
        return this.f213381a;
    }

    public final View getEmptyValueView() {
        return this.f213384d;
    }

    public View a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FrameLayout r101 = new FrameLayout(r100);
        iv4.b r102 = getCellStyle();
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(-1, n.d(22));
        r103.gravity = 16;
        r101.setLayoutParams(r103);
        TextView r104 = new TextView(r100);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(n.d(12), n.d(2));
        r105.gravity = 16;
        r104.setLayoutParams(r105);
        r104.setBackground(ResourcesCompat.getDrawable(r100.getResources(), R.drawable.bitable_card_view_field_emptyvalue, r100.getTheme()));
        this.f213385e = r104;
        TextView r106 = new TextView(r100);
        r106.setGravity(GravityCompat.START);
        r106.setMaxLines(1);
        r106.setEllipsize(TextUtils.TruncateAt.END);
        if (r102 == null) goto L7;
        r102.b(r106, false);
        Intrinsics.checkNotNullParameter(r106, "view");
        r106.setMaxLines(r102.f495940c);
        r102.a(r106);
        Intrinsics.checkNotNullParameter(r106, "view");
        Integer r107 = r102.c(r106.getContext());
        if (r107 == null) goto L7;
        r106.setTextColor(r107.intValue());
    L7:
        this.f213386f = r106;
        r101.addView(this.f213385e);
        r101.addView(this.f213386f);
        return r101;
    }

    public final void setCellCreator(com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> r100) {
        this.f213382b = r100;
    }

    public void setCellStyle(iv4.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213390j = r100;
    }

    public final void setCellUIType(EFieldUIType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213383c = r100;
    }

    public final void setCellValueView(View r100) {
        this.f213381a = r100;
    }

    public final void setEmptyValueView(View r100) {
        this.f213384d = r100;
    }

    public final void setEmptyValueVisible(boolean r100) {
        this.f213389i = r100;
    }

    public void b(BaseCellData r100, a r101) {
        Unit r102 = null;
        if (r100 == null) goto L5;
        EFieldUIType r103 = r100.getFieldUIType();
    L6:
        if (r100 == null) goto L8;
        FieldUIKitFactory.Type r104 = r100.getType();
    L10:
        if (this.f213381a != null) goto L12;
    L13:
        if (r103 != null) goto L15;
        r103 = EFieldUIType.NOT_SUPPORT;
    L15:
        this.f213383c = r103;
        c r105 = FieldUIKitFactory.f216138a;
        if (r104 != null) goto L18;
        r104 = FieldUIKitFactory.Type.COMMON;
    L18:
        c r106 = FieldUIKitFactory.a(r104);
        EFieldUIType r107 = this.f213383c;
        iv4.b r108 = getCellStyle();
        if (r100 == null) goto L21;
        Boolean r109 = r100.isBold();
    L22:
        if (r109 == null) goto L24;
        r108.getClass();
        r108.f495938a = r109.booleanValue();
    L25:
        com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> r110 = r106.a(r107, r108);
        View r111 = r110.b(getContext(), this);
        ViewGroup.LayoutParams r112 = r111.getLayoutParams();
        if (r112 != null) goto L28;
        FrameLayout.LayoutParams r113 = new FrameLayout.LayoutParams(-2, -2);
    L29:
        r113.gravity = 16;
        r111.setLayoutParams(r113);
        addView(r111);
        this.f213382b = r110;
        View r114 = this.f213381a;
        if (r114 == null) goto L32;
        removeView(r114);
    L32:
        this.f213381a = r111;
    L34:
        if (r100 != null) goto L36;
    L38:
        boolean r115 = false;
    L39:
        if (r115 == false) goto L42;
        c();
        return;
    L42:
        if (r100 == null) goto L75;
        ArrayList<h0> r116 = r100.getData();
        if (r116 == null) goto L75;
        if (r116.isEmpty() == false) goto L48;
        c();
        r102 = Unit.INSTANCE;
    L74:
        if (r102 == null) goto L75;
        return;
    L48:
        View r117 = this.f213384d;
        if (r117 == null) goto L51;
        r117.setVisibility(8);
    L51:
        View r118 = this.f213381a;
        if (r118 == null) goto L54;
        r118.setVisibility(0);
    L54:
        com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> r119 = this.f213382b;
        if (r119 == null) goto L62;
        Integer r120 = r100.getTotalChildCount();
        MutilCellLayout r121 = r119.f216159b;
        if ((r121 instanceof MutilCellLayout) == true) goto L60;
        r121 = null;
    L60:
        if (r121 == null) goto L62;
        r121.setIdealChildCount(r120);
    L62:
        com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> r122 = this.f213382b;
        if (r122 == null) goto L71;
        iv4.b r123 = getCellStyle();
        Boolean r124 = r100.isBold();
        if (r124 == null) goto L67;
        r123.getClass();
        r123.f495938a = r124.booleanValue();
    L69:
        if ((!r123.equals(r122.f216158a)) == false) goto L71;
        r122.f216161d = true;
        r122.f216158a = r123;
        goto L71
    L67:
        r123.f495938a = false;
    L71:
        com.bytedance.ee.bear.bitable.uikit.fieldcell.b<h0> r125 = this.f213382b;
        if (r125 == null) goto L74;
        r125.g(r100.getData());
        r102 = Unit.INSTANCE;
    L75:
        c();
        return;
    L36:
        if (r100.isEmptyValue() != true) goto L38;
        r115 = true;
        goto L39
    L28:
        r113 = new FrameLayout.LayoutParams(r112);
        goto L29
    L24:
        r108.f495938a = false;
        goto L25
    L21:
        r109 = null;
        goto L22
    L12:
        if (this.f213383c == r103) goto L34;
    L8:
        r104 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public CommonCellView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f213383c = EFieldUIType.NOT_SUPPORT;
        this.f213389i = true;
        this.f213390j = new iv4.b(false, 0.0f, 0, 0, 15);
    }

    public /* synthetic */ CommonCellView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
