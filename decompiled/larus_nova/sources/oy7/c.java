package oy7;

import com.alibaba.fastjson.JSON;
import com.larksuite.component.blockit.entity.SearchTagsResponseWrap;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.http.response.BaseResponse;
import com.larksuite.framework.http.response.ErrorResult;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes24.dex */
public final class c extends z18.b<BaseResponse> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback f527148a;

    public c(IGetDataCallback r100) {
        this.f527148a = r100;
    }

    @Override // z18.b
    public final void a(ErrorResult r100) {
        Log.w("HashTagService", r100.toString());
        IGetDataCallback r101 = this.f527148a;
        if (r101 == null) goto L6;
        r101.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r100.getHttpStatusCode(), r100.getErrorMessage()));
        return;
    }

    @Override // z18.c
    public final void onSuccess(Object r100) {
        BaseResponse r101 = (BaseResponse) r100;
        if (r101 == null) goto L28;
        String r102 = r101.message();     // Catch: Exception -> L16
        SearchTagsResponseWrap r103 = (SearchTagsResponseWrap) JSON.parseObject(r102, SearchTagsResponseWrap.class);     // Catch: Exception -> L14
        if (r103.code != 0) goto L10;
        IGetDataCallback r104 = this.f527148a;     // Catch: Exception -> L14
        if (r104 == null) goto L24;
        r104.onSuccess(r103.data);     // Catch: Exception -> L14
    L24:
        return;
    L10:
        Log.w("HashTagService", "result:" + r102);     // Catch: Exception -> L14
        IGetDataCallback r105 = this.f527148a;     // Catch: Exception -> L14
        if (r105 == null) goto L24;
        r105.onError(new com.larksuite.framework.callback.Entity.ErrorResult(r103.code, r103.msg));     // Catch: Exception -> L14
    L14:
        e = e;
    L18:
        Log.w("HashTagService", "searchTags result:" + r102, e);
        IGetDataCallback r106 = this.f527148a;
        if (r106 == null) goto L29;
        r106.onError(new com.larksuite.framework.callback.Entity.ErrorResult("Error"));
        return;
    L29:
        return;
    L16:
        e = e;
        r102 = null;
        goto L18
    }
}
