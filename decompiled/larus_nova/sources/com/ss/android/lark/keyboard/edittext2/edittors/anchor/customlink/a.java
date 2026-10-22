package com.ss.android.lark.keyboard.edittext2.edittors.anchor.customlink;

import com.facebook.keyframes.model.KFAnimation;
import com.ss.android.lark.widget.richtext.RichTextElement;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends fob.a<hob.a> {
    public a(eob.a r100) {
        Intrinsics.checkNotNullParameter(r100, "editor");
        super(r100);
    }

    @Override // fob.a
    public final boolean a(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        return r100.isCustom();
    }

    @Override // fob.a
    public final hob.b b(RichTextElement.AnchorProperty r100) {
        Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
        String r101 = r100.getDisplayTitle();
        boolean r102 = true;
        if (r101 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        String r104 = r100.getDisplayTitle();
    L20:
        String r105 = r100.getHref();
        Intrinsics.checkNotNull(r104);
        return new hob.a(r105, r104);
    L11:
        String r106 = r100.getContent();
        if (r106 != null) goto L14;
    L17:
        if (r102 == true) goto L19;
        r104 = r100.getContent();
        goto L20
    L19:
        r104 = r100.getHref();
        goto L20
    L14:
        if (r106.length() == 0) goto L17;
        r102 = false;
        goto L17
    L5:
        if (r101.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
