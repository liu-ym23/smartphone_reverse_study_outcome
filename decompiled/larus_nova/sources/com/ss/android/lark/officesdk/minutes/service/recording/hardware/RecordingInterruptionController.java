package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class RecordingInterruptionController {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f435534l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HardwarePlaybackState f435535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f435536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f435537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f435538d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public InputRecoveryPolicy f435539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f435540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Job f435541g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Job f435542h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f435543i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f435544j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Job f435545k;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/RecordingInterruptionController$InputRecoveryPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "STANDARD", "END_ON_FRESH_IDLE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum InputRecoveryPolicy extends Enum<InputRecoveryPolicy> {
        public static final InputRecoveryPolicy END_ON_FRESH_IDLE = null;
        public static final InputRecoveryPolicy STANDARD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ InputRecoveryPolicy[] f435546a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f435547b = null;

        public static EnumEntries<InputRecoveryPolicy> getEntries() {
            return f435547b;
        }

        static {
            InputRecoveryPolicy r100 = new InputRecoveryPolicy("STANDARD", 0);
            STANDARD = r100;
            InputRecoveryPolicy r101 = new InputRecoveryPolicy("END_ON_FRESH_IDLE", 1);
            END_ON_FRESH_IDLE = r101;
            InputRecoveryPolicy[] r102 = {r100, r101};
            f435546a = r102;
            f435547b = EnumEntriesKt.enumEntries(r102);
        }

        public static InputRecoveryPolicy[] values() {
            return (InputRecoveryPolicy[]) f435546a.clone();
        }

        public static InputRecoveryPolicy valueOf(String r100) {
            return (InputRecoveryPolicy) r27.a.a(InputRecoveryPolicy.class, r100);
        }

        public InputRecoveryPolicy(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    static {
    }

    public final void a() {
        Job r100 = this.f435541g;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        Job r101 = this.f435542h;
        if (r101 == null) goto L8;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L8:
        this.f435544j++;
        Job r102 = this.f435543i;
        if (r102 == null) goto L11;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L11:
        this.f435543i = null;
        Job r103 = this.f435545k;
        if (r103 == null) goto L14;
        Job.DefaultImpls.cancel$default(r103, null, 1, null);
    L14:
        this.f435541g = null;
        this.f435542h = null;
        this.f435545k = null;
        this.f435539e = InputRecoveryPolicy.STANDARD;
    }
}
