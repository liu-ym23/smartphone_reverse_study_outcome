package i25;

import android.text.TextUtils;
import androidx.core.util.Pair;
import com.bytedance.ee.bear.middleground.feed.export.bean.k;
import k25.e0;
import k25.m0;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f488040a = null;

    static {
        f488040a = new a();
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.k
    public final Pair<Integer, String> c(String r100, String r101) {
        m0 r102 = e0.m().A(r100, r101, 0);
        if (r102 != null) goto L6;
        tt5.a.h("OffLineDataImpl", "update feed message : resourceData == null");
        return null;
    L6:
        tt5.a.h("OffLineDataImpl", "update feed message --hasNotPaged: " + r102.a());
        if (TextUtils.isEmpty(r102.f501542c) == false) goto L9;
        return null;
    L9:
        if (r102.a() == true) goto L11;
        return null;
    L11:
        return new Pair(Integer.valueOf(r102.f501540a), r102.f501542c);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.k
    public final int a(String r100, String r101, String r102) {
        m0 r103 = new m0(r100, r101);
        r103.f501542c = r102;
        return e0.m().H(r103);
    }

    @Override // com.bytedance.ee.bear.middleground.feed.export.bean.k
    public final int b(int r100, String r101, String r102, String r103) {
        m0 r104 = new m0(r101, r102);
        r104.f501540a = r100;
        r104.f501542c = r103;
        return e0.m().H(r104);
    }
}
