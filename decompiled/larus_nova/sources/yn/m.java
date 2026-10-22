package yn;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.window.base.common.headlive.WindowV3LiveRoomVO;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f568480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f568481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f568482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WindowV3LiveRoomVO f568483d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f568484e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f568485f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f568486g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f568487h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f568488i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f568489j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f568490k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof m) == false) goto L28;
        m r101 = (m) r100;
        if (Intrinsics.areEqual(this.f568480a, r101.f568480a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f568481b, r101.f568481b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f568482c, r101.f568482c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568483d, r101.f568483d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f568484e, r101.f568484e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f568485f, r101.f568485f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f568486g, r101.f568486g) == true) goto L20;
        return false;
    L20:
        if (this.f568487h == r101.f568487h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f568488i, r101.f568488i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f568489j, r101.f568489j) == true) goto L26;
        return false;
    L26:
        if (this.f568490k == r101.f568490k) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v22, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public final int hashCode() {
        Context r100 = this.f568480a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f568481b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FrameLayout r107 = this.f568482c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        WindowV3LiveRoomVO r110 = this.f568483d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f568484e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f568485f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f568486g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((r118 + r120) * 31) + this.f568487h) * 31;
        String r122 = this.f568488i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f568489j;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        int r126 = (r124 + r101) * 31;
        boolean r127 = this.f568490k;
        ?? r128 = r127;
        if (r127 == false) goto L41;
        r128 = 1;
    L41:
        return r126 + r128;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "WindowFloatLiveContext(context=" + this.f568480a + ", fragment=" + this.f568481b + ", frameLayout=" + this.f568482c + ", liveInfo=" + this.f568483d + ", passThroughLogData=" + this.f568484e + ", ecomSceneId=" + this.f568485f + ", searchParam=" + this.f568486g + ", floatBottomMargin=" + this.f568487h + ", shopId=" + this.f568488i + ", authorId=" + this.f568489j + ", forceNotSharedLiveClient=" + this.f568490k + ")";
    }

    public final Context getContext() {
        return this.f568480a;
    }

    public m(Context r100, Fragment r101, FrameLayout r102, WindowV3LiveRoomVO r103, String r104, String r105, String r106, int r107, String r110) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f568480a = r100;
        this.f568481b = r101;
        this.f568482c = r102;
        this.f568483d = r103;
        this.f568484e = r104;
        this.f568485f = r105;
        this.f568486g = r106;
        this.f568487h = r107;
        this.f568488i = null;
        this.f568489j = r110;
        this.f568490k = false;
    }
}
