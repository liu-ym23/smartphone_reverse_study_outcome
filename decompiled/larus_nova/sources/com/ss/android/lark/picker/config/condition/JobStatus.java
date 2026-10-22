package com.ss.android.lark.picker.config.condition;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016J\u0010\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0000H\u0016R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00000\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fj\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/JobStatus;", "Lcom/ss/android/lark/picker/config/condition/ChatterCondition;", "", "<init>", "(Ljava/lang/String;I)V", UserProfileEvent.POSITION_NONE, "ON_JOB", "RESIGNED", AccountType.ALL, "key", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "getKey", "()Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "isNone", "", "inter", "other", "union", "Key", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum JobStatus extends Enum<JobStatus> implements ChatterCondition<JobStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ JobStatus[] $VALUES = null;
    public static final JobStatus ALL = null;
    public static final JobStatus NONE = null;
    public static final JobStatus ON_JOB = null;
    public static final JobStatus RESIGNED = null;
    private final Condition.Key<JobStatus> key;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/lark/picker/config/condition/JobStatus$Key;", "Lcom/ss/android/lark/picker/config/condition/Condition$Key;", "Lcom/ss/android/lark/picker/config/condition/JobStatus;", "<init>", "()V", "picker_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Key implements Condition.Key<JobStatus> {
        public static final Key INSTANCE = null;

        static {
            INSTANCE = new Key();
        }

        private Key() {
        }
    }

    private static final /* synthetic */ JobStatus[] $values() {
        return new JobStatus[]{NONE, ON_JOB, RESIGNED, ALL};
    }

    public static EnumEntries<JobStatus> getEntries() {
        return $ENTRIES;
    }

    static {
        NONE = new JobStatus(UserProfileEvent.POSITION_NONE, 0);
        ON_JOB = new JobStatus("ON_JOB", 1);
        RESIGNED = new JobStatus("RESIGNED", 2);
        ALL = new JobStatus(AccountType.ALL, 3);
        JobStatus[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static JobStatus[] values() {
        return (JobStatus[]) $VALUES.clone();
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public boolean isNone() {
        if (this != NONE) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public Condition.Key<JobStatus> getKey() {
        return this.key;
    }

    public static JobStatus valueOf(String r100) {
        return (JobStatus) a.a(JobStatus.class, r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public <E extends Condition.Element<E>> E get(Condition.Key<E> r100) {
        return (E) ChatterCondition.DefaultImpls.get(this, r100);
    }

    public JobStatus inter(JobStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        JobStatus[] r101 = values();
        int r102 = ordinal();
        return r101[r100.ordinal() & r102];
    }

    public JobStatus union(JobStatus r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        JobStatus[] r101 = values();
        int r102 = ordinal();
        return r101[r100.ordinal() | r102];
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element inter(Condition.Element r100) {
        return inter((JobStatus) r100);
    }

    @Override // com.ss.android.lark.picker.config.condition.Condition.Element
    public /* bridge */ /* synthetic */ Condition.Element union(Condition.Element r100) {
        return union((JobStatus) r100);
    }

    private JobStatus(String r100, int r101) {
        super(r100, r101);
        this.key = Key.INSTANCE;
    }
}
