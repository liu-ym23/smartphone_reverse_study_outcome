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
public final class SelectFieldOptionGroups extends Message<SelectFieldOptionGroups, Builder> {
    public static final ProtoAdapter<SelectFieldOptionGroups> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> select_field_option_guids;

    public static final class Builder extends Message.Builder<SelectFieldOptionGroups, Builder> {
        public List<String> select_field_option_guids;

        @Override // com.squareup.wire.Message.Builder
        public SelectFieldOptionGroups build() {
            return new SelectFieldOptionGroups(this.select_field_option_guids, super.buildUnknownFields());
        }

        public Builder() {
            this.select_field_option_guids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder select_field_option_guids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.select_field_option_guids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SelectFieldOptionGroups extends ProtoAdapter<SelectFieldOptionGroups> {
        public ProtoAdapter_SelectFieldOptionGroups() {
            super(FieldEncoding.LENGTH_DELIMITED, SelectFieldOptionGroups.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SelectFieldOptionGroups decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.select_field_option_guids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(SelectFieldOptionGroups r100) {
            return ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.select_field_option_guids) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SelectFieldOptionGroups decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SelectFieldOptionGroups r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SelectFieldOptionGroups r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.select_field_option_guids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectFieldOptionGroups r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SelectFieldOptionGroups();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.select_field_option_guids = Internal.copyOf("select_field_option_guids", this.select_field_option_guids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SelectFieldOptionGroups.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SelectFieldOptionGroups(List<String> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SelectFieldOptionGroups(List<String> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.select_field_option_guids = Internal.immutableCopyOf("select_field_option_guids", r100);
    }
}
