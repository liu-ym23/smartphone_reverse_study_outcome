package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/tts/ITtsRecorder$ETtsViewType;", "", "<init>", "(Ljava/lang/String;I)V", "MODAL_PLAYER", "FULLSCREEN_PLAYER", "PLAYLIST", "FLOAT", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ITtsRecorder$ETtsViewType extends Enum<ITtsRecorder$ETtsViewType> {
    public static final ITtsRecorder$ETtsViewType FLOAT = null;
    public static final ITtsRecorder$ETtsViewType FULLSCREEN_PLAYER = null;
    public static final ITtsRecorder$ETtsViewType MODAL_PLAYER = null;
    public static final ITtsRecorder$ETtsViewType PLAYLIST = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ITtsRecorder$ETtsViewType[] f239443a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239444b = null;

    public static EnumEntries<ITtsRecorder$ETtsViewType> getEntries() {
        return f239444b;
    }

    static {
        ITtsRecorder$ETtsViewType r100 = new ITtsRecorder$ETtsViewType("MODAL_PLAYER", 0);
        MODAL_PLAYER = r100;
        ITtsRecorder$ETtsViewType r101 = new ITtsRecorder$ETtsViewType("FULLSCREEN_PLAYER", 1);
        FULLSCREEN_PLAYER = r101;
        ITtsRecorder$ETtsViewType r102 = new ITtsRecorder$ETtsViewType("PLAYLIST", 2);
        PLAYLIST = r102;
        ITtsRecorder$ETtsViewType r103 = new ITtsRecorder$ETtsViewType("FLOAT", 3);
        FLOAT = r103;
        ITtsRecorder$ETtsViewType[] r104 = {r100, r101, r102, r103};
        f239443a = r104;
        f239444b = EnumEntriesKt.enumEntries(r104);
    }

    public static ITtsRecorder$ETtsViewType[] values() {
        return (ITtsRecorder$ETtsViewType[]) f239443a.clone();
    }

    public static ITtsRecorder$ETtsViewType valueOf(String r100) {
        return (ITtsRecorder$ETtsViewType) r27.a.a(ITtsRecorder$ETtsViewType.class, r100);
    }

    public ITtsRecorder$ETtsViewType(String r100, int r101) {
        super(r100, r101);
    }
}
