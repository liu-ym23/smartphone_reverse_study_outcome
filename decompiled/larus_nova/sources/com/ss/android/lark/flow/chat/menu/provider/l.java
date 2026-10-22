package com.ss.android.lark.flow.chat.menu.provider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larus.nova.R;
import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import com.ss.android.lark.chat.message.menu.provider.DeleteActionProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class l extends DeleteActionProvider {

    public static final class a implements yya.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final yya.i f422261a;

        @Override // yya.i
        public final Map<String, Object> R4() {
            return this.f422261a.R4();
        }

        @Override // yya.i
        public final void b(View r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            this.f422261a.b(r100, r101);
        }

        @Override // yya.i
        public final boolean c() {
            return this.f422261a.c();
        }

        @Override // yya.i
        public final void d(com.ss.android.lark.chat.message.menu.c r100) {
            Intrinsics.checkNotNullParameter(r100, "actionControl");
            this.f422261a.d(r100);
        }

        @Override // yya.i
        public final boolean f() {
            return this.f422261a.f();
        }

        @Override // yya.i
        public final s5c.d g() {
            return this.f422261a.g();
        }

        @Override // yya.i
        public final String getLabel(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f422261a.getLabel(r100);
        }

        @Override // yya.i
        public MessageActionType getType() {
            return this.f422261a.getType();
        }

        @Override // yya.i
        public final View getView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return this.f422261a.getView(r100);
        }

        @Override // yya.i
        public final boolean isEnable() {
            return this.f422261a.isEnable();
        }

        @Override // yya.i
        public final boolean isVisible() {
            return this.f422261a.isVisible();
        }

        @Override // yya.i
        public final void onHide() {
            this.f422261a.onHide();
        }

        @Override // yya.i
        public final void onShow() {
            this.f422261a.onShow();
        }

        @Override // yya.i
        public final Integer e() {
            return Integer.valueOf(R.color.flow_ud_conditional_danger_50);
        }

        public a(DeleteActionProvider.b r100) {
            Intrinsics.checkNotNullParameter(r100, "superAction");
            this.f422261a = r100;
        }

        @Override // yya.i
        public final Drawable getIcon(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            return UDIconUtils.getIconDrawable(r100, R.drawable.flow_ud_ic_trash, UDColorUtils.getColor(r100, R.color.chat_operation_item_color_selector));
        }
    }

    public l() {
    }

    @Override // yya.m
    public final yya.i c(yya.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        Intrinsics.checkNotNullParameter(r100, "actionContext");
        return new a(new DeleteActionProvider.b(r100));
    }
}
