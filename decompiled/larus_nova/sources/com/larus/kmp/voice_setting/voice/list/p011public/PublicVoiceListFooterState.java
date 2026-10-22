package com.larus.kmp.voice_setting.voice.list.p011public;

import com.alibaba.gaiax.model.GXAnimation;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/public/PublicVoiceListFooterState;", "", "<init>", "(Ljava/lang/String;I)V", "HIDDEN", "READY", "LOADING", "ERROR", GXAnimation.STATE_END, "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PublicVoiceListFooterState extends Enum<PublicVoiceListFooterState> {
    public static final PublicVoiceListFooterState END = null;
    public static final PublicVoiceListFooterState ERROR = null;
    public static final PublicVoiceListFooterState HIDDEN = null;
    public static final PublicVoiceListFooterState LOADING = null;
    public static final PublicVoiceListFooterState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicVoiceListFooterState[] f353526a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353527b = null;

    public static EnumEntries<PublicVoiceListFooterState> getEntries() {
        return f353527b;
    }

    static {
        PublicVoiceListFooterState r100 = new PublicVoiceListFooterState("HIDDEN", 0);
        HIDDEN = r100;
        PublicVoiceListFooterState r101 = new PublicVoiceListFooterState("READY", 1);
        READY = r101;
        PublicVoiceListFooterState r102 = new PublicVoiceListFooterState("LOADING", 2);
        LOADING = r102;
        PublicVoiceListFooterState r103 = new PublicVoiceListFooterState("ERROR", 3);
        ERROR = r103;
        PublicVoiceListFooterState r104 = new PublicVoiceListFooterState(GXAnimation.STATE_END, 4);
        END = r104;
        PublicVoiceListFooterState[] r105 = {r100, r101, r102, r103, r104};
        f353526a = r105;
        f353527b = EnumEntriesKt.enumEntries(r105);
    }

    public static PublicVoiceListFooterState[] values() {
        return (PublicVoiceListFooterState[]) f353526a.clone();
    }

    public static PublicVoiceListFooterState valueOf(String r100) {
        return (PublicVoiceListFooterState) a.a(PublicVoiceListFooterState.class, r100);
    }

    public PublicVoiceListFooterState(String r100, int r101) {
        super(r100, r101);
    }
}
