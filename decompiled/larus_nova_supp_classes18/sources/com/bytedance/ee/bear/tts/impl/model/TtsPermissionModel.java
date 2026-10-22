package com.bytedance.ee.bear.tts.impl.model;

import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class TtsPermissionModel {
    public final String a;
    public final int b;
    public ro5.a c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final String toString() {
        return "TtsPermissionModel@" + hashCode() + "{permissionBean: " + this.c + '}';
    }

    public final Object a(Continuation<? super ro5.a> r4) {
        return BuildersKt.withContext(Dispatchers.getIO(), new TtsPermissionModel$reload$2(this, null), r4);
    }

    public TtsPermissionModel(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "docToken");
        this.a = r2;
        this.b = r3;
    }
}
