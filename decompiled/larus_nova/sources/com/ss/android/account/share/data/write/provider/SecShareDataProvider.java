package com.ss.android.account.share.data.write.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.bytedance.common.utility.Logger;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.account.share.data.write.SecShareDataWriteManager;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007¢\u0006\u0004\b\u0016\u0010\u0017J\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016JM\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J;\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/ss/android/account/share/data/write/provider/SecShareDataProvider;", "Landroid/content/ContentProvider;", "Landroid/net/Uri;", "uri", "Landroid/content/ContentValues;", "values", "insert", "", "getType", "", "projection", "selection", "selectionArgs", "sortOrder", "Landroid/database/Cursor;", "query", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "", "delete", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sec_share_data_release"}, k = 1, mv = {1, 4, 0})
public final class SecShareDataProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final UriMatcher f406345b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.ss.android.account.share.data.write.a f406346a;

    public static final class a {
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        return 0;
    }

    static {
        f406345b = new UriMatcher(-1);
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        Context r100 = getContext();
        if (r100 == null) goto L9;
        com.ss.android.account.share.data.write.a r101 = com.ss.android.account.share.data.write.a.f406337b;
        this.f406346a = com.ss.android.account.share.data.write.a.C4701a.a(r100);
        String r102 = r100.getPackageName();
        if (TextUtils.isEmpty(r102) == false) goto L7;
        return false;
    L7:
        UriMatcher r103 = f406345b;
        r103.addURI(r102 + ".SecShareProviderAuthority", "sec_share/*", 2);
        r103.addURI(r102 + ".SecShareProviderAuthority", "sec_share_file/*", 3);
        return true;
    L9:
        return false;
    }

    public SecShareDataProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r110) {
        int r100 = f406345b.match(r110);
        if (r100 != 2) goto L5;
        Context r111 = getContext();
        if (r111 == null) goto L31;
        String r112 = r111.getPackageName();
        if (TextUtils.isEmpty(r112) == false) goto L30;
        return null;
    L30:
        return r112 + ".SecShareProviderAuthority";
    L31:
        return null;
    L5:
        if (r100 == 3) goto L7;
        return null;
    L7:
        String r101 = r110.getLastPathSegment();
        if (r101 == null) goto L10;
        int r102 = StringsKt.lastIndexOf$default(r101, '.', 0, false, 6, null);
    L11:
        if (r102 < 0) goto L22;
        String r113 = r110.getLastPathSegment();
        if (r113 != null) goto L15;
        Intrinsics.throwNpe();
    L15:
        int r103 = r102 + 1;
        if (r113 == null) goto L21;
        String r114 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(r113.substring(r103));
        if (r114 == null) goto L32;
        return r114;
    L32:
        return "application/octet-stream";
    L21:
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    L22:
        return "application/octet-stream";
    L10:
        r102 = -1;
        goto L11
    }

    @Override // android.content.ContentProvider
    public synchronized Uri insert(Uri r100, ContentValues r101) {
        monitor-enter(this);
        monitor-exit(this);
        return r100;
    }

    @Override // android.content.ContentProvider
    public final ParcelFileDescriptor openFile(Uri r100, String r101) {
        SecShareDataWriteManager r102 = SecShareDataWriteManager.f406336f;
        String r103 = getCallingPackage();
        r102.getClass();
        if (SecShareDataWriteManager.a(r103) == true) goto L6;
        return null;
    L6:
        if (f406345b.match(r100) == 3) goto L9;
        return null;
    L9:
        if (getContext() == null) goto L38;
        String r104 = r100.getLastPathSegment();
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == true) goto L38;
        int r106 = dra.a.f469799a;
        Context r107 = getContext();
        if (r107 != null) goto L21;
        Intrinsics.throwNpe();
    L21:
        String r108 = r100.getLastPathSegment();
        if (r108 != null) goto L39;
        Intrinsics.throwNpe();
    L39:
        PolarisFileWrapper r109 = new PolarisFileWrapper(r107.getFilesDir(), "sec_share_data_file");     // Catch: Throwable -> L29
        if (r109.exists() == true) goto L27;
        r109.mkdirs();     // Catch: Throwable -> L29
    L27:
        PolarisFileWrapper r110 = new PolarisFileWrapper(r109, r108);     // Catch: Throwable -> L29
    L31:
        if (r110 == null) goto L38;
        if (r110.exists() == false) goto L38;
        if (r110.isFile() == false) goto L38;
        return ParcelFileDescriptor.open(r110, 268435456);
    L29:
        th = move-exception;
        th.printStackTrace();
        r110 = null;
        goto L31
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
    L38:
        return null;
    }

    @Override // android.content.ContentProvider
    public synchronized Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        monitor-enter(this);
        SecShareDataWriteManager r105 = SecShareDataWriteManager.f406336f;     // Catch: Throwable -> L32
        String r106 = getCallingPackage();     // Catch: Throwable -> L32
        r105.getClass();     // Catch: Throwable -> L32
        boolean r107 = SecShareDataWriteManager.a(r106);     // Catch: Throwable -> L32
        MatrixCursor r108 = null;
        if (r107 == true) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Logger.e("SecShareDataProvider", "query getCallingPackage = " + getCallingPackage());     // Catch: Throwable -> L32
        if (f406345b.match(r100) == 2) goto L14;
        monitor-exit(this);
        return null;
    L14:
        List<String> r109 = r100.getPathSegments();     // Catch: Throwable -> L32
        int r110 = r109.size();     // Catch: Throwable -> L32
        if (r110 <= 0) goto L30;
        String r111 = (String) ListProtector.get(r109, r110 - 1);     // Catch: Throwable -> L32
        com.ss.android.account.share.data.write.a r112 = this.f406346a;     // Catch: Exception -> L26 Throwable -> L32
        if (r112 != null) goto L20;
        Intrinsics.throwNpe();     // Catch: Exception -> L26 Throwable -> L32
    L20:
        String r113 = r112.f406338a.getSharedPreferences("account_sec_share_data", 0).getString(r111, "");     // Catch: Exception -> L26 Throwable -> L32
        MatrixCursor r114 = new MatrixCursor(new String[]{r111});     // Catch: Exception -> L26 Throwable -> L32
        MatrixCursor.RowBuilder r115 = r114.newRow();     // Catch: Exception -> L24 Throwable -> L32
        Logger.w("SecShareDataProvider", "MultiProcessShareProvider  get queryKey = " + r111 + " value = " + r113);     // Catch: Exception -> L24 Throwable -> L32
        r115.add(r111, r113);     // Catch: Exception -> L24 Throwable -> L32
        monitor-exit(this);
        return r114;
    L24:
        e = e;
        r108 = r114;
    L27:
        e.printStackTrace();     // Catch: Throwable -> L32
        monitor-exit(this);
        return r108;
    L26:
        e = e;
        goto L27
    L30:
        monitor-exit(this);
        return null;
    L32:
        th = move-exception;
        throw th;
    }
}
