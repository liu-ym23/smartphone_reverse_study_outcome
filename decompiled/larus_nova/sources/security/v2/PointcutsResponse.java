package security.v2;

import annotation.OptionsExt;
import com.google.protobuf.MessageOptions;
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

/* JADX INFO: loaded from: classes41.dex */
public final class PointcutsResponse extends Message<PointcutsResponse, Builder> {
    public static final ProtoAdapter<PointcutsResponse> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_PointcutsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<PointCut> pointcuts;

    public static final class Builder extends Message.Builder<PointcutsResponse, Builder> implements d<PointcutsResponse> {
        public List<PointCut> pointcuts;

        @Override // com.squareup.wire.Message.Builder
        public PointcutsResponse build() {
            return new PointcutsResponse(this.pointcuts, super.buildUnknownFields());
        }

        public Builder() {
            this.pointcuts = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder pointcuts(List<PointCut> r100) {
            Internal.checkElementsNotNull(r100);
            this.pointcuts = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PointcutsResponse extends ProtoAdapter<PointcutsResponse> implements c<PointcutsResponse> {
        public ProtoAdapter_PointcutsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, PointcutsResponse.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public PointcutsResponse decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.pointcuts.add(PointCut.ADAPTER.decode(r100));
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
        public int encodedSize2(PointcutsResponse r100) {
            return PointCut.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.pointcuts) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PointcutsResponse decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PointcutsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PointcutsResponse r101) throws IOException {
            PointCut.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.pointcuts);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PointcutsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PointcutsResponse r100 = new ProtoAdapter_PointcutsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pointcuts = Internal.copyOf("pointcuts", this.pointcuts);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PointcutsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PointcutsResponse(List<PointCut> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PointcutsResponse(List<PointCut> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.pointcuts = Internal.immutableCopyOf("pointcuts", r100);
    }
}
