package com.ss.android.lark.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/media/MediaType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Audio_Record", "Audio_Play", "Camera", "Companion", "lark-media_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum MediaType extends Enum<MediaType> {
    public static final MediaType Audio_Play = null;
    public static final MediaType Audio_Record = null;
    public static final MediaType Camera = null;
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaType[] f431650a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f431651b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MediaType> getEntries() {
        return f431651b;
    }

    static {
        MediaType r100 = new MediaType("Audio_Record", 0, 0);
        Audio_Record = r100;
        MediaType r101 = new MediaType("Audio_Play", 1, 1);
        Audio_Play = r101;
        MediaType r102 = new MediaType("Camera", 2, 2);
        Camera = r102;
        MediaType[] r103 = {r100, r101, r102};
        f431650a = r103;
        f431651b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static MediaType[] values() {
        return (MediaType[]) f431650a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MediaType valueOf(String r100) {
        return (MediaType) r27.a.a(MediaType.class, r100);
    }

    public MediaType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
