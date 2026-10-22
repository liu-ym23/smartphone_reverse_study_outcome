package com.bytedance.lark.pb.todo.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class Progress extends Message<Progress, Builder> {
    public static final ProtoAdapter<Progress> ADAPTER = null;
    public static final Integer DEFAULT_COMPLETED = null;
    public static final Integer DEFAULT_TOTAL = null;
    private static final long serialVersionUID = 0;
    public final Integer completed;
    public final Integer total;

    public static final class Builder extends Message.Builder<Progress, Builder> {
        public Integer completed;
        public Integer total;

        @Override // com.squareup.wire.Message.Builder
        public Progress build() {
            return new Progress(this.total, this.completed, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder completed(Integer r100) {
            this.completed = r100;
            return this;
        }

        public Builder total(Integer r100) {
            this.total = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_Progress extends ProtoAdapter<Progress> {
        public ProtoAdapter_Progress() {
            super(FieldEncoding.LENGTH_DELIMITED, Progress.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public Progress decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.total = 0;
            r101.completed = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.total = ProtoAdapter.INT32.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.completed = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(Progress r100) {
            Integer r101 = r100.total;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L6:
            Integer r104 = r100.completed;
            if (r104 == null) goto L10;
            r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ Progress decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(Progress r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, Progress r101) throws IOException {
            Integer r102 = r101.total;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            Integer r103 = r101.completed;
            if (r103 == null) goto L8;
            ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Progress r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_Progress();
        DEFAULT_TOTAL = 0;
        DEFAULT_COMPLETED = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.total = this.total;
        r100.completed = this.completed;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return Progress.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public Progress(Integer r100, Integer r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public Progress(Integer r100, Integer r101, ByteString r102) {
        super(ADAPTER, r102);
        this.total = r100;
        this.completed = r101;
    }
}
