package nsc;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import io.noties.markwon.core.CoreProps;
import io.noties.markwon.core.spans.CustomCitationSpan;
import io.noties.markwon.core.spans.CustomLinkSpan;
import io.noties.markwon.core.spans.CustomMentionSpan;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lsc.t;
import msc.p;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hw8.b f520440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tsc.n f520441b;

    public e(hw8.b r100, tsc.n r101) {
        this.f520440a = r100;
        this.f520441b = r101;
    }

    @Override // nsc.i, lsc.x
    public final Object a(lsc.h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        String r102 = CoreProps.f492265g.b(r101);
        String r103 = p.f515538d.b(r101);     // Catch: Exception -> L5
    L6:
        String r104 = r103;
        hw8.b r105 = this.f520440a;
        if (r105 == null) goto L11;
        boolean r106 = true;
        if (r105.c(r104) != true) goto L11;
    L12:
        if (r106 == false) goto L15;
        return new CustomCitationSpan(r100.f510591a, r104, r102, r100.f510593c, this.f520440a);
    L15:
        if (StringsKt.startsWith$default(r102, "mention://", false, 2, null) == true) goto L25;
        tsc.n r107 = this.f520441b;
        if (r107 == null) goto L21;
        r107.d("CustomLinkSpanFactory", "link: " + r102 + ",title: " + r104);
    L21:
        return new CustomLinkSpan(r100.f510591a, r102, r100.f510593c);
    L25:
        return new CustomMentionSpan();
    L11:
        r106 = false;
    L5:
        r103 = "";
        goto L6
    }
}
