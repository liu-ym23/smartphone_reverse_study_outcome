package fp5;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.widgets.t;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f478277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public CharSequence f478278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f478279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f478280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CharSequence f478281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f478282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public fp5.a.b f478283g;

    public static final class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f478284a;

        public a(b r100) {
            this.f478284a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            fp5.a.b r102 = this.f478284a.f478283g;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    /* JADX INFO: renamed from: fp5.b$b, reason: collision with other inner class name */
    public static final class C5940b implements UDCheckBox.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f478285a;

        public C5940b(b r100) {
            this.f478285a = r100;
        }

        @Override // com.larksuite.component.universe_design.checkbox.UDCheckBox.c
        public final void a(UDCheckBox r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "buttonView");
            fp5.a.b r102 = this.f478285a.f478283g;
            if (r102 == null) goto L6;
            r102.a(r100, r101);
            return;
        }
    }

    public static final class c extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Checkable f478286c;

        public c(Checkable r100) {
            this.f478286c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Checkable r101 = this.f478286c;
            if (r101 == null) goto L9;
            if (r101 == null) goto L6;
            boolean r102 = r101.isChecked();
        L7:
            r101.setChecked(!r102);
            return;
        L6:
            r102 = false;
            goto L7
        }
    }

    public static final class d extends t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Checkable f478287c;

        public d(Checkable r100) {
            this.f478287c = r100;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r100) {
            Checkable r101 = this.f478287c;
            if (r101 == null) goto L9;
            if (r101 == null) goto L6;
            boolean r102 = r101.isChecked();
        L7:
            r101.setChecked(!r102);
            return;
        L6:
            r102 = false;
            goto L7
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final int getDefaultContentRes() {
        if (this.f478282f == false) goto L5;
        return R.layout.bear_ud_dialog_circle_check_box_content;
    L5:
        return R.layout.bear_ud_dialog_check_box_content;
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View onCreateContent() {
        View r100 = super.onCreateContent();
        if (r100 != null) goto L6;
        return null;
    L6:
        Checkable r101 = (Checkable) r100.findViewById(R.id.ud_dialog_checkbox);
        if (r101 == null) goto L14;
        r101.setChecked(this.f478277a);
        if ((r101 instanceof CheckBox) == false) goto L12;
        ((CheckBox) r101).setOnCheckedChangeListener(new a(this));
        goto L14
    L12:
        if ((r101 instanceof UDCheckBox) == false) goto L14;
        ((UDCheckBox) r101).setOnCheckedChangeListener(new C5940b(this));
    L14:
        TextView r102 = (TextView) r100.findViewById(R.id.ud_dialog_checkbox_hint);
        if (r102 == null) goto L17;
        r102.setText(this.f478278b);
    L17:
        if (r102 == null) goto L20;
        r102.setOnClickListener(new c(r101));
    L20:
        if (this.f478279c == (-1)) goto L23;
        if (r102 == null) goto L23;
        r102.setTextColor(UDColorUtils.getColor(getContext(), this.f478279c));
    L23:
        LinearLayout r103 = (LinearLayout) r100.findViewById(R.id.ud_dialog_checkbox_layout);
        if (r103 == null) goto L26;
        r103.setOnClickListener(new d(r101));
    L26:
        int r104 = 0;
        if (r103 != null) goto L29;
    L33:
        TextView r105 = (TextView) r100.findViewById(R.id.ud_dialog_content_tips_tv);
        if (r105 == null) goto L36;
        r105.setText(this.f478281e);
    L36:
        if (r105 != null) goto L38;
    L42:
        return r100;
    L38:
        if (TextUtils.isEmpty(this.f478281e) == false) goto L41;
        r104 = 8;
    L41:
        r105.setVisibility(r104);
        goto L42
    L29:
        if (this.f478280d == false) goto L31;
        int r106 = 0;
    L32:
        r103.setVisibility(r106);
        goto L33
    L31:
        r106 = 8;
        goto L32
    }

    public b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f478278b = "";
        this.f478279c = -1;
        this.f478280d = true;
        this.f478281e = "";
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r100, UDDialog r101) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        Intrinsics.checkNotNullParameter(r101, "dialog");
        if ((r100 instanceof fp5.a) == false) goto L7;
        super.apply(r100, r101);
        fp5.a r102 = (fp5.a) r100;
        this.f478277a = r102.f478270a;
        this.f478278b = r102.f478271b;
        this.f478279c = r102.f478273d;
        this.f478280d = r102.f478274e;
        this.f478281e = r102.f478272c;
        this.f478283g = r102.f478275f;
        this.f478282f = r102.f478276g;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDCheckBoxDialogBuilder, but actually ".concat(r100.getClass().getSimpleName()).toString());
    }
}
