package com.larus.bmhome.chat.standarduikit.fileoperation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.larus.bmhome.chat.standarduikit.generictool.view.GenericToolView;
import com.larus.mainbot.impl.databinding.LarusFileOperateViewBinding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002B'\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u0018\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/fileoperation/view/FileOperateView;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/fileoperation/view/FileOperateViewInput;", "Lcom/larus/bmhome/chat/standarduikit/fileoperation/view/FileOperateViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/mainbot/impl/databinding/LarusFileOperateViewBinding;", "addCodeView", "", "codeView", "Landroid/view/View;", "bindData", "input", BdpAppEventConstant.PARAMS_OUTPUT, "currentToolTitle", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FileOperateView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusFileOperateViewBinding f309078a;

    public FileOperateView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public FileOperateView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public FileOperateView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_file_operate_view, this);
        int r103 = R.id.file_operate_code_container;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.file_operate_code_container);
        if (r104 == null) goto L9;
        r103 = R.id.file_operate_header;
        GenericToolView r105 = (GenericToolView) ViewBindings.findChildViewById(this, R.id.file_operate_header);
        if (r105 == null) goto L9;
        this.f309078a = new LarusFileOperateViewBinding(this, r104, r105);
        setOrientation(1);
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ FileOperateView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
