package com.ss.android.lark.keyboard.edittext2.edittors.anchor.v2;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i extends CharacterStyle implements com.ss.android.lark.keyboard.edittext2.widget.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f429027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f429028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f429029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f429030d;

    public final Context getContext() {
        return this.f429027a;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint r100) {
        if (r100 == null) goto L5;
        r100.setColor(this.f429030d);
        return;
    }

    public i(Context r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "content");
        this.f429027a = r100;
        this.f429028b = r101;
        this.f429029c = r102;
        if (r100 == null) goto L5;
        int r103 = UIUtils.getColor(r100, R.color.text_link_normal);
    L6:
        this.f429030d = r103;
        return;
    L5:
        r103 = UIHelper.getColor(R.color.text_link_normal);
        goto L6
    }
}
