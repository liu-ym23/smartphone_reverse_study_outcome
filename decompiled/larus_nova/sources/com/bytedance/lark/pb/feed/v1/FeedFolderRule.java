package com.bytedance.lark.pb.feed.v1;

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
public final class FeedFolderRule extends Message<FeedFolderRule, Builder> {
    public static final ProtoAdapter<FeedFolderRule> ADAPTER = null;
    public static final Long DEFAULT_ADDITIONAL_FOLDER_ID = null;
    public static final RuleProperties DEFAULT_SCENE = null;
    private static final long serialVersionUID = 0;
    public final ActionRule action;
    public final Long additional_folder_id;
    public final RuleProperties scene;

    public static final class ActionRule extends Message<ActionRule, Builder> {
        public static final ProtoAdapter<ActionRule> ADAPTER = null;
        public static final Integer DEFAULT_DISPLAY_PRIORITY = null;
        public static final Boolean DEFAULT_IS_ELIGIBLE = null;
        private static final long serialVersionUID = 0;
        public final Integer display_priority;
        public final List<Integer> important_message_type;
        public final Boolean is_eligible;

        public static final class Builder extends Message.Builder<ActionRule, Builder> {
            public Integer display_priority;
            public List<Integer> important_message_type;
            public Boolean is_eligible;

            @Override // com.squareup.wire.Message.Builder
            public ActionRule build() {
                return new ActionRule(this.is_eligible, this.display_priority, this.important_message_type, super.buildUnknownFields());
            }

