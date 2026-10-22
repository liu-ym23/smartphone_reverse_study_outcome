package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/bean/MyAIBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "aiInfo", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/MyAIInfo;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/bean/MyAIInfo;)V", "getAiInfo", "()Lcom/ss/android/lark/mention/base/impl/atselector/bean/MyAIInfo;", "getType", "", "getId", "", "getDisplayName", "getPinyin", "", "showAvatar", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "width", "height", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MyAIBean extends BaseAtBean {
    private final e aiInfo;

    public final e getAiInfo() {
        return null;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return '0';
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 6;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        throw null;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        throw null;
    }

    public MyAIBean(e r100) {
        Intrinsics.checkNotNullParameter(r100, "aiInfo");
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        throw null;
    }
}
