package com.ss.android.lark.pb.todo_entities;

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
public final class FilterCondition extends Message<FilterCondition, Builder> {
    public static final ProtoAdapter<FilterCondition> ADAPTER = null;
    public static final String DEFAULT_FIELD_KEY = "";
    private static final long serialVersionUID = 0;
    public final List<FieldFilterValue> mfield_filter_value;
    public final String mfield_key;
    public final Option moptions;
    public final FilterPredicate mpredicate;

    public static final class Builder extends Message.Builder<FilterCondition, Builder> {
        public List<FieldFilterValue> mfield_filter_value;
        public String mfield_key;
        public Option moptions;
        public FilterPredicate mpredicate;

        @Override // com.squareup.wire.Message.Builder
        public FilterCondition build() {
            return new FilterCondition(this.mfield_key, this.mpredicate, this.mfield_filter_value, this.moptions, super.buildUnknownFields());
        }

        public Builder() {
            this.mfield_filter_value = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_filter_value(List<FieldFilterValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.mfield_filter_value = r100;
            return this;
        }

        public Builder field_key(String r100) {
            this.mfield_key = r100;
            return this;
        }

        public Builder options(Option r100) {
            this.moptions = r100;
            return this;
        }

        public Builder predicate(FilterPredicate r100) {
            this.mpredicate = r100;
            return this;
        }
    }

    public static final class Option extends Message<Option, Builder> {
        public static final ProtoAdapter<Option> ADAPTER = null;
        public static final Boolean DEFAULT_NO_PROCESS_AS_DATE = null;
        private static final long serialVersionUID = 0;
        public final Boolean mno_process_as_date;

        public static final class Builder extends Message.Builder<Option, Builder> {
            public Boolean mno_process_as_date;

            @Override // com.squareup.wire.Message.Builder
            public Option build() {
                return new Option(this.mno_process_as_date, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder no_process_as_date(Boolean r100) {
                this.mno_process_as_date = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Option extends ProtoAdapter<Option> {
            public ProtoAdapter_Option() {
                super(FieldEncoding.LENGTH_DELIMITED, Option.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Option decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.mno_process_as_date = Boolean.FALSE;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.mno_process_as_date = ProtoAdapter.BOOL.decode(r100);
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
            public int encodedSize2(Option r100) {
                Boolean r101 = r100.mno_process_as_date;
                if (r101 == null) goto L5;
                int r102 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L7:
                return r102 + r100.unknownFields().size();
            L5:
                r102 = 0;
                goto L7
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Option decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Option r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Option r101) throws IOException {
                Boolean r102 = r101.mno_process_as_date;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Option r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Option();
            DEFAULT_NO_PROCESS_AS_DATE = Boolean.FALSE;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.mno_process_as_date = this.mno_process_as_date;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Option.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Option(Boolean r100) {
            this(r100, ByteString.EMPTY);
        }

        public Option(Boolean r100, ByteString r101) {
            super(ADAPTER, r101);
            this.mno_process_as_date = r100;
        }
    }

    public static final class ProtoAdapter_FilterCondition extends ProtoAdapter<FilterCondition> {
        public ProtoAdapter_FilterCondition() {
            super(FieldEncoding.LENGTH_DELIMITED, FilterCondition.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FilterCondition decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mfield_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.mfield_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mpredicate = FilterPredicate.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mfield_filter_value.add(FieldFilterValue.ADAPTER.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.moptions = Option.ADAPTER.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(FilterCondition r100) {
            String r101 = r100.mfield_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            FilterPredicate r104 = r100.mpredicate;
            if (r104 == null) goto L9;
            int r105 = FilterPredicate.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = (r103 + r105) + FieldFilterValue.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.mfield_filter_value);
            Option r107 = r100.moptions;
            if (r107 == null) goto L14;
            r102 = Option.ADAPTER.encodedSizeWithTag(4, r107);
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
        public /* bridge */ /* synthetic */ FilterCondition decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FilterCondition r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FilterCondition r101) throws IOException {
            String r102 = r101.mfield_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            FilterPredicate r103 = r101.mpredicate;
            if (r103 == null) goto L8;
            FilterPredicate.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            FieldFilterValue.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.mfield_filter_value);
            Option r104 = r101.moptions;
            if (r104 == null) goto L11;
            Option.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilterCondition r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FilterCondition();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mfield_key = this.mfield_key;
        r100.mpredicate = this.mpredicate;
        r100.mfield_filter_value = Internal.copyOf("mfield_filter_value", this.mfield_filter_value);
        r100.moptions = this.moptions;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FilterCondition.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FilterCondition(String r100, FilterPredicate r101, List<FieldFilterValue> r102, Option r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FilterCondition(String r100, FilterPredicate r101, List<FieldFilterValue> r102, Option r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mfield_key = r100;
        this.mpredicate = r101;
        this.mfield_filter_value = Internal.immutableCopyOf("mfield_filter_value", r102);
        this.moptions = r103;
    }
}
