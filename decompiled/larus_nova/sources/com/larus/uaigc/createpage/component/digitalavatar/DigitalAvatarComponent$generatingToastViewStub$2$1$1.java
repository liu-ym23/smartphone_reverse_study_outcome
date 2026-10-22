package com.larus.uaigc.createpage.component.digitalavatar;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.nova.R;
import com.larus.uaigc.impl.databinding.LarusLayoutAvatarGeneratingToastBinding;
import com.lynx.lottieadapter.LottieAdapterView;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class DigitalAvatarComponent$generatingToastViewStub$2$1$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutAvatarGeneratingToastBinding> {
    public static final DigitalAvatarComponent$generatingToastViewStub$2$1$1 INSTANCE = null;

    static {
        INSTANCE = new DigitalAvatarComponent$generatingToastViewStub$2$1$1();
    }

    public DigitalAvatarComponent$generatingToastViewStub$2$1$1() {
        super(1, LarusLayoutAvatarGeneratingToastBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/uaigc/impl/databinding/LarusLayoutAvatarGeneratingToastBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusLayoutAvatarGeneratingToastBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        int r101 = R.id.content;
        if (((TextView) ViewBindings.findChildViewById(r100, R.id.content)) == null) goto L9;
        r101 = R.id.loading_icon;
        LottieAdapterView r102 = (LottieAdapterView) ViewBindings.findChildViewById(r100, R.id.loading_icon);
        if (r102 == null) goto L9;
        return new LarusLayoutAvatarGeneratingToastBinding((RoundLinearLayout) r100, r102);
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusLayoutAvatarGeneratingToastBinding invoke(View r100) {
        return invoke2(r100);
    }
}
