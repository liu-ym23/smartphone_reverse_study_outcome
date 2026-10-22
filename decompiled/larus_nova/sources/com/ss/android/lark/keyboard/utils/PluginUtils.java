package com.ss.android.lark.keyboard.utils;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class PluginUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f430953a = null;

    static {
        f430953a = LazyKt.lazy(PluginUtils$tokenService$2.INSTANCE);
    }

    public static boolean c() {
        return ((com.ss.android.lark.passport.dpop.b) f430953a.getValue()).isDoubaoBUser();
    }

    public static int b() {
        if (c() == false) goto L5;
        return R.drawable.ic_send_btn_enterprise;
    L5:
        return R.drawable.ic_send_btn;
    }

    public static CharSequence a(CharSequence r100, TextPaint r101, float r102) {
        Intrinsics.checkNotNullParameter(r100, "hint");
        Intrinsics.checkNotNullParameter(r101, "paint");
        CharSequence r103 = TextUtils.ellipsize(r100, r101, r102, TextUtils.TruncateAt.END);
        Intrinsics.checkNotNull(r103);
        boolean r104 = true;
        if (r103.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L9;
        return r103;
    L9:
        if ((r100 instanceof Spanned) == true) goto L11;
    L17:
        r104 = false;
    L18:
        if (r104 == true) goto L20;
        return r103;
    L20:
        SpannableStringBuilder r106 = new SpannableStringBuilder(r103);
        r106.setSpan(new u6b.a(), 0, r106.length(), 17);
        return r106;
    L11:
        if (((Spanned) r100).getSpans(0, r100.length(), u6b.a.class).length != 0) goto L13;
        boolean r107 = true;
    L15:
        if ((!r107) == false) goto L17;
    L13:
        r107 = false;
        goto L15
    L5:
        r105 = false;
        goto L6
    }
}
