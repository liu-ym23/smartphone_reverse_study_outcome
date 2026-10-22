package com.bytedance.pia.core.bridge.methods;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.pia.core.api.bridge.PiaMethod;
import com.bytedance.pia.core.utils.ManifestUtils;
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
public final class j implements PiaMethod.a<c, d> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PiaMethod<c, d> f266195a = null;

    public static final class a<T> implements l47.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T> f266196a = null;

        static {
            f266196a = new a();
        }

        public a() {
        }

        @Override // l47.b
        public final Object create() {
            return new j();
        }

        @Override // l47.b
        public final Object create(Object r100) {
            return create();
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/j$c;", "", "", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "extraVary", "Ljava/util/List;", "b", "()Ljava/util/List;", "content", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "force", "Ljava/lang/Boolean;", "c", "()Ljava/lang/Boolean;", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("content")
        private final String content;

        @SerializedName("extraVary")
        private final List<String> extraVary;

        @SerializedName("force")
        private final Boolean force;

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
            if (Intrinsics.areEqual(this.extraVary, r101.extraVary) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.content, r101.content) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.force, r101.force) == true) goto L20;
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
            List<String> r104 = this.extraVary;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.content;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Boolean r110 = this.force;
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
            return "Params(url=" + this.url + ", extraVary=" + this.extraVary + ", content=" + this.content + ", force=" + this.force + ')';
        }

        public final String a() {
            return this.content;
        }

        public final List<String> b() {
            return this.extraVary;
        }

        public final Boolean c() {
            return this.force;
        }

        public final String d() {
            return this.url;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/pia/core/bridge/methods/j$d;", "", "", "isUpdate", "Z", "()Z", "anniex_release"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("isUpdate")
        private final boolean isUpdate;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.isUpdate == ((d) r100).isUpdate) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.isUpdate == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Result(isUpdate=" + this.isUpdate + ')';
        }

        public d(boolean r100) {
            this.isUpdate = r100;
        }
    }

    public j() {
    }

    static {
        f266195a = new PiaMethod("pia.internal.cache.save", PiaMethod.Scope.All, a.f266196a);
    }

    @Override // com.bytedance.pia.core.api.bridge.PiaMethod.a
    public final void a(m47.o r110, Object r111, m47.h r112, m47.i r113) {
        c r114 = (c) r111;
        Intrinsics.checkNotNullParameter(r110, "bridge");
        Intrinsics.checkNotNullParameter(r114, "params");
        Intrinsics.checkNotNullParameter(r112, JSEventListener.ACTION_RESOLVE);
        Intrinsics.checkNotNullParameter(r113, "reject");
        if (TextUtils.isEmpty(r114.d()) == false) goto L55;
        r113.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
        return;
    L55:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L7
        Object r116 = Result.m9449constructorimpl(com.bytedance.pia.core.utils.j.a(UriProtector.parse(r114.d())));     // Catch: Throwable -> L7
    L10:
        if (Result.m9452exceptionOrNullimpl(r116) != null) goto L53;
        Uri r100 = (Uri) r116;
        String r117 = com.bytedance.pia.core.utils.j.g(r100, null);
        boolean r101 = false;
        if (r117 != null) goto L14;
    L17:
        boolean r102 = true;
    L18:
        if (r102 == false) goto L20;
        r113.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
        return;
    L20:
        List<String> r103 = r114.b();
        String r104 = com.bytedance.pia.core.utils.j.g(r100, r103);
        if (r104 != null) goto L23;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == false) goto L30;
        r113.accept(new PiaMethod.InvalidParamsError("Parameter 'url' & 'extraVary' invalid!"));
        return;
    L30:
        if (Intrinsics.areEqual(r114.c(), Boolean.TRUE) == false) goto L32;
    L34:
        String r118 = r114.a();
        if (r118 != null) goto L37;
    L38:
        r101 = true;
    L39:
        if (r101 == true) goto L52;
        String r106 = r114.a();
        JsonObject r107 = ManifestUtils.c(r106);
        if (r107 != null) goto L43;
        r113.accept(new PiaMethod.Error(-10002, "Invalid manifest in content."));
        return;
    L43:
        o47.a.C7013a r119 = o47.f.i(r107);
        if (r119 != null) goto L46;
    L51:
        r113.accept(new PiaMethod.Error(-10003, "Invalid cache in manifest."));
        return;
    L46:
        if (r119.c() != null) goto L48;
    L50:
        ThreadUtil.c(new k(r100, r106, r107, r103, r112, r113));
        return;
    L48:
        if (r119.c().longValue() > 0) goto L50;
    L52:
        r113.accept(new PiaMethod.InvalidParamsError("Parameter 'content' invalid!"));
        return;
    L37:
        if (r118.length() != 0) goto L39;
    L32:
        if (Intrinsics.areEqual(r117, r104) == false) goto L34;
        r113.accept(new PiaMethod.Error(-10001, "Can't modify the original html."));
        return;
    L23:
        if (r104.length() == 0) goto L26;
        r105 = false;
        goto L27
    L14:
        if (r117.length() == 0) goto L17;
        r102 = false;
        goto L18
    L53:
        r113.accept(new PiaMethod.InvalidParamsError("Parameter 'url' invalid!"));
        return;
    L7:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }
}
