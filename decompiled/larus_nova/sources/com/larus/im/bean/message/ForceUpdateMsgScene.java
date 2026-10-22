package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/larus/im/bean/message/ForceUpdateMsgScene;", "", "<init>", "(Ljava/lang/String;I)V", "FILE_UPLOAD_PROGRESS", "imsdkkmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ForceUpdateMsgScene extends Enum<ForceUpdateMsgScene> {
    public static final ForceUpdateMsgScene FILE_UPLOAD_PROGRESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ForceUpdateMsgScene[] f346633a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f346634b = null;

    public static EnumEntries<ForceUpdateMsgScene> getEntries() {
        return f346634b;
    }

    static {
        ForceUpdateMsgScene r100 = new ForceUpdateMsgScene();
        FILE_UPLOAD_PROGRESS = r100;
        ForceUpdateMsgScene[] r101 = {r100};
        f346633a = r101;
        f346634b = EnumEntriesKt.enumEntries(r101);
    }

    public ForceUpdateMsgScene() {
        super("FILE_UPLOAD_PROGRESS", 0);
    }

    public static ForceUpdateMsgScene[] values() {
        return (ForceUpdateMsgScene[]) f346633a.clone();
    }

    public static ForceUpdateMsgScene valueOf(String r100) {
        return (ForceUpdateMsgScene) r27.a.a(ForceUpdateMsgScene.class, r100);
    }
}
