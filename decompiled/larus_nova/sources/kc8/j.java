package kc8;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function1<String, Boolean> f502498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Boolean> f502499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<List<Message>> f502500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Long> f502501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f502502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f502503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function2<Boolean, Message, Unit> f502504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function0<Boolean> f502505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Long> f502506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function1<Message, Unit> f502507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Function1<Boolean, Unit> f502508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Function0<Unit> f502509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<String, Unit> f502510m;

    public j() {
        this(null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f502498a, r101.f502498a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502499b, r101.f502499b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502500c, r101.f502500c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502501d, r101.f502501d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502502e, r101.f502502e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f502503f, r101.f502503f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f502504g, r101.f502504g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f502505h, r101.f502505h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f502506i, r101.f502506i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f502507j, r101.f502507j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f502508k, r101.f502508k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f502509l, r101.f502509l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f502510m, r101.f502510m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Function1<String, Boolean> r100 = this.f502498a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Function0<Boolean> r104 = this.f502499b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<List<Message>> r107 = this.f502500c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Long> r110 = this.f502501d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Unit> r113 = this.f502502e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Function0<Unit> r116 = this.f502503f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Function2<Boolean, Message, Unit> r119 = this.f502504g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Function0<Boolean> r122 = this.f502505h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Function0<Long> r125 = this.f502506i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        Function1<Message, Unit> r128 = this.f502507j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        Function1<Boolean, Unit> r131 = this.f502508k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        Function0<Unit> r134 = this.f502509l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Function1<String, Unit> r137 = this.f502510m;
        if (r137 == null) goto L55;
        r101 = r137.hashCode();
    L55:
        return r136 + r101;
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
        return "ChatListGlobalConfig(hasContainedMessage=" + this.f502498a + ", isLastMsgIsClearContext=" + this.f502499b + ", getLastMessageList=" + this.f502500c + ", getCurrentLocalIndex=" + this.f502501d + ", autoScrollToAnchorView=" + this.f502502e + ", updateFastButton=" + this.f502503f + ", onMessageHeaderViewExpandStateChange=" + this.f502504g + ", isPageFirstFeedShow=" + this.f502505h + ", getEnterPageTime=" + this.f502506i + ", showFirstAppCard=" + this.f502507j + ", scrollToLatestOnNextLayout=" + this.f502508k + ", updateForCommon=" + this.f502509l + ", notifyAllRelatedCell=" + this.f502510m + ')';
    }

    public /* synthetic */ j(com.larus.larkfeed.impl.lark.holder.content.b r110, int r111) {
        if ((r111 & 4096) == 0) goto L5;
        com.larus.larkfeed.impl.lark.holder.content.b r112 = null;
    L6:
        this(null, null, null, null, null, null, null, null, null, null, null, null, r112);
        return;
    L5:
        r112 = r110;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public j(Function1<? super String, Boolean> r100, Function0<Boolean> r101, Function0<? extends List<Message>> r102, Function0<Long> r103, Function0<Unit> r104, Function0<Unit> r105, Function2<? super Boolean, ? super Message, Unit> r106, Function0<Boolean> r107, Function0<Long> r108, Function1<? super Message, Unit> r110, Function1<? super Boolean, Unit> r111, Function0<Unit> r112, Function1<? super String, Unit> r113) {
        this.f502498a = r100;
        this.f502499b = r101;
        this.f502500c = r102;
        this.f502501d = r103;
        this.f502502e = r104;
        this.f502503f = r105;
        this.f502504g = r106;
        this.f502505h = r107;
        this.f502506i = r108;
        this.f502507j = r110;
        this.f502508k = r111;
        this.f502509l = r112;
        this.f502510m = r113;
    }
}
