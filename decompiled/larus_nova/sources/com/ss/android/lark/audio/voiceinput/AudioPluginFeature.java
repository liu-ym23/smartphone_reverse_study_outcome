package com.ss.android.lark.audio.voiceinput;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \r2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\rB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/audio/voiceinput/AudioPluginFeature;", "", "index", "", "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "WITH_TEXT", "RECORD", "RECOGNIZE", "toString", "", "Companion", "audio_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginFeature extends Enum<AudioPluginFeature> {
    public static final a Companion = null;
    public static final AudioPluginFeature RECOGNIZE = null;
    public static final AudioPluginFeature RECORD = null;
    public static final AudioPluginFeature WITH_TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginFeature[] f409168a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f409169b = null;
    private final int index;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AudioPluginFeature> getEntries() {
        return f409169b;
    }

    static {
        AudioPluginFeature r100 = new AudioPluginFeature("WITH_TEXT", 0, 0);
        WITH_TEXT = r100;
        AudioPluginFeature r101 = new AudioPluginFeature("RECORD", 1, 1);
        RECORD = r101;
        AudioPluginFeature r102 = new AudioPluginFeature("RECOGNIZE", 2, 2);
        RECOGNIZE = r102;
        AudioPluginFeature[] r103 = {r100, r101, r102};
        f409168a = r103;
        f409169b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static AudioPluginFeature[] values() {
        return (AudioPluginFeature[]) f409168a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return name();
    }

    public final int getIndex() {
        return this.index;
    }

    public static AudioPluginFeature valueOf(String r100) {
        return (AudioPluginFeature) r27.a.a(AudioPluginFeature.class, r100);
    }

    public AudioPluginFeature(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
