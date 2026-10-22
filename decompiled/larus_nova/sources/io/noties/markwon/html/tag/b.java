package io.noties.markwon.html.tag;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.Arrays;
import java.util.Collection;
import lsc.t;
import lsc.x;
import org.commonmark.node.Emphasis;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{RXScreenCaptureService.KEY_INDEX, "em", "cite", "dfn"});
    }

    public b() {
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r100, t r101, tsc.l r102) {
        x r103 = ((lsc.l) r100.f510595e).a(Emphasis.class);
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.a(r100, r101);
    }
}
