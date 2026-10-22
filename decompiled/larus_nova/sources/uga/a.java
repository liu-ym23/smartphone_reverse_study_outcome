package uga;

import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f550057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f550058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f550059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f550060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f550061e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f550062f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<String> f550063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f550064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Map<String, String> f550065i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f550057a, r101.f550057a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f550058b, r101.f550058b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f550059c, r101.f550059c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f550060d, r101.f550060d) == true) goto L21;
        return false;
    L21:
        if (this.f550061e == r101.f550061e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f550062f, r101.f550062f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f550063g, r101.f550063g) == true) goto L30;
        return false;
    L30:
        if (this.f550064h == r101.f550064h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f550065i, r101.f550065i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f550057a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = ((((((r101 * 31) + this.f550058b.hashCode()) * 31) + this.f550059c.hashCode()) * 31) + this.f550060d.hashCode()) * 31;
        long r103 = this.f550061e;
        int r104 = (((((r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31) + this.f550062f.hashCode()) * 31) + this.f550063g.hashCode()) * 31;
        long r105 = this.f550064h;
        return ((r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31) + this.f550065i.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "AssistantStartupAttemptSpec(attemptId=" + this.f550057a + ", source=" + this.f550058b + ", action=" + this.f550059c + ", target=" + this.f550060d + ", startElapsedRealtimeMs=" + this.f550061e + ", startClock=" + this.f550062f + ", requiredMilestones=" + this.f550063g + ", timeoutMs=" + this.f550064h + ", attributes=" + this.f550065i + ')';
    }

    public static a a(a r110, String r111) {
        String r100 = r110.f550058b;
        String r101 = r110.f550059c;
        String r102 = r110.f550060d;
        long r103 = r110.f550061e;
        String r104 = r110.f550062f;
        Set<String> r105 = r110.f550063g;
        long r106 = r110.f550064h;
        Map<String, String> r112 = r110.f550065i;
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "action");
        Intrinsics.checkNotNullParameter(r102, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r104, "startClock");
        Intrinsics.checkNotNullParameter(r105, "requiredMilestones");
        Intrinsics.checkNotNullParameter(r112, "attributes");
        return new a(r111, r100, r101, r102, r103, r104, r105, r106, r112);
    }

    public /* synthetic */ a(String r110, String r111, String r112, String r113, long r114, String r115, Set r210, Map r211) {
        this(r110, r111, r112, r113, r114, r115, r210, 15000, r211);
    }

    public a(String r100, String r101, String r102, String r103, long r104, String r105, Set<String> r106, long r110, Map<String, String> r111) {
        Intrinsics.checkNotNullParameter(r101, "source");
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r103, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r105, "startClock");
        Intrinsics.checkNotNullParameter(r106, "requiredMilestones");
        Intrinsics.checkNotNullParameter(r111, "attributes");
        this.f550057a = r100;
        this.f550058b = r101;
        this.f550059c = r102;
        this.f550060d = r103;
        this.f550061e = r104;
        this.f550062f = r105;
        this.f550063g = r106;
        this.f550064h = r110;
        this.f550065i = r111;
    }
}
