package com.bytedance.lark.sdk;

import java.io.ByteArrayInputStream;

/* JADX INFO: loaded from: classes20.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f254134d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayInputStream f254135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f254136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f254137c;

    public static final class a {
    }

    static {
    }

    public /* synthetic */ c(byte[] r100) {
        this(r100, "application/octet-stream");
    }

    public c(byte[] r100, String r101) {
        this.f254136b = "application/octet-stream";
        int r102 = r100.length;
        this.f254137c = r100;
        this.f254135a = new ByteArrayInputStream(r100);
        this.f254136b = r101;
    }
}
