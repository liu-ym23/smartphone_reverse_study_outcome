package com.bytedance.lark.pb.contact.v1;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes20.dex */
public final class DepartmentLeader extends Message<DepartmentLeader, Builder> {
    public static final ProtoAdapter<DepartmentLeader> ADAPTER = null;
    public static final Long DEFAULT_LEADERID = null;
    public static final LeaderType DEFAULT_LEADERTYPE = null;
    private static final long serialVersionUID = 0;
    public final Chatter leader;
    public final Long leaderID;
    public final LeaderType leaderType;

    public static final class Builder extends Message.Builder<DepartmentLeader, Builder> {
        public Chatter leader;
        public Long leaderID;
        public LeaderType leaderType;

        @Override // com.squareup.wire.Message.Builder
        public DepartmentLeader build() {
            return new DepartmentLeader(this.leaderType, this.leaderID, this.leader, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder leader(Chatter r100) {
            this.leader = r100;
            return this;
        }

        public Builder leaderID(Long r100) {
            this.leaderID = r100;
            return this;
        }

        public Builder leaderType(LeaderType r100) {
            this.leaderType = r100;
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
            r101.leaderType = LeaderType.MainLeader;
            r101.leaderID = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.leaderType = LeaderType.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.leaderID = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.leader = Chatter.ADAPTER.decode(r100);
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
            LeaderType r101 = r100.leaderType;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = LeaderType.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.leaderID;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Chatter r107 = r100.leader;
            if (r107 == null) goto L14;
            r102 = Chatter.ADAPTER.encodedSizeWithTag(3, r107);
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
        public /* bridge */ /* synthetic */ DepartmentLeader decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(DepartmentLeader r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, DepartmentLeader r101) throws IOException {
            LeaderType r102 = r101.leaderType;
            if (r102 == null) goto L5;
            LeaderType.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.leaderID;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Chatter r104 = r101.leader;
            if (r104 == null) goto L11;
            Chatter.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, DepartmentLeader r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_DepartmentLeader();
        DEFAULT_LEADERTYPE = LeaderType.MainLeader;
        DEFAULT_LEADERID = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.leaderType = this.leaderType;
        r100.leaderID = this.leaderID;
        r100.leader = this.leader;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return DepartmentLeader.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public DepartmentLeader(LeaderType r100, Long r101, Chatter r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public DepartmentLeader(LeaderType r100, Long r101, Chatter r102, ByteString r103) {
        super(ADAPTER, r103);
        this.leaderType = r100;
        this.leaderID = r101;
        this.leader = r102;
    }
}
