package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class d implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f430374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f430375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public l f430376c;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public boolean b() {
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final String getString() {
        return a(this.f430375b);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final l c() {
        return this.f430376c;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final int getState() {
        return this.f430375b;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final String a(int r100) {
        switch(r100) {
            case 0: goto L11;
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        String r101 = "unknownState";
    L13:
        return "[ImmersiveVoiceState]".concat(r101);
    L5:
        r101 = "RecognizingAfterSwitchLanguage";
        goto L13
    L6:
        r101 = "AsrResultState";
        goto L13
    L7:
        r101 = "CancelingState";
        goto L13
    L8:
        r101 = "RecognizingState";
        goto L13
    L9:
        r101 = "RecordingState";
        goto L13
    L10:
        r101 = "RecordPreparingState";
        goto L13
    L11:
        r101 = "IdleState";
        goto L13
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.l
    public final void d(l r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f430376c = r100;
    }

    public d(Object r100, int r101) {
        this.f430374a = r100;
        this.f430375b = r101;
    }
}
