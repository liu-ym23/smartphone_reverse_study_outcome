package com.bytedance.gamecenter.base.order;

import android.text.TextUtils;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f245020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f245021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f245022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f245023d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f245024e;

    /* JADX INFO: renamed from: com.bytedance.gamecenter.base.order.a$a, reason: collision with other inner class name */
    public static final class C3507a {
    }

    static {
    }

    public final String a() {
        if (TextUtils.isEmpty(this.f245020a) == false) goto L5;
        String r100 = b();
    L7:
        if (this.f245024e == OrderConstant$RESERVE_TYPE.ORDER_UPDATE.getType()) goto L9;
        return r100;
    L9:
        return r100 + Permission.READ + this.f245024e;
    L5:
        r100 = b() + this.f245020a;
        goto L7
    }

    public final String b() {
        return this.f245021b + this.f245023d;
    }

    public a() {
        this.f245020a = "";
        this.f245021b = "";
        this.f245023d = "";
        this.f245024e = OrderConstant$RESERVE_TYPE.ORDER_DOWNLOAD.getType();
    }
}
