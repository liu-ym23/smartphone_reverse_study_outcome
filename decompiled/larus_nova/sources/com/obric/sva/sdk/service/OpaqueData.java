package com.obric.sva.sdk.service;

import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\r\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\u000fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\u0005¨\u0006\u0016"}, d2 = {"Lcom/obric/sva/sdk/service/OpaqueData;", "", TemplateNodeType.RAW, "", "<init>", "([B)V", "getRaw", "()[B", "size", "", "getSize", "()I", "keywordLength", "getKeywordLength", "setKeywordLength", "(I)V", "ftrtLength", "getFtrtLength", "setFtrtLength", "ftrtData", "getFtrtData", "setFtrtData", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OpaqueData {
    private byte[] ftrtData;
    private int ftrtLength;
    private int keywordLength;
    private final byte[] raw;

    public final int getSize() {
        return this.raw.length;
    }

    public final byte[] getFtrtData() {
        return this.ftrtData;
    }

    public final int getFtrtLength() {
        return this.ftrtLength;
    }

    public final int getKeywordLength() {
        return this.keywordLength;
    }

    public final byte[] getRaw() {
        return this.raw;
    }

    public OpaqueData(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        this.raw = r100;
    }

    public final void setFtrtData(byte[] r100) {
        this.ftrtData = r100;
    }

    public final void setFtrtLength(int r100) {
        this.ftrtLength = r100;
    }

    public final void setKeywordLength(int r100) {
        this.keywordLength = r100;
    }
}
