package com.ss.android.ugc.aweme.search.mob.base;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.promotion.ECFindSimilarConfig;
import com.ss.android.ugc.aweme.discover.viewmodel.ECSearchEnterViewModel;
import com.ss.android.ugc.aweme.search.common.ECEntranceLogManager;
import com.ss.android.ugc.aweme.search.mob.BaseMetricsEvent;
import com.ss.android.ugc.aweme.search.mob.base.TrendingWordsMobEvent;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0016\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0001\u0007J\u0017\u0010\u0005\u001a\u00028\u00002\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/TrendingWordsMobEvent;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/ss/android/ugc/aweme/search/mob/base/BaseSearchMobEvent;", "", "param", "query", "(Ljava/lang/String;)Lcom/ss/android/ugc/aweme/search/mob/base/TrendingWordsMobEvent;", "Companion", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class TrendingWordsMobEvent<T extends TrendingWordsMobEvent<T>> extends BaseSearchMobEvent<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f453328e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f453329f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f453330g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f453331h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f453332i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final String f453333j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f453334k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f453335l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f453336m = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f453337n = null;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f453338o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f453339p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f453340q = null;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f453341r = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final String f453342s = null;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f453343t = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b'\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b'\u0010(R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0014\u0010\n\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0014\u0010\f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0011\u0010\u0004R\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0004R\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0004R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0004R\u0014\u0010\u0015\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0004R\u0014\u0010\u0016\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0004R\u0014\u0010\u0017\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0004R\u0014\u0010\u0018\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0004R\u0014\u0010\u0019\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0004R\u0014\u0010\u001a\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0004R\u0014\u0010\u001b\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0004R\u0014\u0010\u001c\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0004R\u0014\u0010\u001d\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0004R\u0014\u0010\u001e\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0004R\u0014\u0010\u001f\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001f\u0010\u0004R\u0014\u0010 \u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b \u0010\u0004R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b!\u0010\u0004R\u0014\u0010\"\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0004R\u0014\u0010#\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0004R\u0014\u0010$\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b$\u0010\u0004R\u0014\u0010%\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b%\u0010\u0004R\u0014\u0010&\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b&\u0010\u0004¨\u0006)"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/base/TrendingWordsMobEvent$Companion;", "", "", "ACTIVITY_ID", "Ljava/lang/String;", "AI_BUTTON_STATUS", "AWEME_ECOM_SEARCH_REFRESH", "BACK_REFRESH", "CARD_TYPE", "CHANNEL_ID", "COIN_AMOUNT", "COUPON_APPLY_TYPE", "COUPON_BSK", "COUPON_IDS", "COUPON_META_IDS", "DIRECTLY_INTO", "GS_WORDS_TYPE", "GS_WORDS_TYPE_DROP_FILTER", "GS_WORDS_TYPE_TEXT_FILTER", "IS_COUPON_PACKAGE", "IS_FROM_PHONE_NUM", "PAGE_COLUMN_TYPE", "PAGE_NAME", "PITAYA_UPLOAD_INFO", "QUERY_TAB", "REAL_WORDS_LIST", "REFRESH_TYPE", "SAR_FROM", "SCAN_TIME", "SEARCH_ENTRANCE", "SUB_WORDS_SOURCE", "TARGET_TAB", "TARGET_TAB_TYPE", "TITLE_CONTENT", "UPDATE_TYPE", "USE_CACHE", "VIDEO_PLAY_DURATION", "WORDS_LINE", "WORDS_LIST", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
        f453328e = "words_num";
        f453329f = "words_source";
        f453330g = "words_position";
        f453331h = "words_content";
        f453332i = "raw_query";
        f453333j = "query";
        f453334k = "search_position";
        f453335l = "query_id";
        f453336m = "sug_type";
        f453337n = "user_tag";
        f453338o = a.KEY_TAG_TYPE;
        f453339p = "after_feed_params";
        f453340q = "sug_enter_type";
        f453341r = "pre_search_query";
        f453342s = "page_type";
        f453343t = "is_search_button";
    }

    public final void j() {
        ECSearchEnterViewModel.Companion.getClass();
        WeakReference r100 = ECSearchEnterViewModel.access$getCurrentActivityRef$cp();
        if (r100 == null) goto L5;
        Activity r101 = (Activity) r100.get();
    L6:
        SearchEnterParam r102 = ECSearchEnterViewModel.Companion.b(r101);
        if (r102 == null) goto L9;
        l(r102);
        f(ECFindSimilarConfig.ENTER_FROM_SECOND, r102.getEnterFromSecond());
        f("enter_from", r102.getEnterSearchFrom());
    L9:
        String r103 = ECEntranceLogManager.b();
        Intrinsics.checkNotNullParameter("search_session_id", "key");
        BaseMetricsEvent.ParamRule.f453279a.getClass();
        b("search_session_id", r103, BaseMetricsEvent.ParamRule.Companion.f453280a);
        return;
    L5:
        r101 = null;
        goto L6
    }

    public final void k() {
        ECSearchEnterViewModel.Companion.getClass();
        WeakReference r100 = ECSearchEnterViewModel.access$getCurrentActivityRef$cp();
        if (r100 == null) goto L5;
        Activity r101 = (Activity) r100.get();
    L6:
        SearchEnterParam r102 = ECSearchEnterViewModel.Companion.b(r101);
        if (r102 == null) goto L10;
        l(r102);
        f(ECFindSimilarConfig.ENTER_FROM_SECOND, r102.getEnterFromSecond());
        f("enter_from", r102.getEnterSearchFrom());
        return;
    L10:
        return;
    L5:
        r101 = null;
        goto L6
    }

    public TrendingWordsMobEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        super(r100);
    }

    public final void l(SearchEnterParam r100) {
        f("search_entrance_style", r100.getHomepageMallSearchStyle());
        if (r100.getHomepageMallSearchButton() != null) goto L5;
        String r101 = null;
    L6:
        f("is_search_button", r101);
        return;
    L5:
        r101 = String.valueOf(r100.getHomepageMallSearchButton());
        goto L6
    }

    public final void m(Integer r100) {
        String r101 = f453330g;
        if (r100 == null) goto L5;
        String r102 = String.valueOf(r100.intValue());
    L6:
        f(r101, r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public final T query(String r100) {
        f(f453333j, r100);
        return this;
    }
}
