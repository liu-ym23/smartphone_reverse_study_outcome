package org.bouncycastle.x509;

import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: loaded from: classes42.dex */
public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection r100) {
        if (r100 == null) goto L7;
        this.collection = r100;
        return;
    L7:
        throw new NullPointerException("collection cannot be null");
    }

    public Object clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer("X509CollectionStoreParameters: [\n");
        r100.append("  collection: " + this.collection + "\n");
        r100.append("]");
        return r100.toString();
    }
}
