package ltc;

import itc.g;
import java.util.Objects;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f510768a = 0;

    public e() {
    }

    public abstract g b();

    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract String e();

    static {
        a("", null, null, itc.b.f495767d);
    }

    public static a a(String r100, @Nullable String r101, @Nullable String r102, g r103) {
        Objects.requireNonNull(r100, "name");
        Objects.requireNonNull(r103, "attributes");
        return new a(r100, r101, r102, r103);
    }
}
