package com.bytedance.lark.pb.tool.v1;

import com.bytedance.lark.pb.basic.v1.DomainSettings;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class SetDomainAliasRequest extends Message<SetDomainAliasRequest, Builder> {
    public static final ProtoAdapter<SetDomainAliasRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, DomainSettings.Alias> domain2alias;

    public static final class Builder extends Message.Builder<SetDomainAliasRequest, Builder> {
        public Map<String, DomainSettings.Alias> domain2alias;

        @Override // com.squareup.wire.Message.Builder
        public SetDomainAliasRequest build() {
            return new SetDomainAliasRequest(this.domain2alias, super.buildUnknownFields());
        }

        public Builder() {
            this.domain2alias = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder domain2alias(Map<String, DomainSettings.Alias> r100) {
            Internal.checkElementsNotNull(r100);
            this.domain2alias = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SetDomainAliasRequest extends ProtoAdapter<SetDomainAliasRequest> {
        private final ProtoAdapter<Map<String, DomainSettings.Alias>> domain2alias;

        public ProtoAdapter_SetDomainAliasRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SetDomainAliasRequest.class);
            this.domain2alias = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, DomainSettings.Alias.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SetDomainAliasRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.domain2alias.putAll(this.domain2alias.decode(r100));
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
        public int encodedSize2(SetDomainAliasRequest r100) {
            return this.domain2alias.encodedSizeWithTag(1, r100.domain2alias) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SetDomainAliasRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SetDomainAliasRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SetDomainAliasRequest r101) throws IOException {
            this.domain2alias.encodeWithTag(r100, 1, r101.domain2alias);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SetDomainAliasRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_SetDomainAliasRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.domain2alias = Internal.copyOf("domain2alias", this.domain2alias);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SetDomainAliasRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SetDomainAliasRequest(Map<String, DomainSettings.Alias> r100) {
        this(r100, ByteString.EMPTY);
    }

    public SetDomainAliasRequest(Map<String, DomainSettings.Alias> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.domain2alias = Internal.immutableCopyOf("domain2alias", r100);
    }
}
