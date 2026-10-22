package com.bytedance.ee.bear.bitable.share;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/ShareModel;", "Lcom/bytedance/ee/util/io/NonProguard;", "baseToken", "", "shareType", "", "title", "tableId", "viewId", "recordId", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBaseToken", "()Ljava/lang/String;", "getShareType", "()I", "getTitle", "getTableId", "getViewId", "getRecordId", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ShareModel implements NonProguard {
    private final String baseToken;
    private final String recordId;
    private final int shareType;
    private final String tableId;
    private final String title;
    private final String viewId;

    public ShareModel() {
        this(null, 0, null, null, null, null, 63, null);
    }

    public final String getBaseToken() {
        return this.baseToken;
    }

    public final String getRecordId() {
        return this.recordId;
    }

    public final int getShareType() {
        return this.shareType;
    }

    public final String getTableId() {
        return this.tableId;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getViewId() {
        return this.viewId;
    }

    public ShareModel(String r100, int r101, String r102, String r103, String r104, String r105) {
        this.baseToken = r100;
        this.shareType = r101;
        this.title = r102;
        this.tableId = r103;
        this.viewId = r104;
        this.recordId = r105;
    }

    public /* synthetic */ ShareModel(String r100, int r101, String r102, String r103, String r110, String r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        int r104 = 0;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r105 = "";
    L15:
        if ((r112 & 8) == 0) goto L17;
        String r106 = "";
    L19:
        if ((r112 & 16) == 0) goto L21;
        String r107 = "";
    L23:
        if ((r112 & 32) == 0) goto L25;
        String r115 = "";
    L26:
        this(r114, r104, r105, r106, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L17:
        r106 = r103;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
