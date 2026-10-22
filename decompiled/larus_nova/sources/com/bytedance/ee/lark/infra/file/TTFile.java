package com.bytedance.ee.lark.infra.file;

import android.net.Uri;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0010\u001a\u00020\u0003J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012J\u0006\u0010\u0016\u001a\u00020\u0012J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003J\u0006\u0010\u0018\u001a\u00020\u0003J\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u001b\u0010\u0006\u001a\u00020\u00078FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/lark/infra/file/TTFile;", "Ljava/io/Serializable;", "rawPath", "", "<init>", "(Ljava/lang/String;)V", "uri", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "uri$delegate", "Lkotlin/Lazy;", "getRawPath", "()Ljava/lang/String;", "getParent", "getChild", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "isTTFileScheme", "", "isInValid", "isPkgFile", "isUserFile", "isTempFile", "getPath", "getName", "getExtension", "isFileNameTooLong", "toString", "Companion", "eco-infra_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class TTFile implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "TTFile";
    public static final TTFile TEMP = null;
    public static final TTFile USER = null;
    private final String rawPath;
    private final Lazy uri$delegate;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        USER = new TTFile("ttfile://user");
        TEMP = new TTFile("ttfile://temp");
    }

    public final Uri getUri() {
        return (Uri) this.uri$delegate.getValue();
    }

    public String toString() {
        return "TTFile(rawPath=" + this.rawPath + ", uri=" + getUri() + ')';
    }

    public final String getExtension() {
        if (isInValid() == false) goto L5;
        return "";
    L5:
        int r100 = StringsKt.lastIndexOf$default(this.rawPath, ".", 0, false, 6, null);
        if (r100 == (-1)) goto L10;
        if (r100 == 0) goto L11;
        String r101 = this.rawPath;
        return r101.substring(r100 + 1, r101.length());
    L11:
        return "";
    L10:
        return "";
    }

    public final String getName() {
        String r100 = "";
        if (isInValid() == false) goto L5;
        return "";
    L5:
        String r101 = getUri().getEncodedPath();
        if (r101 == null) goto L10;
        r100 = r101;
    L10:
        return com.bytedance.ee.lark.infra.foundation.utils.a.a(r100).getName();
    }

    public final TTFile getParent() {
        if (isInValid() == false) goto L5;
        return null;
    L5:
        String r100 = getUri().getEncodedPath();
        if (r100 != null) goto L8;
        r100 = "";
    L8:
        String r101 = com.bytedance.ee.lark.infra.foundation.utils.a.a(r100).getParent();
        if (r101 != null) goto L11;
    L14:
        boolean r102 = true;
    L15:
        if (r102 == false) goto L17;
        return null;
    L17:
        AppBrandLogger.i(TAG, new Object[]{"parent:" + r101});
        return new TTFile(new Uri.Builder().scheme(getUri().getScheme()).encodedAuthority(getUri().getEncodedAuthority()).encodedPath(r101).build().toString());
    L11:
        if (r101.length() == 0) goto L14;
        r102 = false;
        goto L15
    }

    public final String getPath() {
        return getUri().getEncodedPath();
    }

    public final boolean isFileNameTooLong() {
        if (isInValid() == false) goto L6;
        return false;
    L6:
        if (getName().getBytes(Charsets.UTF_8).length < 255) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isInValid() {
        if (isPkgFile() == false) goto L5;
    L9:
        return false;
    L5:
        if (isUserFile() == true) goto L9;
        if (isTempFile() == true) goto L9;
        return true;
    }

    public final boolean isPkgFile() {
        if (getUri().getScheme() == null) goto L5;
        return false;
    L5:
        if (getUri().getEncodedAuthority() != null) goto L17;
        String r100 = getUri().getEncodedPath();
        if (r100 != null) goto L9;
    L12:
        boolean r101 = true;
    L13:
        if (r101 == true) goto L18;
        return true;
    L18:
        return false;
    L9:
        if (r100.length() == 0) goto L12;
        r101 = false;
        goto L13
    L17:
        return false;
    }

    public final boolean isTTFileScheme() {
        return Intrinsics.areEqual(getUri().getScheme(), "ttfile");
    }

    public final boolean isTempFile() {
        if (Intrinsics.areEqual("ttfile", getUri().getScheme()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("temp", getUri().getEncodedAuthority()) == false) goto L7;
        return true;
    }

    public final boolean isUserFile() {
        if (Intrinsics.areEqual("ttfile", getUri().getScheme()) == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual("user", getUri().getEncodedAuthority()) == false) goto L7;
        return true;
    }

    public final String getRawPath() {
        return this.rawPath;
    }

    public TTFile(final String r100) {
        this.uri$delegate = LazyKt.lazy(new TTFile$uri$2(r100));
        this.rawPath = getUri().toString();
    }

    public final TTFile getChild(String r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        if (isInValid() == false) goto L6;
        return null;
    L6:
        String r101 = getUri().getEncodedPath();
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        int r102 = com.bytedance.ee.lark.infra.foundation.utils.a.f242800a;
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        PolarisFileWrapper r103 = new PolarisFileWrapper(r101, r100);
        return new TTFile(new Uri.Builder().scheme(getUri().getScheme()).encodedAuthority(getUri().getEncodedAuthority()).encodedPath(r103.getAbsolutePath()).build().toString());
    }
}
