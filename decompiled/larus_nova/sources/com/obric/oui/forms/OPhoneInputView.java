package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB'\b\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tJ\u0010\u0010\r\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0014\u001a\u00020\t¨\u0006\u001d"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputView;", "Lcom/obric/oui/forms/OInputView;", "", "getContentViewRes", "", "getText", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "", "setLimitCount", "", "show", "setShowAreaCode", "s", "setAreaCode", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OPhoneInputView extends OInputView {
    public boolean H0;
    public boolean L0;
    public boolean P0;
    public String V0;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public final LinearLayout f401005b1;

    /* JADX INFO: renamed from: g1, reason: collision with root package name */
    public final TextView f401006g1;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final ImageView f401007h1;

    /* JADX INFO: renamed from: k1, reason: collision with root package name */
    public boolean f401008k1;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f401009p0;

    public static final class a {
    }

    static {
    }

    public OPhoneInputView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPhoneInputView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.forms.OInputView
    public int getContentViewRes() {
        return R.layout.o_phone_input_view_layout;
    }

    @Override // com.obric.oui.forms.OInputView
    public String getText() {
        if (this.H0 == false) goto L13;
        Editable r100 = getVInput().getText();
        if (r100 == null) goto L14;
        String r101 = r100.toString();
        if (r101 != null) goto L11;
        return null;
    L11:
        return StringsKt.replace$default(r101, " ", "", false, 4, null);
    L14:
        return null;
    L13:
        return super.getText();
    }

    public final boolean o6() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.P0 == false) goto L13;
        String r100 = this.V0;
        if (r100 != null) goto L9;
        String r101 = null;
    L11:
        if (Intrinsics.areEqual(r101, "+86") == false) goto L13;
        return true;
    L9:
        r101 = StringsKt.trim(r100).toString();
        goto L11
    }

    public final String getAreaCode() {
        return this.V0;
    }

    public final boolean getEnableArrowIcon() {
        return this.f401008k1;
    }

    @Override // com.obric.oui.forms.OInputView
    public final void T5(Editable r110) {
        if (o6() == false) goto L56;
        setLimitCountValue(11);
        if (r110 != null) goto L7;
        r110 = getVInput().getText();
    L7:
        if (r110 != null) goto L10;
    L54:
        this.H0 = true;
        this.f401009p0 = getLimitCount();
    L69:
        Editable r111 = getVInput().getText();
        if (r111 != null) goto L72;
        String r112 = null;
    L73:
        n6(r112);
        return;
    L72:
        r112 = r111.toString();
        goto L73
    L10:
        if (this.L0 == true) goto L54;
        String r100 = r110.toString();
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L13:
        if (r103 >= r102) goto L18;
        char r104 = r100.charAt(r103);
        if (Character.isDigit(r104) == false) goto L17;
        r101.append(r104);
    L17:
        r103 = r103 + 1;
        goto L13
    L18:
        String r105 = r101.toString();
        StringBuilder r106 = new StringBuilder();
        int r107 = 0;
        int r108 = 0;
    L20:
        if (r107 >= r105.length()) goto L29;
        int r113 = r108 + 1;
        r106.append(r105.charAt(r107));
        if (r108 == 2) goto L26;
        if (r108 == 6) goto L26;
    L28:
        r107 = r107 + 1;
        r108 = r113;
    L26:
        if (r108 == StringsKt.getLastIndex(r105)) goto L28;
        r106.append(' ');
        goto L28
    L29:
        String r109 = r106.toString();
        if (Intrinsics.areEqual(r109, r100) == true) goto L54;
        this.L0 = true;
        r110.replace(0, r110.length(), r109);
        if (this.H0 == true) goto L75;
    L53:
        this.L0 = false;
        goto L54
    L75:
        Iterator r114 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L51
    L36:
        if (r114.hasNext() == false) goto L53;
        int r115 = ((Number) r114.next()).intValue();     // Catch: Exception -> L51
        int r116 = r115 + 1;     // Catch: Exception -> L51
        if (r100.length() < r115) goto L36;
        if (r109.length() < r115) goto L36;
        if (r100.charAt(r115) == ' ') goto L36;
        if (r109.charAt(r115) != ' ') goto L36;
        if (getVInput().getSelectionStart() != r116) goto L36;
        if (getVInput().getSelectionEnd() != r116) goto L36;
        getVInput().setSelection(r116 + 1);     // Catch: Exception -> L51
    L51:
        e = move-exception;
        wma.b.h("OInputView", Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L53
    L56:
        if (this.H0 == false) goto L69;
        if (r110 != null) goto L59;
        r110 = getVInput().getText();
    L59:
        if (r110 != null) goto L62;
    L68:
        this.H0 = false;
        setLimitCountValue(this.f401009p0);
        goto L69
    L62:
        if (this.L0 == true) goto L68;
        String r117 = r110.toString();
        String r118 = StringsKt.replace$default(r117, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r118, r117) == true) goto L68;
        this.L0 = true;
        r110.replace(0, r110.length(), r118);
        this.L0 = false;
        goto L68
    }

    @Override // com.obric.oui.forms.OInputView
    public final int U5(CharSequence r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.H0 == false) goto L8;
    L11:
        int r102 = 0;
    L13:
        if (r101 >= r100.length()) goto L19;
        if (Character.isDigit(r100.charAt(r101)) == false) goto L17;
        r102 = r102 + 1;
    L17:
        r101 = r101 + 1;
        goto L13
    L19:
        return r102;
    L8:
        if (o6() == true) goto L11;
        return r100.length();
    }

    public final void setAreaClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f401005b1.setOnClickListener(r100);
    }

    public final void setAreaCode(String r100) {
        if (r100 == null) goto L19;
        String r101 = this.V0;
        int r102 = 0;
        if (r101 != null) goto L6;
    L8:
        this.V0 = r100;
        this.f401006g1.setText(r100);
        T5(getVInput().getText());
        Editable r103 = getVInput().getText();
        if (r103 == null) goto L17;
        r102 = r103.length();
    L17:
        getVInput().setSelection(r102);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        wma.b.h("OInputView", Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L6:
        if (StringsKt.equals$default(r101, r100, false, 2, null) == false) goto L8;
        return;
    }

    public final void setEnableArrowIcon(boolean r100) {
        if (this.f401008k1 != r100) goto L5;
        return;
    L5:
        this.f401008k1 = r100;
        ImageView r101 = this.f401007h1;
        if (r101 == null) goto L12;
        if (r100 == false) goto L9;
        float r102 = 1.0f;
    L10:
        r101.setAlpha(r102);
        return;
    L9:
        r102 = 0.3f;
        goto L10
    }

    @Override // com.obric.oui.forms.OInputView
    public void setLimitCount(int r100) {
        this.f401009p0 = r100;
        if (this.H0 == false) goto L5;
        r100 = 11;
    L5:
        super.setLimitCount(r100);
    }

    public final void setShowAreaCode(boolean r100) {
        if (getInputType() == 3) goto L6;
        return;
    L6:
        if (this.P0 != r100) goto L8;
        return;
    L8:
        this.P0 = r100;
        pla.j.h(this.f401005b1, r100);
        T5(getVInput().getText());
    }

    public OPhoneInputView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f401009p0 = -1;
        this.f401008k1 = true;
        this.f401009p0 = getLimitCount();
        this.f401005b1 = (LinearLayout) findViewById(R.id.o_input_area_code_container);
        this.f401006g1 = (TextView) findViewById(R.id.o_input_area_code_text);
        this.f401007h1 = (ImageView) findViewById(R.id.o_input_area_code_arrow);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oui_areaCode, R.attr.oui_showAreaCode}, r102, 0);
        setShowAreaCode(r103.getBoolean(1, false));
        setAreaCode(r103.getString(0));
        r103.recycle();
    }

    public /* synthetic */ OPhoneInputView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
