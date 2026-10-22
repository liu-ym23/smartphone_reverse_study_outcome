package com.bytedance.ee.bear.slide.presentation;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import sa5.d;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0003\u0014\u0015\u0016B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0006\u0010\u0011\u001a\u00020\fJ\u001c\u0010\u0012\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/bytedance/ee/bear/slide/presentation/FullAndExitStagePlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "presentationLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "backPressCount", "", "getPresentationLiveData", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "exitPresentationMode", "onDetachFromUIContainer", "onBackPressed", "Companion", "SlidesStateChangedHandler", "SetFullscreenData", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullAndExitStagePlugin extends DocumentPlugin implements d {
    public static final a Companion = null;
    private static final int MAX_BACK_PRESS_COUNT = 0;
    private static final String ON_PRESENTATION_EXIT = null;
    private static final String SLIDE_STATE_CHANGED = null;
    private static final String TAG = null;
    private int backPressCount;
    private final MutableLiveData<Boolean> presentationLiveData;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/slide/presentation/FullAndExitStagePlugin$SetFullscreenData;", "Lcom/bytedance/ee/util/io/NonProguard;", "states", "", "<init>", "(Ljava/lang/String;)V", "getStates", "()Ljava/lang/String;", "setStates", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "docs-slide_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SetFullscreenData implements NonProguard {
        private String states;

        public SetFullscreenData() {
            String r0 = null;
            this(r0, 1, r0);
        }

        public static /* synthetic */ SetFullscreenData copy$default(SetFullscreenData r0, String r1, int r2, Object r3) {
            if ((r2 & 1) == 0) goto L6;
            r1 = r0.states;
        L6:
            return r0.copy(r1);
        }

        public final String component1() {
            return this.states;
        }

        public final SetFullscreenData copy(String r2) {
            return new SetFullscreenData(r2);
        }

        public boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof SetFullscreenData) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.states, ((SetFullscreenData) r4).states) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            String r0 = this.states;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "SetFullscreenData(states=" + this.states + ')';
        }

        public final String getStates() {
            return this.states;
        }

        public SetFullscreenData(String r1) {
            this.states = r1;
        }

        public final void setStates(String r1) {
            this.states = r1;
        }

        public /* synthetic */ SetFullscreenData(String r1, int r2, DefaultConstructorMarker r3) {
            if ((r2 & 1) == 0) goto L5;
            r1 = null;
        L5:
            this(r1);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<SetFullscreenData> {
        public final /* synthetic */ FullAndExitStagePlugin a;

        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2.-CC.$default$authType(this);
        }

        public b(FullAndExitStagePlugin r1) {
            this.a = r1;
        }

        public final void handle(Object r4, m r5) {
            SetFullscreenData r6 = (SetFullscreenData) r4;
            if (r6 != null) goto L5;
            FullAndExitStagePlugin.Companion.getClass();
            tt5.a.h(FullAndExitStagePlugin.access$getTAG$cp(), "handle: data is null");
            return;
        L5:
            FullAndExitStagePlugin.access$setBackPressCount$p(this.a, 0);
            boolean r7 = Intrinsics.areEqual("presentation", r6.getStates());
            FullAndExitStagePlugin.access$getPresentationLiveData$p(this.a).postValue(Boolean.valueOf(r7));
            FullAndExitStagePlugin.Companion.getClass();
            tt5.a.h(FullAndExitStagePlugin.access$getTAG$cp(), "Slides state changed to: " + r6.getStates() + ", isPresentation: " + r7);
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    static {
        Companion = new a();
        TAG = "FullAndExitStagePlugin";
        SLIDE_STATE_CHANGED = "biz.notify.slidesStateChanged";
        ON_PRESENTATION_EXIT = "window.lark.biz.notify.onPresentationExit";
        MAX_BACK_PRESS_COUNT = 3;
    }

    public FullAndExitStagePlugin() {
        this.presentationLiveData = new MutableLiveData(Boolean.FALSE);
    }

    public final void exitPresentationMode() {
        k r0 = getWeb();
        if (r0 == null) goto L5;
        r0.execJS(ON_PRESENTATION_EXIT);
    L5:
        tt5.a.h(TAG, "Exited presentation mode");
    }

    public boolean onBackPressed() {
        if (Intrinsics.areEqual(getPresentationLiveData().getValue(), Boolean.TRUE) == true) goto L5;
    L7:
        boolean r1 = false;
        this.backPressCount = 0;
    L8:
        tt5.a.h(TAG, "onBackPressed(), result = " + r1);
        return r1;
    L5:
        if (this.backPressCount >= MAX_BACK_PRESS_COUNT) goto L7;
        exitPresentationMode();
        r1 = true;
        this.backPressCount++;
        goto L8
    }

    public static final /* synthetic */ int access$getMAX_BACK_PRESS_COUNT$cp() {
        return MAX_BACK_PRESS_COUNT;
    }

    public static final /* synthetic */ String access$getON_PRESENTATION_EXIT$cp() {
        return ON_PRESENTATION_EXIT;
    }

    public static final /* synthetic */ String access$getSLIDE_STATE_CHANGED$cp() {
        return SLIDE_STATE_CHANGED;
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final MutableLiveData<Boolean> getPresentationLiveData() {
        return this.presentationLiveData;
    }

    public static final /* synthetic */ MutableLiveData access$getPresentationLiveData$p(FullAndExitStagePlugin r0) {
        return r0.presentationLiveData;
    }

    public static final /* synthetic */ void access$setBackPressCount$p(FullAndExitStagePlugin r0, int r1) {
        r0.backPressCount = r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r1, r2);
        bindBridgeHandler(SLIDE_STATE_CHANGED, new b(this));
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super/*com.bytedance.ee.bear.browser.BaseWebPlugin*/.onDetachFromUIContainer(r1, r2);
    }
}
