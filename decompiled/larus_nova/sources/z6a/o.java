package z6a;

import android.os.Build;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* JADX INFO: loaded from: classes32.dex */
public final class o extends CharacterStyle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.tasm.behavior.ui.g f570605a;

    public o(com.lynx.tasm.behavior.ui.g r100) {
        this.f570605a = r100;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        float r101 = this.f570605a.f382530d;
        if (Build.VERSION.SDK_INT > 23) goto L5;
        r101 = Math.min(Math.max(0.0f, r101), 25.0f);
    L5:
        com.lynx.tasm.behavior.ui.g r102 = this.f570605a;
        r100.setShadowLayer(r101, r102.f382528b, r102.f382529c, r102.f382527a);
    }
}
