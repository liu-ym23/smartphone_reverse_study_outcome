package com.bytedance.lark.pb.im.v1;

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
public final class PushMessageReadStates extends Message<PushMessageReadStates, Builder> {
    public static final ProtoAdapter<PushMessageReadStates> ADAPTER = null;
    public static final String DEFAULT_CHAT_ID = "";
    public static final ProtoAdapter_PushMessageReadStates RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String chat_id;
    public final Map<String, ReadStates> read_states;
    public final Map<String, ReadStatesExtra> read_states_extra;

    public static final class Builder extends Message.Builder<PushMessageReadStates, Builder> implements d<PushMessageReadStates> {
        public String chat_id;
        public Map<String, ReadStates> read_states;
        public Map<String, ReadStatesExtra> read_states_extra;

        @Override // com.squareup.wire.Message.Builder
        public PushMessageReadStates build() {
            String r100 = this.chat_id;
            if (r100 == null) goto L7;
            return new PushMessageReadStates(this.chat_id, this.read_states, this.read_states_extra, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "chat_id"});
        }

        public Builder() {
            this.read_states = Internal.newMutableMap();
            this.read_states_extra = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder chat_id(String r100) {
            this.chat_id = r100;
            return this;
        }

        public Builder read_states(Map<String, ReadStates> r100) {
            Internal.checkElementsNotNull(r100);
            this.read_states = r100;
            return this;
        }

        public Builder read_states_extra(Map<String, ReadStatesExtra> r100) {
            Internal.checkElementsNotNull(r100);
            this.read_states_extra = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PushMessageReadStates extends ProtoAdapter<PushMessageReadStates> implements c<PushMessageReadStates> {
        private final ProtoAdapter<Map<String, ReadStates>> read_states;
        private final ProtoAdapter<Map<String, ReadStatesExtra>> read_states_extra;

        public ProtoAdapter_PushMessageReadStates() {
            super(FieldEncoding.LENGTH_DELIMITED, PushMessageReadStates.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.read_states = ProtoAdapter.newMapAdapter(r100, ReadStates.ADAPTER);
            this.read_states_extra = ProtoAdapter.newMapAdapter(r100, ReadStatesExtra.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PushMessageReadStates decode(ProtoReader r100) throws IOException {
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
            r101.read_states.putAll(this.read_states.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.read_states_extra.putAll(this.read_states_extra.decode(r100));
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
        public int encodedSize2(PushMessageReadStates r100) {
            return ((ProtoAdapter.STRING.encodedSizeWithTag(1, r100.chat_id) + this.read_states.encodedSizeWithTag(2, r100.read_states)) + this.read_states_extra.encodedSizeWithTag(3, r100.read_states_extra)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PushMessageReadStates decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PushMessageReadStates r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PushMessageReadStates r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.chat_id);
            this.read_states.encodeWithTag(r100, 2, r101.read_states);
            this.read_states_extra.encodeWithTag(r100, 3, r101.read_states_extra);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PushMessageReadStates r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final class ReadStates extends Message<ReadStates, Builder> {
        public static final ProtoAdapter<ReadStates> ADAPTER = null;
        public static final Integer DEFAULT_READ_COUNT = null;
        public static final Integer DEFAULT_UNREAD_COUNT = null;
        private static final long serialVersionUID = 0;
        public final List<String> read_at_chatter_ids;
        public final Integer read_count;
        public final Integer unread_count;

        public static final class Builder extends Message.Builder<ReadStates, Builder> {
            public List<String> read_at_chatter_ids;
            public Integer read_count;
            public Integer unread_count;

            @Override // com.squareup.wire.Message.Builder
            public ReadStates build() {
                Integer r100 = this.read_count;
                if (r100 == null) goto L9;
                if (this.unread_count == null) goto L9;
                return new ReadStates(this.read_count, this.unread_count, this.read_at_chatter_ids, super.buildUnknownFields());
            L9:
                throw Internal.missingRequiredFields(new Object[]{r100, "read_count", this.unread_count, "unread_count"});
            }

            public Builder() {
                this.read_at_chatter_ids = Internal.newMutableList();
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder read_at_chatter_ids(List<String> r100) {
                Internal.checkElementsNotNull(r100);
                this.read_at_chatter_ids = r100;
                return this;
            }

            public Builder read_count(Integer r100) {
                this.read_count = r100;
                return this;
            }

            public Builder unread_count(Integer r100) {
                this.unread_count = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReadStates extends ProtoAdapter<ReadStates> {
            public ProtoAdapter_ReadStates() {
                super(FieldEncoding.LENGTH_DELIMITED, ReadStates.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReadStates decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.read_count = 0;
                r101.unread_count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.read_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.unread_count = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.read_at_chatter_ids.add(ProtoAdapter.STRING.decode(r100));
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
            public int encodedSize2(ReadStates r100) {
                ProtoAdapter<Integer> r101 = ProtoAdapter.INT32;
                return ((r101.encodedSizeWithTag(1, r100.read_count) + r101.encodedSizeWithTag(2, r100.unread_count)) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(3, r100.read_at_chatter_ids)) + r100.unknownFields().size();
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ ReadStates decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReadStates r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReadStates r101) throws IOException {
                ProtoAdapter<Integer> r102 = ProtoAdapter.INT32;
                r102.encodeWithTag(r100, 1, r101.read_count);
                r102.encodeWithTag(r100, 2, r101.unread_count);
                ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 3, r101.read_at_chatter_ids);
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReadStates r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReadStates();
            DEFAULT_READ_COUNT = 0;
            DEFAULT_UNREAD_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.read_count = this.read_count;
            r100.unread_count = this.unread_count;
            r100.read_at_chatter_ids = Internal.copyOf("read_at_chatter_ids", this.read_at_chatter_ids);
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReadStates.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReadStates(Integer r100, Integer r101, List<String> r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ReadStates(Integer r100, Integer r101, List<String> r102, ByteString r103) {
            super(ADAPTER, r103);
            this.read_count = r100;
            this.unread_count = r101;
            this.read_at_chatter_ids = Internal.immutableCopyOf("read_at_chatter_ids", r102);
        }
    }

    public static final class ReadStatesExtra extends Message<ReadStatesExtra, Builder> {
        public static final ProtoAdapter<ReadStatesExtra> ADAPTER = null;
        public static final Integer DEFAULT_BADGE_COUNT = null;
        public static final Boolean DEFAULT_ME_READ = null;
        public static final Integer DEFAULT_POSITION = null;
        private static final long serialVersionUID = 0;
        public final Integer badge_count;
        public final Boolean me_read;
        public final Integer position;

        public static final class Builder extends Message.Builder<ReadStatesExtra, Builder> {
            public Integer badge_count;
            public Boolean me_read;
            public Integer position;

            @Override // com.squareup.wire.Message.Builder
            public ReadStatesExtra build() {
                return new ReadStatesExtra(this.me_read, this.position, this.badge_count, super.buildUnknownFields());
            }

            public Builder() {
            }

            @Override // com.squareup.wire.Message.Builder
            public /* bridge */ /* synthetic */ Message build() {
                return build();
            }

            public Builder badge_count(Integer r100) {
                this.badge_count = r100;
                return this;
            }

            public Builder me_read(Boolean r100) {
                this.me_read = r100;
                return this;
            }

            public Builder position(Integer r100) {
                this.position = r100;
                return this;
            }
        }

        public static final class ProtoAdapter_ReadStatesExtra extends ProtoAdapter<ReadStatesExtra> {
            public ProtoAdapter_ReadStatesExtra() {
                super(FieldEncoding.LENGTH_DELIMITED, ReadStatesExtra.class);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.squareup.wire.ProtoAdapter
            public ReadStatesExtra decode(ProtoReader r100) throws IOException {
                Builder r101 = new Builder();
                r101.me_read = Boolean.FALSE;
                r101.position = 0;
                r101.badge_count = 0;
                long r102 = r100.beginMessage();
            L3:
                int r103 = r100.nextTag();
                if (r103 == (-1)) goto L15;
                if (r103 != 1) goto L8;
                r101.me_read = ProtoAdapter.BOOL.decode(r100);
                goto L3
            L8:
                if (r103 != 2) goto L10;
                r101.position = ProtoAdapter.INT32.decode(r100);
                goto L3
            L10:
                if (r103 != 3) goto L11;
                r101.badge_count = ProtoAdapter.INT32.decode(r100);
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
            public int encodedSize2(ReadStatesExtra r100) {
                Boolean r101 = r100.me_read;
                int r102 = 0;
                if (r101 == null) goto L5;
                int r103 = ProtoAdapter.BOOL.encodedSizeWithTag(1, r101);
            L6:
                Integer r104 = r100.position;
                if (r104 == null) goto L9;
                int r105 = ProtoAdapter.INT32.encodedSizeWithTag(2, r104);
            L10:
                int r106 = r103 + r105;
                Integer r107 = r100.badge_count;
                if (r107 == null) goto L14;
                r102 = ProtoAdapter.INT32.encodedSizeWithTag(3, r107);
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
            public /* bridge */ /* synthetic */ ReadStatesExtra decode(ProtoReader r100) throws IOException {
                return decode(r100);
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ int encodedSize(ReadStatesExtra r100) {
                return encodedSize2(r100);
            }

            /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
            public void encode2(ProtoWriter r100, ReadStatesExtra r101) throws IOException {
                Boolean r102 = r101.me_read;
                if (r102 == null) goto L5;
                ProtoAdapter.BOOL.encodeWithTag(r100, 1, r102);
            L5:
                Integer r103 = r101.position;
                if (r103 == null) goto L8;
                ProtoAdapter.INT32.encodeWithTag(r100, 2, r103);
            L8:
                Integer r104 = r101.badge_count;
                if (r104 == null) goto L11;
                ProtoAdapter.INT32.encodeWithTag(r100, 3, r104);
            L11:
                r100.writeBytes(r101.unknownFields());
            }

            @Override // com.squareup.wire.ProtoAdapter
            public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ReadStatesExtra r101) throws IOException {
                encode2(r100, r101);
            }
        }

        static {
            ADAPTER = new ProtoAdapter_ReadStatesExtra();
            DEFAULT_ME_READ = Boolean.FALSE;
            DEFAULT_POSITION = 0;
            DEFAULT_BADGE_COUNT = 0;
        }

        @Override // com.squareup.wire.Message
        public Builder newBuilder() {
            Builder r100 = new Builder();
            r100.me_read = this.me_read;
            r100.position = this.position;
            r100.badge_count = this.badge_count;
            r100.addUnknownFields(unknownFields());
            return r100;
        }

        @Override // com.squareup.wire.Message
        public String toString() {
            return ReadStatesExtra.class.getName() + "@" + Integer.toHexString(hashCode());
        }

        @Override // com.squareup.wire.Message
        public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
            return newBuilder();
        }

        public ReadStatesExtra(Boolean r100, Integer r101, Integer r102) {
            this(r100, r101, r102, ByteString.EMPTY);
        }

        public ReadStatesExtra(Boolean r100, Integer r101, Integer r102, ByteString r103) {
            super(ADAPTER, r103);
            this.me_read = r100;
            this.position = r101;
            this.badge_count = r102;
        }
    }

    static {
        ProtoAdapter_PushMessageReadStates r100 = new ProtoAdapter_PushMessageReadStates();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.chat_id = this.chat_id;
        r100.read_states = Internal.copyOf("read_states", this.read_states);
        r100.read_states_extra = Internal.copyOf("read_states_extra", this.read_states_extra);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PushMessageReadStates.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PushMessageReadStates(String r100, Map<String, ReadStates> r101, Map<String, ReadStatesExtra> r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public PushMessageReadStates(String r100, Map<String, ReadStates> r101, Map<String, ReadStatesExtra> r102, ByteString r103) {
        super(ADAPTER, r103);
        this.chat_id = r100;
        this.read_states = Internal.immutableCopyOf("read_states", r101);
        this.read_states_extra = Internal.immutableCopyOf("read_states_extra", r102);
    }
}
