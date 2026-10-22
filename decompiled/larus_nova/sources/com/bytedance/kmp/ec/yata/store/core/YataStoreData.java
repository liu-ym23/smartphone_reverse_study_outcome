package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.perf.AbsPerfMonitor;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class YataStoreData implements ba6.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final YataStoreWrapper f251717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.protocol.data.n f251718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final aa6.a f251719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StoreType f251720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f251721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f251722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AbsPerfMonitor f251723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Unit> f251724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f251725i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/kmp/ec/yata/store/core/YataStoreData$StoreType;", "", "MERGE", "OVERWRITE", "yata-store-kmp_release"}, k = 1, mv = {1, 7, 0})
    public static final enum StoreType extends Enum<StoreType> {
        public static final StoreType MERGE = null;
        public static final StoreType OVERWRITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ StoreType[] f251726a = null;

        public static StoreType valueOf(String r100) {
            return (StoreType) r27.a.a(StoreType.class, r100);
        }

        public static StoreType[] values() {
            return (StoreType[]) f251726a.clone();
        }

        static {
            StoreType r100 = new StoreType("MERGE", 0);
            MERGE = r100;
            StoreType r101 = new StoreType("OVERWRITE", 1);
            OVERWRITE = r101;
            f251726a = new StoreType[]{r100, r101};
        }

        public StoreType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final void a() {
        if (Intrinsics.areEqual(this.f251719c, aa6.a.b.C0039a.f2349b) == false) goto L5;
    L6:
        com.bytedance.kmp.ec.yata.common.protocol.data.n r100 = this.f251718b;
        if (r100 == null) goto L11;
        Map<String, com.bytedance.kmp.ec.yata.common.protocol.data.p> r101 = r100.getData();
        if (r101 == null) goto L11;
        Set<String> r102 = r101.keySet();
    L12:
        if (r102 == null) goto L14;
        this.f251717a.f251342c.getNodeDataChangedSet().removeAll(r102);
    L14:
        Function0<Unit> r103 = this.f251724h;
        if (r103 == null) goto L18;
        r103.invoke();
        return;
    L18:
        return;
    L11:
        r102 = null;
        goto L12
    L5:
        if (Intrinsics.areEqual(this.f251719c, aa6.a.b.C0040b.f2350b) == false) goto L14;
        goto L6
    }

    @Override // ba6.g
    public final aa6.a getStrategy() {
        return this.f251719c;
    }

    @Override // ba6.g
    public final String getTriggerType() {
        return this.f251721e;
    }

    public YataStoreData(YataStoreWrapper r100, com.bytedance.kmp.ec.yata.common.protocol.data.n r101, aa6.a r102, StoreType r103, String r104, String r105, AbsPerfMonitor r106, Function0 r110, Function0 r111, int r112) {
        if ((r112 & 16) == 0) goto L6;
        r104 = null;
    L6:
        if ((r112 & 32) == 0) goto L9;
        r105 = null;
    L9:
        if ((r112 & 64) == 0) goto L12;
        r106 = null;
    L12:
        if ((r112 & 256) == 0) goto L15;
        r110 = null;
    L15:
        if ((r112 & 512) == 0) goto L17;
        r111 = null;
    L17:
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        Intrinsics.checkNotNullParameter(r102, BdpAppEventConstant.PARAMS_STRATEGY_NAME);
        Intrinsics.checkNotNullParameter(r103, "storeType");
        this.f251717a = r100;
        this.f251718b = r101;
        this.f251719c = r102;
        this.f251720d = r103;
        this.f251721e = r104;
        this.f251722f = r105;
        this.f251723g = r106;
        this.f251724h = r110;
        this.f251725i = r111;
    }
}
