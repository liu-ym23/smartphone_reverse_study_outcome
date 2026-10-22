package om5;

import android.text.SpannableStringBuilder;
import android.widget.TextView;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.AttachmentSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.SegmentStyle;
import db5.g;
import java.util.ArrayList;
import java.util.Iterator;
import xm5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends d {
    public com.bytedance.ee.bear.sheet.cellcontent.a g;

    @Override // xm5.d
    public final /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return k((xm5.a) r1);
    }

    @Override // xm5.d
    public final /* bridge */ /* synthetic */ g c(db5.a r1) throws Exception {
        return k((xm5.a) r1);
    }

    @Override // xm5.d
    public final g k(xm5.a r13) throws Exception {
        g r0 = super.k(r13);
        SpannableStringBuilder r1 = r0.a;
        Iterator r14 = ((ArrayList) r13.e).iterator();
        int r3 = 0;
        int r4 = 0;
    L4:
        if (r14.hasNext() == false) goto L22;
        BaseSegment r5 = (BaseSegment) r14.next();
        int[] r6 = d.l(r3, r4, r5.getText());
        int r7 = r6[0];
        int r8 = r6[1];
        if ((r5 instanceof AttachmentSegment) == false) goto L9;
        r8 = r8 + 15;
        r1.setSpan(new b(this, r5), r7, r8, 17);
    L21:
        r4 = r8;
        r3 = r7;
        goto L4
    L9:
        if ((r5 instanceof MentionSegment) == false) goto L17;
        if (((MentionSegment) r5).isMentionDocument() == false) goto L13;
        r8 = r8 + 15;
    L13:
        un5.a[] r9 = (un5.a[]) r1.getSpans(r7, r8, un5.a.class);
        int r10 = r9.length;
        int r11 = 0;
    L14:
        if (r11 >= r10) goto L21;
        un5.a r12 = r9[r11];
        r12.a = new a(this, r5);
        r11 = r11 + 1;
        goto L14
    L17:
        if ((r5 instanceof HyperLinkSegment) == false) goto L21;
        un5.a[] r15 = (un5.a[]) r1.getSpans(r7, r8, un5.a.class);
        int r16 = r15.length;
        int r17 = 0;
    L19:
        if (r17 >= r16) goto L21;
        un5.a r18 = r15[r17];
        r18.a = new a(this, r5);
        r17 = r17 + 1;
        goto L19
    L22:
        return r0;
    }

    public c(TextView r2, SegmentStyle r3) {
        super(r2, r3, null);
    }
}
