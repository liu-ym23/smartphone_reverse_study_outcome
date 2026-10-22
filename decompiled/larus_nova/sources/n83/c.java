package n83;

import android.widget.RelativeLayout;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f518250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f518251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final RelativeLayout.LayoutParams f518252d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f518249a, r101.f518249a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f518250b, r101.f518250b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f518251c, r101.f518251c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f518252d, r101.f518252d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f518249a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Long r104 = this.f518250b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        HashMap<String, String> r107 = this.f518251c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        RelativeLayout.LayoutParams r110 = this.f518252d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECFloatExtra(requestPage=" + this.f518249a + ", enterRoomId=" + this.f518250b + ", mobParams=" + this.f518251c + ", params=" + this.f518252d + ")";
    }

    public c() {
        this("", null, null, null);
    }

    public c(String r100, Long r101, HashMap<String, String> r102, RelativeLayout.LayoutParams r103) {
        Intrinsics.checkNotNullParameter(r100, "requestPage");
        this.f518249a = r100;
        this.f518250b = r101;
        this.f518251c = r102;
        this.f518252d = r103;
    }
}
