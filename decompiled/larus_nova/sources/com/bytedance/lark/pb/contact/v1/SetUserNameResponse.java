package com.bytedance.lark.pb.contact.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SetUserNameResponse extends Message<SetUserNameResponse, Builder> {
    public static final ProtoAdapter<SetUserNameResponse> ADAPTER = null;
    public static final String DEFAULT_ANOTHER_NAME = "";
    public static final String DEFAULT_NAME = "";
    public static final String DEFAULT_NAME_WITH_ANOTHER_NAME = "";
    public static final ProtoAdapter_SetUserNameResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String another_name;
    public final String name;
    public final String name_with_another_name;

    public static final class Builder extends Message.Builder<SetUserNameResponse, Builder> implements d<SetUserNameResponse> {
        public String another_name;
        public String name;
        public String name_with_another_name;

        @Override // com.squareup.wire.Message.Builder
        public SetUserNameResponse build() {
            return new SetUserNameResponse(this.name, this.another_name, this.name_with_another_name, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder another_name(String r100) {
            this.another_name = r100;
            return this;
        }

        public Builder name(String r100) {
            this.name = r100;
            return this;
        }

        public Builder name_with_another_name(String r100) {
            this.name_with_another_name = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetUserNameResponse extends ProtoAdapter<SetUserNameResponse> implements c<SetUserNameResponse> {
        public ProtoAdapter_SetUserNameResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, SetUserNameResponse.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetUserNameResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.name = "";
            r101.another_name = "";
            r101.name_with_another_name = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.another_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.name_with_another_name = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SetUserNameResponse r100) {
            String r101 = r100.name;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.another_name;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.name_with_another_name;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ SetUserNameResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetUserNameResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetUserNameResponse r101) throws IOException {
            String r102 = r101.name;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.another_name;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.name_with_another_name;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetUserNameResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SetUserNameResponse r100 = new ProtoAdapter_SetUserNameResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.name = this.name;
        r100.another_name = this.another_name;
        r100.name_with_another_name = this.name_with_another_name;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetUserNameResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetUserNameResponse(String r100, String r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SetUserNameResponse(String r100, String r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.name = r100;
        this.another_name = r101;
        this.name_with_another_name = r102;
    }
}
