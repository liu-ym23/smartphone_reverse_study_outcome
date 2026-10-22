package com.bytedance.security.android.aopcheck;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import com.bytedance.android.service.manager.alliance.IAllianceService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J9\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nH\u0007¢\u0006\u0002\u0010\u0013J$\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000bH\u0007J.\u0010\u0014\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J\"\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J,\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J\"\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0011H\u0007J,\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007J,\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0007J6\u0010\u001c\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0007JC\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\"\u001a\u0004\u0018\u00010\u000f2\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010$JU\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010&J_\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u000e\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00110\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010#\u001a\u0004\u0018\u00010\u0019H\u0007¢\u0006\u0002\u0010'J,\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007JC\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0010\u0010\u0012\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\nH\u0007¢\u0006\u0002\u0010)¨\u0006*"}, d2 = {"Lcom/bytedance/security/android/aopcheck/ContentProviderWrapper;", "", "()V", "bulkInsert", "", "cp", "Landroid/content/ContentProvider;", "uri", "Landroid/net/Uri;", "values", "", "Landroid/content/ContentValues;", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Landroid/content/ContentValues;)I", "delete", "extras", "Landroid/os/Bundle;", "selection", "", "selectionArgs", "(Landroid/content/ContentProvider;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "insert", "openAssetFile", "Landroid/content/res/AssetFileDescriptor;", "mode", IAllianceService.LAUNCH_FROM_SIGNAL, "Landroid/os/CancellationSignal;", "openFile", "Landroid/os/ParcelFileDescriptor;", "openTypedAssetFile", "mimeTypeFilter", "opts", "query", "Landroid/database/Cursor;", "projection", "queryArgs", "cancellationSignal", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Landroid/os/Bundle;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "sortOrder", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "(Landroid/content/ContentProvider;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/database/Cursor;", "update", "(Landroid/content/ContentProvider;Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "aopcheck_release"}, k = 1, mv = {1, 1, 15})
public final class ContentProviderWrapper {
    public static final ContentProviderWrapper INSTANCE = null;

    private ContentProviderWrapper() {
    }

    static {
        INSTANCE = new ContentProviderWrapper();
    }

    @JvmStatic
    public static final int bulkInsert(ContentProvider r100, Uri r101, ContentValues[] r102) {
        if (r102 != null) goto L5;
        Intrinsics.throwNpe();
    L5:
        return r100.bulkInsert(r101, r102);
    }

    @JvmStatic
    public static final int delete(ContentProvider r100, Uri r101, Bundle r102) {
        return r100.delete(r101, r102);
    }

    @JvmStatic
    public static final Uri insert(ContentProvider r100, Uri r101, ContentValues r102) {
        return r100.insert(r101, r102);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentProvider r100, Uri r101, String r102) {
        return r100.openAssetFile(r101, r102);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentProvider r100, Uri r101, String r102) {
        return r100.openFile(r101, r102);
    }

    @JvmStatic
    public static final int delete(ContentProvider r100, Uri r101, String r102, String[] r103) {
        return r100.delete(r101, r102, r103);
    }

    @JvmStatic
    public static final Uri insert(ContentProvider r100, Uri r101, ContentValues r102, Bundle r103) {
        return r100.insert(r101, r102, r103);
    }

    @JvmStatic
    public static final AssetFileDescriptor openAssetFile(ContentProvider r100, Uri r101, String r102, CancellationSignal r103) {
        return r100.openAssetFile(r101, r102, r103);
    }

    @JvmStatic
    public static final ParcelFileDescriptor openFile(ContentProvider r100, Uri r101, String r102, CancellationSignal r103) {
        return r100.openFile(r101, r102, r103);
    }

    @JvmStatic
    public static final AssetFileDescriptor openTypedAssetFile(ContentProvider r100, Uri r101, String r102, Bundle r103) {
        return r100.openTypedAssetFile(r101, r102, r103);
    }

    @JvmStatic
    public static final int update(ContentProvider r100, Uri r101, ContentValues r102, Bundle r103) {
        return r100.update(r101, r102, r103);
    }

    @JvmStatic
    public static final AssetFileDescriptor openTypedAssetFile(ContentProvider r100, Uri r101, String r102, Bundle r103, CancellationSignal r104) {
        return r100.openTypedAssetFile(r101, r102, r103, r104);
    }

    @JvmStatic
    public static final Cursor query(ContentProvider r100, Uri r101, String[] r102, Bundle r103, CancellationSignal r104) {
        return r100.query(r101, r102, r103, r104);
    }

    @JvmStatic
    public static final int update(ContentProvider r100, Uri r101, ContentValues r102, String r103, String[] r104) {
        return r100.update(r101, r102, r103, r104);
    }

    @JvmStatic
    public static final Cursor query(ContentProvider r100, Uri r101, String[] r102, String r103, String[] r104, String r105) {
        return r100.query(r101, r102, r103, r104, r105);
    }

    @JvmStatic
    public static final Cursor query(ContentProvider r100, Uri r101, String[] r102, String r103, String[] r104, String r105, CancellationSignal r106) {
        return r100.query(r101, r102, r103, r104, r105, r106);
    }
}
