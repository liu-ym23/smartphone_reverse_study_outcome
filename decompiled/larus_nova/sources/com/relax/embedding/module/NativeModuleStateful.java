package com.relax.embedding.module;

import ipa.c;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.HashMap;

/* JADX INFO: loaded from: classes34.dex */
public class NativeModuleStateful extends NativeModule {
    private static final Object lock = null;
    private static HashMap<String, Object> registry;
    private Class<?> statefulClazz;
    private Method statefulMethod;
    private String statefulMethodName;

    static {
        registry = new HashMap();
        lock = new Object();
    }

    @Override // com.relax.embedding.module.NativeModule
    public String getName() {
        return this.statefulMethodName;
    }

    public NativeModuleStateful(Class<?> r100, Method r101, String r102) throws NoSuchMethodException {
        this.statefulMethod = r101;
        this.statefulMethodName = r102;
        this.statefulClazz = r100;
    }

    @Override // com.relax.embedding.module.NativeModule
    public void invoke(String r100, byte[] r101, NativeModuleCallback r102) {
        boolean r103 = c.f495326a;     // Catch: Exception -> L7
        Object r104 = c.a(ByteBuffer.wrap(r101));     // Catch: Exception -> L7
        Object r105 = registry.get(this.statefulClazz.getCanonicalName());     // Catch: Exception -> L7
        if (r105 != null) goto L5;
        r105 = this.statefulClazz.newInstance();     // Catch: Exception -> L7
        registry.put(this.statefulClazz.getCanonicalName(), r105);     // Catch: Exception -> L7
    L5:
        this.statefulMethod.invoke(r105, new Object[]{r100, r104, r102});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error invoking static method", e);
    }

    @Override // com.relax.embedding.module.NativeModule
    public void invokeNoCodec(String r100, Object r101, NativeModuleCallback r102) {
        Object r103 = registry.get(this.statefulClazz.getCanonicalName());     // Catch: Exception -> L7
        if (r103 != null) goto L5;
        r103 = this.statefulClazz.newInstance();     // Catch: Exception -> L7
        registry.put(this.statefulClazz.getCanonicalName(), r103);     // Catch: Exception -> L7
    L5:
        this.statefulMethod.invoke(r103, new Object[]{r100, r101, r102});     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        throw new RuntimeException("Error invoking static method", e);
    }
}
