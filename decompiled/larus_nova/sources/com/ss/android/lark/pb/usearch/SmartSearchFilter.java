package com.ss.android.lark.pb.usearch;

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
public final class SmartSearchFilter extends Message<SmartSearchFilter, Builder> {
    public static final ProtoAdapter<SmartSearchFilter> ADAPTER = null;
    private static final long serialVersionUID = 0;

    public static final class Builder extends Message.Builder<SmartSearchFilter, Builder> {
        @Override // com.squareup.wire.Message.Builder
        public SmartSearchFilter build() {
            return new SmartSearchFilter(super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }
    }

    public static final class FromUserFilter extends Message<FromUserFilter, Builder> {
        public static final ProtoAdapter<FromUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<FromUserFilter, Builder> {
            public List<String> muser_ids;

            @Override // com.squareup.wire.Message.Builder
            public FromUserFilter build() {
                return new FromUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.muser_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_FromUserFilter extends ProtoAdapter<FromUserFilter> {
            public ProtoAdapter_FromUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, FromUserFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public FromUserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muser_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(FromUserFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.muser_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ FromUserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(FromUserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, FromUserFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.muser_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FromUserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_FromUserFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return FromUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public FromUserFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public FromUserFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r100);
        }
    }

    public static final class InChatFilter extends Message<InChatFilter, Builder> {
        public static final ProtoAdapter<InChatFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> mgroup_chat_ids;
        public final List<String> mp2p_chatter_ids;

        public static final class Builder extends Message.Builder<InChatFilter, Builder> {
            public List<String> mgroup_chat_ids;
            public List<String> mp2p_chatter_ids;

            @Override // com.squareup.wire.Message.Builder
            public InChatFilter build() {
                return new InChatFilter(this.mgroup_chat_ids, this.mp2p_chatter_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.mgroup_chat_ids = Internal.newMutableList();
                this.mp2p_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder group_chat_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mgroup_chat_ids = r100;
                return this;
            }

            public Builder p2p_chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.mp2p_chatter_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_InChatFilter extends ProtoAdapter<InChatFilter> {
            public ProtoAdapter_InChatFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, InChatFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public InChatFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L12;
                if (r103 != 1) goto L8;
                r101.mgroup_chat_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L8:
                if (r103 != 2) goto L9;
                r101.mp2p_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(InChatFilter r100) {
                ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                return (r101.asRepeated().encodedSizeWithTag(1, r100.mgroup_chat_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.mp2p_chatter_ids)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ InChatFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(InChatFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, InChatFilter r101) throws IOException {
                ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                r102.asRepeated().encodeWithTag(r100, 1, r101.mgroup_chat_ids);
                r102.asRepeated().encodeWithTag(r100, 2, r101.mp2p_chatter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InChatFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_InChatFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mgroup_chat_ids = Internal.copyOf("mgroup_chat_ids", this.mgroup_chat_ids);
            r100.mp2p_chatter_ids = Internal.copyOf("mp2p_chatter_ids", this.mp2p_chatter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return InChatFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public InChatFilter(List<String> r100, List<String> r101) {
            this(r100, r101, ByteString.EMPTY);
        }

        public InChatFilter(List<String> r100, List<String> r101, ByteString r102) {
            super(ADAPTER, r102);
            this.mgroup_chat_ids = Internal.immutableCopyOf("mgroup_chat_ids", r100);
            this.mp2p_chatter_ids = Internal.immutableCopyOf("mp2p_chatter_ids", r101);
        }
    }

    public static final class ProtoAdapter_SmartSearchFilter extends ProtoAdapter<SmartSearchFilter> {
        public ProtoAdapter_SmartSearchFilter() {
            super(FieldEncoding.LENGTH_DELIMITED, SmartSearchFilter.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SmartSearchFilter decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L6;
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L6:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SmartSearchFilter r100) {
            return r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SmartSearchFilter decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SmartSearchFilter r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SmartSearchFilter r101) throws IOException {
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SmartSearchFilter r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class TimeRangeFilter extends Message<TimeRangeFilter, Builder> {
        public static final ProtoAdapter<TimeRangeFilter> ADAPTER = null;
        public static final Long DEFAULT_CUSTOMIZED_END_TIME = null;
        public static final Long DEFAULT_CUSTOMIZED_START_TIME = null;
        private static final long serialVersionUID = 0;
        public final Long mcustomized_end_time;
        public final Long mcustomized_start_time;
        public final TimeRangeType mtime_range_type;

        public static final class Builder extends Message.Builder<TimeRangeFilter, Builder> {
            public Long mcustomized_end_time;
            public Long mcustomized_start_time;
            public TimeRangeType mtime_range_type;

            @Override // com.squareup.wire.Message.Builder
            public TimeRangeFilter build() {
                return new TimeRangeFilter(this.mtime_range_type, this.mcustomized_start_time, this.mcustomized_end_time, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder customized_end_time(Long r100) {
                this.mcustomized_end_time = r100;
                return this;
            }

            public Builder customized_start_time(Long r100) {
                this.mcustomized_start_time = r100;
                return this;
            }

            public Builder time_range_type(TimeRangeType r100) {
                this.mtime_range_type = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_TimeRangeFilter extends ProtoAdapter<TimeRangeFilter> {
            public ProtoAdapter_TimeRangeFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, TimeRangeFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public TimeRangeFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mcustomized_start_time = 0L;
                r101.mcustomized_end_time = 0L;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.mtime_range_type = TimeRangeType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
            L16:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.mcustomized_start_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.mcustomized_end_time = ProtoAdapter.INT64.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(TimeRangeFilter r100) {
                TimeRangeType r101 = r100.mtime_range_type;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = TimeRangeType.ADAPTER.encodedSizeWithTag(1, r101);
            L6:
                Long r104 = r100.mcustomized_start_time;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Long r107 = r100.mcustomized_end_time;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT64.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ TimeRangeFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(TimeRangeFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, TimeRangeFilter r101) throws IOException {
                TimeRangeType r102 = r101.mtime_range_type;
                if (r102 == null) goto L5;
                TimeRangeType.ADAPTER.encodeWithTag(r100, 1, r102);
            L5:
                Long r103 = r101.mcustomized_start_time;
                if (r103 == null) goto L8;
                ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
            L8:
                Long r104 = r101.mcustomized_end_time;
                if (r104 == null) goto L11;
                ProtoAdapter.INT64.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TimeRangeFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final enum TimeRangeType extends Enum<TimeRangeType> implements WireEnum {
            private static final /* synthetic */ TimeRangeType[] $VALUES = null;
            public static final ProtoAdapter<TimeRangeType> ADAPTER = null;
            public static final TimeRangeType CUSTOMIZED = null;
            public static final TimeRangeType DEFAULT = null;
            public static final TimeRangeType LAST_ONE_DAY = null;
            public static final TimeRangeType LAST_ONE_MONTH = null;
            public static final TimeRangeType LAST_ONE_WEEK = null;
            public static final TimeRangeType LAST_THREE_MONTH = null;
            private final int value;

            static {
                TimeRangeType r100 = new TimeRangeType("DEFAULT", 0, 0);
                DEFAULT = r100;
                TimeRangeType r101 = new TimeRangeType("LAST_ONE_DAY", 1, 1);
                LAST_ONE_DAY = r101;
                TimeRangeType r102 = new TimeRangeType("LAST_ONE_WEEK", 2, 2);
                LAST_ONE_WEEK = r102;
                TimeRangeType r103 = new TimeRangeType("LAST_ONE_MONTH", 3, 3);
                LAST_ONE_MONTH = r103;
                TimeRangeType r104 = new TimeRangeType("LAST_THREE_MONTH", 4, 4);
                LAST_THREE_MONTH = r104;
                TimeRangeType r105 = new TimeRangeType("CUSTOMIZED", 5, 5);
                CUSTOMIZED = r105;
                $VALUES = new TimeRangeType[]{r100, r101, r102, r103, r104, r105};
                ADAPTER = ProtoAdapter.newEnumAdapter(TimeRangeType.class);
            }

            public static TimeRangeType[] values() {
                return (TimeRangeType[]) $VALUES.clone();
            }

            @Override // com.squareup.wire.WireEnum
            public final int getValue() {
                return this.value;
            }

            public static TimeRangeType fromValue(int r100) {
                if (r100 == 0) goto L26;
                if (r100 == 1) goto L24;
                if (r100 == 2) goto L22;
                if (r100 == 3) goto L20;
                if (r100 == 4) goto L18;
                if (r100 == 5) goto L16;
                return null;
            L16:
                return CUSTOMIZED;
            L18:
                return LAST_THREE_MONTH;
            L20:
                return LAST_ONE_MONTH;
            L22:
                return LAST_ONE_WEEK;
            L24:
                return LAST_ONE_DAY;
            L26:
                return DEFAULT;
            }

            public static TimeRangeType valueOf(String r100) {
                return (TimeRangeType) a.a(TimeRangeType.class, r100);
            }

            private TimeRangeType(String r100, int r101, int r102) {
                super(r100, r101);
                this.value = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_TimeRangeFilter();
            DEFAULT_CUSTOMIZED_START_TIME = 0L;
            DEFAULT_CUSTOMIZED_END_TIME = 0L;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mtime_range_type = this.mtime_range_type;
            r100.mcustomized_start_time = this.mcustomized_start_time;
            r100.mcustomized_end_time = this.mcustomized_end_time;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return TimeRangeFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public TimeRangeFilter(TimeRangeType r100, Long r101, Long r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public TimeRangeFilter(TimeRangeType r100, Long r101, Long r102, ByteString r103) {
            super(ADAPTER, r103);
            this.mtime_range_type = r100;
            this.mcustomized_start_time = r101;
            this.mcustomized_end_time = r102;
        }
    }

    public static final class WithUserFilter extends Message<WithUserFilter, Builder> {
        public static final ProtoAdapter<WithUserFilter> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<String> muser_ids;

        public static final class Builder extends Message.Builder<WithUserFilter, Builder> {
            public List<String> muser_ids;

            @Override // com.squareup.wire.Message.Builder
            public WithUserFilter build() {
                return new WithUserFilter(this.muser_ids, super.buildUnknownFields());
            }

            public Builder() {
                this.muser_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder user_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.muser_ids = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_WithUserFilter extends ProtoAdapter<WithUserFilter> {
            public ProtoAdapter_WithUserFilter() {
                super(FieldEncoding.LENGTH_DELIMITED, WithUserFilter.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public WithUserFilter decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.muser_ids.add(ProtoAdapter.STRING.decode(r100));
                goto L3
            L7:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L9:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(WithUserFilter r100) {
                return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.muser_ids) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ WithUserFilter decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(WithUserFilter r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, WithUserFilter r101) throws IOException {
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.muser_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, WithUserFilter r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_WithUserFilter();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.muser_ids = Internal.copyOf("muser_ids", this.muser_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return WithUserFilter.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public WithUserFilter(List<String> r100) {
            this(r100, ByteString.EMPTY);
        }

        public WithUserFilter(List<String> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.muser_ids = Internal.immutableCopyOf("muser_ids", r100);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SmartSearchFilter();
    }

    public SmartSearchFilter() {
        this(ByteString.EMPTY);
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SmartSearchFilter.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SmartSearchFilter(ByteString r100) {
        super(ADAPTER, r100);
    }
}
