package com.larus.livetutor.impl.rtc.adpter;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes30.dex */
public abstract class CustomConnectedStatus implements ij9.a {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus$Idle;", "Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Idle extends CustomConnectedStatus {
        public static final Idle INSTANCE = null;

        static {
            INSTANCE = new Idle();
        }

        private Idle() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus$Listening;", "Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Listening extends CustomConnectedStatus {
        public static final Listening INSTANCE = null;

        static {
            INSTANCE = new Listening();
        }

        private Listening() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus$Speaking;", "Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Speaking extends CustomConnectedStatus {
        public static final Speaking INSTANCE = null;

        static {
            INSTANCE = new Speaking();
        }

        private Speaking() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus$Thinking;", "Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Thinking extends CustomConnectedStatus {
        public static final Thinking INSTANCE = null;

        static {
            INSTANCE = new Thinking();
        }

        private Thinking() {
            super(null);
        }
    }

    private CustomConnectedStatus() {
    }

    public /* synthetic */ CustomConnectedStatus(DefaultConstructorMarker r100) {
        this();
    }
}
