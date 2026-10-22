package com.franmontiel.persistentcookiejar;

import java.util.ArrayList;
import java.util.List;
import okhttp3.HttpUrl;
import okhttp3.g;

/* JADX INFO: loaded from: classes23.dex */
public class PersistentCookieJar implements ClearableCookieJar {
    @Override // okhttp3.h
    public final synchronized List<g> a(HttpUrl r100) {
        monitor-enter(this);
        new ArrayList();     // Catch: Throwable -> L5
        new ArrayList();     // Catch: Throwable -> L5
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // okhttp3.h
    public final synchronized void b(HttpUrl r100, List<g> r101) {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }
}
