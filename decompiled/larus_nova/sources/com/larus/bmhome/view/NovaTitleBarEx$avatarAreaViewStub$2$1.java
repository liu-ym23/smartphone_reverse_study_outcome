package com.larus.bmhome.view;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusLayoutLeftAvatarBinding;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
public /* synthetic */ class NovaTitleBarEx$avatarAreaViewStub$2$1 extends FunctionReferenceImpl implements Function1<View, LarusLayoutLeftAvatarBinding> {
    public static final NovaTitleBarEx$avatarAreaViewStub$2$1 INSTANCE = null;

    static {
        INSTANCE = new NovaTitleBarEx$avatarAreaViewStub$2$1();
    }

    public NovaTitleBarEx$avatarAreaViewStub$2$1() {
        super(1, LarusLayoutLeftAvatarBinding.class, "bind", "bind(Landroid/view/View;)Lcom/larus/common_res/common_ui/databinding/LarusLayoutLeftAvatarBinding;", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final LarusLayoutLeftAvatarBinding invoke2(View r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        int r101 = R.id.avatar;
        TitleAvatarImageView r102 = (TitleAvatarImageView) ViewBindings.findChildViewById(r100, R.id.avatar);
        if (r102 == null) goto L11;
        r101 = R.id.subtitle;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.subtitle);
        if (r103 == null) goto L11;
        r101 = R.id.title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r100, R.id.title);
        if (r104 == null) goto L11;
        return new LarusLayoutLeftAvatarBinding((ConstraintLayout) r100, r102, r103, r104);
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ LarusLayoutLeftAvatarBinding invoke(View r100) {
        return invoke2(r100);
    }
}
