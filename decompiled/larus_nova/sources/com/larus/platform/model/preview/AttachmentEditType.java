package com.larus.platform.model.preview;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/model/preview/AttachmentEditType;", "", "<init>", "(Ljava/lang/String;I)V", "MARK", "CROP", FlowDoraWifiScene.OTHER, "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentEditType extends Enum<AttachmentEditType> {
    public static final AttachmentEditType CROP = null;
    public static final AttachmentEditType MARK = null;
    public static final AttachmentEditType OTHER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentEditType[] f365643a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365644b = null;

    public static EnumEntries<AttachmentEditType> getEntries() {
        return f365644b;
    }

    static {
        AttachmentEditType r100 = new AttachmentEditType("MARK", 0);
        MARK = r100;
        AttachmentEditType r101 = new AttachmentEditType("CROP", 1);
        CROP = r101;
        AttachmentEditType r102 = new AttachmentEditType(FlowDoraWifiScene.OTHER, 2);
        OTHER = r102;
        AttachmentEditType[] r103 = {r100, r101, r102};
        f365643a = r103;
        f365644b = EnumEntriesKt.enumEntries(r103);
    }

    public static AttachmentEditType[] values() {
        return (AttachmentEditType[]) f365643a.clone();
    }

    public static AttachmentEditType valueOf(String r100) {
        return (AttachmentEditType) a.a(AttachmentEditType.class, r100);
    }

    public AttachmentEditType(String r100, int r101) {
        super(r100, r101);
    }
}
