package com.bytedance.applet.utils;

import com.larus.platform.api.g1;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.l1;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class h implements g1.c {
    public final /* synthetic */ d a;
    public final /* synthetic */ LocateScene b;
    public final /* synthetic */ JSONObject c;

    public final void onGoSettingsDialogDismiss(boolean r1) {
    }

    public final void onGoSettingsDialogShow() {
    }

    public final void onSettingPageReturn() {
    }

    public h(f r1, LocateScene r2, JSONObject r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void onResult(boolean r2, List<String> r3, List<String> r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "grantedList");
        Intrinsics.checkNotNullParameter(r4, "deniedList");
        if (r2 == true) goto L6;
        d.a.a(this.a, false, true, false, 4);
        return;
    L6:
        int r6 = i.a;
        LocateScene r7 = this.b;
        d r8 = this.a;
        JSONObject r9 = this.c;
        l1.a.f(r7, new g(r8), r9);
    }
}
