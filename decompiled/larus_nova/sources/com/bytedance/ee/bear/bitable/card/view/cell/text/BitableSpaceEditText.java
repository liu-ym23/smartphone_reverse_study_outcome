package com.bytedance.ee.bear.bitable.card.view.cell.text;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import hp4.v;

/* JADX INFO: loaded from: classes15.dex */
public class BitableSpaceEditText extends SpaceEditText {
    public v V0;

    public BitableSpaceEditText(Context r100) {
        this(r100, null);
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText, androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int r100) {
        if (r100 != 16908321) goto L5;
    L6:
        v r101 = this.V0;
        if (r101 != null) goto L9;
    L13:
        return super.onTextContextMenuItem(r100);
    L9:
        if (r101.S1(r100) == true) goto L13;
        return true;
    L5:
        if (r100 != 16908320) goto L13;
        goto L6
    }

    public void setPermissionCopyChecker(v r100) {
        this.V0 = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.universedesign.SpaceEditText
    public final boolean y(boolean r100) {
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).o() == true) goto L5;
        return true;
    L5:
        if (r100 == false) goto L11;
        v r101 = this.V0;
        if (r101 != null) goto L9;
        return true;
    L9:
        if (r101.canCopy() == true) goto L11;
        return true;
    L11:
        return false;
    }

    public BitableSpaceEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public BitableSpaceEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
    }
}
