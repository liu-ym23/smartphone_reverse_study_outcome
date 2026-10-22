package com.bytedance.ee.bear.tts;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/tts/ITtsRecorder$ETtsViewType;", "", "<init>", "(Ljava/lang/String;I)V", "MODAL_PLAYER", "FULLSCREEN_PLAYER", "PLAYLIST", "FLOAT", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ITtsRecorder$ETtsViewType extends Enum<ITtsRecorder$ETtsViewType> {
    public static final ITtsRecorder$ETtsViewType FLOAT = null;
    public static final ITtsRecorder$ETtsViewType FULLSCREEN_PLAYER = null;
    public static final ITtsRecorder$ETtsViewType MODAL_PLAYER = null;
    public static final ITtsRecorder$ETtsViewType PLAYLIST = null;
    public static final /* synthetic */ ITtsRecorder$ETtsViewType[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ITtsRecorder$ETtsViewType> getEntries() {
        return b;
    }

    static {
        ITtsRecorder$ETtsViewType r0 = new ITtsRecorder$ETtsViewType("MODAL_PLAYER", 0);
        MODAL_PLAYER = r0;
        ITtsRecorder$ETtsViewType r1 = new ITtsRecorder$ETtsViewType("FULLSCREEN_PLAYER", 1);
        FULLSCREEN_PLAYER = r1;
        ITtsRecorder$ETtsViewType r3 = new ITtsRecorder$ETtsViewType("PLAYLIST", 2);
        PLAYLIST = r3;
        ITtsRecorder$ETtsViewType r5 = new ITtsRecorder$ETtsViewType("FLOAT", 3);
        FLOAT = r5;
        ITtsRecorder$ETtsViewType[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static ITtsRecorder$ETtsViewType[] values() {
        return (ITtsRecorder$ETtsViewType[]) a.clone();
    }

    public static ITtsRecorder$ETtsViewType valueOf(String r1) {
        return (ITtsRecorder$ETtsViewType) r27.a.a(ITtsRecorder$ETtsViewType.class, r1);
    }

    public ITtsRecorder$ETtsViewType(String r1, int r2) {
        super(r1, r2);
    }
}
