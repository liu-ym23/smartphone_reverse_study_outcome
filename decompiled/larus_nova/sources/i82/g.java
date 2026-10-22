package i82;

import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.annie.util.p;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.LiveRoundImageView;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.CustomSmoothScroller;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardSkinViewHolder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import com.ss.ugc.effectplatform.util.r;
import fq1.s;
import fq1.t;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends f<VSMsgBoardDress, VSMsgBoardSkinViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f488596c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f488597d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RecyclerView f488598e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.msgboard.a f488599f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final k82.a f488600g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final i f488601h;

    public static final class a {
    }

    static {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r110) {
        VSMsgBoardSkinViewHolder r101 = (VSMsgBoardSkinViewHolder) r100;
        VSMsgBoardDress r111 = (VSMsgBoardDress) r110;
        Intrinsics.checkNotNullParameter(r101, "holder");
        Intrinsics.checkNotNullParameter(r111, "itemData");
        View r102 = r101.itemView;
        Intrinsics.checkNotNullParameter(r102, "view");
        Intrinsics.checkNotNullParameter(r111, "itemData");
        r102.post(new e(this, r111, r102));
        UtilityKotlinExtentionsKt.z(r101.f137215a, !r111.isFree());
        a1.o(r101.f137216b, r111.getDressImage(), ImageView.ScaleType.CENTER_CROP);
        LiveRoundImageView r103 = r101.f137217c;
        s r104 = t.a();
        if (r104 == null) goto L5;
        k r105 = r104.h();
    L6:
        a1.y(r103, r105, R.drawable.ttlive_vs_bg_skin_item_head_default, n82.c.k("1F161823", -1), p.f40070a.a(1.5f));
        TextView r106 = r101.f137218d;
        String r107 = t.a().i();
        if (r107 != null) goto L9;
        r107 = "昵称";
    L9:
        r106.setText(r107);
        LiveRoundImageView r108 = r101.f137217c;
        boolean r109 = false;
        if (r108 != null) goto L12;
    L16:
        TextView r112 = r101.f137218d;
        if (r112 != null) goto L19;
    L22:
        TextView r113 = r101.f137219e;
        int r114 = r.f458047a;
        if (r.b(r111.getDressName()) == true) goto L25;
        String r115 = r111.getDressName();
    L26:
        r113.setText(r115);
        boolean r116 = String.valueOf(r111.getDressId()).equals(this.f488596c);
        if (r116 == true) goto L29;
    L31:
        UtilityKotlinExtentionsKt.z(r101.f137220f, r116);
        r101.itemView.setOnTouchListener(new h(this, r116, r111, r101));
        r101.itemView.getWidth();
        return;
    L29:
        if (this.f488597d == true) goto L31;
        j(10, r101, r111);
        this.f488597d = true;
        goto L31
    L25:
        r115 = "默认";
        goto L26
    L19:
        if (r111.getDressId() <= 0) goto L21;
        r109 = true;
    L21:
        UtilityKotlinExtentionsKt.z(r112, r109);
        goto L22
    L12:
        if (r111.getDressId() <= 0) goto L14;
        boolean r117 = true;
    L15:
        UtilityKotlinExtentionsKt.z(r108, r117);
        goto L16
    L14:
        r117 = false;
        goto L15
    L5:
        r105 = null;
        goto L6
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r102 = n82.c.f518247a;
        k82.a r103 = this.f488600g;
        Boolean r104 = null;
        if (r103 == null) goto L7;
        t9 r105 = r103.s();
        if (r105 == null) goto L7;
        DataCenter r106 = r105.f114228l;
    L8:
        k82.a r107 = this.f488600g;
        if (r107 == null) goto L13;
        t9 r108 = r107.s();
        if (r108 == null) goto L13;
        r104 = Boolean.valueOf(r108.f114232p);
    L13:
        String r109 = n82.c.h(r106, r104);
        this.f488596c = r109;
        if (r.b(r109) == false) goto L17;
        this.f488596c = String.valueOf(0);
    L17:
        return new VSMsgBoardSkinViewHolder(r100.inflate(R.layout.ttlive_section_vs_msg_board_skin_item, r101, false));
    L7:
        r106 = null;
        goto L8
    }

    @Override // i82.f
    public final void i(View r100, VSMsgBoardDress r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "itemData");
        int r102 = l82.a.f507909a;
        int r103 = n82.c.f518247a;
        String r104 = String.valueOf(r101.getDressId());
        k82.a r105 = this.f488600g;
        Map<String, String> r106 = null;
        if (r105 == null) goto L7;
        t9 r107 = r105.s();
        if (r107 == null) goto L7;
        DataCenter r108 = r107.f114228l;
    L8:
        boolean r109 = n82.c.a(r104, r108);
        if (r101.getPaidType() == 1) goto L11;
        boolean r110 = true;
    L12:
        k82.a r111 = this.f488600g;
        if (r111 == null) goto L15;
        r106 = r111.o();
        r106.put("vs_skin_id", String.valueOf(r101.getDressId()));
        Unit r112 = Unit.INSTANCE;
    L15:
        l82.a.d(r109, true, r110, r106);
        return;
    L11:
        r110 = false;
    L7:
        r108 = null;
        goto L8
    }

    public final void j(long r100, VSMsgBoardSkinViewHolder r101, VSMsgBoardDress r102) {
        View r103 = r101.itemView;
        Rect r104 = new Rect();
        r103.getGlobalVisibleRect(r104);
        RecyclerView r105 = this.f488598e;
        if (r105 == null) goto L5;
        int r106 = r105.getWidth();
    L6:
        RecyclerView r107 = this.f488598e;
        if (r107 == null) goto L9;
        int r108 = r107.getHeight();
    L11:
        if (r104.contains(0, 0, r106, r108) == true) goto L19;
        int r109 = h(r102);
        RecyclerView r110 = this.f488598e;
        if (r110 == null) goto L20;
        RecyclerView.LayoutManager r111 = r110.getLayoutManager();
        if (r111 == null) goto L21;
        CustomSmoothScroller r112 = new CustomSmoothScroller(this.f488598e.getContext());
        r112.f137210a = r100;
        r112.setTargetPosition(r109);
        r111.startSmoothScroll(r112);
        return;
    L21:
        return;
    L20:
        return;
    L19:
        return;
    L9:
        r108 = 0;
        goto L11
    L5:
        r106 = 0;
        goto L6
    }

    public g(OverScrollRecyclerView r100, com.bytedance.android.livesdk.chatroom.msgboard.a r101, h82.b r102, i r103) {
        this.f488598e = r100;
        this.f488599f = r101;
        this.f488600g = r102;
        this.f488601h = r103;
        this.f488596c = "";
    }
}
