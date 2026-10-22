package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class RemoteResourceWithFsUnit extends Message<RemoteResourceWithFsUnit, Builder> {
    public static final ProtoAdapter<RemoteResourceWithFsUnit> ADAPTER = null;
    public static final String DEFAULT_CUT_TYPE = "";
    public static final String DEFAULT_FS_UNIT = "";
    public static final Integer DEFAULT_HEIGHT = null;
    public static final Integer DEFAULT_WIDTH = null;
    private static final long serialVersionUID = 0;
    public final String cut_type;
    public final String fs_unit;
    public final Integer height;
    public final Integer width;

    public static final class Builder extends Message.Builder<RemoteResourceWithFsUnit, Builder> {
        public String cut_type;
        public String fs_unit;
        public Integer height;
        public Integer width;

        @Override // com.squareup.wire.Message.Builder
        public RemoteResourceWithFsUnit build() {
            String r100 = this.fs_unit;
            if (r100 == null) goto L7;
            return new RemoteResourceWithFsUnit(this.fs_unit, this.width, this.height, this.cut_type, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "fs_unit"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cut_type(String r100) {
            this.cut_type = r100;
            return this;
        }

        public Builder fs_unit(String r100) {
            this.fs_unit = r100;
            return this;
        }

        public Builder height(Integer r100) {
            this.height = r100;
            return this;
        }

        public Builder width(Integer r100) {
            this.width = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_RemoteResourceWithFsUnit extends ProtoAdapter<RemoteResourceWithFsUnit> {
        public ProtoAdapter_RemoteResourceWithFsUnit() {
            super(FieldEncoding.LENGTH_DELIMITED, RemoteResourceWithFsUnit.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public RemoteResourceWithFsUnit decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.fs_unit = "";
            r101.width = 0;
            r101.height = 0;
            r101.cut_type = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.fs_unit = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.width = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L12;
            r101.height = ProtoAdapter.INT32.decode(r100);
            goto L3
        L12:
            if (r103 != 5) goto L13;
            r101.cut_type = ProtoAdapter.STRING.decode(r100);
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(RemoteResourceWithFsUnit r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.encodedSizeWithTag(1, r100.fs_unit);
            Integer r103 = r100.width;
            int r104 = 0;
            if (r103 == null) goto L5;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(3, r103);
        L6:
            int r106 = r102 + r105;
            Integer r107 = r100.height;
            if (r107 == null) goto L9;
            int r108 = ProtoAdapter.INT32.encodedSizeWithTag(4, r107);
        L10:
            int r109 = r106 + r108;
            String r110 = r100.cut_type;
            if (r110 == null) goto L14;
            r104 = r101.encodedSizeWithTag(5, r110);
        L14:
            return (r109 + r104) + r100.unknownFields().size();
        L9:
            r108 = 0;
            goto L10
        L5:
            r105 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ RemoteResourceWithFsUnit decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(RemoteResourceWithFsUnit r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, RemoteResourceWithFsUnit r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.fs_unit);
            Integer r103 = r101.width;
            if (r103 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
        L5:
            Integer r104 = r101.height;
            if (r104 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 4, r104);
        L8:
            String r105 = r101.cut_type;
            if (r105 == null) goto L11;
            r102.encodeWithTag(r100, 5, r105);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, RemoteResourceWithFsUnit r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_RemoteResourceWithFsUnit();
        DEFAULT_WIDTH = 0;
        DEFAULT_HEIGHT = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.fs_unit = this.fs_unit;
        r100.width = this.width;
        r100.height = this.height;
        r100.cut_type = this.cut_type;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return RemoteResourceWithFsUnit.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public RemoteResourceWithFsUnit(String r100, Integer r101, Integer r102, String r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public RemoteResourceWithFsUnit(String r100, Integer r101, Integer r102, String r103, ByteString r104) {
        super(ADAPTER, r104);
        this.fs_unit = r100;
        this.width = r101;
        this.height = r102;
        this.cut_type = r103;
    }
}
