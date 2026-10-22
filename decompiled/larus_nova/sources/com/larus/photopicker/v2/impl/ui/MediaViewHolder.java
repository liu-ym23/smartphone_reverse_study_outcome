package com.larus.photopicker.v2.impl.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.larus.photopicker.v2.impl.data.model.MediaType;
import com.larus.photopicker.v2.impl.databinding.LarusItemMediaBinding;
import com.larus.photopicker.v2.impl.e0;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import op9.d;
import v19.c;
import vp9.m;
import vp9.v;
import vp9.w;
import vp9.x;
import wp9.i;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001e\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u001e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\tJ\u0018\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\tH\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\bH\u0002J\u0016\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010 \u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0006\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/photopicker/v2/impl/ui/MediaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaBinding;", "resizeOption", "Lcom/facebook/imagepipeline/common/ResizeOptions;", "onItemClick", "Lkotlin/Function3;", "Lcom/larus/photopicker/v2/impl/model/UIMediaItem;", "", "Lcom/larus/photopicker/v2/impl/ui/ClickType;", "", "<init>", "(Lcom/larus/photopicker/v2/impl/databinding/LarusItemMediaBinding;Lcom/facebook/imagepipeline/common/ResizeOptions;Lkotlin/jvm/functions/Function3;)V", "TAG", "", "currentMedia", "currentMediaPosition", "bind", "mediaItem", "mediaListState", "Lcom/larus/photopicker/v2/impl/ui/MediaListStateData;", "dataPosition", "bindImage", "uiMediaItem", "bindVideoDuration", "bindNonImage", "bindPayload", "updateSelectionHitTarget", "useCompactSelectionHitTarget", "", "refreshSelectionView", "bindAnimator", "updateAccessibility", "selected", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MediaViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f364665g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusItemMediaBinding f364666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResizeOptions f364667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function3<d, Integer, ClickType, Unit> f364668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f364669d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public d f364670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f364671f;

    public static final class a {
    }

    static {
    }

    public final void V3(m r100) {
        Intrinsics.checkNotNullParameter(r100, "mediaListState");
        int r101 = e0.f364440a;
        e0.b(this.f364669d, "bindPayload: " + r100.f556683d);
        this.f364666a.f364415b.getHierarchy().setRoundingParams(r100.f556680a);
        if (r100.f556684e == false) goto L5;
        int r102 = 40;
    L6:
        Resources r103 = this.itemView.getResources();
        int r104 = (int) (r102 * WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).density);
        FrameLayout r105 = this.f364666a.f364417d;
        ViewGroup.LayoutParams r106 = r105.getLayoutParams();
        r106.width = r104;
        r106.height = r104;
        r105.setLayoutParams(r106);
        int r107 = r100.f556683d;
        int r108 = R.color.transparent;
        boolean r109 = true;
        if (r107 == 0) goto L13;
        if (r107 == 1) goto L12;
        if (r107 != 2) goto L14;
        this.f364666a.f364417d.setBackgroundResource(R.color.transparent);
        e1.x(this.f364666a.f364417d);
    L14:
        String r110 = this.f364669d;
        StringBuilder r111 = new StringBuilder("refreshSelectionView: ");
        r111.append(r100.f556683d);
        r111.append(' ');
        d r112 = this.f364670e;
        Context r113 = null;
        if (r112 == null) goto L17;
        Boolean r114 = Boolean.valueOf(r112.f524791b);
    L18:
        r111.append(r114);
        e0.b(r110, r111.toString());
        d r115 = this.f364670e;
        if (r115 != null) goto L21;
    L23:
        r109 = false;
    L24:
        if (r109 == false) goto L32;
        AppCompatTextView r116 = this.f364666a.f364416c;
        if (r116 == null) goto L28;
        r113 = r116.getContext();
    L28:
        r116.setBackgroundResource(c.b(com.larus.nova.R.attr.larus_tools_media_import_bg_image_selected, r113, com.larus.nova.R.drawable.larus_tools_media_import_bg_image_selected));
        if (r100.f556683d != 2) goto L31;
        this.f364666a.f364418e.setBackgroundResource(com.larus.nova.R.drawable.larus_tools_media_import_bg_item_shadow_round);
    L37:
        d r117 = this.f364670e;
        if (r117 == null) goto L40;
        W3(r117, r117.f524791b);
    L40:
        d r118 = this.f364670e;
        if (r118 == null) goto L44;
        T3(r118, r100);
        return;
    L44:
        return;
    L31:
        this.f364666a.f364418e.setBackgroundResource(com.larus.nova.R.color.larus_tools_media_item_shadow);
        goto L37
    L32:
        AppCompatTextView r119 = this.f364666a.f364416c;
        if (r100.f556683d == 2) goto L36;
        r108 = com.larus.nova.R.drawable.larus_tools_media_import_bg_image_select;
    L36:
        r119.setBackgroundResource(r108);
        goto L37
    L21:
        if (r115.f524791b != true) goto L23;
    L17:
        r114 = null;
        goto L18
    L12:
        this.f364666a.f364417d.setBackgroundResource(com.larus.nova.R.drawable.larus_tools_media_import_bg_media_select_indicator);
        e1.x(this.f364666a.f364417d);
        goto L14
    L13:
        e1.o(this.f364666a.f364417d);
        goto L14
    L5:
        r102 = 64;
        goto L6
    }

    public final void T3(d r100, m r101) {
        boolean r102 = false;
        float r103 = 1.0f;
        if (r100.f524791b == false) goto L10;
        if (r101.f556683d != 2) goto L7;
        float r104 = 1.0f;
    L8:
        boolean r105 = true;
    L17:
        if (this.f364666a.f364415b.getAlpha() != r103) goto L19;
        boolean r106 = true;
    L20:
        if (r106 == true) goto L23;
        this.f364666a.f364415b.setAlpha(r103);
    L23:
        if (this.f364666a.f364415b.getScaleX() != r104) goto L25;
        r102 = true;
    L25:
        if (r102 == true) goto L27;
        this.f364666a.f364415b.animate().scaleY(r104).scaleX(r104).setDuration(10).start();
    L27:
        i.c(this.f364666a.f364418e, r105);
        return;
    L19:
        r106 = false;
        goto L20
    L7:
        r104 = 1.1f;
        goto L8
    L10:
        if (r101.f556682c == true) goto L12;
    L14:
        float r107 = 0.3f;
    L15:
        r103 = r107;
        r104 = 1.0f;
        r105 = false;
        goto L17
    L12:
        if (r100.f524794e == false) goto L14;
        r107 = 1.0f;
        goto L15
    }

    public final void U3(d r100, m r101) {
        Intrinsics.checkNotNullParameter(r100, "mediaItem");
        Intrinsics.checkNotNullParameter(r101, "mediaListState");
        int r102 = r100.f524792c;
        if (r102 <= 0) goto L5;
        this.f364666a.f364416c.setText(String.valueOf(r102));
    L6:
        W3(r100, r100.f524791b);
        return;
    L5:
        this.f364666a.f364416c.setText("");
        goto L6
    }

    public final void W3(d r110, boolean r111) {
        Calendar r100 = Calendar.getInstance();
        r100.setTimeInMillis(r110.f524790a.f514739h * ((long) 1000));
        String r101 = String.valueOf(r100.get(1));
        String r102 = String.valueOf(r100.get(2) + 1);
        String r103 = String.valueOf(r100.get(5));
        String r104 = String.valueOf(r100.get(11));
        String r105 = String.valueOf(r100.get(12));
        if (r110.f524790a.getType() != MediaType.VIDEO) goto L5;
        boolean r106 = true;
    L6:
        if (r106 == false) goto L8;
        int r112 = com.larus.nova.R.string.larus_accessibility_album_video_cn;
    L9:
        if (r106 == false) goto L13;
        if (r111 == false) goto L12;
        int r107 = com.larus.nova.R.string.larus_accessibility_album_video_selected_cn;
    L16:
        LarusItemMediaBinding r113 = this.f364666a;
        r113.f364415b.setContentDescription(r113.f364414a.getContext().getString(r112, new Object[]{r101, r102, r103, r104, r105}));
        LarusItemMediaBinding r114 = this.f364666a;
        r114.f364416c.setContentDescription(r114.f364414a.getContext().getString(r107, new Object[]{r101, r102, r103, r104, r105}));
        return;
    L12:
        r107 = com.larus.nova.R.string.larus_accessibility_album_video_unselected_cn;
        goto L16
    L13:
        if (r111 == false) goto L15;
        r107 = com.larus.nova.R.string.larus_accessibility_album_photo_selected_cn;
        goto L16
    L15:
        r107 = com.larus.nova.R.string.larus_accessibility_album_photo_unselected_cn;
        goto L16
    L8:
        r112 = com.larus.nova.R.string.larus_accessibility_album_photo_cn;
        goto L9
    L5:
        r106 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MediaViewHolder(LarusItemMediaBinding r100, ResizeOptions r101, Function3<? super d, ? super Integer, ? super ClickType, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "binding");
        Intrinsics.checkNotNullParameter(r102, "onItemClick");
        super(r100.f364414a);
        this.f364666a = r100;
        this.f364667b = r101;
        this.f364668c = r102;
        this.f364669d = "MediaViewHolder";
        ImagePipelineFactory.getInstance().setNewLocalVideoThumbnailOptEnabled(true);
        this.itemView.setOnClickListener(new v(this));
        r100.f364417d.setOnClickListener(new w(this));
        r100.f364416c.setOnClickListener(new x(this));
    }
}
