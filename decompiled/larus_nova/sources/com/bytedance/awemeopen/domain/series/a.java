package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/a;", "", "", "albumId", "J", "getAlbumId", "()J", "setAlbumId", "(J)V", "appId", "getAppId", "setAppId", "displayForbidden", "getDisplayForbidden", "setDisplayForbidden", "displayControl", "getDisplayControl", "setDisplayControl", "interactionControl", "getInteractionControl", "setInteractionControl", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class a implements Cloneable {

    @SerializedName("AlbumId")
    private long albumId;

    @SerializedName(com.alipay.sdk.m.p.e.f25660h)
    private long appId;

    @SerializedName("DisplayControl")
    private long displayControl;

    @SerializedName("DisplayForbidden")
    private long displayForbidden;

    @SerializedName("InteractionControl")
    private long interactionControl;

    public a() {
    }

    public final Object clone() {
        return super.clone();
    }
}
