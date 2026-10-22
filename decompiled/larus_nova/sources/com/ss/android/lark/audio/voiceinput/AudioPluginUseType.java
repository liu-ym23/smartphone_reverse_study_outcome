package com.ss.android.lark.audio.voiceinput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/AudioPluginUseType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "getType", "()I", "NEVER_SET", "OLD", "NEW", "Companion", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginUseType extends Enum<AudioPluginUseType> {
    public static final a Companion = null;
    public static final AudioPluginUseType NEVER_SET = null;
    public static final AudioPluginUseType NEW = null;
    public static final AudioPluginUseType OLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginUseType[] f409170a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409171b = null;
    private final int type;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AudioPluginUseType> getEntries() {
        return f409171b;
    }

    static {
        AudioPluginUseType r100 = new AudioPluginUseType("NEVER_SET", 0, 0);
        NEVER_SET = r100;
        AudioPluginUseType r101 = new AudioPluginUseType("OLD", 1, 1);
        OLD = r101;
        AudioPluginUseType r102 = new AudioPluginUseType("NEW", 2, 2);
        NEW = r102;
        AudioPluginUseType[] r103 = {r100, r101, r102};
        f409170a = r103;
        f409171b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AudioPluginUseType[] values() {
        return (AudioPluginUseType[]) f409170a.clone();
    }

    public final int getType() {
        return this.type;
    }

    public static AudioPluginUseType valueOf(String r100) {
        return (AudioPluginUseType) r27.a.a(AudioPluginUseType.class, r100);
    }

    public AudioPluginUseType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
