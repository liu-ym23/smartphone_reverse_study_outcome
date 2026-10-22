package com.bytedance.awemeopen.export.api.pagetransition;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0003\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/awemeopen/export/api/pagetransition/AosPageTransition;", "", "enterAnim", "", "exitAnim", "(II)V", "getEnterAnim", "()I", "getExitAnim", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosPageTransition {
    private final int enterAnim;
    private final int exitAnim;

    public AosPageTransition() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ AosPageTransition copy$default(AosPageTransition r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.enterAnim;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.exitAnim;
    L9:
        return r100.copy(r101, r102);
    }

    public final int component1() {
        return this.enterAnim;
    }

    public final int component2() {
        return this.exitAnim;
    }

    public final AosPageTransition copy(int r100, int r101) {
        return new AosPageTransition(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof AosPageTransition) == true) goto L8;
        return false;
    L8:
        AosPageTransition r101 = (AosPageTransition) r100;
        if (this.enterAnim == r101.enterAnim) goto L12;
        return false;
    L12:
        if (this.exitAnim == r101.exitAnim) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.enterAnim * 31) + this.exitAnim;
    }

    public String toString() {
        return "AosPageTransition(enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + ')';
    }

    public final int getEnterAnim() {
        return this.enterAnim;
    }

    public final int getExitAnim() {
        return this.exitAnim;
    }

    public AosPageTransition(int r100, int r101) {
        this.enterAnim = r100;
        this.exitAnim = r101;
    }

    public /* synthetic */ AosPageTransition(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = R.anim.aos_slide_in_right;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = R.anim.aos_slide_out_right;
    L8:
        this(r100, r101);
    }
}
