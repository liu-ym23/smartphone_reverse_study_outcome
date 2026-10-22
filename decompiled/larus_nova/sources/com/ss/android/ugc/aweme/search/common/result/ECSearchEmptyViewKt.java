package com.ss.android.ugc.aweme.search.common.result;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.discover.model.SearchClickLinkConfig;
import com.ss.android.ugc.aweme.search.common.mob.SearchFeedbackClickMobEvent;
import com.ss.android.ugc.aweme.search.common.mob.SearchFeedbackShowMobEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"ec-search-impl_saasRelease"}, k = 2, mv = {1, 4, 3})
public final class ECSearchEmptyViewKt {
    public static void b(String r100, String r101, String r102) {
        SearchFeedbackClickMobEvent r103 = new SearchFeedbackClickMobEvent();
        r103.f("search_keyword", r102);
        r103.f("search_id", r101);
        r103.f("impr_id", r101);
        r103.f("enter_from", r100);
        r103.f(SearchFeedbackClickMobEvent.f451773f, null);
        r103.post(null, null);
    }

    public static void c(String r100, String r101, String r102) {
        SearchFeedbackShowMobEvent r103 = new SearchFeedbackShowMobEvent();
        r103.f("search_keyword", r102);
        r103.f("search_id", r101);
        r103.f("impr_id", r101);
        r103.f("enter_from", r100);
        r103.f(SearchFeedbackShowMobEvent.f451775f, null);
        r103.post(null, null);
    }

    public static final CharSequence a(final Context r100, CharSequence r101, final SearchClickLinkConfig r102, final MobListener r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        if (r102 != null) goto L5;
    L10:
        return r101;
    L5:
        if (TextUtils.isEmpty(r102.getTitle()) == true) goto L10;
        if (TextUtils.isEmpty(r102.getSchema()) == true) goto L10;
        String r103 = r102.getTitle();
        Intrinsics.checkNotNull(r103);
        SpannableString r104 = new SpannableString(r101 + ' ' + r103);
        int r105 = StringsKt.indexOf$default(r104, r103, 0, false, 6, null);
        int r106 = r104.length();
        SpannableStringBuilder r107 = new SpannableStringBuilder(r104);
        r107.setSpan(new ECSearchEmptyViewKt$getCommodityTextSpan$1(r100, r102, r110), r105, r106, 34);
        r110.onShow();
        return r107;
    }
}
