package com.ss.android.lark.keyboard_biz_emoji_office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f431065a;

    public static final class a extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f431066b = null;

        static {
            f431066b = new a();
        }

        public a() {
            super("custom_sticker");
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f431067b = null;

        static {
            f431067b = new b();
        }

        public b() {
            super("emoji");
        }
    }

    public final int hashCode() {
        return this.f431065a.hashCode();
    }

    public c(String r100) {
        this.f431065a = r100;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(this.f431065a, ((c) r100).f431065a);
    }
}
