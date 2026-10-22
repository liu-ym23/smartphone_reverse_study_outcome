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
import com.larksuite.component.universe_design.edittext.UDEditText;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class l extends sa5.g<AtEditText> implements kn4.m {
    public com.bytedance.ee.bear.widget.b b;
    public p c;
    public c d;
    public final Context e;
    public final AtEditText f;
    public boolean g;
    public final Pattern h;
    public fc5.c i;

    public class a implements Consumer<db5.g> {
        public final /* synthetic */ l a;

        public a(l r1) {
            this.a = r1;
        }

        public final void accept(Object r2) throws Exception {
            l r0 = this.a;
            r0.c((db5.g) r2);
        }
    }

    public class b implements Consumer<Throwable> {
        public b() {
        }

        public final void accept(Object r3) throws Exception {
            tt5.a.l("DocEditTextPresenter", "doAccept: set comment error", (Throwable) r3);
        }
    }

    public class c implements TextWatcher {
        public boolean a;
        public final /* synthetic */ l b;

        public c(l r1) {
            this.b = r1;
            this.a = false;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable r2) {
            tt5.a.h("DocEditTextPresenter", "afterTextChanged: ");
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r1, int r2, int r3, int r4) {
            tt5.a.h("DocEditTextPresenter", "beforeTextChanged: ");
            this.a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v1 */
        /* JADX WARN: Type inference failed for: r5v7 */
        /* JADX WARN: Type inference failed for: r5v8 */
        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence r17, int r18, int r19, int r20) {
            int r2 = r18;
            if (this.a == true) goto L6;
            tt5.a.d("DocEditTextPresenter", "beforeTextChanged not execute, return!!!");
            return;
        L6:
            boolean r5 = 0;
            this.a = false;
            com.bytedance.ee.bear.widget.b r6 = this.b.d();
            r6.getClass();
            tt5.a.b("AtDetector", "s:" + r17 + " ,start:" + r2 + " ,before:" + r19 + " , count:" + r20);
            if (r19 < 0) goto L10;
            if (r20 <= 0) goto L10;
            boolean r9 = true;
        L11:
            if (r19 <= 0) goto L14;
            if (r20 != 0) goto L14;
            boolean r10 = true;
        L15:
            String r11 = "";
            if (r9 == true) goto L18;
            if (r10 == false) goto L61;
            if (r6.b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Delete text");
            if (r2 < (r6.c + 1)) goto L59;
            r6.d -= r19;
            tt5.a.h("AtDetector", "detectOnTextChange: start = " + (r6.c + 1) + ", end = " + r6.d + ", s = " + r17);
            int r12 = r6.c;
            if (r12 < 0) goto L58;
            int r13 = r12 + 1;
            int r14 = r6.d;
            if (r13 > r14) goto L58;
            if (r14 > r17.length()) goto L58;
            r6.b(r17.subSequence(r6.c + 1, r6.d).toString());
        L58:
            tt5.a.k("AtDetector", "detectOnTextChange: Cancel input because of wrong state.");
            r6.c();
            r6.a();
            goto L63
        L59:
            tt5.a.b("AtDetector", "detectOnTextChange: delete at character");
            r6.c();
            r6.a();
        L63:
            fc5.c r7 = this.b.i;
            if (r7 == null) goto L131;
            int r8 = r17.length();
            StringBuilder r15 = new StringBuilder("handleInput s:");
            r15.append(r17);
            r15.append(". length:");
            r15.append(r8);
            r15.append(". start:");
            r15.append(r2);
            r15.append(". startChar:");
            if (r2 >= r8) goto L68;
            Object r16 = Character.valueOf(r17.charAt(r18));
        L69:
            r15.append(r16);
            r15.append(". before:");
            r15.append(r19);
            r15.append(". after:");
            r15.append(r20);
            tt5.a.b("HyperLinkProcessorV2", r15.toString());
            if (r19 < 0) goto L73;
            if (r20 <= 0) goto L73;
            boolean r21 = true;
        L74:
            if (r21 == false) goto L88;
            fc5.d r22 = r7.d;
            if (r22 == null) goto L88;
            int r3 = (r20 - r19) + r2;
            int r110 = r17.length();
            if (r2 < 0) goto L84;
            if (r2 > r110) goto L84;
            if (r3 > r110) goto L84;
            if (r2 > r3) goto L84;
            r11 = String.valueOf(r17.subSequence(r2, r3));
        L86:
            if (r22.a(r11) == false) goto L88;
            tt5.a.h("HyperLinkProcessorV2", "is suit url return");
            return;
        L84:
            tt5.a.d("HyperLinkProcessorV2", "subSequence failed  start " + r2 + " end " + r3 + " size " + r110);
        L88:
            int r23 = r8 - 1;
            int r4 = Math.max(Math.min(r2, r23), 0);
            if (r20 == 0) goto L91;
            r2 = (r2 + r20) - 1;
        L91:
            int r24 = Math.max(Math.min(r2, r23), 0);
            Lazy r25 = LinkUtils.a;
            Intrinsics.checkNotNullParameter(r17, "s");
        L92:
            r4 = r4 - 1;
            if (r4 < 0) goto L98;
            if (r4 >= r17.length()) goto L98;
            if (((Pattern) LinkUtils.a.getValue()).matcher(String.valueOf(r17.charAt(r4))).matches() == true) goto L92;
        L98:
            int r26 = r4 + 1;
            Intrinsics.checkNotNullParameter(r17, "s");
        L99:
            r24 = r24 + 1;
            if (r24 < 0) goto L105;
            if (r24 >= r17.length()) goto L105;
            if (((Pattern) LinkUtils.a.getValue()).matcher(String.valueOf(r17.charAt(r24))).matches() == true) goto L99;
        L105:
            int r27 = r24 - 1;
            if (r17.length() == 0) goto L146;
            if (r26 >= 0) goto L109;
            return;
        L109:
            if (r17.length() <= r27) goto L148;
            CharSequence r0 = r17.subSequence(r26, r27 + 1);
            Lazy r28 = LinkUtils.a;
            Intrinsics.checkNotNullParameter(r0, "orgStr");
            Matcher r29 = ((Pattern) LinkUtils.b.getValue()).matcher(r0);
        L113:
            if (r29.find() == false) goto L149;
            int r1 = r29.start() + r26;
            int r30 = r29.end() + r26;
            if (r30 > 0) goto L118;
        L127:
            String r31 = r29.group();
            Intrinsics.checkNotNullParameter(r31, "orgStr");
            Matcher r32 = ((Pattern) LinkUtils.c.getValue()).matcher(r31);
            r5 = r5;
        L129:
            if (r32.find() == false) goto L113;
            String r33 = r32.group();
            int r34 = (r29.start() + r26) + r32.start();
            int r111 = (r29.start() + r26) + r32.end();
            db5.j[] r112 = new db5.j[1];
            r112[r5] = new db5.j(r5, r33.length(), r33);
            r7.e.add(Single.just(new db5.a(r33, new bo4.a[r5], r112)).map(new db5.i(r7.a, r7.c, null)).subscribe(new fc5.a(r7, r34, r111), new fc5.b()));
            r5 = 0;
            goto L129
        L118:
            if (r30 > r7.a.getText().length()) goto L127;
            un5.h[] r35 = (un5.h[]) r7.a.getText().getSpans(r1, r30, un5.h.class);
            int r36 = 0;
        L132:
        L125:
            e = move-exception;
            tt5.a.e("HyperLinkProcessorV2", "removeSpans", e, r5);
            goto L127
        L122:
            if (r36 >= r35.length) goto L127;
            r7.a.getText().removeSpan(r35[r36]);     // Catch: Exception -> L125
            r36 = r36 + 1;
            goto L132
        L149:
            return;
        L148:
            return;
        L146:
            return;
        L73:
            r21 = false;
            goto L74
        L68:
            r16 = "outOfIndex";
            goto L69
        L131:
            return;
        L61:
            if (r6.b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Modify text, cancel @ mode.");
            r6.c();
            r6.a();
            goto L63
        L18:
            if (TextUtils.equals("@", r17.subSequence(r2, r2 + r20)) == false) goto L36;
            if (r6.b == false) goto L25;
            tt5.a.h("AtDetector", "detectOnTextChange: We are already in @ mode. Cancel last one.");
            r6.c();
            com.bytedance.ee.bear.widget.b.a r37 = r6.a;
            if (r37 == null) goto L24;
            ((h) r37).a.I();
        L34:
            tt5.a.h("AtDetector", "detectOnTextChange: Begin @ mode.");
            r6.b = true;
            r6.c = r2;
            r6.d = r2 + 1;
            r6.e = false;
            r6.b("");
            goto L63
        L24:
            tt5.a.d("AtDetector", "callReBeginAddAt: mAtTriggerListener is null");
            goto L34
        L25:
            boolean r38 = r6.e;
            com.bytedance.ee.bear.widget.b.a r113 = r6.a;
            if (r113 == null) goto L34;
            h r114 = (h) r113;
            AtEditText.c r115 = r114.a.x1;
            if (r115 == null) goto L30;
            r115.a(r38);
        L30:
            kn4.g r116 = r114.a.k1;
            if (r116 == null) goto L33;
            r116.c(r38);
        L33:
            r114.a.I();
            goto L34
        L36:
            if (r6.b == false) goto L63;
            tt5.a.h("AtDetector", "detectOnTextChange: Add text that is not @");
            int r39 = r6.d + (r20 - r19);
            r6.d = r39;
            int r117 = r6.c;
            int r118 = r117 + 1;
            if (r2 < r118) goto L45;
            if (r117 < 0) goto L44;
            if (r118 > r39) goto L44;
            if (r39 > r17.length()) goto L44;
            tt5.a.h("AtDetector", "detectOnTextChange: Change keyword.");
            r6.b(r17.subSequence(r6.c + 1, r6.d).toString());
        L44:
            tt5.a.k("AtDetector", "detectOnTextChange: Cancel input because of wrong state.");
            r6.c();
            r6.a();
            goto L63
        L45:
            tt5.a.k("AtDetector", "detectOnTextChange: input before at character");
            r6.c();
            r6.a();
        L14:
            r10 = false;
        L10:
            r9 = false;
            goto L11
        }
    }

    public void n(bo4.a r1) {
    }

    public void p() {
    }

    public final void Sw() {
        tt5.a.b("DocEditTextPresenter", "endMonitorText: ");
        UDEditText r0 = (AtEditText) b();
        if (r0 != null) goto L6;
        return;
    L6:
        if (this.c != null) goto L8;
        this.c = new p(this);
    L8:
        r0.removeTextChangedListener(this.c);
        r0.removeTextChangedListener(h());
    }

    public final com.bytedance.ee.bear.widget.b d() {
        if (this.b != null) goto L6;
        this.b = new com.bytedance.ee.bear.widget.b();
    L6:
        return this.b;
    }

    public Function<db5.a, db5.g> f() {
        return new db5.i(b(), null, null);
    }

    public final void gr() {
        tt5.a.b("DocEditTextPresenter", "beginMonitorText: ");
        UDEditText r0 = (AtEditText) b();
        if (r0 != null) goto L5;
        return;
    L5:
        r0.addTextChangedListener(h());
        if (this.c != null) goto L8;
        this.c = new p(this);
    L8:
        r0.addTextChangedListener(this.c);
    }

    public c h() {
        if (this.d != null) goto L6;
        this.d = new c(this);
    L6:
        return this.d;
    }

    public db5.l i() {
        return new db5.l();
    }

    public db5.l e() {
        return i();
    }

    public Single<String> g() {
        return Single.just(new db5.g((SpannableStringBuilder) ((AtEditText) b()).getText())).map(new db5.l()).map(new db5.f()).map(new db5.e());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public l(AtEditText r2) {
        super(r2);
        this.g = true;
        this.h = PatternProtector.compile("lark-ccm-native\\s*=\\s*\"(.*?)\"");
        this.f = r2;
        this.e = r2.getContext();
        gr();
    }

    public void c(db5.g r3) {
        UDEditText r0 = (AtEditText) b();
        if (r0 != null) goto L5;
        return;
    L5:
        Sw();
        r0.setText(r3.a);
        if (this.g == false) goto L8;
        r0.setSelection(r3.a.length());
    L8:
        gr();
    }

    public void j(bo4.a r9) {
        n(r9);
        Context r0 = ((AtEditText) b()).getContext();
        SpannableStringBuilder r1 = (SpannableStringBuilder) ((AtEditText) b()).getText();
        com.bytedance.ee.bear.widget.b r2 = this.b;
        r9.a = r2.c;
        r9.b = r2.d;
        r2.c();
        if (r9.a >= 0) goto L5;
    L68:
        tt5.a.k("DocEditTextPresenter", "markAt: at mode is canceled.");
        return;
    L5:
        if (r9.b < 0) goto L68;
        if (TextUtils.isEmpty(r1) == false) goto L11;
        tt5.a.d("DocEditTextPresenter", "markAt: content isEmpty");
        return;
    L11:
        int r3 = r1.length();
        int r4 = r9.b;
        if (r4 <= r3) goto L14;
    L66:
        tt5.a.k("DocEditTextPresenter", "markAt: invalid replace range before first replace. start=" + r9.a + ", end=" + r9.b + ", content length=" + r3);
        return;
    L14:
        if (r9.a > r4) goto L66;
        Sw();
        if (AtUtils.i(r9.c) == false) goto L19;
        r1.replace(r9.a, r9.b, r9.g);
        r9.b = r9.a + r9.g.length();
    L28:
        if (r9.a >= 0) goto L30;
    L64:
        tt5.a.k("DocEditTextPresenter", "markAt: at start and end is wrong.");
        return;
    L30:
        if (r9.b > r1.length()) goto L64;
        tt5.a.b("DocEditTextPresenter", "markAt: at.start = " + r9.a + " | at.end = " + r9.b);
        int r5 = r9.c;
        if (r5 != 0) goto L40;
        tt5.a.b("DocEditTextPresenter", "markAt: add user span");
        un5.l r6 = m(r1, r9, r0);
        int r7 = r9.a;
        int r8 = r9.b;
        r6.getClass();
        r1.setSpan(r6, r7, r8, 33);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.bitable.content.use_language_user_span_enable") == true) goto L37;
    L59:
        int r10 = ((AtEditText) b()).getSelectionStart();
        int r11 = ((AtEditText) b()).getSelectionEnd();
        int r12 = r1.length();
        ((AtEditText) b()).setText(r1);
        p();
        if (AtUtils.a(r12, r10, r11) == false) goto L62;
        ((AtEditText) b()).setSelection(r10, r11);
    L62:
        ((AtEditText) b()).getEditableText().insert(r9.b, " ");
        gr();
        return;
    L37:
        if (TextUtils.equals(r6.a(), r9.g) == true) goto L59;
        r1.setSpan(new un5.j(r6), r9.a, r9.b, 33);
        goto L59
    L40:
        if (r5 != 6) goto L43;
        tt5.a.b("DocEditTextPresenter", "markAt: add group span");
        r1.setSpan(new un5.f(r0, r9.e), r9.a, r9.b, 33);
        goto L59
    L43:
        if (AtUtils.i(r5) == false) goto L58;
        tt5.a.b("DocEditTextPresenter", "markAt: add doc span");
        r1.replace(r9.a, r9.b, "<doc.at.~#_%=`>" + r9.g);
        r9.b = r9.b + 15;
        un5.e r13 = l(r1, r9, r0);
        int r14 = AtUtils.g(r9.c, r9.d);
        boolean r15 = kn4.f.a().d();
        if (TextUtils.isEmpty(r9.x) == false) goto L47;
    L49:
        if (r15 == true) goto L51;
    L55:
        un5.d r16 = new un5.d(this.e, r14, r9.c, r9.e);
    L56:
        un5.d r17 = r16;
    L57:
        int r18 = r9.a;
        r17.getClass();
        r1.setSpan(r17, r18, r18 + 15, 33);
        int r19 = r9.a;
        int r20 = r9.b;
        r13.getClass();
        r1.setSpan(r13, r19, r20, 33);
        goto L59
    L51:
        if (TextUtils.isEmpty(r9.o) == true) goto L55;
        if (TextUtils.isEmpty(r9.n) == true) goto L55;
        Drawable r21 = kn4.f.b().b().a(this.e, r9.o, r9.n, r14);
        r21.setCallback(new o(this, r1, r9));
        r16 = new un5.d(this.e, r21, r9.c, r9.e);
        goto L56
    L47:
        if (this.f == null) goto L49;
        r17 = k(r9);
        goto L57
    L58:
        tt5.a.d("DocEditTextPresenter", "markAt: unkow at type");
        goto L59
    L19:
        String r22 = r9.g;
        if (ou5.a.e() == true) goto L22;
    L26:
        r1.replace(r9.a, r9.b, "@" + r22);
        r9.b = (r9.a + r22.length()) + 1;
        goto L28
    L22:
        if (idb.f.a().isEnable("ccm.fix_mention_content_disable") == true) goto L26;
        if (r9.l == null) goto L26;
        r22 = ou5.a.c(((i0) org.koin.java.a.a(i0.class)).a(), r9.l, r22);
        goto L26
    }

    public un5.d k(bo4.a r8) {
        return new un5.d(this.e, this.f, r8.x, r8.c, r8.e);
    }

    public final void q(String r4) {
        if (TextUtils.isEmpty(r4) == false) goto L6;
        r4 = "";
    L6:
        if (b() != null) goto L8;
    L14:
        tt5.a.b("DocEditTextPresenter", "setRichText richtext is same");
        return;
    L8:
        if (((AtEditText) b()).getText() != null) goto L10;
    L12:
        Flowable.just(r4).map(new db5.d()).map(new db5.i(b(), null, null)).observeOn(fo5.d.d()).subscribe(new a(this), new b());
        return;
    L10:
        if (TextUtils.equals(((AtEditText) b()).getText().toString(), r4) == false) goto L12;
        goto L12
    }

    public un5.e l(Spannable r12, bo4.a r13, Context r14) {
        return new un5.e(r14, r13.e, r13.c, r13.d, r13.f, r13.x, r13.p, r13.o, r13.n, null);
    }

    public un5.l m(Spannable r15, bo4.a r16, Context r17) {
        return new un5.l(r17, r15.toString(), r16.e, null, r16.i, r16.j, r16.l, false, null, r16.u, r16.m, null);
    }

    public void o(int r2, int r3, SpannableStringBuilder r4) {
        ((AtEditText) b()).getEditableText().replace(r2, r3, r4);
    }
}
