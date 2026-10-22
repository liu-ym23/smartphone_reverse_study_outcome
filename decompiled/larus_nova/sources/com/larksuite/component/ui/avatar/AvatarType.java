package com.larksuite.component.ui.avatar;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larksuite/component/ui/avatar/AvatarType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN", "CHAT", "THRED", "TOPIC", PreloadConfigModel.VERSION_CHECK_TYPE_DOC, "CHATTER", "MICROAPP", "Companion", "avatar-badge_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvatarType extends Enum<AvatarType> {
    public static final AvatarType CHAT = null;
    public static final AvatarType CHATTER = null;
    public static final a Companion = null;
    public static final AvatarType DOC = null;
    public static final AvatarType MICROAPP = null;
    public static final AvatarType THRED = null;
    public static final AvatarType TOPIC = null;
    public static final AvatarType UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarType[] f284064a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f284065b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<AvatarType> getEntries() {
        return f284065b;
    }

    static {
        AvatarType r100 = new AvatarType("UNKNOWN", 0, 0);
        UNKNOWN = r100;
        AvatarType r101 = new AvatarType("CHAT", 1, 1);
        CHAT = r101;
        AvatarType r102 = new AvatarType("THRED", 2, 2);
        THRED = r102;
        AvatarType r103 = new AvatarType("TOPIC", 3, 3);
        TOPIC = r103;
        AvatarType r104 = new AvatarType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 4, 4);
        DOC = r104;
        AvatarType r105 = new AvatarType("CHATTER", 5, 5);
        CHATTER = r105;
        AvatarType r110 = new AvatarType("MICROAPP", 6, 6);
        MICROAPP = r110;
        AvatarType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f284064a = r111;
        f284065b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static AvatarType[] values() {
        return (AvatarType[]) f284064a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final AvatarType valueOf(int r100) {
        Companion.getClass();
        AvatarType[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        AvatarType r104 = r101[r103];
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

    public static AvatarType valueOf(String r100) {
        return (AvatarType) r27.a.a(AvatarType.class, r100);
    }

    public AvatarType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
