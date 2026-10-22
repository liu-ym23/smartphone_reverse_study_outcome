package com.bytedance.lark.pb.im.v1;

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
public final class GetToolListResponse extends Message<GetToolListResponse, Builder> {
    public static final ProtoAdapter<GetToolListResponse> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Long DEFAULT_MAX_SELECT_NUM = null;
    public static final ProtoAdapter_GetToolListResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final Long max_select_num;
    public final List<ToolInfo> tool_list;

    public static final class Builder extends Message.Builder<GetToolListResponse, Builder> implements d<GetToolListResponse> {
        public Boolean has_more;
        public Long max_select_num;
        public List<ToolInfo> tool_list;

        @Override // com.squareup.wire.Message.Builder
        public GetToolListResponse build() {
            return new GetToolListResponse(this.tool_list, this.has_more, this.max_select_num, super.buildUnknownFields());
        }

        public Builder() {
            this.tool_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder max_select_num(Long r100) {
            this.max_select_num = r100;
            return this;
        }

        public Builder tool_list(List<ToolInfo> r100) {
            Internal.checkElementsNotNull(r100);
            this.tool_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetToolListResponse extends ProtoAdapter<GetToolListResponse> implements c<GetToolListResponse> {
        public ProtoAdapter_GetToolListResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, GetToolListResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetToolListResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.has_more = Boolean.FALSE;
            r101.max_select_num = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.tool_list.add(ToolInfo.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.max_select_num = ProtoAdapter.INT64.decode(r100);
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
        public int encodedSize2(GetToolListResponse r100) {
            int r101 = ToolInfo.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.tool_list);
            Boolean r102 = r100.has_more;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            Long r106 = r100.max_select_num;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.INT64.encodedSizeWithTag(3, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetToolListResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetToolListResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetToolListResponse r101) throws IOException {
            ToolInfo.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.tool_list);
            Boolean r102 = r101.has_more;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            Long r103 = r101.max_select_num;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 3, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetToolListResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetToolListResponse r100 = new ProtoAdapter_GetToolListResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_HAS_MORE = Boolean.FALSE;
        DEFAULT_MAX_SELECT_NUM = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.tool_list = Internal.copyOf("tool_list", this.tool_list);
        r100.has_more = this.has_more;
        r100.max_select_num = this.max_select_num;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetToolListResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetToolListResponse(List<ToolInfo> r100, Boolean r101, Long r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public GetToolListResponse(List<ToolInfo> r100, Boolean r101, Long r102, ByteString r103) {
        super(ADAPTER, r103);
        this.tool_list = Internal.immutableCopyOf("tool_list", r100);
        this.has_more = r101;
        this.max_select_num = r102;
    }
}
