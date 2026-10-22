package wt5;

import android.net.Uri;
import com.alibaba.fastjson.JSON;
import com.bytedance.ee.permission.sdk.define.IPermissionApi$ERequestMethod;
import com.ss.android.lark.chameleon.idependency.INetCallback;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.idependency.NetService;
import com.ss.android.lark.docs.sdk.domain.DomainService;
import com.ss.android.lark.docs.sdk.domain.EDomainType;
import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import xt5.b;
import xt5.c;

/* JADX INFO: loaded from: classes19.dex */
public class b<T extends xt5.b, R extends xt5.c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f561216a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Class<R> f561217b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xt5.a<R> f561218c;

    public static final class a {
    }

    /* JADX INFO: renamed from: wt5.b$b, reason: collision with other inner class name */
    public static final class C8160b<R extends xt5.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final R f561219a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f561220b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C8160b) == true) goto L8;
            return false;
        L8:
            C8160b r101 = (C8160b) r100;
            if (Intrinsics.areEqual(this.f561219a, r101.f561219a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f561220b, r101.f561220b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            R r100 = this.f561219a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Throwable r104 = this.f561220b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Parsed(result=" + this.f561219a + ", error=" + this.f561220b + ')';
        }

        public C8160b(R r100, Throwable r101) {
            this.f561219a = r100;
            this.f561220b = r101;
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f561221a = null;

        static {
            int[] r100 = new int[IPermissionApi$ERequestMethod.values().length];
            r100[IPermissionApi$ERequestMethod.GET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[IPermissionApi$ERequestMethod.POST.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f561221a = r100;
        }
    }

    public static final class d implements INetCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b<T, R> f561222a;

        public d(b<T, R> r100) {
            this.f561222a = r100;
        }

        @Override // com.ss.android.lark.chameleon.idependency.INetCallback
        public final void onFailure(int r100, String r101) {
            Log.e("PermissionApiExecutor", "requestJson - onFailure, errorCode: " + r100 + ", errorMsg: " + r101);
            xt5.a<R> r102 = this.f561222a.f561218c;
            if (r102 == null) goto L6;
            r102.onError(r100, new RuntimeException(r101));
            return;
        }

        @Override // com.ss.android.lark.chameleon.idependency.INetCallback
        public final void onSuccess(int r100, String r101) {
            C8160b<R> r102 = this.f561222a.a(r101);
            Throwable r103 = r102.f561220b;
            if (r103 == null) goto L6;
            b<T, R> r104 = this.f561222a;
            onFailure(-1, "Request successfully but parse failed, request: " + r104.f561216a + ", resultClass: " + r104.f561217b + ", error: " + r103);
            return;
        L6:
            Log.e("PermissionApiExecutor", "requestJson - onSuccess, result: " + r102.f561219a);
            xt5.a<R> r105 = this.f561222a.f561218c;
            if (r105 == null) goto L10;
            r105.a(r102.f561219a);
            return;
        }
    }

    static {
    }

    public final void b() {
        Uri r100 = new DomainService().a(EDomainType.DOCS_API, this.f561216a.a());
        String r101 = "";
        if (r100 == null) goto L7;
        String r102 = r100.toString();
        if (r102 == null) goto L7;
    L8:
        IPermissionApi$ERequestMethod r103 = this.f561216a.getMethod();
        d r104 = new d(this);
        int r105 = c.f561221a[r103.ordinal()];
        if (r105 != 1) goto L11;
        NetService.INSTANCE.httpGet(r102, null, r104);
        return;
    L11:
        if (r105 == 2) goto L13;
        Log.e("PermissionApiExecutor", "requestJson, unknown request method: " + r103);
        return;
    L13:
        Map<String, Serializable> r106 = this.f561216a.b();
        if (r106 != null) goto L27;
        r101 = null;
    L24:
        NetService.INSTANCE.httpPost(r102, null, r101, r104);
        return;
    L27:
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L22
        Iterator<Map.Entry<String, Serializable>> r108 = r106.entrySet().iterator();     // Catch: Exception -> L22
    L18:
        if (r108.hasNext() == false) goto L20;
        Map.Entry<String, Serializable> r109 = r108.next();     // Catch: Exception -> L22
        r107.putOpt(r109.getKey(), r109.getValue());     // Catch: Exception -> L22
        goto L18
    L20:
        r101 = r107.toString();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        Log.e("PermissionApiExecutor", "buildJsonParams, error: ", e);
    L7:
        r102 = "";
        goto L8
    }

    public C8160b<R> a(String r100) {
    L8:
        e = move-exception;
        return new C8160b(null, e);
    L4:
        if (r100 != null) goto L6;
        r100 = "";
    L6:
        return new C8160b((xt5.c) JSON.parseObject(new JSONObject(r100).optString("data"), this.f561217b), null);
    }

    public b(T r100, Class<R> r101, xt5.a<R> r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        Intrinsics.checkNotNullParameter(r101, "resultClass");
        this.f561216a = r100;
        this.f561217b = r101;
        this.f561218c = r102;
    }
}
