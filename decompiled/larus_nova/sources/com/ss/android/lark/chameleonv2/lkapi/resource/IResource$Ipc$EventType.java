package com.ss.android.lark.chameleonv2.lkapi.resource;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/resource/IResource$Ipc$EventType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "RESOURCE_UPLOAD_PUSH", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IResource$Ipc$EventType extends Enum<IResource$Ipc$EventType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IResource$Ipc$EventType[] $VALUES = null;
    public static final IResource$Ipc$EventType RESOURCE_UPLOAD_PUSH = null;
    private final String value;

    private static final /* synthetic */ IResource$Ipc$EventType[] $values() {
        return new IResource$Ipc$EventType[]{RESOURCE_UPLOAD_PUSH};
    }

    public static EnumEntries<IResource$Ipc$EventType> getEntries() {
        return $ENTRIES;
    }

    static {
        RESOURCE_UPLOAD_PUSH = new IResource$Ipc$EventType("RESOURCE_UPLOAD_PUSH", 0, "RESOURCE_UPLOAD_PUSH");
        IResource$Ipc$EventType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IResource$Ipc$EventType[] values() {
        return (IResource$Ipc$EventType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IResource$Ipc$EventType valueOf(String r100) {
        return (IResource$Ipc$EventType) a.a(IResource$Ipc$EventType.class, r100);
    }

    private IResource$Ipc$EventType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
