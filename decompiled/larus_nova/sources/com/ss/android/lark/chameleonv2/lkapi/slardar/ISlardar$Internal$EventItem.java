package com.ss.android.lark.chameleonv2.lkapi.slardar;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/slardar/ISlardar$Internal$EventItem;", "Lcom/bytedance/ee/util/io/NonProguard;", "eventName", "", WsConstants.KEY_PAYLOAD, "Lcom/ss/android/lark/chameleonv2/lkapi/slardar/ISlardar$Internal$CustomEventParams;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chameleonv2/lkapi/slardar/ISlardar$Internal$CustomEventParams;)V", "getEventName", "()Ljava/lang/String;", "getPayload", "()Lcom/ss/android/lark/chameleonv2/lkapi/slardar/ISlardar$Internal$CustomEventParams;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ISlardar$Internal$EventItem implements NonProguard {
    private final String eventName;
    private final ISlardar$Internal$CustomEventParams payload;

    public static /* synthetic */ ISlardar$Internal$EventItem copy$default(ISlardar$Internal$EventItem r100, String r101, ISlardar$Internal$CustomEventParams r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.eventName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.payload;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.eventName;
    }

    public final ISlardar$Internal$CustomEventParams component2() {
        return this.payload;
    }

    public final ISlardar$Internal$EventItem copy(String r100, ISlardar$Internal$CustomEventParams r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        return new ISlardar$Internal$EventItem(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ISlardar$Internal$EventItem) == true) goto L8;
        return false;
    L8:
        ISlardar$Internal$EventItem r101 = (ISlardar$Internal$EventItem) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.payload, r101.payload) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.eventName.hashCode() * 31) + this.payload.hashCode();
    }

    public String toString() {
        return "EventItem(eventName=" + this.eventName + ", payload=" + this.payload + ')';
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final ISlardar$Internal$CustomEventParams getPayload() {
        return this.payload;
    }

    public ISlardar$Internal$EventItem(String r100, ISlardar$Internal$CustomEventParams r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        Intrinsics.checkNotNullParameter(r101, WsConstants.KEY_PAYLOAD);
        this.eventName = r100;
        this.payload = r101;
    }
}
