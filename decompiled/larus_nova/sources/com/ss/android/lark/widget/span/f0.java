package com.ss.android.lark.widget.span;

import android.text.TextUtils;
import androidx.collection.LruCache;

/* JADX INFO: loaded from: classes38.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<Integer, RecogniseSpansResult> f448674a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f0 f448675a = null;

        static {
            f448675a = new f0();
        }
    }

    public f0() {
        this.f448674a = new LruCache(100);
    }

    public final synchronized RecogniseSpansResult a(String r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        RecogniseSpansResult r101 = this.f448674a.get(Integer.valueOf(r100.hashCode()));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public final synchronized void b(String r100, RecogniseSpansResult r101) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L10;
        if (r101 == null) goto L10;
        this.f448674a.put(Integer.valueOf(r100.hashCode()), r101);     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L10:
        monitor-exit(this);
    }
}
