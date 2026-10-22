package com.ss.android.lark.chameleonv2.lkapi.storage;

import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chameleonv2/lkapi/storage/IStorage$Internal$StorageFileType;", "Lcom/bytedance/ee/util/io/NonProguard;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "EncryptPreload", "Encrypt", "Plain", "Companion", "larkapi_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IStorage$Internal$StorageFileType extends Enum<IStorage$Internal$StorageFileType> implements NonProguard {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ IStorage$Internal$StorageFileType[] $VALUES = null;
    public static final a Companion = null;
    public static final IStorage$Internal$StorageFileType Encrypt = null;
    public static final IStorage$Internal$StorageFileType EncryptPreload = null;
    public static final IStorage$Internal$StorageFileType Plain = null;
    private final String value;

    public static final class a {
        public a() {
        }

        public static IStorage$Internal$StorageFileType a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "value");
            IStorage$Internal$StorageFileType[] r101 = IStorage$Internal$StorageFileType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L8;
            IStorage$Internal$StorageFileType r104 = r101[r103];
            if (Intrinsics.areEqual(r104.getValue(), r100) == true) goto L9;
            r103 = r103 + 1;
        L9:
            if (r104 == null) goto L12;
            return r104;
        L12:
            return IStorage$Internal$StorageFileType.Encrypt;
        L8:
            r104 = null;
            goto L9
        }
    }

    private static final /* synthetic */ IStorage$Internal$StorageFileType[] $values() {
        return new IStorage$Internal$StorageFileType[]{EncryptPreload, Encrypt, Plain};
    }

    public static EnumEntries<IStorage$Internal$StorageFileType> getEntries() {
        return $ENTRIES;
    }

    static {
        EncryptPreload = new IStorage$Internal$StorageFileType("EncryptPreload", 0, "encrypt-preload");
        Encrypt = new IStorage$Internal$StorageFileType("Encrypt", 1, LBSLightLocationTraceLogger.ENCRYPT);
        Plain = new IStorage$Internal$StorageFileType("Plain", 2, "plain");
        IStorage$Internal$StorageFileType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static IStorage$Internal$StorageFileType[] values() {
        return (IStorage$Internal$StorageFileType[]) $VALUES.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static IStorage$Internal$StorageFileType valueOf(String r100) {
        return (IStorage$Internal$StorageFileType) r27.a.a(IStorage$Internal$StorageFileType.class, r100);
    }

    private IStorage$Internal$StorageFileType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
