package o5a;

import android.content.Context;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.lynx.clay.embedding.engine.plugins.platformview.MeasureMode;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends o5a.a {
    public boolean A;
    public boolean B;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f522142u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f522143v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f522144w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f522145x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f522146y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f522147z;

    public class a implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f522148a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public a(h r100) {
            this.f522148a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            this.f522148a.z();
        }
    }

    public class b implements TextView.OnEditorActionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f522149a;

        public b(h r100) {
            this.f522149a = r100;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView r100, int r101, KeyEvent r102) {
            if (r101 == 6) goto L14;
            if (r101 == 2) goto L14;
            if (r101 == 3) goto L14;
            if (r101 == 4) goto L14;
            if (r101 == 5) goto L14;
            if (r101 == 0) goto L14;
            return false;
        L14:
            if (this.f522149a.c("confirm") == false) goto L19;
            HashMap r103 = new HashMap();
            r103.put("value", this.f522149a.f522108h.getText().toString());
            this.f522149a.q("confirm", r103);
            return false;
        L19:
            return false;
        }
    }

    public class c implements d.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f522150a;

        @Override // o5a.d.a
        public final void a() {
            h r100 = this.f522150a;
            if (r100.B == true) goto L5;
            return;
        L5:
            r100.B = false;
            r100.e();
        }

        public c(h r100) {
            this.f522150a = r100;
        }
    }

    public final void y() {
        if (this.f522108h.getText().length() == 0) goto L5;
    L7:
        Layout r100 = p5a.a.a(this.f522108h.getText(), this.f522108h, (int) this.f522146y);
    L8:
        this.f522145x = Math.max(Math.min(r100.getHeight(), this.f522144w), this.f522143v);
        return;
    L5:
        if (this.f522108h.getHint() == null) goto L7;
        r100 = p5a.a.a(this.f522108h.getHint(), this.f522108h, (int) this.f522146y);
        goto L8
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void g() {
        super.g();
        if (this.A == false) goto L6;
        z();
        this.A = false;
        return;
    }

    @Override // o5a.a
    public final void u() {
        e();
        this.B = true;
        z();
    }

    public final void z() {
        y();
        if (Math.min((int) this.f522145x, (int) this.f522142u) == this.f522108h.getHeight()) goto L6;
        e();
        return;
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r100) {
        super.a(r100);
        this.f522108h.addTextChangedListener(new a(this));
        this.f522108h.setOnEditorActionListener(new b(this));
        this.f522108h.setOnAfterDrawListener(new c(this));
        this.f522108h.setHorizontallyScrolling(false);
        this.f522108h.setSingleLine(false);
        this.f522108h.setGravity(48);
        return this.f522108h;
    }

    @Override // o5a.a, com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void n(String r100, Object r101) {
        if (r100.equals(GXTemplateKey.FLEXBOX_MIN_HEIGHT) == false) goto L8;
        if ((r101 instanceof Number) == false) goto L24;
        this.f522143v = ((Number) r101).floatValue();
        this.A = true;
        return;
    L24:
        return;
    L8:
        if (r100.equals(GXTemplateKey.FLEXBOX_MAX_HEIGHT) == false) goto L13;
        if ((r101 instanceof Number) == false) goto L26;
        this.f522144w = ((Number) r101).floatValue();
        this.A = true;
        return;
    L26:
        return;
    L13:
        if (r100.equals("maxlines") == false) goto L18;
        if ((r101 instanceof Number) == false) goto L28;
        this.f522108h.setMaxLines(((Number) r101).intValue());
        return;
    L28:
        return;
    L18:
        if (r100.equals(GXTemplateKey.GAIAX_LAYER_LINE_SPACING) == true) goto L20;
        super.n(r100, r101);
        return;
    L20:
        if ((r101 instanceof Number) == false) goto L30;
        this.f522108h.setLineSpacing(((Number) r101).floatValue(), 1.0f);
        return;
    }

    public h(Context r100, int r101, String r102) {
        super(r100, r101, r102);
        this.f522142u = Float.MAX_VALUE;
        this.f522143v = 0.0f;
        this.f522144w = Float.MAX_VALUE;
        this.f522145x = 0.0f;
        this.f522146y = 0.0f;
        this.f522147z = 0.0f;
        this.A = false;
        this.B = false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final n5a.h f(MeasureMode r100, int r101, MeasureMode r102, int r103) {
        float r104 = r101;
        this.f522146y = r104;
        float r105 = r103;
        this.f522147z = r105;
        MeasureMode r106 = MeasureMode.EXACTLY;
        if (r102 != r106) goto L7;
        if (r100 != r106) goto L7;
        this.f522142u = Float.MAX_VALUE;
        this.B = true;
        return new n5a.h(r104, r105);
    L7:
        y();
        float r107 = this.f522145x;
        this.f522147z = r107;
        if (r102 != MeasureMode.UNDEFINED) goto L11;
        this.f522142u = Float.MAX_VALUE;
    L13:
        this.B = true;
        return new n5a.h(r104, this.f522147z);
    L11:
        if (r102 != MeasureMode.AT_MOST) goto L13;
        this.f522142u = r105;
        this.f522147z = Math.min(r107, r105);
        goto L13
    }
}
