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
public final class GetBlockActionSourceDetailContent extends Message<GetBlockActionSourceDetailContent, Builder> {
    public static final ProtoAdapter<GetBlockActionSourceDetailContent> ADAPTER = null;
    public static final String DEFAULT_ACTION_TIME = "";
    private static final long serialVersionUID = 0;
    public final String action_time;
    public final List<GetBlockActionSourceDetailMessage> messages;

    public static final class Builder extends Message.Builder<GetBlockActionSourceDetailContent, Builder> {
        public String action_time;
        public List<GetBlockActionSourceDetailMessage> messages;

        @Override // com.squareup.wire.Message.Builder
        public GetBlockActionSourceDetailContent build() {
            String r100 = this.action_time;
            if (r100 == null) goto L7;
            return new GetBlockActionSourceDetailContent(this.action_time, this.messages, super.buildUnknownFields());
        L7:
            throw Internal.missingRequiredFields(new Object[]{r100, "action_time"});
        }

        public Builder() {
            this.messages = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder action_time(String r100) {
            this.action_time = r100;
            return this;
        }

        public Builder messages(List<GetBlockActionSourceDetailMessage> r100) {
            Internal.checkElementsNotNull(r100);
            this.messages = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_GetBlockActionSourceDetailContent extends ProtoAdapter<GetBlockActionSourceDetailContent> {
        public ProtoAdapter_GetBlockActionSourceDetailContent() {
            super(FieldEncoding.LENGTH_DELIMITED, GetBlockActionSourceDetailContent.class);
        }

        @Override // com.squareup.wire.ProtoAdapter
        /* JADX INFO: renamed from: decode, reason: avoid collision after fix types in other method */
        public GetBlockActionSourceDetailContent decode2(ProtoReader r100) throws IOException {
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
            r101.messages.add(GetBlockActionSourceDetailMessage.ADAPTER.decode(r100));
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
        public int encodedSize2(GetBlockActionSourceDetailContent r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.action_time) + GetBlockActionSourceDetailMessage.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.messages)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ GetBlockActionSourceDetailContent decode(ProtoReader r100) throws IOException {
            return decode2(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(GetBlockActionSourceDetailContent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, GetBlockActionSourceDetailContent r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.action_time);
            GetBlockActionSourceDetailMessage.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.messages);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, GetBlockActionSourceDetailContent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_GetBlockActionSourceDetailContent();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.action_time = this.action_time;
        r100.messages = Internal.copyOf("messages", this.messages);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return GetBlockActionSourceDetailContent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public GetBlockActionSourceDetailContent(String r100, List<GetBlockActionSourceDetailMessage> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public GetBlockActionSourceDetailContent(String r100, List<GetBlockActionSourceDetailMessage> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.action_time = r100;
        this.messages = Internal.immutableCopyOf("messages", r101);
    }
}
