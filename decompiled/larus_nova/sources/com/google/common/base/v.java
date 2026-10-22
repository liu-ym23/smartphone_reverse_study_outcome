package com.google.common.base;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f274741a = null;

    public class a extends v {
        @Override // com.google.common.base.v
        public final long a() {
            return System.nanoTime();
        }

        public a() {
        }
    }

    public v() {
    }

    public abstract long a();

    static {
        f274741a = new a();
    }
}
