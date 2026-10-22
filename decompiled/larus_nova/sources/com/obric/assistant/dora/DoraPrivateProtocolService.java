package com.obric.assistant.dora;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000k\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007*\u0003\r\u0010\u0013\u0018\u0000 12\u00020\u0001:\u0003123B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0012\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020!H\u0002J\u0018\u0010\"\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010$\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(H\u0002J\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*2\u0006\u0010,\u001a\u00020-H\u0002J\u000e\u0010.\u001a\u0004\u0018\u00010+*\u00020\nH\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\b2\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u00100\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\nH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u00064"}, d2 = {"Lcom/obric/assistant/dora/DoraPrivateProtocolService;", "Landroid/app/Service;", "<init>", "()V", "callbacks", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/obric/assistant/dora/DoraPrivateProtocolService$CallbackRegistration;", "latestConnectionState", "", "latestDeviceInfo", "Lcom/obric/assistant/dora/DoraDeviceInfo;", "currentConnectionState", "binder", "com/obric/assistant/dora/DoraPrivateProtocolService$binder$1", "Lcom/obric/assistant/dora/DoraPrivateProtocolService$binder$1;", "doraLinkCallback", "com/obric/assistant/dora/DoraPrivateProtocolService$doraLinkCallback$1", "Lcom/obric/assistant/dora/DoraPrivateProtocolService$doraLinkCallback$1;", "doraBudsCallback", "com/obric/assistant/dora/DoraPrivateProtocolService$doraBudsCallback$1", "Lcom/obric/assistant/dora/DoraPrivateProtocolService$doraBudsCallback$1;", WidgetCostModule.TYPE_ON_CREATE, "", LiveCommonConstants.REASON_ON_DEDTROY, "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "updateKeepAliveLevelOverlayByConnectionState", "state", "getCurrentDeviceInfoFromAdapter", "convertToDoraDeviceInfo", "device", "Lcom/bytedance/dora/device/DoraDevice;", "notifyConnectionStateChanged", "deviceInfo", "notifyBatteryChanged", "notifyChargeStateChanged", "removeCallback", "callback", "Lcom/obric/assistant/dora/IDoraPrivateProtocolCallback;", "parseDeviceTypes", "", "Lcom/obric/assistant/dora/DoraPrivateProtocolService$BatteryDeviceType;", "extra", "", "toBatteryDeviceType", "updateLatestState", "updateLatestDeviceInfo", "Companion", "CallbackRegistration", "BatteryDeviceType", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraPrivateProtocolService extends Service {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f389092e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<a> f389093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f389094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile DoraDeviceInfo f389095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraPrivateProtocolService$binder$1 f389096d;

    /* JADX INFO: loaded from: classes6.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0082\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/obric/assistant/dora/DoraPrivateProtocolService$BatteryDeviceType;", "", "<init>", "(Ljava/lang/String;I)V", "LITE", "H_FREE_CLIP_2", "H_FREE_BUDS_PRO_5", "G1", "G2", "G_AIR", "G_PIN", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum BatteryDeviceType extends Enum<BatteryDeviceType> {
        public static final a Companion = null;
        public static final BatteryDeviceType G1 = null;
        public static final BatteryDeviceType G2 = null;
        public static final BatteryDeviceType G_AIR = null;
        public static final BatteryDeviceType G_PIN = null;
        public static final BatteryDeviceType H_FREE_BUDS_PRO_5 = null;
        public static final BatteryDeviceType H_FREE_CLIP_2 = null;
        public static final BatteryDeviceType LITE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ BatteryDeviceType[] f389097a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f389098b = null;

        public static final class a {
            public a() {
            }
        }

        public static EnumEntries<BatteryDeviceType> getEntries() {
            return f389098b;
        }

        static {
            BatteryDeviceType r100 = new BatteryDeviceType("LITE", 0);
            LITE = r100;
            BatteryDeviceType r101 = new BatteryDeviceType("H_FREE_CLIP_2", 1);
            H_FREE_CLIP_2 = r101;
            BatteryDeviceType r102 = new BatteryDeviceType("H_FREE_BUDS_PRO_5", 2);
            H_FREE_BUDS_PRO_5 = r102;
            BatteryDeviceType r103 = new BatteryDeviceType("G1", 3);
            G1 = r103;
            BatteryDeviceType r104 = new BatteryDeviceType("G2", 4);
            G2 = r104;
            BatteryDeviceType r105 = new BatteryDeviceType("G_AIR", 5);
            G_AIR = r105;
            BatteryDeviceType r110 = new BatteryDeviceType("G_PIN", 6);
            G_PIN = r110;
            BatteryDeviceType[] r111 = {r100, r101, r102, r103, r104, r105, r110};
            f389097a = r111;
            f389098b = EnumEntriesKt.enumEntries(r111);
            Companion = new a();
        }

        public static BatteryDeviceType[] values() {
            return (BatteryDeviceType[]) f389097a.clone();
        }

        public static BatteryDeviceType valueOf(String r100) {
            return (BatteryDeviceType) r27.a.a(BatteryDeviceType.class, r100);
        }

        public BatteryDeviceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final IDoraPrivateProtocolCallback f389099a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<BatteryDeviceType> f389100b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f389099a, r101.f389099a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f389100b, r101.f389100b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f389099a.hashCode() * 31;
            Set<BatteryDeviceType> r101 = this.f389100b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "CallbackRegistration(callback=" + this.f389099a + ", deviceTypes=" + this.f389100b + ')';
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(IDoraPrivateProtocolCallback r100, Set<? extends BatteryDeviceType> r101) {
            Intrinsics.checkNotNullParameter(r100, "callback");
            this.f389099a = r100;
            this.f389100b = r101;
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static final class b {
    }

    static {
    }

    @Override // android.app.Service
    public final void onDestroy() {
        FLogger.f375446a.i("DoraPrivateProtocolSvc", "onDestroy called");
        this.f389093a.clear();
        super.onDestroy();
    }

    public DoraPrivateProtocolService() {
        this.f389093a = new CopyOnWriteArrayList();
        this.f389095c = new DoraDeviceInfo(null, null, null, null, 0, 0, null, 0, 0, 0, 0, 16383);
        this.f389096d = new DoraPrivateProtocolService$binder$1(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        FLogger.f375446a.i("DoraPrivateProtocolSvc", "onCreate called");
        e r100 = e.f389108a;
        Context r101 = getApplicationContext();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (e.f389110c != null) goto L6;
        e.f389110c = r101.getApplicationContext();
        return;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        FLogger.f375446a.i("DoraPrivateProtocolSvc", "onBind called with intent=" + r100);
        return this.f389096d;
    }
}
