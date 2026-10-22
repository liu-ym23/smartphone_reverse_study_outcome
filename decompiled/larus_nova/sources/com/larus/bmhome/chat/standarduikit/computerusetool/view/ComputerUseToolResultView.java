package com.larus.bmhome.chat.standarduikit.computerusetool.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.view.DeepThinkCommonToolHeader;
import com.larus.common_ui.widget.shimmer.ShimmerMaskView;
import com.larus.mainbot.impl.databinding.LarusLayoutComputerUseToolResultBlockViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013J\u0018\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0004H\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultBlockInput;", "Lcom/larus/bmhome/chat/standarduikit/computerusetool/view/ComputerUseToolResultBlockOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusLayoutComputerUseToolResultBlockViewBinding;", "imageBindToken", "addCodeView", "", "codeView", "Landroid/view/View;", "bindData", "input", BdpAppEventConstant.PARAMS_OUTPUT, "currentToolTitle", "", "refreshControlGroup", "isFold", "", "hasImage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ComputerUseToolResultView extends ConstraintLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f309037c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusLayoutComputerUseToolResultBlockViewBinding f309038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f309039b;

    public ComputerUseToolResultView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public ComputerUseToolResultView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public ComputerUseToolResultView(Context r100, AttributeSet r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r110);
        LayoutInflater.from(r100).inflate(R.layout.larus_layout_computer_use_tool_result_block_view, this);
        int r102 = R.id.common_tool_header;
        DeepThinkCommonToolHeader r103 = (DeepThinkCommonToolHeader) ViewBindings.findChildViewById(this, R.id.common_tool_header);
        if (r103 == null) goto L15;
        r102 = R.id.computer_use_tool_result_code_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.computer_use_tool_result_code_container);
        if (r104 == null) goto L15;
        r102 = R.id.computer_use_tool_result_cover;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(this, R.id.computer_use_tool_result_cover);
        if (r105 == null) goto L15;
        r102 = R.id.computer_use_tool_result_cover_mask;
        ShimmerMaskView r106 = (ShimmerMaskView) ViewBindings.findChildViewById(this, R.id.computer_use_tool_result_cover_mask);
        if (r106 == null) goto L15;
        r102 = R.id.computer_use_tool_result_cover_stub;
        View r107 = ViewBindings.findChildViewById(this, R.id.computer_use_tool_result_cover_stub);
        if (r107 == null) goto L15;
        this.f309038a = new LarusLayoutComputerUseToolResultBlockViewBinding(this, r103, r104, r105, r106, r107);
        return;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }

    public /* synthetic */ ComputerUseToolResultView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
