package com.larus.kmp.voice_setting.voice.screen.single;

import com.larus.media.MediaScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/screen/single/SingleTtsSpeakerRowGroup;", "", "<init>", "(Ljava/lang/String;I)V", "UGC", MediaScene.SYSTEM, "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SingleTtsSpeakerRowGroup extends Enum<SingleTtsSpeakerRowGroup> {
    public static final SingleTtsSpeakerRowGroup SYSTEM = null;
    public static final SingleTtsSpeakerRowGroup UGC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SingleTtsSpeakerRowGroup[] f354844a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354845b = null;

    public static EnumEntries<SingleTtsSpeakerRowGroup> getEntries() {
        return f354845b;
    }

    static {
        SingleTtsSpeakerRowGroup r100 = new SingleTtsSpeakerRowGroup("UGC", 0);
        UGC = r100;
        SingleTtsSpeakerRowGroup r101 = new SingleTtsSpeakerRowGroup(MediaScene.SYSTEM, 1);
        SYSTEM = r101;
        SingleTtsSpeakerRowGroup[] r102 = {r100, r101};
        f354844a = r102;
        f354845b = EnumEntriesKt.enumEntries(r102);
    }

    public static SingleTtsSpeakerRowGroup[] values() {
        return (SingleTtsSpeakerRowGroup[]) f354844a.clone();
    }

    public static SingleTtsSpeakerRowGroup valueOf(String r100) {
        return (SingleTtsSpeakerRowGroup) r27.a.a(SingleTtsSpeakerRowGroup.class, r100);
    }

    public SingleTtsSpeakerRowGroup(String r100, int r101) {
        super(r100, r101);
    }
}
