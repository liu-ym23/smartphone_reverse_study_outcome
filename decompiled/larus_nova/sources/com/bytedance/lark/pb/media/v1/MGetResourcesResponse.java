package com.bytedance.lark.pb.media.v1;

import com.bytedance.lark.pb.basic.v1.Trace;
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
public final class MGetResourcesResponse extends Message<MGetResourcesResponse, Builder> {
    public static final ProtoAdapter<MGetResourcesResponse> ADAPTER = null;
    public static final Boolean DEFAULT_FROM_NET = null;
    public static final ProtoAdapter_MGetResourcesResponse RAW_TYPE_ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final Boolean from_net;
    public final List<String> miss_keys;
    public final Map<String, Resource> resources;
    public final Trace trace;

    public static final class Builder extends Message.Builder<MGetResourcesResponse, Builder> implements d<MGetResourcesResponse> {
        public Boolean from_net;
        public List<String> miss_keys;
        public Map<String, Resource> resources;
        public Trace trace;

        @Override // com.squareup.wire.Message.Builder
        public MGetResourcesResponse build() {
            return new MGetResourcesResponse(this.resources, this.miss_keys, this.trace, this.from_net, super.buildUnknownFields());
        }

        public Builder() {
            this.resources = Internal.newMutableMap();
            this.miss_keys = Internal.newMutableList();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder from_net(Boolean r100) {
            this.from_net = r100;
            return this;
        }

        public Builder miss_keys(List<String> r100) {
            Internal.checkElementsNotNull(r100);
            this.miss_keys = r100;
            return this;
        }

        public Builder resources(Map<String, Resource> r100) {
            Internal.checkElementsNotNull(r100);
            this.resources = r100;
            return this;
        }

        public Builder trace(Trace r100) {
            this.trace = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_MGetResourcesResponse extends ProtoAdapter<MGetResourcesResponse> implements c<MGetResourcesResponse> {
        private final ProtoAdapter<Map<String, Resource>> resources;

        public ProtoAdapter_MGetResourcesResponse() {
            super(FieldEncoding.LENGTH_DELIMITED, MGetResourcesResponse.class);
            this.resources = ProtoAdapter.newMapAdapter(ProtoAdapter.STRING, Resource.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public MGetResourcesResponse decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            r101.from_net = Boolean.FALSE;
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.resources.putAll(this.resources.decode(r100));
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.miss_keys.add(ProtoAdapter.STRING.decode(r100));
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.trace = Trace.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.from_net = ProtoAdapter.BOOL.decode(r100);
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
        public int encodedSize2(MGetResourcesResponse r100) {
            int r101 = this.resources.encodedSizeWithTag(1, r100.resources) + ProtoAdapter.STRING.asRepeated().encodedSizeWithTag(2, r100.miss_keys);
            Trace r102 = r100.trace;
            int r103 = 0;
            if (r102 == null) goto L5;
            int r104 = Trace.ADAPTER.encodedSizeWithTag(3, r102);
        L6:
            int r105 = r101 + r104;
            Boolean r106 = r100.from_net;
            if (r106 == null) goto L10;
            r103 = ProtoAdapter.BOOL.encodedSizeWithTag(4, r106);
        L10:
            return (r105 + r103) + r100.unknownFields().size();
        L5:
            r104 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ MGetResourcesResponse decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(MGetResourcesResponse r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, MGetResourcesResponse r101) throws IOException {
            this.resources.encodeWithTag(r100, 1, r101.resources);
            ProtoAdapter.STRING.asRepeated().encodeWithTag(r100, 2, r101.miss_keys);
            Trace r102 = r101.trace;
            if (r102 == null) goto L5;
            Trace.ADAPTER.encodeWithTag(r100, 3, r102);
        L5:
            Boolean r103 = r101.from_net;
            if (r103 == null) goto L8;
            ProtoAdapter.BOOL.encodeWithTag(r100, 4, r103);
        L8:
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, MGetResourcesResponse r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ProtoAdapter_MGetResourcesResponse r100 = new ProtoAdapter_MGetResourcesResponse();
        RAW_TYPE_ADAPTER = r100;
        ADAPTER = r100;
        DEFAULT_FROM_NET = Boolean.FALSE;
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.resources = Internal.copyOf("resources", this.resources);
        r100.miss_keys = Internal.copyOf("miss_keys", this.miss_keys);
        r100.trace = this.trace;
        r100.from_net = this.from_net;
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return MGetResourcesResponse.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public MGetResourcesResponse(Map<String, Resource> r100, List<String> r101, Trace r102, Boolean r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public MGetResourcesResponse(Map<String, Resource> r100, List<String> r101, Trace r102, Boolean r103, ByteString r104) {
        super(ADAPTER, r104);
        this.resources = Internal.immutableCopyOf("resources", r100);
        this.miss_keys = Internal.immutableCopyOf("miss_keys", r101);
        this.trace = r102;
        this.from_net = r103;
    }
}
