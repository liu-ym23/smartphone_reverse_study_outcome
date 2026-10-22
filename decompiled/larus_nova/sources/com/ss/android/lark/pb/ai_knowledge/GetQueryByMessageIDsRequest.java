package com.ss.android.lark.pb.ai_knowledge;

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
public final class GetQueryByMessageIDsRequest extends Message<GetQueryByMessageIDsRequest, Builder> {
    public static final ProtoAdapter<GetQueryByMessageIDsRequest> ADAPTER = null;
    public static final Long DEFAULT_CHAT_ID = null;
    public static final String DEFAULT_LEAVE_NOTE = "";
    public static final String DEFAULT_ORIGIN_MERGE_FORWARD_ID = "";
    private static final long serialVersionUID = 0;
    public final Long mchat_id;
    public final String mleave_note;
    public final List<Long> mmessage_ids;
    public final String morigin_merge_forward_id;

    public static final class Builder extends Message.Builder<GetQueryByMessageIDsRequest, Builder> {
        public Long mchat_id;
        public String mleave_note;
        public List<Long> mmessage_ids;
        public String morigin_merge_forward_id;

        @Override // com.squareup.wire.Message.Builder
        public GetQueryByMessageIDsRequest build() {
            return new GetQueryByMessageIDsRequest(this.mchat_id, this.mmessage_ids, this.morigin_merge_forward_id, this.mleave_note, super.buildUnknownFields());
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

        public Builder leave_note(String r100) {
            this.mleave_note = r100;
            return this;
        }

        public Builder message_ids(List<Long> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmessage_ids = r100;
            return this;
        }

        public Builder origin_merge_forward_id(String r100) {
            this.morigin_merge_forward_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetQueryByMessageIDsRequest extends ProtoAdapter<GetQueryByMessageIDsRequest> {
        public ProtoAdapter_GetQueryByMessageIDsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetQueryByMessageIDsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetQueryByMessageIDsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mchat_id = 0L;
            r101.morigin_merge_forward_id = "";
            r101.mleave_note = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mchat_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mmessage_ids.add(ProtoAdapter.INT64.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.morigin_merge_forward_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mleave_note = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetQueryByMessageIDsRequest r100) {
            Long r101 = r100.mchat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.INT64.asRepeated().encodedSizeWithTag(2, r100.mmessage_ids);
            String r105 = r100.morigin_merge_forward_id;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.STRING.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            String r108 = r100.mleave_note;
            if (r108 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(4, r108);
        L14:
            return (r107 + r102) + r100.unknownFields().size();
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetQueryByMessageIDsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetQueryByMessageIDsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetQueryByMessageIDsRequest r101) throws IOException {
            Long r102 = r101.mchat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.INT64.asRepeated().encodeWithTag(r100, 2, r101.mmessage_ids);
            String r103 = r101.morigin_merge_forward_id;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r103);
        L8:
            String r104 = r101.mleave_note;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetQueryByMessageIDsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetQueryByMessageIDsRequest();
        DEFAULT_CHAT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mchat_id = this.mchat_id;
        r100.mmessage_ids = Internal.copyOf("mmessage_ids", this.mmessage_ids);
        r100.morigin_merge_forward_id = this.morigin_merge_forward_id;
        r100.mleave_note = this.mleave_note;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetQueryByMessageIDsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetQueryByMessageIDsRequest(Long r100, List<Long> r101, String r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public GetQueryByMessageIDsRequest(Long r100, List<Long> r101, String r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mchat_id = r100;
        this.mmessage_ids = Internal.immutableCopyOf("mmessage_ids", r101);
        this.morigin_merge_forward_id = r102;
        this.mleave_note = r103;
    }
}
