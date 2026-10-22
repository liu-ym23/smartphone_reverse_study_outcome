package com.larus.bmhome.taskskill;

import com.larus.nova.R;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0080\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B7\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/larus/bmhome/taskskill/RemoteControlAuthorizationMode;", "", "rawValue", "", "titleRes", "descriptionRes", "iconRes", "trackingResult", "", "<init>", "(Ljava/lang/String;IIIIILjava/lang/String;)V", "getRawValue", "()I", "getTitleRes", "getDescriptionRes", "getIconRes", "getTrackingResult", "()Ljava/lang/String;", "ALWAYS_ASK", "ASK_ON_RISK", "FULL_ACCESS", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RemoteControlAuthorizationMode extends Enum<RemoteControlAuthorizationMode> {
    public static final RemoteControlAuthorizationMode ALWAYS_ASK = null;
    public static final RemoteControlAuthorizationMode ASK_ON_RISK = null;
    public static final a Companion = null;
    public static final RemoteControlAuthorizationMode FULL_ACCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RemoteControlAuthorizationMode[] f314197a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314198b = null;
    private final int descriptionRes;
    private final int iconRes;
    private final int rawValue;
    private final int titleRes;
    private final String trackingResult;

    public static final class a {
        public a() {
        }

        public static RemoteControlAuthorizationMode a(int r100) {
            Iterator<RemoteControlAuthorizationMode> r101 = RemoteControlAuthorizationMode.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            RemoteControlAuthorizationMode r102 = r101.next();
            if (r102.getRawValue() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L13:
            return r102;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L13
        }
    }

    public static EnumEntries<RemoteControlAuthorizationMode> getEntries() {
        return f314198b;
    }

    static {
        RemoteControlAuthorizationMode r100 = new RemoteControlAuthorizationMode("ALWAYS_ASK", 0, 0, R.string.larus_permission_mode_always_ask_cn, R.string.larus_permission_mode_always_ask_external_files_and_internet_cn, R.drawable.larus_dbx_ic_requestpermission, "always_ask");
        ALWAYS_ASK = r100;
        RemoteControlAuthorizationMode r101 = new RemoteControlAuthorizationMode("ASK_ON_RISK", 1, 1, R.string.larus_permission_mode_ask_on_risk_cn, R.string.larus_permission_mode_ask_only_for_risky_actions_cn, R.drawable.larus_dbx_ic_code_check, "auto_process");
        ASK_ON_RISK = r101;
        RemoteControlAuthorizationMode r102 = new RemoteControlAuthorizationMode("FULL_ACCESS", 2, 2, R.string.larus_permission_mode_always_allow_cn, R.string.larus_permission_mode_unrestricted_internet_and_file_editing_cn, R.drawable.larus_dbx_ic_fullaccess, "always_permit");
        FULL_ACCESS = r102;
        RemoteControlAuthorizationMode[] r103 = {r100, r101, r102};
        f314197a = r103;
        f314198b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static RemoteControlAuthorizationMode[] values() {
        return (RemoteControlAuthorizationMode[]) f314197a.clone();
    }

    public final int getDescriptionRes() {
        return this.descriptionRes;
    }

    public final int getIconRes() {
        return this.iconRes;
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final String getTrackingResult() {
        return this.trackingResult;
    }

    public static RemoteControlAuthorizationMode valueOf(String r100) {
        return (RemoteControlAuthorizationMode) r27.a.a(RemoteControlAuthorizationMode.class, r100);
    }

    public RemoteControlAuthorizationMode(String r100, int r101, int r102, int r103, int r104, int r105, String r106) {
        super(r100, r101);
        this.rawValue = r102;
        this.titleRes = r103;
        this.descriptionRes = r104;
        this.iconRes = r105;
        this.trackingResult = r106;
    }
}
