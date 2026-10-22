package com.ss.android.lark.officesdk.minutes.service.recording.common.core.orchestrator;

import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class RecordingSamePriorityArbitrator {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<b, SamePriorityArbitrationPolicy> f434204b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434205a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/orchestrator/RecordingSamePriorityArbitrator$SamePriorityArbitrationPolicy;", "", "<init>", "(Ljava/lang/String;I)V", "LATER_STARTED_AT_WINS", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum SamePriorityArbitrationPolicy extends Enum<SamePriorityArbitrationPolicy> {
        public static final SamePriorityArbitrationPolicy LATER_STARTED_AT_WINS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SamePriorityArbitrationPolicy[] f434206a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434207b = null;

        public static EnumEntries<SamePriorityArbitrationPolicy> getEntries() {
            return f434207b;
        }

        static {
            SamePriorityArbitrationPolicy r100 = new SamePriorityArbitrationPolicy();
            LATER_STARTED_AT_WINS = r100;
            SamePriorityArbitrationPolicy[] r101 = {r100};
            f434206a = r101;
            f434207b = EnumEntriesKt.enumEntries(r101);
        }

        public SamePriorityArbitrationPolicy() {
            super("LATER_STARTED_AT_WINS", 0);
        }

        public static SamePriorityArbitrationPolicy[] values() {
            return (SamePriorityArbitrationPolicy[]) f434206a.clone();
        }

        public static SamePriorityArbitrationPolicy valueOf(String r100) {
            return (SamePriorityArbitrationPolicy) r27.a.a(SamePriorityArbitrationPolicy.class, r100);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RecordingPriorityScene f434208a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final RecordingPriorityScene f434209b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f434208a == r101.f434208a) goto L12;
            return false;
        L12:
            if (this.f434209b == r101.f434209b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f434208a.hashCode() * 31) + this.f434209b.hashCode();
        }

        public final String toString() {
            return "SamePriorityArbitrationKey(activeScene=" + this.f434208a + ", requestedScene=" + this.f434209b + ')';
        }

        public b(RecordingPriorityScene r100, RecordingPriorityScene r101) {
            Intrinsics.checkNotNullParameter(r100, "activeScene");
            Intrinsics.checkNotNullParameter(r101, "requestedScene");
            this.f434208a = r100;
            this.f434209b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LinkedHashMap<b, SamePriorityArbitrationPolicy> f434210a;

        public c() {
            this.f434210a = new LinkedHashMap();
        }

        public final void a(RecordingPriorityScene r100, RecordingPriorityScene r101, SamePriorityArbitrationPolicy r102) {
            Intrinsics.checkNotNullParameter(r100, "firstScene");
            Intrinsics.checkNotNullParameter(r101, "secondScene");
            Intrinsics.checkNotNullParameter(r102, "policy");
            this.f434210a.put(new b(r100, r101), r102);
            this.f434210a.put(new b(r101, r100), r102);
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f434211a = null;

        static {
            int[] r100 = new int[SamePriorityArbitrationPolicy.values().length];
            r100[SamePriorityArbitrationPolicy.LATER_STARTED_AT_WINS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L6
        L4:
            f434211a = r100;
        }
    }

    static {
        RecordingSamePriorityArbitrator$Companion$samePriorityArbitrationPolicies$1 r100 = RecordingSamePriorityArbitrator$Companion$samePriorityArbitrationPolicies$1.INSTANCE;
        c r101 = new c();
        r100.invoke(r101);
        f434204b = MapsKt.toMap(r101.f434210a);
    }

    public RecordingSamePriorityArbitrator() {
        this.f434205a = "RecordingSamePriorityArbitrator_" + hashCode();
    }
}
