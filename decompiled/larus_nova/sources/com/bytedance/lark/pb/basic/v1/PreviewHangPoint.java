package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PreviewHangPoint extends com.squareup.wire.Message<PreviewHangPoint, Builder> {
    public static final ProtoAdapter<PreviewHangPoint> ADAPTER = null;
    public static final Boolean DEFAULT_CLOSE_CARD_PREVIEW = null;
    public static final Boolean DEFAULT_IS_LAZY_LOAD = null;
    public static final Boolean DEFAULT_NEED_LOCAL_PREVIEW = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    public static final String DEFAULT_URL = "";
    private static final long serialVersionUID = 0;
    public final Boolean close_card_preview;
    public final Boolean is_lazy_load;
    public final Boolean need_local_preview;
    public final String preview_id;
    public final String url;

    public static final class Builder extends com.squareup.wire.Message.Builder<PreviewHangPoint, Builder> {
        public Boolean close_card_preview;
        public Boolean is_lazy_load;
        public Boolean need_local_preview;
        public String preview_id;
        public String url;

        @Override // com.squareup.wire.Message.Builder
        public PreviewHangPoint build() {
            return new PreviewHangPoint(this.preview_id, this.need_local_preview, this.close_card_preview, this.url, this.is_lazy_load, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder close_card_preview(Boolean r100) {
            this.close_card_preview = r100;
            return this;
        }

        public Builder is_lazy_load(Boolean r100) {
            this.is_lazy_load = r100;
            return this;
        }

        public Builder need_local_preview(Boolean r100) {
            this.need_local_preview = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }

        public Builder url(String r100) {
            this.url = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PreviewHangPoint extends ProtoAdapter<PreviewHangPoint> {
        public ProtoAdapter_PreviewHangPoint() {
            super(FieldEncoding.LENGTH_DELIMITED, PreviewHangPoint.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PreviewHangPoint decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.preview_id = "";
            Boolean r102 = Boolean.FALSE;
            r101.need_local_preview = r102;
            r101.close_card_preview = r102;
            r101.url = "";
            r101.is_lazy_load = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L21;
            if (r104 != 1) goto L8;
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.need_local_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L12;
            r101.close_card_preview = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L12:
            if (r104 != 4) goto L14;
            r101.url = ProtoAdapter.STRING.decode(r100);
            goto L3
        L14:
            if (r104 != 5) goto L15;
            r101.is_lazy_load = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L15:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L21:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PreviewHangPoint r100) {
            String r101 = r100.preview_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.need_local_preview;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.close_card_preview;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            String r110 = r100.url;
            if (r110 == null) goto L17;
            int r111 = ProtoAdapter.STRING.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            Boolean r113 = r100.is_lazy_load;
            if (r113 == null) goto L22;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(5, r113);
        L22:
            return (r112 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ PreviewHangPoint decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PreviewHangPoint r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PreviewHangPoint r101) throws IOException {
            String r102 = r101.preview_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.need_local_preview;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.close_card_preview;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            String r105 = r101.url;
            if (r105 == null) goto L14;
            ProtoAdapter.STRING.encodeWithTag(r100, 4, r105);
        L14:
            Boolean r106 = r101.is_lazy_load;
            if (r106 == null) goto L17;
            ProtoAdapter.BOOL.encodeWithTag(r100, 5, r106);
        L17:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PreviewHangPoint r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PreviewHangPoint();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_NEED_LOCAL_PREVIEW = r100;
        DEFAULT_CLOSE_CARD_PREVIEW = r100;
        DEFAULT_IS_LAZY_LOAD = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview_id = this.preview_id;
        r100.need_local_preview = this.need_local_preview;
        r100.close_card_preview = this.close_card_preview;
        r100.url = this.url;
        r100.is_lazy_load = this.is_lazy_load;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PreviewHangPoint.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public PreviewHangPoint(String r100, Boolean r101, Boolean r110, String r111, Boolean r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PreviewHangPoint(String r100, Boolean r101, Boolean r102, String r103, Boolean r104, ByteString r105) {
        super(ADAPTER, r105);
        this.preview_id = r100;
        this.need_local_preview = r101;
        this.close_card_preview = r102;
        this.url = r103;
        this.is_lazy_load = r104;
    }
}
