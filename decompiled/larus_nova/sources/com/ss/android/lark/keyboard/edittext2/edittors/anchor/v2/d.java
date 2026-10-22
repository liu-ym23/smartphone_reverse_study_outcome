package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.widget.richtext.RichTextElement;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a {
    public d(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        super(r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a, fob.a
    public final /* bridge */ /* synthetic */ hob.b b(RichTextElement.AnchorProperty r100) {
        return c(r100);
    }

    @Override // com.ss.android.lark.keyboard.edittext2.edittors.anchor.urlinline.a
    public final hob.j c(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        hob.j r101 = super.c(r100);
        if (r100.getScene() != RichTextElement.AnchorProperty.Scene.COPY_PASTE_TEXT) goto L5;
        Map<String, Object> r102 = r101.f486306c;
        HashMap r103 = (HashMap) r102;
        r103.put("key::use::wide::character:regex", Boolean.TRUE);
    L5:
        return r101;
    }
}
