package qw8;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.business.markdown.impl.markwon.core.spans.codeblock.CodeBlockWithLineNumberScrollableSpan;
import io.noties.markwon.core.CoreProps;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lsc.h;
import lsc.t;
import lsc.u;
import lsc.x;
import msc.s;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f535033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f535034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f535035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f535036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ctc.e f535037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f535038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f535039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f535040h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final float f535041i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f535042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f535043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Map<String, Object>> f535044l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final jw8.a f535045m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f535046n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Boolean> f535047o;

    @Override // lsc.x
    public final Object a(h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        return b(r100, r101);
    }

    public final Object b(h r110, t r111) {
        Intrinsics.checkNotNullParameter(r110, "configuration");
        Intrinsics.checkNotNullParameter(r111, SlcElement.KEY_PROPS);
        if (this.f535036d == false) goto L12;
        s r100 = r110.f510591a;
        u r101 = (u) r111;
        Integer r102 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320629a);
        Integer r103 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320630b);
        int r104 = this.f535033a;
        float r105 = this.f535034b;
        float r106 = this.f535041i;
        int r112 = this.f535042j;
        boolean r113 = this.f535043k;
        com.larus.business.markdown.impl.markwon.core.spans.codeblock.b r114 = new com.larus.business.markdown.impl.markwon.core.spans.codeblock.b(this.f535035c, (ctc.a) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320631c), this.f535037e, this.f535040h);
        Map r107 = (Map) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320633e);
        if (r107 != null) goto L7;
        r107 = MapsKt.emptyMap();
    L7:
        Integer r108 = (Integer) r101.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320632d);
        if (r108 != null) goto L11;
        r108 = 0;
    L11:
        return new CodeBlockWithLineNumberScrollableSpan(r100, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.c(r102, r103, r104, r105, r106, r112, r113, r114, new com.larus.business.markdown.impl.markwon.core.spans.codeblock.a(r107, r108.intValue(), this.f535039g)), this.f535038f);
    L12:
        u r109 = (u) r111;
        return new c(this.f535044l.invoke(), (String) r109.a(CoreProps.f492270l), (String) r109.a(CoreProps.f492269k), (Integer) r109.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320629a), (Integer) r109.a(com.larus.business.markdown.impl.markwon.core.spans.codeblock.d.f320630b), this.f535046n, this.f535045m, this.f535047o.invoke().booleanValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(int r100, float r101, boolean r102, boolean r103, ctc.e r110, int r111, int r112, int r113, float r114, int r115, boolean r116, Function0<? extends Map<String, ? extends Object>> r117, jw8.a r118, int r119, Function0<Boolean> r210) {
        Intrinsics.checkNotNullParameter(r110, "scrollBarTheme");
        Intrinsics.checkNotNullParameter(r117, "getPayload");
        Intrinsics.checkNotNullParameter(r210, "isFinish");
        this.f535033a = r100;
        this.f535034b = r101;
        this.f535035c = r102;
        this.f535036d = r103;
        this.f535037e = r110;
        this.f535038f = r111;
        this.f535039g = r112;
        this.f535040h = r113;
        this.f535041i = r114;
        this.f535042j = r115;
        this.f535043k = r116;
        this.f535044l = r117;
        this.f535045m = r118;
        this.f535046n = r119;
        this.f535047o = r210;
    }
}
