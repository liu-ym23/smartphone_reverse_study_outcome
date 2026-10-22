package xm5;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.EmbedImageSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.PanoSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextLikeSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.TextSegment;
import db5.g;
import db5.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import un5.h;
import un5.l;
import zm5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class d extends i<a> {
    public SegmentStyle e;
    public final un5.d.a f;

    public /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return k((a) r1);
    }

    public /* bridge */ /* synthetic */ g c(db5.a r1) throws Exception {
        return k((a) r1);
    }

    public g k(a r18) throws Exception {
        g r1 = super.c(r18);
        SpannableStringBuilder r2 = r1.a;
        Iterator r3 = ((ArrayList) r18.e).iterator();
        int r5 = 0;
        int r6 = 0;
    L4:
        if (r3.hasNext() == false) goto L36;
        BaseSegment r7 = (BaseSegment) r3.next();
        int[] r8 = l(r5, r6, r7.getText());
        int r9 = r8[0];
        int r10 = r8[1];
        if ((r7 instanceof EmbedImageSegment) == true) goto L35;
        if ((r7 instanceof TextLikeSegment) == false) goto L17;
        TextLikeSegment r11 = (TextLikeSegment) r7;
        List<TextSegment> r12 = r11.getTexts();
        if (r12 == null) goto L35;
        Iterator<TextSegment> r13 = r12.iterator();
        int r14 = r9;
        int r15 = r14;
    L14:
        if (r13.hasNext() == false) goto L35;
        TextSegment r16 = r13.next();
        int[] r17 = l(r14, r15, r16.getText());
        int r19 = r17[0];
        int r110 = r17[1];
        j r111 = new j(((i) this).a, r16);
        r111.b = this.e;
        r2.setSpan(r111, r19, r110, 33);
        r16.setTextLikeSegment(r11);
        r15 = r110;
        r14 = r19;
        goto L14
    L17:
        if ((r7 instanceof AttachmentSegment) == false) goto L20;
        un5.d r20 = new un5.d(((i) this).a);
        r2.insert(r9, "<doc.at.~#_%=`>");
        r2.setSpan(r20, r9, r9 + 15, 33);
        r10 = r10 + 15;
        zm5.b r21 = new zm5.b(((i) this).a, (AttachmentSegment) r7);
        r21.b = this.e;
        r2.setSpan(r21, r9, r10, 33);
        goto L35
    L20:
        if ((r7 instanceof MentionSegment) == false) goto L30;
        int r22 = r9 + 15;
        if (r22 <= r2.length()) goto L24;
        boolean r23 = false;
    L26:
        if (((MentionSegment) r7).isMentionDocument() == false) goto L35;
        if (r23 == false) goto L35;
        r10 = r10 + 15;
        goto L35
    L24:
        char[] r112 = new char[15];
        r2.getChars(r9, r22, r112, 0);
        r23 = TextUtils.equals(String.valueOf(r112), "<doc.at.~#_%=`>");
        goto L26
    L30:
        if ((r7 instanceof TextSegment) == false) goto L33;
        Context r24 = ((i) this).a;
        j r25 = new j(r24, (TextSegment) r7);
        r25.b = this.e;
        r2.setSpan(r25, r9, r10, 33);
        goto L35
    L33:
        if ((r7 instanceof PanoSegment) == false) goto L35;
        zm5.c r26 = new zm5.c(((i) this).a, (PanoSegment) r7);
        r26.b = this.e;
        r2.setSpan(r26, r9, r10, 33);
    L35:
        r6 = r10;
        r5 = r9;
        goto L4
    L36:
        return r1;
    }

    public final un5.d f(TextView r9, bo4.a r10) {
        return new un5.d(((i) this).a, r9, r10.x, r10.c, r10.e, this.f);
    }

    public final un5.e g(db5.a r14, bo4.a r15) {
        a r16 = (a) r14;
        BaseSegment r0 = (BaseSegment) ((HashMap) r16.f).get(r15);
        if ((r0 instanceof MentionSegment) == false) goto L6;
        zm5.e r17 = new zm5.e(((i) this).a, r15.e, r15.c, r15.d, r15.f, r15.x, r15.p, r15.o, r15.n, ((i) this).c);
        SegmentStyle r18 = this.e;
        zm5.i r1 = r17.m;
        r1.b = r18;
        MentionSegment r2 = (MentionSegment) r0;
        r17.n = r2;
        r1.c = r2;
        return r17;
    L6:
        return super.g(r16, r15);
    }

    public final h h(db5.a r4, db5.j r5) {
        a r6 = (a) r4;
        BaseSegment r0 = (BaseSegment) ((HashMap) r6.f).get(r5);
        if ((r0 instanceof HyperLinkSegment) == false) goto L6;
        zm5.f r7 = new zm5.f(((i) this).a, r5.d, ((i) this).c);
        SegmentStyle r8 = this.e;
        zm5.i r1 = r7.e;
        r1.b = r8;
        HyperLinkSegment r2 = (HyperLinkSegment) r0;
        r7.g = r2;
        r1.c = r2;
        return r7;
    L6:
        return super.h(r6, r5);
    }

    public final h i(db5.a r4, bo4.a r5) {
        a r6 = (a) r4;
        BaseSegment r0 = (BaseSegment) ((HashMap) r6.f).get(r5);
        if ((r0 instanceof MentionSegment) == false) goto L6;
        zm5.f r7 = new zm5.f(((i) this).a, r5.f, ((i) this).c);
        SegmentStyle r8 = this.e;
        zm5.i r1 = r7.e;
        r1.b = r8;
        MentionSegment r2 = (MentionSegment) r0;
        r7.g = r2;
        r1.c = r2;
        return r7;
    L6:
        return super.i(r6, r5);
    }

    public final l j(db5.a r13, bo4.a r14) {
        a r15 = (a) r13;
        BaseSegment r0 = (BaseSegment) ((HashMap) r15.f).get(r14);
        if ((r0 instanceof MentionSegment) == false) goto L6;
        zm5.g r16 = new zm5.g(((i) this).a, r14.e, r14.i, r14.j, r14.q, r14.r, r14.u, r14.m, ((i) this).c);
        SegmentStyle r1 = this.e;
        zm5.i r2 = r16.s;
        r2.b = r1;
        MentionSegment r3 = (MentionSegment) r0;
        r16.t = r3;
        r2.c = r3;
        r16.h = r14.l;
        r16.q = r14.y;
        return r16;
    L6:
        return super.j(r15, r14);
    }

    public d(TextView r2, SegmentStyle r3, pn5.g r4) {
        super(r2, null, null);
        this.e = r3;
        this.f = r4;
    }

    public static int[] l(int r2, int r3, String r4) {
        if (r4 == null) goto L5;
        r3 = r4.length() + r3;
        r2 = r3;
    L5:
        return new int[]{r2, r3};
    }
}
