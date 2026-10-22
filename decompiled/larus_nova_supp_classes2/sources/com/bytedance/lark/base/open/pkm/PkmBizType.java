package com.bytedance.lark.base.open.pkm;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
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
    public static final /* synthetic */ PkmBizType[] f7211a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f7212b = null;

    public static final class a {
        public a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7213a = null;

        static {
            int[] r0 = new int[PkmBizType.values().length];
            r0[PkmBizType.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[PkmBizType.Gadget.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[PkmBizType.WebApp.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[PkmBizType.Widget.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[PkmBizType.Block.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[PkmBizType.DynamicComponent.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[PkmBizType.Jssdk.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[PkmBizType.JssdkBlock.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[PkmBizType.JssdkMsgCard.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[PkmBizType.Base.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            f7213a = r0;
        }
    }

    public static EnumEntries<PkmBizType> getEntries() {
        return f7212b;
    }

    public static PkmBizType valueOf(String r1) {
        return (PkmBizType) r27.a.a(PkmBizType.class, r1);
    }

    public static PkmBizType[] values() {
        return (PkmBizType[]) f7211a.clone();
    }

    static {
        PkmBizType r0 = new PkmBizType("Unknown", 0);
        Unknown = r0;
        PkmBizType r1 = new PkmBizType("Gadget", 1);
        Gadget = r1;
        PkmBizType r3 = new PkmBizType("WebApp", 2);
        WebApp = r3;
        PkmBizType r5 = new PkmBizType("Widget", 3);
        Widget = r5;
        PkmBizType r7 = new PkmBizType("Block", 4);
        Block = r7;
        PkmBizType r9 = new PkmBizType("DynamicComponent", 5);
        DynamicComponent = r9;
        PkmBizType r11 = new PkmBizType("Jssdk", 6);
        Jssdk = r11;
        PkmBizType r13 = new PkmBizType("JssdkBlock", 7);
        JssdkBlock = r13;
        PkmBizType r15 = new PkmBizType("JssdkMsgCard", 8);
        JssdkMsgCard = r15;
        PkmBizType r14 = new PkmBizType("Base", 9);
        Base = r14;
        PkmBizType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        f7211a = r12;
        f7212b = EnumEntriesKt.enumEntries(r12);
        Companion = new a();
    }

    public final open_pkm.proto.PkmBizType into() {
        switch(b.f7213a[ordinal()]) {
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
        switch(b.f7213a[ordinal()]) {
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
    public static final PkmBizType fromInt(int r1) {
        Companion.getClass();
        switch(r1) {
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

    public PkmBizType(String r1, int r2) {
        super(r1, r2);
    }
}
