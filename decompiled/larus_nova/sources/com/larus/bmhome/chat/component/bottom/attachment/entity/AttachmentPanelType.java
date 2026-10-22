package com.larus.bmhome.chat.component.bottom.attachment.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0017B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\u0010J\u0006\u0010\u0012\u001a\u00020\u0010J\u0006\u0010\u0013\u001a\u00020\u0010J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0006\u0010\u0016\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/attachment/entity/AttachmentPanelType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "SingleImage", "MultiImage", "MultiFile", "MixImageFile", "MultiAudio", "SingleFile", "isSingleImage", "", "isUnknown", "isMultiImage", "isMultiFile", "isMultiAudio", "isMixImageFile", "isSingleFile", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AttachmentPanelType extends Enum<AttachmentPanelType> {
    public static final a Companion = null;
    public static final AttachmentPanelType MixImageFile = null;
    public static final AttachmentPanelType MultiAudio = null;
    public static final AttachmentPanelType MultiFile = null;
    public static final AttachmentPanelType MultiImage = null;
    public static final AttachmentPanelType SingleFile = null;
    public static final AttachmentPanelType SingleImage = null;
    public static final AttachmentPanelType Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AttachmentPanelType[] f298110a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298111b = null;
    private final int value;

    public static EnumEntries<AttachmentPanelType> getEntries() {
        return f298111b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.bmhome.chat.component.bottom.attachment.entity.AttachmentPanelType$a] */
    static {
        AttachmentPanelType r100 = new AttachmentPanelType("Unknown", 0, 0);
        Unknown = r100;
        AttachmentPanelType r101 = new AttachmentPanelType("SingleImage", 1, 1);
        SingleImage = r101;
        AttachmentPanelType r102 = new AttachmentPanelType("MultiImage", 2, 2);
        MultiImage = r102;
        AttachmentPanelType r103 = new AttachmentPanelType("MultiFile", 3, 3);
        MultiFile = r103;
        AttachmentPanelType r104 = new AttachmentPanelType("MixImageFile", 4, 4);
        MixImageFile = r104;
        AttachmentPanelType r105 = new AttachmentPanelType("MultiAudio", 5, 5);
        MultiAudio = r105;
        AttachmentPanelType r110 = new AttachmentPanelType("SingleFile", 6, 6);
        SingleFile = r110;
        AttachmentPanelType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f298110a = r111;
        f298111b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static AttachmentPanelType[] values() {
        return (AttachmentPanelType[]) f298110a.clone();
    }

    public final boolean isMixImageFile() {
        if (this != MixImageFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiAudio() {
        if (this != MultiAudio) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiFile() {
        if (this != MultiFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isMultiImage() {
        if (this != MultiImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSingleFile() {
        if (this != SingleFile) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isSingleImage() {
        if (this != SingleImage) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean isUnknown() {
        if (this != Unknown) goto L5;
        return true;
    L5:
        return false;
    }

    public final int getValue() {
        return this.value;
    }

    public static AttachmentPanelType valueOf(String r100) {
        return (AttachmentPanelType) r27.a.a(AttachmentPanelType.class, r100);
    }

    public AttachmentPanelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
