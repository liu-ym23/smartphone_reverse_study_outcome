package com.bytedance.ee.bear.bitable.homepage.preview;

import android.text.TextUtils;
import com.alipay.sdk.m.x.d;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010&\u001a\u00020'J\b\u0010(\u001a\u00020\fH\u0016R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0017\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000e\"\u0004\b\u0019\u0010\u0010R\u001a\u0010\u001a\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000e\"\u0004\b\u001c\u0010\u0010R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/preview/HomePageBoostData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "status", "", "getStatus", "()Ljava/lang/Integer;", "setStatus", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "title", "", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "url", "getUrl", "setUrl", "baseToken", "getBaseToken", "setBaseToken", "tableID", "getTableID", "setTableID", "viewID", "getViewID", "setViewID", "stayDays", "getStayDays", "setStayDays", "boostCreateInfo", "Lcom/bytedance/ee/bear/bitable/homepage/preview/BoostCreateInfo;", "getBoostCreateInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/preview/BoostCreateInfo;", "setBoostCreateInfo", "(Lcom/bytedance/ee/bear/bitable/homepage/preview/BoostCreateInfo;)V", "isValid", "", "toString", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HomePageBoostData implements NonProguard {
    private String baseToken;
    private BoostCreateInfo boostCreateInfo;
    private Integer status;
    private Integer stayDays;
    private String tableID;
    private String title;
    private String url;
    private String viewID;

    public final boolean isValid() {
        if (TextUtils.isEmpty(this.title) == false) goto L5;
    L13:
        return false;
    L5:
        if (TextUtils.isEmpty(this.baseToken) == true) goto L13;
        if (TextUtils.isEmpty(this.tableID) == true) goto L13;
        if (TextUtils.isEmpty(this.viewID) == true) goto L13;
        if (TextUtils.isEmpty(this.url) == true) goto L13;
        return true;
    }

    public String toString() {
        return "HomePageBoostData(status=" + this.status + ", title=" + this.title + ", url=" + this.url + ", baseToken='" + this.baseToken + "', tableID='" + this.tableID + "', viewID='" + this.viewID + "', stayDays=" + this.stayDays + ", boostCreateInfo=" + this.boostCreateInfo + ')';
    }

    public HomePageBoostData() {
        this.baseToken = "";
        this.tableID = "";
        this.viewID = "";
        this.boostCreateInfo = new BoostCreateInfo();
    }

    public final String getBaseToken() {
        return this.baseToken;
    }

    public final BoostCreateInfo getBoostCreateInfo() {
        return this.boostCreateInfo;
    }

    public final Integer getStatus() {
        return this.status;
    }

    public final Integer getStayDays() {
        return this.stayDays;
    }

    public final String getTableID() {
        return this.tableID;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getUrl() {
        return this.url;
    }

    public final String getViewID() {
        return this.viewID;
    }

    public final void setBaseToken(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.baseToken = r100;
    }

    public final void setBoostCreateInfo(BoostCreateInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.boostCreateInfo = r100;
    }

    public final void setStatus(Integer r100) {
        this.status = r100;
    }

    public final void setStayDays(Integer r100) {
        this.stayDays = r100;
    }

    public final void setTableID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.tableID = r100;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public final void setUrl(String r100) {
        this.url = r100;
    }

    public final void setViewID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.viewID = r100;
    }
}
