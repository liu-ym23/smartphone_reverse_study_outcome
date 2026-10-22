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

/* JADX INFO: loaded from: classes20.dex */
public final class ASRName extends Message<ASRName, Builder> {
    public static final ProtoAdapter<ASRName> ADAPTER = null;
    public static final Integer DEFAULT_INDEX_BEGIN = null;
    public static final Integer DEFAULT_INDEX_END = null;
    public static final String DEFAULT_PINYIN = "";
    public static final String DEFAULT_TEXT = "";
    public static final String DEFAULT_TEXT_ORIGIN = "";
    private static final long serialVersionUID = 0;
    public final Integer index_begin;
    public final Integer index_end;
    public final String pinyin;
    public final String text;
    public final String text_origin;
    public final List<ASRUser> user_list;

    public static final class Builder extends Message.Builder<ASRName, Builder> {
        public Integer index_begin;
        public Integer index_end;
        public String pinyin;
        public String text;
        public String text_origin;
        public List<ASRUser> user_list;

        @Override // com.squareup.wire.Message.Builder
        public ASRName build() {
            return new ASRName(this.index_begin, this.index_end, this.text, this.pinyin, this.text_origin, this.user_list, super.buildUnknownFields());
        }

        public Builder() {
            this.user_list = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder index_begin(Integer r100) {
            this.index_begin = r100;
            return this;
        }

        public Builder index_end(Integer r100) {
            this.index_end = r100;
            return this;
        }

        public Builder pinyin(String r100) {
            this.pinyin = r100;
            return this;
        }

        public Builder text(String r100) {
            this.text = r100;
            return this;
        }

        public Builder text_origin(String r100) {
            this.text_origin = r100;
            return this;
        }

        public Builder user_list(List<ASRUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.user_list = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ASRName extends ProtoAdapter<ASRName> {
        public ProtoAdapter_ASRName() {
            super(FieldEncoding.LENGTH_DELIMITED, ASRName.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ASRName decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.index_begin = 0;
            r101.index_end = 0;
            r101.text = "";
            r101.pinyin = "";
            r101.text_origin = "";
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
            r101.user_list.add(ASRUser.ADAPTER.decode(r100));
            goto L3
        L8:
            r101.text_origin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L9:
            r101.pinyin = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            r101.text = ProtoAdapter.STRING.decode(r100);
            goto L3
        L11:
            r101.index_end = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            r101.index_begin = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(ASRName r100) {
            Integer r101 = r100.index_begin;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.index_end;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.text;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.pinyin;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            String r113 = r100.text_origin;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(5, r113);
        L22:
            return ((r112 + r102) + ASRUser.ADAPTER.asRepeated().encodedSizeWithTag(6, r100.user_list)) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ ASRName decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ASRName r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ASRName r101) throws IOException {
            Integer r102 = r101.index_begin;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.index_end;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.text;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.pinyin;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            String r106 = r101.text_origin;
            if (r106 == null) goto L17;
            ProtoAdapter.STRING.encodeWithTag(r100, 5, r106);
        L17:
            ASRUser.ADAPTER.asRepeated().encodeWithTag(r100, 6, r101.user_list);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ASRName r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ASRName();
        DEFAULT_INDEX_BEGIN = 0;
        DEFAULT_INDEX_END = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.index_begin = this.index_begin;
        r100.index_end = this.index_end;
        r100.text = this.text;
        r100.pinyin = this.pinyin;
        r100.text_origin = this.text_origin;
        r100.user_list = Internal.copyOf("user_list", this.user_list);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ASRName.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ASRName(Integer r100, Integer r110, String r111, String r112, String r113, List<ASRUser> r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public ASRName(Integer r100, Integer r101, String r102, String r103, String r104, List<ASRUser> r105, ByteString r106) {
        super(ADAPTER, r106);
        this.index_begin = r100;
        this.index_end = r101;
        this.text = r102;
        this.pinyin = r103;
        this.text_origin = r104;
        this.user_list = Internal.immutableCopyOf("user_list", r105);
    }
}
