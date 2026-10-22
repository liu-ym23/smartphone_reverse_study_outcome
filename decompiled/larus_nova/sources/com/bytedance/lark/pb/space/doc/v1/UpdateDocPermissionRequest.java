package com.bytedance.lark.pb.space.doc.v1;

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
public final class UpdateDocPermissionRequest extends Message<UpdateDocPermissionRequest, Builder> {
    public static final ProtoAdapter<UpdateDocPermissionRequest> ADAPTER = null;
    public static final ProtoAdapter_UpdateDocPermissionRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<Pair> pairs;

    public static final class Builder extends Message.Builder<UpdateDocPermissionRequest, Builder> implements d<UpdateDocPermissionRequest> {
        public List<Pair> pairs;

        @Override // com.squareup.wire.Message.Builder
        public UpdateDocPermissionRequest build() {
            return new UpdateDocPermissionRequest(this.pairs, super.buildUnknownFields());
        }

        public Builder() {
            this.pairs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder pairs(List<Pair> r100) {
            Internal.checkElementsNotNull(r100);
            this.pairs = r100;
            return this;
        }
    }

    public static final class Pair extends Message<Pair, Builder> {
        public static final ProtoAdapter<Pair> ADAPTER = null;
        public static final String DEFAULT_MESSAGE_ID = "";
        public static final Permission DEFAULT_PERM = null;
        public static final String DEFAULT_TOKEN = "";
        private static final long serialVersionUID = 0;
        public final String message_id;
        public final Permission perm;
        public final String token;

        public static final class Builder extends Message.Builder<Pair, Builder> {
            public String message_id;
            public Permission perm;
            public String token;

            @Override // com.squareup.wire.Message.Builder
            public Pair build() {
                return new Pair(this.message_id, this.perm, this.token, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder message_id(String r100) {
                this.message_id = r100;
                return this;
            }

            public Builder perm(Permission r100) {
                this.perm = r100;
                return this;
            }

            public Builder token(String r100) {
                this.token = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Pair extends ProtoAdapter<Pair> {
            public ProtoAdapter_Pair() {
                super(FieldEncoding.LENGTH_DELIMITED, Pair.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Pair decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.message_id = "";
                r101.perm = Permission.UNKNOWN;
                r101.token = "";
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L18;
                if (r103 != 1) goto L8;
                r101.message_id = ProtoAdapter.STRING.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.perm = Permission.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L15
            L15:
                e = move-exception;
                r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.token = ProtoAdapter.STRING.decode(r100);
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L18:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(Pair r100) {
                String r101 = r100.message_id;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
            L6:
                Permission r104 = r100.perm;
                if (r104 == null) goto L9;
                int r105 = Permission.ADAPTER.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                String r107 = r100.token;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.STRING.encodedSizeWithTag(3, r107);
            L14:
                return (r106 + r102) + r100.unknownFields().size();
            L9:
                r105 = 0;
                goto L10
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Pair decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Pair r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Pair r101) throws IOException {
                String r102 = r101.message_id;
                if (r102 == null) goto L5;
                ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
            L5:
                Permission r103 = r101.perm;
                if (r103 == null) goto L8;
                Permission.ADAPTER.encodeWithTag(r100, 2, r103);
            L8:
                String r104 = r101.token;
                if (r104 == null) goto L11;
                ProtoAdapter.STRING.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Pair r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Pair();
            DEFAULT_PERM = Permission.UNKNOWN;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.message_id = this.message_id;
            r100.perm = this.perm;
            r100.token = this.token;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Pair.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Pair(String r100, Permission r101, String r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public Pair(String r100, Permission r101, String r102, ByteString r103) {
            super(ADAPTER, r103);
            this.message_id = r100;
            this.perm = r101;
            this.token = r102;
        }
    }

    public static final enum Permission extends Enum<Permission> implements WireEnum {
        private static final /* synthetic */ Permission[] $VALUES = null;
        public static final ProtoAdapter<Permission> ADAPTER = null;
        public static final Permission EDIT = null;
        public static final Permission FORBIDDEN = null;
        public static final Permission READ = null;
        public static final Permission UNKNOWN = null;
        private final int value;

        static {
            Permission r100 = new Permission("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Permission r101 = new Permission("READ", 1, 1);
            READ = r101;
            Permission r102 = new Permission("EDIT", 2, 4);
            EDIT = r102;
            Permission r103 = new Permission("FORBIDDEN", 3, 501);
            FORBIDDEN = r103;
            $VALUES = new Permission[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Permission.class);
        }

        public static Permission[] values() {
            return (Permission[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Permission fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 4) goto L14;
            if (r100 == 501) goto L12;
            return null;
        L12:
            return FORBIDDEN;
        L14:
            return EDIT;
        L16:
            return READ;
        L18:
            return UNKNOWN;
        }

        public static Permission valueOf(String r100) {
            return (Permission) a.a(Permission.class, r100);
        }

        private Permission(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class ProtoAdapter_UpdateDocPermissionRequest extends ProtoAdapter<UpdateDocPermissionRequest> implements c<UpdateDocPermissionRequest> {
        public ProtoAdapter_UpdateDocPermissionRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, UpdateDocPermissionRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public UpdateDocPermissionRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.pairs.add(Pair.ADAPTER.decode(r100));
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
        public int encodedSize2(UpdateDocPermissionRequest r100) {
            return Pair.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.pairs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ UpdateDocPermissionRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(UpdateDocPermissionRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, UpdateDocPermissionRequest r101) throws IOException {
            Pair.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.pairs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, UpdateDocPermissionRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_UpdateDocPermissionRequest r100 = new ProtoAdapter_UpdateDocPermissionRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.pairs = Internal.copyOf("pairs", this.pairs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return UpdateDocPermissionRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public UpdateDocPermissionRequest(List<Pair> r100) {
        this(r100, ByteString.EMPTY);
    }

    public UpdateDocPermissionRequest(List<Pair> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.pairs = Internal.immutableCopyOf("pairs", r100);
    }
}
