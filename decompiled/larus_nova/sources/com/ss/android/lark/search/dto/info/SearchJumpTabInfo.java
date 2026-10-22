package com.ss.android.lark.search.dto.info;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/search/dto/info/SearchJumpTabInfo;", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "appLink", "", "<init>", "(Ljava/lang/String;)V", "getAppLink", "()Ljava/lang/String;", PickerReporterConstants.KEY.TARGET, "slashId", "getSlashId", "equals", "", "other", "", "hashCode", "", "getTagForReport", "getResultTypeForReport", "search-dto_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SearchJumpTabInfo extends SearchBaseInfo {
    private final String appLink;
    private final String slashId;
    private final String target;

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getResultTypeForReport() {
        return "more_results";
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public int hashCode() {
        return Objects.hash(new Object[]{this.appLink, getTitle()});
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public String getTagForReport() {
        return this.target.toLowerCase() + "_section";
    }

    public final String getAppLink() {
        return this.appLink;
    }

    public final String getSlashId() {
        return this.slashId;
    }

    public SearchJumpTabInfo(String r100) {
        this.appLink = r100;
        this.type = SearchCommonConstants.SearchResultType.JUMP_TAB;
        String r101 = "";
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        Uri r102 = UriProtector.parse(r100);
        String r103 = UriProtector.getQueryParameter(r102, PickerReporterConstants.KEY.TARGET);
        if (r103 != null) goto L8;
        r103 = "";
    L8:
        this.target = r103;
        String r104 = UriProtector.getQueryParameter(r102, "commandId");
        if (r104 == null) goto L12;
        r101 = r104;
    L12:
        this.slashId = r101;
    }

    @Override // com.ss.android.lark.search.dto.info.SearchBaseInfo
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L8;
    L17:
        return false;
    L8:
        if ((r100 instanceof SearchJumpTabInfo) == false) goto L17;
        SearchJumpTabInfo r101 = (SearchJumpTabInfo) r100;
        if (Intrinsics.areEqual(this.appLink, r101.appLink) == true) goto L13;
    L15:
        return false;
    L13:
        if (Intrinsics.areEqual(getTitle(), r101.getTitle()) == false) goto L15;
        return true;
    }
}
