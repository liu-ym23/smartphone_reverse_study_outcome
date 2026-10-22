package com.larus.bmhome.chat.component.bottom.core.speaker;

import android.view.ViewConfiguration;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/speaker/TouchSpeakerState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "speakerTouchEnable", "", "longPressTimeout", "", "<init>", "(ZJ)V", "getSpeakerTouchEnable", "()Z", "getLongPressTimeout", "()J", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TouchSpeakerState implements w1a.b {
    private final long longPressTimeout;
    private final boolean speakerTouchEnable;

    public TouchSpeakerState() {
        this(false, 0, 3, null);
    }

    public static /* synthetic */ TouchSpeakerState copy$default(TouchSpeakerState r100, boolean r101, long r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.speakerTouchEnable;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.longPressTimeout;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.speakerTouchEnable;
    }

    public final long component2() {
        return this.longPressTimeout;
    }

    public final TouchSpeakerState copy(boolean r100, long r101) {
        return new TouchSpeakerState(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TouchSpeakerState) == true) goto L8;
        return false;
    L8:
        TouchSpeakerState r101 = (TouchSpeakerState) r100;
        if (this.speakerTouchEnable == r101.speakerTouchEnable) goto L12;
        return false;
    L12:
        if (this.longPressTimeout == r101.longPressTimeout) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        if (this.speakerTouchEnable == false) goto L5;
        int r100 = 1231;
    L6:
        long r101 = this.longPressTimeout;
        return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
    L5:
        r100 = 1237;
        goto L6
    }

    public String toString() {
        return "TouchSpeakerState(speakerTouchEnable=" + this.speakerTouchEnable + ", longPressTimeout=" + this.longPressTimeout + ')';
    }

    public final long getLongPressTimeout() {
        return this.longPressTimeout;
    }

    public final boolean getSpeakerTouchEnable() {
        return this.speakerTouchEnable;
    }

    public TouchSpeakerState(boolean r100, long r101) {
        this.speakerTouchEnable = r100;
        this.longPressTimeout = r101;
    }

    public /* synthetic */ TouchSpeakerState(boolean r100, long r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = true;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = ViewConfiguration.getLongPressTimeout();
    L8:
        this(r100, r101);
    }
}
