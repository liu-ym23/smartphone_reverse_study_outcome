package com.obric.assistant.activation.presentation.runtime.manager;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/assistant/activation/presentation/runtime/manager/ActivationSource;", "", "<init>", "(Ljava/lang/String;I)V", "AI_KEY", "VOICE", "BREATH", "POWER_KEY", "POWER_KEY_TERMINAL", "runtime_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ActivationSource extends Enum<ActivationSource> {
    public static final ActivationSource AI_KEY = null;
    public static final ActivationSource BREATH = null;
    public static final ActivationSource POWER_KEY = null;
    public static final ActivationSource POWER_KEY_TERMINAL = null;
    public static final ActivationSource VOICE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActivationSource[] f385281a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f385282b = null;

    public static EnumEntries<ActivationSource> getEntries() {
        return f385282b;
    }

    static {
        ActivationSource r100 = new ActivationSource("AI_KEY", 0);
        AI_KEY = r100;
        ActivationSource r101 = new ActivationSource("VOICE", 1);
        VOICE = r101;
        ActivationSource r102 = new ActivationSource("BREATH", 2);
        BREATH = r102;
        ActivationSource r103 = new ActivationSource("POWER_KEY", 3);
        POWER_KEY = r103;
        ActivationSource r104 = new ActivationSource("POWER_KEY_TERMINAL", 4);
        POWER_KEY_TERMINAL = r104;
        ActivationSource[] r105 = {r100, r101, r102, r103, r104};
        f385281a = r105;
        f385282b = EnumEntriesKt.enumEntries(r105);
    }

    public static ActivationSource[] values() {
        return (ActivationSource[]) f385281a.clone();
    }

    public static ActivationSource valueOf(String r100) {
        return (ActivationSource) r27.a.a(ActivationSource.class, r100);
    }

    public ActivationSource(String r100, int r101) {
        super(r100, r101);
    }
}
