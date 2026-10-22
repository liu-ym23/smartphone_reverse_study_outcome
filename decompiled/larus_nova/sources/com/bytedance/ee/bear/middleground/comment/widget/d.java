package com.bytedance.ee.bear.middleground.comment.widget;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class d extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f232327a;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232328a = null;

        static {
            int[] r100 = new int[BotAtHintActionType.values().length];
            r100[BotAtHintActionType.CONFIGURE_NOW.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[BotAtHintActionType.LEARN_MORE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f232328a = r100;
        }
    }

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f232327a = (TextView) r100.findViewById(R.id.bot_at_hint_content);
    }
}
