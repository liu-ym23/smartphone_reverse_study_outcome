package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.app.Application;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.ss.android.lark.location.service.IPickLocationMap;
import com.ss.android.lark.location.service.f;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.utils.LarkContext;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingMapSaveHelper {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f435009m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a f435010a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<MmRecordingUILaunchMode> f435011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f435012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f435013d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f435014e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f435015f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile IPickLocationMap f435016g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public CoroutineScope f435017h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Double f435018i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Double f435019j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WeakReference<ViewGroup> f435020k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public b f435021l;

    public static final class a {
    }

    public interface b {
        void a();

        void b();
    }

    static {
    }

    public final void c() {
        CoroutineScope r100 = this.f435017h;     // Catch: Exception -> L7
        if (r100 == null) goto L5;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);     // Catch: Exception -> L7
    L5:
        this.f435017h = null;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        lvb.a.b(this.f435012c, "[cancelScope] e=" + e);
    }

    public final void f() {
        IPickLocationMap r100 = this.f435016g;
        Unit r101 = null;
        this.f435016g = null;
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L8
        if (r100 == null) goto L6;
        r100.onDestroy();     // Catch: Throwable -> L8
        r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
    L6:
        Result.m9449constructorimpl(r101);     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public static final int b(MmRecordingMapSaveHelper r100) {
        return ((Number) r100.f435014e.getValue()).intValue();
    }

    public final void d(String r100) {
        String r101 = this.f435012c;
        StringBuilder r102 = new StringBuilder("[cleanupAllResources] from=");
        r102.append(r100);
        r102.append(", pickLocationMap is null?=");
        boolean r103 = false;
        if (this.f435016g != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        lvb.a.e(r101, r102.toString());
        c();
        f();
        WeakReference<ViewGroup> r105 = this.f435020k;
        if (r105 == null) goto L9;
        ViewGroup r106 = r105.get();
    L10:
        String r107 = this.f435012c;
        StringBuilder r108 = new StringBuilder("[hideContainer] container is null?=");
        if (r106 != null) goto L13;
        r103 = true;
    L13:
        r108.append(r103);
        lvb.a.e(r107, r108.toString());
        if (r106 == null) goto L16;
        r106.removeAllViews();
    L16:
        if (r106 == null) goto L19;
        r106.setVisibility(8);
        return;
    L19:
        return;
    L9:
        r106 = null;
        goto L10
    L5:
        r104 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingMapSaveHelper(com.ss.android.lark.officesdk.minutes.service.foundation.userscope.a r100, Function0<? extends MmRecordingUILaunchMode> r101) {
        Intrinsics.checkNotNullParameter(r100, "mmUccApi");
        Intrinsics.checkNotNullParameter(r101, "uiLaunchModeProvider");
        this.f435010a = r100;
        this.f435011b = r101;
        this.f435012c = "MmRecordingMapSaveHelper";
        this.f435013d = 1000;
        this.f435014e = LazyKt.lazy(MmRecordingMapSaveHelper$bitmapWidth$2.INSTANCE);
        this.f435015f = LazyKt.lazy(MmRecordingMapSaveHelper$bitmapHeight$2.INSTANCE);
    }

    public static byte[] g(PolarisFileWrapper r100, String r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100, r101);
        if (r102.exists() == true) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == true) goto L12;
        r102 = null;
    L12:
        if (r102 != null) goto L14;
        return null;
    L14:
        return FilesKt.readBytes(r102);
    L5:
        if (r102.length() <= 0) goto L7;
        r103 = true;
        goto L9
    }

    public final void i(Double r110, Double r111, String r112) {
        if (r110 == null) goto L28;
        if (r111 == null) goto L28;
        Application r100 = LarkContext.getApplication();
        if (r100 != null) goto L10;
        lvb.a.b(this.f435012c, "[tryLoadMap] application context is null, from=".concat(r112));
        return;
    L10:
        WeakReference<ViewGroup> r101 = this.f435020k;
        if (r101 == null) goto L13;
        ViewGroup r102 = r101.get();
    L14:
        if (r102 != null) goto L18;
        lvb.a.h(this.f435012c, "[tryLoadMap] no available container, skip, from=".concat(r112));
        return;
    L18:
        if (Intrinsics.areEqual(this.f435018i, r110) == true) goto L20;
    L23:
        boolean r103 = true;
    L24:
        this.f435019j = r111;
        this.f435018i = r110;
        lvb.a.e(this.f435012c, "[tryLoadMap] start, from=" + r112 + ", locationChanged=" + r103);
        c();
        f();
        CoroutineScope r113 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.f435017h = r113;
        if (r113 == null) goto L30;
        BuildersKt.launch$default(r113, null, null, new MmRecordingMapSaveHelper$tryLoadMap$1(r103, r100, this, r112, r102, r110, r111, null), 3, null);
        return;
    L30:
        return;
    L20:
        if (Intrinsics.areEqual(this.f435019j, r111) == false) goto L23;
        r103 = false;
        goto L24
    L13:
        r102 = null;
    L28:
        lvb.a.b(this.f435012c, "[tryLoadMap] unexpected, from=".concat(r112));
    }

    public final void j(Context r110, PolarisFileWrapper r111, boolean r112) {
        if (r112 == false) goto L4;
        String r113 = "mm_recording_amap_style_night.zip";
    L5:
        InputStream r114 = r110.getAssets().open(r113);
        final ZipInputStream r100 = new ZipInputStream(r114);     // Catch: Throwable -> L51
        Iterator r101 = SequencesKt.generateSequence(new MmRecordingMapSaveHelper$unzipAmapStyle$1$1$1(r100)).iterator();     // Catch: Throwable -> L46
    L9:
        if (r101.hasNext() == false) goto L42;
        ZipEntry r102 = (ZipEntry) r101.next();     // Catch: Throwable -> L46
        if (r102.isDirectory() == true) goto L41;
        if (Intrinsics.areEqual(r102.getName(), "style.data") == false) goto L15;
    L16:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r111, r102.getName());     // Catch: Throwable -> L46
        PolarisFileWrapper r104 = new PolarisFileWrapper(r111, r102.getName() + DefaultDiskStorage.FileType.TEMP);     // Catch: Throwable -> L46
        if (r104.exists() == false) goto L19;
        r104.delete();     // Catch: Throwable -> L46
    L19:
        PolarisFileOutputStreamWrapper r105 = new PolarisFileOutputStreamWrapper(r104);     // Catch: Throwable -> L46
        ByteStreamsKt.copyTo$default(r100, r105, 0, 2, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r105, null);     // Catch: Throwable -> L46
        if (r104.length() <= 0) goto L24;
        if (r103.exists() == false) goto L31;
        if (r103.delete() == true) goto L31;
        r104.delete();     // Catch: Throwable -> L46
    L31:
        if (r104.renameTo(r103) == true) goto L33;
    L34:
        r104.delete();     // Catch: Throwable -> L46
        r103.delete();     // Catch: Throwable -> L46
        goto L41
    L33:
        if (r103.length() > 0) goto L41;
    L24:
        r104.delete();     // Catch: Throwable -> L46
        goto L9
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);     // Catch: Throwable -> L46
        throw th;     // Catch: Throwable -> L46
    L15:
        if (Intrinsics.areEqual(r102.getName(), "style_extra.data") == true) goto L16;
    L41:
        r100.closeEntry();     // Catch: Throwable -> L46
        goto L9
    L42:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L46
        CloseableKt.closeFinally(r100, null);     // Catch: Throwable -> L51
        CloseableKt.closeFinally(r114, null);
        lvb.a.e(this.f435012c, "[unzipAmapStyle] assetFile=" + r113 + ", dir=" + r111.getAbsolutePath());
        return;
    L46:
        th = move-exception;
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        throw th;     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        CloseableKt.closeFinally(r114, th);
        throw th;
    L4:
        r113 = "mm_recording_amap_style.zip";
        goto L5
    }

    public final Object h(IPickLocationMap r110, Context r111, boolean r112, Continuation<? super Unit> r210) {
        if ((r210 instanceof MmRecordingMapSaveHelper$setMapStyle$1) == false) goto L7;
        MmRecordingMapSaveHelper$setMapStyle$1 r100 = (MmRecordingMapSaveHelper$setMapStyle$1) r210;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$setMapStyle$1 r102 = r100;
        Object r103 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r106 = r102.J$0;
        boolean r107 = r102.Z$0;
        MmRecordingUILaunchMode r108 = (MmRecordingUILaunchMode) r102.L$0;
        ResultKt.throwOnFailure(r103);
    L29:
        long r113 = r106;
        MmRecordingUILaunchMode r114 = r108;
    L31:
        lvb.a.e(this.f435012c, "[setMapStyle] mode=" + r114 + ", isDarkMode=" + r107 + ", cost=" + (System.currentTimeMillis() - r113) + "ms");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        r113 = System.currentTimeMillis();
        r114 = this.f435011b.invoke();
        r110.d();
        if (r112 == false) goto L17;
        IPickLocationMap.DarkMode r109 = IPickLocationMap.DarkMode.DARK;
    L18:
        r110.j(r109);
        if (r114 != null) goto L21;
    L23:
        boolean r115 = false;
    L24:
        if (r115 == false) goto L30;
        CoroutineDispatcher r116 = Dispatchers.getIO();
        MmRecordingMapSaveHelper$setMapStyle$2 r117 = new MmRecordingMapSaveHelper$setMapStyle$2(this, r110, r111, r112, null);
        r102.L$0 = r114;
        r102.Z$0 = r112;
        r102.J$0 = r113;
        r102.label = 1;
        if (BuildersKt.withContext(r116, r117, r102) != r104) goto L28;
        return r104;
    L28:
        r107 = r112;
        r106 = r113;
        r108 = r114;
        goto L29
    L30:
        r110.g();
        r107 = r112;
        goto L31
    L21:
        if (r114.isFeishuUIStyle() != true) goto L23;
        r115 = true;
        goto L24
    L17:
        r109 = IPickLocationMap.DarkMode.LIGHT;
    L7:
        r100 = new MmRecordingMapSaveHelper$setMapStyle$1(this, r210);
        goto L8
    }

    public static final Object a(MmRecordingMapSaveHelper r110, Context r111, ViewGroup r210, double r211, double r212, boolean r213, Continuation r214) {
        boolean r112 = r213;
        r110.getClass();
        if ((r214 instanceof MmRecordingMapSaveHelper$generateSnapshotForMode$1) == false) goto L7;
        MmRecordingMapSaveHelper$generateSnapshotForMode$1 r100 = (MmRecordingMapSaveHelper$generateSnapshotForMode$1) r214;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$generateSnapshotForMode$1 r113 = r100;
        Object r102 = r113.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r113.label;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        boolean r104 = r113.Z$0;
        IPickLocationMap r105 = (IPickLocationMap) r113.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14 Exception -> L16
        r112 = r104;
        IPickLocationMap r115 = null;
    L72:
        boolean r106 = ((Boolean) r102).booleanValue();     // Catch: Throwable -> L38 Exception -> L40
        r110.f435016g = r115;
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L35
        r105.onDestroy();     // Catch: Throwable -> L35
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L35
    L37:
        boolean r116 = r106;
    L64:
        return Boxing.boxBoolean(r116);
    L35:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L40:
        e = e;
    L52:
        String r109 = r110.f435012c;     // Catch: Throwable -> L38
        StringBuilder r117 = new StringBuilder("[generateSnapshotForMode] failed, isDarkMode=");     // Catch: Throwable -> L38
        if (r112 == false) goto L55;
        boolean r118 = true;
    L56:
        r117.append(r118);     // Catch: Throwable -> L38
        r117.append(", error=");     // Catch: Throwable -> L38
        r117.append(e.getMessage());     // Catch: Throwable -> L38
        lvb.a.b(r109, r117.toString());     // Catch: Throwable -> L38
        r110.f435016g = r115;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L60
        r105.onDestroy();     // Catch: Throwable -> L60
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L60
    L62:
        r116 = false;
    L60:
        th = move-exception;
        Result.Companion r120 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L62
    L55:
        r118 = false;
    L38:
        th = move-exception;
        Throwable r121 = th;
    L66:
        r110.f435016g = r115;
        Result.Companion r122 = Result.Companion;     // Catch: Throwable -> L69
        r105.onDestroy();     // Catch: Throwable -> L69
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L69
        throw r121;
    L69:
        th = move-exception;
        Result.Companion r123 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        throw r121;
    L16:
        e = e;
        r112 = r104;
        r115 = null;
    L14:
        th = move-exception;
        r121 = th;
        r115 = null;
        goto L66
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r102);
        IPickLocationMap r124 = f.a().getPickLocationMap();
        r110.f435016g = r124;
        Intrinsics.checkNotNull(r124);     // Catch: Throwable -> L46 Exception -> L49
        if (r112 == false) goto L24;
        boolean r125 = true;
    L25:
        r113.L$0 = r124;     // Catch: Throwable -> L46 Exception -> L49
        r113.Z$0 = r112;     // Catch: Throwable -> L46 Exception -> L49
        r113.label = 1;     // Catch: Throwable -> L46 Exception -> L49
        IPickLocationMap r126 = r124;
        r115 = null;
        r102 = r110.e(r124, r111, r210, r125, r211, r212, r113);     // Catch: Throwable -> L42 Exception -> L44
        if (r102 == r114) goto L87;
        r105 = r126;
        goto L72
    L87:
        return r114;
    L44:
        e = e;
    L51:
        r105 = r126;
    L42:
        th = th;
    L48:
        r121 = th;
        r105 = r126;
        goto L66
    L24:
        r125 = false;
    L49:
        e = e;
        r126 = r124;
        r115 = null;
    L46:
        th = th;
        r126 = r124;
        r115 = null;
    L7:
        r100 = new MmRecordingMapSaveHelper$generateSnapshotForMode$1(r110, r214);
        goto L8
    }

    public final Object e(IPickLocationMap r210, Context r211, ViewGroup r212, boolean r213, double r214, double r215, Continuation<? super Boolean> r216) {
        boolean r100 = r213;
        if ((r216 instanceof MmRecordingMapSaveHelper$createAndCaptureMap$1) == false) goto L7;
        MmRecordingMapSaveHelper$createAndCaptureMap$1 r101 = (MmRecordingMapSaveHelper$createAndCaptureMap$1) r216;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        MmRecordingMapSaveHelper$createAndCaptureMap$1 r110 = r101;
        Object r103 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r110.label;
        if (r104 == 0) goto L16;
        if (r104 == 1) goto L15;
        if (r104 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L31:
        return r103;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        double r105 = r110.D$1;
        double r106 = r110.D$0;
        r100 = r110.Z$0;
        ViewGroup r107 = (ViewGroup) r110.L$2;
        Context r108 = (Context) r110.L$1;
        IPickLocationMap r109 = (IPickLocationMap) r110.L$0;
        ResultKt.throwOnFailure(r103);
        double r112 = r105;
        ViewGroup r113 = r107;
    L20:
        r113.removeAllViews();
        View r114 = r109.h(r108);
        if (r114 != null) goto L24;
        lvb.a.b(this.f435012c, "[createAndCaptureMap] mapView is null");
        return Boxing.boxBoolean(false);
    L24:
        LinearLayout.LayoutParams r115 = new LinearLayout.LayoutParams(-1, -1);
        r113.addView(r114, r115);
        View r116 = new View(r108);
        int r117 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.f434976a;
        r116.setBackgroundColor(ContextCompat.getColor(r108, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.helper.b.a(this.f435011b.invoke())));
        r113.addView(r116, r115);
        if (r100 == false) goto L27;
        String r118 = "mm_map_snapshot_dark.png";
    L28:
        String r119 = r118;
        r110.L$0 = null;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.label = 2;
        r103 = TimeoutKt.b(this.f435013d + 10000, new MmRecordingMapSaveHelper$captureAndSaveSnapshot$2(this, r119, r109, r106, r112, r108, null), r110);
        if (r103 != r111) goto L31;
        return r111;
    L27:
        r118 = "mm_map_snapshot_light.png";
        goto L28
    L16:
        ResultKt.throwOnFailure(r103);
        r110.L$0 = r210;
        r110.L$1 = r211;
        r113 = r212;
        r110.L$2 = r113;
        r110.Z$0 = r100;
        r110.D$0 = r214;
        r112 = r215;
        r110.D$1 = r112;
        r110.label = 1;
        if (h(r210, r211, r100, r110) != r111) goto L19;
        return r111;
    L19:
        r109 = r210;
        r106 = r214;
        r108 = r211;
    L7:
        r101 = new MmRecordingMapSaveHelper$createAndCaptureMap$1(this, r216);
        goto L8
    }
}
