package com.larus.livetutor.impl.rtc.adpter;

import com.larus.livetutor.api.idl.WaitUserAnswerMsg;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class LiveTutorConnectedStatus implements ij9.a {
    private final BaseConnectedMsg baseMsg;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Idle;", "Lcom/larus/livetutor/impl/rtc/adpter/CustomConnectedStatus;", "<init>", "()V", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Idle extends CustomConnectedStatus {
        public static final Idle INSTANCE = null;

        static {
            INSTANCE = new Idle();
        }

        private Idle() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Listening;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "baseMsg", "Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "<init>", "(Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;)V", "getBaseMsg", "()Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Listening extends LiveTutorConnectedStatus {
        private final BaseConnectedMsg baseMsg;

        /* JADX WARN: Multi-variable type inference failed */
        public Listening() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Listening copy$default(Listening r100, BaseConnectedMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.baseMsg;
        L6:
            return r100.copy(r101);
        }

        public final BaseConnectedMsg component1() {
            return this.baseMsg;
        }

        public final Listening copy(BaseConnectedMsg r100) {
            return new Listening(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Listening) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.baseMsg, ((Listening) r100).baseMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            BaseConnectedMsg r100 = this.baseMsg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "Listening(baseMsg=" + this.baseMsg + ')';
        }

        @Override // com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus
        public BaseConnectedMsg getBaseMsg() {
            return this.baseMsg;
        }

        public Listening(BaseConnectedMsg r100) {
            super(r100, null);
            this.baseMsg = r100;
        }

        public /* synthetic */ Listening(BaseConnectedMsg r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = null;
        L5:
            this(r100);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000fJ\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J:\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Loading;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "streamId", "", "loadingStep", "", "baseMsg", "Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "reloadLoadingAnim", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;Z)V", "getStreamId", "()Ljava/lang/String;", "getLoadingStep", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getBaseMsg", "()Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "getReloadLoadingAnim", "()Z", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;Z)Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Loading;", "equals", "other", "", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Loading extends LiveTutorConnectedStatus {
        private final BaseConnectedMsg baseMsg;
        private final Integer loadingStep;
        private final boolean reloadLoadingAnim;
        private final String streamId;

        public static /* synthetic */ Loading copy$default(Loading r100, String r101, Integer r102, BaseConnectedMsg r103, boolean r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.streamId;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.loadingStep;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.baseMsg;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.reloadLoadingAnim;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final String component1() {
            return this.streamId;
        }

        public final Integer component2() {
            return this.loadingStep;
        }

        public final BaseConnectedMsg component3() {
            return this.baseMsg;
        }

        public final boolean component4() {
            return this.reloadLoadingAnim;
        }

        public final Loading copy(String r100, Integer r101, BaseConnectedMsg r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "baseMsg");
            return new Loading(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Loading) == true) goto L8;
            return false;
        L8:
            Loading r101 = (Loading) r100;
            if (Intrinsics.areEqual(this.streamId, r101.streamId) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.loadingStep, r101.loadingStep) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.baseMsg, r101.baseMsg) == true) goto L18;
            return false;
        L18:
            if (this.reloadLoadingAnim == r101.reloadLoadingAnim) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            String r100 = this.streamId;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.loadingStep;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            int r105 = (((r103 + r101) * 31) + this.baseMsg.hashCode()) * 31;
            if (this.reloadLoadingAnim == false) goto L13;
            int r106 = 1231;
        L15:
            return r105 + r106;
        L13:
            r106 = 1237;
            goto L15
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Loading(streamId=" + this.streamId + ", loadingStep=" + this.loadingStep + ", baseMsg=" + this.baseMsg + ", reloadLoadingAnim=" + this.reloadLoadingAnim + ')';
        }

        @Override // com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus
        public BaseConnectedMsg getBaseMsg() {
            return this.baseMsg;
        }

        public final Integer getLoadingStep() {
            return this.loadingStep;
        }

        public final boolean getReloadLoadingAnim() {
            return this.reloadLoadingAnim;
        }

        public final String getStreamId() {
            return this.streamId;
        }

        public Loading(String r100, Integer r101, BaseConnectedMsg r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r102, "baseMsg");
            super(r102, null);
            this.streamId = r100;
            this.loadingStep = r101;
            this.baseMsg = r102;
            this.reloadLoadingAnim = r103;
        }

        public /* synthetic */ Loading(String r100, Integer r101, BaseConnectedMsg r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 8) == 0) goto L5;
            r103 = false;
        L5:
            this(r100, r101, r102, r103);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$RoundEnd;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "baseMsg", "Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "<init>", "(Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;)V", "getBaseMsg", "()Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class RoundEnd extends LiveTutorConnectedStatus {
        private final BaseConnectedMsg baseMsg;

        public static /* synthetic */ RoundEnd copy$default(RoundEnd r100, BaseConnectedMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.baseMsg;
        L6:
            return r100.copy(r101);
        }

        public final BaseConnectedMsg component1() {
            return this.baseMsg;
        }

        public final RoundEnd copy(BaseConnectedMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "baseMsg");
            return new RoundEnd(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof RoundEnd) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.baseMsg, ((RoundEnd) r100).baseMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.baseMsg.hashCode();
        }

        public String toString() {
            return "RoundEnd(baseMsg=" + this.baseMsg + ')';
        }

        @Override // com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus
        public BaseConnectedMsg getBaseMsg() {
            return this.baseMsg;
        }

        public RoundEnd(BaseConnectedMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "baseMsg");
            super(r100, null);
            this.baseMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Speaking;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "baseMsg", "Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "<init>", "(Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;)V", "getBaseMsg", "()Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Speaking extends LiveTutorConnectedStatus {
        private final BaseConnectedMsg baseMsg;

        public static /* synthetic */ Speaking copy$default(Speaking r100, BaseConnectedMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.baseMsg;
        L6:
            return r100.copy(r101);
        }

        public final BaseConnectedMsg component1() {
            return this.baseMsg;
        }

        public final Speaking copy(BaseConnectedMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "baseMsg");
            return new Speaking(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Speaking) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.baseMsg, ((Speaking) r100).baseMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.baseMsg.hashCode();
        }

        public String toString() {
            return "Speaking(baseMsg=" + this.baseMsg + ')';
        }

        @Override // com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus
        public BaseConnectedMsg getBaseMsg() {
            return this.baseMsg;
        }

        public Speaking(BaseConnectedMsg r100) {
            Intrinsics.checkNotNullParameter(r100, "baseMsg");
            super(r100, null);
            this.baseMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Thinking;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "baseMsg", "Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "showMsg", "", "<init>", "(Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;Z)V", "getBaseMsg", "()Lcom/larus/livetutor/impl/rtc/adpter/BaseConnectedMsg;", "getShowMsg", "()Z", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Thinking extends LiveTutorConnectedStatus {
        private final BaseConnectedMsg baseMsg;
        private final boolean showMsg;

        /* JADX WARN: Multi-variable type inference failed */
        public Thinking() {
            BaseConnectedMsg r100 = null;
            this(r100, false, 3, 0 == true ? 1 : 0);
        }

        public static /* synthetic */ Thinking copy$default(Thinking r100, BaseConnectedMsg r101, boolean r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.baseMsg;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.showMsg;
        L9:
            return r100.copy(r101, r102);
        }

        public final BaseConnectedMsg component1() {
            return this.baseMsg;
        }

        public final boolean component2() {
            return this.showMsg;
        }

        public final Thinking copy(BaseConnectedMsg r100, boolean r101) {
            return new Thinking(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Thinking) == true) goto L8;
            return false;
        L8:
            Thinking r101 = (Thinking) r100;
            if (Intrinsics.areEqual(this.baseMsg, r101.baseMsg) == true) goto L12;
            return false;
        L12:
            if (this.showMsg == r101.showMsg) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            BaseConnectedMsg r100 = this.baseMsg;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            if (this.showMsg == false) goto L9;
            int r103 = 1231;
        L11:
            return r102 + r103;
        L9:
            r103 = 1237;
            goto L11
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public String toString() {
            return "Thinking(baseMsg=" + this.baseMsg + ", showMsg=" + this.showMsg + ')';
        }

        @Override // com.larus.livetutor.impl.rtc.adpter.LiveTutorConnectedStatus
        public BaseConnectedMsg getBaseMsg() {
            return this.baseMsg;
        }

        public final boolean getShowMsg() {
            return this.showMsg;
        }

        public Thinking(BaseConnectedMsg r100, boolean r101) {
            super(r100, null);
            this.baseMsg = r100;
            this.showMsg = r101;
        }

        public /* synthetic */ Thinking(BaseConnectedMsg r100, boolean r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = true;
        L8:
            this(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus$Waiting;", "Lcom/larus/livetutor/impl/rtc/adpter/LiveTutorConnectedStatus;", "waitUserAnswerMsg", "Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "<init>", "(Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;)V", "getWaitUserAnswerMsg", "()Lcom/larus/livetutor/api/idl/WaitUserAnswerMsg;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Waiting extends LiveTutorConnectedStatus {
        private final WaitUserAnswerMsg waitUserAnswerMsg;

        public static /* synthetic */ Waiting copy$default(Waiting r100, WaitUserAnswerMsg r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.waitUserAnswerMsg;
        L6:
            return r100.copy(r101);
        }

        public final WaitUserAnswerMsg component1() {
            return this.waitUserAnswerMsg;
        }

        public final Waiting copy(WaitUserAnswerMsg r100) {
            return new Waiting(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof Waiting) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.waitUserAnswerMsg, ((Waiting) r100).waitUserAnswerMsg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            WaitUserAnswerMsg r100 = this.waitUserAnswerMsg;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public String toString() {
            return "Waiting(waitUserAnswerMsg=" + this.waitUserAnswerMsg + ')';
        }

        public final WaitUserAnswerMsg getWaitUserAnswerMsg() {
            return this.waitUserAnswerMsg;
        }

        public Waiting(WaitUserAnswerMsg r100) {
            DefaultConstructorMarker r101 = null;
            if (r100 == null) goto L5;
            Long r102 = r100.getTutorId();
        L6:
            if (r100 == null) goto L8;
            Long r103 = r100.getTutorRoundId();
        L9:
            if (r100 == null) goto L11;
            Long r104 = r100.getTutorPartId();
        L12:
            super(new BaseConnectedMsg(r102, r103, r104), r101);
            this.waitUserAnswerMsg = r100;
            return;
        L11:
            r104 = null;
            goto L12
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    public /* synthetic */ LiveTutorConnectedStatus(BaseConnectedMsg r100, DefaultConstructorMarker r101) {
        this(r100);
    }

    public BaseConnectedMsg getBaseMsg() {
        return this.baseMsg;
    }

    private LiveTutorConnectedStatus(BaseConnectedMsg r100) {
        this.baseMsg = r100;
    }
}
