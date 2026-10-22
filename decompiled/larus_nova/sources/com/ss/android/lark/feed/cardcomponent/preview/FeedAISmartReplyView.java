package com.ss.android.lark.feed.cardcomponent.preview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.larksuite.component.ui.imageview.GreyStartLoadingView;
import com.larksuite.framework.utils.UIUtils;
import com.larus.bmhome.view.screenmenu.widget.ItemStyle;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010\u001b\u001a\u00020\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/feed/cardcomponent/preview/FeedAISmartReplyView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "iconSize", "", "iconStartMargin", "iconEndMargin", "iconVerticalMargin", "dividerEndMargin", "smartReplyIcon", "Landroidx/appcompat/widget/AppCompatImageView;", "staticIcon", "dynamicIcon", "Lcom/larksuite/component/ui/imageview/GreyStartLoadingView;", ItemStyle.ITEM_STYLE_DIVIDER, "atKnowledgeAiIconSize", "setSmartReplyMode", "", "setAtKnowledgeAiMode", "isStaticIcon", "", "isDigestQuery", "setViewGone", "Companion", "feed-card-component_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FeedAISmartReplyView extends LinearLayout {

    public static final class a {
    }

    static {
    }

    public FeedAISmartReplyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public FeedAISmartReplyView(Context r110, AttributeSet r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110, r111);
        int r100 = zz7.b.g(r110, 16);
        int r101 = UIUtils.dp2px(r110, 2.0f);
        int r102 = UIUtils.dp2px(r110, 6.0f);
        int r103 = UIUtils.dp2px(r110, 1.0f);
        int r104 = UIUtils.dp2px(r110, 6.0f);
        int r105 = zz7.b.g(r110, 14);
        AppCompatImageView r106 = new AppCompatImageView(r110);
        r106.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r106.setAdjustViewBounds(true);
        r106.setImageResource(R.drawable.ud_icon_ai_common_colorful);
        r106.setVisibility(8);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r100, r100);
        r107.gravity = 16;
        r107.setMargins(r101, r103, r102, r103);
        r107.setMarginStart(r101);
        r107.setMarginEnd(r102);
        addView(r106, r107);
        AppCompatImageView r108 = new AppCompatImageView(r110);
        r108.setScaleType(ImageView.ScaleType.FIT_CENTER);
        r108.setAdjustViewBounds(true);
        r108.setImageResource(R.drawable.ud_icon_meeting_ai_outlined);
        r108.setImageTintList(ContextCompat.getColorStateList(r110, R.color.icon_n3));
        r108.setVisibility(8);
        LinearLayout.LayoutParams r109 = new LinearLayout.LayoutParams(r105, r105);
        r109.gravity = 16;
        r109.setMargins(r101, r103, r102, r103);
        r109.setMarginStart(r101);
        r109.setMarginEnd(r102);
        addView(r108, r109);
        View r112 = new GreyStartLoadingView(r110);
        r112.setVisibility(8);
        addView(r112, r109);
        AppCompatImageView r113 = new AppCompatImageView(r110);
        r113.setImageResource(R.drawable.vertical_divier_1dp);
        LinearLayout.LayoutParams r114 = new LinearLayout.LayoutParams(-2, -2);
        r114.gravity = 16;
        r114.setMarginEnd(r104);
        addView(r113, r114);
    }
}
