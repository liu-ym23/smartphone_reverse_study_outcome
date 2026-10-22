package com.ss.android.lark.featuregatingv2impl.entity;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0086\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/featuregatingv2impl/entity/ErrorType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", EffectConstants.NORMAL, "SINGLE_ERROR_FROM_PACKAGE", "SINGLE_ERROR_MOLTEN_FAIL", "SINGLE_ERROR_FROM_DISK", "COMPOUND_ERROR_PACKAGE_MOLTEN", "COMPOUND_ERROR_MOLTEN_DISK", "plus", "other", "featuregating-v2-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ErrorType extends Enum<ErrorType> {
    public static final ErrorType COMPOUND_ERROR_MOLTEN_DISK = null;
    public static final ErrorType COMPOUND_ERROR_PACKAGE_MOLTEN = null;
    public static final ErrorType NORMAL = null;
    public static final ErrorType SINGLE_ERROR_FROM_DISK = null;
    public static final ErrorType SINGLE_ERROR_FROM_PACKAGE = null;
    public static final ErrorType SINGLE_ERROR_MOLTEN_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ErrorType[] f420735a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420736b = null;
    private int value;

    public static EnumEntries<ErrorType> getEntries() {
        return f420736b;
    }

    static {
        ErrorType r100 = new ErrorType(EffectConstants.NORMAL, 0, 0);
        NORMAL = r100;
        ErrorType r101 = new ErrorType("SINGLE_ERROR_FROM_PACKAGE", 1, 1);
        SINGLE_ERROR_FROM_PACKAGE = r101;
        ErrorType r102 = new ErrorType("SINGLE_ERROR_MOLTEN_FAIL", 2, 2);
        SINGLE_ERROR_MOLTEN_FAIL = r102;
        ErrorType r103 = new ErrorType("SINGLE_ERROR_FROM_DISK", 3, 4);
        SINGLE_ERROR_FROM_DISK = r103;
        ErrorType r104 = new ErrorType("COMPOUND_ERROR_PACKAGE_MOLTEN", 4, 3);
        COMPOUND_ERROR_PACKAGE_MOLTEN = r104;
        ErrorType r110 = new ErrorType("COMPOUND_ERROR_MOLTEN_DISK", 5, 6);
        COMPOUND_ERROR_MOLTEN_DISK = r110;
        ErrorType[] r111 = {r100, r101, r102, r103, r104, r110};
        f420735a = r111;
        f420736b = EnumEntriesKt.enumEntries(r111);
    }

    public static ErrorType[] values() {
        return (ErrorType[]) f420735a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static ErrorType valueOf(String r100) {
        return (ErrorType) a.a(ErrorType.class, r100);
    }

    public final ErrorType plus(ErrorType r100) {
        Intrinsics.checkNotNullParameter(r100, "other");
        int r101 = this.value + r100.value;
        if (r101 == 0) goto L22;
        if (r101 == 1) goto L27;
        if (r101 == 2) goto L26;
        if (r101 == 3) goto L25;
        if (r101 == 4) goto L24;
        if (r101 != 6) goto L16;
        return COMPOUND_ERROR_MOLTEN_DISK;
    L16:
        throw new IllegalArgumentException("Invalid result value:" + (this.value + r100.value));
    L24:
        return SINGLE_ERROR_FROM_DISK;
    L25:
        return COMPOUND_ERROR_PACKAGE_MOLTEN;
    L26:
        return SINGLE_ERROR_MOLTEN_FAIL;
    L27:
        return SINGLE_ERROR_FROM_PACKAGE;
    L22:
        return NORMAL;
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public ErrorType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
