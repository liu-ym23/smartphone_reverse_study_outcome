package com.bytedance.ee.bear.middleground.comment.audio.voiceinput.lark;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.SystemClock;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.contract.i0;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceExtraAnalyticParams;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceLog;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.q;
import com.bytedance.ee.bear.middleground.comment.audio.voiceinput.r;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.audio.voiceinput.VoiceInputMode;
import com.ss.android.lark.audio.voiceinput.VoiceInputScene;
import com.ss.android.lark.audio.voiceinput.p;
import com.ss.android.lark.audio.voiceinput.service.IAudioService;
import com.ss.android.lark.audio.voiceinput.service.l;
import com.ss.android.lark.audio.voiceinput.service.o;
import com.ss.android.lark.keyboard.plugin.tool.voice.KeyboardVoiceFGUtils;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.AsrInputVoiceView;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.ImmersiveVoiceInputComponent;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model.ImmersiveVoiceViewModel;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase.VoiceKeyboardFunctionEditText;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.w;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.x;
import com.ss.android.lark.keyboard.plugin.tool.voice.immersive.z;
import com.ss.android.lark.widget.richtext.i;
import e0c.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class LarkImCommentVoiceInputController implements h {
    public final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f a;
    public final Function0<Unit> b;
    public final a c;
    public final q d;
    public final q e;
    public boolean f;

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean a() {
        return false;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void e() {
        i(false);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void d() {
        Function1<Boolean, Unit> r0 = this.a.q;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.FALSE);
    L5:
        k();
        this.c.i();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void destroy() {
        Function1<Boolean, Unit> r0 = this.a.q;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.FALSE);
    L5:
        k();
        a r1 = this.c;
        if (r1.d == false) goto L8;
        r1.i();
        return;
    L8:
        r1.e();
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void g() {
        Function1<Boolean, Unit> r0 = this.a.q;
        if (r0 == null) goto L5;
        r0.invoke(Boolean.FALSE);
    L5:
        m(false);
        l();
        Function0<Unit> r1 = this.a.p;
        if (r1 == null) goto L9;
        r1.invoke();
        return;
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final void h() {
        Function0<Boolean> r0 = this.a.H;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        i(true);
        return;
    L5:
        if (((Boolean) r0.invoke()).booleanValue() != true) goto L7;
        r1 = true;
        goto L8
    }

    public final void k() {
        Function0<View> r0 = this.a.l;
        if (r0 == null) goto L5;
        View r1 = (View) r0.invoke();
    L7:
        if (this.d.b() == false) goto L9;
    L10:
        m(false);
    L11:
        l();
        boolean r2 = true;
        if (r1 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == true) goto L24;
        if (r1 != null) goto L20;
    L22:
        r2 = false;
    L23:
        if (r2 == true) goto L24;
    L25:
        j(false);
        return;
    L20:
        if (r1.getVisibility() != 4) goto L22;
    L24:
        r1.setVisibility(8);
        goto L25
    L14:
        if (r1.getVisibility() != 0) goto L16;
        r3 = true;
        goto L17
    L9:
        if (this.e.b() == false) goto L11;
    L5:
        r1 = null;
        goto L7
    }

    public final void l() {
        Function0<List<View>> r0 = this.a.s;
        if (r0 == null) goto L5;
        List r1 = (List) r0.invoke();
    L6:
        if (r1 != null) goto L8;
        r1 = CollectionsKt.emptyList();
    L8:
        ArrayList r2 = new ArrayList();
        Iterator r3 = r1.iterator();
    L9:
        boolean r4 = false;
        if (r3.hasNext() == false) goto L16;
        Object r5 = r3.next();
        if (((View) r5).getVisibility() != 4) goto L14;
        r4 = true;
    L14:
        if (r4 == false) goto L9;
        r2.add(r5);
        goto L9
    L16:
        Iterator r6 = r2.iterator();
    L18:
        if (r6.hasNext() == false) goto L20;
        ((View) r6.next()).setVisibility(0);
        goto L18
    L20:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public LarkImCommentVoiceInputController(final com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r9) {
        Intrinsics.checkNotNullParameter(r9, "ctx");
        this.a = r9;
        final Function0<Unit> r4 = new LarkImCommentVoiceInputController$onAdvancedDismiss$1(this);
        this.b = r4;
        int r1 = a.J;
        final Function0<Unit> r3 = new LarkImCommentVoiceInputController$advancedAsrAdapter$1(this);
        Intrinsics.checkNotNullParameter(r9, "ctx");
        Intrinsics.checkNotNullParameter(r3, "onShortClick");
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", "getOrCreate hostActivity: " + r9.a + " hostFragment: " + r9.b);
        final Fragment r0 = r9.b;
        if (r0 != null) goto L5;
        CommentVoiceExtraAnalyticParams r2 = CommentVoiceExtraAnalyticParams.a;
        a r5 = new a(r9, r3, r4, false, new ConcurrentHashMap());
        tt5.a.d("CommentAdvancedAsrInputViewAdapter", "hostFragment is null");
    L6:
        this.c = r5;
        this.d = new q();
        this.e = new q();
        return;
    L5:
        r5 = ((CommentAdvancedAsrInputViewAdapterStore) new ViewModelProvider(r0).get(CommentAdvancedAsrInputViewAdapterStore.class)).getOrCreate(new CommentAdvancedAsrInputViewAdapter$Companion$getOrCreate$1(r9, r3, r4, r0));
        r5.a = r9;
        r5.b = r3;
        r5.c = r4;
        r5.b();
        goto L6
    }

    public final void i(boolean r2) {
        if (r2 == false) goto L6;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r3 = this.a;
        com.bytedance.ee.bear.middleground.comment.uitls.h r0 = r3.f;
        if (r0 == null) goto L6;
        r0.k(r3.j);
    L6:
        Function0<Unit> r4 = this.a.C;
        if (r4 == null) goto L9;
        r4.invoke();
    L9:
        Function1<Boolean, Unit> r5 = this.a.q;
        if (r5 == null) goto L12;
        r5.invoke(Boolean.TRUE);
    L12:
        m(true);
        Function0<Unit> r6 = this.a.o;
        if (r6 == null) goto L16;
        r6.invoke();
        return;
    }

    public final void j(boolean r3) {
        if (this.f != r3) goto L5;
        return;
    L5:
        this.f = r3;
        Function1<Boolean, Unit> r0 = this.a.F;
        if (r0 == null) goto L8;
        r0.invoke(Boolean.valueOf(r3));
    L8:
        Function1<Boolean, Unit> r1 = this.a.G;
        if (r1 == null) goto L12;
        r1.invoke(Boolean.valueOf(r3));
        return;
    }

    public final void m(boolean r8) {
        Function0<View> r0 = this.a.l;
        List r1 = null;
        if (r0 == null) goto L5;
        View r2 = (View) r0.invoke();
    L6:
        if (r2 != null) goto L9;
        tt5.a.k("CommentVoice", "[simple] switchBars aborted: voiceBar is null");
        return;
    L9:
        Function0<List<View>> r3 = this.a.s;
        if (r3 == null) goto L12;
        r1 = (List) r3.invoke();
    L12:
        if (r1 != null) goto L14;
        r1 = CollectionsKt.emptyList();
    L14:
        List r4 = r1;
        Set r5 = CollectionsKt.toSet(r4);
        List r6 = CollectionsKt.createListBuilder();
        Function0<View> r7 = this.a.k;
        if (r7 == null) goto L19;
        View r9 = (View) r7.invoke();
        if (r9 == null) goto L19;
        r6.add(r9);
    L19:
        Function0<List<View>> r10 = this.a.r;
        if (r10 == null) goto L24;
        List r11 = (List) r10.invoke();
        if (r11 == null) goto L24;
        r6.addAll(r11);
    L24:
        List r12 = CollectionsKt.build(r6);
        ArrayList r13 = new ArrayList();
        Iterator r14 = r12.iterator();
    L26:
        if (r14.hasNext() == false) goto L31;
        Object r15 = r14.next();
        if (r5.contains((View) r15) == true) goto L26;
        r13.add(r15);
        goto L26
    L31:
        if (r8 == false) goto L41;
        this.d.a();
        Iterator r16 = r13.iterator();
    L34:
        if (r16.hasNext() == false) goto L36;
        this.d.d((View) r16.next(), 8);
        goto L34
    L36:
        this.e.a();
        Iterator r17 = r4.iterator();
    L38:
        if (r17.hasNext() == false) goto L40;
        this.e.d((View) r17.next(), 4);
        goto L38
    L40:
        r2.setVisibility(0);
        j(true);
        return;
    L41:
        r2.setVisibility(8);
        this.d.c(r13, 0);
        this.e.c(r4, 0);
        j(false);
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean b(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        return c(r2, r3);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean c(View r37, MotionEvent r38) {
        Intrinsics.checkNotNullParameter(r37, "view");
        Intrinsics.checkNotNullParameter(r38, "event");
        if ((r38.getAction() & 255) != 0) goto L8;
        a r5 = this.c;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r6 = this.a;
        Function0<Unit> r7 = new LarkImCommentVoiceInputController$onPrimaryVoiceTouch$1(this);
        Function0<Unit> r8 = this.b;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r6, "ctx");
        Intrinsics.checkNotNullParameter(r7, "onShortClick");
        if (r5.a == r6) goto L7;
        r5.i();
    L7:
        r5.a = r6;
        r5.b = r7;
        r5.c = r8;
        r5.b();
    L8:
        final a r9 = this.c;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r37, "view");
        Intrinsics.checkNotNullParameter(r38, "event");
        r9.e.put("source_type", "ccm_comment");
        r9.e.put("file_id", r9.a.g);
        r9.e.put("file_type", r9.a.h);
        r9.e.put("location", r9.a.j);
        View.OnTouchListener r0 = r9.i;
        if (r0 == null) goto L16;
        ViewGroup r10 = r9.k();
        if (r10 == null) goto L15;
        a.C0050a r11 = r9.f;
        if (r11 == null) goto L15;
        r9.c(r11, r10);
    L15:
        r9.b();
    L57:
        if (r0 == null) goto L142;
        int r4 = r38.getAction() & 255;
        String r12 = "";
        if (r4 == 0) goto L98;
        if (r4 == 1) goto L72;
        if (r4 == 2) goto L68;
        if (r4 == 3) goto L72;
        r0.onTouch(r37, r38);
    L104:
        return true;
    L68:
        if (r9.F == true) goto L104;
        r0.onTouch(r37, r38);
    L72:
        if (r9.F == false) goto L74;
        r9.F = false;
        goto L104
    L74:
        long r13 = r38.getEventTime() - r9.t;
        r9.r.removeCallbacks(r9.I);
        if (r9.u == false) goto L90;
        if (r4 != 1) goto L89;
        VoiceKeyboardFunctionEditText r14 = r9.g;
        if (r14 == null) goto L88;
        int r15 = r9.z;
        g r16 = r9.y;
        CharSequence r17 = r9.a.c.c();
        r16.d = true;
        String r18 = r17.toString();
        if (r18 == null) goto L84;
        r12 = r18;
    L84:
        r16.c = r12;
        e r19 = r9.B;
        if (r19 == null) goto L87;
        r9.r.removeCallbacks(r19);
    L87:
        e r20 = new e(r9, r15, r14);
        r9.B = r20;
        r9.r.postDelayed(r20, 3000);
    L88:
        r0.onTouch(r37, r38);
        r9.l();
        goto L104
    L89:
        r0.onTouch(r37, r38);
        r9.l();
        r9.g();
        goto L104
    L90:
        MotionEvent r3 = MotionEvent.obtain(r38);
        r3.setAction(3);
        r0.onTouch(r37, r3);
        r3.recycle();
        r9.g();
        if (r4 != 1) goto L104;
        if (r13 >= 300) goto L104;
        if (r9.x == true) goto L104;
        r9.b.invoke();
        goto L104
    L98:
        if (SystemClock.uptimeMillis() >= r9.E) goto L100;
        boolean r21 = true;
    L101:
        r9.F = r21;
        if (r21 == false) goto L105;
        r9.t = r38.getEventTime();
        goto L104
    L105:
        r9.t = r38.getEventTime();
        r9.u = false;
        int r22 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.a;
        r9.x = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.h();
        VoiceKeyboardFunctionEditText r23 = r9.g;
        if (r23 == null) goto L134;
        r9.w = true;
        a.d r110 = r9.s;
        if (r110 == null) goto L111;
        r9.r.removeCallbacks(r110);
    L111:
        r9.s = null;
        d r111 = r9.A;
        if (r111 == null) goto L114;
        r9.r.removeCallbacks(r111);
    L114:
        r9.A = null;
        e r112 = r9.B;
        if (r112 == null) goto L117;
        r9.r.removeCallbacks(r112);
    L117:
        r9.B = null;
        g r113 = r9.y;
        r113.getClass();
        Intrinsics.checkNotNullParameter(r23, "editor");
        int r114 = r113.a + 1;
        r113.a = r114;
        r113.b = r23;
        r113.d = false;
        r113.e = false;
        String r115 = null;
        r113.c = null;
        r9.z = r114;
        ImmersiveVoiceViewModel r116 = r9.C;
        if (r116 == null) goto L130;
        Editable r117 = r23.getText();
        if (r117 == null) goto L123;
        r115 = r117.toString();
    L123:
        if (r115 == null) goto L126;
        r12 = r115;
    L126:
        int r118 = r23.getSelectionEnd();
        if (r116.isVoiceInputMarkdownFg() == false) goto L129;
        r12 = i.g(r116.addPeriodForRichTextIfNeed(r12, r118), false);
        Intrinsics.checkNotNull(r12);
        goto L130
    L129:
        r12 = r116.addPeriodIfNeed(r12, r118);
    L130:
        StringBuilder r119 = new StringBuilder("[advanced] begin voice session sessionId=");
        r119.append(r9.z);
        r119.append(", pendingPeriodLen=");
        r119.append(r12.length());
        r119.append(", ");
        CommentVoiceLog r120 = CommentVoiceLog.a;
        CharSequence r121 = r9.a.c.c();
        r120.getClass();
        r119.append(CommentVoiceLog.i("comment", r121));
        r119.append(", ");
        r119.append(CommentVoiceLog.i("hiddenEditorBeforeClear", r23.getText()));
        tt5.a.h("CommentAdvancedAsrInputViewAdapter", r119.toString());
        r9.a.c.a(r12);
        if (r23.hasFocus() == false) goto L133;
        r23.clearFocus();
    L133:
        r23.setText(new SpannableStringBuilder());
        r23.setSelection(0);
        r23.setHint(r9.a.c.a.getHint());
        r9.w = false;
    L134:
        r0.onTouch(r37, r38);
        if (r9.x == true) goto L104;
        if (com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.g(r37.getContext()) == false) goto L104;
        r9.r.postDelayed(r9.I, 300);
        goto L104
    L100:
        r21 = false;
        goto L101
    L142:
        return false;
    L16:
        Fragment r122 = r9.a.b;
        if (r122 != null) goto L19;
        tt5.a.k("CommentVoice", "[advanced] AsrInputVoiceView aborted: hostFragment is null");
    L22:
        r0 = null;
        goto L57
    L19:
        ViewGroup r123 = r9.k();
        if (r123 != null) goto L23;
        tt5.a.k("CommentVoice", "[advanced] AsrInputVoiceView aborted: attach parent is null");
        goto L22
    L23:
        VoiceKeyboardFunctionEditText r1 = r9.h(r123.getContext());
        Context r24 = r123.getContext();
        a.C0050a r25 = r9.f;
        if (r25 != null) goto L27;
        r25 = new a.C0050a(r24, r9.a, r1);
        r9.f = r25;
    L27:
        a.C0050a r124 = r25;
        r9.c(r124, r123);
        Application r2 = com.larksuite.framework.utils.b.a;
        Intrinsics.checkNotNull(r2);
        IAudioService r26 = (IAudioService) k.a(r2, IAudioService.class);
        l r125 = (l) k.a(r2, l.class);
        o r126 = (o) k.a(r2, o.class);
        Activity r27 = r9.a.a;
        r r28 = com.bytedance.ee.bear.middleground.comment.audio.voiceinput.k.a;
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.k.b(new CommentAdvancedAsrInputViewAdapter$ensureAsrTouchListener$dependency$1(r9));
        x r127 = new x(r26, r125, r126, r27, r122);
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L30
        Object r30 = Result.constructor-impl(((i0) org.koin.java.a.c(i0.class, null, null, 6)).a());     // Catch: Throwable -> L30
    L33:
        if (Result.isFailure-impl(r30) == false) goto L35;
        r30 = null;
    L35:
        String r31 = (String) r30;
        if (r31 != null) goto L38;
        r31 = "zh_cn";
    L38:
        String r210 = r31;
        p r32 = new p(VoiceInputMode.OnlyAsr, VoiceInputScene.AdvancedMode);
        String r33 = r9.a.e;
        if (r33.length() != 0) goto L41;
        boolean r34 = true;
    L42:
        if (r34 == false) goto L44;
        r33 = "LARK-PSDA-messenger_record_audio";
    L44:
        com.bytedance.ee.bear.middleground.comment.audio.voiceinput.f r128 = r9.a;
        w r35 = new w(true, r210, r32, r33, new CommentVoiceInputResultConsumer(r128.c, null, null, null, 22), null, r9.e, null, r128.i, null, KeyboardVoiceFGUtils.g(KeyboardVoiceFGUtils.a, "im.messenger.voice_input_markdown"), 360384);
        AsrInputVoiceView r36 = new AsrInputVoiceView(r123.getContext(), r124, r127, r35, CollectionsKt.mutableListOf(new z[]{new c(r9)}));
        int r39 = UIUtils.dp2px(r36.getContext(), 8.0f);
        r36.setPadding(r39, r36.getPaddingTop(), r39, r36.getPaddingBottom());
        r36.setClipToPadding(false);
        r36.setLayoutParams(new FrameLayout.LayoutParams(-1, -2, 80));
        r9.h = r36;
        r9.i = r36.getTouchListener();
        ImmersiveVoiceInputComponent.a r40 = ImmersiveVoiceInputComponent.a;
        ImmersiveVoiceViewModel r41 = ImmersiveVoiceInputComponent.a.a(true, r127, r35, r123.getContext());
        ImmersiveVoiceViewModel r42 = r9.C;
        if (r42 == r41) goto L47;
    L49:
        b r43 = r9.D;
        if (r43 == null) goto L55;
        if (r42 == null) goto L55;
        MutableLiveData r44 = r42.isAsrRecognizeFinish();
        if (r44 == null) goto L55;
        r44.removeObserver(r43);
    L55:
        b r45 = new b(r9);
        r41.isAsrRecognizeFinish().observe(r122, r45);
        r9.C = r41;
        r9.D = r45;
    L56:
        r9.b();
        r0 = r36.getTouchListener();
        goto L57
    L47:
        if (r9.D == null) goto L49;
    L41:
        r34 = false;
    L30:
        th = move-exception;
        Result.Companion r46 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L33
    }

    @Override // com.bytedance.ee.bear.middleground.comment.audio.voiceinput.h
    public final boolean f(View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "event");
        Function2<View, MotionEvent, Boolean> r0 = this.a.K;
        if (r0 != null) goto L7;
        return false;
    L7:
        return ((Boolean) r0.invoke(r2, r3)).booleanValue();
    }
}
