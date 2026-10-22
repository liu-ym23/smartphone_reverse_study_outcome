package com.ss.android.lark.flow.feed.component.text_layer;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import zz7.b;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "markTextSize", "", "textView", "Landroidx/appcompat/widget/AppCompatTextView;", "getTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "textView$delegate", "Lkotlin/Lazy;", "dividerImageView", "Landroidx/appcompat/widget/AppCompatImageView;", "getDividerImageView", "()Landroidx/appcompat/widget/AppCompatImageView;", "dividerImageView$delegate", "init", "", "bindTextLayer", "data", "Lcom/ss/android/lark/flow/feed/component/text_layer/FlowTextLayerComponent$FlowTextLayerParams;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowTextLayerView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f423345a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f423346b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f423347c;

    private final AppCompatImageView getDividerImageView() {
        return (AppCompatImageView) this.f423347c.getValue();
    }

    private final AppCompatTextView getTextView() {
        return (AppCompatTextView) this.f423346b.getValue();
    }

    public FlowTextLayerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void a(a.C4997a r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.f423349a == false) goto L6;
        getTextView().setVisibility(0);
        getTextView().setText(UIHelper.getString(R.string.LarkIM_Feed_MentionMe_Text));
        getTextView().setTextColor(UIHelper.getColor(R.color.function_danger_500));
        getDividerImageView().setVisibility(0);
        return;
    L6:
        if (r100.f423350b <= 0) goto L11;
        getTextView().setVisibility(0);
        int r101 = r100.f423350b;
        if (r101 <= 99) goto L10;
        r101 = 99;
    L10:
        getTextView().setText(UIHelper.getQuantityString(R.plurals.LarkIM_Feed_NumNewMsg_Text, r101));
        getTextView().setTextColor(UIUtils.getColor(getContext(), R.color.flow_feed_digest_text));
        getDividerImageView().setVisibility(0);
        return;
    L11:
        getTextView().setVisibility(8);
        getDividerImageView().setVisibility(8);
    }

    public FlowTextLayerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, 0);
        this.f423345a = b.h(getContext(), 14);
        this.f423346b = LazyKt.lazy(new FlowTextLayerView$textView$2(this));
        this.f423347c = LazyKt.lazy(new FlowTextLayerView$dividerImageView$2(this));
        addView(getTextView());
        AppCompatImageView r102 = getDividerImageView();
        LinearLayout.LayoutParams r103 = new LinearLayout.LayoutParams(-2, -2);
        r103.gravity = 16;
        r103.rightMargin = UIHelper.dp2px(6.0f);
        r103.leftMargin = UIHelper.dp2px(6.0f);
        Unit r104 = Unit.INSTANCE;
        addView(r102, r103);
        getDividerImageView().setVisibility(8);
    }
}
