package com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.legou;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m93.s;
import m93.z;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\n\u001a\u00020\tHÖ\u0001J\t\u0010\f\u001a\u00020\u000bHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/common/homepage/card/headercard/model/legou/NewerOneOff;", "", "Lm93/s;", "component1", "Lm93/z;", "component2", "newerOneOffItem", "theme", "copy", "", "toString", "", "hashCode", "other", "", "equals", "Lm93/s;", "getNewerOneOffItem", "()Lm93/s;", "Lm93/z;", "getTheme", "()Lm93/z;", "<init>", "(Lm93/s;Lm93/z;)V", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NewerOneOff {

    @SerializedName("newer_one_off")
    private final s newerOneOffItem;
    private final z theme;

    /* JADX WARN: Multi-variable type inference failed */
    public NewerOneOff() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ NewerOneOff copy$default(NewerOneOff r0, s r1, z r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.newerOneOffItem;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.theme;
    L9:
        return r0.copy(r1, r2);
    }

    public final s component1() {
        return this.newerOneOffItem;
    }

    public final z component2() {
        return this.theme;
    }

    public final NewerOneOff copy(s r2, z r3) {
        return new NewerOneOff(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof NewerOneOff) == false) goto L10;
        NewerOneOff r4 = (NewerOneOff) r3;
        if (Intrinsics.areEqual(this.newerOneOffItem, r4.newerOneOffItem) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.theme, r4.theme) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        s r0 = this.newerOneOffItem;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        z r4 = this.theme;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "NewerOneOff(newerOneOffItem=" + this.newerOneOffItem + ", theme=" + this.theme + ")";
    }

    public final s getNewerOneOffItem() {
        return this.newerOneOffItem;
    }

    public final z getTheme() {
        return this.theme;
    }

    public NewerOneOff(s r1, z r2) {
        this.newerOneOffItem = r1;
        this.theme = r2;
    }

    public /* synthetic */ NewerOneOff(s r2, z r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
