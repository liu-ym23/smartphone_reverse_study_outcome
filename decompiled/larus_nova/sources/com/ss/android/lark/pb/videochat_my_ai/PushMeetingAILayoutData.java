package com.ss.android.lark.pb.videochat_my_ai;

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

/* JADX INFO: loaded from: classes37.dex */
public final class PushMeetingAILayoutData extends Message<PushMeetingAILayoutData, Builder> {
    public static final ProtoAdapter<PushMeetingAILayoutData> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Long DEFAULT_TIMESTAMP = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final FeatureStatus mnote_switch;
    public final List<NotesBlock> mnotes_blocks;
    public final Long mtimestamp;
    public final Type mtype;

    public static final class Builder extends Message.Builder<PushMeetingAILayoutData, Builder> {
        public String mmeeting_id;
        public FeatureStatus mnote_switch;
        public List<NotesBlock> mnotes_blocks;
        public Long mtimestamp;
        public Type mtype;

        @Override // com.squareup.wire.Message.Builder
        public PushMeetingAILayoutData build() {
            return new PushMeetingAILayoutData(this.mmeeting_id, this.mtimestamp, this.mtype, this.mnotes_blocks, this.mnote_switch, super.buildUnknownFields());
        }

        public Builder() {
            this.mnotes_blocks = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder note_switch(FeatureStatus r100) {
            this.mnote_switch = r100;
            return this;
        }

        public Builder notes_blocks(List<NotesBlock> r100) {
            Internal.checkElementsNotNull(r100);
            this.mnotes_blocks = r100;
            return this;
        }

        public Builder timestamp(Long r100) {
            this.mtimestamp = r100;
            return this;
        }

        public Builder type(Type r100) {
            this.mtype = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMeetingAILayoutData extends ProtoAdapter<PushMeetingAILayoutData> {
        public ProtoAdapter_PushMeetingAILayoutData() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMeetingAILayoutData.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMeetingAILayoutData decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mtimestamp = 0L;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L27;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mtimestamp = ProtoAdapter.INT64.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mtype = Type.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L23
        L23:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L14;
            r101.mnotes_blocks.add(NotesBlock.ADAPTER.decode(r100));
            goto L3
        L14:
            if (r103 != 5) goto L15;
            r101.mnote_switch = FeatureStatus.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L18
        L18:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L15:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L27:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PushMeetingAILayoutData r100) {
            String r101 = r100.mmeeting_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.STRING.encodedSizeWithTag(1, r101);
        L6:
            Long r104 = r100.mtimestamp;
            if (r104 == null) goto L9;
            int r105 = ProtoAdapter.INT64.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            Type r107 = r100.mtype;
            if (r107 == null) goto L13;
            int r108 = Type.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            int r109 = (r106 + r108) + NotesBlock.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.mnotes_blocks);
            FeatureStatus r110 = r100.mnote_switch;
            if (r110 == null) goto L18;
            r102 = FeatureStatus.ADAPTER.encodedSizeWithTag(5, r110);
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
        public /* bridge */ /* synthetic */ PushMeetingAILayoutData decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMeetingAILayoutData r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMeetingAILayoutData r101) throws IOException {
            String r102 = r101.mmeeting_id;
            if (r102 == null) goto L5;
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r102);
        L5:
            Long r103 = r101.mtimestamp;
            if (r103 == null) goto L8;
            ProtoAdapter.INT64.encodeWithTag(r100, 2, r103);
        L8:
            Type r104 = r101.mtype;
            if (r104 == null) goto L11;
            Type.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            NotesBlock.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.mnotes_blocks);
            FeatureStatus r105 = r101.mnote_switch;
            if (r105 == null) goto L14;
            FeatureStatus.ADAPTER.encodeWithTag(r100, 5, r105);
        L14:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMeetingAILayoutData r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum Type extends Enum<Type> implements WireEnum {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final ProtoAdapter<Type> ADAPTER = null;
        public static final Type AI_LAYOUT_FISH_BONE = null;
        public static final Type AI_LAYOUT_NOTES = null;
        public static final Type AI_LAYOUT_NOTE_SWITCH = null;
        public static final Type AI_LAYOUT_SUBTITLE_EFFECT = null;
        public static final Type AI_LAYOUT_TOPIC = null;
        public static final Type RESERVED_USER_6 = null;
        public static final Type RESERVED_USER_7 = null;
        public static final Type UNKNOWN = null;
        private final int value;

        static {
            Type r100 = new Type("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Type r101 = new Type("AI_LAYOUT_FISH_BONE", 1, 1);
            AI_LAYOUT_FISH_BONE = r101;
            Type r102 = new Type("AI_LAYOUT_TOPIC", 2, 2);
            AI_LAYOUT_TOPIC = r102;
            Type r103 = new Type("AI_LAYOUT_SUBTITLE_EFFECT", 3, 3);
            AI_LAYOUT_SUBTITLE_EFFECT = r103;
            Type r104 = new Type("AI_LAYOUT_NOTES", 4, 4);
            AI_LAYOUT_NOTES = r104;
            Type r105 = new Type("AI_LAYOUT_NOTE_SWITCH", 5, 5);
            AI_LAYOUT_NOTE_SWITCH = r105;
            Type r110 = new Type("RESERVED_USER_6", 6, 6);
            RESERVED_USER_6 = r110;
            Type r111 = new Type("RESERVED_USER_7", 7, 7);
            RESERVED_USER_7 = r111;
            $VALUES = new Type[]{r100, r101, r102, r103, r104, r105, r110, r111};
            ADAPTER = ProtoAdapter.newEnumAdapter(Type.class);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Type fromValue(int r100) {
            switch(r100) {
                case 0: goto L20;
                case 1: goto L18;
                case 2: goto L16;
                case 3: goto L14;
                case 4: goto L12;
                case 5: goto L10;
                case 6: goto L8;
                case 7: goto L6;
                default: goto L3;
            };
        L3:
            return null;
        L6:
            return RESERVED_USER_7;
        L8:
            return RESERVED_USER_6;
        L10:
            return AI_LAYOUT_NOTE_SWITCH;
        L12:
            return AI_LAYOUT_NOTES;
        L14:
            return AI_LAYOUT_SUBTITLE_EFFECT;
        L16:
            return AI_LAYOUT_TOPIC;
        L18:
            return AI_LAYOUT_FISH_BONE;
        L20:
            return UNKNOWN;
        }

        public static Type valueOf(String r100) {
            return (Type) a.a(Type.class, r100);
        }

        private Type(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PushMeetingAILayoutData();
        DEFAULT_TIMESTAMP = 0L;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mtimestamp = this.mtimestamp;
        r100.mtype = this.mtype;
        r100.mnotes_blocks = Internal.copyOf("mnotes_blocks", this.mnotes_blocks);
        r100.mnote_switch = this.mnote_switch;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMeetingAILayoutData.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMeetingAILayoutData(String r100, Long r101, Type r110, List<NotesBlock> r111, FeatureStatus r112) {
        this(r100, r101, r110, r111, r112, ByteString.EMPTY);
    }

    public PushMeetingAILayoutData(String r100, Long r101, Type r102, List<NotesBlock> r103, FeatureStatus r104, ByteString r105) {
        super(ADAPTER, r105);
        this.mmeeting_id = r100;
        this.mtimestamp = r101;
        this.mtype = r102;
        this.mnotes_blocks = Internal.immutableCopyOf("mnotes_blocks", r103);
        this.mnote_switch = r104;
    }
}
