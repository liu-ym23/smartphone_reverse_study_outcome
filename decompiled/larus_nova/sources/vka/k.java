package vka;

import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f555556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f555557b;

    public final Pair<String, String[]> b() {
        if (this.f555556a.length() <= 0) goto L5;
        boolean r100 = true;
    L6:
        String[] r101 = null;
        if (r100 == false) goto L13;
        String r102 = this.f555556a.toString();
        if ((true ^ this.f555557b.isEmpty()) == false) goto L14;
        r101 = (String[]) this.f555557b.toArray(new String[0]);
    L14:
        return TuplesKt.to(r102, r101);
    L13:
        return TuplesKt.to(null, null);
    L5:
        r100 = false;
        goto L6
    }

    public k() {
        this.f555556a = new StringBuilder();
        this.f555557b = new ArrayList();
    }

    public final void a(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "selection");
        if (r101 != null) goto L5;
        return;
    L5:
        if (this.f555556a.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == false) goto L10;
        this.f555556a.append(" AND ");
    L10:
        this.f555556a.append(r100.concat(" = "));
        if ((r101 instanceof Boolean) == false) goto L17;
        StringBuilder r103 = this.f555556a;
        if (((Boolean) r101).booleanValue() == false) goto L15;
        String r104 = "1";
    L16:
        r103.append(r104);
        return;
    L15:
        r104 = "0";
        goto L16
    L17:
        this.f555556a.append("?");
        List<String> r105 = this.f555557b;
        ArrayList r106 = (ArrayList) r105;
        r106.add(r101.toString());
        return;
    L7:
        r102 = false;
        goto L8
    }
}
