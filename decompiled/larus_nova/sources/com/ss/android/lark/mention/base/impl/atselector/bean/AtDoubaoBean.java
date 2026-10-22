package com.ss.android.lark.mention.base.impl.atselector.bean;

import android.content.Context;
import android.widget.ImageView;
import com.ss.android.lark.image.ImageModule;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtDoubaoBean;", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/BaseAtBean;", "chatChatter", "Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtChatterInfo;", "<init>", "(Lcom/ss/android/lark/mention/base/impl/atselector/bean/AtChatterInfo;)V", "getType", "", "getId", "", "getDisplayName", "getPinyin", "", "showAvatar", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "imageView", "Landroid/widget/ImageView;", "width", "height", "Companion", "im-mention-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AtDoubaoBean extends BaseAtBean {
    public static final a Companion = null;
    private static final long serialVersionUID = -5977531557505484463L;
    private final com.ss.android.lark.mention.base.impl.atselector.bean.a chatChatter;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public char getPinyin() {
        return '0';
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public int getType() {
        return 8;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getDisplayName() {
        return this.chatChatter.f431697c;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public String getId() {
        return this.chatChatter.f431695a;
    }

    public AtDoubaoBean(com.ss.android.lark.mention.base.impl.atselector.bean.a r100) {
        Intrinsics.checkNotNullParameter(r100, "chatChatter");
        this.chatChatter = r100;
    }

    @Override // com.ss.android.lark.mention.base.impl.atselector.bean.BaseAtBean
    public void showAvatar(Context r100, ImageView r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "imageView");
        com.ss.android.lark.mention.base.impl.atselector.bean.a r104 = this.chatChatter;
        String r105 = r104.f431696b;
        String r106 = r104.f431695a;
        LoadParams r107 = new LoadParams();
        r107.f426328a = r102;
        r107.f426329b = r103;
        ImageModule.a(r100, r101, r105, r106, r107);
    }
}
