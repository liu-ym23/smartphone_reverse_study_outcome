package im;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.bytedance.android.ec.store.common.headlive.StoreV3LiveRoomVO;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f490408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Fragment f490409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f490410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StoreV3LiveRoomVO f490411d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f490412e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f490413f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f490414g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f490415h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f490416i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f490417j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f490418k;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof o) == false) goto L28;
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f490408a, r101.f490408a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f490409b, r101.f490409b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f490410c, r101.f490410c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f490411d, r101.f490411d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f490412e, r101.f490412e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f490413f, r101.f490413f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f490414g, r101.f490414g) == true) goto L20;
        return false;
    L20:
        if (this.f490415h == r101.f490415h) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f490416i, r101.f490416i) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f490417j, r101.f490417j) == true) goto L26;
        return false;
    L26:
        if (this.f490418k == r101.f490418k) goto L43;
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
        Context r100 = this.f490408a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Fragment r104 = this.f490409b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        FrameLayout r107 = this.f490410c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        StoreV3LiveRoomVO r110 = this.f490411d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f490412e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f490413f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f490414g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (((r118 + r120) * 31) + this.f490415h) * 31;
        String r122 = this.f490416i;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.f490417j;
        if (r125 == null) goto L37;
        r101 = r125.hashCode();
    L37:
        int r126 = (r124 + r101) * 31;
        boolean r127 = this.f490418k;
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
        return "FloatLiveContext(context=" + this.f490408a + ", fragment=" + this.f490409b + ", frameLayout=" + this.f490410c + ", liveInfo=" + this.f490411d + ", passThroughLogData=" + this.f490412e + ", ecomSceneId=" + this.f490413f + ", searchParam=" + this.f490414g + ", floatBottomMargin=" + this.f490415h + ", shopId=" + this.f490416i + ", authorId=" + this.f490417j + ", forceNotSharedLiveClient=" + this.f490418k + ")";
    }

    public final Context getContext() {
        return this.f490408a;
    }

    public o(Context r100, DialogFragment r101, FrameLayout r102, StoreV3LiveRoomVO r103, String r104, String r105, int r106, String r107) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f490408a = r100;
        this.f490409b = r101;
        this.f490410c = r102;
        this.f490411d = r103;
        this.f490412e = r104;
        this.f490413f = "1003";
        this.f490414g = r105;
        this.f490415h = r106;
        this.f490416i = r107;
        this.f490417j = null;
        this.f490418k = false;
    }
}
