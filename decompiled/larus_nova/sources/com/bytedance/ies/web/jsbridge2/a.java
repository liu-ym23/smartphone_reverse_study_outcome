package com.bytedance.ies.web.jsbridge2;

import android.view.View;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f249293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile View f249294b;

    /* JADX INFO: renamed from: com.bytedance.ies.web.jsbridge2.a$a, reason: collision with other inner class name */
    public static final class C3554a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WebView f249295c;

        @Override // com.bytedance.ies.web.jsbridge2.a
        public final View b() {
            return this.f249295c;
        }

        public C3554a(WebView r100) {
            this.f249295c = r100;
        }
    }

    public abstract View b();

    public final View a() {
        if (this.f249293a == true) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f249293a == true) goto L8;
        this.f249293a = true;     // Catch: Throwable -> L10
        this.f249294b = b();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f249294b;
    }

    public a() {
        this.f249293a = false;
        this.f249294b = null;
    }
}
