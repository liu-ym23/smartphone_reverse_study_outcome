package com.bytedance.ies.xbridge.event;

import com.bytedance.ies.xbridge.XReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/ies/xbridge/event/Js2NativeEvent;", "", "eventName", "", "params", "Lcom/bytedance/ies/xbridge/XReadableMap;", "(Ljava/lang/String;Lcom/bytedance/ies/xbridge/XReadableMap;)V", "getEventName", "()Ljava/lang/String;", "getParams", "()Lcom/bytedance/ies/xbridge/XReadableMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class Js2NativeEvent {
    private final String eventName;
    private final XReadableMap params;

    public static /* synthetic */ Js2NativeEvent copy$default(Js2NativeEvent r100, String r101, XReadableMap r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.eventName;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.eventName;
    }

    public final XReadableMap component2() {
        return this.params;
    }

    public final Js2NativeEvent copy(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return new Js2NativeEvent(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof Js2NativeEvent) == true) goto L8;
        return false;
    L8:
        Js2NativeEvent r101 = (Js2NativeEvent) r100;
        if (Intrinsics.areEqual(this.eventName, r101.eventName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.eventName.hashCode() * 31;
        XReadableMap r101 = this.params;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public String toString() {
        return "Js2NativeEvent(eventName=" + this.eventName + ", params=" + this.params + ')';
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final XReadableMap getParams() {
        return this.params;
    }

    public Js2NativeEvent(String r100, XReadableMap r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        this.eventName = r100;
        this.params = r101;
    }
}
