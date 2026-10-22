package com.larus.bmhome.view.resourcebar.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001:\u0001\u0012B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011H&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "itemView", "Landroid/view/View;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Landroid/view/View;)V", "getConfig", "()Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "setConfig", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;)V", "bind", "", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "Callback", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class BaseResourceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ResourceBarConfig f317159a;

    /* JADX INFO: loaded from: classes4.dex */
    public interface a {

        /* JADX INFO: renamed from: com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: classes26.dex */
        public static final class C4120a {
            public static void a(String r100, View r101) {
                Intrinsics.checkNotNullParameter(r100, "key");
                Intrinsics.checkNotNullParameter(r101, BaseSwitches.V);
            }
        }

        void a(String r100, int r101, View r102);

        boolean b(String r100, View r101);
    }

    public abstract void T3(ResourceItemBean r100, lt8.a r101);

    public BaseResourceViewHolder(ResourceBarConfig r100, View r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "itemView");
        super(r101);
        this.f317159a = r100;
    }
}
