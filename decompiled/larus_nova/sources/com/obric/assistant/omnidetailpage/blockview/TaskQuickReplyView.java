package com.obric.assistant.omnidetailpage.blockview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.obric.assistant.card.databinding.ObricOmniBlockQuickReplyBinding;
import com.obric.assistant.omnidetailpage.blockview.base.OmniDetailVerticalLineFrameLayout;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 (2\u00020\u0001:\u0001(B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\\\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00100\u00142\u001a\b\u0002\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u00172\u001a\b\u0002\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0017J\u0006\u0010\u0019\u001a\u00020\u0010J\u0010\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u001e2\u0006\u0010\u0011\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u001fH\u0002JB\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u00072\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00100\u0017H\u0002J \u0010&\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0007H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/TaskQuickReplyView;", "Lcom/obric/assistant/omnidetailpage/blockview/base/OmniDetailVerticalLineFrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/obric/assistant/card/databinding/ObricOmniBlockQuickReplyBinding;", "verticalSpacingPx", "exposureObserveStages", "", "bind", "", MapController.ITEM_LAYER_TAG, "Lcom/obric/assistant/omnidetailpage/model/OmniTaskItem$QuickReply;", "onItemClick", "Lkotlin/Function1;", "", "onQuickReplyClick", "Lkotlin/Function2;", "onQuickReplyShow", "onRecycled", "updateContentHorizontalPadding", "useCompactIndent", "", "bindItemView", "Lcom/obric/assistant/card/databinding/ObricOmniBlockQuickReplyItemBinding;", "Lcom/larus/im/bean/message/block/QuickReplyItem;", "resolveItemWidth", "registerItemExpose", "itemView", "Landroid/view/View;", "quickReplyItem", "sourceIndex", "buildExposeCellId", "releaseItemExposures", "Companion", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TaskQuickReplyView extends OmniDetailVerticalLineFrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f390593f = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ObricOmniBlockQuickReplyBinding f390594c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f390595d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<Integer> f390596e;

    public static final class a {
    }

    static {
    }

    public TaskQuickReplyView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TaskQuickReplyView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public TaskQuickReplyView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.obric_omni_block_quick_reply, this, false);
        addView(r103);
        LinearLayout r104 = (LinearLayout) ViewBindings.findChildViewById(r103, R.id.quickReplyContainer);
        if (r104 == null) goto L7;
        this.f390594c = new ObricOmniBlockQuickReplyBinding((LinearLayout) r103, r104);
        this.f390595d = getResources().getDimensionPixelSize(R.dimen.dp_12);
        this.f390596e = CollectionsKt.listOf(new Integer[]{0, 1, 2});
        setLayoutParams(new RecyclerView.LayoutParams(-1, -2));
        return;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(R.id.quickReplyContainer)));
    }

    public /* synthetic */ TaskQuickReplyView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
