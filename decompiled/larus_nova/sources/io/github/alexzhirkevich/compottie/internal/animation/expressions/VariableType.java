package io.github.alexzhirkevich.compottie.internal.animation.expressions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lio/github/alexzhirkevich/compottie/internal/animation/expressions/VariableType;", "", "<init>", "(Ljava/lang/String;I)V", "Var", "Let", "Const", "compottie_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VariableType extends Enum<VariableType> {
    public static final VariableType Const = null;
    public static final VariableType Let = null;
    public static final VariableType Var = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VariableType[] f490813a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f490814b = null;

    public static EnumEntries<VariableType> getEntries() {
        return f490814b;
    }

    static {
        VariableType r100 = new VariableType("Var", 0);
        Var = r100;
        VariableType r101 = new VariableType("Let", 1);
        Let = r101;
        VariableType r102 = new VariableType("Const", 2);
        Const = r102;
        VariableType[] r103 = {r100, r101, r102};
        f490813a = r103;
        f490814b = EnumEntriesKt.enumEntries(r103);
    }

    public static VariableType[] values() {
        return (VariableType[]) f490813a.clone();
    }

    public static VariableType valueOf(String r100) {
        return (VariableType) r27.a.a(VariableType.class, r100);
    }

    public VariableType(String r100, int r101) {
        super(r100, r101);
    }
}
