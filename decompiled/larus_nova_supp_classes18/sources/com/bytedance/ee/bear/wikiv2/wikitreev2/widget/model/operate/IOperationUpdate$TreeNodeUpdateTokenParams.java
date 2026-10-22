package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/IOperationUpdate$TreeNodeUpdateTokenParams;", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/model/operate/BaseOperationParams;", "Lcom/bytedance/ee/util/io/NonProguard;", "newTreeNode", "Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;", "<init>", "(Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/bean/TreeNode;)V", "oldWikiToken", "", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class IOperationUpdate$TreeNodeUpdateTokenParams extends zq5.a implements NonProguard {
    public final TreeNode newTreeNode;
    public String oldWikiToken;

    public IOperationUpdate$TreeNodeUpdateTokenParams(TreeNode r2) {
        Intrinsics.checkNotNullParameter(r2, "newTreeNode");
        this.newTreeNode = r2;
        this.oldWikiToken = "";
    }
}
