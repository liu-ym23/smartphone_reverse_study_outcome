package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class FileStat extends Message<FileStat, Builder> {
    public static final ProtoAdapter<FileStat> ADAPTER = null;
    public static final Long DEFAULT_LAST_ACCESSED_TIME = null;
    public static final Long DEFAULT_LAST_MODIFIED_TIME = null;
    public static final Integer DEFAULT_MODE = null;
    public static final Long DEFAULT_SIZE = null;
    private static final long serialVersionUID = 0;
    public final Long last_accessed_time;
    public final Long last_modified_time;
    public final Integer mode;
    public final Long size;

    public static final class Builder extends Message.Builder<FileStat, Builder> {
        public Long last_accessed_time;
        public Long last_modified_time;
        public Integer mode;
        public Long size;

        @Override // com.squareup.wire.Message.Builder
        public FileStat build() {
            Integer r100 = this.mode;
            if (r100 == null) goto L13;
            if (this.size == null) goto L13;
            if (this.last_accessed_time == null) goto L13;
            if (this.last_modified_time == null) goto L13;
            return new FileStat(this.mode, this.size, this.last_accessed_time, this.last_modified_time, super.buildUnknownFields());
        L13:
            throw Internal.missingRequiredFields(new Object[]{r100, "mode", this.size, "size", this.last_accessed_time, "last_accessed_time", this.last_modified_time, "last_modified_time"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder last_accessed_time(Long r100) {
            this.last_accessed_time = r100;
            return this;
        }

        public Builder last_modified_time(Long r100) {
            this.last_modified_time = r100;
            return this;
        }

        public Builder mode(Integer r100) {
            this.mode = r100;
            return this;
        }

        public Builder size(Long r100) {
            this.size = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FileStat extends ProtoAdapter<FileStat> {
        public ProtoAdapter_FileStat() {
            super(FieldEncoding.LENGTH_DELIMITED, FileStat.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public FileStat decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mode = ProtoAdapter.UINT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.size = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.last_accessed_time = ProtoAdapter.UINT64.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.last_modified_time = ProtoAdapter.UINT64.decode(r100);
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
        public int encodedSize2(FileStat r100) {
            int r101 = ProtoAdapter.UINT32.encodedSizeWithTag(1, r100.mode);
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            return (((r101 + r102.encodedSizeWithTag(2, r100.size)) + r102.encodedSizeWithTag(3, r100.last_accessed_time)) + r102.encodedSizeWithTag(4, r100.last_modified_time)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FileStat decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FileStat r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FileStat r101) throws IOException {
            ProtoAdapter.UINT32.encodeWithTag(r100, 1, r101.mode);
            ProtoAdapter<Long> r102 = ProtoAdapter.UINT64;
            r102.encodeWithTag(r100, 2, r101.size);
            r102.encodeWithTag(r100, 3, r101.last_accessed_time);
            r102.encodeWithTag(r100, 4, r101.last_modified_time);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FileStat r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FileStat();
        DEFAULT_MODE = 0;
        DEFAULT_SIZE = 0L;
        DEFAULT_LAST_ACCESSED_TIME = 0L;
        DEFAULT_LAST_MODIFIED_TIME = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mode = this.mode;
        r100.size = this.size;
        r100.last_accessed_time = this.last_accessed_time;
        r100.last_modified_time = this.last_modified_time;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FileStat.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FileStat(Integer r100, Long r101, Long r102, Long r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FileStat(Integer r100, Long r101, Long r102, Long r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mode = r100;
        this.size = r101;
        this.last_accessed_time = r102;
        this.last_modified_time = r103;
    }
}
