package com.ss.android.lark.chameleonv2.lkapi.manifest;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/manifest/IManifest$Ipc$ModuleType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "InternalDomain", "InternalFeatureGating", "toString", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IManifest$Ipc$ModuleType extends Enum<IManifest$Ipc$ModuleType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IManifest$Ipc$ModuleType[] $VALUES = null;
    public static final IManifest$Ipc$ModuleType InternalDomain = null;
    public static final IManifest$Ipc$ModuleType InternalFeatureGating = null;
    private final String value;

    private static final /* synthetic */ IManifest$Ipc$ModuleType[] $values() {
        return new IManifest$Ipc$ModuleType[]{InternalDomain, InternalFeatureGating};
    }

    public static EnumEntries<IManifest$Ipc$ModuleType> getEntries() {
        return $ENTRIES;
    }

    static {
        InternalDomain = new IManifest$Ipc$ModuleType("InternalDomain", 0, "internal.domain");
        InternalFeatureGating = new IManifest$Ipc$ModuleType("InternalFeatureGating", 1, "internal.featureGating");
        IManifest$Ipc$ModuleType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static IManifest$Ipc$ModuleType[] values() {
        return (IManifest$Ipc$ModuleType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public static IManifest$Ipc$ModuleType valueOf(String r100) {
        return (IManifest$Ipc$ModuleType) a.a(IManifest$Ipc$ModuleType.class, r100);
    }

    private IManifest$Ipc$ModuleType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
