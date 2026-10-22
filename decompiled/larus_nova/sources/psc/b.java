package psc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;
import msc.s;

/* JADX INFO: loaded from: classes5.dex */
public final class b implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f530584a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f530585b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f530586c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f530587d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ctc.e f530588e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f530589f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f530590g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f530591h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f530592i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f530593j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f530594k;

    @Override // lsc.x
    public final Object a(h r110, t r111) {
        Intrinsics.checkNotNullParameter(r110, "configuration");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        if (this.f530587d == false) goto L11;
        s r100 = r110.f510591a;
        u r101 = (u) r111;
        Integer r102 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320629a);
        Integer r103 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320630b);
        int r104 = this.f530584a;
        float r105 = this.f530585b;
        float r106 = this.f530592i;
        int r112 = this.f530593j;
        boolean r113 = this.f530594k;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.b r114 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.b(this.f530586c, (ctc.a) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320631c), this.f530588e, this.f530591h);
        Map r107 = (Map) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320633e);
        if (r107 != null) goto L7;
        r107 = MapsKt.emptyMap();
    L7:
        Integer r108 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320632d);
        if (r108 != null) goto L13;
        r108 = 0;
    L13:
        return new CodeBlockWithLineNumberScrollableSpan(r100, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c(r102, r103, r104, r105, r106, r112, r113, r114, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.a(r107, r108.intValue(), this.f530590g)), this.f530589f);
    L11:
        u r109 = (u) r111;
        return new a(r110.f510591a, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c((Integer) r109.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320629a), (Integer) r109.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320630b), this.f530584a, this.f530585b, this.f530592i, this.f530593j, this.f530594k, null, null));
    }

    public b(int r100, float r101, boolean r102, boolean r103, ctc.e r104, int r105, int r106, int r107, float r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r104, "scrollBarTheme");
        this.f530584a = r100;
        this.f530585b = r101;
        this.f530586c = r102;
        this.f530587d = r103;
        this.f530588e = r104;
        this.f530589f = r105;
        this.f530590g = r106;
        this.f530591h = r107;
        this.f530592i = r110;
        this.f530593j = r111;
        this.f530594k = r112;
    }
}
