package com.larksuite.component.blockit.props;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.larksuite.component.blockit.entity.BatchGetItemTagsResponse;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.entity.TagInstance;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.utils.CollectionUtils;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes24.dex */
class PropsViewManager$1 implements IGetDataCallback<BatchGetItemTagsResponse> {
    final /* synthetic */ i this$0;
    final /* synthetic */ String val$blockId;
    final /* synthetic */ a val$callback;
    final /* synthetic */ e val$finalConfig;
    final /* synthetic */ Map val$hitPointParams;
    final /* synthetic */ ViewGroup val$parentView;

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.larksuite.framework.callback.IGetDataCallback
    public void onError(ErrorResult r100) {
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onError(ErrorResult r100) {
        onError(r100);
    }

    public void onSuccess(BatchGetItemTagsResponse r100) {
        ArrayList r101 = new ArrayList();
        Iterator<ItemTags> r102 = r100.itemsTags.values().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        ItemTags r103 = r102.next();
        if (TextUtils.equals(this.val$blockId, r103.uniqId) == false) goto L4;
        Iterator<TagInstance> r104 = r103.tags.iterator();
    L9:
        if (r104.hasNext() == false) goto L4;
        TagInstance r105 = r104.next();
        TagInstance.BasicTagInfo r106 = r105.tagInfo;
        r101.add(new f(r106.name, r105.appLink, r106.tagId));
        goto L9
    L11:
        Log.i("PropsViewManager", "tags:" + r101);
        if (this.val$parentView == null) goto L22;
        PropsView r107 = new PropsView(this.val$parentView.getContext());
        this.val$parentView.addView(r107, new ViewGroup.LayoutParams(-1, -2));
        r107.x(r101, this.val$hitPointParams);
        if (CollectionUtils.isEmpty(r101) == true) goto L21;
        JSONObject r108 = new JSONObject(this.val$hitPointParams);
        r108.put("tag_count", r101.size());     // Catch: JSONException -> L18
    L20:
        qy7.a.a("pano_show_propsview", r108);
    L18:
        e = move-exception;
        Log.w("PropsViewManager", e);
    L21:
        this.this$0.f283121a.a(this.val$blockId, r107, this.val$callback);
    L23:
        a r109 = this.val$callback;
        if (r109 == null) goto L34;
        r101.size();
        r109.a();
        a r110 = this.val$callback;
        ((SpannableStringBuilder) c.a(r101, null)).toString();
        r110.b();
        return;
    L34:
        return;
    L22:
        this.this$0.f283121a.a(this.val$blockId, null, this.val$callback);
        goto L23
    }

    @Override // com.larksuite.framework.callback.IGetDataCallback, com.larksuite.framework.callback.IRequestCallback
    public /* bridge */ /* synthetic */ void onSuccess(Object r100) {
        onSuccess((BatchGetItemTagsResponse) r100);
    }

    public PropsViewManager$1(i r100, String r101, ViewGroup r102, e r103, Map r104, a r105) {
        this.this$0 = r100;
        this.val$blockId = r101;
        this.val$parentView = r102;
        this.val$hitPointParams = r104;
        this.val$callback = r105;
    }
}
