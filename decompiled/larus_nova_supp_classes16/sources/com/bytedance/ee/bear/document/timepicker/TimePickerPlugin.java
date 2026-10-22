package com.bytedance.ee.bear.document.timepicker;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.browser.WebPluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00152\u00020\u0001:\u0004\u0015\u0016\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000b0\tH\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0012\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/TimePickerPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "<init>", "()V", "pickerFragment", "Lcom/bytedance/ee/bear/document/timepicker/TimePickerFragment;", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "dismissPickerIfNeed", "Companion", "TimePickerHandler", "TimePickerRequestData", "TimePickerResponseData", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimePickerPlugin extends DocumentPlugin {
    public static final a Companion = null;
    public static final String TAG = "TimePickerPlugin";
    private TimePickerFragment pickerFragment;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/TimePickerPlugin$TimePickerRequestData;", "Lcom/bytedance/ee/util/io/NonProguard;", "hour", "", "minute", "timeBlockId", "", "<init>", "(IILjava/lang/String;)V", "getHour", "()I", "getMinute", "getTimeBlockId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TimePickerRequestData implements NonProguard {
        private final int hour;
        private final int minute;
        private final String timeBlockId;

        public static /* synthetic */ TimePickerRequestData copy$default(TimePickerRequestData r0, int r1, int r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.hour;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.minute;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.timeBlockId;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final int component1() {
            return this.hour;
        }

        public final int component2() {
            return this.minute;
        }

        public final String component3() {
            return this.timeBlockId;
        }

        public final TimePickerRequestData copy(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "timeBlockId");
            return new TimePickerRequestData(r2, r3, r4);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TimePickerRequestData) == true) goto L8;
            return false;
        L8:
            TimePickerRequestData r6 = (TimePickerRequestData) r5;
            if (this.hour == r6.hour) goto L12;
            return false;
        L12:
            if (this.minute == r6.minute) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.timeBlockId, r6.timeBlockId) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.hour * 31) + this.minute) * 31) + this.timeBlockId.hashCode();
        }

        public String toString() {
            return "TimePickerRequestData(hour=" + this.hour + ", minute=" + this.minute + ", timeBlockId=" + this.timeBlockId + ')';
        }

        public final int getHour() {
            return this.hour;
        }

        public final int getMinute() {
            return this.minute;
        }

        public final String getTimeBlockId() {
            return this.timeBlockId;
        }

        public TimePickerRequestData(int r2, int r3, String r4) {
            Intrinsics.checkNotNullParameter(r4, "timeBlockId");
            this.hour = r2;
            this.minute = r3;
            this.timeBlockId = r4;
        }

        public /* synthetic */ TimePickerRequestData(int r2, int r3, String r4, int r5, DefaultConstructorMarker r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L8;
            r3 = 0;
        L8:
            this(r2, r3, r4);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0006HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/document/timepicker/TimePickerPlugin$TimePickerResponseData;", "Lcom/bytedance/ee/util/io/NonProguard;", "hour", "", "minute", JSEventListener.ACTION, "", "timeBlockId", "<init>", "(IILjava/lang/String;Ljava/lang/String;)V", "getHour", "()I", "getMinute", "getAction", "()Ljava/lang/String;", "getTimeBlockId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TimePickerResponseData implements NonProguard {
        private final String action;
        private final int hour;
        private final int minute;
        private final String timeBlockId;

        public static /* synthetic */ TimePickerResponseData copy$default(TimePickerResponseData r0, int r1, int r2, String r3, String r4, int r5, Object r6) {
            if ((r5 & 1) == 0) goto L6;
            r1 = r0.hour;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r2 = r0.minute;
        L9:
            if ((r5 & 4) == 0) goto L12;
            r3 = r0.action;
        L12:
            if ((r5 & 8) == 0) goto L15;
            r4 = r0.timeBlockId;
        L15:
            return r0.copy(r1, r2, r3, r4);
        }

        public final int component1() {
            return this.hour;
        }

        public final int component2() {
            return this.minute;
        }

        public final String component3() {
            return this.action;
        }

        public final String component4() {
            return this.timeBlockId;
        }

        public final TimePickerResponseData copy(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
            return new TimePickerResponseData(r2, r3, r4, r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof TimePickerResponseData) == true) goto L8;
            return false;
        L8:
            TimePickerResponseData r6 = (TimePickerResponseData) r5;
            if (this.hour == r6.hour) goto L12;
            return false;
        L12:
            if (this.minute == r6.minute) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.action, r6.action) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.timeBlockId, r6.timeBlockId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.hour * 31) + this.minute) * 31) + this.action.hashCode()) * 31;
            String r1 = this.timeBlockId;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "TimePickerResponseData(hour=" + this.hour + ", minute=" + this.minute + ", action=" + this.action + ", timeBlockId=" + this.timeBlockId + ')';
        }

        public final String getAction() {
            return this.action;
        }

        public final int getHour() {
            return this.hour;
        }

        public final int getMinute() {
            return this.minute;
        }

        public final String getTimeBlockId() {
            return this.timeBlockId;
        }

        public TimePickerResponseData(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, JSEventListener.ACTION);
            this.hour = r2;
            this.minute = r3;
            this.action = r4;
            this.timeBlockId = r5;
        }

        public /* synthetic */ TimePickerResponseData(int r2, int r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
            if ((r6 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r6 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r5 = null;
        L11:
            this(r2, r3, r4, r5);
        }
    }

    public static final class a {
        public a() {
        }
    }

    public final class b implements i<TimePickerRequestData> {
        public final /* synthetic */ TimePickerPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public b(TimePickerPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r4, m r5) {
            TimePickerRequestData r6 = (TimePickerRequestData) r4;
            StringBuilder r0 = new StringBuilder("handle data=");
            if (r6 == null) goto L5;
            String r1 = r6.toString();
        L6:
            r0.append(du5.b.k(r1));
            tt5.a.h(TimePickerPlugin.TAG, r0.toString());
            com.bytedance.ee.util.ui.m.a(new com.bytedance.ee.bear.document.timepicker.a(this.a, r6, r5));     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            tt5.a.f(TimePickerPlugin.TAG, th, false);
            return;
        L5:
            r1 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    private final void dismissPickerIfNeed() {
        TimePickerFragment r0 = this.pickerFragment;     // Catch: Throwable -> L6
        if (r0 == null) goto L11;
        INVOKEVIRTUAL_com_bytedance_ee_bear_document_timepicker_TimePickerPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(r0);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        tt5.a.f(TAG, th, false);
    }

    public TimePickerPlugin() {
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_bear_document_timepicker_TimePickerPlugin_com_obric_assistant_interaction_impl_window_helpers_DialogFragmentLancet_dismissAllowingStateLoss(TimePickerFragment r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public static final /* synthetic */ void access$dismissPickerIfNeed(TimePickerPlugin r0) {
        r0.dismissPickerIfNeed();
    }

    public static final /* synthetic */ FragmentActivity access$getActivity(TimePickerPlugin r0) {
        return r0.getActivity();
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(TimePickerPlugin r0) {
        return r0.getFragmentManager();
    }

    public static final /* synthetic */ TimePickerFragment access$getPickerFragment$p(TimePickerPlugin r0) {
        return r0.pickerFragment;
    }

    public static final /* synthetic */ boolean access$isUIContainerDetached(TimePickerPlugin r0) {
        return r0.isUIContainerDetached();
    }

    @Override // com.bytedance.ee.bear.document.DocumentPlugin, yv4.a
    public void getBridgeHandlers(Map<String, i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        r3.put("biz.util.showTimePicker", new b(this));
    }

    public void onAttachToHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost");
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        super.onDetachFromHost(r2);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    public static final /* synthetic */ void access$setPickerFragment$p(TimePickerPlugin r0, TimePickerFragment r1) {
        r0.pickerFragment = r1;
    }

    public void onAttachToUIContainer(DocumentPluginHost r1, t r2) {
        super.onAttachToUIContainer(r1, r2);
        dismissPickerIfNeed();
    }

    public void onDetachFromUIContainer(DocumentPluginHost r1, t r2) {
        super.onDetachFromUIContainer(r1, r2);
        dismissPickerIfNeed();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(WebPluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }

    @Override // com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r1, t r2) {
        onDetachFromUIContainer((DocumentPluginHost) r1, r2);
    }
}
