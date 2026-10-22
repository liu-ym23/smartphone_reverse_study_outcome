package com.bytedance.ee.bear.document.at.search;

import android.text.TextUtils;
import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.bear.atfinder.AtFinderResult;
import com.bytedance.ee.bear.atfinder.MentionModel;
import com.bytedance.ee.bear.atfinder.g;
import com.bytedance.ee.bear.common.DisplayName;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.widgets.tagview.DisplayTagInfoV1;
import com.bytedance.ee.util.avatar.BaseAddAvatarUriSettings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.chat.entity.tag.TagData;
import com.ss.android.lark.chat.entity.tag.TagDataItem;
import com.ss.android.lark.search.dto.SearchResponse;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.search.dto.info.SearchChatInfo;
import com.ss.android.lark.search.dto.info.SearchChatterInfo;
import com.ss.android.lark.search.dto.info.SearchSpaceInfo;
import com.ss.android.lark.search.dto.info.SearchWikiInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.at.search.SearchDataLoader$search$job$1", f = "SearchDataLoader.kt", i = {0, 1}, l = {89, 90}, m = "invokeSuspend", n = {"searchInUserIdsJob", "resultNormal"}, s = {"L$0", "L$0"})
final class SearchDataLoader$search$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ g $callback;
    final /* synthetic */ MentionModel $mentionModel;
    final /* synthetic */ String $searchType;
    private /* synthetic */ Object L$0;
    int label;

    public SearchDataLoader$search$job$1(g r1, String r2, MentionModel r3, Continuation<? super SearchDataLoader$search$job$1> r4) {
        this.$callback = r1;
        this.$searchType = r2;
        this.$mentionModel = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        SearchDataLoader$search$job$1 r0 = new SearchDataLoader$search$job$1(this.$callback, this.$searchType, this.$mentionModel, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r24) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        String r8 = null;
        int r9 = 0;
        if (r2 == 0) goto L10;
        if (r2 == 1) goto L9;
        if (r2 != 2) goto L8;
        SearchResponse r3 = (SearchResponse) this.L$0;
        ResultKt.throwOnFailure(r24);
        Object r4 = r24;
    L46:
        SearchResponse r5 = (SearchResponse) r4;
        tt5.a.h("SearchDataLoader", "resultNormal: " + SearchDataLoader.a(r3) + ", resultInUserIds: " + SearchDataLoader.a(r5));
        int r6 = d.a;
        List r7 = r3.getInfoList();
        if (r7 != null) goto L49;
        r7 = CollectionsKt.emptyList();
    L49:
        List r10 = r5.getInfoList();
        if (r10 != null) goto L52;
        r10 = CollectionsKt.emptyList();
    L52:
        MentionModel r11 = this.$mentionModel;
        Intrinsics.checkNotNullParameter(r7, "normalList");
        Intrinsics.checkNotNullParameter(r10, "inUserIdsList");
        Intrinsics.checkNotNullParameter(r11, "mentionModel");
        tt5.a.h("SearchHelper", "mergeAndSort()... resultNormal size: " + r7.size() + ", resultInUserIds size: " + r10.size());
        if (r7.isEmpty() == false) goto L55;
        List r12 = CollectionsKt.emptyList();
    L96:
        g r13 = this.$callback;
        AtFinderResult r14 = new AtFinderResult();
        r14.keyword = this.$mentionModel.getKeyword();
        int r16 = a.a;
        String r17 = ((i0) org.koin.java.a.c(i0.class, null, null, 6)).a();
        if (r17 != null) goto L99;
        r17 = "";
    L99:
        BaseAddAvatarUriSettings r18 = (BaseAddAvatarUriSettings) SettingManager.getInstance().get(BaseAddAvatarUriSettings.class);
        Intrinsics.checkNotNullParameter(r12, "list");
        Intrinsics.checkNotNullParameter(r17, "languageTag");
        boolean r19 = ou5.a.e();
        ArrayList r110 = new ArrayList();
        Iterator r20 = r12.iterator();
    L101:
        if (r20.hasNext() == false) goto L163;
        SearchSpaceInfo r111 = (SearchBaseInfo) r20.next();
        AtObject r112 = new AtObject();
        DisplayTagInfoV1 r113 = new DisplayTagInfoV1();
        TagData r114 = r111.getTagData();
        if (r114 == null) goto L109;
        List r115 = r114.getTagDataItems();
        if (r115 == null) goto L109;
        TagDataItem r116 = (TagDataItem) CollectionsKt.getOrNull(r115, r9);
        if (r116 == null) goto L109;
        String r117 = r116.getText();
    L110:
        if (r117 != null) goto L112;
        r117 = "";
    L112:
        r113.tag_value = r117;
        r112.setDisplay_tag(r113);
        r112.setExternal(r111.isCrossTenant());
        r112.setLanguage(r17);
        if ((r111 instanceof SearchSpaceInfo) == false) goto L116;
        int r118 = e.a;
        SearchSpaceInfo r119 = r111;
        r112.setType(e.b(r119.getDocType()));
        r112.setToken(r119.getId());
        r112.setId(r119.getId());
        r112.setUrl(r119.getDocUrl());
        r112.setContent(r119.getTitle());
        r112.setIconInfo(r119.getIconInfo());
        r112.setEdit_time(b.a(r111));
    L160:
        if (r112 == null) goto L162;
        r110.add(r112);
    L162:
        r8 = null;
        r9 = 0;
        goto L101
    L116:
        if ((r111 instanceof SearchWikiInfo) == false) goto L119;
        r112.setType(16);
        int r120 = e.a;
        SearchWikiInfo r121 = (SearchWikiInfo) r111;
        r112.setSub_type(e.b(r121.getSpaceInfo().getDocType()));
        r112.setToken(r121.getToken());
        r112.setId(r121.getToken());
        r112.setUrl(r121.getUrl());
        r112.setContent(r121.getTitle());
        r112.setIconInfo(r121.getSpaceInfo().getIconInfo());
        r112.setEdit_time(b.a(r111));
        goto L160
    L119:
        if ((r111 instanceof SearchChatterInfo) == false) goto L157;
        SearchChatterInfo r122 = (SearchChatterInfo) r111;
        if (r122.getChatterType() != Chatter.ChatterType.BOT) goto L123;
        boolean r21 = true;
    L124:
        r112.setType(r9);
        if (r21 == false) goto L127;
        int r22 = 4;
    L128:
        r112.setUserType(r22);
        r112.setToken(r122.getId());
        r112.setId(r122.getId());
        HashMap r23 = r122.getI18nNames();
        if (r23 == null) goto L131;
        String r26 = (String) r23.get("zh_cn");
    L132:
        if (r26 != null) goto L134;
        r26 = "";
    L134:
        HashMap r123 = r122.getI18nNames();
        if (r123 == null) goto L137;
        String r27 = (String) r123.get("en_us");
    L138:
        if (r27 != null) goto L140;
        r27 = "";
    L140:
        DisplayName r124 = new DisplayName();
        if (r19 == true) goto L143;
        String r125 = r122.getName();
    L147:
        r124.setValue(r125);
        r124.setI18n_value(r122.getI18nNames());
        r112.setDisplay_name(r124);
        r112.setI18n_user_name(r122.getI18nNames());
        if (r19 == true) goto L150;
        String r126 = r122.getName();
    L154:
        r112.setName(r126);
        r112.setContent(r112.getName());
        r112.setEn_name(r27);
        r112.setCn_name(r26);
        r112.setAvatarKey(r122.getAvatarKey());
        Integer[] r28 = gu5.a.a;
        r112.setAvatar_url(gu5.a.a(r122.getAvatarKey(), 48, r18));
        r112.setDepartment(r122.getSubTitle());
        r112.setSource(3);
        goto L160
    L150:
        if (TextUtils.isEmpty(r122.getName()) == false) goto L152;
        r126 = r122.getTitle();
        goto L154
    L152:
        r126 = r122.getName();
        goto L154
    L143:
        if (TextUtils.isEmpty(r122.getName()) == false) goto L145;
        r125 = r122.getTitle();
        goto L147
    L145:
        r125 = r122.getName();
        goto L147
    L137:
        r27 = null;
        goto L138
    L131:
        r26 = null;
        goto L132
    L127:
        r22 = 1;
        goto L128
    L123:
        r21 = false;
        goto L124
    L157:
        if ((r111 instanceof SearchChatInfo) == false) goto L159;
        r112.setType(5);
        SearchChatInfo r127 = (SearchChatInfo) r111;
        r112.setToken(r127.getId());
        r112.setId(r127.getId());
        r112.setName(r127.getTitle());
        r112.setContent(r127.getTitle());
        r112.setAvatarKey(r127.getAvatarKey());
        Integer[] r29 = gu5.a.a;
        r112.setAvatar_url(gu5.a.a(r127.getAvatarKey(), 48, r18));
        r112.setUrl(r112.getAvatar_url());
        goto L160
    L159:
        tt5.a.d("DataConverter", "convertList: unknown type: " + r111.getType());
        r112 = null;
    L109:
        r117 = r8;
        goto L110
    L163:
        r14.list = r110;
        r13.b(r14);
        return Unit.INSTANCE;
    L55:
        List r30 = CollectionsKt.toMutableList(CollectionsKt.union(r7, CollectionsKt.toSet(r10)));
        tt5.a.h("SearchHelper", "mergeAndSort()... mergeList size: " + r30.size());
        String r31 = r11.getOwnerId();
        if (r31 != null) goto L58;
        r31 = "";
    L58:
        boolean r32 = r11.isOwner();
        Iterable r33 = r11.getAuthorIds();
        if (r33 != null) goto L61;
        r33 = CollectionsKt.emptyList();
    L61:
        if (r32 == false) goto L63;
    L77:
        int r128 = r30.size();
        r12 = r30;
        if (r128 <= 8) goto L96;
        if (r32 == false) goto L82;
        Set r34 = CollectionsKt.union(SetsKt.setOf(r31), CollectionsKt.toSet(r33));
    L83:
        tt5.a.h("SearchHelper", "mergeAndSort()... toMoveAheadIds size: " + r34.size());
        r12 = r30;
        if (r34.isEmpty() == true) goto L96;
        List r36 = CollectionsKt.slice(r30, RangesKt.until(0, 7));
        ArrayList r37 = new ArrayList();
        List r38 = CollectionsKt.slice(r30, RangesKt.until(7, r30.size()));
        ArrayList r39 = new ArrayList();
        Iterator r40 = r38.iterator();
    L88:
        if (r40.hasNext() == false) goto L95;
        Object r129 = r40.next();
        SearchBaseInfo r130 = (SearchBaseInfo) r129;
        if (r34.contains(r130.getId()) == false) goto L92;
        tt5.a.h("SearchHelper", "mergeAndSort()... move author(" + r130.getId() + ") ahead");
        r37.add(r130);
        boolean r131 = false;
    L93:
        if (r131 == false) goto L88;
        r39.add(r129);
        goto L88
    L92:
        r131 = true;
        goto L93
    L95:
        ArrayList r41 = new ArrayList();
        r41.addAll(r36);
        r41.addAll(r37);
        r41.addAll(r39);
        r12 = r41;
        goto L96
    L82:
        r34 = CollectionsKt.toSet(r33);
        goto L83
    L63:
        if (r31.length() <= 0) goto L65;
        boolean r132 = true;
    L66:
        if (r132 == false) goto L77;
        Iterator r133 = r30.iterator();
        int r134 = 0;
    L69:
        if (r133.hasNext() == false) goto L74;
        if (Intrinsics.areEqual(((SearchBaseInfo) r133.next()).getId(), r31) == true) goto L75;
        r134 = r134 + 1;
    L75:
        if (r134 <= 0) goto L77;
        tt5.a.h("SearchHelper", "mergeAndSort()... move owner(" + r31 + ") to head");
        ListProtector.add(r30, 0, (SearchBaseInfo) ListProtector.remove(r30, r134));
        goto L77
    L74:
        r134 = -1;
        goto L75
    L65:
        r132 = false;
        goto L66
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        Deferred r42 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r24);
        Deferred r43 = r42;
        Object r44 = r24;
    L42:
        SearchResponse r46 = (SearchResponse) r44;
        this.L$0 = r46;
        this.label = 2;
        r4 = r43.await(this);
        if (r4 != r1) goto L45;
        return r1;
    L45:
        r3 = r46;
        goto L46
    L10:
        ResultKt.throwOnFailure(r24);
        CoroutineScope r47 = (CoroutineScope) this.L$0;
        this.$callback.a();
        List r135 = StringsKt.split$default(this.$searchType, new String[]{","}, false, 0, 6, null);
        ArrayList r136 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r135, 10));
        Iterator r137 = r135.iterator();
    L12:
        if (r137.hasNext() == false) goto L18;
        Integer r138 = StringsKt.toIntOrNull(StringsKt.trim((String) r137.next()).toString());
        if (r138 == null) goto L16;
        int r139 = r138.intValue();
    L17:
        r136.add(Boxing.boxInt(r139));
        goto L12
    L16:
        r139 = -1;
        goto L17
    L18:
        ArrayList r140 = new ArrayList();
        Iterator r141 = r136.iterator();
    L20:
        if (r141.hasNext() == false) goto L27;
        Object r142 = r141.next();
        if (((Number) r142).intValue() < 0) goto L24;
        boolean r143 = true;
    L25:
        if (r143 == false) goto L20;
        r140.add(r142);
        goto L20
    L24:
        r143 = false;
        goto L25
    L27:
        boolean r144 = r140.contains(Boxing.boxInt(0));
        Deferred r145 = BuildersKt.async$default(r47, Dispatchers.getIO(), null, new SearchDataLoader$search$job$1$searchNormalJob$1(this.$mentionModel, CollectionsKt.intersect(r140, CollectionsKt.toSet(ArraysKt.asList(com.bytedance.ee.bear.utils.a.a))), r144, r140.contains(Boxing.boxInt(5)), r140.contains(Boxing.boxInt(7)), null), 2, null);
        String r146 = this.$mentionModel.getOwnerId();
        if (r146 != null) goto L30;
        r146 = "";
    L30:
        Set r147 = SetsKt.setOf(r146);
        Iterable r148 = this.$mentionModel.getAuthorIds();
        if (r148 != null) goto L33;
        r148 = CollectionsKt.emptyList();
    L33:
        Set r149 = CollectionsKt.union(r147, CollectionsKt.toSet(r148));
        ArrayList r150 = new ArrayList();
        Iterator r151 = r149.iterator();
    L35:
        if (r151.hasNext() == false) goto L39;
        String r152 = (String) r151.next();
        Intrinsics.checkNotNull(r152);
        Long r153 = StringsKt.toLongOrNull(r152);
        if (r153 == null) goto L35;
        r150.add(r153);
        goto L35
    L39:
        r43 = BuildersKt.async$default(r47, Dispatchers.getIO(), null, new SearchDataLoader$search$job$1$searchInUserIdsJob$1(r150, r144, this.$mentionModel, null), 2, null);
        this.L$0 = r43;
        this.label = 1;
        r44 = r145.await(this);
        if (r44 != r1) goto L42;
        return r1;
    }
}
