package com.bytedance.ee.bear.document.imageviewer.diagram;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/document/imageviewer/diagram/DiagramData$Base64Data;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "result", "", "getResult$annotations", "getResult", "()Ljava/lang/String;", "setResult", "(Ljava/lang/String;)V", ST.UUID_DEVICE, "getUuid", "setUuid", "base64String", "getBase64String", "setBase64String", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiagramData$Base64Data implements NonProguard {
    private String base64String;
    private String result;
    private String uuid;

    public DiagramData$Base64Data() {
    }

    public static /* synthetic */ void getResult$annotations() {
    }

    public final String getBase64String() {
        return this.base64String;
    }

    public final String getResult() {
        return this.result;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final void setBase64String(String r100) {
        this.base64String = r100;
    }

    public final void setResult(String r100) {
        this.result = r100;
    }

    public final void setUuid(String r100) {
        this.uuid = r100;
    }
}
