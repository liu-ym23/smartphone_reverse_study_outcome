package com.huawei.hms.adapter;

import android.app.PendingIntent;
import android.content.Intent;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.core.aidl.annotation.Packed;

/* JADX INFO: loaded from: classes23.dex */
public class CoreBaseResponse implements IMessageEntity {

    @Packed
    public Intent intent;

    @Packed
    private String jsonBody;

    @Packed
    private String jsonHeader;

    @Packed
    public PendingIntent pendingIntent;

    public CoreBaseResponse() {
    }

    public Intent getIntent() {
        return this.intent;
    }

    public String getJsonBody() {
        return this.jsonBody;
    }

    public String getJsonHeader() {
        return this.jsonHeader;
    }

    public PendingIntent getPendingIntent() {
        return this.pendingIntent;
    }

    public void setIntent(Intent r100) {
        this.intent = r100;
    }

    public void setJsonBody(String r100) {
        this.jsonBody = r100;
    }

    public void setJsonHeader(String r100) {
        this.jsonHeader = r100;
    }

    public void setPendingIntent(PendingIntent r100) {
        this.pendingIntent = r100;
    }
}
