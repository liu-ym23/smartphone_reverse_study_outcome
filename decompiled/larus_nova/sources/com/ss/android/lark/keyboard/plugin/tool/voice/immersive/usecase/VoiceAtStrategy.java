package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceModule;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class VoiceAtStrategy extends com.ss.android.lark.keyboard.edittext2.edittors.at.common.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f430439c;

    public static final class a extends ClickableSpan {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f430440a;

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r100) {
            Intrinsics.checkNotNullParameter(r100, "ds");
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f430440a = r100;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r100) {
            Intrinsics.checkNotNullParameter(r100, "widget");
            if (Intrinsics.areEqual(this.f430440a, "all") == false) goto L5;
            return;
        L5:
            Context r101 = r100.getContext();
            KeyboardVoiceModule.c r102 = KeyboardVoiceModule.a().getProfileDependency();
            Intrinsics.checkNotNull(r101);
            r102.a(r101, this.f430440a);
            r100.clearFocus();
        }
    }

    public static final class b {
    }

    static {
    }

    public VoiceAtStrategy() {
        this.f430439c = LazyKt.lazy(new VoiceAtStrategy$enableForceHighlight$2(this));
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.at.common.b, com.ss.android.lark.keyboard.edittext2.edittors.at.c
    public final com.ss.android.lark.keyboard.edittext2.edittors.at.a<hob.c> c(final com.ss.android.lark.keyboard.edittext2.edittors.a r100, final hob.c r101) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        Intrinsics.checkNotNullParameter(r101, "data");
        return new VoiceAtStrategy$prepareAtSpanHolder$1(r100, r101, this);
    }
}
