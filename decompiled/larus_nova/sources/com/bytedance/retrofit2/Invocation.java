package com.bytedance.retrofit2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class Invocation {
    private final List<?> arguments;
    private final Method method;

    public String toString() {
        return String.format("%s.%s() %s", new Object[]{this.method.getDeclaringClass().getName(), this.method.getName(), this.arguments});
    }

    public List<?> arguments() {
        return this.arguments;
    }

    public Method method() {
        return this.method;
    }

    public Invocation(Method r100, List<?> r101) {
        this.method = r100;
        this.arguments = Collections.unmodifiableList(r101);
    }

    public static Invocation of(Method r100, List<?> r101) {
        Utils.checkNotNull(r100, "method == null");
        Utils.checkNotNull(r101, "arguments == null");
        return new Invocation(r100, new ArrayList(r101));
    }
}
