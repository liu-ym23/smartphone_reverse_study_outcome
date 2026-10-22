package com.ss.android.lark.pb.compliance;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MGetIMFileRiskTagResponse extends Message<MGetIMFileRiskTagResponse, Builder> {
    public static final ProtoAdapter<MGetIMFileRiskTagResponse> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<IMFileRiskTag> mresult;

    public static final class Builder extends Message.Builder<MGetIMFileRiskTagResponse, Builder> {
        public List<IMFileRiskTag> mresult;

        @Override // com.squareup.wire.Message.Builder
        public MGetIMFileRiskTagResponse build() {
            return new MGetIMFileRiskTagResponse(this.mresult, super.buildUnknownFields());
        }

        public Builder() {
            this.mresult = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder result(List<IMFileRiskTag> r100) {
            Internal.checkElementsNotNull(r100);
            this.mresult = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetIMFileRiskTagResponse extends ProtoAdapter<MGetIMFileRiskTagResponse> {
        public ProtoAdapter_MGetIMFileRiskTagResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetIMFileRiskTagResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetIMFileRiskTagResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mresult.add(IMFileRiskTag.ADAPTER.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetIMFileRiskTagResponse r100) {
            return IMFileRiskTag.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mresult) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetIMFileRiskTagResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetIMFileRiskTagResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetIMFileRiskTagResponse r101) throws IOException {
            IMFileRiskTag.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mresult);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetIMFileRiskTagResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MGetIMFileRiskTagResponse();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mresult = Internal.copyOf("mresult", this.mresult);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetIMFileRiskTagResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetIMFileRiskTagResponse(List<IMFileRiskTag> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetIMFileRiskTagResponse(List<IMFileRiskTag> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mresult = Internal.immutableCopyOf("mresult", r100);
    }
}
