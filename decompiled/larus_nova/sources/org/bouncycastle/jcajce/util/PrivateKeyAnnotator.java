package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public class PrivateKeyAnnotator {
    public PrivateKeyAnnotator() {
    }

    public static AnnotatedPrivateKey annotate(PrivateKey r100, String r101) {
        return new AnnotatedPrivateKey(r100, r101);
    }

    public static AnnotatedPrivateKey annotate(PrivateKey r100, Map<String, Object> r101) {
        return new AnnotatedPrivateKey(r100, Collections.unmodifiableMap(new HashMap(r101)));
    }
}
