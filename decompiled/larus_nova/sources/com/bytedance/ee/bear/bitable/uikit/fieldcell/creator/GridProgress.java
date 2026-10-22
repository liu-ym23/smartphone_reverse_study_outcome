package com.bytedance.ee.bear.bitable.uikit.fieldcell.creator;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.uikit.fieldcell.ProgressModel;
import com.larksuite.component.universe_design.progress.UDProgress;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u000fJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/creator/GridProgress;", "Landroid/widget/LinearLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Lcom/bytedance/ee/bear/bitable/uikit/fieldcell/ProgressModel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "udProgress", "Lcom/larksuite/component/universe_design/progress/UDProgress;", "textView", "Landroid/widget/TextView;", "getContentView", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GridProgress extends LinearLayout implements gv4.b<ProgressModel> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UDProgress f216169a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f216170b;

    public GridProgress(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public GridProgress(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final TextView getContentView() {
        return this.f216170b;
    }

    public GridProgress(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setGravity(16);
        UDProgress r103 = new UDProgress(r100);
        r103.setIndicatorCornerRadius(com.bytedance.ee.util.ui.n.d(4));
        r103.setThickness(com.bytedance.ee.util.ui.n.d(8));
        r103.setTrackColor(r100.getResources().getColor(R.color.bg_body_overlay));
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -1);
        r104.weight = 1.0f;
        r103.setLayoutParams(r104);
        this.f216169a = r103;
        addView(r103);
        TextView r105 = new TextView(r100);
        r105.setTextSize(14.0f);
        this.f216170b = r105;
        r105.setGravity(5);
        r105.setTextColor(ContextCompat.getColor(r100, R.color.text_title));
        r105.setMaxLines(1);
        r105.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(com.bytedance.ee.util.ui.n.d(38), -1);
        r106.leftMargin = com.bytedance.ee.util.ui.n.d(8);
        r105.setLayoutParams(r106);
        addView(r105);
    }

    public /* synthetic */ GridProgress(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
