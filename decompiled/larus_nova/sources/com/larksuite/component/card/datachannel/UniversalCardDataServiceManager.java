package com.larksuite.component.card.datachannel;

import com.bytedance.lark.pb.openplatform.v1.UniversalCardBizType;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bR*\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/larksuite/component/card/datachannel/UniversalCardDataServiceManager;", "Ljava/io/Serializable;", "<init>", "()V", "bizDataServiceMap", "Ljava/util/HashMap;", "", "Lcom/larksuite/component/card/datachannel/UniversalCardDataService;", "Lkotlin/collections/HashMap;", "getCardDataService", "bizType", "Lcom/bytedance/lark/pb/openplatform/v1/UniversalCardBizType;", "containsService", "", "destroyBizDataService", "", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardDataServiceManager implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<UniversalCardDataServiceManager> f283709a = null;
    private final HashMap<Integer, UniversalCardDataService> bizDataServiceMap;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ UniversalCardDataServiceManager(DefaultConstructorMarker r100) {
        this();
    }

    static {
        Companion = new a();
        f283709a = LazyKt.lazy(UniversalCardDataServiceManager$Companion$INSTANCE$2.INSTANCE);
    }

    private UniversalCardDataServiceManager() {
        this.bizDataServiceMap = new HashMap();
    }

    public static final /* synthetic */ Lazy access$getINSTANCE$delegate$cp() {
        return f283709a;
    }

    public final boolean containsService(UniversalCardBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        return this.bizDataServiceMap.containsKey(Integer.valueOf(r100.getValue()));
    }

    public final void destroyBizDataService(UniversalCardBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        UniversalCardDataService r101 = this.bizDataServiceMap.get(Integer.valueOf(r100.getValue()));
        if (r101 == null) goto L6;
        r101.destroy();
        UniversalCardDataService r102 = this.bizDataServiceMap.remove(Integer.valueOf(r100.getValue()));
        return;
    }

    public final UniversalCardDataService getCardDataService(UniversalCardBizType r100) {
        Intrinsics.checkNotNullParameter(r100, "bizType");
        UniversalCardDataService r101 = this.bizDataServiceMap.get(Integer.valueOf(r100.getValue()));
        if (r101 == null) goto L5;
        return r101;
    L5:
        UniversalCardDataService r102 = new UniversalCardDataService(r100);
        this.bizDataServiceMap.put(Integer.valueOf(r100.getValue()), r102);
        return r102;
    }
}
