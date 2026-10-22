package com.ss.android.lark.forwardv3;

import com.ss.android.lark.forwardv3.dependency.ExternalForwardDirection;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/ExternalForwardSendMode;", "", "executorDirection", "Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "<init>", "(Ljava/lang/String;ILcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;)V", "getExecutorDirection$forward_new_release", "()Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "DOUBAO_ENTRY", "MIXED_EXTERNAL_TARGET", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalForwardSendMode extends Enum<ExternalForwardSendMode> {
    public static final ExternalForwardSendMode DOUBAO_ENTRY = null;
    public static final ExternalForwardSendMode MIXED_EXTERNAL_TARGET = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalForwardSendMode[] f425075a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425076b = null;
    private final ExternalForwardDirection executorDirection;

    public static EnumEntries<ExternalForwardSendMode> getEntries() {
        return f425076b;
    }

    static {
        ExternalForwardSendMode r100 = new ExternalForwardSendMode("DOUBAO_ENTRY", 0, ExternalForwardDirection.DOUBAO_TO_LARK);
        DOUBAO_ENTRY = r100;
        ExternalForwardSendMode r101 = new ExternalForwardSendMode("MIXED_EXTERNAL_TARGET", 1, null);
        MIXED_EXTERNAL_TARGET = r101;
        ExternalForwardSendMode[] r102 = {r100, r101};
        f425075a = r102;
        f425076b = EnumEntriesKt.enumEntries(r102);
    }

    public static ExternalForwardSendMode[] values() {
        return (ExternalForwardSendMode[]) f425075a.clone();
    }

    public final ExternalForwardDirection getExecutorDirection$forward_new_release() {
        return this.executorDirection;
    }

    public static ExternalForwardSendMode valueOf(String r100) {
        return (ExternalForwardSendMode) r27.a.a(ExternalForwardSendMode.class, r100);
    }

    public ExternalForwardSendMode(String r100, int r101, ExternalForwardDirection r102) {
        super(r100, r101);
        this.executorDirection = r102;
    }
}
