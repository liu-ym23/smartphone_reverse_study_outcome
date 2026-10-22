package com.larus.avlink.e.mock;

import androidx.room.util.TableInfo;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f291800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PolarisFileWrapper f291801b;

    public static final class a {
    }

    static {
    }

    public c() {
        Lazy r100 = LazyKt.lazy(new b());
        this.f291800a = r100;
        PolarisFileWrapper r101 = new PolarisFileWrapper((File) r100.getValue(), "Dora_Image");
        this.f291801b = r101;
        a((File) r100.getValue());
        a(r101);
        FLogger r102 = FLogger.f375446a;
        r102.i("CameraMockFileManager", "CameraMockFileManager initialized. BaseDir: " + ((File) r100.getValue()).getAbsolutePath());
        r102.i("CameraMockFileManager", "Dora_Image dir: " + r101.getAbsolutePath());
    }

    public static void a(File r100) {
        if (r100.exists() == true) goto L6;
        r100.mkdirs();
        return;
    }

    public final PolarisFileWrapper b(int r100, int r101, int r102) {
        PolarisFileWrapper r103 = new PolarisFileWrapper(this.f291801b, "mode_" + r100);
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, "dataSet_" + r101);
        PolarisFileWrapper r105 = new PolarisFileWrapper(r104, "pic_data");
        PolarisFileWrapper r106 = new PolarisFileWrapper(r104, "voice_data");
        a(r103);
        a(r104);
        a(r105);
        a(r106);
        PolarisFileWrapper r107 = new PolarisFileWrapper(new PolarisFileWrapper(r104, "pic_data"), TableInfo.Index.DEFAULT_PREFIX + r102);
        a(r107);
        return r107;
    }

    public final void c(int r110, int r111, int r112, List r113) {
        Intrinsics.checkNotNullParameter(r113, "sequence");
        PolarisFileWrapper r100 = new PolarisFileWrapper(b(r110, r111, r112), "sequence.json");     // Catch: Exception -> L5
        FilesKt.writeText$default(r100, h.e(new SequenceMetadata(Integer.valueOf(r110), Integer.valueOf(r111), Integer.valueOf(r112), new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US).format(new Date()), r113)), null, 2, null);     // Catch: Exception -> L5
        FLogger.f375446a.i("CameraMockFileManager", "✅ Sequence saved for imageUuid=" + r112 + ": " + r100.getAbsolutePath() + " (" + r113.size() + " callbacks)");     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("CameraMockFileManager", "saveSequenceToImageUuidDir failed for imageUuid=" + r112, e);
    }
}
