package com.bytedance.lark.pb.feed.v1;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import com.squareup.wire.FieldEncoding;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.ProtoReader;
import com.squareup.wire.ProtoWriter;
import com.squareup.wire.WireEnum;
import com.squareup.wire.internal.Internal;
import java.io.IOException;
import java.util.Map;
import okio.ByteString;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final class FeedCardPushInfo extends Message<FeedCardPushInfo, Builder> {
    public static final ProtoAdapter<FeedCardPushInfo> ADAPTER = null;
    private static final long serialVersionUID = 0;
    public final FeedFilter.List list;
    public final Map<Integer, Action> list_action;
    public final FeedEntityPreview preview;
    public final RemoveFeed remove_info;

    public static final enum Action extends Enum<Action> implements WireEnum {
        private static final /* synthetic */ Action[] $VALUES = null;
        public static final ProtoAdapter<Action> ADAPTER = null;
        public static final Action Remove = null;
        public static final Action TempOrRemove = null;
        public static final Action Update = null;
        public static final Action UpdateCanTemp = null;
        private final int value;

        static {
            Action r100 = new Action(UserChangedCallback.CHANGE_TYPE_UPDATE, 0, 0);
            Update = r100;
            Action r101 = new Action("UpdateCanTemp", 1, 1);
            UpdateCanTemp = r101;
            Action r102 = new Action("TempOrRemove", 2, 2);
            TempOrRemove = r102;
            Action r103 = new Action("Remove", 3, 3);
            Remove = r103;
            $VALUES = new Action[]{r100, r101, r102, r103};
            ADAPTER = ProtoAdapter.newEnumAdapter(Action.class);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }

        @Override // com.squareup.wire.WireEnum
        public final int getValue() {
            return this.value;
        }

        public static Action fromValue(int r100) {
            if (r100 == 0) goto L18;
            if (r100 == 1) goto L16;
            if (r100 == 2) goto L14;
            if (r100 == 3) goto L12;
            return null;
        L12:
            return Remove;
        L14:
            return TempOrRemove;
        L16:
            return UpdateCanTemp;
        L18:
            return Update;
        }

        public static Action valueOf(String r100) {
            return (Action) a.a(Action.class, r100);
        }

        private Action(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class Builder extends Message.Builder<FeedCardPushInfo, Builder> {
        public FeedFilter.List list;
        public Map<Integer, Action> list_action;
        public FeedEntityPreview preview;
        public RemoveFeed remove_info;

        @Override // com.squareup.wire.Message.Builder
        public FeedCardPushInfo build() {
            return new FeedCardPushInfo(this.preview, this.list, this.remove_info, this.list_action, super.buildUnknownFields());
        }

        public Builder() {
            this.list_action = Internal.newMutableMap();
        }

        @Override // com.squareup.wire.Message.Builder
        public /* bridge */ /* synthetic */ Message build() {
            return build();
        }

        public Builder list(FeedFilter.List r100) {
            this.list = r100;
            return this;
        }

        public Builder list_action(Map<Integer, Action> r100) {
            Internal.checkElementsNotNull(r100);
            this.list_action = r100;
            return this;
        }

        public Builder preview(FeedEntityPreview r100) {
            this.preview = r100;
            return this;
        }

        public Builder remove_info(RemoveFeed r100) {
            this.remove_info = r100;
            return this;
        }
    }

    public static final class ProtoAdapter_FeedCardPushInfo extends ProtoAdapter<FeedCardPushInfo> {
        private final ProtoAdapter<Map<Integer, Action>> list_action;

        public ProtoAdapter_FeedCardPushInfo() {
            super(FieldEncoding.LENGTH_DELIMITED, FeedCardPushInfo.class);
            this.list_action = ProtoAdapter.newMapAdapter(ProtoAdapter.INT32, Action.ADAPTER);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.ProtoAdapter
        public FeedCardPushInfo decode(ProtoReader r100) throws IOException {
            Builder r101 = new Builder();
            long r102 = r100.beginMessage();
        L3:
            int r103 = r100.nextTag();
            if (r103 == (-1)) goto L18;
            if (r103 != 1) goto L8;
            r101.preview = FeedEntityPreview.ADAPTER.decode(r100);
            goto L3
        L8:
            if (r103 != 2) goto L10;
            r101.list = FeedFilter.List.ADAPTER.decode(r100);
            goto L3
        L10:
            if (r103 != 3) goto L12;
            r101.remove_info = RemoveFeed.ADAPTER.decode(r100);
            goto L3
        L12:
            if (r103 != 4) goto L13;
            r101.list_action.putAll(this.list_action.decode(r100));
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
        public int encodedSize2(FeedCardPushInfo r100) {
            FeedEntityPreview r101 = r100.preview;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = FeedEntityPreview.ADAPTER.encodedSizeWithTag(1, r101);
        L6:
            FeedFilter.List r104 = r100.list;
            if (r104 == null) goto L9;
            int r105 = FeedFilter.List.ADAPTER.encodedSizeWithTag(2, r104);
        L10:
            int r106 = r103 + r105;
            RemoveFeed r107 = r100.remove_info;
            if (r107 == null) goto L14;
            r102 = RemoveFeed.ADAPTER.encodedSizeWithTag(3, r107);
        L14:
            return ((r106 + r102) + this.list_action.encodedSizeWithTag(4, r100.list_action)) + r100.unknownFields().size();
        L9:
            r105 = 0;
            goto L10
        L5:
            r103 = 0;
            goto L6
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ FeedCardPushInfo decode(ProtoReader r100) throws IOException {
            return decode(r100);
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ int encodedSize(FeedCardPushInfo r100) {
            return encodedSize2(r100);
        }

        /* JADX INFO: renamed from: encode, reason: avoid collision after fix types in other method */
        public void encode2(ProtoWriter r100, FeedCardPushInfo r101) throws IOException {
            FeedEntityPreview r102 = r101.preview;
            if (r102 == null) goto L5;
            FeedEntityPreview.ADAPTER.encodeWithTag(r100, 1, r102);
        L5:
            FeedFilter.List r103 = r101.list;
            if (r103 == null) goto L8;
            FeedFilter.List.ADAPTER.encodeWithTag(r100, 2, r103);
        L8:
            RemoveFeed r104 = r101.remove_info;
            if (r104 == null) goto L11;
            RemoveFeed.ADAPTER.encodeWithTag(r100, 3, r104);
        L11:
            this.list_action.encodeWithTag(r100, 4, r101.list_action);
            r100.writeBytes(r101.unknownFields());
        }

        @Override // com.squareup.wire.ProtoAdapter
        public /* bridge */ /* synthetic */ void encode(ProtoWriter r100, FeedCardPushInfo r101) throws IOException {
            encode2(r100, r101);
        }
    }

    static {
        ADAPTER = new ProtoAdapter_FeedCardPushInfo();
    }

    @Override // com.squareup.wire.Message
    public Builder newBuilder() {
        Builder r100 = new Builder();
        r100.preview = this.preview;
        r100.list = this.list;
        r100.remove_info = this.remove_info;
        r100.list_action = Internal.copyOf("list_action", this.list_action);
        r100.addUnknownFields(unknownFields());
        return r100;
    }

    @Override // com.squareup.wire.Message
    public String toString() {
        return FeedCardPushInfo.class.getName() + "@" + Integer.toHexString(hashCode());
    }

    @Override // com.squareup.wire.Message
    public /* bridge */ /* synthetic */ Message.Builder newBuilder() {
        return newBuilder();
    }

    public FeedCardPushInfo(FeedEntityPreview r100, FeedFilter.List r101, RemoveFeed r102, Map<Integer, Action> r110) {
        this(r100, r101, r102, r110, ByteString.EMPTY);
    }

    public FeedCardPushInfo(FeedEntityPreview r100, FeedFilter.List r101, RemoveFeed r102, Map<Integer, Action> r103, ByteString r104) {
        super(ADAPTER, r104);
        this.preview = r100;
        this.list = r101;
        this.remove_info = r102;
        this.list_action = Internal.immutableCopyOf("list_action", r103);
    }
}
