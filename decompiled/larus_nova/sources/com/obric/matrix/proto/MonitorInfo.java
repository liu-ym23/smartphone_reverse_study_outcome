package com.obric.matrix.proto;

import com.google.gson.annotations.SerializedName;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes33.dex */
public final class MonitorInfo extends Message<MonitorInfo, Builder> {
    public static final ProtoAdapter<MonitorInfo> ADAPTER = null;
    public static final Long DEFAULT_MATRIXBINDPROCESSENDTIME = null;
    public static final Long DEFAULT_MATRIXBINDREVTIME = null;
    public static final Long DEFAULT_THIRDJAVAJNICALLTIME = null;
    public static final Long DEFAULT_THIRDJAVAREVRESRESULT = null;
    public static final Long DEFAULT_THIRDSTARTTIME = null;
    private static final long serialVersionUID = 0;

    @SerializedName("matrixBindProcessEndTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 4)
    public final Long matrixBindProcessEndTime;

    @SerializedName("matrixBindRevTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 3)
    public final Long matrixBindRevTime;

    @SerializedName("thirdJavaJniCallTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 2)
    public final Long thirdJavaJniCallTime;

    @SerializedName("thirdJavaRevResResult")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 5)
    public final Long thirdJavaRevResResult;

    @SerializedName("thirdStartTime")
    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", tag = 1)
    public final Long thirdStartTime;

    public static final class Builder extends Message.Builder<MonitorInfo, Builder> {
        public Long matrixBindProcessEndTime;
        public Long matrixBindRevTime;
        public Long thirdJavaJniCallTime;
        public Long thirdJavaRevResResult;
        public Long thirdStartTime;

        @Override // com.squareup.wire.Message.Builder
        public MonitorInfo build() {
            return new MonitorInfo(this.thirdStartTime, this.thirdJavaJniCallTime, this.matrixBindRevTime, this.matrixBindProcessEndTime, this.thirdJavaRevResResult, super.buildUnknownFields());
        }

        public Builder() {
            this.thirdStartTime = 0L;
            this.thirdJavaJniCallTime = 0L;
            this.matrixBindRevTime = 0L;
            this.matrixBindProcessEndTime = 0L;
            this.thirdJavaRevResResult = 0L;
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder matrixBindProcessEndTime(Long r100) {
            this.matrixBindProcessEndTime = r100;
            return this;
        }

        public Builder matrixBindRevTime(Long r100) {
            this.matrixBindRevTime = r100;
            return this;
        }

        public Builder thirdJavaJniCallTime(Long r100) {
            this.thirdJavaJniCallTime = r100;
            return this;
        }

        public Builder thirdJavaRevResResult(Long r100) {
            this.thirdJavaRevResResult = r100;
            return this;
        }

        public Builder thirdStartTime(Long r100) {
            this.thirdStartTime = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MonitorInfo extends ProtoAdapter<MonitorInfo> {
        public ProtoAdapter_MonitorInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MonitorInfo.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MonitorInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.thirdStartTime(ProtoAdapter.INT64.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.thirdJavaJniCallTime(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.matrixBindRevTime(ProtoAdapter.INT64.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.matrixBindProcessEndTime(ProtoAdapter.INT64.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.thirdJavaRevResResult(ProtoAdapter.INT64.decode(r100));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MonitorInfo r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return ((((r101.encodedSizeWithTag(1, r100.thirdStartTime) + r101.encodedSizeWithTag(2, r100.thirdJavaJniCallTime)) + r101.encodedSizeWithTag(3, r100.matrixBindRevTime)) + r101.encodedSizeWithTag(4, r100.matrixBindProcessEndTime)) + r101.encodedSizeWithTag(5, r100.thirdJavaRevResResult)) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public MonitorInfo redact2(MonitorInfo r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MonitorInfo r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MonitorInfo redact(MonitorInfo r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MonitorInfo r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.thirdStartTime);
            r102.encodeWithTag(r100, 2, r101.thirdJavaJniCallTime);
            r102.encodeWithTag(r100, 3, r101.matrixBindRevTime);
            r102.encodeWithTag(r100, 4, r101.matrixBindProcessEndTime);
            r102.encodeWithTag(r100, 5, r101.thirdJavaRevResResult);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MonitorInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MonitorInfo();
        DEFAULT_THIRDSTARTTIME = 0L;
        DEFAULT_THIRDJAVAJNICALLTIME = 0L;
        DEFAULT_MATRIXBINDREVTIME = 0L;
        DEFAULT_MATRIXBINDPROCESSENDTIME = 0L;
        DEFAULT_THIRDJAVAREVRESRESULT = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L25;
        int r101 = unknownFields().hashCode() * 37;
        Long r102 = this.thirdStartTime;
        int r103 = 0;
        if (r102 == null) goto L7;
        int r104 = r102.hashCode();
    L8:
        int r105 = (r101 + r104) * 37;
        Long r106 = this.thirdJavaJniCallTime;
        if (r106 == null) goto L11;
        int r107 = r106.hashCode();
    L12:
        int r108 = (r105 + r107) * 37;
        Long r109 = this.matrixBindRevTime;
        if (r109 == null) goto L15;
        int r110 = r109.hashCode();
    L16:
        int r111 = (r108 + r110) * 37;
        Long r112 = this.matrixBindProcessEndTime;
        if (r112 == null) goto L19;
        int r113 = r112.hashCode();
    L20:
        int r114 = (r111 + r113) * 37;
        Long r115 = this.thirdJavaRevResResult;
        if (r115 == null) goto L23;
        r103 = r115.hashCode();
    L23:
        int r116 = r114 + r103;
        this.hashCode = r116;
        return r116;
    L19:
        r113 = 0;
        goto L20
    L15:
        r110 = 0;
        goto L16
    L11:
        r107 = 0;
        goto L12
    L7:
        r104 = 0;
        goto L8
    L25:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.thirdStartTime = this.thirdStartTime;
        r100.thirdJavaJniCallTime = this.thirdJavaJniCallTime;
        r100.matrixBindRevTime = this.matrixBindRevTime;
        r100.matrixBindProcessEndTime = this.matrixBindProcessEndTime;
        r100.thirdJavaRevResResult = this.thirdJavaRevResResult;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        if (this.thirdStartTime == null) goto L6;
        r100.append(", thirdStartTime=");
        r100.append(this.thirdStartTime);
    L6:
        if (this.thirdJavaJniCallTime == null) goto L9;
        r100.append(", thirdJavaJniCallTime=");
        r100.append(this.thirdJavaJniCallTime);
    L9:
        if (this.matrixBindRevTime == null) goto L12;
        r100.append(", matrixBindRevTime=");
        r100.append(this.matrixBindRevTime);
    L12:
        if (this.matrixBindProcessEndTime == null) goto L15;
        r100.append(", matrixBindProcessEndTime=");
        r100.append(this.matrixBindProcessEndTime);
    L15:
        if (this.thirdJavaRevResResult == null) goto L17;
        r100.append(", thirdJavaRevResResult=");
        r100.append(this.thirdJavaRevResResult);
    L17:
        StringBuilder r101 = r100.replace(0, 2, "MonitorInfo{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof MonitorInfo) == true) goto L8;
        return false;
    L8:
        MonitorInfo r101 = (MonitorInfo) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L21:
        return false;
    L11:
        if (Internal.equals(this.thirdStartTime, r101.thirdStartTime) == false) goto L21;
        if (Internal.equals(this.thirdJavaJniCallTime, r101.thirdJavaJniCallTime) == false) goto L21;
        if (Internal.equals(this.matrixBindRevTime, r101.matrixBindRevTime) == false) goto L21;
        if (Internal.equals(this.matrixBindProcessEndTime, r101.matrixBindProcessEndTime) == false) goto L21;
        if (Internal.equals(this.thirdJavaRevResResult, r101.thirdJavaRevResResult) == false) goto L21;
        return true;
    }

    public MonitorInfo(Long r100, Long r101, Long r110, Long r111, Long r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public MonitorInfo(Long r100, Long r101, Long r102, Long r103, Long r104, ByteString r105) {
        super(ADAPTER, r105);
        this.thirdStartTime = r100;
        this.thirdJavaJniCallTime = r101;
        this.matrixBindRevTime = r102;
        this.matrixBindProcessEndTime = r103;
        this.thirdJavaRevResResult = r104;
    }
}
