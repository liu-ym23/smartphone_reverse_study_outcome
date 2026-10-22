package com.ss.android.ugc.aweme.search.mob.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.ee.bear.bitable.fieldedit.BitableFieldEditAnalytic;
import com.bytedance.ee.bear.sheet.filter.FilterData;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.search.mob.base.BaseFilterMobEvent;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseFilterMobEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchMobEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class BaseFilterMobEvent<T extends BaseFilterMobEvent<T>> extends BaseSearchMobEvent<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashMap<String, String> f453321e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/BaseFilterMobEvent$Companion;", "", "()V", "BSK", "", "COUPON_META_ID", "CURRENT_ACTIVITY", "FILTER_OPTION", "FILTER_OPTION_ID", "FILTER_OPTION_LIST", "FILTER_OPTION_NUM", "FILTER_OPTION_RANK", "FILTER_OPTION_ROW", "FILTER_OPTION_TYPE", "FILTER_OPTION_WORD_ID", "FILTER_OPTION_WORD_LIST", "FILTER_OPTION_WORD_NAME", "FILTER_OPTION_WORD_POSITION", "FILTER_ORIGIN_SEARCH_ID", "FILTER_SOURCE", "IS_HIDDEN", "IS_SIDEBAR_GUIDE", "POSITION", "PRE_SEARCH_ID", "RANGE", "SEC_FILTER_OPTION", CommonConstant.RETKEY.STATUS, "WORD_POSITION", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    @Override // com.ss.android.ugc.aweme.search.mob.base.BaseMobEvent, com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent
    public final void c() {
    }

    public BaseFilterMobEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        super(r100);
        this.f453321e = new HashMap();
    }

    public final void j(RenderItem.FilterLogParams r100) {
        Intrinsics.checkNotNullParameter(r100, "filterLogParams");
        f("filter_option", r100.f450533a);
        f("filter_option_id", r100.f450534b);
        f("filter_option_type", r100.f450535c);
        f("position", r100.f450536d);
        f("is_hidden", r100.f450537e);
        f("sec_filter_option", r100.f450538f);
        f("filter_option_word_name", r100.f450539g);
        f("filter_option_word_id", r100.f450540h);
        k(r100.f450541i);
        f("filter_option_word_position", r100.f450541i);
        Long r101 = r100.f450542j;
        Long r102 = r100.f450543k;
        if (r101 != null) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        JSONObject r103 = new JSONObject();
        if (r101 == null) goto L9;
        r103.put(BitableFieldEditAnalytic.ProgressFieldEditScene.MIN, r101.longValue());
    L9:
        if (r102 == null) goto L11;
        r103.put(BitableFieldEditAnalytic.ProgressFieldEditScene.MAX, r102.longValue());
    L11:
        f(FilterData.FilterOptionItem.Type.RANGE, r103.toString());
    }

    public void k(String r100) {
        f("word_position", r100);
    }

    @Override // com.ss.android.ugc.aweme.search.mob.base.BaseMobEvent, com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent, com.ss.android.ugc.aweme.search.mob.MetricsEvent
    public final void post(PageFinder r100, String r101) {
        this.f453276a.putAll(this.f453321e);
        super.post(r100, r101);
    }
}
