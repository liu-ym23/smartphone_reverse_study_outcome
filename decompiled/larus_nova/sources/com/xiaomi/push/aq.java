package com.xiaomi.push;

/* JADX INFO: loaded from: classes41.dex */
public class aq implements as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f463148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f463149b;

    @Override // com.xiaomi.push.as
    public String a() {
        return this.f463148a;
    }

    @Override // com.xiaomi.push.as
    public String b() {
        return this.f463149b;
    }

    public aq(String r100, String r101) {
        if (r100 == null) goto L7;
        this.f463148a = r100;
        this.f463149b = r101;
        return;
    L7:
        throw new IllegalArgumentException("Name may not be null");
    }
}
