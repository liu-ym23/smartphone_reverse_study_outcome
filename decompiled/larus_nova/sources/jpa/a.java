package jpa;

import com.relax.embedding.LLog;
import com.relax.embedding.module.NativeModule;
import com.relax.embedding.module.NativeModuleCallback;
import ipa.c;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final class a extends NativeModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f500007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f500008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Method f500009c;

    @Override // com.relax.embedding.module.NativeModule
    public final String getName() {
        return this.f500008b;
    }

    public a(Object r100, Method r101, String r102) {
        this.f500007a = r100;
        this.f500008b = r102;
        this.f500009c = r101;
    }

    @Override // com.relax.embedding.module.NativeModule
    public final void invoke(String r100, byte[] r101, NativeModuleCallback r102) {
        boolean r103 = c.f495326a;     // Catch: Exception -> L4
        this.f500009c.invoke(this.f500007a, new Object[]{r100, c.a(ByteBuffer.wrap(r101)), r102});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("Error invoking proxy method: " + r100);
        throw new RuntimeException("Error invoking proxy method", e);
    }

    @Override // com.relax.embedding.module.NativeModule
    public final void invokeNoCodec(String r100, Object r101, NativeModuleCallback r102) {
        this.f500009c.invoke(this.f500007a, new Object[]{r100, r101, r102});     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LLog.e("Error invoking proxy method: " + r100);
        throw new RuntimeException("Error invoking proxy method", e);
    }
}
