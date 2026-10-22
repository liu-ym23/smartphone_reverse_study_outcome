package io.opentelemetry.context;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes41.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f492701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f492702b = null;

    public g() {
    }

    static {
        f492701a = Logger.getLogger(g.class.getName());
        AtomicReference r100 = new AtomicReference();
        String r101 = System.getProperty("io.opentelemetry.context.contextStorageProvider", "");
        if ("default".equals(r101) == false) goto L5;
        c r102 = ThreadLocalContextStorage.INSTANCE;
    L29:
        if (Boolean.getBoolean("io.opentelemetry.context.enableStrictContext") == false) goto L31;
        r102 = new StrictContextStorage(r102);
    L31:
        Object r103 = e.f492699b;
        monitor-enter(r103);
        List<Function<? super c, ? extends c>> r104 = e.f492698a;     // Catch: Throwable -> L43
        monitor-exit(r103);     // Catch: Throwable -> L43
        Iterator r105 = ((ArrayList) r104).iterator();
    L37:
        if (r105.hasNext() == false) goto L39;
        r102 = (c) ((Function) r105.next()).apply(r102);
        goto L37
    L39:
        f492702b = r102;
        e.a();
        Throwable r106 = (Throwable) r100.get();
        if (r106 == null) goto L54;
        f492701a.log(Level.WARNING, "ContextStorageProvider initialized failed. Using default", r106);
        return;
    L54:
        return;
    L43:
        th = move-exception;
        throw th;
    L5:
        ArrayList r107 = new ArrayList();
        Iterator r108 = ServiceLoader.load(d.class).iterator();
    L7:
        if (r108.hasNext() == false) goto L13;
        d r109 = (d) r108.next();
        if (r109.getClass().getName().equals("io.opentelemetry.sdk.testing.context.SettableContextStorageProvider") == true) goto L10;
        r107.add(r109);
        goto L7
    L10:
        r102 = r109.get();
        goto L29
    L13:
        if (r107.isEmpty() == false) goto L16;
        r102 = ThreadLocalContextStorage.INSTANCE;
        goto L29
    L16:
        if (r101.isEmpty() == true) goto L18;
        Iterator r110 = r107.iterator();
    L23:
        if (r110.hasNext() == false) goto L27;
        d r111 = (d) r110.next();
        if (r111.getClass().getName().equals(r101) == false) goto L23;
        r102 = r111.get();
        goto L29
    L27:
        r100.set(new IllegalStateException("io.opentelemetry.context.ContextStorageProvider property set but no matching class could be found, requested: " + r101 + " but found providers: " + r107));
        r102 = ThreadLocalContextStorage.INSTANCE;
        goto L29
    L18:
        if (r107.size() != 1) goto L20;
        r102 = ((d) ListProtector.get(r107, 0)).get();
        goto L29
    L20:
        r100.set(new IllegalStateException("Found multiple ContextStorageProvider. Set the io.opentelemetry.context.ContextStorageProvider property to the fully qualified class name of the provider to use. Falling back to default ContextStorage. Found providers: " + r107));
        r102 = ThreadLocalContextStorage.INSTANCE;
        goto L29
    }
}
