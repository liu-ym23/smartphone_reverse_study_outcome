package com.ss.android.lark.picker;

import com.bytedance.lark.pb.search.v2.UniversalSearchResponse;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.search.dto.Scene;
import com.ss.android.lark.search.dto.SearchResponse;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J8\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&R\u0012\u0010\u0002\u001a\u00020\u0001X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/picker/ISearchResponseParserWrapper;", "", "wrapper", "getWrapper", "()Ljava/lang/Object;", "parse", "Lcom/ss/android/lark/search/dto/SearchResponse;", "requestId", "", AppbrandHostConstants.SCHEMA_INSPECT.SESSION, "seqId", "", "query", "scene", "Lcom/ss/android/lark/search/dto/Scene$Type;", "sdkResponse", "Lcom/bytedance/lark/pb/search/v2/UniversalSearchResponse;", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface ISearchResponseParserWrapper {
    Object getWrapper();

    SearchResponse parse(String r100, String r101, int r102, String r103, Scene.Type r104, UniversalSearchResponse r105);
}
