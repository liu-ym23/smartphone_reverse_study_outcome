package com.bytedance.ee.bear.rn;

import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f236528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f236529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SmartReplyDataForInsert f236530c;

    public a() {
        this(null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f236528a, r101.f236528a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f236529b, r101.f236529b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f236530c, r101.f236530c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f236528a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f236529b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        SmartReplyDataForInsert r107 = this.f236530c;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClearInputTextParams(commentId=" + this.f236528a + ", replyUUID=" + this.f236529b + ", smartReplyData=" + this.f236530c + ')';
    }

    public a(String r100, String r101, SmartReplyDataForInsert r102) {
        this.f236528a = r100;
        this.f236529b = r101;
        this.f236530c = r102;
    }
}
