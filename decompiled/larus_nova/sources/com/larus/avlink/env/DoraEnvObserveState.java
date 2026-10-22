package com.larus.avlink.env;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/env/DoraEnvObserveState;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, GXAnimation.STATE_END, "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraEnvObserveState extends Enum<DoraEnvObserveState> {
    public static final DoraEnvObserveState END = null;
    public static final DoraEnvObserveState START = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraEnvObserveState[] f291849a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f291850b = null;

    public static EnumEntries<DoraEnvObserveState> getEntries() {
        return f291850b;
    }

    static {
        DoraEnvObserveState r100 = new DoraEnvObserveState(GXAnimation.STATE_START, 0);
        START = r100;
        DoraEnvObserveState r101 = new DoraEnvObserveState(GXAnimation.STATE_END, 1);
        END = r101;
        DoraEnvObserveState[] r102 = {r100, r101};
        f291849a = r102;
        f291850b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoraEnvObserveState[] values() {
        return (DoraEnvObserveState[]) f291849a.clone();
    }

    public static DoraEnvObserveState valueOf(String r100) {
        return (DoraEnvObserveState) a.a(DoraEnvObserveState.class, r100);
    }

    public DoraEnvObserveState(String r100, int r101) {
        super(r100, r101);
    }
}
