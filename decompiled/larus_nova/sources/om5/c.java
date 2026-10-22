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

/* JADX INFO: loaded from: classes18.dex */
public final class c extends d {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.bytedance.ee.bear.sheet.cellcontent.a f524295g;

    @Override // xm5.d, db5.i, io.reactivex.functions.Function
    public final /* bridge */ /* synthetic */ g apply(Object r100) throws Exception {
        return k((xm5.a) r100);
    }

    @Override // xm5.d, db5.i
    public final /* bridge */ /* synthetic */ g c(db5.a r100) throws Exception {
        return k((xm5.a) r100);
    }

    @Override // xm5.d
    public final g k(xm5.a r110) throws Exception {
        g r100 = super.k(r110);
        SpannableStringBuilder r101 = r100.f467817a;
        Iterator r111 = ((ArrayList) r110.f564540e).iterator();
        int r102 = 0;
        int r103 = 0;
    L4:
        if (r111.hasNext() == false) goto L22;
        BaseSegment r104 = (BaseSegment) r111.next();
        int[] r105 = d.l(r102, r103, r104.getText());
        int r106 = r105[0];
        int r107 = r105[1];
        if ((r104 instanceof AttachmentSegment) == false) goto L9;
        r107 = r107 + 15;
        r101.setSpan(new b(this, r104), r106, r107, 17);
    L21:
        r103 = r107;
        r102 = r106;
        goto L4
    L9:
        if ((r104 instanceof MentionSegment) == false) goto L17;
        if (((MentionSegment) r104).isMentionDocument() == false) goto L13;
        r107 = r107 + 15;
    L13:
        un5.a[] r108 = (un5.a[]) r101.getSpans(r106, r107, un5.a.class);
        int r109 = r108.length;
        int r112 = 0;
    L14:
        if (r112 >= r109) goto L21;
        un5.a r113 = r108[r112];
        r113.f550772a = new a(this, r104);
        r112 = r112 + 1;
        goto L14
    L17:
        if ((r104 instanceof HyperLinkSegment) == false) goto L21;
        un5.a[] r114 = (un5.a[]) r101.getSpans(r106, r107, un5.a.class);
        int r115 = r114.length;
        int r116 = 0;
    L19:
        if (r116 >= r115) goto L21;
        un5.a r117 = r114[r116];
        r117.f550772a = new a(this, r104);
        r116 = r116 + 1;
        goto L19
    L22:
        return r100;
    }

    public c(TextView r100, SegmentStyle r101) {
        super(r100, r101, null);
    }
}
