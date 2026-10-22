package com.larus.audio.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/larus/audio/bean/AppeaseType;", "", "type", "", "scene", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getType", "()I", "getScene", "()Ljava/lang/String;", "UNKNOW", "VOICE", "PEOPLE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AppeaseType extends Enum<AppeaseType> {
    public static final AppeaseType PEOPLE = null;
    public static final AppeaseType UNKNOW = null;
    public static final AppeaseType VOICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AppeaseType[] f288715a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f288716b = null;
    private final String scene;
    private final int type;

    public static EnumEntries<AppeaseType> getEntries() {
        return f288716b;
    }

    static {
        AppeaseType r100 = new AppeaseType("UNKNOW", 0, 0, "");
        UNKNOW = r100;
        AppeaseType r101 = new AppeaseType("VOICE", 1, 1, "audio_comfort");
        VOICE = r101;
        AppeaseType r102 = new AppeaseType("PEOPLE", 2, 2, "voice_comfort");
        PEOPLE = r102;
        AppeaseType[] r103 = {r100, r101, r102};
        f288715a = r103;
        f288716b = EnumEntriesKt.enumEntries(r103);
    }

    public static AppeaseType[] values() {
        return (AppeaseType[]) f288715a.clone();
    }

    public final String getScene() {
        return this.scene;
    }

    public final int getType() {
        return this.type;
    }

    public static AppeaseType valueOf(String r100) {
        return (AppeaseType) a.a(AppeaseType.class, r100);
    }

    public AppeaseType(String r100, int r101, int r102, String r103) {
        super(r100, r101);
        this.type = r102;
        this.scene = r103;
    }
}
