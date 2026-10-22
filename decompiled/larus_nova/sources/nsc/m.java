package nsc;

import android.text.style.ParagraphStyle;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.larus.business.markdown.api.model.ThematicBreakConfig;
import com.larus.business.markdown.impl.common.utils.MarkdownDimensExtKt;
import io.noties.markwon.core.spans.w;
import kotlin.jvm.internal.Intrinsics;
import lsc.t;
import lsc.x;

/* JADX INFO: loaded from: classes5.dex */
public final class m implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThematicBreakConfig f520452a;

    public m(ThematicBreakConfig r100) {
        this.f520452a = r100;
    }

    @Override // lsc.x
    public final Object a(lsc.h r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, SlcElement.KEY_PROPS);
        ThematicBreakConfig r102 = this.f520452a;
        if (r102 == null) goto L10;
        Integer r103 = r102.getHeight();
        if (r103 == null) goto L10;
        int r104 = r103.intValue();
        if (r104 > 0) goto L12;
        r104 = MarkdownDimensExtKt.a();
    L12:
        return new ParagraphStyle[]{new w(r100.f510591a), dtc.a.a(r104)};
    L10:
        r104 = MarkdownDimensExtKt.a();
        goto L12
    }
}
