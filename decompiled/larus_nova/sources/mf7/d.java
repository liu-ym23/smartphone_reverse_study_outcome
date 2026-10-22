package mf7;

import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.token.TokenConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d implements c {
    public d() {
    }

    @Override // mf7.c
    public final of7.a a(Token r100, of7.b r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "psdaContext");
        ConcurrentHashMap<String, TokenConfig> r102 = com.bytedance.supervisor.runtime.config.b.f270342b;
        Intrinsics.checkNotNullParameter(r100, "token");
        lf7.b r103 = lf7.d.f509087a;
        if (r103 == null) goto L7;
        Function0<List<String>> r104 = r103.f509075i;
        if (r104 == null) goto L7;
        List<String> r105 = r104.invoke();
    L10:
        if (r105 != null) goto L12;
        boolean r106 = false;
    L13:
        if (r106 == true) goto L16;
        return new of7.a(r100, 0);
    L16:
        return new of7.a(r100, 3);
    L12:
        r106 = r105.contains(r100.getIdentifier());
    L7:
        r105 = null;
        goto L10
    }
}
