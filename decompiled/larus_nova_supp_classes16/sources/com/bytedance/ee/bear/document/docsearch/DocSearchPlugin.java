package com.bytedance.ee.bear.document.docsearch;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lark.dependency.g0;
import com.bytedance.lark.pb.basic.v1.Doc;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.service.SearchContext;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/docsearch/DocSearchPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "tag", "", "mSearchLifecycleObserver", "Lcom/ss/android/lark/search/dto/service/ISearchLifecycleObserver;", "mRequestId", "searchQueryKey", "searchDocTypesKey", "searchResultKey", "searchErrorKey", "searchTokenKey", "searchTitleKey", "getBridgeHandlers", "", "handlersHolder", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "DocSearchHandler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocSearchPlugin extends DocumentPlugin {
    private String mRequestId;
    private z3c.a mSearchLifecycleObserver;
    private final String searchDocTypesKey;
    private final String searchErrorKey;
    private final String searchQueryKey;
    private final String searchResultKey;
    private final String searchTitleKey;
    private final String searchTokenKey;
    private final String tag;

    public final class a implements i<String> {
        public final /* synthetic */ DocSearchPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(DocSearchPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, final m r11) {
            String r12 = (String) r10;
            if (r12 == null) goto L26;
            final DocSearchPlugin r0 = this.a;
            JSONObject r1 = new JSONObject(r12);
            DocSearchPlugin.access$setMRequestId$p(r0, com.ss.android.lark.sdk.a.a());
            if (DocSearchPlugin.access$getMSearchLifecycleObserver$p(r0) == null) goto L22;
            z3c.a r13 = DocSearchPlugin.access$getMSearchLifecycleObserver$p(r0);
            if (r13 == null) goto L24;
            String r2 = DocSearchPlugin.access$getMRequestId$p(r0);
            SearchContext r3 = new SearchContext();
            String r4 = r1.optString(DocSearchPlugin.access$getSearchQueryKey$p(this.a));
            Intrinsics.checkNotNullParameter(r4, "<set-?>");
            r3.b = r4;
            r3.a(Scene.Type.SEARCH_SPACE);
            Intrinsics.checkNotNullParameter(SearchContext.DocSearchContentType.ONLY_MATCH_TITLE, "<set-?>");
            Intrinsics.checkNotNullParameter(SearchContext.DocCategory.ALL, "<set-?>");
            ArrayList r5 = new ArrayList();
            JSONArray r6 = r1.optJSONArray(DocSearchPlugin.access$getSearchDocTypesKey$p(this.a));     // Catch: Exception -> L19
            int r7 = r6.length();     // Catch: Exception -> L19
            if (r7 < 0) goto L21;
            int r8 = 0;
        L12:
            if (Intrinsics.areEqual(JSONArrayProtectorUtils.getString(r6, r8), "bitable") == false) goto L15;
            Doc.Type r9 = Doc.Type.BITABLE;     // Catch: Exception -> L19
        L16:
            r5.add(r9);     // Catch: Exception -> L19
            if (r8 == r7) goto L21;
            r8 = r8 + 1;
            goto L12
        L15:
            r9 = Doc.Type.UNKNOWN;     // Catch: Exception -> L19
        L21:
            r3.v = r5;
            r13.onSearch(r2, r3, new DocSearchPlugin$DocSearchHandler$handle$1$1(this, r11, r0));
            Unit r14 = Unit.INSTANCE;
        L25:
            if (r14 == null) goto L26;
            return;
        L19:
            e = move-exception;
            tt5.a.d(DocSearchPlugin.access$getTag$p(this.a), "parseDocTypes error" + e.getMessage());
        L24:
            r14 = null;
            goto L25
        L22:
            if (r11 == null) goto L24;
            com.alibaba.fastjson.JSONObject r16 = new com.alibaba.fastjson.JSONObject();
            r16.put(DocSearchPlugin.access$getSearchErrorKey$p(r0), "search error with empty context!!");
            r11.b(r16);
            r14 = Unit.INSTANCE;
        L26:
            DocSearchPlugin r17 = this.a;
            com.alibaba.fastjson.JSONObject r18 = new com.alibaba.fastjson.JSONObject();
            r18.put(DocSearchPlugin.access$getSearchErrorKey$p(r17), "can not search with empty info");
            if (r11 == null) goto L34;
            r11.b(r18);
            Unit r19 = Unit.INSTANCE;
            return;
        }
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public DocSearchPlugin() {
        this.tag = "DocSearchPlugin";
        this.mRequestId = "";
        this.searchQueryKey = "searchText";
        this.searchDocTypesKey = "docTypes";
        this.searchResultKey = "results";
        this.searchErrorKey = "error";
        this.searchTokenKey = "token";
        this.searchTitleKey = "title";
    }

    public static final /* synthetic */ String access$getMRequestId$p(DocSearchPlugin r0) {
        return r0.mRequestId;
    }

    public static final /* synthetic */ z3c.a access$getMSearchLifecycleObserver$p(DocSearchPlugin r0) {
        return r0.mSearchLifecycleObserver;
    }

    public static final /* synthetic */ String access$getSearchDocTypesKey$p(DocSearchPlugin r0) {
        return r0.searchDocTypesKey;
    }

    public static final /* synthetic */ String access$getSearchErrorKey$p(DocSearchPlugin r0) {
        return r0.searchErrorKey;
    }

    public static final /* synthetic */ String access$getSearchQueryKey$p(DocSearchPlugin r0) {
        return r0.searchQueryKey;
    }

    public static final /* synthetic */ String access$getSearchResultKey$p(DocSearchPlugin r0) {
        return r0.searchResultKey;
    }

    public static final /* synthetic */ String access$getSearchTitleKey$p(DocSearchPlugin r0) {
        return r0.searchTitleKey;
    }

    public static final /* synthetic */ String access$getSearchTokenKey$p(DocSearchPlugin r0) {
        return r0.searchTokenKey;
    }

    public static final /* synthetic */ String access$getTag$p(DocSearchPlugin r0) {
        return r0.tag;
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.searchDocument", new a(this));
    }

    public void onAttachToHost(DocumentPluginHost r3) {
        super.onAttachToHost(r3);
        this.mSearchLifecycleObserver = ((g0) org.koin.java.a.c(g0.class, null, null, 6)).getSearchLifecycleObserver();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setMRequestId$p(DocSearchPlugin r0, String r1) {
        r0.mRequestId = r1;
    }
}
