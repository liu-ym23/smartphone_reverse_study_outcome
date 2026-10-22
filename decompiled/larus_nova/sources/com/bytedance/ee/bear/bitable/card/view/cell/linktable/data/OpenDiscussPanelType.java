package com.bytedance.ee.bear.bitable.card.view.cell.linktable.data;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/linktable/data/OpenDiscussPanelType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/Integer;)V", "getValue", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "OPEN", "DISCUSS", UserProfileEvent.POSITION_NONE, "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenDiscussPanelType extends Enum<OpenDiscussPanelType> {
    public static final OpenDiscussPanelType DISCUSS = null;
    public static final OpenDiscussPanelType NONE = null;
    public static final OpenDiscussPanelType OPEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenDiscussPanelType[] f207827a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f207828b = null;
    private final Integer value;

    public static EnumEntries<OpenDiscussPanelType> getEntries() {
        return f207828b;
    }

    static {
        OpenDiscussPanelType r100 = new OpenDiscussPanelType("OPEN", 0, 1);
        OPEN = r100;
        OpenDiscussPanelType r101 = new OpenDiscussPanelType("DISCUSS", 1, 2);
        DISCUSS = r101;
        OpenDiscussPanelType r102 = new OpenDiscussPanelType(UserProfileEvent.POSITION_NONE, 2, null);
        NONE = r102;
        OpenDiscussPanelType[] r103 = {r100, r101, r102};
        f207827a = r103;
        f207828b = EnumEntriesKt.enumEntries(r103);
    }

    public static OpenDiscussPanelType[] values() {
        return (OpenDiscussPanelType[]) f207827a.clone();
    }

    public final Integer getValue() {
        return this.value;
    }

    public static OpenDiscussPanelType valueOf(String r100) {
        return (OpenDiscussPanelType) a.a(OpenDiscussPanelType.class, r100);
    }

    public OpenDiscussPanelType(String r100, int r101, Integer r102) {
        super(r100, r101);
        this.value = r102;
    }
}
