package com.larus.bmhome.chat.component.bottom.bottommenu;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/bottommenu/MentionFilePickerType;", "", "<init>", "(Ljava/lang/String;I)V", "CAMERA", FlowDoraWifiScene.ALBUM, "FILE", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MentionFilePickerType extends Enum<MentionFilePickerType> {
    public static final MentionFilePickerType ALBUM = null;
    public static final MentionFilePickerType CAMERA = null;
    public static final MentionFilePickerType FILE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MentionFilePickerType[] f298210a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f298211b = null;

    public static EnumEntries<MentionFilePickerType> getEntries() {
        return f298211b;
    }

    static {
        MentionFilePickerType r100 = new MentionFilePickerType("CAMERA", 0);
        CAMERA = r100;
        MentionFilePickerType r101 = new MentionFilePickerType(FlowDoraWifiScene.ALBUM, 1);
        ALBUM = r101;
        MentionFilePickerType r102 = new MentionFilePickerType("FILE", 2);
        FILE = r102;
        MentionFilePickerType[] r103 = {r100, r101, r102};
        f298210a = r103;
        f298211b = EnumEntriesKt.enumEntries(r103);
    }

    public static MentionFilePickerType[] values() {
        return (MentionFilePickerType[]) f298210a.clone();
    }

    public static MentionFilePickerType valueOf(String r100) {
        return (MentionFilePickerType) r27.a.a(MentionFilePickerType.class, r100);
    }

    public MentionFilePickerType(String r100, int r101) {
        super(r100, r101);
    }
}
