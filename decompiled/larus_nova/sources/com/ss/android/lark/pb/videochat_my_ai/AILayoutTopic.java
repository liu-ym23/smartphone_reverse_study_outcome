package com.ss.android.lark.pb.videochat_my_ai;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class AILayoutTopic extends Message<AILayoutTopic, Builder> {
    public static final ProtoAdapter<AILayoutTopic> ADAPTER = null;
    public static final String DEFAULT_CONTENT = "";
    private static final long serialVersionUID = 0;
    public final String mcontent;
    public final List<MeetingAISSDUser> musers;

    public static final class Builder extends Message.Builder<AILayoutTopic, Builder> {
        public String mcontent;
        public List<MeetingAISSDUser> musers;

        @Override // com.squareup.wire.Message.Builder
        public AILayoutTopic build() {
            return new AILayoutTopic(this.mcontent, this.musers, super.buildUnknownFields());
        }

        public Builder() {
            this.musers = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder content(String r100) {
            this.mcontent = r100;
            return this;
        }

        public Builder users(List<MeetingAISSDUser> r100) {
            Internal.checkElementsNotNull(r100);
            this.musers = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_AILayoutTopic extends ProtoAdapter<AILayoutTopic> {
        public ProtoAdapter_AILayoutTopic() {
            super(FieldEncoding.LENGTH_DELIMITED, AILayoutTopic.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public AILayoutTopic decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mcontent = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mcontent = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.musers.add(MeetingAISSDUser.ADAPTER.decode(r100));
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
        public int encodedSize2(AILayoutTopic r100) {
            String r101 = r100.mcontent;
            if (r101 == null) goto L5;
            int r102 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L7:
            return (r102 + MeetingAISSDUser.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.musers)) + r100.unknownFields().size();
        L5:
            r102 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ AILayoutTopic decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(AILayoutTopic r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, AILayoutTopic r101) throws IOException {
            String r102 = r101.mcontent;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            MeetingAISSDUser.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.musers);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, AILayoutTopic r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_AILayoutTopic();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mcontent = this.mcontent;
        r100.musers = Internal.copyOf("musers", this.musers);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return AILayoutTopic.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public AILayoutTopic(String r100, List<MeetingAISSDUser> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public AILayoutTopic(String r100, List<MeetingAISSDUser> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mcontent = r100;
        this.musers = Internal.immutableCopyOf("musers", r101);
    }
}
