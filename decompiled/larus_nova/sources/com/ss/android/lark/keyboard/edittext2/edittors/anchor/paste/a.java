package com.ss.android.lark.keyboard.edittext2.edittors.anchor.paste;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.widget.richtext.RichTextElement;
import hob.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends fob.a<j> {
    public a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        super(r100);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        if (r100.getHref().length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
    L13:
        return false;
    L8:
        if (r100.getContent().length() <= 0) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L13;
        return true;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = false;
        goto L6
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        j r101 = new j(r100.getHref());
        String r102 = r100.getContent();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f486340e = r102;
        return r101;
    }
}
