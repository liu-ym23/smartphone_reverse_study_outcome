package com.ss.android.ugc.aweme.discover.model.commodity.selects;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/selects/SelectStatus;", "Ljava/io/Serializable;", "()V", "id", "", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "text", "getText", "setText", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public class SelectStatus implements Serializable {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private String f450564id;

    @SerializedName("text")
    private String text;

    public SelectStatus() {
    }

    public final String getId() {
        return this.f450564id;
    }

    public final String getText() {
        return this.text;
    }

    public final void setId(String r100) {
        this.f450564id = r100;
    }

    public final void setText(String r100) {
        this.text = r100;
    }
}
