package nx5;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class a extends ObjectInputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f521060a;

    @Override // java.io.ObjectInputStream
    public final Class<?> resolveClass(ObjectStreamClass r100) throws ClassNotFoundException, IOException {
        if (r100 == null) goto L41;
        if (r100.getName() == null) goto L41;
        String r101 = r100.getName();
        if (((HashSet) this.f521060a).contains(r101) == true) goto L9;
        ClassLoader r102 = ClassLoader.getSystemClassLoader().getParent();
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == false) goto L44;
        Class<?> r105 = Class.forName(r101, true, r102);     // Catch: Throwable -> L25
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L47;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L25
        return r105;
    L47:
        return r105;
    L25:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L30;
        FastClassNotFoundHandler.b(r101);
    L30:
        if ((th instanceof PluginClassNotFoundException) == false) goto L32;
        throw th;
    L32:
        if ((th instanceof ClassNotFoundException) == true) goto L38;
        if ((th instanceof NoClassDefFoundError) == true) goto L38;
        throw th;
    L38:
        return MiraPluginFix.forName(r101);
    L44:
        Class<?> r106 = Class.forName(r101, true, r102);     // Catch: Throwable -> L16
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L46;
        FastClassNotFoundHandler.a(r101);     // Catch: Throwable -> L16
        return r106;
    L46:
        return r106;
    L16:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L20;
        FastClassNotFoundHandler.b(r101);
    L20:
        throw th;
    L9:
        return super.resolveClass(r100);
    L41:
        return super.resolveClass(r100);
    }

    public a(InputStream r100, Class<?>... r101) throws IOException {
        super(r100);
        this.f521060a = new HashSet();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L5;
        Class<?> r104 = r101[r103];
        Set<String> r105 = this.f521060a;
        HashSet r106 = (HashSet) r105;
        r106.add(r104.getName());
        r103 = r103 + 1;
        goto L3
    }
}
