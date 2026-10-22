package com.larus.uaigc.helper;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/uaigc/helper/CreationRemoteFallbackState;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", HttpMethod.DOWNLOAD, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum CreationRemoteFallbackState extends Enum<CreationRemoteFallbackState> {
    public static final CreationRemoteFallbackState DOWNLOAD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CreationRemoteFallbackState[] f372962a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f372963b = null;
    private final String value;

    public static EnumEntries<CreationRemoteFallbackState> getEntries() {
        return f372963b;
    }

    static {
        CreationRemoteFallbackState r100 = new CreationRemoteFallbackState();
        DOWNLOAD = r100;
        CreationRemoteFallbackState[] r101 = {r100};
        f372962a = r101;
        f372963b = EnumEntriesKt.enumEntries(r101);
    }

    public CreationRemoteFallbackState() {
        super(HttpMethod.DOWNLOAD, 0);
        this.value = "download";
    }

    public static CreationRemoteFallbackState[] values() {
        return (CreationRemoteFallbackState[]) f372962a.clone();
    }

    public final String getValue() {
        return this.value;
    }

    public static CreationRemoteFallbackState valueOf(String r100) {
        return (CreationRemoteFallbackState) r27.a.a(CreationRemoteFallbackState.class, r100);
    }
}
