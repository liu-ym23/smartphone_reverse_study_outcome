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
public final class EvaluateUkDeleteRequest extends Message<EvaluateUkDeleteRequest, Builder> {
    public static final ProtoAdapter<EvaluateUkDeleteRequest> ADAPTER = null;
    public static final MessageOptions MESSAGE_OPTIONS = null;
    public static final ProtoAdapter_EvaluateUkDeleteRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<EvaluateUkInfo> evaluate_infos;

    public static final class Builder extends Message.Builder<EvaluateUkDeleteRequest, Builder> implements d<EvaluateUkDeleteRequest> {
        public List<EvaluateUkInfo> evaluate_infos;

        @Override // com.squareup.wire.Message.Builder
        public EvaluateUkDeleteRequest build() {
            return new EvaluateUkDeleteRequest(this.evaluate_infos, super.buildUnknownFields());
        }

        public Builder() {
            this.evaluate_infos = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder evaluate_infos(List<EvaluateUkInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.evaluate_infos = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_EvaluateUkDeleteRequest extends ProtoAdapter<EvaluateUkDeleteRequest> implements c<EvaluateUkDeleteRequest> {
        public ProtoAdapter_EvaluateUkDeleteRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, EvaluateUkDeleteRequest.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public EvaluateUkDeleteRequest decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.evaluate_infos.add(EvaluateUkInfo.ADAPTER.decode(r100));
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
        public int encodedSize2(EvaluateUkDeleteRequest r100) {
            return EvaluateUkInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.evaluate_infos) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ EvaluateUkDeleteRequest decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(EvaluateUkDeleteRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, EvaluateUkDeleteRequest r101) throws IOException {
            EvaluateUkInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.evaluate_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, EvaluateUkDeleteRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_EvaluateUkDeleteRequest r100 = new ProtoAdapter_EvaluateUkDeleteRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        MESSAGE_OPTIONS = new MessageOptions.Builder().message_options(new OptionsExt.Builder().serde(Boolean.TRUE).build()).build();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.evaluate_infos = Internal.copyOf("evaluate_infos", this.evaluate_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return EvaluateUkDeleteRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public EvaluateUkDeleteRequest(List<EvaluateUkInfo> r100) {
        this(r100, ByteString.EMPTY);
    }

    public EvaluateUkDeleteRequest(List<EvaluateUkInfo> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.evaluate_infos = Internal.immutableCopyOf("evaluate_infos", r100);
    }
}
