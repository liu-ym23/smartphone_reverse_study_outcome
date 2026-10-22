package com.larus.camera.impl.widget.title;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewGroupKt;
import ay8.e;
import ay8.f;
import ay8.g;
import ay8.h;
import com.byted.cast.linkcommon.cybergarage.upnp.IconList;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u0010\u001a\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0012J\b\u0010\u0013\u001a\u00020\fH\u0002R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/camera/impl/widget/title/TitleRightIconGroupView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemSpacingPx", "setItemSpacing", "", "createAndAddIcon", "iconItem", "Lcom/larus/camera/impl/widget/title/TitleRightIcon;", "setIconList", IconList.ELEM_NAME, "", "updateItemSpacing", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TitleRightIconGroupView extends LinearLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f322925b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f322926a;

    public TitleRightIconGroupView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TitleRightIconGroupView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void a() {
        Iterator<View> r100 = ViewGroupKt.getChildren(this).iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L23;
        View r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        View r104 = r102;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        if ((r105 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r106 = (ViewGroup.MarginLayoutParams) r105;
    L12:
        if (r106 == null) goto L17;
        if (r101 != 0) goto L15;
        int r107 = 0;
    L16:
        r106.setMarginStart(r107);
    L22:
        r104.setLayoutParams(r106);
        r101 = r103;
        goto L4
    L15:
        r107 = this.f322926a;
        goto L16
    L17:
        r106 = new ViewGroup.MarginLayoutParams(-2, -2);
        if (r101 != 0) goto L20;
        int r108 = 0;
    L21:
        r106.setMarginStart(r108);
        goto L22
    L20:
        r108 = this.f322926a;
        goto L21
    L11:
        r106 = null;
        goto L12
    }

    public final void setIconList(List<e> r100) {
        Intrinsics.checkNotNullParameter(r100, IconList.ELEM_NAME);
        removeAllViews();
        Iterator<e> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        final e r102 = r101.next();
        TitleRightIconView r103 = new TitleRightIconView(getContext(), null, 6, 0);
        r103.setIcon(new f(r102));
        r103.setHint(new g(r102));
        r103.setContentDescription(r102.f16766f);
        e1.d(r103, new h(r102));
        addView(r103);
        a();
        r102.f16763c.invoke(r103);
        goto L4
    }

    public final void setItemSpacing(int r100) {
        this.f322926a = r100;
        setShowDividers(0);
        a();
    }

    public TitleRightIconGroupView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(0);
        setDividerDrawable(new ColorDrawable(0));
        setDividerPadding(c7.b(4));
        setShowDividers(2);
        setGravity(GravityCompat.END);
    }

    public /* synthetic */ TitleRightIconGroupView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
