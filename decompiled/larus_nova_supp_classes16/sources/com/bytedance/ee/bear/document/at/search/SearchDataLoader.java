package com.bytedance.ee.bear.document.at.search;

import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.atfinder.g;
import com.ss.android.lark.picker.config.Permissions;
import com.ss.android.lark.picker.config.SearcherConfig;
import com.ss.android.lark.search.dto.SearchResponse;
import idb.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class SearchDataLoader {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public SearchDataLoader() {
    }

    public static final String a(SearchResponse r9) {
        List r10 = r9.getInfoList();
        if (r10 == null) goto L6;
        String r11 = CollectionsKt.joinToString$default(r10, ",", "[", "]", 0, null, SearchDataLoader$logStr$1.INSTANCE, 24, null);
        if (r11 == null) goto L6;
        return r11;
    L6:
        return "";
    }

    public static c c(MentionModel r13, String r14, g r16) {
        Intrinsics.checkNotNullParameter(r13, "mentionModel");
        Intrinsics.checkNotNullParameter(r14, "searchType");
        Intrinsics.checkNotNullParameter(r16, "callback");
        StringBuilder r0 = new StringBuilder("search()... searchType: ");
        r0.append(r14);
        r0.append(", mentionModel: ");
        StringBuilder r1 = new StringBuilder("{keyword length: ");
        String r2 = r13.getKeyword();
        if (r2 == null) goto L5;
        Integer r3 = Integer.valueOf(r2.length());
    L6:
        r1.append(r3);
        r1.append(", ownerId: ");
        r1.append(r13.getOwnerId());
        r1.append(", isOwner: ");
        r1.append(r13.isOwner());
        r1.append(", authorIds: ");
        ArrayList r4 = r13.getAuthorIds();
        if (r4 == null) goto L9;
        String r5 = CollectionsKt.joinToString$default(r4, ",", "[", "]", 0, null, null, 56, null);
    L10:
        r1.append(r5);
        r1.append('}');
        r0.append(r1.toString());
        tt5.a.h("SearchDataLoader", r0.toString());
        return new c(BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new SearchDataLoader$search$job$1(r16, r14, r13, null), 3, null));
    L9:
        r5 = null;
        goto L10
    L5:
        r3 = null;
        goto L6
    }

    public static SearcherConfig b(final Set r5, boolean r6, boolean r7, boolean r8, final List r9) {
        SearcherConfig r0 = new SearcherConfig(new Permissions(CollectionsKt.emptyList()));
        if (ou5.a.e() == false) goto L8;
        if (f.a().isEnable("ccm.bytedance_english_name_fallback") == false) goto L8;
        r0.getExtra().setSpotlightTag("CCM_MENTION_SEARCH");
    L8:
        if ((!r5.isEmpty()) == false) goto L10;
        SearcherConfig.doc$default(r0, false, new SearchDataLoader$buildSearchConfig$1$1(r5), 1, null);
        SearcherConfig.wiki$default(r0, false, new SearchDataLoader$buildSearchConfig$1$2(r5), 1, null);
    L10:
        if (r6 == false) goto L12;
        SearcherConfig.chatter$default(r0, false, new SearchDataLoader$buildSearchConfig$1$3(r9), 1, null);
    L12:
        if (r7 == false) goto L14;
        SearcherConfig.group$default(r0, false, SearchDataLoader$buildSearchConfig$1$4.INSTANCE, 1, null);
    L14:
        if (r8 == false) goto L16;
        SearcherConfig.bot$default(r0, false, SearchDataLoader$buildSearchConfig$1$5.INSTANCE, 1, null);
    L16:
        return r0;
    }
}
