package com.bytedance.awemeopen.domain.series;

import com.bytedance.android.ec.model.response.ECFloatWindowInfo;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/c;", "", "", "id", "J", "getId", "()J", "setId", "(J)V", "", "tagName", "Ljava/lang/String;", "getTagName", "()Ljava/lang/String;", "setTagName", "(Ljava/lang/String;)V", ECFloatWindowInfo.INFO_TYPE_ATTRIBUTE, "getAttribute", "setAttribute", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class c implements Cloneable {

    @SerializedName("Attribute")
    private String attribute;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("Id")
    private long f198456id;

    @SerializedName("TagName")
    private String tagName;

    public c() {
    }

    public final Object clone() {
        return super.clone();
    }
}
