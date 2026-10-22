package com.bytedance.lark.lynxlib.image;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends xkb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f253264b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lynx.tasm.ui.imageloader.a.c f253265a;

    static {
        f253264b = "com.bytedance.ee.ref.card.core.1".getBytes(Key.CHARSET);
    }

    public a(com.bytedance.lynx.tasm.ui.imageloader.a.c r100) {
        this.f253265a = r100;
    }

    @Override // xkb.a
    public final void a(MessageDigest r100) {
        r100.update(f253264b);
    }
}
