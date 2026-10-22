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
public final class SearchToolResponse extends Message<SearchToolResponse, Builder> {
    public static final ProtoAdapter<SearchToolResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    private static final long serialVersionUID = 0;
    public final Boolean mhas_more;
    public final List<ToolInfo> mtool_list;

    public static final class Builder extends Message.Builder<SearchToolResponse, Builder> {
        public Boolean mhas_more;
        public List<ToolInfo> mtool_list;

        @Override // com.squareup.wire.Message.Builder
        public SearchToolResponse build() {
            return new SearchToolResponse(this.mtool_list, this.mhas_more, super.buildUnknownFields());
        }

        public Builder() {
            this.mtool_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.mhas_more = r100;
            return this;
        }

        public Builder tool_list(List<ToolInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.mtool_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SearchToolResponse extends ProtoAdapter<SearchToolResponse> {
        public ProtoAdapter_SearchToolResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SearchToolResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SearchToolResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mhas_more = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mtool_list.add(ToolInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mhas_more = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(SearchToolResponse r100) {
            int r101 = ToolInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mtool_list);
            Boolean r102 = r100.mhas_more;
            if (r102 == null) goto L5;
            int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SearchToolResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SearchToolResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SearchToolResponse r101) throws IOException {
            ToolInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mtool_list);
            Boolean r102 = r101.mhas_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SearchToolResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SearchToolResponse();
        DEFAULT_HAS_MORE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtool_list = Internal.copyOf("mtool_list", this.mtool_list);
        r100.mhas_more = this.mhas_more;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SearchToolResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SearchToolResponse(List<ToolInfo> r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public SearchToolResponse(List<ToolInfo> r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mtool_list = Internal.immutableCopyOf("mtool_list", r100);
        this.mhas_more = r101;
    }
}
