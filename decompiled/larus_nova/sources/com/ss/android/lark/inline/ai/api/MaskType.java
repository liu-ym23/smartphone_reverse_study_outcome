package com.ss.android.lark.inline.ai.api;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/MaskType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "FULLSCREEN", "AROUNDPANEL", UserProfileEvent.POSITION_NONE, "DEFAULT", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MaskType extends Enum<MaskType> {
    public static final MaskType AROUNDPANEL = null;
    public static final MaskType DEFAULT = null;
    public static final MaskType FULLSCREEN = null;
    public static final MaskType NONE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MaskType[] f426805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f426806b = null;
    private final String value;

    public static EnumEntries<MaskType> getEntries() {
        return f426806b;
    }

    static {
        MaskType r100 = new MaskType("FULLSCREEN", 0, "fullScreen");
        FULLSCREEN = r100;
        MaskType r101 = new MaskType("AROUNDPANEL", 1, "aroundPanel");
        AROUNDPANEL = r101;
        MaskType r102 = new MaskType(UserProfileEvent.POSITION_NONE, 2, "none");
        NONE = r102;
        MaskType r103 = new MaskType("DEFAULT", 3, "default");
        DEFAULT = r103;
        MaskType[] r104 = {r100, r101, r102, r103};
        f426805a = r104;
        f426806b = EnumEntriesKt.enumEntries(r104);
    }

    public static MaskType[] values() {
        return (MaskType[]) f426805a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static MaskType valueOf(String r100) {
        return (MaskType) a.a(MaskType.class, r100);
    }

    public MaskType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
