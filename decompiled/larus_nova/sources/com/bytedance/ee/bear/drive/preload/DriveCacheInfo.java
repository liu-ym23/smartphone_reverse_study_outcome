package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public class DriveCacheInfo implements NonProguard {
    String dataVersion;
    String ext;
    String mimeType;
    String name;
    String objToken;
    int permissionStatusCode;
    String previewExt;
    LinkedHashMap<String, String> previewUrls;
    int serverPreviewType;
    List<Integer> serverSupportPreviewType;
    long size;
    String version;

    public String getVideoPreviewUrl() {
        return this.previewUrls.values().iterator().next();
    L4:
        e = move-exception;
        tt5.a.f("DRIVE_PREVIEW_FLOW", e, false);
        return null;
    }

    public f85.a toFileModel() {
        LinkedHashMap<String, String> r100 = null;
        if (hu5.a.e(this.previewUrls) == false) goto L5;
        String r101 = null;
    L9:
        f85.a r102 = new f85.a(new f85.a.C5868a(this.name, this.size, new int[0], this.mimeType, this.objToken, this.version, this.dataVersion, this.permissionStatusCode));
        r102.f558536e = this.serverPreviewType;
        r102.f558533b = this.serverSupportPreviewType;
        r102.f558537f = this.previewExt;
        r102.h(r100);
        r102.f558540i = r101;
        return r102;
    L5:
        if (this.previewUrls.containsKey("default") == false) goto L7;
        r101 = this.previewUrls.get("default");
        goto L9
    L7:
        r100 = this.previewUrls;
        r101 = null;
        goto L9
    }

    public DriveCacheInfo() {
    }

    public String getDataVersion() {
        return this.dataVersion;
    }

    public String getExt() {
        return this.ext;
    }

    public String getMimeType() {
        return this.mimeType;
    }

    public String getName() {
        return this.name;
    }

    public String getObjToken() {
        return this.objToken;
    }

    public int getPermissionStatusCode() {
        return this.permissionStatusCode;
    }

    public String getPreviewExt() {
        return this.previewExt;
    }

    public LinkedHashMap<String, String> getPreviewUrls() {
        return this.previewUrls;
    }

    public int getServerPreviewType() {
        return this.serverPreviewType;
    }

    public List<Integer> getServerSupportPreviewType() {
        return this.serverSupportPreviewType;
    }

    public long getSize() {
        return this.size;
    }

    public String getVersion() {
        return this.version;
    }

    public DriveCacheInfo(f85.a r100) {
        w75.b r101 = r100.f558532a;
        this.objToken = ((f85.a.C5868a) r101).f558557a;
        this.name = ((f85.a.C5868a) r101).f558558b;
        this.ext = ((f85.a.C5868a) r100.f558532a).f558567k;
        this.size = ((f85.a.C5868a) r100.f558532a).f558559c;
        if (hu5.a.e(r100.f558538g) == true) goto L6;
        this.previewUrls = r100.f558538g;
    L8:
        this.serverSupportPreviewType = r100.f558533b;
        w75.b r102 = r100.f558532a;
        this.version = ((f85.a.C5868a) r102).f475872o;
        this.dataVersion = ((f85.a.C5868a) r102).f475873p;
        this.mimeType = r100.f558549r;
        this.previewExt = r100.f558537f;
        this.serverPreviewType = r100.f558536e;
        this.permissionStatusCode = ((f85.a.C5868a) r102).f558568l;
        return;
    L6:
        if (TextUtils.isEmpty(r100.f558540i) == true) goto L8;
        LinkedHashMap<String, String> r103 = new LinkedHashMap();
        this.previewUrls = r103;
        r103.put("default", r100.f558540i);
        goto L8
    }

    public void setDataVersion(String r100) {
        this.dataVersion = r100;
    }

    public void setExt(String r100) {
        this.ext = r100;
    }

    public void setMimeType(String r100) {
        this.mimeType = r100;
    }

    public void setName(String r100) {
        this.name = r100;
    }

    public void setObjToken(String r100) {
        this.objToken = r100;
    }

    public void setPermissionStatusCode(int r100) {
        this.permissionStatusCode = r100;
    }

    public void setPreviewExt(String r100) {
        this.previewExt = r100;
    }

    public void setPreviewUrls(LinkedHashMap<String, String> r100) {
        this.previewUrls = r100;
    }

    public void setServerPreviewType(int r100) {
        this.serverPreviewType = r100;
    }

    public void setServerSupportPreviewType(List<Integer> r100) {
        this.serverSupportPreviewType = r100;
    }

    public void setSize(long r100) {
        this.size = r100;
    }

    public void setVersion(String r100) {
        this.version = r100;
    }
}
