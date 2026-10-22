package if9;

import com.larus.im.internal.trace.manager.definition.AVCommonError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f489625j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f489626a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f489627b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f489628c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f489629d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f489630e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile Integer f489631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile String f489632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public a f489633h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f489634i;

    /* JADX INFO: renamed from: if9.a$a, reason: collision with other inner class name */
    public static final class C6259a {
        public static a a(a r100, String r101) {
            if (r100 != null) goto L6;
            return null;
        L6:
            if (Intrinsics.areEqual(r100.f489626a, r101) == false) goto L9;
            return r100;
        L9:
            return a(r100.f489633h, r101);
        }
    }

    static {
    }

    public abstract void g(JSONObject r100);

    public boolean h() {
        return false;
    }

    public abstract AVCommonError j();

    public final String c() {
        return "stepName=" + this.f489626a + ", startTime=" + this.f489627b + ", endTime=" + this.f489628c + ", errorCode=" + this.f489629d + ", errorMessage=" + this.f489630e;
    }

    public final int hashCode() {
        return this.f489626a.hashCode();
    }

    public final a m() {
        a r100 = this.f489633h;
        if (r100 != null) goto L6;
        return this;
    L6:
        return r100.m();
    }

    public boolean n() {
        if (this.f489629d == 0) goto L6;
        return true;
    L6:
        if (h() == false) goto L11;
        if (k(this) < 0) goto L15;
    L13:
        return false;
    L15:
        return true;
    L11:
        if (this.f489633h != null) goto L13;
        return true;
    }

    public final a i() {
        if (n() == false) goto L5;
        return this;
    L5:
        a r100 = this.f489633h;
        if (r100 != null) goto L10;
        return null;
    L10:
        return r100.i();
    }

    public final boolean l() {
        if (n() == true) goto L14;
        a r100 = this.f489633h;
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r100.l() != true) goto L9;
        r101 = true;
        goto L10
    L14:
        return true;
    }

    public final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "added");
        if (h() == false) goto L5;
        return;
    L5:
        a r101 = this.f489633h;
        if (r101 == null) goto L8;
        r101.a(r100);
        return;
    L8:
        if (this.f489628c > 0) goto L10;
        this.f489628c = r100.f489627b;
    L10:
        com.larus.im.internal.delegate.a.f348188b.i("AbsFlowAVConnectionStep", "[addStep] current: " + this.f489626a + ", next: " + r100.f489626a);
        this.f489633h = r100;
    }

    public final void b(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "param");
        g(r100);
        a r101 = this.f489633h;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public final boolean d(a r100) {
        Intrinsics.checkNotNullParameter(r100, "added");
        if (Intrinsics.areEqual(r100, this) == true) goto L14;
        a r101 = this.f489633h;
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == true) goto L15;
        return false;
    L15:
        return true;
    L7:
        if (r101.d(r100) != true) goto L9;
        r102 = true;
        goto L10
    L14:
        return true;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f489626a, ((a) r100).f489626a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public void f(long r100) {
        if (this.f489628c > 0) goto L12;
        this.f489628c = r100;
        if (this.f489629d == 0) goto L7;
        return;
    L7:
        if (h() == false) goto L9;
        return;
    L9:
        if (this.f489633h != null) goto L15;
        this.f489629d = j().getCode();
        this.f489630e = j().getMsg();
        this.f489631f = j().getSubCode();
        this.f489632g = j().getSubMsg();
        return;
    L15:
        return;
    }

    public final long k(a r100) {
        if (r100 != null) goto L5;
        return -1;
    L5:
        long r101 = this.f489628c;
        if (r101 <= 0) goto L17;
        if (r101 < r100.f489627b) goto L17;
        if (r100.d(this) == true) goto L15;
        com.larus.im.internal.delegate.a.f348188b.i("AbsFlowAVConnectionStep", "[getTotalDuration] The specified step(" + r100.f489626a + ") is not the preceding step to the current step(" + this.f489626a + ").");
        return -1;
    L15:
        return RangesKt.coerceAtLeast(this.f489628c - r100.f489627b, -1);
    L17:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L20;
        return -1;
    L20:
        throw new IllegalStateException("Current step(" + this.f489626a + ") end time is " + this.f489628c + ", it less than root(" + r100.f489626a + ") step start time " + r100.f489627b + '.');
    }

    public a(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "stepName");
        this.f489626a = r100;
        this.f489627b = r101;
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L5;
    L12:
        this.f489628c = -1;
        return;
    L5:
        if (r101 <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L12;
        throw new IllegalStateException(("start time(" + r101 + ") must be more than 0.").toString());
    L7:
        r102 = false;
        goto L8
    }

    public static long e(long r100, long r101) {
        if (r100 > 0) goto L5;
    L9:
        return -1;
    L5:
        if (r101 < r100) goto L9;
        return RangesKt.coerceAtLeast(r101 - r100, -1);
    }
}
