package xm5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.HyperLinkSegment;
import com.bytedance.ee.bear.sheet.inputbar.at.segment.MentionSegment;
import db5.j;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Function<List<BaseSegment>, a> {
    public b() {
    }

    public final Object apply(Object r34) throws Exception {
        List r4 = (List) r34;
        StringBuilder r0 = new StringBuilder();
        HashMap r5 = new HashMap();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        Iterator r3 = r4.iterator();
    L4:
        if (r3.hasNext() == false) goto L20;
        BaseSegment r6 = (BaseSegment) r3.next();
        int r8 = r0.length();
        String r7 = r6.getText();
        if (r7 != null) goto L8;
        r7 = "";
    L8:
        r0.append(r7);
        int r9 = r8 + r7.length();
        if ((r6 instanceof MentionSegment) == false) goto L15;
        MentionSegment r10 = (MentionSegment) r6;
        MentionSegment.SuiteIcon r11 = r10.getIcon();
        r10.getIconInfo();
        int r12 = r10.getMentionType();
        String r13 = r10.getToken();
        String r14 = r10.getLink();
        String r15 = r10.getText();
        String r16 = r10.getName();
        String r18 = r10.getEn_name();
        String r19 = r10.getIconInfo();
        HashMap<String, String> r20 = r10.getI18n_value();
        boolean r26 = r10.isIs_external();
        if (r11 == null) goto L13;
        int r17 = r11.getType();
        int r27 = r17;
        String r22 = r11.getKey();
        String r21 = r11.getFsUnit();
    L14:
        Iterator r35 = r3;
        bo4.a r110 = new bo4.a(r8, r9, r12, -1, r13, r14, r15, r16, r18, null, r20, r19, r21, r22, r27, false, null, false, r26, "", "", null, null, null, 0);
        r1.add(r110);
        r5.put(r110, r6);
    L18:
        r3 = r35;
        goto L4
    L13:
        r21 = null;
        r22 = null;
        r27 = 0;
        goto L14
    L15:
        r35 = r3;
        if ((r6 instanceof HyperLinkSegment) == false) goto L18;
        j r23 = new j(r8, r9, ((HyperLinkSegment) r6).getLink());
        r2.add(r23);
        r5.put(r23, r6);
        goto L18
    L20:
        return new a(r0.toString(), (bo4.a[]) r1.toArray(new bo4.a[r1.size()]), (j[]) r2.toArray(new j[r2.size()]), r4, r5);
    }
}
