package com.larus.kmp.voice_setting.voice.list.managed;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/list/managed/ManagedVoiceListRowContentType;", "", "<init>", "(Ljava/lang/String;I)V", "CREATE_ENTRY", EffectConstants.NORMAL, "PUBLIC", "SKELETON", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum ManagedVoiceListRowContentType extends Enum<ManagedVoiceListRowContentType> {
    public static final ManagedVoiceListRowContentType CREATE_ENTRY = null;
    public static final ManagedVoiceListRowContentType NORMAL = null;
    public static final ManagedVoiceListRowContentType PUBLIC = null;
    public static final ManagedVoiceListRowContentType SKELETON = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ManagedVoiceListRowContentType[] f353423a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f353424b = null;

    public static EnumEntries<ManagedVoiceListRowContentType> getEntries() {
        return f353424b;
    }

    static {
        ManagedVoiceListRowContentType r100 = new ManagedVoiceListRowContentType("CREATE_ENTRY", 0);
        CREATE_ENTRY = r100;
        ManagedVoiceListRowContentType r101 = new ManagedVoiceListRowContentType(EffectConstants.NORMAL, 1);
        NORMAL = r101;
        ManagedVoiceListRowContentType r102 = new ManagedVoiceListRowContentType("PUBLIC", 2);
        PUBLIC = r102;
        ManagedVoiceListRowContentType r103 = new ManagedVoiceListRowContentType("SKELETON", 3);
        SKELETON = r103;
        ManagedVoiceListRowContentType[] r104 = {r100, r101, r102, r103};
        f353423a = r104;
        f353424b = EnumEntriesKt.enumEntries(r104);
    }

    public static ManagedVoiceListRowContentType[] values() {
        return (ManagedVoiceListRowContentType[]) f353423a.clone();
    }

    public static ManagedVoiceListRowContentType valueOf(String r100) {
        return (ManagedVoiceListRowContentType) r27.a.a(ManagedVoiceListRowContentType.class, r100);
    }

    public ManagedVoiceListRowContentType(String r100, int r101) {
        super(r100, r101);
    }
}
