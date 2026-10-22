package pn5;

import android.content.Context;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.widget.AtEditText;
import com.bytedance.ee.bear.widget.l;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.CollectionsKt;
import kotlin.random.Random;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i extends l implements AtEditText.b {
    public final e j;
    public final xm5.d k;
    public SegmentStyle l;
    public final NetService m;
    public final g n;

    @Override // com.bytedance.ee.bear.widget.AtEditText.b
    public final /* synthetic */ void a() {
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final db5.l e() {
        return new xm5.c();
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final Function<db5.a, db5.g> f() {
        xm5.e r0 = new xm5.e(b());
        r0.e = this.l;
        return r0;
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final void p() {
        Editable r0 = ((AtEditText) b()).getEditableText();
        int r1 = r0.length();
        if (((e[]) r0.getSpans(0, r1, e.class)).length != 0) goto L6;
        r0.setSpan(this.j, 0, r1, 18);
        return;
    }

    public i(AtEditText r4) {
        super(r4);
        g r5 = new g(this);
        this.n = r5;
        this.m = (NetService) org.koin.java.a.a(NetService.class);
        this.k = new xm5.d(b(), this.l, r5);
        this.j = new e(this.e, this.l);
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final void c(db5.g r5) {
        super.c(r5);
        Editable r6 = ((AtEditText) b()).getEditableText();
        int r0 = r6.length();
        if (((e[]) r6.getSpans(0, r0, e.class)).length != 0) goto L6;
        r6.setSpan(this.j, 0, r0, 18);
        return;
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final un5.d k(bo4.a r9) {
        return new un5.d(this.e, this.f, r9.x, r9.c, r9.e, this.n);
    }

    @Override // com.bytedance.ee.bear.widget.AtEditText.b
    public final boolean onPaste(String r1) {
        ((AtEditText) b()).getClass();
        return false;
    }

    public static SegmentStyle r(Spannable r3, int r4) {
        if (r4 >= 0) goto L17;
    L10:
        SegmentStyle r5 = null;
    L11:
        if (r5 == null) goto L21;
        return r5.clone();
    L14:
        e = move-exception;
        tt5.a.e("SheetAtEditTextPresente", "getAdjacentStyle, clone fail", e, false);
        return r5;
    L21:
        return r5;
    L17:
        zm5.j[] r6 = (zm5.j[]) r3.getSpans(r4, r4, zm5.j.class);     // Catch: Throwable -> L8
        if (r6.length <= 0) goto L10;
        r5 = r6[0].getStyle();     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        iu5.d.a("SheetAtEditTextPresente", th);
        goto L10
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final un5.e l(Spannable r12, bo4.a r13, Context r14) {
        zm5.e r10 = new zm5.e(r14, r13.e, r13.c, r13.d, r13.f, r13.x, r13.p, r13.o, r13.n);
        MentionSegment r15 = new MentionSegment();
        r15.setText(r13.g);
        r15.setLink(r13.f);
        int r0 = r13.p;
        if (r0 <= 0) goto L5;
        r15.setIcon(new MentionSegment.SuiteIcon(r13.o, r0, r13.n));
    L5:
        r15.setToken(r13.e);
        int r1 = r13.c;
        if (r1 != sbb.e.n.b) goto L8;
        r15.setMentionType(r13.d);
    L9:
        r15.setStyle(r(r12, r13.a));
        r15.setIconInfo(r13.x);
        r10.n = r15;
        zm5.i r16 = r10.m;
        r16.c = r15;
        r16.b = this.l;
        return r10;
    L8:
        r15.setMentionType(r1);
        goto L9
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final un5.l m(Spannable r19, bo4.a r20, Context r21) {
        zm5.g r8 = new zm5.g(r21, r20.e, r20.i, r20.j, r20.u, r20.m);
        MentionSegment r1 = new MentionSegment();
        r1.setMentionNotify(true);
        r1.setText(r20.g);
        r1.setEn_name(r20.j);
        r1.setLink(r20.f);
        r1.setName(r20.i);
        r1.setToken(r20.e);
        r1.setStyle(r(r19, r20.a));
        r1.setIs_external(r20.u);
        int r2 = k.a;
        ArrayList r9 = new ArrayList(36);
        int r3 = 0;
    L3:
        if (r3 >= 36) goto L12;
        char r4 = "xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".charAt(r3);
        if (r4 != 'x') goto L7;
        String r5 = Integer.toString(Random.Default.nextInt(16), CharsKt.checkRadix(16));
    L11:
        r9.add(r5);
        r3 = r3 + 1;
        goto L3
    L7:
        if (r4 == 'y') goto L9;
        r5 = String.valueOf(r4);
        goto L11
    L9:
        r5 = Integer.toString(Random.Default.nextInt(4) | 8, CharsKt.checkRadix(16));
        goto L11
    L12:
        r1.setMentionId(CollectionsKt.joinToString$default(r9, "", null, null, 0, null, null, 62, null));
        if (r20.c != 0) goto L16;
        r1.setCategory("at-user-block");
    L16:
        if (ou5.a.e() == false) goto L18;
        r1.setI18n_value(r20.l);
        r8.h = r20.l;
    L18:
        r8.t = r1;
        zm5.i r0 = r8.s;
        r0.c = r1;
        r0.b = this.l;
        return r8;
    }

    @Override // com.bytedance.ee.bear.widget.l
    public final void o(int r6, int r7, SpannableStringBuilder r8) {
        SpannableStringBuilder r0 = (SpannableStringBuilder) ((AtEditText) b()).getText();
        if (r0 != null) goto L7;
        tt5.a.d("SheetAtEditTextPresente", "pasteReplaceText, spannableStringBuilder is null");
        return;
    L7:
        if (((e[]) r0.getSpans(0, r0.length(), e.class)).length != 0) goto L9;
        r0.setSpan(this.j, 0, r0.length(), 18);
    L9:
        r0.replace(r6, r7, r8.toString());
        Object[] r9 = r8.getSpans(0, r8.length(), un5.a.class);
        Object[] r1 = r8.getSpans(0, r8.length(), un5.d.class);
        ArrayList r2 = new ArrayList();
        r2.addAll(Arrays.asList(r9));
        r2.addAll(Arrays.asList(r1));
        Iterator r10 = r2.iterator();
    L11:
        if (r10.hasNext() == false) goto L18;
        Object r3 = r10.next();
        int r4 = r8.getSpanStart(r3);
        int r5 = r4 + r6;
        int r11 = r8.getSpanEnd(r3) + r6;
        if (r5 < 0) goto L11;
        if (r5 >= r11) goto L11;
        if (r11 > r0.length()) goto L11;
        Sw();
        r0.setSpan(r3, r5, r11, 33);
        ((AtEditText) b()).setText(r0);
        p();
        gr();
        goto L11
    }
}
