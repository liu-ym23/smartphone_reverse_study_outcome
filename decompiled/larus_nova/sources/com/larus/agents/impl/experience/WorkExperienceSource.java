package com.larus.agents.impl.experience;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/agents/impl/experience/WorkExperienceSource;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "HARNESS", "MODEL", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WorkExperienceSource extends Enum<WorkExperienceSource> {
    public static final a Companion = null;
    public static final WorkExperienceSource HARNESS = null;
    public static final WorkExperienceSource MODEL = null;
    public static final WorkExperienceSource UNKNOWN = null;
    public static final WorkExperienceSource USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WorkExperienceSource[] f286658a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286659b = null;
    private final int value;

    public static final class a {
        public a() {
        }

        public static WorkExperienceSource a(Integer r100) {
            Iterator<WorkExperienceSource> r101 = WorkExperienceSource.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L14;
            WorkExperienceSource r102 = r101.next();
            int r103 = r102.getValue();
            if (r100 != null) goto L9;
        L11:
            boolean r104 = false;
        L12:
            if (r104 == false) goto L4;
        L15:
            WorkExperienceSource r105 = r102;
            if (r105 == null) goto L18;
            return r105;
        L18:
            return WorkExperienceSource.UNKNOWN;
        L9:
            if (r103 != r100.intValue()) goto L11;
            r104 = true;
            goto L12
        L14:
            r102 = null;
            goto L15
        }
    }

    public static EnumEntries<WorkExperienceSource> getEntries() {
        return f286659b;
    }

    static {
        WorkExperienceSource r100 = new WorkExperienceSource("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        WorkExperienceSource r101 = new WorkExperienceSource("HARNESS", 1, 1);
        HARNESS = r101;
        WorkExperienceSource r102 = new WorkExperienceSource("MODEL", 2, 2);
        MODEL = r102;
        WorkExperienceSource r103 = new WorkExperienceSource(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 3, 3);
        USER = r103;
        WorkExperienceSource[] r104 = {r100, r101, r102, r103};
        f286658a = r104;
        f286659b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static WorkExperienceSource[] values() {
        return (WorkExperienceSource[]) f286658a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static WorkExperienceSource valueOf(String r100) {
        return (WorkExperienceSource) r27.a.a(WorkExperienceSource.class, r100);
    }

    public WorkExperienceSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
