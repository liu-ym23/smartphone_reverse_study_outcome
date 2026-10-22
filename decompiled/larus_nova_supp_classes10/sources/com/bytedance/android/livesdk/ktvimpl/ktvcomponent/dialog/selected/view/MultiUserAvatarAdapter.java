package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/selected/view/MultiUserAvatarAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/content/Context;", "d", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "context", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MultiUserAvatarAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public int a;
    public List<k> b;
    public int c;
    public final Context d;

    public static final class a {
    }

    static {
    }

    public final int getItemCount() {
        return this.b.size();
    }

    public final Context getContext() {
        return this.d;
    }

    public MultiUserAvatarAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.d = r2;
        this.b = new ArrayList();
        this.c = 4;
    }

    public final int getItemViewType(int r3) {
        int r0 = this.c;
        if (r3 == (r0 - 1)) goto L5;
        return 0;
    L5:
        if (this.a <= r0) goto L10;
        return 1;
    L10:
        return 0;
    }

    public final void onBindViewHolder(RecyclerView.ViewHolder r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "holder");
        k r4 = (k) ListProtector.get(this.b, r3);
        if ((r2 instanceof MultiUserAvatarViewHolder) == false) goto L8;
        MultiUserAvatarViewHolder r5 = (MultiUserAvatarViewHolder) r2;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r4, "avatarThumb");
        ImageView r6 = r5.a;
        if (r6 == null) goto L9;
        ImageUtil.loadRoundImage(r6, r4);
        return;
    L9:
        return;
    }

    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parent");
        if (r4 == 0) goto L5;
        int r5 = 2131567006;
    L7:
        return new MultiUserAvatarViewHolder(LayoutInflater.from(this.d).inflate(r5, r3, false));
    L5:
        r5 = 2131567005;
        goto L7
    }
}
