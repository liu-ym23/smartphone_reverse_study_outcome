package com.larksuite.framework.http.request;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes24.dex */
public class FormBody extends RequestBody {
    private final Charset charset;
    private final Map<String, String> name2Value;

    public Map<String, String> getName2Value() {
        return new HashMap(this.name2Value);
    }

    public Charset getCharset() {
        return this.charset;
    }

    public FormBody(Map<String, String> r100, Charset r101) {
        HashMap r102 = new HashMap();
        this.name2Value = r102;
        r102.clear();
        r102.putAll(r100);
        this.charset = r101;
    }
}
