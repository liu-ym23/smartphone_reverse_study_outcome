package com.ss.android.lark.chameleonv2.lkapi.transport.command;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ$\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "Lcom/bytedance/ee/util/io/NonProguard;", "appId", "", "feature", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getAppId", "()Ljava/lang/String;", "getFeature", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/ss/android/lark/chameleonv2/lkapi/transport/command/MyIdFeaturePair;", "equals", "", "other", "", "hashCode", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyIdFeaturePair implements NonProguard {
    private final String appId;
    private final Integer feature;

    public static /* synthetic */ MyIdFeaturePair copy$default(MyIdFeaturePair r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appId;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.feature;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.appId;
    }

    public final Integer component2() {
        return this.feature;
    }

    public final MyIdFeaturePair copy(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        return new MyIdFeaturePair(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MyIdFeaturePair) == true) goto L8;
        return false;
    L8:
        MyIdFeaturePair r101 = (MyIdFeaturePair) r100;
        if (Intrinsics.areEqual(this.appId, r101.appId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feature, r101.feature) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.appId.hashCode() * 31;
        Integer r101 = this.feature;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "MyIdFeaturePair(appId=" + this.appId + ", feature=" + this.feature + ')';
    }

    public final String getAppId() {
        return this.appId;
    }

    public final Integer getFeature() {
        return this.feature;
    }

    public MyIdFeaturePair(String r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        this.appId = r100;
        this.feature = r101;
    }
}
