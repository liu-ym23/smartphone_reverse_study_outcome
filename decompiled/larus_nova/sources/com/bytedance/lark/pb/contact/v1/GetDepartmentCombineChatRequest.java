package com.bytedance.lark.pb.contact.v1;

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
public final class GetDepartmentCombineChatRequest extends Message<GetDepartmentCombineChatRequest, Builder> {
    public static final ProtoAdapter<GetDepartmentCombineChatRequest> ADAPTER = null;
    public static final Integer DEFAULT_CHATTER_COUNT = null;
    public static final Integer DEFAULT_CHATTER_OFFSET = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_DEPARTMENT_ID = "";
    public static final Boolean DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = null;
    public static final Boolean DEFAULT_NEED_PATH = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final Boolean DEFAULT_SUB_DEPARTMENT_PAGING = null;
    public static final Boolean DEFAULT_USE_DISPLAY_ORDER = null;
    public static final ProtoAdapter_GetDepartmentCombineChatRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Integer chatter_count;
    public final Integer chatter_offset;
    public final Integer count;
    public final String department_id;
    public final ExtendParam extend_param;
    public final Boolean is_support_memo_richtext;
    public final Boolean need_path;
    public final Integer offset;
    public final Boolean sub_department_paging;
    public final Boolean use_display_order;

    public static final class Builder extends Message.Builder<GetDepartmentCombineChatRequest, Builder> implements d<GetDepartmentCombineChatRequest> {
        public String chat_id;
        public Integer chatter_count;
        public Integer chatter_offset;
        public Integer count;
        public String department_id;
        public ExtendParam extend_param;
        public Boolean is_support_memo_richtext;
        public Boolean need_path;
        public Integer offset;
        public Boolean sub_department_paging;
        public Boolean use_display_order;

