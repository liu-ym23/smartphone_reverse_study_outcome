package com.bytedance.badger.utils;

import com.bytedance.badger.monitor.CollectStage;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.bytedance.badger.utils.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C10462c extends RuntimeException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f199227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f199228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final CollectStage f199229c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f199230d;

    public C10462c(String r100, int r101, CollectStage r102, String r103) {
        super("errorMessage: " + r100 + ", errorCode: " + r101 + ", stage: " + r102);
        this.f199227a = r100;
        this.f199228b = r101;
        this.f199229c = r102;
        this.f199230d = r103;
    }

    public /* synthetic */ C10462c(String r100, int r101, CollectStage r102, String r103, int r104) {
        if ((r104 & 2) == 0) goto L6;
        r101 = -1;
    L6:
        if ((r104 & 4) == 0) goto L8;
        r102 = CollectStage.collect_pre;
    L8:
        this(r100, r101, r102, null);
    }

    public final String a() {
        return this.f199230d;
    }

    public final CollectStage b() {
        return this.f199229c;
    }

    public final int c() {
        return this.f199228b;
    }

    public final String d() {
        return this.f199227a;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L5;
    L19:
        return true;
    L5:
        if ((r100 instanceof C10462c) == false) goto L18;
        C10462c r101 = (C10462c) r100;
        if (Intrinsics.areEqual(this.f199227a, r101.f199227a) == false) goto L18;
        if (this.f199228b != r101.f199228b) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L18;
        if (Intrinsics.areEqual(this.f199229c, r101.f199229c) == false) goto L18;
        if (Intrinsics.areEqual(this.f199230d, r101.f199230d) == false) goto L18;
    L11:
        r102 = false;
    L18:
        return false;
    }

    public int hashCode() {
        String r100 = this.f199227a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = ((r102 * 31) + this.f199228b) * 31;
        CollectStage r104 = this.f199229c;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f199230d;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "BadgerException(errorMessage=" + this.f199227a + ", errorCode=" + this.f199228b + ", collectStage=" + this.f199229c + ", collectErrorMsg=" + this.f199230d + ")";
    }
}
