package com.ss.android.lark.chat.base.model.dispatch;

import com.bytedance.lark.pb.media.v1.PreprocessResourceRequest;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Lcom/ss/android/lark/chat/base/model/dispatch/ResourceType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FILE", "IMAGE", "MEDIA", "toSdkFileType", "Lcom/bytedance/lark/pb/media/v1/PreprocessResourceRequest$FileType;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ResourceType extends Enum<ResourceType> {
    public static final ResourceType FILE = null;
    public static final ResourceType IMAGE = null;
    public static final ResourceType MEDIA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResourceType[] f411759a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411760b = null;
    private final int value;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411761a = null;

        static {
            int[] r100 = new int[ResourceType.values().length];
            r100[ResourceType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ResourceType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ResourceType.MEDIA.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f411761a = r100;
        }
    }

    public static EnumEntries<ResourceType> getEntries() {
        return f411760b;
    }

    static {
        ResourceType r100 = new ResourceType("FILE", 0, 1);
        FILE = r100;
        ResourceType r101 = new ResourceType("IMAGE", 1, 2);
        IMAGE = r101;
        ResourceType r102 = new ResourceType("MEDIA", 2, 5);
        MEDIA = r102;
        ResourceType[] r103 = {r100, r101, r102};
        f411759a = r103;
        f411760b = EnumEntriesKt.enumEntries(r103);
    }

    public static ResourceType[] values() {
        return (ResourceType[]) f411759a.clone();
    }

    public final PreprocessResourceRequest.FileType toSdkFileType() {
        int r100 = a.f411761a[ordinal()];
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L15;
        if (r100 != 3) goto L10;
        return PreprocessResourceRequest.FileType.MEDIA;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return PreprocessResourceRequest.FileType.IMAGE;
    L13:
        return PreprocessResourceRequest.FileType.FILE;
    }

    public final int getValue() {
        return this.value;
    }

    public static ResourceType valueOf(String r100) {
        return (ResourceType) r27.a.a(ResourceType.class, r100);
    }

    public ResourceType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
