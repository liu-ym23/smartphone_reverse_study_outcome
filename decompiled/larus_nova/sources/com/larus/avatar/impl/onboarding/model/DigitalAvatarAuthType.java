package com.larus.avatar.impl.onboarding.model;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/avatar/impl/onboarding/model/DigitalAvatarAuthType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "IMAGE_AVATAR", "CREATE_NEW_VIDEO_AVATAR", "APPEND_VIDEO_MATERIAL", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DigitalAvatarAuthType extends Enum<DigitalAvatarAuthType> {
    public static final DigitalAvatarAuthType APPEND_VIDEO_MATERIAL = null;
    public static final DigitalAvatarAuthType CREATE_NEW_VIDEO_AVATAR = null;
    public static final a Companion = null;
    public static final DigitalAvatarAuthType IMAGE_AVATAR = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DigitalAvatarAuthType[] f290864a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290865b = null;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f290866id;

    public static final class a {
        public a() {
        }

        public static DigitalAvatarAuthType a(int r100) {
            Iterator<DigitalAvatarAuthType> r101 = DigitalAvatarAuthType.getEntries().iterator();
        L4:
            if (r101.hasNext() == false) goto L11;
            DigitalAvatarAuthType r102 = r101.next();
            if (r102.getId() != r100) goto L8;
            boolean r103 = true;
        L9:
            if (r103 == false) goto L4;
        L13:
            return r102;
        L8:
            r103 = false;
            goto L9
        L11:
            r102 = null;
            goto L13
        }
    }

    public static EnumEntries<DigitalAvatarAuthType> getEntries() {
        return f290865b;
    }

    static {
        DigitalAvatarAuthType r100 = new DigitalAvatarAuthType("IMAGE_AVATAR", 0, 0);
        IMAGE_AVATAR = r100;
        DigitalAvatarAuthType r101 = new DigitalAvatarAuthType("CREATE_NEW_VIDEO_AVATAR", 1, 1);
        CREATE_NEW_VIDEO_AVATAR = r101;
        DigitalAvatarAuthType r102 = new DigitalAvatarAuthType("APPEND_VIDEO_MATERIAL", 2, 2);
        APPEND_VIDEO_MATERIAL = r102;
        DigitalAvatarAuthType[] r103 = {r100, r101, r102};
        f290864a = r103;
        f290865b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static DigitalAvatarAuthType[] values() {
        return (DigitalAvatarAuthType[]) f290864a.clone();
    }

    public final int getId() {
        return this.f290866id;
    }

    public static DigitalAvatarAuthType valueOf(String r100) {
        return (DigitalAvatarAuthType) r27.a.a(DigitalAvatarAuthType.class, r100);
    }

    public DigitalAvatarAuthType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f290866id = r102;
    }
}
