package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue;
import androidx.core.app.NotificationCompat;
import com.alibaba.gaiax.model.GXAnimation;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larksuite.framework.utils.a0;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.component.appcontext.LarkAppContext;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSessionManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0004&'()B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\"\u0010\u0018\u001a\u00020\u00192\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\u0012\u0010\u001f\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010 \u001a\u00020\u0017H\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService;", "Landroid/app/Service;", "<init>", "()V", "isDestroying", "", "pendingNotificationContent", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/ForegroundNotificationContent;", RemoteMessageConst.Notification.CHANNEL_ID, "", "shouldCreateNotificationChannel", "foregroundServiceTypes", "", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceType;", "notificationOwner", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceOwner;", "notificationTarget", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$NotificationTarget;", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "", "flags", "startId", "parseForegroundServiceTypes", "value", "parseNotificationOwner", "parseNotificationTarget", LiveCommonConstants.REASON_ON_DEDTROY, "createNotificationChannel", "createNotification", "Landroid/app/Notification;", "title", "content", "ForegroundServiceType", "ForegroundServiceOwner", "NotificationTarget", "Companion", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MinutesForegroundService extends Service {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f434224h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f434225i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Lazy<Handler> f434226j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final LinkedHashMap<ForegroundServiceOwner, Companion.c> f434227k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Map<ForegroundServiceOwner, Long> f434228l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f434229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f434230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f434231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f434232d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Set<? extends ForegroundServiceType> f434233e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ForegroundServiceOwner f434234f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public NotificationTarget f434235g;

    public static final class Companion {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$Companion$ForegroundAction;", "", "<init>", "(Ljava/lang/String;I)V", GXAnimation.STATE_START, "UPDATE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final enum ForegroundAction extends Enum<ForegroundAction> {
            public static final ForegroundAction START = null;
            public static final ForegroundAction UPDATE = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ ForegroundAction[] f434236a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ EnumEntries f434237b = null;

            public static EnumEntries<ForegroundAction> getEntries() {
                return f434237b;
            }

            static {
                ForegroundAction r100 = new ForegroundAction(GXAnimation.STATE_START, 0);
                START = r100;
                ForegroundAction r101 = new ForegroundAction("UPDATE", 1);
                UPDATE = r101;
                ForegroundAction[] r102 = {r100, r101};
                f434236a = r102;
                f434237b = EnumEntriesKt.enumEntries(r102);
            }

            public static ForegroundAction[] values() {
                return (ForegroundAction[]) f434236a.clone();
            }

            public static ForegroundAction valueOf(String r100) {
                return (ForegroundAction) r27.a.a(ForegroundAction.class, r100);
            }

            public ForegroundAction(String r100, int r101) {
                super(r100, r101);
            }
        }

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Set<ForegroundServiceOwner> f434238a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Set<ForegroundServiceType> f434239b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ForegroundServiceOwner f434240c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f434241d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String f434242e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final b f434243f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final NotificationTarget f434244g;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f434238a, r101.f434238a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f434239b, r101.f434239b) == true) goto L15;
                return false;
            L15:
                if (this.f434240c == r101.f434240c) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f434241d, r101.f434241d) == true) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.f434242e, r101.f434242e) == true) goto L24;
                return false;
            L24:
                if (Intrinsics.areEqual(this.f434243f, r101.f434243f) == true) goto L27;
                return false;
            L27:
                if (this.f434244g == r101.f434244g) goto L29;
                return false;
            L29:
                return true;
            }

            public final int hashCode() {
                int r100 = ((((this.f434238a.hashCode() * 31) + this.f434239b.hashCode()) * 31) + this.f434240c.hashCode()) * 31;
                String r101 = this.f434241d;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                String r105 = this.f434242e;
                if (r105 == null) goto L11;
                r102 = r105.hashCode();
            L11:
                return ((((r104 + r102) * 31) + this.f434243f.hashCode()) * 31) + this.f434244g.hashCode();
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "ForegroundSnapshot(owners=" + this.f434238a + ", types=" + this.f434239b + ", notificationOwner=" + this.f434240c + ", title=" + this.f434241d + ", content=" + this.f434242e + ", channelConfig=" + this.f434243f + ", notificationTarget=" + this.f434244g + ')';
            }

            /* JADX WARN: Multi-variable type inference failed */
            public a(Set<? extends ForegroundServiceOwner> r100, Set<? extends ForegroundServiceType> r101, ForegroundServiceOwner r102, String r103, String r104, b r105, NotificationTarget r106) {
                Intrinsics.checkNotNullParameter(r100, "owners");
                Intrinsics.checkNotNullParameter(r101, "types");
                Intrinsics.checkNotNullParameter(r102, "notificationOwner");
                Intrinsics.checkNotNullParameter(r105, "channelConfig");
                Intrinsics.checkNotNullParameter(r106, "notificationTarget");
                this.f434238a = r100;
                this.f434239b = r101;
                this.f434240c = r102;
                this.f434241d = r103;
                this.f434242e = r104;
                this.f434243f = r105;
                this.f434244g = r106;
            }
        }

        public static final class b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f434245a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final boolean f434246b;

            public b() {
                this(0);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f434245a, r101.f434245a) == true) goto L12;
                return false;
            L12:
                if (this.f434246b == r101.f434246b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f434245a.hashCode() * 31;
                if (this.f434246b == false) goto L5;
                int r101 = 1231;
            L7:
                return r100 + r101;
            L5:
                r101 = 1237;
                goto L7
            }

            public final String toString() {
                return "NotificationChannelConfig(channelId=" + this.f434245a + ", shouldCreateChannel=" + this.f434246b + ')';
            }

            public /* synthetic */ b(int r100) {
                this("MinutesAudioRecordingChannel", true);
            }

            public b(String r100, boolean r101) {
                Intrinsics.checkNotNullParameter(r100, RemoteMessageConst.Notification.CHANNEL_ID);
                this.f434245a = r100;
                this.f434246b = r101;
            }
        }

        public static final class c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ForegroundServiceType f434247a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f434248b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f434249c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final b f434250d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final NotificationTarget f434251e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (this.f434247a == r101.f434247a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f434248b, r101.f434248b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f434249c, r101.f434249c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f434250d, r101.f434250d) == true) goto L21;
                return false;
            L21:
                if (this.f434251e == r101.f434251e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f434247a.hashCode() * 31;
                String r101 = this.f434248b;
                int r102 = 0;
                if (r101 != null) goto L5;
                int r103 = 0;
            L6:
                int r104 = (r100 + r103) * 31;
                String r105 = this.f434249c;
                if (r105 == null) goto L11;
                r102 = r105.hashCode();
            L11:
                return ((((r104 + r102) * 31) + this.f434250d.hashCode()) * 31) + this.f434251e.hashCode();
            L5:
                r103 = r101.hashCode();
                goto L6
            }

            public final String toString() {
                return "OwnerState(type=" + this.f434247a + ", title=" + this.f434248b + ", content=" + this.f434249c + ", channelConfig=" + this.f434250d + ", notificationTarget=" + this.f434251e + ')';
            }

            public final ForegroundServiceType getType() {
                return this.f434247a;
            }

            public c(ForegroundServiceType r100, String r101, String r102, b r103, NotificationTarget r104) {
                Intrinsics.checkNotNullParameter(r100, "type");
                Intrinsics.checkNotNullParameter(r103, "channelConfig");
                Intrinsics.checkNotNullParameter(r104, "notificationTarget");
                this.f434247a = r100;
                this.f434248b = r101;
                this.f434249c = r102;
                this.f434250d = r103;
                this.f434251e = r104;
            }
        }

        public /* synthetic */ class d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f434252a = null;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final /* synthetic */ int[] f434253b = null;

            static {
                int[] r100 = new int[ForegroundServiceType.values().length];
                r100[ForegroundServiceType.HARDWARE_LIVE_RECORDING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
            L24:
                r100[ForegroundServiceType.RECORDING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
            L30:
                r100[ForegroundServiceType.DATA_SYNC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
            L8:
                f434252a = r100;
                int[] r101 = new int[ForegroundServiceOwner.values().length];
                r101[ForegroundServiceOwner.HARDWARE_FILE_SYNC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
            L26:
                r101[ForegroundServiceOwner.FILE_UPLOAD.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
            L32:
                r101[ForegroundServiceOwner.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
            L22:
                r101[ForegroundServiceOwner.HARDWARE_LIVE_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L21
            L13:
                f434253b = r101;
            }
        }

        public static final class e implements MessageQueue.IdleHandler {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f434254a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Runnable f434255b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f434256c;

            public e(Ref.BooleanRef r100, f r101, Function0 r102) {
                this.f434254a = r100;
                this.f434255b = r101;
                this.f434256c = r102;
            }

            @Override // android.os.MessageQueue.IdleHandler
            public final boolean queueIdle() {
                Ref.BooleanRef r100 = this.f434254a;
                if (r100.element == false) goto L5;
                return false;
            L5:
                r100.element = true;
                Companion r101 = MinutesForegroundService.f434224h;
                MinutesForegroundService.f434226j.getValue().removeCallbacks(this.f434255b);
                this.f434256c.invoke();
                return false;
            }
        }

        public static final class f implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Ref.BooleanRef f434257a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ Function0<Unit> f434258b;

            public f(Ref.BooleanRef r100, Function0<Unit> r101) {
                this.f434257a = r100;
                this.f434258b = r101;
            }

            @Override // java.lang.Runnable
            public final void run() {
                Ref.BooleanRef r100 = this.f434257a;     // Catch: Throwable -> L7
                if (r100.element == true) goto L10;
                r100.element = true;     // Catch: Throwable -> L7
                this.f434258b.invoke();     // Catch: Throwable -> L7
                return;
            L10:
                return;
            L7:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L14;
                throw th;
            }
        }

        public static a b() {
            LinkedHashMap<ForegroundServiceOwner, c> r100 = MinutesForegroundService.f434227k;
            Object r101 = null;
            if (r100.isEmpty() == false) goto L5;
            return null;
        L5:
            Set<ForegroundServiceOwner> r102 = r100.keySet();
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator<Map.Entry<ForegroundServiceOwner, c>> r104 = r100.entrySet().iterator();
        L6:
            boolean r105 = true;
            if (r104.hasNext() == false) goto L28;
            Map.Entry<ForegroundServiceOwner, c> r106 = r104.next();
            c r107 = r106.getValue();
            String r108 = r107.f434248b;
            if (r108 != null) goto L11;
        L14:
            boolean r109 = true;
        L15:
            if (r109 == false) goto L26;
            String r110 = r107.f434249c;
            if (r110 != null) goto L19;
        L22:
            boolean r111 = true;
        L23:
            if (r111 == false) goto L26;
            r105 = false;
            goto L26
        L19:
            if (r110.length() == 0) goto L22;
            r111 = false;
        L26:
            if (r105 == false) goto L6;
            r103.put(r106.getKey(), r106.getValue());
            goto L6
        L11:
            if (r108.length() == 0) goto L14;
            r109 = false;
            goto L15
        L28:
            Set r112 = r103.keySet();
            Intrinsics.checkNotNullParameter(r102, "owners");
            Intrinsics.checkNotNullParameter(r112, "ownersWithContent");
            List r113 = CollectionsKt.listOf(new ForegroundServiceOwner[]{ForegroundServiceOwner.RECORDING, ForegroundServiceOwner.HARDWARE_LIVE_RECORDING, ForegroundServiceOwner.HARDWARE_FILE_SYNC, ForegroundServiceOwner.FILE_UPLOAD});
            Iterator r114 = r113.iterator();
        L30:
            if (r114.hasNext() == false) goto L34;
            Object r115 = r114.next();
            if (r112.contains((ForegroundServiceOwner) r115) == false) goto L30;
            r101 = r115;
        L34:
            ForegroundServiceOwner r116 = (ForegroundServiceOwner) r101;
            if (r116 != null) goto L44;
            Iterator r117 = r113.iterator();
        L38:
            if (r117.hasNext() == false) goto L43;
            ForegroundServiceOwner r118 = (ForegroundServiceOwner) r117.next();
            if (r102.contains(r118) == false) goto L38;
            r116 = r118;
            goto L44
        L43:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        L44:
            Iterator<T> r119 = r100.entrySet().iterator();
        L46:
            if (r119.hasNext() == false) goto L59;
            Map.Entry r120 = (Map.Entry) r119.next();
            if (r120.getKey() != r116) goto L50;
            boolean r121 = true;
        L51:
            if (r121 == false) goto L46;
            LinkedHashMap<ForegroundServiceOwner, c> r122 = MinutesForegroundService.f434227k;
            Set r123 = CollectionsKt.toSet(r122.keySet());
            Collection<c> r124 = r122.values();
            LinkedHashSet r125 = new LinkedHashSet();
            Iterator<T> r126 = r124.iterator();
        L54:
            if (r126.hasNext() == false) goto L57;
            r125.add(((c) r126.next()).getType());
            goto L54
        L57:
            return new a(r123, r125, (ForegroundServiceOwner) r120.getKey(), ((c) r120.getValue()).f434248b, ((c) r120.getValue()).f434249c, ((c) r120.getValue()).f434250d, ((c) r120.getValue()).f434251e);
        L50:
            r121 = false;
            goto L51
        L59:
            throw new NoSuchElementException("Collection contains no element matching the predicate.");
        }

        public Companion() {
        }

        public static final b a(MmRecordingSessionManager r100) {
            Companion r101 = MinutesForegroundService.f434224h;
            int r102 = 0;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L21
            kub.f r104 = (kub.f) r100.f434127a.u(kub.f.class);     // Catch: Throwable -> L21
            boolean r105 = true;
            if (r104 == null) goto L10;
            String r106 = r104.E();     // Catch: Throwable -> L21
            if (r106 == null) goto L10;
            if ((!StringsKt.isBlank(r106)) == false) goto L10;
        L11:
            if (r106 != null) goto L13;
        L16:
            if (r105 == false) goto L18;
            b r107 = new b(r102);     // Catch: Throwable -> L21
        L19:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L21
        L23:
            Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
            if (r109 == null) goto L28;
            lvb.a.b("MinutesForegroundService", "resolve channel config failed, error:" + r109);
            r108 = new b(r102);
        L28:
            return (b) r108;
        L18:
            r107 = new b(r106, r104.y());     // Catch: Throwable -> L21
            goto L19
        L13:
            if (StringsKt.isBlank(r106) == true) goto L16;
            r105 = false;
        L10:
            r106 = null;
        L21:
            th = move-exception;
            Result.Companion r110 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L23
        }

        public static NotificationTarget c(ForegroundServiceOwner r100) {
            int r101 = d.f434253b[r100.ordinal()];
            if (r101 == 1) goto L15;
            if (r101 == 2) goto L15;
            if (r101 == 3) goto L16;
            if (r101 == 4) goto L16;
            throw new NoWhenBranchMatchedException();
        L16:
            return NotificationTarget.RECORDING;
        L15:
            return NotificationTarget.D1204_DEVICE;
        }

        public static ForegroundServiceOwner d(ForegroundServiceType r100) {
            int r101 = d.f434252a[r100.ordinal()];
            if (r101 == 1) goto L13;
            if (r101 == 2) goto L14;
            if (r101 == 3) goto L14;
            throw new NoWhenBranchMatchedException();
        L14:
            return ForegroundServiceOwner.RECORDING;
        L13:
            return ForegroundServiceOwner.HARDWARE_LIVE_RECORDING;
        }

        public static void e(Function0 r100) {
            Ref.BooleanRef r101 = new Ref.BooleanRef();
            f r102 = new f(r101, r100);
            MinutesForegroundService.f434226j.getValue().postDelayed(r102, 3000);
            Looper.myQueue().addIdleHandler(new e(r101, r102, r100));
        }

        public static void j(Context r100, ForegroundServiceOwner r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "owner");
            LinkedHashMap<ForegroundServiceOwner, c> r102 = MinutesForegroundService.f434227k;
            monitor-enter(r102);
            Map<ForegroundServiceOwner, Long> r103 = MinutesForegroundService.f434228l;     // Catch: Throwable -> L34
            Long r104 = (Long) ((LinkedHashMap) r103).get(r101);     // Catch: Throwable -> L34
            if (r104 == null) goto L7;
            long r105 = r104.longValue();     // Catch: Throwable -> L34
        L8:
            r103.put(r101, Long.valueOf(r105 + 1));     // Catch: Throwable -> L34
            if (r102.remove(r101) == null) goto L11;
            boolean r106 = true;
        L12:
            Boolean r107 = Boolean.valueOf(r106);     // Catch: Throwable -> L34
            Companion r108 = MinutesForegroundService.f434224h;     // Catch: Throwable -> L34
            Pair r109 = TuplesKt.to(r107, b());     // Catch: Throwable -> L34
            monitor-exit(r102);
            boolean r110 = ((Boolean) r109.component1()).booleanValue();
            a r111 = (a) r109.component2();
            if (r110 == true) goto L18;
            lvb.a.e("MinutesForegroundService", "skip stop foreground service because owner is not active, owner=" + r101);
            return;
        L18:
            StringBuilder r112 = new StringBuilder("stop foreground service owner=");
            r112.append(r101);
            r112.append(", remainingOwners=");
            if (r111 == null) goto L21;
            Set<ForegroundServiceOwner> r113 = r111.f434238a;
        L22:
            r112.append(r113);
            lvb.a.e("MinutesForegroundService", r112.toString());
            if (r111 == null) goto L39;
            i(r100, ForegroundAction.UPDATE, r111);
            return;
        L39:
            Result.Companion r114 = Result.Companion;     // Catch: Throwable -> L26
            Object r115 = Result.m9449constructorimpl(Boolean.valueOf(r100.stopService(new Intent(r100, MinutesForegroundService.class))));     // Catch: Throwable -> L26
        L28:
            Throwable r116 = Result.m9452exceptionOrNullimpl(r115);
            if (r116 == null) goto L31;
            lvb.a.b("MinutesForegroundService", "stop service failed:" + r116);
        L31:
            Result.m9448boximpl(r115);
            return;
        L26:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            r115 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L28
        L21:
            r113 = null;
            goto L22
        L11:
            r106 = false;
            goto L12
        L7:
            r105 = 0;
        L34:
            th = move-exception;
            throw th;
        }

        public static void i(Context r110, ForegroundAction r111, a r112) {
            Intent r100 = new Intent(r110, MinutesForegroundService.class);
            r100.putExtra("extra_action", r111.name());
            r100.putExtra("extra_title", r112.f434241d);
            r100.putExtra("extra_content", r112.f434242e);
            r100.putExtra("extra_channel_id", r112.f434243f.f434245a);
            r100.putExtra("extra_should_create_channel", r112.f434243f.f434246b);
            r100.putExtra("extra_foreground_service_types", CollectionsKt.joinToString$default(r112.f434239b, ",", null, null, 0, null, MinutesForegroundService$Companion$startServiceInternal$intent$1$1.INSTANCE, 30, null));
            r100.putExtra("extra_notification_owner", r112.f434240c.name());
            r100.putExtra("extra_notification_target", r112.f434244g.name());
            Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
            if (Build.VERSION.SDK_INT < 26) goto L6;
            ComponentName r113 = r110.startForegroundService(r100);     // Catch: Throwable -> L9
        L7:
            Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L9
        L11:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
            if (r115 == null) goto L17;
            lvb.a.b("MinutesForegroundService", "start service failed, action=" + r111 + ", owners=" + r112.f434238a + ", serviceTypes=" + r112.f434239b + ", error:" + r115);
            return;
        L17:
            return;
        L6:
            r113 = r110.startService(r100);     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            Result.Companion r102 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L11
        }

        public static /* synthetic */ void k(Context r100, String r101, String r110, MmRecordingSessionManager r111, ForegroundServiceType r112, int r113) {
            Companion r102 = MinutesForegroundService.f434224h;
            if ((r113 & 16) == 0) goto L5;
            r112 = ForegroundServiceType.RECORDING;
        L5:
            ForegroundServiceType r103 = r112;
            if ((r113 & 32) == 0) goto L8;
            ForegroundServiceOwner r104 = d(r103);
        L10:
            if ((r113 & 64) == 0) goto L12;
            NotificationTarget r105 = c(r104);
        L13:
            r102.update(r100, r101, r110, r111, r103, r104, r105);
            return;
        L12:
            r105 = null;
            goto L13
        L8:
            r104 = null;
            goto L10
        }

        public static /* synthetic */ void h(Context r100, MmRecordingSessionManager r101, ForegroundServiceType r110, String r111, String r112, boolean r113, int r114) {
            if ((r114 & 4) == 0) goto L5;
            r110 = ForegroundServiceType.RECORDING;
        L5:
            ForegroundServiceType r102 = r110;
            if ((r114 & 8) == 0) goto L8;
            ForegroundServiceOwner r103 = d(r102);
        L10:
            if ((r114 & 16) == 0) goto L12;
            String r104 = null;
        L14:
            if ((r114 & 32) == 0) goto L16;
            String r105 = null;
        L18:
            if ((r114 & 64) == 0) goto L20;
            NotificationTarget r106 = c(r103);
        L22:
            if ((r114 & 128) == 0) goto L24;
            boolean r107 = false;
        L25:
            g(r100, r101, r102, r103, r104, r105, r106, r107);
            return;
        L24:
            r107 = r113;
            goto L25
        L20:
            r106 = null;
            goto L22
        L16:
            r105 = r112;
            goto L18
        L12:
            r104 = r111;
            goto L14
        L8:
            r103 = null;
            goto L10
        }

        public final void update(Context r110, String r111, String r112, MmRecordingSessionManager r113, ForegroundServiceType r114, ForegroundServiceOwner r115, NotificationTarget r116) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "title");
            Intrinsics.checkNotNullParameter(r112, "content");
            Intrinsics.checkNotNullParameter(r113, "sessionManager");
            Intrinsics.checkNotNullParameter(r114, "foregroundServiceType");
            Intrinsics.checkNotNullParameter(r115, "owner");
            Intrinsics.checkNotNullParameter(r116, "notificationTarget");
            lvb.a.e("MinutesForegroundService", "update foreground service, serviceType=" + r114);
            f(r110, ForegroundAction.UPDATE, r113, r114, r115, r111, r112, r116, false);
        }

        public static void g(Context r100, MmRecordingSessionManager r110, ForegroundServiceType r111, ForegroundServiceOwner r112, String r113, String r114, NotificationTarget r115, boolean r116) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r110, "sessionManager");
            Intrinsics.checkNotNullParameter(r111, "foregroundServiceType");
            Intrinsics.checkNotNullParameter(r112, "owner");
            Intrinsics.checkNotNullParameter(r115, "notificationTarget");
            lvb.a.e("MinutesForegroundService", "start foreground service, owner=" + r112 + ", serviceType=" + r111 + ", dispatchImmediately=" + r116);
            f(r100, ForegroundAction.START, r110, r111, r112, r113, r114, r115, r116);
        }

        public static void f(final Context r110, final ForegroundAction r111, final MmRecordingSessionManager r112, final ForegroundServiceType r113, final ForegroundServiceOwner r114, final String r115, final String r116, final NotificationTarget r210, boolean r211) {
            lvb.a.e("MinutesForegroundService", "sendAction action=" + r111 + ", owner=" + r114 + ", serviceType=" + r113);
            LinkedHashMap<ForegroundServiceOwner, c> r100 = MinutesForegroundService.f434227k;
            monitor-enter(r100);
            Map<ForegroundServiceOwner, Long> r101 = MinutesForegroundService.f434228l;     // Catch: Throwable -> L18
            Long r102 = (Long) ((LinkedHashMap) r101).get(r114);     // Catch: Throwable -> L18
            if (r102 == null) goto L7;
            long r103 = r102.longValue();     // Catch: Throwable -> L18
        L8:
            final long r104 = r103 + 1;     // Catch: Throwable -> L18
            r101.put(r114, Long.valueOf(r104));     // Catch: Throwable -> L18
            monitor-exit(r100);
            Function0<Unit> r117 = new MinutesForegroundService$Companion$sendAction$task$1(r104, r111, r114, r112, r110, r113, r115, r116, r210);
            if (r211 == false) goto L14;
            r117.invoke();
            return;
        L14:
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L16;
            e(r117);
            return;
        L16:
            MinutesForegroundService.f434226j.getValue().post(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.b(r117));
            return;
        L7:
            r103 = 0;
        L18:
            th = move-exception;
            throw th;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceOwner;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "HARDWARE_LIVE_RECORDING", "HARDWARE_FILE_SYNC", "FILE_UPLOAD", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ForegroundServiceOwner extends Enum<ForegroundServiceOwner> {
        public static final ForegroundServiceOwner FILE_UPLOAD = null;
        public static final ForegroundServiceOwner HARDWARE_FILE_SYNC = null;
        public static final ForegroundServiceOwner HARDWARE_LIVE_RECORDING = null;
        public static final ForegroundServiceOwner RECORDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ForegroundServiceOwner[] f434259a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434260b = null;

        public static EnumEntries<ForegroundServiceOwner> getEntries() {
            return f434260b;
        }

        static {
            ForegroundServiceOwner r100 = new ForegroundServiceOwner(State.RECORDING, 0);
            RECORDING = r100;
            ForegroundServiceOwner r101 = new ForegroundServiceOwner("HARDWARE_LIVE_RECORDING", 1);
            HARDWARE_LIVE_RECORDING = r101;
            ForegroundServiceOwner r102 = new ForegroundServiceOwner("HARDWARE_FILE_SYNC", 2);
            HARDWARE_FILE_SYNC = r102;
            ForegroundServiceOwner r103 = new ForegroundServiceOwner("FILE_UPLOAD", 3);
            FILE_UPLOAD = r103;
            ForegroundServiceOwner[] r104 = {r100, r101, r102, r103};
            f434259a = r104;
            f434260b = EnumEntriesKt.enumEntries(r104);
        }

        public static ForegroundServiceOwner[] values() {
            return (ForegroundServiceOwner[]) f434259a.clone();
        }

        public static ForegroundServiceOwner valueOf(String r100) {
            return (ForegroundServiceOwner) r27.a.a(ForegroundServiceOwner.class, r100);
        }

        public ForegroundServiceOwner(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$ForegroundServiceType;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "HARDWARE_LIVE_RECORDING", "DATA_SYNC", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ForegroundServiceType extends Enum<ForegroundServiceType> {
        public static final ForegroundServiceType DATA_SYNC = null;
        public static final ForegroundServiceType HARDWARE_LIVE_RECORDING = null;
        public static final ForegroundServiceType RECORDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ForegroundServiceType[] f434261a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434262b = null;

        public static EnumEntries<ForegroundServiceType> getEntries() {
            return f434262b;
        }

        static {
            ForegroundServiceType r100 = new ForegroundServiceType(State.RECORDING, 0);
            RECORDING = r100;
            ForegroundServiceType r101 = new ForegroundServiceType("HARDWARE_LIVE_RECORDING", 1);
            HARDWARE_LIVE_RECORDING = r101;
            ForegroundServiceType r102 = new ForegroundServiceType("DATA_SYNC", 2);
            DATA_SYNC = r102;
            ForegroundServiceType[] r103 = {r100, r101, r102};
            f434261a = r103;
            f434262b = EnumEntriesKt.enumEntries(r103);
        }

        public static ForegroundServiceType[] values() {
            return (ForegroundServiceType[]) f434261a.clone();
        }

        public static ForegroundServiceType valueOf(String r100) {
            return (ForegroundServiceType) r27.a.a(ForegroundServiceType.class, r100);
        }

        public ForegroundServiceType(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/core/service/MinutesForegroundService$NotificationTarget;", "", "<init>", "(Ljava/lang/String;I)V", State.RECORDING, "D1204_DEVICE", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum NotificationTarget extends Enum<NotificationTarget> {
        public static final NotificationTarget D1204_DEVICE = null;
        public static final NotificationTarget RECORDING = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ NotificationTarget[] f434263a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f434264b = null;

        public static EnumEntries<NotificationTarget> getEntries() {
            return f434264b;
        }

        static {
            NotificationTarget r100 = new NotificationTarget(State.RECORDING, 0);
            RECORDING = r100;
            NotificationTarget r101 = new NotificationTarget("D1204_DEVICE", 1);
            D1204_DEVICE = r101;
            NotificationTarget[] r102 = {r100, r101};
            f434263a = r102;
            f434264b = EnumEntriesKt.enumEntries(r102);
        }

        public static NotificationTarget[] values() {
            return (NotificationTarget[]) f434263a.clone();
        }

        public static NotificationTarget valueOf(String r100) {
            return (NotificationTarget) r27.a.a(NotificationTarget.class, r100);
        }

        public NotificationTarget(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        this.f434229a = true;
        lvb.a.e("MinutesForegroundService", "onDestroy: Service stopped");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        stopForeground(1);
    L6:
        Object r100 = getSystemService("notification");
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) r100).cancel(f434225i);
        super.onDestroy();
        return;
    L5:
        stopForeground(true);
        goto L6
    }

    static {
        f434224h = new Companion();
        f434225i = a0.a(1);
        f434226j = LazyKt.lazy(MinutesForegroundService$Companion$mainHandler$2.INSTANCE);
        f434227k = new LinkedHashMap();
        f434228l = new LinkedHashMap();
    }

    public MinutesForegroundService() {
        this.f434230b = new a(null, null);
        this.f434231c = "MinutesAudioRecordingChannel";
        this.f434232d = true;
        this.f434233e = SetsKt.setOf(ForegroundServiceType.RECORDING);
        this.f434234f = ForegroundServiceOwner.RECORDING;
        this.f434235g = NotificationTarget.RECORDING;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        lvb.a.e("MinutesForegroundService", "onCreate: Service started");
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r210, int r211, int r212) {
        lvb.a.e("MinutesForegroundService", "onStartCommand, isDestroying=" + this.f434229a);
        if (this.f434229a == false) goto L6;
        lvb.a.h("MinutesForegroundService", "onStartCommand: ignoring, service is destroying");
        return 2;
    L6:
        if (r210 == null) goto L8;
        String r100 = r210.getStringExtra("extra_action");
    L9:
        String r101 = "";
        int r102 = 0;
        if (r210 == null) goto L58;
        String r110 = r210.getStringExtra("extra_title");
        String r111 = r210.getStringExtra("extra_content");
        String r112 = r210.getStringExtra("extra_channel_id");
        if (r112 != null) goto L14;
    L18:
        r112 = "MinutesAudioRecordingChannel";
    L19:
        this.f434231c = r112;
        this.f434232d = r210.getBooleanExtra("extra_should_create_channel", true);
        String r113 = r210.getStringExtra("extra_foreground_service_types");
        if (r113 != null) goto L22;
        String r114 = "";
    L23:
        List r115 = StringsKt.split$default(r114, new char[]{','}, false, 0, 6, null);
        LinkedHashSet r116 = new LinkedHashSet();
        Iterator r117 = r115.iterator();
    L25:
        if (r117.hasNext() == false) goto L37;
        String r118 = (String) r117.next();
        ForegroundServiceType[] r103 = ForegroundServiceType.values();
        int r104 = r103.length;
    L27:
        if (r102 >= r104) goto L32;
        ForegroundServiceType r119 = r103[r102];
        if (Intrinsics.areEqual(r119.name(), r118) == true) goto L30;
        r102 = r102 + 1;
        goto L27
    L30:
        ForegroundServiceType r105 = r119;
    L33:
        if (r105 == null) goto L35;
        r116.add(r105);
    L35:
        r102 = 0;
        goto L25
    L32:
        r105 = null;
        goto L33
    L37:
        if (r116.isEmpty() == false) goto L39;
        r116 = SetsKt.linkedSetOf(new ForegroundServiceType[]{ForegroundServiceType.RECORDING});
    L39:
        this.f434233e = r116;
        String r106 = r210.getStringExtra("extra_notification_owner");
        ForegroundServiceOwner[] r107 = ForegroundServiceOwner.values();
        int r108 = r107.length;
        int r120 = 0;
    L40:
        if (r120 >= r108) goto L45;
        ForegroundServiceOwner r121 = r107[r120];
        if (Intrinsics.areEqual(r121.name(), r106) == true) goto L46;
        r120 = r120 + 1;
    L46:
        if (r121 != null) goto L48;
        r121 = ForegroundServiceOwner.RECORDING;
    L48:
        this.f434234f = r121;
        String r109 = r210.getStringExtra("extra_notification_target");
        NotificationTarget[] r122 = NotificationTarget.values();
        int r123 = r122.length;
        int r124 = 0;
    L49:
        if (r124 >= r123) goto L54;
        NotificationTarget r125 = r122[r124];
        if (Intrinsics.areEqual(r125.name(), r109) == true) goto L52;
        r124 = r124 + 1;
        goto L49
    L52:
        NotificationTarget r126 = r125;
    L55:
        if (r126 != null) goto L57;
        r126 = NotificationTarget.RECORDING;
    L57:
        this.f434235g = r126;
        a r127 = new a(r110, r111);
    L59:
        a r128 = this.f434230b;
        Intrinsics.checkNotNullParameter(r128, "current");
        if (r127 != null) goto L62;
        r127 = r128;
    L62:
        this.f434230b = r127;
        lvb.a.e("MinutesForegroundService", "handle action=" + r100 + ", serviceTypes=" + this.f434233e + ", notificationOwner=" + this.f434234f + ", title=" + this.f434230b.f434265a + ", content=" + this.f434230b.f434266b + ", channelId=" + this.f434231c + ", shouldCreateChannel=" + this.f434232d);
        a r129 = this.f434230b;
        String r130 = r129.f434265a;
        if (r130 != null) goto L65;
        r130 = "";
    L65:
        String r131 = r129.f434266b;
        if (r131 == null) goto L70;
        r101 = r131;
    L70:
        if (this.f434232d == false) goto L74;
        String r132 = this.f434231c;
        if (Build.VERSION.SDK_INT < 26) goto L74;
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(new NotificationChannel(r132, "Audio Recording Service", 2));
    L74:
        Intent r133 = new Intent(this, MinutesForegroundRouterActivity.class);
        r133.addFlags(335544320);
        r133.putExtra("extra_notification_owner", this.f434234f.name());
        r133.putExtra("extra_notification_target", this.f434235g.name());
        int r134 = 0;
        PendingIntent r135 = PendingIntent.getActivity(this, 0, r133, 201326592);
        NotificationCompat.Builder r136 = new NotificationCompat.Builder(this, this.f434231c).setContentTitle(r130).setContentText(r101).setPriority(0).setSilent(true).setShowWhen(false).setOnlyAlertOnce(true);
        LarkAppContext.Companion.getClass();
        if (LarkAppContext.access$getInstance$cp().buildConfig().isLarkApp() == false) goto L77;
        int r137 = R.drawable.ic_notify;
    L78:
        Notification r138 = r136.setSmallIcon(r137).setContentIntent(r135).build();
        Result.Companion r139 = Result.Companion;     // Catch: Throwable -> L101
        if (Build.VERSION.SDK_INT < 34) goto L98;
        Set<? extends ForegroundServiceType> r140 = this.f434233e;     // Catch: Throwable -> L101
        Intrinsics.checkNotNullParameter(r140, "types");     // Catch: Throwable -> L101
        Iterator<T> r141 = r140.iterator();     // Catch: Throwable -> L101
    L84:
        if (r141.hasNext() == false) goto L97;
        int r142 = c.f434410a[((ForegroundServiceType) r141.next()).ordinal()];     // Catch: Throwable -> L101
        if (r142 != 1) goto L88;
        int r143 = 144;
    L96:
        r134 = r134 | r143;     // Catch: Throwable -> L101
        goto L84
    L88:
        if (r142 != 2) goto L90;
        r143 = 16;
        goto L96
    L90:
        if (r142 != 3) goto L93;
        r143 = 1;
        goto L96
    L93:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L101
    L97:
        startForeground(f434225i, r138, r134);     // Catch: Throwable -> L101
        lvb.a.e("MinutesForegroundService", "startForeground success, action=" + r100 + ", serviceTypes=" + this.f434233e + ", foregroundServiceType=" + r134);     // Catch: Throwable -> L101
    L99:
        Object r144 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L101
    L103:
        Throwable r145 = Result.m9452exceptionOrNullimpl(r144);
        if (r145 == null) goto L123;
        lvb.a.b("MinutesForegroundService", "startForeground failed, action=" + r100 + ", serviceTypes=" + this.f434233e + ", channelId=" + this.f434231c + ", error:" + r145);
        stopSelf(r212);
        return 2;
    L123:
        return 2;
    L98:
        startForeground(f434225i, r138);     // Catch: Throwable -> L101
        lvb.a.e("MinutesForegroundService", "startForeground success, action=" + r100 + ", serviceTypes=" + this.f434233e);     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        Result.Companion r146 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L103
    L77:
        r137 = R.drawable.office_sdk_notification_small;
        goto L78
    L54:
        r126 = null;
        goto L55
    L45:
        r121 = null;
        goto L46
    L22:
        r114 = r113;
        goto L23
    L14:
        if (Boolean.valueOf(!StringsKt.isBlank(r112)).booleanValue() == true) goto L17;
        r112 = null;
    L17:
        if (r112 != null) goto L19;
    L58:
        r127 = null;
        goto L59
    L8:
        r100 = null;
        goto L9
    }
}
