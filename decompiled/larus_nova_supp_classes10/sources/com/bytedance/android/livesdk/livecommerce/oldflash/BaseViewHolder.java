package com.bytedance.android.livesdk.livecommerce.oldflash;

import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.livecommerce.utils.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/oldflash/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
    public LiveFlashViewModel a;
    public View b;

    public abstract void T3(b r1, int r2);

    public BaseViewHolder(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super(r2);
    }

    public final void U3(boolean r3) {
        View r0 = this.b;
        if (r0 == null) goto L13;
        if (r3 == false) goto L10;
        LiveFlashViewModel r4 = this.a;
        if (r4 == null) goto L10;
        if (r4.getShowErrorLine() != true) goto L10;
        int r5 = 2131101651;
    L11:
        r0.setBackgroundColor(ContextCompat.getColor(w0.getContext(), r5));
        return;
    L10:
        r5 = 2131101531;
        goto L11
    }
}
