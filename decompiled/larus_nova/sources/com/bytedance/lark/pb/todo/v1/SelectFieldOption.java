package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SelectFieldOption extends Message<SelectFieldOption, Builder> {
    public static final ProtoAdapter<SelectFieldOption> ADAPTER = null;
    public static final Integer DEFAULT_COLOR_INDEX = null;
    public static final String DEFAULT_GUID = "";
    public static final Boolean DEFAULT_IS_HIDDEN = null;
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_RANK = "";
    public static final String DEFAULT_TASK_FIELD_KEY = "";
    private static final long serialVersionUID = 0;
    public final Integer color_index;
    public final String guid;
    public final Boolean is_hidden;
    public final String name;
    public final String rank;
    public final String task_field_key;

    public static final class Builder extends Message.Builder<SelectFieldOption, Builder> {
        public Integer color_index;
        public String guid;
        public Boolean is_hidden;
        public String name;
        public String rank;
        public String task_field_key;

        @Override // com.squareup.wire.Message.Builder
        public SelectFieldOption build() {
            return new SelectFieldOption(this.guid, this.task_field_key, this.name, this.color_index, this.rank, this.is_hidden, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder color_index(Integer r100) {
            this.color_index = r100;
            return this;
        }

        public Builder guid(String r100) {
            this.guid = r100;
            return this;
        }

        public Builder is_hidden(Boolean r100) {
            this.is_hidden = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder rank(String r100) {
            this.rank = r100;
            return this;
        }

        public Builder task_field_key(String r100) {
            this.task_field_key = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SelectFieldOption extends ProtoAdapter<SelectFieldOption> {
        public ProtoAdapter_SelectFieldOption() {
            super(FieldEncoding.LENGTH_DELIMITED, SelectFieldOption.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SelectFieldOption decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.guid = "";
            r101.task_field_key = "";
            r101.name = "";
            r101.color_index = 0;
            r101.rank = "";
            r101.is_hidden = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.is_hidden = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            r101.rank = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.color_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.task_field_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            r101.guid = ProtoAdapter.STRING.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(SelectFieldOption r100) {
            String r101 = r100.guid;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.task_field_key;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            Integer r110 = r100.color_index;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.INT32.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.rank;
            if (r113 == null) goto L21;
            int r114 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            Boolean r116 = r100.is_hidden;
            if (r116 == null) goto L26;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ SelectFieldOption decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SelectFieldOption r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SelectFieldOption r101) throws IOException {
            String r102 = r101.guid;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.task_field_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            Integer r105 = r101.color_index;
            if (r105 == null) goto L14;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.rank;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            Boolean r107 = r101.is_hidden;
            if (r107 == null) goto L20;
            ProtoAdapter.BOOL.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SelectFieldOption r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SelectFieldOption();
        DEFAULT_COLOR_INDEX = 0;
        DEFAULT_IS_HIDDEN = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.guid = this.guid;
        r100.task_field_key = this.task_field_key;
        r100.name = this.name;
        r100.color_index = this.color_index;
        r100.rank = this.rank;
        r100.is_hidden = this.is_hidden;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SelectFieldOption.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SelectFieldOption(String r100, String r110, String r111, Integer r112, String r113, Boolean r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public SelectFieldOption(String r100, String r101, String r102, Integer r103, String r104, Boolean r105, ByteString r106) {
        super(ADAPTER, r106);
        this.guid = r100;
        this.task_field_key = r101;
        this.name = r102;
        this.color_index = r103;
        this.rank = r104;
        this.is_hidden = r105;
    }
}
