package com.larus.audio.utils;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/utils/AudioLogLevel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEBUG", "INFO", "WARN", "ERROR", "audiosdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioLogLevel extends Enum<AudioLogLevel> {
    public static final AudioLogLevel DEBUG = null;
    public static final AudioLogLevel ERROR = null;
    public static final AudioLogLevel INFO = null;
    public static final AudioLogLevel WARN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioLogLevel[] f289986a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289987b = null;
    private final String value;

    public static EnumEntries<AudioLogLevel> getEntries() {
        return f289987b;
    }

    static {
        AudioLogLevel r100 = new AudioLogLevel("DEBUG", 0, "D");
        DEBUG = r100;
        AudioLogLevel r101 = new AudioLogLevel("INFO", 1, "I");
        INFO = r101;
        AudioLogLevel r102 = new AudioLogLevel("WARN", 2, ExifInterface.LONGITUDE_WEST);
        WARN = r102;
        AudioLogLevel r103 = new AudioLogLevel("ERROR", 3, ExifInterface.LONGITUDE_EAST);
        ERROR = r103;
        AudioLogLevel[] r104 = {r100, r101, r102, r103};
        f289986a = r104;
        f289987b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioLogLevel[] values() {
        return (AudioLogLevel[]) f289986a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static AudioLogLevel valueOf(String r100) {
        return (AudioLogLevel) r27.a.a(AudioLogLevel.class, r100);
    }

    public AudioLogLevel(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
