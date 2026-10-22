package org.bouncycastle.jcajce.util;

import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public class AnnotatedPrivateKey implements PrivateKey {
    public static final String LABEL = "label";
    private final Map<String, Object> annotations;
    private final PrivateKey key;

    public AnnotatedPrivateKey(PrivateKey r100, String r101) {
        this.key = r100;
        this.annotations = Collections.singletonMap("label", r101);
    }

    public AnnotatedPrivateKey(PrivateKey r100, Map<String, Object> r101) {
        this.key = r100;
        this.annotations = r101;
    }

    public AnnotatedPrivateKey addAnnotation(String r100, Object r101) {
        HashMap r102 = new HashMap(this.annotations);
        r102.put(r100, r101);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(r102));
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof AnnotatedPrivateKey) == false) goto L7;
        PrivateKey r101 = this.key;
        r100 = ((AnnotatedPrivateKey) r100).key;
    L6:
        return r101.equals(r100);
    L7:
        r101 = this.key;
        goto L6
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.key.getAlgorithm();
    }

    public Object getAnnotation(String r100) {
        return this.annotations.get(r100);
    }

    public Map<String, Object> getAnnotations() {
        return this.annotations;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.key.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.key.getFormat();
    }

    public PrivateKey getKey() {
        return this.key;
    }

    public int hashCode() {
        return this.key.hashCode();
    }

    public AnnotatedPrivateKey removeAnnotation(String r100) {
        HashMap r101 = new HashMap(this.annotations);
        r101.remove(r100);
        return new AnnotatedPrivateKey(this.key, Collections.unmodifiableMap(r101));
    }

    public String toString() {
        if (this.annotations.containsKey("label") == false) goto L7;
        Object r100 = this.annotations.get("label");
    L6:
        return r100.toString();
    L7:
        r100 = this.key;
        goto L6
    }
}
