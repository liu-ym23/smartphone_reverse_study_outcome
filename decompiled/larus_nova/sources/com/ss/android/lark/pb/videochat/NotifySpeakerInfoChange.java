package com.ss.android.lark.pb.videochat;

import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import okio.ByteString;

/* JADX INFO: loaded from: classes37.dex */
public final class NotifySpeakerInfoChange extends Message<NotifySpeakerInfoChange, Builder> {
    public static final ProtoAdapter<NotifySpeakerInfoChange> ADAPTER = null;
    public static final String DEFAULT_MEETING_ID = "";
    public static final Boolean DEFAULT_SPEAKER_INFO_CHANGE = null;
    private static final long serialVersionUID = 0;
    public final String mmeeting_id;
    public final Boolean mspeaker_info_change;

    public static final class Builder extends Message.Builder<NotifySpeakerInfoChange, Builder> {
        public String mmeeting_id;
        public Boolean mspeaker_info_change;

        @Override // com.squareup.wire.Message.Builder
        public NotifySpeakerInfoChange build() {
            String r100 = this.mmeeting_id;
            if (r100 == null) goto L9;
            if (this.mspeaker_info_change == null) goto L9;
            return new NotifySpeakerInfoChange(this.mmeeting_id, this.mspeaker_info_change, super.buildUnknownFields());
        L9:
            throw Internal.missingRequiredFields(new Object[]{r100, "mmeeting_id", this.mspeaker_info_change, "mspeaker_info_change"});
        }

        public Builder() {
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder meeting_id(String r100) {
            this.mmeeting_id = r100;
            return this;
        }

        public Builder speaker_info_change(Boolean r100) {
            this.mspeaker_info_change = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_NotifySpeakerInfoChange extends ProtoAdapter<NotifySpeakerInfoChange> {
        public ProtoAdapter_NotifySpeakerInfoChange() {
            super(FieldEncoding.LENGTH_DELIMITED, NotifySpeakerInfoChange.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public NotifySpeakerInfoChange decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.mmeeting_id = "";
            r101.mspeaker_info_change = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.mmeeting_id = ProtoAdapter.STRING.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.mspeaker_info_change = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(NotifySpeakerInfoChange r100) {
            return (ProtoAdapter.STRING.encodedSizeWithTag(1, r100.mmeeting_id) + ProtoAdapter.BOOL.encodedSizeWithTag(2, r100.mspeaker_info_change)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ NotifySpeakerInfoChange decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(NotifySpeakerInfoChange r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, NotifySpeakerInfoChange r101) throws IOException {
            ProtoAdapter.STRING.encodeWithTag(r100, 1, r101.mmeeting_id);
            ProtoAdapter.BOOL.encodeWithTag(r100, 2, r101.mspeaker_info_change);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, NotifySpeakerInfoChange r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_NotifySpeakerInfoChange();
        DEFAULT_SPEAKER_INFO_CHANGE = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mmeeting_id = this.mmeeting_id;
        r100.mspeaker_info_change = this.mspeaker_info_change;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return NotifySpeakerInfoChange.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public NotifySpeakerInfoChange(String r100, Boolean r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public NotifySpeakerInfoChange(String r100, Boolean r101, ByteString r102) {
        super(ADAPTER, r102);
        this.mmeeting_id = r100;
        this.mspeaker_info_change = r101;
    }
}
