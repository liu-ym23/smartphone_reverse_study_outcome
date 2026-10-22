package com.ss.android.lark.pb.messages;

import com.google.protobuf.server.FieldOptions;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RecallMessageFoldRequest extends Message<RecallMessageFoldRequest, Builder> {
    public static final ProtoAdapter<RecallMessageFoldRequest> ADAPTER = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final Boolean DEFAULT_RECALL_BY_GROUP_ADMIN = null;
    public static final FieldOptions FIELD_OPTIONS_MFOLD_ID = null;
    private static final long serialVersionUID = 0;
    public final Long mfold_id;
    public final Boolean mrecall_by_group_admin;

    public static final class Builder extends Message.Builder<RecallMessageFoldRequest, Builder> {
        public Long mfold_id;
        public Boolean mrecall_by_group_admin;

        @Override // com.squareup.wire.Message.Builder
        public RecallMessageFoldRequest build() {
            return new RecallMessageFoldRequest(this.mfold_id, this.mrecall_by_group_admin, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder fold_id(Long r100) {
            this.mfold_id = r100;
            return this;
        }

        public Builder recall_by_group_admin(Boolean r100) {
            this.mrecall_by_group_admin = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RecallMessageFoldRequest extends ProtoAdapter<RecallMessageFoldRequest> {
        public ProtoAdapter_RecallMessageFoldRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, RecallMessageFoldRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RecallMessageFoldRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfold_id = 0L;
            r101.mrecall_by_group_admin = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mfold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mrecall_by_group_admin = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(RecallMessageFoldRequest r100) {
            Long r101 = r100.mfold_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.mrecall_by_group_admin;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RecallMessageFoldRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RecallMessageFoldRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RecallMessageFoldRequest r101) throws IOException {
            Long r102 = r101.mfold_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.mrecall_by_group_admin;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RecallMessageFoldRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RecallMessageFoldRequest();
        FIELD_OPTIONS_MFOLD_ID = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_RECALL_BY_GROUP_ADMIN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfold_id = this.mfold_id;
        r100.mrecall_by_group_admin = this.mrecall_by_group_admin;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RecallMessageFoldRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RecallMessageFoldRequest(Long r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public RecallMessageFoldRequest(Long r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mfold_id = r100;
        this.mrecall_by_group_admin = r101;
    }
}
