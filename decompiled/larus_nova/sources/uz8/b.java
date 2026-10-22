package uz8;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f552201e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f552202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f552203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f552204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f552205d;

    public static final class a {
        public static String a(List r100) {
            Intrinsics.checkNotNullParameter(r100, "featureDetails");
            if (r100.isEmpty() == false) goto L6;
            return null;
        L6:
            LinkedHashMap r101 = new LinkedHashMap();
            Iterator r102 = r100.iterator();
        L8:
            if (r102.hasNext() == false) goto L10;
            C7949b r103 = (C7949b) r102.next();
            r101.put(r103.f552207a, r103.f552208b);
            goto L8
        L10:
            JSONArray r104 = new JSONArray();
            Iterator r105 = r101.entrySet().iterator();
        L12:
            if (r105.hasNext() == false) goto L15;
            Map.Entry r106 = (Map.Entry) r105.next();
            String r107 = (String) r106.getKey();
            String r108 = (String) r106.getValue();
            JSONObject r109 = new JSONObject();
            r109.put("feature_type", r107);
            r109.put("feature_detail", r108);
            r104.put(r109);
            goto L12
        L15:
            return r104.toString();
        }
    }

    /* JADX INFO: renamed from: uz8.b$b, reason: collision with other inner class name */
    public static final class C7949b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final /* synthetic */ int f552206c = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f552207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f552208b;

        /* JADX INFO: renamed from: uz8.b$b$a */
        public static final class a {
            public static C7949b a(String r100, String r110, Integer r111) {
                if (r100 == null) goto L30;
                String r101 = StringsKt.trim(r100).toString();
                if (r101 == null) goto L30;
                boolean r102 = false;
                if (r101.length() <= 0) goto L9;
                boolean r103 = true;
            L10:
                if (r103 == true) goto L13;
                r101 = null;
            L13:
                if (r101 == null) goto L30;
                if (r110 == null) goto L30;
                String r112 = StringsKt.trim(r110).toString();
                if (r112 == null) goto L30;
                if (r112.length() <= 0) goto L21;
                r102 = true;
            L21:
                if (r102 == false) goto L23;
                String r104 = r112;
            L24:
                if (r104 == null) goto L30;
                if (r111 == null) goto L29;
                r104 = StringsKt.replace$default(r104, "{duration}", String.valueOf(r111.intValue()), false, 4, null);
            L29:
                return new C7949b(r101, r104);
            L23:
                r104 = null;
                goto L24
            L9:
                r103 = false;
            L30:
                return null;
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7949b) == true) goto L8;
            return false;
        L8:
            C7949b r101 = (C7949b) r100;
            if (Intrinsics.areEqual(this.f552207a, r101.f552207a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f552208b, r101.f552208b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f552207a.hashCode() * 31) + this.f552208b.hashCode();
        }

        public final String toString() {
            return "CreationSubscriptionFeatureDetail(key=" + this.f552207a + ", value=" + this.f552208b + ')';
        }

        public C7949b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            this.f552207a = r100;
            this.f552208b = r101;
        }
    }

    static {
    }

    public b() {
        this(null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f552202a, r101.f552202a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f552203b, r101.f552203b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f552204c, r101.f552204c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f552205d, r101.f552205d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f552202a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f552203b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f552204c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f552205d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CreationSubscriptionTrackingExtra(enterMethod=" + this.f552202a + ", triggerScene=" + this.f552203b + ", featureKey=" + this.f552204c + ", featureDetail=" + this.f552205d + ')';
    }

    public b(String r100, String r101, String r102, String r103) {
        this.f552202a = r100;
        this.f552203b = r101;
        this.f552204c = r102;
        this.f552205d = r103;
    }
}
