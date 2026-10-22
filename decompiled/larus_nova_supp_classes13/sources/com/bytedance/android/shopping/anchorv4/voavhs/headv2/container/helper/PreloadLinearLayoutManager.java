package com.bytedance.android.shopping.anchorv4.voavhs.headv2.container.helper;

import android.content.Context;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.ec.core.anchorv3.PdpPerfOpt;
import com.bytedance.android.ec.core.anchorv3.q;
import com.bytedance.android.shopping.anchorv4.voavhs.headv2.ability.s;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/headv2/container/helper/PreloadLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreloadLinearLayoutManager extends LinearLayoutManager {
    public final int a;
    public boolean b;

    public static final class a extends q {
        public final /* synthetic */ PreloadLinearLayoutManager e;

        public final void c() {
            this.e.b = true;
        }

        public a(PreloadLinearLayoutManager r1) {
            this.e = r1;
            super(3);
        }
    }

    public final int getExtraLayoutSpace(RecyclerView.State r2) {
        int r3 = super.getExtraLayoutSpace(r2);
        if (r3 == 0) goto L5;
        return r3;
    L5:
        if (this.b == true) goto L7;
        return r3;
    L7:
        return this.a;
    }

    public PreloadLinearLayoutManager(Context r2, s r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "headAbility");
        super(r2);
        this.a = com.bytedance.android.shopping.extensions.b.a(10);
        if (PdpPerfOpt.e() == false) goto L5;
        r3.rR().Z(new a(this), false);
        return;
    L5:
        this.b = true;
    }
}
