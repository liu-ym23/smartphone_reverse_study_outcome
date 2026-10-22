package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/LiveFlashListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/android/livesdk/livecommerce/oldflash/BaseViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFlashListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public final List<b> a;
    public final LayoutInflater b;
    public final LiveFlashViewModel c;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        Iterator r0 = ((ArrayList) this.a).iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        b r2 = (b) r0.next();
        r1 = r1 + 1;
        if ((r2 instanceof f) == false) goto L4;
        if (((f) r2).b == true) goto L4;
    L9:
        return r1;
    }

    public final int getItemViewType(int r4) {
        b r0 = (b) ListProtector.get(this.a, r4);
        if ((r0 instanceof com.bytedance.android.livesdk.livecommerce.oldflash.a) == false) goto L6;
        return 4;
    L6:
        if ((r0 instanceof e) == false) goto L9;
        return 0;
    L9:
        if ((r0 instanceof k) == false) goto L12;
    L10:
        return 1;
    L12:
        if ((r0 instanceof h) == true) goto L10;
        if ((r0 instanceof f) == false) goto L18;
        return 2;
    L18:
        if ((r0 instanceof l) == false) goto L21;
        return 3;
    L21:
        if ((r0 instanceof j) == false) goto L24;
        return 5;
    L24:
        if ((r0 instanceof g) == false) goto L27;
        return 6;
    L27:
        if ((r0 instanceof d) == false) goto L31;
        return 7;
    L31:
        throw new IllegalStateException("Invalid type ".concat(((b) ListProtector.get(this.a, r4)).getClass().getName()).toString());
    }

    public LiveFlashListAdapter(Context r2, LiveFlashViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.c = r3;
        this.a = new ArrayList();
        this.b = LayoutInflater.from(th.a.e(r2, true));
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        BaseViewHolder r4 = (BaseViewHolder) r2;
        Intrinsics.checkNotNullParameter(r4, "viewHolder");
        r4.T3((b) ListProtector.get(this.a, r3), r3);
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        switch(r5) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        BaseViewHolder r6 = new g0(this.b.inflate(2131560705, r4, false));
    L14:
        r6.a = this.c;
        return r6;
    L7:
        r6 = new j0(this.b.inflate(2131560708, r4, false));
        goto L14
    L8:
        r6 = new k0(this.b.inflate(2131560710, r4, false));
        goto L14
    L9:
        r6 = new f0(this.b.inflate(2131560704, r4, false));
        goto L14
    L10:
        r6 = new m0(this.b.inflate(2131560712, r4, false));
        goto L14
    L11:
        r6 = new i0(this.b.inflate(2131560707, r4, false));
        goto L14
    L12:
        r6 = new l0(this.b.inflate(2131560711, r4, false));
        goto L14
    L13:
        r6 = new h0(this.b.inflate(2131560706, r4, false));
        goto L14
    L5:
        throw new IllegalStateException(("Invalid type " + r5).toString());
    }
}
