package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003JH\u0010\u0018\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\tHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000f¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyPullOpenAppBadgeNodesRequest;", "Lcom/bytedance/ee/util/io/NonProguard;", "idFeaturePairs", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "Lkotlin/collections/ArrayList;", "isMobile", "", BdpAppEventConstant.PARAMS_STRATEGY_NAME, "", "needTriggerPush", "<init>", "(Ljava/util/ArrayList;ZLjava/lang/Integer;Z)V", "getIdFeaturePairs", "()Ljava/util/ArrayList;", "()Z", "getStrategy", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNeedTriggerPush", "component1", "component2", "component3", "component4", "copy", "(Ljava/util/ArrayList;ZLjava/lang/Integer;Z)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyPullOpenAppBadgeNodesRequest;", "equals", "other", "", "hashCode", "toString", "", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyPullOpenAppBadgeNodesRequest implements NonProguard {
    private final ArrayList<MyIdFeaturePair> idFeaturePairs;
    private final boolean isMobile;
    private final boolean needTriggerPush;
    private final Integer strategy;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyPullOpenAppBadgeNodesRequest copy$default(MyPullOpenAppBadgeNodesRequest r100, ArrayList r101, boolean r102, Integer r103, boolean r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.idFeaturePairs;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isMobile;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.strategy;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.needTriggerPush;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final ArrayList<MyIdFeaturePair> component1() {
        return this.idFeaturePairs;
    }

    public final boolean component2() {
        return this.isMobile;
    }

    public final Integer component3() {
        return this.strategy;
    }

    public final boolean component4() {
        return this.needTriggerPush;
    }

    public final MyPullOpenAppBadgeNodesRequest copy(ArrayList<MyIdFeaturePair> r100, boolean r101, Integer r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "idFeaturePairs");
        return new MyPullOpenAppBadgeNodesRequest(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyPullOpenAppBadgeNodesRequest) == true) goto L8;
        return false;
    L8:
        MyPullOpenAppBadgeNodesRequest r101 = (MyPullOpenAppBadgeNodesRequest) r100;
        if (Intrinsics.areEqual(this.idFeaturePairs, r101.idFeaturePairs) == true) goto L12;
        return false;
    L12:
        if (this.isMobile == r101.isMobile) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.strategy, r101.strategy) == true) goto L18;
        return false;
    L18:
        if (this.needTriggerPush == r101.needTriggerPush) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.idFeaturePairs.hashCode() * 31;
        int r101 = 1231;
        if (this.isMobile == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        Integer r104 = this.strategy;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        if (this.needTriggerPush == true) goto L15;
        r101 = 1237;
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "MyPullOpenAppBadgeNodesRequest(idFeaturePairs=" + this.idFeaturePairs + ", isMobile=" + this.isMobile + ", strategy=" + this.strategy + ", needTriggerPush=" + this.needTriggerPush + ')';
    }

    public final ArrayList<MyIdFeaturePair> getIdFeaturePairs() {
        return this.idFeaturePairs;
    }

    public final boolean getNeedTriggerPush() {
        return this.needTriggerPush;
    }

    public final Integer getStrategy() {
        return this.strategy;
    }

    public final boolean isMobile() {
        return this.isMobile;
    }

    public MyPullOpenAppBadgeNodesRequest(ArrayList<MyIdFeaturePair> r100, boolean r101, Integer r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "idFeaturePairs");
        this.idFeaturePairs = r100;
        this.isMobile = r101;
        this.strategy = r102;
        this.needTriggerPush = r103;
    }
}
