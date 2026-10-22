package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class CCMResourceItem extends Message<CCMResourceItem, Builder> {
    public static final ProtoAdapter<CCMResourceItem> ADAPTER = null;
    public static final String DEFAULT_DATA_JSON = "";
    public static final String DEFAULT_RES_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String data_json;
    public final String res_type;

    public static final class Builder extends Message.Builder<CCMResourceItem, Builder> {
        public String data_json;
        public String res_type;

        @Override // com.squareup.wire.Message.Builder
        public CCMResourceItem build() {
            String r100 = this.res_type;
            if (r100 == null) goto L9;
            if (this.data_json == null) goto L9;
            return new CCMResourceItem(this.res_type, this.data_json, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "res_type", this.data_json, "data_json"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder data_json(String r100) {
            this.data_json = r100;
            return this;
        }

        public Builder res_type(String r100) {
            this.res_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMResourceItem extends ProtoAdapter<CCMResourceItem> {
        public ProtoAdapter_CCMResourceItem() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMResourceItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMResourceItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.res_type = "";
            r101.data_json = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.res_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.data_json = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(CCMResourceItem r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.res_type) + r101.encodedSizeWithTag(2, r100.data_json)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMResourceItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMResourceItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMResourceItem r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.res_type);
            r102.encodeWithTag(r100, 2, r101.data_json);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMResourceItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_CCMResourceItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.res_type = this.res_type;
        r100.data_json = this.data_json;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMResourceItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMResourceItem(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public CCMResourceItem(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.res_type = r100;
        this.data_json = r101;
    }
}
