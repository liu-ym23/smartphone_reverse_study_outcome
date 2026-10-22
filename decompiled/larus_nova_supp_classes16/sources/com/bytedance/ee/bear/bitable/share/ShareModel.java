package com.bytedance.ee.bear.bitable.share;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

    public ShareModel(String r1, int r2, String r3, String r4, String r5, String r6) {
        this.baseToken = r1;
        this.shareType = r2;
        this.title = r3;
        this.tableId = r4;
        this.viewId = r5;
        this.recordId = r6;
    }

    public /* synthetic */ ShareModel(String r6, int r7, String r8, String r9, String r10, String r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = "";
    L7:
        if ((r12 & 2) == 0) goto L9;
        int r1 = 0;
    L11:
        if ((r12 & 4) == 0) goto L13;
        String r2 = "";
    L15:
        if ((r12 & 8) == 0) goto L17;
        String r3 = "";
    L19:
        if ((r12 & 16) == 0) goto L21;
        String r4 = "";
    L23:
        if ((r12 & 32) == 0) goto L25;
        String r16 = "";
    L26:
        this(r14, r1, r2, r3, r4, r16);
        return;
    L25:
        r16 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
