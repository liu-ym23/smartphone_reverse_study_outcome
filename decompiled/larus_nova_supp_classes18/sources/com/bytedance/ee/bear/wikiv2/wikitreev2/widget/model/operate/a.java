package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import io.reactivex.disposables.CompositeDisposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a$a, reason: collision with other inner class name */
    public static final class C0218a extends zq5.a {
        public String a;
        public String b;
        public WikiAction c;
        public Throwable d;
        public Integer e;

        public C0218a() {
            this.a = "";
            this.b = "";
            this.c = WikiAction.UNKNOWN;
        }
    }

    void delete(ce5.a r1, C0218a r2, CompositeDisposable r3);
}
