package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/FileBizDomain;", "", "biz", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getBiz", "()Ljava/lang/String;", "FileBizDomainUNKNOWN", "FileBizDomainCCM", "FileBizDomainIM", "FileBizDomainMAIL", "FileBizDomainVC", "FileBizDomainTODO", "FileBizDomainCALENDAR", "FileBizDomainPASSPORT", "FileBizDomainIMOTHERS", "FileBizDomainMeetingMinutes", "FileBizDomainApproval", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileBizDomain extends Enum<FileBizDomain> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ FileBizDomain[] $VALUES = null;

    @SerializedName("Approval")
    public static final FileBizDomain FileBizDomainApproval = null;

    @SerializedName("Calendar")
    public static final FileBizDomain FileBizDomainCALENDAR = null;

    @SerializedName("CCM")
    public static final FileBizDomain FileBizDomainCCM = null;

    @SerializedName("IM")
    public static final FileBizDomain FileBizDomainIM = null;

    @SerializedName("IM_Others")
    public static final FileBizDomain FileBizDomainIMOTHERS = null;

    @SerializedName("Mail")
    public static final FileBizDomain FileBizDomainMAIL = null;

    @SerializedName("MeetingMinutes")
    public static final FileBizDomain FileBizDomainMeetingMinutes = null;

    @SerializedName("Passport")
    public static final FileBizDomain FileBizDomainPASSPORT = null;

    @SerializedName(AlarmSessionType.TODO)
    public static final FileBizDomain FileBizDomainTODO = null;

    @SerializedName("Unknown")
    public static final FileBizDomain FileBizDomainUNKNOWN = null;

    @SerializedName("VC")
    public static final FileBizDomain FileBizDomainVC = null;
    private final String biz;

    private static final /* synthetic */ FileBizDomain[] $values() {
        return new FileBizDomain[]{FileBizDomainUNKNOWN, FileBizDomainCCM, FileBizDomainIM, FileBizDomainMAIL, FileBizDomainVC, FileBizDomainTODO, FileBizDomainCALENDAR, FileBizDomainPASSPORT, FileBizDomainIMOTHERS, FileBizDomainMeetingMinutes, FileBizDomainApproval};
    }

    public static EnumEntries<FileBizDomain> getEntries() {
        return $ENTRIES;
    }

    static {
        FileBizDomainUNKNOWN = new FileBizDomain("FileBizDomainUNKNOWN", 0, "Unknown");
        FileBizDomainCCM = new FileBizDomain("FileBizDomainCCM", 1, "CCM");
        FileBizDomainIM = new FileBizDomain("FileBizDomainIM", 2, "IM");
        FileBizDomainMAIL = new FileBizDomain("FileBizDomainMAIL", 3, "Mail");
        FileBizDomainVC = new FileBizDomain("FileBizDomainVC", 4, "VC");
        FileBizDomainTODO = new FileBizDomain("FileBizDomainTODO", 5, AlarmSessionType.TODO);
        FileBizDomainCALENDAR = new FileBizDomain("FileBizDomainCALENDAR", 6, "Calendar");
        FileBizDomainPASSPORT = new FileBizDomain("FileBizDomainPASSPORT", 7, "Passport");
        FileBizDomainIMOTHERS = new FileBizDomain("FileBizDomainIMOTHERS", 8, "IM_Others");
        FileBizDomainMeetingMinutes = new FileBizDomain("FileBizDomainMeetingMinutes", 9, "MeetingMinutes");
        FileBizDomainApproval = new FileBizDomain("FileBizDomainApproval", 10, "Approval");
        FileBizDomain[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static FileBizDomain[] values() {
        return (FileBizDomain[]) $VALUES.clone();
    }

    public final String getBiz() {
        return this.biz;
    }

    public static FileBizDomain valueOf(String r100) {
        return (FileBizDomain) r27.a.a(FileBizDomain.class, r100);
    }

    private FileBizDomain(String r100, int r101, String r102) {
        super(r100, r101);
        this.biz = r102;
    }
}
