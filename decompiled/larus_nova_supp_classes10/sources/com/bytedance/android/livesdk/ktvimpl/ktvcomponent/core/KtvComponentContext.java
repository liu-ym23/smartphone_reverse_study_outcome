package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.audience.KtvComponentAudienceLogicWidget;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.b;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.d;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import fd2.x;
import java.util.ArrayList;
import java.util.List;
import jd2.g;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0014\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007¢\u0006\u0004\bH\u0010IJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002J\b\u0010\n\u001a\u0004\u0018\u00010\tR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R!\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u000e\u001a\u0004\b\u001c\u0010\u0010R'\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0\u001e0\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\"R!\u0010'\u001a\b\u0012\u0004\u0012\u00020$0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u000e\u001a\u0004\b&\u0010\u0010R!\u0010+\u001a\b\u0012\u0004\u0012\u00020(0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u000e\u001a\u0004\b-\u0010\u0010R!\u00101\u001a\b\u0012\u0004\u0012\u00020\t0\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u000e\u001a\u0004\b0\u0010\u0010R!\u00104\u001a\b\u0012\u0004\u0012\u00020\u00120\u001d8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u000e\u001a\u0004\b3\u0010\"R!\u00107\u001a\b\u0012\u0004\u0012\u00020\u00120\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u000e\u001a\u0004\b6\u0010\u0010R!\u0010;\u001a\b\u0012\u0004\u0012\u0002080\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b9\u0010\u000e\u001a\u0004\b:\u0010\u0010R$\u0010<\u001a\u0004\u0018\u0001088\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010B\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bB\u0010C\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006L"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/core/KtvComponentContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "count", "", "updateSingApplyUnreadCount", "updateListenApplyUnreadCount", "getSingApplyUnreadCount", "getListenApplyUnreadCount", "", "getSource", "Lcom/bytedance/live/datacontext/n;", "Lfd2/x;", "ktvComponentCmd$delegate", "Lcom/bytedance/live/datacontext/p;", "getKtvComponentCmd", "()Lcom/bytedance/live/datacontext/n;", "ktvComponentCmd", "", "ktvComponentStatus$delegate", "getKtvComponentStatus", "ktvComponentStatus", "Ljd2/g;", "enableVideoChorus$delegate", "getEnableVideoChorus", "enableVideoChorus", "", "isAudienceEnableSing$delegate", "isAudienceEnableSing", "Lcom/bytedance/live/datacontext/m;", "", "Lcom/bytedance/android/live/ktv/common/model/bean/d;", "curWaitingUserList$delegate", "getCurWaitingUserList", "()Lcom/bytedance/live/datacontext/m;", "curWaitingUserList", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/dialog/common/setting/b;", "kSongSettingViewModel$delegate", "getKSongSettingViewModel", "kSongSettingViewModel", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/viewmodel/KtvComponentUIContext;", "ktvComponentUIContext$delegate", "getKtvComponentUIContext", "ktvComponentUIContext", "openSource$delegate", "getOpenSource", "openSource", "fromSource$delegate", "getFromSource", "fromSource", "panelState$delegate", "getPanelState", "panelState", "panelTop$delegate", "getPanelTop", "panelTop", "", "ballRelativeY$delegate", "getBallRelativeY", "ballRelativeY", "containerTransY", "Ljava/lang/Float;", "getContainerTransY", "()Ljava/lang/Float;", "setContainerTransY", "(Ljava/lang/Float;)V", "containerRightMargin", "Ljava/lang/Integer;", "getContainerRightMargin", "()Ljava/lang/Integer;", "setContainerRightMargin", "(Ljava/lang/Integer;)V", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvComponentContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final a Companion = null;
    public static final int KTV_COMPONENT_STATUS_OFF = 0;
    public static final int KTV_COMPONENT_STATUS_ON = 1;
    public static final int KTV_COMPONENT_STATUS_OPENNING = 2;
    private final p ballRelativeY$delegate;
    private Integer containerRightMargin;
    private Float containerTransY;
    private final p curWaitingUserList$delegate;
    private final p enableVideoChorus$delegate;
    private final p fromSource$delegate;
    private final p isAudienceEnableSing$delegate;
    private final p kSongSettingViewModel$delegate;
    private final p ktvComponentCmd$delegate;
    private final p ktvComponentStatus$delegate;
    private final p ktvComponentUIContext$delegate;
    private final p openSource$delegate;
    private final p panelState$delegate;
    private final p panelTop$delegate;

    public static final class a {
        public a() {
        }

        public final KtvComponentContext getContext() {
            DataContext r0 = d.d(KtvComponentContext.class);
            if ((r0 instanceof KtvComponentContext) == true) goto L6;
            r0 = null;
        L6:
            return (KtvComponentContext) r0;
        }

        @JvmStatic
        public final MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> a() {
            KtvComponentContext r0 = getContext();
            if (r0 == null) goto L9;
            n<b> r1 = r0.getKSongSettingViewModel();
            if (r1 == null) goto L9;
            b r2 = (b) r1.getValue();
            if (r2 == null) goto L9;
            return r2.obtainKSongSettingKey();
        L9:
            return null;
        }
    }

    @JvmStatic
    public static final MutableLiveData<com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.common.setting.d> obtainKSongSettingKey() {
        return Companion.a();
    }

    public final n<Float> getBallRelativeY() {
        return (n) this.ballRelativeY$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<List<com.bytedance.android.live.ktv.common.model.bean.d>> getCurWaitingUserList() {
        return (m) this.curWaitingUserList$delegate.a(this, $$delegatedProperties[4]);
    }

    public final n<g> getEnableVideoChorus() {
        return (n) this.enableVideoChorus$delegate.a(this, $$delegatedProperties[2]);
    }

    public final n<String> getFromSource() {
        return (n) this.fromSource$delegate.a(this, $$delegatedProperties[8]);
    }

    public final n<b> getKSongSettingViewModel() {
        return (n) this.kSongSettingViewModel$delegate.a(this, $$delegatedProperties[5]);
    }

    public final n<x> getKtvComponentCmd() {
        return (n) this.ktvComponentCmd$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<Integer> getKtvComponentStatus() {
        return (n) this.ktvComponentStatus$delegate.a(this, $$delegatedProperties[1]);
    }

    public final n<KtvComponentUIContext> getKtvComponentUIContext() {
        return (n) this.ktvComponentUIContext$delegate.a(this, $$delegatedProperties[6]);
    }

    public final n<Integer> getOpenSource() {
        return (n) this.openSource$delegate.a(this, $$delegatedProperties[7]);
    }

    public final m<Integer> getPanelState() {
        return (m) this.panelState$delegate.a(this, $$delegatedProperties[9]);
    }

    public final n<Integer> getPanelTop() {
        return (n) this.panelTop$delegate.a(this, $$delegatedProperties[10]);
    }

    public final n<Boolean> isAudienceEnableSing() {
        return (n) this.isAudienceEnableSing$delegate.a(this, $$delegatedProperties[3]);
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "ktvComponentCmd", "getKtvComponentCmd()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "ktvComponentStatus", "getKtvComponentStatus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "enableVideoChorus", "getEnableVideoChorus()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "isAudienceEnableSing", "isAudienceEnableSing()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "curWaitingUserList", "getCurWaitingUserList()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "kSongSettingViewModel", "getKSongSettingViewModel()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "ktvComponentUIContext", "getKtvComponentUIContext()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "openSource", "getOpenSource()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "fromSource", "getFromSource()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "panelState", "getPanelState()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "panelTop", "getPanelTop()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(KtvComponentContext.class, "ballRelativeY", "getBallRelativeY()Lcom/bytedance/live/datacontext/IMutableNullable;", 0))};
        Companion = new a();
    }

    public KtvComponentContext() {
        this.ktvComponentCmd$delegate = q.c(this);
        this.ktvComponentStatus$delegate = q.c(this);
        this.enableVideoChorus$delegate = q.c(this);
        this.isAudienceEnableSing$delegate = q.c(this);
        this.curWaitingUserList$delegate = q.d(this, new ArrayList());
        this.kSongSettingViewModel$delegate = q.c(this);
        this.ktvComponentUIContext$delegate = q.c(this);
        this.openSource$delegate = q.c(this);
        this.fromSource$delegate = q.c(this);
        this.panelState$delegate = q.d(this, 0);
        this.panelTop$delegate = q.c(this);
        this.ballRelativeY$delegate = q.c(this);
    }

    public final long getListenApplyUnreadCount() {
        KtvComponentUIContext r0 = (KtvComponentUIContext) getKtvComponentUIContext().getValue();
        if (r0 == null) goto L7;
        Long r1 = r0.getListenApplyUnreadNum();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public final long getSingApplyUnreadCount() {
        KtvComponentUIContext r0 = (KtvComponentUIContext) getKtvComponentUIContext().getValue();
        if (r0 == null) goto L7;
        Long r1 = r0.getSingApplyUnreadNum();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 0;
    }

    public final String getSource() {
        n<Integer> r0 = getOpenSource();
        if (r0 == null) goto L5;
        Integer r1 = (Integer) r0.getValue();
    L6:
        int r2 = KtvComponentAudienceLogicWidget.OpenSource.AUTO.getValue();
        if (r1 != null) goto L10;
    L12:
        int r3 = KtvComponentAudienceLogicWidget.OpenSource.CHORUS.getValue();
        if (r1 != null) goto L16;
        return null;
    L16:
        if (r1.intValue() != r3) goto L20;
        return "pk_chorus";
    L20:
        return null;
    L10:
        if (r1.intValue() != r2) goto L12;
        return "auto";
    L5:
        r1 = null;
        goto L6
    }

    public final Integer getContainerRightMargin() {
        return this.containerRightMargin;
    }

    public final Float getContainerTransY() {
        return this.containerTransY;
    }

    public final void setContainerRightMargin(Integer r1) {
        this.containerRightMargin = r1;
    }

    public final void setContainerTransY(Float r1) {
        this.containerTransY = r1;
    }

    public final void updateListenApplyUnreadCount(long r2) {
        KtvComponentUIContext r0 = (KtvComponentUIContext) getKtvComponentUIContext().getValue();
        if (r0 == null) goto L6;
        r0.setListenApplyUnreadNum(r2);
        return;
    }

    public final void updateSingApplyUnreadCount(long r2) {
        KtvComponentUIContext r0 = (KtvComponentUIContext) getKtvComponentUIContext().getValue();
        if (r0 == null) goto L6;
        r0.setSingApplyUnreadNum(r2);
        return;
    }
}
