package ql1;

import io.reactivex.subjects.BehaviorSubject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f533718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f533719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f533720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final BehaviorSubject<String> f533721d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof d) == false) goto L14;
        d r101 = (d) r100;
        if (this.f533718a == r101.f533718a) goto L8;
        return false;
    L8:
        if (this.f533719b == r101.f533719b) goto L10;
        return false;
    L10:
        if (this.f533720c == r101.f533720c) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f533721d, r101.f533721d) == true) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public final int hashCode() {
        boolean r100 = this.f533718a;
        ?? r101 = r100;
        if (r100 == false) goto L5;
        r101 = 1;
    L5:
        int r102 = ((((r101 * 31) + this.f533719b) * 31) + this.f533720c) * 31;
        BehaviorSubject<String> r103 = this.f533721d;
        if (r103 == null) goto L8;
        int r104 = r103.hashCode();
    L10:
        return r102 + r104;
    L8:
        r104 = 0;
        goto L10
    }

    public final String toString() {
        return "ReplayDanmakuEmojiPanelProviderParam(isVertical=" + this.f533718a + ", keyboardHeight=" + this.f533719b + ", emojiPanelType=" + this.f533720c + ", emojiPanelSwitcher=" + this.f533721d + ")";
    }

    public d() {
        this(false, 0, 2, BehaviorSubject.create());
    }

    public d(boolean r100, int r101, int r102, BehaviorSubject<String> r103) {
        this.f533718a = r100;
        this.f533719b = r101;
        this.f533720c = r102;
        this.f533721d = r103;
    }
}
