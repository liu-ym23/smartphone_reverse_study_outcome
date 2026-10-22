package l4a;

import ae7.d;
import android.content.ContentUris;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f507355a = 0;

    static {
    }

    public static String a(Context r110, Uri r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Uri r100 = null;
        if (r111 == null) goto L107;
        String r101 = r111.getScheme();
        if (TextUtils.isEmpty(r101) == true) goto L90;
        if ("file".equals(r101) == true) goto L90;
        if ("http".equals(r101) == false) goto L14;
        return r111.toString();
    L14:
        if ("content".equals(r101) == true) goto L16;
    L18:
        int r102 = Build.VERSION.SDK_INT;
        if (DocumentsContract.isDocumentUri(r110, r111) == false) goto L61;
        if (TextUtils.equals("com.android.externalstorage.documents", r111.getAuthority()) == false) goto L26;
        String[] r103 = DocumentsContract.getDocumentId(r111).split(":");
        if ("primary".equalsIgnoreCase(r103[0]) == false) goto L61;
        return Environment.getExternalStorageDirectory() + HTTP.URL_DEFAULT + r103[1];
    L26:
        if (TextUtils.equals("com.android.providers.downloads.documents", r111.getAuthority()) == false) goto L49;
        String r104 = DocumentsContract.getDocumentId(r111);
        if (r104 == null) goto L33;
        if (r104.startsWith("raw:") == false) goto L33;
        return r104.substring(4);
    L33:
        if (r102 >= 26) goto L35;
        Uri r105 = ContentUris.withAppendedId(UriProtector.parse("content://downloads/public_downloads"), CastLongProtector.valueOf(r104).longValue());
    L36:
        String r106 = d.c(r110, r105, null, null);
        if (r106 != null) goto L101;
        String r107 = new PolarisFileWrapper(r110.getCacheDir(), "uri_tmp").getAbsolutePath();     // Catch: IOException -> L91
        ParcelFileDescriptor r112 = d.a(r110.getContentResolver(), r111);     // Catch: IOException -> L91
        if (r112 == null) goto L100;
        PolarisFileInputStreamWrapper r113 = new PolarisFileInputStreamWrapper(r112.getFileDescriptor());     // Catch: IOException -> L91
        PolarisFileOutputStreamWrapper r114 = new PolarisFileOutputStreamWrapper(r107);     // Catch: IOException -> L91
        byte[] r108 = new byte[4096];     // Catch: IOException -> L91
    L42:
        int r109 = r113.read(r108);     // Catch: IOException -> L91
        if (r109 == (-1)) goto L45;
        r114.write(r108, 0, r109);     // Catch: IOException -> L91
        goto L42
    L45:
        r113.close();     // Catch: IOException -> L91
        r114.close();     // Catch: IOException -> L91
        return new PolarisFileWrapper(r107).getAbsolutePath();
    L100:
        return null;
    L101:
        return r106;
    L35:
        r105 = r111;
        goto L36
    L49:
        if (TextUtils.equals("com.android.providers.media.documents", r111.getAuthority()) == false) goto L61;
        String[] r115 = DocumentsContract.getDocumentId(r111).split(":");
        String r116 = r115[0];
        if (TextUtils.equals("image", r116) == false) goto L54;
        r100 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    L102:
        return d.c(r110, r100, "_id=?", new String[]{r115[1]});
    L54:
        if (TextUtils.equals("video", r116) == false) goto L57;
        r100 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        goto L102
    L57:
        if (TextUtils.equals("audio", r116) == false) goto L102;
        r100 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    L61:
        if ("content".equals(r101) == false) goto L103;
        r110.getContentResolver();
        if ("com.google.android.apps.photos.contentprovider".equals(r111.getAuthority()) == false) goto L68;
        String r117 = (String) ListProtector.get(r111.getPathSegments(), 2);
        if (r117.startsWith("content") == true) goto L104;
    L78:
        String r118 = r111.getLastPathSegment();
        if (TextUtils.isEmpty(r118) == true) goto L84;
        if (r118.startsWith("/storage/emulated/") == false) goto L84;
        return r118;
    L84:
        if (TextUtils.isEmpty(r118) == true) goto L106;
        if (r118.contains(":") == false) goto L106;
        r118 = r118.split(":")[1];
    L106:
        return d.c(r110, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id= ?", new String[]{r118});
    L104:
        return d.c(r110, UriProtector.parse(r117), null, null);
    L68:
        if ("com.android.fileexplorer.myprovider".equals(r111.getAuthority()) == true) goto L72;
        if ("com.mi.android.globalFileexplorer.myprovider".equals(r111.getAuthority()) == false) goto L78;
    L72:
        if (TextUtils.isEmpty(r111.getPath()) == true) goto L78;
        ArrayList r119 = new ArrayList(r111.getPathSegments());
        ListProtector.remove(r119, 0);
        StringBuilder r120 = new StringBuilder(Environment.getExternalStorageDirectory().getAbsolutePath());
        Iterator r121 = r119.iterator();
    L75:
        if (r121.hasNext() == false) goto L105;
        String r122 = (String) r121.next();
        r120.append(HTTP.URL_DEFAULT);
        r120.append(r122);
        goto L75
    L105:
        return r120.toString();
    L103:
        return null;
    L16:
        if ("media".equals(r111.getAuthority()) == false) goto L18;
        return d.c(r110, r111, null, null);
    L90:
        return r111.getPath();
    L107:
        return null;
    }
}
