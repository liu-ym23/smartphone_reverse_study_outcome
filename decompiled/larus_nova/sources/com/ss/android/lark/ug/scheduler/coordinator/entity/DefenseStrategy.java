package com.ss.android.lark.ug.scheduler.coordinator.entity;

import com.bytedance.lark.pb.ugreach.v1.ReachPointRelation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/ug/scheduler/coordinator/entity/DefenseStrategy;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "ROUND_ABORT", "GIVE_UP", "Companion", "ug-reach-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DefenseStrategy extends Enum<DefenseStrategy> {
    public static final a Companion = null;
    public static final DefenseStrategy GIVE_UP = null;
    public static final DefenseStrategy ROUND_ABORT = null;
    public static final DefenseStrategy UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DefenseStrategy[] f444477a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f444478b = null;

    public static final class a {

        /* JADX INFO: renamed from: com.ss.android.lark.ug.scheduler.coordinator.entity.DefenseStrategy$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C5365a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f444479a = null;

            static {
                int[] r100 = new int[ReachPointRelation.DefenseStrategy.values().length];
                r100[ReachPointRelation.DefenseStrategy.GIVE_UP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r100[ReachPointRelation.DefenseStrategy.ROUNDABOUT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f444479a = r100;
            }
        }

        public a() {
        }
    }

    public static EnumEntries<DefenseStrategy> getEntries() {
        return f444478b;
    }

    static {
        DefenseStrategy r100 = new DefenseStrategy("UNKNOWN", 0);
        UNKNOWN = r100;
        DefenseStrategy r101 = new DefenseStrategy("ROUND_ABORT", 1);
        ROUND_ABORT = r101;
        DefenseStrategy r102 = new DefenseStrategy("GIVE_UP", 2);
        GIVE_UP = r102;
        DefenseStrategy[] r103 = {r100, r101, r102};
        f444477a = r103;
        f444478b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static DefenseStrategy[] values() {
        return (DefenseStrategy[]) f444477a.clone();
    }

    public static DefenseStrategy valueOf(String r100) {
        return (DefenseStrategy) r27.a.a(DefenseStrategy.class, r100);
    }

    public DefenseStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
