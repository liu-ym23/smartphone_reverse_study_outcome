package com.larus.platform.model.audio;

import com.larus.media.MediaScene;
import com.larus.network.http.ServiceType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/platform/model/audio/ClientConfigKey;", "", "key", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "REALTIME_CALL", "DORA_RADIO", ServiceType.DORA, "IM", "CLICK_TALK", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ClientConfigKey extends Enum<ClientConfigKey> {
    public static final ClientConfigKey CLICK_TALK = null;
    public static final ClientConfigKey DORA = null;
    public static final ClientConfigKey DORA_RADIO = null;
    public static final ClientConfigKey IM = null;
    public static final ClientConfigKey REALTIME_CALL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ClientConfigKey[] f365553a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365554b = null;
    private final String key;

    public static EnumEntries<ClientConfigKey> getEntries() {
        return f365554b;
    }

    static {
        ClientConfigKey r100 = new ClientConfigKey("REALTIME_CALL", 0, "realtimeCall");
        REALTIME_CALL = r100;
        ClientConfigKey r101 = new ClientConfigKey("DORA_RADIO", 1, "doraRadio");
        DORA_RADIO = r101;
        ClientConfigKey r102 = new ClientConfigKey(ServiceType.DORA, 2, MediaScene.DORA);
        DORA = r102;
        ClientConfigKey r103 = new ClientConfigKey("IM", 3, "im");
        IM = r103;
        ClientConfigKey r104 = new ClientConfigKey("CLICK_TALK", 4, "clickTalk");
        CLICK_TALK = r104;
        ClientConfigKey[] r105 = {r100, r101, r102, r103, r104};
        f365553a = r105;
        f365554b = EnumEntriesKt.enumEntries(r105);
    }

    public static ClientConfigKey[] values() {
        return (ClientConfigKey[]) f365553a.clone();
    }

    public final String getKey() {
        return this.key;
    }

    public static ClientConfigKey valueOf(String r100) {
        return (ClientConfigKey) a.a(ClientConfigKey.class, r100);
    }

    public ClientConfigKey(String r100, int r101, String r102) {
        super(r100, r101);
        this.key = r102;
    }
}
