package com.bytedance.android.livesdk.linkvideo.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "b", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "LinkVideoDesPicViewHolder", "LinkVideoDesViewHolder", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LinkVideoListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public final List<hf2.b> a;
    public final Context b;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoListAdapter$LinkVideoDesPicViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkVideoDesPicViewHolder extends RecyclerView.ViewHolder {
        public final View a;
        public final TextView b;
        public final TextView c;
        public final HSImageView d;
        public final HSImageView e;

        public LinkVideoDesPicViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = r2.findViewById(2131377891);
            this.b = (TextView) r2.findViewById(2131388772);
            this.c = (TextView) r2.findViewById(2131368818);
            this.d = r2.findViewById(2131374985);
            this.e = r2.findViewById(2131375063);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/linkvideo/ui/LinkVideoListAdapter$LinkVideoDesViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "room-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LinkVideoDesViewHolder extends RecyclerView.ViewHolder {
        public final TextView a;
        public final TextView b;

        public LinkVideoDesViewHolder(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (TextView) r2.findViewById(2131388772);
            this.b = (TextView) r2.findViewById(2131368818);
        }
    }

    public final int getItemCount() {
        return this.a.size();
    }

    public final Context getContext() {
        return this.b;
    }

    public final int getItemViewType(int r2) {
        return ((hf2.b) ListProtector.get(this.a, r2)).getType();
    }

    public LinkVideoListAdapter(Context r2, List<hf2.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "list");
        this.b = r2;
        this.a = new ArrayList();
        this.a = r3;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "holder");
        hf2.b r6 = (hf2.b) ListProtector.get(this.a, r5);
        if ((r4 instanceof LinkVideoDesViewHolder) == false) goto L11;
        LinkVideoDesViewHolder r7 = (LinkVideoDesViewHolder) r4;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        TextView r0 = r7.a;
        if (r0 == null) goto L7;
        r0.setText(r6.b);
    L7:
        TextView r8 = r7.b;
        if (r8 == null) goto L45;
        r8.setText(r6.c);
        return;
    L45:
        return;
    L11:
        if ((r4 instanceof LinkVideoDesPicViewHolder) == false) goto L47;
        LinkVideoDesPicViewHolder r9 = (LinkVideoDesPicViewHolder) r4;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r6, "data");
        String r1 = r6.b;
        if (r1 != null) goto L15;
    L18:
        boolean r2 = true;
    L19:
        if (r2 == false) goto L26;
        TextView r3 = r9.b;
        if (r3 == null) goto L23;
        r3.setVisibility(8);
    L23:
        View r10 = r9.a;
        if (r10 == null) goto L35;
        r10.setVisibility(8);
    L35:
        TextView r11 = r9.c;
        if (r11 == null) goto L43;
        r11.setText(r6.c);
    L43:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L40
        a1.s(r9.d, r6.d);     // Catch: Throwable -> L40
        a1.s(r9.e, r6.e);     // Catch: Throwable -> L40
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L40
        return;
    L40:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        return;
    L26:
        TextView r14 = r9.b;
        if (r14 == null) goto L29;
        r14.setText(r6.b);
    L29:
        TextView r15 = r9.b;
        if (r15 == null) goto L32;
        r15.setVisibility(0);
    L32:
        View r16 = r9.a;
        if (r16 == null) goto L35;
        r16.setVisibility(0);
        goto L35
    L15:
        if (StringsKt.isBlank(r1) == true) goto L18;
        r2 = false;
        goto L19
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "parent");
        if (r5 == 0) goto L9;
        if (r5 == 1) goto L11;
        return new LinkVideoDesViewHolder(LayoutInflater.from(this.b).inflate(2131566839, r4, false));
    L11:
        return new LinkVideoDesPicViewHolder(LayoutInflater.from(this.b).inflate(2131566840, r4, false));
    L9:
        return new LinkVideoDesViewHolder(LayoutInflater.from(this.b).inflate(2131566839, r4, false));
    }
}
