package mf7;

import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.token.TokenConfig;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e implements c {
    public e() {
    }

    @Override // mf7.c
    public final of7.a a(Token r100, of7.b r101) {
        Intrinsics.checkNotNullParameter(r100, "token");
        Intrinsics.checkNotNullParameter(r101, "psdaContext");
        ConcurrentHashMap<String, TokenConfig> r102 = com.bytedance.supervisor.runtime.config.b.f270342b;
        Intrinsics.checkNotNullParameter(r100, "token");
        if (com.bytedance.supervisor.runtime.config.b.f270342b.containsKey(r100.getIdentifier()) == false) goto L6;
        return new of7.a(r100, 0);
    L6:
        return new of7.a(r100, 1);
    }
}
