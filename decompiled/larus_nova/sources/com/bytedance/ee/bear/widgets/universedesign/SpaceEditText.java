package com.bytedance.ee.bear.widgets.universedesign;

import android.content.ClipData;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.supervisor.token.Token;
import com.larksuite.component.universe_design.edittext.UDEditText;
import com.larus.nova.R;
import kotlin.jvm.functions.Function1;
import mp5.b;

/* JADX INFO: loaded from: classes18.dex */
public class SpaceEditText extends UDEditText {
    public static final /* synthetic */ int P0 = 0;
    public a H0;
    public Function1<Boolean, Boolean> L0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public boolean f240349p0;

    public interface a {
        boolean a(int r100);
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

    public final boolean x() {
        int r100 = getSelectionStart();
        int r101 = getSelectionEnd();
        boolean r102 = true;
        if (r101 < r100) goto L10;
        int r103 = getText().length();
        if (r100 < 0) goto L10;
        if (r101 > r103) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        String r105 = getText().subSequence(r100, r101).toString();
        r102 = ((fu5.a) org.koin.java.a.a(fu5.a.class)).w(r105);
    L14:
        return y(r102);
    L10:
        r104 = false;
        goto L11
    }

    public SpaceEditText(Context r100) {
        this(r100, null);
    }

    public boolean A(ClipData r100) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).h(r100, new Token(getCopyToken()));
    }

    @Override // androidx.appcompat.widget.AppCompatEditText, android.widget.EditText, android.widget.TextView
    public boolean onTextContextMenuItem(int r100) {
        a r101 = this.H0;
        if (r101 == null) goto L8;
        if (r101.a(r100) == false) goto L8;
        return true;
    L8:
        if (r100 != 16908321) goto L10;
    L20:
        tt5.a.h("SpaceEditText", "copySecurityEnable:" + this.f240349p0);
        if (this.f240349p0 == false) goto L35;
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        tt5.a.e("SpaceEditText", AppConstants.API_HOST_SI_PREFIX, th, false);
    L35:
        return super.onTextContextMenuItem(r100);
    L28:
        e = move-exception;
        tt5.a.e("SpaceEditText", "onTextContextMenuItem error", e, false);
        return true;
    L10:
        if (r100 == 16908320) goto L20;
        if (r100 != 16908322) goto L15;
    L31:
        ((fu5.a) org.koin.java.a.a(fu5.a.class)).i();     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        tt5.a.e("SpaceEditText", AppConstants.API_HOST_SI_PREFIX, th, false);
        goto L35
    L15:
        if (r100 != 16908337) goto L35;
        goto L31
    }

    public void setCopySecurityEnable(boolean r100) {
        this.f240349p0 = r100;
    }

    public void setFilterMenuWhiteList(Function1<Boolean, Boolean> r100) {
        this.L0 = r100;
    }

    public void setInterceptor(a r100) {
        this.H0 = r100;
    }

    public boolean y(boolean r100) {
        Function1<Boolean, Boolean> r101 = this.L0;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.invoke(Boolean.valueOf(r100)).booleanValue();
    }

    public SpaceEditText(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    @Override // android.view.View
    public final ActionMode startActionMode(ActionMode.Callback r100, int r101) {
        return ((fu5.a) org.koin.java.a.a(fu5.a.class)).q(super.startActionMode(r100, r101), new mp5.a(this));
    }

    public SpaceEditText(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102, R.style.SpaceEditTextStyle);
        this.f240349p0 = true;
        if (((fu5.a) org.koin.java.a.a(fu5.a.class)).s() == false) goto L6;
        setCustomSelectionActionModeCallback(((fu5.a) org.koin.java.a.a(fu5.a.class)).t(new b(this)));
        return;
    }
}
