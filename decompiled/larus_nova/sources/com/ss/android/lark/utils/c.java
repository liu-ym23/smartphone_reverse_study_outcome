package com.ss.android.lark.utils;

import android.content.Context;
import com.ss.android.lark.permission.StoragePermissionUtils;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements h.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.c f444700a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f444701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String[] f444702c;

    @Override // com.ss.android.lark.utils.h.e
    public final void a(boolean r100) {
        this.f444700a.b(new StoragePermissionUtils.c(this.f444701b, this.f444702c));
    }

    public c(h.c r100, Context r101, String[] r102) {
        this.f444700a = r100;
        this.f444701b = r101;
        this.f444702c = r102;
    }
}
