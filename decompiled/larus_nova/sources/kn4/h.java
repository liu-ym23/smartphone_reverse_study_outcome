package kn4;

import android.view.View;
import com.bytedance.ee.bear.at.AtConstant$Zone;
import com.bytedance.ee.bear.utils.AtUtils;
import com.bytedance.ee.bear.widget.AtFinderView;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: loaded from: classes15.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f504230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f504231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f504232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f504233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bo4.c f504234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f504235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f504236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f504237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f504238i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ArrayList<String> f504239j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f504240k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public AtFinderView f504241l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f504242m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f504243n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f504244o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public com.bytedance.ee.bear.atfinder.f f504245p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ArrayList<View> f504246q;

    public final ArrayList<String> a() {
        ArrayList<String> r100 = this.f504239j;
        if (r100 != null) goto L5;
    L9:
        ArrayList<String> r101 = new ArrayList();
        r101.addAll(AtUtils.c());
        r101.addAll(Arrays.asList(com.bytedance.ee.bear.utils.a.f239814c));
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L9;
        return this.f504239j;
    }

    public h(bo4.c r100, sbb.e r101, String r102) {
        this(r100, AtUtils.h(r101), r102, AtConstant$Zone.PART_COMMENT, AtConstant$Zone.PART_COMMENT);
    }

    public h(bo4.c r100, int r101, String r102, String r103, String r104) {
        this.f504240k = 0;
        this.f504246q = new ArrayList();
        this.f504230a = r101;
        this.f504234e = r100;
        this.f504231b = r102;
        this.f504232c = r103;
        this.f504233d = r104;
        AtUtils.f239808c.clear();
    }
}
