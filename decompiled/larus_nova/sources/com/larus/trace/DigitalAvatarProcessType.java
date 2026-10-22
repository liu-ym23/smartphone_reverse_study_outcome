package com.larus.trace;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u0011"}, d2 = {"Lcom/larus/trace/DigitalAvatarProcessType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "UNKNOWN", "BOTH_IMAGE_AND_VIDEO", "APPEND_VIDEO_ONLY", "APPEND_IMAGE_ONLY", "RE_UPLOAD_VIDEO", "RE_UPLOAD_IMAGE", "isNewCreate", "", "Companion", "trace_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarProcessType extends Enum<DigitalAvatarProcessType> {
    public static final DigitalAvatarProcessType APPEND_IMAGE_ONLY = null;
    public static final DigitalAvatarProcessType APPEND_VIDEO_ONLY = null;
    public static final DigitalAvatarProcessType BOTH_IMAGE_AND_VIDEO = null;
    public static final a Companion = null;
    public static final DigitalAvatarProcessType RE_UPLOAD_IMAGE = null;
    public static final DigitalAvatarProcessType RE_UPLOAD_VIDEO = null;
    public static final DigitalAvatarProcessType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarProcessType[] f370136a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f370137b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f370138id;

    public static final class a {
        public a() {
        }

        public static DigitalAvatarProcessType a(int r100) {
            Iterator<DigitalAvatarProcessType> r101 = DigitalAvatarProcessType.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            DigitalAvatarProcessType r102 = r101.next();
            if (r102.getId() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L12:
            DigitalAvatarProcessType r104 = r102;
            if (r104 == null) goto L15;
            return r104;
        L15:
            return DigitalAvatarProcessType.UNKNOWN;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L12
        }
    }

    public static EnumEntries<DigitalAvatarProcessType> getEntries() {
        return f370137b;
    }

    static {
        DigitalAvatarProcessType r100 = new DigitalAvatarProcessType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        DigitalAvatarProcessType r101 = new DigitalAvatarProcessType("BOTH_IMAGE_AND_VIDEO", 1, 1);
        BOTH_IMAGE_AND_VIDEO = r101;
        DigitalAvatarProcessType r102 = new DigitalAvatarProcessType("APPEND_VIDEO_ONLY", 2, 2);
        APPEND_VIDEO_ONLY = r102;
        DigitalAvatarProcessType r103 = new DigitalAvatarProcessType("APPEND_IMAGE_ONLY", 3, 3);
        APPEND_IMAGE_ONLY = r103;
        DigitalAvatarProcessType r104 = new DigitalAvatarProcessType("RE_UPLOAD_VIDEO", 4, 4);
        RE_UPLOAD_VIDEO = r104;
        DigitalAvatarProcessType r105 = new DigitalAvatarProcessType("RE_UPLOAD_IMAGE", 5, 5);
        RE_UPLOAD_IMAGE = r105;
        DigitalAvatarProcessType[] r110 = {r100, r101, r102, r103, r104, r105};
        f370136a = r110;
        f370137b = EnumEntriesKt.enumEntries(r110);
        Companion = new a();
    }

    public static DigitalAvatarProcessType[] values() {
        return (DigitalAvatarProcessType[]) f370136a.clone();
    }

    public final boolean isNewCreate() {
        if (this != UNKNOWN) goto L5;
    L8:
        return true;
    L5:
        if (this == BOTH_IMAGE_AND_VIDEO) goto L8;
        return false;
    }

    public final int getId() {
        return this.f370138id;
    }

    public static DigitalAvatarProcessType valueOf(String r100) {
        return (DigitalAvatarProcessType) r27.a.a(DigitalAvatarProcessType.class, r100);
    }

    public DigitalAvatarProcessType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f370138id = r102;
    }
}
