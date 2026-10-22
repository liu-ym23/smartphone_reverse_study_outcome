package de3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.shopping.feedbackpanel.enums.WhereType;
import com.tencent.open.SocialConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f468058a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ECUrlModel f468059b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f468060c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public WhereType f468061d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof c) == false) goto L14;
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f468058a, r101.f468058a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f468059b, r101.f468059b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f468060c, r101.f468060c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f468061d, r101.f468061d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f468058a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        ECUrlModel r104 = this.f468059b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f468060c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        WhereType r110 = this.f468061d;
        if (r110 == null) goto L18;
        r101 = r110.hashCode();
    L18:
        return r109 + r101;
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "FeedbackBoardItemData(uniqueKey=" + this.f468058a + ", icon=" + this.f468059b + ", desc=" + this.f468060c + ", where=" + this.f468061d + ")";
    }

    public c(String r100, ECUrlModel r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uniqueKey");
        Intrinsics.checkNotNullParameter(r102, SocialConstants.PARAM_APP_DESC);
        this.f468058a = r100;
        this.f468059b = r101;
        this.f468060c = r102;
        this.f468061d = null;
    }
}
