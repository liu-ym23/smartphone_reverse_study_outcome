package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001:\u0002)*B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J5\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u001cHÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent;", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent;", "action", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "touchInfo", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "endTouchInfo", "scrollDirection", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getAction", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "getTouchInfo", "()Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "getEndTouchInfo", "getScrollDirection", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "eventType", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "getEventType", "()Lcom/obric/memorydata/sdk/screencapture/event/ScreenEvent$EventType;", "writeToParcel", "", "flags", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "", "TouchAction", "ScrollDirection", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenTouchEvent extends ScreenEvent {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TouchAction f397242d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TouchInfo f397243e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final TouchInfo f397244f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ScrollDirection f397245g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ScreenEvent.EventType f397246h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$ScrollDirection;", "", "<init>", "(Ljava/lang/String;I)V", "UP", "DOWN", "LEFT", "RIGHT", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum ScrollDirection extends Enum<ScrollDirection> {
        public static final ScrollDirection DOWN = null;
        public static final ScrollDirection LEFT = null;
        public static final ScrollDirection RIGHT = null;
        public static final ScrollDirection UP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ScrollDirection[] f397247a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397248b = null;

        public static EnumEntries<ScrollDirection> getEntries() {
            return f397248b;
        }

        static {
            ScrollDirection r100 = new ScrollDirection("UP", 0);
            UP = r100;
            ScrollDirection r101 = new ScrollDirection("DOWN", 1);
            DOWN = r101;
            ScrollDirection r102 = new ScrollDirection("LEFT", 2);
            LEFT = r102;
            ScrollDirection r103 = new ScrollDirection("RIGHT", 3);
            RIGHT = r103;
            ScrollDirection[] r104 = {r100, r101, r102, r103};
            f397247a = r104;
            f397248b = EnumEntriesKt.enumEntries(r104);
        }

        public static ScrollDirection[] values() {
            return (ScrollDirection[]) f397247a.clone();
        }

        public static ScrollDirection valueOf(String r100) {
            return (ScrollDirection) a.a(ScrollDirection.class, r100);
        }

        public ScrollDirection(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "", "<init>", "(Ljava/lang/String;I)V", "TAP", "DOUBLE_TAP", "LONG_PRESS", "SCROLL_START", "SCROLLED", "BACK_KEY", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final enum TouchAction extends Enum<TouchAction> {
        public static final TouchAction BACK_KEY = null;
        public static final TouchAction DOUBLE_TAP = null;
        public static final TouchAction LONG_PRESS = null;
        public static final TouchAction SCROLLED = null;
        public static final TouchAction SCROLL_START = null;
        public static final TouchAction TAP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TouchAction[] f397249a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397250b = null;

        public static EnumEntries<TouchAction> getEntries() {
            return f397250b;
        }

        static {
            TouchAction r100 = new TouchAction("TAP", 0);
            TAP = r100;
            TouchAction r101 = new TouchAction("DOUBLE_TAP", 1);
            DOUBLE_TAP = r101;
            TouchAction r102 = new TouchAction("LONG_PRESS", 2);
            LONG_PRESS = r102;
            TouchAction r103 = new TouchAction("SCROLL_START", 3);
            SCROLL_START = r103;
            TouchAction r104 = new TouchAction("SCROLLED", 4);
            SCROLLED = r104;
            TouchAction r105 = new TouchAction("BACK_KEY", 5);
            BACK_KEY = r105;
            TouchAction[] r110 = {r100, r101, r102, r103, r104, r105};
            f397249a = r110;
            f397250b = EnumEntriesKt.enumEntries(r110);
        }

        public static TouchAction[] values() {
            return (TouchAction[]) f397249a.clone();
        }

        public static TouchAction valueOf(String r100) {
            return (TouchAction) a.a(TouchAction.class, r100);
        }

        public TouchAction(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ScreenTouchEvent) == true) goto L8;
        return false;
    L8:
        ScreenTouchEvent r101 = (ScreenTouchEvent) r100;
        if (this.f397242d == r101.f397242d) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f397243e, r101.f397243e) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397244f, r101.f397244f) == true) goto L18;
        return false;
    L18:
        if (this.f397245g == r101.f397245g) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f397242d.hashCode() * 31) + this.f397243e.hashCode()) * 31;
        TouchInfo r101 = this.f397244f;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        ScrollDirection r105 = this.f397245g;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ScreenTouchEvent(action=" + this.f397242d + ", touchInfo=" + this.f397243e + ", endTouchInfo=" + this.f397244f + ", scrollDirection=" + this.f397245g + ')';
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent
    public final ScreenEvent.EventType a() {
        return this.f397246h;
    }

    public ScreenTouchEvent(Parcel r100) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        String r101 = r100.readString();
        Intrinsics.checkNotNull(r101);
        TouchAction r102 = TouchAction.valueOf(r101);
        Parcelable r103 = r100.readParcelable(ScreenEvent.class.getClassLoader());
        Intrinsics.checkNotNull(r103);
        TouchInfo r104 = (TouchInfo) r103;
        TouchInfo r105 = (TouchInfo) r100.readParcelable(ScreenEvent.class.getClassLoader());
        String r106 = r100.readString();
        if (r106 == null) goto L5;
        ScrollDirection r107 = ScrollDirection.valueOf(r106);
    L6:
        Intrinsics.checkNotNullParameter(r102, "action");
        Intrinsics.checkNotNullParameter(r104, "touchInfo");
        this.f397242d = r102;
        this.f397243e = r104;
        this.f397244f = r105;
        this.f397245g = r107;
        this.f397246h = ScreenEvent.EventType.TOUCH;
        return;
    L5:
        r107 = null;
        goto L6
    }

    @Override // com.obric.memorydata.sdk.screencapture.event.ScreenEvent, android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "parcel");
        super.writeToParcel(r100, r101);
        r100.writeString(this.f397242d.name());
        r100.writeParcelable(this.f397243e, r101);
        r100.writeParcelable(this.f397244f, r101);
        ScrollDirection r102 = this.f397245g;
        if (r102 == null) goto L5;
        String r103 = r102.name();
    L6:
        r100.writeString(r103);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