        @Override // com.squareup.wire.Message.Builder
        public GetDepartmentCombineChatRequest build() {
            String r100 = this.department_id;
            if (r100 == null) goto L7;
            return new GetDepartmentCombineChatRequest(this.chat_id, this.department_id, this.chatter_count, this.chatter_offset, this.extend_param, this.offset, this.count, this.sub_department_paging, this.use_display_order, this.need_path, this.is_support_memo_richtext, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "department_id"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder chatter_count(Integer r100) {
            this.chatter_count = r100;
            return this;
        }

        public Builder chatter_offset(Integer r100) {
            this.chatter_offset = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.count = r100;
            return this;
        }

        public Builder department_id(String r100) {
            this.department_id = r100;
            return this;
        }

        public Builder extend_param(ExtendParam r100) {
            this.extend_param = r100;
            return this;
        }

        public Builder is_support_memo_richtext(Boolean r100) {
            this.is_support_memo_richtext = r100;
            return this;
        }

        public Builder need_path(Boolean r100) {
            this.need_path = r100;
            return this;
        }

        public Builder offset(Integer r100) {
            this.offset = r100;
            return this;
        }

        public Builder sub_department_paging(Boolean r100) {
            this.sub_department_paging = r100;
            return this;
        }

        public Builder use_display_order(Boolean r100) {
            this.use_display_order = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetDepartmentCombineChatRequest extends ProtoAdapter<GetDepartmentCombineChatRequest> implements c<GetDepartmentCombineChatRequest> {
        public ProtoAdapter_GetDepartmentCombineChatRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, GetDepartmentCombineChatRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public GetDepartmentCombineChatRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            r101.department_id = "";
            r101.chatter_count = 20;
            r101.chatter_offset = 0;
            r101.offset = 0;
            r101.count = 0;
            Boolean r102 = Boolean.FALSE;
            r101.sub_department_paging = r102;
            r101.use_display_order = r102;
            r101.need_path = r102;
            r101.is_support_memo_richtext = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L18;
            switch(r104) {
                case 1: goto L17;
                case 2: goto L16;
                case 3: goto L15;
                case 4: goto L14;
                case 5: goto L13;
                case 6: goto L12;
                case 7: goto L11;
                case 8: goto L10;
                case 9: goto L9;
                case 10: goto L8;
                case 11: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_support_memo_richtext = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.need_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.use_display_order = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.sub_department_paging = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            r101.count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L13:
            r101.extend_param = ExtendParam.ADAPTER.decode(r100);
            goto L3
        L14:
            r101.chatter_offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.chatter_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.department_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L17:
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(GetDepartmentCombineChatRequest r100) {
            String r101 = r100.chat_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            int r104 = r103 + ProtoAdapter.STRING.encodedSizeWithTag(2, r100.department_id);
            Integer r105 = r100.chatter_count;
            if (r105 == null) goto L9;
            int r106 = ProtoAdapter.INT32.encodedSizeWithTag(3, r105);
        L10:
            int r107 = r104 + r106;
            Integer r108 = r100.chatter_offset;
            if (r108 == null) goto L13;
            int r109 = ProtoAdapter.INT32.encodedSizeWithTag(4, r108);
        L14:
            int r110 = r107 + r109;
            ExtendParam r111 = r100.extend_param;
            if (r111 == null) goto L17;
            int r112 = ExtendParam.ADAPTER.encodedSizeWithTag(5, r111);
        L18:
            int r113 = r110 + r112;
            Integer r114 = r100.offset;
            if (r114 == null) goto L21;
            int r115 = ProtoAdapter.INT32.encodedSizeWithTag(6, r114);
        L22:
            int r116 = r113 + r115;
            Integer r117 = r100.count;
            if (r117 == null) goto L25;
            int r118 = ProtoAdapter.INT32.encodedSizeWithTag(7, r117);
        L26:
            int r119 = r116 + r118;
            Boolean r120 = r100.sub_department_paging;
            if (r120 == null) goto L29;
            int r121 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r120);
        L30:
            int r122 = r119 + r121;
            Boolean r123 = r100.use_display_order;
            if (r123 == null) goto L33;
            int r124 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r123);
        L34:
            int r125 = r122 + r124;
            Boolean r126 = r100.need_path;
            if (r126 == null) goto L37;
            int r127 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r126);
        L38:
            int r128 = r125 + r127;
            Boolean r129 = r100.is_support_memo_richtext;
            if (r129 == null) goto L42;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r129);
        L42:
            return (r128 + r102) + r100.unknownFields().size();
        L37:
            r127 = 0;
            goto L38
        L33:
            r124 = 0;
            goto L34
        L29:
            r121 = 0;
            goto L30
        L25:
            r118 = 0;
            goto L26
        L21:
            r115 = 0;
            goto L22
        L17:
            r112 = 0;
            goto L18
        L13:
            r109 = 0;
            goto L14
        L9:
            r106 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetDepartmentCombineChatRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetDepartmentCombineChatRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetDepartmentCombineChatRequest r101) throws IOException {
            String r102 = r101.chat_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r101.department_id);
            Integer r103 = r101.chatter_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L8:
            Integer r104 = r101.chatter_offset;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L11:
            ExtendParam r105 = r101.extend_param;
            if (r105 == null) goto L14;
            ExtendParam.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            Integer r106 = r101.offset;
            if (r106 == null) goto L17;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r106);
        L17:
            Integer r107 = r101.count;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r107);
        L20:
            Boolean r108 = r101.sub_department_paging;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r108);
        L23:
            Boolean r109 = r101.use_display_order;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r109);
        L26:
            Boolean r110 = r101.need_path;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r110);
        L29:
            Boolean r111 = r101.is_support_memo_richtext;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetDepartmentCombineChatRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_GetDepartmentCombineChatRequest r100 = new ProtoAdapter_GetDepartmentCombineChatRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_CHATTER_COUNT = 20;
        DEFAULT_CHATTER_OFFSET = 0;
        DEFAULT_OFFSET = 0;
        DEFAULT_COUNT = 0;
        Boolean r101 = Boolean.FALSE;
        DEFAULT_SUB_DEPARTMENT_PAGING = r101;
        DEFAULT_USE_DISPLAY_ORDER = r101;
        DEFAULT_NEED_PATH = r101;
        DEFAULT_IS_SUPPORT_MEMO_RICHTEXT = r101;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.department_id = this.department_id;
        r100.chatter_count = this.chatter_count;
        r100.chatter_offset = this.chatter_offset;
        r100.extend_param = this.extend_param;
        r100.offset = this.offset;
        r100.count = this.count;
        r100.sub_department_paging = this.sub_department_paging;
        r100.use_display_order = this.use_display_order;
        r100.need_path = this.need_path;
        r100.is_support_memo_richtext = this.is_support_memo_richtext;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetDepartmentCombineChatRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetDepartmentCombineChatRequest(String r110, String r111, Integer r112, Integer r113, ExtendParam r114, Integer r115, Integer r210, Boolean r211, Boolean r212, Boolean r213, Boolean r214) {
        this(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, ByteString.EMPTY);
    }

    public GetDepartmentCombineChatRequest(String r100, String r101, Integer r102, Integer r103, ExtendParam r104, Integer r105, Integer r106, Boolean r107, Boolean r110, Boolean r111, Boolean r112, ByteString r113) {
        super(ADAPTER, r113);
        this.chat_id = r100;
        this.department_id = r101;
        this.chatter_count = r102;
        this.chatter_offset = r103;
        this.extend_param = r104;
        this.offset = r105;
        this.count = r106;
        this.sub_department_paging = r107;
        this.use_display_order = r110;
        this.need_path = r111;
        this.is_support_memo_richtext = r112;
    }
}
