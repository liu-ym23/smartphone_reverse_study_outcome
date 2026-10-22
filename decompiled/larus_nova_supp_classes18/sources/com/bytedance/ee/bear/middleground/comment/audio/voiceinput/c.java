package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import com.ss.android.lark.keyboard.plugin.tool.voice.dependency.IVoiceFaceDependency;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements IVoiceFaceDependency {
    public c() {
    }

    public final void b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "faceTag");
    }

    public final void c() {
    }

    public final DefaultEmojiPanelData a() {
        return k2c.a.a().a();
    }

    public final void e() {
        k2c.a.a().md(true);
    }

    public final IVoiceFaceDependency.EmojiScene d() {
        return IVoiceFaceDependency.EmojiScene.IM;
    }
}
