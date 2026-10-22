package com.bytedance.lark.pb.im.v1;

import com.larus.dora.api.model.FlowDoraWifiScene;
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
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SubscribeChatEventRequest extends Message<SubscribeChatEventRequest, Builder> {
    public static final ProtoAdapter<SubscribeChatEventRequest> ADAPTER = null;
    public static final SubscriptionKey DEFAULT_SUBSCRIPTION_KEY = null;
    public static final ProtoAdapter_SubscribeChatEventRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<String> subscribe_chat_ids;
    public final SubscriptionKey subscription_key;
    public final List<SubscriptionKey> subscription_keys;
    public final List<String> unsubscribe_chat_ids;

    public static final class Builder extends Message.Builder<SubscribeChatEventRequest, Builder> implements d<SubscribeChatEventRequest> {
        public List<String> subscribe_chat_ids;
        public SubscriptionKey subscription_key;
        public List<SubscriptionKey> subscription_keys;
        public List<String> unsubscribe_chat_ids;

        @Override // com.squareup.wire.Message.Builder
        public SubscribeChatEventRequest build() {
            return new SubscribeChatEventRequest(this.subscribe_chat_ids, this.unsubscribe_chat_ids, this.subscription_key, this.subscription_keys, super.buildUnknownFields());
        }

        public Builder() {
            this.subscribe_chat_ids = Internal.newMutableList();
            this.unsubscribe_chat_ids = Internal.newMutableList();
            this.subscription_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder subscribe_chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.subscribe_chat_ids = r100;
            return this;
        }

        public Builder subscription_key(SubscriptionKey r100) {
            this.subscription_key = r100;
            return this;
        }

        public Builder subscription_keys(List<SubscriptionKey> r100) {
            Internal.checkElementsNotNull(r100);
            this.subscription_keys = r100;
            return this;
        }

        public Builder unsubscribe_chat_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.unsubscribe_chat_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SubscribeChatEventRequest extends ProtoAdapter<SubscribeChatEventRequest> implements c<SubscribeChatEventRequest> {
        public ProtoAdapter_SubscribeChatEventRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, SubscribeChatEventRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SubscribeChatEventRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.subscription_key = SubscriptionKey.OTHER;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L24;
            if (r103 != 1) goto L8;
            r101.subscribe_chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.unsubscribe_chat_ids.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.subscription_key = SubscriptionKey.ADAPTER.decode(r100);     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L20
        L20:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.subscription_keys.add(SubscriptionKey.ADAPTER.decode(r100));     // Catch: ProtoAdapter.EnumConstantNotFoundException -> L16
        L16:
            e = move-exception;
            r101.addUnknownField(r103, FieldEncoding.VARINT, Long.valueOf(e.value));
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
        public int encodedSize2(SubscribeChatEventRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            int r102 = r101.asRepeated().encodedSizeWithTag(1, r100.subscribe_chat_ids) + r101.asRepeated().encodedSizeWithTag(2, r100.unsubscribe_chat_ids);
            SubscriptionKey r103 = r100.subscription_key;
            if (r103 == null) goto L5;
            int r104 = SubscriptionKey.ADAPTER.encodedSizeWithTag(3, r103);
        L7:
            return ((r102 + r104) + SubscriptionKey.ADAPTER.asRepeated().encodedSizeWithTag(4, r100.subscription_keys)) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L7
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SubscribeChatEventRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SubscribeChatEventRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SubscribeChatEventRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.subscribe_chat_ids);
            r102.asRepeated().encodeWithTag(r100, 2, r101.unsubscribe_chat_ids);
            SubscriptionKey r103 = r101.subscription_key;
            if (r103 == null) goto L5;
            SubscriptionKey.ADAPTER.encodeWithTag(r100, 3, r103);
        L5:
            SubscriptionKey.ADAPTER.asRepeated().encodeWithTag(r100, 4, r101.subscription_keys);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SubscribeChatEventRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    public static final enum SubscriptionKey extends Enum<SubscriptionKey> implements WireEnum {
        private static final /* synthetic */ SubscriptionKey[] $VALUES = null;
        public static final ProtoAdapter<SubscriptionKey> ADAPTER = null;
        public static final SubscriptionKey DOUBAO_SMART_REPLY = null;
        public static final SubscriptionKey DOUBAO_TYPING = null;
        public static final SubscriptionKey IMAGE_VIEWER = null;
        public static final SubscriptionKey OTHER = null;
        public static final SubscriptionKey SEARCH_WITH_MY_AI = null;
        private final int value;

        static {
            SubscriptionKey r100 = new SubscriptionKey(FlowDoraWifiScene.OTHER, 0, 0);
            OTHER = r100;
            SubscriptionKey r101 = new SubscriptionKey("IMAGE_VIEWER", 1, 1);
            IMAGE_VIEWER = r101;
            SubscriptionKey r102 = new SubscriptionKey("SEARCH_WITH_MY_AI", 2, 2);
            SEARCH_WITH_MY_AI = r102;
            SubscriptionKey r103 = new SubscriptionKey("DOUBAO_TYPING", 3, 3);
            DOUBAO_TYPING = r103;
            SubscriptionKey r104 = new SubscriptionKey("DOUBAO_SMART_REPLY", 4, 4);
            DOUBAO_SMART_REPLY = r104;
            $VALUES = new SubscriptionKey[]{r100, r101, r102, r103, r104};
            ADAPTER = ProtoAdapter.newEnumAdapter(SubscriptionKey.class);
        }

        public static SubscriptionKey[] values() {
            return (SubscriptionKey[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static SubscriptionKey fromValue(int r100) {
            if (r100 == 0) goto L22;
            if (r100 == 1) goto L20;
            if (r100 == 2) goto L18;
            if (r100 == 3) goto L16;
            if (r100 == 4) goto L14;
            return null;
        L14:
            return DOUBAO_SMART_REPLY;
        L16:
            return DOUBAO_TYPING;
        L18:
            return SEARCH_WITH_MY_AI;
        L20:
            return IMAGE_VIEWER;
        L22:
            return OTHER;
        }

        public static SubscriptionKey valueOf(String r100) {
            return (SubscriptionKey) a.a(SubscriptionKey.class, r100);
        }

        private SubscriptionKey(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        ProtoAdapter_SubscribeChatEventRequest r100 = new ProtoAdapter_SubscribeChatEventRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_SUBSCRIPTION_KEY = SubscriptionKey.OTHER;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.subscribe_chat_ids = Internal.copyOf("subscribe_chat_ids", this.subscribe_chat_ids);
        r100.unsubscribe_chat_ids = Internal.copyOf("unsubscribe_chat_ids", this.unsubscribe_chat_ids);
        r100.subscription_key = this.subscription_key;
        r100.subscription_keys = Internal.copyOf("subscription_keys", this.subscription_keys);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SubscribeChatEventRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SubscribeChatEventRequest(List<String> r100, List<String> r101, SubscriptionKey r102, List<SubscriptionKey> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public SubscribeChatEventRequest(List<String> r100, List<String> r101, SubscriptionKey r102, List<SubscriptionKey> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.subscribe_chat_ids = Internal.immutableCopyOf("subscribe_chat_ids", r100);
        this.unsubscribe_chat_ids = Internal.immutableCopyOf("unsubscribe_chat_ids", r101);
        this.subscription_key = r102;
        this.subscription_keys = Internal.immutableCopyOf("subscription_keys", r103);
    }
}
