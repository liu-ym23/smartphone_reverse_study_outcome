package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.ThreadUtil;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class f implements PiaMethod.a<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PiaMethod<c, d> f266180a = null;

    public static final class a<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f266181a = null;

        static {
            f266181a = new a();
        }

        public a() {
        }

        @Override // l47.b
        public final Object create() {
            return new f();
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/f$c;", "", "", "url", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "", "extraVary", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("extraVary")
        private final List<String> extraVary;

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
            if (Intrinsics.areEqual(this.extraVary, r101.extraVary) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.url;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            List<String> r104 = this.extraVary;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Params(url=" + this.url + ", extraVary=" + this.extraVary + ')';
        }

        public c() {
            this.url = null;
            this.extraVary = null;
        }

        public final List<String> a() {
            return this.extraVary;
        }

        public final String b() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/f$d;", "", "Lcom/google/gson/JsonObject;", "headers", "Lcom/google/gson/JsonObject;", "getHeaders", "()Lcom/google/gson/JsonObject;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("headers")
        private final JsonObject headers;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.headers, ((d) r100).headers) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            JsonObject r100 = this.headers;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Result(headers=" + this.headers + ')';
        }

        public d(JsonObject r100) {
            this.headers = r100;
        }
    }

    public f() {
    }

    static {
        f266180a = new PiaMethod("pia.internal.cache.getHeaders", PiaMethod.Scope.All, a.f266181a);
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.a
    public final void a(m47.o r100, Object r101, m47.h r102, m47.i r103) {
        c r104 = (c) r101;
        Intrinsics.checkNotNullParameter(r100, "bridge");
        Intrinsics.checkNotNullParameter(r104, "params");
        Intrinsics.checkNotNullParameter(r102, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r103, "reject");
        if (TextUtils.isEmpty(r104.b()) == false) goto L30;
        r103.accept(new PiaMethod.InvalidParamsError("Parameter 'url' required!"));
        return;
    L30:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(com.bytedance.pia.core.utils.j.a(UriProtector.parse(r104.b())));     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r106) != null) goto L28;
        Uri r107 = (Uri) r106;
        String r108 = com.bytedance.pia.core.utils.j.g(r107, null);
        boolean r109 = false;
        if (r108 != null) goto L14;
    L17:
        boolean r110 = true;
    L18:
        if (r110 == false) goto L20;
        r103.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
        return;
    L20:
        String r111 = com.bytedance.pia.core.utils.j.g(r107, r104.a());
        if (r111 != null) goto L23;
    L24:
        r109 = true;
    L25:
        if (r109 == false) goto L27;
        r103.accept(new PiaMethod.InvalidParamsError("Parameter 'url' & 'extraVary' invalid!"));
        return;
    L27:
        ThreadUtil.c(new g(r102, r111, r103));
        return;
    L23:
        if (r111.length() != 0) goto L25;
    L14:
        if (r108.length() == 0) goto L17;
        r110 = false;
        goto L18
    L28:
        r103.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
        return;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
