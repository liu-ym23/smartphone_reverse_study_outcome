package mf7;

import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.token.TokenConfig;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a implements c {
    public a() {
    }

    @Override // mf7.c
    public final of7.a a(Token r100, of7.b r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "psdaContext");
        if (r101.f523111a.contains("default_atomic_info") == true) goto L5;
        ConcurrentHashMap<String, TokenConfig> r102 = com.bytedance.supervisor.runtime.config.b.f270342b;
        List r103 = com.bytedance.supervisor.runtime.config.b.c(r100);
        List<String> r104 = r101.f523111a;
        if ((!r104.isEmpty()) == false) goto L12;
        if (r103.containsAll(r104) == false) goto L12;
        return new of7.a(r100, 0);
    L12:
        return new of7.a(r100, 2);
    L5:
        return new of7.a(r100, 0);
    }
}
