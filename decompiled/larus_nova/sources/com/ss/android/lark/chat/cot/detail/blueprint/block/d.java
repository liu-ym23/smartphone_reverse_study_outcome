package com.ss.android.lark.chat.cot.detail.blueprint.block;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.larus.nova.R;
import com.ss.android.lark.chat.cot.detail.j;
import com.ss.android.lark.chat.cot.detail.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes35.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CotToolCallBlock f414933a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k f414934b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CotToolCallBlock.b f414935c;

    public d(CotToolCallBlock r100, k r101, CotToolCallBlock.b r102) {
        this.f414933a = r100;
        this.f414934b = r101;
        this.f414935c = r102;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        j r101 = this.f414933a.f414897c;
        String r102 = this.f414934b.f414982a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "stableId");
        Intrinsics.checkNotNullParameter(r102, "stableId");
        boolean r103 = !r101.a(r102 + "#tool-call");
        int r104 = j.f414980b;
        String r105 = r102 + "#tool-call";
        Intrinsics.checkNotNullParameter(r105, "key");
        r101.f414981a.put(r105, Boolean.valueOf(r103));
        this.f414933a.f414900f.invoke();
        LinearLayout r106 = this.f414935c.f414916e;
        if (r103 == false) goto L5;
        int r107 = 0;
    L6:
        r106.setVisibility(r107);
        this.f414935c.f414913b.setSelected(r103);
        ImageView r108 = this.f414935c.f414915d;
        Regex r109 = CotToolCallBlock.f414895r;
        if (r103 == false) goto L9;
        int r110 = R.drawable.ud_icon_down_small_ccm_outlined;
    L10:
        r108.setImageResource(r110);
        return;
    L9:
        r110 = R.drawable.ud_icon_right_small_ccm_outlined;
        goto L10
    L5:
        r107 = 8;
        goto L6
    }
}
