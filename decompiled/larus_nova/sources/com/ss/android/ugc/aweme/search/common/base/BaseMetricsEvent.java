package com.ss.android.ugc.aweme.search.common.base;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.ss.android.ugc.aweme.search.common.utils.ThreadUtils;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchPadSplitService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.GsonUtil;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/BaseMetricsEvent;", ExifInterface.GPS_DIRECTION_TRUE, "", "Companion", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public abstract class BaseMetricsEvent<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f451474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f451475b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b \b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/base/BaseMetricsEvent$Companion;", "", "()V", "KEY_ACTION_TYPE", "", "KEY_AUTHOR_ID", "KEY_CLICK_AREA", "KEY_ENTER_FROM", "KEY_ENTER_FROM_MERGE", "KEY_ENTER_FROM_METHOD", "KEY_ENTER_FROM_SECOND", "KEY_ENTER_METHOD", "KEY_GD_LABEL", "KEY_GROUP_ID", "KEY_HOMEPAGE_MALL_SEARCH_STYLE", "KEY_IMPR_ID", "KEY_IS_SAAS", "KEY_LOG_PB", "KEY_ORIGIN_SEARCH_ID", "KEY_PAGE_NAME", "KEY_PAGE_TYPE", "KEY_PREVIOUS_PAGE", "KEY_QUERY_TAB", "KEY_RAW_QUERY", "KEY_REQUEST_ID", "KEY_RESULTS_FORMAT", "KEY_ROOM_ID", "KEY_SEARCH_ID", "KEY_SEARCH_KEYWORD", "KEY_SEARCH_POSITION", "KEY_SEARCH_SESSION_ID", "KEY_SORT_BY", "KEY_SUG_TYPE", "KEY_TARGET_TAB", "KEY_TARGET_TAB_TYPE", "KEY_TOKEN_TYPE", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
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

    public void d() {
        ThreadUtils r100 = ThreadUtils.f452277a;
        Function0<Unit> r101 = new BaseMetricsEvent$post$1(this);
        r100.getClass();
        ThreadUtils.c(r101);
    }

    public BaseMetricsEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        this.f451474a = r100;
        this.f451475b = new HashMap();
    }

    public static final void a(BaseMetricsEvent r100) {
        r100.c("is_saas", "1");
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        Integer r102 = null;
        if (r101 == null) goto L5;
        ITradeSearchPadSplitService r103 = r101.getITradeSearchPadSplitService();
    L6:
        if (r103 == null) goto L8;
        Integer r104 = Integer.valueOf(r103.getFoldType());
    L9:
        r100.c("ecom_fold_type", String.valueOf(r104));
        if (r103 == null) goto L12;
        r102 = r103.getFoldStatus();
    L12:
        r100.c("ecom_fold_status", String.valueOf(r102));
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void b(Map r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<T> r101 = r100.entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L13;
        Map.Entry r102 = (Map.Entry) r101.next();
        Object r103 = r102.getValue();
        if ((r102.getKey() instanceof String) == false) goto L6;
        if ((r103 instanceof String) == true) goto L11;
        c(String.valueOf(r102.getKey()), GsonProtectorUtils.toJson(GsonUtil.a(), r103));
        goto L6
    L11:
        c(String.valueOf(r102.getKey()), (String) r103);
        goto L6
    }

    public final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        this.f451475b.put(r100, r101);
        return;
    L12:
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r102 = false;
        goto L9
    }
}
