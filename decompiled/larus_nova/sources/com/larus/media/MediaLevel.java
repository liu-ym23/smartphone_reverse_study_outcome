package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/larus/media/MediaLevel;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "PLAY_LOW", "PLAY_DEFAULT", "PLAY_HIGH", "PLAY_BIG_HIGH", "RECORD_LOW", "RECORD_DEFAULT", "RECORD_HIGH", "RECORD_BIG_HIGH", "HIGH_MAX", "Companion", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaLevel extends Enum<MediaLevel> {
    public static final a Companion = null;
    public static final MediaLevel HIGH_MAX = null;
    public static final MediaLevel PLAY_BIG_HIGH = null;
    public static final MediaLevel PLAY_DEFAULT = null;
    public static final MediaLevel PLAY_HIGH = null;
    public static final MediaLevel PLAY_LOW = null;
    public static final MediaLevel RECORD_BIG_HIGH = null;
    public static final MediaLevel RECORD_DEFAULT = null;
    public static final MediaLevel RECORD_HIGH = null;
    public static final MediaLevel RECORD_LOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaLevel[] f358946a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358947b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MediaLevel> getEntries() {
        return f358947b;
    }

    static {
        MediaLevel r100 = new MediaLevel("PLAY_LOW", 0, 0);
        PLAY_LOW = r100;
        MediaLevel r101 = new MediaLevel("PLAY_DEFAULT", 1, 1);
        PLAY_DEFAULT = r101;
        MediaLevel r102 = new MediaLevel("PLAY_HIGH", 2, 2);
        PLAY_HIGH = r102;
        MediaLevel r103 = new MediaLevel("PLAY_BIG_HIGH", 3, 3);
        PLAY_BIG_HIGH = r103;
        MediaLevel r104 = new MediaLevel("RECORD_LOW", 4, 1001);
        RECORD_LOW = r104;
        MediaLevel r105 = new MediaLevel("RECORD_DEFAULT", 5, 1002);
        RECORD_DEFAULT = r105;
        MediaLevel r110 = new MediaLevel("RECORD_HIGH", 6, 1003);
        RECORD_HIGH = r110;
        MediaLevel r111 = new MediaLevel("RECORD_BIG_HIGH", 7, 1004);
        RECORD_BIG_HIGH = r111;
        MediaLevel r112 = new MediaLevel("HIGH_MAX", 8, Integer.MAX_VALUE);
        HIGH_MAX = r112;
        MediaLevel[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
        f358946a = r113;
        f358947b = EnumEntriesKt.enumEntries(r113);
        Companion = new a();
    }

    public static MediaLevel[] values() {
        return (MediaLevel[]) f358946a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MediaLevel valueOf(String r100) {
        return (MediaLevel) r27.a.a(MediaLevel.class, r100);
    }

    public MediaLevel(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
