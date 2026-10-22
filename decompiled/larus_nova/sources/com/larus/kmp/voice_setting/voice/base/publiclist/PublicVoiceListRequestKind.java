package com.larus.kmp.voice_setting.voice.base.publiclist;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/base/publiclist/PublicVoiceListRequestKind;", "", "<init>", "(Ljava/lang/String;I)V", "FIRST_PAGE", "LOAD_MORE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PublicVoiceListRequestKind extends Enum<PublicVoiceListRequestKind> {
    public static final PublicVoiceListRequestKind FIRST_PAGE = null;
    public static final PublicVoiceListRequestKind LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PublicVoiceListRequestKind[] f351805a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351806b = null;

    public static EnumEntries<PublicVoiceListRequestKind> getEntries() {
        return f351806b;
    }

    static {
        PublicVoiceListRequestKind r100 = new PublicVoiceListRequestKind("FIRST_PAGE", 0);
        FIRST_PAGE = r100;
        PublicVoiceListRequestKind r101 = new PublicVoiceListRequestKind("LOAD_MORE", 1);
        LOAD_MORE = r101;
        PublicVoiceListRequestKind[] r102 = {r100, r101};
        f351805a = r102;
        f351806b = EnumEntriesKt.enumEntries(r102);
    }

    public static PublicVoiceListRequestKind[] values() {
        return (PublicVoiceListRequestKind[]) f351805a.clone();
    }

    public static PublicVoiceListRequestKind valueOf(String r100) {
        return (PublicVoiceListRequestKind) r27.a.a(PublicVoiceListRequestKind.class, r100);
    }

    public PublicVoiceListRequestKind(String r100, int r101) {
        super(r100, r101);
    }
}
