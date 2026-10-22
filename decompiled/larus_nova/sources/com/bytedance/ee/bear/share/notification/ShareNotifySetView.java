package com.bytedance.ee.bear.share.notification;

import android.content.Context;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import androidx.core.app.NotificationCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.ee.bear.widgets.universedesign.SpaceSettingGroupLayout;
import com.bytedance.ee.util.ui.m;
import com.larksuite.component.universe_design.p010switch.UDSwitch;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.doc.IFetchRemindCallback;
import com.ss.android.lark.doc.IPutRemindCallback;
import com.ss.android.lark.doc.IRemindStateChangeListener;
import com.ss.android.lark.doc.IReminder;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0004./01B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0005\u0010\tB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\u0005\u0010\fJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020\u000bJ\b\u0010&\u001a\u00020\"H\u0002J\b\u0010'\u001a\u00020\"H\u0014J\u0018\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\"H\u0002R\u001e\u0010\r\u001a\u0004\u0018\u00010\u000e8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0018\u00010\u001aR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0018\u00010\u001cR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0018\u00010\u001eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;", "Landroid/widget/RelativeLayout;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "shareNotificationSwitchFromXml", "Lcom/larksuite/component/universe_design/switch/UDSwitch;", "getShareNotificationSwitchFromXml", "()Lcom/larksuite/component/universe_design/switch/UDSwitch;", "setShareNotificationSwitchFromXml", "(Lcom/larksuite/component/universe_design/switch/UDSwitch;)V", "docFeedId", "", NotificationCompat.CATEGORY_REMINDER, "Lcom/ss/android/lark/doc/IReminder;", "deathRecipient", "Landroid/os/IBinder$DeathRecipient;", "remindStateChangeListener", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IRemindStateChangeListenerImpl;", "fetchRemindCallback", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IFetchRemindCallbackImpl;", "putRemindCallback", "Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IPutRemindCallbackImpl;", "notifyLayout", "Lcom/bytedance/ee/bear/widgets/universedesign/SpaceSettingGroupLayout;", "init", "", "setInfo", "setMargin", GXTemplateKey.FLEXBOX_MARGIN, "initNotification", "onDetachedFromWindow", "onCheckedChanged", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "setRemindState", "IFetchRemindCallbackImpl", "IRemindStateChangeListenerImpl", "IPutRemindCallbackImpl", "Companion", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShareNotifySetView extends RelativeLayout implements CompoundButton.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public UDSwitch f237246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f237247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IReminder f237248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f237249d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IRemindStateChangeListenerImpl f237250e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public IFetchRemindCallbackImpl f237251f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public IPutRemindCallbackImpl f237252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public SpaceSettingGroupLayout f237253h;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IFetchRemindCallbackImpl;", "Lcom/ss/android/lark/doc/IFetchRemindCallback$Stub;", "<init>", "(Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;)V", "onSuccess", "", "feedDocId", "", "remind", "", "onFaile", "code", "", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IFetchRemindCallbackImpl extends IFetchRemindCallback.Stub {
        final /* synthetic */ ShareNotifySetView this$0;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShareNotifySetView f237254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f237255b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f237256c;

            public a(ShareNotifySetView r100, boolean r101, String r102) {
                this.f237254a = r100;
                this.f237255b = r101;
                this.f237256c = r102;
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
                if (this.f237254a.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                if (this.f237255b != this.f237254a.getShareNotificationSwitchFromXml().isChecked()) goto L7;
                return;
            L7:
                if (TextUtils.equals(this.f237254a.f237247b, this.f237256c) == false) goto L18;
                this.f237254a.getShareNotificationSwitchFromXml().setChecked(this.f237255b);     // Catch: Throwable -> L10
                return;
            }
        }

        public IFetchRemindCallbackImpl(ShareNotifySetView r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.android.lark.doc.IFetchRemindCallback
        public void onFaile(int r100) {
            tt5.a.d("ShareNotifySetView", "remind getState fail");
        }

        @Override // com.ss.android.lark.doc.IFetchRemindCallback
        public void onSuccess(String r100, boolean r101) {
            m.a(new a(this.this$0, r101, r100));
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
            ShareNotifySetView r100 = this.this$0;     // Catch: Throwable -> L11
            IReminder r101 = r100.f237248c;     // Catch: Throwable -> L11
            if (r101 == null) goto L17;
            IRemindStateChangeListenerImpl r102 = r100.f237250e;     // Catch: Throwable -> L11
            if (r102 == null) goto L18;
            if (r101 == null) goto L19;
            r101.registerRemindListener(r102);     // Catch: Throwable -> L11
            return;
        L19:
            return;
        L18:
            return;
        L17:
            return;
        }

        public IPutRemindCallbackImpl(ShareNotifySetView r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.android.lark.doc.IPutRemindCallback
        public void onFaile(int r100) {
            tt5.a.d("ShareNotifySetView", " remind set failed, code = " + r100);
            registerRemindListener();
        }

        @Override // com.ss.android.lark.doc.IPutRemindCallback
        public void onSuccess(String r100) {
            tt5.a.h("ShareNotifySetView", " remind set success");
            registerRemindListener();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView$IRemindStateChangeListenerImpl;", "Lcom/ss/android/lark/doc/IRemindStateChangeListener$Stub;", "<init>", "(Lcom/bytedance/ee/bear/share/notification/ShareNotifySetView;)V", "onChange", "", "feedId", "", "isRemind", "", "features-share-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class IRemindStateChangeListenerImpl extends IRemindStateChangeListener.Stub {
        final /* synthetic */ ShareNotifySetView this$0;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ShareNotifySetView f237257a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ boolean f237258b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f237259c;

            public a(ShareNotifySetView r100, boolean r101, String r102) {
                this.f237257a = r100;
                this.f237258b = r101;
                this.f237259c = r102;
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
                if (this.f237257a.isAttachedToWindow() == true) goto L5;
                return;
            L5:
                if (this.f237258b != this.f237257a.getShareNotificationSwitchFromXml().isChecked()) goto L7;
                return;
            L7:
                if (TextUtils.equals(this.f237257a.f237247b, this.f237259c) == false) goto L18;
                this.f237257a.getShareNotificationSwitchFromXml().setChecked(this.f237258b);     // Catch: Throwable -> L10
                return;
            }
        }

        public IRemindStateChangeListenerImpl(ShareNotifySetView r100) {
            this.this$0 = r100;
        }

        @Override // com.ss.android.lark.doc.IRemindStateChangeListener
        public void onChange(String r100, boolean r101) {
            m.a(new a(this.this$0, r101, r100));
        }
    }

    public static final class a {
    }

    static {
    }

    public final UDSwitch getShareNotificationSwitchFromXml() {
        KeyEvent.Callback r100 = this.f237246a;
        if (r100 != null) goto L6;
        r100 = findViewById(R.id.shareNotificationSwitch);
        this.f237246a = (UDSwitch) r100;
    L6:
        return (UDSwitch) r100;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        IRemindStateChangeListenerImpl r100 = this.f237250e;     // Catch: Throwable -> L10
        if (r100 == null) goto L8;
        IReminder r101 = this.f237248c;     // Catch: Throwable -> L10
        if (r101 == null) goto L8;
        r101.unRegisterRemindListener(r100);     // Catch: Throwable -> L10
    L8:
        this.f237248c = null;     // Catch: Throwable -> L10
        this.f237250e = null;     // Catch: Throwable -> L10
        this.f237252g = null;     // Catch: Throwable -> L10
        this.f237251f = null;     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "unRegisterRemindListener error", th, false);
    }

    public ShareNotifySetView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setMargin(int r100) {
        SpaceSettingGroupLayout r101 = this.f237253h;
        if (r101 == null) goto L5;
        ViewGroup.LayoutParams r102 = r101.getLayoutParams();
    L7:
        if ((r102 instanceof RelativeLayout.LayoutParams) == false) goto L12;
        ((RelativeLayout.LayoutParams) r102).setMargins(r100, r100, r100, r100);
        SpaceSettingGroupLayout r103 = this.f237253h;
        if (r103 == null) goto L13;
        r103.setLayoutParams(r102);
        return;
    L13:
        return;
    L12:
        return;
    L5:
        r102 = null;
        goto L7
    }

    public final void setShareNotificationSwitchFromXml(UDSwitch r100) {
        this.f237246a = r100;
    }

    public ShareNotifySetView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    public final void a(String r100, IReminder r101) {
        Intrinsics.checkNotNullParameter(r100, "docFeedId");
        this.f237247b = r100;
        this.f237248c = r101;
        boolean r102 = true;
        if (r101 == null) goto L9;
        IBinder r103 = r101.asBinder();
        if (r103 == null) goto L9;
        if (r103.isBinderAlive() != true) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L12;
    L14:
        r102 = false;
    L15:
        if (r102 == false) goto L17;
        int r105 = 0;
    L18:
        setVisibility(r105);
        if (r102 == true) goto L21;
        return;
    L21:
        if (this.f237251f != null) goto L24;
        this.f237251f = new IFetchRemindCallbackImpl(this);
    L24:
        if (this.f237250e != null) goto L27;
        this.f237250e = new IRemindStateChangeListenerImpl(this);
    L27:
        if (this.f237249d != null) goto L39;
        this.f237249d = new b(this);
    L39:
        IReminder r106 = this.f237248c;     // Catch: Throwable -> L36
        if (r106 == null) goto L32;
        r106.getRemindState(this.f237247b, this.f237251f);     // Catch: Throwable -> L36
    L32:
        IReminder r107 = this.f237248c;     // Catch: Throwable -> L36
        if (r107 == null) goto L42;
        r107.registerRemindListener(this.f237250e);     // Catch: Throwable -> L36
        return;
    L42:
        return;
    L36:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "init notification error", th, false);
        return;
    L17:
        r105 = 8;
        goto L18
    L12:
        if (TextUtils.isEmpty(this.f237247b) == true) goto L14;
    L9:
        r104 = false;
        goto L10
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "buttonView");
        tt5.a.h("ShareNotifySetView", "set remind state: " + getShareNotificationSwitchFromXml().isChecked());
        IReminder r102 = this.f237248c;     // Catch: Throwable -> L24
        if (r102 == null) goto L10;
        IBinder r103 = r102.asBinder();     // Catch: Throwable -> L24
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.isBinderAlive() != true) goto L10;
    L11:
        if (r104 == true) goto L13;
        return;
    L13:
        if (this.f237252g != null) goto L15;
        this.f237252g = new IPutRemindCallbackImpl(this);     // Catch: Throwable -> L24
    L15:
        IRemindStateChangeListenerImpl r105 = this.f237250e;     // Catch: Throwable -> L24
        if (r105 == null) goto L20;
        IReminder r106 = this.f237248c;     // Catch: Throwable -> L24
        if (r106 == null) goto L20;
        r106.registerRemindListener(r105);     // Catch: Throwable -> L24
    L20:
        IReminder r107 = this.f237248c;     // Catch: Throwable -> L24
        if (r107 == null) goto L30;
        r107.setRemind(this.f237247b, getShareNotificationSwitchFromXml().isChecked(), this.f237252g);     // Catch: Throwable -> L24
        return;
    L30:
        return;
    L10:
        r104 = false;
    L24:
        th = move-exception;
        tt5.a.e("ShareNotifySetView", "setRemindState error", th, false);
    }

    public ShareNotifySetView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f237247b = "";
        this.f237253h = (SpaceSettingGroupLayout) LayoutInflater.from(r100).inflate(R.layout.share_notification_layout, this).findViewById(R.id.notifyLayout);
        getShareNotificationSwitchFromXml().setOnCheckedChangeListener(this);
    }
}
