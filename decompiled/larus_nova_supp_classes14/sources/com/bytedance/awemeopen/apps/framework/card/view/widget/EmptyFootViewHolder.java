package com.bytedance.awemeopen.apps.framework.card.view.widget;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class EmptyFootViewHolder extends RecyclerView.ViewHolder {
    public static final /* synthetic */ int f = 0;
    public final LoadingMoreView a;
    public final TextView b;
    public final View c;
    public final View d;
    public final View e;

    public EmptyFootViewHolder(View r2) {
        super(r2);
        this.a = (LoadingMoreView) r2.findViewById(2131380286);
        this.b = (TextView) r2.findViewById(2131388741);
        this.c = r2.findViewById(2131362944);
        this.d = r2.findViewById(2131362946);
        this.e = r2.findViewById(2131362945);
        r2.setVisibility(0);
    }

    public final void T3(View r4) {
        TextView r0 = this.b;
        r0.setText(r0.getResources().getString(2131894292));
        LoadingMoreView r1 = this.a;
        r1.g = 0.0f;
        r1.invalidate();
        View r2 = this.c;
        if (r2 == null) goto L5;
        LinearLayout.LayoutParams r3 = (LinearLayout.LayoutParams) r2.getLayoutParams();
        r3.width = 0;
        this.c.setLayoutParams(r3);
    L5:
        View r5 = this.d;
        if (r5 == null) goto L8;
        LinearLayout.LayoutParams r6 = (LinearLayout.LayoutParams) r5.getLayoutParams();
        r6.width = 0;
        this.d.setLayoutParams(r6);
    L8:
        if (r4 == null) goto L11;
        r4.scrollTo(0, r4.getScrollY());
        return;
    }
}
