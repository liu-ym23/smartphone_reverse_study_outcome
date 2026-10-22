package jc;

import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.btm.api.model.d;
import com.bytedance.android.btm.api.model.l;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f498067a = null;

    public a() {
    }

    @Override // jc.b
    public final void appendPageParams(PageFinder r100, String r101, BcmParams r102) {
    }

    @Override // jc.b
    public final void appendUnitParams(PageFinder r100, String r101, BcmParams r102) {
    }

    @Override // jc.b
    public final void configBusiness(String r100, kc.b r101) {
    }

    @Override // jc.b
    public final kc.a getBcmChainByBtmModel(d r100, List<String> r101, int r102, boolean r103) {
        return null;
    }

    @Override // jc.b
    public final kc.a getBcmChainByFinder(PageFinder r100, List<String> r101, int r102, boolean r103) {
        return null;
    }

    @Override // jc.b
    public final kc.a getBcmChainByToken(String r100, List<String> r101, int r102, boolean r103) {
        return null;
    }

    @Override // jc.b
    public final void init() {
    }

    @Override // jc.b
    public final void registerExtraChecker(kc.d r100) {
    }

    @Override // jc.b
    public final void setBcmPageParams(PageFinder r100, BcmParams r101, boolean r102) {
    }

    @Override // jc.b
    public final boolean setBcmParams(PageFinder r100, Map<String, ? extends Object> r101) {
        return false;
    }

    @Override // jc.b
    public final boolean setBcmParamsV2(PageFinder r100, Map<String, ? extends Object> r101) {
        return false;
    }

    @Override // jc.b
    public final void setPageEventParams(PageFinder r100, Map<String, ? extends Object> r101) {
    }

    @Override // jc.b
    public final void setPageParams(PageFinder r100, String r101, BcmParams r102) {
    }

    @Override // jc.b
    public final void setUnitParams(PageFinder r100, String r101, BcmParams r102) {
    }

    @Override // jc.b
    public final void setUnitParamsV2(PageFinder r100, Map<String, ? extends Object> r101) {
    }

    static {
        f498067a = new a();
    }

    @Override // jc.b
    public final Map<String, Object> getBcmPassThroughMap(l r100) {
        return MapsKt.emptyMap();
    }
}
