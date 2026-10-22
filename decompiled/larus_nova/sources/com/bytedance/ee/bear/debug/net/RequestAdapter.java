package com.bytedance.ee.bear.debug.net;

import android.content.Context;
import android.widget.TextView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qx4.d;
import qx4.e;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/debug/net/RequestAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/contract/DebugRequest;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "convert", "", "helper", MapController.ITEM_LAYER_TAG, "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestAdapter extends BaseQuickAdapter<DebugRequest, BaseViewHolder> {

    public static final class a {
    }

    static {
    }

    public RequestAdapter() {
        super(R.layout.item_request);
    }

    public static final /* synthetic */ Context y2(RequestAdapter r100) {
        return r100.mContext;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder r100, DebugRequest r110) {
        DebugRequest r111 = r110;
        Intrinsics.checkNotNullParameter(r100, "helper");
        if (r111 != null) goto L5;
        tt5.a.h(BaseQuickAdapter.TAG, "DebugRequest is null, position = " + r100.getBindingAdapterPosition() + ", return");
        return;
    L5:
        int r101 = -1;
        int r102 = new JSONObject(r111.f216902g).optInt("code");     // Catch: Throwable -> L8
    L10:
        if (r102 != 0) goto L12;
        int r103 = this.mContext.getResources().getColor(R.color.text_title);
    L24:
        int r104 = new JSONObject(r111.f216902g).optInt("code");     // Catch: Throwable -> L15
    L16:
        if (r104 != 0) goto L18;
        int r105 = this.mContext.getResources().getColor(R.color.text_caption);
    L19:
        BaseViewHolder r106 = r100.setText(R.id.url, r111.f216897b).setTextColor(R.id.url, r103);
        StringBuilder r107 = new StringBuilder("code:");
        r101 = new JSONObject(r111.f216902g).optInt("code");     // Catch: Throwable -> L23
    L21:
        r107.append(r101);
        r106.setText(R.id.resultCode, r107.toString()).setTextColor(R.id.resultCode, r105).setText(R.id.logid, "logId:" + r111.f216900e).setTextColor(R.id.logid, r105);
        ((TextView) r100.getView(R.id.logid)).setOnLongClickListener(new d(r111, this));
        r100.getView(R.id.url).setOnClickListener(new e(this, r111));
        return;
    L18:
        r105 = this.mContext.getResources().getColor(R.color.function_danger_fill_default);
    L15:
        r104 = -1;
        goto L16
    L12:
        r103 = this.mContext.getResources().getColor(R.color.function_danger_fill_default);
    L8:
        r102 = -1;
        goto L10
    }
}
