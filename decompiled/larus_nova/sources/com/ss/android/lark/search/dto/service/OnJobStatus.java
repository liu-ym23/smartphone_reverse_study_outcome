package com.ss.android.lark.search.dto.service;

import com.obric.miniapp.alarm.AccountType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/search/dto/service/OnJobStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "ON_JOB", "RESIGNED", AccountType.ALL, "Companion", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OnJobStatus extends Enum<OnJobStatus> {
    public static final OnJobStatus ALL = null;
    public static final a Companion = null;
    public static final OnJobStatus ON_JOB = null;
    public static final OnJobStatus RESIGNED = null;
    public static final OnJobStatus UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OnJobStatus[] f440170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f440171b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<OnJobStatus> getEntries() {
        return f440171b;
    }

    static {
        OnJobStatus r100 = new OnJobStatus("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        OnJobStatus r101 = new OnJobStatus("ON_JOB", 1, 1);
        ON_JOB = r101;
        OnJobStatus r102 = new OnJobStatus("RESIGNED", 2, 2);
        RESIGNED = r102;
        OnJobStatus r103 = new OnJobStatus(AccountType.ALL, 3, 3);
        ALL = r103;
        OnJobStatus[] r104 = {r100, r101, r102, r103};
        f440170a = r104;
        f440171b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static OnJobStatus[] values() {
        return (OnJobStatus[]) f440170a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final OnJobStatus valueOf(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        return UNKNOWN;
    L17:
        return ALL;
    L18:
        return RESIGNED;
    L19:
        return ON_JOB;
    L15:
        return UNKNOWN;
    }

    public static OnJobStatus valueOf(String r100) {
        return (OnJobStatus) r27.a.a(OnJobStatus.class, r100);
    }

    public OnJobStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
