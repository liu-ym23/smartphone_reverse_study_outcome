package com.bytedance.lark.pb.search.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SearchBoxMeta extends Message<SearchBoxMeta, Builder> {
    public static final ProtoAdapter<SearchBoxMeta> ADAPTER = null;
    public static final String DEFAULT_ID = "";
    public static final Integer DEFAULT_UNREAD_MESSAGE_COUNT = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public final String f253689id;
    public final Integer unread_message_count;

    public static final class Builder extends Message.Builder<SearchBoxMeta, Builder> {

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        public String f253690id;
        public Integer unread_message_count;

        @Override // com.squareup.wire.Message.Builder
        public SearchBoxMeta build() {
            String r100 = this.f253690id;
            if (r100 == null) goto L9;
            if (this.unread_message_count == null) goto L9;
            return new SearchBoxMeta(this.f253690id, this.unread_message_count, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "id", this.unread_message_count, "unread_message_count"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(String r100) {
            this.f253690id = r100;
            return this;
        }

        public Builder unread_message_count(Integer r100) {
            this.unread_message_count = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchBoxMeta extends ProtoAdapter<SearchBoxMeta> {
        public ProtoAdapter_SearchBoxMeta() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchBoxMeta.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchBoxMeta decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.f253690id = "";
            r101.unread_message_count = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.f253690id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.unread_message_count = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(SearchBoxMeta r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.f253689id) + ProtoAdapter.INT32.encodedSizeWithTag(2, r100.unread_message_count)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchBoxMeta decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchBoxMeta r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchBoxMeta r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.f253689id);
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r101.unread_message_count);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchBoxMeta r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchBoxMeta();
        DEFAULT_UNREAD_MESSAGE_COUNT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f253690id = this.f253689id;
        r100.unread_message_count = this.unread_message_count;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchBoxMeta.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchBoxMeta(String r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SearchBoxMeta(String r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.f253689id = r100;
        this.unread_message_count = r101;
    }
}
