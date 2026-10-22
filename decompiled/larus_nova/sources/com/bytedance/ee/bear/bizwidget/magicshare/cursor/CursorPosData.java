package com.bytedance.ee.bear.bizwidget.magicshare.cursor;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ee/bear/bizwidget/magicshare/cursor/CursorPosData;", "Lcom/bytedance/ee/util/io/NonProguard;", "x", "", "y", "close", "", "<init>", "(Ljava/lang/Float;Ljava/lang/Float;Z)V", "getX", "()Ljava/lang/Float;", "setX", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getY", "setY", "getClose", "()Z", "setClose", "(Z)V", "toString", "", "framework-biz-widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CursorPosData implements NonProguard {
    private boolean close;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private Float f216491x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private Float f216492y;

    public String toString() {
        return "{ x = " + this.f216491x + ", y = " + this.f216492y + ", close = " + this.close + '}';
    }

    public final boolean getClose() {
        return this.close;
    }

    public final Float getX() {
        return this.f216491x;
    }

    public final Float getY() {
        return this.f216492y;
    }

    public final void setClose(boolean r100) {
        this.close = r100;
    }

    public final void setX(Float r100) {
        this.f216491x = r100;
    }

    public final void setY(Float r100) {
        this.f216492y = r100;
    }

    public CursorPosData(Float r100, Float r101, boolean r102) {
        this.f216491x = r100;
        this.f216492y = r101;
        this.close = r102;
    }

    public /* synthetic */ CursorPosData(Float r100, Float r101, boolean r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 4) == 0) goto L5;
        r102 = false;
    L5:
        this(r100, r101, r102);
    }
}
