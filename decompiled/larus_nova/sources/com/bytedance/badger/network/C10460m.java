package com.bytedance.badger.network;

import com.bytedance.badger.Badger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10460m extends Lambda implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C10460m f199120a = null;

    static {
        f199120a = new C10460m();
    }

    public C10460m() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return new j0(Badger.INSTANCE.getContext().getApplicationContext());
    }
}
