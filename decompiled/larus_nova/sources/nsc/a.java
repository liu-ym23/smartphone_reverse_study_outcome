package nsc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.q;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import lsc.t;

/* JADX INFO: loaded from: classes41.dex */
public final class a extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f520434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer f520435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Float f520436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f520437d;

    @Override // nsc.k, lsc.x
    public final Object a(lsc.h r100, t r110) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r110, SlcElement.KEY_PROPS);
        if (CoreProps.ListItemType.BULLET != CoreProps.f492259a.b(r110)) goto L6;
        return super.a(r100, r110);
    L6:
        if (this.f520434a != null) goto L8;
    L10:
        Object r111 = new q(r100.f510591a, null, CoreProps.f492262d.b(r110).intValue() + ". ", 0, true);
    L12:
        return r111;
    L8:
        if (this.f520435b == null) goto L10;
        StringBuilder r101 = new StringBuilder();
        r101.append(CoreProps.f492262d.b(r110).intValue());
        r101.append(Typography.nbsp);
        r111 = new io.noties.markwon.core.spans.a(r100.f510591a, r101.toString(), this.f520434a.intValue(), this.f520435b.intValue(), this.f520436c, this.f520437d);
        goto L12
    }

    public a(Integer r100, Integer r101, Float r102, Integer r103) {
        this.f520434a = r100;
        this.f520435b = r101;
        this.f520436c = r102;
        this.f520437d = r103;
    }
}
