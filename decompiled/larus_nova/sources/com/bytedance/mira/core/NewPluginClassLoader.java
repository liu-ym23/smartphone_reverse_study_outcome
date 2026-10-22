package com.bytedance.mira.core;

import android.os.Build;
import com.bytedance.mira.hook.delegate.MiraClassLoader;
import com.bytedance.mira.log.MiraLogger;
import com.bytedance.mira.util.FieldUtils;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class NewPluginClassLoader extends PluginClassLoader {
    private static final List<String> sPreLoader = null;

    static {
        ArrayList r100 = new ArrayList();
        sPreLoader = r100;
        r100.add("QIKU");
    }

    public ClassLoader getHostClassLoader() {
        return MiraClassLoader.getHostClassLoader();
    }

    @Override // com.bytedance.mira.core.PluginClassLoader
    public ClassLoader getInnerClassloader() {
        return getHostClassLoader();
    }

    @Override // com.bytedance.mira.core.PluginClassLoader
    public Class<?> findClassFromCurrent(String r100) throws ClassNotFoundException {
        return super.findClass(r100);
    }

    @Override // com.bytedance.mira.core.PluginClassLoader, java.lang.ClassLoader
    public Class<?> loadClass(String r100, boolean r101) throws ClassNotFoundException {
        String r102 = Build.MANUFACTURER;
        if (r102 == null) goto L12;
        if (sPreLoader.contains(r102.toUpperCase()) == false) goto L12;
        Class<?> r103 = findClass(r100);     // Catch: ClassNotFoundException -> L9
        if (r103 == null) goto L12;
        return r103;
    L9:
        e = move-exception;
        MiraLogger.e("PluginClassLoader", "UCK QIKU:error", e);
    L12:
        return super.loadClass(r100, r101);
    }

    public NewPluginClassLoader(String r100, String r101, String r102, ClassLoader r103) {
        super(r100, r101, r102, r103);
        FieldUtils.writeField(FieldUtils.readField(this, "pathList"), "definingContext", getHostClassLoader());     // Catch: IllegalAccessException -> L5
        MiraLogger.d("hook pathList definingContext success");     // Catch: IllegalAccessException -> L5
        return;
    L5:
        e = move-exception;
        MiraLogger.e("hook pathList definingContext fail", e);
    }
}
