package com.obric.assistant.settings.autogui;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiItemBgType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", UserProfileEvent.POSITION_NONE, EffectConstants.NORMAL, "TOP_CORNERS", "BOTTOM_CORNERS", "CORNERS", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ObricAutoGuiItemBgType extends Enum<ObricAutoGuiItemBgType> {
    public static final ObricAutoGuiItemBgType BOTTOM_CORNERS = null;
    public static final ObricAutoGuiItemBgType CORNERS = null;
    public static final ObricAutoGuiItemBgType NONE = null;
    public static final ObricAutoGuiItemBgType NORMAL = null;
    public static final ObricAutoGuiItemBgType TOP_CORNERS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ObricAutoGuiItemBgType[] f391820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f391821b = null;
    private final int value;

    public static EnumEntries<ObricAutoGuiItemBgType> getEntries() {
        return f391821b;
    }

    static {
        ObricAutoGuiItemBgType r100 = new ObricAutoGuiItemBgType(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        ObricAutoGuiItemBgType r101 = new ObricAutoGuiItemBgType(EffectConstants.NORMAL, 1, 1);
        NORMAL = r101;
        ObricAutoGuiItemBgType r102 = new ObricAutoGuiItemBgType("TOP_CORNERS", 2, 2);
        TOP_CORNERS = r102;
        ObricAutoGuiItemBgType r103 = new ObricAutoGuiItemBgType("BOTTOM_CORNERS", 3, 3);
        BOTTOM_CORNERS = r103;
        ObricAutoGuiItemBgType r104 = new ObricAutoGuiItemBgType("CORNERS", 4, 4);
        CORNERS = r104;
        ObricAutoGuiItemBgType[] r105 = {r100, r101, r102, r103, r104};
        f391820a = r105;
        f391821b = EnumEntriesKt.enumEntries(r105);
    }

    public static ObricAutoGuiItemBgType[] values() {
        return (ObricAutoGuiItemBgType[]) f391820a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ObricAutoGuiItemBgType valueOf(String r100) {
        return (ObricAutoGuiItemBgType) r27.a.a(ObricAutoGuiItemBgType.class, r100);
    }

    public ObricAutoGuiItemBgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
