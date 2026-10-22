package com.bytedance.ee.bear.widgets.universedesign;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.ee.bear.drive.view.preview.permission.EncryptData;
import com.bytedance.ee.bear.drive.view.preview.puretext.PureTextView;
import mp5.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceTextView extends AppCompatTextView {
    public static final /* synthetic */ int c = 0;
    public a a;
    public b b;

    public interface a {
    }

    public interface b {
    }

    public SpaceTextView(Context r1) {
        super(r1);
        this.a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onTextContextMenuItem(int r5) {
        if (r5 != 16908321) goto L5;
    L10:
        com.bytedance.ee.bear.drive.view.preview.puretext.a r0 = this.a;
        if (r0 == null) goto L31;
        PureTextView.b r1 = r0.a;
        r1.getClass();
        EncryptData r3 = r1.b.h;     // Catch: Throwable -> L20
        if (r3 != null) goto L16;
    L18:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L20
    L33:
    L26:
        PureTextView r2 = this.b;
        if (r2 == null) goto L30;
        r2.f(r5);
    L30:
        return super/*android.widget.TextView*/.onTextContextMenuItem(r5);
    L16:
        if (r3.isBlock() == false) goto L18;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).j(r1.b.h.getEncryptId());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        tt5.a.e("PureTextView", "security", th, false);
        goto L26
    L31:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        tt5.a.e("SpaceTextView", "security", th, false);
        goto L26
    L5:
        if (r5 == 16908320) goto L10;
        if (r5 == 16908322) goto L10;
        if (r5 != 16908337) goto L26;
        goto L10
    }

    public void setCopyCallback(a r1) {
        this.a = r1;
    }

    public void setOnTextContextMenuItemClickListener(b r1) {
        this.b = r1;
    }

    public SpaceTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode startActionMode(ActionMode.Callback r2, int r3) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).q(super/*android.widget.TextView*/.startActionMode(r2, r3), new c());
    }

    public SpaceTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = null;
    }
}
