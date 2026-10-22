package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushLanguageAutoTranslateScopeNotify extends Message<PushLanguageAutoTranslateScopeNotify, Builder> {
    public static final ProtoAdapter<PushLanguageAutoTranslateScopeNotify> ADAPTER = null;
    public static final ProtoAdapter_PushLanguageAutoTranslateScopeNotify RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Integer> src_languages_scope;

    public static final class Builder extends Message.Builder<PushLanguageAutoTranslateScopeNotify, Builder> implements d<PushLanguageAutoTranslateScopeNotify> {
        public Map<String, Integer> src_languages_scope;

        @Override // com.squareup.wire.Message.Builder
        public PushLanguageAutoTranslateScopeNotify build() {
            return new PushLanguageAutoTranslateScopeNotify(this.src_languages_scope, super.buildUnknownFields());
        }

        public Builder() {
            this.src_languages_scope = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder src_languages_scope(Map<String, Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.src_languages_scope = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushLanguageAutoTranslateScopeNotify extends ProtoAdapter<PushLanguageAutoTranslateScopeNotify> implements c<PushLanguageAutoTranslateScopeNotify> {
        private final ProtoAdapter<Map<String, Integer>> src_languages_scope;

        public ProtoAdapter_PushLanguageAutoTranslateScopeNotify() {
            super(FieldEncoding.LENGTH_DELIMITED, PushLanguageAutoTranslateScopeNotify.class);
            this.src_languages_scope = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, ProtoAdapter.INT32);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushLanguageAutoTranslateScopeNotify decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.src_languages_scope.putAll(this.src_languages_scope.decode(r100));
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
        public int encodedSize2(PushLanguageAutoTranslateScopeNotify r100) {
            return this.src_languages_scope.encodedSizeWithTag(1, r100.src_languages_scope) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushLanguageAutoTranslateScopeNotify decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushLanguageAutoTranslateScopeNotify r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushLanguageAutoTranslateScopeNotify r101) throws IOException {
            this.src_languages_scope.encodeWithTag(r100, 1, r101.src_languages_scope);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushLanguageAutoTranslateScopeNotify r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_PushLanguageAutoTranslateScopeNotify r100 = new ProtoAdapter_PushLanguageAutoTranslateScopeNotify();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.src_languages_scope = Internal.copyOf("src_languages_scope", this.src_languages_scope);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushLanguageAutoTranslateScopeNotify.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushLanguageAutoTranslateScopeNotify(Map<String, Integer> r100) {
        this(r100, ByteString.EMPTY);
    }

    public PushLanguageAutoTranslateScopeNotify(Map<String, Integer> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.src_languages_scope = Internal.immutableCopyOf("src_languages_scope", r100);
    }
}
