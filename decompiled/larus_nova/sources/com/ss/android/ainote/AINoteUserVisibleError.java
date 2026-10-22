package com.ss.android.ainote;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ainote/AINoteUserVisibleError;", "", "<init>", "(Ljava/lang/String;I)V", "VERSION_CONFLICT", "ai-note_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AINoteUserVisibleError extends Enum<AINoteUserVisibleError> {
    public static final AINoteUserVisibleError VERSION_CONFLICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AINoteUserVisibleError[] f406531a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f406532b = null;

    public static EnumEntries<AINoteUserVisibleError> getEntries() {
        return f406532b;
    }

    static {
        AINoteUserVisibleError r100 = new AINoteUserVisibleError();
        VERSION_CONFLICT = r100;
        AINoteUserVisibleError[] r101 = {r100};
        f406531a = r101;
        f406532b = EnumEntriesKt.enumEntries(r101);
    }

    public AINoteUserVisibleError() {
        super("VERSION_CONFLICT", 0);
    }

    public static AINoteUserVisibleError[] values() {
        return (AINoteUserVisibleError[]) f406531a.clone();
    }

    public static AINoteUserVisibleError valueOf(String r100) {
        return (AINoteUserVisibleError) r27.a.a(AINoteUserVisibleError.class, r100);
    }
}
