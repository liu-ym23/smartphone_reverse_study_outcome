package com.bytedance.ee.bear.bitable.uikit.drag;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/uikit/drag/DragAreaState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, "PARENT_SELECTED", "ERROR", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DragAreaState extends Enum<DragAreaState> {
    public static final DragAreaState ERROR = null;
    public static final DragAreaState NONE = null;
    public static final DragAreaState PARENT_SELECTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DragAreaState[] f216116a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f216117b = null;
    private final int value;

    public static EnumEntries<DragAreaState> getEntries() {
        return f216117b;
    }

    static {
        DragAreaState r100 = new DragAreaState(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        DragAreaState r101 = new DragAreaState("PARENT_SELECTED", 1, 1);
        PARENT_SELECTED = r101;
        DragAreaState r102 = new DragAreaState("ERROR", 2, 2);
        ERROR = r102;
        DragAreaState[] r103 = {r100, r101, r102};
        f216116a = r103;
        f216117b = EnumEntriesKt.enumEntries(r103);
    }

    public static DragAreaState[] values() {
        return (DragAreaState[]) f216116a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static DragAreaState valueOf(String r100) {
        return (DragAreaState) a.a(DragAreaState.class, r100);
    }

    public DragAreaState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
