package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class ElementRefs extends com.squareup.wire.Message<ElementRefs, Builder> {
    public static final ProtoAdapter<ElementRefs> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, Refs> element_refs;

    public static final class Builder extends com.squareup.wire.Message.Builder<ElementRefs, Builder> {
        public Map<String, Refs> element_refs;

        @Override // com.squareup.wire.Message.Builder
        public ElementRefs build() {
            return new ElementRefs(this.element_refs, super.buildUnknownFields());
        }

        public Builder() {
            this.element_refs = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder element_refs(Map<String, Refs> r100) {
            Internal.checkElementsNotNull(r100);
            this.element_refs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ElementRefs extends ProtoAdapter<ElementRefs> {
        private final ProtoAdapter<Map<String, Refs>> element_refs;

        public ProtoAdapter_ElementRefs() {
            super(FieldEncoding.LENGTH_DELIMITED, ElementRefs.class);
            this.element_refs = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Refs.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ElementRefs decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.element_refs.putAll(this.element_refs.decode(r100));
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
        public int encodedSize2(ElementRefs r100) {
            return this.element_refs.encodedSizeWithTag(1, r100.element_refs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ElementRefs decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ElementRefs r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ElementRefs r101) throws IOException {
            this.element_refs.encodeWithTag(r100, 1, r101.element_refs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ElementRefs r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_ElementRefs();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.element_refs = Internal.copyOf("element_refs", this.element_refs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ElementRefs.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public ElementRefs(Map<String, Refs> r100) {
        this(r100, ByteString.EMPTY);
    }

    public ElementRefs(Map<String, Refs> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.element_refs = Internal.immutableCopyOf("element_refs", r100);
    }
}
