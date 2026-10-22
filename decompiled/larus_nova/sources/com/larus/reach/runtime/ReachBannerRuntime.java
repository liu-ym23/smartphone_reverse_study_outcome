package com.larus.reach.runtime;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.setting.UserSettingDelegate;
import com.larus.bmhome.chat.setting.bean.UserConfigKey;
import com.larus.common_ui.venus.ShapeLinearLayout;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.larus.platform.model.UserConfigItem;
import com.larus.reach.api.ReachBannerHost;
import com.larus.reach.api.ReachButtonStyle;
import com.larus.reach.api.ReachButtonType;
import com.larus.reach.api.ReachClickTarget;
import com.larus.reach.api.ReachCloseReason;
import com.larus.reach.api.ReachCustomClickResult;
import com.larus.reach.api.ReachPosition;
import com.larus.reach.api.ReachRejectReason;
import com.larus.reach.api.ReachRequestSource;
import com.larus.reach.api.ReachSceneInterceptor;
import com.larus.reach.api.ReachSceneLifecycleListener;
import com.larus.reach.ui.ReachSwipeDismissLayout;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.IntIterator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes31.dex */
public final class ReachBannerRuntime {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f367246j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f367247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final os9.g f367248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.reach.impl.a f367249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.larus.reach.impl.n f367250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AtomicLong f367251e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicLong f367252f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinkedHashMap<String, c> f367253g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f367254h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f367255i;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Lcom/larus/reach/runtime/ReachBannerRuntime$EntryState;", "", "<init>", "(Ljava/lang/String;I)V", "PENDING", "WAITING_HOST", "WAITING_POSITION", "CHECKING", "ALLOWED", "FOREGROUND", "BACKGROUND", "DISMISSING", "isPresented", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EntryState extends Enum<EntryState> {
        public static final EntryState ALLOWED = null;
        public static final EntryState BACKGROUND = null;
        public static final EntryState CHECKING = null;
        public static final EntryState DISMISSING = null;
        public static final EntryState FOREGROUND = null;
        public static final EntryState PENDING = null;
        public static final EntryState WAITING_HOST = null;
        public static final EntryState WAITING_POSITION = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EntryState[] f367256a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f367257b = null;

        public static EnumEntries<EntryState> getEntries() {
            return f367257b;
        }

        static {
            EntryState r100 = new EntryState("PENDING", 0);
            PENDING = r100;
            EntryState r101 = new EntryState("WAITING_HOST", 1);
            WAITING_HOST = r101;
            EntryState r102 = new EntryState("WAITING_POSITION", 2);
            WAITING_POSITION = r102;
            EntryState r103 = new EntryState("CHECKING", 3);
            CHECKING = r103;
            EntryState r104 = new EntryState("ALLOWED", 4);
            ALLOWED = r104;
            EntryState r105 = new EntryState("FOREGROUND", 5);
            FOREGROUND = r105;
            EntryState r110 = new EntryState("BACKGROUND", 6);
            BACKGROUND = r110;
            EntryState r111 = new EntryState("DISMISSING", 7);
            DISMISSING = r111;
            EntryState[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
            f367256a = r112;
            f367257b = EnumEntriesKt.enumEntries(r112);
        }

        public static EntryState[] values() {
            return (EntryState[]) f367256a.clone();
        }

        public final boolean isPresented() {
            if (this != ALLOWED) goto L5;
        L12:
            return true;
        L5:
            if (this == FOREGROUND) goto L12;
            if (this == BACKGROUND) goto L12;
            if (this == DISMISSING) goto L12;
            return false;
        }

        public static EntryState valueOf(String r100) {
            return (EntryState) r27.a.a(EntryState.class, r100);
        }

        public EntryState(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/reach/runtime/ReachBannerRuntime$ReachGatePhase;", "", "<init>", "(Ljava/lang/String;I)V", "SUBMIT", "BEFORE_PRESENT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ReachGatePhase extends Enum<ReachGatePhase> {
        public static final ReachGatePhase BEFORE_PRESENT = null;
        public static final ReachGatePhase SUBMIT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ReachGatePhase[] f367258a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f367259b = null;

        public static EnumEntries<ReachGatePhase> getEntries() {
            return f367259b;
        }

        static {
            ReachGatePhase r100 = new ReachGatePhase("SUBMIT", 0);
            SUBMIT = r100;
            ReachGatePhase r101 = new ReachGatePhase("BEFORE_PRESENT", 1);
            BEFORE_PRESENT = r101;
            ReachGatePhase[] r102 = {r100, r101};
            f367258a = r102;
            f367259b = EnumEntriesKt.enumEntries(r102);
        }

        public static ReachGatePhase[] values() {
            return (ReachGatePhase[]) f367258a.clone();
        }

        public static ReachGatePhase valueOf(String r100) {
            return (ReachGatePhase) r27.a.a(ReachGatePhase.class, r100);
        }

        public ReachGatePhase(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.larus.reach.runtime.ReachBannerRuntime$a$a, reason: collision with other inner class name */
        public static final class C4479a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f367260a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4479a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f367260a, ((C4479a) r100).f367260a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f367260a.hashCode();
            }

            public final String toString() {
                return "Check(entry=" + this.f367260a + ')';
            }

            public C4479a(c r100) {
                Intrinsics.checkNotNullParameter(r100, "entry");
                this.f367260a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f367261a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ReachCloseReason f367262b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f367261a, r101.f367261a) == true) goto L12;
                return false;
            L12:
                if (this.f367262b == r101.f367262b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f367261a.hashCode() * 31) + this.f367262b.hashCode();
            }

            public final String toString() {
                return "Dismiss(entry=" + this.f367261a + ", reason=" + this.f367262b + ')';
            }

            public b(c r100, ReachCloseReason r101) {
                Intrinsics.checkNotNullParameter(r100, "entry");
                Intrinsics.checkNotNullParameter(r101, "reason");
                this.f367261a = r100;
                this.f367262b = r101;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final c f367263a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ReachRejectReason f367264b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f367263a, r101.f367263a) == true) goto L12;
                return false;
            L12:
                if (this.f367264b == r101.f367264b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                return (this.f367263a.hashCode() * 31) + this.f367264b.hashCode();
            }

            public final String toString() {
                return "Reject(entry=" + this.f367263a + ", reason=" + this.f367264b + ')';
            }

