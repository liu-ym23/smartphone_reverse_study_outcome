package com.bytedance.crash.upload;

import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentLinkedQueue<a> f203349a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<C2955a> f203350b = null;

    /* JADX INFO: renamed from: com.bytedance.crash.upload.a$a, reason: collision with other inner class name */
    public static class C2955a {
        public C2955a() {
        }
    }

    public a() {
    }

    public abstract void a();

    static {
        f203349a = new ConcurrentLinkedQueue();
        f203350b = new LinkedList();
    }
}
