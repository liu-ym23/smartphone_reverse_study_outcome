package zy1;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR*\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R*\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u000e\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010\"\u0004\b\u0019\u0010\u0012¨\u0006\u001c"}, d2 = {"Lzy1/b;", "", "", "maxDisplayTimePreDay", "I", "d", "()I", "setMaxDisplayTimePreDay", "(I)V", "maxNoTapTime", "e", "setMaxNoTapTime", "", "giftPriceRange", "Ljava/util/List;", "c", "()Ljava/util/List;", "setGiftPriceRange", "(Ljava/util/List;)V", "", "giftGuideBgList", "b", "setGiftGuideBgList", "giftGuideAnimList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setGiftGuideAnimList", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("gift_guide_anim_list")
    private List<String> giftGuideAnimList;

    @SerializedName("gift_guide_bg_list")
    private List<String> giftGuideBgList;

    @SerializedName("gift_price_range")
    private List<Integer> giftPriceRange;

    @SerializedName("max_display_time_pre_day")
    private int maxDisplayTimePreDay;

    @SerializedName("max_no_tap_time")
    private int maxNoTapTime;

    public b() {
        this.maxDisplayTimePreDay = 5;
        this.maxNoTapTime = 100;
        this.giftPriceRange = new ArrayList(CollectionsKt.listOf(new Integer[]{0, 100, 1000}));
        this.giftGuideBgList = new ArrayList();
        this.giftGuideAnimList = new ArrayList();
    }

    public final List<String> a() {
        return this.giftGuideAnimList;
    }

    public final List<String> b() {
        return this.giftGuideBgList;
    }

    public final List<Integer> c() {
        return this.giftPriceRange;
    }

    public final int d() {
        return this.maxDisplayTimePreDay;
    }

    public final int e() {
        return this.maxNoTapTime;
    }
}
