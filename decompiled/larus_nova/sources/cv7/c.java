package cv7;

import dalvik.system.PathClassLoader;

/* JADX INFO: loaded from: classes23.dex */
public final class c extends PathClassLoader {
    public c(String r100, ClassLoader r101) {
        super(r100, r101);
    }

    @Override // java.lang.ClassLoader
    public final Class loadClass(String r100, boolean r101) throws ClassNotFoundException {
        if (r100.startsWith("java.") == true) goto L9;
        if (r100.startsWith("android.") == true) goto L9;
        return findClass(r100);
    L9:
        return super.loadClass(r100, r101);
    }
}
