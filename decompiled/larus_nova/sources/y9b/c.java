package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends y9b.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<CommonPrefixSpan.Type> f566995d = null;

    public static final class a {
    }

    static {
        f566995d = CollectionsKt.listOf(new CommonPrefixSpan.Type[]{CommonPrefixSpan.Type.FILL_CIRCLE, CommonPrefixSpan.Type.HOLLOW_CIRCLE, CommonPrefixSpan.Type.FILL_RECT});
    }

    public c() {
        CommonPrefixSpan.c r100 = new CommonPrefixSpan.c();
        r100.f419939b = true;
        super(r100);
        j("- ");
        h(0);
        i(CommonPrefixSpan.Type.FILL_CIRCLE);
    }

    @Override // y9b.a
    public final int b() {
        return this.f419934a.f419945h;
    }

    @Override // y9b.a
    public final int c() {
        return this.f419934a.f419946i;
    }

    @Override // y9b.a
    public final String e() {
        return this.f419934a.f419943f;
    }

    @Override // y9b.a
    public final CommonPrefixSpan.Type d() {
        return super.d();
    }

    @Override // y9b.a
    public final void f(int r100) {
        super.f(r100);
        CommonPrefixSpan.c r101 = this.f419934a;
        int r102 = r101.f419945h;
        CommonPrefixSpan.Type r103 = (CommonPrefixSpan.Type) CollectionsKt.getOrNull(f566995d, r102 % 3);
        if (r103 != null) goto L5;
        r103 = CommonPrefixSpan.Type.FILL_CIRCLE;
    L5:
        r101.f419938a = r103;
    }

    @Override // y9b.a
    public final void h(int r100) {
        this.f419934a.f419946i = 0;
    }

    @Override // y9b.a
    public final void i(CommonPrefixSpan.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        super.i(r100);
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter("- ", "_");
        this.f419934a.f419943f = "- ";
    }
}
