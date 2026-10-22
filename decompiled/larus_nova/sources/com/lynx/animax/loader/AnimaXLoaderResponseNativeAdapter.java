package com.lynx.animax.loader;

import u4a.j;

/* JADX INFO: loaded from: classes32.dex */
public final class AnimaXLoaderResponseNativeAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimaXLoaderResponse<?> f380310a;

    public AnimaXCloseableBitmapReferenceNativeAdapter getBitmap() {
        return new AnimaXCloseableBitmapReferenceNativeAdapter((j) this.f380310a.f380308b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] getData() {
        return (byte[]) this.f380310a.f380308b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getErrorMessage() {
        if (this.f380310a.getType() != AnimaXLoaderResponse.Type.ERROR) goto L8;
        Throwable r100 = (Throwable) this.f380310a.f380308b;
        if (r100 != null) goto L7;
        return "";
    L7:
        return r100.getMessage();
    L8:
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getFilePath() {
        return (String) this.f380310a.f380308b;
    }

    public int getType() {
        return this.f380310a.getType().ordinal();
    }

    public AnimaXLoaderResponseNativeAdapter(AnimaXLoaderResponse<?> r100) {
        this.f380310a = r100;
    }
}
