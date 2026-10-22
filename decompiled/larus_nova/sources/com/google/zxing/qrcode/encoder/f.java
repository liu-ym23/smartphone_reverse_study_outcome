package com.google.zxing.qrcode.encoder;

import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;

/* JADX INFO: loaded from: classes23.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Mode f276006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ErrorCorrectionLevel f276007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.google.zxing.qrcode.decoder.b f276008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f276009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f276010e;

    public final String toString() {
        StringBuilder r100 = new StringBuilder(200);
        r100.append("<<\n mode: ");
        r100.append(this.f276006a);
        r100.append("\n ecLevel: ");
        r100.append(this.f276007b);
        r100.append("\n version: ");
        r100.append(this.f276008c);
        r100.append("\n maskPattern: ");
        r100.append(this.f276009d);
        if (this.f276010e != null) goto L5;
        r100.append("\n matrix: null\n");
    L6:
        r100.append(">>\n");
        return r100.toString();
    L5:
        r100.append("\n matrix:\n");
        r100.append(this.f276010e);
        goto L6
    }

    public f() {
        this.f276009d = -1;
    }
}
