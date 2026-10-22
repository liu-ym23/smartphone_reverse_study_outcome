package com.ss.android.lark.keyboard.event;

import android.util.SparseArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class EventContextImpl implements g, h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Factory f429283c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f429284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<Object> f429285b;

    public static final class Factory extends s<EventContextImpl> {
        public Factory() {
            super(AnonymousClass1.INSTANCE);
        }
    }

    static {
        f429283c = new Factory();
    }

    @Override // com.ss.android.lark.keyboard.event.g
    public final Object getValue() {
        d r100 = com.ss.android.lark.keyboard.base.f.a.f428231b;
        Intrinsics.checkNotNullParameter(r100, "key");
        SparseArray<Object> r101 = this.f429285b;
        int r102 = r100.hashCode();
        return r101.get(r102 ^ (r102 >>> 16));
    }

    @Override // com.ss.android.lark.keyboard.event.g
    public final com.ss.android.lark.keyboard.b n() {
        com.ss.android.lark.keyboard.b r100 = this.f429284a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public EventContextImpl() {
        this.f429285b = new SparseArray();
    }

    @Override // com.ss.android.lark.keyboard.event.h
    public final void a(Object r100) {
        Intrinsics.checkNotNullParameter(com.ss.android.lark.keyboard.base.f.a.f428231b, "$receiver");
        b(r100);
    }

    public final void b(Object r100) {
        d r101 = com.ss.android.lark.keyboard.base.f.a.f428231b;
        Intrinsics.checkNotNullParameter(r101, "key");
        SparseArray<Object> r102 = this.f429285b;
        int r103 = r101.hashCode();
        r102.put(r103 ^ (r103 >>> 16), r100);
    }
}
