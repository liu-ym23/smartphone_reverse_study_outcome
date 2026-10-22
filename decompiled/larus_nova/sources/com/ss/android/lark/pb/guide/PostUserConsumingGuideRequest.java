package com.ss.android.lark.pb.guide;

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

/* JADX INFO: loaded from: classes37.dex */
public final class PostUserConsumingGuideRequest extends Message<PostUserConsumingGuideRequest, Builder> {
    public static final ProtoAdapter<PostUserConsumingGuideRequest> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Map<String, String> mcontext;
    public final Map<String, Integer> mkey_step;
    public final List<String> mkeys;
    public final List<String> mkeys_done;

    public static final class Builder extends Message.Builder<PostUserConsumingGuideRequest, Builder> {
        public Map<String, String> mcontext;
        public Map<String, Integer> mkey_step;
        public List<String> mkeys;
        public List<String> mkeys_done;

        @Override // com.squareup.wire.Message.Builder
        public PostUserConsumingGuideRequest build() {
            return new PostUserConsumingGuideRequest(this.mkeys, this.mkey_step, this.mcontext, this.mkeys_done, super.buildUnknownFields());
        }

        public Builder() {
            this.mkeys = Internal.newMutableList();
            this.mkey_step = Internal.newMutableMap();
            this.mcontext = Internal.newMutableMap();
            this.mkeys_done = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder context(Map<String, String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mcontext = r100;
            return this;
        }

        public Builder key_step(Map<String, Integer> r100) {
            Internal.checkElementsNotNull(r100);
            this.mkey_step = r100;
            return this;
        }

        public Builder keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mkeys = r100;
            return this;
        }

        public Builder keys_done(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.mkeys_done = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_PostUserConsumingGuideRequest extends ProtoAdapter<PostUserConsumingGuideRequest> {
        private final ProtoAdapter<Map<String, String>> mcontext;
        private final ProtoAdapter<Map<String, Integer>> mkey_step;

        public ProtoAdapter_PostUserConsumingGuideRequest() {
            super(FieldEncoding.LENGTH_DELIMITED, PostUserConsumingGuideRequest.class);
            ProtoAdapter<String> r100 = ProtoAdapter.STRING;
            this.mkey_step = ProtoAdapter.newMapAdapter(r100, ProtoAdapter.INT32);
            this.mcontext = ProtoAdapter.newMapAdapter(r100, r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public PostUserConsumingGuideRequest decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.mkeys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.mkey_step.putAll(this.mkey_step.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.mcontext.putAll(this.mcontext.decode(r100));
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.mkeys_done.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L13:
            FieldEncoding r104 = r100.peekFieldEncoding();
            r101.addUnknownField(r103, r104, r104.rawProtoAdapter().decode(r100));
            goto L3
        L18:
            r100.endMessage(r102);
            return r101.build();
        }

        /* JADX INFO: renamed from: encodedSize, reason: avoid collision after fix types in other method */
        public int encodedSize2(PostUserConsumingGuideRequest r100) {
            ProtoAdapter<String> r101 = ProtoAdapter.STRING;
            return (((r101.asRepeated().encodedSizeWithTag(1, r100.mkeys) + this.mkey_step.encodedSizeWithTag(2, r100.mkey_step)) + this.mcontext.encodedSizeWithTag(3, r100.mcontext)) + r101.asRepeated().encodedSizeWithTag(4, r100.mkeys_done)) + r100.unknownFields().size();
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ PostUserConsumingGuideRequest decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(PostUserConsumingGuideRequest r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, PostUserConsumingGuideRequest r101) throws IOException {
            ProtoAdapter<String> r102 = ProtoAdapter.STRING;
            r102.asRepeated().encodeWithTag(r100, 1, r101.mkeys);
            this.mkey_step.encodeWithTag(r100, 2, r101.mkey_step);
            this.mcontext.encodeWithTag(r100, 3, r101.mcontext);
            r102.asRepeated().encodeWithTag(r100, 4, r101.mkeys_done);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, PostUserConsumingGuideRequest r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_PostUserConsumingGuideRequest();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.mkeys = Internal.copyOf("mkeys", this.mkeys);
        r100.mkey_step = Internal.copyOf("mkey_step", this.mkey_step);
        r100.mcontext = Internal.copyOf("mcontext", this.mcontext);
        r100.mkeys_done = Internal.copyOf("mkeys_done", this.mkeys_done);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return PostUserConsumingGuideRequest.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public PostUserConsumingGuideRequest(List<String> r100, Map<String, Integer> r101, Map<String, String> r102, List<String> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public PostUserConsumingGuideRequest(List<String> r100, Map<String, Integer> r101, Map<String, String> r102, List<String> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.mkeys = Internal.immutableCopyOf("mkeys", r100);
        this.mkey_step = Internal.immutableCopyOf("mkey_step", r101);
        this.mcontext = Internal.immutableCopyOf("mcontext", r102);
        this.mkeys_done = Internal.immutableCopyOf("mkeys_done", r103);
    }
}
