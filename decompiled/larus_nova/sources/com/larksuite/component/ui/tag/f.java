package com.larksuite.component.ui.tag;

import android.content.Context;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes24.dex */
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f284457g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f284458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f284459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f284460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<Context, String> f284461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lambda f284462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lambda f284463f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f284464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f284465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f284466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f284467d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f284468e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Integer f284469f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f284470g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Integer f284471h;

        public final f a() {
            return new f(this);
        }

        public a() {
            this.f284464a = -1;
            this.f284465b = 100;
        }
    }

    public static final class b {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f284458a, ((f) r100).f284458a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.f284458a.hashCode();
    }

    public final String toString() {
        return "TextTag(bd=" + this.f284458a + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v5, types: [kotlin.jvm.internal.Lambda] */
    /* JADX WARN: Type inference failed for: r0v8, types: [kotlin.jvm.internal.Lambda] */
    public f(final a r100) {
        this.f284458a = r100;
        this.f284459b = r100.f284464a;
        this.f284460c = r100.f284465b;
        this.f284461d = new TextTag$Builder$text$1(r100);
        if (r100.f284469f == null) goto L5;
        ?? r101 = new TextTag$Builder$textColor$1(r100);
    L6:
        this.f284462e = r101;
        if (r100.f284471h == null) goto L9;
        ?? r102 = new TextTag$Builder$bgColor$1(r100);
    L10:
        this.f284463f = r102;
        return;
    L9:
        r102 = new TextTag$Builder$bgColor$2(r100);
        goto L10
    L5:
        r101 = new TextTag$Builder$textColor$2(r100);
        goto L6
    }
}
