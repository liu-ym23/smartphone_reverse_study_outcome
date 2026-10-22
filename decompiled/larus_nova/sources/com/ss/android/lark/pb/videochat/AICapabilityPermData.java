package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.ss.android.lark.pb.vc_common.ByteviewUser;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AICapabilityPermData extends Message<AICapabilityPermData, Builder> {
    public static final ProtoAdapter<AICapabilityPermData> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final MeetingAICapabilityAction maction;
    public final MeetingAICapability mcapability;
    public final ByteviewUser moperate_user;
    public final ByteviewUser mrequester;

    public static final class Builder extends Message.Builder<AICapabilityPermData, Builder> {
        public MeetingAICapabilityAction maction;
        public MeetingAICapability mcapability;
        public ByteviewUser moperate_user;
        public ByteviewUser mrequester;

        @Override // com.squareup.wire.Message.Builder
        public AICapabilityPermData build() {
            return new AICapabilityPermData(this.maction, this.mcapability, this.mrequester, this.moperate_user, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(MeetingAICapabilityAction r100) {
            this.maction = r100;
            return this;
        }

        public Builder capability(MeetingAICapability r100) {
            this.mcapability = r100;
            return this;
        }

        public Builder operate_user(ByteviewUser r100) {
            this.moperate_user = r100;
            return this;
        }

        public Builder requester(ByteviewUser r100) {
            this.mrequester = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AICapabilityPermData extends ProtoAdapter<AICapabilityPermData> {
        public ProtoAdapter_AICapabilityPermData() {
            super(FieldEncoding.LENGTH_DELIMITED, AICapabilityPermData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AICapabilityPermData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.maction = MeetingAICapabilityAction.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L22
        L22:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mcapability = MeetingAICapability.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mrequester = ByteviewUser.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.moperate_user = ByteviewUser.ADAPTER.decode(r100);
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
        public int encodedSize2(AICapabilityPermData r100) {
            MeetingAICapabilityAction r101 = r100.maction;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = MeetingAICapabilityAction.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            MeetingAICapability r104 = r100.mcapability;
            if (r104 == null) goto L9;
            int r105 = MeetingAICapability.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            ByteviewUser r107 = r100.mrequester;
            if (r107 == null) goto L13;
            int r108 = ByteviewUser.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = r106 + r108;
            ByteviewUser r110 = r100.moperate_user;
            if (r110 == null) goto L18;
            r102 = ByteviewUser.ADAPTER.encodedSizeWithTag(4, r110);
        L18:
            return (r109 + r102) + r100.unknownFields().size();
        L13:
            r108 = 0;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AICapabilityPermData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AICapabilityPermData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AICapabilityPermData r101) throws IOException {
            MeetingAICapabilityAction r102 = r101.maction;
            if (r102 == null) goto L5;
            MeetingAICapabilityAction.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            MeetingAICapability r103 = r101.mcapability;
            if (r103 == null) goto L8;
            MeetingAICapability.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            ByteviewUser r104 = r101.mrequester;
            if (r104 == null) goto L11;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            ByteviewUser r105 = r101.moperate_user;
            if (r105 == null) goto L14;
            ByteviewUser.ADAPTER.encodeWithTag(r100, 4, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AICapabilityPermData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AICapabilityPermData();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.maction = this.maction;
        r100.mcapability = this.mcapability;
        r100.mrequester = this.mrequester;
        r100.moperate_user = this.moperate_user;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AICapabilityPermData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AICapabilityPermData(MeetingAICapabilityAction r100, MeetingAICapability r101, ByteviewUser r102, ByteviewUser r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public AICapabilityPermData(MeetingAICapabilityAction r100, MeetingAICapability r101, ByteviewUser r102, ByteviewUser r103, ByteString r104) {
        super(ADAPTER, r104);
        this.maction = r100;
        this.mcapability = r101;
        this.mrequester = r102;
        this.moperate_user = r103;
    }
}
