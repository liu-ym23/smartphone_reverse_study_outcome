package com.bytedance.ee.bear.drive.preload;

import android.text.TextUtils;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.util.io.NonProguard;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        LinkedHashMap<String, String> r1 = null;
        if (hu5.a.e(this.previewUrls) == false) goto L5;
        String r0 = null;
    L9:
        f85.a r2 = new f85.a(new f85.a.C0229a(this.name, this.size, new int[0], this.mimeType, this.objToken, this.version, this.dataVersion, this.permissionStatusCode));
        r2.e = this.serverPreviewType;
        r2.b = this.serverSupportPreviewType;
        r2.f = this.previewExt;
        r2.h(r1);
        r2.i = r0;
        return r2;
    L5:
        if (this.previewUrls.containsKey(BottomPopupData.Default) == false) goto L7;
        r0 = this.previewUrls.get(BottomPopupData.Default);
        goto L9
    L7:
        r1 = this.previewUrls;
        r0 = null;
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

    public DriveCacheInfo(f85.a r4) {
        w75.b r0 = r4.a;
        this.objToken = ((f85.a.C0229a) r0).a;
        this.name = ((f85.a.C0229a) r0).b;
        this.ext = ((f85.a.C0229a) r4.a).k;
        this.size = ((f85.a.C0229a) r4.a).c;
        if (hu5.a.e(r4.g) == true) goto L6;
        this.previewUrls = r4.g;
    L8:
        this.serverSupportPreviewType = r4.b;
        w75.b r1 = r4.a;
        this.version = ((f85.a.C0229a) r1).o;
        this.dataVersion = ((f85.a.C0229a) r1).p;
        this.mimeType = r4.r;
        this.previewExt = r4.f;
        this.serverPreviewType = r4.e;
        this.permissionStatusCode = ((f85.a.C0229a) r1).l;
        return;
    L6:
        if (TextUtils.isEmpty(r4.i) == true) goto L8;
        LinkedHashMap<String, String> r2 = new LinkedHashMap();
        this.previewUrls = r2;
        r2.put(BottomPopupData.Default, r4.i);
        goto L8
    }

    public void setDataVersion(String r1) {
        this.dataVersion = r1;
    }

    public void setExt(String r1) {
        this.ext = r1;
    }

    public void setMimeType(String r1) {
        this.mimeType = r1;
    }

    public void setName(String r1) {
        this.name = r1;
    }

    public void setObjToken(String r1) {
        this.objToken = r1;
    }

    public void setPermissionStatusCode(int r1) {
        this.permissionStatusCode = r1;
    }

    public void setPreviewExt(String r1) {
        this.previewExt = r1;
    }

    public void setPreviewUrls(LinkedHashMap<String, String> r1) {
        this.previewUrls = r1;
    }

    public void setServerPreviewType(int r1) {
        this.serverPreviewType = r1;
    }

    public void setServerSupportPreviewType(List<Integer> r1) {
        this.serverSupportPreviewType = r1;
    }

    public void setSize(long r1) {
        this.size = r1;
    }

    public void setVersion(String r1) {
        this.version = r1;
    }
}
