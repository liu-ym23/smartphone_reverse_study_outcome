package com.bytedance.ee.bear.drive.biz.permission.inject;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/permission/inject/PointValue;", "Lcom/bytedance/ee/util/io/NonProguard;", "allow", "", "point", "", "<init>", "(ZI)V", "getAllow", "()Z", "setAllow", "(Z)V", "getPoint", "()I", "setPoint", "(I)V", "isEscaped", "contentmanager-drive-model_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PointValue implements NonProguard {
    private boolean allow;
    private int point;

    /* JADX WARN: Multi-variable type inference failed */
    public PointValue() {
        boolean r2 = false;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public final boolean isEscaped() {
        if (this.point != 210001) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean getAllow() {
        return this.allow;
    }

    public final int getPoint() {
        return this.point;
    }

    public final void setAllow(boolean r1) {
        this.allow = r1;
    }

    public final void setPoint(int r1) {
        this.point = r1;
    }

    public PointValue(boolean r1, int r2) {
        this.allow = r1;
        this.point = r2;
    }

    public /* synthetic */ PointValue(boolean r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
