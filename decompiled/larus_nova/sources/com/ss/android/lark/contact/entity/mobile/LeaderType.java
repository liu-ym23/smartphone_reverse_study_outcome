package com.ss.android.lark.contact.entity.mobile;

import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/contact/entity/mobile/LeaderType;", "", "value", "", "stringRes", "<init>", "(Ljava/lang/String;III)V", "getValue", "()I", "getStringRes", "MAINLEADER", "SUBLEADER", "ENTERPRISELEADER", "Companion", "contact-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LeaderType extends Enum<LeaderType> {
    public static final a Companion = null;
    public static final LeaderType ENTERPRISELEADER = null;
    public static final LeaderType MAINLEADER = null;
    public static final LeaderType SUBLEADER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<LeaderType[]> f419439a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ LeaderType[] f419440b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f419441c = null;
    private final int stringRes;
    private final int value;

    public static EnumEntries<LeaderType> getEntries() {
        return f419441c;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.contact.entity.mobile.LeaderType$a] */
    static {
        LeaderType r100 = new LeaderType("MAINLEADER", 0, 1, R.string.Lark_Status_SupervisorMain);
        MAINLEADER = r100;
        LeaderType r101 = new LeaderType("SUBLEADER", 1, 2, R.string.Lark_Status_SupervisorTag);
        SUBLEADER = r101;
        LeaderType r102 = new LeaderType("ENTERPRISELEADER", 2, 3, R.string.Lark_Status_OrganizationSupervisor);
        ENTERPRISELEADER = r102;
        LeaderType[] r103 = {r100, r101, r102};
        f419440b = r103;
        f419441c = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
        f419439a = LazyKt.lazy(LeaderType$Companion$values$2.INSTANCE);
    }

    public static LeaderType[] values() {
        return (LeaderType[]) f419440b.clone();
    }

    public static final /* synthetic */ Lazy access$getValues$delegate$cp() {
        return f419439a;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public final int getValue() {
        return this.value;
    }

    public static LeaderType valueOf(String r100) {
        return (LeaderType) r27.a.a(LeaderType.class, r100);
    }

    public LeaderType(String r100, int r101, int r102, int r103) {
        super(r100, r101);
        this.value = r102;
        this.stringRes = r103;
    }
}
