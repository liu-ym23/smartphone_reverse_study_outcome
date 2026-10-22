package com.bytedance.ee.bear.widgets.universedesign;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.edittext.UDEditText;
import kotlin.jvm.functions.Function1;
import mp5.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SpaceEditText extends UDEditText {
    public static final /* synthetic */ int P0 = 0;
    public a H0;
    public Function1<Boolean, Boolean> L0;
    public boolean p0;

    public interface a {
        boolean a(int r1);
    }

    public String getCopyToken() {
        return "LARK-PSDA-ccm_android_space_edit_text_base_set_clipboard";
    }

    public String getPasteToken() {
        return "LARK-PSDA-ccm_android_space_edit_text_base_get_clipboard";
    }

    public ClipData getPrimaryClip() {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).l(new Token(getPasteToken()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean x() {
        int r0 = getSelectionStart();
        int r1 = getSelectionEnd();
        boolean r2 = true;
        if (r1 < r0) goto L10;
        int r3 = getText().length();
        if (r0 < 0) goto L10;
        if (r1 > r3) goto L10;
        boolean r4 = true;
    L11:
        if (r4 == false) goto L14;
        String r5 = getText().subSequence(r0, r1).toString();
        r2 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r5);
    L14:
        return y(r2);
    L10:
        r4 = false;
        goto L11
    }

    public SpaceEditText(Context r2) {
        this(r2, null);
    }

    public boolean A(ClipData r4) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).h(r4, new Token(getCopyToken()));
    }

    public boolean onTextContextMenuItem(int r7) {
        a r0 = this.H0;
        if (r0 == null) goto L8;
        if (r0.a(r7) == false) goto L8;
        return true;
    L8:
        if (r7 != 16908321) goto L10;
    L20:
        tt5.a.h("SpaceEditText", "copySecurityEnable:" + this.p0);
        if (this.p0 == false) goto L35;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        tt5.a.e("SpaceEditText", "security", th, false);
    L35:
        return super/*androidx.appcompat.widget.AppCompatEditText*/.onTextContextMenuItem(r7);
    L28:
        e = move-exception;
        tt5.a.e("SpaceEditText", "onTextContextMenuItem error", e, false);
        return true;
    L10:
        if (r7 == 16908320) goto L20;
        if (r7 != 16908322) goto L15;
    L31:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        tt5.a.e("SpaceEditText", "security", th, false);
        goto L35
    L15:
        if (r7 != 16908337) goto L35;
        goto L31
    }

    public void setCopySecurityEnable(boolean r1) {
        this.p0 = r1;
    }

    public void setFilterMenuWhiteList(Function1<Boolean, Boolean> r1) {
        this.L0 = r1;
    }

    public void setInterceptor(a r1) {
        this.H0 = r1;
    }

    public boolean y(boolean r2) {
        Function1<Boolean, Boolean> r0 = this.L0;
        if (r0 != null) goto L5;
        return false;
    L5:
        return ((Boolean) r0.invoke(Boolean.valueOf(r2))).booleanValue();
    }

    public SpaceEditText(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ActionMode startActionMode(ActionMode.Callback r2, int r3) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).q(super/*android.widget.EditText*/.startActionMode(r2, r3), new mp5.a(this));
    }

    public SpaceEditText(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4, 2131953439);
        this.p0 = true;
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L6;
        setCustomSelectionActionModeCallback(((fu5.a) org.koin.java.a.a(fu5.a.class)).t(new b(this)));
        return;
    }
}
