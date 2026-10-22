package com.ss.android.lark.chameleonv2.container.webcontainer.res.resupdate;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/chameleonv2/container/webcontainer/res/resupdate/ChameleonChannel;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "DEFAULT_CHANNEL", "chameleon_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ChameleonChannel extends Enum<ChameleonChannel> {
    public static final ChameleonChannel DEFAULT_CHANNEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ChameleonChannel[] f411270a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f411271b = null;
    private final String value;

    public static EnumEntries<ChameleonChannel> getEntries() {
        return f411271b;
    }

    static {
        ChameleonChannel r100 = new ChameleonChannel();
        DEFAULT_CHANNEL = r100;
        ChameleonChannel[] r101 = {r100};
        f411270a = r101;
        f411271b = EnumEntriesKt.enumEntries(r101);
    }

    public ChameleonChannel() {
        super("DEFAULT_CHANNEL", 0);
        this.value = "Chameleon_default_channel";
    }

    public static ChameleonChannel[] values() {
        return (ChameleonChannel[]) f411270a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static ChameleonChannel valueOf(String r100) {
        return (ChameleonChannel) r27.a.a(ChameleonChannel.class, r100);
    }
}
