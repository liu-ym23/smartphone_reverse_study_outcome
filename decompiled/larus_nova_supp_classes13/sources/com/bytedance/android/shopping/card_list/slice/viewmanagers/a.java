package com.bytedance.android.shopping.card_list.slice.viewmanagers;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/shopping/card_list/slice/viewmanagers/a;", "", "", "badgeType", "I", "c", "()I", "", "badgeText", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "Lcom/bytedance/android/shopping/card_list/slice/viewmanagers/g;", "badgePic", "Lcom/bytedance/android/shopping/card_list/slice/viewmanagers/g;", "a", "()Lcom/bytedance/android/shopping/card_list/slice/viewmanagers/g;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("badge_pic")
    private final g badgePic;

    @SerializedName("badge_text")
    private final String badgeText;

    @SerializedName("badge_type")
    private final int badgeType;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.card_list.slice.viewmanagers.a$a, reason: collision with other inner class name */
    public static final class C0035a {
    }

    static {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof a) == false) goto L12;
        a r4 = (a) r3;
        if (this.badgeType == r4.badgeType) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.badgeText, r4.badgeText) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.badgePic, r4.badgePic) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public final int hashCode() {
        int r0 = this.badgeType * 31;
        String r1 = this.badgeText;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = r1.hashCode();
    L6:
        int r4 = (r0 + r3) * 31;
        g r5 = this.badgePic;
        if (r5 == null) goto L10;
        r2 = r5.hashCode();
    L10:
        return r4 + r2;
    L5:
        r3 = 0;
        goto L6
    }

    public final String toString() {
        return "BadgeInfo(badgeType=" + this.badgeType + ", badgeText=" + this.badgeText + ", badgePic=" + this.badgePic + ")";
    }

    public a() {
        this.badgeType = 0;
        this.badgeText = null;
        this.badgePic = null;
    }

    public final g a() {
        return this.badgePic;
    }

    public final String b() {
        return this.badgeText;
    }

    public final int c() {
        return this.badgeType;
    }
}
