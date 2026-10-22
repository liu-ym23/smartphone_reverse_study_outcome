package com.ss.android.lark.log.alog;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0007\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0013R\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0011\"\u0004\b\u001b\u0010\u0013¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/log/alog/ReportConfig;", "", "duration", "", "maxTagF", "", "maxFreq", "maxCost", "maxLogSize", "maxLogSubSize", "<init>", "(JIIIII)V", "getDuration", "()J", "setDuration", "(J)V", "getMaxTagF", "()I", "setMaxTagF", "(I)V", "getMaxFreq", "setMaxFreq", "getMaxCost", "setMaxCost", "getMaxLogSize", "setMaxLogSize", "getMaxLogSubSize", "setMaxLogSubSize", "lark-logger_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReportConfig {
    private long duration;
    private int maxCost;
    private int maxFreq;
    private int maxLogSize;
    private int maxLogSubSize;
    private int maxTagF;

    public ReportConfig() {
        this(0, 0, 0, 0, 0, 0, 63, null);
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getMaxCost() {
        return this.maxCost;
    }

    public final int getMaxFreq() {
        return this.maxFreq;
    }

    public final int getMaxLogSize() {
        return this.maxLogSize;
    }

    public final int getMaxLogSubSize() {
        return this.maxLogSubSize;
    }

    public final int getMaxTagF() {
        return this.maxTagF;
    }

    public final void setDuration(long r100) {
        this.duration = r100;
    }

    public final void setMaxCost(int r100) {
        this.maxCost = r100;
    }

    public final void setMaxFreq(int r100) {
        this.maxFreq = r100;
    }

    public final void setMaxLogSize(int r100) {
        this.maxLogSize = r100;
    }

    public final void setMaxLogSubSize(int r100) {
        this.maxLogSubSize = r100;
    }

    public final void setMaxTagF(int r100) {
        this.maxTagF = r100;
    }

    public ReportConfig(long r100, int r101, int r102, int r103, int r104, int r105) {
        this.duration = r100;
        this.maxTagF = r101;
        this.maxFreq = r102;
        this.maxCost = r103;
        this.maxLogSize = r104;
        this.maxLogSubSize = r105;
    }

    public /* synthetic */ ReportConfig(long r100, int r110, int r111, int r112, int r113, int r114, int r115, DefaultConstructorMarker r116) {
        if ((r115 & 1) == 0) goto L5;
        long r101 = 1000;
    L7:
        if ((r115 & 2) == 0) goto L9;
        int r102 = 100;
    L11:
        if ((r115 & 4) == 0) goto L13;
        int r103 = 500;
    L15:
        if ((r115 & 8) == 0) goto L17;
        int r104 = 200;
    L19:
        if ((r115 & 16) == 0) goto L21;
        int r105 = 4096;
    L23:
        if ((r115 & 32) == 0) goto L25;
        int r106 = 50;
    L26:
        this(r101, r102, r103, r104, r105, r106);
        return;
    L25:
        r106 = r114;
        goto L26
    L21:
        r105 = r113;
        goto L23
    L17:
        r104 = r112;
        goto L19
    L13:
        r103 = r111;
        goto L15
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }
}
