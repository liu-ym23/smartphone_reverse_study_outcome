package ox4;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f527080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JSONObject f527081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, String> f527082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f527083d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList<Pair<String, Boolean>> f527084e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f527085f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f527086g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<Pair<String, Boolean>> f527087h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f527088i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<Pair<String, String>> f527089j;

    public a(JSONObject r100, JSONObject r101, HashMap<String, String> r102, HashMap<String, String> r110) {
        Intrinsics.checkNotNullParameter(r102, "rcMap");
        Intrinsics.checkNotNullParameter(r110, "gaMap");
        this.f527080a = r100;
        this.f527081b = r101;
        this.f527082c = r102;
        this.f527083d = r110;
        this.f527084e = new ArrayList();
        this.f527085f = new ArrayList();
        this.f527086g = new ArrayList();
        this.f527087h = new ArrayList();
        this.f527088i = new ArrayList();
        this.f527089j = new ArrayList();
        String[] r103 = (String[]) r102.keySet().toArray(new String[0]);
        Arrays.sort(r103);
        int r104 = r103.length;
        int r111 = 0;
    L3:
        if (r111 >= r104) goto L39;
        String r105 = r103[r111];
        if (TextUtils.isEmpty(r105) == true) goto L38;
        String r106 = this.f527082c.get(r105);
        String r107 = this.f527083d.get(r105);
        if (TextUtils.equals(r106, "true") == false) goto L9;
    L29:
        ArrayList<Pair<String, Boolean>> r108 = this.f527084e;
        if (r106 == null) goto L32;
        boolean r109 = Boolean.parseBoolean(r106);
    L33:
        r108.add(new Pair(r105, Boolean.valueOf(r109)));
        ArrayList<Pair<String, Boolean>> r112 = this.f527087h;
        if (r107 == null) goto L36;
        boolean r113 = Boolean.parseBoolean(r107);
    L37:
        r112.add(new Pair(r105, Boolean.valueOf(r113)));
        goto L38
    L36:
        r113 = false;
        goto L37
    L32:
        r109 = false;
        goto L33
    L9:
        if (TextUtils.equals(r106, "false") == true) goto L29;
        if (r106 == null) goto L15;
        boolean r114 = true;
        if (StringsKt.contains$default(r106, "{", false, 2, null) != true) goto L15;
    L17:
        if (r114 == false) goto L22;
        this.f527086g.add(new Pair(r105, r106));
        ArrayList<Pair<String, String>> r115 = this.f527089j;
        if (r107 != null) goto L21;
        r107 = "value is empty";
    L21:
        r115.add(new Pair(r105, r107));
        goto L38
    L22:
        ArrayList<Pair<String, String>> r116 = this.f527085f;
        if (r106 != null) goto L25;
        r106 = "value is empty";
    L25:
        r116.add(new Pair(r105, r106));
        ArrayList<Pair<String, String>> r117 = this.f527088i;
        if (r107 != null) goto L28;
        r107 = "value is empty";
    L28:
        r117.add(new Pair(r105, r107));
    L15:
        r114 = false;
    L38:
        r111 = r111 + 1;
        goto L3
    }
}
