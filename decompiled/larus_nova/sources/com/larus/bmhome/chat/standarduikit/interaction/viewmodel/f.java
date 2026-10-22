package com.larus.bmhome.chat.standarduikit.interaction.viewmodel;

import com.larus.bmhome.interactionpanel.w;
import com.larus.im.bean.message.block.QuickReplyBlock;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f309352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f309353b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f309354c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f309355d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f309356e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, String> f309357f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f309358g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final QuickReplyBlock f309359h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final w f309360i;

    public f() {
        this(null, null, null, null, null, 0, null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f309352a, r101.f309352a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f309353b, r101.f309353b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f309354c, r101.f309354c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f309355d, r101.f309355d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f309356e, r101.f309356e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f309357f, r101.f309357f) == true) goto L27;
        return false;
    L27:
        if (this.f309358g == r101.f309358g) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f309359h, r101.f309359h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f309360i, r101.f309360i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f309352a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f309353b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f309354c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f309355d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f309356e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Map<String, String> r116 = this.f309357f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        long r119 = this.f309358g;
        int r120 = (r118 + ((int) (r119 ^ (r119 >>> 32)))) * 31;
        QuickReplyBlock r121 = this.f309359h;
        if (r121 != null) goto L29;
        int r122 = 0;
    L30:
        int r123 = (r120 + r122) * 31;
        w r124 = this.f309360i;
        if (r124 == null) goto L35;
        r101 = r124.hashCode();
    L35:
        return r123 + r101;
    L29:
        r122 = r121.hashCode();
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
        return "InteractionQuickReplyVMData(messageId=" + this.f309352a + ", blockId=" + this.f309353b + ", conversationId=" + this.f309354c + ", botId=" + this.f309355d + ", currentPage=" + this.f309356e + ", messageExt=" + this.f309357f + ", previousBlockCompleteTimeMs=" + this.f309358g + ", quickReplyBlock=" + this.f309359h + ", trackContext=" + this.f309360i + ')';
    }

    public f(String r100, String r101, String r102, String r103, Map r104, long r105, QuickReplyBlock r110, w r111, int r112) {
        if ((r112 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r112 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r112 & 64) == 0) goto L21;
        r105 = 0;
    L21:
        if ((r112 & 128) == 0) goto L24;
        r110 = null;
    L24:
        if ((r112 & 256) == 0) goto L26;
        r111 = null;
    L26:
        this.f309352a = r100;
        this.f309353b = r101;
        this.f309354c = r102;
        this.f309355d = r103;
        this.f309356e = null;
        this.f309357f = r104;
        this.f309358g = r105;
        this.f309359h = r110;
        this.f309360i = r111;
    }
}
