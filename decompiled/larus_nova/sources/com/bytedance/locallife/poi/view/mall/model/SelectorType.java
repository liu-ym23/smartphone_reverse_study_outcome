package com.bytedance.locallife.poi.view.mall.model;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/view/mall/model/SelectorType;", "", "", "value", "I", "getValue", "()I", UserProfileEvent.POSITION_NONE, "FLOOR", "CATEGORY", "SORT", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum SelectorType extends Enum<SelectorType> {
    public static final SelectorType CATEGORY = null;
    public static final SelectorType FLOOR = null;
    public static final SelectorType NONE = null;
    public static final SelectorType SORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SelectorType[] f264268a = null;
    private final int value;

    public static SelectorType valueOf(String r100) {
        return (SelectorType) a.a(SelectorType.class, r100);
    }

    public static SelectorType[] values() {
        return (SelectorType[]) f264268a.clone();
    }

    static {
        SelectorType r100 = new SelectorType(UserProfileEvent.POSITION_NONE, 0, -1);
        NONE = r100;
        SelectorType r101 = new SelectorType("FLOOR", 1, 0);
        FLOOR = r101;
        SelectorType r102 = new SelectorType("CATEGORY", 2, 1);
        CATEGORY = r102;
        SelectorType r103 = new SelectorType("SORT", 3, 2);
        SORT = r103;
        f264268a = new SelectorType[]{r100, r101, r102, r103};
    }

    public final int getValue() {
        return this.value;
    }

    public SelectorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
