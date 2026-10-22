package com.ss.android.lark.widget;

import android.content.Context;
import android.text.TextWatcher;
import android.util.AttributeSet;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public class ExtendedEditText extends SCEditText {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<TextWatcher> f445617b;

    public ExtendedEditText(Context r100) {
        super(r100);
        this.f445617b = null;
    }

    @Override // android.widget.TextView
    public final void addTextChangedListener(TextWatcher r100) {
        if (this.f445617b != null) goto L5;
        this.f445617b = new ArrayList();
    L5:
        this.f445617b.add(r100);
        super.addTextChangedListener(r100);
    }

    @Override // android.widget.TextView
    public final void removeTextChangedListener(TextWatcher r100) {
        ArrayList<TextWatcher> r101 = this.f445617b;
        if (r101 == null) goto L7;
        int r102 = r101.indexOf(r100);
        if (r102 < 0) goto L7;
        ListProtector.remove(this.f445617b, r102);
    L7:
        super.removeTextChangedListener(r100);
    }

    public ExtendedEditText(Context r100, AttributeSet r101) {
        super(r100, r101);
        this.f445617b = null;
    }

    public ExtendedEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f445617b = null;
    }
}
