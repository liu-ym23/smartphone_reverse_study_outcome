package com.ss.android.lark.officesdk.chameleon.assembly.doubao.common.deps;

import android.content.Context;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larksuite.framework.utils.m0;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.di.core.deps.StorageVolume;
import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.vfs.VFSPath;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.File;
import java.io.InputStream;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class w implements ntb.v {

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f433132a = null;

        static {
            int[] r100 = new int[StorageVolume.values().length];
            r100[StorageVolume.INTERNAL_FILES.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[StorageVolume.INTERNAL_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[StorageVolume.INTERNAL_ROOT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[StorageVolume.EXTERNAL_FILES.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[StorageVolume.EXTERNAL_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[StorageVolume.PUBLIC_ROOT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[StorageVolume.PUBLIC_PICTURES.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f433132a = r100;
        }
    }

    static {
    }

    public w() {
    }

    @Override // ntb.v
    public final boolean e() {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("web_chromium_debugger_type", "key");
        return LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).getBoolean("web_chromium_debugger_type", true);
    }

    @Override // ntb.v
    public final String getString() {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter("", "defaultValue");
        String r100 = LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).getString("cachedChromium", "");
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // ntb.v
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter("cachedChromium", "key");
        Intrinsics.checkNotNullParameter(r100, "value");
        LarkKVStorage.h(new com.ss.android.lark.storage.a("open_platform"), true).putString("cachedChromium", r100);
    }

    @Override // ntb.v
    public final VFSFile i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        return VFSFiles.f444819b.i(r100);
    L5:
        e = move-exception;
        Log.e("StorageDependency", "newFile", e);
        return null;
    }

    @Override // ntb.v
    public final InputStream k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "file");
        return VFSFiles.f444819b.k(r100);
    }

    @Override // ntb.v
    public final File l0(StorageVolume r110, String... r111) {
        Intrinsics.checkNotNullParameter(r110, ITTVideoEngineEventSource.KEY_VOLUME);
        Intrinsics.checkNotNullParameter("open_platform", "domain");
        Intrinsics.checkNotNullParameter(r111, "path");
    L16:
        e = move-exception;
        Log.e("StorageDependency", "getFile", e);
        return null;
    L4:
        switch(b.f433132a[r110.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L15;
        };     // Catch: Exception -> L16
    L6:
        com.ss.android.lark.storage.f r112 = com.ss.android.lark.storage.f.f440963j;     // Catch: Exception -> L16
    L13:
        String r113 = ArraysKt.joinToString$default(r111, HTTP.URL_DEFAULT, null, null, 0, null, null, 62, null);     // Catch: Exception -> L16
        VFSPath r114 = LarkFileStorage.b().b(r112, new com.ss.android.lark.storage.d(new com.ss.android.lark.storage.a("open_platform"), r113));     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r114, "<this>");     // Catch: Exception -> L16
        VFSFiles.f444819b.getClass();     // Catch: Exception -> L16
        return VFSFiles.a(r114).r(r114, false);
    L7:
        r112 = com.ss.android.lark.storage.f.f440962i;     // Catch: Exception -> L16
        goto L13
    L8:
        r112 = com.ss.android.lark.storage.f.f440961h;     // Catch: Exception -> L16
        goto L13
    L9:
        r112 = com.ss.android.lark.storage.f.f440960g;     // Catch: Exception -> L16
        goto L13
    L10:
        r112 = com.ss.android.lark.storage.f.f440959f;     // Catch: Exception -> L16
        goto L13
    L11:
        r112 = com.ss.android.lark.storage.f.f440958e;     // Catch: Exception -> L16
        goto L13
    L12:
        r112 = com.ss.android.lark.storage.f.f440957d;     // Catch: Exception -> L16
        goto L13
    L15:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L16
    }

    @Override // ntb.v
    public final PolarisFileWrapper A(Context r100, Uri r101, boolean r102) {
        return m0.b(r100, r101, r102);
    }
}
