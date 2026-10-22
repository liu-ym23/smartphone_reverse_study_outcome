package io.noties.markwon.html.tag;

import android.text.TextUtils;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import io.noties.markwon.core.CoreProps;
import java.util.Collection;
import java.util.Collections;
import lsc.t;
import lsc.x;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes5.dex */
public class g extends i {
    @Override // tsc.a0
    public final Collection<String> c() {
        return Collections.singleton(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY);
    }

    public g() {
    }

    @Override // io.noties.markwon.html.tag.i
    public Object e(lsc.h r100, t r101, tsc.l r102) {
        String r103 = r102.b().get("href");
        if (TextUtils.isEmpty(r103) == true) goto L8;
        x r104 = ((lsc.l) r100.f510595e).a(Link.class);
        if (r104 == null) goto L10;
        CoreProps.f492265g.c(r101, r103);
        return r104.a(r100, r101);
    L10:
        return null;
    L8:
        return null;
    }
}
