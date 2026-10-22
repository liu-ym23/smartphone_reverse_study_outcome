package com.larus.audio.asr;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f288486a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f288487b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f288488c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f288489d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f288490e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Boolean f288491f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k f288492g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y) == true) goto L8;
        return false;
    L8:
        y r101 = (y) r100;
        if (Intrinsics.areEqual(this.f288486a, r101.f288486a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f288487b, r101.f288487b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f288488c, r101.f288488c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f288489d, r101.f288489d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f288490e, r101.f288490e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f288491f, r101.f288491f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f288492g, r101.f288492g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f288486a.hashCode() * 31;
        String r101 = this.f288487b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        Boolean r105 = this.f288488c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Boolean r108 = this.f288489d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f288490e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Boolean r114 = this.f288491f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        k r117 = this.f288492g;
        if (r117 == null) goto L27;
        r102 = r117.hashCode();
    L27:
        return r116 + r102;
    L21:
        r115 = r114.hashCode();
        goto L22
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "AsrRequestExtraConfig(taskId=" + this.f288486a + ", itemId=" + this.f288487b + ", enableAsrTwoPass=" + this.f288488c + ", singleReturn=" + this.f288489d + ", asrTextPostProcessType=" + this.f288490e + ", enableBoxInputAsr=" + this.f288491f + ", asrContextConfig=" + this.f288492g + ')';
    }

    public y(String r100, Boolean r101, Boolean r102, String r103, k r104) {
        Intrinsics.checkNotNullParameter(r100, DBDefinition.TASK_ID);
        this.f288486a = r100;
        this.f288487b = null;
        this.f288488c = r101;
        this.f288489d = r102;
        this.f288490e = r103;
        this.f288491f = null;
        this.f288492g = r104;
    }
}
