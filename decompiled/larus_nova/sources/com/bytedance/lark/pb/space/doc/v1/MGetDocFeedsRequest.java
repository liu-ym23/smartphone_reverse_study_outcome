package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetDocFeedsRequest extends Message<MGetDocFeedsRequest, Builder> {
    public static final ProtoAdapter<MGetDocFeedsRequest> ADAPTER = null;
    public static final ProtoAdapter_MGetDocFeedsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> ids;

    public static final class Builder extends Message.Builder<MGetDocFeedsRequest, Builder> implements d<MGetDocFeedsRequest> {
        public List<String> ids;

        @Override // com.squareup.wire.Message.Builder
        public MGetDocFeedsRequest build() {
            return new MGetDocFeedsRequest(this.ids, super.buildUnknownFields());
        }

        public Builder() {
            this.ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetDocFeedsRequest extends ProtoAdapter<MGetDocFeedsRequest> implements c<MGetDocFeedsRequest> {
        public ProtoAdapter_MGetDocFeedsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetDocFeedsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetDocFeedsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(MGetDocFeedsRequest r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.ids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetDocFeedsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetDocFeedsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetDocFeedsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetDocFeedsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetDocFeedsRequest r100 = new ProtoAdapter_MGetDocFeedsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.ids = Internal.copyOf("ids", this.ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetDocFeedsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetDocFeedsRequest(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MGetDocFeedsRequest(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.ids = Internal.immutableCopyOf("ids", r100);
    }
}
