package iub;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingCreateMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.doubao.DoubaoStatisticInfo;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MmRecordingSource f495846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, Object> f495847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final MmRecordingUILaunchMode f495848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495849d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495850e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MmRecordingCreateMode f495851f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f495852g;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof k) == true) goto L8;
        return false;
    L8:
        k r101 = (k) r100;
        if (this.f495846a == r101.f495846a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f495847b, r101.f495847b) == true) goto L15;
        return false;
    L15:
        if (this.f495848c == r101.f495848c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495849d, r101.f495849d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495850e, r101.f495850e) == true) goto L24;
        return false;
    L24:
        if (this.f495851f == r101.f495851f) goto L27;
        return false;
    L27:
        if (this.f495852g == r101.f495852g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((this.f495846a.hashCode() * 31) + this.f495847b.hashCode()) * 31) + this.f495848c.hashCode()) * 31) + this.f495849d.hashCode()) * 31) + this.f495850e.hashCode()) * 31) + this.f495851f.hashCode()) * 31;
        if (this.f495852g == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "MmRecordingCreateContext(source=" + this.f495846a + ", extra=" + this.f495847b + ", uiLaunchMode=" + this.f495848c + ", spokenLanguage=" + this.f495849d + ", translationLanguage=" + this.f495850e + ", mode=" + this.f495851f + ", autoOpenRecordingPage=" + this.f495852g + ')';
    }

    public final DoubaoStatisticInfo a() {
        Object r100 = this.f495847b.get("doubao_statistics_params");
        if (r100 == null) goto L25;
        String r101 = r100.toString();
        if (r101 != null) goto L7;
        return null;
    L7:
        if ((!StringsKt.isBlank(r101)) == true) goto L10;
        r101 = null;
    L10:
        if (r101 == null) goto L27;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L13
        Object r103 = Result.m9449constructorimpl(new JSONObject(r101));     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r103) == false) goto L19;
        r103 = null;
    L19:
        if (((JSONObject) r103) != null) goto L22;
        return null;
    L22:
        return new DoubaoStatisticInfo(r101);
    L13:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L27:
        return null;
    L25:
        return null;
    }

    public /* synthetic */ k(MmRecordingSource r100, Map r110, MmRecordingUILaunchMode r111, String r112, MmRecordingCreateMode r113, int r114) {
        if ((r114 & 2) == 0) goto L5;
        r110 = MapsKt.emptyMap();
    L5:
        Map r101 = r110;
        if ((r114 & 8) == 0) goto L8;
        String r102 = "";
    L10:
        if ((r114 & 16) == 0) goto L12;
        String r103 = "";
    L14:
        if ((r114 & 32) == 0) goto L16;
        r113 = MmRecordingCreateMode.DEFAULT_RTC;
    L16:
        MmRecordingCreateMode r104 = r113;
        if ((r114 & 64) == 0) goto L19;
        boolean r105 = true;
    L20:
        this(r100, r101, r111, r102, r103, r104, r105);
        return;
    L19:
        r105 = false;
        goto L20
    L12:
        r103 = r112;
        goto L14
    L8:
        r102 = null;
        goto L10
    }

    public k(MmRecordingSource r100, Map<String, ? extends Object> r101, MmRecordingUILaunchMode r102, String r103, String r104, MmRecordingCreateMode r105, boolean r106) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "extra");
        Intrinsics.checkNotNullParameter(r102, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r103, "spokenLanguage");
        Intrinsics.checkNotNullParameter(r104, "translationLanguage");
        Intrinsics.checkNotNullParameter(r105, "mode");
        this.f495846a = r100;
        this.f495847b = r101;
        this.f495848c = r102;
        this.f495849d = r103;
        this.f495850e = r104;
        this.f495851f = r105;
        this.f495852g = r106;
    }
}
