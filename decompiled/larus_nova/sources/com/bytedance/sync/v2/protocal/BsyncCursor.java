package com.bytedance.sync.v2.protocal;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireField;
import com.squareup.wire.internal.Internal;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes22.dex */
public final class BsyncCursor extends Message<BsyncCursor, Builder> {
    public static final ProtoAdapter<BsyncCursor> ADAPTER = null;
    public static final Long DEFAULT_CURSOR = null;
    private static final long serialVersionUID = 0;

    @WireField(adapter = "com.squareup.wire.ProtoAdapter#INT64", label = WireField.Label.REQUIRED, tag = 1)
    public final Long cursor;

    public static final class Builder extends Message.Builder<BsyncCursor, Builder> {
        public Long cursor;

        @Override // com.squareup.wire.Message.Builder
        public BsyncCursor build() {
            Long r100 = this.cursor;
            if (r100 == null) goto L7;
            return new BsyncCursor(this.cursor, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, EffectConfiguration.KEY_CURSOR});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder cursor(Long r100) {
            this.cursor = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_BsyncCursor extends ProtoAdapter<BsyncCursor> {
        public ProtoAdapter_BsyncCursor() {
            super(FieldEncoding.LENGTH_DELIMITED, BsyncCursor.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public BsyncCursor decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.cursor(ProtoAdapter.INT64.decode(r100));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L9:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(BsyncCursor r100) {
            return ProtoAdapter.INT64.encodedSizeWithTag(1, r100.cursor) + r100.unknownFields().size();
        }

        /* JADX INFO: renamed from: redact, reason: avoid collision after fix types in other method */
        public BsyncCursor redact2(BsyncCursor r100) {
            Builder r101 = r100.newBuilder();
            r101.clearUnknownFields();
            return r101.build();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncCursor decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(BsyncCursor r100) {
            return encodedSize2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ BsyncCursor redact(BsyncCursor r100) {
            return redact2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, BsyncCursor r101) throws IOException {
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r101.cursor);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, BsyncCursor r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_BsyncCursor();
        DEFAULT_CURSOR = 0L;
    }

    public int hashCode() {
        int r100 = this.hashCode;
        if (r100 != 0) goto L6;
        int r101 = (unknownFields().hashCode() * 37) + this.cursor.hashCode();
        this.hashCode = r101;
        return r101;
    L6:
        return r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.cursor = this.cursor;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        StringBuilder r100 = new StringBuilder();
        r100.append(", cursor=");
        r100.append(this.cursor);
        StringBuilder r101 = r100.replace(0, 2, "BsyncCursor{");
        r101.append('}');
        return r101.toString();
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public BsyncCursor(Long r100) {
        this(r100, ByteString.EMPTY);
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof BsyncCursor) == true) goto L8;
        return false;
    L8:
        BsyncCursor r101 = (BsyncCursor) r100;
        if (unknownFields().equals(r101.unknownFields()) == true) goto L11;
    L13:
        return false;
    L11:
        if (this.cursor.equals(r101.cursor) == false) goto L13;
        return true;
    }

    public BsyncCursor(Long r100, ByteString r101) {
        super(ADAPTER, r101);
        this.cursor = r100;
    }
}
