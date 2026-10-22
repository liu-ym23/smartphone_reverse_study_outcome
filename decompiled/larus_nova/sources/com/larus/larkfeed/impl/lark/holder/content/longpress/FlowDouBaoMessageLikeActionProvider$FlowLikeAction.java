package com.larus.larkfeed.impl.lark.holder.content.longpress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larus.common.apphost.AppHost;
import com.larus.feedback.api.FlowFeedbackServiceDelegate;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class FlowDouBaoMessageLikeActionProvider$FlowLikeAction implements yya.i {
    @Override // yya.i
    public final Map<String, Object> R4() {
        return null;
    }

    @Override // yya.i
    public final boolean c() {
        return false;
    }

    @Override // yya.i
    public final Integer e() {
        return null;
    }

    @Override // yya.i
    public final s5c.d g() {
        return null;
    }

    @Override // yya.i
    public final boolean isEnable() {
        return true;
    }

    @Override // yya.i
    public final void onHide() {
    }

    @Override // yya.i
    public final void onShow() {
    }

    @Override // yya.i
    public final boolean f() {
        throw null;
    }

    @Override // yya.i
    public MessageActionType getType() {
        return MessageActionType.FLOW_LIKE;
    }

    @Override // yya.i
    public final boolean isVisible() {
        throw null;
    }

    @Override // yya.i
    public final void d(com.ss.android.lark.chat.message.menu.c r100) {
        Intrinsics.checkNotNullParameter(r100, "actionControl");
    }

    @Override // yya.i
    public final Drawable getIcon(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        throw null;
    }

    @Override // yya.i
    public final String getLabel(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return AppHost.f326268a.getApplication().getString(R.string.larus_message_long_press_like);
    }

    @Override // yya.i
    public final View getView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return null;
    }

    public static final void a(FlowDouBaoMessageLikeActionProvider$FlowLikeAction r110, yc9.m r111) {
        r110.getClass();
        FlowFeedbackServiceDelegate r112 = FlowFeedbackServiceDelegate.f343027a;
        List<Integer> r100 = r111.f567268e;
        if (r100 != null) goto L5;
        r100 = CollectionsKt.listOf(Integer.valueOf(r111.f567267d));
    L5:
        r112.g(new q99.m(yc9.m.a(r111, r100), 9, null, null, null, null, null, 124), new w());
    }

    @Override // yya.i
    public final void b(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        throw null;
    }
}
