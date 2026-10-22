package g7b;

import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.chat.base.view.vo.message.BaseTextContentVO;
import com.ss.android.lark.chat.base.view.vo.message.PostContentVO;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.h;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.q;
import com.ss.android.lark.chat.chatwindow.chat.menu.handler.v;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f480358f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f480359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final m2b.a f480360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y6b.a<BaseTextContentVO<?>> f480361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h<BaseTextContentVO<?>> f480362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public BasePopupWindow f480363e;

    /* JADX INFO: renamed from: g7b.a$a, reason: collision with other inner class name */
    public static final class C5992a {
    }

    static {
    }

    public final void a() {
        View r100 = LayoutInflater.from(this.f480359a.getContext()).inflate(R.layout.chat_message_menu, null);
        View r101 = r100.findViewById(R.id.copy);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.widget.TextView");
        TextView r102 = (TextView) r101;
        BasePopupWindow r103 = new BasePopupWindow(r100, -2, -2, true);
        r103.setTouchable(true);
        r103.setOutsideTouchable(true);
        r103.setFocusable(false);
        r103.setBackgroundDrawable(new BitmapDrawable());
        r100.measure(0, 0);
        int[] r104 = this.f480360b.J8();
        if (r104 != null) goto L5;
        return;
    L5:
        View r110 = this.f480359a;
        int r111 = r104[2];
        int r105 = r104[0] - r100.getMeasuredHeight();
        if (PopupWindowLancet.hasSubWindowToken(r110) == false) goto L9;
    L15:
        r102.setOnClickListener(new b(this, r103));
        r103.setOnDismissListener(c.f480366a);
        this.f480363e = r103;
        return;
    L9:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r103) == false) goto L11;
        r103.showAtLocation(r110, 0, r111, r105);
        goto L15
    L11:
        OverlaySource r112 = PopupWindowLancet.resolveSource(r110);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r103, r110, r112, 0, r111, r105) == true) goto L15;
        r103.showAtLocation(r110, 0, r111, r105);
        PopupWindowLancet.trackAfterShow(r103, r112, r110);
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a(View r100, m2b.a r101, y6b.a r102) {
        this.f480359a = r100;
        this.f480360b = r101;
        this.f480361c = r102;
        if ((((BaseTextContentVO) r102.b()) instanceof PostContentVO) == false) goto L5;
        h<BaseTextContentVO<?>> r103 = new q(r100.getContext());
    L6:
        this.f480362d = r103;
        return;
    L5:
        r103 = new v(r100.getContext());
        goto L6
    }
}
