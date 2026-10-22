package kc8;

import androidx.fragment.app.Fragment;
import cb8.a1;
import cb8.p1;
import cb8.r1;
import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes25.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f502546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f502547b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Boolean f502548c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a0 f502549d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Boolean> f502550e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f502551f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final rd8.b f502552g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final rd8.a f502553h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<List<Message>> f502554i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c0 f502555j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b0 f502556k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final com.larus.bmhome.chat.api.q0 f502557l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Function1<Integer, Unit> f502558m;

    public q() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 8191);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof q) == true) goto L8;
        return false;
    L8:
        q r101 = (q) r100;
        if (Intrinsics.areEqual(this.f502546a, r101.f502546a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502547b, r101.f502547b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502548c, r101.f502548c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502549d, r101.f502549d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f502550e, r101.f502550e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f502551f, r101.f502551f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f502552g, r101.f502552g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f502553h, r101.f502553h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f502554i, r101.f502554i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f502555j, r101.f502555j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f502556k, r101.f502556k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.f502557l, r101.f502557l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f502558m, r101.f502558m) == true) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        Fragment r100 = this.f502546a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Boolean r104 = this.f502547b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Boolean r107 = this.f502548c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        a0 r110 = this.f502549d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Function0<Boolean> r113 = this.f502550e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        CoroutineScope r116 = this.f502551f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        rd8.b r119 = this.f502552g;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        rd8.a r122 = this.f502553h;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Function0<List<Message>> r125 = this.f502554i;
        if (r125 != null) goto L37;
        int r126 = 0;
    L38:
        int r127 = (r124 + r126) * 31;
        c0 r128 = this.f502555j;
        if (r128 != null) goto L41;
        int r129 = 0;
    L42:
        int r130 = (r127 + r129) * 31;
        b0 r131 = this.f502556k;
        if (r131 != null) goto L45;
        int r132 = 0;
    L46:
        int r133 = (r130 + r132) * 31;
        com.larus.bmhome.chat.api.q0 r134 = this.f502557l;
        if (r134 != null) goto L49;
        int r135 = 0;
    L50:
        int r136 = (r133 + r135) * 31;
        Function1<Integer, Unit> r137 = this.f502558m;
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
        return "CreateBlockConfig(hostFragment=" + this.f502546a + ", disableCreateImagePreview=" + this.f502547b + ", showShare=" + this.f502548c + ", conversationProvider=" + this.f502549d + ", isCollectMode=" + this.f502550e + ", coroutineScope=" + this.f502551f + ", creationVideoAction=" + this.f502552g + ", creationLoadingState=" + this.f502553h + ", messageListProvider=" + this.f502554i + ", interactionHandler=" + this.f502555j + ", editAction=" + this.f502556k + ", messageAdapter=" + this.f502557l + ", customClickListener=" + this.f502558m + ')';
    }

    public q(Fragment r100, Boolean r101, a0 r102, cb8.z0 r103, CoroutineScope r104, rd8.b r105, p1 r106, a1 r110, c0 r111, r1 r112, com.larus.bmhome.chat.api.q0 r113, com.larus.larkfeed.impl.lark.holder.content.n r114, int r115) {
        if ((r115 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r115 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r115 & 8) == 0) goto L12;
        r102 = null;
    L12:
        if ((r115 & 16) == 0) goto L15;
        r103 = null;
    L15:
        if ((r115 & 32) == 0) goto L18;
        r104 = null;
    L18:
        if ((r115 & 64) == 0) goto L21;
        r105 = null;
    L21:
        if ((r115 & 128) == 0) goto L24;
        r106 = null;
    L24:
        if ((r115 & 256) == 0) goto L27;
        r110 = null;
    L27:
        if ((r115 & 512) == 0) goto L30;
        r111 = null;
    L30:
        if ((r115 & 1024) == 0) goto L33;
        r112 = null;
    L33:
        if ((r115 & 2048) == 0) goto L36;
        r113 = null;
    L36:
        if ((r115 & 4096) == 0) goto L38;
        r114 = null;
    L38:
        this.f502546a = r100;
        this.f502547b = r101;
        this.f502548c = null;
        this.f502549d = r102;
        this.f502550e = r103;
        this.f502551f = r104;
        this.f502552g = r105;
        this.f502553h = r106;
        this.f502554i = r110;
        this.f502555j = r111;
        this.f502556k = r112;
        this.f502557l = r113;
        this.f502558m = r114;
    }
}
