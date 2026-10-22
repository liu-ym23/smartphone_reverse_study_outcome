package com.ss.android.lark.keyboard.biz.mention.inject;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.MutableLiveData;
import com.obric.trace.ObricActionBarTrackType;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import com.ss.android.lark.keyboard.base.inputinner.Direction;
import com.ss.android.lark.keyboard.base.inputinner.DirectionInParent;
import com.ss.android.lark.keyboard.base.inputinner.InputInnerVisibilityMode;
import com.ss.android.lark.keyboard.editor.inject.InputInnerController;
import com.ss.android.lark.keyboard.event.k;
import com.ss.android.lark.keyboard.event.q;
import com.ss.android.lark.keyboard.utils.PluginUtils;
import com.ss.android.lark.keyboard.widget.RoundedIconTextView;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes36.dex */
public final class AtDoubaoTopPlugin implements wnb.b<AtDoubaoTopPlugin> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f428433i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.biz.im.api.extension.chat_window.b f428434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.ss.android.lark.keyboard.b f428435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public wnb.c f428436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f428437d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Chatter f428438e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RoundedIconTextView f428439f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f428440g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f428441h;

    public static final class a implements wnb.b.a<AtDoubaoTopPlugin> {
        public a() {
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AtDoubaoTopPlugin f428442a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RoundedIconTextView f428443b;

        public b(AtDoubaoTopPlugin r100, RoundedIconTextView r101) {
            this.f428442a = r100;
            this.f428443b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            AtDoubaoTopPlugin r101 = this.f428442a;
            boolean r102 = !r101.f428440g;
            r101.f428440g = r102;
            this.f428443b.d(r102, true);
            boolean r103 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
            com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a = this.f428442a.f428440g;
            k.a.a(this.f428442a.g().e(), new com.ss.android.lark.keyboard.biz.mention.inject.a(this.f428442a.f428440g));
            int r104 = xob.a.f564691a;
            Context r105 = this.f428442a.f428434a.f410096a.requireContext();
            String r106 = this.f428442a.f428434a.f410098c.getId();
            Intrinsics.checkNotNullParameter(r105, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r106, "chatId");
            xob.a.b(new Pair[]{new Pair("chat_id", r106), new Pair("click", "at_doubao_icon"), new Pair(PickerReporterConstants.KEY.TARGET, "none"), new Pair("keyboard_status", xob.a.a(r105))});
        }
    }

    static {
        f428433i = new a();
    }

    @Override // wnb.b
    public final View a() {
        RoundedIconTextView r100 = new RoundedIconTextView(this.f428434a.f410096a.requireContext(), null, 6, 0);
        boolean r101 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        this.f428440g = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        itb.a r102 = (itb.a) OfficeSDKManager.getHostGlobalService(itb.a.class);
        if (r102 == null) goto L6;
        String r103 = r102.i();
        if (r103 == null) goto L6;
    L7:
        r100.setText("@ ".concat(r103));
        r100.setTextBold(true);
        r100.setInputTopActionCheckedStyle(PluginUtils.c());
        r100.d(this.f428440g, false);
        com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a = this.f428440g;
        r100.setOnClickListener(new b(this, r100));
        this.f428439f = r100;
        Lifecycle r104 = g().l().f429558b;
        if (r104 == null) goto L12;
        LifecycleCoroutineScope r105 = LifecycleKt.getCoroutineScope(r104);
        if (r105 == null) goto L12;
        BuildersKt.launch$default(r105, null, null, new AtDoubaoTopPlugin$getDoubaoChatter$1(this, null), 3, null);
    L12:
        g().e().of(this).c(q.b.class, new AtDoubaoTopPlugin$refreshUI$1(this));
        g().e().of(this).c(j.class, new AtDoubaoTopPlugin$refreshUI$2(this));
        boolean r106 = j();
        if (r106 == true) goto L15;
        f();
    L15:
        this.f428441h = Boolean.valueOf(r106);
        Log.i("AtDoubaoTopPlugin", "init Doubao top entry visibility, visible=" + this.f428441h);
        com.ss.android.lark.biz.im.api.extension.chat_window.b r107 = this.f428434a;
        com.ss.android.lark.biz.im.api.extension.chat_window.h r108 = r107.f410100e;
        if (r108 == null) goto L20;
        MutableLiveData<Chat> r109 = r108.f410103c;
        if (r109 == null) goto L20;
        r109.observe(r107.f410096a.getViewLifecycleOwner(), new c(this));
    L20:
        RoundedIconTextView r110 = this.f428439f;
        Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.ss.android.lark.keyboard.widget.RoundedIconTextView");
        return r110;
    L6:
        r103 = "";
        goto L7
    }

    @Override // wnb.b
    public final wnb.e b() {
        return new wnb.e(UIHelper.dp2px(12.0f), UIHelper.dp2px(12.0f), UIHelper.dp2px(8.0f), UIHelper.dp2px(0.0f));
    }

    public final void f() {
        boolean r100 = true;
        if (this.f428440g == true) goto L15;
        boolean r101 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        if (com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a == true) goto L15;
        RoundedIconTextView r102 = this.f428439f;
        if (r102 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        if (r103 == true) goto L15;
        r100 = false;
        goto L15
    L9:
        if (r102.f431017l != true) goto L11;
        r103 = true;
    L15:
        this.f428440g = false;
        boolean r104 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a = false;
        RoundedIconTextView r105 = this.f428439f;
        if (r105 == null) goto L18;
        r105.d(false, false);
    L18:
        if (r100 == false) goto L21;
        k.a.a(g().e(), new com.ss.android.lark.keyboard.biz.mention.inject.a(false));
        return;
    }

    public final com.ss.android.lark.keyboard.b g() {
        com.ss.android.lark.keyboard.b r100 = this.f428435b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException(ObricActionBarTrackType.KEY_BOARD);
        return null;
    }

    @Override // wnb.b
    public final wnb.c h() {
        wnb.c r100 = this.f428436c;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Intrinsics.throwUninitializedPropertyAccessException("pluginContext");
        return null;
    }

    public final boolean j() {
        com.ss.android.lark.biz.im.api.extension.chat_window.h r100 = this.f428434a.f410100e;
        if (r100 == null) goto L8;
        MutableLiveData<Chat> r101 = r100.f410103c;
        if (r101 == null) goto L8;
        Chat r102 = r101.getValue();
        if (r102 == null) goto L8;
    L10:
        return com.ss.android.lark.keyboard.utils.b.a(r102);
    L8:
        r102 = this.f428434a.f410098c;
        goto L10
    }

    @Override // wnb.b
    public final void onDestroy() {
        boolean r100 = com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a;
        com.ss.android.lark.keyboard.biz.mention.inject.b.f428445a = false;
    }

    @Override // wnb.b
    public final InputInnerVisibilityMode d() {
        if (j() == false) goto L6;
        return InputInnerVisibilityMode.DYNAMIC;
    L6:
        return InputInnerVisibilityMode.ALWAYS_GONE;
    }

    @Override // wnb.b
    public final boolean i() {
        return j();
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
    public final wnb.b.a<AtDoubaoTopPlugin> getKey() {
        return f428433i;
    }

    public AtDoubaoTopPlugin(com.ss.android.lark.biz.im.api.extension.chat_window.b r100) {
        Intrinsics.checkNotNullParameter(r100, "keyboardPluginContext");
        this.f428434a = r100;
        this.f428437d = LazyKt.lazy(AtDoubaoTopPlugin$model$2.INSTANCE);
    }

    @Override // wnb.b
    public final void e(InputInnerController r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428436c = r100;
    }

    @Override // wnb.b
    public final void setKeyboard(com.ss.android.lark.keyboard.b r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f428435b = r100;
    }
}
