package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SaveCommentDraftRequest extends Message<SaveCommentDraftRequest, Builder> {
    public static final ProtoAdapter<SaveCommentDraftRequest> ADAPTER = null;
    public static final String DEFAULT_TODO_GUID = "";
    public static final ProtoAdapter_SaveCommentDraftRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final CreateCommentInfo info;
    public final String todo_guid;

    public static final class Builder extends Message.Builder<SaveCommentDraftRequest, Builder> implements d<SaveCommentDraftRequest> {
        public CreateCommentInfo info;
        public String todo_guid;

        @Override // com.squareup.wire.Message.Builder
        public SaveCommentDraftRequest build() {
            return new SaveCommentDraftRequest(this.todo_guid, this.info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder info(CreateCommentInfo r100) {
            this.info = r100;
            return this;
        }

        public Builder todo_guid(String r100) {
            this.todo_guid = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SaveCommentDraftRequest extends ProtoAdapter<SaveCommentDraftRequest> implements c<SaveCommentDraftRequest> {
        public ProtoAdapter_SaveCommentDraftRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SaveCommentDraftRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SaveCommentDraftRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.todo_guid = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.todo_guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.info = CreateCommentInfo.ADAPTER.decode(r100);
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
        public int encodedSize2(SaveCommentDraftRequest r100) {
            String r101 = r100.todo_guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            CreateCommentInfo r104 = r100.info;
            if (r104 == null) goto L10;
            r102 = CreateCommentInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SaveCommentDraftRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SaveCommentDraftRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SaveCommentDraftRequest r101) throws IOException {
            String r102 = r101.todo_guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            CreateCommentInfo r103 = r101.info;
            if (r103 == null) goto L8;
            CreateCommentInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SaveCommentDraftRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SaveCommentDraftRequest r100 = new ProtoAdapter_SaveCommentDraftRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.todo_guid = this.todo_guid;
        r100.info = this.info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SaveCommentDraftRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SaveCommentDraftRequest(String r100, CreateCommentInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SaveCommentDraftRequest(String r100, CreateCommentInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.todo_guid = r100;
        this.info = r101;
    }
}
