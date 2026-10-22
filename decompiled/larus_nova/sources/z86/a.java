package z86;

import com.bytedance.iesgurd.statistic.model.CleanStrategy;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CleanStrategy f570913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f570915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f570916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f570917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f570918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f570919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f570920h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L22;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f570913a, r101.f570913a) == true) goto L8;
        return false;
    L8:
        if (this.f570914b == r101.f570914b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f570915c, r101.f570915c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f570916d, r101.f570916d) == true) goto L14;
        return false;
    L14:
        if (this.f570917e == r101.f570917e) goto L16;
        return false;
    L16:
        if (this.f570918f == r101.f570918f) goto L18;
        return false;
    L18:
        if (this.f570919g == r101.f570919g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f570920h, r101.f570920h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    public final int hashCode() {
        CleanStrategy r100 = this.f570913a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f570914b) * 31;
        String r104 = this.f570915c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f570916d;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        long r110 = this.f570917e;
        int r111 = (((((r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31) + this.f570918f) * 31) + this.f570919g) * 31;
        String r112 = this.f570920h;
        if (r112 == null) goto L18;
        r101 = r112.hashCode();
    L18:
        return r111 + r101;
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
        return "StatisticCleanData(cleanStrategy=" + this.f570913a + ", cleanType=" + this.f570914b + ", accessKey=" + this.f570915c + ", channel=" + this.f570916d + ", id=" + this.f570917e + ", statsType=" + this.f570918f + ", expireAge=" + this.f570919g + ", cleanGroup=" + this.f570920h + ")";
    }

    public final void a() {
        JSONObject r100 = new JSONObject();
        r100.put("clean_strategy", this.f570913a.ordinal());
        int r101 = this.f570914b;
        if (r101 == 0) goto L5;
        r100.put("clean_type", r101);
    L5:
        r100.put("stats_type", this.f570918f);
        String r102 = this.f570915c;
        if (r102 == null) goto L8;
        r100.put("access_key", r102);
    L8:
        String r103 = this.f570916d;
        if (r103 == null) goto L11;
        r100.put("channel", r103);
    L11:
        long r104 = this.f570917e;
        if (r104 == 0) goto L14;
        r100.put("id", r104);
    L14:
        String r105 = this.f570920h;
        if (r105 == null) goto L17;
        r100.put(DownloadSettingKeys.CacheCleaner.CLEAN_GROUP, r105);
    L17:
        int r106 = this.f570919g;
        if (r106 == 0) goto L20;
        r100.put("expire_age", r106);
    L20:
        y86.a.c("geckosdk_clean_stats", r100);
    }

    public /* synthetic */ a(CleanStrategy r110, int r111, String r112, String r113, long r114, int r115, int r210) {
        if ((r210 & 4) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r210 & 8) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r210 & 16) == 0) goto L13;
        long r102 = 0;
    L15:
        if ((r210 & 32) == 0) goto L17;
        int r103 = 200;
    L18:
        this(r110, r111, r100, r101, r102, r103, 0, null);
        return;
    L17:
        r103 = r115;
        goto L18
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }

    public a(CleanStrategy r100, int r101, String r102, String r103, long r104, int r105, int r106, String r107) {
        this.f570913a = r100;
        this.f570914b = r101;
        this.f570915c = r102;
        this.f570916d = r103;
        this.f570917e = r104;
        this.f570918f = r105;
        this.f570919g = r106;
        this.f570920h = r107;
    }
}
