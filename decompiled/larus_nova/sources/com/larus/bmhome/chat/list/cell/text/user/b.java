package com.larus.bmhome.chat.list.cell.text.user;

import android.graphics.drawable.Drawable;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f306446a = 0;

    static {
    }

    public static Drawable a(TextView r100, com.larus.bmhome.chat.markdown.richtext.r r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "resource");
        boolean r102 = r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.d;
        if (r102 == false) goto L5;
    L8:
        int r103 = r100.getCurrentTextColor();
    L9:
        if (r102 == false) goto L12;
        int r104 = R.drawable.larus_ic_skill_light;
    L15:
        Drawable r105 = ContextCompat.getDrawable(r100.getContext(), r104);
        if (r105 != null) goto L18;
        return null;
    L18:
        Drawable r106 = DrawableCompat.wrap(r105).mutate();
        DrawableCompat.setTint(r106, r103);
        return r106;
    L12:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == false) goto L14;
        r104 = R.drawable.larus_dbx_ic_squarechat;
        goto L15
    L14:
        r104 = R.drawable.larus_ic_mention_reference;
        goto L15
    L5:
        if ((r101 instanceof com.larus.bmhome.chat.markdown.richtext.r.b) == true) goto L8;
        r103 = -13405953;
        goto L9
    }
}
