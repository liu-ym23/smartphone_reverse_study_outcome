package com.ss.android.lark.im.sdk.service;

import com.ss.android.lark.chat.entity.Channel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Channel f426119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f426120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Long> f426121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f426122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f426123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f426124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f426125g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Channel f426126a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<String> f426127b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List<Long> f426128c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f426129d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f426130e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f426131f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f426132g;

        public a() {
        }

        public final void a(Channel r100) {
            Intrinsics.checkNotNullParameter(r100, "channel");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f426126a = r100;
        }

        public final void b(List r100) {
            Intrinsics.checkNotNullParameter(r100, "messageIds");
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f426127b = r100;
        }
    }

    public z(a r100) {
        Channel r101 = r100.f426126a;
        List<String> r102 = null;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("channel");
        r101 = null;
    L6:
        this.f426119a = r101;
        List<String> r103 = r100.f426127b;
        if (r103 == null) goto L9;
        r102 = r103;
    L10:
        this.f426120b = r102;
        this.f426121c = r100.f426128c;
        this.f426122d = r100.f426129d;
        this.f426123e = r100.f426130e;
        this.f426124f = r100.f426131f;
        this.f426125g = r100.f426132g;
        return;
    L9:
        Intrinsics.throwUninitializedPropertyAccessException("messageIds");
        goto L10
    }
}
