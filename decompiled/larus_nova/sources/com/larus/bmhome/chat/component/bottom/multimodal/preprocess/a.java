package com.larus.bmhome.chat.component.bottom.multimodal.preprocess;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Matrix;
import android.graphics.Movie;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bmhome.utils.ImFileUtil;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.z0;
import com.ss.android.downloadlib.constants.MimeType;
import ic8.m0;
import ic8.n0;
import java.io.File;
import java.io.FileDescriptor;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import v19.m5;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends e {

    /* JADX INFO: renamed from: com.larus.bmhome.chat.component.bottom.multimodal.preprocess.a$a, reason: collision with other inner class name */
    public static final class C4038a {
    }

    static {
    }

    public a() {
    }

    public static Bitmap k(Bitmap r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return r100;
    L5:
        ColorSpace r101 = r100.getColorSpace();
        ColorSpace r102 = ColorSpace.get(ColorSpace.Named.SRGB);
        if (r101 != null) goto L8;
    L12:
        return r100;
    L8:
        if (Intrinsics.areEqual(r101, r102) == true) goto L12;
        Bitmap r103 = Bitmap.createBitmap(r100.getWidth(), r100.getHeight(), z0.b(r100.getConfig()), r100.hasAlpha(), r102);
        Canvas r104 = new Canvas(r103);
        Paint r105 = new Paint();
        r105.setAntiAlias(true);
        r104.drawBitmap(r100, 0.0f, 0.0f, r105);
        return r103;
    }

    public final int m(FileDescriptor r100) {
        ExifInterface r101 = new ExifInterface(r100);     // Catch: Throwable -> L5
        this.f299943c = r101;     // Catch: Throwable -> L5
        return r101.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
    L5:
        th = move-exception;
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[getImgOrientation] readImgDegree err: " + th);
        return 1;
    }

    public static ParcelFileDescriptor j(ContentResolver r210, Uri r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r211, "r"};
        f06.b r110 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240020);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r104 = r111.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r111[r105];
        int r112 = r105;
        int r113 = r104;
        f06.a[] r114 = r111;
        f06.d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r210, r101, "android.os.ParcelFileDescriptor", r110);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (ParcelFileDescriptor) r107.f474983b;
    L21:
        return ContentResolverWrapper.openFileDescriptor(r210, r211, "r");
    L14:
        r105 = r112 + 1;
        r104 = r113;
        r111 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public final boolean o(Bitmap r100, Bitmap.CompressFormat r101, int r102, String r110) {
        boolean r103 = true;
        boolean r104 = false;
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L18
        e.b(r110);     // Catch: Throwable -> L18
        PolarisFileOutputStreamWrapper r106 = new PolarisFileOutputStreamWrapper(r110);     // Catch: Throwable -> L18
        boolean r107 = g(r101);     // Catch: Throwable -> L16
        int r108 = i.b(r101, r102, r107);     // Catch: Throwable -> L16
        if (r107 == false) goto L7;
        int r109 = com.larus.image.loader.v.f350991a;     // Catch: Throwable -> L16
        boolean r111 = com.larus.image.loader.v.a(r100, r108, r106, f().g());     // Catch: Throwable -> L16
    L8:
        if (r111 == true) goto L10;
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[writeCompressedBitmap] compress failed, outPath:".concat(r110));     // Catch: Throwable -> L16
        boolean r112 = true;
    L39:
        Object r113 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L14
    L21:
        Throwable r114 = Result.m9452exceptionOrNullimpl(r113);
        if (r114 == null) goto L24;
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[writeCompressedBitmap] failed, outPath:" + r110 + ", err:" + r114);
    L25:
        if (r106 == null) goto L30;
        Intrinsics.checkNotNullParameter(r106, "<this>");
        r106.close();     // Catch: Throwable -> L29
    L30:
        if (r103 == false) goto L32;
        m5.b(r110);
    L32:
        Boolean r115 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r113) == false) goto L36;
        r113 = r115;
    L36:
        return ((Boolean) r113).booleanValue();
    L24:
        r103 = r112;
    L14:
        Throwable th10 = th;
        r104 = r112;
    L20:
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        r112 = r104;
        goto L21
    L10:
        r106.flush();     // Catch: Throwable -> L16
        r112 = false;
        r104 = true;
        goto L39
    L7:
        r111 = r100.compress(r101, r108, r106);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        th10 = th;
    L18:
        th = move-exception;
        th10 = th;
        r106 = null;
        goto L20
    }

    public final n0 l(Uri r210, boolean r310, ns8.a r311, String r312, ns8.b r313) {
        Intrinsics.checkNotNullParameter(r210, "uri");
        FLogger r100 = FLogger.f375446a;
        r100.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] for uri: " + r210);
        m0 r101 = new m0(r210.toString(), null, 0, null, null, null, null, 16382);
        ImFileUtil.f314899a.getClass();
        if (ImFileUtil.w(r210) == true) goto L6;
        r100.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] not image type abort for uri: " + r210);
        return new n0(r101, ProcessFileResultCode.PREPARE_TYPE_NO_MATCH);
    L6:
        String r110 = null;
        this.f299943c = null;
        ParcelFileDescriptor r111 = j((ContentResolver) this.f299942b.getValue(), r210);     // Catch: Throwable -> L9
    L11:
        if (r111 == null) goto L13;
        FileDescriptor r112 = r111.getFileDescriptor();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("fileDescriptor:");
        boolean r113 = false;
        if (r112 == null) goto L17;
        boolean r104 = true;
    L18:
        r103.append(r104);
        r102.i("SendResourcePreprocessManager_AlbumImgProcessor", r103.toString());
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L21
        Intrinsics.checkNotNull(r112);     // Catch: Throwable -> L21
        BitmapFactory.Options r106 = new BitmapFactory.Options();     // Catch: Throwable -> L21
        r106.inJustDecodeBounds = true;     // Catch: Throwable -> L21
        BitmapFactory.decodeFileDescriptor(r112, null, r106);     // Catch: Throwable -> L21
        Object r107 = Result.m9449constructorimpl(r106.outMimeType);     // Catch: Throwable -> L21
    L24:
        if (Result.m9455isFailureimpl(r107) == false) goto L26;
        r107 = null;
    L26:
        String r108 = (String) r107;
        if (r108 != null) goto L29;
        ImFileUtil.f314899a.getClass();
        r108 = ImFileUtil.i(r210);
    L29:
        String r109 = r108;
        r101.f489226d = r109;
        Regex r114 = j.f299948a;
        ImFileUtil.f314899a.getClass();
        r101.f489235m = j.a(ImFileUtil.f(r210).f489224b, r109);
        FLogger r115 = FLogger.f375446a;
        r115.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] imageType: " + r109);
        if (r313 != null) goto L32;
    L34:
        boolean r116 = false;
    L35:
        if (r116 == false) goto L37;
    L40:
        boolean r117 = true;
    L41:
        if (r109 != null) goto L43;
    L45:
        boolean r118 = false;
    L47:
        if (r118 == false) goto L120;
        if (r117 == true) goto L120;
        if (r311 == null) goto L57;
        Bitmap.CompressFormat r119 = r311.f520346d;
        if (r119 == null) goto L57;
        if (Intrinsics.areEqual(i.a(r119), "webp") == true) goto L56;
        r119 = null;
    L56:
        if (r119 == null) goto L57;
    L58:
        Intrinsics.checkNotNull(r112);
        PolarisFileInputStreamWrapper r120 = new PolarisFileInputStreamWrapper(r112);     // Catch: Throwable -> L80
        Movie r121 = Movie.decodeStream(r120);     // Catch: Throwable -> L78
        Bitmap r122 = Bitmap.createBitmap(r121.width(), r121.height(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L78
        Canvas r123 = new Canvas(r122);     // Catch: Throwable -> L78
        r121.draw(r123, 0.0f, 0.0f);     // Catch: Throwable -> L78
        r123.save();     // Catch: Throwable -> L78
        String r124 = e.a(this, i.a(r119), r313, null, 10);     // Catch: Throwable -> L78
        PolarisFileOutputStreamWrapper r125 = new PolarisFileOutputStreamWrapper(r124);     // Catch: Throwable -> L76
        boolean r126 = g(r119);     // Catch: Throwable -> L65
        int r127 = i.b(r119, 100, r126);     // Catch: Throwable -> L65
        if (r126 == false) goto L67;
        int r128 = com.larus.image.loader.v.f350991a;     // Catch: Throwable -> L65
        boolean r129 = com.larus.image.loader.v.a(r122, r127, r125, f().g());     // Catch: Throwable -> L65
    L68:
        if (r129 == false) goto L75;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        r120.close();     // Catch: Throwable -> L331
    L71:
        Intrinsics.checkNotNullParameter(r125, "<this>");
        r125.close();     // Catch: Throwable -> L332
    L94:
        Intrinsics.checkNotNullParameter(r111, "<this>");
        r111.close();     // Catch: Throwable -> L97
    L99:
        if (o0.d(r124) == false) goto L101;
        ProcessFileResultCode r130 = ProcessFileResultCode.PREPARE_GIF_PROCESS_SUCCESS;
    L102:
        r101.f489227e = r124;
        if (r310 == true) goto L105;
    L107:
        r101.f489228f = r110;
        return new n0(r101, r130);
    L105:
        if (o0.d(r124) == false) goto L107;
        ImFileUtil r131 = ImFileUtil.f314899a;
        PolarisFileWrapper r132 = new PolarisFileWrapper(r124);
        r131.getClass();
        r110 = ImFileUtil.g(r132);
        goto L107
    L101:
        r130 = ProcessFileResultCode.PREPARE_GIF_PROCESS_FAILED;
        goto L102
    L75:
        throw new IllegalStateException("encode gif first frame failed".toString());     // Catch: Throwable -> L65
    L67:
        r129 = r122.compress(r119, r127, r125);     // Catch: Throwable -> L65
    L65:
        th = th;
    L358:
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execForGif] execForGif failed, err:" + th);     // Catch: Throwable -> L109
        if (r120 == null) goto L90;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        r120.close();     // Catch: Throwable -> L89
    L90:
        if (r125 == null) goto L93;
        Intrinsics.checkNotNullParameter(r125, "<this>");
        r125.close();     // Catch: Throwable -> L333
    L93:
        m5.b(r124);
        r124 = null;
    L109:
        th = move-exception;
        if (r120 == null) goto L115;
        Intrinsics.checkNotNullParameter(r120, "<this>");
        r120.close();     // Catch: Throwable -> L114
    L115:
        if (r125 == null) goto L118;
        Intrinsics.checkNotNullParameter(r125, "<this>");
        r125.close();     // Catch: Throwable -> L334
    L118:
        m5.b(r124);
        throw th;
    L76:
        th = th;
    L83:
        r125 = null;
    L78:
        th = th;
    L82:
        r124 = null;
    L80:
        th = th;
        r120 = null;
    L57:
        r119 = Bitmap.CompressFormat.JPEG;
    L120:
        r115.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] imageMineType: " + r109);
        if (r109 == null) goto L125;
        boolean r133 = true;
        if (x.a(r109) != true) goto L126;
        boolean r134 = true;
    L127:
        if (r134 == false) goto L270;
        if (r313 != null) goto L130;
    L132:
        boolean r135 = false;
    L133:
        if (r135 == true) goto L270;
        Intrinsics.checkNotNullParameter(r109, "<this>");
        Locale r136 = Locale.ROOT;
        String r137 = r109.toLowerCase(r136);
        if (Intrinsics.areEqual(r137, "image/heif") == false) goto L137;
    L140:
        boolean r138 = true;
    L141:
        if (r138 == false) goto L143;
    L150:
        r109 = r109;
    L151:
        boolean r211 = false;
    L152:
        Intrinsics.checkNotNull(r112);
        if (r311 != null) goto L362;
    L157:
        int r139 = z2.f365865a.imageUploadOptConfig().f486799a;     // Catch: Throwable -> L238
    L158:
        int r212 = r139;
        if (r311 == null) goto L162;
        Integer r213 = r311.f520344b;     // Catch: Throwable -> L238
    L163:
        ParcelFileDescriptor r214 = r111;
        FileDescriptor r215 = r112;
        String r140 = r109;
        String r141 = "<this>";
        m0 r216 = r101;
        Pair<Bitmap, Boolean> r142 = n(r210, r112, r212, r213, r313);     // Catch: Throwable -> L236
        if (r142 == null) goto L176;
        Bitmap r143 = r142.getFirst();     // Catch: Throwable -> L236
        z2 r144 = z2.f365865a;     // Catch: Throwable -> L236
        if (r144.enableImageUploadConvertToSrgb() == false) goto L170;
        r115.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] tryFixImgDegreeForCompress convertToSrgb");     // Catch: Throwable -> L236
        Bitmap r145 = k(r143);     // Catch: Throwable -> L236
    L171:
        if (r211 == true) goto L173;
    L177:
        Intrinsics.checkNotNullParameter(r140, r141);     // Catch: Throwable -> L236
        String r146 = r140.toLowerCase(r136);     // Catch: Throwable -> L236
        if (Intrinsics.areEqual(r146, "image/png") == false) goto L180;
    L187:
        boolean r147 = true;
        boolean r148 = true;
    L188:
        if (r148 != r147) goto L190;
        boolean r149 = true;
    L191:
        if (r149 == true) goto L193;
    L195:
        boolean r150 = false;
    L196:
        if (r150 == false) goto L199;
        if (r311 == null) goto L201;
        Bitmap.CompressFormat r151 = r311.f520349g;     // Catch: Throwable -> L236
    L202:
        if (r151 != null) goto L204;
        r151 = Bitmap.CompressFormat.JPEG;     // Catch: Throwable -> L236
    L204:
        int r152 = r144.imageUploadOptConfig().f486800b;     // Catch: Throwable -> L236
        if (1 <= r152) goto L207;
    L209:
        boolean r153 = false;
    L210:
        if (r153 == true) goto L213;
        r152 = 100;
    L213:
        if (r150 == false) goto L219;
        if (r311 == null) goto L217;
        Integer r154 = r311.f520348f;     // Catch: Throwable -> L236
        if (r154 == null) goto L217;
    L222:
        if (r154 == null) goto L224;
        r152 = r154.intValue();     // Catch: Throwable -> L236
    L224:
        String r155 = i.a(r151);     // Catch: Throwable -> L236
        String r156 = e.a(this, r155, r313, ImFileUtil.f(r210).f489224b, 2);     // Catch: Throwable -> L236
        r115.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] outPath:".concat(r156));     // Catch: Throwable -> L236
        if (o(r145, r151, r152, r156) == false) goto L228;
    L234:
        Object r157 = Result.m9449constructorimpl(r156);     // Catch: Throwable -> L236
    L241:
        Throwable r158 = Result.m9452exceptionOrNullimpl(r157);
        if (r158 == null) goto L245;
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] err: " + r158);
    L245:
        if (Result.m9455isFailureimpl(r157) == false) goto L247;
        r157 = null;
    L247:
        String r159 = (String) r157;
        m0 r160 = r216;
    L248:
        r160.f489227e = r159;
        if (r159 == null) goto L269;
        FLogger.f375446a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] Compressed");
        PolarisFileWrapper r161 = new PolarisFileWrapper(r159);
        r160.f489225c = r161.length();
        if (r310 == false) goto L253;
        ImFileUtil.f314899a.getClass();
        r160.f489228f = ImFileUtil.g(r161);
    L253:
        if (r311 != null) goto L255;
    L257:
        if (r113 == false) goto L259;
        e.d(this.f299943c, r159);
    L259:
        ParcelFileDescriptor r162 = r214;
        Intrinsics.checkNotNullParameter(r162, r141);
        r162.close();     // Catch: Throwable -> L262
    L263:
        ImFileUtil r163 = ImFileUtil.f314899a;
        long r164 = r160.f489225c;
        r163.getClass();
        if (ImFileUtil.v(r164, true) == false) goto L266;
        ProcessFileResultCode r165 = ProcessFileResultCode.PREPARE_OVER_SIZE;
    L268:
        return new n0(r160, r165);
    L266:
        r165 = ProcessFileResultCode.PREPARE_COMPRESSED_SUCCESS;
        goto L268
    L255:
        if (r311.f520347e != true) goto L257;
        r113 = true;
        goto L257
    L269:
        r111 = r214;
    L271:
        Intrinsics.checkNotNull(r215);
        FileDescriptor r166 = r215;
        long r167 = e.c(r166, r210);
        r160.f489225c = r167;
        ImFileUtil.f314899a.getClass();
        if (ImFileUtil.v(r167, true) == false) goto L277;
        Intrinsics.checkNotNullParameter(r111, r141);
        r111.close();     // Catch: Throwable -> L335
    L276:
        return new n0(r160, ProcessFileResultCode.PREPARE_OVER_SIZE);
    L277:
        if (r313 != null) goto L279;
    L281:
        if (r113 == false) goto L318;
        FLogger.f375446a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] skip clone");
        if (r160.f489227e == null) goto L354;
        Intrinsics.checkNotNullParameter(r111, r141);
        r111.close();     // Catch: Throwable -> L336
    L287:
        return new n0(r160, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
    L354:
        String r168 = com.larus.utils.r.j(AppHost.f326268a.getApplication(), r210);     // Catch: Throwable -> L296
        if (r168 == null) goto L293;
        PolarisFileWrapper r169 = new PolarisFileWrapper(r168);     // Catch: Throwable -> L296
        if (r169.exists() == false) goto L293;
    L294:
        Object r170 = Result.m9449constructorimpl(r169);     // Catch: Throwable -> L296
    L298:
        Throwable r171 = Result.m9452exceptionOrNullimpl(r170);
        if (r171 == null) goto L302;
        FLogger.f375446a.w("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] get original file path failed: " + r171);
    L302:
        if (Result.m9455isFailureimpl(r170) == false) goto L304;
        r170 = null;
    L304:
        File r172 = (File) r170;
        if (r172 == null) goto L307;
        String r173 = r172.getAbsolutePath();
    L308:
        if (r173 == null) goto L318;
        r160.f489227e = r172.getAbsolutePath();
        if (r313.f520356f == true) goto L312;
        ImFileUtil.f314899a.getClass();
        String r174 = ImFileUtil.g(r172);
    L313:
        r160.f489228f = r174;
        Intrinsics.checkNotNullParameter(r111, r141);
        r111.close();     // Catch: Throwable -> L337
    L316:
        return new n0(r160, ProcessFileResultCode.PREPARE_CLONE_SUCCESS);
    L312:
        r174 = null;
        goto L313
    L307:
        r173 = null;
    L293:
        r169 = null;
    L296:
        th = move-exception;
        Result.Companion r175 = Result.Companion;
        r170 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L318:
        if (AppHost.f326268a.isPlugin() == true) goto L320;
        ImFileUtil.f314899a.getClass();
        Pair<String, String> r176 = e.h(this, r140, r166, false, null, r310, r313, ImFileUtil.f(r210).f489224b, r210, 12);
        r141 = r141;
    L321:
        r160.f489227e = r176.getFirst();
        r160.f489228f = r176.getSecond();
        FLogger.f375446a.i("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] tryCloneOriginalRes result: " + r176.getFirst());
        Intrinsics.checkNotNullParameter(r111, r141);
        r111.close();     // Catch: Throwable -> L324
    L326:
        if (o0.d(r176.getFirst()) == false) goto L328;
        ProcessFileResultCode r177 = ProcessFileResultCode.PREPARE_CLONE_SUCCESS;
    L330:
        return new n0(r160, r177);
    L328:
        r177 = ProcessFileResultCode.PREPARE_CLONE_FAILED;
        goto L330
    L320:
        r176 = i(r140, r210, false, null, r310, r313);
        goto L321
    L279:
        if (r313.f520355e != true) goto L281;
        r113 = true;
        goto L281
    L228:
        if (r144.enableImagePreprocessCacheFallback() == false) goto L233;
        r156 = SendResourcePreprocessManager.g(true, r155);     // Catch: Throwable -> L236
        x.b(r156);     // Catch: Throwable -> L236
        r115.w("SendResourcePreprocessManager_AlbumImgProcessor", "[tryCompress] retry compress to cache outPath:".concat(r156));     // Catch: Throwable -> L236
        if (o(r145, r151, r152, r156) == true) goto L234;
    L233:
        r156 = null;
    L217:
        if (r311 == null) goto L221;
        r154 = r311.f520345c;     // Catch: Throwable -> L236
    L221:
        r154 = null;
        goto L222
    L219:
        if (r311 == null) goto L221;
        r154 = r311.f520345c;     // Catch: Throwable -> L236
        goto L222
    L207:
        if (r152 >= 101) goto L209;
        r153 = true;
    L201:
        r151 = null;
        goto L202
    L199:
        if (r311 == null) goto L201;
        r151 = r311.f520346d;     // Catch: Throwable -> L236
        goto L202
    L193:
        if (r145.hasAlpha() == false) goto L195;
        r150 = true;
        goto L196
    L190:
        r149 = false;
        goto L191
    L180:
        if (Intrinsics.areEqual(r146, MimeType.WEBP) == true) goto L187;
        if (Intrinsics.areEqual(r146, "image/heif") == true) goto L187;
        if (Intrinsics.areEqual(r146, "image/heic") == true) goto L187;
        r147 = true;
        r148 = false;
        goto L188
    L173:
        if (Intrinsics.areEqual(r145, r143) == false) goto L177;
        if (r142.getSecond().booleanValue() == true) goto L177;
    L170:
        r145 = r143;
    L176:
        r160 = r216;
        r159 = null;
    L236:
        th = th;
    L240:
        Result.Companion r178 = Result.Companion;
        r157 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L238:
        th = th;
        r141 = "<this>";
        r216 = r101;
        r214 = r111;
        r215 = r112;
        r140 = r109;
        goto L240
    L162:
        r213 = null;
        goto L163
    L362:
        Integer r179 = r311.f520343a;     // Catch: Throwable -> L238
        if (r179 == null) goto L157;
        r139 = r179.intValue();     // Catch: Throwable -> L238
        goto L158
    L143:
        if (r111.getStatSize() <= 0) goto L150;
        if (r311 == null) goto L146;
        int r180 = r311.f520350h;
    L148:
        if (r180 <= r111.getStatSize()) goto L151;
        r211 = true;
        goto L152
    L146:
        r180 = 0;
        goto L148
    L137:
        if (Intrinsics.areEqual(r137, "image/heic") == true) goto L140;
        r138 = false;
        goto L141
    L130:
        if (r313.f520351a != r133) goto L132;
        r135 = true;
    L270:
        r141 = "<this>";
        r160 = r101;
        r215 = r112;
        r140 = r109;
    L126:
        r134 = false;
        goto L127
    L125:
        r133 = true;
        goto L126
    L43:
        if (Intrinsics.areEqual(r109.toLowerCase(), MimeType.GIF) == false) goto L45;
        r118 = true;
        goto L47
    L37:
        if (Intrinsics.areEqual(r312, "doc") == true) goto L40;
        r117 = false;
        goto L41
    L32:
        if (r313.f520354d != true) goto L34;
        r116 = true;
    L21:
        th = move-exception;
        Result.Companion r181 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L24
    L17:
        r104 = false;
        goto L18
    L13:
        return new n0(r101, ProcessFileResultCode.PREPARE_OPEN_FILE_ERROR);
    L9:
        th = move-exception;
        FLogger.f375446a.e("SendResourcePreprocessManager_AlbumImgProcessor", "[execIncludeClone] openFileDescriptor failed: " + th);
        r111 = null;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [com.larus.common.apphost.AppHost$Companion] */
    /* JADX WARN: Type inference failed for: r6v38 */
    /* JADX WARN: Type inference failed for: r6v40 */
    /* JADX WARN: Type inference failed for: r6v46 */
    /* JADX WARN: Type inference failed for: r6v47 */
    /* JADX WARN: Type inference failed for: r6v48 */
    /* JADX WARN: Type inference failed for: r8v27, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v28 */
    /* JADX WARN: Type inference failed for: r8v29 */
    public final Pair<Bitmap, Boolean> n(Uri r110, FileDescriptor r111, int r210, Integer r211, ns8.b r212) {
        BitmapFactory.Options r100 = new BitmapFactory.Options();
        r100.inJustDecodeBounds = false;
        ?? r101 = AppHost.f326268a;
        Boolean r102 = null;
        ?? r103 = 0;
        if (r101.isPlugin() == true) goto L107;
        Bitmap r104 = BitmapFactory.decodeFileDescriptor(r111, null, r100);
    L25:
        Bitmap r105 = r104;
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder(PlayerResolution.SDKKEY.ORIGIN);
        if (r105 == null) goto L28;
        Integer r108 = Integer.valueOf(r105.getHeight());
    L29:
        r107.append(r108);
        r107.append(',');
        if (r105 == null) goto L32;
        Integer r109 = Integer.valueOf(r105.getWidth());
    L33:
        r107.append(r109);
        r107.append(",isRecycled ");
        if (r105 == null) goto L36;
        Boolean r112 = Boolean.valueOf(r105.isRecycled());
    L37:
        r107.append(r112);
        r107.append(')');
        r106.i("SendResourcePreprocessManager_AlbumImgProcessor", r107.toString());
        if (r105 != null) goto L40;
        return null;
    L40:
        Matrix r113 = new Matrix();
        Boolean r114 = f().a();
        Boolean r115 = Boolean.TRUE;
        float r116 = 270.0f;
        if (Intrinsics.areEqual(r114, r115) == false) goto L54;
        int r117 = m(r111);
        r106.i("SendResourcePreprocessManager_AlbumImgProcessor", "[getRotationFixedMatrix] orientation: " + r117);
        switch(r117) {
            case 2: goto L51;
            case 3: goto L50;
            case 4: goto L49;
            case 5: goto L48;
            case 6: goto L47;
            case 7: goto L46;
            case 8: goto L45;
            default: goto L44;
        };
    L44:
        boolean r118 = false;
    L53:
        r102 = Boolean.valueOf(r118);
    L72:
        if (r102 == null) goto L74;
        boolean r119 = r102.booleanValue();
    L76:
        if (Math.min(r105.getWidth(), r105.getHeight()) <= r210) goto L83;
        if (r210 <= 0) goto L83;
        if (r105.getWidth() >= r105.getHeight()) goto L81;
        float r120 = r210;
        int r121 = r105.getWidth();
    L82:
        float r122 = r120 / r121;
    L84:
        if (r211 != null) goto L86;
    L94:
        float r123 = f.a(r122, r212);
        if (Intrinsics.areEqual(f().a(), r115) == false) goto L104;
        if (r119 == true) goto L104;
        if (r123 != 1.0f) goto L100;
        boolean r124 = true;
    L101:
        if (r124 == false) goto L104;
        return TuplesKt.to(r105, Boolean.FALSE);
    L100:
        r124 = false;
    L104:
        r113.postScale(r123, r123);
        r106.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] resize scaleFactor: " + r123 + ",height: " + r105.getHeight() + ", width: " + r105.getWidth() + ", optShortSize: " + r210 + "optLongSize: " + r211);
        return TuplesKt.to(Bitmap.createBitmap(r105, 0, 0, r105.getWidth(), r105.getHeight(), r113, true), r115);
    L86:
        if (r211.intValue() <= 0) goto L94;
        if ((Math.max(r105.getWidth(), r105.getHeight()) * r122) <= r211.intValue()) goto L94;
        if (r105.getWidth() >= r105.getHeight()) goto L92;
        float r125 = r211.intValue();
        int r126 = r105.getHeight();
    L93:
        r122 = r125 / r126;
        goto L94
    L92:
        r125 = r211.intValue();
        r126 = r105.getWidth();
        goto L93
    L81:
        r120 = r210;
        r121 = r105.getHeight();
    L83:
        r122 = 1.0f;
        goto L84
    L74:
        r119 = false;
        goto L76
    L45:
        r113.postRotate(270.0f);
    L52:
        r118 = true;
        goto L53
    L46:
        r113.postScale(-1.0f, 1.0f);
        r113.postRotate(90.0f);
        goto L52
    L47:
        r113.postRotate(90.0f);
        goto L52
    L48:
        r113.postScale(-1.0f, 1.0f);
        r113.postRotate(270.0f);
        goto L52
    L49:
        r113.postScale(1.0f, -1.0f);
        goto L52
    L50:
        r113.postRotate(180.0f);
        goto L52
    L51:
        r113.postScale(-1.0f, 1.0f);
        goto L52
    L54:
        int r127 = m(r111);
        if (r127 != 3) goto L57;
        r116 = 180.0f;
    L63:
        Float r128 = Float.valueOf(r116);
        if (r128.floatValue() <= 0.0f) goto L66;
        boolean r129 = true;
    L67:
        if (r129 == true) goto L70;
        r128 = null;
    L70:
        if (r128 == null) goto L72;
        float r130 = r128.floatValue();
        r106.i("SendResourcePreprocessManager_AlbumImgProcessor", "[tryFixImgDegreeForCompress] tryFixImgDegree not to rotate degree:" + r130);
        r113.postRotate(r130);
        r102 = r115;
        goto L72
    L66:
        r129 = false;
        goto L67
    L57:
        if (r127 != 6) goto L59;
        r116 = 90.0f;
        goto L63
    L59:
        if (r127 == 8) goto L63;
        r116 = 0.0f;
        goto L63
    L36:
        r112 = null;
        goto L37
    L32:
        r109 = null;
        goto L33
    L28:
        r108 = null;
        goto L29
    L107:
        InputStream r131 = ContentResolverWrapper.openInputStream(r101.getApplication().getContentResolver(), r110);     // Catch: Throwable -> L13 Exception -> L15
        r104 = BitmapFactory.decodeStream(r131);     // Catch: Throwable -> L9 Exception -> L11
        InputStream r132 = r131;
        r101 = r131;
        if (r131 == null) goto L106;
    L20:
        r132.close();
        r101 = r132;
    L106:
    L11:
        e = e;
    L17:
        e.printStackTrace();     // Catch: Throwable -> L9
        r104 = null;
        r132 = r131;
        r101 = r131;
        if (r131 == null) goto L106;
    L9:
        th = th;
        r103 = r101;
    L21:
        if (r103 == 0) goto L23;
        r103.close();
    L23:
        throw th;
    L15:
        e = e;
        r131 = null;
    L13:
        th = th;
        goto L21
    }
}
