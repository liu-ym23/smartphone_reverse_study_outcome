package com.privacy.azerothprivacy.exception;

import fpa.a;
import fpa.f;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class AzerothException extends Exception {
    private final Map<String, String> debugData;

    public Map<String, String> getDebugData() {
        return this.debugData;
    }

    public AzerothException(String r100) {
        super(r100);
        this.debugData = a.a();
    }

    public AzerothException(String r100, f... r101) {
        super(r100);
        this.debugData = a.a();
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L9;
        f r104 = r101[r103];
        this.debugData.put(r104.f478392a, r104.f478393b);
        r103 = r103 + 1;
        goto L5
    L9:
        return;
    }

    public AzerothException(String r100, Throwable r101) {
        super(r100, r101);
        this.debugData = a.a();
    }

    public AzerothException(String r100, Throwable r101, f... r102) {
        super(r100, r101);
        this.debugData = a.a();
        if (r102 == null) goto L7;
        int r103 = r102.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L9;
        f r105 = r102[r104];
        this.debugData.put(r105.f478392a, r105.f478393b);
        r104 = r104 + 1;
        goto L5
    L9:
        return;
    }

    public AzerothException(String r100, Throwable r101, Map<String, String> r102) {
        super(r100, r101);
        Map<String, String> r103 = a.a();
        this.debugData = r103;
        r103.putAll(r102);
    }
}
