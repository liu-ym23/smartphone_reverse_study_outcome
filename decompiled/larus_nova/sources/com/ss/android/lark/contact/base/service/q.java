package com.ss.android.lark.contact.base.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<f9b.a> f418934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f418935b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final q f418936a = null;

        static {
            f418936a = new q();
        }
    }

    public interface b {
        void a();
    }

    public interface c extends b {
        void b(com.ss.android.lark.contact.base.entity.a r100);
    }

    public q() {
        this.f418934a = new CopyOnWriteArrayList();
        this.f418935b = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
    }
}
