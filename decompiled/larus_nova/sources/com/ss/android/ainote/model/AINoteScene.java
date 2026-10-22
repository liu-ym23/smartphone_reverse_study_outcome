package com.ss.android.ainote.model;

import com.bytedance.crash.general.HardwareInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\u000b\u001a\u00020\fj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u000e"}, d2 = {"Lcom/ss/android/ainote/model/AINoteScene;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "Meeting", "Record", "Hardware", "usesMeetingId", "", "usesUniqueId", "sessionPrefix", "", "Companion", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteScene extends Enum<AINoteScene> {
    public static final a Companion = null;
    public static final AINoteScene Hardware = null;
    public static final AINoteScene Meeting = null;
    public static final AINoteScene Record = null;
    public static final AINoteScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteScene[] f407143a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f407144b = null;

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f407145a = null;

        static {
            int[] r100 = new int[AINoteScene.values().length];
            r100[AINoteScene.Meeting.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AINoteScene.Record.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AINoteScene.Hardware.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AINoteScene.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f407145a = r100;
        }
    }

    public static EnumEntries<AINoteScene> getEntries() {
        return f407144b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.ainote.model.AINoteScene$a] */
    static {
        AINoteScene r100 = new AINoteScene("UNKNOWN", 0);
        UNKNOWN = r100;
        AINoteScene r101 = new AINoteScene("Meeting", 1);
        Meeting = r101;
        AINoteScene r102 = new AINoteScene("Record", 2);
        Record = r102;
        AINoteScene r103 = new AINoteScene("Hardware", 3);
        Hardware = r103;
        AINoteScene[] r104 = {r100, r101, r102, r103};
        f407143a = r104;
        f407144b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static AINoteScene[] values() {
        return (AINoteScene[]) f407143a.clone();
    }

    public final String sessionPrefix() {
        int r100 = b.f407145a[ordinal()];
        if (r100 != 1) goto L5;
        return "meeting";
    L5:
        if (r100 != 2) goto L7;
        return "record";
    L7:
        if (r100 != 3) goto L9;
        return HardwareInfo.KEY_HW_CPU_HARDWARE;
    L9:
        if (r100 != 4) goto L12;
        return "unknown";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public final boolean usesMeetingId() {
        if (this != Meeting) goto L5;
    L10:
        return true;
    L5:
        if (this == Record) goto L10;
        if (this == Hardware) goto L10;
        return false;
    }

    public final boolean usesUniqueId() {
        if (this != Hardware) goto L5;
        return true;
    L5:
        return false;
    }

    public static AINoteScene valueOf(String r100) {
        return (AINoteScene) r27.a.a(AINoteScene.class, r100);
    }

    public AINoteScene(String r100, int r101) {
        super(r100, r101);
    }
}
