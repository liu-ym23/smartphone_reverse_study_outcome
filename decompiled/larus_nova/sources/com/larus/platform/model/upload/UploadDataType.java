package com.larus.platform.model.upload;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/platform/model/upload/UploadDataType;", "", "type", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "FILE", "IMAGE", "VIDEO", "UNCLEAR", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UploadDataType extends Enum<UploadDataType> {
    public static final a Companion = null;
    public static final UploadDataType FILE = null;
    public static final UploadDataType IMAGE = null;
    public static final UploadDataType UNCLEAR = null;
    public static final UploadDataType VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UploadDataType[] f365663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365664b = null;
    private final String type;

    public static final class a {
        public a() {
        }

        public static boolean a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            UploadDataType[] r101 = UploadDataType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            if (Intrinsics.areEqual(r101[r103].getType(), r100) == true) goto L6;
            r103 = r103 + 1;
            goto L3
        L6:
            return true;
        L11:
            return false;
        }
    }

    public static EnumEntries<UploadDataType> getEntries() {
        return f365664b;
    }

    static {
        UploadDataType r100 = new UploadDataType("FILE", 0, "file");
        FILE = r100;
        UploadDataType r101 = new UploadDataType("IMAGE", 1, "image");
        IMAGE = r101;
        UploadDataType r102 = new UploadDataType("VIDEO", 2, "video");
        VIDEO = r102;
        UploadDataType r103 = new UploadDataType("UNCLEAR", 3, "unclear");
        UNCLEAR = r103;
        UploadDataType[] r104 = {r100, r101, r102, r103};
        f365663a = r104;
        f365664b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static UploadDataType[] values() {
        return (UploadDataType[]) f365663a.clone();
    }

    public final String getType() {
        return this.type;
    }

    public static UploadDataType valueOf(String r100) {
        return (UploadDataType) r27.a.a(UploadDataType.class, r100);
    }

    public UploadDataType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
