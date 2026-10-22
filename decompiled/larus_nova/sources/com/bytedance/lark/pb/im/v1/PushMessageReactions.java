package com.bytedance.lark.pb.im.v1;

import com.bytedance.lark.pb.basic.v1.Entity;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class PushMessageReactions extends Message<PushMessageReactions, Builder> {
    public static final ProtoAdapter<PushMessageReactions> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final ProtoAdapter_PushMessageReactions RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Entity entity;
    public final Map<String, Reactions> msg_id2reactions;

    public static final class Builder extends Message.Builder<PushMessageReactions, Builder> implements d<PushMessageReactions> {
        public String chat_id;
        public Entity entity;
        public Map<String, Reactions> msg_id2reactions;

        @Override // com.squareup.wire.Message.Builder
        public PushMessageReactions build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L9;
            if (this.entity == null) goto L9;
            return new PushMessageReactions(this.chat_id, this.msg_id2reactions, this.entity, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id", this.entity, "entity"});
        }

        public Builder() {
            this.msg_id2reactions = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder entity(Entity r100) {
            this.entity = r100;
            return this;
        }

        public Builder msg_id2reactions(Map<String, Reactions> r100) {
            Internal.checkElementsNotNull(r100);
            this.msg_id2reactions = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMessageReactions extends ProtoAdapter<PushMessageReactions> implements c<PushMessageReactions> {
        private final ProtoAdapter<Map<String, Reactions>> msg_id2reactions;

        public ProtoAdapter_PushMessageReactions() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMessageReactions.class);
            this.msg_id2reactions = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Reactions.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMessageReactions decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.chat_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.chat_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.msg_id2reactions.putAll(this.msg_id2reactions.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.entity = Entity.ADAPTER.decode(r100);
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
        public int encodedSize2(PushMessageReactions r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + this.msg_id2reactions.encodedSizeWithTag(2, r100.msg_id2reactions)) + Entity.ADAPTER.encodedSizeWithTag(3, r100.entity)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushMessageReactions decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMessageReactions r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMessageReactions r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            this.msg_id2reactions.encodeWithTag(r100, 2, r101.msg_id2reactions);
            Entity.ADAPTER.encodeWithTag(r100, 3, r101.entity);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMessageReactions r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class Reactions extends Message<Reactions, Builder> {
        public static final ProtoAdapter<Reactions> ADAPTER = null;
        private static final long serialVersionUID = 0;
        public final List<Reaction> reactions;

        public static final class Builder extends Message.Builder<Reactions, Builder> {
            public List<Reaction> reactions;

            @Override // com.squareup.wire.Message.Builder
            public Reactions build() {
                return new Reactions(this.reactions, super.buildUnknownFields());
            }

            public Builder() {
                this.reactions = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder reactions(List<Reaction> r100) {
                Internal.checkElementsNotNull(r100);
                this.reactions = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_Reactions extends ProtoAdapter<Reactions> {
            public ProtoAdapter_Reactions() {
                super(FieldEncoding.LENGTH_DELIMITED, Reactions.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public Reactions decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L9;
                if (r103 != 1) goto L7;
                r101.reactions.add(Reaction.ADAPTER.decode(r100));
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
            public int encodedSize2(Reactions r100) {
                return Reaction.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.reactions) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ Reactions decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(Reactions r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, Reactions r101) throws IOException {
                Reaction.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.reactions);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Reactions r101) throws IOException {
                encode2(r100, r101);
            }
        }

        public static final class Reaction extends Message<Reaction, Builder> {
            public static final ProtoAdapter<Reaction> ADAPTER = null;
            public static final Integer DEFAULT_CHATTER_COUNT = null;
            public static final String DEFAULT_TYPE = "";
            private static final long serialVersionUID = 0;
            public final Integer chatter_count;
            public final List<String> chatter_ids;
            public final String type;

            public static final class Builder extends Message.Builder<Reaction, Builder> {
                public Integer chatter_count;
                public List<String> chatter_ids;
                public String type;

                @Override // com.squareup.wire.Message.Builder
                public Reaction build() {
                    String r100 = this.type;
                    if (r100 == null) goto L7;
                    return new Reaction(this.type, this.chatter_ids, this.chatter_count, super.buildUnknownFields());
                L7:
                    throw Internal.missingRequiredFields(new Object[]{r100, "type"});
                }

                public Builder() {
                    this.chatter_ids = Internal.newMutableList();
                }

                @Override // com.squareup.wire.Message.Builder
                public /* bridge */ /* synthetic */ Message build() {
                    return build();
                }

                public Builder chatter_count(Integer r100) {
                    this.chatter_count = r100;
                    return this;
                }

                public Builder chatter_ids(List<String> r100) {
                    Internal.checkElementsNotNull(r100);
                    this.chatter_ids = r100;
                    return this;
                }

                public Builder type(String r100) {
                    this.type = r100;
                    return this;
                }
            }

            public static final class ProtoAdapter_Reaction extends ProtoAdapter<Reaction> {
                public ProtoAdapter_Reaction() {
                    super(FieldEncoding.LENGTH_DELIMITED, Reaction.class);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.squareup.wire.ProtoAdapter
                public Reaction decode(ProtoReader r100) throws IOException {
                    Builder r101 = new Builder();
                    r101.type = "";
                    r101.chatter_count = 0;
                    long r102 = r100.beginMessage();
                L3:
                    int r103 = r100.nextTag();
                    if (r103 == (-1)) goto L15;
                    if (r103 != 1) goto L8;
                    r101.type = ProtoAdapter.STRING.decode(r100);
                    goto L3
                L8:
                    if (r103 != 2) goto L10;
                    r101.chatter_ids.add(ProtoAdapter.STRING.decode(r100));
                    goto L3
                L10:
                    if (r103 != 3) goto L11;
                    r101.chatter_count = ProtoAdapter.INT32.decode(r100);
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
                public int encodedSize2(Reaction r100) {
                    ProtoAdapter<String> r101 = ProtoAdapter.STRING;
                    int r102 = r101.encodedSizeWithTag(1, r100.type) + r101.asRepeated().encodedSizeWithTag(2, r100.chatter_ids);
                    Integer r103 = r100.chatter_count;
                    if (r103 == null) goto L5;
                    int r104 = ProtoAdapter.INT32.encodedSizeWithTag(3, r103);
                L7:
                    return (r102 + r104) + r100.unknownFields().size();
                L5:
                    r104 = 0;
                    goto L7
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ Reaction decode(ProtoReader r100) throws IOException {
                    return decode(r100);
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ int encodedSize(Reaction r100) {
                    return encodedSize2(r100);
                }

                /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
                public void encode2(ProtoWriter r100, Reaction r101) throws IOException {
                    ProtoAdapter<String> r102 = ProtoAdapter.STRING;
                    r102.encodeWithTag(r100, 1, r101.type);
                    r102.asRepeated().encodeWithTag(r100, 2, r101.chatter_ids);
                    Integer r103 = r101.chatter_count;
                    if (r103 == null) goto L5;
                    ProtoAdapter.INT32.encodeWithTag(r100, 3, r103);
                L5:
                    r100.writeBytes(r101.unknownFields());
                }

                @Override // com.squareup.wire.ProtoAdapter
                public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, Reaction r101) throws IOException {
                    encode2(r100, r101);
                }
            }

            static {
                ADAPTER = new ProtoAdapter_Reaction();
                DEFAULT_CHATTER_COUNT = 0;
            }

            @Override // com.squareup.wire.Message
            public Builder newBuilder() {
                Builder r100 = new Builder();
                r100.type = this.type;
                r100.chatter_ids = Internal.copyOf("chatter_ids", this.chatter_ids);
                r100.chatter_count = this.chatter_count;
                r100.addUnknownFields(unknownFields());
                return r100;
            }

            @Override // com.squareup.wire.Message
            public String toString() {
                return Reaction.class.getName() + "@" + Integer.toHexString(hashCode());
            }

            @Override // com.squareup.wire.Message
            public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
                return newBuilder();
            }

            public Reaction(String r100, List<String> r101, Integer r102) {
                this(r100, r101, r102, ByteString.EMPTY);
            }

            public Reaction(String r100, List<String> r101, Integer r102, ByteString r103) {
                super(ADAPTER, r103);
                this.type = r100;
                this.chatter_ids = Internal.immutableCopyOf("chatter_ids", r101);
                this.chatter_count = r102;
            }
        }

        static {
            ADAPTER = new ProtoAdapter_Reactions();
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.reactions = Internal.copyOf("reactions", this.reactions);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return Reactions.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public Reactions(List<Reaction> r100) {
            this(r100, ByteString.EMPTY);
        }

        public Reactions(List<Reaction> r100, ByteString r101) {
            super(ADAPTER, r101);
            this.reactions = Internal.immutableCopyOf("reactions", r100);
        }
    }

    static {
        ProtoAdapter_PushMessageReactions r100 = new ProtoAdapter_PushMessageReactions();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.msg_id2reactions = Internal.copyOf("msg_id2reactions", this.msg_id2reactions);
        r100.entity = this.entity;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMessageReactions.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMessageReactions(String r100, Map<String, Reactions> r101, Entity r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushMessageReactions(String r100, Map<String, Reactions> r101, Entity r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.msg_id2reactions = Internal.immutableCopyOf("msg_id2reactions", r101);
        this.entity = r102;
    }
}
