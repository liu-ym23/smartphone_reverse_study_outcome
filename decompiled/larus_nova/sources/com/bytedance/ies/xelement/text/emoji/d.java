package com.bytedance.ies.xelement.text.emoji;

import android.content.Context;
import android.graphics.drawable.Drawable;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d implements b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static d f250380b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f250381a;

    public static final class a {
        @JvmStatic
        public static d a() {
            if (d.f250380b == null) goto L5;
        L15:
            d r100 = d.f250380b;
            Intrinsics.checkNotNull(r100);
            return r100;
        L5:
            monitor-enter(d.class);
        L12:
            th = move-exception;
            throw th;
        L7:
            if (d.f250380b != null) goto L9;
            d.f250380b = new d();     // Catch: Throwable -> L12
        L9:
            Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L12
            monitor-exit(d.class);
            goto L15
        }
    }

    static {
    }

    public d() {
    }

    @Override // com.bytedance.ies.xelement.text.emoji.b
    public final Drawable a(Context r100, String r101) {
        b r102 = this.f250381a;
        if (r102 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r102 = null;
    L7:
        return r102.a(r100, r101);
    }
}
