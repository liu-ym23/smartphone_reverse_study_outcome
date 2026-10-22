package com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel;

import com.larus.bmhome.chat.bean.ChatPageContext;
import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309009d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f309010e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f309011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f309012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, String> f309013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Message f309014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f309015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final wc9.e f309016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f309017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f309018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Function1<String, Boolean> f309019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Function0<Boolean> f309020o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Function0<List<Message>> f309021p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ChatPageContext f309022q;

    /* JADX INFO: renamed from: com.larus.bmhome.chat.standarduikit.commonbuttonv2.viewmodel.a$a, reason: collision with other inner class name */
    public static final class C4073a {
    }

    static {
    }

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f309006a, r101.f309006a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309007b, r101.f309007b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309008c, r101.f309008c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309009d, r101.f309009d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309010e, r101.f309010e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309011f, r101.f309011f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f309012g, r101.f309012g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f309013h, r101.f309013h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309014i, r101.f309014i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f309015j, r101.f309015j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f309016k, r101.f309016k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f309017l, r101.f309017l) == true) goto L45;
        return false;
    L45:
        if (this.f309018m == r101.f309018m) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.f309019n, r101.f309019n) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f309020o, r101.f309020o) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.f309021p, r101.f309021p) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f309022q, r101.f309022q) == true) goto L59;
        return false;
    L59:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f309006a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f309007b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f309008c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f309009d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f309010e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.f309011f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f309012g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Map<String, String> r122 = this.f309013h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Message r125 = this.f309014i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        String r128 = this.f309015j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        wc9.e r131 = this.f309016k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        String r134 = this.f309017l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        if (this.f309018m == false) goto L53;
        int r137 = 1231;
    L54:
        int r138 = (r136 + r137) * 31;
        Function1<String, Boolean> r139 = this.f309019n;
        if (r139 != null) goto L57;
        int r140 = 0;
    L58:
        int r141 = (r138 + r140) * 31;
        Function0<Boolean> r142 = this.f309020o;
        if (r142 != null) goto L61;
        int r143 = 0;
    L62:
        int r144 = (r141 + r143) * 31;
        Function0<List<Message>> r145 = this.f309021p;
        if (r145 != null) goto L65;
        int r146 = 0;
    L66:
        int r147 = (r144 + r146) * 31;
        ChatPageContext r148 = this.f309022q;
        if (r148 == null) goto L71;
        r101 = r148.hashCode();
    L71:
        return r147 + r101;
    L65:
        r146 = r145.hashCode();
        goto L66
    L61:
        r143 = r142.hashCode();
        goto L62
    L57:
        r140 = r139.hashCode();
        goto L58
    L53:
        r137 = 1237;
        goto L54
    L49:
        r135 = r134.hashCode();
        goto L50
    L45:
        r132 = r131.hashCode();
        goto L46
    L41:
        r129 = r128.hashCode();
        goto L42
    L37:
        r126 = r125.hashCode();
        goto L38
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
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
        return "CommonButtonV2VMData(displayText=" + this.f309006a + ", messageText=" + this.f309007b + ", iconUrlLight=" + this.f309008c + ", iconUrlDark=" + this.f309009d + ", schemeUrl=" + this.f309010e + ", command=" + this.f309011f + ", scene=" + this.f309012g + ", extra=" + this.f309013h + ", message=" + this.f309014i + ", previousPage=" + this.f309015j + ", conversation=" + this.f309016k + ", conversationId=" + this.f309017l + ", isMultiBtn=" + this.f309018m + ", hasContainedMessage=" + this.f309019n + ", isLastMsgIsClearContext=" + this.f309020o + ", getLastMessageList=" + this.f309021p + ", chatPageContext=" + this.f309022q + ')';
    }

    public /* synthetic */ a(int r110) {
        this(null, null, null, null, null, 0, null, null, null, null, null, null, false, null, null, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(String r100, String r101, String r102, String r103, String r104, Integer r105, String r106, Map<String, String> r110, Message r111, String r112, wc9.e r113, String r114, boolean r115, Function1<? super String, Boolean> r116, Function0<Boolean> r117, Function0<? extends List<Message>> r118, ChatPageContext r119) {
        this.f309006a = r100;
        this.f309007b = r101;
        this.f309008c = r102;
        this.f309009d = r103;
        this.f309010e = r104;
        this.f309011f = r105;
        this.f309012g = r106;
        this.f309013h = r110;
        this.f309014i = r111;
        this.f309015j = r112;
        this.f309016k = r113;
        this.f309017l = r114;
        this.f309018m = r115;
        this.f309019n = r116;
        this.f309020o = r117;
        this.f309021p = r118;
        this.f309022q = r119;
    }
}
