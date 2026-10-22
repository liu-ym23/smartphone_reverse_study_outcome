package com.bytedance.ee.bear.office.export;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/office/export/OfficeTokenType;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "OFFLINE", UserProfileEvent.POSITION_NONE, "office-ccm-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeTokenType extends Enum<OfficeTokenType> {
    public static final OfficeTokenType NONE = null;
    public static final OfficeTokenType OFFLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeTokenType[] f235444a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f235445b = null;
    private final String value;

    public static EnumEntries<OfficeTokenType> getEntries() {
        return f235445b;
    }

    static {
        OfficeTokenType r100 = new OfficeTokenType("OFFLINE", 0, "OFL");
        OFFLINE = r100;
        OfficeTokenType r101 = new OfficeTokenType(UserProfileEvent.POSITION_NONE, 1, UserProfileEvent.POSITION_NONE);
        NONE = r101;
        OfficeTokenType[] r102 = {r100, r101};
        f235444a = r102;
        f235445b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeTokenType[] values() {
        return (OfficeTokenType[]) f235444a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static OfficeTokenType valueOf(String r100) {
        return (OfficeTokenType) a.a(OfficeTokenType.class, r100);
    }

    public OfficeTokenType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
