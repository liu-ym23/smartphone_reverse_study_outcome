package lark_bitable.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class StageModel extends Message<StageModel, Builder> {
    public static final ProtoAdapter<StageModel> ADAPTER = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final String name;

    public static final class Builder extends Message.Builder<StageModel, Builder> {
        public String name;

        @Override // com.squareup.wire.Message.Builder
        public StageModel build() {
            String r100 = this.name;
            if (r100 == null) goto L7;
            return new StageModel(this.name, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "name"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_StageModel extends ProtoAdapter<StageModel> {
        public ProtoAdapter_StageModel() {
            super(FieldEncoding.LENGTH_DELIMITED, StageModel.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public StageModel decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(StageModel r100) {
            return ProtoAdapter.STRING.encodedSizeWithTag(1, r100.name) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ StageModel decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(StageModel r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, StageModel r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.name);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, StageModel r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_StageModel();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return StageModel.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public StageModel(String r100) {
        this(r100, ByteString.EMPTY);
    }

    public StageModel(String r100, ByteString r101) {
        super(ADAPTER, r101);
        this.name = r100;
    }
}
