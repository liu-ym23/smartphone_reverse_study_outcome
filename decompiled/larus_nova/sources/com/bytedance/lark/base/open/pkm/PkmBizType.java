package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/base/open/pkm/PkmBizType;", "", "(Ljava/lang/String;I)V", "into", "Lopen_pkm/proto/PkmBizType;", "intoInt", "", "Unknown", "Gadget", "WebApp", "Widget", "Block", "DynamicComponent", "Jssdk", "JssdkBlock", "JssdkMsgCard", "Base", "Companion", "open_pkm_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum PkmBizType extends Enum<PkmBizType> {
    public static final PkmBizType Base = null;
    public static final PkmBizType Block = null;
    public static final a Companion = null;
    public static final PkmBizType DynamicComponent = null;
    public static final PkmBizType Gadget = null;
    public static final PkmBizType Jssdk = null;
    public static final PkmBizType JssdkBlock = null;
    public static final PkmBizType JssdkMsgCard = null;
    public static final PkmBizType Unknown = null;
    public static final PkmBizType WebApp = null;
    public static final PkmBizType Widget = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PkmBizType[] f252878a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f252879b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f252880a = null;

        static {
            int[] r100 = new int[PkmBizType.values().length];
            r100[PkmBizType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r100[PkmBizType.Gadget.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r100[PkmBizType.WebApp.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r100[PkmBizType.Widget.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[PkmBizType.Block.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r100[PkmBizType.DynamicComponent.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r100[PkmBizType.Jssdk.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r100[PkmBizType.JssdkBlock.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r100[PkmBizType.JssdkMsgCard.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[PkmBizType.Base.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f252880a = r100;
        }
    }

    public static EnumEntries<PkmBizType> getEntries() {
        return f252879b;
    }

    public static PkmBizType valueOf(String r100) {
        return (PkmBizType) r27.a.a(PkmBizType.class, r100);
    }

    public static PkmBizType[] values() {
        return (PkmBizType[]) f252878a.clone();
    }

    static {
        PkmBizType r100 = new PkmBizType("Unknown", 0);
        Unknown = r100;
        PkmBizType r101 = new PkmBizType("Gadget", 1);
        Gadget = r101;
        PkmBizType r102 = new PkmBizType("WebApp", 2);
        WebApp = r102;
        PkmBizType r103 = new PkmBizType("Widget", 3);
        Widget = r103;
        PkmBizType r104 = new PkmBizType("Block", 4);
        Block = r104;
        PkmBizType r105 = new PkmBizType("DynamicComponent", 5);
        DynamicComponent = r105;
        PkmBizType r110 = new PkmBizType("Jssdk", 6);
        Jssdk = r110;
        PkmBizType r111 = new PkmBizType("JssdkBlock", 7);
        JssdkBlock = r111;
        PkmBizType r112 = new PkmBizType("JssdkMsgCard", 8);
        JssdkMsgCard = r112;
        PkmBizType r113 = new PkmBizType("Base", 9);
        Base = r113;
        PkmBizType[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f252878a = r114;
        f252879b = EnumEntriesKt.enumEntries(r114);
        Companion = new a();
    }

    public final open_pkm.proto.PkmBizType into() {
        switch(b.f252880a[ordinal()]) {
            case 1: goto L16;
            case 2: goto L25;
            case 3: goto L24;
            case 4: goto L23;
            case 5: goto L22;
            case 6: goto L21;
            case 7: goto L20;
            case 8: goto L19;
            case 9: goto L18;
            case 10: goto L17;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L17:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_BASE;
    L18:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_JSSDK_MSG_CARD;
    L19:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_JSSDK_BLOCK;
    L20:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_JSSDK;
    L21:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_DYNAMIC_COMPONENT;
    L22:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_BLOCK;
    L23:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_WIDGET;
    L24:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_WEB_APP;
    L25:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_GADGET;
    L16:
        return open_pkm.proto.PkmBizType.VAR_PKM_BIZ_TYPE_UNKNOWN;
    }

    public final int intoInt() {
        switch(b.f252880a[ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L7;
            case 10: goto L6;
            default: goto L5;
        };
    L6:
        return 9;
    L7:
        return 8;
    L8:
        return 7;
    L9:
        return 6;
    L10:
        return 5;
    L11:
        return 4;
    L12:
        return 3;
    L13:
        return 2;
    L14:
        return 1;
    L15:
        return 0;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    @JvmStatic
    public static final PkmBizType fromInt(int r100) {
        Companion.getClass();
        switch(r100) {
            case 0: goto L16;
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            case 9: goto L17;
            default: goto L5;
        };
    L5:
        throw new RuntimeException("Unmatched primitive enum value: PkmBizType with ");
    L17:
        return Base;
    L18:
        return JssdkMsgCard;
    L19:
        return JssdkBlock;
    L20:
        return Jssdk;
    L21:
        return DynamicComponent;
    L22:
        return Block;
    L23:
        return Widget;
    L24:
        return WebApp;
    L25:
        return Gadget;
    L16:
        return Unknown;
    }

    public PkmBizType(String r100, int r101) {
        super(r100, r101);
    }
}
