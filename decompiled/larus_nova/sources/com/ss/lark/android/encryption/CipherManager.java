package com.ss.lark.android.encryption;

import android.app.Activity;
import android.app.Application;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.supervisor.token.Token;
import com.ss.android.lark.appcontext.applifecycle.AppLifecycle;
import com.ss.android.lark.featuregating.FeatureGatingModule;
import com.ss.android.lark.log.Log;
import com.ss.lark.android.encryption.exception.CipherException;
import com.ss.lark.android.encryption.exception.DecryptException;
import com.ss.lark.android.encryption.exception.EncryptException;
import com.ss.lark.android.encryption.ui.CipherErrorTipsActivity;
import com.ss.lark.android.encryption.utils.PreCheckUtilKt;
import f06.b;
import f06.d;
import ikc.f;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public final class CipherManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f456788a = 0;

    static {
    }

    @JvmStatic
    public static final int d() {
        return FileCipherApiProxy.f456789a.o1();
    }

    @JvmStatic
    public static final void h() {
        if (FeatureGatingModule.getFeatureGatingService().isEnable("security.crypto.track.enabled") == false) goto L6;
        Log.i("ScsFileLock", "reportCipherInterceptEvent");
        f.f490295a.f490294c.sendEvent("scs_mobile_file_encrytion_status");
        return;
    }

    public static String a(File r100) throws DecryptException {
        if (r100 != null) goto L6;
        return "";
    L6:
        if (r100.exists() == false) goto L19;
        if (FileCipherChecker.a(r100) == false) goto L19;
        Pair<Integer, String> r101 = FileCipherApiProxy.f456789a.m3(r100);
        Integer r102 = (Integer) r101.first;
        String r103 = (String) r101.second;
        if (r102 != null) goto L13;
    L16:
        Intrinsics.checkNotNull(r102);
        i(r102.intValue());
        throw new DecryptException(r102.intValue());
    L13:
        if (r102.intValue() != 0) goto L16;
        Intrinsics.checkNotNull(r103);
        return r103;
    L19:
        return r100.getPath();
    }

    @JvmStatic
    public static final void c(File r100) throws EncryptException {
        Intrinsics.checkNotNullParameter(r100, "file");
        if (r100.exists() == false) goto L10;
        int r101 = FileCipherApiProxy.f456789a.Q9(r100);
        if (r101 != 0) goto L8;
        return;
    L8:
        i(r101);
        throw new EncryptException(r101);
    }

    @JvmStatic
    public static final long f(String r110) {
        Intrinsics.checkNotNullParameter(r110, "filePath");
        CipherManager$getFileSize$1 r100 = CipherManager$getFileSize$1.INSTANCE;
        Lazy r101 = PreCheckUtilKt.f456819a;
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Intrinsics.checkNotNullParameter(r100, "v1Decrypt");
        PolarisFileWrapper r102 = new PolarisFileWrapper(r110);
        long r103 = r102.length();
        if (r103 > 0) goto L5;
        Log.i("ScsFileLock", "getFileSize: return 0");
        return 0;
    L5:
        Intrinsics.checkNotNullParameter(r110, "filePath");
        Map<String, byte[]> r104 = PreCheckUtilKt.c(r110);
        byte r105 = 1;
        if (r104 != null) goto L8;
    L11:
        boolean r111 = true;
    L13:
        if (r111 == false) goto L16;
    L26:
        r105 = -1;
    L27:
        if (r105 != (-1)) goto L29;
        Log.i("ScsFileLock", "getFileSize: unencrypted, return original size");
        return r103;
    L29:
        if (r105 == 0) goto L36;
        Log.i("ScsFileLock", "getFileSize: v2, return original file size - 96");
        return r103 - ((long) 96);
    L36:
        File r112 = r100.invoke(r102);     // Catch: Exception -> L32
        Log.i("ScsFileLock", "getFileSize: v1, return decrypt file size");     // Catch: Exception -> L32
        r103 = r112.length();     // Catch: Exception -> L32
    L33:
        Log.i("ScsFileLock", "getFileSize: encrypt but version not match, return original file size");
        return RangesKt.coerceAtLeast(r103, 0);
    L32:
        Log.i("ScsFileLock", "getFileSize: v1, decryptFile error: return original size");
        goto L33
    L16:
        if (PreCheckUtilKt.a(r110, r104) == false) goto L26;
        byte[] r113 = r104.get("VERSION");
        if (r113 == null) goto L26;
        byte r114 = r113[0];
        if (r114 != 0) goto L24;
        r105 = 0;
        goto L27
    L24:
        if (r114 != 1) goto L26;
    L8:
        if (r104.isEmpty() == true) goto L11;
        r111 = false;
        goto L13
    }

    @JvmStatic
    public static final String g(String r100) throws CipherException {
        Intrinsics.checkNotNullParameter(r100, "decryptedPath");
        Pair<Integer, String> r101 = FileCipherApiProxy.f456789a.Ec(r100);
        Integer r102 = (Integer) r101.first;
        String r103 = (String) r101.second;
        if (r102 != null) goto L5;
    L7:
        Intrinsics.checkNotNull(r102);
        i(r102.intValue());
        throw new CipherException(r102.intValue());
    L5:
        if (r102.intValue() != 0) goto L7;
        return r103;
    }

    public static void i(int r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L9
        r101.put("error_code", r100);     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter(r101, "jsonObject");     // Catch: Exception -> L9
        Log.i("ScsFileLock", "reportCipherError");     // Catch: Exception -> L6
        f.f490295a.f490294c.sendEvent("disk_file_cipher_error");     // Catch: Exception -> L6
    L12:
        return;
    L6:
        e = move-exception;
        Log.e("ScsFileLock", e.getMessage());     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.i("ScsFileLock", "reportError: " + e);
    }

    public static void j(DecryptException r100) {
        Activity r101 = AppLifecycle.a.f408803a.f();
        if (r101 == null) goto L9;
        int r102 = r100.getErrorCode();
        int r103 = CipherErrorTipsActivity.f456805c;
        Intent r104 = new Intent(r101, CipherErrorTipsActivity.class);
        r104.putExtra("cipher_error", r102);
        if ((r101 instanceof Application) == false) goto L7;
        r104.addFlags(268435456);
    L7:
        r101.startActivity(r104);
        r101.overridePendingTransition(0, 0);
        return;
    }

    public static Uri b(Context r210, Uri r211) throws DecryptException {
        f.f490295a.f490292a.c();
        if (r210 == null) goto L41;
        ContentResolver r100 = r210.getContentResolver();
        ArrayList r110 = new ArrayList();
        Object[] r111 = {r211, "r"};
        b r112 = new b();
        g06.a r101 = ApiHookConfig.f245611b.get(240020);
        if (r101 == null) goto L7;
        f06.a[] r102 = r101.f479473i;
    L8:
        f06.a[] r103 = r102;
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L17;
        f06.a r106 = r103[r105];
        int r113 = r105;
        int r212 = r104;
        f06.a[] r213 = r103;
        d r107 = r106.preInvoke(240020, "android/content/ContentResolver", "openFileDescriptor", r100, r111, "android.os.ParcelFileDescriptor", r112);     // Catch: Exception -> L52
        if (r107.f474982a == true) goto L14;
        r110.add(r106);     // Catch: Exception -> L52
        goto L16
    L14:
        Throwable r114 = null;
    L19:
        if (r107.f474982a == false) goto L21;
        ParcelFileDescriptor r108 = (ParcelFileDescriptor) r107.f474983b;
    L22:
        if (r108 == null) goto L41;
        r108.close();
        Cursor r109 = sf7.a.f541727a.query(r210.getContentResolver(), r211, null, null, null, null, null, new Token("LARK-PSDA-security_judge_virtual_file"));
        if (r109 == null) goto L41;
        Cursor r115 = r109;
        Cursor r116 = r115;     // Catch: Throwable -> L35
        if (r116.moveToFirst() == true) goto L29;
    L33:
        Unit r117 = Unit.INSTANCE;     // Catch: Throwable -> L35
        CloseableKt.closeFinally(r115, r114);
        goto L41
    L29:
        if (r116.getLong(r116.getColumnIndex("_size")) > 0) goto L33;
        Log.i("ScsFileLock", "uri is virtual file, skip decrypt.");     // Catch: Throwable -> L35
        CloseableKt.closeFinally(r115, r114);
        return r211;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r115, th);
        throw th;
    L21:
        r108 = ContentResolverWrapper.openFileDescriptor(r100, r211, "r");
    L16:
        r105 = r113 + 1;
        r104 = r212;
        r103 = r213;
        goto L10
    L17:
        r114 = null;
        r107 = new d(false, null);
        goto L19
    L7:
        r102 = ApiHookConfig.f245613d;
    L41:
        Pair<Integer, String> r118 = FileCipherApiProxy.f456789a.Gd(r210, r211);
        Integer r119 = (Integer) r118.first;
        String r120 = (String) r118.second;
        if (r119 != null) goto L44;
    L50:
        Intrinsics.checkNotNull(r119);
        i(r119.intValue());
        throw new DecryptException(r119.intValue());
    L44:
        if (r119.intValue() != 0) goto L50;
        if (Intrinsics.areEqual(r120, r211.toString()) == false) goto L49;
        return r211;
    L49:
        return Uri.fromFile(new PolarisFileWrapper(r120));
    }

    @JvmStatic
    public static final PolarisFileWrapper e(File r100, boolean r101) throws DecryptException {
        return new PolarisFileWrapper(a(r100));
    L4:
        e = move-exception;
        if (r101 == false) goto L7;
        j(e);
    L7:
        throw e;
    }
}
