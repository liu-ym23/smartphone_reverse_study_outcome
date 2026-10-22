package com.ss.android.lark.appreciablelib;

import androidx.exifinterface.media.ExifInterface;
import com.alipay.sdk.m.k.b;
import com.bytedance.android.live.soloktv.SoloKtvContext;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u00012\u00020\u0005B/\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00028\u0001\u0012\u0006\u0010\b\u001a\u00028\u0002\u0012\u0006\u0010\t\u001a\u00028\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0016\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0017\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0018\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0019\u001a\u00028\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u000bHÆ\u0003JX\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u0006\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00028\u00012\b\b\u0002\u0010\b\u001a\u00028\u00022\b\b\u0002\u0010\t\u001a\u00028\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u0006\u0010\"\u001a\u00020\u000bJ\b\u0010#\u001a\u00020$H\u0016R\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\t\u001a\u00028\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0014\u0010\u000eR\u0013\u0010\b\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/ss/android/lark/appreciablelib/CacheEvent;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", "Ljava/io/Serializable;", SoloKtvContext.SOLO_PAGE_FIRST, "second", b.f25414o, "forth", "isTea", "", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)V", "getFirst", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getForth", "()Z", "setTea", "(Z)V", "getSecond", "getThird", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Z)Lcom/ss/android/lark/appreciablelib/CacheEvent;", "equals", "other", "", "hashCode", "", "isTeaEvent", "toString", "", "appreciablelib_release"}, k = 1, mv = {1, 1, 15})
public final class CacheEvent<A, B, C, D> implements Serializable {
    private final A first;
    private final D forth;
    private boolean isTea;
    private final B second;
    private final C third;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CacheEvent copy$default(CacheEvent r100, Object r101, Object r102, Object r103, Object r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.first;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.second;
    L8:
        Object r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.third;
    L11:
        Object r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.forth;
    L14:
        Object r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isTea;
    L17:
        Object r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final A component1() {
        return this.first;
    }

    public final B component2() {
        return this.second;
    }

    public final C component3() {
        return this.third;
    }

    public final D component4() {
        return this.forth;
    }

    public final boolean component5() {
        return this.isTea;
    }

    public final CacheEvent<A, B, C, D> copy(A r100, B r101, C r110, D r111, boolean r112) {
        return new CacheEvent(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L21:
        return true;
    L5:
        if ((r100 instanceof CacheEvent) == false) goto L20;
        CacheEvent r101 = (CacheEvent) r100;
        if (Intrinsics.areEqual(this.first, r101.first) == false) goto L20;
        if (Intrinsics.areEqual(this.second, r101.second) == false) goto L20;
        if (Intrinsics.areEqual(this.third, r101.third) == false) goto L20;
        if (Intrinsics.areEqual(this.forth, r101.forth) == false) goto L20;
        if (this.isTea != r101.isTea) goto L17;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L20;
    L17:
        r102 = false;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        A r100 = this.first;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        B r104 = this.second;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        C r107 = this.third;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        D r110 = this.forth;
        if (r110 == null) goto L17;
        r101 = r110.hashCode();
    L17:
        int r111 = (r109 + r101) * 31;
        boolean r112 = this.isTea;
        ?? r113 = r112;
        if (r112 == false) goto L21;
        r113 = 1;
    L21:
        return r111 + r113;
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

    public String toString() {
        return "(" + this.first + ", " + this.second + ", " + this.third + ", " + this.forth + ')';
    }

    public final A getFirst() {
        return this.first;
    }

    public final D getForth() {
        return this.forth;
    }

    public final B getSecond() {
        return this.second;
    }

    public final C getThird() {
        return this.third;
    }

    public final boolean isTea() {
        return this.isTea;
    }

    public final boolean isTeaEvent() {
        return this.isTea;
    }

    public final void setTea(boolean r100) {
        this.isTea = r100;
    }

    public CacheEvent(A r100, B r101, C r102, D r103, boolean r104) {
        this.first = r100;
        this.second = r101;
        this.third = r102;
        this.forth = r103;
        this.isTea = r104;
    }

    public /* synthetic */ CacheEvent(Object r100, Object r101, Object r102, Object r110, boolean r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r103 = false;
    L6:
        this(r100, r101, r102, r110, r103);
        return;
    L5:
        r103 = r111;
        goto L6
    }
}
