package open_pkm.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class DiffPath extends Message<DiffPath, Builder> {
    public static final ProtoAdapter<DiffPath> ADAPTER = null;
    public static final String DEFAULT_PATH = "";
    public static final String DEFAULT_PATH_MD5 = "";
    private static final long serialVersionUID = 0;
    public final String path;
    public final String path_md5;

    public static final class Builder extends Message.Builder<DiffPath, Builder> {
        public String path;
        public String path_md5;

        @Override // com.squareup.wire.Message.Builder
        public DiffPath build() {
            String r100 = this.path;
            if (r100 == null) goto L9;
            if (this.path_md5 == null) goto L9;
            return new DiffPath(this.path, this.path_md5, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "path", this.path_md5, "path_md5"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder path(String r100) {
            this.path = r100;
            return this;
        }

        public Builder path_md5(String r100) {
            this.path_md5 = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DiffPath extends ProtoAdapter<DiffPath> {
        public ProtoAdapter_DiffPath() {
            super(FieldEncoding.LENGTH_DELIMITED, DiffPath.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public DiffPath decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.path = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.path_md5 = ProtoAdapter.STRING.decode(r100);
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
        public int encodedSize2(DiffPath r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.path) + r101.encodedSizeWithTag(2, r100.path_md5)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DiffPath decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DiffPath r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DiffPath r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.path);
            r102.encodeWithTag(r100, 2, r101.path_md5);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DiffPath r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DiffPath();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.path = this.path;
        r100.path_md5 = this.path_md5;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DiffPath.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DiffPath(String r100, String r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public DiffPath(String r100, String r101, ByteString r102) {
        super(ADAPTER, r102);
        this.path = r100;
        this.path_md5 = r101;
    }
}
