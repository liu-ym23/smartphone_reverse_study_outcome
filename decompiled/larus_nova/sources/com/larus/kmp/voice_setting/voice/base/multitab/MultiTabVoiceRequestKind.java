package com.larus.kmp.voice_setting.voice.base.multitab;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/base/multitab/MultiTabVoiceRequestKind;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "LOAD_MORE", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultiTabVoiceRequestKind extends Enum<MultiTabVoiceRequestKind> {
    public static final MultiTabVoiceRequestKind INIT = null;
    public static final MultiTabVoiceRequestKind LOAD_MORE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultiTabVoiceRequestKind[] f351785a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f351786b = null;

    public static EnumEntries<MultiTabVoiceRequestKind> getEntries() {
        return f351786b;
    }

    static {
        MultiTabVoiceRequestKind r100 = new MultiTabVoiceRequestKind(ErrorCode.INIT, 0);
        INIT = r100;
        MultiTabVoiceRequestKind r101 = new MultiTabVoiceRequestKind("LOAD_MORE", 1);
        LOAD_MORE = r101;
        MultiTabVoiceRequestKind[] r102 = {r100, r101};
        f351785a = r102;
        f351786b = EnumEntriesKt.enumEntries(r102);
    }

    public static MultiTabVoiceRequestKind[] values() {
        return (MultiTabVoiceRequestKind[]) f351785a.clone();
    }

    public static MultiTabVoiceRequestKind valueOf(String r100) {
        return (MultiTabVoiceRequestKind) r27.a.a(MultiTabVoiceRequestKind.class, r100);
    }

    public MultiTabVoiceRequestKind(String r100, int r101) {
        super(r100, r101);
    }
}
