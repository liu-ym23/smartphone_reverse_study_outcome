package com.ss.android.rust.molten.ffi;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0012\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/ss/android/rust/molten/ffi/LogConfig;", "", "name", "", "path", "appId", "", "limitSize", "limitFileCount", "encodedPublicKey", "keyId", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "getPath", "getAppId", "()J", "getLimitSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLimitFileCount", "getEncodedPublicKey", "getKeyId", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LogConfig {
    private final long appId;
    private final String encodedPublicKey;
    private final String keyId;
    private final Long limitFileCount;
    private final Long limitSize;
    private final String name;
    private final String path;

    public final long getAppId() {
        return this.appId;
    }

    public final String getEncodedPublicKey() {
        return this.encodedPublicKey;
    }

    public final String getKeyId() {
        return this.keyId;
    }

    public final Long getLimitFileCount() {
        return this.limitFileCount;
    }

    public final Long getLimitSize() {
        return this.limitSize;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public LogConfig(String r100, String r101, long r102, Long r103, Long r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "path");
        this.name = r100;
        this.path = r101;
        this.appId = r102;
        this.limitSize = r103;
        this.limitFileCount = r104;
        this.encodedPublicKey = r105;
        this.keyId = r106;
    }

    public /* synthetic */ LogConfig(String r110, String r111, long r112, Long r113, Long r114, String r115, String r116, int r210, DefaultConstructorMarker r211) {
        if ((r210 & 8) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r210 & 16) == 0) goto L9;
        Long r101 = null;
    L11:
        if ((r210 & 32) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r210 & 64) == 0) goto L17;
        String r117 = null;
    L18:
        this(r110, r111, r112, r100, r101, r102, r117);
        return;
    L17:
        r117 = r116;
        goto L18
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
