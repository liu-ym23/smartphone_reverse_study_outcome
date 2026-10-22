package com.bytedance.lark.pb.vote.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Paginated extends Message<Paginated, Builder> {
    public static final ProtoAdapter<Paginated> ADAPTER = null;
    public static final Boolean DEFAULT_HAS_MORE = null;
    public static final Boolean DEFAULT_IS_LIMITED_BY_SECURITY = null;
    public static final Long DEFAULT_NEXT_CURSOR = null;
    private static final long serialVersionUID = 0;
    public final Boolean has_more;
    public final Boolean is_limited_by_security;
    public final Long next_cursor;

    public static final class Builder extends Message.Builder<Paginated, Builder> {
        public Boolean has_more;
        public Boolean is_limited_by_security;
        public Long next_cursor;

        @Override // com.squareup.wire.Message.Builder
        public Paginated build() {
            return new Paginated(this.next_cursor, this.has_more, this.is_limited_by_security, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder has_more(Boolean r100) {
            this.has_more = r100;
            return this;
        }

        public Builder is_limited_by_security(Boolean r100) {
            this.is_limited_by_security = r100;
            return this;
        }

        public Builder next_cursor(Long r100) {
            this.next_cursor = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Paginated extends ProtoAdapter<Paginated> {
        public ProtoAdapter_Paginated() {
            super(FieldEncoding.LENGTH_DELIMITED, Paginated.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Paginated decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.next_cursor = 0L;
            Boolean r102 = Boolean.FALSE;
            r101.has_more = r102;
            r101.is_limited_by_security = r102;
            long r103 = r100.beginMessage();
        L3:
            int r104 = r100.nextTag();
            if (r104 == (-1)) goto L15;
            if (r104 != 1) goto L8;
            r101.next_cursor = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r104 != 2) goto L10;
            r101.has_more = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r104 != 3) goto L11;
            r101.is_limited_by_security = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L11:
            FieldEncoding r105 = r100.peekFieldEncoding();
            r101.addUnknownField(r104, r105, r105.rawProtoAdapter().decode(r100));
            goto L3
        L15:
            r100.endMessage(r103);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(Paginated r100) {
            Long r101 = r100.next_cursor;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            Boolean r104 = r100.has_more;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Boolean r107 = r100.is_limited_by_security;
            if (r107 == null) goto L14;
            r102 = ProtoAdapter.BOOL.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ Paginated decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Paginated r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Paginated r101) throws IOException {
            Long r102 = r101.next_cursor;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            Boolean r103 = r101.has_more;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r103);
        L8:
            Boolean r104 = r101.is_limited_by_security;
            if (r104 == null) goto L11;
            ProtoAdapter.BOOL.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Paginated r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Paginated();
        DEFAULT_NEXT_CURSOR = 0L;
        Boolean r100 = Boolean.FALSE;
        DEFAULT_HAS_MORE = r100;
        DEFAULT_IS_LIMITED_BY_SECURITY = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.next_cursor = this.next_cursor;
        r100.has_more = this.has_more;
        r100.is_limited_by_security = this.is_limited_by_security;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Paginated.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Paginated(Long r100, Boolean r101, Boolean r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public Paginated(Long r100, Boolean r101, Boolean r102, ByteString r103) {
        super(ADAPTER, r103);
        this.next_cursor = r100;
        this.has_more = r101;
        this.is_limited_by_security = r102;
    }
}
