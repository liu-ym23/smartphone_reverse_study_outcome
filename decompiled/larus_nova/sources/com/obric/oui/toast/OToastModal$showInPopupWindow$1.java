package com.obric.oui.toast;

import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/view/ViewGroup;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class OToastModal$showInPopupWindow$1 extends Lambda implements Function0<ViewGroup> {
    final /* synthetic */ PopupWindow $popupWindow;
    final /* synthetic */ g this$0;

    public OToastModal$showInPopupWindow$1(PopupWindow r100, g r101) {
        this.$popupWindow = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewGroup invoke() {
        PopupWindow r100 = this.$popupWindow;
        boolean r101 = false;
        if (r100 == null) goto L9;
        if (r100.isShowing() != true) goto L9;
        r101 = true;
    L9:
        if (r101 == true) goto L11;
    L15:
        return null;
    L11:
        if (this.$popupWindow.getContentView() == null) goto L15;
        int r102 = g.f403724a;
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ViewGroup invoke() {
        return invoke();
    }
}
