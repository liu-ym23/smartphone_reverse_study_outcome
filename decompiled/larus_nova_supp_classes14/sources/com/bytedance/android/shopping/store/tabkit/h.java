package com.bytedance.android.shopping.store.tabkit;

import android.util.SparseArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h {
    public final a a;
    public final SparseArray<a> b;

    public static final class a {
        public boolean a;
        public long b;
        public long c;

        public a() {
            this(0);
        }

        public a(int r3) {
            this.a = false;
            this.b = 0;
            this.c = 0;
        }
    }

    public h() {
        this.a = new a(0);
        this.b = new SparseArray();
    }
}
