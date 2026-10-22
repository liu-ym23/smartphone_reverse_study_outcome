package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AudioKBPlugin f429936a;

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final CharSequence b() {
        if (this.f429936a.K() == false) goto L7;
        KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null);
        return "";
    L7:
        return "";
    }

    public e(AudioKBPlugin r100) {
        this.f429936a = r100;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.i
    public final void a(CharSequence r100) {
        if (KeyboardVoiceFGUtils.a("im.messenger.advance_mode_refactor", null) == false) goto L5;
        this.f429936a.getClass();
        return;
    L5:
        this.f429936a.getClass();
    }
}
