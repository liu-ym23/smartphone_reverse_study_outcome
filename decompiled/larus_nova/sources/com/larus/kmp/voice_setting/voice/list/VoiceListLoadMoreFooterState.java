package com.larus.kmp.voice_setting.voice.list;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/VoiceListLoadMoreFooterState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "READY", "LOADING", "ERROR", GXAnimation.STATE_END, "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceListLoadMoreFooterState extends Enum<VoiceListLoadMoreFooterState> {
    public static final VoiceListLoadMoreFooterState END = null;
    public static final VoiceListLoadMoreFooterState ERROR = null;
    public static final VoiceListLoadMoreFooterState HIDDEN = null;
    public static final VoiceListLoadMoreFooterState LOADING = null;
    public static final VoiceListLoadMoreFooterState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceListLoadMoreFooterState[] f353403a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353404b = null;

    public static EnumEntries<VoiceListLoadMoreFooterState> getEntries() {
        return f353404b;
    }

    static {
        VoiceListLoadMoreFooterState r100 = new VoiceListLoadMoreFooterState("HIDDEN", 0);
        HIDDEN = r100;
        VoiceListLoadMoreFooterState r101 = new VoiceListLoadMoreFooterState("READY", 1);
        READY = r101;
        VoiceListLoadMoreFooterState r102 = new VoiceListLoadMoreFooterState("LOADING", 2);
        LOADING = r102;
        VoiceListLoadMoreFooterState r103 = new VoiceListLoadMoreFooterState("ERROR", 3);
        ERROR = r103;
        VoiceListLoadMoreFooterState r104 = new VoiceListLoadMoreFooterState(GXAnimation.STATE_END, 4);
        END = r104;
        VoiceListLoadMoreFooterState[] r105 = {r100, r101, r102, r103, r104};
        f353403a = r105;
        f353404b = EnumEntriesKt.enumEntries(r105);
    }

    public static VoiceListLoadMoreFooterState[] values() {
        return (VoiceListLoadMoreFooterState[]) f353403a.clone();
    }

    public static VoiceListLoadMoreFooterState valueOf(String r100) {
        return (VoiceListLoadMoreFooterState) a.a(VoiceListLoadMoreFooterState.class, r100);
    }

    public VoiceListLoadMoreFooterState(String r100, int r101) {
        super(r100, r101);
    }
}
