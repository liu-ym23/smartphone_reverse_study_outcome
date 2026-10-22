package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class FilterCondition extends Message<FilterCondition, Builder> {
    public static final ProtoAdapter<FilterCondition> ADAPTER = null;
    public static final String DEFAULT_FIELD_KEY = "";
    public static final FilterPredicate DEFAULT_PREDICATE = null;
    private static final long serialVersionUID = 0;
    public final List<FieldFilterValue> field_filter_value;
    public final String field_key;
    public final FilterPredicate predicate;

    public static final class Builder extends Message.Builder<FilterCondition, Builder> {
        public List<FieldFilterValue> field_filter_value;
        public String field_key;
        public FilterPredicate predicate;

        @Override // com.squareup.wire.Message.Builder
        public FilterCondition build() {
            return new FilterCondition(this.field_key, this.predicate, this.field_filter_value, super.buildUnknownFields());
        }

        public Builder() {
            this.field_filter_value = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder field_filter_value(List<FieldFilterValue> r100) {
            Internal.checkElementsNotNull(r100);
            this.field_filter_value = r100;
            return this;
        }

        public Builder field_key(String r100) {
            this.field_key = r100;
            return this;
        }

        public Builder predicate(FilterPredicate r100) {
            this.predicate = r100;
            return this;
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
            r101.field_key = "";
            r101.predicate = FilterPredicate.UNKNOWN_PREDICATE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.field_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.predicate = FilterPredicate.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
        L15:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.field_filter_value.add(FieldFilterValue.ADAPTER.decode(r100));
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
        public int encodedSize2(FilterCondition r100) {
            String r101 = r100.field_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            FilterPredicate r104 = r100.predicate;
            if (r104 == null) goto L10;
            r102 = FilterPredicate.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + FieldFilterValue.ADAPTER.asRepeated().encodedSizeWithTag(3, r100.field_filter_value)) + r100.unknownFields().size();
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
            String r102 = r101.field_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            FilterPredicate r103 = r101.predicate;
            if (r103 == null) goto L8;
            FilterPredicate.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            FieldFilterValue.ADAPTER.asRepeated().encodeWithTag(r100, 3, r101.field_filter_value);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FilterCondition r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FilterCondition();
        DEFAULT_PREDICATE = FilterPredicate.UNKNOWN_PREDICATE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.field_key = this.field_key;
        r100.predicate = this.predicate;
        r100.field_filter_value = Internal.copyOf("field_filter_value", this.field_filter_value);
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

    public FilterCondition(String r100, FilterPredicate r101, List<FieldFilterValue> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FilterCondition(String r100, FilterPredicate r101, List<FieldFilterValue> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.field_key = r100;
        this.predicate = r101;
        this.field_filter_value = Internal.immutableCopyOf("field_filter_value", r102);
    }
}
