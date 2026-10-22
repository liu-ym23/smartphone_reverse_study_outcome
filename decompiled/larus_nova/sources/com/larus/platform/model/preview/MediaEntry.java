package com.larus.platform.model.preview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/platform/model/preview/MediaEntry;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN_INPUT", "ATTACHMENT_PANEL", "CAMERA_ALBUM", "PREVIEW_PLUS", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaEntry extends Enum<MediaEntry> {
    public static final MediaEntry ATTACHMENT_PANEL = null;
    public static final MediaEntry CAMERA_ALBUM = null;
    public static final MediaEntry MAIN_INPUT = null;
    public static final MediaEntry PREVIEW_PLUS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaEntry[] f365653a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365654b = null;

    public static EnumEntries<MediaEntry> getEntries() {
        return f365654b;
    }

    static {
        MediaEntry r100 = new MediaEntry("MAIN_INPUT", 0);
        MAIN_INPUT = r100;
        MediaEntry r101 = new MediaEntry("ATTACHMENT_PANEL", 1);
        ATTACHMENT_PANEL = r101;
        MediaEntry r102 = new MediaEntry("CAMERA_ALBUM", 2);
        CAMERA_ALBUM = r102;
        MediaEntry r103 = new MediaEntry("PREVIEW_PLUS", 3);
        PREVIEW_PLUS = r103;
        MediaEntry[] r104 = {r100, r101, r102, r103};
        f365653a = r104;
        f365654b = EnumEntriesKt.enumEntries(r104);
    }

    public static MediaEntry[] values() {
        return (MediaEntry[]) f365653a.clone();
    }

    public static MediaEntry valueOf(String r100) {
        return (MediaEntry) a.a(MediaEntry.class, r100);
    }

    public MediaEntry(String r100, int r101) {
        super(r100, r101);
    }
}
