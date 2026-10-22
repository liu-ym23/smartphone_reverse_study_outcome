package com.bytedance.salamander.anniex;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i8<VALUE> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f268128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ValidateResultCode f268129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f268130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final VALUE f268131d;

    public final long a() {
        return this.f268129b.getValue();
    }

    public final VALUE b() {
        if (this.f268128a == true) goto L7;
        return null;
    L7:
        return this.f268131d;
    }

    public final boolean c() {
        if (this.f268129b != ValidateResultCode.Invalid_input) goto L5;
        return true;
    L5:
        return false;
    }

    public i8(ValidateResultCode r100, int r101) {
        Intrinsics.checkNotNullParameter("validate failed and the field is discarded", "reason");
        Intrinsics.checkNotNullParameter(r100, "code");
        this.f268129b = ValidateResultCode.Fail;
        this.f268128a = false;
        this.f268129b = r100;
        this.f268130c = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i8(String r100, ValidateResultCode r101, Object r102) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r101, "code");
        this.f268129b = ValidateResultCode.Fail;
        this.f268128a = true;
        this.f268129b = r101;
        this.f268131d = r102;
    }

    public i8(boolean r100, String r101, ValidateResultCode r102, int r103, VALUE r104) {
        Intrinsics.checkNotNullParameter(r101, "reason");
        Intrinsics.checkNotNullParameter(r102, "code");
        this.f268129b = ValidateResultCode.Fail;
        this.f268128a = r100;
        this.f268129b = r102;
        this.f268130c = r103;
        this.f268131d = r104;
    }
}
