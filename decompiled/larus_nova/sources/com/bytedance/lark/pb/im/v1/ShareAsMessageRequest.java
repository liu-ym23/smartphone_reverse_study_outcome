package com.bytedance.lark.pb.im.v1;

import com.bytedance.android.ec.core.event.a;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.List;
import okio.ByteString;
import we6.c;
import we6.d;

/* JADX INFO: loaded from: classes20.dex */
public final class ShareAsMessageRequest extends Message<ShareAsMessageRequest, Builder> {
    public static final ProtoAdapter<ShareAsMessageRequest> ADAPTER = null;
    public static final ProtoAdapter_ShareAsMessageRequest RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final List<ShareObject> share_object;
    public final List<ShareTarget> targets;

    public static final class Builder extends Message.Builder<ShareAsMessageRequest, Builder> implements d<ShareAsMessageRequest> {
        public List<ShareObject> share_object;
        public List<ShareTarget> targets;

        @Override // com.squareup.wire.Message.Builder
        public ShareAsMessageRequest build() {
            return new ShareAsMessageRequest(this.share_object, this.targets, super.buildUnknownFields());
        }

        public Builder() {
            this.share_object = Internal.newMutableList();
            this.targets = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder share_object(List<ShareObject> r100) {
            Internal.checkElementsNotNull(r100);
            this.share_object = r100;
            return this;
        }

        public Builder targets(List<ShareTarget> r100) {
            Internal.checkElementsNotNull(r100);
            this.targets = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_ShareAsMessageRequest extends ProtoAdapter<ShareAsMessageRequest> implements c<ShareAsMessageRequest> {
        public ProtoAdapter_ShareAsMessageRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, ShareAsMessageRequest.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public ShareAsMessageRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L12;
            if (r103 != 1) goto L8;
            r101.share_object.add(ShareObject.ADAPTER.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L9;
            r101.targets.add(ShareTarget.ADAPTER.decode(r100));
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
        public int encodedSize2(ShareAsMessageRequest r100) {
            return (ShareObject.ADAPTER.asRepeated().encodedSizeWithTag(1, r100.share_object) + ShareTarget.ADAPTER.asRepeated().encodedSizeWithTag(2, r100.targets)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ ShareAsMessageRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(ShareAsMessageRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, ShareAsMessageRequest r101) throws IOException {
            ShareObject.ADAPTER.asRepeated().encodeWithTag(r100, 1, r101.share_object);
            ShareTarget.ADAPTER.asRepeated().encodeWithTag(r100, 2, r101.targets);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, ShareAsMessageRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_ShareAsMessageRequest r100 = new ProtoAdapter_ShareAsMessageRequest();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.share_object = Internal.copyOf(a.KEY_SHARE_OBJECT, this.share_object);
        r100.targets = Internal.copyOf("targets", this.targets);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return ShareAsMessageRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public ShareAsMessageRequest(List<ShareObject> r100, List<ShareTarget> r101) {
        this(r100, r101, ByteString.EMPTY);
    }

    public ShareAsMessageRequest(List<ShareObject> r100, List<ShareTarget> r101, ByteString r102) {
        super(ADAPTER, r102);
        this.share_object = Internal.immutableCopyOf(a.KEY_SHARE_OBJECT, r100);
        this.targets = Internal.immutableCopyOf("targets", r101);
    }
}
