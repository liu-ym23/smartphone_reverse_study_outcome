package pj5;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import com.bytedance.ee.bear.more.fresh.DocFreshNessFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ DocFreshNessFragment b;

    public static final class a implements DialogInterface.OnClickListener {
        public final /* synthetic */ DocFreshNessFragment a;
        public final /* synthetic */ i b;

        public a(DocFreshNessFragment r1, i r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
            DocFreshNessFragment.ea0(this.a, this.b);
        }
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
        }
    }

    public j(boolean r1, DocFreshNessFragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        if (this.a == false) goto L5;
        return;
    L5:
        Context r0 = this.b.getContext();
        if (r0 == null) goto L9;
        String r1 = r0.getString(2131888838);
        if (r1 == null) goto L9;
    L10:
        i r14 = new i(false, r1, false, false, null, false, 0, false, 0, 893);
        DocFreshNessFragment r2 = this.b;
        DocFreshNessFragment.da0(r2, new a(r2, r14), b.a, r2.getString(m.a(r2.l.getFreshInfo().getFreshState())), r14.h);
        return;
    L9:
        r1 = "";
        goto L10
    }
}
