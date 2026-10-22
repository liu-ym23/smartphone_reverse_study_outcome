package com.facebook.common.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import f06.b;
import f06.c;
import f06.d;
import java.io.File;
import java.net.URL;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class UriUtil {
    public static final String DATA_SCHEME = "data";
    public static final String HTTPS_SCHEME = "https";
    public static final String HTTP_SCHEME = "http";
    private static final int ID_PATH_SEGMENTS = 1;
    public static final String LOCAL_ASSET_SCHEME = "asset";
    private static final Uri LOCAL_CONTACT_IMAGE_URI = null;
    public static final String LOCAL_CONTENT_SCHEME = "content";
    public static final String LOCAL_FILE_SCHEME = "file";
    public static final String LOCAL_RESOURCE_SCHEME = "res";
    private static final int NAME_PATH_SEGMENT_INDEX = 1;
    private static final int NAME_URI_PATH_SEGMENTS = 2;
    public static final String QUALIFIED_RESOURCE_SCHEME = "android.resource";
    private static final int RESOURCE_ID_SEGMENT_INDEX = 0;
    private static final int TYPE_PATH_SEGMENT_INDEX = 0;

    public UriUtil() {
    }

    static {
        LOCAL_CONTACT_IMAGE_URI = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "display_photo");
    }

    @Nullable
    public static String getSchemeOrNull(@Nullable Uri r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getScheme();
    }

    public static Uri getUriForFile(File r100) {
        return Uri.fromFile(r100);
    }

    public static Uri getUriForResourceId(int r100) {
        return new Uri.Builder().scheme("res").path(String.valueOf(r100)).build();
    }

    public static boolean isDataUri(@Nullable Uri r100) {
        return "data".equals(getSchemeOrNull(r100));
    }

    public static boolean isLocalAssetUri(@Nullable Uri r100) {
        return LOCAL_ASSET_SCHEME.equals(getSchemeOrNull(r100));
    }

    public static boolean isLocalCameraUri(Uri r100) {
        String r101 = r100.toString();
        if (r101.startsWith(MediaStore.Images.Media.EXTERNAL_CONTENT_URI.toString()) == false) goto L5;
    L8:
        return true;
    L5:
        if (r101.startsWith(MediaStore.Images.Media.INTERNAL_CONTENT_URI.toString()) == true) goto L8;
        return false;
    }

    public static boolean isLocalContactUri(Uri r100) {
        if (isLocalContentUri(r100) == true) goto L5;
    L9:
        return false;
    L5:
        if ("com.android.contacts".equals(r100.getAuthority()) == false) goto L9;
        if (r100.getPath().startsWith(LOCAL_CONTACT_IMAGE_URI.getPath()) == true) goto L9;
        return true;
    }

    public static boolean isLocalContentUri(@Nullable Uri r100) {
        return "content".equals(getSchemeOrNull(r100));
    }

    public static boolean isLocalFileUri(@Nullable Uri r100) {
        return "file".equals(getSchemeOrNull(r100));
    }

    public static boolean isLocalResourceUri(@Nullable Uri r100) {
        return "res".equals(getSchemeOrNull(r100));
    }

    public static boolean isNetworkUri(@Nullable Uri r100) {
        String r101 = getSchemeOrNull(r100);
        if ("https".equals(r101) == false) goto L5;
    L8:
        return true;
    L5:
        if ("http".equals(r101) == true) goto L8;
        return false;
    }

    public static boolean isQualifiedResourceUri(@Nullable Uri r100) {
        return QUALIFIED_RESOURCE_SCHEME.equals(getSchemeOrNull(r100));
    }

    public static Uri parseUriOrNull(@Nullable String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return Uri.parse(r100);
    }

    @Nullable
    public static URL uriToUrl(@Nullable Uri r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new URL(r100.toString());
    L7:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Nullable
    public static String getRealPathFromUri(ContentResolver r100, Uri r101) {
        Cursor r102 = null;
        String r103 = null;
        r103 = null;
        r103 = null;
        if (isLocalContentUri(r101) == false) goto L22;
        Cursor r104 = com_facebook_common_util_UriUtil_android_content_ContentResolver_query(r100, r101, null, null, null, null);     // Catch: Throwable -> L17
        if (r104 != null) goto L27;
    L15:
        if (r104 == null) goto L29;
        r104.close();
        return r103;
    L29:
        return r103;
    L27:
    L13:
        th = th;
        r102 = r104;
    L18:
        if (r102 == null) goto L20;
        r102.close();
    L20:
        throw th;
    L8:
        if (r104.moveToFirst() == false) goto L15;
        int r105 = r104.getColumnIndex("_data");     // Catch: Throwable -> L13
        if (r105 == (-1)) goto L15;
        r103 = r104.getString(r105);     // Catch: Throwable -> L13
    L17:
        th = th;
        goto L18
    L22:
        if (isLocalFileUri(r101) == true) goto L24;
        return null;
    L24:
        return r101.getPath();
    }

    public static int getResourceIdFromUri(Context r100, Uri r101) {
        List<String> r102 = r101.getPathSegments();
        if (r102.size() != 2) goto L9;
        String r103 = r101.getAuthority();
        if (TextUtils.isEmpty(r103) == false) goto L7;
        r103 = r100.getPackageName();
    L7:
        String r104 = r102.get(0);
        Integer r105 = Integer.valueOf(r100.getResources().getIdentifier(r102.get(1), r104, r103));
    L13:
        if (r105 == null) goto L21;
        if (r105.intValue() <= 0) goto L19;
        return r105.intValue();
    L19:
        throw new IllegalArgumentException("Failed to obtain resource id for: " + r101);
    L21:
        throw new IllegalArgumentException("Unrecognized Uri format: " + r101);
    L9:
        if (r102.size() == 1) goto L23;
    L12:
        r105 = null;
        goto L13
    L23:
        r105 = Integer.valueOf(r102.get(0));     // Catch: NumberFormatException -> L22
        goto L13
    }

    public static Uri getUriForQualifiedResource(String r100, int r101) {
        return new Uri.Builder().scheme(QUALIFIED_RESOURCE_SCHEME).authority(r100).path(String.valueOf(r101)).build();
    }

    private static Cursor com_facebook_common_util_UriUtil_android_content_ContentResolver_query(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        c r100 = new c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        b r116 = new b();
        d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
