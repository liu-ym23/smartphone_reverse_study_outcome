package ui4;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.bytedance.creativex.mediaimport.util.MediaImportUtilsArbiterKt$suppressA11yExtraAnnouncements$1;
import com.bytedance.creativex.mediaimport.view.internal.base.BaseMediaViewHolder;
import com.bytedance.creativex.mediaimport.view.internal.viewholder.MediaSelectViewHolder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class w<DATA, STATE, VIEW extends View> implements ti4.x<DATA, STATE>, com.bytedance.creativex.mediaimport.view.internal.validator.d<DATA> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f550195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaSelectViewHolder.a f550196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ui4.a f550197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f550198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public DATA f550199e;

    public static class a extends w<ki4.r, BaseMediaViewHolder.a, SimpleDraweeView> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.creativex.mediaimport.view.internal.validator.d.a f550200f;

        /* JADX INFO: renamed from: ui4.w$a$a, reason: collision with other inner class name */
        public static final class C7887a {
        }

        static {
        }

        @Override // com.bytedance.creativex.mediaimport.view.internal.validator.d
        public final String getPath(Object r100) {
            ki4.r r101 = (ki4.r) r100;
            Intrinsics.checkNotNullParameter(r101, "data");
            this.f550200f.getClass();
            Intrinsics.checkNotNullParameter(r101, "data");
            return r101.getPath();
        }

        public a(View r100, MediaSelectViewHolder.a r101, zi4.d r102) {
            Intrinsics.checkNotNullParameter(r100, "itemView");
            Intrinsics.checkNotNullParameter(r101, "viewConfigure");
            super(r100, r101, r102);
            this.f550200f = com.bytedance.creativex.mediaimport.view.internal.validator.d.f204098o1;
        }
    }

    public w(View r100, MediaSelectViewHolder.a r101, zi4.d r102) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        Intrinsics.checkNotNullParameter(r101, "viewConfigure");
        this.f550195a = r100;
        this.f550196b = r101;
        this.f550197c = r102;
        this.f550198d = LazyKt.lazy(new u(this));
    }

    @Override // ti4.x
    public final void c(DATA r110, final int r111, STATE r210) {
        BaseMediaViewHolder.a r100 = (BaseMediaViewHolder.a) r210;
        Intrinsics.checkNotNullParameter(r100, "state");
        if (r100.a() == true) goto L30;
        DATA r101 = this.f550199e;
        if (r101 == null) goto L7;
        String r102 = ((a) this).getPath(r101);
    L8:
        final a r103 = (a) this;
        if (Intrinsics.areEqual(r102, r103.getPath(r110)) == true) goto L30;
        final ki4.r r104 = (ki4.r) r110;
        Intrinsics.checkNotNullParameter(r104, "data");
        View r105 = (View) r103.f550198d.getValue();
        SimpleDateFormat r106 = ri4.a.f537885a;
        Intrinsics.checkNotNullParameter(r105, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r104, "mediaItem");
        Context r107 = r105.getContext();
        Calendar r108 = Calendar.getInstance();
        r108.setTimeInMillis(r104.getDate() * ((long) 1000));
        String r109 = String.valueOf(r108.get(1));
        String r112 = String.valueOf(r108.get(2) + 1);
        String r113 = String.valueOf(r108.get(5));
        String r114 = String.valueOf(r108.get(11));
        String r115 = String.valueOf(r108.get(12));
        if (com.bytedance.creativex.mediaimport.repository.api.a.d(r104) == false) goto L13;
        int r116 = R.string.larus_accessibility_album_video_cn;
    L14:
        r105.setContentDescription(r107.getString(r116, new Object[]{r109, r112, r113, r114, r115}));
        ViewCompat.setAccessibilityDelegate(r105, new MediaImportUtilsArbiterKt$suppressA11yExtraAnnouncements$1());
        final Uri r117 = r104.getUri();
        GenericDraweeHierarchy r118 = ((SimpleDraweeView) ((View) r103.f550198d.getValue())).getHierarchy();
        r118.setPlaceholderImage(r103.f550196b.f204107c);
        ImageView.ScaleType r119 = r103.f550196b.f204109e;
        Intrinsics.checkNotNullParameter(r119, "scaleType");
        switch(y.f550205a[r119.ordinal()]) {
            case 1: goto L25;
            case 2: goto L24;
            case 3: goto L23;
            case 4: goto L22;
            case 5: goto L21;
            case 6: goto L20;
            case 7: goto L19;
            case 8: goto L18;
            default: goto L17;
        };
    L18:
        ScalingUtils.ScaleType r120 = ScalingUtils.ScaleType.FIT_XY;
    L26:
        r118.setActualImageScaleType(r120);
        r118.setFadeDuration(r103.f550196b.f204108d);
        if (r103.f550196b.f204112h == false) goto L29;
        ImagePipelineFactory.getInstance().setNewLocalVideoThumbnailOptEnabled(true);
    L29:
        ImageLoaderKt.y((GenericDraweeView) ((View) r103.f550198d.getValue()), r117.toString(), null, new v(r103, r117, r104, r111), 6);
        goto L30
    L19:
        r120 = ScalingUtils.ScaleType.FIT_START;
        goto L26
    L20:
        r120 = ScalingUtils.ScaleType.FIT_END;
        goto L26
    L21:
        r120 = ScalingUtils.ScaleType.FIT_CENTER;
        goto L26
    L22:
        r120 = ScalingUtils.ScaleType.CENTER_INSIDE;
        goto L26
    L23:
        r120 = ScalingUtils.ScaleType.CENTER_CROP;
        goto L26
    L24:
        r120 = ScalingUtils.ScaleType.CENTER;
        goto L26
    L25:
        r120 = ScalingUtils.ScaleType.FIT_BOTTOM_START;
        goto L26
    L17:
        throw new NoWhenBranchMatchedException();
    L13:
        r116 = R.string.larus_accessibility_album_photo_cn;
        goto L14
    L7:
        r102 = null;
    L30:
        this.f550199e = r110;
    }
}
