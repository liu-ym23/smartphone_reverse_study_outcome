package com.bytedance.ee.bear.share.notification;

import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.ignition.widget.setting_group.SettingGroupLayout;
import com.larksuite.component.universe_design.switch.UDSwitch;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.doc.IFetchRemindCallback;
import com.ss.android.lark.doc.IPutRemindCallback;
import com.ss.android.lark.doc.IRemindStateChangeListener;
import com.ss.android.lark.doc.IReminder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0004./01B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0014J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\"H\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;", "Landroid/widget/RelativeLayout;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shareNotificationSwitchFromXml", "Lcom/larksuite/component/universe_design/switch/UDSwitch;", "getShareNotificationSwitchFromXml", "()Lcom/larksuite/component/universe_design/switch/UDSwitch;", "setShareNotificationSwitchFromXml", "(Lcom/larksuite/component/universe_design/switch/UDSwitch;)V", "docFeedId", "", "reminder", "Lcom/ss/android/lark/doc/IReminder;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "remindStateChangeListener", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IRemindStateChangeListenerImpl;", "fetchRemindCallback", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IFetchRemindCallbackImpl;", "putRemindCallback", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IPutRemindCallbackImpl;", "notifyLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "init", "", "setInfo", "setMargin", "margin", "initNotification", "onDetachedFromWindow", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "setRemindState", "IFetchRemindCallbackImpl", "IRemindStateChangeListenerImpl", "IPutRemindCallbackImpl", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareNotifySetView extends RelativeLayout implements CompoundButton.OnCheckedChangeListener {
    public UDSwitch a;
    public String b;
    public IReminder c;
    public b d;
    public IRemindStateChangeListenerImpl e;
    public IFetchRemindCallbackImpl f;
    public IPutRemindCallbackImpl g;
    public SpaceSettingGroupLayout h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IFetchRemindCallbackImpl;", "Lcom/ss/android/lark/doc/IFetchRemindCallback$Stub;", "<init>", "(Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;)V", "onSuccess", "", "feedDocId", "", "remind", "", "onFaile", "code", "", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IFetchRemindCallbackImpl extends IFetchRemindCallback.Stub {
        final /* synthetic */ ShareNotifySetView this$0;

        public static final class a implements Runnable {
            public final /* synthetic */ ShareNotifySetView a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ String c;

            public a(ShareNotifySetView r1, boolean r2, String r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            L19:
                return;
            L3:
                if (this.a.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                if (this.b != this.a.getShareNotificationSwitchFromXml().isChecked()) goto L7;
                return;
            L7:
                if (TextUtils.equals(this.a.b, this.c) == false) goto L18;
                this.a.getShareNotificationSwitchFromXml().setChecked(this.b);     // Catch: Throwable -> L10
                return;
            }
        }

        public IFetchRemindCallbackImpl(ShareNotifySetView r1) {
            this.this$0 = r1;
        }

        public void onFaile(int r2) {
            tt5.a.d("ShareNotifySetView", "remind getState fail");
        }

        public void onSuccess(String r3, boolean r4) {
            m.a(new a(this.this$0, r4, r3));
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IPutRemindCallbackImpl;", "Lcom/ss/android/lark/doc/IPutRemindCallback$Stub;", "<init>", "(Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;)V", "onSuccess", "", "docFeedId", "", "onFaile", "code", "", "registerRemindListener", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IPutRemindCallbackImpl extends IPutRemindCallback.Stub {
        final /* synthetic */ ShareNotifySetView this$0;

        private final void registerRemindListener() {
        L11:
            th = move-exception;
            tt5.a.e("ShareNotifySetView", "IPutRemindCallbackImpl registerRemindListener error", th, false);
            return;
        L3:
            if (this.this$0.isAttachedToWindow() == false) goto L16;
            ShareNotifySetView r0 = this.this$0;     // Catch: Throwable -> L11
            IReminder r1 = r0.c;     // Catch: Throwable -> L11
            if (r1 == null) goto L17;
            IRemindStateChangeListenerImpl r2 = r0.e;     // Catch: Throwable -> L11
            if (r2 == null) goto L18;
            if (r1 == null) goto L19;
            r1.registerRemindListener(r2);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        }

        public IPutRemindCallbackImpl(ShareNotifySetView r1) {
            this.this$0 = r1;
        }

        public void onFaile(int r3) {
            tt5.a.d("ShareNotifySetView", " remind set failed, code = " + r3);
            registerRemindListener();
        }

        public void onSuccess(String r2) {
            tt5.a.h("ShareNotifySetView", " remind set success");
            registerRemindListener();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IRemindStateChangeListenerImpl;", "Lcom/ss/android/lark/doc/IRemindStateChangeListener$Stub;", "<init>", "(Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;)V", "onChange", "", "feedId", "", "isRemind", "", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IRemindStateChangeListenerImpl extends IRemindStateChangeListener.Stub {
        final /* synthetic */ ShareNotifySetView this$0;

        public static final class a implements Runnable {
            public final /* synthetic */ ShareNotifySetView a;
            public final /* synthetic */ boolean b;
            public final /* synthetic */ String c;

            public a(ShareNotifySetView r1, boolean r2, String r3) {
                this.a = r1;
                this.b = r2;
                this.c = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
            L10:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L19;
                throw th;
            L19:
                return;
            L3:
                if (this.a.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                if (this.b != this.a.getShareNotificationSwitchFromXml().isChecked()) goto L7;
                return;
            L7:
                if (TextUtils.equals(this.a.b, this.c) == false) goto L18;
                this.a.getShareNotificationSwitchFromXml().setChecked(this.b);     // Catch: Throwable -> L10
                return;
            }
        }

        public IRemindStateChangeListenerImpl(ShareNotifySetView r1) {
            this.this$0 = r1;
        }

        public void onChange(String r3, boolean r4) {
            m.a(new a(this.this$0, r4, r3));
        }
    }

    public static final class a {
    }

    static {
    }

    public final UDSwitch getShareNotificationSwitchFromXml() {
        UDSwitch r0 = this.a;
        if (r0 != null) goto L6;
        r0 = findViewById(2131386053);
        this.a = r0;
    L6:
        return r0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IRemindStateChangeListenerImpl r0 = this.e;     // Catch: Throwable -> L10
        if (r0 == null) goto L8;
        IReminder r1 = this.c;     // Catch: Throwable -> L10
        if (r1 == null) goto L8;
        r1.unRegisterRemindListener(r0);     // Catch: Throwable -> L10
    L8:
        this.c = null;     // Catch: Throwable -> L10
        this.e = null;     // Catch: Throwable -> L10
        this.g = null;     // Catch: Throwable -> L10
        this.f = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "unRegisterRemindListener error", th, false);
    }

    public ShareNotifySetView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public final void setMargin(int r3) {
        SettingGroupLayout r0 = this.h;
        if (r0 == null) goto L5;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
    L7:
        if ((r1 instanceof RelativeLayout.LayoutParams) == false) goto L12;
        ((RelativeLayout.LayoutParams) r1).setMargins(r3, r3, r3, r3);
        SettingGroupLayout r4 = this.h;
        if (r4 == null) goto L13;
        r4.setLayoutParams(r1);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r1 = null;
        goto L7
    }

    public final void setShareNotificationSwitchFromXml(UDSwitch r1) {
        this.a = r1;
    }

    public ShareNotifySetView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    public final void a(String r3, IReminder r4) {
        Intrinsics.checkNotNullParameter(r3, "docFeedId");
        this.b = r3;
        this.c = r4;
        boolean r5 = true;
        if (r4 == null) goto L9;
        IBinder r6 = r4.asBinder();
        if (r6 == null) goto L9;
        if (r6.isBinderAlive() != true) goto L9;
        boolean r7 = true;
    L10:
        if (r7 == true) goto L12;
    L14:
        r5 = false;
    L15:
        if (r5 == false) goto L17;
        int r8 = 0;
    L18:
        setVisibility(r8);
        if (r5 == true) goto L21;
        return;
    L21:
        if (this.f != null) goto L24;
        this.f = new IFetchRemindCallbackImpl(this);
    L24:
        if (this.e != null) goto L27;
        this.e = new IRemindStateChangeListenerImpl(this);
    L27:
        if (this.d != null) goto L39;
        this.d = new b(this);
    L39:
        IReminder r9 = this.c;     // Catch: Throwable -> L36
        if (r9 == null) goto L32;
        r9.getRemindState(this.b, this.f);     // Catch: Throwable -> L36
    L32:
        IReminder r10 = this.c;     // Catch: Throwable -> L36
        if (r10 == null) goto L42;
        r10.registerRemindListener(this.e);     // Catch: Throwable -> L36
        return;
    L42:
        return;
    L36:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "init notification error", th, false);
        return;
    L17:
        r8 = 8;
        goto L18
    L12:
        if (TextUtils.isEmpty(this.b) == true) goto L14;
    L9:
        r7 = false;
        goto L10
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r5, "buttonView");
        tt5.a.h("ShareNotifySetView", "set remind state: " + getShareNotificationSwitchFromXml().isChecked());
        IReminder r0 = this.c;     // Catch: Throwable -> L24
        if (r0 == null) goto L10;
        IBinder r1 = r0.asBinder();     // Catch: Throwable -> L24
        if (r1 == null) goto L10;
        boolean r2 = true;
        if (r1.isBinderAlive() != true) goto L10;
    L11:
        if (r2 == true) goto L13;
        return;
    L13:
        if (this.g != null) goto L15;
        this.g = new IPutRemindCallbackImpl(this);     // Catch: Throwable -> L24
    L15:
        IRemindStateChangeListenerImpl r3 = this.e;     // Catch: Throwable -> L24
        if (r3 == null) goto L20;
        IReminder r4 = this.c;     // Catch: Throwable -> L24
        if (r4 == null) goto L20;
        r4.registerRemindListener(r3);     // Catch: Throwable -> L24
    L20:
        IReminder r7 = this.c;     // Catch: Throwable -> L24
        if (r7 == null) goto L30;
        r7.setRemind(this.b, getShareNotificationSwitchFromXml().isChecked(), this.g);     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L10:
        r2 = false;
    L24:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "setRemindState error", th, false);
    }

    public ShareNotifySetView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = "";
        this.h = (SpaceSettingGroupLayout) LayoutInflater.from(r2).inflate(2131564516, this).findViewById(2131381066);
        getShareNotificationSwitchFromXml().setOnCheckedChangeListener(this);
    }
}
