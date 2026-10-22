package com.larus.voicecall.impl.ui.utils;

import c4a.c;
import com.bytedance.keva.Keva;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes32.dex */
public final class NewThemeSwitchAvatar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f379398a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static AvatarType f379399b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/voicecall/impl/ui/utils/NewThemeSwitchAvatar$AvatarType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BUBBLE", "NORMAL_AVATAR", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AvatarType extends Enum<AvatarType> {
        public static final AvatarType BUBBLE = null;
        public static final AvatarType NORMAL_AVATAR = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AvatarType[] f379400a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f379401b = null;
        private final int value;

        public static EnumEntries<AvatarType> getEntries() {
            return f379401b;
        }

        static {
            AvatarType r100 = new AvatarType("BUBBLE", 0, 0);
            BUBBLE = r100;
            AvatarType r101 = new AvatarType("NORMAL_AVATAR", 1, 1);
            NORMAL_AVATAR = r101;
            AvatarType[] r102 = {r100, r101};
            f379400a = r102;
            f379401b = EnumEntriesKt.enumEntries(r102);
        }

        public static AvatarType[] values() {
            return (AvatarType[]) f379400a.clone();
        }

        public final int getValue() {
            return this.value;
        }

        public static AvatarType valueOf(String r100) {
            return (AvatarType) a.a(AvatarType.class, r100);
        }

        public AvatarType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f379398a = LazyKt.lazy(new c());
        int r100 = ((Keva) m78.c.f512357a.getValue()).getInt("keva_key_avatar_type", AvatarType.BUBBLE.getValue());
        AvatarType[] r101 = AvatarType.values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        AvatarType r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L12;
        r103 = r103 + 1;
    L12:
        if (r104 != null) goto L14;
        r104 = AvatarType.BUBBLE;
    L14:
        f379399b = r104;
        return;
    L7:
        r105 = false;
        goto L8
    L11:
        r104 = null;
        goto L12
    }

    public static boolean a() {
        if (f379399b != AvatarType.BUBBLE) goto L5;
    L8:
        return true;
    L5:
        if (((Boolean) f379398a.getValue()).booleanValue() == false) goto L8;
        return false;
    }
}
