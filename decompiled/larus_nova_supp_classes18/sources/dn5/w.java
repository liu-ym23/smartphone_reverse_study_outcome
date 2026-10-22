package dn5;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class w extends RecyclerView.OnScrollListener {
    public boolean a;
    public boolean b;
    public final /* synthetic */ RecyclerView c;
    public final /* synthetic */ com.bytedance.ee.bear.document.onboarding.c d;
    public final /* synthetic */ FragmentActivity e;
    public final /* synthetic */ uk5.c f;

    public final void onScrollStateChanged(RecyclerView r3, int r4) {
        super.onScrollStateChanged(r3, r4);
        if (r4 == 0) goto L5;
        return;
    L5:
        if (this.a == true) goto L8;
        this.a = true;
        this.c.smoothScrollToPosition(0);
        return;
    L8:
        if (this.b == true) goto L13;
        this.b = true;
        this.d.c(this.e.getWindow(), this.f, null);
        this.c.removeOnScrollListener(this);
        return;
    }

    public w(RecyclerView r1, com.bytedance.ee.bear.document.onboarding.c r2, FragmentActivity r3, uk5.c r4) {
        this.c = r1;
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.a = false;
        this.b = false;
    }
}
