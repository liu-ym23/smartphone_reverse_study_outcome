package org.bouncycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes42.dex */
public class PemObject implements PemObjectGenerator {
    private static final List EMPTY_LIST = null;
    private byte[] content;
    private List headers;
    private String type;

    static {
        EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
    }

    public PemObject(String r100, List r101, byte[] r102) {
        this.type = r100;
        this.headers = Collections.unmodifiableList(r101);
        this.content = r102;
    }

    public PemObject(String r100, byte[] r101) {
        this(r100, EMPTY_LIST, r101);
    }

    @Override // org.bouncycastle.util.io.pem.PemObjectGenerator
    public PemObject generate() throws PemGenerationException {
        return this;
    }

    public byte[] getContent() {
        return this.content;
    }

    public List getHeaders() {
        return this.headers;
    }

    public String getType() {
        return this.type;
    }
}
