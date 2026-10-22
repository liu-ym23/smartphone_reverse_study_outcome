package com.bytedance.awemeopen.apps.framework.feed.mix;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.awemeopen.infra.base.image.AoImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/mix/MixAwemeListViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "a", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class MixAwemeListViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int e = 0;
    public final AoImageView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;

    public static final class a {
    }

    static {
    }

    public MixAwemeListViewHolder(View r2, AoImageView r3, TextView r4, TextView r5, TextView r6) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        Intrinsics.checkNotNullParameter(r3, "img");
        Intrinsics.checkNotNullParameter(r4, "desc");
        Intrinsics.checkNotNullParameter(r5, "time");
        Intrinsics.checkNotNullParameter(r6, "likeCount");
        super(r2);
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }
}
