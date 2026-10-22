package com.ss.android.lark.pb.security_event;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class RenderItem extends Message<RenderItem, Builder> {
    public static final ProtoAdapter<RenderItem> ADAPTER = null;
    public static final String DEFAULT_KEY = "";
    public static final String DEFAULT_VALUE = "";
    private static final long serialVersionUID = 0;
    public final String mKey;
    public final RenderTypeValue mRenderTypeValue;
    public final String mValue;

    public static final class Builder extends Message.Builder<RenderItem, Builder> {
        public String mKey;
        public RenderTypeValue mRenderTypeValue;
        public String mValue;

        @Override // com.squareup.wire.Message.Builder
        public RenderItem build() {
            return new RenderItem(this.mKey, this.mValue, this.mRenderTypeValue, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder Key(String r100) {
            this.mKey = r100;
            return this;
        }

        public Builder RenderTypeValue(RenderTypeValue r100) {
            this.mRenderTypeValue = r100;
            return this;
        }

        public Builder Value(String r100) {
            this.mValue = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RenderItem extends ProtoAdapter<RenderItem> {
        public ProtoAdapter_RenderItem() {
            super(FieldEncoding.LENGTH_DELIMITED, RenderItem.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RenderItem decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mKey = "";
            r101.mValue = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mKey = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mValue = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mRenderTypeValue = RenderTypeValue.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(RenderItem r100) {
            String r101 = r100.mKey;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.mValue;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RenderTypeValue r107 = r100.mRenderTypeValue;
            if (r107 == null) goto L14;
            r102 = RenderTypeValue.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ RenderItem decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RenderItem r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RenderItem r101) throws IOException {
            String r102 = r101.mKey;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.mValue;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            RenderTypeValue r104 = r101.mRenderTypeValue;
            if (r104 == null) goto L11;
            RenderTypeValue.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RenderItem r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RenderItem();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mKey = this.mKey;
        r100.mValue = this.mValue;
        r100.mRenderTypeValue = this.mRenderTypeValue;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RenderItem.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RenderItem(String r100, String r101, RenderTypeValue r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public RenderItem(String r100, String r101, RenderTypeValue r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mKey = r100;
        this.mValue = r101;
        this.mRenderTypeValue = r102;
    }
}
