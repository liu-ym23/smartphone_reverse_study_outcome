package com.larus.im.internal.delegate;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f348191a = null;

    public static final class a extends fe9.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f348192a;

        public a() {
            this.f348192a = "FlowSettingsLogger";
        }

        @Override // fe9.f
        public final String d() {
            return this.f348192a;
        }
    }

    static {
        f348191a = LazyKt.lazy(new z());
    }

    public static final a a() {
        return (a) f348191a.getValue();
    }
}
