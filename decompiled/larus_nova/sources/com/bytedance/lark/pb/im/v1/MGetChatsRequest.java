package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class MGetChatsRequest extends Message<MGetChatsRequest, Builder> {
    public static final ProtoAdapter<MGetChatsRequest> ADAPTER = null;
    public static final Boolean DEFAULT_SHOULD_AUTH = null;
    public static final Source DEFAULT_SOURCE = null;
    public static final SyncDataStrategy DEFAULT_STRATEGY = null;
    public static final ProtoAdapter_MGetChatsRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> chat_ids;
    public final Boolean should_auth;
    public final Source source;
    public final SyncDataStrategy strategy;

    public static final class Builder extends Message.Builder<MGetChatsRequest, Builder> implements d<MGetChatsRequest> {
        public List<String> chat_ids;
        public Boolean should_auth;
        public Source source;
        public SyncDataStrategy strategy;

        @Override // com.squareup.wire.Message.Builder
        public MGetChatsRequest build() {
            return new MGetChatsRequest(this.chat_ids, this.should_auth, this.strategy, this.source, super.buildUnknownFields());
        }

        public Builder() {
            this.chat_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.chat_ids = r100;
            return this;
        }

        public Builder should_auth(Boolean r100) {
            this.should_auth = r100;
            return this;
        }

        public Builder source(Source r100) {
            this.source = r100;
            return this;
        }

        public Builder strategy(SyncDataStrategy r100) {
            this.strategy = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetChatsRequest extends ProtoAdapter<MGetChatsRequest> implements c<MGetChatsRequest> {
        public ProtoAdapter_MGetChatsRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetChatsRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetChatsRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.should_auth = Boolean.FALSE;
            r101.strategy = SyncDataStrategy.TRY_LOCAL;
            r101.source = Source.UNKNOWN;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.should_auth = ProtoAdapter.BOOL.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.strategy = SyncDataStrategy.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.source = Source.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L24:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MGetChatsRequest r100) {
            int r101 = ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(1, r100.chat_ids);
            Boolean r102 = r100.should_auth;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = ProtoAdapter.BOOL.encodedSizeWithTag(2, r102);
        L6:
            int r105 = r101 + r104;
            SyncDataStrategy r106 = r100.strategy;
            if (r106 == null) goto L9;
            int r107 = SyncDataStrategy.ADAPTER.encodedSizeWithTag(3, r106);
        L10:
            int r108 = r105 + r107;
            Source r109 = r100.source;
            if (r109 == null) goto L14;
            r103 = Source.ADAPTER.encodedSizeWithTag(4, r109);
        L14:
            return (r108 + r103) + r100.unknownFields().size();
        L9:
            r107 = 0;
            goto L10
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetChatsRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetChatsRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetChatsRequest r101) throws IOException {
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 1, r101.chat_ids);
            Boolean r102 = r101.should_auth;
            if (r102 == null) goto L5;
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r102);
        L5:
            SyncDataStrategy r103 = r101.strategy;
            if (r103 == null) goto L8;
            SyncDataStrategy.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            Source r104 = r101.source;
            if (r104 == null) goto L11;
            Source.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetChatsRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Source extends Enum<Source> implements WireEnum {
        private static final /* synthetic */ Source[] $VALUES = null;
        public static final ProtoAdapter<Source> ADAPTER = null;
        public static final Source CHAT_WINDOW = null;
        public static final Source UNKNOWN = null;
        private final int value;

        static {
            Source r100 = new Source("UNKNOWN", 0, 1);
            UNKNOWN = r100;
            Source r101 = new Source("CHAT_WINDOW", 1, 2);
            CHAT_WINDOW = r101;
            $VALUES = new Source[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(Source.class);
        }

        public static Source[] values() {
            return (Source[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Source fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return CHAT_WINDOW;
        L11:
            return UNKNOWN;
        }

        public static Source valueOf(String r100) {
            return (Source) a.a(Source.class, r100);
        }

        private Source(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_MGetChatsRequest r100 = new ProtoAdapter_MGetChatsRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SHOULD_AUTH = Boolean.FALSE;
        DEFAULT_STRATEGY = SyncDataStrategy.TRY_LOCAL;
        DEFAULT_SOURCE = Source.UNKNOWN;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_ids = Internal.copyOf("chat_ids", this.chat_ids);
        r100.should_auth = this.should_auth;
        r100.strategy = this.strategy;
        r100.source = this.source;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetChatsRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetChatsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Source r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MGetChatsRequest(List<String> r100, Boolean r101, SyncDataStrategy r102, Source r103, ByteString r104) {
        super(ADAPTER, r104);
        this.chat_ids = Internal.immutableCopyOf("chat_ids", r100);
        this.should_auth = r101;
        this.strategy = r102;
        this.source = r103;
    }
}
