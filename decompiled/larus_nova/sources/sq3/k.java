package sq3;

import com.bytedance.android.ec.window.base.repository.vo.WindowV2ProductItemVO;

/* JADX INFO: loaded from: classes14.dex */
public final class k extends com.bytedance.android.window.shop.repository.tab.entity.f {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f542990k = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final h f542991j;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final void d() {
        Integer r100 = this.f189553b;
        if (r100 == null) goto L10;
        int r101 = r100.intValue();
        h r102 = this.f542991j;
        if (r102 == null) goto L11;
        fo.b r103 = r102.C;
        if (r103 == null) goto L12;
        fo.a<String> r104 = wn.a.f560404a;
        Integer r105 = (Integer) r103.b(wn.a.C, Integer.valueOf(r101));
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.window.shop.repository.tab.entity.f
    public final WindowV2ProductItemVO c() {
        return this.f542991j;
    }

    public k(h r100) {
        super(308);
        this.f542991j = r100;
        fo.b r101 = r100.C;
        if (r101 == null) goto L6;
        Integer r102 = (Integer) r101.b(wn.a.f560409f, 308);
        return;
    }
}
