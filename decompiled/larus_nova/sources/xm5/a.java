package xm5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import db5.j;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends db5.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<BaseSegment> f564540e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Object, BaseSegment> f564541f;

    public a() {
        this.f564540e = new ArrayList();
        this.f564541f = new HashMap();
    }

    public a(String r100, bo4.a[] r101, j[] r102, List<BaseSegment> r103, Map<Object, BaseSegment> r104) {
        super(r100, r101, r102);
        ArrayList r105 = new ArrayList();
        this.f564540e = r105;
        HashMap r106 = new HashMap();
        this.f564541f = r106;
        if (r103 == null) goto L5;
        r105.addAll(r103);
    L5:
        r106.putAll(r104);
    }
}
