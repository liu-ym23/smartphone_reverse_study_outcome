package com.obric.assistant.voice;

import android.content.ComponentName;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class j implements lha.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricVoiceServiceImpl f394379a;

    @Override // lha.g
    public final void onTaskCreated(int r100, ComponentName r101) {
    }

    public j(ObricVoiceServiceImpl r100) {
        this.f394379a = r100;
    }

    @Override // lha.g
    public final void onChange(ComponentName r100, ComponentName r101) {
        FLogger r102 = FLogger.f375446a;
        r102.i(this.f394379a.f394366b, "onChange fromTopActivity: " + r100 + ", toTopActivity: " + r101);
        String r103 = null;
        if (r101 == null) goto L5;
        String r104 = r101.getClassName();
    L7:
        if (Intrinsics.areEqual(r104, this.f394379a.f394367c) == false) goto L9;
        r102.i(this.f394379a.f394366b, "go to fingerprint, disable the voice wakeup");
        this.f394379a.i(true);
        return;
    L9:
        if (r100 == null) goto L12;
        r103 = r100.getClassName();
    L12:
        if (Intrinsics.areEqual(r103, this.f394379a.f394367c) == false) goto L16;
        r102.i(this.f394379a.f394366b, "not in fingerprint, enable the voice wakeup");
        this.f394379a.i(false);
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L7
    }
}
