package com.larus.dora.impl.device.manage;

import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class u0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f334015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f334016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f334017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f334018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f334019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f334020f;

    public u0() {
        this(false, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof u0) == true) goto L8;
        return false;
    L8:
        u0 r101 = (u0) r100;
        if (Intrinsics.areEqual(this.f334015a, r101.f334015a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f334016b, r101.f334016b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f334017c, r101.f334017c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f334018d, r101.f334018d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f334019e, r101.f334019e) == true) goto L24;
        return false;
    L24:
        if (this.f334020f == r101.f334020f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((this.f334015a.hashCode() * 31) + this.f334016b.hashCode()) * 31) + this.f334017c.hashCode()) * 31) + this.f334018d.hashCode()) * 31) + this.f334019e.hashCode()) * 31;
        if (this.f334020f == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "DoraGDeviceManagementSimultaneousInterpretItem(id=" + this.f334015a + ", title=" + this.f334016b + ", sourceLang=" + this.f334017c + ", targetLang=" + this.f334018d + ", buttonText=" + this.f334019e + ", isConnected=" + this.f334020f + ')';
    }

    @Override // com.larus.dora.impl.device.manage.p0
    public final String getId() {
        return this.f334015a;
    }

    public u0(boolean r100, int r101) {
        String r102 = null;
        if ((r101 & 1) == 0) goto L5;
        String r103 = "DoraGDeviceManagementSimultaneousInterpretItem";
    L7:
        if ((r101 & 2) == 0) goto L9;
        int r104 = com.larus.utils.j0.f375426a;
        String r105 = com.larus.utils.j0.d(R.string.larus_dora_gesture_simultaneous_interpretation_cn);
    L11:
        if ((r101 & 4) == 0) goto L13;
        int r106 = com.larus.utils.j0.f375426a;
        String r107 = com.larus.utils.j0.d(R.string.larus_write_requirements_language_cn);
    L15:
        if ((r101 & 8) == 0) goto L17;
        int r108 = com.larus.utils.j0.f375426a;
        String r109 = com.larus.utils.j0.d(R.string.larus_dora_g_device_lang_english_cn);
    L19:
        if ((r101 & 16) == 0) goto L22;
        int r110 = com.larus.utils.j0.f375426a;
        r102 = com.larus.utils.j0.d(R.string.larus_dora_g_device_start_trans_cn);
    L22:
        if ((r101 & 32) == 0) goto L24;
        r100 = false;
    L24:
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r105, "title");
        Intrinsics.checkNotNullParameter(r107, "sourceLang");
        Intrinsics.checkNotNullParameter(r109, "targetLang");
        Intrinsics.checkNotNullParameter(r102, "buttonText");
        this.f334015a = r103;
        this.f334016b = r105;
        this.f334017c = r107;
        this.f334018d = r109;
        this.f334019e = r102;
        this.f334020f = r100;
        return;
    L17:
        r109 = null;
        goto L19
    L13:
        r107 = null;
        goto L15
    L9:
        r105 = null;
        goto L11
    L5:
        r103 = null;
        goto L7
    }
}
