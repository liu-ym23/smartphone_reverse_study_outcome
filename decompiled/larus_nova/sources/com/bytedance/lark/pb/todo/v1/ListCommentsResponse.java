package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ListCommentsResponse extends Message<ListCommentsResponse, Builder> {
    public static final ProtoAdapter<ListCommentsResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final ProtoAdapter_ListCommentsResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<TodoComment> comments;
    public final Boolean has_more;

    public static final class Builder extends Message.Builder<ListCommentsResponse, Builder> implements d<ListCommentsResponse> {
        public List<TodoComment> comments;
        public Boolean has_more;

        @Override // com.squareup.wire.Message.Builder
        public ListCommentsResponse build() {
            return new ListCommentsResponse(this.comments, this.has_more, super.buildUnknownFields());
        }

        public Builder() {
            this.comments = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder comments(List<TodoComment> r100) {
            Internal.checkElementsNotNull(r100);
            this.comments = r100;
            return this;
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ListCommentsResponse extends ProtoAdapter<ListCommentsResponse> implements c<ListCommentsResponse> {
        public ProtoAdapter_ListCommentsResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ListCommentsResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ListCommentsResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.comments.add(TodoComment.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ListCommentsResponse r100) {
            int r101 = TodoComment.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.comments);
            Boolean r102 = r100.has_more;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ListCommentsResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ListCommentsResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ListCommentsResponse r101) throws IOException {
            TodoComment.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.comments);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ListCommentsResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ListCommentsResponse r100 = new ProtoAdapter_ListCommentsResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.comments = Internal.copyOf("comments", this.comments);
        r100.has_more = this.has_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ListCommentsResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ListCommentsResponse(List<TodoComment> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ListCommentsResponse(List<TodoComment> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.comments = Internal.immutableCopyOf("comments", r100);
        this.has_more = r101;
    }
}
