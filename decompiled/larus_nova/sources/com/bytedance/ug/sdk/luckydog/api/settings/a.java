package com.bytedance.ug.sdk.luckydog.api.settings;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f271594a;

    /* JADX INFO: renamed from: com.bytedance.ug.sdk.luckydog.api.settings.a$a, reason: collision with other inner class name */
    public static class C3803a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f271595a = null;

        static {
            f271595a = new a();
        }
    }

    public final boolean a() {
        return this.f271594a.get();
    }

    public a() {
        this.f271594a = new AtomicBoolean(false);
    }
}
