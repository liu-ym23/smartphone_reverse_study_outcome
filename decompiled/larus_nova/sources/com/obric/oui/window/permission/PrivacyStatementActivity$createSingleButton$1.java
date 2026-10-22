package com.obric.oui.window.permission;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.obric.oui.button.OButton;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "Lcom/obric/oui/button/OButton;", "styledContext", "Landroid/content/Context;", "width", "", "height", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createSingleButton$1 extends Lambda implements Function3<Context, Integer, Integer, OButton> {
    final /* synthetic */ Function1<View, Unit> $onClickListener;
    final /* synthetic */ String $text;

    /* JADX WARN: Multi-variable type inference failed */
    public PrivacyStatementActivity$createSingleButton$1(String r100, Function1<? super View, Unit> r101) {
        this.$text = r100;
        this.$onClickListener = r101;
        super(3);
    }

    public final OButton invoke(Context r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "styledContext");
        View.OnClickListener r103 = null;
        OButton r104 = new OButton(r100, null, 0, 28);
        String r105 = this.$text;
        final Function1<View, Unit> r106 = this.$onClickListener;
        r104.setText(r105);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, r102));
        if (r106 == null) goto L6;
        r103 = new b(r106);
    L6:
        r104.setOnClickListener(r103);
        return r104;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ OButton invoke(Context r100, Integer r101, Integer r102) {
        return invoke(r100, r101.intValue(), r102.intValue());
    }
}
