package com.larus.bmhome.clarification;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.Block;
import com.larus.im.bean.message.block.InteractionAskQuestion;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f310495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f310496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f310497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f310498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f310499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Message f310500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Block f310501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<InteractionAskQuestion> f310502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v1 f310503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f310504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ze8.b f310505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<z1> f310506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f310507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.larus.bmhome.interactionpanel.w f310508n;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d2) == true) goto L8;
        return false;
    L8:
        d2 r101 = (d2) r100;
        if (Intrinsics.areEqual(this.f310495a, r101.f310495a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f310496b, r101.f310496b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f310497c, r101.f310497c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f310498d, r101.f310498d) == true) goto L21;
        return false;
    L21:
        if (this.f310499e == r101.f310499e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f310500f, r101.f310500f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f310501g, r101.f310501g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f310502h, r101.f310502h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f310503i, r101.f310503i) == true) goto L36;
        return false;
    L36:
        if (this.f310504j == r101.f310504j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f310505k, r101.f310505k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f310506l, r101.f310506l) == true) goto L45;
        return false;
    L45:
        if (this.f310507m == r101.f310507m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f310508n, r101.f310508n) == true) goto L50;
        return false;
    L50:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((((((((((((((this.f310495a.hashCode() * 31) + this.f310496b.hashCode()) * 31) + this.f310497c.hashCode()) * 31) + this.f310498d.hashCode()) * 31) + this.f310499e) * 31) + this.f310500f.hashCode()) * 31) + this.f310501g.hashCode()) * 31) + this.f310502h.hashCode()) * 31) + this.f310503i.hashCode()) * 31) + this.f310504j) * 31;
        ze8.b r101 = this.f310505k;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (((r100 + r103) * 31) + this.f310506l.hashCode()) * 31;
        long r105 = this.f310507m;
        int r106 = (r104 + ((int) (r105 ^ (r105 >>> 32)))) * 31;
        com.larus.bmhome.interactionpanel.w r107 = this.f310508n;
        if (r107 == null) goto L11;
        r102 = r107.hashCode();
    L11:
        return r106 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ClarificationSession(conversationId=" + this.f310495a + ", messageId=" + this.f310496b + ", blockId=" + this.f310497c + ", clarifyId=" + this.f310498d + ", status=" + this.f310499e + ", triggerMessage=" + this.f310500f + ", triggerBlock=" + this.f310501g + ", questions=" + this.f310502h + ", inputSnapshot=" + this.f310503i + ", currentIndex=" + this.f310504j + ", panelSession=" + this.f310505k + ", pageStates=" + this.f310506l + ", createdAt=" + this.f310507m + ", trackContext=" + this.f310508n + ')';
    }

    public static d2 a(d2 r210, Message r211, int r212, ze8.b r213, List r214, com.larus.bmhome.interactionpanel.w r215, int r216) {
        v1 r100 = null;
        if ((r216 & 1) == 0) goto L5;
        String r101 = r210.f310495a;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r102 = r210.f310496b;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r103 = r210.f310497c;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r104 = r210.f310498d;
    L19:
        if ((r216 & 16) == 0) goto L21;
        int r105 = r210.f310499e;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Message r110 = r210.f310500f;
    L27:
        if ((r216 & 64) == 0) goto L29;
        Block r111 = r210.f310501g;
    L31:
        if ((r216 & 128) == 0) goto L33;
        List<InteractionAskQuestion> r112 = r210.f310502h;
    L35:
        if ((r216 & 256) == 0) goto L37;
        r100 = r210.f310503i;
    L37:
        v1 r113 = r100;
        if ((r216 & 512) == 0) goto L40;
        int r114 = r210.f310504j;
    L42:
        if ((r216 & 1024) == 0) goto L44;
        ze8.b r115 = r210.f310505k;
    L46:
        if ((r216 & 2048) == 0) goto L48;
        List r106 = r210.f310506l;
    L50:
        if ((r216 & 4096) == 0) goto L52;
        long r107 = r210.f310507m;
    L53:
        long r116 = r107;
        if ((r216 & 8192) == 0) goto L56;
        com.larus.bmhome.interactionpanel.w r117 = r210.f310508n;
    L57:
        Intrinsics.checkNotNullParameter(r101, "conversationId");
        Intrinsics.checkNotNullParameter(r102, "messageId");
        Intrinsics.checkNotNullParameter(r103, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r104, "clarifyId");
        Intrinsics.checkNotNullParameter(r110, "triggerMessage");
        Intrinsics.checkNotNullParameter(r111, "triggerBlock");
        Intrinsics.checkNotNullParameter(r112, "questions");
        Intrinsics.checkNotNullParameter(r113, "inputSnapshot");
        Intrinsics.checkNotNullParameter(r106, "pageStates");
        return new d2(r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r117);
    L56:
        r117 = r215;
        goto L57
    L52:
        r107 = 0;
        goto L53
    L48:
        r106 = r214;
        goto L50
    L44:
        r115 = r213;
        goto L46
    L40:
        r114 = r212;
        goto L42
    L33:
        r112 = null;
        goto L35
    L29:
        r111 = null;
        goto L31
    L25:
        r110 = r211;
        goto L27
    L21:
        r105 = 0;
        goto L23
    L17:
        r104 = null;
        goto L19
    L13:
        r103 = null;
        goto L15
    L9:
        r102 = null;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d2(String r110, String r111, String r112, String r113, int r114, Message r115, Block r116, List<InteractionAskQuestion> r117, v1 r210, int r211, ze8.b r212, List<z1> r213, long r214, com.larus.bmhome.interactionpanel.w r215) {
        Intrinsics.checkNotNullParameter(r110, "conversationId");
        Intrinsics.checkNotNullParameter(r111, "messageId");
        Intrinsics.checkNotNullParameter(r112, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r113, "clarifyId");
        Intrinsics.checkNotNullParameter(r115, "triggerMessage");
        Intrinsics.checkNotNullParameter(r116, "triggerBlock");
        Intrinsics.checkNotNullParameter(r117, "questions");
        Intrinsics.checkNotNullParameter(r210, "inputSnapshot");
        Intrinsics.checkNotNullParameter(r213, "pageStates");
        this.f310495a = r110;
        this.f310496b = r111;
        this.f310497c = r112;
        this.f310498d = r113;
        this.f310499e = r114;
        this.f310500f = r115;
        this.f310501g = r116;
        this.f310502h = r117;
        this.f310503i = r210;
        this.f310504j = r211;
        this.f310505k = r212;
        this.f310506l = r213;
        this.f310507m = r214;
        this.f310508n = r215;
    }
}
