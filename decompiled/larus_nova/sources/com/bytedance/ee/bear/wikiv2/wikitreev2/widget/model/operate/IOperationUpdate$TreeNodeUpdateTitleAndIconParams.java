package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/IOperationUpdate$TreeNodeUpdateTitleAndIconParams;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/BaseOperationParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", WikiFolderPushPlugin.WIKI_TOKEN, "", "spaceId", "newTitle", "newIconInfo", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOperationUpdate$TreeNodeUpdateTitleAndIconParams extends zq5.a implements NonProguard {
    public String newIconInfo;
    public String newTitle;
    public String spaceId;
    public String wikiToken;

    public IOperationUpdate$TreeNodeUpdateTitleAndIconParams() {
        this.wikiToken = "";
        this.spaceId = "";
    }
}
