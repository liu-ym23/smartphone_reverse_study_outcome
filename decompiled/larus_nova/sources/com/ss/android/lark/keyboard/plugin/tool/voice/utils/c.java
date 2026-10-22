package com.ss.android.lark.keyboard.plugin.tool.voice.utils;

import com.ss.android.lark.keyboard.edittext2.edittors.richText.d;
import com.ss.android.lark.keyboard.edittext2.widget.RichTextFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;

/* JADX INFO: loaded from: classes36.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f430828a = 0;

    static {
    }

    public static String a(RichTextFunctionEditText r100) {
        KeyboardVoiceFGUtils r101 = KeyboardVoiceFGUtils.f429815a;
        if (((Boolean) KeyboardVoiceFGUtils.f429816b.getValue()).booleanValue() == false) goto L6;
        if (r100 == null) goto L6;
        return ((d) r100.q(d.f429100g)).m(0, r100.getEditableText().length());
    L6:
        return null;
    }
}
