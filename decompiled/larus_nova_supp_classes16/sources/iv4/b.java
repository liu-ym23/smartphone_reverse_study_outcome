package iv4;

import android.content.Context;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import h18.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public boolean a;
    public float b;
    public int c;
    public int d;

    public final void a(TextView r3) {
        Intrinsics.checkNotNullParameter(r3, "view");
        if (this.a == false) goto L5;
        int r0 = e.a;
        r3.setTypeface(e.b(r3.getContext(), 1));
        return;
    L5:
        int r1 = e.a;
        r3.setTypeface(e.b(r3.getContext(), 0));
    }

    public final Integer c(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return Integer.valueOf(ContextCompat.getColor(r2, this.d));
    }

    public final boolean equals(Object r5) {
        if ((r5 instanceof b) == true) goto L5;
        return false;
    L5:
        b r6 = (b) r5;
        if (this.a == r6.a) goto L8;
        return false;
    L8:
        if (this.b != r6.b) goto L10;
        boolean r0 = true;
    L11:
        if (r0 == true) goto L13;
        return false;
    L13:
        if (this.c == r6.c) goto L15;
        return false;
    L15:
        if (this.d != r6.d) goto L21;
        return true;
    L21:
        return false;
    L10:
        r0 = false;
        goto L11
    }

    public final void b(TextView r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        float r0 = this.b;
        if (r3 == false) goto L5;
        int r4 = -2;
    L6:
        r2.setTextSize(r0 + r4);
        return;
    L5:
        r4 = 0;
        goto L6
    }

    public b(boolean r1, float r2, int r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public /* synthetic */ b(boolean r2, float r3, int r4, int r5, int r6) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 14.0f;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 1;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 2131106622;
    L14:
        this(r2, r3, r4, r5);
    }
}
