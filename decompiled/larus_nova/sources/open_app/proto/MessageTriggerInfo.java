package open_app.proto;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes42.dex */
public final class MessageTriggerInfo extends Message<MessageTriggerInfo, Builder> {
    public static final ProtoAdapter<MessageTriggerInfo> ADAPTER = null;
    public static final String DEFAULT_ACTION_TIME = "";
    private static final long serialVersionUID = 0;
    public final String action_time;
    public final List<String> message_ids;

    public static final class Builder extends Message.Builder<MessageTriggerInfo, Builder> {
        public String action_time;
        public List<String> message_ids;

        @Override // com.squareup.wire.Message.Builder
        public MessageTriggerInfo build() {
            String r100 = this.action_time;
            if (r100 == null) goto L7;
            return new MessageTriggerInfo(this.action_time, this.message_ids, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_time"});
        }

        public Builder() {
            this.message_ids = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_time(String r100) {
            this.action_time = r100;
            return this;
        }

        public Builder message_ids(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.message_ids = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MessageTriggerInfo extends ProtoAdapter<MessageTriggerInfo> {
        public ProtoAdapter_MessageTriggerInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, MessageTriggerInfo.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public MessageTriggerInfo decode2(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.action_time = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.message_ids.add(ProtoAdapter.STRING.decode(r100));
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
        public int encodedSize2(MessageTriggerInfo r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (r101.encodedSizeWithTag(1, r100.action_time) + r101.asRepeated().encodedSizeWithTag(2, r100.message_ids)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MessageTriggerInfo decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MessageTriggerInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MessageTriggerInfo r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.action_time);
            r102.asRepeated().encodeWithTag(r100, 2, r101.message_ids);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MessageTriggerInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_MessageTriggerInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_time = this.action_time;
        r100.message_ids = Internal.copyOf("message_ids", this.message_ids);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MessageTriggerInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MessageTriggerInfo(String r100, List<String> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public MessageTriggerInfo(String r100, List<String> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.action_time = r100;
        this.message_ids = Internal.immutableCopyOf("message_ids", r101);
    }
}
