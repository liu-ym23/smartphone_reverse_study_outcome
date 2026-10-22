package p22;

import com.amap.api.col.s.ce;
import com.bytedance.android.livesdk.interactivity.api.settings.config.h0;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001a\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001e"}, d2 = {"Lp22/o;", "", "", "isDanmakuOpen", "Z", "f", "()Z", "h", "(Z)V", "", "lineCount", "I", "d", "()I", ce.f26395j, "(I)V", "", "speedCoefficient", FaceService.girlLabel, "e", "()F", ce.f26396k, "(F)V", "fontSizeCoefficient", "c", RXScreenCaptureService.KEY_INDEX, "alpha", "b", ce.f26391f, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-platform-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f527446a = null;

    @SerializedName("alpha")
    private float alpha;

    @SerializedName("font_size_coefficient")
    private float fontSizeCoefficient;

    @SerializedName("is_danmaku_open")
    private boolean isDanmakuOpen;

    @SerializedName("line_count")
    private int lineCount;

    @SerializedName("speed_coefficient")
    private float speedCoefficient;

    public static final class a {
        public a() {
        }

        public static float a(h0 r100) {
            if (r100.a() >= 20.0f) goto L5;
            return 80.0f;
        L5:
            if (r100.a() <= 100.0f) goto L8;
            return 80.0f;
        L8:
            return r100.a();
        }

        public static float b(h0 r100) {
            int r101 = r100.b();
            if (r101 != 0) goto L5;
            return 0.8f;
        L5:
            if (r101 != 1) goto L7;
            return 0.9f;
        L7:
            if (r101 != 2) goto L9;
        L15:
            return 1.0f;
        L9:
            if (r101 != 3) goto L11;
            return 1.2f;
        L11:
            if (r101 != 4) goto L15;
            return 1.4f;
        }

        public static float c(h0 r100) {
            int r101 = r100.c();
            if (r101 != 0) goto L5;
            return 0.6f;
        L5:
            if (r101 != 1) goto L7;
            return 0.8f;
        L7:
            if (r101 != 2) goto L9;
        L15:
            return 1.0f;
        L9:
            if (r101 != 3) goto L11;
            return 1.2f;
        L11:
            if (r101 != 4) goto L15;
            return 1.4f;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L16;
        o r101 = (o) r100;
        if (this.isDanmakuOpen == r101.isDanmakuOpen) goto L8;
        return false;
    L8:
        if (this.lineCount == r101.lineCount) goto L10;
        return false;
    L10:
        if (Float.compare(this.speedCoefficient, r101.speedCoefficient) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.fontSizeCoefficient, r101.fontSizeCoefficient) == 0) goto L14;
        return false;
    L14:
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public final int hashCode() {
        boolean r100 = this.isDanmakuOpen;
        ?? r101 = r100;
        if (r100 == false) goto L6;
        r101 = 1;
    L6:
        return (((((((r101 * 31) + this.lineCount) * 31) + Float.floatToIntBits(this.speedCoefficient)) * 31) + Float.floatToIntBits(this.fontSizeCoefficient)) * 31) + Float.floatToIntBits(this.alpha);
    }

    public final String toString() {
        return "SimpleDanmakuSetting(isDanmakuOpen=" + this.isDanmakuOpen + ", lineCount=" + this.lineCount + ", speedCoefficient=" + this.speedCoefficient + ", fontSizeCoefficient=" + this.fontSizeCoefficient + ", alpha=" + this.alpha + ")";
    }

    static {
        f527446a = new a();
    }

    public final float b() {
        return this.alpha;
    }

    public final float c() {
        return this.fontSizeCoefficient;
    }

    public final int d() {
        return this.lineCount;
    }

    public final float e() {
        return this.speedCoefficient;
    }

    public final boolean f() {
        return this.isDanmakuOpen;
    }

    public static o a(o r100) {
        boolean r101 = r100.isDanmakuOpen;
        int r102 = r100.lineCount;
        float r103 = r100.speedCoefficient;
        float r104 = r100.fontSizeCoefficient;
        float r105 = r100.alpha;
        r100.getClass();
        return new o(r101, r102, r103, r104, r105);
    }

    public final void g(float r100) {
        this.alpha = r100;
    }

    public final void h(boolean r100) {
        this.isDanmakuOpen = r100;
    }

    public final void i(float r100) {
        this.fontSizeCoefficient = r100;
    }

    public final void j(int r100) {
        this.lineCount = r100;
    }

    public final void k(float r100) {
        this.speedCoefficient = r100;
    }

    public o(boolean r100, int r101, float r102, float r103, float r104) {
        this.isDanmakuOpen = r100;
        this.lineCount = r101;
        this.speedCoefficient = r102;
        this.fontSizeCoefficient = r103;
        this.alpha = r104;
    }
}
