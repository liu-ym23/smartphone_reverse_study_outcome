package com.larus.kmp.voice_setting.voice.list.managed;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/managed/ManagedVoiceListFooterState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "READY", "LOADING", "ERROR", GXAnimation.STATE_END, "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ManagedVoiceListFooterState extends Enum<ManagedVoiceListFooterState> {
    public static final ManagedVoiceListFooterState END = null;
    public static final ManagedVoiceListFooterState ERROR = null;
    public static final ManagedVoiceListFooterState HIDDEN = null;
    public static final ManagedVoiceListFooterState LOADING = null;
    public static final ManagedVoiceListFooterState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManagedVoiceListFooterState[] f353417a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353418b = null;

    public static EnumEntries<ManagedVoiceListFooterState> getEntries() {
        return f353418b;
    }

    static {
        ManagedVoiceListFooterState r100 = new ManagedVoiceListFooterState("HIDDEN", 0);
        HIDDEN = r100;
        ManagedVoiceListFooterState r101 = new ManagedVoiceListFooterState("READY", 1);
        READY = r101;
        ManagedVoiceListFooterState r102 = new ManagedVoiceListFooterState("LOADING", 2);
        LOADING = r102;
        ManagedVoiceListFooterState r103 = new ManagedVoiceListFooterState("ERROR", 3);
        ERROR = r103;
        ManagedVoiceListFooterState r104 = new ManagedVoiceListFooterState(GXAnimation.STATE_END, 4);
        END = r104;
        ManagedVoiceListFooterState[] r105 = {r100, r101, r102, r103, r104};
        f353417a = r105;
        f353418b = EnumEntriesKt.enumEntries(r105);
    }

    public static ManagedVoiceListFooterState[] values() {
        return (ManagedVoiceListFooterState[]) f353417a.clone();
    }

    public static ManagedVoiceListFooterState valueOf(String r100) {
        return (ManagedVoiceListFooterState) r27.a.a(ManagedVoiceListFooterState.class, r100);
    }

    public ManagedVoiceListFooterState(String r100, int r101) {
        super(r100, r101);
    }
}
