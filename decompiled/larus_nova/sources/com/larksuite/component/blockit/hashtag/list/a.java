package com.larksuite.component.blockit.hashtag.list;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.larksuite.component.blockit.entity.BatchTagActionRequest;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.BlockInfo;
import com.larksuite.component.blockit.entity.GrantRecord4Get;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.mvp.BaseModel;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a extends BaseModel implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlockEntity f283037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f283038b;

    @Override // com.larksuite.framework.mvp.BaseModel, com.larksuite.framework.mvp.ILifecycle
    public final void create() {
        super.create();
    }

    public a(BlockEntity r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "blockEntity");
        this.f283037a = r100;
        this.f283038b = r101;
    }

    public static final String h(a r100, TagInstance.BasicTagInfo r101) {
        r100.getClass();
        String r102 = "";
        if (CollectionUtils.isEmpty(r101.owners) == true) goto L14;
        Iterator<GrantRecord4Get> r103 = r101.owners.iterator();
    L6:
        if (r103.hasNext() == false) goto L14;
        GrantRecord4Get r104 = r103.next();
        Map<String, String> r105 = r104.name;
        if (r105 == null) goto L6;
        if (CollectionUtils.isEmpty(r105.values()) == true) goto L6;
        r102 = r104.name.get(ry7.a.b());
        if (TextUtils.isEmpty(r102) == false) goto L6;
        r102 = (String) CollectionsKt.first(r104.name.values());
    L14:
        return r102;
    }

    @Override // com.larksuite.component.blockit.hashtag.list.j
    public final void B4(String r100, final UIGetDataCallback r101) {
        Intrinsics.checkNotNullParameter(r100, WikiFolderPushPlugin.BLOCK_ID);
        Intrinsics.checkNotNullParameter(r101, "callback");
        int r102 = oy7.a.d.f527145a;
        oy7.a.c(r100, true, true, this.f283038b, (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new HashTagListModel$loadAddedHashTags$1(this, r101)));
    }

    @Override // com.larksuite.component.blockit.hashtag.list.j
    public final void G7(String r100, String r101, final UIGetDataCallback r102) {
        Intrinsics.checkNotNullParameter(r100, "tagId");
        Intrinsics.checkNotNullParameter(r101, "tagInstanceId");
        Intrinsics.checkNotNullParameter(r102, "callback");
        int r103 = oy7.a.d.f527145a;
        BlockEntity r104 = this.f283037a;
        String r105 = this.f283038b;
        IGetDataCallback r106 = (IGetDataCallback) getCallbackManager().wrapAndAddCallback(new HashTagListModel$deleteTag$1(this, r102));
        Log.i("HashTagService", "deleteTag:" + r100 + ":" + r104.getBlockID());
        BatchTagActionRequest.RemoveTagAction r107 = new BatchTagActionRequest.RemoveTagAction();
        r107.tagId = r100;
        r107.tagType = 1;
        r107.tagInstanceId = r101;
        BatchTagActionRequest.ItemTagAction r108 = new BatchTagActionRequest.ItemTagAction();
        r108.uniqId = r104.getBlockID();
        r108.blockInfo = new BlockInfo(r104);
        r108.tagsRemoving = Collections.singletonList(r107);
        BatchTagActionRequest r109 = new BatchTagActionRequest();
        r109.itemsAction = Collections.singletonList(r108);
        r109.context = r105;
        oy7.a.a(r104.getBlockID(), r109, r106);
    }
}
