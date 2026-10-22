package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
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
public final class DeriveMessagesToDocRequest extends Message<DeriveMessagesToDocRequest, Builder> {
    public static final ProtoAdapter<DeriveMessagesToDocRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_USER_TIME_ZONE = "";
    public static final FieldOptions FIELD_OPTIONS_MCHAT_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final List<Long> mmessage_ids;
    public final String muser_time_zone;

    public static final class Builder extends Message.Builder<DeriveMessagesToDocRequest, Builder> {
        public Long mchat_id;
        public List<Long> mmessage_ids;
        public String muser_time_zone;

        @Override // com.squareup.wire.Message.Builder
        public DeriveMessagesToDocRequest build() {
            return new DeriveMessagesToDocRequest(this.muser_time_zone, this.mchat_id, this.mmessage_ids, super.buildUnknownFields());
        }

        public Builder() {
            this.mmessage_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(Long r100) {
            this.mchat_id = r100;
            return this;
        }

        public Builder message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessage_ids = r100;
            return this;
        }

        public Builder user_time_zone(String r100) {
            this.muser_time_zone = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DeriveMessagesToDocRequest extends ProtoAdapter<DeriveMessagesToDocRequest> {
        public ProtoAdapter_DeriveMessagesToDocRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, DeriveMessagesToDocRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DeriveMessagesToDocRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.muser_time_zone = "";
            r101.mchat_id = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.muser_time_zone = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mmessage_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L11:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(DeriveMessagesToDocRequest r100) {
            String r101 = r100.muser_time_zone;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mchat_id;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(3, r100.mmessage_ids)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DeriveMessagesToDocRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DeriveMessagesToDocRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DeriveMessagesToDocRequest r101) throws IOException {
            String r102 = r101.muser_time_zone;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mchat_id;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 3, r101.mmessage_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DeriveMessagesToDocRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DeriveMessagesToDocRequest();
        FIELD_OPTIONS_MCHAT_ID = new FieldOptions.Builder().FieldInfo("split,type=channel").build();
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.muser_time_zone = this.muser_time_zone;
        r100.mchat_id = this.mchat_id;
        r100.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DeriveMessagesToDocRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DeriveMessagesToDocRequest(String r100, Long r101, List<Long> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DeriveMessagesToDocRequest(String r100, Long r101, List<Long> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.muser_time_zone = r100;
        this.mchat_id = r101;
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r102);
    }
}
