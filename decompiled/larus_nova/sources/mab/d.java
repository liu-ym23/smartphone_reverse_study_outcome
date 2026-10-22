package mab;

import android.content.Context;
import java.util.Arrays;

/* JADX INFO: loaded from: classes35.dex */
public final class d extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String[] f512740e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f512741f;

    @Override // mab.c, android.widget.Adapter
    public final int getCount() {
        if (this.f512740e != null) goto L9;
        this.f512740e = new String[35];
        int r100 = 0;
    L6:
        if (r100 >= 31) goto L9;
        int r101 = r100 + 1;
        this.f512740e[r100] = String.valueOf(r101);
        r100 = r101;
    L9:
        return this.f512740e.length;
    }

    @Override // mab.c
    public final String a(int r100) {
        if (r100 >= 0) goto L4;
        return "";
    L4:
        if (r100 < 31) goto L6;
        return "";
    L6:
        return this.f512740e[r100];
    }

    public final void c(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 < 31) goto L6;
        return;
    L6:
        if (this.f512741f.booleanValue() == false) goto L16;
        this.f512736a[r100] = true;
        int r101 = 0;
    L8:
        boolean[] r102 = this.f512736a;
        if (r101 >= r102.length) goto L17;
        boolean r103 = r102[r101];
        if (r103 == false) goto L15;
        if (r101 == r100) goto L15;
        r102[r101] = !r103;
    L15:
        r101 = r101 + 1;
    L17:
        notifyDataSetChanged();
        return;
    L16:
        boolean[] r104 = this.f512736a;
        r104[r100] = true ^ r104[r100];
        goto L17
    }

    public d(Context r100, int r101) {
        super(r100, 7, r101);
        this.f512741f = Boolean.FALSE;
        boolean[] r102 = new boolean[this.f512740e.length];
        this.f512736a = r102;
        Arrays.fill(r102, false);
    }
}
