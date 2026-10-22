package com.bytedance.android.shopping.anchorv4.voavhs.guess;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.bst.api.ext.ExtKt;
import com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeLynxView;
import com.bytedance.android.shopping.jedi.JediBaseMultiTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessLynxVH;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/guess/AnchorV4GuessBaseVH;", "Lcom/bytedance/android/shopping/anchorv4/log/c;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnchorV4GuessLynxVH extends AnchorV4GuessBaseVH implements com.bytedance.android.shopping.anchorv4.log.c {
    public final ViewGroup q;
    public final RecyclerView r;
    public final h s;

    public final int q0() {
        return 0;
    }

    public final int v1() {
        return 0;
    }

    public final void E0() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV3GuessULikeLynxView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeLynxView r1 = (AnchorV3GuessULikeLynxView) r0;
    }

    public final void onShow() {
        View r0 = ((RecyclerView.ViewHolder) this).itemView;
        if ((r0 instanceof AnchorV3GuessULikeLynxView) == true) goto L5;
        r0 = null;
    L5:
        AnchorV3GuessULikeLynxView r1 = (AnchorV3GuessULikeLynxView) r0;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final View t() {
        return ((RecyclerView.ViewHolder) this).itemView;
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final /* bridge */ /* synthetic */ void a4(Object r1) {
        e4((j63.c) r1);
    }

    @Override // com.bytedance.android.shopping.anchorv4.voavhs.guess.AnchorV4GuessBaseVH
    public final void e4(j63.c r6) {
        Intrinsics.checkNotNullParameter(r6, "item");
        StringBuilder r0 = new StringBuilder("onBind (");
        int r1 = getAdapterPosition();
        RecyclerView.Adapter r2 = this.r.getAdapter();
        int r3 = 0;
        if (r2 == null) goto L5;
        int r4 = r2.getItemCount();
    L6:
        r0.append("a1.b8094.c7615.d7024_i" + (((r1 - r4) + this.p.C()) + 1));
        r0.append(')');
        ExtKt.b("AnchorV4GuessLynxVH", r0.toString());
        AnchorV3GuessULikeLynxView r5 = ((RecyclerView.ViewHolder) this).itemView;
        if (r5 == null) goto L14;
        AnchorV3GuessULikeLynxView r7 = r5;
        int r8 = getAdapterPosition();
        RecyclerView.Adapter r9 = this.r.getAdapter();
        if (r9 == null) goto L11;
        r3 = r9.getItemCount();
    L11:
        r7.a(r6, ((r8 - r3) + this.p.C()) + 1, this.s);
        return;
    L14:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.anchorv3.view.AnchorV3GuessULikeLynxView");
    L5:
        r4 = 0;
        goto L6
    }

    public AnchorV4GuessLynxVH(ViewGroup r5, com.bytedance.android.shopping.anchorv4.voavhs.lynx.d r6, JediBaseMultiTypeAdapter r7, RecyclerView r8, h r9) {
        Intrinsics.checkNotNullParameter(r5, "viewGroup");
        Intrinsics.checkNotNullParameter(r6, "logManager");
        Intrinsics.checkNotNullParameter(r7, "adapter");
        Intrinsics.checkNotNullParameter(r8, "recyclerView");
        Intrinsics.checkNotNullParameter(r9, "viewModel");
        int r10 = AnchorV3GuessULikeLynxView.f;
        Context r11 = r5.getContext();
        Intrinsics.checkNotNullParameter(r11, "context");
        super(new AnchorV3GuessULikeLynxView(r11, null, 6, 0), r6, r8, r9);
        this.q = r5;
        this.r = r8;
        this.s = r9;
    }
}
