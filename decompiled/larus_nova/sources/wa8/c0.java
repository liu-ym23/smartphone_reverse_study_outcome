package wa8;

import com.larus.bmhome.actionbar.model.ActionBarItemLocation;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, b0> f558840a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f558841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f558842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f558843c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f558841a, r101.f558841a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f558842b, r101.f558842b) == true) goto L15;
            return false;
        L15:
            if (this.f558843c == r101.f558843c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f558841a.hashCode() * 31) + this.f558842b.hashCode()) * 31) + this.f558843c;
        }

        public final String toString() {
            return "ItemIdentity(scopeId=" + this.f558841a + ", actionBarKey=" + this.f558842b + ", showPosition=" + this.f558843c + ')';
        }

        public a(String r100, String r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "scopeId");
            Intrinsics.checkNotNullParameter(r101, "actionBarKey");
            this.f558841a = r100;
            this.f558842b = r101;
            this.f558843c = r102;
        }
    }

    public c0() {
    }

    static {
        f558840a = new LinkedHashMap();
    }

    public static a c(Map r100, Integer r101) {
        if (r100 == null) goto L47;
        String r102 = (String) r100.get("__action_bar_item_event_scope_id");
        if (r102 == null) goto L47;
        boolean r103 = true;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L47;
        String r104 = (String) r100.get("__action_bar_item_event_key");
        if (r104 == null) goto L47;
        if ((!StringsKt.isBlank(r104)) == true) goto L18;
        r104 = null;
    L18:
        if (r104 == null) goto L47;
        String r105 = (String) r100.get("__action_bar_item_event_position");
        if (r105 == null) goto L23;
        Integer r106 = StringsKt.toIntOrNull(r105);
    L25:
        if (r101 != null) goto L27;
    L35:
        if (r106 != null) goto L37;
    L42:
        r106 = null;
    L43:
        if (r106 == null) goto L47;
        int r107 = r106.intValue();
    L46:
        return new a(r102, r104, r107);
    L37:
        if (r106.intValue() > 0) goto L40;
        r103 = false;
    L40:
        if (r103 == false) goto L42;
    L27:
        if (r101.intValue() <= 0) goto L29;
        boolean r108 = true;
    L30:
        if (r108 == true) goto L33;
        r101 = null;
    L33:
        if (r101 == null) goto L35;
        r107 = r101.intValue();
        goto L46
    L29:
        r108 = false;
        goto L30
    L23:
        r106 = null;
    L47:
        return null;
    }

    public static boolean a(Map r100, ActionBarItemLocation r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "location");
        a r103 = c(r100, r102);
        if (r103 != null) goto L5;
        return false;
    L5:
        Map<String, b0> r104 = f558840a;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        b0 r106 = (b0) r105.get(r103.f558841a);
        if (r106 != null) goto L8;
        return false;
    L8:
        r106.b(r101, r103.f558842b, r103.f558843c);
        return true;
    }

    public static boolean b(Map r100, ActionBarItemLocation r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r101, "location");
        a r103 = c(r100, r102);
        if (r103 != null) goto L5;
        return false;
    L5:
        Map<String, b0> r104 = f558840a;
        LinkedHashMap r105 = (LinkedHashMap) r104;
        b0 r106 = (b0) r105.get(r103.f558841a);
        if (r106 != null) goto L8;
        return false;
    L8:
        r106.a(r101, r103.f558842b, r103.f558843c);
        return true;
    }
}
