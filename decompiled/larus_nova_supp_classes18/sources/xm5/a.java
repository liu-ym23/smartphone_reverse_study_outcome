package xm5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import db5.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a extends db5.a {
    public final List<BaseSegment> e;
    public final Map<Object, BaseSegment> f;

    public a() {
        this.e = new ArrayList();
        this.f = new HashMap();
    }

    public a(String r1, bo4.a[] r2, j[] r3, List<BaseSegment> r4, Map<Object, BaseSegment> r5) {
        super(r1, r2, r3);
        ArrayList r6 = new ArrayList();
        this.e = r6;
        HashMap r7 = new HashMap();
        this.f = r7;
        if (r4 == null) goto L5;
        r6.addAll(r4);
    L5:
        r7.putAll(r5);
    }
}
