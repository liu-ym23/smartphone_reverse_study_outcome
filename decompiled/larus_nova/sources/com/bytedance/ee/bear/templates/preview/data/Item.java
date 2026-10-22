package com.bytedance.ee.bear.templates.preview.data;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.lark.diskmanage.NonProguard;
import du5.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010 \u001a\u00020!H\u0002J\u0006\u0010)\u001a\u00020!R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015R\u001a\u0010\b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\rR\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\rR\u0011\u0010\"\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b$\u0010#R\u0011\u0010%\u001a\u00020!8F¢\u0006\u0006\u001a\u0004\b%\u0010#R\u001a\u0010&\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/data/Item;", "Lcom/ss/android/lark/diskmanage/NonProguard;", "objToken", "", "name", "objType", "", "source", "index", GXTemplateKey.GAIAX_TEMPLATE_ID, "<init>", "(Ljava/lang/String;Ljava/lang/String;IIILjava/lang/String;)V", "getObjToken", "()Ljava/lang/String;", "setObjToken", "(Ljava/lang/String;)V", "getName", "setName", "getObjType", "()I", "setObjType", "(I)V", "getSource", "setSource", "getIndex", "setIndex", "getTemplateId", "setTemplateId", "reportToken", "getReportToken", "reportName", "getReportName", "canReportNotEncryption", "", "isSystemTemplate", "()Z", "isCustomTemplate", "isBusinessTemplate", "isCategorySdkTemplate", "setCategorySdkTemplate", "(Z)V", "checkToken", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Item implements NonProguard {
    private int index;
    private boolean isCategorySdkTemplate;
    private String name;
    private String objToken;
    private int objType;
    private int source;
    private String templateId;

    public final boolean isBusinessTemplate() {
        if (this.source != 3) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isCustomTemplate() {
        if (this.source != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSystemTemplate() {
        if (this.source == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public final boolean checkToken() {
        return !isSystemTemplate();
    }

    public final String getReportName() {
        if (isSystemTemplate() == false) goto L6;
        return this.name;
    L6:
        return b.g(this.name);
    }

    public final String getReportToken() {
        if (isSystemTemplate() == false) goto L6;
        return this.objToken;
    L6:
        return b.g(this.objToken);
    }

    public final int getIndex() {
        return this.index;
    }

    public final String getName() {
        return this.name;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final int getObjType() {
        return this.objType;
    }

    public final int getSource() {
        return this.source;
    }

    public final String getTemplateId() {
        return this.templateId;
    }

    public final boolean isCategorySdkTemplate() {
        return this.isCategorySdkTemplate;
    }

    public final void setCategorySdkTemplate(boolean r100) {
        this.isCategorySdkTemplate = r100;
    }

    public final void setIndex(int r100) {
        this.index = r100;
    }

    public final void setName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.name = r100;
    }

    public final void setObjToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.objToken = r100;
    }

    public final void setObjType(int r100) {
        this.objType = r100;
    }

    public final void setSource(int r100) {
        this.source = r100;
    }

    public final void setTemplateId(String r100) {
        this.templateId = r100;
    }

    public Item(String r100, String r101, int r102, int r103, int r104, String r105) {
        Intrinsics.checkNotNullParameter(r100, "objToken");
        Intrinsics.checkNotNullParameter(r101, "name");
        this.objToken = r100;
        this.name = r101;
        this.objType = r102;
        this.source = r103;
        this.index = r104;
        this.templateId = r105;
    }
}
