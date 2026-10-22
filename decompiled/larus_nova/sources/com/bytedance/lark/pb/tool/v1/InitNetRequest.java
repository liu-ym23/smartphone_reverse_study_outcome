package com.bytedance.lark.pb.tool.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class InitNetRequest extends Message<InitNetRequest, Builder> {
    public static final ProtoAdapter<InitNetRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<HostAlias> optimized_alias;

    public static final class Builder extends Message.Builder<InitNetRequest, Builder> {
        public List<HostAlias> optimized_alias;

        @Override // com.squareup.wire.Message.Builder
        public InitNetRequest build() {
            return new InitNetRequest(this.optimized_alias, super.buildUnknownFields());
        }

        public Builder() {
            this.optimized_alias = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder optimized_alias(List<HostAlias> r100) {
            Internal.checkElementsNotNull(r100);
            this.optimized_alias = r100;
            return this;
        }
    }

    public static final enum HostAlias extends Enum<HostAlias> implements WireEnum {
        private static final /* synthetic */ HostAlias[] $VALUES = null;
        public static final ProtoAdapter<HostAlias> ADAPTER = null;
        public static final HostAlias DOCS_API = null;
        public static final HostAlias DOCS_DRIVE = null;
        public static final HostAlias MINA = null;
        public static final HostAlias OPEN = null;
        private final int value;

        static {
            HostAlias r100 = new HostAlias("DOCS_API", 0, 1);
            DOCS_API = r100;
            HostAlias r101 = new HostAlias("MINA", 1, 2);
            MINA = r101;
            HostAlias r102 = new HostAlias("OPEN", 2, 3);
            OPEN = r102;
            HostAlias r103 = new HostAlias("DOCS_DRIVE", 3, 4);
            DOCS_DRIVE = r103;
            $VALUES = new HostAlias[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(HostAlias.class);
        }

        public static HostAlias[] values() {
            return (HostAlias[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static HostAlias fromValue(int r100) {
            if (r100 == 1) goto L19;
            if (r100 == 2) goto L17;
            if (r100 == 3) goto L15;
            if (r100 == 4) goto L13;
            return null;
        L13:
            return DOCS_DRIVE;
        L15:
            return OPEN;
        L17:
            return MINA;
        L19:
            return DOCS_API;
        }

        public static HostAlias valueOf(String r100) {
            return (HostAlias) a.a(HostAlias.class, r100);
        }

        private HostAlias(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_InitNetRequest extends ProtoAdapter<InitNetRequest> {
        public ProtoAdapter_InitNetRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, InitNetRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public InitNetRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L7;
            r101.optimized_alias.add(HostAlias.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L10
        L10:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L7:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(InitNetRequest r100) {
            return HostAlias.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.optimized_alias) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ InitNetRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(InitNetRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, InitNetRequest r101) throws IOException {
            HostAlias.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.optimized_alias);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, InitNetRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_InitNetRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.optimized_alias = Internal.copyOf("optimized_alias", this.optimized_alias);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return InitNetRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public InitNetRequest(List<HostAlias> r100) {
        this(r100, ByteString.EMPTY);
    }

    public InitNetRequest(List<HostAlias> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.optimized_alias = Internal.immutableCopyOf("optimized_alias", r100);
    }
}
