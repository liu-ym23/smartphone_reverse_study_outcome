package com.bytedance.android.shopping.mall.feed.help;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.shopping.slice.action.entity.PdpOpenThirdParam;
import com.google.gson.annotations.SerializedName;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class ECMallGulRefresh {
    public static final Lazy g = null;
    public final Object a;
    public int b;
    public final Handler c;
    public String d;
    public final b e;
    public final boolean f;

    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/ECMallGulRefresh$Companion$PrefetchState;", "", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface PrefetchState {
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/shopping/mall/feed/help/ECMallGulRefresh$Companion$a;", "", "", "fromPitaya", "Ljava/lang/Boolean;", "getFromPitaya", "()Ljava/lang/Boolean;", "", "leaveTimeout", "Ljava/lang/Long;", "getLeaveTimeout", "()Ljava/lang/Long;", "", "", "pageName", "Ljava/util/List;", "getPageName", "()Ljava/util/List;", "pitayaActions", "b", "", "revertFiltersLength", "Ljava/lang/Integer;", "c", "()Ljava/lang/Integer;", "timeoutDelay", "getTimeoutDelay", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class a {

            @SerializedName("from_pitaya")
            private final Boolean fromPitaya;

            @SerializedName("leave_timeout")
            private final Long leaveTimeout;

            @SerializedName(PdpOpenThirdParam.KEY_PAGE_NAME)
            private final List<String> pageName;

            @SerializedName("pitaya_actions")
            private final Boolean pitayaActions;

            @SerializedName("revert_filters_length")
            private final Integer revertFiltersLength;

            @SerializedName("timeout_delay")
            private final Long timeoutDelay;

            public a() {
                this(null);
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof a) == false) goto L18;
                a r4 = (a) r3;
                if (Intrinsics.areEqual(this.fromPitaya, r4.fromPitaya) == true) goto L8;
                return false;
            L8:
                if (Intrinsics.areEqual(this.leaveTimeout, r4.leaveTimeout) == true) goto L10;
                return false;
            L10:
                if (Intrinsics.areEqual(this.pageName, r4.pageName) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.pitayaActions, r4.pitayaActions) == true) goto L14;
                return false;
            L14:
                if (Intrinsics.areEqual(this.revertFiltersLength, r4.revertFiltersLength) == true) goto L16;
                return false;
            L16:
                if (Intrinsics.areEqual(this.timeoutDelay, r4.timeoutDelay) == true) goto L28;
                return false;
            L28:
                return true;
            L18:
                return false;
            }

            public final int hashCode() {
                Boolean r0 = this.fromPitaya;
                int r1 = 0;
                if (r0 == null) goto L5;
                int r2 = r0.hashCode();
            L6:
                int r3 = r2 * 31;
                Long r4 = this.leaveTimeout;
                if (r4 == null) goto L9;
                int r5 = r4.hashCode();
            L10:
                int r6 = (r3 + r5) * 31;
                List<String> r7 = this.pageName;
                if (r7 == null) goto L13;
                int r8 = r7.hashCode();
            L14:
                int r9 = (r6 + r8) * 31;
                Boolean r10 = this.pitayaActions;
                if (r10 == null) goto L17;
                int r11 = r10.hashCode();
            L18:
                int r12 = (r9 + r11) * 31;
                Integer r13 = this.revertFiltersLength;
                if (r13 == null) goto L21;
                int r14 = r13.hashCode();
            L22:
                int r15 = (r12 + r14) * 31;
                Long r16 = this.timeoutDelay;
                if (r16 == null) goto L26;
                r1 = r16.hashCode();
            L26:
                return r15 + r1;
            L21:
                r14 = 0;
                goto L22
            L17:
                r11 = 0;
                goto L18
            L13:
                r8 = 0;
                goto L14
            L9:
                r5 = 0;
                goto L10
            L5:
                r2 = 0;
                goto L6
            }

            public final String toString() {
                return "GulRefreshConfig(fromPitaya=" + this.fromPitaya + ", leaveTimeout=" + this.leaveTimeout + ", pageName=" + this.pageName + ", pitayaActions=" + this.pitayaActions + ", revertFiltersLength=" + this.revertFiltersLength + ", timeoutDelay=" + this.timeoutDelay + ")";
            }

            public final Boolean b() {
                return this.pitayaActions;
            }

            public final Integer c() {
                return this.revertFiltersLength;
            }

            public a(Object r1) {
                this.fromPitaya = null;
                this.leaveTimeout = null;
                this.pageName = null;
                this.pitayaActions = null;
                this.revertFiltersLength = null;
                this.timeoutDelay = null;
            }

            public final Long a(String r3) {
                if (r3 != null) goto L5;
                return null;
            L5:
                List<String> r1 = this.pageName;
                if (r1 != null) goto L8;
            L12:
                return null;
            L8:
                if (r1.contains(r3) != true) goto L12;
                return this.leaveTimeout;
            }

            public final boolean d(String r4) {
                if (r4 != null) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.fromPitaya, Boolean.TRUE) == false) goto L13;
                List<String> r1 = this.pageName;
                if (r1 != null) goto L10;
                return false;
            L10:
                if (r1.contains(r4) != true) goto L15;
                return true;
            L15:
                return false;
            L13:
                return false;
            }
        }

        public static a a() {
            return (a) ECMallGulRefresh.g.getValue();
        }
    }

    public static final class a implements Runnable {
        public final /* synthetic */ ECMallGulRefresh a;

        public a(ECMallGulRefresh r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.e.run();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ECMallGulRefresh a;

        public b(ECMallGulRefresh r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r0 = this.a.a;     // Catch: Throwable -> L10
            monitor-enter(r0);     // Catch: Throwable -> L10
            this.a.d = "finish";     // Catch: Throwable -> L7
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);     // Catch: Throwable -> L10
            return;
        L7:
            th = move-exception;
            throw th;     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
        g = LazyKt.lazy(ECMallGulRefresh$Companion$gulRefreshConfig$2.INSTANCE);
    }

    public final void a() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.c.removeCallbacks(this.e);     // Catch: Throwable -> L7
        this.d = "init";     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void b() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.d = "finish";     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void c() {
        Object r0 = this.a;
        monitor-enter(r0);
        this.d = "running";     // Catch: Throwable -> L7
        this.c.removeCallbacks(this.e);     // Catch: Throwable -> L7
        this.c.postDelayed(new a(this), 16000);     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public ECMallGulRefresh(boolean r1, Long r2) {
        this.f = r1;
        this.a = new Object();
        this.c = new Handler(Looper.getMainLooper());
        this.d = "init";
        this.e = new b(this);
    }
}
