package com.ss.android.lark.search.parser;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.pb.usearch.PullRenderDSLTemplatesResponse;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/ss/android/lark/search/parser/SearchDynamicTemplateManager$loadLocalAndUpdateTemplateFromNet$1", "Lcom/larksuite/framework/callback/IGetDataCallback;", "Lcom/ss/android/lark/pb/usearch/PullRenderDSLTemplatesResponse;", "onSuccess", "", "data", LynxVideoManagerLite.EVENT_ON_ERROR, "err", "Lcom/larksuite/framework/callback/Entity/ErrorResult;", "search-parser_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchDynamicTemplateManager$loadLocalAndUpdateTemplateFromNet$1 implements IGetDataCallback<PullRenderDSLTemplatesResponse> {
    final /* synthetic */ c this$0;

    public SearchDynamicTemplateManager$loadLocalAndUpdateTemplateFromNet$1(c r100) {
        this.this$0 = r100;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
        Intrinsics.checkNotNullParameter(r100, "err");
        Log.e("LarkSearch.Common.SearchDynamicTemplateManager", "UpdateTemplateFromNet error");
    }

    public void onSuccess(PullRenderDSLTemplatesResponse r100) {
        StringBuilder r101 = new StringBuilder("UpdateTemplateFromNet success， templates: ");
        if (r100 == null) goto L5;
        Map<String, String> r102 = r100.mtemplates;
    L6:
        r101.append(r102);
        Log.i("LarkSearch.Common.SearchDynamicTemplateManager", r101.toString());
        if (r100 == null) goto L12;
        Map<String, String> r103 = r100.mtemplates;
        if (r103 == null) goto L13;
        c r104 = this.this$0;
        r104.f440236a.clear();
        r104.f440236a.putAll(r103);
        r104.f440237b.d().putJSONObject("sp_key_search_dsl_template", r103);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((PullRenderDSLTemplatesResponse) r100);
    }
}
