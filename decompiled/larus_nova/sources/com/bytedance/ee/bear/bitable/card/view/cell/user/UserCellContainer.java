package com.bytedance.ee.bear.bitable.card.view.cell.user;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.UserEntity;
import com.bytedance.ee.bear.bitable.common.widgets.flex.InnerRecyclerView;
import com.bytedance.ee.bear.bitable.common.widgets.flex.SafeFlexboxLayoutManager;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0018\u001a\u00020\u00192\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001bJ\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!J\u000e\u0010\"\u001a\u00020\u00192\u0006\u0010#\u001a\u00020!J\u0010\u0010$\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010&R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/user/UserCellContainer;", "Landroid/widget/RelativeLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", RootDescription.ROOT_ELEMENT, "Landroid/view/View;", "dropTriangle", "Landroid/widget/ImageView;", "flexView", "Lcom/bytedance/ee/bear/bitable/common/widgets/flex/IFlexView;", "Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/UserEntity;", "value", "Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;", "delegate", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;", "setDelegate", "(Lcom/bytedance/ee/bear/bitable/card/view/cell/user/IUserDelegate;)V", "setData", "", "userList", "", "limitVisibleLine", GXTemplateKey.STYLE_FONT_LINES, "", "setDropTriangleVisibility", "visible", "", "setDropTriangleSelected", "selected", "injectClickListener", "listener", "Landroid/view/View$OnClickListener;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UserCellContainer extends RelativeLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f208353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f208354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f208355c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.ee.bear.bitable.card.view.cell.user.a f208356d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InnerRecyclerView f208357a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final FlexUserAdapter f208358b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ UserCellContainer f208359c;

        public a(UserCellContainer r100, Context r101) {
            this.f208359c = r100;
            InnerRecyclerView r102 = (InnerRecyclerView) r100.f208353a.findViewById(R.id.recycler_view);
            this.f208357a = r102;
            FlexUserAdapter r103 = new FlexUserAdapter();
            this.f208358b = r103;
            r102.setLayoutManager(new SafeFlexboxLayoutManager(r101));
            r102.setAdapter(r103);
        }
    }

    public UserCellContainer(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public UserCellContainer(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final com.bytedance.ee.bear.bitable.card.view.cell.user.a getDelegate() {
        return this.f208356d;
    }

    public final void setData(List<? extends UserEntity> r100) {
        this.f208355c.f208358b.setNewData(r100);
    }

    public final void setDelegate(com.bytedance.ee.bear.bitable.card.view.cell.user.a r100) {
        this.f208356d = r100;
        this.f208355c.f208358b.f208350a = r100;
    }

    public final void setDropTriangleSelected(boolean r100) {
        this.f208354b.setSelected(r100);
    }

    public final void setDropTriangleVisibility(boolean r100) {
        ImageView r101 = this.f208354b;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public UserCellContainer(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_cell_user_container_v2, this);
        this.f208353a = r103;
        this.f208355c = new a(this, r100);
        this.f208354b = (ImageView) r103.findViewById(R.id.bitable_cell_user_drop_triangle);
    }

    public /* synthetic */ UserCellContainer(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
