package com.ss.android.lark.forwardv3.dependency;

import com.ss.android.lark.picker.doubao.ExternalTargetConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/forwardv3/dependency/ExternalForwardDirection;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DOUBAO_TO_LARK", "LARK_TO_DOUBAO", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ExternalForwardDirection extends Enum<ExternalForwardDirection> {
    public static final ExternalForwardDirection DOUBAO_TO_LARK = null;
    public static final ExternalForwardDirection LARK_TO_DOUBAO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ExternalForwardDirection[] f425329a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f425330b = null;
    private final String value;

    public static EnumEntries<ExternalForwardDirection> getEntries() {
        return f425330b;
    }

    static {
        ExternalForwardDirection r100 = new ExternalForwardDirection("DOUBAO_TO_LARK", 0, ExternalTargetConstants.DIRECTION_DOUBAO_TO_LARK);
        DOUBAO_TO_LARK = r100;
        ExternalForwardDirection r101 = new ExternalForwardDirection("LARK_TO_DOUBAO", 1, ExternalTargetConstants.DIRECTION_LARK_TO_DOUBAO);
        LARK_TO_DOUBAO = r101;
        ExternalForwardDirection[] r102 = {r100, r101};
        f425329a = r102;
        f425330b = EnumEntriesKt.enumEntries(r102);
    }

    public static ExternalForwardDirection[] values() {
        return (ExternalForwardDirection[]) f425329a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ExternalForwardDirection valueOf(String r100) {
        return (ExternalForwardDirection) a.a(ExternalForwardDirection.class, r100);
    }

    public ExternalForwardDirection(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
