package com.ss.android.ainote.model;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/ss/android/ainote/model/AINoteBlockStatus;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "CREATING", "DIRTY", "WAITING_IMAGE_UPLOAD", "READY_TO_COMMIT", "SAVING", "UPDATING", "POLISHING", "FAILED", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteBlockStatus extends Enum<AINoteBlockStatus> {
    public static final AINoteBlockStatus CREATING = null;
    public static final AINoteBlockStatus DIRTY = null;
    public static final AINoteBlockStatus FAILED = null;
    public static final AINoteBlockStatus NORMAL = null;
    public static final AINoteBlockStatus POLISHING = null;
    public static final AINoteBlockStatus READY_TO_COMMIT = null;
    public static final AINoteBlockStatus SAVING = null;
    public static final AINoteBlockStatus UPDATING = null;
    public static final AINoteBlockStatus WAITING_IMAGE_UPLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteBlockStatus[] f407132a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407133b = null;

    public static EnumEntries<AINoteBlockStatus> getEntries() {
        return f407133b;
    }

    static {
        AINoteBlockStatus r100 = new AINoteBlockStatus(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        AINoteBlockStatus r101 = new AINoteBlockStatus("CREATING", 1);
        CREATING = r101;
        AINoteBlockStatus r102 = new AINoteBlockStatus("DIRTY", 2);
        DIRTY = r102;
        AINoteBlockStatus r103 = new AINoteBlockStatus("WAITING_IMAGE_UPLOAD", 3);
        WAITING_IMAGE_UPLOAD = r103;
        AINoteBlockStatus r104 = new AINoteBlockStatus("READY_TO_COMMIT", 4);
        READY_TO_COMMIT = r104;
        AINoteBlockStatus r105 = new AINoteBlockStatus("SAVING", 5);
        SAVING = r105;
        AINoteBlockStatus r110 = new AINoteBlockStatus("UPDATING", 6);
        UPDATING = r110;
        AINoteBlockStatus r111 = new AINoteBlockStatus("POLISHING", 7);
        POLISHING = r111;
        AINoteBlockStatus r112 = new AINoteBlockStatus("FAILED", 8);
        FAILED = r112;
        AINoteBlockStatus[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f407132a = r113;
        f407133b = EnumEntriesKt.enumEntries(r113);
    }

    public static AINoteBlockStatus[] values() {
        return (AINoteBlockStatus[]) f407132a.clone();
    }

    public static AINoteBlockStatus valueOf(String r100) {
        return (AINoteBlockStatus) a.a(AINoteBlockStatus.class, r100);
    }

    public AINoteBlockStatus(String r100, int r101) {
        super(r100, r101);
    }
}
