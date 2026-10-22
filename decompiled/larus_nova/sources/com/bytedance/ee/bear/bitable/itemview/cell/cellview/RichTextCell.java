package com.bytedance.ee.bear.bitable.itemview.cell.cellview;

import android.content.Context;
import android.content.res.Resources;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.common.model.field.EFieldUIType;
import com.bytedance.ee.bear.bitable.itemview.util.t;
import com.bytedance.ee.bear.bitable.uikit.ReportActionPayload;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 22\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00022\u00020\u00052\u00020\u0006:\u00012B\u001d\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\b\u0010$\u001a\u00020%H\u0014J\b\u0010&\u001a\u00020%H\u0014J\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)J$\u0010*\u001a\u00020%2\b\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u0006\u0010,\u001a\u00020-J\b\u0010.\u001a\u00020%H\u0016J\u0012\u0010/\u001a\u00020%2\b\u00100\u001a\u0004\u0018\u000101H\u0016R\u001c\u0010\r\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u00063"}, d2 = {"Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/RichTextCell;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/text/BitableAtEditText;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKitEx2;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/cellview/RichTextCellValue;", "Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "Lcom/bytedance/ee/bear/bitable/common/TouchDetectListener;", "Lcom/bytedance/ee/bear/span/AbsSpan$ISpanClickListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "extra", "getExtra", "()Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;", "setExtra", "(Lcom/bytedance/ee/bear/bitable/itemview/cell/CellContextData;)V", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "getHandler", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "setHandler", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "mCustomActionMode", "Landroid/view/ActionMode;", "getMCustomActionMode", "()Landroid/view/ActionMode;", "setMCustomActionMode", "(Landroid/view/ActionMode;)V", "mLongPressWrapper", "Lcom/bytedance/ee/bear/bitable/itemview/util/LongPressWrapper;", "getMLongPressWrapper", "()Lcom/bytedance/ee/bear/bitable/itemview/util/LongPressWrapper;", "setMLongPressWrapper", "(Lcom/bytedance/ee/bear/bitable/itemview/util/LongPressWrapper;)V", "onAttachedToWindow", "", "onDetachedFromWindow", "log", "msg", "", "setData", "data", "getEditable", "", "onTouchDown", "onSpanClicked", "span", "Lcom/bytedance/ee/bear/span/AbsSpan;", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RichTextCell extends BitableAtEditText implements com.bytedance.ee.bear.bitable.common.k, un5.a.InterfaceC7903a {

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public qt4.a f213837h2;

    /* JADX INFO: renamed from: p2, reason: collision with root package name */
    public gv4.a f213838p2;

    /* JADX INFO: renamed from: v2, reason: collision with root package name */
    public ActionMode f213839v2;

    /* JADX INFO: renamed from: x2, reason: collision with root package name */
    public t f213840x2;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.bitable.common.k
    public final void b() {
        setSelection(0, 0);
    }

    public final boolean getEditable() {
        qt4.a r100 = this.f213837h2;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.f534788e;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 == null) goto L6;
        r100.EB(this);
        return;
    }

    @Override // com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.bytedance.ee.bear.bitable.itemview.b r100 = com.bytedance.ee.bear.bitable.itemview.util.i.c(this);
        if (r100 == null) goto L6;
        r100.ES(this);
        return;
    }

    public final qt4.a getExtra() {
        return this.f213837h2;
    }

    @Override // android.view.View
    public final gv4.a getHandler() {
        return this.f213838p2;
    }

    public final ActionMode getMCustomActionMode() {
        return this.f213839v2;
    }

    public final t getMLongPressWrapper() {
        return this.f213840x2;
    }

    public RichTextCell(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    @Override // un5.a.InterfaceC7903a
    public final void B3(un5.a r100) {
        O("text onSpanClicked");
        qt4.a r101 = this.f213837h2;
        if (r101 == null) goto L5;
        EFieldUIType r102 = r101.f534790g;
    L7:
        if (r102 == EFieldUIType.URL) goto L14;
        if (r101 == null) goto L10;
        EFieldUIType r103 = r101.f534790g;
    L12:
        if (r103 == EFieldUIType.EMAIL) goto L14;
    L16:
        String r104 = "";
        if ((r100 instanceof un5.e) == false) goto L30;
        com.bytedance.ee.bear.bitable.itemview.util.i.h(getContext(), ((un5.e) r100).f550787e);
        int r105 = com.bytedance.ee.bear.bitable.itemview.util.b.f214273b;
        com.bytedance.ee.bear.bitable.itemview.util.b.f214272a = System.currentTimeMillis();
        gv4.a r106 = this.f213838p2;
        if (r106 == null) goto L46;
        ReportActionPayload r107 = new ReportActionPayload("ItemViewClickSpan");
        qt4.a r108 = this.f213837h2;
        if (r108 == null) goto L28;
        EFieldUIType r109 = r108.f534790g;
        if (r109 == null) goto L28;
        String r110 = r109.getReportValue();
        if (r110 == null) goto L28;
        r104 = r110;
    L28:
        r107.put("field_type", r104);
        r106.a(r107);
        return;
    L46:
        return;
    L30:
        if ((r100 instanceof un5.h) == false) goto L43;
        com.bytedance.ee.bear.bitable.itemview.util.i.h(getContext(), ((un5.h) r100).f550805d);
        int r111 = com.bytedance.ee.bear.bitable.itemview.util.b.f214273b;
        com.bytedance.ee.bear.bitable.itemview.util.b.f214272a = System.currentTimeMillis();
        gv4.a r112 = this.f213838p2;
        if (r112 == null) goto L48;
        ReportActionPayload r113 = new ReportActionPayload("ItemViewClickSpan");
        qt4.a r114 = this.f213837h2;
        if (r114 == null) goto L41;
        EFieldUIType r115 = r114.f534790g;
        if (r115 == null) goto L41;
        String r116 = r115.getReportValue();
        if (r116 == null) goto L41;
        r104 = r116;
    L41:
        r113.put("field_type", r104);
        r112.a(r113);
        return;
    L48:
        return;
    L43:
        if ((r100 instanceof un5.l) == false) goto L50;
        ((com.bytedance.ee.bear.docshost.k) org.koin.java.a.c(com.bytedance.ee.bear.docshost.k.class, null, null, 6)).e(((un5.l) r100).f550815d, null);
        int r117 = com.bytedance.ee.bear.bitable.itemview.util.b.f214273b;
        com.bytedance.ee.bear.bitable.itemview.util.b.f214272a = System.currentTimeMillis();
        return;
    L50:
        return;
    L10:
        r103 = null;
    L14:
        if (getEditable() == false) goto L16;
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void O(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        tt5.a.h("RichTextCell", r100 + "isCursorVisible:" + isCursorVisible() + ", isFocusable:" + isFocusable() + ", isClickable:" + isClickable() + ", isLongClickable:" + isLongClickable() + ", inputType:" + getInputType());
    }

    public final void setExtra(qt4.a r100) {
        this.f213837h2 = r100;
    }

    public final void setHandler(gv4.a r100) {
        this.f213838p2 = r100;
    }

    public final void setMCustomActionMode(ActionMode r100) {
        this.f213839v2 = r100;
    }

    public final void setMLongPressWrapper(t r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213840x2 = r100;
    }

    public RichTextCell(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f213840x2 = new t(this, false);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setLayoutParams(com.bytedance.ee.bear.bitable.m.d(true, true));
        setHintTextColor(ContextCompat.getColor(getContext(), R.color.text_placeholder));
        setBackground(null);
        getHighlightColor();
        setLineSpacing(0.0f, 1.0f);
        setImeOptions(5);
        setInputType(131073);
        setTextColor(ContextCompat.getColor(getContext(), R.color.text_title));
        setTextSize(2, 14.0f);
        setPadding(0, com.bytedance.ee.util.ui.n.d(2), 0, com.bytedance.ee.util.ui.n.d(2));
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(10000)});
        Resources r102 = getResources();
        setMinWidth((int) TypedValue.applyDimension(1, 0.5f, WindowDisplayMetricsOverride.apply(r102, r102.getDisplayMetrics())));
        setTextIsSelectable(true);
        setInputType(0);
        setShowSoftInputOnFocus(false);
        setCursorVisible(false);
        setSingleLine(false);
        M(10.0f);
        setCopyAtMentionEnable(true);
        Intrinsics.checkNotNullParameter(this, "<this>");
        setMovementMethod(new com.bytedance.ee.bear.bitable.card.view.cell.text.e());
        E(this, l.f213880a);
        getPresenter().f208235j = this;
        setCustomSelectionActionModeCallback(new com.bytedance.ee.bear.bitable.itemview.util.d());
    }
}
