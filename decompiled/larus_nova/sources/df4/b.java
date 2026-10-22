package df4;

import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.IFaceCheckBizExtension;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.IWxPayBizExtension;
import com.bytedance.caijing.sdk.infra.base.api.plugin.container.biz.base.IBizExtension;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes15.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Class<? extends IBizExtension>> f468210a = null;

    static {
        f468210a = MapsKt.mapOf(new Pair[]{TuplesKt.to("weixin", IWxPayBizExtension.class), TuplesKt.to("face_verify", IFaceCheckBizExtension.class)});
    }
}
