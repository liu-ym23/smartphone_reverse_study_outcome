package j4c;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.larksuite.component.decoration.avatar.DecoratedAvatar;
import com.larksuite.component.ui.avatar.v2.LarkAvatarView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b implements l, b08.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b08.a f497408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public DecoratedAvatar f497409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Context f497410c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ViewGroup f497411d;

    @Override // b08.c
    public final <M, V extends View> void registerModelBinder(Class<M> r100, Class<V> r101, b08.b<? super V, ? super M> r102) {
        this.f497408a.registerModelBinder(r100, r101, r102);
    }

    public b() {
        b08.a r100 = new b08.a();
        Intrinsics.checkNotNullParameter(r100, "compositeComponentDelegate");
        this.f497408a = r100;
    }

    public final Context getContext() {
        return this.f497410c;
    }

    @Override // j4c.l
    public final void a(Context r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "parent");
        this.f497410c = r100;
        this.f497411d = r101;
        r101.removeAllViews();
        AttributeSet r102 = null;
        DecoratedAvatar r103 = new DecoratedAvatar(r100, r102, 6, 0);
        r103.setId(R.id.avatar_item_decoration);
        RelativeLayout.LayoutParams r104 = new RelativeLayout.LayoutParams(a0.a(48.0f, r100), a0.a(48.0f, r100));
        r104.addRule(17, R.id.avatar_item_checkbox);
        r104.addRule(1, R.id.avatar_item_checkbox);
        r104.addRule(15);
        r104.setMarginStart(a0.a(16.0f, r100));
        r104.setMarginEnd(a0.a(12.0f, r100));
        r103.setLayoutParams(r104);
        r101.addView(r103);
        this.f497409b = r103;
        LarkAvatarView r105 = new LarkAvatarView(r100);
        r105.setId(R.id.avatar_item_avatar);
        r105.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r103.a(r105);
        LarkAvatarView r106 = new LarkAvatarView(r100);
        r106.setId(R.id.avatar_item_mini_avatar);
        RelativeLayout.LayoutParams r107 = new RelativeLayout.LayoutParams(a0.a(22.0f, r100), a0.a(22.0f, r100));
        r107.addRule(8, R.id.avatar_item_decoration);
        r107.addRule(19, R.id.avatar_item_decoration);
        r106.setLayoutParams(r107);
        r106.setScaleType(ImageView.ScaleType.CENTER_CROP);
        r106.setVisibility(8);
        r101.addView(r106);
    }

    @Override // j4c.l
    public final void b(Context r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        TypedArray r102 = r100.obtainStyledAttributes(r101, new int[]{R.attr.item_avatar_size, R.attr.item_check_box_size, R.attr.item_space_left, R.attr.item_space_mid, R.attr.item_space_right});
        int r103 = r102.getDimensionPixelSize(0, a0.a(48.0f, r100));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r104 = (int) r102.getDimension(3, j08.b.a(r100, 16.0f));
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r105 = (int) r102.getDimension(4, j08.b.a(r100, 12.0f));
        r102.recycle();
        DecoratedAvatar r106 = this.f497409b;
        RelativeLayout.LayoutParams r107 = null;
        if (r106 == null) goto L5;
        ViewGroup.LayoutParams r108 = r106.getLayoutParams();
    L7:
        if ((r108 instanceof RelativeLayout.LayoutParams) == false) goto L9;
        r107 = (RelativeLayout.LayoutParams) r108;
    L9:
        if (r107 == null) goto L12;
        r107.width = r103;
        r107.height = r103;
        r107.setMarginStart(r104);
        r107.setMarginEnd(r105);
        return;
    L12:
        return;
    L5:
        r108 = null;
        goto L7
    }
}
