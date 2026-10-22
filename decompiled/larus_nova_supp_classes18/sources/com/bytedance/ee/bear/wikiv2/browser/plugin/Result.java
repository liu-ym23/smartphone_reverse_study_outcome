package com.bytedance.ee.bear.wikiv2.browser.plugin;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/browser/plugin/Result;", "Lcom/bytedance/ee/util/io/NonProguard;", "code", "", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/wikiv2/browser/plugin/ThumbnailData;", "<init>", "(ILcom/bytedance/ee/bear/wikiv2/browser/plugin/ThumbnailData;)V", "getCode", "()I", "getData", "()Lcom/bytedance/ee/bear/wikiv2/browser/plugin/ThumbnailData;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Result implements NonProguard {
    private final int code;
    private final ThumbnailData data;

    public static /* synthetic */ Result copy$default(Result r0, int r1, ThumbnailData r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.code;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.data;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.code;
    }

    public final ThumbnailData component2() {
        return this.data;
    }

    public final Result copy(int r2, ThumbnailData r3) {
        return new Result(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof Result) == true) goto L8;
        return false;
    L8:
        Result r6 = (Result) r5;
        if (this.code == r6.code) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.data, r6.data) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.code * 31;
        ThumbnailData r1 = this.data;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "Result(code=" + this.code + ", data=" + this.data + ')';
    }

    public final int getCode() {
        return this.code;
    }

    public final ThumbnailData getData() {
        return this.data;
    }

    public Result(int r1, ThumbnailData r2) {
        this.code = r1;
        this.data = r2;
    }
}
