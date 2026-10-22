package jca;

import com.larus.im.bean.message.block.OSearchEntityImage;
import com.larus.im.bean.message.block.OSearchEntityVideo;
import com.larus.im.bean.message.block.OSearchReferenceInCollection;
import kotlin.text.StringsKt;
import zda.c;

/* JADX INFO: loaded from: classes32.dex */
public final class a {
    public static final OSearchReferenceInCollection a(c r110) {
        String r100 = r110.f571487a;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L10:
        if (r101 == false) goto L13;
        return null;
    L13:
        if (r110.f571492f == false) goto L15;
        OSearchReferenceInCollection r102 = new OSearchReferenceInCollection(null, new OSearchEntityVideo(r110.f571487a, r110.f571488b, r110.f571489c, r110.f571490d, r110.f571491e), 1, null);
    L17:
        return r102;
    L15:
        r102 = new OSearchReferenceInCollection(new OSearchEntityImage(r110.f571487a, r110.f571488b, r110.f571489c, r110.f571490d, r110.f571491e), null, 2, null);
        goto L17
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r101 = false;
        goto L10
    }
}
