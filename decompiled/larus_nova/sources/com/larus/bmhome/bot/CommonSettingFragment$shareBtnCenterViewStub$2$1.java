package com.larus.bmhome.bot;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusShareButtonCenterLayoutBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class CommonSettingFragment$shareBtnCenterViewStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusShareButtonCenterLayoutBinding> {
    public static final CommonSettingFragment$shareBtnCenterViewStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new CommonSettingFragment$shareBtnCenterViewStub$2$1();
    }

    public CommonSettingFragment$shareBtnCenterViewStub$2$1() {
        super(1, LarusShareButtonCenterLayoutBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/common_res/common_ui/databinding/LarusShareButtonCenterLayoutBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusShareButtonCenterLayoutBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        FrameLayout r101 = (FrameLayout) r100;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r100, R.id.share_button_center_text_view);
        if (r102 == null) goto L7;
        return new LarusShareButtonCenterLayoutBinding(r101, r101, r102);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(R.id.share_button_center_text_view)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusShareButtonCenterLayoutBinding invoke(View r100) {
        return invoke2(r100);
    }
}
