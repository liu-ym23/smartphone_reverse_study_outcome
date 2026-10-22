package com.ss.android.ugc.effectmanager.model;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.ugc.effectplatform.util.k;

/* JADX INFO: loaded from: classes40.dex */
public class LocalModelInfo {
    private boolean mIsBuilt;
    private final Uri mUri;

    /* JADX INFO: renamed from: md5, reason: collision with root package name */
    private String f454373md5;
    private String name;
    private int size;
    private String version;

    public String getMD5() {
        String r100 = this.f454373md5;
        if (r100 != null) goto L5;
    L6:
        Uri r101 = this.mUri;
        if (r101 == null) goto L10;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getPath());
        boolean r103 = k.f458040a;
        this.f454373md5 = k.b(r102.getName());
    L10:
        return this.f454373md5;
    L5:
        if (r100.isEmpty() == false) goto L10;
        goto L6
    }

    public String getName() {
        String r100 = this.name;
        if (r100 != null) goto L5;
    L6:
        Uri r101 = this.mUri;
        if (r101 == null) goto L10;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101.getPath());
        boolean r103 = k.f458040a;
        this.name = k.d(r102.getName());
    L10:
        return this.name;
    L5:
        if (r100.isEmpty() == false) goto L10;
        goto L6
    }

    public int getSize() {
        if (this.size != (-1)) goto L8;
        Uri r100 = this.mUri;
        if (r100 == null) goto L8;
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100.getPath());
        boolean r102 = k.f458040a;
        this.size = k.e(r101.getName());
    L8:
        return this.size;
    }

    public String getVersion() {
        String r100 = this.version;
        if (r100 != null) goto L5;
    L6:
        Uri r101 = this.mUri;
        if (r101 == null) goto L10;
        this.version = getVersionOfModel(r101.getPath());
    L10:
        return this.version;
    L5:
        if (r100.isEmpty() == false) goto L10;
        goto L6
    }

    public String toString() {
        return "LocalModelInfo{name=" + getName() + "',version=" + getVersion() + "',size=" + getSize() + "',md5=" + getMD5() + "'}";
    }

    public LocalModelInfo() {
        this.size = -1;
        this.mIsBuilt = false;
        this.mUri = null;
    }

    public Uri getUri() {
        return this.mUri;
    }

    public boolean isBuilt() {
        return this.mIsBuilt;
    }

    private LocalModelInfo(Uri r100) {
        this.size = -1;
        this.mIsBuilt = false;
        this.mUri = r100;
    }

    public static LocalModelInfo fromFile(String r100) {
        return new LocalModelInfo(UriProtector.parse(MSkiaImageRegionDecoder.FILE_PREFIX + r100));
    }

    private static String getVersionOfModel(String r100) {
        if (r100 != null) goto L5;
        return "1.0";
    L5:
        r100.lastIndexOf(HTTP.URL_DEFAULT);
        int r101 = r100.lastIndexOf("_v");
        if (r100.contains("size") == false) goto L8;
        int r102 = r100.lastIndexOf("_size");
    L9:
        if (r101 > 0) goto L11;
        return "1.0";
    L11:
        return r100.substring(r101 + 2, r102).replace('_', '.');
    L8:
        r102 = r100.lastIndexOf("_model");
        goto L9
    }

    public void setBuilt(boolean r100) {
        this.mIsBuilt = r100;
    }

    public void setMd5(String r100) {
        this.f454373md5 = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setSize(int r100) {
        this.size = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
