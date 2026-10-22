package lark_biz_feed.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class ListStatus extends Message<ListStatus, Builder> {
    public static final ProtoAdapter<ListStatus> ADAPTER = null;
    public static final Boolean DEFAULT_IS_EMPTY = null;
    public static final Boolean DEFAULT_IS_LOADING = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_empty;
    public final Boolean is_loading;

    public static final class Builder extends Message.Builder<ListStatus, Builder> {
        public Boolean is_empty;
        public Boolean is_loading;

        @Override // com.squareup.wire.Message.Builder
        public ListStatus build() {
            Boolean r100 = this.is_loading;
            if (r100 == null) goto L9;
            if (this.is_empty == null) goto L9;
            return new ListStatus(this.is_loading, this.is_empty, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_loading", this.is_empty, "is_empty"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder is_empty(Boolean r100) {
            this.is_empty = r100;
            return this;
        }

        public Builder is_loading(Boolean r100) {
            this.is_loading = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ListStatus extends ProtoAdapter<ListStatus> {
        public ProtoAdapter_ListStatus() {
            super(FieldEncoding.LENGTH_DELIMITED, ListStatus.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public ListStatus decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.is_loading = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.is_empty = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(ListStatus r100) {
            ProtoAdapter<Boolean> r101 = ProtoAdapter.BOOL;
            return (r101.encodedSizeWithTag(1, r100.is_loading) + r101.encodedSizeWithTag(2, r100.is_empty)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ListStatus decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ListStatus r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ListStatus r101) throws IOException {
            ProtoAdapter<Boolean> r102 = ProtoAdapter.BOOL;
            r102.encodeWithTag(r100, 1, r101.is_loading);
            r102.encodeWithTag(r100, 2, r101.is_empty);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ListStatus r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ListStatus();
        Boolean r100 = Boolean.FALSE;
        DEFAULT_IS_LOADING = r100;
        DEFAULT_IS_EMPTY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_loading = this.is_loading;
        r100.is_empty = this.is_empty;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ListStatus.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ListStatus(Boolean r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ListStatus(Boolean r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.is_loading = r100;
        this.is_empty = r101;
    }
}
