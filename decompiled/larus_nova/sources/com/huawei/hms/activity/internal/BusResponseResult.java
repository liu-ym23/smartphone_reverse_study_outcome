package com.huawei.hms.activity.internal;

import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class BusResponseResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Intent f276860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f276861b;

    public BusResponseResult() {
    }

    public int getCode() {
        return this.f276861b;
    }

    public Intent getIntent() {
        return this.f276860a;
    }

    public void setCode(int r100) {
        this.f276861b = r100;
    }

    public void setIntent(Intent r100) {
        this.f276860a = r100;
    }
}
