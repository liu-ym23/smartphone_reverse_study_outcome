package com.larus.kmp.voice_setting.voice.list;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceListLoadTriggerKind;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_PAGE", "RETRY", "REFRESH", "LOAD_MORE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceListLoadTriggerKind extends Enum<VoiceListLoadTriggerKind> {
    public static final VoiceListLoadTriggerKind FIRST_PAGE = null;
    public static final VoiceListLoadTriggerKind LOAD_MORE = null;
    public static final VoiceListLoadTriggerKind REFRESH = null;
    public static final VoiceListLoadTriggerKind RETRY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceListLoadTriggerKind[] f353405a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353406b = null;

    public static EnumEntries<VoiceListLoadTriggerKind> getEntries() {
        return f353406b;
    }

    static {
        VoiceListLoadTriggerKind r100 = new VoiceListLoadTriggerKind("FIRST_PAGE", 0);
        FIRST_PAGE = r100;
        VoiceListLoadTriggerKind r101 = new VoiceListLoadTriggerKind("RETRY", 1);
        RETRY = r101;
        VoiceListLoadTriggerKind r102 = new VoiceListLoadTriggerKind("REFRESH", 2);
        REFRESH = r102;
        VoiceListLoadTriggerKind r103 = new VoiceListLoadTriggerKind("LOAD_MORE", 3);
        LOAD_MORE = r103;
        VoiceListLoadTriggerKind[] r104 = {r100, r101, r102, r103};
        f353405a = r104;
        f353406b = EnumEntriesKt.enumEntries(r104);
    }

    public static VoiceListLoadTriggerKind[] values() {
        return (VoiceListLoadTriggerKind[]) f353405a.clone();
    }

    public static VoiceListLoadTriggerKind valueOf(String r100) {
        return (VoiceListLoadTriggerKind) a.a(VoiceListLoadTriggerKind.class, r100);
    }

    public VoiceListLoadTriggerKind(String r100, int r101) {
        super(r100, r101);
    }
}
