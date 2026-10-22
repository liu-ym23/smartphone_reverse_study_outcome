package com.ss.android.lark.export.entity.preview;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b \b\u0086\u0081\u0002\u0018\u0000 #2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001#B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"¨\u0006$"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/Type;", "Ljava/io/Serializable;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "setValue", "(I)V", "UNKNOWN", "EMPTY", "LINEAR_LAYOUT", "FLEX_LAYOUT", "HEADER", "RICHTEXT", "IMAGE", "CHATTERS_PREVIEW", "BUTTON", "ICON_BUTTON", "TEXT_BUTTON", "TIME", CardAdapter.TEXT, "TAG_LIST", "SPIN_BUTTON", "AVATAR", "VIDEO", "CARD_CONTAINER", "DOC_IMAGE", "LOADING", "TIME_ZONE", "OVERSIZED_TEXT", "ENGINE", "IMAGE_CONTAINER", "Companion", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum Type extends Enum<Type> implements Serializable {
    public static final Type AVATAR = null;
    public static final Type BUTTON = null;
    public static final Type CARD_CONTAINER = null;
    public static final Type CHATTERS_PREVIEW = null;
    public static final a Companion = null;
    public static final Type DOC_IMAGE = null;
    public static final Type EMPTY = null;
    public static final Type ENGINE = null;
    public static final Type FLEX_LAYOUT = null;
    public static final Type HEADER = null;
    public static final Type ICON_BUTTON = null;
    public static final Type IMAGE = null;
    public static final Type IMAGE_CONTAINER = null;
    public static final Type LINEAR_LAYOUT = null;
    public static final Type LOADING = null;
    public static final Type OVERSIZED_TEXT = null;
    public static final Type RICHTEXT = null;
    public static final Type SPIN_BUTTON = null;
    public static final Type TAG_LIST = null;
    public static final Type TEXT = null;
    public static final Type TEXT_BUTTON = null;
    public static final Type TIME = null;
    public static final Type TIME_ZONE = null;
    public static final Type UNKNOWN = null;
    public static final Type VIDEO = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ Type[] f420671a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f420672b = null;
    private int value;

    public static final class a {
        public a() {
        }

        public static Type a(int r100) {
            if (r100 == 0) goto L34;
            if (r100 == 1) goto L57;
            if (r100 == 2) goto L56;
            if (r100 == 521) goto L55;
            switch(r100) {
                case 501: goto L54;
                case 502: goto L53;
                case 503: goto L52;
                case 504: goto L51;
                case 505: goto L50;
                case 506: goto L49;
                case 507: goto L48;
                case 508: goto L47;
                case 509: goto L46;
                case 510: goto L45;
                case 511: goto L44;
                case 512: goto L43;
                case 513: goto L42;
                case 514: goto L41;
                case 515: goto L40;
                case 516: goto L39;
                case 517: goto L38;
                case 518: goto L37;
                case 519: goto L36;
                default: goto L35;
            };
        L35:
            return Type.UNKNOWN;
        L36:
            return Type.ENGINE;
        L37:
            return Type.OVERSIZED_TEXT;
        L38:
            return Type.TIME_ZONE;
        L39:
            return Type.LOADING;
        L40:
            return Type.DOC_IMAGE;
        L41:
            return Type.CARD_CONTAINER;
        L42:
            return Type.VIDEO;
        L43:
            return Type.AVATAR;
        L44:
            return Type.SPIN_BUTTON;
        L45:
            return Type.TAG_LIST;
        L46:
            return Type.TEXT;
        L47:
            return Type.TIME;
        L48:
            return Type.TEXT_BUTTON;
        L49:
            return Type.ICON_BUTTON;
        L50:
            return Type.BUTTON;
        L51:
            return Type.CHATTERS_PREVIEW;
        L52:
            return Type.IMAGE;
        L53:
            return Type.RICHTEXT;
        L54:
            return Type.HEADER;
        L55:
            return Type.IMAGE_CONTAINER;
        L56:
            return Type.FLEX_LAYOUT;
        L57:
            return Type.LINEAR_LAYOUT;
        L34:
            return Type.EMPTY;
        }
    }

    public static EnumEntries<Type> getEntries() {
        return f420672b;
    }

    static {
        Type r100 = new Type("UNKNOWN", 0, -1);
        UNKNOWN = r100;
        Type r101 = new Type("EMPTY", 1, 0);
        EMPTY = r101;
        Type r102 = new Type("LINEAR_LAYOUT", 2, 1);
        LINEAR_LAYOUT = r102;
        Type r103 = new Type("FLEX_LAYOUT", 3, 2);
        FLEX_LAYOUT = r103;
        Type r104 = new Type("HEADER", 4, 501);
        HEADER = r104;
        Type r105 = new Type("RICHTEXT", 5, 502);
        RICHTEXT = r105;
        Type r110 = new Type("IMAGE", 6, 503);
        IMAGE = r110;
        Type r111 = new Type("CHATTERS_PREVIEW", 7, 504);
        CHATTERS_PREVIEW = r111;
        Type r112 = new Type("BUTTON", 8, 505);
        BUTTON = r112;
        Type r113 = new Type("ICON_BUTTON", 9, 506);
        ICON_BUTTON = r113;
        Type r106 = new Type("TEXT_BUTTON", 10, 507);
        TEXT_BUTTON = r106;
        Type r107 = new Type("TIME", 11, 508);
        TIME = r107;
        Type r108 = new Type(CardAdapter.TEXT, 12, 509);
        TEXT = r108;
        Type r109 = new Type("TAG_LIST", 13, 510);
        TAG_LIST = r109;
        Type r114 = new Type("SPIN_BUTTON", 14, 511);
        SPIN_BUTTON = r114;
        Type r115 = new Type("AVATAR", 15, 512);
        AVATAR = r115;
        Type r116 = new Type("VIDEO", 16, 513);
        VIDEO = r116;
        Type r117 = new Type("CARD_CONTAINER", 17, 514);
        CARD_CONTAINER = r117;
        Type r118 = new Type("DOC_IMAGE", 18, 515);
        DOC_IMAGE = r118;
        Type r119 = new Type("LOADING", 19, 516);
        LOADING = r119;
        Type r120 = new Type("TIME_ZONE", 20, 517);
        TIME_ZONE = r120;
        Type r121 = new Type("OVERSIZED_TEXT", 21, 518);
        OVERSIZED_TEXT = r121;
        Type r122 = new Type("ENGINE", 22, 519);
        ENGINE = r122;
        Type r123 = new Type("IMAGE_CONTAINER", 23, 521);
        IMAGE_CONTAINER = r123;
        Type[] r124 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r107, r108, r109, r114, r115, r116, r117, r118, r119, r120, r121, r122, r123};
        f420671a = r124;
        f420672b = EnumEntriesKt.enumEntries(r124);
        Companion = new a();
    }

    public static Type[] values() {
        return (Type[]) f420671a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static Type valueOf(String r100) {
        return (Type) r27.a.a(Type.class, r100);
    }

    public final void setValue(int r100) {
        this.value = r100;
    }

    public Type(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
