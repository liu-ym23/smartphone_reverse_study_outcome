package com.bytedance.locallife.dito.view;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0002\u0010\tR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/dito/view/DitoPagerData;", "Ljava/io/Serializable;", DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY, "", com.bytedance.android.ec.core.event.a.KEY_PAGE_ID, ThumbGlideUrl.SOURCE_TEMPLATE, "", "biz_query", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V", "getBiz_query", "()Ljava/util/Map;", "getPage_id", "()Ljava/lang/String;", "getPage_key", "getTemplate", "dito-core-saas_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class DitoPagerData implements Serializable {
    private final Map<String, Object> biz_query;
    private final String page_id;
    private final String page_key;
    private final Map<String, String> template;

    public DitoPagerData() {
        this(null, null, null, null, 15, null);
    }

    public final Map<String, Object> getBiz_query() {
        return this.biz_query;
    }

    public final String getPage_id() {
        return this.page_id;
    }

    public final String getPage_key() {
        return this.page_key;
    }

    public final Map<String, String> getTemplate() {
        return this.template;
    }

    public DitoPagerData(String r100, String r101, Map<String, String> r102, Map<String, ? extends Object> r103) {
        this.page_key = r100;
        this.page_id = r101;
        this.template = r102;
        this.biz_query = r103;
    }

    public /* synthetic */ DitoPagerData(String r100, String r101, Map r102, Map r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
