package io.noties.markwon.html.tag;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import io.noties.markwon.core.CoreProps;
import java.util.Arrays;
import java.util.Collection;
import lsc.t;
import lsc.x;
import org.commonmark.node.Heading;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Arrays.asList(new String[]{"h1", "h2", "h3", "h4", "h5", "h6"});
    }

    public c() {
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r100, t r101, tsc.l r102) {
        x r103 = ((lsc.l) r100.f510595e).a(Heading.class);
        if (r103 != null) goto L17;
        return null;
    L17:
        int r104 = CastIntegerProtector.parseInt(r102.name().substring(1));     // Catch: NumberFormatException -> L8
    L10:
        if (r104 >= 1) goto L12;
    L16:
        return null;
    L12:
        if (r104 > 6) goto L16;
        CoreProps.f492264f.c(r101, Integer.valueOf(r104));
        return r103.a(r100, r101);
    L8:
        e = move-exception;
        e.printStackTrace();
        r104 = 0;
        goto L10
    }
}
