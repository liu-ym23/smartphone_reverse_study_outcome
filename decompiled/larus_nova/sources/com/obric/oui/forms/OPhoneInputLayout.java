package com.obric.oui.forms;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u001eB'\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\b\u0010\u000f\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013¨\u0006\u001f"}, d2 = {"Lcom/obric/oui/forms/OPhoneInputLayout;", "Lcom/obric/oui/forms/OInputLayout;", "", "type", "", "setType", "resId", "setCustomStart", "defaultStart", "setDefaultCustomStart", "", "getText", "", "s", "setAreaCode", "getAreaCode", "Landroid/view/View$OnClickListener;", "listener", "setAreaClickListener", "", "enableArrow", "setEnableArrowIcon", "getEnableArrowIcon", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OPhoneInputLayout extends OInputLayout {
    public boolean D;
    public boolean E;
    public boolean F;
    public String G;
    public final LinearLayout H;
    public final TextView I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final ImageView f401004J;
    public boolean K;

    public static final class a {
    }

    static {
    }

    public OPhoneInputLayout(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public OPhoneInputLayout(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public CharSequence getText() {
        if (this.D == false) goto L13;
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

    public final boolean n() {
        if ((getInputType() & 15) == 3) goto L5;
    L13:
        return false;
    L5:
        if (this.F == false) goto L13;
        String r100 = this.G;
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
        return this.G;
    }

    public final boolean getEnableArrowIcon() {
        return this.K;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final void a(Editable r110) {
        if (n() == false) goto L55;
        if (r110 != null) goto L6;
        r110 = getVInput().getText();
    L6:
        if (r110 != null) goto L9;
    L53:
        this.D = true;
        return;
    L9:
        if (this.E == true) goto L53;
        String r100 = r110.toString();
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length();
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L17;
        char r104 = r100.charAt(r103);
        if (Character.isDigit(r104) == false) goto L16;
        r101.append(r104);
    L16:
        r103 = r103 + 1;
        goto L12
    L17:
        String r105 = r101.toString();
        StringBuilder r106 = new StringBuilder();
        int r107 = 0;
        int r108 = 0;
    L19:
        if (r107 >= r105.length()) goto L28;
        int r111 = r108 + 1;
        r106.append(r105.charAt(r107));
        if (r108 == 2) goto L25;
        if (r108 == 6) goto L25;
    L27:
        r107 = r107 + 1;
        r108 = r111;
    L25:
        if (r108 == StringsKt.getLastIndex(r105)) goto L27;
        r106.append(' ');
        goto L27
    L28:
        String r109 = r106.toString();
        if (Intrinsics.areEqual(r109, r100) == true) goto L53;
        this.E = true;
        r110.replace(0, r110.length(), r109);
        if (this.D == true) goto L69;
    L52:
        this.E = false;
        goto L53
    L69:
        Iterator r112 = CollectionsKt.listOf(new Integer[]{3, 8}).iterator();     // Catch: Exception -> L50
    L35:
        if (r112.hasNext() == false) goto L52;
        int r113 = ((Number) r112.next()).intValue();     // Catch: Exception -> L50
        int r114 = r113 + 1;     // Catch: Exception -> L50
        if (r100.length() < r113) goto L35;
        if (r109.length() < r113) goto L35;
        if (r100.charAt(r113) == ' ') goto L35;
        if (r109.charAt(r113) != ' ') goto L35;
        if (getVInput().getSelectionStart() != r114) goto L35;
        if (getVInput().getSelectionEnd() != r114) goto L35;
        getVInput().setSelection(r114 + 1);     // Catch: Exception -> L50
    L50:
        e = move-exception;
        wma.b.h("OInputLayout", Intrinsics.stringPlus("Failed to move cursor when formating: ", e.getMessage()));
        goto L52
    L55:
        if (this.D == false) goto L94;
        if (r110 != null) goto L58;
        r110 = getVInput().getText();
    L58:
        if (r110 != null) goto L61;
    L67:
        this.D = false;
        return;
    L61:
        if (this.E == true) goto L67;
        String r115 = r110.toString();
        String r116 = StringsKt.replace$default(r115, " ", "", false, 4, null);
        if (Intrinsics.areEqual(r116, r115) == true) goto L67;
        this.E = true;
        r110.replace(0, r110.length(), r116);
        this.E = false;
        goto L67
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final int b(CharSequence r100) {
        int r101 = 0;
        if (r100 != null) goto L6;
        return 0;
    L6:
        if (this.D == false) goto L8;
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
        if (n() == true) goto L11;
        return r100.length();
    }

    @Override // com.obric.oui.forms.OInputLayout
    public final void f(boolean r100) {
        if (this.F != r100) goto L5;
        return;
    L5:
        this.F = r100;
        super.f(r100);
        a(getVInput().getText());
    }

    public final void setAreaClickListener(View.OnClickListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.H.setOnClickListener(r100);
    }

    public final void setAreaCode(String r100) {
        if (r100 == null) goto L19;
        String r101 = this.G;
        int r102 = 0;
        if (r101 != null) goto L6;
    L8:
        this.G = r100;
        this.I.setText(r100);
        a(getVInput().getText());
        Editable r103 = getVInput().getText();
        if (r103 == null) goto L17;
        r102 = r103.length();
    L17:
        getVInput().setSelection(r102);     // Catch: Exception -> L14
        return;
    L14:
        e = move-exception;
        wma.b.h("OInputLayout", Intrinsics.stringPlus("Failed to move cursor to end: ", e.getMessage()));
        return;
    L6:
        if (StringsKt.equals$default(r101, r100, false, 2, null) == false) goto L8;
        return;
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setCustomStart(int r100) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    @Override // com.obric.oui.forms.OInputLayout
    public void setDefaultCustomStart(int r100) {
        super.setCustomStart(R.layout.o_input_custom_start_area_code);
    }

    public final void setEnableArrowIcon(boolean r100) {
        if (this.K != r100) goto L5;
        return;
    L5:
        this.K = r100;
        ImageView r101 = this.f401004J;
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

    @Override // com.obric.oui.forms.OInputLayout
    public void setType(int r100) {
        if (r100 == 0) goto L4;
        return;
    L4:
        super.setType(r100);
    }

    public OPhoneInputLayout(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.K = true;
        setType(0);
        setCustomStart(R.layout.o_input_custom_start_area_code);
        f(true);
        setInputType(3);
        this.H = (LinearLayout) findViewById(R.id.o_input_area_code_container);
        this.I = (TextView) findViewById(R.id.o_input_area_code_text);
        this.f401004J = (ImageView) findViewById(R.id.o_input_area_code_arrow);
        TypedArray r103 = r100.getTheme().obtainStyledAttributes(r101, new int[]{R.attr.oinput_areaCode}, r102, 0);
        setAreaCode(r103.getString(0));
        r103.recycle();
    }

    public /* synthetic */ OPhoneInputLayout(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
