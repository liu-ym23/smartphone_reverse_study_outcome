package com.ss.android.lark.image.impl.cache;

import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0016\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000e\"\u0004\b\u0018\u0010\u0010R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\n\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001c¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/image/impl/cache/FindMonitorInfo;", "", "scene", "", "hasCache", "", "cacheKey", "cacheLevel", "cacheSize", "", WiseOpenHianalyticsData.UNION_COSTTIME, "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;JJ)V", "getScene", "()Ljava/lang/String;", "setScene", "(Ljava/lang/String;)V", "getHasCache", "()Z", "setHasCache", "(Z)V", "getCacheKey", "setCacheKey", "getCacheLevel", "setCacheLevel", "getCacheSize", "()J", "setCacheSize", "(J)V", "getCostTime", "setCostTime", "lark-image_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FindMonitorInfo {
    private String cacheKey;
    private String cacheLevel;
    private long cacheSize;
    private long costTime;
    private boolean hasCache;
    private String scene;

    public FindMonitorInfo() {
        this(null, false, null, null, 0, 0, 63, null);
    }

    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final String getCacheLevel() {
        return this.cacheLevel;
    }

    public final long getCacheSize() {
        return this.cacheSize;
    }

    public final long getCostTime() {
        return this.costTime;
    }

    public final boolean getHasCache() {
        return this.hasCache;
    }

    public final String getScene() {
        return this.scene;
    }

    public final void setCacheKey(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cacheKey = r100;
    }

    public final void setCacheLevel(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.cacheLevel = r100;
    }

    public final void setCacheSize(long r100) {
        this.cacheSize = r100;
    }

    public final void setCostTime(long r100) {
        this.costTime = r100;
    }

    public final void setHasCache(boolean r100) {
        this.hasCache = r100;
    }

    public final void setScene(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.scene = r100;
    }

    public FindMonitorInfo(String r100, boolean r101, String r102, String r103, long r104, long r105) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "cacheKey");
        Intrinsics.checkNotNullParameter(r103, "cacheLevel");
        this.scene = r100;
        this.hasCache = r101;
        this.cacheKey = r102;
        this.cacheLevel = r103;
        this.cacheSize = r104;
        this.costTime = r105;
    }

    public /* synthetic */ FindMonitorInfo(String r100, boolean r101, String r102, String r103, long r110, long r111, int r112, DefaultConstructorMarker r113) {
        String r104 = "";
        if ((r112 & 1) == 0) goto L5;
        String r114 = "";
    L7:
        if ((r112 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r106 = "";
    L15:
        if ((r112 & 8) != 0) goto L19;
        r104 = r103;
    L19:
        if ((r112 & 16) == 0) goto L21;
        long r107 = 0;
    L23:
        if ((r112 & 32) == 0) goto L25;
        long r115 = 0;
    L26:
        this(r114, r105, r106, r104, r107, r115);
        return;
    L25:
        r115 = r111;
        goto L26
    L21:
        r107 = r110;
        goto L23
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r114 = r100;
        goto L7
    }
}