            public Builder() {
                this.important_message_type = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder display_priority(Integer r100) {
                this.display_priority = r100;
                return this;
            }

            public Builder important_message_type(List<Integer> r100) {
                Internal.checkElementsNotNull(r100);
                this.important_message_type = r100;
                return this;
            }

            public Builder is_eligible(Boolean r100) {
                this.is_eligible = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ActionRule extends ProtoAdapter<ActionRule> {
            public ProtoAdapter_ActionRule() {
                super(FieldEncoding.LENGTH_DELIMITED, ActionRule.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ActionRule decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.is_eligible = Boolean.FALSE;
                r101.display_priority = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.is_eligible = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.display_priority = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.important_message_type.add(ProtoAdapter.INT32.decode(r100));
                goto L3
            L11:
                FieldEncoding r104 = r100.peekFieldEncoding();
                r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
                goto L3
            L15:
                r100.endMessage(r102);
                return r101.build();
            }

            /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
            public int encodedSize2(ActionRule r100) {
                Boolean r101 = r100.is_eligible;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.display_priority;
                if (r104 == null) goto L10;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                return ((r103 + r102) + ProtoAdapter.INT32.asRepeated().encodedSizeWithTag(3, r100.important_message_type)) + r100.unknownFields().size();
            L5:
                r103 = 0;
                goto L6
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ActionRule decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ActionRule r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ActionRule r101) throws IOException {
                Boolean r102 = r101.is_eligible;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.display_priority;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                ProtoAdapter.INT32.asRepeated().encodeWithTag(r100, 3, r101.important_message_type);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ActionRule r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ActionRule();
            DEFAULT_IS_ELIGIBLE = Boolean.FALSE;
            DEFAULT_DISPLAY_PRIORITY = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.is_eligible = this.is_eligible;
            r100.display_priority = this.display_priority;
            r100.important_message_type = Internal.copyOf("important_message_type", this.important_message_type);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ActionRule.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ActionRule(Boolean r100, Integer r101, List<Integer> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ActionRule(Boolean r100, Integer r101, List<Integer> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.is_eligible = r100;
            this.display_priority = r101;
            this.important_message_type = Internal.immutableCopyOf("important_message_type", r102);
        }
    }

    public static final class Builder extends Message.Builder<FeedFolderRule, Builder> {
        public ActionRule action;
        public Long additional_folder_id;
        public RuleProperties scene;

        @Override // com.squareup.wire.Message.Builder
        public FeedFolderRule build() {
            return new FeedFolderRule(this.additional_folder_id, this.action, this.scene, super.buildUnknownFields());
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action(ActionRule r100) {
            this.action = r100;
            return this;
        }

        public Builder additional_folder_id(Long r100) {
            this.additional_folder_id = r100;
            return this;
        }

        public Builder scene(RuleProperties r100) {
            this.scene = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedFolderRule extends ProtoAdapter<FeedFolderRule> {
        public ProtoAdapter_FeedFolderRule() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedFolderRule.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedFolderRule decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.additional_folder_id = 0L;
            r101.scene = RuleProperties.Immediate;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.additional_folder_id = ProtoAdapter.INT64.decode(r100);
            goto L3
        L8:
            if (r103 != 3) goto L10;
            r101.action = ActionRule.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 4) goto L11;
            r101.scene = RuleProperties.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L14
        L14:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(FeedFolderRule r100) {
            Long r101 = r100.additional_folder_id;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = ProtoAdapter.INT64.encodedSizeWithTag(1, r101);
        L6:
            ActionRule r104 = r100.action;
            if (r104 == null) goto L9;
            int r105 = ActionRule.ADAPTER.encodedSizeWithTag(3, r104);
        L10:
            int r106 = r103 + r105;
            RuleProperties r107 = r100.scene;
            if (r107 == null) goto L14;
            r102 = RuleProperties.ADAPTER.encodedSizeWithTag(4, r107);
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
        public /* bridge */ /* synthetic */ FeedFolderRule decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedFolderRule r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedFolderRule r101) throws IOException {
            Long r102 = r101.additional_folder_id;
            if (r102 == null) goto L5;
            ProtoAdapter.INT64.encodeWithTag(r100, 1, r102);
        L5:
            ActionRule r103 = r101.action;
            if (r103 == null) goto L8;
            ActionRule.ADAPTER.encodeWithTag(r100, 3, r103);
        L8:
            RuleProperties r104 = r101.scene;
            if (r104 == null) goto L11;
            RuleProperties.ADAPTER.encodeWithTag(r100, 4, r104);
        L11:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedFolderRule r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum RuleProperties extends Enum<RuleProperties> implements WireEnum {
        private static final /* synthetic */ RuleProperties[] $VALUES = null;
        public static final ProtoAdapter<RuleProperties> ADAPTER = null;
        public static final RuleProperties Immediate = null;
        public static final RuleProperties SwitchTab = null;
        private final int value;

        static {
            RuleProperties r100 = new RuleProperties("Immediate", 0, 1);
            Immediate = r100;
            RuleProperties r101 = new RuleProperties("SwitchTab", 1, 2);
            SwitchTab = r101;
            $VALUES = new RuleProperties[]{r100, r101};
            ADAPTER = ProtoAdapter.newEnumAdapter(RuleProperties.class);
        }

        public static RuleProperties[] values() {
            return (RuleProperties[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static RuleProperties fromValue(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return null;
        L9:
            return SwitchTab;
        L11:
            return Immediate;
        }

        public static RuleProperties valueOf(String r100) {
            return (RuleProperties) a.a(RuleProperties.class, r100);
        }

        private RuleProperties(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedFolderRule();
        DEFAULT_ADDITIONAL_FOLDER_ID = 0L;
        DEFAULT_SCENE = RuleProperties.Immediate;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.additional_folder_id = this.additional_folder_id;
        r100.action = this.action;
        r100.scene = this.scene;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedFolderRule.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedFolderRule(Long r100, ActionRule r101, RuleProperties r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public FeedFolderRule(Long r100, ActionRule r101, RuleProperties r102, ByteString r103) {
        super(ADAPTER, r103);
        this.additional_folder_id = r100;
        this.action = r101;
        this.scene = r102;
    }
}
