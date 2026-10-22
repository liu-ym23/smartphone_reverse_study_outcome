package com.larus.audio.call;

import com.larus.im.internal.audio.u;
import com.larus.im.internal.utils.x;
import com.larus.im.service.audio.autotest.SaveEncodeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SaveEncodeType f289156a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f289157b;

    public final void a() {
        if (c78.a.f22663g.getBoolean("keva_rtc_video_dump_enable", false) == true) goto L5;
        return;
    L5:
        int r100 = com.larus.im.a.f346406a;
        gd9.o r101 = com.larus.im.internal.d.f347913a;
        u.f347501c.getClass();
        x r102 = x.f350563a;
        com.larus.audio.call.util.e.f289645a.i(this.f289157b, "[start]: dumper: null, with saveEncodeType: " + this.f289156a);
    }

    public final void b(com.larus.im.service.audio.u r100) {
        if (c78.a.f22663g.getBoolean("keva_rtc_video_dump_enable", false) == true) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        com.larus.audio.call.util.e.f289645a.d(this.f289157b, "[startSavingFile] frame: " + r100);
    }

    public l(boolean r100, SaveEncodeType r101, String r102) {
        Intrinsics.checkNotNullParameter(r101, "saveEncodeType");
        Intrinsics.checkNotNullParameter(r102, "scene");
        this.f289156a = r101;
        this.f289157b = "RawVideoFileSaver_" + r102 + '_' + hashCode();
    }
}
