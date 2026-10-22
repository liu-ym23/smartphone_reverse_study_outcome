package com.ss.android.lark.keyboard.biz.emoji.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.biz.im.api.extension.chat_window.h;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.event.r;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.keyboard2.m;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import wnb.c;
import wnb.e;

/* JADX INFO: loaded from: classes36.dex */
public final class EmojiTopPlugin implements wnb.b<EmojiTopPlugin> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f428320h = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428321a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428322b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f428323c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RoundedIconTextView f428324d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f428325e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f428326f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f428327g;

    public static final class a implements wnb.b.a<EmojiTopPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ EmojiTopPlugin f428328a;

        public b(EmojiTopPlugin r100) {
            this.f428328a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            m r111 = this.f428328a.f().H().k();
            if (r111 == null) goto L5;
            KeyboardMenuItemKey r112 = r111.g();
        L6:
            KeyboardMenuItemKey r100 = KeyboardMenuItemKey.Emoji;
            if (r112 != r100) goto L9;
            boolean r113 = true;
        L10:
            this.f428328a.f428326f = Boolean.valueOf(!r113);
            EmojiTopPlugin r101 = this.f428328a;
            r101.f428327g = false;
            if (r113 == false) goto L13;
            r101.f().H().h();
        L14:
            int r114 = xob.a.f564691a;
            Context r115 = this.f428328a.f428321a.f410096a.requireContext();
            String r102 = this.f428328a.f428321a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r102), new Pair("click", "reaction_icon"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r115))});
            return;
        L13:
            r101.f().H().f(r100);
            int r116 = xob.a.f564691a;
            Context r117 = this.f428328a.f428321a.f410096a.requireContext();
            String r103 = this.f428328a.f428321a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r117, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r103, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r103), new Pair("click", "input_emoji"), new Pair(PickerReporterConstants.KEY.TARGET, "public_emoji_panel_select_view"), new Pair("keyboard_status", xob.a.a(r117))});
            goto L14
        L9:
            r113 = false;
            goto L10
        L5:
            r112 = null;
            goto L6
        }
    }

    static {
        f428320h = new a();
    }

    @Override // wnb.b
    public final boolean i() {
        return true;
    }

    @Override // wnb.b
    public final View a() {
        KeyboardMenuItemKey r100 = null;
        RoundedIconTextView r101 = new RoundedIconTextView(this.f428321a.f410096a.requireContext(), null, 6, 0);
        this.f428324d = r101;
        r101.setIcon(R.drawable.ic_emoji_btn);
        r101.setText(UIUtils.getString(r101.getContext(), R.string.LarkIM_Dm_Emoji_Button));
        r101.setTextBold(true);
        r101.setInputTopActionCheckedStyle(PluginUtils.c());
        r101.setOnClickListener(new b(this));
        m r102 = f().H().k();
        if (r102 == null) goto L6;
        r100 = r102.g();
    L6:
        if (r100 != KeyboardMenuItemKey.Emoji) goto L8;
        boolean r103 = true;
    L9:
        r101.d(r103, false);
        if (this.f428325e == true) goto L12;
        this.f428325e = true;
        f().e().of(this).d(r.class, new EmojiTopPlugin$getPluginView$pluginView$1$2(this));
        f().e().of(this).c(com.ss.android.lark.keyboard.biz.emoji.a.class, new EmojiTopPlugin$getPluginView$pluginView$1$3(this));
    L12:
        com.ss.android.lark.biz.im.api.extension.chat_window.b r104 = this.f428321a;
        h r105 = r104.f410100e;
        if (r105 == null) goto L17;
        MutableLiveData<Chat> r106 = r105.f410103c;
        if (r106 == null) goto L17;
        r106.observe(r104.f410096a.getViewLifecycleOwner(), new com.ss.android.lark.keyboard.biz.emoji.inject.a(this));
    L17:
        return r101;
    L8:
        r103 = false;
        goto L9
    }

    @Override // wnb.b
    public final e b() {
        h r100 = this.f428321a.f410100e;
        if (r100 == null) goto L8;
        MutableLiveData<Chat> r101 = r100.f410103c;
        if (r101 == null) goto L8;
        Chat r102 = r101.getValue();
        if (r102 == null) goto L8;
    L10:
        if (r102.isGroup() == false) goto L12;
    L14:
        int r103 = 0;
    L16:
        return new e(r103, UIHelper.dp2px(12.0f), 0, UIHelper.dp2px(0.0f));
    L12:
        if (com.ss.android.lark.keyboard.utils.b.a(r102) == true) goto L14;
        r103 = UIHelper.dp2px(12.0f);
    L8:
        r102 = this.f428321a.f410098c;
        goto L10
    }

    public final com.ss.android.lark.keyboard.b f() {
        com.ss.android.lark.keyboard.b r100 = this.f428322b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // wnb.b
    public final c h() {
        c r100 = this.f428323c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final void onDestroy() {
        if (this.f428322b == null) goto L5;
        f().e().of(this).a();
    L5:
        this.f428324d = null;
        this.f428325e = false;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        return InputInnerVisibilityMode.DYNAMIC;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.Top;
    }

    @Override // wnb.b
    public final wnb.b.a<EmojiTopPlugin> getKey() {
        return f428320h;
    }

    public EmojiTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428321a = r100;
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428323c = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428322b = r100;
    }
}
