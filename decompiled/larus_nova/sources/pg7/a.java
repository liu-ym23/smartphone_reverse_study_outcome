package pg7;

import com.bytedance.bpea.basics.Cert;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: pg7.a$a, reason: collision with other inner class name */
    public static final class C7195a implements InvocationHandler {
        public C7195a() {
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object r100, Method r101, Object[] r102) {
            if (r101 == null) goto L5;
            String r103 = r101.getName();
        L7:
            if (Intrinsics.areEqual(r103, "certToken") == false) goto L10;
            return "bpea-pasteboard_empty_cert";
        L10:
            return null;
        L5:
            r103 = null;
            goto L7
        }
    }

    public static Cert a() {
        Object r100 = Proxy.newProxyInstance(Cert.class.getClassLoader(), new Class[]{Cert.class}, new C7195a());
        if (r100 == null) goto L7;
        return (Cert) r100;
    L7:
        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.bpea.basics.Cert");
    }

    static {
    }
}
