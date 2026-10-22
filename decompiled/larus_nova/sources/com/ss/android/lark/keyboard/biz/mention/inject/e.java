package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.keyboard2.KeyboardMenuItemKey;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class e implements wnb.b<e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f428449f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f428451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public wnb.c f428453d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RoundedIconTextView f428454e;

    public static final class a implements wnb.b.a<e> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f428455a;

        public b(e r100) {
            this.f428455a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r110) {
            com.ss.android.lark.keyboard.b r111 = this.f428455a.f428452c;
            if (r111 != null) goto L6;
            Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
            r111 = null;
        L6:
            r111.H().f(KeyboardMenuItemKey.At);
            int r112 = xob.a.f564691a;
            Context r113 = this.f428455a.f428450a.f410096a.requireContext();
            String r100 = this.f428455a.f428450a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r113, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r100), new Pair("click", "at_user_icon"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r113))});
            Context r101 = this.f428455a.f428450a.f410096a.requireContext();
            String r102 = this.f428455a.f428450a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r102, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r102), new Pair("click", "at_mention"), new Pair(PickerReporterConstants.KEY.TARGET, "public_at_mention_select_view"), new Pair("keyboard_status", xob.a.a(r101))});
        }
    }

    static {
        f428449f = new a();
    }

    @Override // wnb.b
    public final /* synthetic */ void onDestroy() {
    }

    @Override // wnb.b
    public final View a() {
        RoundedIconTextView r100 = new RoundedIconTextView(this.f428450a.f410096a.requireContext(), null, 6, 0);
        r100.setText("@ " + UIUtils.getString(r100.getContext(), R.string.LarkIM_Group_GroupMember_Button));
        r100.setTextBold(true);
        r100.setOnClickListener(new b(this));
        this.f428454e = r100;
        com.ss.android.lark.biz.im.api.extension.chat_window.b r101 = this.f428450a;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r102 = r101.f410100e;
        if (r102 == null) goto L7;
        MutableLiveData<Chat> r103 = r102.f410103c;
        if (r103 == null) goto L7;
        r103.observe(r101.f410096a.getViewLifecycleOwner(), new f(this));
    L7:
        RoundedIconTextView r104 = this.f428454e;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.ss.android.lark.keyboard.widget.RoundedIconTextView");
        return r104;
    }

    @Override // wnb.b
    public final wnb.e b() {
        com.ss.android.lark.biz.im.api.extension.chat_window.h r100 = this.f428450a.f410100e;
        if (r100 == null) goto L8;
        MutableLiveData<Chat> r101 = r100.f410103c;
        if (r101 == null) goto L8;
        Chat r102 = r101.getValue();
        if (r102 == null) goto L8;
    L10:
        if (r102.isGroup() == true) goto L12;
    L14:
        int r103 = 0;
    L16:
        return new wnb.e(r103, UIHelper.dp2px(12.0f), UIHelper.dp2px(8.0f), UIHelper.dp2px(0.0f));
    L12:
        if (com.ss.android.lark.keyboard.utils.b.a(r102) == true) goto L14;
        r103 = UIHelper.dp2px(12.0f);
    L8:
        r102 = this.f428450a.f410098c;
        goto L10
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        if (this.f428451b == false) goto L6;
        return InputInnerVisibilityMode.DYNAMIC;
    L6:
        return InputInnerVisibilityMode.ALWAYS_GONE;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428453d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    @Override // wnb.b
    public final DirectionInParent c() {
        return DirectionInParent.TOP;
    }

    @Override // wnb.b
    public final Direction getDirection() {
        return Direction.Top;
    }

    @Override // wnb.b
    public final wnb.b.a<e> getKey() {
        return f428449f;
    }

    @Override // wnb.b
    public final boolean i() {
        return this.f428451b;
    }

    public e(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428450a = r100;
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428453d = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428452c = r100;
    }
}
