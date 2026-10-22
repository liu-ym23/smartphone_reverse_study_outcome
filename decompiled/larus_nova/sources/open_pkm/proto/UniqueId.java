package open_pkm.proto;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class UniqueId extends Message<UniqueId, Builder> {
    public static final ProtoAdapter<UniqueId> ADAPTER = null;
    public static final String DEFAULT_APP_ID = "";
    public static final PkmBizType DEFAULT_BIZ_TYPE = null;
    public static final String DEFAULT_IDENTIFIER = "";
    private static final long serialVersionUID = 0;
    public final String app_id;
    public final PkmBizType biz_type;
    public final String identifier;

    public static final class Builder extends Message.Builder<UniqueId, Builder> {
        public String app_id;
        public PkmBizType biz_type;
        public String identifier;

        @Override // com.squareup.wire.Message.Builder
        public UniqueId build() {
            String r100 = this.app_id;
            if (r100 == null) goto L11;
            if (this.identifier == null) goto L11;
            if (this.biz_type == null) goto L11;
            return new UniqueId(this.app_id, this.identifier, this.biz_type, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_id", this.identifier, LocationMonitorConst.IDENTIFIER, this.biz_type, "biz_type"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(String r100) {
            this.app_id = r100;
            return this;
        }

        public Builder biz_type(PkmBizType r100) {
            this.biz_type = r100;
            return this;
        }

        public Builder identifier(String r100) {
            this.identifier = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UniqueId extends ProtoAdapter<UniqueId> {
        public ProtoAdapter_UniqueId() {
            super(FieldEncoding.LENGTH_DELIMITED, UniqueId.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public UniqueId decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.identifier = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.biz_type = PkmBizType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(UniqueId r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.app_id) + r101.encodedSizeWithTag(2, r100.identifier)) + PkmBizType.ADAPTER.encodedSizeWithTag(3, r100.biz_type)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UniqueId decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UniqueId r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UniqueId r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.app_id);
            r102.encodeWithTag(r100, 2, r101.identifier);
            PkmBizType.ADAPTER.encodeWithTag(r100, 3, r101.biz_type);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UniqueId r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_UniqueId();
        DEFAULT_BIZ_TYPE = PkmBizType.VAR_PKM_BIZ_TYPE_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.identifier = this.identifier;
        r100.biz_type = this.biz_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UniqueId.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UniqueId(String r100, String r101, PkmBizType r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public UniqueId(String r100, String r101, PkmBizType r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_id = r100;
        this.identifier = r101;
        this.biz_type = r102;
    }
}
