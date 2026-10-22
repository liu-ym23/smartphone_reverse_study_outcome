package com.bytedance.lark.pb.url.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PushNeedLazyLoadPreview extends Message<PushNeedLazyLoadPreview, Builder> {
    public static final ProtoAdapter<PushNeedLazyLoadPreview> ADAPTER = null;
    public static final Long DEFAULT_APP_ID = null;
    public static final Long DEFAULT_APP_SCENE_TYPE = null;
    public static final String DEFAULT_PREVIEW_ID = "";
    private static final long serialVersionUID = 0;
    public final Long app_id;
    public final Long app_scene_type;
    public final String preview_id;

    public static final class Builder extends Message.Builder<PushNeedLazyLoadPreview, Builder> {
        public Long app_id;
        public Long app_scene_type;
        public String preview_id;

        @Override // com.squareup.wire.Message.Builder
        public PushNeedLazyLoadPreview build() {
            return new PushNeedLazyLoadPreview(this.app_id, this.app_scene_type, this.preview_id, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_id(Long r100) {
            this.app_id = r100;
            return this;
        }

        public Builder app_scene_type(Long r100) {
            this.app_scene_type = r100;
            return this;
        }

        public Builder preview_id(String r100) {
            this.preview_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushNeedLazyLoadPreview extends ProtoAdapter<PushNeedLazyLoadPreview> {
        public ProtoAdapter_PushNeedLazyLoadPreview() {
            super(FieldEncoding.LENGTH_DELIMITED, PushNeedLazyLoadPreview.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushNeedLazyLoadPreview decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_id = 0L;
            r101.app_scene_type = 0L;
            r101.preview_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.app_scene_type = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.preview_id = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(PushNeedLazyLoadPreview r100) {
            Long r101 = r100.app_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.app_scene_type;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.preview_id;
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
        public /* bridge */ /* synthetic */ PushNeedLazyLoadPreview decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushNeedLazyLoadPreview r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushNeedLazyLoadPreview r101) throws IOException {
            Long r102 = r101.app_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.app_scene_type;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.preview_id;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushNeedLazyLoadPreview r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushNeedLazyLoadPreview();
        DEFAULT_APP_ID = 0L;
        DEFAULT_APP_SCENE_TYPE = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_id = this.app_id;
        r100.app_scene_type = this.app_scene_type;
        r100.preview_id = this.preview_id;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushNeedLazyLoadPreview.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushNeedLazyLoadPreview(Long r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushNeedLazyLoadPreview(Long r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_id = r100;
        this.app_scene_type = r101;
        this.preview_id = r102;
    }
}
