package com.larus.bmhome.chat.standarduikit.commonbuttonv2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.mainbot.impl.databinding.LarusBlockItemButtonV2Binding;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zj8.e;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002:\u0001\u0014B\u001d\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0004H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2;", "Landroid/widget/LinearLayout;", "Lcom/larus/bmhome/chat/standarduikit/FlowStandardView;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2ViewInput;", "Lcom/larus/bmhome/chat/standarduikit/commonbuttonv2/view/CommonButtonV2ViewOutput;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "contentBinding", "Lcom/larus/mainbot/impl/databinding/LarusBlockItemButtonV2Binding;", "bindData", "", "input", BdpAppEventConstant.PARAMS_OUTPUT, "getCurrentIconView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mobCardShow", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonButtonV2 extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f309000b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusBlockItemButtonV2Binding f309001a;

    public static final class a {
    }

    static {
    }

    public CommonButtonV2(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final SimpleDraweeView a(e r100) {
        if (r100.f572514i != 1) goto L5;
        SimpleDraweeView r101 = this.f309001a.f358435c;
        Intrinsics.checkNotNull(r101);
        return r101;
    L5:
        SimpleDraweeView r102 = this.f309001a.f358436d;
        Intrinsics.checkNotNull(r102);
        return r102;
    }

    public CommonButtonV2(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        View r102 = LayoutInflater.from(r100).inflate(R.layout.larus_block_item_button_v2, this, false);
        addView(r102);
        LinearLayout r103 = (LinearLayout) r102;
        int r104 = R.id.button_v2_icon_left;
        SimpleDraweeView r105 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.button_v2_icon_left);
        if (r105 == null) goto L11;
        r104 = R.id.button_v2_icon_right;
        SimpleDraweeView r106 = (SimpleDraweeView) ViewBindings.findChildViewById(r102, R.id.button_v2_icon_right);
        if (r106 == null) goto L11;
        r104 = R.id.button_v2_text;
        AppCompatTextView r107 = (AppCompatTextView) ViewBindings.findChildViewById(r102, R.id.button_v2_text);
        if (r107 == null) goto L11;
        this.f309001a = new LarusBlockItemButtonV2Binding(r103, r103, r105, r106, r107);
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r102.getResources().getResourceName(r104)));
    }
}
