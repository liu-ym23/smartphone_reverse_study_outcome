package com.bytedance.badger.data;

import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0003\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult;", "", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Failure", "Success", "Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult$Failure;", "badger-api_release"}, k = 1, mv = {1, 4, 0})
public abstract class BadgerResult {
    public static final a Companion = null;
    public static final int ERROR = -1000;
    public static final int ERROR_AWAIT_TIMEOUT = -2001;
    public static final int SUCCESS = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Failure;", "Lcom/bytedance/badger/data/BadgerResult;", "errorCode", "", "errorMsg", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMsg", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "badger-api_release"}, k = 1, mv = {1, 1, 15})
    public static final class Failure extends BadgerResult {
        private final int errorCode;
        private final String errorMsg;

        public static /* synthetic */ Failure copy$default(Failure r100, int r101, String r102, int r103, Object r104) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.errorCode;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.errorMsg;
        L9:
            return r100.copy(r101, r102);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.errorMsg;
        }

        public final Failure copy(int r100, String r101) {
            return new Failure(r100, r101);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L5;
        L15:
            return true;
        L5:
            if ((r100 instanceof Failure) == false) goto L14;
            Failure r101 = (Failure) r100;
            if (this.errorCode != r101.errorCode) goto L9;
            boolean r102 = true;
        L10:
            if (r102 == false) goto L14;
            if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == false) goto L14;
        L9:
            r102 = false;
        L14:
            return false;
        }

        public int hashCode() {
            int r100 = this.errorCode * 31;
            String r101 = this.errorMsg;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public String toString() {
            return "Failure(errorCode=" + this.errorCode + ", errorMsg=" + this.errorMsg + ")";
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public Failure(int r100, String r101) {
            super(null);
            this.errorCode = r100;
            this.errorMsg = r101;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/bytedance/badger/data/BadgerResult$Success;", "Lcom/bytedance/badger/data/BadgerResult;", "data", "Lcom/bytedance/badger/data/IBadgerData;", "(Lcom/bytedance/badger/data/IBadgerData;)V", "getData", "()Lcom/bytedance/badger/data/IBadgerData;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "badger-api_release"}, k = 1, mv = {1, 1, 15})
    public static final class Success extends BadgerResult {
        private final IBadgerData data;

        public static /* synthetic */ Success copy$default(Success r100, IBadgerData r101, int r102, Object r103) {
            if ((r102 & 1) == 0) goto L6;
            r101 = r100.data;
        L6:
            return r100.copy(r101);
        }

        public final IBadgerData component1() {
            return this.data;
        }

        public final Success copy(IBadgerData r100) {
            return new Success(r100);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Success) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.data, ((Success) r100).data) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public int hashCode() {
            IBadgerData r100 = this.data;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }

        public final IBadgerData getData() {
            return this.data;
        }

        public Success(IBadgerData r100) {
            super(null);
            this.data = r100;
        }
    }

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    private BadgerResult() {
    }

    public /* synthetic */ BadgerResult(DefaultConstructorMarker r100) {
        this();
    }
}
