package si2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001:\u0002\t\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lsi2/j;", "", "Lsi2/j$b;", "popCard", "Lsi2/j$b;", "getPopCard", "()Lsi2/j$b;", "introCard", "getIntroCard", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("intro_card")
    private final b introCard;

    @SerializedName("pop_card")
    private final b popCard;

    public static final class a {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R(\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lsi2/j$b;", "", "", "", "", "requestScene", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "requestPath", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("request_path")
        private final Map<String, String> requestPath;

        @SerializedName("request_scene")
        private final Map<String, Integer> requestScene;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof b) == false) goto L10;
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.requestScene, r101.requestScene) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.requestPath, r101.requestPath) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            Map<String, Integer> r100 = this.requestScene;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<String, String> r104 = this.requestPath;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
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

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof j) == false) goto L10;
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.popCard, r101.popCard) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.introCard, r101.introCard) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        b r100 = this.popCard;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        b r104 = this.introCard;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECLiveOuterCallMapRule(popCard=" + this.popCard + ", introCard=" + this.introCard + ")";
    }

    public final String a() {
        Intrinsics.checkNotNullParameter("refresh", "type");
        b r100 = this.introCard;
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.a();
        if (r101 == null) goto L8;
        String r102 = r101.get("refresh");
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "/live/promotions/intro/refresh/";
    }

    public final String c() {
        Intrinsics.checkNotNullParameter("refresh", "type");
        b r100 = this.popCard;
        if (r100 == null) goto L8;
        Map<String, String> r101 = r100.a();
        if (r101 == null) goto L8;
        String r102 = r101.get("refresh");
        if (r102 == null) goto L8;
        return r102;
    L8:
        return "/live/promotions/pop/refresh/";
    }

    public j(int r100) {
        this.popCard = null;
        this.introCard = null;
    }

    public final int b(String r100) {
        b r101 = this.introCard;
        if (r101 == null) goto L9;
        Map<String, Integer> r102 = r101.b();
        if (r102 == null) goto L9;
        Integer r103 = r102.get(r100);
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 188;
    }

    public final int d(String r100) {
        b r101 = this.popCard;
        if (r101 == null) goto L9;
        Map<String, Integer> r102 = r101.b();
        if (r102 == null) goto L9;
        Integer r103 = r102.get(r100);
        if (r103 == null) goto L9;
        return r103.intValue();
    L9:
        return 80;
    }
}
