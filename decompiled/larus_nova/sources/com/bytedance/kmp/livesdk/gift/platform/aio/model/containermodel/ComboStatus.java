package com.bytedance.kmp.livesdk.gift.platform.aio.model.containermodel;

import com.bytedance.tools.kcp.aio.runtime.RpcEnum;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@RpcEnum(messageName = "webcast.revenue.biz.gift.dialog.ComboStatus")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0087\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/containermodel/ComboStatus;", "", "IDLE", "COMBO", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum ComboStatus extends Enum<ComboStatus> {
    public static final ComboStatus COMBO = null;
    public static final ComboStatus IDLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ComboStatus[] f252243a = null;

    static {
        ComboStatus r100 = new ComboStatus("IDLE", 0);
        IDLE = r100;
        ComboStatus r101 = new ComboStatus("COMBO", 1);
        COMBO = r101;
        f252243a = new ComboStatus[]{r100, r101};
    }

    public static ComboStatus valueOf(String r100) {
        return (ComboStatus) a.a(ComboStatus.class, r100);
    }

    public static ComboStatus[] values() {
        return (ComboStatus[]) f252243a.clone();
    }

    public ComboStatus(String r100, int r101) {
        super(r100, r101);
    }
}
