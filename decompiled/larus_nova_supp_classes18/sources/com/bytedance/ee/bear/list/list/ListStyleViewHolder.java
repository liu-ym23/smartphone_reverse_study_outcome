package com.bytedance.ee.bear.list.list;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.ee.bear.facade.common.widget.recyclerview.SwipeMenuLayout;
import com.bytedance.ee.bear.list.docstate.SyncStateView;
import com.bytedance.ee.bear.widgets.tagview.SpaceTagTitleView;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class ListStyleViewHolder extends BaseViewHolder {
    public final SwipeMenuLayout a;
    public final ConstraintLayout b;
    public final SpaceTagTitleView c;
    public final TextView d;
    public final View e;
    public final ImageView f;
    public final ImageView g;
    public final ImageView h;
    public final ImageView i;
    public final ImageView j;
    public final ImageView k;
    public final SyncStateView l;
    public final TextView m;
    public final TextView n;
    public final AppCompatImageView o;
    public int p;
    public final a q;

    public class a implements Runnable {
        public final /* synthetic */ ListStyleViewHolder a;

        @Override // java.lang.Runnable
        public final void run() {
            this.a.T3(0);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(ListStyleViewHolder r1) {
            this.a = r1;
        }
    }

    public ListStyleViewHolder(View r2) {
        super(r2);
        this.q = new a(this);
        this.a = r2.findViewById(2131378129);
        this.b = r2.findViewById(2131375720);
        this.c = (SpaceTagTitleView) r2.findViewById(2131375808);
        this.d = (TextView) r2.findViewById(2131391910);
        this.e = r2.findViewById(2131381790);
        this.f = (ImageView) r2.findViewById(2131375773);
        this.g = (ImageView) r2.findViewById(2131375843);
        this.h = (ImageView) r2.findViewById(2131387821);
        this.i = (ImageView) r2.findViewById(2131387823);
        this.j = (ImageView) r2.findViewById(2131387819);
        this.l = (SyncStateView) r2.findViewById(2131375856);
        this.m = (TextView) r2.findViewById(2131378144);
        this.n = (TextView) r2.findViewById(2131378141);
        this.o = r2.findViewById(2131375745);
        this.k = (ImageView) r2.findViewById(2131378165);
    }

    public final void T3(int r7) {
        tt5.a.h("ListStyleViewHolder", "setSyncState()...state = " + r7 + ", preState = " + this.p + ", securityVisible = false");
        switch(r7) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L6;
            case 8: goto L5;
            default: goto L4;
        };
    L4:
        this.d.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        this.m.removeCallbacks(this.q);
    L20:
        this.p = r7;
        return;
    L5:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887940);
        goto L20
    L6:
        int r4 = this.p;
        if (r4 != 5) goto L9;
    L12:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887941);
        this.q.getClass();
        this.m.postDelayed(this.q, 1000);
        goto L20
    L9:
        if (r4 == 6) goto L12;
        this.d.setVisibility(0);
        this.n.setVisibility(8);
        this.m.setVisibility(8);
        goto L20
    L13:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887943);
        goto L20
    L14:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887950);
        goto L20
    L15:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887990);
        goto L20
    L16:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131888036);
        this.m.postDelayed(this.q, 1000);
        goto L20
    L17:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131887991);
        goto L20
    L18:
        this.d.setVisibility(8);
        this.n.setVisibility(8);
        this.m.setVisibility(0);
        this.m.setText(2131888012);
        goto L20
    }
}
