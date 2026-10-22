package com.larksuite.component.ui.avatar;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larksuite/component/ui/avatar/ImageKeyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "IMAGE", "UNKOWN", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageKeyType extends Enum<ImageKeyType> {
    public static final a Companion = null;
    public static final ImageKeyType IMAGE = null;
    public static final ImageKeyType UNKOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageKeyType[] f284066a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284067b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<ImageKeyType> getEntries() {
        return f284067b;
    }

    static {
        ImageKeyType r100 = new ImageKeyType("IMAGE", 0, 1);
        IMAGE = r100;
        ImageKeyType r101 = new ImageKeyType("UNKOWN", 1, 0);
        UNKOWN = r101;
        ImageKeyType[] r102 = {r100, r101};
        f284066a = r102;
        f284067b = EnumEntriesKt.enumEntries(r102);
        Companion = new a();
    }

    public static ImageKeyType[] values() {
        return (ImageKeyType[]) f284066a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final ImageKeyType valueOf(int r100) {
        Companion.getClass();
        ImageKeyType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        ImageKeyType r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L15;
        r103 = r103 + 1;
        goto L3
    L15:
        return r104;
    L7:
        r105 = false;
        goto L8
    L11:
        return null;
    }

    public static ImageKeyType valueOf(String r100) {
        return (ImageKeyType) r27.a.a(ImageKeyType.class, r100);
    }

    public ImageKeyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
