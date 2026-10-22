package com.bytedance.ies.xelement.text.emoji;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.lynx.tasm.behavior.LynxContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f250386a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f250387b;

    static {
        f250386a = PatternProtector.compile("(\\[)([^\\[\\]]+)(])");
    }

    public static CharSequence a(LynxContext r100, CharSequence r101, int r110) {
        d r102 = d.f250380b;
        d r103 = d.a.a();
        Matcher r104 = f250386a.matcher(r101);
        SpannableString r105 = new SpannableString(r101);
    L4:
        if (r104.find() == false) goto L8;
        int r106 = r104.start();
        int r107 = r104.end();
        String r108 = r104.group();
        Drawable r109 = r103.a(r100, r108);
        if (r109 == null) goto L4;
        r109.setBounds(0, 0, (int) ((r110 * ((r109.getIntrinsicWidth() + 0.0f) / r109.getIntrinsicHeight())) + 0.5f), r110);
        r105.setSpan(new e(r109, Integer.valueOf(r107 - r106), r108), r106, r107, 33);
        goto L4
    L8:
        return r105;
    }
}
