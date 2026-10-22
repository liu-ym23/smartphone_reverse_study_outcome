package com.ss.android.lark.chat.entity.chatter;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u00162\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0016B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u000e\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0015\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\u0014\b\u0002\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/chat/entity/chatter/BotMutedInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "muteScene", "", "", "", "<init>", "(Ljava/util/Map;)V", "getMuteScene", "()Ljava/util/Map;", "isItemSame", "diffable", "isContentSame", "equals", "other", "", "component1", "copy", "hashCode", "", "toString", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BotMutedInfo implements Serializable, y28.b<BotMutedInfo> {
    public static final a Companion = null;
    private final Map<String, Boolean> muteScene;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BotMutedInfo copy$default(BotMutedInfo r100, Map r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.muteScene;
    L6:
        return r100.copy(r101);
    }

    public final Map<String, Boolean> component1() {
        return this.muteScene;
    }

    public final BotMutedInfo copy(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "muteScene");
        return new BotMutedInfo(r100);
    }

    public int hashCode() {
        return this.muteScene.hashCode();
    }

    public String toString() {
        return "BotMutedInfo(muteScene=" + this.muteScene + ')';
    }

    public final Map<String, Boolean> getMuteScene() {
        return this.muteScene;
    }

    public BotMutedInfo(Map<String, Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "muteScene");
        this.muteScene = r100;
    }

    @JvmStatic
    public static final com.bytedance.lark.pb.basic.v1.Chatter.BotMutedInfo parse(BotMutedInfo r100) {
        Companion.getClass();
        if (r100 == null) goto L7;
        Map<String, Boolean> r101 = r100.getMuteScene();
        if (r101 == null) goto L7;
        return new com.bytedance.lark.pb.basic.v1.Chatter.BotMutedInfo.Builder().muted_scenes(r101).build();
    L7:
        return null;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 == null) goto L8;
        Class<?> r101 = r100.getClass();
    L10:
        if (Intrinsics.areEqual(BotMutedInfo.class, r101) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.chatter.BotMutedInfo");
        if (Intrinsics.areEqual(this.muteScene, ((BotMutedInfo) r100).muteScene) == true) goto L15;
        return false;
    L15:
        return true;
    L8:
        r101 = null;
        goto L10
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isContentSame(y28.b r100) {
        return isContentSame((BotMutedInfo) r100);
    }

    @Override // y28.b
    public /* bridge */ /* synthetic */ boolean isItemSame(y28.b r100) {
        return isItemSame((BotMutedInfo) r100);
    }

    @JvmStatic
    public static final BotMutedInfo parse(com.bytedance.lark.pb.basic.v1.Chatter.BotMutedInfo r100) {
        Companion.getClass();
        if (r100 != null) goto L6;
        return null;
    L6:
        return new BotMutedInfo(r100.muted_scenes);
    }

    public boolean isContentSame(BotMutedInfo r100) {
        return equals(r100);
    }

    public boolean isItemSame(BotMutedInfo r100) {
        return equals(r100);
    }
}
