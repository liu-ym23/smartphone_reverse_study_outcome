package yca;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.chat.api.q0;
import com.larus.bmhome.view.ChatMessageList;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.card.databinding.ObricCardMenuBinding;
import com.obric.assistant.remote_card_container.widget.RemoteCardContainer;
import com.skydoves.balloon.Balloon;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import z19.j;

/* JADX INFO: loaded from: classes32.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f567291a = null;

    public interface a {
        void dismiss();
    }

    static {
        f567291a = new d();
    }

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v16, types: [android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r0v41 */
    /* JADX WARN: Type inference failed for: r0v7, types: [T, com.skydoves.balloon.Balloon] */
    /* JADX WARN: Type inference failed for: r19v0, types: [android.view.View, com.obric.assistant.remote_card_container.widget.RemoteCardContainer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v1, types: [yca.a] */
    public static e a(d r110, RemoteCardContainer r111, final q0 r210, List r211, final com.obric.assistant.remote_card_container.b r212, final com.obric.assistant.remote_card_container.c r213) {
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "longClickView");
        Intrinsics.checkNotNullParameter(r211, "items");
        Intrinsics.checkNotNullParameter(r212, "onItemSelectedListener");
        Intrinsics.checkNotNullParameter(r213, "onMenuDismiss");
        if (r210 != null) goto L5;
        FLogger.f375446a.i("MenuHelper", "showMenu: adapter is null");
        return null;
    L5:
        ArrayList r100 = (ArrayList) r211;
        if (r100.isEmpty() == false) goto L8;
        FLogger.f375446a.w("MenuHelper", "showMenu: items is empty");
        return null;
    L8:
        final Ref.ObjectRef r112 = new Ref.ObjectRef();
        Context r101 = r111.getContext();
        final ?? r102 = new yca.a(r112, r212);
        LayoutInflater r103 = LayoutInflater.from(r101);
        boolean r113 = false;
        View r104 = r103.inflate(R.layout.obric_card_menu, null, false);
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r104, R.id.item_container);
        if (r105 == null) goto L74;
        RelativeLayout r106 = (RelativeLayout) r104;
        ObricCardMenuBinding r107 = new ObricCardMenuBinding(r106, r105, r106);
        r106.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        Iterator r108 = r211.iterator();
        final int r109 = 0;
    L12:
        if (r108.hasNext() == false) goto L37;
        Object r114 = r108.next();
        int r115 = r109 + 1;
        if (r109 >= 0) goto L16;
        CollectionsKt.throwIndexOverflow();
    L16:
        String r116 = (String) r114;
        LinearLayout r117 = r107.f386187b;
        View r118 = r103.inflate(R.layout.obric_card_menu_item, r117, r113);
        r117.addView(r118);
        RelativeLayout r119 = (RelativeLayout) r118;
        TextView r120 = (TextView) ViewBindings.findChildViewById(r118, R.id.tv);
        if (r120 == null) goto L36;
        Iterator r121 = r108;
        if (r100.size() != 1) goto L21;
        int r122 = R.drawable.larus_bg_common_menu_item_single;
    L27:
        r119.setBackgroundResource(r122);
        r120.setText(r116);
        r119.setOnClickListener(new c(r102, r109));
        if (r109 == (r100.size() - 1)) goto L34;
        LinearLayout r123 = r107.f386187b;
        f567291a.getClass();
        Drawable r124 = ContextCompat.getDrawable(r101, R.drawable.larus_common_menu_divider);
        if (r124 == null) goto L32;
        int r125 = r124.getIntrinsicHeight();
    L33:
        View r126 = new View(r101);
        r126.setBackground(r124);
        r126.setLayoutParams(new LinearLayoutCompat.LayoutParams(-1, r125));
        r123.addView(r126);
        goto L34
    L32:
        r125 = 1;
    L34:
        r109 = r115;
        r108 = r121;
        r113 = false;
        goto L12
    L21:
        if (r109 != 0) goto L24;
        r122 = R.drawable.larus_bg_common_menu_item_first;
        goto L27
    L24:
        if (r109 != (r100.size() - 1)) goto L26;
        r122 = R.drawable.larus_bg_common_menu_item_last;
        goto L27
    L26:
        r122 = R.drawable.larus_bg_common_menu_item_middle;
        goto L27
    L36:
        throw new NullPointerException("Missing required view with ID: ".concat(r118.getResources().getResourceName(R.id.tv)));
    L37:
        RelativeLayout r127 = r107.f386188c;
        final ViewGroup r128 = null;
        r112.element = com.larus.bmhome.view.screenmenu.d.a(com.larus.bmhome.view.screenmenu.d.f317270a, r111, r127, false, null, null, null, new b(r213, r210, r128), 60);
        if ((r111 instanceof j) == false) goto L40;
        j r129 = (j) r111;
    L50:
        if (r129 == null) goto L54;
        Float r130 = r129.getLastMotionX();
        if (r130 == null) goto L54;
        int r131 = (int) r130.floatValue();
    L55:
        if (r129 == null) goto L59;
        Float r132 = r129.getLastMotionY();
        if (r132 == null) goto L59;
        int r133 = (int) r132.floatValue();
    L61:
        if (Build.VERSION.SDK_INT >= 26) goto L67;
        Balloon r134 = (Balloon) r112.element;
        ChatMessageList r135 = r210.B7();
        if (r135 == null) goto L65;
        Point r136 = e1.n(r111, r135);
        int r137 = 0;
        r127.measure(0, 0);
        r133 = Math.max(r127.getMeasuredHeight() - r136.y, r133);
    L66:
        r134.v(r111, r137, r133);
    L68:
        ChatMessageList r138 = r210.B7();
        if (r138 == null) goto L72;
        r138.requestDisallowInterceptTouchEvent(true);
    L72:
        return new e(r112);
    L65:
        r137 = 0;
        goto L66
    L67:
        ((Balloon) r112.element).v(r111, r131, r133);
    L59:
        r133 = r111.getHeight() / 2;
    L54:
        r131 = r111.getWidth() / 2;
        goto L55
    L40:
        ViewParent r139 = r111.getParent();
        if ((r139 instanceof ViewGroup) == false) goto L43;
        ?? r140 = (ViewGroup) r139;
    L44:
        if (r140 == 0) goto L49;
        if ((r140 instanceof j) == true) goto L47;
        ViewParent r141 = r140.getParent();
        Intrinsics.checkNotNull(r141, "null cannot be cast to non-null type android.view.ViewGroup");
        r140 = (ViewGroup) r141;
        goto L44
    L47:
        r129 = (j) r140;
        goto L50
    L49:
        r129 = null;
        goto L50
    L43:
        r140 = 0;
        goto L44
    L74:
        throw new NullPointerException("Missing required view with ID: ".concat(r104.getResources().getResourceName(R.id.item_container)));
    }
}
