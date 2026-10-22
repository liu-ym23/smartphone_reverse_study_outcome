package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class TurtleCanvasContent extends com.squareup.wire.Message<TurtleCanvasContent, Builder> {
    public static final ProtoAdapter<TurtleCanvasContent> ADAPTER = null;
    public static final ByteString DEFAULT_DATA = null;
    public static final String DEFAULT_SCRIPT_KEY = "";
    public static final String DEFAULT_SCRIPT_PATH = "";
    public static final Integer DEFAULT_SCRIPT_VERSION = null;
    private static final long serialVersionUID = 0;
    public final ByteString data;
    public final String script_key;
    public final String script_path;
    public final Integer script_version;

    public static final class Builder extends com.squareup.wire.Message.Builder<TurtleCanvasContent, Builder> {
        public ByteString data;
        public String script_key;
        public String script_path;
        public Integer script_version;

        @Override // com.squareup.wire.Message.Builder
        public TurtleCanvasContent build() {
            return new TurtleCanvasContent(this.script_key, this.script_version, this.script_path, this.data, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder data(ByteString r100) {
            this.data = r100;
            return this;
        }

        public Builder script_key(String r100) {
            this.script_key = r100;
            return this;
        }

        public Builder script_path(String r100) {
            this.script_path = r100;
            return this;
        }

        public Builder script_version(Integer r100) {
            this.script_version = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_TurtleCanvasContent extends ProtoAdapter<TurtleCanvasContent> {
        public ProtoAdapter_TurtleCanvasContent() {
            super(FieldEncoding.LENGTH_DELIMITED, TurtleCanvasContent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public TurtleCanvasContent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.script_key = "";
            r101.script_version = 0;
            r101.script_path = "";
            r101.data = ByteString.EMPTY;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.script_key = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.script_version = ProtoAdapter.INT32.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.script_path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.data = ProtoAdapter.BYTES.decode(r100);
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
        public int encodedSize2(TurtleCanvasContent r100) {
            String r101 = r100.script_key;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.script_version;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            String r107 = r100.script_path;
            if (r107 == null) goto L13;
            int r108 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteString r110 = r100.data;
            if (r110 == null) goto L18;
            r102 = ProtoAdapter.BYTES.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
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
        public /* bridge */ /* synthetic */ TurtleCanvasContent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(TurtleCanvasContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, TurtleCanvasContent r101) throws IOException {
            String r102 = r101.script_key;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.script_version;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            String r104 = r101.script_path;
            if (r104 == null) goto L11;
            ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
        L11:
            ByteString r105 = r101.data;
            if (r105 == null) goto L14;
            ProtoAdapter.BYTES.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, TurtleCanvasContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_TurtleCanvasContent();
        DEFAULT_SCRIPT_VERSION = 0;
        DEFAULT_DATA = ByteString.EMPTY;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.script_key = this.script_key;
        r100.script_version = this.script_version;
        r100.script_path = this.script_path;
        r100.data = this.data;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return TurtleCanvasContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public TurtleCanvasContent(String r100, Integer r101, String r102, ByteString r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public TurtleCanvasContent(String r100, Integer r101, String r102, ByteString r103, ByteString r104) {
        super(ADAPTER, r104);
        this.script_key = r100;
        this.script_version = r101;
        this.script_path = r102;
        this.data = r103;
    }
}
