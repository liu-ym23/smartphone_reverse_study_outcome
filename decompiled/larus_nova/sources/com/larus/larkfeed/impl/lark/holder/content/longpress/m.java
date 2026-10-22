package com.larus.larkfeed.impl.lark.holder.content.longpress;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.im.bean.message.Message;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.PageType;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class m extends FlowDouBaoBlockTypeActionProvider {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f355385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MessageActionType f355386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f355387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f355388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f355389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<c, Boolean> f355390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function4<View, yya.a, c, Message, Unit> f355391i;

    public static final class a implements yya.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f355392a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ yya.a f355393b;

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
        public final boolean f() {
            return false;
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
        public MessageActionType getType() {
            return this.f355392a.f355386d;
        }

        @Override // yya.i
        public final boolean isVisible() {
            c r100 = DouBaoMenuPayloadStore.f355360a.a(this.f355393b);
            if (r100 != null) goto L6;
            return false;
        L6:
            if (this.f355392a.f355390h.invoke(r100).booleanValue() == false) goto L9;
            this.f355392a.d(this.f355393b);
            return true;
        L9:
            return false;
        }

        @Override // yya.i
        public final void d(com.ss.android.lark.chat.message.menu.c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
        }

        @Override // yya.i
        public final Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            m r101 = this.f355392a;
            return UDIconUtils.getIconDrawable(r100, v19.c.b(r101.f355388f, r100, r101.f355389g), UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        }

        @Override // yya.i
        public final String getLabel(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return r100.getString(this.f355392a.f355387e);
        }

        @Override // yya.i
        public final View getView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return null;
        }

        public a(m r100, yya.a r101) {
            this.f355392a = r100;
            this.f355393b = r101;
        }

        @Override // yya.i
        public final void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            c r102 = DouBaoMenuPayloadStore.f355360a.a(this.f355393b);
            if (r102 != null) goto L5;
            return;
        L5:
            m r103 = this.f355392a;
            yya.a r104 = this.f355393b;
            r103.getClass();
            Message r105 = FlowDouBaoBlockTypeActionProvider.e(r104);
            if (r105 != null) goto L8;
            return;
        L8:
            this.f355392a.f355391i.invoke(r100, this.f355393b, r102, r105);
        }
    }

    @Override // yya.b
    public final List<PageType> b() {
        return CollectionsKt.listOf(new PageType[]{PageType.CHAT_WINDOW, PageType.REPLY_IN_THREAD});
    }

    @Override // yya.b
    public final String getTAG() {
        return this.f355385c;
    }

    @Override // yya.m
    public final yya.i c(yya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        return new a(this, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public m(String r100, MessageActionType r101, int r102, int r103, int r104, Function1<? super c, Boolean> r105, Function4<? super View, ? super yya.a, ? super c, ? super Message, Unit> r106) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "targetType");
        Intrinsics.checkNotNullParameter(r105, "payloadMatcher");
        Intrinsics.checkNotNullParameter(r106, "clickHandler");
        this.f355385c = r100;
        this.f355386d = r101;
        this.f355387e = r102;
        this.f355388f = r103;
        this.f355389g = r104;
        this.f355390h = r105;
        this.f355391i = r106;
    }
}
