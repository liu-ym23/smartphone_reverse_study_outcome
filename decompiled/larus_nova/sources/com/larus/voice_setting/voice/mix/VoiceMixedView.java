package com.larus.voice_setting.voice.mix;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.bean.bot.MixVoice;
import com.larus.im.bean.bot.SpeakerVoice;
import com.larus.utils.logger.FLogger;
import com.larus.voice_setting.voice.base.AppBarLayoutStateListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import v2a.c;
import v2a.d;
import v2a.e0;
import v2a.f0;
import v2a.g0;
import v2a.h0;
import v2a.i0;
import v2a.j0;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ+\u0010@\u001a\u00020\u001e2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0B2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\u0006\u0010,\u001a\u00020-¢\u0006\u0002\u0010CJ\u001a\u0010D\u001a\u00020\u001e2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001cJ$\u0010F\u001a\u00020\u001e2\u001c\u0010G\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001e0 J\u001c\u0010H\u001a\u00020\u001e2\u0014\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e0\u001cJ\u001c\u0010I\u001a\u00020\u001e2\u0014\u0010G\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e0\u001cJ\u000e\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020LJ\u000e\u0010M\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dJ\u0018\u0010O\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001d2\b\b\u0002\u0010P\u001a\u00020\u0018J\u000e\u0010Q\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dJ\u0006\u0010R\u001a\u00020\u001eJ\b\u0010S\u001a\u00020\u001eH\u0002J\u0010\u0010T\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dH\u0002J\u001a\u0010U\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001d2\b\b\u0002\u0010V\u001a\u00020-H\u0002J\u0010\u0010W\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001dH\u0002J\u0014\u0010X\u001a\u00020\u001e2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u001d0BJ\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u001d0BH\u0002J\u000e\u0010Z\u001a\u00020\u001e2\u0006\u0010[\u001a\u00020%J\u0014\u0010\\\u001a\u00020\u001e2\f\u0010]\u001a\b\u0012\u0004\u0012\u00020\u001e0+J\b\u0010^\u001a\u0004\u0018\u00010_R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u001f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u001e\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010#\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u0012\u0012\u0004\u0012\u00020\u001d0'j\b\u0012\u0004\u0012\u00020\u001d`(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102RJ\u00103\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0013\u0012\u00110-¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u001e0 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R,\u0010<\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180=0+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u00100\"\u0004\b?\u00102¨\u0006`"}, d2 = {"Lcom/larus/voice_setting/voice/mix/VoiceMixedView;", "Landroid/widget/LinearLayout;", "aContext", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAContext", "()Landroid/content/Context;", "setAContext", "(Landroid/content/Context;)V", "getAttrs", "()Landroid/util/AttributeSet;", "setAttrs", "(Landroid/util/AttributeSet;)V", "getDefStyleAttr", "()I", "setDefStyleAttr", "(I)V", "selectVoiceMode", "tag", "", "singleView", "Lcom/larus/voice_setting/voice/mix/IVoiceMixSingleView;", "onVoiceRemove", "Lkotlin/Function1;", "Lcom/larus/im/bean/bot/MixVoice;", "", "onVoiceProportionChanged", "Lkotlin/Function2;", "Lcom/larus/im/bean/bot/SpeakerVoice;", "onVoiceAudition", "onVoiceAuditionEnd", "mViewState", "Lcom/larus/voice_setting/voice/base/AppBarLayoutStateListener$State;", "pendingAddVoice", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "nowPlayingVoiceId", "mDelegateMixVoicePlay", "Lkotlin/Function0;", "defaultExpandMixVoiceView", "", "collapseCallback", "getCollapseCallback", "()Lkotlin/jvm/functions/Function0;", "setCollapseCallback", "(Lkotlin/jvm/functions/Function0;)V", "renderCountChange", "Lkotlin/ParameterName;", "name", "count", "defaultCollapse", "getRenderCountChange", "()Lkotlin/jvm/functions/Function2;", "setRenderCountChange", "(Lkotlin/jvm/functions/Function2;)V", "audioObserverExtraParamsGetter", "", "getAudioObserverExtraParamsGetter", "setAudioObserverExtraParamsGetter", "initVoice", "list", "", "(Ljava/util/List;Ljava/lang/Integer;Z)V", "setRemoveCallback", "removeCallback", "setVoiceProportionCallback", "callBack", "setVoiceAuditionCallback", "setVoiceAuditionEndCallback", "updateAuditionStatus", "update", "Lcom/larus/voice_setting/voice/mix/res/VoiceAuditionUpdate;", "addVoice", "voice", "removeVoice", "from", "updateVoice", "clearVoice", "applyAddVoice", "realAddVoiceView", "addSingleVoice", "isFromRemove", "addMultiVoice", "updateVoiceList", "getDisplayVoiceList", "viewState", "state", "delegatePlayMixVoice", "callback", "getExpandIconView", "Landroid/view/View;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoiceMixedView extends LinearLayout {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ int f376935r = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f376936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AttributeSet f376937b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f376938c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f376939d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VoiceMixSingleView f376940e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super MixVoice, Unit> f376941f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super SpeakerVoice, ? super Integer, Unit> f376942g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function1<? super SpeakerVoice, Unit> f376943h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super SpeakerVoice, Unit> f376944i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public AppBarLayoutStateListener.State f376945j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ArrayList<MixVoice> f376946k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f376947l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Function0<Unit> f376948m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f376949n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<Unit> f376950o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Function2<? super Integer, ? super Boolean, Unit> f376951p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Function0<? extends Map<String, String>> f376952q;

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoiceMixedView f376953a;

        @Override // v2a.d
        public final void a() {
            this.f376953a.getCollapseCallback().invoke();
        }

        public a(VoiceMixedView r100) {
            this.f376953a = r100;
        }

        @Override // v2a.d
        public final void c(SpeakerVoice r100) {
            Function1<? super SpeakerVoice, Unit> r101 = this.f376953a.f376944i;
            if (r101 == null) goto L6;
            r101.invoke(r100);
            return;
        }

        @Override // v2a.d
        public final void d(SpeakerVoice r100) {
            Function1<? super SpeakerVoice, Unit> r101 = this.f376953a.f376943h;
            if (r101 == null) goto L6;
            r101.invoke(r100);
            return;
        }

        @Override // v2a.d
        public final void e(MixVoice r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            VoiceMixedView r101 = this.f376953a;
            int r102 = VoiceMixedView.f376935r;
            r101.e(r100, "from_mix");
        }

        @Override // v2a.d
        public final void b(SpeakerVoice r100, Integer r101) {
            Function2<? super SpeakerVoice, ? super Integer, Unit> r102 = this.f376953a.f376942g;
            if (r102 == null) goto L6;
            r102.invoke(r100, r101);
            return;
        }
    }

    public VoiceMixedView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public VoiceMixedView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        this(r100, r101, 4, 0);
    }

    public final synchronized void c() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.f376946k.isEmpty() == false) goto L7;
        monitor-exit(this);
        return;
    L7:
        Iterator<T> r100 = this.f376946k.iterator();     // Catch: Throwable -> L14
    L9:
        if (r100.hasNext() == false) goto L11;
        d((MixVoice) r100.next());     // Catch: Throwable -> L14
        goto L9
    L11:
        this.f376946k.clear();     // Catch: Throwable -> L14
        monitor-exit(this);
    }

    private final List<MixVoice> getDisplayVoiceList() {
        ArrayList r100 = new ArrayList();
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L13;
        KeyEvent.Callback r103 = getChildAt(r102);
        MixVoice r104 = null;
        if ((r103 instanceof c) == false) goto L7;
        c r105 = (c) r103;
    L8:
        if (r105 == null) goto L10;
        r104 = r105.getData();
    L10:
        if (r104 == null) goto L12;
        r100.add(r104);
    L12:
        r102 = r102 + 1;
        goto L3
    L7:
        r105 = null;
        goto L8
    L13:
        return r100;
    }

    public final View getExpandIconView() {
        VoiceMixSingleView r100 = this.f376940e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getExpandIconView();
    }

    public final Context getAContext() {
        return this.f376936a;
    }

    public final AttributeSet getAttrs() {
        return this.f376937b;
    }

    public final Function0<Map<String, String>> getAudioObserverExtraParamsGetter() {
        return this.f376952q;
    }

    public final Function0<Unit> getCollapseCallback() {
        return this.f376950o;
    }

    public final int getDefStyleAttr() {
        return this.f376938c;
    }

    public final Function2<Integer, Boolean, Unit> getRenderCountChange() {
        return this.f376951p;
    }

    public final void a(MixVoice r100) {
        VoiceMixMultiView r101 = new VoiceMixMultiView(this.f376936a);
        r101.setAudioObserverExtraParamsGetter(this.f376952q);
        r101.setListener(new a(this));
        addView(r101);
        String r102 = this.f376947l;
        SpeakerVoice r103 = r100.getVoiceItem();
        if (r103 == null) goto L5;
        String r104 = r103.getId();
    L6:
        r101.p1(r100, Intrinsics.areEqual(r102, r104));
        return;
    L5:
        r104 = null;
        goto L6
    }

    public final void b(MixVoice r100) {
        if (this.f376940e != null) goto L5;
        VoiceMixSingleView r101 = new VoiceMixSingleView(this.f376936a);
        r101.setMixVoicePlayDelegate(new i0(this));
        r101.setListener(new j0(this));
        this.f376940e = r101;
    L5:
        VoiceMixSingleView r102 = this.f376940e;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
        addView(r102, 0);
        VoiceMixSingleView r103 = this.f376940e;
        if (r103 == null) goto L13;
        String r104 = this.f376947l;
        SpeakerVoice r105 = r100.getVoiceItem();
        if (r105 == null) goto L10;
        String r106 = r105.getId();
    L11:
        r103.p1(r100, Intrinsics.areEqual(r104, r106));
        return;
    L10:
        r106 = null;
        goto L11
    }

    public final void d(MixVoice r100) {
        if (getChildCount() != 0) goto L6;
        b(r100);
        this.f376951p.invoke(Integer.valueOf(getChildCount()), Boolean.valueOf(true ^ this.f376949n));
        return;
    L6:
        if (getChildCount() != 3) goto L9;
        return;
    L9:
        if (getChildCount() != 1) goto L19;
        VoiceMixSingleView r101 = this.f376940e;
        if (r101 == null) goto L13;
        MixVoice r102 = r101.getData();
    L14:
        VoiceMixSingleView r103 = this.f376940e;
        if (r103 == null) goto L17;
        removeView(r103);
    L17:
        if (r102 == null) goto L19;
        a(r102);
        goto L19
    L13:
        r102 = null;
    L19:
        a(r100);
        this.f376951p.invoke(Integer.valueOf(getChildCount()), Boolean.FALSE);
    }

    public final void f(MixVoice r100) {
        Intrinsics.checkNotNullParameter(r100, "voice");
        Iterator<MixVoice> r101 = this.f376946k.iterator();
        int r102 = 0;
        int r103 = 0;
    L3:
        c r104 = null;
        if (r101.hasNext() == false) goto L17;
        SpeakerVoice r105 = r101.next().getVoiceItem();
        if (r105 == null) goto L8;
        String r106 = r105.getId();
    L9:
        SpeakerVoice r107 = r100.getVoiceItem();
        if (r107 == null) goto L12;
        String r108 = r107.getId();
    L14:
        if (Intrinsics.areEqual(r106, r108) == true) goto L18;
        r103 = r103 + 1;
    L18:
        if (r103 == (-1)) goto L21;
        ListProtector.set(this.f376946k, r103, r100);
        return;
    L21:
        Iterator<MixVoice> r109 = getDisplayVoiceList().iterator();
    L23:
        if (r109.hasNext() == false) goto L36;
        SpeakerVoice r110 = r109.next().getVoiceItem();
        if (r110 == null) goto L27;
        String r111 = r110.getId();
    L28:
        SpeakerVoice r112 = r100.getVoiceItem();
        if (r112 == null) goto L31;
        String r113 = r112.getId();
    L33:
        if (Intrinsics.areEqual(r111, r113) == true) goto L37;
        r102 = r102 + 1;
    L37:
        FLogger.f375446a.i(this.f376939d, "[updateVoice] list:" + r100 + ", update:" + r100 + ", index:" + r102);
        if (r102 != (-1)) goto L40;
        return;
    L40:
        KeyEvent.Callback r114 = getChildAt(r102);
        if ((r114 instanceof c) == false) goto L43;
        r104 = (c) r114;
    L43:
        if (r104 == null) goto L50;
        r104.m2(r100.getVoiceItem());
        return;
    L50:
        return;
    L31:
        r113 = null;
        goto L33
    L27:
        r111 = null;
        goto L28
    L36:
        r102 = -1;
        goto L37
    L12:
        r108 = null;
        goto L14
    L8:
        r106 = null;
        goto L9
    L17:
        r103 = -1;
        goto L18
    }

    public final void g(List<MixVoice> r110) {
        Intrinsics.checkNotNullParameter(r110, "list");
        List<MixVoice> r100 = getDisplayVoiceList();
        Iterator<T> r111 = r110.iterator();
    L4:
        if (r111.hasNext() == false) goto L33;
        MixVoice r101 = (MixVoice) r111.next();
        Iterator<MixVoice> r102 = r100.iterator();
        int r103 = 0;
    L6:
        String r104 = null;
        if (r102.hasNext() == false) goto L20;
        SpeakerVoice r105 = r102.next().getVoiceItem();
        if (r105 == null) goto L11;
        String r106 = r105.getId();
    L12:
        SpeakerVoice r107 = r101.getVoiceItem();
        if (r107 == null) goto L15;
        String r108 = r107.getId();
    L17:
        if (Intrinsics.areEqual(r106, r108) == true) goto L21;
        r103 = r103 + 1;
    L21:
        FLogger.f375446a.i(this.f376939d, "[updateVoice] update:" + r101 + ", index:" + r103);
        if (r103 == (-1)) goto L23;
        KeyEvent.Callback r109 = getChildAt(r103);
        if ((r109 instanceof c) == false) goto L27;
        c r112 = (c) r109;
    L28:
        if (r112 == null) goto L4;
        String r113 = this.f376947l;
        SpeakerVoice r114 = r101.getVoiceItem();
        if (r114 == null) goto L32;
        r104 = r114.getId();
    L32:
        r112.p1(r101, Intrinsics.areEqual(r113, r104));
        goto L4
    L27:
        r112 = null;
        goto L28
    L23:
        return;
    L15:
        r108 = null;
        goto L17
    L11:
        r106 = null;
        goto L12
    L20:
        r103 = -1;
        goto L21
    }

    public final void setAContext(Context r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376936a = r100;
    }

    public final void setAttrs(AttributeSet r100) {
        this.f376937b = r100;
    }

    public final void setAudioObserverExtraParamsGetter(Function0<? extends Map<String, String>> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376952q = r100;
    }

    public final void setCollapseCallback(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376950o = r100;
    }

    public final void setDefStyleAttr(int r100) {
        this.f376938c = r100;
    }

    public final void setRemoveCallback(Function1<? super MixVoice, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "removeCallback");
        this.f376941f = r100;
    }

    public final void setRenderCountChange(Function2<? super Integer, ? super Boolean, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f376951p = r100;
    }

    public final void setVoiceAuditionCallback(Function1<? super SpeakerVoice, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f376943h = r100;
    }

    public final void setVoiceAuditionEndCallback(Function1<? super SpeakerVoice, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f376944i = r100;
    }

    public final void setVoiceProportionCallback(Function2<? super SpeakerVoice, ? super Integer, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callBack");
        this.f376942g = r100;
    }

    public final void e(MixVoice r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "voice");
        Intrinsics.checkNotNullParameter(r111, "from");
        Iterator<MixVoice> r100 = this.f376946k.iterator();
    L3:
        Object r101 = null;
        if (r100.hasNext() == false) goto L16;
        MixVoice r102 = r100.next();
        SpeakerVoice r103 = r102.getVoiceItem();
        if (r103 == null) goto L8;
        String r104 = r103.getId();
    L9:
        SpeakerVoice r105 = r110.getVoiceItem();
        if (r105 == null) goto L12;
        String r106 = r105.getId();
    L14:
        if (Intrinsics.areEqual(r104, r106) == false) goto L3;
    L17:
        MixVoice r107 = r102;
        if (r107 == null) goto L21;
        this.f376946k.remove(r107);
        return;
    L21:
        List<MixVoice> r108 = getDisplayVoiceList();
        Iterator<MixVoice> r109 = r108.iterator();
        boolean r112 = false;
        int r113 = 0;
    L23:
        if (r109.hasNext() == false) goto L36;
        SpeakerVoice r114 = r109.next().getVoiceItem();
        if (r114 == null) goto L27;
        String r115 = r114.getId();
    L28:
        SpeakerVoice r116 = r110.getVoiceItem();
        if (r116 == null) goto L31;
        String r117 = r116.getId();
    L33:
        if (Intrinsics.areEqual(r115, r117) == true) goto L37;
        r113 = r113 + 1;
    L37:
        FLogger.f375446a.i(this.f376939d, "[removeVoice] list:" + r110 + ", remove:" + r110 + ", index:" + r113);
        if (r113 != (-1)) goto L40;
        return;
    L40:
        int r118 = getChildCount();
        if (r118 != 1) goto L43;
        VoiceMixSingleView r119 = this.f376940e;
        if (r119 == null) goto L66;
        removeView(r119);
    L66:
        if (Intrinsics.areEqual(r111, "from_mix") == false) goto L71;
        Function1<? super MixVoice, Unit> r120 = this.f376941f;
        if (r120 == null) goto L71;
        r120.invoke(r110);
    L71:
        if (this.f376949n == false) goto L74;
    L76:
        this.f376951p.invoke(Integer.valueOf(getChildCount()), Boolean.valueOf(r112));
        return;
    L74:
        if (getChildCount() != 1) goto L76;
        r112 = true;
        goto L76
    L43:
        if (r118 == 2) goto L45;
        removeViewAt(r113);
        goto L66
    L45:
        removeAllViews();
        Iterator<T> r121 = r108.iterator();
    L47:
        if (r121.hasNext() == false) goto L59;
        Object r122 = r121.next();
        SpeakerVoice r123 = ((MixVoice) r122).getVoiceItem();
        if (r123 == null) goto L51;
        String r124 = r123.getId();
    L52:
        SpeakerVoice r125 = r110.getVoiceItem();
        if (r125 == null) goto L55;
        String r126 = r125.getId();
    L57:
        if ((!Intrinsics.areEqual(r124, r126)) == false) goto L47;
        r101 = r122;
        goto L59
    L55:
        r126 = null;
        goto L57
    L51:
        r124 = null;
    L59:
        MixVoice r127 = (MixVoice) r101;
        if (r127 == null) goto L66;
        b(r127);
        goto L66
    L31:
        r117 = null;
        goto L33
    L27:
        r115 = null;
        goto L28
    L36:
        r113 = -1;
        goto L37
    L12:
        r106 = null;
        goto L14
    L8:
        r104 = null;
        goto L9
    L16:
        r102 = null;
        goto L17
    }

    public VoiceMixedView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "aContext");
        super(r100, r101, r102);
        this.f376936a = r100;
        this.f376937b = r101;
        this.f376938c = r102;
        this.f376939d = "VoiceMixedView";
        this.f376945j = AppBarLayoutStateListener.State.EXPANDED;
        this.f376946k = new ArrayList();
        this.f376947l = "";
        this.f376948m = new e0();
        this.f376950o = new f0();
        this.f376951p = new g0();
        this.f376952q = new h0();
        setOrientation(1);
    }

    public /* synthetic */ VoiceMixedView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
