package com.bytedance.timonbase;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import java.util.Stack;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\b\u0010\n\u001a\u0004\u0018\u00010\tR \u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\f0\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/bytedance/timonbase/TimonTokenStack;", "", "", "token", "", "push", "", "extras", "pop", "Lcom/bytedance/timonbase/TimonTokenStack$a;", "currentToken", "Ljava/lang/ThreadLocal;", "Ljava/util/Stack;", "threadLocal", "Ljava/lang/ThreadLocal;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "timonfoundation_release"}, k = 1, mv = {1, 4, 0})
public final class TimonTokenStack {
    public static final TimonTokenStack INSTANCE = null;
    private static final ThreadLocal<Stack<a>> threadLocal = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f270785a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f270786b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f270785a, r101.f270785a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f270786b, r101.f270786b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f270785a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Map<String, String> r104 = this.f270786b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "TokenItem(value=" + this.f270785a + ", extras=" + this.f270786b + ")";
        }

        public a(String r100, Map<String, String> r101) {
            this.f270785a = r100;
            this.f270786b = r101;
        }
    }

    private TimonTokenStack() {
    }

    static {
        INSTANCE = new TimonTokenStack();
        threadLocal = new ThreadLocal();
    }

    public final a currentToken() {
        Stack<a> r100 = threadLocal.get();
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.empty() == false) goto L8;
        return null;
    L8:
        return r100.peek();
    }

    @JvmStatic
    public static final void pop(String r100) {
        Stack<a> r101 = threadLocal.get();
        if (r101 == null) goto L6;
        r101.pop();
        return;
    }

    @JvmStatic
    public static final void push(String r100) {
        push(r100, MapsKt.emptyMap());
    }

    @JvmStatic
    public static final void push(String r100, Map<String, String> r101) {
        ThreadLocal<Stack<a>> r102 = threadLocal;
        Stack<a> r103 = r102.get();
        if (r103 != null) goto L6;
        r103 = new Stack();
        r102.set(r103);
    L6:
        r103.push(new a(r100, r101));
    }
}
