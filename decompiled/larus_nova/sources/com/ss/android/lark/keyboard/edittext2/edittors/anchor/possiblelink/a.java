package com.ss.android.lark.keyboard.edittext2.edittors.anchor.possiblelink;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.h;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends fob.a<h> {
    public a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        super(r100);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (r100.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return new h(r100.getHref());
    }
}
