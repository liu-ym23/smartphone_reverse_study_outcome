package com.ss.android.lark.pb.videochat;

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
public final class MeetingAIQuickActions extends Message<MeetingAIQuickActions, Builder> {
    public static final ProtoAdapter<MeetingAIQuickActions> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<MyAIQuickActionConfig> mmy_ai_quick_action_configs;

    public static final class Builder extends Message.Builder<MeetingAIQuickActions, Builder> {
        public List<MyAIQuickActionConfig> mmy_ai_quick_action_configs;

        @Override // com.squareup.wire.Message.Builder
        public MeetingAIQuickActions build() {
            return new MeetingAIQuickActions(this.mmy_ai_quick_action_configs, super.buildUnknownFields());
        }

        public Builder() {
            this.mmy_ai_quick_action_configs = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder my_ai_quick_action_configs(List<MyAIQuickActionConfig> r100) {
            Internal.checkElementsNotNull(r100);
            this.mmy_ai_quick_action_configs = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MeetingAIQuickActions extends ProtoAdapter<MeetingAIQuickActions> {
        public ProtoAdapter_MeetingAIQuickActions() {
            super(FieldEncoding.LENGTH_DELIMITED, MeetingAIQuickActions.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MeetingAIQuickActions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L9;
            if (r103 != 1) goto L7;
            r101.mmy_ai_quick_action_configs.add(MyAIQuickActionConfig.ADAPTER.decode(r100));
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
        public int encodedSize2(MeetingAIQuickActions r100) {
            return MyAIQuickActionConfig.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.mmy_ai_quick_action_configs) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MeetingAIQuickActions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MeetingAIQuickActions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MeetingAIQuickActions r101) throws IOException {
            MyAIQuickActionConfig.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.mmy_ai_quick_action_configs);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MeetingAIQuickActions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MeetingAIQuickActions();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmy_ai_quick_action_configs = Internal.copyOf("mmy_ai_quick_action_configs", this.mmy_ai_quick_action_configs);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MeetingAIQuickActions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MeetingAIQuickActions(List<MyAIQuickActionConfig> r100) {
        this(r100, ByteString.EMPTY);
    }

    public MeetingAIQuickActions(List<MyAIQuickActionConfig> r100, ByteString r101) {
        super(ADAPTER, r101);
        this.mmy_ai_quick_action_configs = Internal.immutableCopyOf("mmy_ai_quick_action_configs", r100);
    }
}
