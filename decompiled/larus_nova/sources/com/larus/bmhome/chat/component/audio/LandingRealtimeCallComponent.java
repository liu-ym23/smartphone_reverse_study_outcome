package com.larus.bmhome.chat.component.audio;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.ui.arch.component.external.api.feature.ComponentFeature;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0014H\u0002R\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018¨\u0006!"}, d2 = {"Lcom/larus/bmhome/chat/component/audio/LandingRealtimeCallComponent;", "Lcom/larus/ui/arch/component/external/api/feature/ComponentFeature;", "Lcom/larus/ui/arch/component/external/Component;", "<init>", "()V", "chatConversationAbility", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "getChatConversationAbility", "()Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility;", "chatConversationAbility$delegate", "Lkotlin/Lazy;", "chatArgumentData", "Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "getChatArgumentData", "()Lcom/larus/bmhome/chat/component/vdata/ChatArgumentData;", "chatArgumentData$delegate", "onConversationChanged", "Lcom/larus/bmhome/chat/component/cvs/IChatConversationAbility$ChangeListener;", "Lcom/larus/im/bean/conversation/Conversation;", "onBotChanged", "Lcom/larus/im/bean/bot/BotModel;", "fixTouristEnable", "", "getFixTouristEnable", "()Z", "fixTouristEnable$delegate", WidgetCostModule.TYPE_ON_CREATE, "", "observeConversationAndBot", LiveCommonConstants.REASON_ON_DEDTROY, "checkIfStartRealtimeCall", "conversation", "bot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LandingRealtimeCallComponent extends ComponentFeature {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f297921h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f297922i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public e f297923j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f297924k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f297925l;

    /* JADX INFO: loaded from: classes25.dex */
    public static final class a implements Observer, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f297926a;

        public a(d r100) {
            Intrinsics.checkNotNullParameter(r100, "function");
            this.f297926a = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r100 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r100).getFunctionDelegate());
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> getFunctionDelegate() {
            return this.f297926a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        @Override // androidx.lifecycle.Observer
        public final /* synthetic */ void onChanged(Object r100) {
            this.f297926a.invoke(r100);
        }
    }

    /* JADX WARN: Type inference failed for: r3v2, types: [com.larus.bmhome.chat.component.audio.d] */
    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onCreate() {
        final MutableLiveData r100 = new MutableLiveData();
        final MutableLiveData r101 = new MutableLiveData();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "another");
        final MediatorLiveData r102 = new MediatorLiveData();
        r102.addSource(r100, new com.larus.utils.livedata.d(new com.larus.utils.livedata.b(r102, r101)));
        r102.addSource(r101, new com.larus.utils.livedata.d(new com.larus.utils.livedata.c(r102, r100)));
        r102.observe(this, new a(new d(this)));
        this.f297923j = new e(r100);
        this.f297924k = new f(r101);
        y r103 = (y) this.f297921h.getValue();
        if (r103 == null) goto L5;
        y.b.b(r103, this.f297923j);
    L5:
        y r104 = (y) this.f297921h.getValue();
        if (r104 == null) goto L9;
        y.b.a(r104, this.f297924k);
        return;
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void onDestroy() {
        y r100 = (y) this.f297921h.getValue();
        if (r100 == null) goto L5;
        r100.lQ(this.f297923j);
    L5:
        y r101 = (y) this.f297921h.getValue();
        if (r101 == null) goto L9;
        r101.lQ(this.f297924k);
        return;
    }

    public LandingRealtimeCallComponent() {
        this.f297921h = LazyKt.lazy(new com.larus.bmhome.chat.component.audio.a(this));
        this.f297922i = LazyKt.lazy(new b(this));
        this.f297925l = LazyKt.lazy(new c());
    }
}
