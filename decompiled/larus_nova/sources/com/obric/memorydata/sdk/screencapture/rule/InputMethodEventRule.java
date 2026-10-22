package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenEventRule;", "visible", "", "<init>", "(Ljava/lang/Boolean;)V", "getVisible", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "isMatch", "event", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/obric/memorydata/sdk/screencapture/rule/InputMethodEventRule;", "equals", "other", "", "hashCode", "", "toString", "", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InputMethodEventRule extends ScreenEventRule {
    public static final a CREATOR = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f397272b;

    public static final class a implements Parcelable.Creator<InputMethodEventRule> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final InputMethodEventRule createFromParcel(Parcel r100) {
            Intrinsics.checkNotNullParameter(r100, "parcel");
            return (InputMethodEventRule) GsonProtectorUtils.fromJson(new Gson(), r100.readString(), InputMethodEventRule.class);
        }

        @Override // android.os.Parcelable.Creator
        public final InputMethodEventRule[] newArray(int r100) {
            return new InputMethodEventRule[r100];
        }
    }

    static {
        CREATOR = new a();
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof InputMethodEventRule) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f397272b, ((InputMethodEventRule) r100).f397272b) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Boolean r100 = this.f397272b;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "InputMethodEventRule(visible=" + this.f397272b + ')';
    }

    public InputMethodEventRule() {
        this.f397272b = null;
        ScreenEvent.EventType r100 = ScreenEvent.EventType.TOUCH;
    }
}
