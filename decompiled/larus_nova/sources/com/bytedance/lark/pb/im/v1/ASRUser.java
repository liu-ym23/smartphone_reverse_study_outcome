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
public final class ASRUser extends Message<ASRUser, Builder> {
    public static final ProtoAdapter<ASRUser> ADAPTER = null;
    public static final Integer DEFAULT_SOURCE_INDEX = null;
    public static final String DEFAULT_USER_ID = "";
    private static final long serialVersionUID = 0;
    public final List<String> lark_user_names;
    public final Integer source_index;
    public final String user_id;

    public static final class Builder extends Message.Builder<ASRUser, Builder> {
        public List<String> lark_user_names;
        public Integer source_index;
        public String user_id;

        @Override // com.squareup.wire.Message.Builder
        public ASRUser build() {
            return new ASRUser(this.user_id, this.source_index, this.lark_user_names, super.buildUnknownFields());
        }

        public Builder() {
            this.lark_user_names = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder lark_user_names(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.lark_user_names = r100;
            return this;
        }

        public Builder source_index(Integer r100) {
            this.source_index = r100;
            return this;
        }

        public Builder user_id(String r100) {
            this.user_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ASRUser extends ProtoAdapter<ASRUser> {
        public ProtoAdapter_ASRUser() {
            super(FieldEncoding.LENGTH_DELIMITED, ASRUser.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ASRUser decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.user_id = "";
            r101.source_index = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.user_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.source_index = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.lark_user_names.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(ASRUser r100) {
            String r101 = r100.user_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.source_index;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.lark_user_names)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ASRUser decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ASRUser r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ASRUser r101) throws IOException {
            String r102 = r101.user_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.source_index;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.lark_user_names);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ASRUser r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ASRUser();
        DEFAULT_SOURCE_INDEX = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.user_id = this.user_id;
        r100.source_index = this.source_index;
        r100.lark_user_names = Internal.copyOf("lark_user_names", this.lark_user_names);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ASRUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ASRUser(String r100, Integer r101, List<String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public ASRUser(String r100, Integer r101, List<String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.user_id = r100;
        this.source_index = r101;
        this.lark_user_names = Internal.immutableCopyOf("lark_user_names", r102);
    }
}
