package com.larus.office.card.minutes.model;

import androidx.lifecycle.ViewModel;
import com.larus.im.bean.message.block.AudioRecordStatus;
import com.larus.utils.logger.FLogger;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0002\u0018\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\u0013\u001a\u00020\u00112\b\u0010\f\u001a\u0004\u0018\u00010\tJ/\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/larus/office/card/minutes/model/AudioRecordCardLifecycleGuard;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "instanceId", "", "classLoaderId", "snapshots", "", "", "Lcom/larus/office/card/minutes/model/AudioRecordCardLifecycleGuard$Snapshot;", "reconcileStatus", DownloadHelper.IDENTITY, "incomingStatus", "hasFailure", "", "markStartSucceeded", "", "tryStart", "markStartFailed", "shouldKeepPreviousStatus", "previousStatus", "hasStarted", "(Ljava/lang/Integer;IZZ)Z", "Snapshot", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioRecordCardLifecycleGuard extends ViewModel {
    public static final a Companion = null;
    private static final String LOG_PREFIX = "[AudioRecordCardLifecycleGuard]";
    private static final Set<Integer> NON_REGRESSIBLE_STATUSES = null;
    private static final String TAG = "AudioRecordCardLifecycleGuard";
    private final int classLoaderId;
    private final int instanceId;
    private final Map<String, b> snapshots;

    public static final class a {
        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f361451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f361452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f361453c;

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
            if (Intrinsics.areEqual(this.f361451a, r101.f361451a) == true) goto L12;
            return false;
        L12:
            if (this.f361452b == r101.f361452b) goto L15;
            return false;
        L15:
            if (this.f361453c == r101.f361453c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Integer r100 = this.f361451a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            int r103 = 1231;
            if (this.f361452b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f361453c == true) goto L15;
            r103 = 1237;
        L15:
            return r105 + r103;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Snapshot(acceptedStatus=" + this.f361451a + ", isStartPending=" + this.f361452b + ", hasStarted=" + this.f361453c + ')';
        }

        public b(int r100) {
            this.f361451a = null;
            this.f361452b = false;
            this.f361453c = false;
        }
    }

    static {
        Companion = new a();
        NON_REGRESSIBLE_STATUSES = SetsKt.setOf(new Integer[]{Integer.valueOf(AudioRecordStatus.STATUS_RECORDING.getValue()), Integer.valueOf(AudioRecordStatus.STATUS_PAUSED.getValue()), Integer.valueOf(AudioRecordStatus.STATUS_GENERATING_SUMMARY.getValue()), Integer.valueOf(AudioRecordStatus.STATUS_COMPLETED.getValue())});
    }

    public AudioRecordCardLifecycleGuard() {
        int r100 = System.identityHashCode(this);
        this.instanceId = r100;
        int r101 = System.identityHashCode(AudioRecordCardLifecycleGuard.class.getClassLoader());
        this.classLoaderId = r101;
        this.snapshots = new LinkedHashMap();
        FLogger.f375446a.i(TAG, "[AudioRecordCardLifecycleGuard] Init lifecycle guard, instanceId=" + r100 + ", classLoaderId=" + r101);
    }

    public final void markStartFailed(String r100) {
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        FLogger.f375446a.i(TAG, "[AudioRecordCardLifecycleGuard] Skip marking start failed for blank identity, instanceId=" + this.instanceId + ", classLoaderId=" + this.classLoaderId);
        return;
    L12:
        Map<String, b> r103 = this.snapshots;
        monitor-enter(r103);
        b r104 = this.snapshots.get(r100);     // Catch: Throwable -> L31
        if (r104 == null) goto L17;
        r104.f361452b = false;     // Catch: Throwable -> L31
    L17:
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L31
        StringBuilder r106 = new StringBuilder("[AudioRecordCardLifecycleGuard] Mark start failed, identity=");     // Catch: Throwable -> L31
        r106.append(r100);     // Catch: Throwable -> L31
        r106.append(", snapshotFound=");     // Catch: Throwable -> L31
        if (r104 != null) goto L21;
        r101 = false;
    L21:
        r106.append(r101);     // Catch: Throwable -> L31
        r106.append(", acceptedStatus=");     // Catch: Throwable -> L31
        Boolean r107 = null;
        if (r104 == null) goto L24;
        Integer r108 = r104.f361451a;     // Catch: Throwable -> L31
    L25:
        r106.append(r108);     // Catch: Throwable -> L31
        r106.append(", hasStarted=");     // Catch: Throwable -> L31
        if (r104 == null) goto L28;
        r107 = Boolean.valueOf(r104.f361453c);     // Catch: Throwable -> L31
    L28:
        r106.append(r107);     // Catch: Throwable -> L31
        r106.append(", size=");     // Catch: Throwable -> L31
        r106.append(this.snapshots.size());     // Catch: Throwable -> L31
        r106.append(", instanceId=");     // Catch: Throwable -> L31
        r106.append(this.instanceId);     // Catch: Throwable -> L31
        r106.append(", classLoaderId=");     // Catch: Throwable -> L31
        r106.append(this.classLoaderId);     // Catch: Throwable -> L31
        r105.i(TAG, r106.toString());     // Catch: Throwable -> L31
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L31
        monitor-exit(r103);
        return;
    L24:
        r108 = null;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r100) == true) goto L8;
        r102 = false;
        goto L9
    }

    public final void markStartSucceeded(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i(TAG, "[AudioRecordCardLifecycleGuard] Skip marking start succeeded for blank identity, instanceId=" + this.instanceId + ", classLoaderId=" + this.classLoaderId);
        return;
    L12:
        Map<String, b> r102 = this.snapshots;
        monitor-enter(r102);
        b r103 = this.snapshots.get(r110);     // Catch: Throwable -> L27
        if (r103 != null) goto L17;
        b r104 = new b(0);     // Catch: Throwable -> L27
        this.snapshots.put(r110, r104);     // Catch: Throwable -> L27
    L18:
        r104.f361452b = false;     // Catch: Throwable -> L27
        r104.f361453c = true;     // Catch: Throwable -> L27
        if (CollectionsKt.contains(NON_REGRESSIBLE_STATUSES, r104.f361451a) == true) goto L21;
        r104.f361451a = Integer.valueOf(AudioRecordStatus.STATUS_RECORDING.getValue());     // Catch: Throwable -> L27
    L21:
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L27
        StringBuilder r106 = new StringBuilder("[AudioRecordCardLifecycleGuard] Mark start succeeded, identity=");     // Catch: Throwable -> L27
        r106.append(r110);     // Catch: Throwable -> L27
        r106.append(", snapshotFound=");     // Catch: Throwable -> L27
        if (r103 == null) goto L24;
        r100 = true;
    L24:
        r106.append(r100);     // Catch: Throwable -> L27
        r106.append(", acceptedStatus=");     // Catch: Throwable -> L27
        r106.append(r104.f361451a);     // Catch: Throwable -> L27
        r106.append(", size=");     // Catch: Throwable -> L27
        r106.append(this.snapshots.size());     // Catch: Throwable -> L27
        r106.append(", instanceId=");     // Catch: Throwable -> L27
        r106.append(this.instanceId);     // Catch: Throwable -> L27
        r106.append(", classLoaderId=");     // Catch: Throwable -> L27
        r106.append(this.classLoaderId);     // Catch: Throwable -> L27
        r105.i(TAG, r106.toString());     // Catch: Throwable -> L27
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L27
        monitor-exit(r102);
        return;
    L17:
        r104 = r103;
    L27:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final boolean tryStart(String r110) {
        boolean r100 = false;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i(TAG, "[AudioRecordCardLifecycleGuard] Try start, identity=" + r110 + ", snapshotFound=false, allowed=true, reason=blank_identity, instanceId=" + this.instanceId + ", classLoaderId=" + this.classLoaderId);
        return true;
    L12:
        Map<String, b> r102 = this.snapshots;
        monitor-enter(r102);
        b r103 = this.snapshots.get(r110);     // Catch: Throwable -> L31
        if (r103 != null) goto L17;
        b r104 = new b(0);     // Catch: Throwable -> L31
        this.snapshots.put(r110, r104);     // Catch: Throwable -> L31
    L19:
        if (r104.f361452b == false) goto L21;
    L24:
        boolean r105 = false;
    L25:
        FLogger r106 = FLogger.f375446a;     // Catch: Throwable -> L31
        StringBuilder r107 = new StringBuilder("[AudioRecordCardLifecycleGuard] Try start, identity=");     // Catch: Throwable -> L31
        r107.append(r110);     // Catch: Throwable -> L31
        r107.append(", snapshotFound=");     // Catch: Throwable -> L31
        if (r103 == null) goto L28;
        r100 = true;
    L28:
        r107.append(r100);     // Catch: Throwable -> L31
        r107.append(", allowed=");     // Catch: Throwable -> L31
        r107.append(r105);     // Catch: Throwable -> L31
        r107.append(", acceptedStatus=");     // Catch: Throwable -> L31
        r107.append(r104.f361451a);     // Catch: Throwable -> L31
        r107.append(", isStartPending=");     // Catch: Throwable -> L31
        r107.append(r104.f361452b);     // Catch: Throwable -> L31
        r107.append(", hasStarted=");     // Catch: Throwable -> L31
        r107.append(r104.f361453c);     // Catch: Throwable -> L31
        r107.append(", size=");     // Catch: Throwable -> L31
        r107.append(this.snapshots.size());     // Catch: Throwable -> L31
        r107.append(", instanceId=");     // Catch: Throwable -> L31
        r107.append(this.instanceId);     // Catch: Throwable -> L31
        r107.append(", classLoaderId=");     // Catch: Throwable -> L31
        r107.append(this.classLoaderId);     // Catch: Throwable -> L31
        r106.i(TAG, r107.toString());     // Catch: Throwable -> L31
        monitor-exit(r102);
        return r105;
    L21:
        if (r104.f361453c == true) goto L24;
        r104.f361452b = true;     // Catch: Throwable -> L31
        r105 = true;
        goto L25
    L17:
        r104 = r103;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    public final int reconcileStatus(String r110, int r111, boolean r112) {
        boolean r100 = true;
        if (r110 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L12;
        FLogger.f375446a.i(TAG, "[AudioRecordCardLifecycleGuard] Skip lifecycle reconciliation for blank identity, incomingStatus=" + r111 + ", hasFailure=" + r112 + ", instanceId=" + this.instanceId + ", classLoaderId=" + this.classLoaderId);
        return r111;
    L12:
        Map<String, b> r102 = this.snapshots;
        monitor-enter(r102);
        b r103 = this.snapshots.get(r110);     // Catch: Throwable -> L31
        if (r103 != null) goto L17;
        b r104 = new b(0);     // Catch: Throwable -> L31
        this.snapshots.put(r110, r104);     // Catch: Throwable -> L31
    L18:
        Integer r105 = r104.f361451a;     // Catch: Throwable -> L31
        if (shouldKeepPreviousStatus(r105, r111, r112, r104.f361453c) == false) goto L22;
        if (r105 == null) goto L23;
        int r106 = r105.intValue();     // Catch: Throwable -> L31
    L24:
        FLogger r107 = FLogger.f375446a;     // Catch: Throwable -> L31
        StringBuilder r113 = new StringBuilder("[AudioRecordCardLifecycleGuard] Reconcile lifecycle status, identity=");     // Catch: Throwable -> L31
        r113.append(r110);     // Catch: Throwable -> L31
        r113.append(", snapshotFound=");     // Catch: Throwable -> L31
        if (r103 != null) goto L28;
        r100 = false;
    L28:
        r113.append(r100);     // Catch: Throwable -> L31
        r113.append(", incomingStatus=");     // Catch: Throwable -> L31
        r113.append(r111);     // Catch: Throwable -> L31
        r113.append(", previousStatus=");     // Catch: Throwable -> L31
        r113.append(r105);     // Catch: Throwable -> L31
        r113.append(", acceptedStatus=");     // Catch: Throwable -> L31
        r113.append(r106);     // Catch: Throwable -> L31
        r113.append(", hasFailure=");     // Catch: Throwable -> L31
        r113.append(r112);     // Catch: Throwable -> L31
        r113.append(", isStartPending=");     // Catch: Throwable -> L31
        r113.append(r104.f361452b);     // Catch: Throwable -> L31
        r113.append(", hasStarted=");     // Catch: Throwable -> L31
        r113.append(r104.f361453c);     // Catch: Throwable -> L31
        r113.append(", size=");     // Catch: Throwable -> L31
        r113.append(this.snapshots.size());     // Catch: Throwable -> L31
        r113.append(", instanceId=");     // Catch: Throwable -> L31
        r113.append(this.instanceId);     // Catch: Throwable -> L31
        r113.append(", classLoaderId=");     // Catch: Throwable -> L31
        r113.append(this.classLoaderId);     // Catch: Throwable -> L31
        r107.i(TAG, r113.toString());     // Catch: Throwable -> L31
        monitor-exit(r102);
        return r106;
    L23:
        r106 = r111;
        goto L24
    L22:
        r104.f361451a = Integer.valueOf(r111);     // Catch: Throwable -> L31
        goto L23
    L17:
        r104 = r103;
    L31:
        th = move-exception;
        throw th;
    L5:
        if (StringsKt.isBlank(r110) == true) goto L8;
        r101 = false;
        goto L9
    }

    private final boolean shouldKeepPreviousStatus(Integer r100, int r101, boolean r102, boolean r103) {
        if (r103 == true) goto L5;
        if (r102 == false) goto L5;
    L9:
        return false;
    L5:
        if (r101 != AudioRecordStatus.STATUS_IDLE.getValue()) goto L9;
        if (CollectionsKt.contains(NON_REGRESSIBLE_STATUSES, r100) == false) goto L9;
        return true;
    }
}
