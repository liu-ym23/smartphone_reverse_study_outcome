package com.bytedance.lark.pb.contact.v2;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class GetAddressBookContactListResponse extends Message<GetAddressBookContactListResponse, Builder> {
    public static final ProtoAdapter<GetAddressBookContactListResponse> ADAPTER = null;
    public static final Long DEFAULT_NEW_TIMELINE_MARK = null;
    public static final ProtoAdapter_GetAddressBookContactListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, ContactPointUserList> cp_user_infos;
    public final Long new_timeline_mark;

    public static final class Builder extends Message.Builder<GetAddressBookContactListResponse, Builder> implements d<GetAddressBookContactListResponse> {
        public Map<String, ContactPointUserList> cp_user_infos;
        public Long new_timeline_mark;

        @Override // com.squareup.wire.Message.Builder
        public GetAddressBookContactListResponse build() {
            Long r100 = this.new_timeline_mark;
            if (r100 == null) goto L7;
            return new GetAddressBookContactListResponse(this.new_timeline_mark, this.cp_user_infos, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "new_timeline_mark"});
        }

        public Builder() {
            this.cp_user_infos = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cp_user_infos(Map<String, ContactPointUserList> r100) {
            Internal.checkElementsNotNull(r100);
            this.cp_user_infos = r100;
            return this;
        }

        public Builder new_timeline_mark(Long r100) {
            this.new_timeline_mark = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetAddressBookContactListResponse extends ProtoAdapter<GetAddressBookContactListResponse> implements c<GetAddressBookContactListResponse> {
        private final ProtoAdapter<Map<String, ContactPointUserList>> cp_user_infos;

        public ProtoAdapter_GetAddressBookContactListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetAddressBookContactListResponse.class);
            this.cp_user_infos = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ContactPointUserList.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetAddressBookContactListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.new_timeline_mark = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.new_timeline_mark = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.cp_user_infos.putAll(this.cp_user_infos.decode(r100));
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
        public int encodedSize2(GetAddressBookContactListResponse r100) {
            return (ProtoAdapter.INT64.encodedSizeWithTag(1, r100.new_timeline_mark) + this.cp_user_infos.encodedSizeWithTag(2, r100.cp_user_infos)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetAddressBookContactListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetAddressBookContactListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetAddressBookContactListResponse r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.new_timeline_mark);
            this.cp_user_infos.encodeWithTag(r100, 2, r101.cp_user_infos);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetAddressBookContactListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetAddressBookContactListResponse r100 = new ProtoAdapter_GetAddressBookContactListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_NEW_TIMELINE_MARK = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.new_timeline_mark = this.new_timeline_mark;
        r100.cp_user_infos = Internal.copyOf("cp_user_infos", this.cp_user_infos);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetAddressBookContactListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetAddressBookContactListResponse(Long r100, Map<String, ContactPointUserList> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetAddressBookContactListResponse(Long r100, Map<String, ContactPointUserList> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.new_timeline_mark = r100;
        this.cp_user_infos = Internal.immutableCopyOf("cp_user_infos", r101);
    }
}
