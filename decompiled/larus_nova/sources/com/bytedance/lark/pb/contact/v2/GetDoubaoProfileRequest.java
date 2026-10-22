package com.bytedance.lark.pb.contact.v2;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import java.io.IOException;
import okio.ByteString;
import r27.a;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetDoubaoProfileRequest extends Message<GetDoubaoProfileRequest, Builder> {
    public static final ProtoAdapter<GetDoubaoProfileRequest> ADAPTER = null;
    public static final DoubaoProfileEdition DEFAULT_EDITION = null;
    public static final SyncDataStrategy DEFAULT_SYNC_DATA_STRATEGY = null;
    public static final String DEFAULT_TOKEN = "";
    public static final String DEFAULT_USER_ID = "";
    public static final ProtoAdapter_GetDoubaoProfileRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final DoubaoProfileEdition edition;
    public final SyncDataStrategy sync_data_strategy;
    public final String token;
    public final String user_id;

    public static final class Builder extends Message.Builder<GetDoubaoProfileRequest, Builder> implements d<GetDoubaoProfileRequest> {
        public DoubaoProfileEdition edition;
        public SyncDataStrategy sync_data_strategy;
        public String token;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public GetDoubaoProfileRequest build() {
            return new GetDoubaoProfileRequest(this.user_id, this.token, this.sync_data_strategy, this.edition, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder edition(DoubaoProfileEdition r100) {
            this.edition = r100;
            return this;
        }

        public Builder sync_data_strategy(SyncDataStrategy r100) {
            this.sync_data_strategy = r100;
            return this;
        }

        public Builder token(String r100) {
            this.token = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final enum DoubaoProfileEdition extends Enum<DoubaoProfileEdition> implements WireEnum {
        private static final /* synthetic */ DoubaoProfileEdition[] $VALUES = null;
        public static final ProtoAdapter<DoubaoProfileEdition> ADAPTER = null;
        public static final DoubaoProfileEdition EDITION_ENTERPRISE = null;
        public static final DoubaoProfileEdition EDITION_PERSONAL = null;
        public static final DoubaoProfileEdition EDITION_UNKNOWN = null;
        private final int value;

        static {
            DoubaoProfileEdition r100 = new DoubaoProfileEdition("EDITION_UNKNOWN", 0, 0);
            EDITION_UNKNOWN = r100;
            DoubaoProfileEdition r101 = new DoubaoProfileEdition("EDITION_PERSONAL", 1, 1);
            EDITION_PERSONAL = r101;
            DoubaoProfileEdition r102 = new DoubaoProfileEdition("EDITION_ENTERPRISE", 2, 2);
            EDITION_ENTERPRISE = r102;
            $VALUES = new DoubaoProfileEdition[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(DoubaoProfileEdition.class);
        }

        public static DoubaoProfileEdition[] values() {
            return (DoubaoProfileEdition[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static DoubaoProfileEdition fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return EDITION_ENTERPRISE;
        L12:
            return EDITION_PERSONAL;
        L14:
            return EDITION_UNKNOWN;
        }

        public static DoubaoProfileEdition valueOf(String r100) {
            return (DoubaoProfileEdition) a.a(DoubaoProfileEdition.class, r100);
        }

        private DoubaoProfileEdition(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_GetDoubaoProfileRequest extends ProtoAdapter<GetDoubaoProfileRequest> implements c<GetDoubaoProfileRequest> {
        public ProtoAdapter_GetDoubaoProfileRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDoubaoProfileRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDoubaoProfileRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.token = "";
            r101.sync_data_strategy = SyncDataStrategy.LOCAL;
            r101.edition = DoubaoProfileEdition.EDITION_UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.sync_data_strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.edition = DoubaoProfileEdition.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDoubaoProfileRequest r100) {
            String r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.token;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            SyncDataStrategy r107 = r100.sync_data_strategy;
            if (r107 == null) goto L13;
            int r108 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            DoubaoProfileEdition r110 = r100.edition;
            if (r110 == null) goto L18;
            r102 = DoubaoProfileEdition.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDoubaoProfileRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDoubaoProfileRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDoubaoProfileRequest r101) throws IOException {
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.token;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            SyncDataStrategy r104 = r101.sync_data_strategy;
            if (r104 == null) goto L11;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            DoubaoProfileEdition r105 = r101.edition;
            if (r105 == null) goto L14;
            DoubaoProfileEdition.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDoubaoProfileRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDoubaoProfileRequest r100 = new ProtoAdapter_GetDoubaoProfileRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SYNC_DATA_STRATEGY = SyncDataStrategy.LOCAL;
        DEFAULT_EDITION = DoubaoProfileEdition.EDITION_UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.token = this.token;
        r100.sync_data_strategy = this.sync_data_strategy;
        r100.edition = this.edition;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDoubaoProfileRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDoubaoProfileRequest(String r100, String r101, SyncDataStrategy r102, DoubaoProfileEdition r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetDoubaoProfileRequest(String r100, String r101, SyncDataStrategy r102, DoubaoProfileEdition r103, ByteString r104) {
        super(ADAPTER, r104);
        this.user_id = r100;
        this.token = r101;
        this.sync_data_strategy = r102;
        this.edition = r103;
    }
}
