package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class MentionContentStyle extends com.squareup.wire.Message<MentionContentStyle, Builder> {
    public static final ProtoAdapter<MentionContentStyle> ADAPTER = null;
    public static final Boolean DEFAULT_IS_AVAILABLE = null;
    private static final long serialVersionUID = 0;
    public final Boolean is_available;

    public static final class Builder extends com.squareup.wire.Message.Builder<MentionContentStyle, Builder> {
        public Boolean is_available;

        @Override // com.squareup.wire.Message.Builder
        public MentionContentStyle build() {
            Boolean r100 = this.is_available;
            if (r100 == null) goto L7;
            return new MentionContentStyle(this.is_available, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "is_available"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder is_available(Boolean r100) {
            this.is_available = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MentionContentStyle extends ProtoAdapter<MentionContentStyle> {
        public ProtoAdapter_MentionContentStyle() {
            super(FieldEncoding.LENGTH_DELIMITED, MentionContentStyle.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MentionContentStyle decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.is_available = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.is_available = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(MentionContentStyle r100) {
            return ProtoAdapter.BOOL.encodedSizeWithTag(1, r100.is_available) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MentionContentStyle decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MentionContentStyle r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MentionContentStyle r101) throws IOException {
            ProtoAdapter.BOOL.encodeWithTag(r100, 1, r101.is_available);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MentionContentStyle r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MentionContentStyle();
        DEFAULT_IS_AVAILABLE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.is_available = this.is_available;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MentionContentStyle.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public MentionContentStyle(Boolean r100) {
        this(r100, ByteString.EMPTY);
    }

    public MentionContentStyle(Boolean r100, ByteString r101) {
        super(ADAPTER, r101);
        this.is_available = r100;
    }
}
