package com.bytedance.android.livesdk.livecommerce.oldflash.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0003\u0004\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/search/SearchListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "b", "c", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<k> a;
    public final Function1<Pair<String, String>, Unit> b;

    public static final class a {
    }

    public static final class b extends RecyclerView.ViewHolder {
        public final TextView a;
        public final ImageView b;

        public b(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390394);
            this.b = (ImageView) r2.findViewById(2131376593);
        }
    }

    public static final class c extends RecyclerView.ViewHolder {
        public final TextView a;

        public c(View r2) {
            Intrinsics.checkNotNullParameter(r2, "view");
            super(r2);
            this.a = (TextView) r2.findViewById(2131390737);
        }
    }

    public static final class d implements View.OnClickListener {
        public final /* synthetic */ i a;
        public final /* synthetic */ SearchListAdapter b;

        public d(i r1, SearchListAdapter r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            Function1<Pair<String, String>, Unit> r4 = this.b.b;
            i r0 = this.a;
            r4.invoke(TuplesKt.to(r0.a, r0.b));
        }
    }

    static {
    }

    public final int getItemCount() {
        return ((ArrayList) this.a).size();
    }

    public SearchListAdapter(Function1<? super Pair<String, String>, Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "clickCallback");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final int getItemViewType(int r3) {
        k r0 = (k) ListProtector.get(this.a, r3);
        if ((r0 instanceof j) == false) goto L6;
        return 0;
    L6:
        if ((r0 instanceof i) == false) goto L10;
        return 1;
    L10:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.a, r3)).getClass().getName()).toString());
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "holder");
        k r0 = (k) ListProtector.get(this.a, r7);
        k r2 = null;
        if ((r6 instanceof c) == false) goto L11;
        if ((r0 instanceof j) == true) goto L7;
        r0 = null;
    L7:
        j r1 = (j) r0;
        if (r1 == null) goto L30;
        ((c) r6).a.setText(r1.a);
        return;
    L30:
        return;
    L11:
        if ((r6 instanceof b) == false) goto L29;
        if ((r0 instanceof i) == false) goto L16;
        r2 = r0;
    L16:
        i r3 = (i) r2;
        if (r3 == null) goto L32;
        b r8 = (b) r6;
        TextView r4 = r8.a;
        r4.setText(r0.a);
        Context r5 = r4.getContext();
        i r9 = (i) r0;
        if (r9.c == false) goto L21;
        int r10 = 2131101581;
    L22:
        r4.setTextColor(th.a.a(r5, r10));
        ImageView r11 = r8.b;
        if (r9.c == false) goto L25;
        int r12 = 0;
    L26:
        r11.setVisibility(r12);
        r6.itemView.setOnClickListener(new d(r3, this));
        return;
    L25:
        r12 = 8;
        goto L26
    L21:
        r10 = 2131101610;
        goto L22
    L32:
        return;
    L29:
        throw new IllegalStateException("Invalid type ".concat(((k) ListProtector.get(this.a, r7)).getClass().getName()).toString());
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parent");
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L8;
        return new b(y2(this, 2131560836, r2));
    L8:
        throw new IllegalStateException(("Invalid type " + r3).toString());
    L10:
        return new c(y2(this, 2131560835, r2));
    }

    public static View y2(SearchListAdapter r1, int r2, ViewGroup r3) {
        r1.getClass();
        Context r4 = r3.getContext();
        if (r4 == null) goto L5;
        Context r5 = th.a.e(r4, true);
    L7:
        return LayoutInflater.from(r5).inflate(r2, r3, false);
    L5:
        r5 = null;
        goto L7
    }
}
