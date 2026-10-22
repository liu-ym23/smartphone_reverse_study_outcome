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
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b extends UDDialogController {
    public boolean a;
    public CharSequence b;
    public int c;
    public boolean d;
    public CharSequence e;
    public boolean f;
    public fp5.a.b g;

    public static final class a implements CompoundButton.OnCheckedChangeListener {
        public final /* synthetic */ b a;

        public a(b r1) {
            this.a = r1;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "buttonView");
            fp5.a.b r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }
    }

    /* JADX INFO: renamed from: fp5.b$b, reason: collision with other inner class name */
    public static final class C0233b implements UDCheckBox.c {
        public final /* synthetic */ b a;

        public C0233b(b r1) {
            this.a = r1;
        }

        public final void a(UDCheckBox r2, boolean r3) {
            Intrinsics.checkNotNullParameter(r2, "buttonView");
            fp5.a.b r0 = this.a.g;
            if (r0 == null) goto L6;
            r0.a(r2, r3);
            return;
        }
    }

    public static final class c extends t {
        public final /* synthetic */ Checkable c;

        public c(Checkable r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Checkable r3 = this.c;
            if (r3 == null) goto L9;
            if (r3 == null) goto L6;
            boolean r0 = r3.isChecked();
        L7:
            r3.setChecked(!r0);
            return;
        L6:
            r0 = false;
            goto L7
        }
    }

    public static final class d extends t {
        public final /* synthetic */ Checkable c;

        public d(Checkable r1) {
            this.c = r1;
        }

        @Override // com.bytedance.ee.bear.widgets.t
        public final void a(View r2) {
            Checkable r3 = this.c;
            if (r3 == null) goto L9;
            if (r3 == null) goto L6;
            boolean r0 = r3.isChecked();
        L7:
            r3.setChecked(!r0);
            return;
        L6:
            r0 = false;
            goto L7
        }
    }

    public final int getDefaultContentRes() {
        if (this.f == false) goto L5;
        return 2131558801;
    L5:
        return 2131558799;
    }

    public final View onCreateContent() {
        View r0 = super.onCreateContent();
        if (r0 != null) goto L6;
        return null;
    L6:
        UDCheckBox r1 = (Checkable) r0.findViewById(2131391781);
        if (r1 == null) goto L14;
        r1.setChecked(this.a);
        if ((r1 instanceof CheckBox) == false) goto L12;
        ((CheckBox) r1).setOnCheckedChangeListener(new a(this));
        goto L14
    L12:
        if ((r1 instanceof UDCheckBox) == false) goto L14;
        r1.setOnCheckedChangeListener(new C0233b(this));
    L14:
        TextView r2 = (TextView) r0.findViewById(2131391782);
        if (r2 == null) goto L17;
        r2.setText(this.b);
    L17:
        if (r2 == null) goto L20;
        r2.setOnClickListener(new c(r1));
    L20:
        if (this.c == (-1)) goto L23;
        if (r2 == null) goto L23;
        r2.setTextColor(UDColorUtils.getColor(getContext(), this.c));
    L23:
        LinearLayout r3 = (LinearLayout) r0.findViewById(2131391783);
        if (r3 == null) goto L26;
        r3.setOnClickListener(new d(r1));
    L26:
        int r4 = 0;
        if (r3 != null) goto L29;
    L33:
        TextView r5 = (TextView) r0.findViewById(2131391795);
        if (r5 == null) goto L36;
        r5.setText(this.e);
    L36:
        if (r5 != null) goto L38;
    L42:
        return r0;
    L38:
        if (TextUtils.isEmpty(this.e) == false) goto L41;
        r4 = 8;
    L41:
        r5.setVisibility(r4);
        goto L42
    L29:
        if (this.d == false) goto L31;
        int r6 = 0;
    L32:
        r3.setVisibility(r6);
        goto L33
    L31:
        r6 = 8;
        goto L32
    }

    public b(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = "";
        this.c = -1;
        this.d = true;
        this.e = "";
    }

    public final <T extends UDBaseDialogBuilder<? extends T>> void apply(UDBaseDialogBuilder<? extends T> r2, UDDialog r3) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        Intrinsics.checkNotNullParameter(r3, "dialog");
        if ((r2 instanceof fp5.a) == false) goto L7;
        super.apply(r2, r3);
        fp5.a r4 = (fp5.a) r2;
        this.a = r4.a;
        this.b = r4.b;
        this.c = r4.d;
        this.d = r4.e;
        this.e = r4.c;
        this.g = r4.f;
        this.f = r4.g;
        return;
    L7:
        throw new IllegalArgumentException("builder should be BearUDCheckBoxDialogBuilder, but actually ".concat(r2.getClass().getSimpleName()).toString());
    }
}
