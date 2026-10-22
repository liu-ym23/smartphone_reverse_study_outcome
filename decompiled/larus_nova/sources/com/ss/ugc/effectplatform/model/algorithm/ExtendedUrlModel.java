package com.ss.ugc.effectplatform.model.algorithm;

import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import ilc.a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B1\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0014R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/ugc/effectplatform/model/algorithm/ExtendedUrlModel;", "", ScoreTags.STAR_URL_LIST, "", "", "uri", "zip_url_list", "(Ljava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getUri", "()Ljava/lang/String;", "setUri", "(Ljava/lang/String;)V", "getUrl_list", "()Ljava/util/List;", "setUrl_list", "(Ljava/util/List;)V", "getZip_url_list", "setZip_url_list", "getUrl", "type", "Lcom/ss/ugc/effectplatform/model/algorithm/FetchModelType;", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public class ExtendedUrlModel {
    private String uri;
    private List<String> url_list;
    private List<String> zip_url_list;

    public ExtendedUrlModel() {
        this(null, null, null, 7, null);
    }

    public String getUri() {
        return this.uri;
    }

    public List<String> getUrl_list() {
        return this.url_list;
    }

    public List<String> getZip_url_list() {
        return this.zip_url_list;
    }

    public final List<String> getUrl(FetchModelType r100) {
        int r101 = a.f490364a[r100.ordinal()];
        if (r101 == 1) goto L10;
        if (r101 != 2) goto L8;
        return getUrl_list();
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return getZip_url_list();
    }

    public void setUri(String r100) {
        this.uri = r100;
    }

    public void setUrl_list(List<String> r100) {
        this.url_list = r100;
    }

    public void setZip_url_list(List<String> r100) {
        this.zip_url_list = r100;
    }

    public ExtendedUrlModel(List<String> r100, String r101, List<String> r102) {
        this.url_list = r100;
        this.uri = r101;
        this.zip_url_list = r102;
    }

    public /* synthetic */ ExtendedUrlModel(List r100, String r101, List r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = new ArrayList();
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = new ArrayList();
    L11:
        this(r100, r101, r102);
    }
}
