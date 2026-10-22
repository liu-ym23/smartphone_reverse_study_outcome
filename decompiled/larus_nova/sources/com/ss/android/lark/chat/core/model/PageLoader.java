package com.ss.android.lark.chat.core.model;

import com.ss.android.lark.chat.core.model.PageLoader.b;
import com.ss.android.lark.log.Log;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executor;
import x4b.m;

/* JADX INFO: loaded from: classes35.dex */
public abstract class PageLoader<T extends b, PageData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f414761a;

    public interface IReceiver<PageData> {

        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultType {
            public static final int AFTER = 1;
            public static final int BEFORE = 2;
            public static final int INIT = 0;
        }

        void a(int r100, x4b.a r101);

        void b(Throwable r100);
    }

    public interface a<PageData> {
        void a(x4b.a r100);

        void onError(Throwable r100);
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c f414762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f414763b;

        public b(final int r100, int r101) {
            this.f414762a = new m(r100);
            this.f414763b = r101;
        }

        public b(c r100, int r101) {
            this.f414762a = r100;
            this.f414763b = r101;
        }
    }

    public interface c {
        int getPosition();
    }

    public static class d<PageData> implements a<PageData> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IReceiver<PageData> f414764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f414765b;

        @Override // com.ss.android.lark.chat.core.model.PageLoader.a
        public final void a(x4b.a r100) {
            IReceiver<PageData> r101 = this.f414764a;
            if (r101 == null) goto L6;
            r101.a(this.f414765b, r100);
            return;
        }

        @Override // com.ss.android.lark.chat.core.model.PageLoader.a
        public final void onError(Throwable r100) {
            IReceiver<PageData> r101 = this.f414764a;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }

        public d(IReceiver<PageData> r100, int r101) {
            this.f414764a = r100;
            this.f414765b = r101;
        }
    }

    public PageLoader(Executor r100) {
        this.f414761a = r100;
    }

    public final void a(Runnable r100) {
        Executor r101 = this.f414761a;
        if (r101 == null) goto L5;
        r101.execute(r100);
        return;
    L5:
        Log.e("PageLoader", new Exception("ExecuteAction, loadExecutor is null"), true);
        r100.run();
    }
}
