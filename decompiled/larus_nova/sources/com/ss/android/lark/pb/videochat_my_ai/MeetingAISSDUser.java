package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class MeetingAISSDUser extends Message<MeetingAISSDUser, Builder> {
    public static final ProtoAdapter<MeetingAISSDUser> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final ByteviewUser morigin_user;
    public final MeetingAISSDInfo mssd_info;

    public static final class Builder extends Message.Builder<MeetingAISSDUser, Builder> {
        public ByteviewUser morigin_user;
        public MeetingAISSDInfo mssd_info;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAISSDUser build() {
            return new MeetingAISSDUser(this.morigin_user, this.mssd_info, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder origin_user(ByteviewUser r100) {
            this.morigin_user = r100;
            return this;
        }

        public Builder ssd_info(MeetingAISSDInfo r100) {
            this.mssd_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAISSDUser extends ProtoAdapter<MeetingAISSDUser> {
        public ProtoAdapter_MeetingAISSDUser() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAISSDUser.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAISSDUser decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.morigin_user = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mssd_info = MeetingAISSDInfo.ADAPTER.decode(r100);
            goto L3
        L9:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L12:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(MeetingAISSDUser r100) {
            ByteviewUser r101 = r100.morigin_user;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ByteviewUser.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            MeetingAISSDInfo r104 = r100.mssd_info;
            if (r104 == null) goto L10;
            r102 = MeetingAISSDInfo.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            return (r103 + r102) + r100.unknownFields().size();
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingAISSDUser decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAISSDUser r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAISSDUser r101) throws IOException {
            ByteviewUser r102 = r101.morigin_user;
            if (r102 == null) goto L5;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            MeetingAISSDInfo r103 = r101.mssd_info;
            if (r103 == null) goto L8;
            MeetingAISSDInfo.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAISSDUser r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAISSDUser();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.morigin_user = this.morigin_user;
        r100.mssd_info = this.mssd_info;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAISSDUser.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAISSDUser(ByteviewUser r100, MeetingAISSDInfo r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MeetingAISSDUser(ByteviewUser r100, MeetingAISSDInfo r101, ByteString r102) {
        super(ADAPTER, r102);
        this.morigin_user = r100;
        this.mssd_info = r101;
    }
}
