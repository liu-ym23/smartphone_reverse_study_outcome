package com.bytedance.locallife.photo.photopage.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.ContextCompat;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.dux.text.DuxTextView;
import com.bytedance.locallife.dito.utils.o;
import com.bytedance.locallife.model.album.TabInfo;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003H\u0007¨\u0006\u000f"}, d2 = {"Lcom/bytedance/locallife/photo/photopage/view/PoiAlbumTagItemView;", "Lcom/bytedance/dux/text/DuxTextView;", "Lcom/bytedance/locallife/model/album/TabInfo;", "Lcom/bytedance/locallife/photo/album/model/TabInfo;", "tabInfo", "", "setData", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "locallife-photo-impl_release"}, k = 1, mv = {1, 4, 3})
public final class PoiAlbumTagItemView extends DuxTextView {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Drawable f262287f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Drawable f262288g;

    public PoiAlbumTagItemView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PoiAlbumTagItemView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final void setData(TabInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "tabInfo");
        setText(r100.getTabName() + '(' + r100.getTabCount() + ')');
        setBackground(this.f262288g);
        setTextColor(ContextCompat.getColor(getContext(), R.color.POIPrimary2));
    }

    public PoiAlbumTagItemView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setGravity(17);
        setPadding((int) UIUtils.dip2Px(r100, 10.0f), (int) UIUtils.dip2Px(r100, 5.0f), (int) UIUtils.dip2Px(r100, 10.0f), (int) UIUtils.dip2Px(r100, 5.0f));
        if (Build.VERSION.SDK_INT < 23) goto L5;
        setTextAppearance(R.style.font_size_26_sp);
    L6:
        this.f262287f = o.a(new PoiAlbumTagItemView$selectedBackground$1(r100));
        this.f262288g = o.a(new PoiAlbumTagItemView$unSelectedBackground$1(r100));
        return;
    L5:
        setTextAppearance(r100, R.style.font_size_26_sp);
        goto L6
    }

    public /* synthetic */ PoiAlbumTagItemView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
