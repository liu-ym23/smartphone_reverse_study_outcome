package ox4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a {
    public final JSONObject a;
    public final JSONObject b;
    public final HashMap<String, String> c;
    public final HashMap<String, String> d;
    public final ArrayList<Pair<String, Boolean>> e;
    public final ArrayList<Pair<String, String>> f;
    public final ArrayList<Pair<String, String>> g;
    public final ArrayList<Pair<String, Boolean>> h;
    public final ArrayList<Pair<String, String>> i;
    public final ArrayList<Pair<String, String>> j;

    public a(JSONObject r7, JSONObject r8, HashMap<String, String> r9, HashMap<String, String> r10) {
        Intrinsics.checkNotNullParameter(r9, "rcMap");
        Intrinsics.checkNotNullParameter(r10, "gaMap");
        this.a = r7;
        this.b = r8;
        this.c = r9;
        this.d = r10;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.j = new ArrayList();
        String[] r11 = (String[]) r9.keySet().toArray(new String[0]);
        Arrays.sort(r11);
        int r12 = r11.length;
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L39;
        String r0 = r11[r13];
        if (TextUtils.isEmpty(r0) == true) goto L38;
        String r1 = this.c.get(r0);
        String r2 = this.d.get(r0);
        if (TextUtils.equals(r1, "true") == false) goto L9;
    L29:
        ArrayList<Pair<String, Boolean>> r3 = this.e;
        if (r1 == null) goto L32;
        boolean r4 = Boolean.parseBoolean(r1);
    L33:
        r3.add(new Pair(r0, Boolean.valueOf(r4)));
        ArrayList<Pair<String, Boolean>> r5 = this.h;
        if (r2 == null) goto L36;
        boolean r6 = Boolean.parseBoolean(r2);
    L37:
        r5.add(new Pair(r0, Boolean.valueOf(r6)));
        goto L38
    L36:
        r6 = false;
        goto L37
    L32:
        r4 = false;
        goto L33
    L9:
        if (TextUtils.equals(r1, "false") == true) goto L29;
        if (r1 == null) goto L15;
        boolean r14 = true;
        if (StringsKt.contains$default(r1, "{", false, 2, null) != true) goto L15;
    L17:
        if (r14 == false) goto L22;
        this.g.add(new Pair(r0, r1));
        ArrayList<Pair<String, String>> r16 = this.j;
        if (r2 != null) goto L21;
        r2 = "value is empty";
    L21:
        r16.add(new Pair(r0, r2));
        goto L38
    L22:
        ArrayList<Pair<String, String>> r17 = this.f;
        if (r1 != null) goto L25;
        r1 = "value is empty";
    L25:
        r17.add(new Pair(r0, r1));
        ArrayList<Pair<String, String>> r18 = this.i;
        if (r2 != null) goto L28;
        r2 = "value is empty";
    L28:
        r18.add(new Pair(r0, r2));
    L15:
        r14 = false;
    L38:
        r13 = r13 + 1;
        goto L3
    }
}
