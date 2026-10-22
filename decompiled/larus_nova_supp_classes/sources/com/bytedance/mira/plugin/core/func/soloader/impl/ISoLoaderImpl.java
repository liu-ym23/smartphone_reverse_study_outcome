package com.bytedance.mira.plugin.core.func.soloader.impl;

import com.bytedance.mira.plugin.core.func.soloader.SoLoader;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public interface ISoLoaderImpl {
    boolean callOnRegisterClassLoader(ClassLoader r1);

    boolean callOnSystemLoadOrLoadLibrary(String r1) throws Throwable;

    boolean checkPluginLinkedByPkg(String r1);

    String getLdLibraryPath(Object r1);

    List<String> getSoListByPkg(String r1);

    String getSoListStrByPkg(String r1);

    boolean init(SoLoader.Config r1) throws Throwable;

    boolean nativeLoad(String r1, ClassLoader r2, String r3) throws Throwable;
}
