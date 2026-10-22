package com.bytedance.applet.aibridge.navi;

import android.app.Application;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.core.util.Consumer;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.AIBridgeMethod;
import com.bytedance.ai.bridge.core.model.idl.ParamModel;
import com.bytedance.applet.aibridge.navi.picker.NavigationMapAppLauncher;
import com.bytedance.applet.aibridge.navigation.l;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.larus.common.apphost.AppHost;
import com.larus.lbs.trace.api.model.LbsTraceLevel;
import com.larus.navigation.api.NavigationLocationPrewarmMode;
import com.larus.navigation.api.NavigationServiceDelegate;
import com.larus.platform.model.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.service.w0;
import com.larus.utils.t0;
import f3.h;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import rv3.n;
import rv3.q;
import rv3.r;
import rv3.s;
import rv3.u;
import rv3.v;
import rv3.w;
import sv3.e;
import sv3.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 j2\u00020\u0001:\u0003jklB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J6\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u000bH\u0016J&\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J6\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0003J\u0082\u0001\u0010\u001a\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001a\u00020$2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001c2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0094\u0001\u0010+\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001a\u00020$2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-2\u000e\b\u0002\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001c2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010.\u001a\u00020-2\u0006\u0010/\u001a\u00020-2\b\u00100\u001a\u0004\u0018\u00010-H\u0002J\u001a\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u00102\u001a\u0004\u0018\u000103H\u0002J\u0018\u00104\u001a\b\u0012\u0004\u0012\u00020&0\u001c2\b\u00105\u001a\u0004\u0018\u000103H\u0002J\u001a\u00106\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010,\u001a\u0004\u0018\u00010-H\u0002J6\u00107\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020:09\u0012\n\u0012\b\u0012\u0004\u0012\u00020-09082\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001a\u0010<\u001a\u0004\u0018\u00010:2\u0006\u0010=\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010>\u001a\u00020:H\u0002J8\u0010?\u001a\u0004\u0018\u00010-2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:092\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010A\u001a\u0004\u0018\u00010-H\u0002J\"\u0010B\u001a\u0004\u0018\u00010-2\b\u0010A\u001a\u0004\u0018\u00010-2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:09H\u0002Jq\u0010C\u001a\u00020\u00052\b\u0010D\u001a\u0004\u0018\u00010-2\b\u0010E\u001a\u0004\u0018\u00010F2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:0\u001c2\b\u00100\u001a\u0004\u0018\u00010-2\u0006\u0010G\u001a\u00020H2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010#\u001a\u00020$2\b\u0010I\u001a\u0004\u0018\u00010-2\u0006\u0010J\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002¢\u0006\u0002\u0010KJ9\u0010L\u001a\u00020M2\b\u0010D\u001a\u0004\u0018\u00010-2\b\u0010E\u001a\u0004\u0018\u00010F2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020:0\u001c2\b\u00100\u001a\u0004\u0018\u00010-H\u0002¢\u0006\u0002\u0010NJ\u0018\u0010O\u001a\u00020\u00122\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J \u0010P\u001a\u00020\u00122\u0006\u0010G\u001a\u00020H2\u0006\u0010Q\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010R\u001a\u00020-2\u0006\u0010S\u001a\u00020TH\u0002J:\u0010U\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000f2\u0014\u0010V\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u00050W2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00050WH\u0002J:\u0010Y\u001a\u00020Z2\u0006\u0010\b\u001a\u00020\u000f2\u0014\u0010V\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010!\u0012\u0004\u0012\u00020\u00050W2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00050WH\u0002J:\u0010[\u001a\u00020\u00052\u0006\u0010S\u001a\u00020T2\u0006\u0010G\u001a\u00020H2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010I\u001a\u0004\u0018\u00010-H\u0002J\u0012\u0010\\\u001a\u0004\u0018\u00010]2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u001e\u0010^\u001a\u00020\u00052\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002JB\u0010_\u001a\u00020$2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000f2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010`\u001a\u00020\u0019H\u0002J<\u0010a\u001a\u00020\u00122\u0006\u0010b\u001a\u00020F2\u0006\u0010c\u001a\u00020F2\u0006\u0010d\u001a\u00020-2\b\u0010e\u001a\u0004\u0018\u00010-2\b\u0010f\u001a\u0004\u0018\u00010-2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010g\u001a\u0010\u0012\u0004\u0012\u00020-\u0012\u0006\u0012\u0004\u0018\u00010i0h2\u0006\u0010\b\u001a\u00020\u000fH\u0002¨\u0006m"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/OpenNavigationMapMethod;", "Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL;", "<init>", "()V", "realHandle", "", "bridgeContext", "Lcom/bytedance/ai/bridge/context/IAIBridgeContext;", "params", "Lcom/google/gson/JsonObject;", "resolve", "Landroidx/core/util/Consumer;", "reject", "Lcom/bytedance/ai/bridge/core/AIBridgeMethod$Error;", "handle", "Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL$OpenNavigationMapParam;", "callback", "Lcom/bytedance/ai/bridge/core/CompletionBlock;", "Lcom/bytedance/applet/aibridge/navi/AbsOpenNavigationMapIDL$OpenNavigationMapResult;", "handleOnMain", "requestGeneration", "", "trace", "Lcom/bytedance/applet/aibridge/navi/OpenNavigationMapMethod$OpenTrace;", "prepareOpenRequest", "", "handleDirectLaunch", "parsedDialogItems", "", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapDialogItem;", "mode", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$RouteMode;", "origin", "Lcom/bytedance/applet/aibridge/navi/picker/GeoPoint;", "destination", "session", "Lcom/bytedance/applet/aibridge/navi/picker/tracking/OutlinkSession;", "waypoints", "Lcom/bytedance/applet/aibridge/navi/picker/Waypoint;", "routePreference", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$BaiduDrivingPreference;", "transitStrategy", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$BaiduTransitStrategy;", "handleDialog", "fallbackAppName", "", "resolveRowBrand", "selectionKey", "installFallbackPackage", "parseDialogItems", "dialogJson", "Lcom/google/gson/JsonArray;", "parseWaypoints", "waypointsJson", "buildFallbackItems", "filterDialogRows", "Lkotlin/Pair;", "", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapPopupManager$Row;", "items", "filterOneRow", "item", "doubaoRow", "resolveFallbackPackage", "rows", "backupAppKey", "buildInstallFallback", "onPickerSelected", "selected", "rankIndex", "", "ctx", "Lcom/bytedance/applet/aibridge/navi/OpenNavigationMapMethod$LaunchContext;", "prewarmLocationIdentifier", "isDirectFallback", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/bytedance/applet/aibridge/navi/OpenNavigationMapMethod$LaunchContext;Lcom/bytedance/ai/bridge/core/CompletionBlock;Lcom/bytedance/applet/aibridge/navi/picker/tracking/OutlinkSession;Ljava/lang/String;ZLcom/bytedance/applet/aibridge/navi/OpenNavigationMapMethod$OpenTrace;)V", "resolveClickOutcome", "Lcom/bytedance/applet/aibridge/navi/picker/tracking/ClickOutcome;", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)Lcom/bytedance/applet/aibridge/navi/picker/tracking/ClickOutcome;", "cancelResult", "installStoreResult", "launched", "defaultText", "app", "Lcom/bytedance/applet/aibridge/navi/picker/NavigationMapAppLauncher$AppType;", "resolveOriginAsync", "onResolved", "Lkotlin/Function1;", "onFailure", "newLocationCallback", "Lcom/larus/platform/model/LocationDataCallBack;", "dispatchLaunch", "prewarmMode", "Lcom/larus/navigation/api/NavigationLocationPrewarmMode;", "completeSupersededRequest", "buildSession", "showDialog", "buildResult", "result", "isBackground", "availableApps", "appName", "selectedApp", "buildOpenTraceRequestParams", "", "", "Companion", "LaunchContext", "OpenTrace", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpenNavigationMapMethod extends AbsOpenNavigationMapIDL {
    public static final Gson b = null;
    public static final AtomicLong c = null;

    public static final class a {
        public static boolean a(long r3) {
            if (OpenNavigationMapMethod.c.get() != r3) goto L5;
            return true;
        L5:
            return false;
        }
    }

    public static final class b {
        public final NavigationMapAppLauncher.RouteMode a;
        public final sv3.a b;
        public final sv3.a c;
        public final boolean d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final List<m> l;
        public final boolean m;
        public final NavigationMapAppLauncher.BaiduDrivingPreference n;
        public final NavigationMapAppLauncher.BaiduTransitStrategy o;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (this.m == r6.m) goto L48;
            return false;
        L48:
            if (this.n == r6.n) goto L51;
            return false;
        L51:
            if (this.o == r6.o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            sv3.a r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((r0 + r3) * 31) + this.c.hashCode()) * 31;
            int r5 = 1231;
            if (this.d == false) goto L9;
            int r6 = 1231;
        L10:
            int r7 = (((r4 + r6) * 31) + this.e.hashCode()) * 31;
            String r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.k;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (((r22 + r24) * 31) + this.l.hashCode()) * 31;
            if (this.m == true) goto L38;
            r5 = 1237;
        L38:
            int r26 = (r25 + r5) * 31;
            NavigationMapAppLauncher.BaiduDrivingPreference r27 = this.n;
            if (r27 != null) goto L41;
            int r28 = 0;
        L42:
            int r29 = (r26 + r28) * 31;
            NavigationMapAppLauncher.BaiduTransitStrategy r30 = this.o;
            if (r30 == null) goto L47;
            r2 = r30.hashCode();
        L47:
            return r29 + r2;
        L41:
            r28 = r27.hashCode();
            goto L42
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = 1237;
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "LaunchContext(mode=" + this.a + ", origin=" + this.b + ", destination=" + this.c + ", startNaviDirectly=" + this.d + ", availableApps=" + this.e + ", appletRouteMode=" + this.f + ", dPoiId=" + this.g + ", dPoiIdType=" + this.h + ", autoLinkId=" + this.i + ", traceId=" + this.j + ", widgetInstanceId=" + this.k + ", waypoints=" + this.l + ", directLaunch=" + this.m + ", routePreference=" + this.n + ", transitStrategy=" + this.o + ')';
        }

        public b(NavigationMapAppLauncher.RouteMode r7, sv3.a r8, sv3.a r9, boolean r10, String r11, String r12, String r13, String r14, String r15, String r16, String r17, List<m> r18, boolean r19, NavigationMapAppLauncher.BaiduDrivingPreference r20, NavigationMapAppLauncher.BaiduTransitStrategy r21) {
            Intrinsics.checkNotNullParameter(r7, "mode");
            Intrinsics.checkNotNullParameter(r9, "destination");
            Intrinsics.checkNotNullParameter(r11, "availableApps");
            Intrinsics.checkNotNullParameter(r18, "waypoints");
            this.a = r7;
            this.b = r8;
            this.c = r9;
            this.d = r10;
            this.e = r11;
            this.f = r12;
            this.g = r13;
            this.h = r14;
            this.i = r15;
            this.j = r16;
            this.k = r17;
            this.l = r18;
            this.m = r19;
            this.n = r20;
            this.o = r21;
        }
    }

    public static final class c {
        public final com.larus.lbs.trace.api.a a;
        public final Map<String, Object> b;

        public final void a() {
            b(-1, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "OpenTrace(session=" + this.a + ", requestParams=" + this.b + ')';
        }

        public c(com.larus.lbs.trace.api.a r2, Map<String, ? extends Object> r3) {
            Intrinsics.checkNotNullParameter(r2, "session");
            Intrinsics.checkNotNullParameter(r3, "requestParams");
            this.a = r2;
            this.b = r3;
        }

        public final void b(int r5, String r6, String r7, String r8) {
            com.larus.lbs.trace.api.a r0 = this.a;
            Map<String, Object> r1 = this.b;
            Pair[] r2 = new Pair[4];
            r2[0] = TuplesKt.to("result", Integer.valueOf(r5));
            if (r6 != null) goto L5;
        L7:
            r6 = null;
        L8:
            r2[1] = TuplesKt.to("selected_app", r6);
            if (r7 != null) goto L11;
        L13:
            r7 = null;
        L14:
            r2[2] = TuplesKt.to("opened_app", r7);
            r2[3] = TuplesKt.to("available_apps", r8);
            r0.a(MapsKt.plus(r1, MapsKt.mapOf(r2)), LbsTraceLevel.INFO);
            return;
        L11:
            if (StringsKt.isBlank(r7) == true) goto L13;
        L5:
            if (StringsKt.isBlank(r6) == true) goto L7;
            goto L7
        }
    }

    public /* synthetic */ class d {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;
        public static final /* synthetic */ int[] c = null;

        static {
            int[] r0 = new int[NavigationMapAppLauncher.InstallState.values().length];
            r0[NavigationMapAppLauncher.InstallState.NEED_INSTALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L22
        L42:
            r0[NavigationMapAppLauncher.InstallState.INSTALLED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L23
        L52:
            r0[NavigationMapAppLauncher.InstallState.IN_APP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L24
        L8:
            a = r0;
            int[] r1 = new int[NavigationMapAppLauncher.AppType.values().length];
            r1[NavigationMapAppLauncher.AppType.DOUBAO.ordinal()] = 1;     // Catch: NoSuchFieldError -> L25
        L44:
            r1[NavigationMapAppLauncher.AppType.AMAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L26
        L54:
            r1[NavigationMapAppLauncher.AppType.BAIDU.ordinal()] = 3;     // Catch: NoSuchFieldError -> L27
        L34:
            r1[NavigationMapAppLauncher.AppType.APPLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L28
        L14:
            b = r1;
            int[] r2 = new int[NavigationMapAppLauncher.RouteMode.values().length];
            r2[NavigationMapAppLauncher.RouteMode.WALKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L48:
            r2[NavigationMapAppLauncher.RouteMode.CYCLING.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L36:
            r2[NavigationMapAppLauncher.RouteMode.E_CYCLING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L46:
            r2[NavigationMapAppLauncher.RouteMode.DRIVING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L40:
            r2[NavigationMapAppLauncher.RouteMode.TRANSIT.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L20:
            c = r2;
        }
    }

    static {
        b = new Gson();
        c = new AtomicLong(0);
    }

    public OpenNavigationMapMethod() {
    }

    public static String d(NavigationMapAppLauncher.AppType r1) {
        int r2 = d.b[r1.ordinal()];
        if (r2 != 1) goto L5;
        return "轻导航";
    L5:
        if (r2 != 2) goto L7;
        return "高德地图";
    L7:
        if (r2 != 3) goto L9;
        return "百度地图";
    L9:
        if (r2 != 4) goto L12;
        return "苹果地图";
    L12:
        throw new NoWhenBranchMatchedException();
    }

    public static List g(JsonArray r7) {
        if (r7 != null) goto L5;
    L24:
        com.larus.navigation.api.c.d("jsb_open_nav_map", "dialogAppList is empty or missing");
        return null;
    L5:
        if (r7.size() == 0) goto L24;
        ArrayList r2 = new ArrayList();
        Iterator r8 = r7.iterator();
    L9:
        if (r8.hasNext() == false) goto L21;
        JsonElement r3 = (JsonElement) r8.next();
        e r4 = (e) GsonProtectorUtils.fromJson(b, r3, e.class);     // Catch: JsonSyntaxException -> L18
        if (r4 == null) goto L14;
        String r5 = r4.a();     // Catch: JsonSyntaxException -> L18
    L15:
        if (r5 == null) goto L9;
        r2.add(r4);     // Catch: JsonSyntaxException -> L18
        goto L9
    L14:
        r5 = null;
    L18:
        e = move-exception;
        int r6 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_open_nav_map", "bad dialogAppList element: " + r3, e);
        goto L9
    L21:
        if ((!r2.isEmpty()) == true) goto L23;
        return null;
    L23:
        return r2;
    }

    public static List h(JsonArray r11) {
        if (r11 == null) goto L47;
        if (r11.size() == 0) goto L47;
        ArrayList r0 = new ArrayList();
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L41;
        JsonElement r1 = (JsonElement) r12.next();
        m r3 = (m) GsonProtectorUtils.fromJson(b, r1, m.class);     // Catch: JsonSyntaxException -> L38
        if (r3 == null) goto L36;
        double r4 = r3.a();     // Catch: JsonSyntaxException -> L38
        boolean r7 = false;
        if (Double.isInfinite(r4) == false) goto L15;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L36;
        double r6 = r3.b();     // Catch: JsonSyntaxException -> L38
        if (Double.isInfinite(r6) == false) goto L22;
    L24:
        boolean r8 = false;
    L25:
        if (r8 == false) goto L36;
        if (r3.a() != 0.0d) goto L29;
        boolean r9 = true;
    L30:
        if (r9 == false) goto L35;
        if (r3.b() != 0.0d) goto L34;
        r7 = true;
    L34:
        if (r7 == true) goto L36;
    L35:
        r0.add(r3);     // Catch: JsonSyntaxException -> L38
        goto L8
    L29:
        r9 = false;
        goto L30
    L22:
        if (Double.isNaN(r6) == true) goto L24;
        r8 = true;
        goto L25
    L15:
        if (Double.isNaN(r4) == true) goto L17;
        r5 = true;
    L36:
        int r10 = com.larus.navigation.api.c.a;     // Catch: JsonSyntaxException -> L38
        com.larus.navigation.api.c.e("jsb_open_nav_map", "drop waypoint with missing/invalid coord: " + r1);     // Catch: JsonSyntaxException -> L38
    L38:
        e = move-exception;
        int r13 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_open_nav_map", "bad waypoint element: " + r1, e);
        goto L8
    L41:
        if (r0.size() <= 15) goto L44;
        int r14 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.e("jsb_open_nav_map", "waypoints size=" + r0.size() + " exceeds 15, truncating to first 15");
        return CollectionsKt.take(r0, 15);
    L44:
        int r15 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "parsed waypoints size=" + r0.size());
        return r0;
    L47:
        return CollectionsKt.emptyList();
    }

    public static void c(h r8, c r9) {
        com.larus.navigation.api.c.d("jsb_open_nav_map", "openNavigationMap request superseded before launch");
        r8.b(b(-1, 0, "", null, "cancel", r9), "");
    }

    public static String j(String r5, String r6) {
        if (Intrinsics.areEqual(r5, "install_app") == true) goto L5;
        return r5;
    L5:
        NavigationMapAppLauncher.AppType[] r7 = NavigationMapAppLauncher.AppType.values();
        int r0 = r7.length;
        int r2 = 0;
    L6:
        if (r2 >= r0) goto L16;
        NavigationMapAppLauncher.AppType r3 = r7[r2];
        if (r3.getPackageName() != null) goto L10;
    L12:
        boolean r4 = false;
    L13:
        if (r4 == true) goto L17;
        r2 = r2 + 1;
    L17:
        if (r3 == null) goto L22;
        String r8 = r3.getKey();
        if (r8 == null) goto L22;
        return r8;
    L22:
        return NavigationMapAppLauncher.AppType.AMAP.getKey();
    L10:
        if (Intrinsics.areEqual(r3.getPackageName(), r6) == false) goto L12;
        r4 = true;
        goto L13
    L16:
        r3 = null;
        goto L17
    }

    public static void i(AbsOpenNavigationMapIDL.a r8, r r9, s r10) {
        Double r0 = r8.getOlat();
        Double r1 = r8.getOlon();
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        r9.invoke(new sv3.a(r0.doubleValue(), r1.doubleValue(), r8.getOrigin()));
        return;
    L7:
        com.larus.navigation.api.c.d("jsb_open_nav_map", "origin missing, fetching via LocationService.singleLocate");
        com.larus.platform.service.m r2 = com.larus.platform.service.m.a;
        if (com.larus.platform.service.m.i() != null) goto L16;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "LocationService SPI not registered, fail fast");
        r10.invoke("location_service_unavailable");
        return;
    L16:
        r2.e(LocateScene.APPLET, CoordinateType.GCJ_O2, 5000L, new com.bytedance.applet.aibridge.navi.a(r9, r8, r10));     // Catch: RuntimeException -> L13
        return;
    L13:
        e = move-exception;
        int r11 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("jsb_open_nav_map", "singleLocate threw [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        r10.invoke("locate_call_threw");
    }

    public final void handle(final e3.d r9, ParamModel r10, final h r11) {
        final AbsOpenNavigationMapIDL.a r3 = (AbsOpenNavigationMapIDL.a) r10;
        Intrinsics.checkNotNullParameter(r9, "bridgeContext");
        Intrinsics.checkNotNullParameter(r3, "params");
        Intrinsics.checkNotNullParameter(r11, "callback");
        com.larus.lbs.trace.api.a r12 = new com.larus.lbs.trace.api.a(yv3.c.c(r3.getTraceContext()), "lbs_client_doubao_open_navi_dialog");
        boolean r0 = Intrinsics.areEqual(r3.getShowDialog(), Boolean.TRUE);
        Pair[] r1 = new Pair[4];
        boolean r4 = false;
        r1[0] = TuplesKt.to("show_dialog", Boolean.valueOf(r0));
        String r2 = r3.getAppName();
        String r6 = null;
        if (r2 == null) goto L10;
        if (r0 == false) goto L6;
    L7:
        r4 = true;
    L8:
        if (r4 == true) goto L10;
    L11:
        r1[1] = TuplesKt.to("requested_app", r2);
        String r5 = r3.getType();
        if (r5 != null) goto L14;
    L16:
        r5 = null;
    L17:
        r1[2] = TuplesKt.to("route_mode", r5);
        String r7 = r3.getDPoiIdType();
        if (r7 != null) goto L20;
    L22:
        r1[3] = TuplesKt.to("poi_id_type", r6);
        final c r8 = new c(r12, MapsKt.mapOf(r1));
        final long r13 = c.incrementAndGet();
        t0.e(new q(this, r9, r3, r11, r13, r8));
        return;
    L20:
        if (StringsKt.isBlank(r7) == true) goto L22;
        r6 = r7;
        goto L22
    L14:
        if (StringsKt.isBlank(r5) == true) goto L16;
    L6:
        if (StringsKt.isBlank(r2) == false) goto L8;
    L10:
        r2 = null;
        goto L11
    }

    public final void realHandle(e3.d r3, JsonObject r4, Consumer<JsonObject> r5, Consumer<AIBridgeMethod.Error> r6) {
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r5, "resolve");
        Intrinsics.checkNotNullParameter(r6, "reject");
        if (r4 == null) goto L10;
        JsonObject r0 = r4.deepCopy();
        if (r0 == null) goto L10;
        r0.remove("traceContext");
        String r1 = r0.toString();
        if (r1 == null) goto L10;
        String r2 = StringsKt.take(r1, 800);
        if (r2 == null) goto L10;
    L11:
        int r7 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.a("nav_protocol_trace", "[FE_RAW/doubao.openNavigationMap] paramJson=".concat(r2));
        super.realHandle(r3, r4, r5, r6);
        return;
    L10:
        r2 = "<null>";
        goto L11
    }

    public static void e(NavigationMapAppLauncher.AppType r18, b r19, h r20, c r21, String r22) {
        NavigationMapAppLauncher.AppType r0 = NavigationMapAppLauncher.AppType.DOUBAO;
        if (r18 != r0) goto L8;
        String r5 = com.larus.navigation.api.m.b;
        String r6 = r19.i;
        if (r6 != null) goto L7;
        r6 = "";
    L7:
        String r7 = "mode=" + r19.a + " startNaviDirectly=" + r19.d;
        Intrinsics.checkNotNullParameter(r6, "key");
        Intrinsics.checkNotNullParameter(r7, "detail");
        com.larus.navigation.api.m.a = SystemClock.elapsedRealtime();
        com.larus.navigation.api.m.b = r6;
        int r8 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("nav_launch_perf", "[T0/picker_click] key=" + r6 + ' ' + r7);
    L8:
        int r9 = com.larus.navigation.api.c.a;
        StringBuilder r10 = new StringBuilder("[step5/dispatchLaunch] app=");
        r10.append(r18);
        r10.append(" mode=");
        r10.append(r19.a);
        r10.append(" startNaviDirectly=");
        r10.append(r19.d);
        r10.append(" directLaunch=");
        r10.append(r19.m);
        r10.append(" waypoints=");
        r10.append(r19.l.size());
        r10.append(" routePreference=");
        r10.append(r19.n);
        r10.append(" transitStrategy=");
        r10.append(r19.o);
        r10.append(" origin=");
        sv3.a r11 = r19.b;
        if (r11 == null) goto L12;
        String r12 = "(" + r11.a + ',' + r11.b + ')';
        if (r12 == null) goto L12;
    L13:
        r10.append(r12);
        r10.append(" destination=(");
        r10.append(r19.c.a);
        r10.append(',');
        r10.append(r19.c.b);
        r10.append(") dPoiId=");
        r10.append(r19.g);
        r10.append(" dPoiIdType=");
        r10.append(r19.h);
        r10.append(" autoLinkId=");
        r10.append(r19.i);
        com.larus.navigation.api.c.a("jsb_open_nav_map", r10.toString());
        NavigationMapAppLauncher r13 = NavigationMapAppLauncher.a;
        NavigationMapAppLauncher.RouteMode r14 = r19.a;
        sv3.a r15 = r19.b;
        sv3.a r16 = r19.c;
        String r17 = r19.f;
        String r110 = r19.g;
        String r111 = r19.h;
        String r112 = r19.i;
        String r113 = r19.j;
        String r114 = r19.k;
        List<m> r115 = r19.l;
        boolean r3 = r19.m;
        NavigationMapAppLauncher.BaiduDrivingPreference r4 = r19.n;
        NavigationMapAppLauncher.BaiduTransitStrategy r23 = r19.o;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r18, "app");
        Intrinsics.checkNotNullParameter(r14, "mode");
        Intrinsics.checkNotNullParameter(r16, "destination");
        Intrinsics.checkNotNullParameter(r115, "waypoints");
        Application r24 = AppHost.a.getApplication();
        if (r24 != null) goto L16;
        com.larus.navigation.api.c.b("nav_map_launcher", "[launch] AppHost.application is null — cannot launch");
        NavigationMapAppLauncher.a r1 = new NavigationMapAppLauncher.a(false, false);
    L101:
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step5/dispatchLaunch] launchResult=" + r1);
        if (r1.a == true) goto L111;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "[step5/dispatchLaunch] FAILED for " + r18 + " → onFailure(LAUNCH_FAILED)");
        if (r18 == NavigationMapAppLauncher.AppType.DOUBAO) goto L106;
    L108:
        r21.a();
        h.a.a(r20, "launch_failed", null, null, 14);
        return;
    L106:
        if (r22 == null) goto L108;
        Handler r2 = n.a;
        n.b(r19.i);
        NavigationServiceDelegate.b.o("light_navigation_route_failed", r22);
        goto L108
    L111:
        if (r18 != NavigationMapAppLauncher.AppType.DOUBAO) goto L113;
        int r25 = 1;
    L114:
        boolean r26 = r1.b;
        r20.b(b(r25, r26 ? 1 : 0, r19.e, r18.getKey(), r18.getKey(), r21), "");
        return;
    L113:
        r25 = 0;
        goto L114
    L16:
        if (r18 != r0) goto L120;
        AppletAppManagerService.INSTANCE.getClass();     // Catch: RuntimeException -> L42
        AppletApplication r27 = AppletAppManagerService.a("db_1GFLTGc");     // Catch: RuntimeException -> L42
        if (r27 == null) goto L21;
        r27.h().e().b = "chat_card";     // Catch: RuntimeException -> L42
    L21:
        xe8.a r28 = w0.a(null);     // Catch: RuntimeException -> L42
        if ((r28 instanceof xe8.a) == false) goto L24;
        xe8.a r29 = r28;     // Catch: RuntimeException -> L42
    L25:
        if (r29 == null) goto L31;
        String r30 = r29.getConversationId();     // Catch: RuntimeException -> L42
        if (r30 == null) goto L31;
        if (StringsKt.isBlank(r30) == true) goto L31;
    L32:
        StringBuilder r116 = new StringBuilder("[launchLightNav] conversationIdIsEmpty=");     // Catch: RuntimeException -> L42
        if (r30 != null) goto L35;
        boolean r31 = true;
    L36:
        r116.append(r31);     // Catch: RuntimeException -> L42
        com.larus.navigation.api.c.d("nav_map_launcher", r116.toString());     // Catch: RuntimeException -> L42
        String r32 = NavigationMapAppLauncher.e(r14, r15, r16, r17, r110, r111, r112, r113, r114, r115).toString();     // Catch: RuntimeException -> L40
        com.larus.navigation.api.c.a("nav_map_launcher", "[launchLightNav] routing via SmartRouter, uri=" + r32);     // Catch: RuntimeException -> L40
        com.larus.navigation.api.m.a("T1/before_smartrouter", "");     // Catch: RuntimeException -> L40
        i r33 = SmartRouter.buildRoute(r24, r32);     // Catch: RuntimeException -> L40
        r33.c.putExtra("argConversationId", r30);     // Catch: RuntimeException -> L40
        r33.d();     // Catch: RuntimeException -> L40
        com.larus.navigation.api.c.d("nav_map_launcher", "[launchLightNav] SmartRouter.open() returned");     // Catch: RuntimeException -> L40
        com.larus.navigation.api.m.a("T2/smartrouter_returned", "");     // Catch: RuntimeException -> L40
        r1 = new NavigationMapAppLauncher.a(true, false);     // Catch: RuntimeException -> L40
    L40:
        e = e;
    L44:
        Object r34 = l.a;
        if (r112 != 0) goto L47;
    L69:
        int r35 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("nav_map_launcher", "[launchLightNav] SmartRouter failed [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        r1 = new NavigationMapAppLauncher.a(false, false);
        goto L101
    L47:
        if ((!StringsKt.isBlank(r112)) == false) goto L49;
        String r117 = r112;
    L50:
        if (r117 == null) goto L69;
        Object r36 = l.a;
        monitor-enter(r36);
        l.b r37 = l.d;     // Catch: Throwable -> L66
        if (r37 == null) goto L59;
        rv3.i r38 = r37.a;     // Catch: Throwable -> L66
        if (r38 == null) goto L59;
        String r39 = r38.f();     // Catch: Throwable -> L66
    L61:
        if (Intrinsics.areEqual(r39, r117) == false) goto L63;
        l.d = null;     // Catch: Throwable -> L66
    L63:
        Unit r40 = Unit.INSTANCE;     // Catch: Throwable -> L66
        monitor-exit(r36);
    L59:
        r39 = null;
    L66:
        th = move-exception;
        throw th;
    L49:
        r117 = null;
        goto L50
    L35:
        r31 = false;
    L31:
        r30 = null;
        goto L32
    L24:
        r29 = null;
    L42:
        e = e;
        goto L44
    L120:
        int r41 = NavigationMapAppLauncher.b.a[r18.ordinal()];     // Catch: RuntimeException -> L93
        if (r41 == 1) goto L98;
        if (r41 != 2) goto L76;
        com.larus.navigation.api.c.b("nav_map_launcher", "[launchExternalApp] apple is not supported on Android");     // Catch: RuntimeException -> L99
        r1 = new NavigationMapAppLauncher.a(false, false);     // Catch: RuntimeException -> L99
        goto L101
    L76:
        if (r41 != 3) goto L78;
        Uri r42 = NavigationMapAppLauncher.c(r14, r15, r16, r115, r3, r4, r23);     // Catch: RuntimeException -> L93
    L83:
        com.larus.navigation.api.c.a("nav_map_launcher", "[launchExternalApp] app=" + r18 + " built URI=" + r42);     // Catch: RuntimeException -> L93
        Intent r43 = new Intent("android.intent.action.VIEW", r42);     // Catch: RuntimeException -> L93
        r43.addFlags(268435456);     // Catch: RuntimeException -> L93
        if (r18 != NavigationMapAppLauncher.AppType.BAIDU) goto L86;
        r43.addFlags(67108864);     // Catch: RuntimeException -> L93
    L86:
        ComponentName r44 = r43.resolveActivity(r24.getPackageManager());     // Catch: RuntimeException -> L93
        if (r44 != null) goto L90;
        com.larus.navigation.api.c.b("nav_map_launcher", "[launchExternalApp] NO Activity handles uri for app=" + r18);     // Catch: RuntimeException -> L93
        com.larus.navigation.api.c.a("nav_map_launcher", "[launchExternalApp] unresolved URI=" + r42);     // Catch: RuntimeException -> L93
        r1 = new NavigationMapAppLauncher.a(false, false);     // Catch: RuntimeException -> L93
        goto L101
    L90:
        com.larus.navigation.api.c.d("nav_map_launcher", "[launchExternalApp] resolveActivity=" + r44 + " → startActivity");     // Catch: RuntimeException -> L93
        r24.startActivity(r43);     // Catch: RuntimeException -> L93
        com.larus.navigation.api.c.d("nav_map_launcher", "[launchExternalApp] startActivity OK for " + r18);     // Catch: RuntimeException -> L93
        r1 = new NavigationMapAppLauncher.a(true, true);     // Catch: RuntimeException -> L99
        goto L101
    L78:
        if (r41 != 4) goto L81;
        r42 = NavigationMapAppLauncher.b(r14, r15, r16, r3, r115);     // Catch: RuntimeException -> L93
        goto L83
    L81:
        throw new NoWhenBranchMatchedException();     // Catch: RuntimeException -> L93
    L98:
        throw new IllegalStateException("DOUBAO should be routed via launchLightNav, not Intent path".toString());     // Catch: RuntimeException -> L99
    L99:
        e = e;
    L100:
        int r45 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.c("nav_map_launcher", "[launchExternalApp] failed for " + r18 + " [" + e.getClass().getSimpleName() + "]: " + e.getMessage(), e);
        r1 = new NavigationMapAppLauncher.a(false, false);
    L93:
        e = e;
    L12:
        r12 = "null";
        goto L13
    }

    public static AbsOpenNavigationMapIDL.b b(int r2, int r3, String r4, String r5, String r6, c r7) {
        Intrinsics.checkNotNullParameter(AbsOpenNavigationMapIDL.b.class, "<this>");
        AbsOpenNavigationMapIDL.b r0 = k3.c.a(AbsOpenNavigationMapIDL.b.class);
        r7.b(r2, r6, r5, r4);
        r0.setResult(r2);
        r0.setBackground(r3);
        r0.setAvailableApps(r4);
        r0.setAppName(r5);
        r0.setSelectedApp(r6);
        return r0;
    }

    /* JADX WARN: Type inference failed for: r15v2, types: [java.lang.Object, rv3.u] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object, rv3.w] */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, rv3.v] */
    public final void f(final AbsOpenNavigationMapIDL.a r33, List<e> r34, NavigationMapAppLauncher.RouteMode r35, sv3.a r36, sv3.a r37, final h<AbsOpenNavigationMapIDL.b> r38, final tv3.d r39, String r40, List<m> r41, NavigationMapAppLauncher.BaiduDrivingPreference r42, NavigationMapAppLauncher.BaiduTransitStrategy r43, final c r44, final long r45) {
        boolean r16 = false;
        if (r40 == null) goto L5;
        boolean r17 = true;
    L7:
        if (r34 != null) goto L20;
        if (r40 != null) goto L10;
    L13:
        boolean r1 = true;
    L14:
        if (r1 == false) goto L16;
        List<e> r2 = null;
    L17:
        if (r2 != null) goto L21;
        r44.a();
        h.a.a(r38, "empty_dialog_list", null, null, 14);
        return;
    L21:
        int r3 = com.larus.navigation.api.c.a;
        StringBuilder r4 = new StringBuilder("[step2/handleDialog] parsed items.size=");
        r4.append(r2.size());
        r4.append(", mode=");
        r4.append(r35);
        if (r40 == null) goto L24;
        String r5 = " (direct-launch fallback for " + r40 + ')';
    L25:
        r4.append(r5);
        com.larus.navigation.api.c.d("jsb_open_nav_map", r4.toString());
        ArrayList r6 = new ArrayList();
        ArrayList r7 = new ArrayList();
        List<e> r8 = r2;
        Iterator<T> r9 = r8.iterator();
    L27:
        if (r9.hasNext() == false) goto L49;
        e r10 = (e) r9.next();
        NavigationMapAppLauncher.AppType.a r11 = NavigationMapAppLauncher.AppType.Companion;
        String r12 = r10.a();
        r11.getClass();
        NavigationMapAppLauncher.AppType r13 = NavigationMapAppLauncher.AppType.a.a(r12);
        if (r13 != null) goto L31;
        int r14 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.5/filter] appName=" + r10.a() + " DROP (unknown enum)");
    L40:
        com.bytedance.applet.aibridge.navi.picker.a.C0051a r15 = null;
    L45:
        if (r15 == null) goto L27;
        r6.add(r15);
        r7.add(r15.c);
        goto L27
    L31:
        NavigationMapAppLauncher.a.getClass();
        if (NavigationMapAppLauncher.j(r13, r35) == true) goto L34;
        int r18 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.5/filter] " + r13 + " DROP (mode " + r35 + " not supported)");
        goto L40
    L34:
        NavigationMapAppLauncher.AppType r19 = NavigationMapAppLauncher.AppType.DOUBAO;
        if (r13 != r19) goto L37;
        int r20 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.5/filter] " + r13 + " KEEP (standard light-navigation style)");
        r15 = new com.bytedance.applet.aibridge.navi.picker.a.C0051a("轻导航(推荐)", "无需下载,点击即用", r19.getKey(), NavigationMapAppLauncher.InstallState.IN_APP);
        goto L45
    L37:
        NavigationMapAppLauncher.InstallState r21 = NavigationMapAppLauncher.g(r13);
        if (r21 != NavigationMapAppLauncher.InstallState.NEED_INSTALL) goto L41;
        int r22 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.5/filter] " + r13 + " DROP (NEED_INSTALL)");
        goto L40
    L41:
        int r110 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.5/filter] " + r13 + " KEEP (installState=" + r21 + ')');
        String r111 = r10.c();
        if (r111 != null) goto L44;
        r111 = d(r13);
    L44:
        r15 = new com.bytedance.applet.aibridge.navi.picker.a.C0051a(r111, r10.b(), r13.getKey(), r21);
        goto L45
    L49:
        Pair r23 = TuplesKt.to(r6, r7);
        final List r112 = (List) r23.component1();
        List r24 = (List) r23.component2();
        String r25 = r33.getBackupApp();
        if (r25 != null) goto L53;
        r25 = r40;
    L53:
        if ((r8 instanceof Collection) == true) goto L55;
    L57:
        Iterator<T> r0 = r8.iterator();
    L59:
        if (r0.hasNext() == false) goto L70;
        e r26 = (e) r0.next();
        NavigationMapAppLauncher.AppType.a r27 = NavigationMapAppLauncher.AppType.Companion;
        String r28 = r26.a();
        r27.getClass();
        NavigationMapAppLauncher.AppType r29 = NavigationMapAppLauncher.AppType.a.a(r28);
        if (r29 != null) goto L63;
    L67:
        boolean r30 = false;
    L68:
        if (r30 == false) goto L59;
        boolean r31 = true;
    L71:
        boolean r32 = !r112.isEmpty();
        if (r31 == false) goto L81;
        if (r32 == true) goto L81;
        NavigationMapAppLauncher.AppType.Companion.getClass();
        NavigationMapAppLauncher.AppType r46 = NavigationMapAppLauncher.AppType.a.a(r25);
        if (r46 == null) goto L81;
        String r47 = r46.getPackageName();
        if (r47 == null) goto L81;
        String r113 = null;
        r112.add(new com.bytedance.applet.aibridge.navi.picker.a.C0051a(d(r46), null, "install_app", null));
        int r48 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "no available app, showing install fallback for " + r25);
        String r49 = r47;
    L82:
        int r50 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2.6/fallback] hasThirdPartyConfigured=" + r31 + " hasAnyEligibleRow=" + r32 + " fallbackPkg=" + r49);
        boolean r51 = Intrinsics.areEqual(r33.getStartNaviDirectly(), Boolean.FALSE) ^ true;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step3/handleDialog] showing picker: rows=" + r112.size() + " availableKeys=" + r24 + " installFallback=" + r49 + " startNaviDirectly=" + r51);
        String r52 = CollectionsKt.joinToString$default(r24, ",", null, null, 0, null, null, 62, null);
        String r53 = r33.getRouteMode();
        String r54 = r33.getDPoiId();
        String r114 = r33.getDPoiIdType();
        String r55 = r39.a;
        yv3.b r56 = r33.getTraceContext();
        if (r56 == null) goto L89;
        String r57 = r56.b();
        if (r57 == null) goto L89;
        if (StringsKt.isBlank(r57) == true) goto L89;
        String r115 = r57;
    L90:
        yv3.b r58 = r33.getTraceContext();
        if (r58 == null) goto L97;
        String r59 = r58.d();
        if (r59 == null) goto L97;
        if (StringsKt.isBlank(r59) == true) goto L97;
        String r210 = r59;
    L98:
        final String r211 = r49;
        final b r212 = new b(r35, r36, r37, r51, r52, r53, r54, r114, r55, r115, r210, r41, false, r42, r43);
        if (r112.isEmpty() == false) goto L102;
        com.larus.navigation.api.c.b("jsb_open_nav_map", "[step3/handleDialog] no eligible rows + no backup, returning EMPTY_DIALOG_LIST");
        r44.a();
        h.a.a(r38, "empty_dialog_list", null, null, 14);
        return;
    L102:
        List r116 = r112;
        final ArrayList r60 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r61 = r116.iterator();
    L104:
        if (r61.hasNext() == false) goto L107;
        r60.add(j(((com.bytedance.applet.aibridge.navi.picker.a.C0051a) r61.next()).c, r211));
        goto L104
    L107:
        if ((r116 instanceof Collection) == true) goto L109;
    L111:
        Iterator r62 = r116.iterator();
    L113:
        if (r62.hasNext() == false) goto L117;
        if (Intrinsics.areEqual(((com.bytedance.applet.aibridge.navi.picker.a.C0051a) r62.next()).c, NavigationMapAppLauncher.AppType.DOUBAO.getKey()) == false) goto L113;
        r16 = true;
    L117:
        if (r16 == false) goto L135;
        int r63 = d.c[r35.ordinal()];
        if (r63 != 1) goto L121;
        NavigationLocationPrewarmMode r64 = NavigationLocationPrewarmMode.WALKING;
    L134:
        final NavigationLocationPrewarmMode r65 = r64;
    L136:
        final Ref.BooleanRef r117 = new Ref.BooleanRef();
        final Ref.ObjectRef r118 = new Ref.ObjectRef();
        WeakReference<Dialog> r66 = com.bytedance.applet.aibridge.navi.picker.a.a;
        final boolean r67 = r17;
        final ?? r119 = new u(r45, r117, r65, r39, r67, r60, r118, r33);
        final ?? r68 = new v(r45);
        final boolean r69 = r17;
        final ?? r70 = new w(r45, r117, r39, r69, r118, r38, this, r212, r44, r112, r211);
        Intrinsics.checkNotNullParameter(r112, "items");
        Intrinsics.checkNotNullParameter(r119, "onPresented");
        Intrinsics.checkNotNullParameter(r68, "shouldPresent");
        Intrinsics.checkNotNullParameter(r70, "onSelected");
        t0.e(new sv3.h(r68, r70, r112, r119));
        return;
    L121:
        if (r63 != 2) goto L123;
    L132:
        r64 = NavigationLocationPrewarmMode.CYCLING;
        goto L134
    L123:
        if (r63 == 3) goto L132;
        if (r63 != 4) goto L127;
    L131:
        r64 = null;
        goto L134
    L127:
        if (r63 == 5) goto L131;
        throw new NoWhenBranchMatchedException();
    L135:
        r65 = null;
        goto L136
    L109:
        if (r116.isEmpty() == false) goto L111;
    L97:
        r210 = r113;
    L89:
        r115 = r113;
    L81:
        r113 = null;
        r49 = null;
        goto L82
    L63:
        if (r29 == NavigationMapAppLauncher.AppType.DOUBAO) goto L67;
        NavigationMapAppLauncher.a.getClass();
        if (NavigationMapAppLauncher.j(r29, r35) == false) goto L67;
        r30 = true;
    L70:
        r31 = false;
        goto L71
    L55:
        if (r8.isEmpty() == false) goto L57;
    L24:
        r5 = "";
        goto L25
    L16:
        int r71 = com.larus.navigation.api.c.a;
        com.larus.navigation.api.c.d("jsb_open_nav_map", "[step2/handleDialog] synthesised items=[" + r40 + "] from direct-launch fallback");
        r2 = CollectionsKt.listOf(new e(r40, null, null));
        goto L17
    L10:
        if (r40.length() == 0) goto L13;
        r1 = false;
        goto L14
    L20:
        r2 = r34;
        goto L21
    L5:
        r17 = false;
        goto L7
    }
}
