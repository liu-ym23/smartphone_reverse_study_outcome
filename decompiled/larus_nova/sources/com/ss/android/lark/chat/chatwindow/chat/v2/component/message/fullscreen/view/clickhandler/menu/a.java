package com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu;

import android.content.Context;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larksuite.framework.ui.BasePopupWindow;
import com.larus.nova.R;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.chat.message.menu.MessageActionManager;
import com.ss.android.lark.chat.message.menu.v2.NormalMessageActionListConfig;
import com.ss.android.lark.chat.message.menu.v2.adapter.binder.MessageActionAdapter;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import f4b.d;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import zya.e;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f414108a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Function0<Unit> f414109b;

    /* JADX INFO: renamed from: com.ss.android.lark.chat.chatwindow.chat.v2.component.message.fullscreen.view.clickhandler.menu.a$a, reason: collision with other inner class name */
    public static final class C4833a {
    }

    static {
    }

    public final BasePopupWindow a() {
        d r100 = this.f414108a;
        if (r100 == null) goto L29;
        List r101 = (List) FullFetchMessageActionConfig.f414105b.getValue();
        if (r101.isEmpty() == false) goto L7;
        Log.e("FullActionPanelManager", "no actions for message " + r100.f475586e.f475581b.getId());
        return null;
    L7:
        final com.ss.android.lark.chat.message.menu.d r102 = MessageActionManager.a(r100, r101, new c(r100));
        Log.i("FullActionPanelManager", "action panel popup for message " + r100.f475586e.f475581b.getId());
        Context r103 = r100.f475585d;
        Function0<List<? extends e>> r104 = new FullActionPanelManager$popup$1$1(r102);
        View r105 = LayoutInflater.from(r103).inflate(R.layout.layout_message_full_action, null, false);
        RecyclerView r106 = (RecyclerView) r105.findViewById(R.id.partial_message_action_rv);
        MessageActionAdapter r107 = new MessageActionAdapter();
        r107.z2(new b(this));
        r106.setLayoutManager(new LinearLayoutManager(r103));
        r106.setAdapter(r107);
        List<? extends e> r108 = r104.invoke();
        r107.resetAll(r108);
        ActionPanelUIUtil r109 = new ActionPanelUIUtil(r103);
        Intrinsics.checkNotNull(r106);
        Intrinsics.checkNotNull(r105);
        ActionPanelUIUtil.a r110 = new ActionPanelUIUtil.a(r106, r105);
        Intrinsics.checkNotNullParameter(r108, "updateList");
        Intrinsics.checkNotNullParameter(r110, "uiViews");
        Iterator<T> r111 = r108.iterator();
        float r112 = 0.0f;
    L9:
        if (r111.hasNext() == false) goto L13;
        e r113 = (e) r111.next();
        if ((r113 instanceof zya.b) == false) goto L9;
        r112 = Math.max(r112, ((TextPaint) r109.f414101b.getValue()).measureText(((zya.b) r113).f573990e));
        goto L9
    L13:
        float r114 = UIHelper.dp2px(64.0f) + r112;
        int r115 = UIHelper.dp2px(136.0f);
        int r116 = UIHelper.dp2px(300.0f);
        if (r114 >= r115) goto L17;
    L20:
        int r117 = View.MeasureSpec.makeMeasureSpec(r115, 1073741824);
        ViewGroup r118 = r110.f414102a;
        r118.measure(r117, 0);
        ViewGroup.LayoutParams r119 = r118.getLayoutParams();
        if (r119 == null) goto L28;
        r119.width = r118.getMeasuredWidth();
        r118.setLayoutParams(r119);
        ViewGroup.LayoutParams r120 = r118.getLayoutParams();
        if (r120 == null) goto L26;
        r120.height = r118.getMeasuredHeight();
        r118.setLayoutParams(r120);
        BasePopupWindow r121 = new BasePopupWindow(r105, -2, -2);
        r121.setTouchable(true);
        r121.setOutsideTouchable(false);
        r121.setFocusable(false);
        r121.setClippingEnabled(false);
        return r121;
    L26:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L28:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    L17:
        if (r114 <= r116) goto L19;
        r115 = r116;
        goto L20
    L19:
        r115 = (int) r114;
        goto L20
    L29:
        return null;
    }

    public a() {
        List<String> r100 = FullFetchMessageActionConfig.f414104a;
        if (FullFetchMessageActionConfig.f414104a != null) goto L7;
        SettingManager.getInstance().get(NormalMessageActionListConfig.class, new FullFetchMessageActionConfig$initConfig$1());
        return;
    }
}
