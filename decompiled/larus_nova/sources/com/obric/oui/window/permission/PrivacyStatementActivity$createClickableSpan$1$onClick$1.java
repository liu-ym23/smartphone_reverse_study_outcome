package com.obric.oui.window.permission;

import android.content.DialogInterface;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "which", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 6, 0}, xi = 48)
final class PrivacyStatementActivity$createClickableSpan$1$onClick$1 extends Lambda implements Function2<DialogInterface, Integer, Unit> {
    final /* synthetic */ PrivacyStatementActivity.b $linkClickListener;
    final /* synthetic */ String $title;
    final /* synthetic */ String $url;
    final /* synthetic */ PrivacyStatementActivity this$0;

    public PrivacyStatementActivity$createClickableSpan$1$onClick$1(PrivacyStatementActivity r100, String r101, PrivacyStatementActivity.b r102, String r103) {
        this.this$0 = r100;
        this.$url = r101;
        this.$linkClickListener = r102;
        this.$title = r103;
        super(2);
    }

    public final void invoke(DialogInterface r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dialog");
        r100.dismiss();
        boolean r102 = true;
        this.this$0.f403767a = true;
        String r103 = this.$url;
        if (r103 != null) goto L5;
    L8:
        if (r102 == true) goto L16;
        PrivacyStatementActivity.b r104 = this.$linkClickListener;
        if (r104 != null) goto L12;
        Unit r105 = null;
    L13:
        if (r105 != null) goto L17;
        PrivacyStatementActivity.z1(this.this$0, this.$url, this.$title);
        return;
    L17:
        return;
    L12:
        r104.onLinkClick();
        r105 = Unit.INSTANCE;
        goto L13
    L16:
        return;
    L5:
        if (r103.length() == 0) goto L8;
        r102 = false;
        goto L8
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(DialogInterface r100, Integer r101) {
        invoke(r100, r101.intValue());
        return Unit.INSTANCE;
    }
}
