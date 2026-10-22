package j4a;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f497384a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int f497385a = 0;

        static {
        }
    }

    static {
    }

    public static ParcelFileDescriptor a(ContentResolver r210, Uri r211) {
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

    public static Long b(Context r110, Uri r111) {
        if (r111 != null) goto L6;
        return 0L;
    L6:
        if (DocumentsContract.isDocumentUri(r110, r111) == false) goto L38;
        if (TextUtils.equals("com.android.providers.media.documents", r111.getAuthority()) == false) goto L38;
        List r112 = StringsKt.split$default(DocumentsContract.getDocumentId(r111), new String[]{":"}, false, 0, 6, null);
        boolean r100 = false;
        String r101 = (String) ListProtector.get(r112, 0);
        if (TextUtils.equals("image", r101) == false) goto L17;
        Uri r102 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        int r103 = a.f497385a;
        if (Build.VERSION.SDK_INT < 29) goto L14;
        r100 = true;
    L14:
        if (r100 == false) goto L32;
        r102 = MediaStore.Images.Media.getContentUri("external_primary");
    L32:
        if (TextUtils.isEmpty((CharSequence) ListProtector.get(r112, 1)) == false) goto L34;
        r111 = null;
    L35:
        if (r111 != null) goto L47;
        return null;
    L47:
        if (r111 == null) goto L58;
        if (r110 == null) goto L63;
        ContentResolver r113 = r110.getContentResolver();     // Catch: Throwable -> L55
        if (r113 == null) goto L64;
        ParcelFileDescriptor r114 = a(r113, r111);     // Catch: Throwable -> L55
        if (r114 == null) goto L65;
        return Long.valueOf(r114.getStatSize());
    L65:
        return null;
    L64:
        return null;
    L55:
        th = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th, "AppFileUtils.getFileSize");
        FLogger.f375446a.e("AppFileUtils", "getFileSize error", th);
        return 0L;
    L63:
        return null;
    L58:
        return null;
    L34:
        Intrinsics.checkNotNull(r102);
        r111 = ContentUris.withAppendedId(r102, CastLongProtector.parseLong((String) ListProtector.get(r112, 1)));
        goto L35
    L17:
        if (TextUtils.equals("video", r101) == false) goto L24;
        r102 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        int r104 = a.f497385a;
        if (Build.VERSION.SDK_INT < 29) goto L21;
        r100 = true;
    L21:
        if (r100 == false) goto L32;
        r102 = MediaStore.Video.Media.getContentUri("external_primary");
        goto L32
    L24:
        if (TextUtils.equals("audio", r101) == false) goto L30;
        r102 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        int r105 = a.f497385a;
        if (Build.VERSION.SDK_INT < 29) goto L28;
        r100 = true;
    L28:
        if (r100 == false) goto L32;
        r102 = MediaStore.Audio.Media.getContentUri("external_primary");
        goto L32
    L30:
        r102 = null;
    L38:
        if (TextUtils.equals("media", r111.getAuthority()) == true) goto L47;
        if (r110 != null) goto L61;
        r111 = null;
        goto L47
    L61:
        return Long.valueOf(new PolarisFileWrapper(l4a.a.a(r110, r111)).length());
    L43:
        th = move-exception;
        com.larus.platform.service.g.f365738a.ensureNotReachHere(th, "AppFileUtils.getFileLength");
        FLogger.f375446a.e("AppFileUtils", "getFileLength error", th);
        return 0L;
    }
}
