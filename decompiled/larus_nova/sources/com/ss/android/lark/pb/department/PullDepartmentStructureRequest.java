package com.ss.android.lark.pb.department;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class PullDepartmentStructureRequest extends Message<PullDepartmentStructureRequest, Builder> {
    public static final ProtoAdapter<PullDepartmentStructureRequest> ADAPTER = null;
    public static final Integer DEFAULT_CHATTER_COUNT = null;
    public static final Integer DEFAULT_CHATTER_OFFSET = null;
    public static final Integer DEFAULT_COUNT = null;
    public static final String DEFAULT_DEPARTMENT_ID = "";
    public static final String DEFAULT_IN_CHAT_ID = "";
    public static final Boolean DEFAULT_NEED_PATH = null;
    public static final Integer DEFAULT_OFFSET = null;
    public static final Boolean DEFAULT_SUB_DEPARTMENT_PAGING = null;
    public static final Boolean DEFAULT_USE_DISPLAY_ORDER = null;
    private static final long serialVersionUID = 0;
    public final Integer mchatter_count;
    public final Integer mchatter_offset;
    public final Integer mcount;
    public final String mdepartment_id;
    public final ExtendParam mextend_param;
    public final String min_chat_id;
    public final Boolean mneed_path;
    public final Integer moffset;
    public final Boolean msub_department_paging;
    public final Boolean muse_display_order;

    public static final class Builder extends Message.Builder<PullDepartmentStructureRequest, Builder> {
        public Integer mchatter_count;
        public Integer mchatter_offset;
        public Integer mcount;
        public String mdepartment_id;
        public ExtendParam mextend_param;
        public String min_chat_id;
        public Boolean mneed_path;
        public Integer moffset;
        public Boolean msub_department_paging;
        public Boolean muse_display_order;

        @Override // com.squareup.wire.Message.Builder
        public PullDepartmentStructureRequest build() {
            return new PullDepartmentStructureRequest(this.mdepartment_id, this.mchatter_count, this.mchatter_offset, this.min_chat_id, this.mextend_param, this.moffset, this.mcount, this.msub_department_paging, this.mneed_path, this.muse_display_order, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chatter_count(Integer r100) {
            this.mchatter_count = r100;
            return this;
        }

        public Builder chatter_offset(Integer r100) {
            this.mchatter_offset = r100;
            return this;
        }

        public Builder count(Integer r100) {
            this.mcount = r100;
            return this;
        }

        public Builder department_id(String r100) {
            this.mdepartment_id = r100;
            return this;
        }

        public Builder extend_param(ExtendParam r100) {
            this.mextend_param = r100;
            return this;
        }

        public Builder in_chat_id(String r100) {
            this.min_chat_id = r100;
            return this;
        }

        public Builder need_path(Boolean r100) {
            this.mneed_path = r100;
            return this;
        }

        public Builder offset(Integer r100) {
            this.moffset = r100;
            return this;
        }

        public Builder sub_department_paging(Boolean r100) {
            this.msub_department_paging = r100;
            return this;
        }

        public Builder use_display_order(Boolean r100) {
            this.muse_display_order = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PullDepartmentStructureRequest extends ProtoAdapter<PullDepartmentStructureRequest> {
        public ProtoAdapter_PullDepartmentStructureRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullDepartmentStructureRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullDepartmentStructureRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mdepartment_id = "";
            r101.mchatter_count = 20;
            r101.mchatter_offset = 0;
            r101.min_chat_id = "";
            r101.moffset = 0;
            r101.mcount = 0;
            Boolean r102 = Boolean.FALSE;
            r101.msub_department_paging = r102;
            r101.mneed_path = r102;
            r101.muse_display_order = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L17;
            switch(r104) {
                case 1: goto L16;
                case 2: goto L15;
                case 3: goto L14;
                case 4: goto L13;
                case 5: goto L12;
                case 6: goto L11;
                case 7: goto L10;
                case 8: goto L9;
                case 9: goto L8;
                case 10: goto L7;
                default: goto L6;
            };
        L7:
            r101.muse_display_order = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mneed_path = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.msub_department_paging = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mcount = ProtoAdapter.INT32.decode(r100);
            goto L3
        L11:
            r101.moffset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.mextend_param = ExtendParam.ADAPTER.decode(r100);
            goto L3
        L13:
            r101.min_chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            r101.mchatter_offset = ProtoAdapter.INT32.decode(r100);
            goto L3
        L15:
            r101.mchatter_count = ProtoAdapter.INT32.decode(r100);
            goto L3
        L16:
            r101.mdepartment_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L17:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullDepartmentStructureRequest r100) {
            String r101 = r100.mdepartment_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mchatter_count;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mchatter_offset;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.min_chat_id;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            ExtendParam r113 = r100.mextend_param;
            if (r113 == null) goto L21;
            int r114 = ExtendParam.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Integer r116 = r100.moffset;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.INT32.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Integer r119 = r100.mcount;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.INT32.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.msub_department_paging;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            Boolean r125 = r100.mneed_path;
            if (r125 == null) goto L37;
            int r126 = ProtoAdapter.BOOL.encodedSizeWithTag(9, r125);
        L38:
            int r127 = r124 + r126;
            Boolean r128 = r100.muse_display_order;
            if (r128 == null) goto L42;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(10, r128);
        L42:
            return (r127 + r102) + r100.unknownFields().size();
        L37:
            r126 = 0;
            goto L38
        L33:
            r123 = 0;
            goto L34
        L29:
            r120 = 0;
            goto L30
        L25:
            r117 = 0;
            goto L26
        L21:
            r114 = 0;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PullDepartmentStructureRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullDepartmentStructureRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullDepartmentStructureRequest r101) throws IOException {
            String r102 = r101.mdepartment_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mchatter_count;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mchatter_offset;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.min_chat_id;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            ExtendParam r106 = r101.mextend_param;
            if (r106 == null) goto L17;
            ExtendParam.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Integer r107 = r101.moffset;
            if (r107 == null) goto L20;
            ProtoAdapter.INT32.encodeWithTag(r100, 6, r107);
        L20:
            Integer r108 = r101.mcount;
            if (r108 == null) goto L23;
            ProtoAdapter.INT32.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.msub_department_paging;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            Boolean r110 = r101.mneed_path;
            if (r110 == null) goto L29;
            ProtoAdapter.BOOL.encodeWithTag(r100, 9, r110);
        L29:
            Boolean r111 = r101.muse_display_order;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 10, r111);
        L32:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullDepartmentStructureRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullDepartmentStructureRequest();
        DEFAULT_CHATTER_COUNT = 20;
        DEFAULT_CHATTER_OFFSET = 0;
        DEFAULT_OFFSET = 0;
        DEFAULT_COUNT = 0;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_SUB_DEPARTMENT_PAGING = r100;
        DEFAULT_NEED_PATH = r100;
        DEFAULT_USE_DISPLAY_ORDER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mdepartment_id = this.mdepartment_id;
        r100.mchatter_count = this.mchatter_count;
        r100.mchatter_offset = this.mchatter_offset;
        r100.min_chat_id = this.min_chat_id;
        r100.mextend_param = this.mextend_param;
        r100.moffset = this.moffset;
        r100.mcount = this.mcount;
        r100.msub_department_paging = this.msub_department_paging;
        r100.mneed_path = this.mneed_path;
        r100.muse_display_order = this.muse_display_order;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullDepartmentStructureRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullDepartmentStructureRequest(String r110, Integer r111, Integer r112, String r113, ExtendParam r114, Integer r115, Integer r116, Boolean r210, Boolean r211, Boolean r212) {
        this(r110, r111, r112, r113, r114, r115, r116, r210, r211, r212, ByteString.EMPTY);
    }

    public PullDepartmentStructureRequest(String r100, Integer r101, Integer r102, String r103, ExtendParam r104, Integer r105, Integer r106, Boolean r107, Boolean r110, Boolean r111, ByteString r112) {
        super(ADAPTER, r112);
        this.mdepartment_id = r100;
        this.mchatter_count = r101;
        this.mchatter_offset = r102;
        this.min_chat_id = r103;
        this.mextend_param = r104;
        this.moffset = r105;
        this.mcount = r106;
        this.msub_department_paging = r107;
        this.mneed_path = r110;
        this.muse_display_order = r111;
    }
}
