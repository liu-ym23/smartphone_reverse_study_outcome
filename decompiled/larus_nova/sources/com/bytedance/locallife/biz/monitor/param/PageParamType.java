package com.bytedance.locallife.biz.monitor.param;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/biz/monitor/param/PageParamType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", ConfirmNextAction.ACTION_TYPE_QUERY, "SESSION", "API_TRACK_PARAMS", "SOURCE_DETAIL", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum PageParamType extends Enum<PageParamType> {
    public static final PageParamType API_TRACK_PARAMS = null;
    public static final PageParamType QUERY = null;
    public static final PageParamType SESSION = null;
    public static final PageParamType SOURCE_DETAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageParamType[] f256717a = null;
    private final String value;

    public static PageParamType valueOf(String r100) {
        return (PageParamType) r27.a.a(PageParamType.class, r100);
    }

    public static PageParamType[] values() {
        return (PageParamType[]) f256717a.clone();
    }

    static {
        PageParamType r100 = new PageParamType(ConfirmNextAction.ACTION_TYPE_QUERY, 0, "query");
        QUERY = r100;
        PageParamType r101 = new PageParamType("SESSION", 1, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
        SESSION = r101;
        PageParamType r102 = new PageParamType("API_TRACK_PARAMS", 2, "api_track_params");
        API_TRACK_PARAMS = r102;
        PageParamType r103 = new PageParamType("SOURCE_DETAIL", 3, "source_detail");
        SOURCE_DETAIL = r103;
        f256717a = new PageParamType[]{r100, r101, r102, r103};
    }

    public final String getValue() {
        return this.value;
    }

    public PageParamType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
