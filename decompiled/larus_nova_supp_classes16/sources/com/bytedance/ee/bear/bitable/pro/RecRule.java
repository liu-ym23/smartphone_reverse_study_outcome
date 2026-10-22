package com.bytedance.ee.bear.bitable.pro;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/pro/RecRule;", "Lcom/bytedance/ee/util/io/NonProguard;", "perm", "", "otherPerm", "<init>", "(II)V", "getPerm", "()I", "getOtherPerm", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecRule implements NonProguard {
    private final int otherPerm;
    private final int perm;

    public RecRule() {
        int r2 = 0;
        this(r2, r2, 3, null);
    }

    public final int getOtherPerm() {
        return this.otherPerm;
    }

    public final int getPerm() {
        return this.perm;
    }

    public RecRule(int r1, int r2) {
        this.perm = r1;
        this.otherPerm = r2;
    }

    public /* synthetic */ RecRule(int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 0;
    L8:
        this(r2, r3);
    }
}
