package com.bytedance.ee.bear.bitable.uikit.setting.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.bitable.common.e;
import com.bytedance.ee.bear.facade.common.widget.RoundFrameLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/setting/card/CardType;", "Lcom/bytedance/ee/bear/facade/common/widget/RoundFrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableCardViewSettingCardTypeBinding;", "setData", "", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "(Ljava/lang/Boolean;Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardType extends RoundFrameLayout implements b<Boolean> {
    public CardType(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CardType(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public CardType(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_card_view_setting_card_type, this, false);
        addView(r103);
        int r104 = R.id.cover_graph;
        RoundFrameLayout r105 = (RoundFrameLayout) ViewBindings.findChildViewById(r103, R.id.cover_graph);
        if (r105 == null) goto L15;
        r104 = R.id.line1;
        if (ViewBindings.findChildViewById(r103, R.id.line1) == null) goto L15;
        r104 = R.id.line2;
        if (ViewBindings.findChildViewById(r103, R.id.line2) == null) goto L15;
        r104 = R.id.line3;
        if (ViewBindings.findChildViewById(r103, R.id.line3) == null) goto L15;
        r104 = R.id.line3_2;
        if (ViewBindings.findChildViewById(r103, R.id.line3_2) == null) goto L15;
        LinearLayout r106 = (LinearLayout) r103;
        this.f226533e = true;
        r105.f226533e = true;
        e.b(this, 0.97f, 4);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }

    public /* synthetic */ CardType(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
