package com.larus.bmhome.chat.markdown.richtext;

import android.text.Spanned;
import android.widget.TextView;
import com.larus.nova.R;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b extends lsc.a {
    public b() {
    }

    @Override // lsc.a, lsc.j
    public final void G4(TextView r100) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Object r101 = r100.getTag(R.id.larus_mention_avatar_binding);
        List r102 = null;
        if ((r101 instanceof AvatarBinding) == false) goto L5;
        AvatarBinding r103 = (AvatarBinding) r101;
    L6:
        if (r103 == null) goto L8;
        r103.a();
        r100.removeOnAttachStateChangeListener(r103);
    L8:
        r100.setTag(R.id.larus_mention_avatar_binding, null);
        CharSequence r104 = r100.getText();
        if ((r104 instanceof Spanned) == false) goto L11;
        Spanned r105 = (Spanned) r104;
    L12:
        if (r105 == null) goto L14;
        r102 = fh8.o.c(r105, d.class);
    L14:
        if (r102 != null) goto L17;
        r102 = CollectionsKt.emptyList();
    L17:
        if (r102.isEmpty() == false) goto L19;
        return;
    L19:
        AvatarBinding r106 = new AvatarBinding(r100, r102);
        r100.setTag(R.id.larus_mention_avatar_binding, r106);
        r100.addOnAttachStateChangeListener(r106);
        if (r100.isAttachedToWindow() == false) goto L23;
        r106.b();
        return;
    L23:
        return;
    L11:
        r105 = null;
        goto L12
    L5:
        r103 = null;
        goto L6
    }
}
