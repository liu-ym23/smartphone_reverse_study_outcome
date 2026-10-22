package com.bytedance.bdp.appbase.meta.impl.pkg;

import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.monitor.cloudmessage.consts.CloudControlInf;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/bdp/appbase/meta/impl/pkg/TriggerType;", "", "Lcom/bytedance/bdp/appbase/meta/impl/pkg/RequestType;", "mainType", "Lcom/bytedance/bdp/appbase/meta/impl/pkg/RequestType;", "getMainType", "()Lcom/bytedance/bdp/appbase/meta/impl/pkg/RequestType;", "normal", "async", "preload", LiveCommonConstants.REASON_SILENCE, "prefetch_host", "jump_single", "jump_batch", "start_page", CloudControlInf.ROUTE, "cp_preload", "preload_enhance", "bdp-appbase-meta_release"}, k = 1, mv = {1, 4, 0})
public final enum TriggerType extends Enum<TriggerType> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TriggerType[] f200842a = null;
    public static final TriggerType async = null;
    public static final TriggerType cp_preload = null;
    public static final TriggerType jump_batch = null;
    public static final TriggerType jump_single = null;
    public static final TriggerType normal = null;
    public static final TriggerType prefetch_host = null;
    public static final TriggerType preload = null;
    public static final TriggerType preload_enhance = null;
    public static final TriggerType route = null;
    public static final TriggerType silence = null;
    public static final TriggerType start_page = null;
    private final RequestType mainType;

    public static TriggerType valueOf(String r100) {
        return (TriggerType) a.a(TriggerType.class, r100);
    }

    public static TriggerType[] values() {
        return (TriggerType[]) f200842a.clone();
    }

    static {
        RequestType r100 = RequestType.normal;
        TriggerType r101 = new TriggerType("normal", 0, r100);
        normal = r101;
        RequestType r102 = RequestType.async;
        TriggerType r103 = new TriggerType("async", 1, r102);
        async = r103;
        RequestType r104 = RequestType.preload;
        TriggerType r105 = new TriggerType("preload", 2, r104);
        preload = r105;
        TriggerType r106 = new TriggerType(LiveCommonConstants.REASON_SILENCE, 3, RequestType.silence);
        silence = r106;
        TriggerType r107 = new TriggerType("prefetch_host", 4, r100);
        prefetch_host = r107;
        TriggerType r108 = new TriggerType("jump_single", 5, r102);
        jump_single = r108;
        TriggerType r109 = new TriggerType("jump_batch", 6, r102);
        jump_batch = r109;
        TriggerType r110 = new TriggerType("start_page", 7, r100);
        start_page = r110;
        TriggerType r111 = new TriggerType(CloudControlInf.ROUTE, 8, r100);
        route = r111;
        TriggerType r112 = new TriggerType("cp_preload", 9, r100);
        cp_preload = r112;
        TriggerType r113 = new TriggerType("preload_enhance", 10, r104);
        preload_enhance = r113;
        f200842a = new TriggerType[]{r101, r103, r105, r106, r107, r108, r109, r110, r111, r112, r113};
    }

    public final RequestType getMainType() {
        return this.mainType;
    }

    public TriggerType(String r100, int r101, RequestType r102) {
        super(r100, r101);
        this.mainType = r102;
    }
}
