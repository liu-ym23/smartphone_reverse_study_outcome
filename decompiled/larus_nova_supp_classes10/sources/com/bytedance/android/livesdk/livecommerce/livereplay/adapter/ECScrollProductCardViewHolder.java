package com.bytedance.android.livesdk.livecommerce.livereplay.adapter;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.kiwi.ui.QUIManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ni2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/livereplay/adapter/ECScrollProductCardViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECScrollProductCardViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int c = 0;
    public final QUIManager a;
    public final b b;

    public static final class a {
        public static ECScrollProductCardViewHolder a(Context r3, b r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            Intrinsics.checkNotNullParameter(r4, "params");
            QUIManager r0 = new QUIManager();
            int r1 = com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.a;
            if (com.bytedance.android.livesdk.livecommerce.livereplay.utils.a.b(r4.h) == false) goto L5;
            r0.l(new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a(r4), r3, true);
        L7:
            return new ECScrollProductCardViewHolder(r0, r4);
        L5:
            r0.l(new com.bytedance.android.livesdk.livecommerce.livereplay.adapter.module.a(r4), r3, false);
            goto L7
        }
    }

    static {
    }

    public ECScrollProductCardViewHolder(QUIManager r2, b r3) {
        super(r2.p());
        this.a = r2;
        this.b = r3;
    }
}
