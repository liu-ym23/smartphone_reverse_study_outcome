package oy7;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.BlockEntity;
import com.larksuite.component.blockit.entity.CreateTagAndAddItemResponseWrap;
import com.larksuite.component.blockit.entity.ItemTags;
import com.larksuite.component.blockit.props.i;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.ss.android.lark.log.Log;
import java.util.Collections;

/* JADX INFO: loaded from: classes24.dex */
public final class b extends z18.b<BaseResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BlockEntity f527146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f527147b;

    @Override // z18.b
    public final void a(ErrorResult r100) {
        Log.w("HashTagService", r100.toString());
        IGetDataCallback r101 = this.f527147b;
        if (r101 == null) goto L6;
        r101.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r100.getHttpStatusCode(), r100.getErrorMessage()));
        return;
    }

    @Override // z18.c
    public final void onSuccess(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        if (r101 == null) goto L28;
        String r102 = r101.message();     // Catch: Exception -> L16
        CreateTagAndAddItemResponseWrap r103 = (CreateTagAndAddItemResponseWrap) JSON.parseObject(r102, CreateTagAndAddItemResponseWrap.class);     // Catch: Exception -> L14
        if (r103.code != 0) goto L10;
        i r104 = i.b.f283125a;     // Catch: Exception -> L14
        String r105 = this.f527146a.getBlockID();     // Catch: Exception -> L14
        ItemTags r106 = r103.data.latestItemTags;     // Catch: Exception -> L14
        r104.a(r105, Collections.singletonMap(r106.uniqId, r106));     // Catch: Exception -> L14
        IGetDataCallback r107 = this.f527147b;     // Catch: Exception -> L14
        if (r107 == null) goto L24;
        r107.onSuccess(r103.data);     // Catch: Exception -> L14
    L24:
        return;
    L10:
        Log.w("HashTagService", "result:" + r102);     // Catch: Exception -> L14
        IGetDataCallback r108 = this.f527147b;     // Catch: Exception -> L14
        if (r108 == null) goto L24;
        r108.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r103.code, r103.msg));     // Catch: Exception -> L14
    L14:
        e = e;
    L18:
        Log.w("HashTagService", "createTag result:" + r102, e);
        IGetDataCallback r109 = this.f527147b;
        if (r109 == null) goto L29;
        r109.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
        return;
    L29:
        return;
    L16:
        e = e;
        r102 = null;
        goto L18
    }

    public b(BlockEntity r100, IGetDataCallback r101) {
        this.f527146a = r100;
        this.f527147b = r101;
    }
}