            public c(c r100, ReachRejectReason r101) {
                Intrinsics.checkNotNullParameter(r100, "entry");
                Intrinsics.checkNotNullParameter(r101, "reason");
                this.f367263a = r100;
                this.f367264b = r101;
            }
        }

        public a() {
        }
    }

    public static final class b {
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ns9.t f367265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f367266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f367267c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f367268d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f367269e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EntryState f367270f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ReachBannerHost f367271g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public long f367272h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public long f367273i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public long f367274j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f367275k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f367276l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f367277m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public ns9.c f367278n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f367279o;

        public c() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f367265a, r101.f367265a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f367266b, r101.f367266b) == true) goto L15;
            return false;
        L15:
            if (this.f367267c == r101.f367267c) goto L18;
            return false;
        L18:
            if (this.f367268d == r101.f367268d) goto L21;
            return false;
        L21:
            if (this.f367269e == r101.f367269e) goto L24;
            return false;
        L24:
            if (this.f367270f == r101.f367270f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f367271g, r101.f367271g) == true) goto L30;
            return false;
        L30:
            if (this.f367272h == r101.f367272h) goto L33;
            return false;
        L33:
            if (this.f367273i == r101.f367273i) goto L36;
            return false;
        L36:
            if (this.f367274j == r101.f367274j) goto L39;
            return false;
        L39:
            if (this.f367275k == r101.f367275k) goto L42;
            return false;
        L42:
            if (this.f367276l == r101.f367276l) goto L45;
            return false;
        L45:
            if (this.f367277m == r101.f367277m) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f367278n, r101.f367278n) == true) goto L51;
            return false;
        L51:
            if (this.f367279o == r101.f367279o) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f367265a.hashCode() * 31;
            Function0<Unit> r101 = this.f367266b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            long r104 = this.f367267c;
            int r105 = (((r100 + r103) * 31) + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f367268d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            int r108 = 1231;
            if (this.f367269e == false) goto L9;
            int r109 = 1231;
        L10:
            int r110 = (((r107 + r109) * 31) + this.f367270f.hashCode()) * 31;
            ReachBannerHost r111 = this.f367271g;
            if (r111 != null) goto L13;
            int r112 = 0;
        L14:
            long r113 = this.f367272h;
            int r114 = (((r110 + r112) * 31) + ((int) (r113 ^ (r113 >>> 32)))) * 31;
            long r115 = this.f367273i;
            int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
            long r117 = this.f367274j;
            int r118 = (r116 + ((int) (r117 ^ (r117 >>> 32)))) * 31;
            if (this.f367275k == false) goto L17;
            int r119 = 1231;
        L18:
            int r120 = (r118 + r119) * 31;
            if (this.f367276l == false) goto L21;
            int r121 = 1231;
        L22:
            long r122 = this.f367277m;
            int r123 = (((r120 + r121) * 31) + ((int) (r122 ^ (r122 >>> 32)))) * 31;
            ns9.c r124 = this.f367278n;
            if (r124 == null) goto L26;
            r102 = r124.hashCode();
        L26:
            int r125 = (r123 + r102) * 31;
            if (this.f367279o == true) goto L31;
            r108 = 1237;
        L31:
            return r125 + r108;
        L21:
            r121 = 1237;
            goto L22
        L17:
            r119 = 1237;
            goto L18
        L13:
            r112 = r111.hashCode();
            goto L14
        L9:
            r109 = 1237;
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Entry(request=" + this.f367265a + ", localClickAction=" + this.f367266b + ", arrivalOrder=" + this.f367267c + ", entryToken=" + this.f367268d + ", isP0=" + this.f367269e + ", state=" + this.f367270f + ", host=" + this.f367271g + ", firstShownAtUptimeMs=" + this.f367272h + ", foregroundStartedAtMs=" + this.f367273i + ", remainingAutoDismissMs=" + this.f367274j + ", autoDismissEnabled=" + this.f367275k + ", hasAutoDismissTimeout=" + this.f367276l + ", autoDismissGeneration=" + this.f367277m + ", content=" + this.f367278n + ", localClickActionConsumed=" + this.f367279o + ')';
        }

        public final void a(EntryState r100) {
            Intrinsics.checkNotNullParameter(r100, "<set-?>");
            this.f367270f = r100;
        }

        public c(ns9.t r100, Function0 r101, long r102, long r103, boolean r104) {
            EntryState r105 = EntryState.PENDING;
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r105, "state");
            this.f367265a = r100;
            this.f367266b = r101;
            this.f367267c = r102;
            this.f367268d = r103;
            this.f367269e = r104;
            this.f367270f = r105;
            this.f367271g = null;
            this.f367272h = 0;
            this.f367273i = 0;
            this.f367274j = 0;
            this.f367275k = true;
            this.f367276l = false;
            this.f367277m = 0;
            this.f367278n = null;
            this.f367279o = false;
        }
    }

    public static abstract class d {

        public static final class a extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReachBannerHost f367280a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f367280a, ((a) r100).f367280a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f367280a.hashCode();
            }

            public final String toString() {
                return "Ready(host=" + this.f367280a + ')';
            }

            public a(ReachBannerHost r100) {
                Intrinsics.checkNotNullParameter(r100, "host");
                this.f367280a = r100;
            }
        }

        public static final class b extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReachRejectReason f367281a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ReachBannerHost f367282b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (this.f367281a == r101.f367281a) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f367282b, r101.f367282b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f367281a.hashCode() * 31;
                ReachBannerHost r101 = this.f367282b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Reject(reason=" + this.f367281a + ", host=" + this.f367282b + ')';
            }

            public b(ReachRejectReason r100, ReachBannerHost r101) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f367281a = r100;
                this.f367282b = r101;
            }
        }

        public static final class c extends d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReachBannerHost f367283a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final long f367284b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f367285c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f367283a, r101.f367283a) == true) goto L12;
                return false;
            L12:
                if (this.f367284b == r101.f367284b) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f367285c, r101.f367285c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f367283a.hashCode() * 31;
                long r101 = this.f367284b;
                int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
                String r103 = this.f367285c;
                if (r103 != null) goto L5;
                int r104 = 0;
            L7:
                return r102 + r104;
            L5:
                r104 = r103.hashCode();
                goto L7
            }

            public final String toString() {
                return "Wait(host=" + this.f367283a + ", environmentGeneration=" + this.f367284b + ", reason=" + this.f367285c + ')';
            }

            public c(ReachBannerHost r100, long r101, String r102) {
                Intrinsics.checkNotNullParameter(r100, "host");
                this.f367283a = r100;
                this.f367284b = r101;
                this.f367285c = r102;
            }
        }

        public d() {
        }
    }

    public static abstract class e {

        public static final class a extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReachBannerHost f367286a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ns9.g f367287b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ns9.c f367288c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final c f367289d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final ReachCloseReason f367290e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f367286a, r101.f367286a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f367287b, r101.f367287b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f367288c, r101.f367288c) == true) goto L18;
                return false;
            L18:
                if (Intrinsics.areEqual(this.f367289d, r101.f367289d) == true) goto L21;
                return false;
            L21:
                if (this.f367290e == r101.f367290e) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                return (((((((this.f367286a.hashCode() * 31) + this.f367287b.hashCode()) * 31) + this.f367288c.hashCode()) * 31) + this.f367289d.hashCode()) * 31) + this.f367290e.hashCode();
            }

            public final String toString() {
                return "Replace(host=" + this.f367286a + ", session=" + this.f367287b + ", content=" + this.f367288c + ", replacedEntry=" + this.f367289d + ", reason=" + this.f367290e + ')';
            }

            public a(ReachBannerHost r100, f r101, ns9.c r102, c r103, ReachCloseReason r104) {
                Intrinsics.checkNotNullParameter(r100, "host");
                Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
                Intrinsics.checkNotNullParameter(r102, "content");
                Intrinsics.checkNotNullParameter(r103, "replacedEntry");
                Intrinsics.checkNotNullParameter(r104, "reason");
                this.f367286a = r100;
                this.f367287b = r101;
                this.f367288c = r102;
                this.f367289d = r103;
                this.f367290e = r104;
            }
        }

        public static final class b extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ReachBannerHost f367291a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ns9.g f367292b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final ns9.c f367293c;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L8;
                return false;
            L8:
                b r101 = (b) r100;
                if (Intrinsics.areEqual(this.f367291a, r101.f367291a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f367292b, r101.f367292b) == true) goto L15;
                return false;
            L15:
                if (Intrinsics.areEqual(this.f367293c, r101.f367293c) == true) goto L17;
                return false;
            L17:
                return true;
            }

            public final int hashCode() {
                return (((this.f367291a.hashCode() * 31) + this.f367292b.hashCode()) * 31) + this.f367293c.hashCode();
            }

            public final String toString() {
                return "Show(host=" + this.f367291a + ", session=" + this.f367292b + ", content=" + this.f367293c + ')';
            }

            public b(ReachBannerHost r100, f r101, ns9.c r102) {
                Intrinsics.checkNotNullParameter(r100, "host");
                Intrinsics.checkNotNullParameter(r101, AppbrandHostConstants.SCHEMA_INSPECT.SESSION);
                Intrinsics.checkNotNullParameter(r102, "content");
                this.f367291a = r100;
                this.f367292b = r101;
                this.f367293c = r102;
            }
        }

        public static final class c extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f367294a = null;

            static {
                f367294a = new c();
            }

            public c() {
            }
        }

        public static final class d extends e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Long f367295a;

            public d() {
                this(null);
            }

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f367295a, ((d) r100).f367295a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                Long r100 = this.f367295a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Wait(retryDelayMs=" + this.f367295a + ')';
            }

            public d(Long r100) {
                this.f367295a = r100;
            }
        }

        public e() {
        }
    }

    public static final class f implements ns9.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ns9.t f367296a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f367297b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ReachBannerRuntime f367298c;

        @Override // ns9.g
        public final void a() {
            ReachBannerRuntime r100 = this.f367298c;
            String r101 = this.f367296a.f520408a.f520400h;
            long r102 = this.f367297b;
            monitor-enter(r100);
            c r103 = r100.f367253g.get(r101);     // Catch: Throwable -> L26
            if (r103 != null) goto L7;
        L24:
            monitor-exit(r100);
            return;
        L7:
            if (r103.f367268d == r102) goto L9;
        L11:
            boolean r104 = false;
        L12:
            if (r104 == true) goto L15;
            r103 = null;
        L15:
            if (r103 == null) goto L24;
            r103.a(EntryState.BACKGROUND);     // Catch: Throwable -> L26
            r103.f367277m++;     // Catch: Throwable -> L26
            long r105 = r103.f367273i;     // Catch: Throwable -> L26
            if (r105 <= 0) goto L21;
            long r106 = r103.f367274j;     // Catch: Throwable -> L26
            if (r106 <= 0) goto L21;
            r103.f367274j = RangesKt.coerceAtLeast(r106 - (SystemClock.uptimeMillis() - r105), 0);     // Catch: Throwable -> L26
        L21:
            r103.f367273i = 0;     // Catch: Throwable -> L26
            Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L26
            monitor-exit(r100);
            r100.r();
            return;
        L9:
            if (r103.f367270f != EntryState.FOREGROUND) goto L11;
            r104 = true;
        L26:
            th = move-exception;
            throw th;
        }

        @Override // ns9.g
        public final void c() {
            final ReachBannerRuntime r100 = this.f367298c;
            final String r101 = this.f367296a.f520408a.f520400h;
            long r102 = this.f367297b;
            monitor-enter(r100);
            c r103 = r100.f367253g.get(r101);     // Catch: Throwable -> L79
            if (r103 != null) goto L7;
        L77:
            monitor-exit(r100);
            return;
        L7:
            if (r103.f367268d != r102) goto L9;
            boolean r104 = true;
        L10:
            if (r104 == true) goto L13;
            r103 = null;
        L13:
            if (r103 == null) goto L77;
            EntryState r105 = r103.f367270f;     // Catch: Throwable -> L79
            EntryState r106 = EntryState.FOREGROUND;     // Catch: Throwable -> L79
            if (r105 != r106) goto L20;
            monitor-exit(r100);
            return;
        L20:
            if (r105 != EntryState.ALLOWED) goto L22;
        L25:
            r103.a(r106);     // Catch: Throwable -> L79
            if (r103.f367272h > 0) goto L28;
            boolean r110 = true;
        L29:
            if (r110 == false) goto L31;
            r103.f367272h = SystemClock.uptimeMillis();     // Catch: Throwable -> L79
        L31:
            if (r110 == false) goto L39;
            ns9.t r107 = r103.f367265a;     // Catch: Throwable -> L79
            Long r108 = r107.f520410c.f520406b;     // Catch: Throwable -> L79
            if (r108 == null) goto L36;
            long r109 = RangesKt.coerceAtLeast(r108.longValue(), 0);     // Catch: Throwable -> L79
        L40:
            long r111 = r109;
            if (r110 == true) goto L43;
        L47:
            r103.f367274j = r111;     // Catch: Throwable -> L79
            r103.f367273i = SystemClock.uptimeMillis();     // Catch: Throwable -> L79
            r103.f367277m++;     // Catch: Throwable -> L79
            Collection<c> r112 = r100.f367253g.values();     // Catch: Throwable -> L79
            ArrayList r113 = new ArrayList();     // Catch: Throwable -> L79
            Iterator<T> r114 = r112.iterator();     // Catch: Throwable -> L79
        L49:
            if (r114.hasNext() == false) goto L58;
            Object r115 = r114.next();     // Catch: Throwable -> L79
            c r116 = (c) r115;     // Catch: Throwable -> L79
            if (r116.f367265a.f520409b.b() == r103.f367265a.f520409b.b()) goto L53;
        L55:
            boolean r117 = false;
        L56:
            if (r117 == false) goto L49;
            r113.add(r115);     // Catch: Throwable -> L79
            goto L49
        L53:
            if (r116.f367270f != EntryState.WAITING_POSITION) goto L55;
            r117 = true;
            goto L56
        L58:
            Iterator r118 = r113.iterator();     // Catch: Throwable -> L79
        L60:
            if (r118.hasNext() == false) goto L62;
            ((c) r118.next()).a(EntryState.PENDING);     // Catch: Throwable -> L79
            goto L60
        L62:
            ns9.t r119 = r103.f367265a;     // Catch: Throwable -> L79
            if (r103.f367275k == true) goto L65;
        L67:
            boolean r120 = false;
        L68:
            final g r121 = new g(r119, r110, r111, r120, r103.f367268d, r103.f367277m);     // Catch: Throwable -> L79
            monitor-exit(r100);
            if (r121.f367300b == false) goto L74;
            ConcurrentHashMap<String, Long> r122 = com.larus.reach.impl.b.f367163a;
            com.larus.reach.impl.b.e(r121.f367299a);
            r100.f367250d.a(r121.f367299a);
            Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r123 = y.f367359a;
            y.d(r121.f367299a);
        L74:
            if (r121.f367302d == false) goto L76;
            r100.f367247a.postDelayed(new n(r100, r101, r121), RangesKt.coerceAtLeast(r121.f367301c, 0));
        L76:
            r100.r();
            return;
        L65:
            if (r103.f367276l == false) goto L67;
            r120 = true;
            goto L68
        L43:
            if (r111 <= 0) goto L45;
            boolean r124 = true;
        L46:
            r103.f367276l = r124;     // Catch: Throwable -> L79
            goto L47
        L45:
            r124 = false;
            goto L46
        L36:
            if (r107.f520409b.b() != ReachPosition.TOP) goto L38;
            r109 = 5000;
            goto L40
        L38:
            r109 = 10000;
            goto L40
        L39:
            r109 = r103.f367274j;     // Catch: Throwable -> L79
            goto L40
        L28:
            r110 = false;
            goto L29
        L22:
            if (r105 == EntryState.BACKGROUND) goto L25;
            monitor-exit(r100);
            return;
        L9:
            r104 = false;
        L79:
            th = move-exception;
            throw th;
        }

        @Override // ns9.g
        public final void b(ReachCloseReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f367298c.s(this.f367296a.f520408a.f520400h, this.f367297b, r100);
        }

        public final ReachCustomClickResult d(ns9.e r110) {
            Intrinsics.checkNotNullParameter(r110, "click");
            ReachBannerRuntime r100 = this.f367298c;
            String r101 = this.f367296a.f520408a.f520400h;
            long r102 = this.f367297b;
            r100.getClass();
            if (r110.f520368a == ReachClickTarget.CLOSE) goto L86;
            monitor-enter(r100);
            c r103 = r100.f367253g.get(r101);     // Catch: Throwable -> L75
            if (r103 == null) goto L72;
            boolean r104 = false;
            if (r103.f367268d != r102) goto L11;
            boolean r105 = true;
        L12:
            Function0<Unit> r106 = null;
            if (r105 == true) goto L16;
            r103 = null;
        L16:
            if (r103 == null) goto L72;
            EntryState r107 = r103.f367270f;     // Catch: Throwable -> L75
            if (r107 != EntryState.ALLOWED) goto L20;
        L24:
            ns9.t r108 = r103.f367265a;     // Catch: Throwable -> L75
            Function0<Unit> r109 = r103.f367266b;     // Catch: Throwable -> L75
            if (r109 == null) goto L27;
            boolean r111 = true;
        L28:
            if (r111 == true) goto L30;
        L32:
            Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L75
            monitor-exit(r100);
            if (r111 == false) goto L45;
            if (r106 == null) goto L87;
            Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L38
            Object r114 = Result.m9449constructorimpl(r106.invoke());     // Catch: Throwable -> L38
        L40:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
            if (r115 == null) goto L43;
            FLogger.f375446a.w("ReachBannerRuntime", "reach local click action failed, reachUniqueId=" + r101, r115);
        L43:
            Result.m9448boximpl(r114);
        L38:
            th = move-exception;
            Result.Companion r116 = Result.Companion;
            r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L87:
            return ReachCustomClickResult.LOCAL_HANDLED;
        L45:
            if (r108 == null) goto L90;
            Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r117 = y.f367359a;
            Intrinsics.checkNotNullParameter(r108, "request");
            Intrinsics.checkNotNullParameter(r110, "click");
            List r118 = y.f(r108.f520408a.f520395c);
            if ((r118 instanceof Collection) == true) goto L49;
        L51:
            Iterator r119 = r118.iterator();
        L53:
            if (r119.hasNext() == false) goto L68;
            ReachSceneInterceptor r120 = (ReachSceneInterceptor) r119.next();
            Result.Companion r121 = Result.Companion;     // Catch: Throwable -> L57
            Object r122 = Result.m9449constructorimpl(Boolean.valueOf(r120.j(r108, r110)));     // Catch: Throwable -> L57
        L59:
            Throwable r123 = Result.m9452exceptionOrNullimpl(r122);
            if (r123 == null) goto L62;
            FLogger.f375446a.w("ReachSceneDispatcher", "reach scene click action failed, reachUniqueId=" + r108.f520408a.f520400h + ", scene=" + r108.f520408a.f520395c, r123);
        L62:
            Boolean r124 = Boolean.FALSE;
            if (Result.m9455isFailureimpl(r122) == false) goto L66;
            r122 = r124;
        L66:
            if (((Boolean) r122).booleanValue() == false) goto L53;
            r104 = true;
        L57:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r122 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L68:
            if (r104 == false) goto L89;
            return ReachCustomClickResult.SCENE_HANDLED;
        L89:
            return ReachCustomClickResult.NOT_HANDLED;
        L49:
            if (r118.isEmpty() == false) goto L51;
        L90:
            return ReachCustomClickResult.LOCAL_HANDLED;
        L30:
            if (r103.f367279o == true) goto L32;
            r103.f367279o = true;     // Catch: Throwable -> L75
            r106 = r109;
            goto L32
        L27:
            r111 = false;
            goto L28
        L20:
            if (r107 == EntryState.FOREGROUND) goto L24;
            ReachCustomClickResult r126 = ReachCustomClickResult.LOCAL_HANDLED;     // Catch: Throwable -> L75
            monitor-exit(r100);
            return r126;
        L11:
            r105 = false;
        L72:
            ReachCustomClickResult r127 = ReachCustomClickResult.LOCAL_HANDLED;     // Catch: Throwable -> L75
            monitor-exit(r100);
            return r127;
        L75:
            th = move-exception;
            throw th;
        L86:
            return ReachCustomClickResult.NOT_HANDLED;
        }

        public f(ns9.t r100, long r101, ReachBannerRuntime r102) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r102, "runtime");
            this.f367296a = r100;
            this.f367297b = r101;
            this.f367298c = r102;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ns9.t f367299a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f367300b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f367301c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f367302d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f367303e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f367304f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f367299a, r101.f367299a) == true) goto L12;
            return false;
        L12:
            if (this.f367300b == r101.f367300b) goto L15;
            return false;
        L15:
            if (this.f367301c == r101.f367301c) goto L18;
            return false;
        L18:
            if (this.f367302d == r101.f367302d) goto L21;
            return false;
        L21:
            if (this.f367303e == r101.f367303e) goto L24;
            return false;
        L24:
            if (this.f367304f == r101.f367304f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f367299a.hashCode() * 31;
            int r101 = 1231;
            if (this.f367300b == false) goto L5;
            int r102 = 1231;
        L6:
            long r103 = this.f367301c;
            int r104 = (((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            if (this.f367302d == true) goto L10;
            r101 = 1237;
        L10:
            int r105 = (r104 + r101) * 31;
            long r106 = this.f367303e;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f367304f;
            return r107 + ((int) (r108 ^ (r108 >>> 32)));
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ShownResult(request=" + this.f367299a + ", firstShown=" + this.f367300b + ", autoDismissMs=" + this.f367301c + ", scheduleAutoDismiss=" + this.f367302d + ", entryToken=" + this.f367303e + ", autoDismissGeneration=" + this.f367304f + ')';
        }

        public g(ns9.t r100, boolean r101, long r102, boolean r103, long r104, long r105) {
            Intrinsics.checkNotNullParameter(r100, "request");
            this.f367299a = r100;
            this.f367300b = r101;
            this.f367301c = r102;
            this.f367302d = r103;
            this.f367303e = r104;
            this.f367304f = r105;
        }
    }

    public /* synthetic */ class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f367305a = null;

        static {
            int[] r100 = new int[ReachCloseReason.values().length];
            r100[ReachCloseReason.BUSINESS_NOT_ALLOWED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReachCloseReason.REVOKED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f367305a = r100;
        }
    }

    public static final class i<T> implements Comparator {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((c) r100).f367267c), Long.valueOf(((c) r101).f367267c));
        }
    }

    static {
    }

    public final void e() {
        monitor-enter(this);
    L44:
        th = move-exception;
        throw th;
    L4:
        if (this.f367255i == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f367255i = true;     // Catch: Throwable -> L44
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L44
        monitor-exit(this);
    L57:
        monitor-enter(this);     // Catch: Throwable -> L36
        a r101 = h();     // Catch: Throwable -> L33
        if (r101 != null) goto L15;
        r101 = k();     // Catch: Throwable -> L33
    L15:
        monitor-exit(this);     // Catch: Throwable -> L36
        if (r101 == null) goto L17;
        g(r101);     // Catch: Throwable -> L36
        if ((r101 instanceof a.c) == true) goto L57;
        monitor-enter(this);
        this.f367255i = false;     // Catch: Throwable -> L30
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L30
        monitor-exit(this);
        return;
    L30:
        th = move-exception;
        throw th;
    L17:
        monitor-enter(this);
        this.f367255i = false;     // Catch: Throwable -> L21
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(this);
        return;
    L21:
        th = move-exception;
        throw th;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        monitor-enter(this);
        this.f367255i = false;     // Catch: Throwable -> L41
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L41
        throw th;
    L41:
        th = move-exception;
        throw th;
    }

    public final void l() {
        monitor-enter(this);
        Collection<c> r100 = this.f367253g.values();     // Catch: Throwable -> L20
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L20
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L20
    L5:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();     // Catch: Throwable -> L20
        if (((c) r103).f367270f != EntryState.WAITING_HOST) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L5;
        r101.add(r103);     // Catch: Throwable -> L20
        goto L5
    L9:
        r104 = false;
        goto L10
    L12:
        Iterator r105 = r101.iterator();     // Catch: Throwable -> L20
    L14:
        if (r105.hasNext() == false) goto L16;
        ((c) r105.next()).a(EntryState.PENDING);     // Catch: Throwable -> L20
        goto L14
    L16:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        r();
        return;
    L20:
        th = move-exception;
        throw th;
    }

    public final void r() {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f367254h == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.f367254h = true;     // Catch: Throwable -> L12
        Unit r100 = Unit.INSTANCE;     // Catch: Throwable -> L12
        monitor-exit(this);
        this.f367247a.post(new com.larus.reach.runtime.i(this));
    }

    public final a.c h() {
        Iterator<T> r100 = this.f367253g.values().iterator();
    L4:
        if (r100.hasNext() == false) goto L15;
        Object r101 = r100.next();
        c r102 = (c) r101;
        EntryState r103 = r102.f367270f;
        if (r103 != EntryState.DISMISSING) goto L8;
    L12:
        boolean r104 = false;
    L13:
        if (r104 == false) goto L4;
    L16:
        c r105 = (c) r101;
        if (r105 != null) goto L19;
        return null;
    L19:
        o(r105);
        return new a.c(r105, ReachRejectReason.EXPIRED);
    L8:
        if (r103.isPresented() == true) goto L12;
        if (j(r102.f367265a) == false) goto L12;
        r104 = true;
        goto L13
    L15:
        r101 = null;
        goto L16
    }

    public final a.C4479a k() {
        Collection<c> r100 = this.f367253g.values();
        if (r100.isEmpty() == true) goto L18;
        Iterator<T> r101 = r100.iterator();
    L7:
        if (r101.hasNext() == false) goto L18;
        c r102 = (c) r101.next();
        if (r102.f367265a.f520409b.b() == ReachPosition.TOP) goto L11;
    L15:
        boolean r103 = false;
    L16:
        if (r103 == false) goto L7;
        boolean r104 = true;
    L19:
        Collection<c> r105 = this.f367253g.values();
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r105.iterator();
    L21:
        if (r107.hasNext() == false) goto L30;
        Object r108 = r107.next();
        c r109 = (c) r108;
        if (r109.f367265a.f520409b.b() == ReachPosition.TOP) goto L25;
    L27:
        boolean r110 = false;
    L28:
        if (r110 == false) goto L21;
        r106.add(r108);
        goto L21
    L25:
        if (r109.f367270f.isPresented() == true) goto L27;
        r110 = true;
        goto L28
    L30:
        Iterator r111 = r106.iterator();
        if (r111.hasNext() == true) goto L33;
        Object r112 = null;
    L42:
        c r113 = (c) r112;
        Collection<c> r114 = this.f367253g.values();
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L44:
        if (r116.hasNext() == false) goto L55;
        Object r117 = r116.next();
        c r118 = (c) r117;
        if (r118.f367270f == EntryState.PENDING) goto L48;
    L52:
        boolean r119 = false;
    L53:
        if (r119 == false) goto L44;
        r115.add(r117);
        goto L44
    L48:
        if (r118.f367265a.f520409b.b() != ReachPosition.TOP) goto L51;
        if (r104 == true) goto L52;
        if (r118 != r113) goto L52;
    L51:
        r119 = true;
        goto L53
    L55:
        Iterator r120 = CollectionsKt.sortedWith(r115, new o()).iterator();
        if (r120.hasNext() == false) goto L59;
        c r121 = (c) r120.next();
        r121.a(EntryState.CHECKING);
        return new a.C4479a(r121);
    L59:
        return null;
    L33:
        r112 = r111.next();
        if (r111.hasNext() == false) goto L42;
        long r122 = ((c) r112).f367267c;
    L37:
        Object r123 = r111.next();
        long r124 = ((c) r123).f367267c;
        if (r122 <= r124) goto L41;
        r112 = r123;
        r122 = r124;
    L41:
        if (r111.hasNext() == true) goto L37;
    L11:
        if (r102.f367270f != EntryState.ALLOWED) goto L15;
        if (r102.f367272h > 0) goto L15;
        r103 = true;
    L18:
        r104 = false;
        goto L19
    }

    public ReachBannerRuntime() {
        this.f367247a = new Handler(Looper.getMainLooper());
        this.f367248b = new os9.g();
        this.f367249c = new com.larus.reach.impl.a();
        this.f367250d = new com.larus.reach.impl.n();
        this.f367251e = new AtomicLong();
        this.f367252f = new AtomicLong();
        this.f367253g = new LinkedHashMap();
    }

    public static boolean j(ns9.t r100) {
        ns9.v r101 = r100.f520409b;
        if ((r101 instanceof ns9.w) == false) goto L5;
        ns9.w r102 = (ns9.w) r101;
    L7:
        if (r102 != null) goto L10;
        return false;
    L10:
        if (r102.f520419d > 0) goto L12;
        return false;
    L12:
        if (System.currentTimeMillis() < r102.f520419d) goto L16;
        return true;
    L16:
        return false;
    L5:
        r102 = null;
        goto L7
    }

    public final List<ns9.j> d(c r110) {
        monitor-enter(this);
        Collection<c> r100 = this.f367253g.values();     // Catch: Throwable -> L26
        ArrayList r101 = new ArrayList();     // Catch: Throwable -> L26
        Iterator<T> r102 = r100.iterator();     // Catch: Throwable -> L26
    L4:
        boolean r103 = false;
        if (r102.hasNext() == false) goto L15;
        Object r104 = r102.next();     // Catch: Throwable -> L26
        c r105 = (c) r104;     // Catch: Throwable -> L26
        if (r105 != r110) goto L9;
    L13:
        if (r103 == false) goto L4;
        r101.add(r104);     // Catch: Throwable -> L26
        goto L4
    L9:
        if (r105.f367265a.f520409b.b() != r110.f367265a.f520409b.b()) goto L13;
        if (r105.f367270f.isPresented() == false) goto L13;
        r103 = true;
        goto L13
    L15:
        List r111 = CollectionsKt.sortedWith(r101, new i());     // Catch: Throwable -> L26
        ArrayList r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));     // Catch: Throwable -> L26
        Iterator r112 = r111.iterator();     // Catch: Throwable -> L26
    L16:
        if (r112.hasNext() == false) goto L24;
        c r107 = (c) r112.next();     // Catch: Throwable -> L26
        ns9.t r108 = r107.f367265a;     // Catch: Throwable -> L26
        long r109 = r107.f367267c;     // Catch: Throwable -> L26
        long r113 = r107.f367272h;     // Catch: Throwable -> L26
        boolean r114 = r107.f367269e;     // Catch: Throwable -> L26
        if (r107.f367270f != EntryState.DISMISSING) goto L21;
        boolean r115 = true;
    L22:
        r106.add(new ns9.j(r108, r109, r113, r114, r115));     // Catch: Throwable -> L26
        goto L16
    L21:
        r115 = false;
        goto L22
    L24:
        monitor-exit(this);
        return r106;
    L26:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r10v11, types: [os9.d] */
    /* JADX WARN: Type inference failed for: r12v0, types: [com.larus.reach.runtime.f, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v0, types: [com.larus.reach.runtime.g, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r15v8, types: [os9.c] */
    /* JADX WARN: Type inference failed for: r6v5, types: [com.larus.reach.runtime.a, java.lang.Object] */
    public final void g(a r210) {
        if ((r210 instanceof a.C4479a) == false) goto L351;
        final c r100 = ((a.C4479a) r210).f367260a;
        long r101 = v.b();
        ReachRejectReason r102 = f(r100.f367265a, ReachGatePhase.BEFORE_PRESENT);
        c r103 = null;
        boolean r110 = true;
        if (r102 != null) goto L7;
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L34
        Object r105 = Result.m9449constructorimpl(v.d(r100.f367265a));     // Catch: Throwable -> L34
    L36:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L40;
        FLogger.f375446a.w("ReachBannerRuntime", "reach host resolve failed, reachUniqueId=" + r100.f367265a.f520408a.f520400h, r106);
    L40:
        if (Result.m9455isFailureimpl(r105) == false) goto L42;
        r105 = null;
    L42:
        ReachBannerHost r107 = (ReachBannerHost) r105;
        if (r107 != null) goto L369;
        c(r100, new d.b(ReachRejectReason.INVALID_PROTOCOL, null));
        return;
    L369:
        ns9.h r108 = r107.d(r100.f367265a);     // Catch: Throwable -> L57
        if (Intrinsics.areEqual(r108, ns9.h.a.f520377a) == false) goto L49;
        Object r109 = null;
    L54:
        Object r111 = Result.m9449constructorimpl(r109);     // Catch: Throwable -> L57
    L59:
        Throwable r112 = Result.m9452exceptionOrNullimpl(r111);
        if (r112 == null) goto L62;
        FLogger.f375446a.w("ReachBannerRuntime", "reach host evaluate failed, reachUniqueId=" + r100.f367265a.f520408a.f520400h, r112);
    L62:
        d.b r113 = new d.b(ReachRejectReason.CLIENT_EXCEPTION, r107);
        if (Result.m9455isFailureimpl(r111) == false) goto L65;
        r111 = r113;
    L65:
        d r114 = (d) r111;
        if (r114 == null) goto L68;
        c(r100, r114);
        return;
    L68:
        Context r115 = r107.e(r100.f367265a);
        if (r115 != null) goto L71;
        c(r100, new d.c(r107, r101, "render_context_unavailable"));
        return;
    L71:
        ns9.c r116 = r100.f367278n;
        if (r116 != null) goto L322;
        final ns9.t r117 = r100.f367265a;
        os9.g r118 = this.f367248b;
        List<os9.g.a> r119 = os9.g.f526560a;
        r118.getClass();
        Intrinsics.checkNotNullParameter(r115, PerfLog.PARAM_KEY_CONTEXT_ID);
        final View r120 = LayoutInflater.from(r115).inflate(R.layout.larus_view_reach_banner, null, false);
        os9.g r121 = this.f367248b;
        final ?? r122 = new com.larus.reach.runtime.a(this, r120, r117, r100);
        final ?? r123 = new com.larus.reach.runtime.f(r117, this, r120, r100);
        final ?? r124 = new com.larus.reach.runtime.g(r117, this);
        r121.getClass();
        Intrinsics.checkNotNullParameter(r120, "view");
        Intrinsics.checkNotNullParameter(r117, "request");
        Intrinsics.checkNotNullParameter(r122, "onContainerClick");
        Intrinsics.checkNotNullParameter(r123, "onButtonClick");
        Intrinsics.checkNotNullParameter(r124, "onCloseClick");
        Integer r125 = r117.f520411d.f520371a;
        if (r125 != null) goto L77;
    L79:
        boolean r126 = false;
    L80:
        String r127 = r117.f520411d.f520373c;
        if (r127 != null) goto L83;
    L86:
        boolean r128 = true;
    L87:
        boolean r129 = !r128;
        if (r126 == true) goto L110;
        List<ns9.d> r130 = r117.f520411d.f520376f;
        if ((r130 instanceof Collection) == true) goto L92;
    L94:
        Iterator<T> r131 = r130.iterator();
    L96:
        if (r131.hasNext() == false) goto L107;
        ns9.d r132 = (ns9.d) r131.next();
        if (r132.getType() != ReachButtonType.NORMAL) goto L100;
    L103:
        boolean r133 = true;
    L104:
        if (r133 == false) goto L96;
        boolean r134 = true;
    L108:
        if (r134 == false) goto L110;
        boolean r135 = true;
    L111:
        SimpleDraweeView r136 = (SimpleDraweeView) r120.findViewById(R.id.reach_banner_icon);
        if (r136 == null) goto L129;
        if (r129 == false) goto L115;
        int r137 = 0;
    L116:
        r136.setVisibility(r137);
        GenericDraweeHierarchy r138 = r136.getHierarchy();
        RoundingParams r139 = r136.getHierarchy().getRoundingParams();
        if (r139 == null) goto L119;
        boolean r140 = true;
        RoundingParams r141 = r139.setRoundAsCircle(StringsKt.equals(r117.f520412e.f520404b.get("icon_shape"), SVGRenderEngine.CIRCLE, true));
    L120:
        r138.setRoundingParams(r141);
        String r142 = r117.f520411d.f520373c;
        if (r142 != null) goto L123;
    L128:
        ViewGroup.LayoutParams r143 = r136.getLayoutParams();
        r143.width = os9.g.b(36, r136);
        r143.height = os9.g.b(36, r136);
        r136.setLayoutParams(r143);
    L130:
        String r144 = r117.f520411d.f520374d;
        if (r144 != null) goto L133;
    L136:
        boolean r145 = true;
    L137:
        boolean r146 = !r145;
        TextView r147 = (TextView) r120.findViewById(R.id.reach_banner_title);
        if (r147 == null) goto L147;
        String r148 = r117.f520411d.f520372b;
        if (r148 != null) goto L142;
        r148 = "";
    L142:
        r147.setText(r148);
        if (r146 == false) goto L145;
        int r149 = 1;
    L146:
        r147.setMaxLines(r149);
        goto L147
    L145:
        r149 = 2;
    L147:
        TextView r150 = (TextView) r120.findViewById(R.id.reach_banner_subtitle);
        if (r150 == null) goto L157;
        String r151 = r117.f520411d.f520374d;
        if (r151 != null) goto L152;
        r151 = "";
    L152:
        r150.setText(r151);
        if (r146 == false) goto L155;
        int r152 = 0;
    L156:
        r150.setVisibility(r152);
        goto L157
    L155:
        r152 = 8;
    L157:
        View r153 = r120.findViewById(R.id.reach_banner_content_row);
        if (r153 == null) goto L166;
        ViewGroup.LayoutParams r154 = r153.getLayoutParams();
        r154.height = -2;
        r153.setLayoutParams(r154);
        int r155 = 14;
        int r156 = os9.g.b(14, r153);
        if (r126 == false) goto L162;
        r155 = 10;
    L162:
        if (r126 == false) goto L164;
        int r157 = os9.g.b(10, r153);
    L165:
        r153.setMinimumHeight(os9.g.b(r155 + 50, r153));
        int r158 = os9.g.b(16, r153);
        r153.setPaddingRelative(r158, r156, r158, r157);
        goto L166
    L164:
        r157 = r156;
    L166:
        View r159 = r120.findViewById(R.id.reach_banner_text_container);
        if (r159 == null) goto L186;
        ViewGroup.LayoutParams r160 = r159.getLayoutParams();
        if ((r160 instanceof ViewGroup.MarginLayoutParams) == false) goto L171;
        ViewGroup.MarginLayoutParams r161 = (ViewGroup.MarginLayoutParams) r160;
    L172:
        if (r161 == null) goto L186;
        int r162 = 12;
        if (r129 == false) goto L176;
        int r163 = 12;
    L177:
        r161.setMarginStart(os9.g.b(r163, r159));
        if (r117.f520408a.f520398f == ReachRequestSource.CLIENT_BRIDGE) goto L180;
    L182:
        if (r135 == true) goto L185;
        r162 = 0;
    L185:
        r161.setMarginEnd(os9.g.b(r162, r159));
        r159.setLayoutParams(r161);
        goto L186
    L180:
        if (r117.f520409b.b() != ReachPosition.BOTTOM) goto L182;
        r162 = 8;
        goto L182
    L176:
        r163 = 0;
        goto L177
    L171:
        r161 = null;
    L186:
        Iterator r164 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(R.id.reach_banner_bottom_actions), Integer.valueOf(R.id.reach_banner_secondary_button), Integer.valueOf(R.id.reach_banner_primary_button)}).iterator();
    L188:
        if (r164.hasNext() == false) goto L192;
        View r165 = r120.findViewById(((Number) r164.next()).intValue());
        if (r165 == null) goto L188;
        r165.setVisibility(8);
        r165.setOnClickListener(null);
        goto L188
    L192:
        int r166 = 8;
        View r167 = r120.findViewById(R.id.reach_banner_right_actions);
        if (r167 == null) goto L197;
        if (r135 == false) goto L196;
        r166 = 0;
    L196:
        r167.setVisibility(r166);
    L197:
        if (r126 == false) goto L262;
        Iterable r168 = CollectionsKt.withIndex(r117.f520411d.f520376f);
        ArrayList r169 = new ArrayList();
        Iterator r170 = r168.iterator();
    L200:
        if (r170.hasNext() == false) goto L207;
        Object r171 = r170.next();
        if (((ns9.d) ((IndexedValue) r171).getValue()).getType() != ReachButtonType.NORMAL) goto L204;
        boolean r172 = true;
    L205:
        if (r172 == false) goto L200;
        r169.add(r171);
        goto L200
    L204:
        r172 = false;
        goto L205
    L207:
        List r173 = CollectionsKt.take(r169, 2);
        if (r173.isEmpty() == true) goto L305;
        View r174 = r120.findViewById(R.id.reach_banner_bottom_actions);
        if (r174 == null) goto L213;
        r174.setVisibility(0);
    L213:
        int r175 = r173.size();
        ViewGroup r176 = (ViewGroup) r120.findViewById(R.id.reach_banner_bottom_actions);
        if (r176 == null) goto L247;
        List r177 = CollectionsKt.take(os9.g.f526560a, r175);
        ArrayList r178 = new ArrayList();
        Iterator r179 = r177.iterator();
    L218:
        if (r179.hasNext() == false) goto L222;
        View r180 = r176.findViewById(((os9.g.a) r179.next()).f526561a);
        if (r180 == null) goto L218;
        r178.add(r180);
        goto L218
    L222:
        Iterator r181 = r178.iterator();
    L224:
        if (r181.hasNext() == false) goto L226;
        r176.removeView((View) r181.next());
        goto L224
    L226:
        Iterator r182 = r178.iterator();
        int r183 = 0;
    L228:
        if (r182.hasNext() == false) goto L247;
        Object r184 = r182.next();
        int r185 = r183 + 1;
        if (r183 >= 0) goto L232;
        CollectionsKt.throwIndexOverflow();
    L232:
        View r186 = (View) r184;
        r176.addView(r186, r183);
        ViewGroup.LayoutParams r187 = r186.getLayoutParams();
        if ((r187 instanceof ViewGroup.MarginLayoutParams) == false) goto L235;
        ViewGroup.MarginLayoutParams r188 = (ViewGroup.MarginLayoutParams) r187;
    L236:
        if (r188 == null) goto L246;
        int r189 = os9.g.b(6, r186);
        if (r183 != 0) goto L240;
        int r190 = 0;
    L241:
        r188.setMarginStart(r190);
        if (r183 != CollectionsKt.getLastIndex(r178)) goto L244;
        r189 = 0;
    L244:
        r188.setMarginEnd(r189);
        r186.setLayoutParams(r188);
        goto L246
    L240:
        r190 = r189;
    L246:
        r183 = r185;
        r182 = r182;
        goto L228
    L235:
        r188 = null;
    L247:
        Iterator r191 = r173.iterator();
        int r192 = 0;
    L249:
        if (r191.hasNext() == false) goto L305;
        Object r193 = r191.next();
        int r194 = r192 + 1;
        if (r192 >= 0) goto L253;
        CollectionsKt.throwIndexOverflow();
    L253:
        final IndexedValue r195 = (IndexedValue) r193;
        os9.g.a r196 = (os9.g.a) ListProtector.get(os9.g.f526560a, r192);
        TextView r197 = (TextView) r120.findViewById(r196.f526562b);
        ShapeLinearLayout r198 = (ShapeLinearLayout) r120.findViewById(r196.f526561a);
        if (r198 == null) goto L256;
        r198.setVisibility(0);
        e1.d(r198, new os9.b(r123, r195));
        os9.g.a(r198, r197, ((ns9.d) r195.getValue()).f520365b);
    L256:
        if (r197 == null) goto L261;
        String r199 = ((ns9.d) r195.getValue()).f520366c;
        if (r199 != null) goto L260;
        r199 = "";
    L260:
        r197.setText(r199);
    L261:
        r192 = r194;
    L305:
        Intrinsics.checkNotNullParameter(r120, "view");
        View r200 = r120.findViewById(R.id.reach_banner_container);
        if (r200 != null) goto L308;
        r200 = r120;
    L308:
        r200.setClickable(true);
        e1.d(r200, new os9.a(r122));
        this.f367248b.getClass();
        Intrinsics.checkNotNullParameter(r120, "view");
        View r201 = r120.findViewById(R.id.reach_banner_container);
        if (r201 != null) goto L312;
        r201 = r120;
    L312:
        if ((r201 instanceof ReachSwipeDismissLayout) == false) goto L314;
        ReachSwipeDismissLayout r202 = (ReachSwipeDismissLayout) r201;
    L315:
        if (r202 != null) goto L317;
    L321:
        r116 = new ns9.c(r120, r201);
        r100.f367278n = r116;
    L367:
        Result.Companion r203 = Result.Companion;     // Catch: Throwable -> L340
        ReachBannerHost r204 = r107;
        ns9.h r205 = r204.b(r100.f367265a, r116);     // Catch: Throwable -> L338
        if (Intrinsics.areEqual(r205, ns9.h.a.f520377a) == false) goto L329;
        Object r206 = new d.a(r204);     // Catch: Throwable -> L338
    L335:
        Object r207 = Result.m9449constructorimpl(r206);     // Catch: Throwable -> L338
    L343:
        Throwable r208 = Result.m9452exceptionOrNullimpl(r207);
        if (r208 == null) goto L346;
        FLogger.f375446a.w("ReachBannerRuntime", "reach host evaluate failed, reachUniqueId=" + r100.f367265a.f520408a.f520400h, r208);
    L346:
        d.b r209 = new d.b(ReachRejectReason.CLIENT_EXCEPTION, r204);
        if (Result.m9455isFailureimpl(r207) == false) goto L349;
        r207 = r209;
    L349:
        c(r100, (d) r207);
        return;
    L329:
        if ((r205 instanceof ns9.h.c) == false) goto L333;
        Object r211 = new d.c(r204, r101, ((ns9.h.c) r205).f520380a);     // Catch: Throwable -> L338
    L331:
        r206 = r211;
        goto L335
    L333:
        if ((r205 instanceof ns9.h.b) == false) goto L337;
        r211 = new d.b(((ns9.h.b) r205).f520378a, r204);     // Catch: Throwable -> L338
        goto L331
    L337:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L338
    L338:
        th = th;
    L342:
        Result.Companion r212 = Result.Companion;
        r207 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L340:
        th = th;
        r204 = r107;
        goto L342
    L317:
        if (r117.f520409b.b() != ReachPosition.BOTTOM) goto L319;
        int r1100 = 1;
    L320:
        r202.setSwipeDirection(r1100);
        r202.setOnSwipeDismiss(new com.larus.reach.runtime.h(this, r117));
        goto L321
    L319:
        r1100 = -1;
        goto L320
    L314:
        r202 = null;
        goto L315
    L262:
        ViewGroup r213 = (ViewGroup) r120.findViewById(R.id.reach_banner_right_actions);
        if (r213 == null) goto L305;
        r213.removeAllViews();
        Iterator r214 = r117.f520411d.f520376f.iterator();
        final int r215 = 0;
    L267:
        if (r214.hasNext() == false) goto L283;
        Object r1101 = r214.next();
        int r1102 = r215 + 1;
        if (r215 >= 0) goto L271;
        CollectionsKt.throwIndexOverflow();
    L271:
        ns9.d r1103 = (ns9.d) r1101;
        int r1104 = os9.g.c.f526563a[r1103.getType().ordinal()];
        if (r1104 != 1) goto L274;
        String r1105 = r1103.f520366c;
        if (r1105 != null) goto L281;
        r1105 = "";
    L281:
        ReachButtonStyle r1106 = r1103.f520365b;
        final ?? r1107 = new os9.c(r123, r215);
        View r216 = LayoutInflater.from(r213.getContext()).inflate(R.layout.larus_view_reach_banner_normal_button, r213, false);
        Intrinsics.checkNotNull(r216, "null cannot be cast to non-null type com.larus.common_ui.venus.ShapeLinearLayout");
        ShapeLinearLayout r217 = (ShapeLinearLayout) r216;
        TextView r218 = (TextView) r217.findViewById(android.R.id.text1);
        r218.setText(r1105);
        e1.d(r217, new os9.e(r1107));
        os9.g.a(r217, r218, r1106);
        r213.addView(r217);
    L282:
        r215 = r1102;
        r214 = r214;
        goto L267
    L274:
        if (r1104 != 2) goto L277;
        final ?? r1108 = new os9.d(r124, r215);
        View r219 = LayoutInflater.from(r213.getContext()).inflate(R.layout.larus_view_reach_banner_close_button, r213, false);
        e1.d(r219, new os9.f(r1108));
        r213.addView(r219);
        goto L282
    L277:
        throw new NoWhenBranchMatchedException();
    L283:
        IntRange r220 = RangesKt.until(0, r213.getChildCount());
        ArrayList r221 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r220, 10));
        Iterator<Integer> r222 = r220.iterator();
    L285:
        if (r222.hasNext() == false) goto L287;
        r221.add(r213.getChildAt(((IntIterator) r222).nextInt()));
        goto L285
    L287:
        Iterator r223 = r221.iterator();
        int r1109 = 0;
    L289:
        if (r223.hasNext() == false) goto L305;
        Object r224 = r223.next();
        int r225 = r1109 + 1;
        if (r1109 >= 0) goto L293;
        CollectionsKt.throwIndexOverflow();
    L293:
        View r226 = (View) r224;
        ViewGroup.LayoutParams r227 = r226.getLayoutParams();
        if ((r227 instanceof ViewGroup.MarginLayoutParams) == false) goto L296;
        ViewGroup.MarginLayoutParams r228 = (ViewGroup.MarginLayoutParams) r227;
    L298:
        if (r228 == null) goto L304;
        r228.setMarginStart(0);
        if (r1109 != CollectionsKt.getLastIndex(r221)) goto L302;
        int r1110 = 0;
    L303:
        r228.setMarginEnd(r1110);
        r226.setLayoutParams(r228);
        goto L304
    L302:
        Intrinsics.checkNotNull(r226);
        r1110 = os9.g.b(15, r226);
    L304:
        r1109 = r225;
        goto L289
    L296:
        r228 = null;
        goto L298
    L133:
        if (StringsKt.isBlank(r144) == true) goto L136;
        r145 = false;
        goto L137
    L123:
        if ((StringsKt.isBlank(r142) ^ r140) == true) goto L126;
        r142 = null;
    L126:
        if (r142 == null) goto L128;
        ImageLoaderKt.u(r136, r142, "notification.banner");
        goto L128
    L119:
        r140 = true;
        r141 = null;
        goto L120
    L115:
        r137 = 8;
        goto L116
    L129:
        r107 = r107;
        r101 = r101;
        goto L130
    L100:
        if (r132.getType() == ReachButtonType.CLOSE) goto L103;
        r133 = false;
    L107:
        r134 = false;
        goto L108
    L92:
        if (r130.isEmpty() == false) goto L94;
    L110:
        r135 = false;
        goto L111
    L83:
        if (StringsKt.isBlank(r127) == true) goto L86;
        r128 = false;
        goto L87
    L77:
        if (r125.intValue() != 2) goto L79;
        r126 = true;
        goto L80
    L322:
        r107 = r107;
        r101 = r101;
        goto L367
    L49:
        if ((r108 instanceof ns9.h.c) == false) goto L52;
        r109 = new d.c(r107, r101, ((ns9.h.c) r108).f520380a);     // Catch: Throwable -> L57
        goto L54
    L52:
        if ((r108 instanceof ns9.h.b) == false) goto L56;
        r109 = new d.b(((ns9.h.b) r108).f520378a, r107);     // Catch: Throwable -> L57
        goto L54
    L56:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L57
    L57:
        th = move-exception;
        Result.Companion r229 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L34:
        th = move-exception;
        Result.Companion r230 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L7:
        if (r102 == ReachRejectReason.NOT_TARGET_PAGE) goto L9;
    L11:
        monitor-enter(this);
        c r231 = this.f367253g.get(r100.f367265a.f520408a.f520400h);     // Catch: Throwable -> L29
        if (r231 == null) goto L24;
        if (r231 == r100) goto L16;
    L18:
        boolean r232 = false;
    L19:
        if (r232 == false) goto L21;
        r103 = r231;
    L21:
        if (r103 == null) goto L24;
        o(r100);     // Catch: Throwable -> L29
    L25:
        monitor-exit(this);
        if (r110 == false) goto L28;
        n(r100, r102);
    L28:
        r();
        return;
    L16:
        if (r231.f367270f != EntryState.CHECKING) goto L18;
        r232 = true;
    L24:
        r110 = false;
    L29:
        th = move-exception;
        throw th;
    L9:
        if (t(r100, null, r101, null) == false) goto L11;
        r();
        return;
    L351:
        if ((r210 instanceof a.b) == false) goto L357;
        a.b r233 = (a.b) r210;
        final c r234 = r233.f367261a;
        final ReachCloseReason r235 = r233.f367262b;
        final ReachBannerHost r236 = r234.f367271g;
        if (r236 != null) goto L355;
        s(r234.f367265a.f520408a.f520400h, r234.f367268d, r235);
        return;
    L355:
        q(new l(this, r236, r234, r235));
        return;
    L357:
        if ((r210 instanceof a.c) == false) goto L361;
        a.c r237 = (a.c) r210;
        n(r237.f367263a, r237.f367264b);
        return;
    L361:
        throw new NoWhenBranchMatchedException();
    }

    public final c o(c r100) {
        c r101 = this.f367253g.remove(r100.f367265a.f520408a.f520400h);
        if (r101 == null) goto L6;
        r100 = r101;
    L6:
        Collection<c> r102 = this.f367253g.values();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L17;
        Object r105 = r104.next();
        c r106 = (c) r105;
        if (r106.f367265a.f520409b.b() == r100.f367265a.f520409b.b()) goto L12;
    L14:
        boolean r107 = false;
    L15:
        if (r107 == false) goto L8;
        r103.add(r105);
        goto L8
    L12:
        if (r106.f367270f != EntryState.WAITING_POSITION) goto L14;
        r107 = true;
        goto L15
    L17:
        Iterator r108 = r103.iterator();
    L19:
        if (r108.hasNext() == false) goto L21;
        ((c) r108.next()).a(EntryState.PENDING);
        goto L19
    L21:
        return r100;
    }

    public final void q(final Function0<Unit> r100) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L5;
        r100.invoke();
        return;
    L5:
        this.f367247a.post(new m(r100));
    }

    public static ReachRejectReason f(ns9.t r100, ReachGatePhase r101) {
        if (j(r100) == true) goto L54;
        List<Integer> r102 = r100.f520408a.f520399g;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L32
        if (r102 != null) goto L9;
        r102 = CollectionsKt.emptyList();     // Catch: Throwable -> L32
    L9:
        boolean r104 = true;
        if (r102.isEmpty() == true) goto L30;
        List<Integer> r105 = r102;     // Catch: Throwable -> L32
        if ((r105 instanceof Collection) == true) goto L15;
    L17:
        Iterator<T> r106 = r105.iterator();     // Catch: Throwable -> L32
    L19:
        if (r106.hasNext() == false) goto L30;
        int r107 = ((Number) r106.next()).intValue();     // Catch: Throwable -> L32
        UserConfigKey.Companion.getClass();     // Catch: Throwable -> L32
        UserConfigKey r108 = UserConfigKey.a.a(r107);     // Catch: Throwable -> L32
        if (r108 != null) goto L23;
        boolean r109 = true;
    L28:
        if (r109 == true) goto L19;
        r104 = false;
        goto L30
    L23:
        UserConfigItem r110 = UserSettingDelegate.f308901b.b(r108);     // Catch: Throwable -> L32
        if (r110 == null) goto L26;
        String r111 = r110.c();     // Catch: Throwable -> L32
    L27:
        r109 = !Intrinsics.areEqual(r111, "0");     // Catch: Throwable -> L32
        goto L28
    L26:
        r111 = null;
        goto L27
    L15:
        if (r105.isEmpty() == false) goto L17;
    L30:
        Object r112 = Result.m9449constructorimpl(Boolean.valueOf(r104));     // Catch: Throwable -> L32
    L34:
        Boolean r113 = Boolean.TRUE;
        if (Result.m9455isFailureimpl(r112) == false) goto L38;
        r112 = r113;
    L38:
        if (((Boolean) r112).booleanValue() == true) goto L41;
        return ReachRejectReason.NOTIFICATION_DISABLED;
    L41:
        if (r101 != ReachGatePhase.BEFORE_PRESENT) goto L46;
        if (y.a(r100) == true) goto L46;
        return ReachRejectReason.BUSINESS_NOT_ALLOWED;
    L46:
        return null;
    L32:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L34
    L54:
        return ReachRejectReason.EXPIRED;
    }

    public static void n(c r100, ReachRejectReason r101) {
        ConcurrentHashMap<String, Long> r102 = com.larus.reach.impl.b.f367163a;
        com.larus.reach.impl.b.d(r100.f367265a, r101);
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r103 = y.f367359a;
        y.c(r100.f367265a, r101);
    }

    public final void a(ns9.t r100, boolean r101) {
        if (r101 == true) goto L4;
        return;
    L4:
        boolean r102 = false;
        if (StringsKt.equals(r100.f520410c.f520407c, "keep", true) == false) goto L16;
        monitor-enter(this);
        c r103 = this.f367253g.get(r100.f520408a.f520400h);     // Catch: Throwable -> L13
        if (r103 == null) goto L10;
        r103.f367275k = false;     // Catch: Throwable -> L13
    L10:
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(this);
        return;
    L13:
        th = move-exception;
        throw th;
    L16:
        String r105 = r100.f520410c.f520407c;
        if (r105 != null) goto L19;
    L20:
        r102 = true;
    L21:
        if (r102 == false) goto L23;
    L24:
        p(this, r100.f520408a.f520400h, ReachCloseReason.CLICK_DISMISSAL, null, null, true, 12);
        return;
    L23:
        if (StringsKt.equals(r100.f520410c.f520407c, "dismiss", true) == true) goto L24;
        return;
    L19:
        if (StringsKt.isBlank(r105) == false) goto L21;
        goto L20
    }

    public final void c(final c r110, d r111) {
        if ((r111 instanceof d.a) == true) goto L84;
        boolean r100 = true;
        c r101 = null;
        if ((r111 instanceof d.c) == false) goto L55;
        d.c r102 = (d.c) r111;
        if (t(r110, r102.f367283a, r102.f367284b, r102.f367285c) == true) goto L73;
        monitor-enter(this);
        c r103 = this.f367253g.get(r110.f367265a.f520408a.f520400h);     // Catch: Throwable -> L51
        if (r103 == null) goto L47;
        if (r103 == r110) goto L39;
    L41:
        boolean r104 = false;
    L42:
        if (r104 == false) goto L44;
        r101 = r103;
    L44:
        if (r101 == null) goto L47;
        r101.f367271g = ((d.c) r111).f367283a;     // Catch: Throwable -> L51
        o(r110);     // Catch: Throwable -> L51
    L48:
        monitor-exit(this);
        if (r100 == false) goto L73;
        n(r110, ReachRejectReason.NOT_TARGET_PAGE);
        goto L73
    L39:
        if (r103.f367270f != EntryState.CHECKING) goto L41;
        r104 = true;
    L47:
        r100 = false;
    L51:
        th = move-exception;
        throw th;
    L73:
        r();
        return;
    L55:
        if ((r111 instanceof d.b) == false) goto L79;
        monitor-enter(this);
        c r105 = this.f367253g.get(r110.f367265a.f520408a.f520400h);     // Catch: Throwable -> L75
        if (r105 == null) goto L69;
        if (r105 == r110) goto L61;
    L63:
        boolean r106 = false;
    L64:
        if (r106 == false) goto L66;
        r101 = r105;
    L66:
        if (r101 == null) goto L69;
        r101.f367271g = ((d.b) r111).f367282b;     // Catch: Throwable -> L75
        o(r110);     // Catch: Throwable -> L75
    L70:
        monitor-exit(this);
        if (r100 == false) goto L73;
        n(r110, ((d.b) r111).f367281a);
        goto L73
    L61:
        if (r105.f367270f != EntryState.CHECKING) goto L63;
        r106 = true;
    L69:
        r100 = false;
    L75:
        th = move-exception;
        throw th;
    L79:
        throw new NoWhenBranchMatchedException();
    L84:
        Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L6
        Object r108 = Result.m9449constructorimpl(((d.a) r111).f367280a.c(r110.f367265a, d(r110)));     // Catch: Throwable -> L6
    L8:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L11;
        FLogger.f375446a.w("ReachBannerRuntime", "reach host resolve display decision failed, reachUniqueId=" + r110.f367265a.f520408a.f520400h, r109);
    L11:
        ns9.i.b r112 = ns9.i.b.f520383a;
        if (Result.m9455isFailureimpl(r108) == false) goto L14;
        r108 = r112;
    L14:
        final e r113 = b(r110, ((d.a) r111).f367280a, (ns9.i) r108);
        if ((r113 instanceof e.b) == false) goto L18;
        q(new j(this, r113, r110));
        this.f367247a.postDelayed(new com.larus.reach.runtime.b(this, r110), 3000);
        goto L73
    L18:
        if ((r113 instanceof e.a) == false) goto L21;
        q(new k(this, r113, r110));
        this.f367247a.postDelayed(new com.larus.reach.runtime.b(this, r110), 3000);
        goto L73
    L21:
        if ((r113 instanceof e.d) == false) goto L26;
        Long r114 = ((e.d) r113).f367295a;
        if (r114 == null) goto L73;
        this.f367247a.postDelayed(new com.larus.reach.runtime.c(this, r110), RangesKt.coerceAtLeast(r114.longValue(), 1));
        goto L73
    L26:
        if (Intrinsics.areEqual(r113, e.c.f367294a) == true) goto L73;
        throw new NoWhenBranchMatchedException();
    L6:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    }

    public final void i(c r100, ReachRejectReason r101) {
        monitor-enter(this);
        c r102 = this.f367253g.get(r100.f367265a.f520408a.f520400h);     // Catch: Throwable -> L21
        c r103 = null;
        if (r102 == null) goto L17;
        if (r102 == r100) goto L7;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        r103 = o(r102);     // Catch: Throwable -> L21
        goto L17
    L7:
        if (r102.f367268d != r100.f367268d) goto L11;
        if (r102.f367272h > 0) goto L11;
        r104 = true;
    L17:
        monitor-exit(this);
        if (r103 == null) goto L26;
        n(r103, r101);
        r();
        return;
    L26:
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final void m(final c r100, final ReachRejectReason r101) {
        monitor-enter(this);
        c r102 = this.f367253g.get(r100.f367265a.f520408a.f520400h);     // Catch: Throwable -> L23
        final ReachBannerHost r103 = null;
        if (r102 == null) goto L17;
        if (r102 == r100) goto L7;
    L11:
        boolean r104 = false;
    L12:
        if (r104 == true) goto L15;
        r102 = null;
    L15:
        if (r102 == null) goto L17;
        r102.a(EntryState.DISMISSING);     // Catch: Throwable -> L23
        r103 = r102.f367271g;     // Catch: Throwable -> L23
        goto L17
    L7:
        if (r102.f367268d != r100.f367268d) goto L11;
        if (r102.f367270f != EntryState.ALLOWED) goto L11;
        r104 = true;
    L17:
        monitor-exit(this);
        if (r103 != null) goto L21;
        i(r100, r101);
        return;
    L21:
        q(new com.larus.reach.runtime.d(this, r103, r100, r101));
        this.f367247a.postDelayed(new com.larus.reach.runtime.e(this, r100, r101), 500);
        return;
    L23:
        th = move-exception;
        throw th;
    }

    public final e b(c r110, ReachBannerHost r111, ns9.i r112) {
        monitor-enter(this);
        c r100 = this.f367253g.get(r110.f367265a.f520408a.f520400h);     // Catch: Throwable -> L49
        if (r100 == null) goto L46;
        boolean r101 = true;
        if (r100 == r110) goto L8;
    L10:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L15;
        r100 = null;
    L15:
        if (r100 == null) goto L46;
        r100.f367271g = r111;     // Catch: Throwable -> L49
        f r103 = new f(r110.f367265a, r110.f367268d, this);     // Catch: Throwable -> L49
        ns9.c r104 = r110.f367278n;     // Catch: Throwable -> L49
        if (r104 != null) goto L20;
        e r113 = e.c.f367294a;     // Catch: Throwable -> L49
    L47:
        monitor-exit(this);
        return r113;
    L20:
        if (Intrinsics.areEqual(r112, ns9.i.b.f520383a) == false) goto L23;
        r100.a(EntryState.ALLOWED);     // Catch: Throwable -> L49
        r113 = new e.b(r111, r103, r104);     // Catch: Throwable -> L49
        goto L47
    L23:
        if ((r112 instanceof ns9.i.a) == false) goto L42;
        c r105 = this.f367253g.get(((ns9.i.a) r112).f520381a);     // Catch: Throwable -> L49
        if (r105 != null) goto L27;
    L34:
        c r106 = null;
    L35:
        if (r106 == null) goto L40;
        EntryState r114 = r106.f367270f;     // Catch: Throwable -> L49
        EntryState r107 = EntryState.DISMISSING;     // Catch: Throwable -> L49
        if (r114 == r107) goto L40;
        r106.a(r107);     // Catch: Throwable -> L49
        r100.a(EntryState.ALLOWED);     // Catch: Throwable -> L49
        r113 = new e.a(r111, r103, r104, r106, ((ns9.i.a) r112).f520382b);     // Catch: Throwable -> L49
    L40:
        r100.a(EntryState.WAITING_POSITION);     // Catch: Throwable -> L49
        r113 = new e.d(null);     // Catch: Throwable -> L49
        goto L47
    L27:
        if (r105.f367265a.f520409b.b() == r110.f367265a.f520409b.b()) goto L29;
    L31:
        r101 = false;
    L32:
        if (r101 == false) goto L34;
        r106 = r105;
        goto L35
    L29:
        if (r105.f367270f.isPresented() == false) goto L31;
    L42:
        if ((r112 instanceof ns9.i.c) == false) goto L45;
        r100.a(EntryState.WAITING_POSITION);     // Catch: Throwable -> L49
        r113 = new e.d(((ns9.i.c) r112).f520384a);     // Catch: Throwable -> L49
        goto L47
    L45:
        throw new NoWhenBranchMatchedException();     // Catch: Throwable -> L49
    L8:
        if (r100.f367270f != EntryState.CHECKING) goto L10;
        r102 = true;
    L46:
        r113 = e.c.f367294a;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        throw th;
    }

    public final void s(String r100, long r101, ReachCloseReason r110) {
        monitor-enter(this);
        c r102 = this.f367253g.get(r100);     // Catch: Throwable -> L46
        c r103 = null;
        if (r102 != null) goto L6;
    L14:
        monitor-exit(this);
        if (r103 != null) goto L18;
        return;
    L18:
        if (r103.f367272h <= 0) goto L36;
        ConcurrentHashMap<String, Long> r104 = com.larus.reach.impl.b.f367163a;
        ns9.t r105 = r103.f367265a;
        Intrinsics.checkNotNullParameter(r105, "request");
        Intrinsics.checkNotNullParameter(r110, "reason");
        Long r106 = com.larus.reach.impl.b.f367163a.remove(r105.f520408a.f520400h);
        if (r106 == null) goto L25;
        long r107 = r106.longValue();
        if (com.larus.reach.impl.c.a(r105) == false) goto L25;
        com.larus.platform.service.o r108 = com.larus.platform.service.o.f365780a;
        JSONObject r109 = com.larus.reach.impl.b.a(r105);
        r109.put("close_type", r110.getCloseType());
        r109.put("stay_duration", RangesKt.coerceAtLeast(SystemClock.uptimeMillis() - r107, 0));
        Unit r111 = Unit.INSTANCE;
        r108.reportEvent("inapp_push_close", r109);
    L25:
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r112 = y.f367359a;
        ns9.t r113 = r103.f367265a;
        Intrinsics.checkNotNullParameter(r113, "request");
        Intrinsics.checkNotNullParameter(r110, "reason");
        Iterator r114 = y.h(r113.f520408a.f520395c).iterator();
    L27:
        if (r114.hasNext() == false) goto L44;
        ReachSceneLifecycleListener r115 = (ReachSceneLifecycleListener) r114.next();
        Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L31
        r115.d(r113, r110);     // Catch: Throwable -> L31
        Object r117 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L31
    L33:
        Throwable r118 = Result.m9452exceptionOrNullimpl(r117);
        if (r118 == null) goto L27;
        FLogger.f375446a.w("ReachSceneDispatcher", "reach scene onDismiss failed, reachUniqueId=" + r113.f520408a.f520400h + ", scene=" + r113.f520408a.f520395c, r118);
    L31:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r117 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L44:
        r();
        return;
    L36:
        int r120 = h.f367305a[r110.ordinal()];
        if (r120 != 1) goto L39;
        ReachRejectReason r121 = ReachRejectReason.BUSINESS_NOT_ALLOWED;
    L43:
        ConcurrentHashMap<String, Long> r122 = com.larus.reach.impl.b.f367163a;
        com.larus.reach.impl.b.d(r103.f367265a, r121);
        Map<String, ? extends List<? extends ReachSceneLifecycleListener>> r123 = y.f367359a;
        y.c(r103.f367265a, r121);
        goto L44
    L39:
        if (r120 == 2) goto L41;
        r121 = ReachRejectReason.CLIENT_EXCEPTION;
        goto L43
    L41:
        r121 = ReachRejectReason.REVOKED;
        goto L43
    L6:
        if (r102.f367268d != r101) goto L8;
        boolean r124 = true;
    L9:
        if (r124 == true) goto L12;
        r102 = null;
    L12:
        if (r102 == null) goto L14;
        r103 = o(r102);     // Catch: Throwable -> L46
        goto L14
    L8:
        r124 = false;
    L46:
        th = move-exception;
        throw th;
    }

    public final boolean t(c r100, ReachBannerHost r101, long r102, String r110) {
        ns9.t r103 = r100.f367265a;
        c r104 = null;
        boolean r105 = false;
        if (Intrinsics.areEqual(r110, "legacy_activity_dialog_dismissing") == true) goto L39;
        ns9.v r106 = r103.f520409b;
        if ((r106 instanceof ns9.w) == false) goto L8;
        ns9.w r107 = (ns9.w) r106;
    L9:
        if (r107 != null) goto L11;
        boolean r111 = false;
    L41:
        if (r111 == true) goto L43;
        return false;
    L43:
        monitor-enter(this);
        c r112 = this.f367253g.get(r100.f367265a.f520408a.f520400h);     // Catch: Throwable -> L65
        if (r112 == null) goto L57;
        if (r112 == r100) goto L48;
    L50:
        boolean r108 = false;
    L51:
        if (r108 == true) goto L54;
        r112 = null;
    L54:
        if (r112 == null) goto L57;
        r112.f367271g = r101;     // Catch: Throwable -> L65
        r112.a(EntryState.WAITING_HOST);     // Catch: Throwable -> L65
        r104 = r112;
        goto L57
    L48:
        if (r112.f367270f != EntryState.CHECKING) goto L50;
        r108 = true;
    L57:
        if (r104 == null) goto L59;
        r105 = true;
    L59:
        monitor-exit(this);
        if (r105 == false) goto L64;
        int r109 = v.f367352a;
        if (v.a(r102, new ReachBannerRuntime$waitDisplayUnavailableIfNeeded$registered$1(this)) == true) goto L64;
        l();
    L64:
        return r105;
    L65:
        th = move-exception;
        throw th;
    L11:
        if (r110 != null) goto L13;
    L37:
        boolean r113 = false;
    L38:
        if (r113 == true) goto L39;
        r111 = !StringsKt.equals(r107.f520418c, "discard", true);
        goto L41
    L13:
        switch(r110.hashCode()) {
            case -2102071058: goto L34;
            case -1807286182: goto L31;
            case -1069127566: goto L28;
            case -992605017: goto L25;
            case -672605360: goto L22;
            case 1272387642: goto L19;
            case 2127802908: goto L16;
            default: goto L37;
        };
    L16:
        if (r110.equals("message_spacer_not_ready") == false) goto L37;
    L36:
        r113 = true;
        goto L38
    L19:
        if (r110.equals("banner_measurement_unavailable") == true) goto L36;
    L22:
        if (r110.equals("target_page_container_unavailable") == true) goto L36;
    L25:
        if (r110.equals("target_page_anchor_root_detached") == true) goto L36;
    L28:
        if (r110.equals("target_page_container_detached") == true) goto L36;
    L31:
        if (r110.equals("bottom_anchor_unavailable") == true) goto L36;
    L34:
        if (r110.equals("target_conversation_host_not_ready") == true) goto L36;
    L8:
        r107 = null;
    L39:
        r111 = true;
        goto L41
    }

    public static void p(ReachBannerRuntime r100, String r101, ReachCloseReason r102, Long r103, Long r104, boolean r105, int r110) {
        if ((r110 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r110 & 8) == 0) goto L9;
        r104 = null;
    L9:
        if ((r110 & 16) == 0) goto L11;
        r105 = false;
    L11:
        monitor-enter(r100);
        c r106 = r100.f367253g.get(r101);     // Catch: Throwable -> L46
        if (r106 != null) goto L16;
        monitor-exit(r100);
        return;
    L16:
        if (r103 != null) goto L19;
    L22:
        if (r104 == null) goto L29;
        if (r106.f367277m == r104.longValue()) goto L29;
        monitor-exit(r100);
        return;
    L29:
        if (r102 != ReachCloseReason.AUTO_DISMISS) goto L35;
        if (r105 == true) goto L35;
        if (r106.f367275k == true) goto L35;
        monitor-exit(r100);
        return;
    L35:
        EntryState r107 = r106.f367270f;     // Catch: Throwable -> L46
        EntryState r108 = EntryState.DISMISSING;     // Catch: Throwable -> L46
        if (r107 != r108) goto L40;
        monitor-exit(r100);
        return;
    L40:
        if (r107.isPresented() == false) goto L42;
        r106.a(r108);     // Catch: Throwable -> L46
        a r109 = new a.b(r106, r102);     // Catch: Throwable -> L46
    L43:
        monitor-exit(r100);
        r100.g(r109);
        return;
    L42:
        r100.o(r106);     // Catch: Throwable -> L46
        r109 = new a.c(r106, ReachRejectReason.CLIENT_EXCEPTION);     // Catch: Throwable -> L46
        goto L43
    L19:
        if (r106.f367268d == r103.longValue()) goto L22;
        monitor-exit(r100);
        return;
    L46:
        th = move-exception;
        throw th;
    }
}
