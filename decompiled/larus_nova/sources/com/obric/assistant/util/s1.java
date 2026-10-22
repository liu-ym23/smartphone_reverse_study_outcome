package com.obric.assistant.util;

import com.larus.bmhome.view.ChatInputText;

/* JADX INFO: loaded from: classes33.dex */
public final class s1 implements ChatInputText.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ObricMentionHighlightHelper.a f393839a;

    public s1(ObricMentionHighlightHelper.a r100) {
        this.f393839a = r100;
    }

    @Override // com.larus.bmhome.view.ChatInputText.b
    public final boolean y9(int r100, int r101) {
        if (r100 <= 0) goto L7;
        if (r101 != 0) goto L7;
        if (this.f393839a.d() == false) goto L7;
        return true;
    L7:
        return false;
    }

    @Override // com.larus.bmhome.view.ChatInputText.b
    public final boolean z9(int r100, int r101) {
        if (r100 <= 0) goto L7;
        if (r101 != 0) goto L7;
        if (this.f393839a.d() == false) goto L7;
        return true;
    L7:
        return false;
    }
}
