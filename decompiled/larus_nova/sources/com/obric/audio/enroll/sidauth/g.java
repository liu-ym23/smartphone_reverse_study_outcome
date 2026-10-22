package com.obric.audio.enroll.sidauth;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.crypto.local.LocalDataCrypto;
import com.bytedance.crypto.utils.CryptoConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.sva.sdk.controller.Global;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.File;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f395552a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f395553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f395554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f395555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f395556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f395557e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f395558f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final File f395559g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final File f395560h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f395553a == r101.f395553a) goto L12;
            return false;
        L12:
            if (this.f395554b == r101.f395554b) goto L15;
            return false;
        L15:
            if (this.f395555c == r101.f395555c) goto L18;
            return false;
        L18:
            if (this.f395556d == r101.f395556d) goto L21;
            return false;
        L21:
            if (this.f395557e == r101.f395557e) goto L24;
            return false;
        L24:
            if (this.f395558f == r101.f395558f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f395559g, r101.f395559g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f395560h, r101.f395560h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f395553a;
            int r101 = ((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f395554b) * 31;
            long r102 = this.f395555c;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            if (this.f395556d == false) goto L5;
            int r104 = 1231;
        L6:
            int r105 = (((r103 + r104) * 31) + this.f395557e) * 31;
            long r106 = this.f395558f;
            return ((((r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31) + this.f395559g.hashCode()) * 31) + this.f395560h.hashCode();
        L5:
            r104 = 1237;
            goto L6
        }

        public final String toString() {
            return "PendingItem(wkrId=" + this.f395553a + ", audioBytes=" + this.f395554b + ", audioDurationMs=" + this.f395555c + ", isContinuousTalk=" + this.f395556d + ", asrTextLen=" + this.f395557e + ", createTsMs=" + this.f395558f + ", pcmFile=" + this.f395559g + ", metaFile=" + this.f395560h + ')';
        }

        public a(long r100, int r101, long r102, boolean r103, int r104, long r105, PolarisFileWrapper r110, File r111) {
            Intrinsics.checkNotNullParameter(r110, "pcmFile");
            Intrinsics.checkNotNullParameter(r111, "metaFile");
            this.f395553a = r100;
            this.f395554b = r101;
            this.f395555c = r102;
            this.f395556d = r103;
            this.f395557e = r104;
            this.f395558f = r105;
            this.f395559g = r110;
            this.f395560h = r111;
        }
    }

    static {
        f395552a = new g();
    }

    public g() {
    }

    public static PolarisFileWrapper c() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        Object r101 = Result.m9449constructorimpl(AppHost.f326268a.getApplication().getFilesDir());     // Catch: Throwable -> L4
    L6:
        Throwable r102 = Result.m9452exceptionOrNullimpl(r101);
        if (r102 == null) goto L10;
        FLogger.f375446a.e("SidAuthPendingStore", "get filesDir failed: " + r102.getMessage());
    L10:
        if (Result.m9455isFailureimpl(r101) == false) goto L12;
        r101 = null;
    L12:
        File r103 = (File) r101;
        if (r103 != null) goto L15;
        return null;
    L15:
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103, "sidauth_pending");
        if (r104.exists() == false) goto L18;
    L21:
        return r104;
    L18:
        if (r104.mkdirs() == true) goto L21;
        FLogger.f375446a.e("SidAuthPendingStore", "mkdirs failed: " + r104.getAbsolutePath());
        return null;
    L4:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r101 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static void a() {
        PolarisFileWrapper r100 = c();
        if (r100 != null) goto L38;
        return;
    L38:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(r100.listFiles());     // Catch: Throwable -> L7
    L10:
        if (Result.m9455isFailureimpl(r102) == false) goto L12;
        r102 = null;
    L12:
        File[] r103 = (File[]) r102;
        if (r103 != null) goto L15;
        return;
    L15:
        int r104 = r103.length;
        int r105 = 0;
        int r106 = 0;
    L16:
        if (r105 >= r104) goto L34;
        File r107 = r103[r105];
        if (r107.isFile() == false) goto L33;
        if (StringsKt.endsWith$default(r107.getName(), Global.SUFFIX_PCM_FILE, false, 2, null) == false) goto L22;
    L36:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L25
        Object r109 = Result.m9449constructorimpl(Boolean.valueOf(r107.delete()));     // Catch: Throwable -> L25
    L27:
        Boolean r110 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r109) == false) goto L31;
        r109 = r110;
    L31:
        if (((Boolean) r109).booleanValue() == false) goto L33;
        r106 = r106 + 1;
    L25:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L27
    L22:
        if (StringsKt.endsWith$default(r107.getName(), InvRouter.FLOW_SUFFIX, false, 2, null) == true) goto L36;
    L33:
        r105 = r105 + 1;
        goto L16
    L34:
        FLogger.f375446a.i("SidAuthPendingStore", "clearAll deletedFiles=" + r106);
        return;
    L7:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    public static void b(a r100) {
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L4
        Result.m9449constructorimpl(Boolean.valueOf(r100.f395559g.delete()));     // Catch: Throwable -> L4
    L13:
        Result.m9449constructorimpl(Boolean.valueOf(r100.f395560h.delete()));     // Catch: Throwable -> L8
        return;
    L8:
        th = move-exception;
        Result.Companion r102 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L4:
        th = move-exception;
        Result.Companion r103 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public final void delete(a r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        b(r100);
    }

    public static a d(long r110, byte[] r210, long r211, boolean r212, int r213) {
        Intrinsics.checkNotNullParameter(r210, "pcm");
        if (r110 != 0) goto L5;
    L105:
        FLogger.f375446a.i("SidAuthPendingStore", "persist skip: invalid wkrId=" + r110 + " or empty pcm");
        return null;
    L5:
        if (r210.length != 0) goto L7;
        boolean r100 = true;
    L8:
        if (r100 == true) goto L105;
        if (r210.length <= 320000) goto L13;
        FLogger r101 = FLogger.f375446a;
        StringBuilder r111 = new StringBuilder("persist truncate pcm wkrId=");
        r111.append(r110);
        r111.append(" originalBytes=");
        r111.append(r210.length);
        r111.append(" originalDurationMs=");
        long r112 = r211;
        r111.append(r112);
        r111.append(" -> maxBytes=320000 maxDurationMs=10000");
        r101.i("SidAuthPendingStore", r111.toString());
        byte[] r102 = ArraysKt.copyOfRange(r210, 0, 320000);
    L15:
        if (r210.length <= 320000) goto L17;
        long r113 = 10000;
    L18:
        PolarisFileWrapper r114 = c();
        if (r114 != null) goto L109;
        return null;
    L109:
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L23
        nia.a.f519383a.i(AppHost.f326268a.getApplication().getApplicationContext());     // Catch: Throwable -> L23
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L119:
        Object r104 = Result.m9449constructorimpl(LocalDataCrypto.getInstance().bytesXcrypt(1, CryptoConst.ALGORITHM_CHACHA20, "com.larus.nova", r102));     // Catch: Throwable -> L27
    L29:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r104);
        if (r115 == null) goto L33;
        FLogger.f375446a.e("SidAuthPendingStore", "encrypt failed wkrId=" + r110 + ": " + r115.getMessage());
    L33:
        if (Result.m9455isFailureimpl(r104) == false) goto L35;
        r104 = null;
    L35:
        byte[] r105 = (byte[]) r104;
        if (r105 != null) goto L39;
        return null;
    L39:
        if (r105.length != 0) goto L41;
        boolean r106 = true;
    L42:
        if (r106 == false) goto L45;
        FLogger.f375446a.e("SidAuthPendingStore", "encrypt returned empty wkrId=" + r110);
        return null;
    L45:
        long r107 = System.currentTimeMillis();
        StringBuilder r108 = new StringBuilder();
        r108.append(r107);
        r108.append('_');
        r108.append(r110);
        String r109 = r108.toString();
        PolarisFileWrapper r116 = new PolarisFileWrapper(r114, r109 + Global.SUFFIX_PCM_FILE);
        PolarisFileWrapper r117 = new PolarisFileWrapper(r114, r109 + InvRouter.FLOW_SUFFIX);
        FilesKt.writeBytes(r116, r105);     // Catch: Throwable -> L52
        JSONObject r118 = new JSONObject();     // Catch: Throwable -> L52
        r118.put("wkrId", r110);     // Catch: Throwable -> L52
        r118.put("audioFile", r116.getAbsolutePath());     // Catch: Throwable -> L52
        r118.put("audioBytes", r102.length);     // Catch: Throwable -> L52
        r118.put("audioDurationMs", r113);     // Catch: Throwable -> L52
        boolean r119 = r212;
        long r120 = r113;
        long r121 = r107;
        r118.put("isContinuousTalk", r119);     // Catch: Throwable -> L50
        r118.put("asrTextLen", r213);     // Catch: Throwable -> L50
        r118.put("createTsMs", r121);     // Catch: Throwable -> L50
        FilesKt.writeText$default(r117, r118.toString(), null, 2, null);     // Catch: Throwable -> L50
        Object r122 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L50
    L55:
        Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
        if (r123 == null) goto L59;
        FLogger.f375446a.e("SidAuthPendingStore", "write pending file failed wkrId=" + r110 + ": " + r123.getMessage());
    L59:
        Boolean r124 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r122) == false) goto L63;
        r122 = r124;
    L63:
        if (((Boolean) r122).booleanValue() == false) goto L115;
        FLogger r125 = FLogger.f375446a;
        StringBuilder r126 = new StringBuilder("persist success wkrId=");
        r126.append(r110);
        r126.append(" audioBytes=");
        r126.append(r102.length);
        r126.append(" audioDurationMs=");
        long r127 = r120;
        r126.append(r127);
        r126.append(" isContinuousTalk=");
        r126.append(r119);
        r126.append(" asrTextLen=");
        r126.append(r213);
        r126.append(" pcm=");
        r126.append(r116.getName());
        r125.i("SidAuthPendingStore", r126.toString());
        Object r128 = Result.m9449constructorimpl(r114.listFiles(new f()));     // Catch: Throwable -> L77
    L80:
        if (Result.m9455isFailureimpl(r128) == false) goto L82;
        Object r129 = null;
    L83:
        File[] r130 = (File[]) r129;
        if (r130 == null) goto L104;
        if (r130.length <= 20) goto L104;
        List r131 = ArraysKt.sortedWith(r130, new h());
        int r132 = r131.size() - 20;
        int r133 = 0;
    L90:
        if (r133 >= r132) goto L104;
        File r134 = (File) ListProtector.get(r131, r133);
        List r214 = r131;
        StringBuilder r135 = new StringBuilder();
        Intrinsics.checkNotNull(r134);
        r135.append(FilesKt.getNameWithoutExtension(r134));
        r135.append(Global.SUFFIX_PCM_FILE);
        PolarisFileWrapper r136 = new PolarisFileWrapper(r114, r135.toString());
        Result.Companion r137 = Result.Companion;     // Catch: Throwable -> L94
        Result.m9449constructorimpl(Boolean.valueOf(r134.delete()));     // Catch: Throwable -> L94
    L97:
        if (r136.exists() == false) goto L102;
        Result.m9449constructorimpl(Boolean.valueOf(r136.delete()));     // Catch: Throwable -> L100
    L100:
        th = move-exception;
        Result.Companion r138 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L102:
        FLogger.f375446a.w("SidAuthPendingStore", "enforceCapacity drop old pending name=" + FilesKt.getNameWithoutExtension(r134));
        r133 = r133 + 1;
        r131 = r214;
    L94:
        th = move-exception;
        Result.Companion r139 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L104:
        return new a(r110, r102.length, r127, r212, r213, r121, r116, r117);
    L82:
        r129 = r128;
    L77:
        th = move-exception;
        Result.Companion r140 = Result.Companion;
        r128 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L80
    L115:
        Result.m9449constructorimpl(Boolean.valueOf(r116.delete()));     // Catch: Throwable -> L66
    L123:
        Result.m9449constructorimpl(Boolean.valueOf(r117.delete()));     // Catch: Throwable -> L70
        return null;
    L70:
        th = move-exception;
        Result.Companion r141 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return null;
    L66:
        th = move-exception;
        Result.Companion r142 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L50:
        th = th;
    L54:
        Result.Companion r143 = Result.Companion;
        r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L52:
        th = th;
        r119 = r212;
        r120 = r113;
        r121 = r107;
        goto L54
    L41:
        r106 = false;
    L27:
        th = move-exception;
        Result.Companion r144 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L23:
        th = move-exception;
        Result.Companion r145 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L119
    L17:
        r113 = r112;
        goto L18
    L13:
        r112 = r211;
        r102 = r210;
        goto L15
    L7:
        r100 = false;
        goto L8
    }
}
