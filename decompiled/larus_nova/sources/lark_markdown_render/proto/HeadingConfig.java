package lark_markdown_render.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class HeadingConfig extends Message<HeadingConfig, Builder> {
    public static final ProtoAdapter<HeadingConfig> ADAPTER = null;
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: h1, reason: collision with root package name */
    public final HeadingLevelConfig f508269h1;

    /* JADX INFO: renamed from: h2, reason: collision with root package name */
    public final HeadingLevelConfig f508270h2;

    /* JADX INFO: renamed from: h3, reason: collision with root package name */
    public final HeadingLevelConfig f508271h3;

    /* JADX INFO: renamed from: h4, reason: collision with root package name */
    public final HeadingLevelConfig f508272h4;

    /* JADX INFO: renamed from: h5, reason: collision with root package name */
    public final HeadingLevelConfig f508273h5;

    /* JADX INFO: renamed from: h6, reason: collision with root package name */
    public final HeadingLevelConfig f508274h6;

    public static final class Builder extends Message.Builder<HeadingConfig, Builder> {

        /* JADX INFO: renamed from: h1, reason: collision with root package name */
        public HeadingLevelConfig f508275h1;

        /* JADX INFO: renamed from: h2, reason: collision with root package name */
        public HeadingLevelConfig f508276h2;

        /* JADX INFO: renamed from: h3, reason: collision with root package name */
        public HeadingLevelConfig f508277h3;

        /* JADX INFO: renamed from: h4, reason: collision with root package name */
        public HeadingLevelConfig f508278h4;

        /* JADX INFO: renamed from: h5, reason: collision with root package name */
        public HeadingLevelConfig f508279h5;

        /* JADX INFO: renamed from: h6, reason: collision with root package name */
        public HeadingLevelConfig f508280h6;

        @Override // com.squareup.wire.Message.Builder
        public HeadingConfig build() {
            return new HeadingConfig(this.f508275h1, this.f508276h2, this.f508277h3, this.f508278h4, this.f508279h5, this.f508280h6, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder h1(HeadingLevelConfig r100) {
            this.f508275h1 = r100;
            return this;
        }

        public Builder h2(HeadingLevelConfig r100) {
            this.f508276h2 = r100;
            return this;
        }

        public Builder h3(HeadingLevelConfig r100) {
            this.f508277h3 = r100;
            return this;
        }

        public Builder h4(HeadingLevelConfig r100) {
            this.f508278h4 = r100;
            return this;
        }

        public Builder h5(HeadingLevelConfig r100) {
            this.f508279h5 = r100;
            return this;
        }

        public Builder h6(HeadingLevelConfig r100) {
            this.f508280h6 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_HeadingConfig extends ProtoAdapter<HeadingConfig> {
        public ProtoAdapter_HeadingConfig() {
            super(FieldEncoding.LENGTH_DELIMITED, HeadingConfig.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public HeadingConfig decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L13;
            switch(r103) {
                case 1: goto L12;
                case 2: goto L11;
                case 3: goto L10;
                case 4: goto L9;
                case 5: goto L8;
                case 6: goto L7;
                default: goto L6;
            };
        L7:
            r101.f508280h6 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L8:
            r101.f508279h5 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L9:
            r101.f508278h4 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L10:
            r101.f508277h3 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L11:
            r101.f508276h2 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L12:
            r101.f508275h1 = HeadingLevelConfig.ADAPTER.decode(r100);
            goto L3
        L6:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L13:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(HeadingConfig r100) {
            HeadingLevelConfig r101 = r100.f508269h1;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            HeadingLevelConfig r104 = r100.f508270h2;
            if (r104 == null) goto L9;
            int r105 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            HeadingLevelConfig r107 = r100.f508271h3;
            if (r107 == null) goto L13;
            int r108 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            HeadingLevelConfig r110 = r100.f508272h4;
            if (r110 == null) goto L17;
            int r111 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            int r112 = r109 + r111;
            HeadingLevelConfig r113 = r100.f508273h5;
            if (r113 == null) goto L21;
            int r114 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(5, r113);
        L22:
            int r115 = r112 + r114;
            HeadingLevelConfig r116 = r100.f508274h6;
            if (r116 == null) goto L26;
            r102 = HeadingLevelConfig.ADAPTER.encodedSizeWithTag(6, r116);
        L26:
            return (r115 + r102) + r100.unknownFields().size();
        L21:
            r114 = 0;
            goto L22
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
        public /* bridge */ /* synthetic */ HeadingConfig decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(HeadingConfig r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, HeadingConfig r101) throws IOException {
            HeadingLevelConfig r102 = r101.f508269h1;
            if (r102 == null) goto L5;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            HeadingLevelConfig r103 = r101.f508270h2;
            if (r103 == null) goto L8;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            HeadingLevelConfig r104 = r101.f508271h3;
            if (r104 == null) goto L11;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            HeadingLevelConfig r105 = r101.f508272h4;
            if (r105 == null) goto L14;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            HeadingLevelConfig r106 = r101.f508273h5;
            if (r106 == null) goto L17;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 5, r106);
        L17:
            HeadingLevelConfig r107 = r101.f508274h6;
            if (r107 == null) goto L20;
            HeadingLevelConfig.ADAPTER.encodeWithTag(r100, 6, r107);
        L20:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, HeadingConfig r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_HeadingConfig();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.f508275h1 = this.f508269h1;
        r100.f508276h2 = this.f508270h2;
        r100.f508277h3 = this.f508271h3;
        r100.f508278h4 = this.f508272h4;
        r100.f508279h5 = this.f508273h5;
        r100.f508280h6 = this.f508274h6;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return HeadingConfig.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public HeadingConfig(HeadingLevelConfig r100, HeadingLevelConfig r110, HeadingLevelConfig r111, HeadingLevelConfig r112, HeadingLevelConfig r113, HeadingLevelConfig r114) {
        this(r100, r110, r111, r112, r113, r114, ByteString.EMPTY);
    }

    public HeadingConfig(HeadingLevelConfig r100, HeadingLevelConfig r101, HeadingLevelConfig r102, HeadingLevelConfig r103, HeadingLevelConfig r104, HeadingLevelConfig r105, ByteString r106) {
        super(ADAPTER, r106);
        this.f508269h1 = r100;
        this.f508270h2 = r101;
        this.f508271h3 = r102;
        this.f508272h4 = r103;
        this.f508273h5 = r104;
        this.f508274h6 = r105;
    }
}
