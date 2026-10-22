package com.obric.assistant.interaction.base.model;

import com.heytap.mcssdk.constant.b;
import com.obric.assistant.interaction.base.interact.KeyguardLockedState;
import com.obric.assistant.interaction.base.mode.MicMuteState;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0007\u0004\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0007\u000b\f\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "", "<init>", "()V", "CommonEvent", "SessionLifecycleEvent", "InteractionActivityExpandEvent", "InteractionActivityVisibleEvent", "InteractionKeyguardLockedEvent", "MicMuteEvent", "ErrorEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$CommonEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$ErrorEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class InteractionEvent {

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\b6\u0018\u00002\u00020\u0001B'\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$CommonEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", b.f276361k, "", "args", "", "", "", "<init>", "(ILjava/util/Map;)V", "getEventId", "()I", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class CommonEvent extends InteractionEvent {
        private final int eventId;

        public /* synthetic */ CommonEvent(int r100, Map r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }

        public final int getEventId() {
            return this.eventId;
        }

        private CommonEvent(int r100, Map<String, ? extends Object> r101) {
            super(null);
            this.eventId = r100;
        }

        public /* synthetic */ CommonEvent(int r100, Map r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = MapsKt.emptyMap();
        L5:
            this(r100, r101, null);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$ErrorEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "error", "", "errorCode", "", "<init>", "(Ljava/lang/Throwable;I)V", "getError", "()Ljava/lang/Throwable;", "getErrorCode", "()I", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class ErrorEvent extends InteractionEvent {
        private final Throwable error;
        private final int errorCode;

        public final Throwable getError() {
            return this.error;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public ErrorEvent(Throwable r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            super(null);
            this.error = r100;
            this.errorCode = r101;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "<init>", "(Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;)V", "getState", "()Lcom/obric/assistant/interaction/base/model/AssistantActivityExpandState;", "SmallWindowEvent", "NineSplitEvent", "FullScreenEvent", "InvisibleEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$FullScreenEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$NineSplitEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$SmallWindowEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class InteractionActivityExpandEvent extends InteractionEvent {
        private final AssistantActivityExpandState state;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$FullScreenEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class FullScreenEvent extends InteractionActivityExpandEvent {
            public static final FullScreenEvent INSTANCE = null;

            static {
                INSTANCE = new FullScreenEvent();
            }

            private FullScreenEvent() {
                super(AssistantActivityExpandState.FULL_SCREEN, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class InvisibleEvent extends InteractionActivityExpandEvent {
            public static final InvisibleEvent INSTANCE = null;

            static {
                INSTANCE = new InvisibleEvent();
            }

            private InvisibleEvent() {
                super(AssistantActivityExpandState.INVISIBLE, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$NineSplitEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class NineSplitEvent extends InteractionActivityExpandEvent {
            public static final NineSplitEvent INSTANCE = null;

            static {
                INSTANCE = new NineSplitEvent();
            }

            private NineSplitEvent() {
                super(AssistantActivityExpandState.HALF_WINDOW, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent$SmallWindowEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityExpandEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class SmallWindowEvent extends InteractionActivityExpandEvent {
            public static final SmallWindowEvent INSTANCE = null;

            static {
                INSTANCE = new SmallWindowEvent();
            }

            private SmallWindowEvent() {
                super(AssistantActivityExpandState.CHAT_WINDOW, null);
            }
        }

        public /* synthetic */ InteractionActivityExpandEvent(AssistantActivityExpandState r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public final AssistantActivityExpandState getState() {
            return this.state;
        }

        private InteractionActivityExpandEvent(AssistantActivityExpandState r100) {
            super(null);
            this.state = r100;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "<init>", "(Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;)V", "getState", "()Lcom/obric/assistant/interaction/base/model/AssistantActivityVisibleState;", "VisibleEvent", "InvisibleEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$VisibleEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class InteractionActivityVisibleEvent extends InteractionEvent {
        private final AssistantActivityVisibleState state;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$InvisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class InvisibleEvent extends InteractionActivityVisibleEvent {
            public static final InvisibleEvent INSTANCE = null;

            static {
                INSTANCE = new InvisibleEvent();
            }

            private InvisibleEvent() {
                super(AssistantActivityVisibleState.INVISIBLE, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent$VisibleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionActivityVisibleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class VisibleEvent extends InteractionActivityVisibleEvent {
            public static final VisibleEvent INSTANCE = null;

            static {
                INSTANCE = new VisibleEvent();
            }

            private VisibleEvent() {
                super(AssistantActivityVisibleState.VISIBLE, null);
            }
        }

        public /* synthetic */ InteractionActivityVisibleEvent(AssistantActivityVisibleState r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public final AssistantActivityVisibleState getState() {
            return this.state;
        }

        private InteractionActivityVisibleEvent(AssistantActivityVisibleState r100) {
            super(null);
            this.state = r100;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "<init>", "(Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;)V", "getState", "()Lcom/obric/assistant/interaction/base/interact/KeyguardLockedState;", "LockedEvent", "UnlockedEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$LockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$UnlockedEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class InteractionKeyguardLockedEvent extends InteractionEvent {
        private final KeyguardLockedState state;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$LockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class LockedEvent extends InteractionKeyguardLockedEvent {
            public static final LockedEvent INSTANCE = null;

            static {
                INSTANCE = new LockedEvent();
            }

            private LockedEvent() {
                super(KeyguardLockedState.LOCKED, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent$UnlockedEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$InteractionKeyguardLockedEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class UnlockedEvent extends InteractionKeyguardLockedEvent {
            public static final UnlockedEvent INSTANCE = null;

            static {
                INSTANCE = new UnlockedEvent();
            }

            private UnlockedEvent() {
                super(KeyguardLockedState.UNLOCKED, null);
            }
        }

        public /* synthetic */ InteractionKeyguardLockedEvent(KeyguardLockedState r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public final KeyguardLockedState getState() {
            return this.state;
        }

        private InteractionKeyguardLockedEvent(KeyguardLockedState r100) {
            super(null);
            this.state = r100;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "state", "Lcom/obric/assistant/interaction/base/mode/MicMuteState;", "<init>", "(Lcom/obric/assistant/interaction/base/mode/MicMuteState;)V", "getState", "()Lcom/obric/assistant/interaction/base/mode/MicMuteState;", "MuteEvent", "UnmuteEvent", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent$MuteEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent$UnmuteEvent;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class MicMuteEvent extends InteractionEvent {
        private final MicMuteState state;

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent$MuteEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class MuteEvent extends MicMuteEvent {
            public static final MuteEvent INSTANCE = null;

            static {
                INSTANCE = new MuteEvent();
            }

            private MuteEvent() {
                super(MicMuteState.MUTE, null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent$UnmuteEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$MicMuteEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class UnmuteEvent extends MicMuteEvent {
            public static final UnmuteEvent INSTANCE = null;

            static {
                INSTANCE = new UnmuteEvent();
            }

            private UnmuteEvent() {
                super(MicMuteState.UNMUTE, null);
            }
        }

        public /* synthetic */ MicMuteEvent(MicMuteState r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        public final MicMuteState getState() {
            return this.state;
        }

        private MicMuteEvent(MicMuteState r100) {
            super(null);
            this.state = r100;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u001f\b\u0004\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent;", "args", "", "", "", "<init>", "(Ljava/util/Map;)V", "ShowSession", "HideSession", "CreateSession", "PrepareSession", "DestroySession", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$CreateSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$DestroySession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$HideSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$PrepareSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$ShowSession;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static abstract class SessionLifecycleEvent extends InteractionEvent {

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$CreateSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class CreateSession extends SessionLifecycleEvent {
            /* JADX WARN: Multi-variable type inference failed */
            public CreateSession() {
                super(null, 1, 0 == true ? 1 : 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$DestroySession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class DestroySession extends SessionLifecycleEvent {
            /* JADX WARN: Multi-variable type inference failed */
            public DestroySession() {
                super(null, 1, 0 == true ? 1 : 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$HideSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class HideSession extends SessionLifecycleEvent {
            /* JADX WARN: Multi-variable type inference failed */
            public HideSession() {
                super(null, 1, 0 == true ? 1 : 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$PrepareSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class PrepareSession extends SessionLifecycleEvent {
            /* JADX WARN: Multi-variable type inference failed */
            public PrepareSession() {
                super(null, 1, 0 == true ? 1 : 0);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent$ShowSession;", "Lcom/obric/assistant/interaction/base/model/InteractionEvent$SessionLifecycleEvent;", "<init>", "()V", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class ShowSession extends SessionLifecycleEvent {
            /* JADX WARN: Multi-variable type inference failed */
            public ShowSession() {
                super(null, 1, 0 == true ? 1 : 0);
            }
        }

        public /* synthetic */ SessionLifecycleEvent(Map r100, DefaultConstructorMarker r101) {
            this(r100);
        }

        private SessionLifecycleEvent(Map<String, ? extends Object> r100) {
            super(null);
        }

        public /* synthetic */ SessionLifecycleEvent(Map r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = MapsKt.emptyMap();
        L5:
            this(r100, null);
        }
    }

    private InteractionEvent() {
    }

    public /* synthetic */ InteractionEvent(DefaultConstructorMarker r100) {
        this();
    }
}
