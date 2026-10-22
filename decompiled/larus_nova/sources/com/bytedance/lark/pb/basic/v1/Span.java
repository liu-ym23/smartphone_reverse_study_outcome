package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Span extends com.squareup.wire.Message<Span, Builder> {
    public static final ProtoAdapter<Span> ADAPTER = null;
    public static final Integer DEFAULT_END = null;
    public static final Integer DEFAULT_START = null;
    private static final long serialVersionUID = 0;
    public final Integer end;
    public final Integer start;

    public static final class Builder extends com.squareup.wire.Message.Builder<Span, Builder> {
        public Integer end;
        public Integer start;

        @Override // com.squareup.wire.Message.Builder
        public Span build() {
            Integer r100 = this.start;
            if (r100 == null) goto L9;
            if (this.end == null) goto L9;
            return new Span(this.start, this.end, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "start", this.end, "end"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder end(Integer r100) {
            this.end = r100;
            return this;
        }

        public Builder start(Integer r100) {
            this.start = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Span extends ProtoAdapter<Span> {
        public ProtoAdapter_Span() {
            super(FieldEncoding.LENGTH_DELIMITED, Span.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Span decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.start = 0;
            r101.end = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.start = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.end = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(Span r100) {
            ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
            return (r101.encodedSizeWithTag(1, r100.start) + r101.encodedSizeWithTag(2, r100.end)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Span decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Span r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Span r101) throws IOException {
            ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
            r102.encodeWithTag(r100, 1, r101.start);
            r102.encodeWithTag(r100, 2, r101.end);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Span r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Span();
        DEFAULT_START = 0;
        DEFAULT_END = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.start = this.start;
        r100.end = this.end;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Span.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public Span(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Span(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.start = r100;
        this.end = r101;
    }
}
