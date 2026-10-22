package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/IOperationMove$TreeNodeMoveToWikiParams;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/BaseOperationParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "srcToken", "", "srcParentToken", "srcSpaceId", "destParentToken", "destSpaceId", "forceExpand", "", "expandToToken", "moveSource", "", "sortId", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOperationMove$TreeNodeMoveToWikiParams extends zq5.a implements NonProguard {
    public String destParentToken;
    public String destSpaceId;
    public String expandToToken;
    public boolean forceExpand;
    public int moveSource;
    public double sortId;
    public String srcParentToken;
    public String srcSpaceId;
    public String srcToken;

    public IOperationMove$TreeNodeMoveToWikiParams() {
        this.srcToken = "";
        this.srcParentToken = "";
        this.srcSpaceId = "";
        this.destParentToken = "";
        this.destSpaceId = "";
    }
}
