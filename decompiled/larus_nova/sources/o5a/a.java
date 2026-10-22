package o5a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.IBinder;
import android.text.Editable;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.common.TeaEventTrack;
import com.bytedance.android.ec.model.response.ECPromotion;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.relax.k;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public class a extends com.lynx.clay.embedding.engine.plugins.platformview.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public o5a.d f522108h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f522109i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f522110j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f522111k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f522112l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f522113m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f522114n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f522115o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f522116p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f522117q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f522118r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f522119s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f522120t;

    /* JADX INFO: renamed from: o5a.a$a, reason: collision with other inner class name */
    public class C7017a implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522121a;

        public C7017a(a r100) {
            this.f522121a = r100;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
            Pattern r106 = PatternProtector.compile(this.f522121a.f522112l);
            StringBuilder r107 = new StringBuilder();
        L3:
            if (r101 >= r102) goto L9;
            char r108 = r100.charAt(r101);
            if (r106.matcher(Character.toString(r108)).matches() == false) goto L7;
            r107.append(r108);
        L7:
            r101 = r101 + 1;
            goto L3
        L9:
            return r107.toString();
        }
    }

    public class b implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522122a;

        public b(a r100) {
            this.f522122a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            this.f522122a.getClass();
            a.s(r100);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
            this.f522122a.t();
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522123a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(a r100) {
            this.f522123a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            if (this.f522123a.c("input") == false) goto L7;
            if (r100 == null) goto L8;
            HashMap r101 = new HashMap();
            r101.put("value", r100.toString());
            r101.put(EffectConfiguration.KEY_CURSOR, Integer.valueOf(this.f522123a.f522108h.getSelectionEnd()));
            this.f522123a.q("input", r101);
            return;
        L8:
            return;
        }
    }

    public class d implements View.OnFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522124a;

        public d(a r100) {
            this.f522124a = r100;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View r100, boolean r101) {
            if (r101 == false) goto L8;
            this.f522124a.f380857c.markAsEditing();
            if (this.f522124a.c(ButtonColorBean.StateFocus) == false) goto L11;
            HashMap r102 = new HashMap();
            r102.put("value", this.f522124a.f522108h.getText().toString());
            this.f522124a.q(ButtonColorBean.StateFocus, r102);
            return;
        L11:
            return;
        L8:
            if (this.f522124a.c("blur") == false) goto L13;
            HashMap r103 = new HashMap();
            r103.put("value", this.f522124a.f522108h.getText().toString());
            this.f522124a.q("blur", r103);
            return;
        }
    }

    public class e implements o5a.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522125a;

        public e(a r100) {
            this.f522125a = r100;
        }
    }

    public class f implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522126a;

        public f(a r100) {
            this.f522126a = r100;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
            int r106 = this.f522126a.f522111k - (r103.length() - (r105 - r104));
            if (r106 > 0) goto L6;
            return "";
        L6:
            if (r106 < (r102 - r101)) goto L9;
            return null;
        L9:
            int r107 = r106 + r101;
            if (Character.isHighSurrogate(r100.charAt(r107 - 1)) == false) goto L15;
            r107 = r107 - 1;
            if (r107 != r101) goto L15;
            return "";
        L15:
            return r100.subSequence(r101, r107);
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522127a;

        @Override // java.lang.Runnable
        public final void run() {
            this.f522127a.w(true);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public g(a r100) {
            this.f522127a = r100;
        }
    }

    public class h implements InputFilter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f522128a;

        public h(a r100) {
            this.f522128a = r100;
        }

        @Override // android.text.InputFilter
        public final CharSequence filter(CharSequence r100, int r101, int r102, Spanned r103, int r104, int r105) {
            int r106 = this.f522128a.f522111k - (r103.length() - (r105 - r104));
            if (r106 > 0) goto L6;
            return "";
        L6:
            if (r106 < (r102 - r101)) goto L9;
            return null;
        L9:
            int r107 = r106 + r101;
            if (Character.isHighSurrogate(r100.charAt(r107 - 1)) == false) goto L15;
            r107 = r107 - 1;
            if (r107 != r101) goto L15;
            return "";
        L15:
            return r100.subSequence(r101, r107);
        }
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void j() {
        this.f522109i = true;
        if (this.f522110j == false) goto L6;
        this.f522110j = false;
        this.f522108h.post(new g(this));
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void m() {
        w(false);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public void g() {
        if (this.f522117q == false) goto L26;
        boolean r100 = true;
        if (this.f522114n != null) goto L24;
        Typeface r101 = Typeface.DEFAULT;
        int r102 = this.f522116p;
        if (this.f522115o == 2) goto L21;
        r100 = false;
    L21:
        this.f522108h.setTypeface(Typeface.create(r101, r102, r100));
    L22:
        this.f522117q = false;
        return;
    L24:
        Typeface r103 = Typeface.createFromAsset(this.f380859e.getAssets(), this.f522114n);     // Catch: Exception -> L12
        int r104 = this.f522116p;     // Catch: Exception -> L12
        if (this.f522115o != 2) goto L9;
        boolean r105 = true;
    L10:
        this.f522108h.setTypeface(Typeface.create(r103, r104, r105));     // Catch: Exception -> L12
        goto L22
    L9:
        r105 = false;
    L12:
        c5a.c.d(5, "BaseInputView", "Font family not found: " + this.f522114n);
        Typeface r106 = Typeface.DEFAULT;
        int r107 = this.f522116p;
        if (this.f522115o == 2) goto L16;
        r100 = false;
    L16:
        this.f522108h.setTypeface(Typeface.create(r106, r107, r100));
        goto L22
    }

    public final void t() {
        o5a.d r100 = this.f522108h;
        if (r100 != null) goto L19;
        return;
    L19:
        r100.clearFocus();     // Catch: RuntimeException -> L18
        InputMethodManager r101 = (InputMethodManager) this.f380859e.getSystemService("input_method");     // Catch: RuntimeException -> L18
        if (r101 != null) goto L8;
        return;
    L8:
        IBinder r102 = this.f522108h.getWindowToken();     // Catch: RuntimeException -> L18
        if (r102 != null) goto L11;
        r102 = this.f522108h.getApplicationWindowToken();     // Catch: RuntimeException -> L18
    L11:
        if (r102 == null) goto L13;
    L15:
        if (r102 == null) goto L21;
        r101.hideSoftInputFromWindow(r102, 0);     // Catch: RuntimeException -> L18
        return;
    L21:
        return;
    L13:
        if (this.f522108h.getRootView() == null) goto L15;
        r102 = this.f522108h.getRootView().getWindowToken();     // Catch: RuntimeException -> L18
    }

    public final void v() {
        h r100 = new h(this);
        C7017a r101 = new C7017a(this);
        String r102 = this.f522112l;
        if (r102 != null) goto L5;
    L9:
        this.f522108h.setFilters(new InputFilter[]{r100});
        return;
    L5:
        if (r102.isEmpty() == true) goto L9;
        this.f522108h.setFilters(new InputFilter[]{r100, r101});
    }

    public final void x() {
        if (this.f522119s.isEmpty() == false) goto L5;
        return;
    L5:
        if (this.f522120t > 0.0f) goto L10;
        float r100 = this.f522118r;
        if (r100 <= 0.0f) goto L9;
        this.f522120t = r100;
        goto L10
    L9:
        this.f522120t = 14.0f;
    L10:
        SpannableString r101 = new SpannableString(this.f522119s);
        r101.setSpan(new AbsoluteSizeSpan((int) this.f522120t, true), 0, this.f522119s.length(), 18);
        this.f522108h.setHint(r101);
        this.f522108h.requestLayout();
        this.f522108h.invalidate();
        e();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void h() {
        t();
    }

    public void u() {
        e();
    }

    public static void s(View r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof FlutterView) == false) goto L12;
        FlutterView.g r101 = ((FlutterView) r100).getKeyboardEventStartCallback();
        if (r101 == null) goto L16;
        k r102 = ((lpa.d) r101).f510274a.f510279c;
        if (r102 == null) goto L17;
        r102.onStart();
        return;
    L17:
        return;
    L16:
        return;
    L12:
        Object r103 = r100.getParent();
        if ((r103 instanceof View) == false) goto L18;
        s((View) r103);
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public View a(Context r100) {
        c5a.c.c("BaseInputView", "createView");
        o5a.d r101 = new o5a.d(r100);
        r101.setBackground(null);
        r101.setImeOptions(1);
        r101.setPadding(0, 0, 0, 0);
        this.f522108h = r101;
        r101.addOnAttachStateChangeListener(new b(this));
        this.f522108h.addTextChangedListener(new c(this));
        this.f522108h.setOnFocusChangeListener(new d(this));
        this.f522108h.setOnSelectionChangeListener(new e(this));
        f r102 = new f(this);
        this.f522108h.setFilters(new InputFilter[]{r102});
        return r101;
    }

    public final void w(boolean r100) {
        if (r100 == false) goto L7;
        this.f522108h.requestFocus();
        if (this.f522113m == false) goto L12;
        this.f522108h.post(new o5a.b(this));
        return;
    L12:
        return;
    L7:
        if (this.f522108h.isFocused() == false) goto L14;
        this.f522108h.clearFocus();
        if (this.f522113m == false) goto L15;
        this.f522108h.post(new o5a.c(this));
        return;
    L15:
        return;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public void n(String r110, Object r111) {
        byte r100 = 6;
        byte r101 = -1;
        int r102 = 0;
        if ("confirm-type".equals(r110) == false) goto L38;
        if ((r111 instanceof String) == false) goto L432;
        String r112 = (String) r111;
        r112.getClass();
        switch(r112.hashCode()) {
            case -906336856: goto L27;
            case 3304: goto L23;
            case 3089282: goto L19;
            case 3377907: goto L15;
            case 3526536: goto L11;
            default: goto L30;
        };
    L30:
        switch(r101) {
            case 0: goto L36;
            case 1: goto L35;
            case 2: goto L34;
            case 3: goto L33;
            case 4: goto L32;
            default: goto L31;
        };
    L31:
        c5a.c.d(5, "BaseInputView", "Unsupported confirm type: ".concat(r112));
        return;
    L32:
        this.f522108h.setImeOptions(4);
        return;
    L33:
        this.f522108h.setImeOptions(5);
        return;
    L34:
        this.f522108h.setImeOptions(6);
        return;
    L35:
        this.f522108h.setImeOptions(2);
        return;
    L36:
        this.f522108h.setImeOptions(3);
        return;
    L11:
        if (r112.equals("send") == false) goto L30;
        r101 = 4;
        goto L30
    L15:
        if (r112.equals(TeaEventTrack.ACTION_DRAMA_NEXT) == false) goto L30;
        r101 = 3;
        goto L30
    L19:
        if (r112.equals("done") == false) goto L30;
        r101 = 2;
        goto L30
    L23:
        if (r112.equals("go") == false) goto L30;
        r101 = 1;
        goto L30
    L27:
        if (r112.equals("search") == false) goto L30;
        r101 = 0;
        goto L30
    L432:
        return;
    L38:
        if ("keyboard-type".equals(r110) == false) goto L78;
        if ((r111 instanceof String) == false) goto L433;
        String r113 = (String) r111;
        r113.getClass();
        switch(r113.hashCode()) {
            case -1034364087: goto L66;
            case 114715: goto L62;
            case 3556653: goto L58;
            case 95582509: goto L54;
            case 96619420: goto L50;
            case 1216985755: goto L46;
            default: goto L69;
        };
    L69:
        switch(r101) {
            case 0: goto L76;
            case 1: goto L75;
            case 2: goto L74;
            case 3: goto L73;
            case 4: goto L72;
            case 5: goto L71;
            default: goto L70;
        };
    L70:
        c5a.c.d(5, "BaseInputView", "Unsupported keyboard type: ".concat(r113));
        return;
    L71:
        this.f522108h.setInputType(128);
        return;
    L72:
        this.f522108h.setInputType(32);
        return;
    L73:
        this.f522108h.setInputType(8194);
        return;
    L74:
        this.f522108h.setInputType(1);
        return;
    L75:
        this.f522108h.setInputType(3);
        return;
    L76:
        this.f522108h.setInputType(12290);
        return;
    L46:
        if (r113.equals("password") == false) goto L69;
        r101 = 5;
        goto L69
    L50:
        if (r113.equals("email") == false) goto L69;
        r101 = 4;
        goto L69
    L54:
        if (r113.equals("digit") == false) goto L69;
        r101 = 3;
        goto L69
    L58:
        if (r113.equals("text") == false) goto L69;
        r101 = 2;
        goto L69
    L62:
        if (r113.equals("tel") == false) goto L69;
        r101 = 1;
        goto L69
    L66:
        if (r113.equals("number") == false) goto L69;
        r101 = 0;
        goto L69
    L433:
        return;
    L78:
        if ("maxlength".equals(r110) == false) goto L84;
        if ((r111 instanceof Number) == false) goto L434;
        this.f522111k = ((Number) r111).intValue();
        v();
        return;
    L434:
        return;
    L84:
        if ("show-soft-input-on-focus".equals(r110) == false) goto L90;
        if ((r111 instanceof Boolean) == false) goto L435;
        this.f522113m = ((Boolean) r111).booleanValue();
        return;
    L435:
        return;
    L90:
        if ("readonly".equals(r110) == true) goto L92;
        Float r103 = null;
        Field r104 = null;
        Integer r105 = null;
        r105 = null;
        r105 = null;
        r105 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        r103 = null;
        if ("caret-color".equals(r110) == false) goto L122;
        if ((r111 instanceof Number) == false) goto L437;
        int r114 = (int) ((Number) r111).longValue();
        o5a.d r115 = this.f522108h;
        Field r106 = TextView.class.getDeclaredField("mEditor");     // Catch: Throwable -> L103
        r106.setAccessible(true);     // Catch: Throwable -> L103
        r104 = r106;
    L104:
        if (r104 != null) goto L388;
        Object r107 = r115;
    L109:
        if (r104 != null) goto L111;
        Class<?> r108 = TextView.class;
    L112:
        Field r109 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: Throwable -> L106
        r109.setAccessible(true);     // Catch: Throwable -> L106
        Drawable r116 = r115.getContext().getDrawable(r109.getInt(r115));     // Catch: Throwable -> L106
        if (r116 == null) goto L405;
        r116.setTint(r114);     // Catch: Throwable -> L106
        if (Build.VERSION.SDK_INT < 28) goto L118;
        Field r117 = r108.getDeclaredField("mDrawableForCursor");     // Catch: Throwable -> L106
        r117.setAccessible(true);     // Catch: Throwable -> L106
        r117.set(r107, r116);     // Catch: Throwable -> L106
        return;
    L118:
        Field r118 = r108.getDeclaredField("mCursorDrawable");     // Catch: Throwable -> L106
        r118.setAccessible(true);     // Catch: Throwable -> L106
        r118.set(r107, new Drawable[]{r116, r116});     // Catch: Throwable -> L106
        return;
    L405:
        return;
    L111:
        r108 = r107.getClass();     // Catch: Throwable -> L106
        goto L112
    L388:
        r107 = r104.get(r115);     // Catch: Throwable -> L106
    L106:
        th = move-exception;
        th.printStackTrace();
        return;
    L437:
        return;
    L122:
        if ("input-filter".equals(r110) == false) goto L128;
        if ((r111 instanceof String) == false) goto L439;
        this.f522112l = (String) r111;
        v();
        return;
    L439:
        return;
    L128:
        if (ButtonColorBean.StateFocus.equals(r110) == false) goto L140;
        if ((r111 instanceof Boolean) == true) goto L133;
        return;
    L133:
        if (((Boolean) r111).booleanValue() == true) goto L135;
        this.f522110j = false;
        w(false);
        return;
    L135:
        if (this.f522109i == false) goto L137;
        w(true);
        return;
    L137:
        this.f522110j = true;
        return;
    L140:
        if ("direction".equals(r110) == false) goto L165;
        if ((r111 instanceof String) == false) goto L441;
        String r119 = (String) r111;
        r119.getClass();
        switch(r119.hashCode()) {
            case -1039745817: goto L156;
            case 107498: goto L152;
            case 113258: goto L148;
            default: goto L159;
        };
    L159:
        switch(r101) {
            case 0: goto L163;
            case 1: goto L162;
            case 2: goto L161;
            default: goto L442;
        };
    L161:
        this.f522108h.setTextDirection(4);
        return;
    L162:
        this.f522108h.setTextDirection(3);
        return;
    L163:
        this.f522108h.setTextDirection(5);
        return;
    L442:
        return;
    L148:
        if (r119.equals("rtl") == false) goto L159;
        r101 = 2;
        goto L159
    L152:
        if (r119.equals("ltr") == false) goto L159;
        r101 = 1;
        goto L159
    L156:
        if (r119.equals("normal") == false) goto L159;
        r101 = 0;
        goto L159
    L441:
        return;
    L165:
        if (GXTemplateKey.STYLE_FONT_SIZE.equals(r110) == false) goto L173;
        if ((r111 instanceof Number) == false) goto L443;
        float r120 = ((Number) r111).floatValue();
        this.f522118r = r120;
        this.f522108h.setTextSize(0, r120);
        if (this.f522119s.isEmpty() == true) goto L415;
        x();
        return;
    L415:
        return;
    L443:
        return;
    L173:
        if (GXTemplateKey.STYLE_FONT_WEIGHT.equals(r110) == false) goto L187;
        if ((r111 instanceof Number) == false) goto L444;
        int r121 = ((Number) r111).intValue();
        int r122 = this.f522116p;
        if (r121 == 0) goto L182;
        if (r121 == 1) goto L181;
        this.f522116p = (r121 - 1) * 100;
    L184:
        if (this.f522116p == r122) goto L417;
        this.f522117q = true;
        return;
    L417:
        return;
    L181:
        this.f522116p = 700;
        goto L184
    L182:
        this.f522116p = 400;
        goto L184
    L444:
        return;
    L187:
        if ("font-style".equals(r110) == false) goto L203;
        if ((r111 instanceof Number) == false) goto L445;
        int r123 = ((Number) r111).intValue();
        int r124 = this.f522115o;
        if (r123 == 0) goto L198;
        if (r123 == 1) goto L197;
        if (r123 != 2) goto L200;
        this.f522115o = 2;
    L200:
        if (r124 == this.f522115o) goto L419;
        this.f522117q = true;
        return;
    L419:
        return;
    L197:
        this.f522115o = 2;
        goto L200
    L198:
        this.f522115o = 0;
        goto L200
    L445:
        return;
    L203:
        if (GXTemplateKey.STYLE_FONT_FAMILY.equals(r110) == false) goto L213;
        if ((r111 instanceof String) == false) goto L446;
        String r125 = this.f522114n;
        if (r125 != null) goto L210;
    L211:
        this.f522114n = (String) r111;
        this.f522117q = true;
        return;
    L210:
        if (r125 != ((String) r111)) goto L211;
        return;
    L446:
        return;
    L213:
        if ("letter-spacing".equals(r110) == false) goto L219;
        if ((r111 instanceof Number) == false) goto L447;
        this.f522108h.setLetterSpacing(((float) ((Number) r111).doubleValue()) / this.f522108h.getTextSize());
        return;
    L447:
        return;
    L219:
        if (GXTemplateKey.STYLE_FONT_TEXT_ALIGN.equals(r110) == false) goto L232;
        if ((r111 instanceof Number) == false) goto L448;
        int r126 = ((Number) r111).intValue();
        if (r126 == 0) goto L230;
        if (r126 == 1) goto L229;
        if (r126 != 2) goto L449;
        this.f522108h.setTextAlignment(3);
        return;
    L449:
        return;
    L229:
        this.f522108h.setTextAlignment(4);
        return;
    L230:
        this.f522108h.setTextAlignment(2);
        return;
    L448:
        return;
    L232:
        if ("color".equals(r110) == false) goto L238;
        if ((r111 instanceof Number) == false) goto L450;
        this.f522108h.setTextColor(((Number) r111).intValue());
        return;
    L450:
        return;
    L238:
        if (GXTemplateKey.GAIAX_PLACEHOLDER.equals(r110) == false) goto L247;
        if ((r111 instanceof String) == false) goto L243;
        this.f522119s = (String) r111;
    L245:
        x();
        u();
        return;
    L243:
        if ((r111 instanceof Number) == false) goto L428;
        this.f522119s = String.valueOf(r111);
        goto L245
    L428:
        return;
    L247:
        if ("placeholder-color".equals(r110) == false) goto L356;
        if ((r111 instanceof Number) == false) goto L252;
        r105 = Integer.valueOf((int) ((Number) r111).longValue());
    L352:
        if (r105 == null) goto L451;
        this.f522108h.setHintTextColor(r105.intValue());
        x();
        u();
        return;
    L451:
        return;
    L252:
        if ((r111 instanceof String) == false) goto L352;
        String r127 = (String) r111;
        Pattern r128 = o5a.g.f522141a;
        if (r127 == null) goto L352;
        String r129 = r127.trim().toLowerCase();
        if (r129.isEmpty() == true) goto L352;
        switch(r129.hashCode()) {
            case -1726194350: goto L302;
            case -734239628: goto L298;
            case 112785: goto L294;
            case 3027034: goto L290;
            case 3068707: goto L286;
            case 3181155: goto L282;
            case 3181279: goto L279;
            case 93818879: goto L275;
            case 98619139: goto L271;
            case 113101865: goto L267;
            case 828922025: goto L263;
            default: goto L305;
        };
    L305:
        r100 = -1;
    L306:
        switch(r100) {
            case 0: goto L318;
            case 1: goto L317;
            case 2: goto L316;
            case 3: goto L315;
            case 4: goto L314;
            case 5: goto L313;
            case 6: goto L313;
            case 7: goto L312;
            case 8: goto L311;
            case 9: goto L310;
            case 10: goto L309;
            default: goto L382;
        };
    L309:
        r105 = Integer.valueOf(FakePickerAvatarCreator.MAGENTA);
        goto L352
    L310:
        r105 = -1;
        goto L352
    L311:
        r105 = Integer.valueOf(FakePickerAvatarCreator.GREEN);
        goto L352
    L312:
        r105 = -16777216;
        goto L352
    L313:
        r105 = Integer.valueOf(FakePickerAvatarCreator.GRAY);
        goto L352
    L314:
        r105 = Integer.valueOf(FakePickerAvatarCreator.CYAN);
        goto L352
    L315:
        r105 = Integer.valueOf(FakePickerAvatarCreator.BLUE);
        goto L352
    L316:
        r105 = -65536;
        goto L352
    L317:
        r105 = -256;
        goto L352
    L318:
        r105 = 0;
        goto L352
    L382:
        Matcher r130 = o5a.g.f522141a.matcher(r129);     // Catch: RuntimeException -> L351
        if (r130.matches() == false) goto L347;
        int r131 = CastIntegerProtector.parseInt(r130.group(1));     // Catch: RuntimeException -> L351
        if (r131 >= 0) goto L324;
        r131 = 0;
    L326:
        int r132 = CastIntegerProtector.parseInt(r130.group(2));     // Catch: RuntimeException -> L351
        if (r132 >= 0) goto L329;
        r132 = 0;
    L331:
        int r133 = CastIntegerProtector.parseInt(r130.group(3));     // Catch: RuntimeException -> L351
        if (r133 >= 0) goto L334;
        r133 = 0;
    L336:
        float r134 = CastFloatProtector.parseFloat(r130.group(4));     // Catch: RuntimeException -> L351
        if (r134 > 1.0f) goto L339;
        int r135 = Math.round(r134 * 255.0f);     // Catch: RuntimeException -> L351
    L340:
        if (r135 < 0) goto L345;
        if (r135 <= 255) goto L344;
        r102 = 255;
        goto L345
    L344:
        r102 = r135;
    L345:
        r105 = Integer.valueOf(Color.argb(r102, r131, r132, r133));     // Catch: RuntimeException -> L351
        goto L352
    L339:
        r135 = Math.round(r134);     // Catch: RuntimeException -> L351
        goto L340
    L334:
        if (r133 <= 255) goto L336;
        r133 = 255;
        goto L336
    L329:
        if (r132 <= 255) goto L331;
        r132 = 255;
        goto L331
    L324:
        if (r131 <= 255) goto L326;
        r131 = 255;
        goto L326
    L347:
        if (r129.startsWith("#") == false) goto L349;
        r105 = Integer.valueOf(Color.parseColor(r129));     // Catch: RuntimeException -> L351
        goto L352
    L349:
        r105 = Integer.valueOf((int) CastLongProtector.parseLong(r129));     // Catch: RuntimeException -> L351
        goto L352
    L263:
        if (r129.equals("magenta") == false) goto L305;
        r100 = 10;
        goto L306
    L267:
        if (r129.equals("white") == false) goto L305;
        r100 = 9;
        goto L306
    L271:
        if (r129.equals("green") == false) goto L305;
        r100 = 8;
        goto L306
    L275:
        if (r129.equals("black") == false) goto L305;
        r100 = 7;
        goto L306
    L279:
        if (r129.equals("grey") == true) goto L306;
    L282:
        if (r129.equals("gray") == false) goto L305;
        r100 = 5;
        goto L306
    L286:
        if (r129.equals("cyan") == false) goto L305;
        r100 = 4;
        goto L306
    L290:
        if (r129.equals("blue") == false) goto L305;
        r100 = 3;
        goto L306
    L294:
        if (r129.equals("red") == false) goto L305;
        r100 = 2;
        goto L306
    L298:
        if (r129.equals("yellow") == false) goto L305;
        r100 = 1;
        goto L306
    L302:
        if (r129.equals(ECPromotion.TRANSPARENT_BOTTON_ICON) == false) goto L305;
        r100 = 0;
        goto L306
    L356:
        if ("placeholder-font-size".equals(r110) == true) goto L358;
        return;
    L358:
        if ((r111 instanceof Number) == false) goto L361;
        float r136 = ((Number) r111).floatValue();
        Resources r137 = this.f380859e.getResources();
        r103 = Float.valueOf(r136 / WindowDisplayMetricsOverride.apply(r137, r137.getDisplayMetrics()).density);
    L378:
        if (r103 == null) goto L452;
        this.f522120t = r103.floatValue();
        x();
        u();
        return;
    L452:
        return;
    L361:
        if ((r111 instanceof String) == false) goto L378;
        Context r138 = this.f380859e;
        String r139 = (String) r111;
        Pattern r140 = o5a.g.f522141a;
        if (r138 == null) goto L378;
        if (r139 == null) goto L378;
        String r141 = r139.trim().toLowerCase();
        if (r141.isEmpty() == true) goto L378;
        if (r141.endsWith(GXTemplateKey.GAIAX_PX) == false) goto L373;
        r103 = Float.valueOf(CastFloatProtector.parseFloat(r141.substring(0, r141.length() - 2).trim()));     // Catch: RuntimeException -> L377
    L385:
        goto L378
    L373:
        if (r141.endsWith("rpx") == false) goto L375;
        float r142 = CastFloatProtector.parseFloat(r141.substring(0, r141.length() - 3).trim());     // Catch: RuntimeException -> L377
        Resources r143 = r138.getResources();     // Catch: RuntimeException -> L377
        r103 = Float.valueOf((r142 * WindowDisplayMetricsOverride.apply(r143, r143.getDisplayMetrics()).widthPixels) / 750.0f);     // Catch: RuntimeException -> L377
        goto L385
    L375:
        r103 = Float.valueOf(CastFloatProtector.parseFloat(r141));     // Catch: RuntimeException -> L377
        goto L385
    L92:
        if ((r111 instanceof Boolean) == false) goto L436;
        boolean r144 = !((Boolean) r111).booleanValue();
        this.f522108h.setFocusable(r144);
        this.f522108h.setFocusableInTouchMode(r144);
        return;
    }

    public a(Context r100, int r101, String r102) {
        super(r100, r101, r102);
        this.f522109i = false;
        this.f522110j = false;
        this.f522111k = 140;
        this.f522112l = "";
        this.f522113m = true;
        this.f522115o = 0;
        this.f522116p = 400;
        this.f522117q = false;
        this.f522118r = 0.0f;
        this.f522119s = "";
        this.f522120t = 0.0f;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final boolean d(String r100, JSONObject r101, n5a.a r102) {
        if (ButtonColorBean.StateFocus.equals(r100) == false) goto L9;
        w(true);
        if (this.f522108h.isFocused() == false) goto L7;
        r102.a(PlatformMethodCallbackResult.SUCCESS);
    L71:
        return true;
    L7:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L9:
        if ("blur".equals(r100) == false) goto L18;
        if (this.f522108h.isFocused() == false) goto L16;
        w(false);
        if (this.f522108h.isFocused() == true) goto L15;
        r102.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L15:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L16:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L18:
        if ("setValue".equals(r100) == false) goto L27;
        String r103 = r101.optString("value", "");
        int r104 = r101.optInt("index", -1);
        if (this.f522108h.getText() == null) goto L25;
        this.f522108h.setText(r103);
        if (r104 < 0) goto L24;
        this.f522108h.setSelection(Math.min(r104, r103.length()));
    L24:
        r102.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L25:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L27:
        if ("getValue".equals(r100) == false) goto L33;
        if (this.f522108h.getText() == null) goto L31;
        HashMap r105 = new HashMap();
        r105.put("value", this.f522108h.getText().toString());
        r102.b(PlatformMethodCallbackResult.SUCCESS, r105);
        goto L71
    L31:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L33:
        if ("setSelectionRange".equals(r100) == false) goto L47;
        int r106 = r101.optInt("selectionStart", -1);
        int r107 = r101.optInt("selectionEnd", -1);
        if (this.f522108h.getText() == null) goto L37;
        int r108 = this.f522108h.getText().length();
    L38:
        if (r108 == (-1)) goto L45;
        if (r106 > r108) goto L45;
        if (r107 > r108) goto L45;
        if (r106 < 0) goto L45;
        if (r107 < 0) goto L45;
        this.f522108h.setSelection(r106, r107);
        r102.a(PlatformMethodCallbackResult.SUCCESS);
    L45:
        r102.a(PlatformMethodCallbackResult.PARAM_INVALID);
        goto L71
    L37:
        r108 = -1;
        goto L38
    L47:
        if ("sendDelEvent".equals(r100) == false) goto L66;
        int r109 = r101.optInt("action", 1);
        if (r109 != 0) goto L58;
        int r110 = r101.optInt("length", 0);
        if (r110 <= 0) goto L64;
        int r111 = this.f522108h.getSelectionStart();
        int r112 = this.f522108h.getSelectionEnd();
        if (r111 == r112) goto L55;
        this.f522108h.getText().delete(r111, r112);
        goto L64
    L55:
        int r113 = Math.min(r110 + r111, this.f522108h.getText().length());
        if (r113 <= r111) goto L64;
        this.f522108h.getText().delete(r111, r113);
    L64:
        r102.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L58:
        if (r109 != 1) goto L64;
        int r114 = this.f522108h.getSelectionStart();
        int r115 = this.f522108h.getSelectionEnd();
        if (r114 == r115) goto L62;
        this.f522108h.getText().delete(r114, r115);
        goto L64
    L62:
        if (r114 <= 0) goto L64;
        this.f522108h.getText().delete(r114 - 1, r114);
        goto L64
    L66:
        if ("addText".equals(r100) == false) goto L72;
        String r116 = r101.optString("text", "");
        if (this.f522108h.getText() == null) goto L70;
        int r117 = this.f522108h.getSelectionStart();
        this.f522108h.getText().insert(r117, r116);
        this.f522108h.setSelection(r117 + r116.length());
        r102.a(PlatformMethodCallbackResult.SUCCESS);
        goto L71
    L70:
        r102.a(PlatformMethodCallbackResult.UNKNOWN);
        goto L71
    L72:
        return false;
    }
}
