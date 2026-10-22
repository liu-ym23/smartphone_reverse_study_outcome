package com.bytedance.ee.bear.debug.net;

import android.content.Context;
import android.widget.TextView;
import com.bytedance.ee.bear.contract.DebugRequest;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import qx4.d;
import qx4.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0014¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/debug/net/RequestAdapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapter;", "Lcom/bytedance/ee/bear/contract/DebugRequest;", "Lcom/chad/library/adapter/base/BaseViewHolder;", "<init>", "()V", "convert", "", "helper", "item", "Companion", "dev-tools-debug-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RequestAdapter extends BaseQuickAdapter<DebugRequest, BaseViewHolder> {

    public static final class a {
    }

    static {
    }

    public RequestAdapter() {
        super(2131561665);
    }

    public static final /* synthetic */ Context y2(RequestAdapter r0) {
        return ((BaseQuickAdapter) r0).mContext;
    }

    public final void convert(BaseViewHolder r9, Object r10) {
        DebugRequest r11 = (DebugRequest) r10;
        Intrinsics.checkNotNullParameter(r9, "helper");
        if (r11 != null) goto L5;
        tt5.a.h(BaseQuickAdapter.TAG, "DebugRequest is null, position = " + r9.getBindingAdapterPosition() + ", return");
        return;
    L5:
        int r1 = -1;
        int r2 = new JSONObject(r11.g).optInt("code");     // Catch: Throwable -> L8
    L10:
        if (r2 != 0) goto L12;
        int r3 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131106622);
    L24:
        int r4 = new JSONObject(r11.g).optInt("code");     // Catch: Throwable -> L15
    L16:
        if (r4 != 0) goto L18;
        int r5 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131106607);
    L19:
        BaseViewHolder r6 = r9.setText(2131391945, r11.b).setTextColor(2131391945, r3);
        StringBuilder r7 = new StringBuilder("code:");
        r1 = new JSONObject(r11.g).optInt("code");     // Catch: Throwable -> L23
    L21:
        r7.append(r1);
        r6.setText(2131384445, r7.toString()).setTextColor(2131384445, r5).setText(2131379173, "logId:" + r11.e).setTextColor(2131379173, r5);
        ((TextView) r9.getView(2131379173)).setOnLongClickListener(new d(r11, this));
        r9.getView(2131391945).setOnClickListener(new e(this, r11));
        return;
    L18:
        r5 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131102093);
    L15:
        r4 = -1;
        goto L16
    L12:
        r3 = ((BaseQuickAdapter) this).mContext.getResources().getColor(2131102093);
    L8:
        r2 = -1;
        goto L10
    }
}
