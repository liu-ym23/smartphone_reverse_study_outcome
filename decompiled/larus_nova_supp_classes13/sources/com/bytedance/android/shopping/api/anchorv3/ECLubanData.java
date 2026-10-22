package com.bytedance.android.shopping.api.anchorv3;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/api/anchorv3/ECLubanData;", "Ljava/io/Serializable;", "isLuban", "", "pageId", "", "sourceType", "qianchuanAB", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "()Z", "getPageId", "()Ljava/lang/String;", "getQianchuanAB", "getSourceType", "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class ECLubanData implements Serializable {
    private final boolean isLuban;
    private final String pageId;
    private final String qianchuanAB;
    private final String sourceType;

    public ECLubanData() {
        this(false, null, null, null, 15, null);
    }

    public final String getPageId() {
        return this.pageId;
    }

    public final String getQianchuanAB() {
        return this.qianchuanAB;
    }

    public final String getSourceType() {
        return this.sourceType;
    }

    public final boolean isLuban() {
        return this.isLuban;
    }

    public ECLubanData(boolean r1, String r2, String r3, String r4) {
        this.isLuban = r1;
        this.pageId = r2;
        this.sourceType = r3;
        this.qianchuanAB = r4;
    }

    public /* synthetic */ ECLubanData(boolean r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = null;
    L14:
        this(r2, r3, r4, r5);
    }
}
