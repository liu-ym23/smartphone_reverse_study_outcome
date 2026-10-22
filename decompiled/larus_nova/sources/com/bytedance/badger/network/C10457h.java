package com.bytedance.badger.network;

import com.bytedance.badger.data.BadgerUpdateInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: renamed from: com.bytedance.badger.network.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes47.dex */
final class C10457h extends Lambda implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C10457h f199107a = null;

    static {
        f199107a = new C10457h();
    }

    public C10457h() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Object invoke(Object r100) {
        BadgerUpdateInfo r101 = (BadgerUpdateInfo) r100;
        com.bytedance.badger.monitor.c.f199044c.getClass();
        com.bytedance.badger.monitor.c.e();
        return Unit.INSTANCE;
    }
}
