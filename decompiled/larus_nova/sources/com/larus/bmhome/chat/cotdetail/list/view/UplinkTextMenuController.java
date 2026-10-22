package com.larus.bmhome.chat.cotdetail.list.view;

import android.content.Context;
import android.graphics.Rect;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.MovementMethod;
import android.view.ActionMode;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.chat.cotdetail.list.processor.d;
import com.larus.bmhome.chat.cotdetail.list.processor.e;
import com.larus.bmhome.chat.cotdetail.list.processor.f;
import com.larus.bmhome.chat.layout.holder.helper.s0;
import com.larus.bmhome.interactionpanel.w;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.screenmenu.g;
import com.larus.bmhome.view.screenmenu.l0;
import com.larus.bmhome.view.screenmenu.u0;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatService;
import java.util.List;
import kc8.y;
import ke8.r;
import ke8.s;
import ke8.t;
import ke8.u;
import ke8.v;
import ke8.x;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import oo8.b;
import st8.a;
import v19.c;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
public final class UplinkTextMenuController implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f302052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f302053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f302054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f302055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f302056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f302057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MovementMethod f302058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f302059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public y f302060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f302061j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f302062k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ActionMode f302063l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public x f302064m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public RecyclerView f302065n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ViewTreeObserver f302066o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final s f302067p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Rect f302068q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final UplinkTextMenuController$outsideSelectionTouchListener$1 f302069r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f302070s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f302071t;

    public final boolean d() {
        y r100 = this.f302060i;
        String r101 = null;
        if (r100 == null) goto L5;
        ActivityResultCaller r102 = r100.f502620a;
    L7:
        if ((r102 instanceof fe8.a) == false) goto L9;
        fe8.a r103 = (fe8.a) r102;
    L10:
        if (r103 == null) goto L15;
        w r104 = r103.vF();
        if (r104 == null) goto L15;
        r101 = r104.f312442a;
    L15:
        if (z2.f365865a.enableMessageMenuTimestamp() == true) goto L17;
    L21:
        return false;
    L17:
        if (Intrinsics.areEqual(r101, "thread") == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r101, "organizer") == false) goto L21;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public final void e() {
        ViewTreeObserver r100 = this.f302066o;
        if (r100 != null) goto L5;
    L10:
        this.f302066o = null;
        RecyclerView r101 = this.f302065n;
        if (r101 == null) goto L13;
        r101.removeOnItemTouchListener(this.f302069r);
    L13:
        this.f302065n = null;
        x r102 = this.f302064m;
        if (r102 == null) goto L16;
        this.f302052a.removeCallbacks(r102);
    L16:
        this.f302064m = null;
        ActionMode r103 = this.f302063l;
        this.f302063l = null;
        if (r103 == null) goto L20;
        r103.finish();
    L20:
        if (this.f302062k == false) goto L28;
        this.f302052a.clearFocus();
        CharSequence r104 = this.f302052a.getText();
        if ((r104 instanceof Spannable) == false) goto L24;
        Spannable r105 = (Spannable) r104;
    L25:
        if (r105 == null) goto L27;
        Selection.removeSelection(r105);
    L27:
        this.f302052a.setTextIsSelectable(false);
        this.f302052a.setMovementMethod(this.f302058g);
        goto L28
    L24:
        r105 = null;
    L28:
        this.f302062k = false;
        this.f302052a.setCustomSelectionActionModeCallback(null);
        this.f302052a.setOnLongClickListener(new r(this));
        this.f302052a.setClickable(this.f302054c);
        this.f302052a.setLongClickable(this.f302055d);
        this.f302052a.setFocusable(this.f302056e);
        this.f302052a.setFocusableInTouchMode(this.f302057f);
        return;
    L5:
        if (r100.isAlive() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.removeOnWindowFocusChangeListener(this.f302067p);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.Object, ke8.w] */
    /* JADX WARN: Type inference failed for: r9v1, types: [java.lang.Object, ke8.v] */
    public final boolean f() {
        boolean r100 = false;
        if (d() == true) goto L5;
    L39:
        return false;
    L5:
        if (this.f302062k == true) goto L39;
        CharSequence r101 = this.f302052a.getText();
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == true) goto L39;
        Message r103 = this.f302059h;
        if (r103 != null) goto L18;
        return false;
    L18:
        y r104 = this.f302060i;
        if (r104 == null) goto L39;
        Fragment r105 = r104.f502620a;
        if (r105 == null) goto L39;
        RecyclerView r106 = r104.f502623d;
        if (r106 == null) goto L39;
        final int r107 = this.f302061j;
        int r108 = f.f302020f;
        String r109 = null;
        final f r110 = f.a.a(r105, r103, null);
        final ?? r111 = new v(this, r107, r110);
        final ?? r112 = new ke8.w(this, r107);
        Intrinsics.checkNotNullParameter(r105, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r106, "recyclerView");
        Intrinsics.checkNotNullParameter(this, "anchorView");
        Intrinsics.checkNotNullParameter(r103, "message");
        Intrinsics.checkNotNullParameter(r111, "onSelect");
        Intrinsics.checkNotNullParameter(r112, "onCopy");
        f r113 = f.a.a(r105, r103, null);
        if (r113 == null) goto L38;
        List<? extends ot8.a> r114 = CollectionsKt.listOf(new l0[]{new l0(R.string.larus_message_long_press_select_text, R.string.larus_message_long_press_select_text, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(c.b(R.attr.larus_ic_screen_menu_select, r106.getContext(), R.drawable.larus_ic_screen_menu_select)), null, false, false, null, null, "choose_text", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127), new l0(R.string.larus_message_long_press_copy, R.string.larus_message_long_press_copy, null, null, null, null, null, null, null, false, false, null, Integer.valueOf(c.b(R.attr.larus_ic_screen_menu_copy, r106.getContext(), R.drawable.larus_ic_screen_menu_copy)), null, false, false, null, null, "copy", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, -528388, 127)});
        CommonMenu r115 = new CommonMenu(r106.getContext());
        g.a(r115);
        u0.a(r115, true);
        r115.f317231i = i5.q();
        Long r116 = Long.valueOf(r103.getCreateTime());
        if (r116.longValue() <= 0) goto L32;
        r100 = true;
    L32:
        if (r100 == true) goto L35;
        r116 = null;
    L35:
        if (r116 == null) goto L37;
        r109 = b.a(r116.longValue() * 1000, true);
    L37:
        r115.g(u0.b(r114, true, r109), new d(r111, r112));
        IAIChatService.f365899a.I7(r105, new e.b(r106), this, r103, r115);
        r113.b(r114);
    L38:
        return true;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L13
    }

    @Override // st8.a
    public final float getClickX() {
        return this.f302070s;
    }

    @Override // st8.a
    public final float getClickY() {
        return this.f302071t;
    }

    @Override // st8.a
    public final View l5() {
        return this.f302052a;
    }

    public final boolean b(int r100) {
        if (this.f302061j == r100) goto L5;
    L9:
        return false;
    L5:
        if (this.f302052a.isAttachedToWindow() == false) goto L9;
        if (d() == false) goto L9;
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [ke8.s] */
    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.bmhome.chat.cotdetail.list.view.UplinkTextMenuController$outsideSelectionTouchListener$1] */
    public UplinkTextMenuController(TextView r100, FrameLayout r101) {
        Intrinsics.checkNotNullParameter(r100, "textView");
        Intrinsics.checkNotNullParameter(r101, KtvSubElement.CONTAINER);
        this.f302052a = r100;
        this.f302053b = r101;
        this.f302054c = r100.isClickable();
        boolean r102 = r100.isLongClickable();
        this.f302055d = r102;
        this.f302056e = r100.isFocusable();
        this.f302057f = r100.isFocusableInTouchMode();
        this.f302058g = r100.getMovementMethod();
        this.f302067p = new s(this);
        this.f302068q = new Rect();
        this.f302069r = new UplinkTextMenuController$outsideSelectionTouchListener$1(this);
        r100.setOnLongClickListener(new t(this));
        r100.setLongClickable(r102);
        r100.setOnTouchListener(new u(this));
    }

    public static final void a(UplinkTextMenuController r100, Menu r101) {
        r100.getClass();
        int r102 = r101.size() - 1;
    L3:
        if ((-1) >= r102) goto L10;
        int r103 = r101.getItem(r102).getItemId();
        if (r103 == 16908321) goto L9;
        if (r103 == 16908319) goto L9;
        r101.removeItem(r103);
    L9:
        r102 = r102 - 1;
        goto L3
    }

    public final void c(CharSequence r100, String r101) {
        if (d() == true) goto L5;
        return;
    L5:
        s0 r102 = ILegacyChatUiServiceDelegate.f297164b.X8();
        if (r102 == null) goto L10;
        boolean r103 = r102.f(this.f302052a.getContext(), r100);
        boolean r104 = true;
        if (r103 != true) goto L10;
    L11:
        if (r104 == true) goto L13;
        return;
    L13:
        Message r105 = this.f302059h;
        if (r105 == null) goto L22;
        int r106 = f.f302020f;
        y r107 = this.f302060i;
        if (r107 == null) goto L18;
        Fragment r108 = r107.f502620a;
    L19:
        f r109 = f.a.a(r108, r105, null);
        if (r109 == null) goto L22;
        r109.a("copy", r101);
        goto L22
    L18:
        r108 = null;
    L22:
        t19.s r110 = t19.s.f544207a;
        Context r111 = this.f302052a.getContext();
        r110.getClass();
        t19.s.o(r111, R.string.larus_text_copied_tip, false);
        return;
    L10:
        r104 = false;
        goto L11
    }
}
