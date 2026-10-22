package com.bytedance.ee.bear.middleground.comment.widget;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d extends RecyclerView.ViewHolder {
    public final TextView a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[BotAtHintActionType.values().length];
            r0[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[BotAtHintActionType.LEARN_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    public d(View r2) {
        Intrinsics.checkNotNullParameter(r2, "itemView");
        super(r2);
        this.a = (TextView) r2.findViewById(2131364349);
    }
}
