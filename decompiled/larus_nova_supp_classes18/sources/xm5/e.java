package xm5;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import db5.a;
import db5.g;
import db5.i;
import java.util.Arrays;
import java.util.Comparator;
import un5.h;
import un5.l;
import zm5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e<T extends db5.a> extends i<db5.a> {
    public SegmentStyle e;

    public class a implements Comparator<un5.a> {
        public final /* synthetic */ SpannableStringBuilder a;

        public a(SpannableStringBuilder r1) {
            this.a = r1;
        }

        @Override // java.util.Comparator
        public final int compare(un5.a r2, un5.a r3) {
            SpannableStringBuilder r0 = this.a;
            int r4 = r0.getSpanStart(r2);
            SpannableStringBuilder r1 = this.a;
            return r4 - r1.getSpanStart(r3);
        }
    }

    public e(TextView r2) {
        super(r2, null, null);
    }

    public final /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return c((db5.a) r1);
    }

    public final g c(db5.a r12) throws Exception {
        g r13 = super.c(r12);
        SpannableStringBuilder r0 = r13.a;
        int r3 = 0;
        un5.a[] r1 = (un5.a[]) r0.getSpans(0, r0.length(), un5.a.class);
        Arrays.sort(r1, new a(r0));
        int r2 = r1.length;
        int r4 = 0;
    L4:
        if (r3 >= r2) goto L13;
        un5.a r6 = r1[r3];
        int r7 = r0.getSpanStart(r6);
        tt5.a.b("SheetPasteFormatFun", "start: " + r7 + ", index: " + r4);
        if (r7 < 0) goto L12;
        if (r4 < 0) goto L12;
        if (r7 == r4) goto L12;
        if (r4 >= r0.length()) goto L12;
        j r8 = new j(((i) this).a, new TextSegment(r0.subSequence(r4, r7).toString()));
        r8.b = this.e;
        r0.setSpan(r8, r4, r7, 17);
    L12:
        r4 = r0.getSpanEnd(r6);
        r3 = r3 + 1;
        goto L4
    L13:
        if (r4 >= 0) goto L15;
    L17:
        return r13;
    L15:
        if (r4 >= r0.length()) goto L17;
        j r5 = new j(((i) this).a, new TextSegment(r0.subSequence(r4, r0.length()).toString()));
        r5.b = this.e;
        r0.setSpan(r5, r4, r0.length(), 17);
        goto L17
    }

    public final un5.e g(db5.a r11, bo4.a r12) {
        zm5.e r13 = new zm5.e(((i) this).a, r12.e, r12.c, r12.d, r12.f, r12.x, r12.p, r12.o, r12.n);
        MentionSegment r0 = new MentionSegment();
        r0.setText(r12.g);
        r0.setLink(r12.f);
        int r1 = r12.p;
        if (r1 <= 0) goto L5;
        r0.setIcon(new MentionSegment.SuiteIcon(r12.o, r1, r12.n));
    L5:
        r0.setToken(r12.e);
        int r2 = r12.c;
        if (r2 != sbb.e.n.b) goto L8;
        r0.setMentionType(r12.d);
    L9:
        r0.setIconInfo(r12.x);
        r13.n = r0;
        zm5.i r14 = r13.m;
        r14.c = r0;
        r14.b = this.e;
        return r13;
    L8:
        r0.setMentionType(r2);
        goto L9
    }

    public final h h(db5.a r4, db5.j r5) {
        HyperLinkSegment r6 = new HyperLinkSegment();
        r6.setText(r5.c);
        r6.setLink(r5.d);
        zm5.f r0 = new zm5.f(((i) this).a, r5.d, ((i) this).c);
        SegmentStyle r7 = this.e;
        zm5.i r1 = r0.e;
        r1.b = r7;
        r0.g = r6;
        r1.c = r6;
        return r0;
    }

    public final l j(db5.a r8, bo4.a r9) {
        zm5.g r10 = new zm5.g(((i) this).a, r9.e, r9.i, r9.j, r9.u, r9.m);
        MentionSegment r0 = new MentionSegment();
        r0.setText(r9.g);
        r0.setEn_name(r9.j);
        r0.setLink(r9.f);
        r0.setName(r9.i);
        r0.setToken(r9.e);
        r0.setIs_external(r9.u);
        if (r9.c != 0) goto L6;
        r0.setCategory("at-user-block");
    L6:
        if (ou5.a.e() == false) goto L8;
        r0.setI18n_value(r9.l);
        r10.h = r9.l;
    L8:
        r10.t = r0;
        zm5.i r11 = r10.s;
        r11.c = r0;
        r11.b = this.e;
        return r10;
    }
}
