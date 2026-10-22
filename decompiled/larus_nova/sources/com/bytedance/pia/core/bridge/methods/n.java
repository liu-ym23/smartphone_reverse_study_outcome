package com.bytedance.pia.core.bridge.methods;

import android.content.Context;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.api.resource.LoadFrom;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class n implements PiaMethod.a<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PiaMethod<c, d> f266208a = null;

    public static final class a<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f266209a = null;

        static {
            f266209a = new a();
        }

        public a() {
        }

        @Override // l47.b
        public final Object create() {
            return new n();
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\r¨\u0006\u0010"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/n$c;", "", "", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "loadFrom", "b", "", "headers", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "options", "c", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("headers")
        private final Map<String, String> headers;

        @SerializedName("loadFrom")
        private final String loadFrom;

        @SerializedName("options")
        private final Map<String, String> options;

        @SerializedName("url")
        private final String url;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.url, r101.url) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.loadFrom, r101.loadFrom) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.headers, r101.headers) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.options, r101.options) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.url;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.loadFrom;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Map<String, String> r107 = this.headers;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Map<String, String> r110 = this.options;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(url=" + this.url + ", loadFrom=" + this.loadFrom + ", headers=" + this.headers + ", options=" + this.options + ')';
        }

        public final Map<String, String> a() {
            return this.headers;
        }

        public final String b() {
            return this.loadFrom;
        }

        public final Map<String, String> c() {
            return this.options;
        }

        public final String d() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/n$d;", "", "", "content", "Ljava/lang/String;", "getContent", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("content")
        private final String content;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.content, ((d) r100).content) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.content;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Result(content=" + this.content + ')';
        }

        public d(String r100) {
            this.content = r100;
        }
    }

    public n() {
    }

    static {
        f266208a = new PiaMethod("pia.internal.preload.resource", PiaMethod.Scope.All, a.f266209a);
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.a
    public final void a(m47.o r100, Object r101, m47.h r102, m47.i r103) {
        c r104 = (c) r101;
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        if ((r100.getContext() instanceof b47.b) == false) goto L5;
        e47.b r105 = r100.getContext();
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.bytedance.pia.core.PiaContext");
        i47.b r106 = i47.a.a(((b47.b) r105).f17566o);
    L6:
        if (r106 != null) goto L8;
        r103.accept(new PiaMethod.Error("preloader is null"));
        return;
    L8:
        q r107 = new q(r104);
        if (r106.d(r104.d(), r107) == false) goto L11;
        r103.accept(new PiaMethod.Error("resource has preloaded"));
        return;
    L11:
        String r108 = r104.b();
        if (r108 != null) goto L14;
        r108 = "Auto";
    L14:
        r106.e(LoadFrom.valueOf(r108), r107, new o(r102, r103), new p(r103));
        return;
    L5:
        Context r109 = c47.c.a.f22405a;
        r106 = null;
        goto L6
    }
}
