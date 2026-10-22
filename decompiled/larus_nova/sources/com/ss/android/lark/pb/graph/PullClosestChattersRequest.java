package com.ss.android.lark.pb.graph;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final class PullClosestChattersRequest extends Message<PullClosestChattersRequest, Builder> {
    public static final ProtoAdapter<PullClosestChattersRequest> ADAPTER = null;
    public static final Integer DEFAULT_BEGIN = null;
    public static final Integer DEFAULT_END = null;
    public static final Boolean DEFAULT_IS_FETCH_FEATURE = null;
    public static final Boolean DEFAULT_IS_NEED_AGENT = null;
    public static final Boolean DEFAULT_IS_NEED_DEPARTMENT = null;
    public static final Boolean DEFAULT_IS_NEED_EMAIL_ADDRESS = null;
    public static final Boolean DEFAULT_IS_NEED_EXTENDED_FIELDS = null;
    public static final Boolean DEFAULT_IS_NEED_RELATIONSHIP = null;
    public static final String DEFAULT_LOCALE_IDENTIFIER = "zh_CN";
    private static final long serialVersionUID = 0;
    public final Integer mbegin;
    public final Integer mend;
    public final FilterParam mfilter_param;
    public final Boolean mis_fetch_feature;
    public final Boolean mis_need_agent;
    public final Boolean mis_need_department;
    public final Boolean mis_need_email_address;
    public final Boolean mis_need_extended_fields;
    public final Boolean mis_need_relationship;
    public final String mlocale_identifier;
    public final PullStrategy mpull_type;
    public final Scene mscene;
    public final List<UpdateId> mupdate_ids;

    public static final class Builder extends Message.Builder<PullClosestChattersRequest, Builder> {
        public Integer mbegin;
        public Integer mend;
        public FilterParam mfilter_param;
        public Boolean mis_fetch_feature;
        public Boolean mis_need_agent;
        public Boolean mis_need_department;
        public Boolean mis_need_email_address;
        public Boolean mis_need_extended_fields;
        public Boolean mis_need_relationship;
        public String mlocale_identifier;
        public PullStrategy mpull_type;
        public Scene mscene;
        public List<UpdateId> mupdate_ids;

        @Override // com.squareup.wire.Message.Builder
        public PullClosestChattersRequest build() {
            return new PullClosestChattersRequest(this.mlocale_identifier, this.mbegin, this.mend, this.mfilter_param, this.mscene, this.mis_fetch_feature, this.mis_need_email_address, this.mis_need_extended_fields, this.mpull_type, this.mupdate_ids, this.mis_need_relationship, this.mis_need_department, this.mis_need_agent, super.buildUnknownFields());
        }

        public Builder() {
            this.mupdate_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder begin(Integer r100) {
            this.mbegin = r100;
            return this;
        }

        public Builder end(Integer r100) {
            this.mend = r100;
            return this;
        }

        public Builder filter_param(FilterParam r100) {
            this.mfilter_param = r100;
            return this;
        }

        public Builder is_fetch_feature(Boolean r100) {
            this.mis_fetch_feature = r100;
            return this;
        }

        public Builder is_need_agent(Boolean r100) {
            this.mis_need_agent = r100;
            return this;
        }

        public Builder is_need_department(Boolean r100) {
            this.mis_need_department = r100;
            return this;
        }

        public Builder is_need_email_address(Boolean r100) {
            this.mis_need_email_address = r100;
            return this;
        }

        public Builder is_need_extended_fields(Boolean r100) {
            this.mis_need_extended_fields = r100;
            return this;
        }

        public Builder is_need_relationship(Boolean r100) {
            this.mis_need_relationship = r100;
            return this;
        }

        public Builder locale_identifier(String r100) {
            this.mlocale_identifier = r100;
            return this;
        }

        public Builder pull_type(PullStrategy r100) {
            this.mpull_type = r100;
            return this;
        }

        public Builder scene(Scene r100) {
            this.mscene = r100;
            return this;
        }

        public Builder update_ids(List<UpdateId> r100) {
            Internal.checkElementsNotNull(r100);
            this.mupdate_ids = r100;
            return this;
        }
    }

    public static final class FilterParam extends Message<FilterParam, Builder> {
        public static final ProtoAdapter<FilterParam> ADAPTER = null;
        public static final String DEFAULT_AGENDA_ID = "";
        public static final Long DEFAULT_AGENDA_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final String magenda_id;
        public final Long magenda_start_time;
        public final List<String> mchat_ids;

        public static final class Builder extends Message.Builder<FilterParam, Builder> {
            public String magenda_id;
            public Long magenda_start_time;
            public List<String> mchat_ids;

            @Override // com.squareup.wire.Message.Builder
            public FilterParam build() {
                return new FilterParam(this.mchat_ids, this.magenda_id, this.magenda_start_time, super.buildUnknownFields());
            }

            public Builder() {
                this.mchat_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder agenda_id(String r100) {
                this.magenda_id = r100;
                return this;
            }

            public Builder agenda_start_time(Long r100) {
                this.magenda_start_time = r100;
                return this;
            }

            public Builder chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mchat_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FilterParam extends ProtoAdapter<FilterParam> {
            public ProtoAdapter_FilterParam() {
                super(FieldEncoding.LENGTH_DELIMITED, FilterParam.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FilterParam decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.magenda_id = "";
                r101.magenda_start_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.mchat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.magenda_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.magenda_start_time = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(FilterParam r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.mchat_ids);
                String r103 = r100.magenda_id;
                int r104 = 0;
                if (r103 == null) goto L5;
                int r105 = r101.encodedSizeWithTag(2, r103);
            L6:
                int r106 = r102 + r105;
                Long r107 = r100.magenda_start_time;
                if (r107 == null) goto L10;
                r104 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L10:
                return (r106 + r104) + r100.unknownFields().size();
            L5:
                r105 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FilterParam decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FilterParam r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FilterParam r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.mchat_ids);
                String r103 = r101.magenda_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                Long r104 = r101.magenda_start_time;
                if (r104 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L8:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilterParam r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FilterParam();
            DEFAULT_AGENDA_START_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mchat_ids = Internal.copyOf("mchat_ids", this.mchat_ids);
            r100.magenda_id = this.magenda_id;
            r100.magenda_start_time = this.magenda_start_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FilterParam.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FilterParam(List<String> r100, String r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public FilterParam(List<String> r100, String r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mchat_ids = Internal.immutableCopyOf("mchat_ids", r100);
            this.magenda_id = r101;
            this.magenda_start_time = r102;
        }
    }

    public static final class ProtoAdapter_PullClosestChattersRequest extends ProtoAdapter<PullClosestChattersRequest> {
        public ProtoAdapter_PullClosestChattersRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PullClosestChattersRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PullClosestChattersRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mlocale_identifier = "zh_CN";
            r101.mbegin = 0;
            r101.mend = 4;
            Boolean r102 = Boolean.FALSE;
            r101.mis_fetch_feature = r102;
            r101.mis_need_email_address = r102;
            r101.mis_need_extended_fields = r102;
            r101.mis_need_relationship = r102;
            r101.mis_need_department = r102;
            r101.mis_need_agent = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L26;
            switch(r104) {
                case 1: goto L25;
                case 2: goto L24;
                case 3: goto L23;
                case 4: goto L22;
                case 5: goto L30;
                case 6: goto L17;
                case 7: goto L16;
                case 8: goto L15;
                case 9: goto L28;
                case 10: goto L10;
                case 11: goto L9;
                case 12: goto L8;
                case 13: goto L7;
                default: goto L6;
            };
        L28:
            r101.mpull_type = PullStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L13
        L13:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L30:
            r101.mscene = Scene.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r104, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            r101.mis_need_agent = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.mis_need_department = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L9:
            r101.mis_need_relationship = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            r101.mupdate_ids.add(UpdateId.ADAPTER.decode(r100));
            goto L3
        L15:
            r101.mis_need_extended_fields = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L16:
            r101.mis_need_email_address = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L17:
            r101.mis_fetch_feature = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L22:
            r101.mfilter_param = FilterParam.ADAPTER.decode(r100);
            goto L3
        L23:
            r101.mend = ProtoAdapter.INT32.decode(r100);
            goto L3
        L24:
            r101.mbegin = ProtoAdapter.INT32.decode(r100);
            goto L3
        L25:
            r101.mlocale_identifier = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L26:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PullClosestChattersRequest r100) {
            String r101 = r100.mlocale_identifier;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.mbegin;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Integer r107 = r100.mend;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            FilterParam r110 = r100.mfilter_param;
            if (r110 == null) goto L17;
            int r111 = FilterParam.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Scene r113 = r100.mscene;
            if (r113 == null) goto L21;
            int r114 = Scene.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.mis_fetch_feature;
            if (r116 == null) goto L25;
            int r117 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            int r118 = r115 + r117;
            Boolean r119 = r100.mis_need_email_address;
            if (r119 == null) goto L29;
            int r120 = ProtoAdapter.BOOL.encodedSizeWithTag(7, r119);
        L30:
            int r121 = r118 + r120;
            Boolean r122 = r100.mis_need_extended_fields;
            if (r122 == null) goto L33;
            int r123 = ProtoAdapter.BOOL.encodedSizeWithTag(8, r122);
        L34:
            int r124 = r121 + r123;
            PullStrategy r125 = r100.mpull_type;
            if (r125 == null) goto L37;
            int r126 = PullStrategy.ADAPTER.encodedSizeWithTag(9, r125);
        L38:
            int r127 = (r124 + r126) + UpdateId.ADAPTER.asRepeated().encodedSizeWithTag(10, r100.mupdate_ids);
            Boolean r128 = r100.mis_need_relationship;
            if (r128 == null) goto L41;
            int r129 = ProtoAdapter.BOOL.encodedSizeWithTag(11, r128);
        L42:
            int r130 = r127 + r129;
            Boolean r131 = r100.mis_need_department;
            if (r131 == null) goto L45;
            int r132 = ProtoAdapter.BOOL.encodedSizeWithTag(12, r131);
        L46:
            int r133 = r130 + r132;
            Boolean r134 = r100.mis_need_agent;
            if (r134 == null) goto L50;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(13, r134);
        L50:
            return (r133 + r102) + r100.unknownFields().size();
        L45:
            r132 = 0;
            goto L46
        L41:
            r129 = 0;
            goto L42
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
        public /* bridge */ /* synthetic */ PullClosestChattersRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PullClosestChattersRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PullClosestChattersRequest r101) throws IOException {
            String r102 = r101.mlocale_identifier;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.mbegin;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            Integer r104 = r101.mend;
            if (r104 == null) goto L11;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
        L11:
            FilterParam r105 = r101.mfilter_param;
            if (r105 == null) goto L14;
            FilterParam.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            Scene r106 = r101.mscene;
            if (r106 == null) goto L17;
            Scene.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.mis_fetch_feature;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            Boolean r108 = r101.mis_need_email_address;
            if (r108 == null) goto L23;
            ProtoAdapter.BOOL.encodeWithTag(r100, 7, r108);
        L23:
            Boolean r109 = r101.mis_need_extended_fields;
            if (r109 == null) goto L26;
            ProtoAdapter.BOOL.encodeWithTag(r100, 8, r109);
        L26:
            PullStrategy r110 = r101.mpull_type;
            if (r110 == null) goto L29;
            PullStrategy.ADAPTER.encodeWithTag(r100, 9, r110);
        L29:
            UpdateId.ADAPTER.asRepeated().encodeWithTag(r100, 10, r101.mupdate_ids);
            Boolean r111 = r101.mis_need_relationship;
            if (r111 == null) goto L32;
            ProtoAdapter.BOOL.encodeWithTag(r100, 11, r111);
        L32:
            Boolean r112 = r101.mis_need_department;
            if (r112 == null) goto L35;
            ProtoAdapter.BOOL.encodeWithTag(r100, 12, r112);
        L35:
            Boolean r113 = r101.mis_need_agent;
            if (r113 == null) goto L38;
            ProtoAdapter.BOOL.encodeWithTag(r100, 13, r113);
        L38:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PullClosestChattersRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum PullStrategy extends Enum<PullStrategy> implements WireEnum {
        private static final /* synthetic */ PullStrategy[] $VALUES = null;
        public static final ProtoAdapter<PullStrategy> ADAPTER = null;
        public static final PullStrategy PullStrategy_FULL = null;
        public static final PullStrategy PullStrategy_UNKNOWN = null;
        public static final PullStrategy PullStrategy_UPDATE = null;
        private final int value;

        static {
            PullStrategy r100 = new PullStrategy("PullStrategy_UNKNOWN", 0, 0);
            PullStrategy_UNKNOWN = r100;
            PullStrategy r101 = new PullStrategy("PullStrategy_FULL", 1, 1);
            PullStrategy_FULL = r101;
            PullStrategy r102 = new PullStrategy("PullStrategy_UPDATE", 2, 2);
            PullStrategy_UPDATE = r102;
            $VALUES = new PullStrategy[]{r100, r101, r102};
            ADAPTER = ProtoAdapter.newEnumAdapter(PullStrategy.class);
        }

        public static PullStrategy[] values() {
            return (PullStrategy[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static PullStrategy fromValue(int r100) {
            if (r100 == 0) goto L14;
            if (r100 == 1) goto L12;
            if (r100 == 2) goto L10;
            return null;
        L10:
            return PullStrategy_UPDATE;
        L12:
            return PullStrategy_FULL;
        L14:
            return PullStrategy_UNKNOWN;
        }

        public static PullStrategy valueOf(String r100) {
            return (PullStrategy) a.a(PullStrategy.class, r100);
        }

        private PullStrategy(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final enum Scene extends Enum<Scene> implements WireEnum {
        private static final /* synthetic */ Scene[] $VALUES = null;
        public static final ProtoAdapter<Scene> ADAPTER = null;
        public static final Scene SEARCH = null;
        public static final Scene UNKNOWN = null;
        private final int value;

        static {
            Scene r100 = new Scene("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Scene r101 = new Scene("SEARCH", 1, 1);
            SEARCH = r101;
            $VALUES = new Scene[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Scene.class);
        }

        public static Scene[] values() {
            return (Scene[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Scene fromValue(int r100) {
            if (r100 == 0) goto L10;
            if (r100 == 1) goto L8;
            return null;
        L8:
            return SEARCH;
        L10:
            return UNKNOWN;
        }

        public static Scene valueOf(String r100) {
            return (Scene) a.a(Scene.class, r100);
        }

        private Scene(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class UpdateId extends Message<UpdateId, Builder> {
        public static final ProtoAdapter<UpdateId> ADAPTER = null;
        public static final Long DEFAULT_TENANT_ID = null;
        public static final Long DEFAULT_USER_ID = null;
        private static final long serialVersionUID = 0;
        public final Long mtenant_id;
        public final Long muser_id;

        public static final class Builder extends Message.Builder<UpdateId, Builder> {
            public Long mtenant_id;
            public Long muser_id;

            @Override // com.squareup.wire.Message.Builder
            public UpdateId build() {
                Long r100 = this.muser_id;
                if (r100 == null) goto L7;
                return new UpdateId(this.muser_id, this.mtenant_id, super.buildUnknownFields());
            L7:
                throw Internal.missingRequiredFields(new Object[]{r100, "muser_id"});
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder tenant_id(Long r100) {
                this.mtenant_id = r100;
                return this;
            }

            public Builder user_id(Long r100) {
                this.muser_id = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_UpdateId extends ProtoAdapter<UpdateId> {
            public ProtoAdapter_UpdateId() {
                super(FieldEncoding.LENGTH_DELIMITED, UpdateId.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public UpdateId decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.muser_id = 0L;
                r101.mtenant_id = -1L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.muser_id = ProtoAdapter.INT64.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mtenant_id = ProtoAdapter.INT64.decode(r100);
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
            public int encodedSize2(UpdateId r100) {
                ProtoAdapter<Long> r101 = ProtoAdapter.INT64;
                int r102 = r101.encodedSizeWithTag(1, r100.muser_id);
                Long r103 = r100.mtenant_id;
                if (r103 == null) goto L5;
                int r104 = r101.encodedSizeWithTag(2, r103);
            L7:
                return (r102 + r104) + r100.unknownFields().size();
            L5:
                r104 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ UpdateId decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(UpdateId r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, UpdateId r101) throws IOException {
                ProtoAdapter<Long> r102 = ProtoAdapter.INT64;
                r102.encodeWithTag(r100, 1, r101.muser_id);
                Long r103 = r101.mtenant_id;
                if (r103 == null) goto L5;
                r102.encodeWithTag(r100, 2, r103);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateId r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_UpdateId();
            DEFAULT_USER_ID = 0L;
            DEFAULT_TENANT_ID = -1L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_id = this.muser_id;
            r100.mtenant_id = this.mtenant_id;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return UpdateId.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public UpdateId(Long r100, Long r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public UpdateId(Long r100, Long r101, ByteString r102) {
            super(ADAPTER, r102);
            this.muser_id = r100;
            this.mtenant_id = r101;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PullClosestChattersRequest();
        DEFAULT_BEGIN = 0;
        DEFAULT_END = 4;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_FETCH_FEATURE = r100;
        DEFAULT_IS_NEED_EMAIL_ADDRESS = r100;
        DEFAULT_IS_NEED_EXTENDED_FIELDS = r100;
        DEFAULT_IS_NEED_RELATIONSHIP = r100;
        DEFAULT_IS_NEED_DEPARTMENT = r100;
        DEFAULT_IS_NEED_AGENT = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mlocale_identifier = this.mlocale_identifier;
        r100.mbegin = this.mbegin;
        r100.mend = this.mend;
        r100.mfilter_param = this.mfilter_param;
        r100.mscene = this.mscene;
        r100.mis_fetch_feature = this.mis_fetch_feature;
        r100.mis_need_email_address = this.mis_need_email_address;
        r100.mis_need_extended_fields = this.mis_need_extended_fields;
        r100.mpull_type = this.mpull_type;
        r100.mupdate_ids = Internal.copyOf("mupdate_ids", this.mupdate_ids);
        r100.mis_need_relationship = this.mis_need_relationship;
        r100.mis_need_department = this.mis_need_department;
        r100.mis_need_agent = this.mis_need_agent;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PullClosestChattersRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PullClosestChattersRequest(String r110, Integer r111, Integer r112, FilterParam r113, Scene r210, Boolean r211, Boolean r212, Boolean r213, PullStrategy r214, List<UpdateId> r215, Boolean r216, Boolean r217, Boolean r218) {
        this(r110, r111, r112, r113, r210, r211, r212, r213, r214, r215, r216, r217, r218, ByteString.EMPTY);
    }

    public PullClosestChattersRequest(String r100, Integer r101, Integer r102, FilterParam r103, Scene r104, Boolean r105, Boolean r106, Boolean r107, PullStrategy r110, List<UpdateId> r111, Boolean r112, Boolean r113, Boolean r114, ByteString r115) {
        super(ADAPTER, r115);
        this.mlocale_identifier = r100;
        this.mbegin = r101;
        this.mend = r102;
        this.mfilter_param = r103;
        this.mscene = r104;
        this.mis_fetch_feature = r105;
        this.mis_need_email_address = r106;
        this.mis_need_extended_fields = r107;
        this.mpull_type = r110;
        this.mupdate_ids = Internal.immutableCopyOf("mupdate_ids", r111);
        this.mis_need_relationship = r112;
        this.mis_need_department = r113;
        this.mis_need_agent = r114;
    }
}
