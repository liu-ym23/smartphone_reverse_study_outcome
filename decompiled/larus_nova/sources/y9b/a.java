package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.span.list.ListHeadType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a extends CommonPrefixSpan {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ListHeadType f566994c;

    /* JADX INFO: renamed from: y9b.a$a, reason: collision with other inner class name */
    public static final class C8318a {
    }

    static {
    }

    public int b() {
        return this.f419934a.f419945h;
    }

    public int c() {
        return this.f419934a.f419946i;
    }

    public CommonPrefixSpan.Type d() {
        return this.f419934a.getType();
    }

    public String e() {
        return this.f419934a.f419943f;
    }

    public a(CommonPrefixSpan.c r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        super(r100);
        this.f566994c = ListHeadType.None;
        i(CommonPrefixSpan.Type.NONE);
        f(0);
    }

    public void f(int r100) {
        this.f419934a.f419945h = Math.min(Math.max(r100, 0), 5);
    }

    public final void g(ListHeadType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f566994c = r100;
    }

    public void h(int r100) {
        this.f419934a.f419946i = r100;
    }

    public void i(CommonPrefixSpan.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f419934a.f419938a = r100;
    }
}
