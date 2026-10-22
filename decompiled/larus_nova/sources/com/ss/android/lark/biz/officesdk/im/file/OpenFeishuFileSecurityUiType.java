package com.ss.android.lark.biz.officesdk.im.file;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/file/OpenFeishuFileSecurityUiType;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "TOAST", "DIALOG", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OpenFeishuFileSecurityUiType extends Enum<OpenFeishuFileSecurityUiType> {
    public static final OpenFeishuFileSecurityUiType DIALOG = null;
    public static final OpenFeishuFileSecurityUiType NONE = null;
    public static final OpenFeishuFileSecurityUiType TOAST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenFeishuFileSecurityUiType[] f410593a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410594b = null;

    public static EnumEntries<OpenFeishuFileSecurityUiType> getEntries() {
        return f410594b;
    }

    static {
        OpenFeishuFileSecurityUiType r100 = new OpenFeishuFileSecurityUiType(UserProfileEvent.POSITION_NONE, 0);
        NONE = r100;
        OpenFeishuFileSecurityUiType r101 = new OpenFeishuFileSecurityUiType("TOAST", 1);
        TOAST = r101;
        OpenFeishuFileSecurityUiType r102 = new OpenFeishuFileSecurityUiType("DIALOG", 2);
        DIALOG = r102;
        OpenFeishuFileSecurityUiType[] r103 = {r100, r101, r102};
        f410593a = r103;
        f410594b = EnumEntriesKt.enumEntries(r103);
    }

    public static OpenFeishuFileSecurityUiType[] values() {
        return (OpenFeishuFileSecurityUiType[]) f410593a.clone();
    }

    public static OpenFeishuFileSecurityUiType valueOf(String r100) {
        return (OpenFeishuFileSecurityUiType) a.a(OpenFeishuFileSecurityUiType.class, r100);
    }

    public OpenFeishuFileSecurityUiType(String r100, int r101) {
        super(r100, r101);
    }
}
