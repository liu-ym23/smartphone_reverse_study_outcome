package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0096\u0002¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/bean/SkeletonAtBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "<init>", "()V", "getType", "", "getId", "", "getDisplayName", "getPinyin", "", "showAvatar", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "width", "height", "hashCode", "equals", "", "other", "", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SkeletonAtBean extends BaseAtBean {
    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return "";
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return "skeleton";
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return ' ';
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 9;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public SkeletonAtBean() {
    }
}
