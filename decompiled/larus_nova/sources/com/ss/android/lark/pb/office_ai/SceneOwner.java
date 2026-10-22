package com.ss.android.lark.pb.office_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class SceneOwner extends Message<SceneOwner, Builder> {
    public static final ProtoAdapter<SceneOwner> ADAPTER = null;
    public static final Long DEFAULT_ID = null;
    public static final String DEFAULT_NAME = "";
    private static final long serialVersionUID = 0;
    public final Long mid;
    public final String mname;
    public final SceneOwnerType mtype;

    public static final class Builder extends Message.Builder<SceneOwner, Builder> {
        public Long mid;
        public String mname;
        public SceneOwnerType mtype;

        @Override // com.squareup.wire.Message.Builder
        public SceneOwner build() {
            return new SceneOwner(this.mtype, this.mid, this.mname, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder id(Long r100) {
            this.mid = r100;
            return this;
        }

        public Builder name(String r100) {
            this.mname = r100;
            return this;
        }

        public Builder type(SceneOwnerType r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SceneOwner extends ProtoAdapter<SceneOwner> {
        public ProtoAdapter_SceneOwner() {
            super(FieldEncoding.LENGTH_DELIMITED, SceneOwner.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SceneOwner decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mid = 0L;
            r101.mname = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mtype = SceneOwnerType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mid = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mname = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(SceneOwner r100) {
            SceneOwnerType r101 = r100.mtype;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = SceneOwnerType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mid;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.mname;
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
        public /* bridge */ /* synthetic */ SceneOwner decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SceneOwner r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SceneOwner r101) throws IOException {
            SceneOwnerType r102 = r101.mtype;
            if (r102 == null) goto L5;
            SceneOwnerType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mid;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.mname;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SceneOwner r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SceneOwner();
        DEFAULT_ID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mtype = this.mtype;
        r100.mid = this.mid;
        r100.mname = this.mname;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SceneOwner.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SceneOwner(SceneOwnerType r100, Long r101, String r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SceneOwner(SceneOwnerType r100, Long r101, String r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mtype = r100;
        this.mid = r101;
        this.mname = r102;
    }
}
