package com.bytedance.dux.gestureguide;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/dux/gestureguide/GestureType;", "", "", "animResName", "Ljava/lang/String;", "getAnimResName", "()Ljava/lang/String;", "animImgFolderName", "getAnimImgFolderName", "DoubleTap", "LongPress", "SwipeDown", "SwipeLeft", "SwipeRight", "SwipeUp", "Tap", "Pointer", "Dynamic", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum GestureType extends Enum<GestureType> {
    public static final GestureType DoubleTap = null;
    public static final GestureType Dynamic = null;
    public static final GestureType LongPress = null;
    public static final GestureType Pointer = null;
    public static final GestureType SwipeDown = null;
    public static final GestureType SwipeLeft = null;
    public static final GestureType SwipeRight = null;
    public static final GestureType SwipeUp = null;
    public static final GestureType Tap = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GestureType[] f205180a = null;
    private final String animImgFolderName;
    private final String animResName;

    public GestureType() {
        throw null;
    }

    public static GestureType valueOf(String r100) {
        return (GestureType) a.a(GestureType.class, r100);
    }

    public static GestureType[] values() {
        return (GestureType[]) f205180a.clone();
    }

    static {
        GestureType r100 = new GestureType("DoubleTap", 0, "doubleTap.json", null, 2, null);
        DoubleTap = r100;
        GestureType r101 = new GestureType("LongPress", 1, "longPress.json", null, 2, null);
        LongPress = r101;
        GestureType r102 = new GestureType("SwipeDown", 2, "swipeDown.json", null, 2, null);
        SwipeDown = r102;
        GestureType r103 = new GestureType("SwipeLeft", 3, "swipeLeft.json", null, 2, null);
        SwipeLeft = r103;
        GestureType r104 = new GestureType("SwipeRight", 4, "swipeRight.json", null, 2, null);
        SwipeRight = r104;
        GestureType r105 = new GestureType("SwipeUp", 5, "swipeUp.json", null, 2, null);
        SwipeUp = r105;
        GestureType r106 = new GestureType("Tap", 6, "tap.json", null, 2, null);
        Tap = r106;
        GestureType r107 = new GestureType("Pointer", 7, "pointer.json", null, 2, null);
        Pointer = r107;
        GestureType r108 = new GestureType("Dynamic", 8, "", null, 2, null);
        Dynamic = r108;
        f205180a = new GestureType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public final String getAnimImgFolderName() {
        return this.animImgFolderName;
    }

    public final String getAnimResName() {
        return this.animResName;
    }

    public GestureType(String r100, int r101, String r102, String r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = "gesture/images/";
    L5:
        super(r100, r101);
        this.animResName = r102;
        this.animImgFolderName = r103;
    }
}
