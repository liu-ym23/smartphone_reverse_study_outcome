package com.larus.im.service.audio;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/larus/im/service/audio/ILLMVideoStreamIndex;", "", "streamIndex", "", "<init>", "(Ljava/lang/String;II)V", "STREAM_INDEX_UNKNOWN", "STREAM_INDEX_MAIN", "STREAM_INDEX_SCREEN", "Companion", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ILLMVideoStreamIndex extends Enum<ILLMVideoStreamIndex> {
    public static final a Companion = null;
    public static final ILLMVideoStreamIndex STREAM_INDEX_MAIN = null;
    public static final ILLMVideoStreamIndex STREAM_INDEX_SCREEN = null;
    public static final ILLMVideoStreamIndex STREAM_INDEX_UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ILLMVideoStreamIndex[] f350641a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350642b = null;
    private final int streamIndex;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ILLMVideoStreamIndex> getEntries() {
        return f350642b;
    }

    static {
        ILLMVideoStreamIndex r100 = new ILLMVideoStreamIndex("STREAM_INDEX_UNKNOWN", 0, -1);
        STREAM_INDEX_UNKNOWN = r100;
        ILLMVideoStreamIndex r101 = new ILLMVideoStreamIndex("STREAM_INDEX_MAIN", 1, 0);
        STREAM_INDEX_MAIN = r101;
        ILLMVideoStreamIndex r102 = new ILLMVideoStreamIndex("STREAM_INDEX_SCREEN", 2, 1);
        STREAM_INDEX_SCREEN = r102;
        ILLMVideoStreamIndex[] r103 = {r100, r101, r102};
        f350641a = r103;
        f350642b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static ILLMVideoStreamIndex[] values() {
        return (ILLMVideoStreamIndex[]) f350641a.clone();
    }

    public static final /* synthetic */ int access$getStreamIndex$p(ILLMVideoStreamIndex r100) {
        return r100.streamIndex;
    }

    public static ILLMVideoStreamIndex valueOf(String r100) {
        return (ILLMVideoStreamIndex) r27.a.a(ILLMVideoStreamIndex.class, r100);
    }

    public ILLMVideoStreamIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.streamIndex = r102;
    }
}
