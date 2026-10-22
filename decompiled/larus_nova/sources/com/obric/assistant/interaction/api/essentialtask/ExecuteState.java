package com.obric.assistant.interaction.api.essentialtask;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0005\r\u000e\u000f\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "", "showText", "", "<init>", "(Ljava/lang/String;)V", "getShowText", "()Ljava/lang/String;", "NotStarted", "Executing", "WaitRetry", "Failed", "Succeed", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Executing;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Failed;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$NotStarted;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Succeed;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$WaitRetry;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class ExecuteState {
    private final String showText;

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Executing;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "showText", "", "<init>", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Executing extends ExecuteState {
        public Executing(String r100) {
            Intrinsics.checkNotNullParameter(r100, "showText");
            super(r100, null);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Failed;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "showText", "", "<init>", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Failed extends ExecuteState {
        public Failed(String r100) {
            Intrinsics.checkNotNullParameter(r100, "showText");
            super(r100, null);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$NotStarted;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "<init>", "()V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NotStarted extends ExecuteState {
        public NotStarted() {
            super("", null);
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$Succeed;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "<init>", "()V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Succeed extends ExecuteState {
        public Succeed() {
            super("", null);
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState$WaitRetry;", "Lcom/obric/assistant/interaction/api/essentialtask/ExecuteState;", "showText", "", "<init>", "(Ljava/lang/String;)V", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class WaitRetry extends ExecuteState {
        public WaitRetry(String r100) {
            Intrinsics.checkNotNullParameter(r100, "showText");
            super(r100, null);
        }
    }

    public /* synthetic */ ExecuteState(String r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public final String getShowText() {
        return this.showText;
    }

    private ExecuteState(String r100) {
        this.showText = r100;
    }
}
