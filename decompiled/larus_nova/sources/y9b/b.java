package y9b;

import com.ss.android.lark.coremd.span.CommonPrefixSpan;
import com.ss.android.lark.coremd.utils.d;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends y9b.a {

    public static final class a {
    }

    static {
    }

    public b() {
        CommonPrefixSpan.c r100 = new CommonPrefixSpan.c();
        r100.f419939b = true;
        super(r100);
        i(CommonPrefixSpan.Type.LIST_NUM);
        h(1);
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
    public final void f(int r100) {
        super.f(r100);
        String[] r101 = d.f419966a;
        CommonPrefixSpan.c r102 = this.f419934a;
        j(d.c(r102.f419946i, r102.f419945h));
    }

    @Override // y9b.a
    public final void h(int r100) {
        CommonPrefixSpan.c r101 = this.f419934a;
        r101.f419946i = r100;
        String[] r102 = d.f419966a;
        j(d.c(r100, r101.f419945h));
    }

    public final void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f419934a.f419943f = r100;
    }
}
