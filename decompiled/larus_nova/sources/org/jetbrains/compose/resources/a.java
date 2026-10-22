package org.jetbrains.compose.resources;

import android.content.Context;
import android.content.res.AssetManager;
import com.bytedance.keva.KevaImpl;
import com.lynx.jsbridge.LynxResourceModule;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes42.dex */
@ExperimentalResourceApi
public final class a implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f525833a = null;

    static {
        f525833a = new a();
    }

    public a() {
    }

    @Override // org.jetbrains.compose.resources.t
    public final Object a(String r100) {
        if (StringsKt.startsWith$default(r100, KevaImpl.PrivateConstants.FILES_DIR_NAME, false, 2, null) == false) goto L5;
    L19:
        Context r101 = p.f525846a;
        if (r101 == null) goto L31;
        AssetManager r102 = r101.getAssets();
        Intrinsics.checkNotNullParameter(r100, "path");
        InputStream r103 = r102.open("composeResources/" + r100);
        Intrinsics.checkNotNull(r103);     // Catch: Throwable -> L25
        byte[] r104 = ByteStreamsKt.readBytes(r103);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r103, null);
    L24:
        return r104;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L31:
        throw new IllegalStateException("Make sure call org.jetbrains.compose.resources.initResourceContext to init compose resource context");
    L5:
        if (StringsKt.startsWith$default(r100, LynxResourceModule.FONT_TYPE, false, 2, null) == true) goto L19;
        Context r105 = p.f525846a;
        if (r105 == null) goto L18;
        InputStream r106 = r105.getAssets().open(r100);
        Intrinsics.checkNotNull(r106);     // Catch: Throwable -> L12
        r104 = ByteStreamsKt.readBytes(r106);     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r106, null);
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);
        throw th;
    L18:
        throw new IllegalStateException("Make sure call org.jetbrains.compose.resources.initResourceContext to init compose resource context");
    }

    @Override // org.jetbrains.compose.resources.t
    public final Object b(String r100, long r101, long r102) {
        Context r103 = p.f525846a;
        if (r103 == null) goto L14;
        AssetManager r104 = r103.getAssets();
        Intrinsics.checkNotNullParameter(r100, "path");
        InputStream r105 = r104.open("composeResources/" + r100);
        int r106 = (int) r102;
        byte[] r107 = new byte[r106];     // Catch: Throwable -> L8
        r105.skip(r101);     // Catch: Throwable -> L8
        r105.read(r107, 0, r106);     // Catch: Throwable -> L8
        CloseableKt.closeFinally(r105, null);
        return r107;
    L8:
        th = move-exception;
        throw th;     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L14:
        throw new IllegalStateException("Make sure call org.jetbrains.compose.resources.initResourceContext to init compose resource context");
    }
}
