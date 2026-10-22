package com.lark.kmp.pb.basic.v1;

import com.lark.wire.ProtoAdapter;
import com.lark.wire.Syntax;
import com.lark.wire.o0;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/lark/kmp/pb/basic/v1/TnsBlockedFeature;", "Lcom/lark/wire/WireEnum;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "UNKNOWN_BLOCKED_FEATURE", "BLOCKED_ADD_MEMBER", "BLOCKED_REMOVE_MEMBER", "BLOCKED_CHAT_TAB", "BLOCKED_CHAT_MENU_TNS", "BLOCKED_MESSAGE_MENU", "BLOCKED_BOT_POST", "BLOCKED_MANAGE_BOT", "BLOCKED_GROUP_TASK", "BLOCKED_MODIFY_CHAT_INFO", "Companion", "rust-sdk-kotlin-pb_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final enum TnsBlockedFeature extends Enum<TnsBlockedFeature> implements o0 {
    public static final ProtoAdapter<TnsBlockedFeature> ADAPTER = null;
    public static final TnsBlockedFeature BLOCKED_ADD_MEMBER = null;
    public static final TnsBlockedFeature BLOCKED_BOT_POST = null;
    public static final TnsBlockedFeature BLOCKED_CHAT_MENU_TNS = null;
    public static final TnsBlockedFeature BLOCKED_CHAT_TAB = null;
    public static final TnsBlockedFeature BLOCKED_GROUP_TASK = null;
    public static final TnsBlockedFeature BLOCKED_MANAGE_BOT = null;
    public static final TnsBlockedFeature BLOCKED_MESSAGE_MENU = null;
    public static final TnsBlockedFeature BLOCKED_MODIFY_CHAT_INFO = null;
    public static final TnsBlockedFeature BLOCKED_REMOVE_MEMBER = null;
    public static final b Companion = null;
    public static final TnsBlockedFeature UNKNOWN_BLOCKED_FEATURE = null;
    public static final /* synthetic */ TnsBlockedFeature[] a = null;
    public static final /* synthetic */ EnumEntries b = null;
    private final int value;

    public static final class b {
        public b() {
        }

        @JvmStatic
        public static TnsBlockedFeature a(int r0) {
            switch(r0) {
                case 0: goto L14;
                case 1: goto L24;
                case 2: goto L23;
                case 3: goto L22;
                case 4: goto L21;
                case 5: goto L20;
                case 6: goto L19;
                case 7: goto L18;
                case 8: goto L17;
                case 9: goto L16;
                default: goto L3;
            };
        L3:
            return null;
        L16:
            return TnsBlockedFeature.BLOCKED_MODIFY_CHAT_INFO;
        L17:
            return TnsBlockedFeature.BLOCKED_GROUP_TASK;
        L18:
            return TnsBlockedFeature.BLOCKED_MANAGE_BOT;
        L19:
            return TnsBlockedFeature.BLOCKED_BOT_POST;
        L20:
            return TnsBlockedFeature.BLOCKED_MESSAGE_MENU;
        L21:
            return TnsBlockedFeature.BLOCKED_CHAT_MENU_TNS;
        L22:
            return TnsBlockedFeature.BLOCKED_CHAT_TAB;
        L23:
            return TnsBlockedFeature.BLOCKED_REMOVE_MEMBER;
        L24:
            return TnsBlockedFeature.BLOCKED_ADD_MEMBER;
        L14:
            return TnsBlockedFeature.UNKNOWN_BLOCKED_FEATURE;
        }
    }

    @JvmStatic
    public static final TnsBlockedFeature fromValue(int r1) {
        Companion.getClass();
        return b.a(r1);
    }

    public static EnumEntries<TnsBlockedFeature> getEntries() {
        return b;
    }

    static {
        final TnsBlockedFeature r0 = new TnsBlockedFeature("UNKNOWN_BLOCKED_FEATURE", 0, 0);
        UNKNOWN_BLOCKED_FEATURE = r0;
        TnsBlockedFeature r1 = new TnsBlockedFeature("BLOCKED_ADD_MEMBER", 1, 1);
        BLOCKED_ADD_MEMBER = r1;
        TnsBlockedFeature r3 = new TnsBlockedFeature("BLOCKED_REMOVE_MEMBER", 2, 2);
        BLOCKED_REMOVE_MEMBER = r3;
        TnsBlockedFeature r5 = new TnsBlockedFeature("BLOCKED_CHAT_TAB", 3, 3);
        BLOCKED_CHAT_TAB = r5;
        TnsBlockedFeature r7 = new TnsBlockedFeature("BLOCKED_CHAT_MENU_TNS", 4, 4);
        BLOCKED_CHAT_MENU_TNS = r7;
        TnsBlockedFeature r9 = new TnsBlockedFeature("BLOCKED_MESSAGE_MENU", 5, 5);
        BLOCKED_MESSAGE_MENU = r9;
        TnsBlockedFeature r11 = new TnsBlockedFeature("BLOCKED_BOT_POST", 6, 6);
        BLOCKED_BOT_POST = r11;
        TnsBlockedFeature r13 = new TnsBlockedFeature("BLOCKED_MANAGE_BOT", 7, 7);
        BLOCKED_MANAGE_BOT = r13;
        TnsBlockedFeature r15 = new TnsBlockedFeature("BLOCKED_GROUP_TASK", 8, 8);
        BLOCKED_GROUP_TASK = r15;
        TnsBlockedFeature r14 = new TnsBlockedFeature("BLOCKED_MODIFY_CHAT_INFO", 9, 9);
        BLOCKED_MODIFY_CHAT_INFO = r14;
        TnsBlockedFeature[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
        a = r12;
        b = EnumEntriesKt.enumEntries(r12);
        Companion = new b();
        final KClass r2 = Reflection.getOrCreateKotlinClass(TnsBlockedFeature.class);
        final Syntax r4 = Syntax.PROTO_2;
        ADAPTER = new a(r2, r4, r0);
    }

    public static TnsBlockedFeature[] values() {
        return (TnsBlockedFeature[]) a.clone();
    }

    @Override // com.lark.wire.o0
    public int getValue() {
        return this.value;
    }

    public static TnsBlockedFeature valueOf(String r1) {
        return (TnsBlockedFeature) r27.a.a(TnsBlockedFeature.class, r1);
    }

    public TnsBlockedFeature(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }
}
