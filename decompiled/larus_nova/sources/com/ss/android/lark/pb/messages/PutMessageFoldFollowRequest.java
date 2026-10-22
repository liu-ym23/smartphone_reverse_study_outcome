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
public final class PutMessageFoldFollowRequest extends Message<PutMessageFoldFollowRequest, Builder> {
    public static final ProtoAdapter<PutMessageFoldFollowRequest> ADAPTER = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final Long DEFAULT_FOLD_ID = null;
    public static final FieldOptions FIELD_OPTIONS_MFOLD_ID = null;
    private static final long serialVersionUID = 0;
    public final Integer mcount;
    public final Long mfold_id;

    public static final class Builder extends Message.Builder<PutMessageFoldFollowRequest, Builder> {
        public Integer mcount;
        public Long mfold_id;

        @Override // com.squareup.wire.Message.Builder
        public PutMessageFoldFollowRequest build() {
            return new PutMessageFoldFollowRequest(this.mfold_id, this.mcount, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder count(Integer r100) {
            this.mcount = r100;
            return this;
        }

        public Builder fold_id(Long r100) {
            this.mfold_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PutMessageFoldFollowRequest extends ProtoAdapter<PutMessageFoldFollowRequest> {
        public ProtoAdapter_PutMessageFoldFollowRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PutMessageFoldFollowRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PutMessageFoldFollowRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfold_id = 0L;
            r101.mcount = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mfold_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mcount = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(PutMessageFoldFollowRequest r100) {
            Long r101 = r100.mfold_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mcount;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PutMessageFoldFollowRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PutMessageFoldFollowRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PutMessageFoldFollowRequest r101) throws IOException {
            Long r102 = r101.mfold_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mcount;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PutMessageFoldFollowRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PutMessageFoldFollowRequest();
        FIELD_OPTIONS_MFOLD_ID = new FieldOptions.Builder().FieldInfo("split,type=msg").build();
        DEFAULT_FOLD_ID = 0L;
        DEFAULT_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfold_id = this.mfold_id;
        r100.mcount = this.mcount;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PutMessageFoldFollowRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PutMessageFoldFollowRequest(Long r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public PutMessageFoldFollowRequest(Long r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mfold_id = r100;
        this.mcount = r101;
    }
}
