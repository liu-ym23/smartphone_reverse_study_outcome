package inject_request.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes41.dex */
public final class MoltenFfiInstanceMsg extends Message<MoltenFfiInstanceMsg, Builder> {
    public static final ProtoAdapter<MoltenFfiInstanceMsg> ADAPTER = null;
    public static final Long DEFAULT_INSTANCE_ID = null;
    public static final Long DEFAULT_TYPE_ID = null;
    private static final long serialVersionUID = 0;
    public final Long instance_id;
    public final Long type_id;

    public static final class Builder extends Message.Builder<MoltenFfiInstanceMsg, Builder> {
        public Long instance_id;
        public Long type_id;

        @Override // com.squareup.wire.Message.Builder
        public MoltenFfiInstanceMsg build() {
            Long r100 = this.type_id;
            if (r100 == null) goto L9;
            if (this.instance_id == null) goto L9;
            return new MoltenFfiInstanceMsg(this.type_id, this.instance_id, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "type_id", this.instance_id, "instance_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder instance_id(Long r100) {
            this.instance_id = r100;
            return this;
        }

        public Builder type_id(Long r100) {
            this.type_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MoltenFfiInstanceMsg extends ProtoAdapter<MoltenFfiInstanceMsg> {
        public ProtoAdapter_MoltenFfiInstanceMsg() {
            super(FieldEncoding.LENGTH_DELIMITED, MoltenFfiInstanceMsg.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MoltenFfiInstanceMsg decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.type_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.instance_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MoltenFfiInstanceMsg r100) {
            ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
            return (r101.encodedSizeWithTag(1, r100.type_id) + r101.encodedSizeWithTag(2, r100.instance_id)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MoltenFfiInstanceMsg decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MoltenFfiInstanceMsg r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MoltenFfiInstanceMsg r101) throws IOException {
            ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
            r102.encodeWithTag(r100, 1, r101.type_id);
            r102.encodeWithTag(r100, 2, r101.instance_id);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MoltenFfiInstanceMsg r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MoltenFfiInstanceMsg();
        DEFAULT_TYPE_ID = 0L;
        DEFAULT_INSTANCE_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.type_id = this.type_id;
        r100.instance_id = this.instance_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MoltenFfiInstanceMsg.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MoltenFfiInstanceMsg(Long r100, Long r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MoltenFfiInstanceMsg(Long r100, Long r101, ByteString r102) {
        super(ADAPTER, r102);
        this.type_id = r100;
        this.instance_id = r101;
    }
}
