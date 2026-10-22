package com.larus.audio.call.mgr;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface StateTriggerEvent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Connect;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Connect implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Connect f289195a = null;

        static {
            f289195a = new Connect();
        }

        private Connect() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Connected;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Connected implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Connected f289196a = null;

        static {
            f289196a = new Connected();
        }

        private Connected() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$CurrentReplyPlayEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "expectedState", "Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "<init>", "(Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;)V", "getExpectedState", "()Lcom/larus/audio/call/mgr/AVKitDuplexState$DownState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CurrentReplyPlayEnd implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AVKitDuplexState.DownState f289197a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof CurrentReplyPlayEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f289197a, ((CurrentReplyPlayEnd) r100).f289197a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f289197a.hashCode();
        }

        public final String toString() {
            return "CurrentReplyPlayEnd(expectedState=" + this.f289197a + ')';
        }

        public CurrentReplyPlayEnd(AVKitDuplexState.DownState r100) {
            Intrinsics.checkNotNullParameter(r100, "expectedState");
            this.f289197a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$DeepThinkEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeepThinkEnd implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeepThinkEnd f289198a = null;

        static {
            f289198a = new DeepThinkEnd();
        }

        private DeepThinkEnd() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$DeepThinkStart;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class DeepThinkStart implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DeepThinkStart f289199a = null;

        static {
            f289199a = new DeepThinkStart();
        }

        private DeepThinkStart() {
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u0017\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0003J5\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\bHÖ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Error;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "code", "", "msg", "", "extra", "", "", "<init>", "(ILjava/lang/String;Ljava/util/Map;)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "getExtra", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Error implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f289200a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f289201b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map<String, Object> f289202c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Error) == true) goto L8;
            return false;
        L8:
            Error r101 = (Error) r100;
            if (this.f289200a == r101.f289200a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f289201b, r101.f289201b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f289202c, r101.f289202c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f289200a * 31) + this.f289201b.hashCode()) * 31) + this.f289202c.hashCode();
        }

        public final String toString() {
            return "Error(code=" + this.f289200a + ", msg=" + this.f289201b + ", extra=" + this.f289202c + ')';
        }

        public Error(int r100, String r101, Map<String, ? extends Object> r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "extra");
            this.f289200a = r100;
            this.f289201b = r101;
            this.f289202c = r102;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Interrupt;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Interrupt implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Interrupt f289203a = null;

        static {
            f289203a = new Interrupt();
        }

        private Interrupt() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Pause;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Pause implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Pause f289204a = null;

        static {
            f289204a = new Pause();
        }

        private Pause() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$PlayEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class PlayEnd implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final PlayEnd f289205a = null;

        static {
            f289205a = new PlayEnd();
        }

        private PlayEnd() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$QueryBegin;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueryBegin implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final QueryBegin f289206a = null;

        static {
            f289206a = new QueryBegin();
        }

        private QueryBegin() {
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$QueryEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "noContent", "", "<init>", "(Z)V", "getNoContent", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class QueryEnd implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f289207a;

        public QueryEnd() {
            this(false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof QueryEnd) == true) goto L9;
            return false;
        L9:
            if (this.f289207a == ((QueryEnd) r100).f289207a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f289207a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "QueryEnd(noContent=" + this.f289207a + ')';
        }

        public QueryEnd(boolean r100) {
            this.f289207a = r100;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$ReplyStart;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ReplyStart implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ReplyStart f289208a = null;

        static {
            f289208a = new ReplyStart();
        }

        private ReplyStart() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestSpeaking;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestSpeaking implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestSpeaking f289209a = null;

        static {
            f289209a = new RequestSpeaking();
        }

        private RequestSpeaking() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestThinking;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestThinking implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestThinking f289210a = null;

        static {
            f289210a = new RequestThinking();
        }

        private RequestThinking() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$RequestWaiting;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RequestWaiting implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final RequestWaiting f289211a = null;

        static {
            f289211a = new RequestWaiting();
        }

        private RequestWaiting() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Reset;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Reset implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Reset f289212a = null;

        static {
            f289212a = new Reset();
        }

        private Reset() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Resume;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Resume implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Resume f289213a = null;

        static {
            f289213a = new Resume();
        }

        private Resume() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$SceneSwitched;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class SceneSwitched implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final SceneSwitched f289214a = null;

        static {
            f289214a = new SceneSwitched();
        }

        private SceneSwitched() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$Stop;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Stop implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Stop f289215a = null;

        static {
            f289215a = new Stop();
        }

        private Stop() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/audio/call/mgr/StateTriggerEvent$TtsStreamEnd;", "Lcom/larus/audio/call/mgr/StateTriggerEvent;", "<init>", "()V", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class TtsStreamEnd implements StateTriggerEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final TtsStreamEnd f289216a = null;

        static {
            f289216a = new TtsStreamEnd();
        }

        private TtsStreamEnd() {
        }
    }
}
