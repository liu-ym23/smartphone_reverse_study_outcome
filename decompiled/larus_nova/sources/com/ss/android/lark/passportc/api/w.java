package com.ss.android.lark.passportc.api;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class w extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f438118c;

    @Override // com.ss.android.lark.passportc.api.z
    public final String a() {
        return this.f438118c;
    }

    public w(List r100) {
        Intrinsics.checkNotNullParameter(r100, "expectedBackgroundUserList");
        super(r100, false);
        this.f438118c = "OfflineForeground";
    }
}
