package com.obric.assistant.voice;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/assistant/voice/ContentStatus;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, "VOICE_AUTHEN", "ASR_RESULT", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ContentStatus extends Enum<ContentStatus> {
    public static final ContentStatus ASR_RESULT = null;
    public static final ContentStatus INIT = null;
    public static final ContentStatus VOICE_AUTHEN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ContentStatus[] f394358a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f394359b = null;

    public static EnumEntries<ContentStatus> getEntries() {
        return f394359b;
    }

    static {
        ContentStatus r100 = new ContentStatus(ErrorCode.INIT, 0);
        INIT = r100;
        ContentStatus r101 = new ContentStatus("VOICE_AUTHEN", 1);
        VOICE_AUTHEN = r101;
        ContentStatus r102 = new ContentStatus("ASR_RESULT", 2);
        ASR_RESULT = r102;
        ContentStatus[] r103 = {r100, r101, r102};
        f394358a = r103;
        f394359b = EnumEntriesKt.enumEntries(r103);
    }

    public static ContentStatus[] values() {
        return (ContentStatus[]) f394358a.clone();
    }

    public static ContentStatus valueOf(String r100) {
        return (ContentStatus) r27.a.a(ContentStatus.class, r100);
    }

    public ContentStatus(String r100, int r101) {
        super(r100, r101);
    }
}
