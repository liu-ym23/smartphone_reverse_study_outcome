package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements IVoiceFaceDependency {
    public c() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "faceTag");
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency
    public final void c() {
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency
    public final DefaultEmojiPanelData a() {
        return k2c.a.a().a();
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency
    public final void e() {
        k2c.a.a().md(true);
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency
    public final IVoiceFaceDependency.EmojiScene d() {
        return IVoiceFaceDependency.EmojiScene.IM;
    }
}
