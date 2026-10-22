package com.ss.android.ugc.aweme.discover.adapter;

import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.LiveTextView;
import com.bytedance.android.livesdk.r3;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.utils.landscape.b;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qa1.c;
import ra1.g;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0002\u0002\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/adapter/LiveSearchSugHistoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "OnDeleteItemClickListener", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveSearchSugHistoryViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Companion f450012b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f450013a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/adapter/LiveSearchSugHistoryViewHolder$Companion;", "", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/adapter/LiveSearchSugHistoryViewHolder$OnDeleteItemClickListener;", "", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface OnDeleteItemClickListener {
        void a(int r100);
    }

    static {
        f450012b = new Companion(0);
    }

    public LiveSearchSugHistoryViewHolder(View r100, c r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f450013a = r101;
        if (b.b() == true) goto L5;
        boolean r102 = false;
    L6:
        if (r102 == false) goto L9;
        ((ImageView) r100.findViewById(R.id.iv_delete)).setPadding(s1.f(20.0f), 0, 0, 0);
        return;
    L9:
        return;
    L5:
        r102 = e5.n();
        goto L6
    }

    public final void T3(final g r100, final String r101, final int r102, final OnDeleteItemClickListener r103) {
        Intrinsics.checkNotNullParameter(r100, "searchSugEntity");
        Intrinsics.checkNotNullParameter(r101, "requestId");
        Intrinsics.checkNotNullParameter(r103, "listener");
        ((LiveTextView) this.itemView.findViewById(R.id.tv_content)).setText(r100.a());
        ((LiveTextView) this.itemView.findViewById(R.id.tv_content)).setOnClickListener(new LiveSearchSugHistoryViewHolder$bind$1(this, r100, r102, r101));
        ((ImageView) this.itemView.findViewById(R.id.iv_delete)).setOnClickListener(new LiveSearchSugHistoryViewHolder$bind$2(this, r100, r102, r103));
        r3.a(this.itemView.findViewById(R.id.iv_delete), s1.B(R.string.ttlive_a11y_delete));
    }
}
