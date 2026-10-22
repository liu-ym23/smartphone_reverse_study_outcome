package com.ss.android.lark.movable.selection;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/movable/selection/HandleType;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, GXAnimation.STATE_END, "movable_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum HandleType extends Enum<HandleType> {
    public static final HandleType END = null;
    public static final HandleType START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ HandleType[] f432721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f432722b = null;

    public static EnumEntries<HandleType> getEntries() {
        return f432722b;
    }

    static {
        HandleType r100 = new HandleType(GXAnimation.STATE_START, 0);
        START = r100;
        HandleType r101 = new HandleType(GXAnimation.STATE_END, 1);
        END = r101;
        HandleType[] r102 = {r100, r101};
        f432721a = r102;
        f432722b = EnumEntriesKt.enumEntries(r102);
    }

    public static HandleType[] values() {
        return (HandleType[]) f432721a.clone();
    }

    public static HandleType valueOf(String r100) {
        return (HandleType) r27.a.a(HandleType.class, r100);
    }

    public HandleType(String r100, int r101) {
        super(r100, r101);
    }
}
