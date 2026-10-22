package com.bytedance.ee.bear.bitable.card.view.cell.formgrid.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import bq4.d;
import com.bytedance.ee.bear.bitable.card.view.cell.formgrid.FieldModel;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/view/FormGridFieldView;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FieldModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "fieldName", "Landroid/widget/TextView;", "getFieldName", "()Landroid/widget/TextView;", "requiredIcon", "getRequiredIcon", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridFieldView extends LinearLayout implements b<FieldModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f207685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f207686b;

    public FormGridFieldView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FormGridFieldView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getFieldName() {
        return this.f207685a;
    }

    public final TextView getRequiredIcon() {
        return this.f207686b;
    }

    public FormGridFieldView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(16);
        TextView r103 = new TextView(r100);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2);
        r104.gravity = 17;
        r103.setLayoutParams(r104);
        m.s(r103, n.d(8), false);
        r103.setTextSize(14.0f);
        r103.setTextColor(ContextCompat.getColor(r100, R.color.text_title));
        r103.setMaxLines(1);
        r103.setEllipsize(TextUtils.TruncateAt.END);
        this.f207685a = r103;
        addView(r103);
        TextView r105 = new TextView(r100);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(n.d(8), -2);
        r106.gravity = 17;
        r105.setLayoutParams(r106);
        SpannableStringBuilder r107 = new SpannableStringBuilder("*");
        r107.setSpan(new d(r100), r107.length() - 1, r107.length(), 33);
        r105.setText(r107);
        this.f207686b = r105;
        addView(r105);
        m.t(this, n.d(12));
    }

    public /* synthetic */ FormGridFieldView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
