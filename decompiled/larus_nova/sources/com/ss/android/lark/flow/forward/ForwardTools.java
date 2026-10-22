package com.ss.android.lark.flow.forward;

import android.text.TextUtils;
import com.larksuite.framework.utils.f0;
import com.ss.android.lark.biz.im.api.ChatterNameDisplayRule;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;

/* JADX INFO: loaded from: classes36.dex */
public final class ForwardTools {

    public static final enum RecentVisitTargetType extends Enum<RecentVisitTargetType> {
        public static final RecentVisitTargetType CHAT = null;
        public static final RecentVisitTargetType MSG_THREAD = null;
        public static final RecentVisitTargetType THREAD = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecentVisitTargetType[] f423633a = null;
        private final int value;

        static {
            RecentVisitTargetType r100 = new RecentVisitTargetType("CHAT", 0, 1);
            CHAT = r100;
            RecentVisitTargetType r101 = new RecentVisitTargetType("THREAD", 1, 4);
            THREAD = r101;
            RecentVisitTargetType r102 = new RecentVisitTargetType("MSG_THREAD", 2, 11);
            MSG_THREAD = r102;
            f423633a = new RecentVisitTargetType[]{r100, r101, r102};
        }

        public static RecentVisitTargetType[] values() {
            return (RecentVisitTargetType[]) f423633a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static /* synthetic */ int access$000(RecentVisitTargetType r100) {
            return r100.value;
        }

        public static RecentVisitTargetType fromValue(int r100) {
            if (r100 == 1) goto L15;
            if (r100 == 4) goto L13;
            if (r100 == 11) goto L11;
            return null;
        L11:
            return MSG_THREAD;
        L13:
            return THREAD;
        L15:
            return CHAT;
        }

        public static RecentVisitTargetType valueOf(String r100) {
            return (RecentVisitTargetType) r27.a.a(RecentVisitTargetType.class, r100);
        }

        public RecentVisitTargetType(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f423634a = null;

        static {
            int[] r100 = new int[ChatterNameDisplayRule.values().length];
            f423634a = r100;
            r100[ChatterNameDisplayRule.ALIAS_NAME.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f423634a[ChatterNameDisplayRule.NICKNAME_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f423634a[ChatterNameDisplayRule.ALIAS_NICKNAME_NAME.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f423634a[ChatterNameDisplayRule.NICKNAME_ALIAS_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f423634a[ChatterNameDisplayRule.NICKNAME_WITH_ALIAS.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static String a(Chatter r100, ChatterNameDisplayRule r101) {
        String r102 = "";
        if (r100 != null) goto L6;
        return "";
    L6:
        if ((r100 instanceof ChatChatter) == false) goto L12;
        ChatChatter r103 = (ChatChatter) r100;
        if (r103.isOncallDuty() == true) goto L10;
        String r104 = r103.getNickName();
    L13:
        String r105 = r100.getAlias();
        String r106 = r100.getName();
        String r107 = r100.getLocalizedName();
        r100.getEnName();
        int r108 = a.f423634a[r101.ordinal()];
        if (r108 == 1) goto L49;
        if (r108 == 2) goto L46;
        if (r108 == 3) goto L40;
        if (r108 == 4) goto L34;
        if (r108 != 5) goto L52;
        if (f0.a(r104) == true) goto L31;
        StringBuilder r109 = new StringBuilder();
        r109.append(r104);
        if (f0.a(r105) == true) goto L29;
        r102 = String.format("(%s)", new Object[]{r105});
    L29:
        r109.append(r102);
        return r109.toString();
    L31:
        if (f0.a(r105) == true) goto L52;
    L57:
        return r105;
    L52:
        if (TextUtils.isEmpty(r107) == true) goto L55;
        return r107;
    L55:
        return r106;
    L34:
        if (f0.a(r104) == true) goto L37;
        return r104;
    L37:
        if (f0.a(r105) == true) goto L52;
    L40:
        if (f0.a(r105) == false) goto L57;
        if (f0.a(r104) == true) goto L52;
        return r104;
    L46:
        if (f0.a(r104) == true) goto L52;
        return r104;
    L49:
        if (f0.a(r105) == true) goto L52;
    L10:
        return r103.getName();
    L12:
        r104 = null;
        goto L13
    }
}
