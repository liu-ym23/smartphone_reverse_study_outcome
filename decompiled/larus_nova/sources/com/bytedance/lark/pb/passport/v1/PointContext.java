package com.bytedance.lark.pb.passport.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class PointContext extends Message<PointContext, Builder> {
    public static final ProtoAdapter<PointContext> ADAPTER = null;
    public static final String DEFAULT_POINT_KEY = "";
    public static final String DEFAULT_SCENE_TYPE = "";
    private static final long serialVersionUID = 0;
    public final String point_key;
    public final Map<String, String> point_param;
    public final String scene_type;

    public static final class Builder extends Message.Builder<PointContext, Builder> {
        public String point_key;
        public Map<String, String> point_param;
        public String scene_type;

        @Override // com.squareup.wire.Message.Builder
        public PointContext build() {
            return new PointContext(this.scene_type, this.point_key, this.point_param, super.buildUnknownFields());
        }

        public Builder() {
            this.point_param = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder point_key(String r100) {
            this.point_key = r100;
            return this;
        }

        public Builder point_param(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.point_param = r100;
            return this;
        }

        public Builder scene_type(String r100) {
            this.scene_type = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PointContext extends ProtoAdapter<PointContext> {
        private final ProtoAdapter<Map<String, String>> point_param;

        public ProtoAdapter_PointContext() {
            super(FieldEncoding.LENGTH_DELIMITED, PointContext.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.point_param = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PointContext decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scene_type = "";
            r101.point_key = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.scene_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.point_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.point_param.putAll(this.point_param.decode(r100));
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
        public int encodedSize2(PointContext r100) {
            String r101 = r100.scene_type;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            String r104 = r100.point_key;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.STRING.encodedSizeWithTag(2, r104);
        L10:
            return ((r103 + r102) + this.point_param.encodedSizeWithTag(3, r100.point_param)) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PointContext decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PointContext r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PointContext r101) throws IOException {
            String r102 = r101.scene_type;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            String r103 = r101.point_key;
            if (r103 == null) goto L8;
            ProtoAdapter.STRING.encodeWithTag(r100, 2, r103);
        L8:
            this.point_param.encodeWithTag(r100, 3, r101.point_param);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PointContext r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PointContext();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scene_type = this.scene_type;
        r100.point_key = this.point_key;
        r100.point_param = Internal.copyOf("point_param", this.point_param);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PointContext.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PointContext(String r100, String r101, Map<String, String> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PointContext(String r100, String r101, Map<String, String> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.scene_type = r100;
        this.point_key = r101;
        this.point_param = Internal.immutableCopyOf("point_param", r102);
    }
}
