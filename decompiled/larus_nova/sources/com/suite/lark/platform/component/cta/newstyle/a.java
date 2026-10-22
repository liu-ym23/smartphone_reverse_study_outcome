package com.suite.lark.platform.component.cta.newstyle;

import android.graphics.drawable.Drawable;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.image.api.SimpleTarget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends SimpleTarget<Drawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDButton f460537a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ goc.b.d f460538b;

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onLoadFailed(Drawable r100) {
        super.onLoadFailed(r100);
        UDButton r101 = this.f460537a;
        String r102 = this.f460538b.b();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        r101.setText(r102);
    }

    @Override // com.ss.android.lark.image.api.SimpleTarget, com.ss.android.lark.image.api.Target
    public final void onResourceReady(Object r100) {
        Drawable r101 = (Drawable) r100;
        if (r101 != null) goto L9;
        UDButton r102 = this.f460537a;
        String r103 = this.f460538b.b();
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        r102.setText(r103);
        return;
    L9:
        if (Intrinsics.areEqual(this.f460538b.d(), "primary") == false) goto L11;
        int r104 = UIUtils.getColor(this.f460537a.getContext(), R.color.primary_on_primary_fill);
    L12:
        r101.mutate();
        r101.setTint(r104);
        int r105 = UIUtils.dp2px(this.f460537a.getContext(), 17.0f);
        r101.setBounds(0, 0, r105, r105);
        UDButton r106 = this.f460537a;
        final goc.b.d r107 = this.f460538b;
        com.larksuite.component.universe_design.button.e.e(r106, r101, new CTADialogFragment$initFooterView$1$1$2$onResourceReady$1(r107));
        return;
    L11:
        r104 = UIUtils.getColor(this.f460537a.getContext(), R.color.primary_content_default);
        goto L12
    }

    public a(UDButton r100, goc.b.d r101) {
        this.f460537a = r100;
        this.f460538b = r101;
    }
}
