package i82;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.OverScrollRecyclerView;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.android.livesdk.chatroom.ui.t9;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.CustomSmoothScroller;
import com.bytedance.android.livesdk.interactivity.interactive.dialog.adapter.VSMsgBoardBadgeViewHolder;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends f<VSMsgBoardDress, VSMsgBoardBadgeViewHolder> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f488580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f488581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f488582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final k82.a f488583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OverScrollRecyclerView f488584g;

    /* JADX INFO: renamed from: i82.a$a, reason: collision with other inner class name */
    public static final class C6240a {
    }

    static {
    }

    @Override // me.drakeet.multitype.b
    public final void b(RecyclerView.ViewHolder r100, Object r101) {
        VSMsgBoardBadgeViewHolder r102 = (VSMsgBoardBadgeViewHolder) r100;
        VSMsgBoardDress r103 = (VSMsgBoardDress) r101;
        Intrinsics.checkNotNullParameter(r102, "holder");
        Intrinsics.checkNotNullParameter(r103, "itemData");
        if (this.f513439a.getItemCount() != 0) goto L5;
        return;
    L5:
        if (r102.getAdapterPosition() == (-1)) goto L19;
        View r104 = r102.itemView;
        Intrinsics.checkNotNullParameter(r104, "view");
        Intrinsics.checkNotNullParameter(r103, "itemData");
        r104.post(new e(this, r103, r104));
        UtilityKotlinExtentionsKt.z(r102.f137211a, !r103.isFree());
        a1.o(r102.f137212b, r103.getDressImage(), ImageView.ScaleType.CENTER_CROP);
        TextView r105 = r102.f137213c;
        if (TextUtils.isEmpty(r103.getDressName()) == true) goto L10;
        String r106 = r103.getDressName();
    L11:
        r105.setText(r106);
        boolean r107 = String.valueOf(r103.getDressId()).equals(this.f488580c);
        if (r107 == true) goto L14;
    L16:
        UtilityKotlinExtentionsKt.z(r102.f137214d, r107);
        r102.itemView.setOnTouchListener(new c(this, r107, r103, r102));
        r102.itemView.getWidth();
        return;
    L14:
        if (this.f488581d == true) goto L16;
        r102.itemView.post(new b(this, r102, r103));
        this.f488581d = true;
        goto L16
    L10:
        r106 = "默认";
        goto L11
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        int r102 = n82.c.f518247a;
        k82.a r103 = this.f488583f;
        Boolean r104 = null;
        if (r103 == null) goto L7;
        t9 r105 = r103.s();
        if (r105 == null) goto L7;
        DataCenter r106 = r105.f114228l;
    L8:
        k82.a r107 = this.f488583f;
        if (r107 == null) goto L13;
        t9 r108 = r107.s();
        if (r108 == null) goto L13;
        r104 = Boolean.valueOf(r108.f114232p);
    L13:
        String r109 = n82.c.g(r106, r104);
        this.f488580c = r109;
        if (TextUtils.isEmpty(r109) == false) goto L17;
        this.f488580c = String.valueOf(0);
    L17:
        return new VSMsgBoardBadgeViewHolder(r100.inflate(R.layout.ttlive_section_vs_msg_board_badge_item, r101, false));
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
        k82.a r105 = this.f488583f;
        Map<String, String> r106 = null;
        if (r105 == null) goto L7;
        t9 r107 = r105.s();
        if (r107 == null) goto L7;
        DataCenter r108 = r107.f114228l;
    L8:
        boolean r109 = n82.c.a(r104, r108);
        boolean r110 = true;
        if (r101.getPaidType() != 1) goto L12;
        r110 = false;
    L12:
        k82.a r111 = this.f488583f;
        if (r111 == null) goto L15;
        r106 = r111.o();
        r106.put("vs_medal_id", String.valueOf(r101.getDressId()));
        Unit r112 = Unit.INSTANCE;
    L15:
        l82.a.d(r109, false, r110, r106);
        return;
    L7:
        r108 = null;
        goto L8
    }

    public a(d r100, h82.b r101, OverScrollRecyclerView r102) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f488582e = r100;
        this.f488583f = r101;
        this.f488584g = r102;
        this.f488580c = "";
    }

    public static final void j(a r100, long r101, VSMsgBoardBadgeViewHolder r102, VSMsgBoardDress r103) {
        if (r100.f513439a.getItemCount() != 0) goto L5;
        return;
    L5:
        if (r102.getAdapterPosition() == (-1)) goto L38;
        int r104 = r100.h(r103);
        if (r104 >= 0) goto L10;
        return;
    L10:
        if (r104 >= r100.f513439a.getItemCount()) goto L39;
        View r105 = r102.itemView;
        Rect r106 = new Rect();
        r105.getGlobalVisibleRect(r106);
        OverScrollRecyclerView r107 = r100.f488584g;
        if (r107 == null) goto L15;
        int r108 = r107.getWidth();
    L16:
        OverScrollRecyclerView r109 = r100.f488584g;
        if (r109 == null) goto L19;
        int r110 = r109.getHeight();
    L21:
        if (r106.contains(0, 0, r108, r110) == true) goto L35;
        OverScrollRecyclerView r111 = r100.f488584g;
        if (r111 == null) goto L36;
        RecyclerView.LayoutManager r112 = r111.getLayoutManager();
        if (r112 == null) goto L40;
        if (r104 >= 0) goto L29;
        return;
    L29:
        if (r104 >= r100.f513439a.getItemCount()) goto L41;
        CustomSmoothScroller r113 = new CustomSmoothScroller(r100.f488584g.getContext());
        r113.f137210a = r101;
        r113.setTargetPosition(r104);
        r112.startSmoothScroll(r113);
        return;
    L41:
        return;
    L40:
        return;
    L36:
        return;
    L35:
        return;
    L19:
        r110 = 0;
        goto L21
    L15:
        r108 = 0;
        goto L16
    L39:
        return;
    }
}
