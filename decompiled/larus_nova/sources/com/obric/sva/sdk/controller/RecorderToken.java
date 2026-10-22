package com.obric.sva.sdk.controller;

import android.media.AudioRecord;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.speech.speechengine.SpeechEngineDefines;
import com.ss.android.common.applog.EventVerify;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001e\u001a\u00020\u0013J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u0005J\"\u0010!\u001a\u00020\u00132\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u0006\u0010#\u001a\u00020\u0019J\u0006\u0010$\u001a\u00020\u0013J\b\u0010%\u001a\u00020&H\u0016J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006/"}, d2 = {"Lcom/obric/sva/sdk/controller/RecorderToken;", "", "state", "Lcom/obric/sva/sdk/controller/RecorderState;", SpeechEngineDefines.RECORDER_ENGINE, "Landroid/media/AudioRecord;", "<init>", "(Lcom/obric/sva/sdk/controller/RecorderState;Landroid/media/AudioRecord;)V", "getState", "()Lcom/obric/sva/sdk/controller/RecorderState;", "setState", "(Lcom/obric/sva/sdk/controller/RecorderState;)V", "getRecorder", "()Landroid/media/AudioRecord;", "setRecorder", "(Landroid/media/AudioRecord;)V", "runnable", "Lkotlin/Function1;", "Lcom/obric/sva/sdk/controller/ExecuteCategory;", "", "getRunnable", "()Lkotlin/jvm/functions/Function1;", "setRunnable", "(Lkotlin/jvm/functions/Function1;)V", "deferred", "Lkotlinx/coroutines/Job;", "getDeferred", "()Lkotlinx/coroutines/Job;", "setDeferred", "(Lkotlinx/coroutines/Job;)V", EventVerify.TYPE_TERMINATE, "ready", "rec", "using", "task", "def", BasicTestActionHandler.TEST_ACTION_RESET, "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RecorderToken {
    private Job deferred;
    private AudioRecord recorder;
    private Function1<? super ExecuteCategory, Unit> runnable;
    private RecorderState state;

    public static /* synthetic */ RecorderToken copy$default(RecorderToken r100, RecorderState r101, AudioRecord r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.state;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.recorder;
    L9:
        return r100.copy(r101, r102);
    }

    public final RecorderState component1() {
        return this.state;
    }

    public final AudioRecord component2() {
        return this.recorder;
    }

    public final RecorderToken copy(RecorderState r100, AudioRecord r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        return new RecorderToken(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RecorderToken) == true) goto L8;
        return false;
    L8:
        RecorderToken r101 = (RecorderToken) r100;
        if (this.state == r101.state) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.recorder, r101.recorder) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = this.state.hashCode() * 31;
        AudioRecord r101 = this.recorder;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final void reset() {
        monitor-enter(this);
        Job r100 = this.deferred;     // Catch: Throwable -> L15
        AudioRecord r101 = this.recorder;     // Catch: Throwable -> L15
        Unit r102 = null;
        this.runnable = null;     // Catch: Throwable -> L15
        this.deferred = null;     // Catch: Throwable -> L15
        this.state = RecorderState.NA;     // Catch: Throwable -> L15
        this.recorder = null;     // Catch: Throwable -> L15
        Unit r103 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(this);
        if (r100 == null) goto L20;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L20:
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L12
        if (r101 == null) goto L10;
        HotwordRecorderMgrKt.releaseLocked(r101);     // Catch: Throwable -> L12
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L12
    L10:
        Result.m9449constructorimpl(r102);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void terminate() {
        monitor-enter(this);
        Function1<? super ExecuteCategory, Unit> r100 = this.runnable;     // Catch: Throwable -> L10
        Job r101 = this.deferred;     // Catch: Throwable -> L10
        this.state = RecorderState.FINISHED;     // Catch: Throwable -> L10
        this.deferred = null;     // Catch: Throwable -> L10
        this.runnable = null;     // Catch: Throwable -> L10
        this.recorder = null;     // Catch: Throwable -> L10
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(this);
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L7:
        if (r100 == null) goto L15;
        r100.invoke(ExecuteCategory.NORMAL);
        return;
    L15:
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("AudioRecorder ");
        r100.append(this.recorder);
        r100.append(" State ");
        r100.append(this.state);
        r100.append(":[ hashcode ");
        AudioRecord r101 = this.recorder;
        Integer r102 = null;
        if (r101 == null) goto L5;
        Integer r103 = Integer.valueOf(r101.hashCode());
    L6:
        r100.append(r103);
        r100.append(" session_id : ");
        AudioRecord r104 = this.recorder;
        if (r104 == null) goto L9;
        Integer r105 = Integer.valueOf(r104.getAudioSessionId());
    L10:
        r100.append(r105);
        r100.append(" recorderState : ");
        AudioRecord r106 = this.recorder;
        if (r106 == null) goto L13;
        r102 = Integer.valueOf(r106.getState());
    L13:
        r100.append(r102);
        r100.append(']');
        return r100.toString();
    L9:
        r105 = null;
        goto L10
    L5:
        r103 = null;
        goto L6
    }

    public final Job getDeferred() {
        return this.deferred;
    }

    public final AudioRecord getRecorder() {
        return this.recorder;
    }

    public final Function1<ExecuteCategory, Unit> getRunnable() {
        return this.runnable;
    }

    public final RecorderState getState() {
        return this.state;
    }

    public final synchronized void ready(AudioRecord r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "rec");     // Catch: Throwable -> L6
        this.state = RecorderState.READY;     // Catch: Throwable -> L6
        this.recorder = r100;     // Catch: Throwable -> L6
        this.deferred = null;     // Catch: Throwable -> L6
        this.runnable = null;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final void setDeferred(Job r100) {
        this.deferred = r100;
    }

    public final void setRecorder(AudioRecord r100) {
        this.recorder = r100;
    }

    public final void setRunnable(Function1<? super ExecuteCategory, Unit> r100) {
        this.runnable = r100;
    }

    public final void setState(RecorderState r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.state = r100;
    }

    public RecorderToken(RecorderState r100, AudioRecord r101) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.state = r100;
        this.recorder = r101;
    }

    public final synchronized void using(Function1<? super ExecuteCategory, Unit> r100, Job r101) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "task");     // Catch: Throwable -> L6
        Intrinsics.checkNotNullParameter(r101, "def");     // Catch: Throwable -> L6
        this.state = RecorderState.IN_USE;     // Catch: Throwable -> L6
        this.runnable = r100;     // Catch: Throwable -> L6
        this.deferred = r101;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public /* synthetic */ RecorderToken(RecorderState r100, AudioRecord r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101);
    }
}
