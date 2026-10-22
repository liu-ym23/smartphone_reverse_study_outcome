package uw3;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class h {
    public final Set<String> a;

    public h() {
        this.a = Collections.newSetFromMap(new ConcurrentHashMap());
    }
}
