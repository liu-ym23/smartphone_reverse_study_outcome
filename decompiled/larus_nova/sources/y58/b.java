package y58;

import com.larus.audio.audiov3.config.task.sami.asr.AsrResultState;
import com.larus.audio.audiov3.task.asr.AsrEventEnum;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f566268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f566269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f566270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566271d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f566272e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f566273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AsrResultState f566274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AsrEventEnum f566275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final c f566276i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f566268a, r101.f566268a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566269b, r101.f566269b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566270c, r101.f566270c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566271d, r101.f566271d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566272e, r101.f566272e) == true) goto L24;
        return false;
    L24:
        if (this.f566273f == r101.f566273f) goto L27;
        return false;
    L27:
        if (this.f566274g == r101.f566274g) goto L30;
        return false;
    L30:
        if (this.f566275h == r101.f566275h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f566276i, r101.f566276i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f566268a.hashCode() * 31;
        Integer r101 = this.f566269b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f566270c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f566271d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (((r107 + r109) * 31) + this.f566272e.hashCode()) * 31;
        long r111 = this.f566273f;
        int r112 = (((r110 + ((int) (r111 ^ (r111 >>> 32)))) * 31) + this.f566274g.hashCode()) * 31;
        AsrEventEnum r113 = this.f566275h;
        if (r113 != null) goto L17;
        int r114 = 0;
    L18:
        int r115 = (r112 + r114) * 31;
        c r116 = this.f566276i;
        if (r116 == null) goto L23;
        r102 = r116.hashCode();
    L23:
        return r115 + r102;
    L17:
        r114 = r113.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrResultData(taskId=" + this.f566268a + ", errCode=" + this.f566269b + ", errorMessage=" + this.f566270c + ", asrResult=" + this.f566271d + ", vid=" + this.f566272e + ", duration=" + this.f566273f + ", asrResultState=" + this.f566274g + ", reason=" + this.f566275h + ", extra=" + this.f566276i + ')';
    }

    public static b a(b r110, String r111) {
        String r100 = r110.f566268a;
        Integer r101 = r110.f566269b;
        String r102 = r110.f566270c;
        String r103 = r110.f566272e;
        long r104 = r110.f566273f;
        AsrResultState r105 = r110.f566274g;
        AsrEventEnum r106 = r110.f566275h;
        c r112 = r110.f566276i;
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r103, "vid");
        Intrinsics.checkNotNullParameter(r105, "asrResultState");
        return new b(r100, r101, r102, r111, r103, r104, r105, r106, r112);
    }

    public b(String r100, Integer r101, String r102, String r103, String r104, long r105, AsrResultState r106, AsrEventEnum r110, c r111) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r104, "vid");
        Intrinsics.checkNotNullParameter(r106, "asrResultState");
        this.f566268a = r100;
        this.f566269b = r101;
        this.f566270c = r102;
        this.f566271d = r103;
        this.f566272e = r104;
        this.f566273f = r105;
        this.f566274g = r106;
        this.f566275h = r110;
        this.f566276i = r111;
    }

    public /* synthetic */ b(String r110, Integer r111, String r112, String r113, String r114, long r210, AsrResultState r211, AsrEventEnum r212, c r213, int r214) {
        if ((r214 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r214 & 2) == 0) goto L9;
        Integer r101 = 0;
    L11:
        if ((r214 & 4) == 0) goto L13;
        String r102 = "";
    L15:
        if ((r214 & 8) == 0) goto L17;
        String r103 = "";
    L19:
        if ((r214 & 16) == 0) goto L21;
        String r104 = "";
    L23:
        if ((r214 & 32) == 0) goto L25;
        long r105 = 0;
    L27:
        if ((r214 & 256) == 0) goto L29;
        c r115 = null;
    L30:
        this(r100, r101, r102, r103, r104, r105, r211, r212, r115);
        return;
    L29:
        r115 = r213;
        goto L30
    L25:
        r105 = r210;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
