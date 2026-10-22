package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class t0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f334011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f334012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f334013e;

    public t0() {
        this(false, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof t0) == true) goto L8;
        return false;
    L8:
        t0 r101 = (t0) r100;
        if (Intrinsics.areEqual(this.f334009a, r101.f334009a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334010b, r101.f334010b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f334011c, r101.f334011c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f334012d, r101.f334012d) == true) goto L21;
        return false;
    L21:
        if (this.f334013e == r101.f334013e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f334009a.hashCode() * 31) + this.f334010b.hashCode()) * 31) + this.f334011c.hashCode()) * 31) + this.f334012d.hashCode()) * 31;
        if (this.f334013e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementRecordMinutesItem(id=" + this.f334009a + ", title=" + this.f334010b + ", description=" + this.f334011c + ", buttonText=" + this.f334012d + ", isConnected=" + this.f334013e + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f334009a;
    }

    public t0(boolean r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        String r103 = "DoraGDeviceManagementRecordMinutesItem";
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_g_device_record_audio_cn);
    L11:
        if ((r101 & 4) == 0) goto L13;
        String r106 = "你也可以通过语音“豆包豆包，开始录音“";
    L15:
        if ((r101 & 8) == 0) goto L18;
        int r107 = com.larus.utils.j0.f375426a;
        r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_start_record_cn);
    L18:
        if ((r101 & 16) == 0) goto L20;
        r100 = false;
    L20:
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r106, "description");
        Intrinsics.checkNotNullParameter(r102, "buttonText");
        this.f334009a = r103;
        this.f334010b = r105;
        this.f334011c = r106;
        this.f334012d = r102;
        this.f334013e = r100;
        return;
    L13:
        r106 = null;
        goto L15
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }
}
