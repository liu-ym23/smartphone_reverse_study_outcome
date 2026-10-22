package com.ss.android.lark.contact.base.service;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class InvRequestUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f418898a = 0;

    public static final class LocalAndServerRequestImpl<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<T> f418899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f418900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f418901c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 f418902d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 f418903e;

        public LocalAndServerRequestImpl(a<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "dataCallback");
            this.f418899a = r100;
            this.f418902d = new InvRequestUtils$LocalAndServerRequestImpl$localCallback$1(this);
            this.f418903e = new InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1(this);
        }
    }

    public interface a<T> {
        void a(InvRequestUtils$LocalAndServerRequestImpl$localCallback$1 r100);

        void b(boolean r100, T r101);

        void c();

        boolean d(T r100);

        void e(InvRequestUtils$LocalAndServerRequestImpl$serverCallback$1 r100);

        void f(ErrorResult r100);

        void onShowLoading();
    }

    static {
    }
}
