package qn6;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.dito.core.y;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Window f534103a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<View> f534104b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f534105c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Rect[] f534106d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f534107e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Window.Callback f534108f;

    public c(Window r110, List r111, int r210, String r211, Function0 r212, Function1 r213, y r214, com.bytedance.locallife.biz.mob.a r215, boolean r216, int r217) {
        if ((r217 & 4) == 0) goto L5;
        int r100 = 1;
    L7:
        if ((r217 & 8) == 0) goto L9;
        String r101 = "operation_on_poi_detail";
    L11:
        if ((r217 & 16) == 0) goto L13;
        Function0 r112 = null;
    L15:
        if ((r217 & 32) == 0) goto L17;
        Function1 r113 = null;
    L19:
        if ((r217 & 64) == 0) goto L21;
        y r114 = null;
    L23:
        if ((r217 & 128) == 0) goto L25;
        com.bytedance.locallife.biz.mob.a r115 = null;
    L26:
        int r102 = 0;
        if ((r217 & 256) == 0) goto L29;
        boolean r116 = false;
    L30:
        Intrinsics.checkNotNullParameter(r110, LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNullParameter(r111, "operationViews");
        Intrinsics.checkNotNullParameter(r101, "mobEventName");
        this.f534103a = r110;
        this.f534104b = r111;
        this.f534105c = new a();
        int r103 = r111.size();
        Rect[] r104 = new Rect[r103];
    L31:
        if (r102 >= r103) goto L33;
        r104[r102] = new Rect();
        r102 = r102 + 1;
        goto L31
    L33:
        this.f534106d = r104;
        Window.Callback r105 = this.f534103a.getCallback();     // Catch: Throwable -> L36
        this.f534108f = r105;     // Catch: Throwable -> L36
        this.f534103a.setCallback(new b(r105, this));     // Catch: Throwable -> L36
        a.f(this.f534105c, this.f534103a.getContext(), CollectionsKt.emptyList(), r100, r101, r112, r113, r115, null, r116, r114, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME);     // Catch: Throwable -> L36
        return;
    L36:
        th = move-exception;
        HostServiceUtilsKt.c().a(th);
        return;
    L29:
        r116 = r216;
        goto L30
    L25:
        r115 = r215;
        goto L26
    L21:
        r114 = r214;
        goto L23
    L17:
        r113 = r213;
        goto L19
    L13:
        r112 = r212;
        goto L15
    L9:
        r101 = r211;
        goto L11
    L5:
        r100 = r210;
        goto L7
    }
}
