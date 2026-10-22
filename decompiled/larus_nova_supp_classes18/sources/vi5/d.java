package vi5;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public final Context a;
    public final ArrayList<c> b;

    public final Context getContext() {
        return this.a;
    }

    public d(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.b = new ArrayList(4);
    }

    public final void a(View.OnClickListener r10) {
        Intrinsics.checkNotNullParameter(r10, "clickListener");
        int r1 = b.a;
        String r2 = this.a.getString(2131887736);
        Intrinsics.checkNotNullParameter(r2, "desc");
        Intrinsics.checkNotNullParameter(r10, "clickListener");
        c r0 = new c(r2, 2131102093, "", false, true, true, r10);
        this.b.add(r0);
    }

    public static void d(d r9, boolean r10, boolean r11, View.OnClickListener r12) {
        Intrinsics.checkNotNullParameter(r12, "clickListener");
        int r1 = b.a;
        String r2 = r9.a.getString(2131888241);
        Intrinsics.checkNotNullParameter(r2, "desc");
        Intrinsics.checkNotNullParameter(r12, "clickListener");
        c r0 = new c(r2, 2131106622, "", r10, r11, false, r12);
        r9.b.add(r0);
    }

    public final void b(boolean r10, boolean r11, View.OnClickListener r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "clickListener");
        if (r13 == true) goto L5;
        return;
    L5:
        int r14 = b.a;
        String r2 = this.a.getString(2131888210);
        Intrinsics.checkNotNullParameter(r2, "desc");
        Intrinsics.checkNotNullParameter(r12, "clickListener");
        c r15 = new c(r2, 2131106622, "", r10, r11, false, r12);
        this.b.add(r15);
    }

    public final void c(boolean r10, boolean r11, boolean r12, boolean r13, View.OnClickListener r14) {
        Intrinsics.checkNotNullParameter(r14, "clickListener");
        if (r10 == true) goto L5;
        return;
    L5:
        if (r13 == false) goto L7;
        int r15 = 2131887511;
    L8:
        int r16 = b.a;
        String r2 = this.a.getString(2131887512);
        Intrinsics.checkNotNullParameter(r2, "desc");
        String r4 = this.a.getString(r15);
        Intrinsics.checkNotNullParameter(r4, "tips");
        Intrinsics.checkNotNullParameter(r14, "clickListener");
        c r17 = new c(r2, 2131106622, r4, r12, r11, false, r14);
        this.b.add(r17);
        return;
    L7:
        r15 = 2131887247;
        goto L8
    }
}
