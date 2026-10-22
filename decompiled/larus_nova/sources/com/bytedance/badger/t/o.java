package com.bytedance.badger.t;

import java.io.ByteArrayOutputStream;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayOutputStream f199208a;

    public o() {
        this.f199208a = new ByteArrayOutputStream();
    }

    public final void a(int r100) {
        this.f199208a.write(1);
        this.f199208a.write((r100 >> 24) & 255);
        this.f199208a.write((r100 >> 16) & 255);
        this.f199208a.write((r100 >> 8) & 255);
        this.f199208a.write(r100 & 255);
    }

    public final void b(long r100) {
        this.f199208a.write(2);
        this.f199208a.write((int) ((r100 >> 56) & 255));
        this.f199208a.write((int) ((r100 >> 48) & 255));
        this.f199208a.write((int) ((r100 >> 40) & 255));
        this.f199208a.write((int) ((r100 >> 32) & 255));
        this.f199208a.write((int) ((r100 >> 24) & 255));
        this.f199208a.write((int) ((r100 >> 16) & 255));
        this.f199208a.write((int) ((r100 >> 8) & 255));
        this.f199208a.write((int) (r100 & 255));
    }

    public final void c(String r100) {
        byte[] r101 = r100.getBytes(Charsets.UTF_8);
        this.f199208a.write(3);
        int r102 = r101.length;
        this.f199208a.write((r102 >> 8) & 255);
        this.f199208a.write(r102 & 255);
        this.f199208a.write(r101);
    }

    public final void d(byte[] r100) {
        this.f199208a.write(4);
        int r101 = r100.length;
        this.f199208a.write((r101 >> 8) & 255);
        this.f199208a.write(r101 & 255);
        this.f199208a.write(r100);
    }
}
