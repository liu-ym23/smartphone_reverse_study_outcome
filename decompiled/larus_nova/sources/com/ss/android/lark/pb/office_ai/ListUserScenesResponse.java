package com.ss.android.lark.pb.office_ai;

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
public final class ListUserScenesResponse extends Message<ListUserScenesResponse, Builder> {
    public static final ProtoAdapter<ListUserScenesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_PAGE_OFFSET = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_more;
    public final Long mpage_offset;
    public final List<MyAIScene> mscene;

    public static final class Builder extends Message.Builder<ListUserScenesResponse, Builder> {
        public Boolean mhas_more;
        public Long mpage_offset;
        public List<MyAIScene> mscene;

        @Override // com.squareup.wire.Message.Builder
        public ListUserScenesResponse build() {
            return new ListUserScenesResponse(this.mscene, this.mhas_more, this.mpage_offset, super.buildUnknownFields());
        }

        public Builder() {
            this.mscene = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.mhas_more = r100;
            return this;
        }

        public Builder page_offset(Long r100) {
            this.mpage_offset = r100;
            return this;
        }

        public Builder scene(List<MyAIScene> r100) {
            Internal.checkElementsNotNull(r100);
            this.mscene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ListUserScenesResponse extends ProtoAdapter<ListUserScenesResponse> {
        public ProtoAdapter_ListUserScenesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, ListUserScenesResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ListUserScenesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mhas_more = Boolean.FALSE;
            r101.mpage_offset = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.mscene.add(MyAIScene.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mhas_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mpage_offset = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(ListUserScenesResponse r100) {
            int r101 = MyAIScene.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mscene);
            Boolean r102 = r100.mhas_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.mpage_offset;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ListUserScenesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ListUserScenesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ListUserScenesResponse r101) throws IOException {
            MyAIScene.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mscene);
            Boolean r102 = r101.mhas_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Long r103 = r101.mpage_offset;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ListUserScenesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ListUserScenesResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_PAGE_OFFSET = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mscene = Internal.copyOf("mscene", this.mscene);
        r100.mhas_more = this.mhas_more;
        r100.mpage_offset = this.mpage_offset;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ListUserScenesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ListUserScenesResponse(List<MyAIScene> r100, Boolean r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ListUserScenesResponse(List<MyAIScene> r100, Boolean r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mscene = Internal.immutableCopyOf("mscene", r100);
        this.mhas_more = r101;
        this.mpage_offset = r102;
    }
}
