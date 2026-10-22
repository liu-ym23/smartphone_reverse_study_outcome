package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0011\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/InputMethodEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "visible", "", "<init>", "(Z)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getVisible", "()Z", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "copy", "equals", "other", "", "hashCode", "toString", "", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputMethodEvent extends ScreenEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397234d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ScreenEvent.EventType f397235e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputMethodEvent) == true) goto L9;
        return false;
    L9:
        if (this.f397234d == ((InputMethodEvent) r100).f397234d) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.f397234d == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "InputMethodEvent(visible=" + this.f397234d + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public final ScreenEvent.EventType a() {
        return this.f397235e;
    }

    public InputMethodEvent(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        if (r100.readByte() == 0) goto L5;
        boolean r101 = true;
    L6:
        this.f397234d = r101;
        this.f397235e = ScreenEvent.EventType.INPUT_METHOD;
        return;
    L5:
        r101 = false;
        goto L6
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeByte(this.f397234d ? 1 : 0);
    }
}
