package com.larus.bmhome.upload.sdk.impl.core;

import com.larus.bmhome.upload.sdk.api.model.CancelReason;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import is8.j;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements gs8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Flow<j> f314859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<CancelReason, Boolean> f314860b;

    @Override // gs8.b
    public final Flow<j> a() {
        return this.f314859a;
    }

    @Override // gs8.b
    public final boolean b(CancelReason r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        return this.f314860b.invoke(r100).booleanValue();
    }

    public a(String r100, z0 r101, com.larus.bmhome.upload.sdk.impl.b r102) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        Intrinsics.checkNotNullParameter(r101, "states");
        Intrinsics.checkNotNullParameter(r102, "cancelAction");
        this.f314859a = r101;
        this.f314860b = r102;
    }
}
