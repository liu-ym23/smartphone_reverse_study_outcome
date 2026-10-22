package com.bytedance.lark.pb.sync.v1;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class SyncPushEvent extends Message<SyncPushEvent, Builder> {
    public static final ProtoAdapter<SyncPushEvent> ADAPTER = null;
    public static final String DEFAULT_APP_NAME = "";
    public static final String DEFAULT_TOPIC_ID = "";
    public static final ProtoAdapter_SyncPushEvent RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final String app_name;
    public final SyncEvent sync_event;
    public final String topic_id;

    public static final class Builder extends Message.Builder<SyncPushEvent, Builder> implements d<SyncPushEvent> {
        public String app_name;
        public SyncEvent sync_event;
        public String topic_id;

        @Override // com.squareup.wire.Message.Builder
        public SyncPushEvent build() {
            String r100 = this.app_name;
            if (r100 == null) goto L11;
            if (this.topic_id == null) goto L11;
            if (this.sync_event == null) goto L11;
            return new SyncPushEvent(this.app_name, this.topic_id, this.sync_event, super.buildUnknownFields());
        L11:
            throw Internal.missingRequiredFields(new Object[]{r100, "app_name", this.topic_id, "topic_id", this.sync_event, "sync_event"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder app_name(String r100) {
            this.app_name = r100;
            return this;
        }

        public Builder sync_event(SyncEvent r100) {
            this.sync_event = r100;
            return this;
        }

        public Builder topic_id(String r100) {
            this.topic_id = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_SyncPushEvent extends ProtoAdapter<SyncPushEvent> implements c<SyncPushEvent> {
        public ProtoAdapter_SyncPushEvent() {
            super(FieldEncoding.LENGTH_DELIMITED, SyncPushEvent.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public SyncPushEvent decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.app_name = "";
            r101.topic_id = "";
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L15;
            if (r103 != 1) goto L8;
            r101.app_name = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.topic_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L11;
            r101.sync_event = SyncEvent.ADAPTER.decode(r100);
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
        public int encodedSize2(SyncPushEvent r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return ((r101.encodedSizeWithTag(1, r100.app_name) + r101.encodedSizeWithTag(2, r100.topic_id)) + SyncEvent.ADAPTER.encodedSizeWithTag(3, r100.sync_event)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ SyncPushEvent decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(SyncPushEvent r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, SyncPushEvent r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.encodeWithTag(r100, 1, r101.app_name);
            r102.encodeWithTag(r100, 2, r101.topic_id);
            SyncEvent.ADAPTER.encodeWithTag(r100, 3, r101.sync_event);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, SyncPushEvent r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_SyncPushEvent r100 = new ProtoAdapter_SyncPushEvent();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.app_name = this.app_name;
        r100.topic_id = this.topic_id;
        r100.sync_event = this.sync_event;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return SyncPushEvent.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public SyncPushEvent(String r100, String r101, SyncEvent r102) {
        this(r100, r101, r102, ByteString.EMPTY);
    }

    public SyncPushEvent(String r100, String r101, SyncEvent r102, ByteString r103) {
        super(ADAPTER, r103);
        this.app_name = r100;
        this.topic_id = r101;
        this.sync_event = r102;
    }
}
