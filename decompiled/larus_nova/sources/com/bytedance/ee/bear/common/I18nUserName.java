package com.bytedance.ee.bear.common;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/common/I18nUserName;", "Lcom/bytedance/ee/util/io/NonProguard;", "ja_jp", "", "zh_cn", "en_us", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getJa_jp", "()Ljava/lang/String;", "getZh_cn", "getEn_us", "base-util_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class I18nUserName implements NonProguard {
    private final String en_us;
    private final String ja_jp;
    private final String zh_cn;

    public I18nUserName() {
        this(null, null, null, 7, null);
    }

    public final String getEn_us() {
        return this.en_us;
    }

    public final String getJa_jp() {
        return this.ja_jp;
    }

    public final String getZh_cn() {
        return this.zh_cn;
    }

    public I18nUserName(String r100, String r101, String r102) {
        this.ja_jp = r100;
        this.zh_cn = r101;
        this.en_us = r102;
    }

    public /* synthetic */ I18nUserName(String r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
