package com.bytedance.ee.bear.document.offline.sync.preloadtask;

import com.bytedance.ee.util.io.NonProguard;
import du5.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001c\u001a\u00020\u0017H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000bj\b\u0012\u0004\u0012\u00020\u0013`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/PreloadSubblock;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "code", "", "getCode", "()I", "setCode", "(I)V", "resList", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/ResDetail;", "Lkotlin/collections/ArrayList;", "getResList", "()Ljava/util/ArrayList;", "setResList", "(Ljava/util/ArrayList;)V", "embedDocList", "Lcom/bytedance/ee/bear/document/offline/sync/preloadtask/EmbedDocList;", "getEmbedDocList", "setEmbedDocList", "token", "", "getToken", "()Ljava/lang/String;", "setToken", "(Ljava/lang/String;)V", "toString", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PreloadSubblock implements NonProguard {
    private int code;
    private ArrayList<EmbedDocList> embedDocList;
    private ArrayList<ResDetail> resList;
    private String token;

    public String toString() {
        return "preloadSubblock(code=" + this.code + ", resList=" + this.resList + ", embedDocList=" + this.embedDocList + ", token=" + b.g(this.token);
    }

    public PreloadSubblock() {
        this.resList = new ArrayList();
        this.embedDocList = new ArrayList();
    }

    public final int getCode() {
        return this.code;
    }

    public final ArrayList<EmbedDocList> getEmbedDocList() {
        return this.embedDocList;
    }

    public final ArrayList<ResDetail> getResList() {
        return this.resList;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setCode(int r100) {
        this.code = r100;
    }

    public final void setEmbedDocList(ArrayList<EmbedDocList> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.embedDocList = r100;
    }

    public final void setResList(ArrayList<ResDetail> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.resList = r100;
    }

    public final void setToken(String r100) {
        this.token = r100;
    }
}
