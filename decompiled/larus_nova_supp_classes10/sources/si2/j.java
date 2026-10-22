package si2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsi2/j;", "", "Lsi2/j$b;", "popCard", "Lsi2/j$b;", "getPopCard", "()Lsi2/j$b;", "introCard", "getIntroCard", "a", "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("intro_card")
    private final b introCard;

    @SerializedName("pop_card")
    private final b popCard;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lsi2/j$b;", "", "", "", "", "requestScene", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "requestPath", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("request_path")
        private final Map<String, String> requestPath;

        @SerializedName("request_scene")
        private final Map<String, Integer> requestScene;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (Intrinsics.areEqual(this.requestScene, r4.requestScene) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.requestPath, r4.requestPath) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Map<String, Integer> r0 = this.requestScene;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            Map<String, String> r4 = this.requestPath;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "GeneralRule(requestScene=" + this.requestScene + ", requestPath=" + this.requestPath + ")";
        }

        public b() {
            this.requestScene = null;
            this.requestPath = null;
        }

        public final Map<String, String> a() {
            return this.requestPath;
        }

        public final Map<String, Integer> b() {
            return this.requestScene;
        }
    }

    static {
    }

    public j() {
        this(0);
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof j) == false) goto L10;
        j r4 = (j) r3;
        if (Intrinsics.areEqual(this.popCard, r4.popCard) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.introCard, r4.introCard) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        b r0 = this.popCard;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        b r4 = this.introCard;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECLiveOuterCallMapRule(popCard=" + this.popCard + ", introCard=" + this.introCard + ")";
    }

    public final String a() {
        Intrinsics.checkNotNullParameter("refresh", LocationMonitorConst.TYPE);
        b r0 = this.introCard;
        if (r0 == null) goto L8;
        Map<String, String> r1 = r0.a();
        if (r1 == null) goto L8;
        String r2 = r1.get("refresh");
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "/live/promotions/intro/refresh/";
    }

    public final String c() {
        Intrinsics.checkNotNullParameter("refresh", LocationMonitorConst.TYPE);
        b r0 = this.popCard;
        if (r0 == null) goto L8;
        Map<String, String> r1 = r0.a();
        if (r1 == null) goto L8;
        String r2 = r1.get("refresh");
        if (r2 == null) goto L8;
        return r2;
    L8:
        return "/live/promotions/pop/refresh/";
    }

    public j(int r1) {
        this.popCard = null;
        this.introCard = null;
    }

    public final int b(String r2) {
        b r0 = this.introCard;
        if (r0 == null) goto L9;
        Map<String, Integer> r1 = r0.b();
        if (r1 == null) goto L9;
        Integer r3 = r1.get(r2);
        if (r3 == null) goto L9;
        return r3.intValue();
    L9:
        return 188;
    }

    public final int d(String r2) {
        b r0 = this.popCard;
        if (r0 == null) goto L9;
        Map<String, Integer> r1 = r0.b();
        if (r1 == null) goto L9;
        Integer r3 = r1.get(r2);
        if (r3 == null) goto L9;
        return r3.intValue();
    L9:
        return 80;
    }
}
