package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushAutoTranslateScopeNotify extends Message<PushAutoTranslateScopeNotify, Builder> {
    public static final ProtoAdapter<PushAutoTranslateScopeNotify> ADAPTER = null;
    public static final Integer DEFAULT_SCOPES = null;
    public static final ProtoAdapter_PushAutoTranslateScopeNotify RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Integer scopes;

    public static final class Builder extends Message.Builder<PushAutoTranslateScopeNotify, Builder> implements d<PushAutoTranslateScopeNotify> {
        public Integer scopes;

        @Override // com.squareup.wire.Message.Builder
        public PushAutoTranslateScopeNotify build() {
            return new PushAutoTranslateScopeNotify(this.scopes, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder scopes(Integer r100) {
            this.scopes = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushAutoTranslateScopeNotify extends ProtoAdapter<PushAutoTranslateScopeNotify> implements c<PushAutoTranslateScopeNotify> {
        public ProtoAdapter_PushAutoTranslateScopeNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, PushAutoTranslateScopeNotify.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushAutoTranslateScopeNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.scopes = 0;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.scopes = ProtoAdapter.INT32.decode(r100);
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
        public int encodedSize2(PushAutoTranslateScopeNotify r100) {
            Integer r101 = r100.scopes;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.INT32.encodedSizeWithTag(1, r101);
        L7:
            return r102 + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushAutoTranslateScopeNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushAutoTranslateScopeNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushAutoTranslateScopeNotify r101) throws IOException {
            Integer r102 = r101.scopes;
            if (r102 == null) goto L5;
            ProtoAdapter.INT32.encodeWithTag(r100, 1, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushAutoTranslateScopeNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushAutoTranslateScopeNotify r100 = new ProtoAdapter_PushAutoTranslateScopeNotify();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SCOPES = 0;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.scopes = this.scopes;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushAutoTranslateScopeNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushAutoTranslateScopeNotify(Integer r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushAutoTranslateScopeNotify(Integer r100, ByteString r101) {
        super(ADAPTER, r101);
        this.scopes = r100;
    }
}
