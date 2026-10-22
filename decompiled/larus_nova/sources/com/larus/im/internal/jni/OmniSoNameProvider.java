package com.larus.im.internal.jni;

import com.larus.utils.logger.FLogger;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\tJ\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0006H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/larus/im/internal/jni/OmniSoNameProvider;", "", "<init>", "()V", "loadedLibraries", "", "", "getSoName", "loadFoundationLibrary", "", "loadIMLibraries", "loadAVLibraries", "loadOmniLibrary", "componentSoName", "loadLibraryIfNeeded", "soName", "omnisdk-foundation_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OmniSoNameProvider {
    public static final OmniSoNameProvider INSTANCE = null;
    private static final Set<String> loadedLibraries = null;

    private OmniSoNameProvider() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    public final String getSoName() {
        return "omnisdk";
    }

    public final void loadFoundationLibrary() {
        monitor-enter(this);
        INSTANCE.loadLibraryIfNeeded("omni_foundation");     // Catch: Throwable -> L6
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    static {
        INSTANCE = new OmniSoNameProvider();
        loadedLibraries = new LinkedHashSet();
    }

    public final void loadAVLibraries() {
        loadOmniLibrary("omnisdk_av");
    }

    public final void loadIMLibraries() {
        loadOmniLibrary("omnisdk");
    }

    @JvmStatic
    public static void INVOKESTATIC_com_larus_im_internal_jni_OmniSoNameProvider_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    private final void loadLibraryIfNeeded(String r100) {
        Set<String> r101 = loadedLibraries;
        if (r101.contains(r100) == false) goto L5;
        return;
    L5:
        INVOKESTATIC_com_larus_im_internal_jni_OmniSoNameProvider_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(r100);
        r101.add(r100);
    }

    private final void loadOmniLibrary(String r100) {
        monitor-enter(this);
        OmniSoNameProvider r101 = INSTANCE;     // Catch: Throwable -> L6
        r101.loadLibraryIfNeeded("omni_foundation");     // Catch: Throwable -> L6
        r101.loadLibraryIfNeeded(r100);     // Catch: Throwable -> L6
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
