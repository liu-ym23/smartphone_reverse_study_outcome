package com.ss.android.lark.pb.improto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PutSameDeviceJudgeInfoRequest extends Message<PutSameDeviceJudgeInfoRequest, Builder> {
    public static final ProtoAdapter<PutSameDeviceJudgeInfoRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final SameDeviceJudgeItem mitem;

    public static final class Builder extends Message.Builder<PutSameDeviceJudgeInfoRequest, Builder> {
        public SameDeviceJudgeItem mitem;

        @Override // com.squareup.wire.Message.Builder
        public PutSameDeviceJudgeInfoRequest build() {
            SameDeviceJudgeItem r100 = this.mitem;
            if (r100 == null) goto L7;
            return new PutSameDeviceJudgeInfoRequest(this.mitem, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "mitem"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder item(SameDeviceJudgeItem r100) {
            this.mitem = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutSameDeviceJudgeInfoRequest extends ProtoAdapter<PutSameDeviceJudgeInfoRequest> {
        public ProtoAdapter_PutSameDeviceJudgeInfoRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutSameDeviceJudgeInfoRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutSameDeviceJudgeInfoRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mitem = SameDeviceJudgeItem.ADAPTER.decode(r100);
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
        public int encodedSize2(PutSameDeviceJudgeInfoRequest r100) {
            return SameDeviceJudgeItem.ADAPTER.encodedSizeWithTag(1, r100.mitem) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutSameDeviceJudgeInfoRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutSameDeviceJudgeInfoRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutSameDeviceJudgeInfoRequest r101) throws IOException {
            SameDeviceJudgeItem.ADAPTER.encodeWithTag(r100, 1, r101.mitem);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutSameDeviceJudgeInfoRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutSameDeviceJudgeInfoRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mitem = this.mitem;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutSameDeviceJudgeInfoRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutSameDeviceJudgeInfoRequest(SameDeviceJudgeItem r100) {
        this(r100, ByteString.EMPTY);
    }

    public PutSameDeviceJudgeInfoRequest(SameDeviceJudgeItem r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mitem = r100;
    }
}
