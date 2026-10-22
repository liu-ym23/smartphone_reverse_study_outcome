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

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Function<List<BaseSegment>, a> {
    public b() {
    }

    @Override // io.reactivex.functions.Function
    public final a apply(List<BaseSegment> r310) throws Exception {
        List<BaseSegment> r100 = r310;
        StringBuilder r101 = new StringBuilder();
        HashMap r102 = new HashMap();
        ArrayList r103 = new ArrayList();
        ArrayList r104 = new ArrayList();
        Iterator<BaseSegment> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L20;
        BaseSegment r106 = r105.next();
        int r107 = r101.length();
        String r108 = r106.getText();
        if (r108 != null) goto L8;
        r108 = "";
    L8:
        r101.append(r108);
        int r109 = r107 + r108.length();
        if ((r106 instanceof MentionSegment) == false) goto L15;
        MentionSegment r110 = (MentionSegment) r106;
        MentionSegment.SuiteIcon r111 = r110.getIcon();
        r110.getIconInfo();
        int r112 = r110.getMentionType();
        String r113 = r110.getToken();
        String r114 = r110.getLink();
        String r115 = r110.getText();
        String r116 = r110.getName();
        String r117 = r110.getEn_name();
        String r118 = r110.getIconInfo();
        HashMap<String, String> r210 = r110.getI18n_value();
        boolean r211 = r110.isIs_external();
        if (r111 == null) goto L13;
        int r119 = r111.getType();
        int r212 = r119;
        String r213 = r111.getKey();
        String r214 = r111.getFsUnit();
    L14:
        Iterator<BaseSegment> r311 = r105;
        bo4.a r120 = new bo4.a(r107, r109, r112, -1, r113, r114, r115, r116, r117, null, r210, r118, r214, r213, r212, false, null, false, r211, "", "", null, null, null, 0);
        r103.add(r120);
        r102.put(r120, r106);
    L18:
        r105 = r311;
        goto L4
    L13:
        r214 = null;
        r213 = null;
        r212 = 0;
        goto L14
    L15:
        r311 = r105;
        if ((r106 instanceof HyperLinkSegment) == false) goto L18;
        j r121 = new j(r107, r109, ((HyperLinkSegment) r106).getLink());
        r104.add(r121);
        r102.put(r121, r106);
        goto L18
    L20:
        return new a(r101.toString(), (bo4.a[]) r103.toArray(new bo4.a[r103.size()]), (j[]) r104.toArray(new j[r104.size()]), r100, r102);
    }
}
