package com.bytedance.ee.bear.middleground.comment.export.bean;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/bean/FilterVisibility;", "Lcom/bytedance/ee/util/io/NonProguard;", "currentFilterVisibility", "", "allCount", "relateToMeCount", "onlyMeCount", "<init>", "(IIII)V", "getCurrentFilterVisibility", "()I", "getAllCount", "getRelateToMeCount", "getOnlyMeCount", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterVisibility implements NonProguard {
    private final int allCount;
    private final int currentFilterVisibility;
    private final int onlyMeCount;
    private final int relateToMeCount;

    public FilterVisibility() {
        this(0, 0, 0, 0, 15, null);
    }

    public final int getAllCount() {
        return this.allCount;
    }

    public final int getCurrentFilterVisibility() {
        return this.currentFilterVisibility;
    }

    public final int getOnlyMeCount() {
        return this.onlyMeCount;
    }

    public final int getRelateToMeCount() {
        return this.relateToMeCount;
    }

    public FilterVisibility(int r1, int r2, int r3, int r4) {
        this.currentFilterVisibility = r1;
        this.allCount = r2;
        this.relateToMeCount = r3;
        this.onlyMeCount = r4;
    }

    public /* synthetic */ FilterVisibility(int r2, int r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = 0;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r4 = 0;
    L12:
        if ((r6 & 8) == 0) goto L14;
        r5 = 0;
    L14:
        this(r2, r3, r4, r5);
    }
}
