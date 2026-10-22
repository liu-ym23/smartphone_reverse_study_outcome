package rd4;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C7463a f537260c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, d> f537261d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f537262a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f537263b;

    /* JADX INFO: renamed from: rd4.a$a, reason: collision with other inner class name */
    public static final class C7463a {
        public C7463a() {
        }

        public static a a(JSONObject r100) {
            if (r100 == null) goto L4;
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L19
            JSONArray r102 = r100.optJSONArray("timeout_config_list");     // Catch: Throwable -> L19
            if (r102 != null) goto L8;
            r102 = new JSONArray();     // Catch: Throwable -> L19
        L8:
            JSONArray r103 = r100.optJSONArray("page_config_list");     // Catch: Throwable -> L19
            if (r103 != null) goto L11;
            r103 = new JSONArray();     // Catch: Throwable -> L19
        L11:
            ArrayList r104 = new ArrayList();     // Catch: Throwable -> L19
            ArrayList r105 = new ArrayList();     // Catch: Throwable -> L19
            int r106 = r102.length();     // Catch: Throwable -> L19
            int r107 = 0;
            int r108 = 0;
        L12:
            if (r108 >= r106) goto L14;
            c.a r109 = c.f537267d;     // Catch: Throwable -> L19
            JSONObject r110 = r102.optJSONObject(r108);     // Catch: Throwable -> L19
            r109.getClass();     // Catch: Throwable -> L19
            r104.add(c.a.a(r110));     // Catch: Throwable -> L19
            r108 = r108 + 1;     // Catch: Throwable -> L19
            goto L12
        L14:
            int r111 = r103.length();     // Catch: Throwable -> L19
        L15:
            if (r107 >= r111) goto L17;
            b.a r112 = b.f537264c;     // Catch: Throwable -> L19
            JSONObject r113 = r103.optJSONObject(r107);     // Catch: Throwable -> L19
            r112.getClass();     // Catch: Throwable -> L19
            r105.add(b.a.a(r113));     // Catch: Throwable -> L19
            r107 = r107 + 1;     // Catch: Throwable -> L19
            goto L15
        L17:
            return new a(r104, r105);
        L19:
            th = move-exception;
            Result.Companion r114 = Result.Companion;
            Result.m9449constructorimpl(ResultKt.createFailure(th));
            return new a();
        L4:
            return new a();
        }

        public static void b(String r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            HashMap<String, d> r101 = a.f537261d;
            if (r101.containsKey(r100) == false) goto L7;
            d r102 = r101.get(r100);
        L8:
            if (r102 == null) goto L11;
            r102.f537272b++;
            r102.f537271a.add(Long.valueOf(System.currentTimeMillis()));
            return;
        L11:
            return;
        L7:
            r101.put(r100, new d(r100));
            r102 = r101.get(r100);
            goto L8
        }
    }

    static {
        f537260c = new C7463a();
        f537261d = new HashMap();
    }

    public /* synthetic */ a() {
        this(new ArrayList(), new ArrayList());
    }

    public final boolean a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Iterator<T> r101 = this.f537263b.iterator();
    L3:
        boolean r102 = false;
        if (r101.hasNext() == false) goto L12;
        b r103 = (b) r101.next();
        r103.getClass();
        Intrinsics.checkNotNullParameter(r100, "url");
        if (Intrinsics.areEqual(r100, r103.f537266b) == false) goto L10;
        if (r103.f537265a.contains(Integer.valueOf(Calendar.getInstance().get(5))) == false) goto L10;
        r102 = true;
    L10:
        if (r102 == false) goto L3;
        return true;
    L12:
        return false;
    }

    public final boolean b(String r110) {
        Intrinsics.checkNotNullParameter(r110, "url");
        d r100 = f537261d.get(r110);
        if (r100 != null) goto L5;
        return false;
    L5:
        Iterator<T> r101 = this.f537262a.iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((c) r102).f537269b, r110) == false) goto L7;
    L12:
        c r103 = (c) r102;
        if (r103 != null) goto L15;
        return false;
    L15:
        Intrinsics.checkNotNullParameter(r100, "records");
        if (r100.f537272b < r103.f537270c) goto L41;
        ArrayList<Long> r111 = r100.f537271a;
        if (r111.size() < r103.f537270c) goto L42;
        int r104 = r111.size() - r103.f537270c;
        if (r104 >= 0) goto L25;
        return false;
    L25:
        if ((!r111.isEmpty()) == true) goto L27;
    L29:
        long r105 = -1;
    L31:
        if (r105 > 0) goto L34;
        return false;
    L34:
        if (r105 >= r103.f537268a) goto L40;
        return true;
    L40:
        return false;
    L27:
        if (r111.size() <= r104) goto L29;
        r105 = ((Number) CollectionsKt.last(r111)).longValue() - ((Number) ListProtector.get(r111, r104)).longValue();
        goto L31
    L42:
        return false;
    L41:
        return false;
    L11:
        r102 = null;
        goto L12
    }

    public a(ArrayList<c> r100, ArrayList<b> r101) {
        Intrinsics.checkNotNullParameter(r100, "timeConfig");
        Intrinsics.checkNotNullParameter(r101, "pageConfig");
        this.f537262a = r100;
        this.f537263b = r101;
    }
}
