package fl3;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class f {
    public final Context a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public View h;
    public View i;
    public FrameLayout j;
    public LinearLayout k;
    public RelativeLayout l;
    public final String m;
    public final String n;
    public final String o;
    public final int p;
    public final int q;
    public final DialogInterface.OnClickListener r;
    public final DialogInterface.OnClickListener s;
    public final boolean t;
    public final boolean u;
    public AlertDialog v;

    public static class a {
        public String a;
        public String b;
        public String c;
        public DialogInterface.OnClickListener d;
        public DialogInterface.OnClickListener e;
        public final Context f;
        public int g;
        public int h;
        public boolean i;
        public boolean j;

        public a(Context r3) {
            this.f = r3;
            this.g = th.a.a(r3, 2131101869);
            this.h = th.a.a(r3, 2131101869);
        }
    }

    public f(a r4) {
        Context r0 = r4.f;
        this.a = r0;
        this.m = r4.a;
        this.o = r4.c;
        this.n = r4.b;
        this.r = r4.d;
        this.s = r4.e;
        this.u = r4.j;
        this.t = r4.i;
        this.p = r4.h;
        this.q = r4.g;
        View r5 = th.a.c(th.a.e(r0, true), 2131563308, null, false);
        this.g = r5;
        this.b = (TextView) r5.findViewById(2131391606);
        this.c = (TextView) this.g.findViewById(2131390392);
        TextView r6 = (TextView) this.g.findViewById(2131391369);
        ImageView r7 = (ImageView) this.g.findViewById(2131374686);
        this.d = (TextView) this.g.findViewById(2131390853);
        this.e = (TextView) this.g.findViewById(2131391310);
        this.f = (TextView) this.g.findViewById(2131390866);
        this.l = (RelativeLayout) this.g.findViewById(2131384842);
        RelativeLayout r8 = (RelativeLayout) this.g.findViewById(2131384679);
        this.j = (FrameLayout) this.g.findViewById(2131384722);
        this.k = (LinearLayout) this.g.findViewById(2131378623);
        this.h = this.g.findViewById(2131369232);
        this.i = this.g.findViewById(2131367000);
    }
}
