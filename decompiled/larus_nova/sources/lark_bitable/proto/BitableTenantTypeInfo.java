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
public final class BitableTenantTypeInfo extends Message<BitableTenantTypeInfo, Builder> {
    public static final ProtoAdapter<BitableTenantTypeInfo> ADAPTER = null;
    public static final Boolean DEFAULT_SOLO_BASE = null;
    public static final Boolean DEFAULT_SOLO_USER = null;
    private static final long serialVersionUID = 0;
    public final Boolean solo_base;
    public final Boolean solo_user;

    public static final class Builder extends Message.Builder<BitableTenantTypeInfo, Builder> {
        public Boolean solo_base;
        public Boolean solo_user;

        @Override // com.squareup.wire.Message.Builder
        public BitableTenantTypeInfo build() {
            Boolean r100 = this.solo_user;
            if (r100 == null) goto L9;
            if (this.solo_base == null) goto L9;
            return new BitableTenantTypeInfo(this.solo_user, this.solo_base, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "solo_user", this.solo_base, "solo_base"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder solo_base(Boolean r100) {
            this.solo_base = r100;
            return this;
        }

        public Builder solo_user(Boolean r100) {
            this.solo_user = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BitableTenantTypeInfo extends ProtoAdapter<BitableTenantTypeInfo> {
        public ProtoAdapter_BitableTenantTypeInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, BitableTenantTypeInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public BitableTenantTypeInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.solo_user = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.solo_base = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(BitableTenantTypeInfo r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            return (r101.encodedSizeWithTag(1, r100.solo_user) + r101.encodedSizeWithTag(2, r100.solo_base)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BitableTenantTypeInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BitableTenantTypeInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BitableTenantTypeInfo r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.solo_user);
            r102.encodeWithTag(r100, 2, r101.solo_base);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BitableTenantTypeInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BitableTenantTypeInfo();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SOLO_USER = r100;
        DEFAULT_SOLO_BASE = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.solo_user = this.solo_user;
        r100.solo_base = this.solo_base;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return BitableTenantTypeInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BitableTenantTypeInfo(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public BitableTenantTypeInfo(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.solo_user = r100;
        this.solo_base = r101;
    }
}
