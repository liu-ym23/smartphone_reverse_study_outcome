package f10;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcastgame.api.model.InteractEntranceCell;
import com.bytedance.android.live.broadcastgame.api.model.k0;
import com.bytedance.android.live.broadcastgame.api.model.v;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.ExtendedToolbarButton;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.g3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.h3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.x3;
import com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.y3;
import com.bytedance.android.livesdk.config.ud0;
import com.bytedance.android.livesdkapi.depend.model.broadcast.CommonDot;
import com.bytedance.android.livesdkapi.depend.model.broadcast.InteractionItemDotInfo;
import com.bytedance.android.livesdkapi.depend.model.broadcast.ItemDotInfo;
import com.larus.nova.R;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f extends ExtendedToolbarButton.c {
    public boolean A;
    public int B;
    public CharSequence C;
    public InteractEntranceCell D;
    public final List<v> E;
    public k0 F;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f475042t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f475043u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f475044v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f475045w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f475046x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f475047y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final ItemDotInfo f475048z;

    public final String h() {
        ItemDotInfo r100 = this.f475048z;
        if (r100 == null) goto L7;
        CommonDot r101 = r100.getDot();
        if (r101 == null) goto L7;
        return String.valueOf(r101.getId());
    L7:
        return null;
    }

    public final boolean k() {
        boolean r100 = true;
        if (this.f115636r == true) goto L25;
        g3 r101 = null;
        if (this.f475048z == null) goto L11;
        ((IBroadcastService) va1.b.a.f553922a.a(IBroadcastService.class)).getBroadcastDotManager();
        ItemDotInfo r102 = this.f475048z;
        if (r102 == null) goto L24;
        r102.getDot();
        throw null;
    L24:
        throw null;
    L11:
        g3 r103 = y3.e();
        if ((r103 instanceof x3) == false) goto L15;
        r101 = r103;
    L15:
        if (r101 == null) goto L21;
        c0.b r104 = r101.s(this);
        if (r104 == null) goto L21;
        if (r104.showRedDot() != true) goto L21;
    L23:
        return r100;
    L21:
        r100 = false;
        goto L23
    L25:
        return !h3.a(this.f115635q);
    }

    public final boolean j() {
        g3 r100 = y3.e();
        if ((r100 instanceof x3) == true) goto L5;
        r100 = null;
    L5:
        if (r100 != null) goto L9;
        return false;
    L9:
        return r100.x(this);
    }

    public final String i(boolean r100) {
        String r101 = this.f115635q;
        if (r100 == true) goto L5;
        return r101;
    L5:
        if (r101.length() >= (this.f475047y + 1)) goto L7;
        return r101;
    L7:
        return r101.substring(0, this.f475047y) + "...";
    }

    public f(List r100, String r101, boolean r102, String r103, CharSequence r104, InteractEntranceCell r105, List r106, k0 r107) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "title");
        Intrinsics.checkNotNullParameter(r103, "id");
        Intrinsics.checkNotNullParameter(r104, "summary");
        Intrinsics.checkNotNullParameter(r105, "targetEntranceCell");
        super(r100, r101, r102, r103);
        this.C = r104;
        this.D = r105;
        this.E = r106;
        this.F = r107;
        this.f475042t = true;
        this.f475045w = "";
        this.f475046x = 1;
        if (ud0.f121363a.getValue().booleanValue() == false) goto L5;
        int r108 = 5;
    L6:
        this.f475047y = r108;
        this.A = true;
        this.B = -1;
        this.f115627i = R.drawable.ttlive_open_feature_icon_default;
        String r109 = this.D.extra;     // Catch: Exception -> L20
        if (r109 != null) goto L10;
        return;
    L10:
        if (r109.length() <= 0) goto L12;
        boolean r110 = true;
    L13:
        if (r110 != true) goto L24;
        InteractionItemDotInfo r111 = (InteractionItemDotInfo) GsonHelper.get().fromJson(this.D.extra, InteractionItemDotInfo.class);     // Catch: Exception -> L20
        if (r111 == null) goto L17;
        ItemDotInfo r112 = r111.getItemDot();     // Catch: Exception -> L20
    L18:
        this.f475048z = r112;     // Catch: Exception -> L20
        return;
    L17:
        r112 = null;
        goto L18
    L24:
        return;
    L12:
        r110 = false;
    L25:
        return;
    L5:
        r108 = 4;
        goto L6
    }
}
