package com.bytedance.mira.plugin.core.func.soloader.impl;

import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ISoLoaderImpl {
    boolean callOnRegisterClassLoader(ClassLoader r100);

    boolean callOnSystemLoadOrLoadLibrary(String r100) throws Throwable;

    boolean checkPluginLinkedByPkg(String r100);

    String getLdLibraryPath(Object r100);

    List<String> getSoListByPkg(String r100);

    String getSoListStrByPkg(String r100);

    boolean init(SoLoader.Config r100) throws Throwable;

    boolean nativeLoad(String r100, ClassLoader r101, String r102) throws Throwable;
}
