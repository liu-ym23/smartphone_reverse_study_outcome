package com.larus.bmhome.chat.standarduikit.quickreply.viewmodel;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.QuickReplyBlock;
import com.larus.im.bean.message.block.QuickReplyItem;
import com.ss.android.socialbase.appdownloader.util.parser.zip.UnixStat;
import java.util.Map;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f309567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f309568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> f309569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f309570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final QuickReplyBlock f309571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ChatPageContext f309572j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f309573k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Message f309574l;

    public b() {
        this(null, null, null, null, 0, null, null, null, UnixStat.PERM_MASK);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f309563a, r101.f309563a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309564b, r101.f309564b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309565c, r101.f309565c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309566d, r101.f309566d) == true) goto L21;
        return false;
    L21:
        if (this.f309567e == r101.f309567e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309568f, r101.f309568f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309569g, r101.f309569g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f309570h, r101.f309570h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309571i, r101.f309571i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f309572j, r101.f309572j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f309573k, r101.f309573k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f309574l, r101.f309574l) == true) goto L44;
        return false;
    L44:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f309563a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f309564b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f309565c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f309566d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f309567e;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        Map<String, String> r115 = this.f309568f;
        if (r115 != null) goto L21;
        int r116 = 0;
    L22:
        int r117 = (r114 + r116) * 31;
        Function6<String, QuickReplyBlock, String, QuickReplyItem, Integer, Integer, Boolean> r118 = this.f309569g;
        if (r118 != null) goto L25;
        int r119 = 0;
    L26:
        int r120 = (r117 + r119) * 31;
        Integer r121 = this.f309570h;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        QuickReplyBlock r124 = this.f309571i;
        if (r124 != null) goto L33;
        int r125 = 0;
    L34:
        int r126 = (r123 + r125) * 31;
        ChatPageContext r127 = this.f309572j;
        if (r127 != null) goto L37;
        int r128 = 0;
    L38:
        int r129 = (r126 + r128) * 31;
        String r130 = this.f309573k;
        if (r130 != null) goto L41;
        int r131 = 0;
    L42:
        int r132 = (r129 + r131) * 31;
        Message r133 = this.f309574l;
        if (r133 == null) goto L47;
        r101 = r133.hashCode();
    L47:
        return r132 + r101;
    L41:
        r131 = r130.hashCode();
        goto L42
    L37:
        r128 = r127.hashCode();
        goto L38
    L33:
        r125 = r124.hashCode();
        goto L34
    L29:
        r122 = r121.hashCode();
        goto L30
    L25:
        r119 = r118.hashCode();
        goto L26
    L21:
        r116 = r115.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "QuickReplyVMData(conversationId=" + this.f309563a + ", referenceMessageId=" + this.f309564b + ", botId=" + this.f309565c + ", currentPage=" + this.f309566d + ", previousBlockCompleteTimeMs=" + this.f309567e + ", messageExt=" + this.f309568f + ", customClickListener=" + this.f309569g + ", itemBackgroundRes=" + this.f309570h + ", quickReplyBlock=" + this.f309571i + ", chatPageContext=" + this.f309572j + ", blockId=" + this.f309573k + ", message=" + this.f309574l + ')';
    }

    public /* synthetic */ b(String r110, String r111, String r210, String r211, long r212, Map r213, QuickReplyBlock r214, String r215, int r216) {
        if ((r216 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r216 & 4) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r104 = 0;
    L23:
        if ((r216 & 32) == 0) goto L25;
        Map r112 = null;
    L27:
        if ((r216 & 256) == 0) goto L29;
        QuickReplyBlock r113 = null;
    L31:
        if ((r216 & 1024) == 0) goto L33;
        String r114 = null;
    L34:
        this(r100, r101, r102, r103, r104, r112, null, null, r113, null, r114, null);
        return;
    L33:
        r114 = r215;
        goto L34
    L29:
        r113 = r214;
        goto L31
    L25:
        r112 = r213;
        goto L27
    L21:
        r104 = r212;
        goto L23
    L17:
        r103 = r211;
        goto L19
    L13:
        r102 = r210;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(String r100, String r101, String r102, String r103, long r104, Map<String, String> r105, Function6<? super String, ? super QuickReplyBlock, ? super String, ? super QuickReplyItem, ? super Integer, ? super Integer, Boolean> r106, Integer r107, QuickReplyBlock r110, ChatPageContext r111, String r112, Message r113) {
        this.f309563a = r100;
        this.f309564b = r101;
        this.f309565c = r102;
        this.f309566d = r103;
        this.f309567e = r104;
        this.f309568f = r105;
        this.f309569g = r106;
        this.f309570h = r107;
        this.f309571i = r110;
        this.f309572j = r111;
        this.f309573k = r112;
        this.f309574l = r113;
    }
}
