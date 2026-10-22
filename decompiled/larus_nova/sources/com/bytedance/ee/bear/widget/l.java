package com.bytedance.ee.bear.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.utils.LinkUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public class l extends sa5.g<AtEditText> implements kn4.m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.bytedance.ee.bear.widget.b f239932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public p f239933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f239934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Context f239935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtEditText f239936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f239937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Pattern f239938h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public fc5.c f239939i;

    public class a implements Consumer<db5.g> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f239940a;

        public a(l r100) {
            this.f239940a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(db5.g r100) throws Exception {
            l r101 = this.f239940a;
            r101.c(r100);
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Throwable r100) throws Exception {
            tt5.a.l("DocEditTextPresenter", "doAccept: set comment error", r100);
        }
    }

    public class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f239941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ l f239942b;

        public c(l r100) {
            this.f239942b = r100;
            this.f239941a = false;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r100) {
            tt5.a.h("DocEditTextPresenter", "afterTextChanged: ");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
            tt5.a.h("DocEditTextPresenter", "beforeTextChanged: ");
            this.f239941a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8 */
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r110, int r111, int r112, int r210) {
            int r100 = r111;
            if (this.f239941a == true) goto L6;
            tt5.a.d("DocEditTextPresenter", "beforeTextChanged not execute, return!!!");
            return;
        L6:
            boolean r101 = 0;
            this.f239941a = false;
            com.bytedance.ee.bear.widget.b r102 = this.f239942b.d();
            r102.getClass();
            tt5.a.b("AtDetector", "s:" + r110 + " ,start:" + r100 + " ,before:" + r112 + " , count:" + r210);
            if (r112 < 0) goto L10;
            if (r210 <= 0) goto L10;
            boolean r103 = true;
        L11:
            if (r112 <= 0) goto L14;
            if (r210 != 0) goto L14;
            boolean r113 = true;
        L15:
            String r114 = "";
            if (r103 == true) goto L18;
            if (r113 == false) goto L61;
            if (r102.f239901b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Delete text");
            if (r100 < (r102.f239902c + 1)) goto L59;
            r102.f239903d -= r112;
            tt5.a.h("AtDetector", "detectOnTextChange: start = " + (r102.f239902c + 1) + ", end = " + r102.f239903d + ", s = " + r110);
            int r104 = r102.f239902c;
            if (r104 < 0) goto L58;
            int r105 = r104 + 1;
            int r115 = r102.f239903d;
            if (r105 > r115) goto L58;
            if (r115 > r110.length()) goto L58;
            r102.b(r110.subSequence(r102.f239902c + 1, r102.f239903d).toString());
        L58:
            tt5.a.k("AtDetector", "detectOnTextChange: Cancel input because of wrong state.");
            r102.c();
            r102.a();
            goto L63
        L59:
            tt5.a.b("AtDetector", "detectOnTextChange: delete at character");
            r102.c();
            r102.a();
        L63:
            fc5.c r106 = this.f239942b.f239939i;
            if (r106 == null) goto L131;
            int r107 = r110.length();
            StringBuilder r108 = new StringBuilder("handleInput s:");
            r108.append(r110);
            r108.append(". length:");
            r108.append(r107);
            r108.append(". start:");
            r108.append(r100);
            r108.append(". startChar:");
            if (r100 >= r107) goto L68;
            Object r116 = Character.valueOf(r110.charAt(r111));
        L69:
            r108.append(r116);
            r108.append(". before:");
            r108.append(r112);
            r108.append(". after:");
            r108.append(r210);
            tt5.a.b("HyperLinkProcessorV2", r108.toString());
            if (r112 < 0) goto L73;
            if (r210 <= 0) goto L73;
            boolean r109 = true;
        L74:
            if (r109 == false) goto L88;
            fc5.d r117 = r106.f476356d;
            if (r117 == null) goto L88;
            int r118 = (r210 - r112) + r100;
            int r119 = r110.length();
            if (r100 < 0) goto L84;
            if (r100 > r119) goto L84;
            if (r118 > r119) goto L84;
            if (r100 > r118) goto L84;
            r114 = String.valueOf(r110.subSequence(r100, r118));
        L86:
            if (r117.a(r114) == false) goto L88;
            tt5.a.h("HyperLinkProcessorV2", "is suit url return");
            return;
        L84:
            tt5.a.d("HyperLinkProcessorV2", "subSequence failed  start " + r100 + " end " + r118 + " size " + r119);
        L88:
            int r120 = r107 - 1;
            int r121 = Math.max(Math.min(r100, r120), 0);
            if (r210 == 0) goto L91;
            r100 = (r100 + r210) - 1;
        L91:
            int r122 = Math.max(Math.min(r100, r120), 0);
            Lazy r123 = LinkUtils.f239809a;
            Intrinsics.checkNotNullParameter(r110, "s");
        L92:
            r121 = r121 - 1;
            if (r121 < 0) goto L98;
            if (r121 >= r110.length()) goto L98;
            if (((Pattern) LinkUtils.f239809a.getValue()).matcher(String.valueOf(r110.charAt(r121))).matches() == true) goto L92;
        L98:
            int r124 = r121 + 1;
            Intrinsics.checkNotNullParameter(r110, "s");
        L99:
            r122 = r122 + 1;
            if (r122 < 0) goto L105;
            if (r122 >= r110.length()) goto L105;
            if (((Pattern) LinkUtils.f239809a.getValue()).matcher(String.valueOf(r110.charAt(r122))).matches() == true) goto L99;
        L105:
            int r125 = r122 - 1;
            if (r110.length() == 0) goto L146;
            if (r124 >= 0) goto L109;
            return;
        L109:
            if (r110.length() <= r125) goto L148;
            CharSequence r126 = r110.subSequence(r124, r125 + 1);
            Lazy r127 = LinkUtils.f239809a;
            Intrinsics.checkNotNullParameter(r126, "orgStr");
            Matcher r128 = ((Pattern) LinkUtils.f239810b.getValue()).matcher(r126);
        L113:
            if (r128.find() == false) goto L149;
            int r129 = r128.start() + r124;
            int r130 = r128.end() + r124;
            if (r130 > 0) goto L118;
        L127:
            String r131 = r128.group();
            Intrinsics.checkNotNullParameter(r131, "orgStr");
            Matcher r132 = ((Pattern) LinkUtils.f239811c.getValue()).matcher(r131);
            r101 = r101;
        L129:
            if (r132.find() == false) goto L113;
            String r133 = r132.group();
            int r134 = (r128.start() + r124) + r132.start();
            int r135 = (r128.start() + r124) + r132.end();
            db5.j[] r136 = new db5.j[1];
            r136[r101] = new db5.j(r101, r133.length(), r133);
            r106.f476357e.add(Single.just(new db5.a(r133, new bo4.a[r101], r136)).map(new db5.i(r106.f476353a, r106.f476355c, null)).subscribe(new fc5.a(r106, r134, r135), new fc5.b()));
            r101 = 0;
            goto L129
        L118:
            if (r130 > r106.f476353a.getText().length()) goto L127;
            un5.h[] r137 = (un5.h[]) r106.f476353a.getText().getSpans(r129, r130, un5.h.class);
            int r138 = 0;
        L132:
        L125:
            e = move-exception;
            tt5.a.e("HyperLinkProcessorV2", "removeSpans", e, r101);
            goto L127
        L122:
            if (r138 >= r137.length) goto L127;
            r106.f476353a.getText().removeSpan(r137[r138]);     // Catch: Exception -> L125
            r138 = r138 + 1;
            goto L132
        L149:
            return;
        L148:
            return;
        L146:
            return;
        L73:
            r109 = false;
            goto L74
        L68:
            r116 = "outOfIndex";
            goto L69
        L131:
            return;
        L61:
            if (r102.f239901b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Modify text, cancel @ mode.");
            r102.c();
            r102.a();
            goto L63
        L18:
            if (TextUtils.equals("@", r110.subSequence(r100, r100 + r210)) == false) goto L36;
            if (r102.f239901b == false) goto L25;
            tt5.a.h("AtDetector", "detectOnTextChange: We are already in @ mode. Cancel last one.");
            r102.c();
            com.bytedance.ee.bear.widget.b.a r139 = r102.f239900a;
            if (r139 == null) goto L24;
            ((h) r139).f239928a.I();
        L34:
            tt5.a.h("AtDetector", "detectOnTextChange: Begin @ mode.");
            r102.f239901b = true;
            r102.f239902c = r100;
            r102.f239903d = r100 + 1;
            r102.f239904e = false;
            r102.b("");
            goto L63
        L24:
            tt5.a.d("AtDetector", "callReBeginAddAt: mAtTriggerListener is null");
            goto L34
        L25:
            boolean r140 = r102.f239904e;
            com.bytedance.ee.bear.widget.b.a r141 = r102.f239900a;
            if (r141 == null) goto L34;
            h r142 = (h) r141;
            AtEditText.c r143 = r142.f239928a.f239855x1;
            if (r143 == null) goto L30;
            r143.a(r140);
        L30:
            kn4.g r144 = r142.f239928a.f239852k1;
            if (r144 == null) goto L33;
            r144.c(r140);
        L33:
            r142.f239928a.I();
            goto L34
        L36:
            if (r102.f239901b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Add text that is not @");
            int r145 = r102.f239903d + (r210 - r112);
            r102.f239903d = r145;
            int r146 = r102.f239902c;
            int r147 = r146 + 1;
            if (r100 < r147) goto L45;
            if (r146 < 0) goto L44;
            if (r147 > r145) goto L44;
            if (r145 > r110.length()) goto L44;
            tt5.a.h("AtDetector", "detectOnTextChange: Change keyword.");
            r102.b(r110.subSequence(r102.f239902c + 1, r102.f239903d).toString());
        L44:
            tt5.a.k("AtDetector", "detectOnTextChange: Cancel input because of wrong state.");
            r102.c();
            r102.a();
            goto L63
        L45:
            tt5.a.k("AtDetector", "detectOnTextChange: input before at character");
            r102.c();
            r102.a();
        L14:
            r113 = false;
        L10:
            r103 = false;
            goto L11
        }
    }

    public void n(bo4.a r100) {
    }

    public void p() {
    }

    @Override // kn4.m
    public final void Sw() {
        tt5.a.b("DocEditTextPresenter", "endMonitorText: ");
        AtEditText r100 = b();
        if (r100 != null) goto L6;
        return;
    L6:
        if (this.f239933c != null) goto L8;
        this.f239933c = new p(this);
    L8:
        r100.removeTextChangedListener(this.f239933c);
        r100.removeTextChangedListener(h());
    }

    public final com.bytedance.ee.bear.widget.b d() {
        if (this.f239932b != null) goto L6;
        this.f239932b = new com.bytedance.ee.bear.widget.b();
    L6:
        return this.f239932b;
    }

    public Function<db5.a, db5.g> f() {
        return new db5.i(b(), null, null);
    }

    @Override // kn4.m
    public final void gr() {
        tt5.a.b("DocEditTextPresenter", "beginMonitorText: ");
        AtEditText r100 = b();
        if (r100 != null) goto L5;
        return;
    L5:
        r100.addTextChangedListener(h());
        if (this.f239933c != null) goto L8;
        this.f239933c = new p(this);
    L8:
        r100.addTextChangedListener(this.f239933c);
    }

    public c h() {
        if (this.f239934d != null) goto L6;
        this.f239934d = new c(this);
    L6:
        return this.f239934d;
    }

    public db5.l i() {
        return new db5.l();
    }

    public db5.l e() {
        return i();
    }

    public Single<String> g() {
        return Single.just(new db5.g((SpannableStringBuilder) b().getText())).map(new db5.l()).map(new db5.f()).map(new db5.e());
    }

    public l(AtEditText r100) {
        super(r100);
        this.f239937g = true;
        this.f239938h = PatternProtector.compile("lark-ccm-native\\s*=\\s*\"(.*?)\"");
        this.f239936f = r100;
        this.f239935e = r100.getContext();
        gr();
    }

    public void c(db5.g r100) {
        AtEditText r101 = b();
        if (r101 != null) goto L5;
        return;
    L5:
        Sw();
        r101.setText(r100.f467817a);
        if (this.f239937g == false) goto L8;
        r101.setSelection(r100.f467817a.length());
    L8:
        gr();
    }

    public void j(bo4.a r100) {
        n(r100);
        Context r101 = ((AtEditText) b()).getContext();
        SpannableStringBuilder r102 = (SpannableStringBuilder) ((AtEditText) b()).getText();
        com.bytedance.ee.bear.widget.b r103 = this.f239932b;
        r100.f19811a = r103.f239902c;
        r100.f19812b = r103.f239903d;
        r103.c();
        if (r100.f19811a >= 0) goto L5;
    L68:
        tt5.a.k("DocEditTextPresenter", "markAt: at mode is canceled.");
        return;
    L5:
        if (r100.f19812b < 0) goto L68;
        if (TextUtils.isEmpty(r102) == false) goto L11;
        tt5.a.d("DocEditTextPresenter", "markAt: content isEmpty");
        return;
    L11:
        int r104 = r102.length();
        int r105 = r100.f19812b;
        if (r105 <= r104) goto L14;
    L66:
        tt5.a.k("DocEditTextPresenter", "markAt: invalid replace range before first replace. start=" + r100.f19811a + ", end=" + r100.f19812b + ", content length=" + r104);
        return;
    L14:
        if (r100.f19811a > r105) goto L66;
        Sw();
        if (AtUtils.i(r100.f19813c) == false) goto L19;
        r102.replace(r100.f19811a, r100.f19812b, r100.f19817g);
        r100.f19812b = r100.f19811a + r100.f19817g.length();
    L28:
        if (r100.f19811a >= 0) goto L30;
    L64:
        tt5.a.k("DocEditTextPresenter", "markAt: at start and end is wrong.");
        return;
    L30:
        if (r100.f19812b > r102.length()) goto L64;
        tt5.a.b("DocEditTextPresenter", "markAt: at.start = " + r100.f19811a + " | at.end = " + r100.f19812b);
        int r106 = r100.f19813c;
        if (r106 != 0) goto L40;
        tt5.a.b("DocEditTextPresenter", "markAt: add user span");
        un5.l r107 = m(r102, r100, r101);
        int r108 = r100.f19811a;
        int r109 = r100.f19812b;
        r107.getClass();
        r102.setSpan(r107, r108, r109, 33);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.bitable.content.use_language_user_span_enable") == true) goto L37;
    L59:
        int r110 = ((AtEditText) b()).getSelectionStart();
        int r111 = ((AtEditText) b()).getSelectionEnd();
        int r112 = r102.length();
        ((AtEditText) b()).setText(r102);
        p();
        if (AtUtils.a(r112, r110, r111) == false) goto L62;
        ((AtEditText) b()).setSelection(r110, r111);
    L62:
        ((AtEditText) b()).getEditableText().insert(r100.f19812b, " ");
        gr();
        return;
    L37:
        if (TextUtils.equals(r107.a(), r100.f19817g) == true) goto L59;
        r102.setSpan(new un5.j(r107), r100.f19811a, r100.f19812b, 33);
        goto L59
    L40:
        if (r106 != 6) goto L43;
        tt5.a.b("DocEditTextPresenter", "markAt: add group span");
        r102.setSpan(new un5.f(r101, r100.f19815e), r100.f19811a, r100.f19812b, 33);
        goto L59
    L43:
        if (AtUtils.i(r106) == false) goto L58;
        tt5.a.b("DocEditTextPresenter", "markAt: add doc span");
        r102.replace(r100.f19811a, r100.f19812b, "<doc.at.~#_%=`>" + r100.f19817g);
        r100.f19812b = r100.f19812b + 15;
        un5.e r113 = l(r102, r100, r101);
        int r114 = AtUtils.g(r100.f19813c, r100.f19814d);
        boolean r115 = kn4.f.a().d();
        if (TextUtils.isEmpty(r100.f19834x) == false) goto L47;
    L49:
        if (r115 == true) goto L51;
    L55:
        un5.d r116 = new un5.d(this.f239935e, r114, r100.f19813c, r100.f19815e);
    L56:
        un5.d r117 = r116;
    L57:
        int r118 = r100.f19811a;
        r117.getClass();
        r102.setSpan(r117, r118, r118 + 15, 33);
        int r119 = r100.f19811a;
        int r120 = r100.f19812b;
        r113.getClass();
        r102.setSpan(r113, r119, r120, 33);
        goto L59
    L51:
        if (TextUtils.isEmpty(r100.f19825o) == true) goto L55;
        if (TextUtils.isEmpty(r100.f19824n) == true) goto L55;
        Drawable r121 = kn4.f.b().b().a(this.f239935e, r100.f19825o, r100.f19824n, r114);
        r121.setCallback(new o(this, r102, r100));
        r116 = new un5.d(this.f239935e, r121, r100.f19813c, r100.f19815e);
        goto L56
    L47:
        if (this.f239936f == null) goto L49;
        r117 = k(r100);
        goto L57
    L58:
        tt5.a.d("DocEditTextPresenter", "markAt: unkow at type");
        goto L59
    L19:
        String r122 = r100.f19817g;
        if (ou5.a.e() == true) goto L22;
    L26:
        r102.replace(r100.f19811a, r100.f19812b, "@" + r122);
        r100.f19812b = (r100.f19811a + r122.length()) + 1;
        goto L28
    L22:
        if (idb.f.a().isEnable("ccm.fix_mention_content_disable") == true) goto L26;
        if (r100.f19822l == null) goto L26;
        r122 = ou5.a.c(((i0) org.koin.java.a.a(i0.class)).a(), r100.f19822l, r122);
        goto L26
    }

    public un5.d k(bo4.a r100) {
        return new un5.d(this.f239935e, this.f239936f, r100.f19834x, r100.f19813c, r100.f19815e);
    }

    public final void q(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = "";
    L6:
        if (b() != null) goto L8;
    L14:
        tt5.a.b("DocEditTextPresenter", "setRichText richtext is same");
        return;
    L8:
        if (b().getText() != null) goto L10;
    L12:
        Flowable.just(r100).map(new db5.d()).map(new db5.i(b(), null, null)).observeOn(fo5.d.d()).subscribe(new a(this), new b());
        return;
    L10:
        if (TextUtils.equals(b().getText().toString(), r100) == false) goto L12;
        goto L12
    }

    public un5.e l(Spannable r110, bo4.a r111, Context r112) {
        return new un5.e(r112, r111.f19815e, r111.f19813c, r111.f19814d, r111.f19816f, r111.f19834x, r111.f19826p, r111.f19825o, r111.f19824n, null);
    }

    public un5.l m(Spannable r110, bo4.a r111, Context r112) {
        return new un5.l(r112, r110.toString(), r111.f19815e, null, r111.f19819i, r111.f19820j, r111.f19822l, false, null, r111.f19831u, r111.f19823m, null);
    }

    public void o(int r100, int r101, SpannableStringBuilder r102) {
        b().getEditableText().replace(r100, r101, r102);
    }
}
