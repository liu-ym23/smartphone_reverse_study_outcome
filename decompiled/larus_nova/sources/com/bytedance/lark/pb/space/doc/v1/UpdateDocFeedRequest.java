package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class UpdateDocFeedRequest extends Message<UpdateDocFeedRequest, Builder> {
    public static final ProtoAdapter<UpdateDocFeedRequest> ADAPTER = null;
    public static final String DEFAULT_DOC_FEED_ID = "";
    public static final Boolean DEFAULT_IS_REMIND = null;
    public static final ProtoAdapter_UpdateDocFeedRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String doc_feed_id;
    public final Boolean is_remind;

    public static final class Builder extends Message.Builder<UpdateDocFeedRequest, Builder> implements d<UpdateDocFeedRequest> {
        public String doc_feed_id;
        public Boolean is_remind;

        @Override // com.squareup.wire.Message.Builder
        public UpdateDocFeedRequest build() {
            String r100 = this.doc_feed_id;
            if (r100 == null) goto L7;
            return new UpdateDocFeedRequest(this.doc_feed_id, this.is_remind, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "doc_feed_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder doc_feed_id(String r100) {
            this.doc_feed_id = r100;
            return this;
        }

        public Builder is_remind(Boolean r100) {
            this.is_remind = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_UpdateDocFeedRequest extends ProtoAdapter<UpdateDocFeedRequest> implements c<UpdateDocFeedRequest> {
        public ProtoAdapter_UpdateDocFeedRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateDocFeedRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateDocFeedRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.doc_feed_id = "";
            r101.is_remind = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.doc_feed_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_remind = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(UpdateDocFeedRequest r100) {
            int r101 = ProtoAdapter.STRING.encodedSizeWithTag(1, r100.doc_feed_id);
            Boolean r102 = r100.is_remind;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateDocFeedRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateDocFeedRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateDocFeedRequest r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.doc_feed_id);
            Boolean r102 = r101.is_remind;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateDocFeedRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateDocFeedRequest r100 = new ProtoAdapter_UpdateDocFeedRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_IS_REMIND = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.doc_feed_id = this.doc_feed_id;
        r100.is_remind = this.is_remind;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateDocFeedRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateDocFeedRequest(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public UpdateDocFeedRequest(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.doc_feed_id = r100;
        this.is_remind = r101;
    }
}
