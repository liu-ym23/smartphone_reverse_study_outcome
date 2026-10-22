package com.bytedance.lark.pb.space.doc.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class CCMRustSetDataRequest extends Message<CCMRustSetDataRequest, Builder> {
    public static final ProtoAdapter<CCMRustSetDataRequest> ADAPTER = null;
    public static final String DEFAULT_CATEGORY = "";
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_KEY = "";
    public static final Boolean DEFAULT_NEED_SYNC = null;
    public static final String DEFAULT_OBJ_TOKEN = "";
    public static final ProtoAdapter_CCMRustSetDataRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String category;
    public final ByteString data;
    public final String key;
    public final Boolean need_sync;
    public final String obj_token;

    public static final class Builder extends Message.Builder<CCMRustSetDataRequest, Builder> implements d<CCMRustSetDataRequest> {
        public String category;
        public ByteString data;
        public String key;
        public Boolean need_sync;
        public String obj_token;

        @Override // com.squareup.wire.Message.Builder
        public CCMRustSetDataRequest build() {
            String r100 = this.key;
            if (r100 == null) goto L11;
            if (this.obj_token == null) goto L11;
            if (this.data == null) goto L11;
            return new CCMRustSetDataRequest(this.key, this.obj_token, this.data, this.need_sync, this.category, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "key", this.obj_token, "obj_token", this.data, "data"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder category(String r100) {
            this.category = r100;
            return this;
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder key(String r100) {
            this.key = r100;
            return this;
        }

        public Builder need_sync(Boolean r100) {
            this.need_sync = r100;
            return this;
        }

        public Builder obj_token(String r100) {
            this.obj_token = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_CCMRustSetDataRequest extends ProtoAdapter<CCMRustSetDataRequest> implements c<CCMRustSetDataRequest> {
        public ProtoAdapter_CCMRustSetDataRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, CCMRustSetDataRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public CCMRustSetDataRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.key = "";
            r101.obj_token = "";
            r101.data = ByteString.EMPTY;
            r101.need_sync = Boolean.FALSE;
            r101.category = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L21;
            if (r103 != 1) goto L8;
            r101.key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.obj_token = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.data = ProtoAdapter.BYTES.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.need_sync = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.category = ProtoAdapter.STRING.decode(r100);
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(CCMRustSetDataRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = (r101.encodedSizeWithTag(1, r100.key) + r101.encodedSizeWithTag(2, r100.obj_token)) + ProtoAdapter.BYTES.encodedSizeWithTag(3, r100.data);
            Boolean r103 = r100.need_sync;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r103);
        L6:
            int r106 = r102 + r105;
            String r107 = r100.category;
            if (r107 == null) goto L10;
            r104 = r101.encodedSizeWithTag(5, r107);
        L10:
            return (r106 + r104) + r100.unknownFields().size();
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ CCMRustSetDataRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(CCMRustSetDataRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, CCMRustSetDataRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.key);
            r102.encodeWithTag(r100, 2, r101.obj_token);
            ProtoAdapter.BYTES.encodeWithTag(r100, 3, r101.data);
            Boolean r103 = r101.need_sync;
            if (r103 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L5:
            String r104 = r101.category;
            if (r104 == null) goto L8;
            r102.encodeWithTag(r100, 5, r104);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, CCMRustSetDataRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_CCMRustSetDataRequest r100 = new ProtoAdapter_CCMRustSetDataRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_DATA = ByteString.EMPTY;
        DEFAULT_NEED_SYNC = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.key = this.key;
        r100.obj_token = this.obj_token;
        r100.data = this.data;
        r100.need_sync = this.need_sync;
        r100.category = this.category;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return CCMRustSetDataRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public CCMRustSetDataRequest(String r100, String r101, ByteString r110, Boolean r111, String r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public CCMRustSetDataRequest(String r100, String r101, ByteString r102, Boolean r103, String r104, ByteString r105) {
        super(ADAPTER, r105);
        this.key = r100;
        this.obj_token = r101;
        this.data = r102;
        this.need_sync = r103;
        this.category = r104;
    }
}
