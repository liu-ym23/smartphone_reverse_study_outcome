package com.larus.uaigc.chat.block.createloading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.uaigc.chat.markdown.placeholder.ShimmerTextPlaceHolderView;
import com.larus.uaigc.impl.databinding.LarusWidgetMarkdownCreationTextPlaceholderBinding;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\r2\b\b\u0001\u0010\u0013\u001a\u00020\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/chat/block/createloading/CreationLoadingBlockView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetMarkdownCreationTextPlaceholderBinding;", "updateView", "", "loadingText", "", "blockLongClickHandler", "Lcom/larus/bmhome/chat/block/base/config/IBlockLongClickHandler;", "updatePaddingTop", GXTemplateKey.FLEXBOX_PADDING, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLoadingBlockView extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f370581b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetMarkdownCreationTextPlaceholderBinding f370582a;

    public CreationLoadingBlockView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public CreationLoadingBlockView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a(int r100) {
        ShimmerTextPlaceHolderView r101 = this.f370582a.f373278b;
        int r102 = r101.getPaddingStart();
        int r103 = r101.getPaddingEnd();
        int r104 = r101.getPaddingBottom();
        FLogger.f375446a.i("updatePaddingRelative", "view:" + r101.getClass().getSimpleName() + ",source:,start:" + r102 + ",top:" + r100 + ",end:" + r103 + ",bottom:" + r104);
        r101.setPaddingRelative(r102, r100, r103, r104);
    }

    public CreationLoadingBlockView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LarusWidgetMarkdownCreationTextPlaceholderBinding r103 = LarusWidgetMarkdownCreationTextPlaceholderBinding.a(LayoutInflater.from(r100), null, false);
        this.f370582a = r103;
        addView(r103.f373277a);
    }

    public /* synthetic */ CreationLoadingBlockView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
