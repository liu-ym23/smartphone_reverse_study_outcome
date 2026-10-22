package com.ss.android.lark.officesdk.experiment;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u000e2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000eB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000f"}, d2 = {"Lcom/ss/android/lark/officesdk/experiment/LaunchExperiment;", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "LAUNCH_ONLY_OFFICE_SDK", "LAUNCH_OFFICE_SDK_RUST_INIT", "LAUNCH_OFFICE_SDK_ALL", "LAUNCH_ALL_AFTER", "isBeforeFirstFeed", "", "Companion", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LaunchExperiment extends Enum<LaunchExperiment> {
    public static final a Companion = null;
    public static final LaunchExperiment LAUNCH_ALL_AFTER = null;
    public static final LaunchExperiment LAUNCH_OFFICE_SDK_ALL = null;
    public static final LaunchExperiment LAUNCH_OFFICE_SDK_RUST_INIT = null;
    public static final LaunchExperiment LAUNCH_ONLY_OFFICE_SDK = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LaunchExperiment[] f433206a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433207b = null;
    private final String desc;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<LaunchExperiment> getEntries() {
        return f433207b;
    }

    static {
        LaunchExperiment r100 = new LaunchExperiment("LAUNCH_ONLY_OFFICE_SDK", 0, "office_sdk_only");
        LAUNCH_ONLY_OFFICE_SDK = r100;
        LaunchExperiment r101 = new LaunchExperiment("LAUNCH_OFFICE_SDK_RUST_INIT", 1, "office_sdk_rust_init");
        LAUNCH_OFFICE_SDK_RUST_INIT = r101;
        LaunchExperiment r102 = new LaunchExperiment("LAUNCH_OFFICE_SDK_ALL", 2, "office_sdk_all");
        LAUNCH_OFFICE_SDK_ALL = r102;
        LaunchExperiment r103 = new LaunchExperiment("LAUNCH_ALL_AFTER", 3, "office_sdk_lazy");
        LAUNCH_ALL_AFTER = r103;
        LaunchExperiment[] r104 = {r100, r101, r102, r103};
        f433206a = r104;
        f433207b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static LaunchExperiment[] values() {
        return (LaunchExperiment[]) f433206a.clone();
    }

    public final boolean isBeforeFirstFeed() {
        if (this == LAUNCH_ALL_AFTER) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getDesc() {
        return this.desc;
    }

    @JvmStatic
    public static final LaunchExperiment toEnum(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return LAUNCH_ALL_AFTER;
    L14:
        return LAUNCH_ONLY_OFFICE_SDK;
    L15:
        return LAUNCH_OFFICE_SDK_ALL;
    L12:
        return LAUNCH_ALL_AFTER;
    }

    public static LaunchExperiment valueOf(String r100) {
        return (LaunchExperiment) r27.a.a(LaunchExperiment.class, r100);
    }

    public LaunchExperiment(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
