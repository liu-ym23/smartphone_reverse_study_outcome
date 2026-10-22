package com.larus.im.service.audio.event;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/im/service/audio/event/FileBizType;", "", "<init>", "(Ljava/lang/String;I)V", "ImageBizType_UNSPECIFIED", "DoraImage", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FileBizType extends Enum<FileBizType> {
    public static final FileBizType DoraImage = null;
    public static final FileBizType ImageBizType_UNSPECIFIED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FileBizType[] f350740a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350741b = null;

    public static EnumEntries<FileBizType> getEntries() {
        return f350741b;
    }

    static {
        FileBizType r100 = new FileBizType("ImageBizType_UNSPECIFIED", 0);
        ImageBizType_UNSPECIFIED = r100;
        FileBizType r101 = new FileBizType("DoraImage", 1);
        DoraImage = r101;
        FileBizType[] r102 = {r100, r101};
        f350740a = r102;
        f350741b = EnumEntriesKt.enumEntries(r102);
    }

    public static FileBizType[] values() {
        return (FileBizType[]) f350740a.clone();
    }

    public static FileBizType valueOf(String r100) {
        return (FileBizType) a.a(FileBizType.class, r100);
    }

    public FileBizType(String r100, int r101) {
        super(r100, r101);
    }
}
