package hp5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.button.UDButton;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f486439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f486440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f486441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f486442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f486443e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public UDButton f486444f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public UDCheckBox.c f486445g;

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        return R.layout.bear_ud_dialog_check_box_content_v2;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L6;
        return null;
    L6:
        TextView r101 = (TextView) r100.findViewById(R.id.ud_dialog_content_tips_tv);
        if (r101 == null) goto L9;
        r101.setText(this.f486443e);
    L9:
        int r102 = 0;
        if (r101 != null) goto L12;
    L16:
        UDCheckBox r103 = (UDCheckBox) r100.findViewById(R.id.ud_dialog_checkbox);
        if (r103 == null) goto L19;
        r103.setChecked(this.f486439a);
        r103.setOnCheckedChangeListener(new b(this));
    L19:
        TextView r104 = (TextView) r100.findViewById(R.id.ud_dialog_checkbox_hint);
        if (r104 == null) goto L22;
        r104.setText(this.f486440b);
    L22:
        if (r104 == null) goto L25;
        r104.setOnClickListener(new c(r103));
    L25:
        if (this.f486441c == (-1)) goto L28;
        if (r104 == null) goto L28;
        r104.setTextColor(UDColorUtils.getColor(getContext(), this.f486441c));
    L28:
        LinearLayout r105 = (LinearLayout) r100.findViewById(R.id.ud_dialog_checkbox_layout);
        if (r105 == null) goto L31;
        r105.setOnClickListener(new d(r103));
    L31:
        if (r105 != null) goto L33;
    L37:
        return r100;
    L33:
        if (this.f486442d == true) goto L36;
        r102 = 8;
    L36:
        r105.setVisibility(r102);
        goto L37
    L12:
        if (TextUtils.isEmpty(this.f486443e) == true) goto L14;
        int r106 = 0;
    L15:
        r101.setVisibility(r106);
        goto L16
    L14:
        r106 = 8;
        goto L15
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateFooter() {
        View r100 = super.onCreateFooter();
        if (r100 == null) goto L5;
        UDButton r101 = (UDButton) r100.findViewById(R.id.ud_dialog_btn_primary);
    L6:
        this.f486444f = r101;
        boolean r102 = this.f486439a;
        if (this.f486442d == false) goto L14;
        if (r101 == null) goto L11;
        r101.setClickable(r102);
    L11:
        UDButton r103 = this.f486444f;
        if (r103 == null) goto L14;
        r103.setEnabled(r102);
    L14:
        return r100;
    L5:
        r101 = null;
        goto L6
    }

    public e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f486440b = "";
        this.f486441c = -1;
        this.f486442d = true;
        this.f486443e = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof a) == false) goto L7;
        super.apply(r100, r101);
        a r102 = (a) r100;
        this.f486439a = r102.f486430a;
        this.f486440b = r102.f486431b;
        this.f486441c = r102.f486433d;
        this.f486442d = r102.f486434e;
        this.f486443e = r102.f486432c;
        this.f486445g = r102.f486435f;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDCheckBoxDialogBuilderV2, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
