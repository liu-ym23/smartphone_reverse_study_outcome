package com.larus.avlink.plugins;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/plugins/DoraIntentType;", "", "type", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getDesc", "()Ljava/lang/String;", "UNKNOWN", "TAKE_PHOTO", "START_VIDEO_RECORDING", "END_SESSION", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraIntentType extends Enum<DoraIntentType> {
    public static final DoraIntentType END_SESSION = null;
    public static final DoraIntentType START_VIDEO_RECORDING = null;
    public static final DoraIntentType TAKE_PHOTO = null;
    public static final DoraIntentType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraIntentType[] f293659a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f293660b = null;
    private final String desc;
    private final int type;

    public static EnumEntries<DoraIntentType> getEntries() {
        return f293660b;
    }

    static {
        DoraIntentType r100 = new DoraIntentType("UNKNOWN", 0, -1, "unknown");
        UNKNOWN = r100;
        DoraIntentType r101 = new DoraIntentType("TAKE_PHOTO", 1, 1, "take_photo");
        TAKE_PHOTO = r101;
        DoraIntentType r102 = new DoraIntentType("START_VIDEO_RECORDING", 2, 2, "start_video_recording");
        START_VIDEO_RECORDING = r102;
        DoraIntentType r103 = new DoraIntentType("END_SESSION", 3, 3, "end_session");
        END_SESSION = r103;
        DoraIntentType[] r104 = {r100, r101, r102, r103};
        f293659a = r104;
        f293660b = EnumEntriesKt.enumEntries(r104);
    }

    public static DoraIntentType[] values() {
        return (DoraIntentType[]) f293659a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public final int getType() {
        return this.type;
    }

    public static DoraIntentType valueOf(String r100) {
        return (DoraIntentType) r27.a.a(DoraIntentType.class, r100);
    }

    public DoraIntentType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.desc = r103;
    }
}
