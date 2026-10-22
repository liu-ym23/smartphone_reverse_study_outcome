package n07;

import android.text.TextUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f516599a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f516600b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f516601c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f516602d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f516603e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f516604f;

    public final String toString() {
        return "SccSettings{mEnableScc=" + this.f516599a + ", mEnablePrefetch=" + this.f516600b + ", mCsMaxWaitMs=" + this.f516601c + ", mSeclinkScene='" + this.f516602d + "', mIsDebug=" + this.f516603e + ", mDomainAllowSet=" + this.f516604f + '}';
    }

    public e() {
        this.f516599a = true;
        this.f516600b = false;
        this.f516601c = 450;
        this.f516602d = null;
        this.f516603e = false;
        this.f516604f = new HashSet();
    }

    public e(e r100) {
        this.f516599a = r100.f516599a;
        this.f516600b = r100.f516600b;
        this.f516601c = r100.f516601c;
        this.f516602d = r100.f516602d;
        this.f516603e = r100.f516603e;
        this.f516604f = new HashSet(r100.f516604f);
    }

    public final f b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return null;
    L5:
        Iterator r101 = ((HashSet) this.f516604f).iterator();
    L7:
        if (r101.hasNext() == false) goto L14;
        String r102 = (String) r101.next();
        if (r100.equals(r102) == true) goto L13;
        if (r100.endsWith("." + r102) == false) goto L7;
    L13:
        return new f(r102);
    L14:
        return null;
    }

    public static void a(JsonObject r100, e r101) {
        int r102 = 0;
        if (b.f516587d.f516599a == false) goto L8;
        if (r100 == null) goto L8;
        if (q07.a.a(r100, "scc_cs_enable", false) == false) goto L8;
        boolean r103 = true;
    L9:
        r101.f516599a = r103;
        if (r103 == true) goto L12;
        return;
    L12:
        r101.f516603e = q07.a.a(r100, "scc_cs_is_debug", r101.f516603e);
        r101.f516600b = q07.a.a(r100, "scc_cs_enable_prefetch", r101.f516600b);
        int r104 = r101.f516601c;
        if (r100 != null) goto L15;
    L23:
        if (r104 > 0) goto L25;
        r104 = 450;
    L25:
        r101.f516601c = r104;
        String r105 = r101.f516602d;
        if (r100 != null) goto L28;
    L36:
        r101.f516602d = r105;
        if (r100 != null) goto L39;
    L47:
        JsonArray r106 = null;
    L48:
        if (r106 != null) goto L50;
        return;
    L50:
        if (r106.size() <= 0) goto L68;
        HashSet r107 = new HashSet();
    L53:
        if (r102 >= r106.size()) goto L61;
        JsonElement r108 = r106.get(r102);
        if (r108.isJsonPrimitive() == false) goto L60;
        if (r108.getAsJsonPrimitive().isString() == false) goto L60;
        r107.add(r108.getAsString());
    L60:
        r102 = r102 + 1;
        goto L53
    L61:
        r101.f516604f.addAll(r107);
        return;
    L68:
        return;
    L39:
        if (r100.has("scc_cs_allow_list") == false) goto L47;
        JsonElement r109 = r100.get("scc_cs_allow_list");
        if (r109.isJsonArray() == false) goto L47;
        if (r109.getAsJsonArray().isJsonArray() == false) goto L47;
        r106 = r109.getAsJsonArray();
        goto L48
    L28:
        if (r100.has("scc_seclink_scene") == false) goto L36;
        JsonElement r110 = r100.get("scc_seclink_scene");
        if (r110.isJsonPrimitive() == false) goto L36;
        if (r110.getAsJsonPrimitive().isString() == false) goto L36;
        r105 = r110.getAsString();
        goto L36
    L15:
        if (r100.has("scc_cs_max_wait_time") == false) goto L23;
        JsonElement r111 = r100.get("scc_cs_max_wait_time");
        if (r111.isJsonPrimitive() == false) goto L23;
        if (r111.getAsJsonPrimitive().isNumber() == false) goto L23;
        r104 = r111.getAsInt();
    L8:
        r103 = false;
        goto L9
    }
}
