package sq3;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class j extends com.bytedance.android.window.shop.repository.tab.entity.f {
    public static final /* synthetic */ int k = 0;
    public final h j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final void d() {
        Integer r0 = this.b;
        if (r0 == null) goto L10;
        int r1 = r0.intValue();
        h r2 = this.j;
        if (r2 == null) goto L11;
        fo.b r3 = ((WindowV2ProductItemVO) r2).C;
        if (r3 == null) goto L12;
        fo.a r4 = wn.a.a;
        Integer r5 = (Integer) r3.b(wn.a.C, Integer.valueOf(r1));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.j;
    }

    public j(h r3) {
        super(307);
        this.j = r3;
        fo.b r4 = ((WindowV2ProductItemVO) r3).C;
        if (r4 == null) goto L6;
        Integer r5 = (Integer) r4.b(wn.a.f, 307);
        return;
    }
}
