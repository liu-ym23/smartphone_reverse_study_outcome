package com.ss.android.lark.pb.entities;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class DepartmentLeader extends com.squareup.wire.Message<DepartmentLeader, Builder> {
    public static final ProtoAdapter<DepartmentLeader> ADAPTER = null;
    public static final Long DEFAULT_LEADERID = null;
    private static final long serialVersionUID = 0;
    public final Chatter mleader;
    public final Long mleaderID;
    public final LeaderType mleaderType;

    public static final class Builder extends com.squareup.wire.Message.Builder<DepartmentLeader, Builder> {
        public Chatter mleader;
        public Long mleaderID;
        public LeaderType mleaderType;

        @Override // com.squareup.wire.Message.Builder
        public DepartmentLeader build() {
            LeaderType r100 = this.mleaderType;
            if (r100 == null) goto L9;
            if (this.mleaderID == null) goto L9;
            return new DepartmentLeader(this.mleaderType, this.mleaderID, this.mleader, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mleaderType", this.mleaderID, "mleaderID"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ com.squareup.wire.Message build() {
            return build();
        }

        public Builder leader(Chatter r100) {
            this.mleader = r100;
            return this;
        }

        public Builder leaderID(Long r100) {
            this.mleaderID = r100;
            return this;
        }

        public Builder leaderType(LeaderType r100) {
            this.mleaderType = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_DepartmentLeader extends ProtoAdapter<DepartmentLeader> {
        public ProtoAdapter_DepartmentLeader() {
            super(FieldEncoding.LENGTH_DELIMITED, DepartmentLeader.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public DepartmentLeader decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mleaderID = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mleaderType = LeaderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mleaderID = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.mleader = Chatter.ADAPTER.decode(r100);
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
        public int encodedSize2(DepartmentLeader r100) {
            int r101 = LeaderType.ADAPTER.encodedSizeWithTag(1, r100.mleaderType) + ProtoAdapter.INT64.encodedSizeWithTag(2, r100.mleaderID);
            Chatter r102 = r100.mleader;
            if (r102 == null) goto L5;
            int r103 = Chatter.ADAPTER.encodedSizeWithTag(3, r102);
        L7:
            return (r101 + r103) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ DepartmentLeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DepartmentLeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DepartmentLeader r101) throws IOException {
            LeaderType.ADAPTER.encodeWithTag(r100, 1, r101.mleaderType);
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r101.mleaderID);
            Chatter r102 = r101.mleader;
            if (r102 == null) goto L5;
            Chatter.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentLeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentLeader();
        DEFAULT_LEADERID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mleaderType = this.mleaderType;
        r100.mleaderID = this.mleaderID;
        r100.mleader = this.mleader;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DepartmentLeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ com.squareup.wire.Message.Builder newBuilder() {
        return newBuilder();
    }

    public DepartmentLeader(LeaderType r100, Long r101, Chatter r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DepartmentLeader(LeaderType r100, Long r101, Chatter r102, ByteString r103) {
        super(ADAPTER, r103);
        this.mleaderType = r100;
        this.mleaderID = r101;
        this.mleader = r102;
    }
}
