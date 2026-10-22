package lh3;

import com.google.gson.annotations.SerializedName;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Llh3/f;", "", "Llh3/e;", "xiaodianLawConfig", "Llh3/e;", "getXiaodianLawConfig", "()Llh3/e;", "setXiaodianLawConfig", "(Llh3/e;)V", "thirdLawConfig", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setThirdLawConfig", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName(com.alipay.sdk.m.k.b.f25414o)
    private e thirdLawConfig;

    @SerializedName("xiaodian")
    private e xiaodianLawConfig;

    public static final class a {
    }

    public f() {
    }

    static {
        e r100 = new e();
        r100.c(com.bytedance.android.shopping.extensions.j.c(R.string.cancel));
        r100.d(com.bytedance.android.shopping.extensions.j.c(R.string.commerce_law_hint_confirm));
        r100.f(com.bytedance.android.shopping.extensions.j.c(R.string.commerce_normal_desc));
        d r101 = new d();
        r101.e("《小店平台用户协议》");
        r101.c("https://school.jinritemai.com/doudian/web/article/104868?noNav=true&from=douyin_shop_detail");
        r101.d();
        Unit r102 = Unit.INSTANCE;
        d r103 = new d();
        r103.e("《小店平台隐私政策》");
        r103.c("https://school.jinritemai.com/doudian/web/article/104870?noNav=true&from=douyin_shop_detail");
        r103.d();
        r100.e(CollectionsKt.listOf(new d[]{r101, r103}));
    }

    public final e a() {
        return this.thirdLawConfig;
    }
}
