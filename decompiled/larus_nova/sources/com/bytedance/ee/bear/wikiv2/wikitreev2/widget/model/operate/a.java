package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: classes18.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a$a, reason: collision with other inner class name */
    public static final class C3465a extends zq5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f241978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f241979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public WikiAction f241980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f241981d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Integer f241982e;

        public C3465a() {
            this.f241978a = "";
            this.f241979b = "";
            this.f241980c = WikiAction.UNKNOWN;
        }
    }

    void delete(ce5.a r100, C3465a r101, CompositeDisposable r102);
}
